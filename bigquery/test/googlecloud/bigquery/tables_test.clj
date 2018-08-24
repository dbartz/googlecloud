(ns googlecloud.bigquery.tables-test
  (:require [googlecloud.bigquery.tables :refer :all]
            [clojure.test :refer [deftest testing is are]]))

(def unpartitioned-unclustered-table
  {:table-reference {:table-id   "table-id" 
                     :project-id "project-id"
                     :dataset-id "dataset-id"}
   :description     "Contains import events"
   :schema          [{:name "event"       :type :string}
                     {:name "timestamp"       :type :timestamp :mode :nullable}]})

(def ingestion-partitioned-table (assoc unpartitioned-unclustered-table :time-partitioning {:type "DAY"}))

(def field-partitioned-table (assoc unpartitioned-unclustered-table :time-partitioning {:type "DAY" :field "timestamp"}))

(def required-field-partitioned-table (assoc unpartitioned-unclustered-table :time-partitioning {:type "DAY" :field "timestamp" :require-partition-filter true}))

(def clustered-table (assoc unpartitioned-unclustered-table :clustering {:fields ["EventType", "otherField"]}))

(deftest test-unpartitioned-unclustered-table
  (let [bq-table (#'googlecloud.bigquery.tables/mk-table unpartitioned-unclustered-table)
        time-partitioning (. bq-table getTimePartitioning)
        clustering (. bq-table getClustering)]
    (is (= nil time-partitioning))
    (is (= nil clustering))))

(deftest test-ingestion-partitioned-table
  (let [bq-table (#'googlecloud.bigquery.tables/mk-table ingestion-partitioned-table)
        time-partitioning (. bq-table getTimePartitioning)]
    (is (= "DAY" (. time-partitioning getType)))
    (is (= nil (. time-partitioning getField)))))

(deftest test-field-partitioned-table
  (let [bq-table (#'googlecloud.bigquery.tables/mk-table field-partitioned-table)
        time-partitioning (. bq-table getTimePartitioning)]
    (is (= "DAY" (. time-partitioning getType)))
    (is (= "timestamp" (. time-partitioning getField)))))

(deftest test-required-field-partitioned-table
  (let [bq-table (#'googlecloud.bigquery.tables/mk-table required-field-partitioned-table)
        time-partitioning (. bq-table getTimePartitioning)]
    (is (= "DAY" (. time-partitioning getType)))
    (is (= "timestamp" (. time-partitioning getField)))
    (is (= true (. time-partitioning isRequirePartitionFilter)))))

(deftest test-clustered-table
  (let [bq-table (#'googlecloud.bigquery.tables/mk-table clustered-table)
        clustering (. bq-table getClustering)]
    (is (= ["EventType" "otherField"] (. clustering getFields)))))

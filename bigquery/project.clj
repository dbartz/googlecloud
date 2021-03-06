(defproject googleclojd/bigquery "0.4.1"
  :description "BigQuery"
  :url "https://github.com/dbartz/googlecloud"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :scm {:dir ".."}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [prismatic/schema "1.0.1"]
                 [com.google.api-client/google-api-client "1.24.1"]
                 [com.google.apis/google-api-services-bigquery "v2-rev400-1.24.1"]
                 [googleclojd/core "0.4.0"]])

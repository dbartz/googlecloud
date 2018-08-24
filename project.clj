(defproject googleclojd "0.4.0"
  :description "Google Cloud service clients for Clojure"
  :url "https://github.com/dbartz/googlecloud"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[lein-sub "0.3.0"]]
  :sub ["core" "bigquery" "cloudstorage"]
  :eval-in-leiningen true)

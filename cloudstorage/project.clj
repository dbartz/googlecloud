(defproject googleclojd/cloudstorage "0.4.0"
  :description "Google Cloud Storage client"
  :url "https://github.com/dbartz/googlecloud"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :scm {:dir ".."}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [com.google.api-client/google-api-client "1.24.1"]
                 [com.google.apis/google-api-services-storage "v1-rev136-1.24.1"]
                 [googleclojd/core "0.4.0"]])

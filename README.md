# Google Cloud in Clojure

A collection of client libraries to make interfacing with Google's official Java SDKs more pleasant with Clojure.

Currently supported clients:

* BigQuery
* CloudStorage

This is a fork of https://github.com/pingles/googlecloud. The fork is based on updated google cloud client libraries and supports some additional features:
* time partioning, also as a required partitioning
* clustered tables
* updating and patching of table data

The fork has been released to clojars as `googleclojd`. To use the latest version, add the following dependencies to you `project.clj`:

    :dependencies [[googleclojd/core             "0.4.0"]
                   [googleclojd/cloudstorage     "0.4.0"]
                   [googleclojd/bigquery         "0.4.1"]]

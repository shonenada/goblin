(ns goblin.core.response
  (:require [clojure.data.json :as json]))

(defn json-response
  [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/json;charset=utf-8"}
   :body (json/write-str data)})

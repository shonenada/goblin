(ns goblin.apps.hello.handler
  (:require [goblin.utils.response :refer [json-response]]))

(defn index
  [request]
  (json-response {:message "Hello Goblin"}))

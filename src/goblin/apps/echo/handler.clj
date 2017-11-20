(ns goblin.apps.echo.handler
  (:require [goblin.utils.response :refer [json-response]]))

(defn echo
  [request]
  (let [echo (get-in request [:params :echo])]
    (json-response {:message echo})))

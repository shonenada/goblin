(ns goblin.apps.echo.handler
  (:require [goblin.core
             [handler :refer [defhandler]]
             [response :refer [json-response]]]))

(defhandler echo
  [context]
  (let [echo (get-in context [:params :echo])]
    (json-response {:message echo})))

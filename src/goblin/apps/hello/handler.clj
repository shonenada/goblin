(ns goblin.apps.hello.handler
  (:require [goblin.core
             [handler :refer [defhandler]]
             [response :refer [json-response]]]))

(defhandler index
  [context]
  (json-response {:message "Hello Goblin"}))

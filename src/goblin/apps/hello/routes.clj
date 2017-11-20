(ns goblin.apps.hello.routes
  (:require [compojure.core :refer [defroutes GET]])
  (:require [goblin.apps.hello.handler :as handler]))

(defroutes routes
  (GET "/" [] handler/index))

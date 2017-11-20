(ns goblin.apps.echo.routes
  (:require [compojure.core :refer [defroutes GET]])
  (:require [goblin.apps.echo.handler :as handler]))

(defroutes routes
  (GET "/echo/:echo" [echo] handler/echo))

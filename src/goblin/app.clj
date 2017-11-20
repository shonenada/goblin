(ns goblin.app
  (:require [compojure.core :refer [routes]]
            [compojure.handler :as handler])
  (:require [goblin.config :as config]
            [goblin.apps.hello.routes :as hello]
            [goblin.apps.echo.routes :as echo]
            [goblin.apps.hello.handler :as h]))

(def ^:const envs
  {:simple [hello/routes]
   :advence [hello/routes
             echo/routes]})

(def simple-apps
  (apply routes (:simple envs)))

(def advenced-apps
  (apply routes (:advence envs)))

(defn create-site-app
  []
  (case config/env
    :simple simple-apps
    :advence advenced-apps))

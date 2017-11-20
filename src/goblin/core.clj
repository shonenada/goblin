(ns goblin.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [compojure.handler :as handler])
  (:require [goblin.app :refer [create-site-app]]
            [goblin.config :as config]))

(defn -main
  [& args]
  (run-jetty (create-site-app)
             {:port config/port}))

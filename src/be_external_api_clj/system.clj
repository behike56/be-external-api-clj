(ns be-external-api-clj.system
  (:require
   [be-external-api-clj.component.handler :as c.handler]
   [be-external-api-clj.component.server :as c.server]
   [be-external-api-clj.config :as config]
   [com.stuartsierra.component :as component]))

(defn- new-system [config]
  (component/system-map
   :handler (c.handler/map->Handler {})
   :server (component/using
            (c.server/map->JettyServer (:server config))
            [:handler])))

(defn start [profile]
  (let [config (config/read-config profile)
        system (new-system config)]
    (component/start system)))

(defn stop [system]
  (component/stop system))
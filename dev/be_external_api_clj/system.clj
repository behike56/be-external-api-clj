(ns be-external-api-clj.system
  (:require
   [be-external-api-clj.component.handler :as c.handler]
   [be-external-api-clj.component.server :as c.server]
   [com.stuartsierra.component :as component]))

(defn- new-system []
  (component/system-map
   :handler (c.handler/map->Handler {})
   :server (component/using
            (c.server/map->JettyServer {:opts {:join? false
                                                :port 8000}})
            [:handler])))

(defn start []
  (let [system (new-system)]
    (component/start system)))

(defn stop [system]
  (component/stop system))
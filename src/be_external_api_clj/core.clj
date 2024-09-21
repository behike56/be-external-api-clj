(ns be-external-api-clj.core
  (:require
   [cljapi.system :as system]))

(defn -main
  [& _args]
  (system/start))

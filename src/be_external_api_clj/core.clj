(ns be-external-api-clj.core
  (:gen-class)
  (:require
   [be-external-api-clj.system :as system]))

(defn -main
  [& _args]
  (system/start :dev))

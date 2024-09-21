(ns user
  (:require
   [be-external-api-clj.system :as system]))

(defonce system (atom nil))

(defn start []
  (reset! system (system/start)))

(defn stop []
  (when @system
    (reset! system (system/stop @system))))

(defn go 
  "REPLで呼び出す"
  []
  (stop)
  (start))
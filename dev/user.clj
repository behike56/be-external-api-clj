(ns user
  (:require
   [be-external-api-clj.system :as system]))

(defonce system (atom nil))

(defn start [profile]
  (reset! system (system/start profile)))

(defn stop []
  (when @system
    (reset! system (system/stop @system))))

(defn go 
  "REPLで呼び出す"
  [profile]
  (stop)
  (start profile))
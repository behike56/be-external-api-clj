(ns be-external-api-clj.config
  "実行環境切り替えのための設定。"
  (:require
   [aero.core :as aero]
   [clojure.java.io :as io]))

(defn read-config 
  "resouceに設置した`config.edn`を読み込む"
  [profile]
  {:pre [(contains? #{:dev :prod :test} profile)]}
  (-> (io/resource "config.edn")
      (aero/read-config {:profile profile})
      (assoc :profile profile)))
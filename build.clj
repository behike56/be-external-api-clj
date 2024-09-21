(ns build
    "ビルドスクリプト"
  (:require
   [clojure.tools.build.api :as b]))

(def class-dir "target/classes")
(def uber-file "target/be-external-api-clj.jar")
(def basis (b/create-basis {:project "project.clj"}))

(defn clean [_]
  (b/delete {:path "target"}))

(defn uber [_]
  (clean nil)
  (b/copy-dir {:src-dirs ["src" "resources"]
               :target-dir class-dir})
  (b/compile-clj {:basis basis
                  :src-dirs ["src"]
                  :class-dir class-dir})
  (b/uber {:class-dir class-dir
           :uber-file uber-file
           :basis basis
           :main 'cljapi.core}))

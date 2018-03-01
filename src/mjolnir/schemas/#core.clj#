(ns mjolnir.schemas.core
  (:require [clojure.edn :as edn]
            [clojure.java.io :as io]
            [clojure.spec.alpha :as s]))

(def default-file-location "./data/schema.edn")

(defn load-config-edn []
  (-> (io/file default-file-location)
      io/reader
      java.io.PushbackReader.
      edn/read))

(ns goblin.core.handler
  (:require [clojure.tools.macro :refer [name-with-attributes]])
  (:require [goblin.core.context :refer [->context]]))

(def ^:dynamic *before-request-hooks* (atom []))
(def ^:dynamic *after-request-hooks* (atom []))

(defmacro defhandler*
  [name context & body]
  `(defn ~name
     [request#]
     (let [before-hooks# (apply comp @*before-request-hooks*)
           after-hooks# (apply comp @*after-request-hooks*)
           ~'context (->context (before-hooks# request#))]
       (after-hooks# (do ~@body)))))

(defmacro defhandler
  [name & fdecl]
  (let [[name [args & fdecl]] (name-with-attributes name fdecl)]
    `(defhandler* ~name ~args ~@fdecl)))

(defn before-hook
  [hook]
  (swap! *before-request-hooks* #(conj % hook)))

(defn aftere-hook
  [hook]
  (swap! *after-request-hooks* #(conj % hook)))

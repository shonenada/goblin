(ns goblin.core.context
  (:require [clojure.set :refer [rename-keys]]
            [schema.core :as s]))

(def Context
  {:headers {s/Str s/Str}
   :body s/Any
   :path s/Str
   :method s/Str
   :json-params s/Any
   :form-params s/Any
   :query-string s/Any
   :params s/Any

   :data s/Any})

(defn ->context
  [request]
  (-> request
      (select-keys [:headers :body :uri :request-method
                    :query-string :json-params :form-params :params
                    :data])
      (rename-keys {:request-method :method
                    :uri :path})))

(defn context->data
  [context]
  (get context :data))

(defn cget
  [context key]
  (get-in context [:data key]))

(defn cset
  [context key value]
  (assoc-in context [:data key] value))

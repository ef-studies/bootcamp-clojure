(ns bootcamp.models.category
  (:require [schema.core :as s]))

(defn uuid []
  (java.util.UUID/randomUUID))

(def Category
  {:category/name s/Str
   :category/id   java.util.UUID})

(s/defn to-category
        ([name :- s/Str]
         (to-category name (uuid)))
        ([name :- s/Str, uuid :- java.util.UUID]
         {:category/name name
          :category/id   uuid}))
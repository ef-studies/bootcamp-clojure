(ns bootcamp.models.client
  (:require [schema.core :as s]))

(defn uuid
  []
  (java.util.UUID/randomUUID))

(def Client
  {:client/name  s/Str
   :client/cpf   s/Str
   :client/email s/Str
   :client/id    java.util.UUID})

(s/defn to-client
  "Returns a hashmap on Client format"

  ([name, cpf, email, uuid]
   {:client/name  name
    :client/cpf   cpf
    :client/email email
    :client/id    uuid})

  ([name, cpf, email]
   (to-client name, cpf, email, (uuid))))

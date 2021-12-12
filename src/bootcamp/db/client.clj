(ns bootcamp.db.client
  (:require [datomic.api :as d]
            [schema.core :as s]
            [bootcamp.models.client :as m.client]))

(def schema [{:db/ident       :client/name
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one}
             {:db/ident       :client/cpf
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one}
             {:db/ident       :client/email
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one}
             {:db/ident       :client/id
              :db/valueType   :db.type/uuid
              :db/unique      :db.unique/identity
              :db/cardinality :db.cardinality/one}])

(s/defn new!
  [conn, clients :- [m.client/Client]]
  (d/transact conn clients))
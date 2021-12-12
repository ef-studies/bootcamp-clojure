(ns bootcamp.db.category
  (:require [datomic.api :as d]
            [schema.core :as s]
            [bootcamp.models.category :as m.category]))

(def schema [{:db/ident       :category/name
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one}
             {:db/ident       :category/id
              :db/valueType   :db.type/uuid
              :db/unique      :db.unique/identity
              :db/cardinality :db.cardinality/one}])

(s/defn new!
  [conn, categories :- [m.category/Category]]
  (d/transact conn categories))
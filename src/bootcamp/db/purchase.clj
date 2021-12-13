(ns bootcamp.db.purchase
  (:require [datomic.api :as d]
            [schema.core :as s]
            [bootcamp.models.purchase :as m.purchase]))

(def schema [{:db/ident       :purchase/date
              :db/valueType   :db.type/instant
              :db/cardinality :db.cardinality/one}
             {:db/ident       :purchase/value
              :db/valueType   :db.type/bigdec
              :db/cardinality :db.cardinality/one}
             {:db/ident       :purchase/seller
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one}
             {:db/ident       :purchase/category
              :db/valueType   :db.type/ref
              :db/cardinality :db.cardinality/one}
             {:db/ident       :purchase/credit-card
              :db/valueType   :db.type/ref
              :db/cardinality :db.cardinality/one}
             {:db/ident       :purchase/id
              :db/valueType   :db.type/uuid
              :db/unique      :db.unique/identity
              :db/cardinality :db.cardinality/one}])

(s/defn new!
  [conn purchases :- [m.purchase/Purchase] ]
  (d/transact conn purchases))
(ns bootcamp.db.credit-card
  (:require [schema.core :as s]
            [datomic.api :as d]
            [bootcamp.models.credit-card :as m.credit-card]))

(def schema [{:db/ident       :credit-card/number
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one}
             {:db/ident       :credit-card/cvv
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one}
             {:db/ident       :credit-card/expiration-date
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one}
             {:db/ident       :credit-card/limit
              :db/valueType   :db.type/bigdec
              :db/cardinality :db.cardinality/one}
             {:db/ident       :credit-card/id
              :db/valueType   :db.type/uuid
              :db/unique      :db.unique/identity
              :db/cardinality :db.cardinality/one}
             {:db/ident       :credit-card/client
              :db/valueType   :db.type/ref
              :db/cardinality :db.cardinality/one}])

(s/defn new!
  [conn, credit-cards :- [m.credit-card/CreditCard]]
  (d/transact conn credit-cards))

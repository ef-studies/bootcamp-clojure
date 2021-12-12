(ns bootcamp.db.client)

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
              :db/cardinality :db.cardinality/one}])
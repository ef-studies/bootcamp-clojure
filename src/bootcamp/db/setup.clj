(ns bootcamp.db.setup
  (:require [datomic.api :as d]
            [bootcamp.db.client :as db.client]
            [bootcamp.db.credit-card :as db.credit-card]
            [bootcamp.db.category :as db.category]))

;(d/delete-database db-uri)

(def db-uri "datomic:dev://localhost:4334/nubank")

(defn connection
  "Creates a database and returns a connection with this database
  If no uri is given, connects with global uri defined by 'db-uri'"
  ([]
   (connection db-uri))

  ([uri]
  (d/create-database uri)
  (d/connect uri)))

(d/transact (connection) db.client/schema)
(d/transact (connection) db.credit-card/schema)
(d/transact (connection) db.category/schema)
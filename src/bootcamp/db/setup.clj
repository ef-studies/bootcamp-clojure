(ns bootcamp.db.setup
  (:require [datomic.api :as d]
            [bootcamp.db.client :as db.client]))


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
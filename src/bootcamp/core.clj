(ns bootcamp.core
  (:require [datomic.api :as d]
            [schema.core :as s]
            [bootcamp.db.setup :as db.setup]
            [bootcamp.models.client :as m.client]
            [bootcamp.db.client :as db.client]))

(s/set-fn-validation! true)

(def conn
  (d/connect db.setup/db-uri))

; Inserindo clientes
(defn populate-clients []
  (let [emily (m.client/to-client "Emily Faccin" "40986723455" "email@bla.com")
        fernanda (m.client/to-client "Fernanda Andrade" "12364590800" "email@fablau.com")]
    (db.client/new! conn [emily, fernanda])))

(populate-clients)
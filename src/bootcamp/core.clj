(ns bootcamp.core
  (:require [datomic.api :as d]
            [schema.core :as s]
            [bootcamp.db.setup :as db.setup]
            [bootcamp.models.client :as m.client]
            [bootcamp.db.client :as db.client]
            [bootcamp.models.credit-card :as m.credit-card]
            [bootcamp.db.credit-card :as db.credit-card]))

(s/set-fn-validation! true)

(def conn
  (d/connect db.setup/db-uri))

(def emily (m.client/to-client "Emily Faccin" "40986723455" "email@bla.com"))
(def fernanda (m.client/to-client "Fernanda Andrade" "12364590800" "email@fablau.com"))

; Inserindo clientes
(defn populate-clients []
  (db.client/new! conn [emily, fernanda]))

(populate-clients)

(def emily-card
  (m.credit-card/to-credit-card "1234567890983333" "321" "10/2022" 9500M emily))

(def fernanda-card
  (m.credit-card/to-credit-card "1234567890983333" "321" "10/2022" 9500M emily))

(defn populate-credit-cards []
  (db.credit-card/new! conn [emily-card, fernanda-card]))

(populate-credit-cards)
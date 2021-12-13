(ns bootcamp.core
  (:require [datomic.api :as d]
            [schema.core :as s]
            [bootcamp.db.setup :as db.setup]
            [bootcamp.models.client :as m.client]
            [bootcamp.db.client :as db.client]
            [bootcamp.models.credit-card :as m.credit-card]
            [bootcamp.db.credit-card :as db.credit-card]
            [bootcamp.models.category :as m.category]
            [bootcamp.db.category :as db.category]
            [bootcamp.models.purchase :as m.purchase]
            [bootcamp.db.purchase :as db.purchase]))

(s/set-fn-validation! true)

(def conn
  (d/connect db.setup/db-uri))

(def emily (m.client/to-client "Emily Faccin" "40986723455" "email@bla.com"))
(def fernanda (m.client/to-client "Fernanda Andrade" "12364590800" "email@fablau.com"))
(db.client/new! conn [emily, fernanda])

(def emily-card (m.credit-card/to-credit-card "1234567890983333" "321" "10/2022" 9500M emily))
(def fernanda-card (m.credit-card/to-credit-card "1234567890983333" "321" "10/2022" 9500M emily))
(db.credit-card/new! conn [emily-card, fernanda-card])

(def food (m.category/to-category "food"))
(def eletronics (m.category/to-category "eletronics"))
(def subscriptions (m.category/to-category "subscriptions"))
(db.category/new! conn [food, eletronics, subscriptions])

(def compra1 (m.purchase/to-purchase "2021-12-01" 1200M "Magalu" eletronics emily-card))
(def compra2 (m.purchase/to-purchase "2021-12-07" 19M "Bom Jardim" food emily-card))
(def compra3 (m.purchase/to-purchase "2021-12-10" 84.20M "Poke Vila Velha" food fernanda-card))
(def compra4 (m.purchase/to-purchase "2021-12-13" 6500M "Avell" eletronics fernanda-card))
(db.purchase/new! conn [compra1, compra2, compra3, compra4])
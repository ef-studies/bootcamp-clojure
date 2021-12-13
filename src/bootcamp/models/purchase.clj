(ns bootcamp.models.purchase
  (:import java.text.SimpleDateFormat)
  (:require [schema.core :as s]
            [bootcamp.models.category :as m.category]
            [bootcamp.models.credit-card :as m.credit-card]))

(defn uuid []
  (java.util.UUID/randomUUID))

(defn string->date
  [string]
  (.parse (SimpleDateFormat. "yyyy-MM-dd") string))

(def Purchase
  {:purchase/date        java.util.Date
   :purchase/value       BigDecimal
   :purchase/seller      s/Str
   :purchase/category    m.category/Category
   :purchase/credit-card m.credit-card/CreditCard
   :purchase/id          java.util.UUID})

(s/defn to-purchase
  ([date :- s/Str, value :- BigDecimal, seller :- s/Str, category :- m.category/Category
    credit-card :- m.credit-card/CreditCard]
   (to-purchase date, value, seller, category, credit-card, (uuid)))

  ([date :- s/Str, value :- BigDecimal, seller :- s/Str, category :- m.category/Category
    credit-card :- m.credit-card/CreditCard, uuid :- java.util.UUID]
   {:purchase/date        (string->date date)
    :purchase/value       value
    :purchase/seller      seller
    :purchase/category    category
    :purchase/credit-card credit-card
    :purchase/id          uuid}))
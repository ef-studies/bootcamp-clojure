(ns bootcamp.models.credit-card
  (:require [schema.core :as s]
            [bootcamp.models.client :as m.client]
            [bootcamp.models.credit-card :as m.credit-card]))

(defn uuid []
  (java.util.UUID/randomUUID))

(defn string-com-dezesseis-digitos?
  [string]
  (and (string? string) (= 16 (count string))))

(def CreditCardNumber
  (s/pred string-com-dezesseis-digitos? 'string-com-dezesseis-digitos))

(defn string-com-tres-digitos?
  [string]
  (and (string? string) (= 3 (count string))))

(def Cvv
  (s/pred string-com-tres-digitos? 'string-com-tres-digitos))

(def CreditCard
  {:credit-card/number          CreditCardNumber
   :credit-card/cvv             Cvv
   :credit-card/expiration-date s/Str
   :credit-card/limit           BigDecimal
   :credit-card/id              java.util.UUID
   :credit-card/client          m.client/Client})

(s/defn to-credit-card
  ([number :- m.credit-card/CreditCardNumber, cvv :- m.credit-card/Cvv, expiration-date :- s/Str,
    limit :- BigDecimal, client :- m.client/Client]
   (new! number, cvv, expiration-date, limit, client, (uuid)))

  ([number :- m.credit-card/CreditCardNumber, cvv :- m.credit-card/Cvv,
    expiration-date :- s/Str, limit :- BigDecimal,
    client :- m.client/Client uuid :- java.util.UUID]
   {:credit-card/number          number
    :credit-card/cvv             cvv
    :credit-card/expiration-date expiration-date
    :credit-card/limit           limit
    :credit-card/id              uuid
    :credit-card/client          client}))

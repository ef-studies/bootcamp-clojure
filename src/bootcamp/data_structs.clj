(ns bootcamp.data-structs
  (:require [schema.core :as s]))

(s/set-fn-validation! true)

(defn double-maior-ou-igual-a-zero? [x]
  (and (double? x) (>= x 0)))

(defn string-com-dezesseis-digitos?
  [string]
  (and (string? string)
       (= 16 (count string))))

(def ValorFinanceiro
  (s/pred double-maior-ou-igual-a-zero? 'double-maior-ou-igual-a-zero))

;(def Cpf
;  (s/constrained s/Str (fn dezesseis-digitos? [str] (= 16 (count str)))))

(def Cpf
  (s/pred string-com-dezesseis-digitos? 'string-com-dezesseis-digitos))

(def Client
  {:name s/Str, :cpf s/Str, :email s/Str})

(println (s/validate Client {:name  "Emily Faccin",
                             :cpf   "39861661816",
                             :email "emily.faccin@nubank.com"}))

; ==================================================

; Dado que o exercicio trata de apenas um cliente, nao ha necessidade
; de trackear o dono do cartao

(def CreditCard
  {:number          Cpf,
   :cvv             s/Str,
   :expiration-date s/Str,
   :limit           ValorFinanceiro})

(println (s/validate CreditCard {:number "0123453899981010"
                                 :cvv "435"
                                 :expiration-date "2029-10-23"
                                 :limit 1000.0}))

; ====================================================

; schema de uma compra
(def Purchase
  {:date     s/Str
   :value    ValorFinanceiro
   :seller   s/Str
   :category s/Keyword})

(println (s/validate Purchase {:date     "2021-11-22",
                               :value    200.0,
                               :seller   "Magalu",
                               :category :eletronics}))
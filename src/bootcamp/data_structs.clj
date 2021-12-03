(ns bootcamp.data-structs
  (:require [schema.core :as s]))

(s/set-fn-validation! true)

; :client {:name  string,
;         :cpf string,
;         :email string}

(def client {:name  "Emily",
             :cpf   "39875649088",
             :email "emily.faccin@nubank.com.br"})

(println "Client:" client)
; ==================================================

; Dado que o exercicio trata de apenas um cliente, nao ha necessidade
; de trackear o dono do cartao

;{:credit-card {:number string,
;               :cvv string,
;               :expiration-date string,
;               :limit double}}

(def credit-card {:number          "0000 0000 0000 0000",
                  :cvv             "432",
                  :expiration-date "2029-11-22",
                  :limit           1000.0})

(println "Credit Card:" credit-card)
; ====================================================

(defn double-maior-ou-igual-a-zero? [x]
  (and (double? x) (>= x 0)))

(def ValorFinanceiro (s/pred double-maior-ou-igual-a-zero? 'double-maior-ou-igual-a-zero))

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

;(println "Purchase:" purchase)

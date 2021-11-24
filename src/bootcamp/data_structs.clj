(ns bootcamp.data-structs)

; :client {:name  string,
;         :cpf string,
;         :email string}

(def client {:name  "Emily",
             :cpf   "39875649088",
             :email "emily.faccin@nubank.com.br"})

; ==================================================

; Dado que o exercicio trata de apenas um cliente, nao ha necessidade
; de trackear o dono do cartao

;{:credit-card {:number string,
;               :cvv string,
;               :expiration-date string,
;               :limit double}}

(def credit-card {:number          "0000 0000 0000 0000",
                  :cvv             "432",
                  :expiration-date "2021-11-22",
                  :limit           1000.0})
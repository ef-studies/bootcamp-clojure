(ns bootcamp.logic
  (:require [bootcamp.db :as b.db]
            [clojure.string :as str]))

; funcao que adiciona uma compra ao array de compras
(defn adiciona-compra
  "Adiciona uma compra ao final do array de compras passado"
  [purchases new-purchase]
  {; assegura que o array de retorno contem exatamente um item a mais que o de entrada
   :post [(= (count %) (inc (count purchases)))]}
  (conj purchases new-purchase))

(println
  (adiciona-compra b.db/purchases {:date "2021-12-03", :value 53.50, :seller "Starbucks", :category "food"}))

; funcao que retorna o total gasto por categoria

(defn group-by-category
  [purchases]
  (group-by :category purchases))

;(defn sum-by-category
;  [[category purchases]]
;  {:category category :total (reduce + (map :value purchases))})

(defn sum-by-category
  [[category purchases]]
  {:category category,
   :total    (->> purchases
                  (map :value)
                  (reduce +))})

(defn total-by-category
  [purchases]
  (->> purchases
       group-by-category
       (map sum-by-category)))

(println (total-by-category []))

; calcular o total do mes solicitado

(defn month-retriever
  "Returns the month of given date
  e.g. 2021-10-21 will return 10"
  [date]
  ((str/split date #"-") 1))

(defn purchased-in-this-month?
  [month purchase]
  (= month (month-retriever (:date purchase))))

(defn filter-by-month
  "Returns only purchases that were made on given month"
  [month purchases]
  (filter #(purchased-in-this-month? month %) purchases))

(defn total-by-month
  "Returns the total of purchases from the month required"
  [month purchases]
  (->> purchases
       (filter-by-month month)
       (map :value)
       (reduce +)))

(defn print-total-bill
  [month purchases]
  (println "========================")
  (println "O total da sua fatura no mês" month "é R$" (total-by-month month purchases))
  (println "========================"))

(print-total-bill "05" b.db/purchases)

;(println (reduce + (map :value (filter (fn [purchase] (= (month-retriever (:date purchase)) "05")) b.db/purchases))))
;(println (reduce + (map :value (filter #(purchased-in-this-month? "05" %) b.db/purchases))))

;; ==========================================

; busca por valor ou estabelecimento

(defn filter-by-seller
  [seller purchases]
  (filter #(= seller (:seller %)) purchases))

(println (filter-by-seller "Magalu" b.db/purchases))

(defn filter-by-value
  [value purchases]
  (filter #(== (read-string value) (:value %)) purchases))

(println (filter-by-value "100" b.db/purchases))

(defn filter-by-value-or-seller
  "Returns all purchases that attends range informed or seller"
  [seller-or-value purchases]
  (if (symbol? (read-string seller-or-value))
    (filter-by-seller seller-or-value purchases)
    (filter-by-value seller-or-value purchases)))

(println "Por valor:" (filter-by-value-or-seller "100" b.db/purchases))
(println "Por estabelecimento:" (filter-by-value-or-seller "Magalu" b.db/purchases))





















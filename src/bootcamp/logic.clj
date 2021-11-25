(ns bootcamp.logic
  (:require [bootcamp.db :as b.db]
            [clojure.string :as str]))

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

(println (total-by-category b.db/purchases))

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























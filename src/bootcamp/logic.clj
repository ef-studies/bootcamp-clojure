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

(defn total-by-month
  "Returns the total of purchases from the month required"
  [month purchases]

  )

(defn month-retriever
  [date]
  ((str/split date #"-") 1))

(println (filter (fn [purchase] (= (month-retriever (:date purchase)) "05")) b.db/purchases))























(ns bootcamp.logic
  (:require [bootcamp.db :as b.db]))

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
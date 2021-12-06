(ns bootcamp.logic-test
  (:require [clojure.test :refer :all]
            [bootcamp.logic :refer :all]))

;{:date "2021-05-22", :value 100.0, :seller "Magalu", :category "eletronics"},
;{:date "2021-11-29", :value 800.0, :seller "Magalu", :category "eletronics"}

(deftest adiciona-compra-test

  (testing "Que a nova compra é adicionada ao vetor de compras"
    (let [purchases [{:date "2021-05-22", :value 100.0, :seller "Magalu", :category "eletronics"}]
          result-purchases [{:date "2021-05-22", :value 100.0, :seller "Magalu", :category "eletronics"},
                            {:date "2021-11-29", :value 200.0, :seller "Magalu", :category "eletronics"}]
          new-purchase {:date "2021-11-29", :value 200.0, :seller "Magalu", :category "eletronics"}]

      (is (= result-purchases
             (adiciona-compra purchases new-purchase)))

      (is (= [{:date "2021-11-29", :value 200.0, :seller "Magalu", :category "eletronics"}]
             (adiciona-compra [] new-purchase))))))

(deftest total-by-category-test
  (testing "Que é retornado o total agrupadas por categoria"
    (let [purchases [{:date "2021-05-22", :value 30.0, :seller "Mc Donalds", :category :food},
                     {:date "2021-05-10", :value 7.0, :seller "Mc Donalds", :category :food},
                     {:date "2021-07-09", :value 200.0, :seller "Posto Ipiranga", :category :transportation},
                     {:date "2021-08-22", :value 500.10, :seller "Extra", :category :food},]
          totals [{:category :food, :total 537.10}, {:category :transportation :total 200.0}]]
      (is (= totals
             (total-by-category purchases)))))

  (testing "Que retorna lista vazia quando a lista de compras é vazia"
    (is (empty? (total-by-category [])))))
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

(ns primes.core-test
  (:require [clojure.test :refer :all]
            [primes.core :refer :all]))


(defn prime? [n]
  (if (< n 2) false
    (not-any? #(zero? (rem n %)) (range 2 n))))

(deftest gen-primes-test
  (testing "prime number generation"
    (is (let [primes (take 1000 (gen-primes))]
          (and (= 1000 (count primes))
               (every? prime? primes))))))

(deftest gen-table-test
  (testing "table generation"
    (is (= '((\* 2 3 5) (2 4 6 10) (3 6 9 15) (5 10 15 25))
           (gen-mul-table (take 3 (gen-primes)))))))

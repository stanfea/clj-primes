(ns primes.core
  (:require [clojure.string :as string])
  (:gen-class))

(defn multiple?
  "check if n is a multiple of m"
  [n m]
  (zero? (rem n m)))

(defn gen-primes
  "generates a lazy sequence of prime numbers"
  []
  ((fn fun [n primes]
     (if (not-any? (partial multiple? n)
                      (take-while #(<= % (Math/sqrt n)) primes))
       (lazy-seq (cons n (fun (inc n) (conj primes n))))
       (recur (inc n) primes)))
   2 []))


(defn gen-mul-table
  "generates a multiplication table"
  [coll]
  (->> coll
       (map (fn [x] (cons x (map #(* x %) coll))))
       (cons (cons \* coll))))

(defn print-table [coll]
  (doseq [row coll]
      (println (string/join "\t" row))))


(defn -main
  "prints a multiplication table of the first 10 primes"
  []
  (->> (gen-primes)
       (take 10)
       gen-mul-table
       print-table))

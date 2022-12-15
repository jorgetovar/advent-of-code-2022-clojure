(ns advent-of-code-2022-day-3.core
  (:gen-class)
  (:require [clojure.string :as s]
            [clojure.set :as set])
  )


(defn parse-input [file-name]
  (let [rucksacks (slurp file-name)
        lines (s/split-lines rucksacks)]
    lines
    ))

(defn priority [c]
  (if (Character/isUpperCase ^char c)
    (+ 27 (- (int c) (int \A)))
    (+ 1 (- (int c) (int \a))))
  )

(defn compartments-split [rucksack]
  (partition (/ (count rucksack) 2) rucksack)
  )

(defn in-both-compartments [compartments-1 compartments-2]
  (first (set/intersection compartments-1 compartments-2))
  )

(defn compartments-str [coll]
  (map #(apply str %) coll)
  )

(defn -main
  [& args]
  (println "Hello, World!"))

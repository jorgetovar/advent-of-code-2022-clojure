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


(defn find-groups [file-name]
  (partition 3 (parse-input file-name))
  )

(defn priority [c]
  (if (Character/isUpperCase ^char c)
    (+ 27 (- (int c) (int \A)))
    (+ 1 (- (int c) (int \a))))
  )

(defn compartments-split [rucksack]
  (map #(apply str %) (partition (/ (count rucksack) 2) rucksack))
  )

(defn in-both-compartments [[compartments-1 compartments-2]]
  (first (set/intersection (set compartments-1) (set compartments-2)))
  )

(defn in-all-three-rucksacks [[compartments-1 compartments-2 compartments-3]]
  (first (set/intersection (set/intersection (set compartments-1) (set compartments-2)) (set compartments-3)))
  )

(defn parse-rucksack-file [file-name]
  (map priority
       (map in-both-compartments
            (map compartments-split
                 (parse-input file-name))))
  )

(defn sum-priorities [coll]
  (reduce + coll))

(defn parse-rucksack-file-group [file-name]
  (map priority (map in-all-three-rucksacks (find-groups file-name)))
  )

(defn rucksack-groups [file-name]
  (sum-priorities (parse-rucksack-file-group file-name))
  )

(defn rucksack-reorganization [file-name]
  (sum-priorities (parse-rucksack-file file-name))
  )

(defn -main
  [& args]
  (println "Hello, World! Im @jorgetovar"))

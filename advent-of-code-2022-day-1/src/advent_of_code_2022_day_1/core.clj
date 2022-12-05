(ns advent-of-code-2022-day-1.core
  (:gen-class)
  (:require [clojure.string :as s]))

(defn item->elf [item-content]
  (map #(Integer/parseInt %)
       (s/split-lines item-content)))

(defn group-by-elf [content]
  (map item->elf (s/split content #"\n\n")))

(defn max-calories [calorie-sums]
  (apply max calorie-sums))

(defn sum-calories [inventory]
  (map #(reduce + %) inventory))

(defn parse-input [file-name]
  (group-by-elf (slurp file-name)))

(defn find-max-calories [file-name]
  (->> (parse-input file-name)
       (sum-calories)
       (max-calories)
       ))

(defn find-calories-in-top-three-elves [file-name]
  (->> (parse-input file-name)
       (sum-calories)
       (sort)
       (take-last 3)
       (reduce +)
       ))

(defn -main
  [& args]
  (println "Hello, Advent of Code!"))

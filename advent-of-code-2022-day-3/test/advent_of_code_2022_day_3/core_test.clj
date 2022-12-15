(ns advent-of-code-2022-day-3.core-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2022-day-3.core :refer :all]))

(def file-1 "input-1.txt")

(let [line-1 (first (parse-input file-1))]
  (deftest test-parse-input
    (testing "Reading file line by line"
      (is (= line-1 "vJrwpWtwJgWrhcsFMMfFFhFp")))

    (testing "Compartments split"
      (is (= (first (compartments-split line-1)) "vJrwpWtwJgWr"))
      (is (= (last (compartments-split line-1)) "hcsFMMfFFhFp"))
      )
    )
  )

(deftest test-parse-input-map
  (testing "Reading file line by line & map priority"
    (let [lines (parse-rucksack-file file-1)]
      (is (= lines '(16
                      38
                      42
                      22
                      20
                      19)))
      ))
  )

(deftest test-sum-priorities
  (testing "Reading file line by line & sum"
    (let [total (rucksack-reorganization file-1)]
      (is (= 157 total))
      ))
  )

(deftest test-sum-priorities-puzzle
  (testing "Reading file line by line & sum [puzzle]"
    (let [total (rucksack-reorganization "input-2.txt")]
      (is (= 7727 total))
      ))
  )


(deftest test-in-both-compartments
  (testing "Find common element in compartments"
    (is (= (in-both-compartments "vJrwpWtwJgWr" "hcsFMMfFFhFp") \p))
    )
  )

(deftest test-priority
  (testing "priority char"
    (is (= (priority \a) 1))
    (is (= (priority \A) 27))
    )
  )



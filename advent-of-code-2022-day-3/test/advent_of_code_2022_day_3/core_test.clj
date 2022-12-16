(ns advent-of-code-2022-day-3.core-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2022-day-3.core :refer :all]))

(def file-1 "input-1.txt")

(let [line-1 (first (parse-input file-1))]
  (deftest test-parse-input
    (testing "Reading file line by line"
      (is (= line-1 "vJrwpWtwJgWrhcsFMMfFFhFp")))

    (testing "Compartments split"
      (is (= "vJrwpWtwJgWr" (first (compartments-split line-1))))
      (is (= "hcsFMMfFFhFp" (last (compartments-split line-1))))
      )
    )
  )


(let [group-1 (first (find-groups file-1))
      expected '("vJrwpWtwJgWrhcsFMMfFFhFp"
                  "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL"
                  "PmmdzqPrVvPwwTWBwg")
      ]
  (deftest test-parse-groups
    (testing "Reading file line by line by groups"
      (is (= group-1 expected))
      (is (= (in-all-three-rucksacks expected) \r))
      )
    )

  )

(deftest test-parse-input-map-group
  (testing "Reading file line by line & map priority group"
    (let [lines (parse-rucksack-file-group file-1)]
      (is (= '(18 52) lines))
      ))
  )

(deftest test-parse-input-map
  (testing "Reading file line by line & map priority"
    (let [lines (parse-rucksack-file file-1)]
      (is (= '(16
                38
                42
                22
                20
                19) lines))
      ))
  )

(deftest test-sum-priorities
  (testing "Reading file line by line & sum"
    (let [total (rucksack-reorganization file-1)]
      (is (= total 157))
      ))
  )


(deftest test-sum-priorities-group
  (testing "Reading file line by line & sum group"
    (let [total (rucksack-groups file-1)]
      (is (= total 70))
      ))
  )

(deftest test-sum-priorities-puzzle-group
  (testing "Reading file line by line & sum [puzzle] group"
    (let [total (rucksack-groups "input-2.txt")]
      (is (= total 2609))
      ))
  )

(deftest test-sum-priorities-puzzle
  (testing "Reading file line by line & sum [puzzle]"
    (let [total (rucksack-reorganization "input-2.txt")]
      (is (= total 7727))
      ))
  )


(deftest test-in-both-compartments
  (testing "Find common element in compartments"
    (is (= (in-both-compartments '("vJrwpWtwJgWr" "hcsFMMfFFhFp")) \p))
    )
  )

(deftest test-priority
  (testing "priority char"
    (is (= (priority \a) 1))
    (is (= (priority \A) 27))
    )
  )



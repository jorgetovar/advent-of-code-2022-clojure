(ns advent-of-code-2022-day-3.core-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2022-day-3.core :refer :all]))

(def file-1 "input-1.txt")

(let [line1 (first (parse-input file-1))]
  (deftest test-parse-input
    (testing "reading file line by line"
      (is (= line1 "vJrwpWtwJgWrhcsFMMfFFhFp")))

    (testing "compartments-char"
      (is (= (first (compartments-split line1)) (seq "vJrwpWtwJgWr")))
      (is (= (last (compartments-split line1)) (seq "hcsFMMfFFhFp")))
      )

    )
  )

(deftest test-in-both-compartments
  (testing "find common element in sets"
    (is (= (in-both-compartments (set "vJrwpWtwJgWr") (set "hcsFMMfFFhFp")) \p))
    )
  )

(deftest test-priority
  (testing "priority char"
    (is (= (priority \a) 1))
    (is (= (priority \A) 27))
    )
  )



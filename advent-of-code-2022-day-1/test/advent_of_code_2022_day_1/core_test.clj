(ns advent-of-code-2022-day-1.core-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2022-day-1.core :refer :all]))


(def content "1000\n2000\n3000\n\n4000\n\n5000\n6000\n\n7000\n8000\n9000\n\n10000")
(def file-1 "input-1.txt")
(def file-2 "input-2.txt")

(deftest test-parse-input

  (testing "read file from repository"
    (is (= (slurp file-1)
           content)))

  (testing "map item to elf calories"
    (is (= (item->elf "1000\n2000\n3000")
           [1000 2000 3000])))

  (testing "group by elf"
    (is (= (parse-input file-1)
           [[1000 2000 3000] [4000] [5000 6000] [7000 8000 9000] [10000]])))

  (testing "sum elf"
    (is (= (sum-calories (parse-input file-1))
           [6000
            4000
            11000
            24000
            10000])))

  (testing "max calories by elf"
    (is (= (max-calories (sum-calories (parse-input file-1)))
           24000
           ))))



(deftest solutions
  (testing "solves part 1 finding the maximum calories file 1"
    (is (= (find-max-calories file-1)
           24000
           )))

  (testing "solves part 1 finding the maximum calories file 2"
    (is (= (find-max-calories file-2)
           67016
           )))

  (testing "solves part 2 finding top 3 elves file 1"
    (is (= (find-calories-in-top-three-elves file-1)
           45000
           )))

  (testing "solves part 2 finding top 3 elves file 2"
    (is (= (find-calories-in-top-three-elves file-2)
           200116
           )))

  )

(ns aoc.day-01-test
  (:require [clojure.test :refer :all]
            [aoc.code.day_01 :as day_01]))

(deftest test-solution-1
  (testing "Test return value of solution 1 of day 1 of aoc, should be 24000"
    (is (= (day_01/solution-1 "input/day_01/testinput.txt") 24000))))

(deftest test-solution-2
  (testing "Test return value of solution 2 of day 1 of aoc"
    (is (= (day_01/solution-2 "input/day_01/testinput.txt") 45000))))

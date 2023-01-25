(ns aoc.day-04-test
  (:require [clojure.test :refer :all]
            [aoc.code.day_04 :as day_04]))

(deftest test-solution-1
  (testing "Test return value of solution 1 of day 4 of aoc, should be 24000"
    (is (= (day_04/solution-1 "input/day_04/testinput.txt") 2))))

(deftest test-solution-2
  (testing "Test return value of solution 2 of day 4 of aoc"
    (is (= (day_04/solution-2 "input/day_04/testinput.txt") 4))))

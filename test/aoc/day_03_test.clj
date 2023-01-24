(ns aoc.day-03-test
  (:require [clojure.test :refer :all]
            [aoc.code.day_03 :as day_03]))

(deftest test-get-alphabet-a
  (testing "Return the position of the char in the alphabet, a => 1"
    (is (= (day_03/get-position-in-alphabet \a) 1))))

(deftest test-get-alphabet-z
  (testing "Return the position of the char in the alphabet, Z => 52"
    (is (= (day_03/get-position-in-alphabet \Z) 52))))

(deftest test-solution-1
  (testing "Test return value of solution 1 of day 3 of aoc, should be 24000"
    (is (= (day_03/solution-1 "input/day_03/testinput.txt") 157))))

(deftest test-solution-2
  (testing "Test return value of solution 2 of day 3 of aoc"
    (is (= (day_03/solution-2 "input/day_03/testinput2.txt") 70))))

^{:nextjournal.clerk/visibility {:code :hide :result :hide}}
(ns aoc.code.day_01
  (:gen-class)
  (:require [clojure.string :as str]))

{:nextjournal.clerk/visibility {:result :hide}}
(defn filter-empty-strings [m]
  (->> m
       slurp
       str/split-lines
       (partition-by str/blank?)
       (map #(remove str/blank? %))))

(defn parse-map-values->long [m] (map #(parse-long %) m))

(defn parse-input [input]
  (->> input
       filter-empty-strings
       (map #(parse-map-values->long %))
       (map #(reduce + %))))

;### Find the Elf carrying the most Calories. How many total Calories is that Elf carrying?
{:nextjournal.clerk/visibility {:result :show}}
(defn solution-1 [input]
  (->> input
       parse-input
       (apply max)))

(solution-1 "input/day_01/input.txt")

(defn solution-2 [input]
  (->> input
       parse-input
       (sort >)
       (take 3)
       (reduce +)))

(solution-2 "input/day_01/input.txt")

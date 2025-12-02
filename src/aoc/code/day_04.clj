^{:nextjournal.clerk/visibility {:code :hide :result :hide}}
(ns aoc.code.day_04
  (:gen-class)
  (:require [clojure.string :as str]
            [clojure.set :as set]))
{:nextjournal.clerk/visibility {:result :hide}}
(defn cord->range [string]
  (let [start (first (str/split string #"-")) end (last (str/split string #"-"))]
    (into #{} (range (parse-long start) (inc (parse-long end))))))

{:nextjournal.clerk/visibility {:result :hide}}
(defn check-subset [set1 set2]
  (or (set/subset? set1 set2)
      (set/subset? set2 set1)))

{:nextjournal.clerk/visibility {:result :hide}}
(defn map-range->cord [row]
  (map cord->range row))

{:nextjournal.clerk/visibility {:result :hide}}
(defn solution-1 [input]
  (->> input
       slurp
       str/split-lines
       (map #(str/split % #","))
       (map map-range->cord)
       (map #(check-subset (first %) (last %)))
       (filter true?)
       count))

{:nextjournal.clerk/visibility {:result :show}}
(solution-1 "input/day_04/input.txt")


{:nextjournal.clerk/visibility {:result :hide}}
(defn any-overlapping-values? [range1 range2]
  (< 0 (count (set/intersection range1 range2))))

{:nextjournal.clerk/visibility {:result :hide}}
(defn solution-2 [input]
  (->> input
       slurp
       str/split-lines
       (map #(str/split % #","))
       (map map-range->cord)
       (map #(any-overlapping-values? (first %) (last %)))
       (filter true?)
       count))

{:nextjournal.clerk/visibility {:result :show}}
(solution-2 "input/day_04/input.txt")

^{:nextjournal.clerk/visibility {:code :hide :result :hide}}
(ns aoc.code.day_05
  (:gen-class)
  (:require
   [clojure.core :as c]
   [clojure.string :as str]))

{:nextjournal.clerk/visibility {:result :hide}}
(defn format-input [input]
  (partition-by str/blank?
                (str/split-lines (slurp input))))

{:nextjournal.clerk/visibility {:result :hide}}
(defn remove-number-from-string [string]
  (apply str (remove #(Character/isDigit %) string)))

{:nextjournal.clerk/visibility {:result :hide}}
(defn get-stacks-as-vectors [input]
  (->> input
       slurp
       str/split-lines
       (partition-by str/blank?)
       first
       (apply map vector)
       (map #(apply str %))
       (mapv str/trim)
       (remove str/blank?)
       (filter #(re-matches #"(.*\w)" %))
       (mapv #(apply str (remove-number-from-string %)))
       (mapv #(into [] %))))

{:nextjournal.clerk/visibility {:result :hide}}
(defn row-value->move [input]
  (let [[amount  from  to] input]
    {:amount (parse-long amount)
     :from (dec (parse-long from))
     :to (dec (parse-long to))}))

{:nextjournal.clerk/visibility {:result :hide}}
(defn get-moves [input]
  (->> input
       format-input
       last
       (mapv #(str %))
       (mapv #(re-seq #"\d+" %))
       (mapv #(into [] %))
       (mapv #(row-value->move %))))

{:nextjournal.clerk/visibility {:result :hide}}
(defn add-to-crate [stacks moves move-multiple?]
  (vec (reverse
        (into
         (vec (reverse (nth stacks (:to moves))))
         (if move-multiple?
           (reverse (take (:amount moves) (nth stacks (:from moves))))
           ; else
           (take (:amount moves) (nth stacks (:from moves))))))))

{:nextjournal.clerk/visibility {:result :hide}}
(defn remove-from-crate [crates moves]
  (->> (:from moves)
       (nth crates)
       (drop (:amount moves))
       vec))

{:nextjournal.clerk/visibility {:result :hide}}
(defn move-stack [crates moves]
  (->> moves
       (remove-from-crate crates)
       (assoc (assoc crates
                     (:to moves)
                     (add-to-crate crates moves false))
              (:from moves))))

{:nextjournal.clerk/visibility {:result :hide}}
(defn solution-1 [input]
  (apply str (->> input
                  get-moves
                  (reduce move-stack (get-stacks-as-vectors input))
                  (map first))))
{:nextjournal.clerk/visibility {:result :show}}
(solution-1 "input/day_05/input.txt")

{:nextjournal.clerk/visibility {:result :hide}}
(defn move-multiple-stacks [crates moves]
  (->> moves
       (remove-from-crate crates)
       (assoc (assoc crates
                     (:to moves)
                     (add-to-crate crates moves true))
              (:from moves))))

{:nextjournal.clerk/visibility {:result :hide}}
(defn solution-2 [input]
  (apply str
         (->> input
              get-moves
              (reduce move-multiple-stacks
                      (get-stacks-as-vectors input))
              (map first))))

{:nextjournal.clerk/visibility {:result :show}}
(solution-2 "input/day_05/input.txt")

^{:nextjournal.clerk/visibility {:code :hide :result :hide}}
(ns aoc.code.day_05
  (:gen-class)
  (:require
   [clojure.core :as c]
   [clojure.string :as str]))

;# --- Day 5: Supply Stacks ---
; The expedition can depart as soon as the final supplies have been unloaded from the ships. Supplies are stored in stacks of marked crates, but because the needed supplies are buried under many other crates, the crates need to be rearranged.

; The ship has a giant cargo crane capable of moving crates between stacks. To ensure none of the crates get crushed or fall over, the crane operator will rearrange them in a series of carefully-planned steps. After the crates are rearranged, the desired crates will be at the top of each stack.

; The Elves don't want to interrupt the crane operator during this delicate procedure, but they forgot to ask her which crate will end up where, and they want to be ready to unload them as soon as possible so they can embark.

; They do, however, have a drawing of the starting stacks of crates and the rearrangement procedure (your puzzle input). For example:

;     [D]    
; [N] [C]    
; [Z] [M] [P]
;  1   2   3 

; move 1 from 2 to 1
; move 3 from 1 to 3
; move 2 from 2 to 1
; move 1 from 1 to 2

; In this example, there are three stacks of crates. Stack 1 contains two crates: crate Z is on the bottom, and crate N is on top. Stack 2 contains three crates; from bottom to top, they are crates M, C, and D. Finally, stack 3 contains a single crate, P.

; Then, the rearrangement procedure is given. In each step of the procedure, a quantity of crates is moved from one stack to a different stack. In the first step of the above rearrangement procedure, one crate is moved from stack 2 to stack 1, resulting in this configuration:

; [D]        
; [N] [C]    
; [Z] [M] [P]
;  1   2   3 

; In the second step, three crates are moved from stack 1 to stack 3. Crates are moved one at a time, so the first crate to be moved (D) ends up below the second and third crates:

;         [Z]
;         [N]
;     [C] [D]
;     [M] [P]
;  1   2   3

; Then, both crates are moved from stack 2 to stack 1. Again, because crates are moved one at a time, crate C ends up below crate M:

;         [Z]
;         [N]
; [M]     [D]
; [C]     [P]
;  1   2   3

; Finally, one crate is moved from stack 1 to stack 2:

;         [Z]
;         [N]
;         [D]
; [C] [M] [P]
;  1   2   3

; The Elves just need to know which crate will end up on top of each stack; in this example, the top crates are C in stack 1, M in stack 2, and Z in stack 3, so you should combine these together and give the Elves the message CMZ.
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
     :from (parse-long from)
     :to (parse-long to)}))

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
(defn add-to-crate [crates moves]
  (->> (:from moves)
       dec
       (nth crates)
       (take (:amount moves))
       (into (vec (reverse (nth crates (dec (:to moves))))))
       reverse
       vec))

{:nextjournal.clerk/visibility {:result :hide}}
(defn remove-from-crate [crates moves]
  (->> (:from moves)
       dec
       (nth crates)
       (drop (:amount moves))
       vec))

{:nextjournal.clerk/visibility {:result :hide}}
(defn move-crate [crates moves]
  (->> moves
       (remove-from-crate crates)
       (assoc (assoc crates (dec (:to moves)) (add-to-crate crates moves)) (dec (:from moves)))))

{:nextjournal.clerk/visibility {:result :hide}}
(defn solution-1 [input]
  (apply str (->> input
                  get-moves
                  (reduce move-crate (get-stacks-as-vectors input))
                  (map first))))

; After the rearrangement procedure completes, what crate ends up on top of each stack?
{:nextjournal.clerk/visibility {:result :show}}
(solution-1 "input/day_05/input.txt")



^{:nextjournal.clerk/visibility {:code :hide :result :hide}}
(ns aoc.code.day_02
  (:gen-class)
  (:require [clojure.string :as str]))

{:nextjournal.clerk/visibility {:result :hide}}
(def selection {"X" "Rock"
                "Y" "Paper"
                "Z" "Scissors"
                "A" "Rock"
                "B" "Paper"
                "C" "Scissors"})
{:nextjournal.clerk/visibility {:result :hide}}
(def selection-points {"X" 1
                       "Y" 2
                       "Z" 3
                       "A" 1
                       "B" 2
                       "C" 3})
{:nextjournal.clerk/visibility {:result :hide}}
(def game-points {"Win" 6 "Loss" 0 "Draw" 3})
{:nextjournal.clerk/visibility {:result :hide}}
(defn winning-condition [input]
  (let [computer (first input) human (last input)]
    (cond
      (and
       (= (selection computer) "Rock")
       (= (selection human) "Paper"))
      (+ (game-points "Win") (selection-points human))
      (and
       (= (selection computer) "Rock")
       (= (selection human) "Scissors"))
      (+ (game-points "Loss") (selection-points human))
      (and
       (= (selection computer) "Paper")
       (= (selection human) "Scissors"))
      (+ (game-points "Win") (selection-points human))
      (and
       (= (selection computer) "Paper")
       (= (selection human) "Rock"))
      (+ (game-points "Loss") (selection-points human))
      (and
       (= (selection computer) "Scissors")
       (= (selection human) "Rock"))
      (+ (game-points "Win") (selection-points human))
      (and
       (= (selection computer) "Scissors")
       (= (selection human) "Paper"))
      (+ (game-points "Loss") (selection-points human))
      (= (selection computer) (selection human))
      (+ (game-points "Draw") (selection-points human))
      :else "Invalid input")))
;What would your total score be if everything goes exactly according to your strategy guide?
{:nextjournal.clerk/visibility {:result :show}}
(->> "input/day_02/input.txt"
     slurp
     str/split-lines
     (mapv #(str/split % #" "))
     (mapv #(winning-condition %))
     (reduce +))

{:nextjournal.clerk/visibility {:result :hide}}
(defn cheat-condition [input]
  (let [computer (first input) human (last input)]
    (cond
      (= human "Y") (+ (game-points "Draw") (selection-points computer))
      (and
       (= (selection computer) "Paper")
       (= human "X"))
      (+ (game-points "Loss") (selection-points "X"))
      (and
       (= (selection computer) "Scissors")
       (= human "X"))
      (+ (game-points "Loss") (selection-points "Y"))
      (and
       (= (selection computer) "Rock")
       (= human "X"))
      (+ (game-points "Loss") (selection-points "Z"))
      (and
       (= (selection computer) "Paper")
       (= human "Z"))
      (+ (game-points "Win") (selection-points "Z"))
      (and
       (= (selection computer) "Scissors")
       (= human "Z"))
      (+ (game-points "Win") (selection-points "X"))
      (and
       (= (selection computer) "Rock")
       (= human "Z"))
      (+ (game-points "Win") (selection-points "Y"))
      :else "Invalid input")))

{:nextjournal.clerk/visibility {:result :show}}
(->> "input/day_02/input.txt"
     slurp
     str/split-lines
     (mapv #(str/split % #" "))
     (mapv #(cheat-condition %))
     (reduce +))

 ^{:nextjournal.clerk/visibility {:code :hide :result :hide}}
(require '[nextjournal.clerk :as clerk]
         '[clojure.string :as str])

{:nextjournal.clerk/visibility {:result :hide}}
(defn get-marker-index [input length]
  (let [groups (partition length 1 input)]
    (loop [index 0]
      (if (= length (count (distinct (nth groups index))))
        (+ index length)
        (recur (inc index))))))

{:nextjournal.clerk/visibility {:result :show}}
(get-marker-index (slurp "input/day_06/input.txt") 4)

{:nextjournal.clerk/visibility {:result :show}}
(get-marker-index (slurp "input/day_06/input.txt") 14)

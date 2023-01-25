(ns aoc.core
  (:gen-class)
  (:require [nextjournal.clerk :as clerk]))

;; start Clerk's built-in webserver on the default port 7777, opening the browser when done
; (clerk/serve! {:browse? true})
; (clerk/show! "src/aoc/code/day_04.clj")

;; either call `clerk/show!` explicitly
(defn -main []
  (clerk/build! {:paths ["src/aoc/code/day_01.clj"
                         "src/aoc/code/day_02.clj"
                         "src/aoc/code/day_03.clj"
                         "src/aoc/code/day_03.clj"
                         "src/aoc/code/day_04.clj"
                         "src/aoc/code/day_05.clj"
                         "src/aoc/code/day_06.clj"
                         "src/aoc/code/day_07.clj"
                         "src/aoc/code/day_08.clj"
                         "src/aoc/code/day_09.clj"
                         "src/aoc/code/day_10.clj"
                         "src/aoc/code/day_11.clj"
                         "src/aoc/code/day_12.clj"
                         "src/aoc/code/day_13.clj"
                         "src/aoc/code/day_14.clj"
                         "src/aoc/code/day_15.clj"
                         "src/aoc/code/day_16.clj"
                         "src/aoc/code/day_17.clj"
                         "src/aoc/code/day_18.clj"
                         "src/aoc/code/day_19.clj"
                         "src/aoc/code/day_20.clj"
                         "src/aoc/code/day_21.clj"
                         "src/aoc/code/day_22.clj"
                         "src/aoc/code/day_23.clj"
                         "src/aoc/code/day_24.clj"
                         "src/aoc/code/day_25.clj"]
                 :bundle true :out-path "public/build"}))

;; or let Clerk watch the given `:paths` for changes
;; start with watcher and show filter function to enable notebook pinning
; (clerk/serve! {:watch-paths ["code"] :show-filter-fn #(clojure.string/starts-with? % "code")})



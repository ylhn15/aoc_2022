(ns aoc.core
  (:gen-class)
  (:require [nextjournal.clerk :as clerk]))

;; start Clerk's built-in webserver on the default port 7777, opening the browser when done
(clerk/serve! {:browse? true})
(clerk/show! "code/day_02.clj")

;; either call `clerk/show!` explicitly
; (defn -main []
;   (clerk/build! {:paths ["code/day_01.clj"
;                          "code/day_02.clj"
;                          "code/day_03.clj"
;                          "code/day_03.clj"
;                          "code/day_04.clj"
;                          "code/day_05.clj"
;                          "code/day_06.clj"
;                          "code/day_07.clj"
;                          "code/day_08.clj"
;                          "code/day_09.clj"
;                          "code/day_10.clj"
;                          "code/day_11.clj"
;                          "code/day_12.clj"
;                          "code/day_13.clj"
;                          "code/day_14.clj"
;                          "code/day_15.clj"
;                          "code/day_16.clj"
;                          "code/day_17.clj"
;                          "code/day_18.clj"
;                          "code/day_19.clj"
;                          "code/day_20.clj"
;                          "code/day_21.clj"
;                          "code/day_22.clj"
;                          "code/day_23.clj"
;                          "code/day_24.clj"
;                          "code/day_25.clj"]
;                  :bundle true :out-path "public/build"}))

;; or let Clerk watch the given `:paths` for changes
;; start with watcher and show filter function to enable notebook pinning
; (clerk/serve! {:watch-paths ["code"] :show-filter-fn #(clojure.string/starts-with? % "code")})



(require '[nextjournal.clerk :as clerk])

;; start Clerk's built-in webserver on the default port 7777, opening the browser when done
(clerk/serve! {:browse? true})

;; either call `clerk/show!` explicitly
(clerk/show! "code/aoc_1/aoc_1.clj")

(clerk/build! {:paths ["code/aoc_1/aoc_1.clj" "code/aoc_2/aoc_2.clj"] :bundle true :ssr true :out-path "public/build"})

;; or let Clerk watch the given `:paths` for changes
(clerk/serve! {:watch-paths ["code"]})

;; start with watcher and show filter function to enable notebook pinning
(clerk/serve! {:watch-paths ["code"] :show-filter-fn #(clojure.string/starts-with? % "code")})

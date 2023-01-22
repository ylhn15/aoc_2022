(require '[nextjournal.clerk :as clerk])

;; start Clerk's built-in webserver on the default port 7777, opening the browser when done
(clerk/serve! {:browse? true})

;; either call `clerk/show!` explicitly
(clerk/show! "code/aoc_1/aoc_1.clj")

;; or let Clerk watch the given `:paths` for changes
(clerk/serve! {:watch-paths ["code"]})

;; start with watcher and show filter function to enable notebook pinning
(clerk/serve! {:watch-paths ["code"] :show-filter-fn #(clojure.string/starts-with? % "code")})

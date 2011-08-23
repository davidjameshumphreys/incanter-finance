(ns incanter.finance
  (:require [incanter.stats :as stats]))

(defn
  ^{:doc "Calculates the daily historic volatility for the input data.
Assumes the first item is the oldest timepoint."}
  historic-volatility [coll]
  (stats/sd
   (map
    (fn [[a b]] (Math/log (/ b a)))
    (partition 2 1 coll))))

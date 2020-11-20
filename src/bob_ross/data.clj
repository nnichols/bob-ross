(ns bob-ross.data
  "Functions to access data from https://github.com/fivethirtyeight/data/blob/master/bob-ross/elements-by-episode.csv"
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io]))

(defn csv->map
  "Normalize `clojure.data.csv` data into a list of maps with header:row-value data"
  [csv-data]
  (let [header (->> (first csv-data)
                    (map keyword)
                    repeat)
        body (rest csv-data)]
    (mapv zipmap header body)))

(def bob-ross-episodes
  "FiveThirtyEight data on Bob Ross episodes"
  (with-open [reader (io/reader "resources/episodes.csv")]
    (csv->map (csv/read-csv reader))))

(def sample-row
  {:CACTUS             "0"
   :RIVER              "1"
   :BARN               "0"
   :BOAT               "0"
   :MOUNTAINS          "0"
   :CIRRUS             "0"
   :CONIFER            "0"
   :HALF_OVAL_FRAME    "0"
   :TRIPLE_FRAME       "0"
   :DECIDUOUS          "1"
   :LAKES              "0"
   :FLOWERS            "0"
   :AURORA_BOREALIS    "0"
   :FIRE               "0"
   :PATH               "0"
   :FARM               "0"
   :TOMB_FRAME         "0"
   :FLORIDA_FRAME      "0"
   :BEACH              "0"
   :SNOWY_MOUNTAIN     "0"
   :PERSON             "0"
   :MILL               "0"
   :PORTRAIT           "0"
   :NIGHT              "0"
   :STEVE_ROSS         "0"
   :OVAL_FRAME         "0"
   :DOCK               "0"
   :ROCKS              "0"
   :BRIDGE             "0"
   :MOON               "0"
   :FOG                "0"
   :LAKE               "0"
   :CUMULUS            "0"
   :APPLE_FRAME        "0"
   :WATERFALL          "0"
   :CLOUDS             "0"
   :SUN                "0"
   :TREE               "1"
   :WINTER             "0"
   :GUEST              "0"
   :CLIFF              "0"
   :WINDOW_FRAME       "0"
   :CABIN              "0"
   :EPISODE            "S01E01"
   :TREES              "1"
   :SNOW               "0"
   :WINDMILL           "0"
   :GRASS              "1"
   :BUSHES             "1"
   :PALM_TREES         "0"
   :MOUNTAIN           "0"
   :SPLIT_FRAME        "0"
   :BUILDING           "0"
   :SEASHELL_FRAME     "0"
   :HILLS              "0"
   :WAVES              "0"
   :FRAMED             "0"
   :TITLE              "A WALK IN THE WOODS"
   :STRUCTURE          "0"
   :CIRCLE_FRAME       "0"
   :OCEAN              "0"
   :RECTANGULAR_FRAME  "0"
   :LIGHTHOUSE         "0"
   :DIANE_ANDRE        "0"
   :FENCE              "0"
   :DOUBLE_OVAL_FRAME  "0"
   :RECTANGLE_3D_FRAME "0"
   :HALF_CIRCLE_FRAME  "0"
   :WOOD_FRAMED        "0"})

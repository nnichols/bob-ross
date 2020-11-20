(ns bob-ross.core
  (:require [bob-ross.data :as ross]
            [clojure.string :as str]))

(def episodes ross/bob-ross-episodes)

(defn first-episode-title
  "The Joy of Painting first aired on January 11, 1983.
   What was the title of the first episode?"
  [])

(defn boat-episode?
  "Water was one of Bob Ross's favorite background subjects.
   Given an episode map, return a boolean indiacting if that episode featured a boat"
  [episode])

(defn steve-ross-episodes
  "Bob Ross's son, Steve, appeared on The Joy of Painting regularly.
   How many episodes featured him?"
  [])

(defn find-episodes-by-subject
  "Bob Ross was best known for painting happy little trees, but painted many familiar subjects.
   Given a string, such as 'Tree', find every episode identifier (e.g. 'S01E01') that had a tree painted in it."
  [subject])

(defn find-subjects-by-episode
  "The Joy of Painting taught viewers how to paint several of nature's gifts each episode.
   Given an episode and season number (e.g. '1' '1'), return a list of the things painted in that episode ('TREE', 'BUSHES', ...).
   If no episode exists for that combination (e.g. '-1' '10000'), return :not-found"
  [season-number episode-number])

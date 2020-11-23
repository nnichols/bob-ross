(ns bob-ross.core
  (:require [bob-ross.data :as ross]
            [clojure.string :as str]))

(def episodes ross/bob-ross-episodes)
(def subjects (keys (dissoc (first episodes) :EPISODE :TITLE)))

(defn first-episode-title
  "The Joy of Painting first aired on January 11, 1983.
   What was the title of the first episode?"
  []
  (:TITLE (first episodes)))

(defn boat-episode?
  "Water was one of Bob Ross's favorite background subjects.
   Given an episode map, return a boolean indiacting if that episode featured a boat"
  [episode]
  (= "1" (:BOAT episode)))

(defn steve-ross-episodes
  "Bob Ross's son, Steve, appeared on The Joy of Painting regularly.
   How many episodes featured him?"
  []
  (count (filter #(= "1" (:STEVE_ROSS %)) episodes)))

(defn find-episodes-by-subject
  "Bob Ross was best known for painting happy little trees, but painted many familiar subjects.
   Given a keyword, such as ':TREE', find every episode identifier (e.g. 'S01E01') that had a tree painted in it."
  [subject]
  (let [subject (if (keyword? subject) subject (keyword (clojure.string/upper-case subject)))
        ->episode (fn [e] (:EPISODE e))]
    (map ->episode (filter #(= "1" (get % subject)) episodes))))

(defn pad-episode-data
  [n]
  (if (> n 9)
    (str n)
    (str "0" n)))

(def episode-lookup
  (zipmap (map :EPISODE episodes) episodes))

(defn find-subjects-by-episode
  "The Joy of Painting taught viewers how to paint several of nature's gifts each episode.
   Given an episode and season number (e.g. '1' '1'), return a list of the things painted in that episode (:TREE, :BUSHES, ...).
   If no episode exists for that combination (e.g. '-1' '10000'), return :not-found"
  [season-number episode-number]
  (let [episode-id (str "S" (pad-episode-data season-number) "E" (pad-episode-data episode-number))
        episode (first (filter #(= episode-id (:EPISODE %)) episodes))
        episode->contents (fn [c k v] (if (= "1" v) (conj c k) c))]
    (if episode
      (reduce-kv episode->contents [] episode)
      :not-found)))

(defn find-episodes-by-subject-optimized
  [season-number episode-number]
  (let [episode-id (str "S" (pad-episode-data season-number) "E" (pad-episode-data episode-number))
        episode (get episode-lookup episode-id)
        episode->contents (fn [c k v] (if (= "1" v) (conj c k) c))]
    (if episode
      (reduce-kv episode->contents [] episode)
      :not-found)))

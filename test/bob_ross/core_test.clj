(ns bob-ross.core-test
  (:require [bob-ross.core :as ross]
            [clojure.test :refer :all]))

(deftest ^:first first-episode-test
  (testing "Ensure students know the first episode's title"
    (is (= "A WALK IN THE WOODS" (ross/first-episode-title)))))

(deftest ^:second boat-episode-test
  (testing "Ensure students can identify if an episode contains a boat"
    (is (false? (ross/boat-episode? (first ross/episodes))))
    (is (true? (ross/boat-episode? (nth ross/episodes 308))))))

(deftest ^:third steve-ross-episodes-test
  (testing "Ensure students can count the number of Steve Ross episodes"
    (is (= 11 (ross/steve-ross-episodes)))))

(deftest ^:fourth find-episodes-test
  (testing "Ensure students can aggregate episodes by subject"
    (is (= 11 (count (ross/find-episodes-by-subject :STEVE_ROSS))))))

(deftest ^:fourth-challenge find-episodes-test-challenge
  (testing "Ensure students can aggregate episodes by subject"
    (is (= (ross/find-episodes-by-subject "tREe") (ross/find-episodes-by-subject :TREE)))))

(deftest ^:fifth find-subjects-by-episode-test
  (testing  "Ensure students can lookup episodes by id"
    (is (= '(:CONIFER :SNOWY_MOUNTAIN :CLOUDS :TREE :WINTER :CABIN :TREES :SNOW :MOUNTAIN)
           (ross/find-subjects-by-episode 1 2)))
    (is (= :not-found (ross/find-subjects-by-episode -1 2)))))

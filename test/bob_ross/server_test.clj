(ns bob-ross.server-test
  (:require [bob-ross.server :as server]
            [clojure.test :refer :all]
            [ring.mock.request :as mock]))

(deftest ^:server test-routes
  (testing "Route testing"
    (is (= 404 (:status (server/app (mock/request :get "/v1/fake-route")))))
    (is (= 200 (:status (server/app (mock/request :get "/v1/episodes/subject/TREE")))))))

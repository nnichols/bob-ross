(ns bob-ross.server
  (:require [bob-ross.core :as ross]
            [ring.adapter.jetty :as jetty]
            [compojure.core :refer [defroutes GET]]
            [compojure.route :as route]
            [ring.util.response :refer [response]]
            [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.json :refer [wrap-json-response]])
  (:gen-class))

(defroutes v1
  (GET "/v1/episodes/subject/:subject" {{:keys [subject]} :params}
    (response (ross/find-episodes-by-subject subject)))

  (GET "/v1/episodes/season/:season/episode/:episode" {{:keys [season episode]} :params}
    (response (ross/find-subjects-by-episode season episode)))

  (route/not-found (response {:message "not found"})))

(def app (-> v1 wrap-json-response wrap-params))

(defn -main
  []
  (jetty/run-jetty app {:port 8080}))

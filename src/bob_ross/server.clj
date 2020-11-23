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
    (let [episodes (ross/find-episodes-by-subject subject)]
      (if (empty? episodes)
        {:status 404}
        (response episodes))))

  (GET "/v1/episodes/season/:season/episode/:episode" {{:keys [season episode]} :params}
    (let [subjects (ross/find-subjects-by-episode season episode)]
      (if (= :not-found subjects)
        {:status 404}
        (response subjects))))
  
  (GET "/v1/episodes/subject" {}
    (response ross/subjects))

  (route/not-found (response {:message "not found"})))

(def app (-> v1 wrap-json-response wrap-params))

(defn -main
  []
  (jetty/run-jetty app {:port 8080}))

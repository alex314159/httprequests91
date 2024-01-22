(ns httprequests91.core
  (:require [org.httpkit.client :as http]
            [jsonista.core :as jsonista])
  )

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))


(defn python-minimal-example-again []
  (let [novagpt4url "https://nova.ninetyone.com/GenAISandbox_Core/rest/GenAISandbox/documentsearch/teams/search"
        HEADERS {"x-api-key" "89084b44-dcec-4889-882a-6cb9dd854f87"
                 "Content-Type" "application/json",
                 "Accept" "application/json"}]
    (http/post novagpt4url {                                ;:insecure? true
                            :headers HEADERS
                            :body (jsonista/write-value-as-string {"Input" "Summarize the latest developments with IHS Towers." , "Group" "EM Corporate Debt"})})))

(defn testroute []
  ;THIS WORKS
  (http/get (str "https://jasmine:5120/v1/comparator?as_of_date=2023-11-01&active_codes=OGEMCORD&comparator_label=Official"))
  )
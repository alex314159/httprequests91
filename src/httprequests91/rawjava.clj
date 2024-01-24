(ns httprequests91.rawjava
  (:import
           (com.fasterxml.jackson.databind ObjectMapper)
           (java.net.http HttpClient HttpRequest HttpResponse HttpRequest$BodyPublishers HttpResponse$BodyHandlers)
           (java.net URI)
           (java.util HashMap)))

(defn makeRequestBody []
  (let [values (doto (HashMap.)
                    (.put "Input" "You are a financial analyst working in the corporate advisory team. You are investigating new company updates. Write a report on Braskem")
                    (.put "Group" "EM Corporate Debt"))
        objectMapper (ObjectMapper.)]
    (.writeValueAsString objectMapper values)))

(def API_URL "https://nova.ninetyone.com/GenAISandbox_Core/rest/GenAISandbox/documentsearch/teams/search")
(def API_KEY "ddfd1400-82b3-4903-af0d-a0e7b5814e05")

(defn buildRequest [requestBody]
  (let [builder (doto (HttpRequest/newBuilder (URI. API_URL))
                  (.header "x-api-key" API_KEY )
                  (.header "Content-Type" "application/json")
                  (.POST (HttpRequest$BodyPublishers/ofString requestBody)))]
    (.build builder)))


(defn main-request []
  (let [requestBody (makeRequestBody)
        httpRequest (buildRequest requestBody)
        client (HttpClient/newHttpClient)
        response (.send client httpRequest (HttpResponse$BodyHandlers/ofString))]
    (println (.body response))
    response))

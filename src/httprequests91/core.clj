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
        HEADERS {"x-api-key" "ddfd1400-82b3-4903-af0d-a0e7b5814e05"
                 "Content-Type" "application/json",
                 }]                                         ;"Accept" "application/json"
    (http/post novagpt4url {                                ;:insecure? true
                            :headers HEADERS
                            :body (jsonista/write-value-as-string {"Input" "Summarize the latest developments with IHS Towers." , "Group" "EM Corporate Debt"})})))

(defn new-example []
  (http/request {:url "https://nova.ninetyone.com/GenAISandbox_Core/rest/GenAISandbox/documentsearch/teams/search"
                 :method :post
                 ;:user-agent "User-Agent string"
                 ;:oauth-token "your-token"
                 :headers {"Content-Type" "application/json"
                           "x-api-key" "ddfd1400-82b3-4903-af0d-a0e7b5814e05"}
                 ;:query-params {"q" "foo, bar"} ;"Nested" query parameters are also supported
                 ;:form-params {"q" "foo, bar"} ; just like query-params, except sent in the body
                 :body "hello"
                 :basic-auth ["user" "pass"]
                 :keepalive 3000          ; Keep the TCP connection for 3000ms
                 :timeout 1000      ; connection timeout and reading timeout 1000ms
                 :filter (http/max-body-filter (* 1024 100)) ; reject if body is more than 100k
                 ;:insecure? true ; Need to contact a server with an untrusted SSL cert?

                 :max-redirects 10 ; Max redirects to follow
                 ;; whether follow 301/302 redirects automatically, default to true
                 ;; :trace-redirects will contain the chain of the redirections followed.
                 :follow-redirects true
                 })

  )

(defn testroute []
  ;THIS WORKS
  (http/get (str "https://jasmine:5120/v1/comparator?as_of_date=2023-11-01&active_codes=OGEMCORD&comparator_label=Official"))
  )
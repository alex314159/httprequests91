(defproject httprequests91 "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.4"]
                 [http-kit "2.8.0"]
                 [metosin/jsonista "0.3.10"]
                 ;[com.microsoft.sqlserver/mssql-jdbc "11.2.3.jre17"]
                 [com.microsoft.sqlserver/mssql-jdbc "10.2.0.jre17"]
                 [com.github.seancorfield/next.jdbc "1.3.939"]
                 [org.xerial/sqlite-jdbc "3.46.1.0"]]
  ;:jvm-opts ["-Djavax.net.ssl.trustStoreType=WINDOWS-ROOT"]

  :repl-options {:init-ns httprequests91.core})

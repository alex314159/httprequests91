(ns httprequests91.mssql
  (:require  [next.jdbc :as jdbc]
             [next.jdbc.sql :as sql])
  (:import java.sql.Connection java.sql.DriverManager)
  )

(def EMFI_SPEC
  {:dbtype                 "mssql"
   :dbname                 "EMFI"
   :host                   "IAML4FLIVE"
   :trustServerCertificate true
   :integratedSecurity     true
   :authenticationScheme   "NativeAuthentication"})

(def emfi_connection (jdbc/get-datasource EMFI_SPEC))

(defn dummy-query [] (map :portfolio_name (jdbc/execute! emfi_connection ["SELECT [portfolio_id],[portfolio_name],[portfolio_status],[associated_benchmark_code]FROM [EMFI].[emcd].[tbl_sys_portfolios] WHERE [portfolio_status] = 'dummy' "])))


(def url "jdbc:sqlserver://IAML4FLIVE;database=EMFI;user=*****;password=***;encrypt=true;trustServerCertificate=true;loginTimeout=30;")
(def conn (DriverManager/getConnection url))

(def EMFI_SPEC_WITH_USERNAME
  {:dbtype                 "mssql"
   :dbname                 "EMFI"
   :host                   "IAML4FLIVE"
   :user                    "***"
   :password                "***"
   :trustServerCertificate true
   :encrypt                   true
   ;:integratedSecurity     true
   ;:authenticationScheme   "NativeAuthentication"
   })
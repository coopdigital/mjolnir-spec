(ns mjolnir.core
  (:gen-class))

(defn -main
  "Takes three arguments, for database [type], database port
  and frequency of operation in ms."
  [db port frequency]
  (let []
    (println (str "> Starting... \n"
                  "> Running against "
                  db
                  " on port "
                  port
                  " every "
                  frequency
                  " milliseconds..."))))

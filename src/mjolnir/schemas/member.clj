(ns mjolnir.schemas.member
  (:require [clojure.spec.alpha :as s]
            [clojure.spec.gen.alpha :as gen]))

(defn gen-uuid-str []
  (-> (java.util.UUID/randomUUID)
      str))

(def non-blank-str?
  (fn [s]
    (not (clojure.string/blank? s))))

(def non-blank-str-generator
  (gen/such-that non-blank-str? (gen/string-alphanumeric)))

(def str-with-gen (s/with-gen string?
                        #(gen/such-that non-blank-str?
                                        (gen/string-alphanumeric))))

(def email-regex #"^\S+@\S+\.\S+$")
(s/def ::email-formatter (s/and string? #(re-matches email-regex %)))

(s/def ::_id (s/with-gen string?
               #(gen/fmap (fn [s] (gen-uuid-str)) ;; discard gen string
                          (gen/string-alphanumeric))))

;;(s/def ::email string?)
(s/def ::phone int?)

(s/def ::employee_number str-with-gen)
(s/def ::last_name str-with-gen)
(s/def ::birth_date str-with-gen)
(s/def ::mdm_id str-with-gen)
(s/def ::date_processed_as_leaver str-with-gen)
(s/def ::sunlight_member_id str-with-gen)
(s/def ::fk_employment_id str-with-gen)
(s/def ::payroll str-with-gen)
(s/def ::business_unit str-with-gen)
(s/def ::location str-with-gen)
(s/def ::start_date str-with-gen)
(s/def ::end_date str-with-gen)
(s/def ::leaver_code str-with-gen)
(s/def ::transaction_type str-with-gen)
(s/def ::batch_number str-with-gen)
(s/def ::insert_timestamp str-with-gen)
(s/def ::CardNumber str-with-gen)
(s/def ::MemberID str-with-gen)
(s/def ::CardType str-with-gen)
(s/def ::SpendStatus str-with-gen)
(s/def ::StartDate str-with-gen)
(s/def ::EndDate str-with-gen)
(s/def ::CardCancellationReason str-with-gen)
(s/def ::SequenceID str-with-gen)
(s/def ::Rule1_Flag str-with-gen)
(s/def ::Rule1_Spend str-with-gen)
(s/def ::Rule2_Flag str-with-gen)
(s/def ::Rule3_Flag str-with-gen)
(s/def ::Rule4_Flag str-with-gen)
(s/def ::Rule5_Flag str-with-gen)
(s/def ::Rule6_Flag str-with-gen)
(s/def ::Rule6_Points str-with-gen)
(s/def ::Overall_Flag str-with-gen)
(s/def ::CreationDate str-with-gen)
(s/def ::LastModificationDate str-with-gen)
(s/def ::SequenceID str-with-gen)
(s/def ::MemberID str-with-gen)
(s/def ::ReferrerMemberID str-with-gen)
(s/def ::CreationDate str-with-gen)
(s/def ::CONT_ID str-with-gen)
(s/def ::BIRTH_DT str-with-gen)
(s/def ::PREFIX_NAME_TP_CD str-with-gen)
(s/def ::FIRST_NAME str-with-gen)
(s/def ::LAST_NAME str-with-gen)
(s/def ::SHARE_ACCOUNT_STATUS_TP_CD str-with-gen)
(s/def ::SHARE_ACCOUNT_NUMBER str-with-gen)
(s/def ::PARTY_STATUS_TP_CD str-with-gen)
(s/def ::PERSON_ORG_CODE str-with-gen)
(s/def ::PARTY_MEMBER_TYPE_TP_CD str-with-gen)
(s/def ::PARTY_SECONDARY_TP_CD str-with-gen)
(s/def ::PARTY_VIP_TP_CD str-with-gen)
(s/def ::INFORMATION_FORMAT_TP_CD str-with-gen)
(s/def ::EMPLOYEE_ID str-with-gen)
(s/def ::LOB_REL_TP_CD str-with-gen)
(s/def ::LOB_TP_CD str-with-gen)
(s/def ::CHANNEL_TP_CD str-with-gen)
(s/def ::SOURCE_IDENT_TP_CD str-with-gen)
(s/def ::sunlight_id str-with-gen)
(s/def ::email (s/with-gen ::email-formatter
                 #(gen/fmap (fn [[user host tld]] (str user "@" host "." tld))
                            (gen/tuple non-blank-str-generator
                                       non-blank-str-generator
                                       non-blank-str-generator))))
(s/def ::CONT_ID str-with-gen)
(s/def ::ADDR_LINE_ONE str-with-gen)
(s/def ::ADDR_LINE_TWO str-with-gen)
(s/def ::ADDR_LINE_THREE str-with-gen)
(s/def ::CITY_NAME str-with-gen)
(s/def ::COUNTY_TP_CD str-with-gen)
(s/def ::POSTAL_CODE str-with-gen)
(s/def ::COUNTRY_TP_CD str-with-gen)
(s/def ::ADDR_USAGE_TP_CD str-with-gen)
(s/def ::START_DT str-with-gen)
(s/def ::END_DT str-with-gen)
(s/def ::FOREIGN_INDICATOR str-with-gen)
(s/def ::ADDRESS_OVERRIDE_IND str-with-gen)
(s/def ::LATITUDE_DEGREES str-with-gen)
(s/def ::LONGITUDE_DEGREES str-with-gen)
(s/def ::EXT_GONE_AWAY_TP_CD str-with-gen)
(s/def ::EXT_GONE_AWAY_DT str-with-gen)
(s/def ::INT_GONE_AWAY_TP_CD str-with-gen)
(s/def ::INT_GONE_AWAY_DT str-with-gen)
(s/def ::CONT_ID str-with-gen)
(s/def ::PREFERRED_IND str-with-gen)
(s/def ::CONT_METH_CAT_CD str-with-gen)
(s/def ::CONT_METH_TP_CD str-with-gen)
(s/def ::REF_NUM str-with-gen)
(s/def ::PPREF_INSTANCE_PK str-with-gen)
(s/def ::SOURCE_IDENT_TP_CD str-with-gen)
(s/def ::PPREF_REASON_TP_CD str-with-gen)
(s/def ::LOB_NAME str-with-gen)
(s/def ::PPREF_TP_CD str-with-gen)
(s/def ::VALUE_STRING str-with-gen)

;; a mock for full mocks of a rough member shape to be bashed into a
;; streaming store.
(s/def ::member-producer-mock
  (s/keys :req [::_id]
          :opt [::employee_number
                ::last_name
                ::birth_date
                ::mdm_id
                ::date_processed_as_leaver
                ::sunlight_member_id
                ::fk_employment_id
                ::payroll
                ::business_unit
                ::location
                ::start_date
                ::end_date
                ::leaver_code
                ::transaction_type
                ::batch_number
                ::insert_timestamp
                ::CardNumber
                ::MemberID
                ::CardType
                ::SpendStatus
                ::StartDate
                ::EndDate
                ::CardCancellationReason
                ::SequenceID
                ::Rule1_Flag
                ::Rule1_Spend
                ::Rule2_Flag
                ::Rule3_Flag
                ::Rule4_Flag
                ::Rule5_Flag
                ::Rule6_Flag
                ::Rule6_Points
                ::Overall_Flag
                ::CreationDate
                ::LastModificationDate
                ::SequenceID
                ::MemberID
                ::ReferrerMemberID
                ::CreationDate
                ::CONT_ID
                ::BIRTH_DT
                ::PREFIX_NAME_TP_CD
                ::FIRST_NAME
                ::LAST_NAME
                ::SHARE_ACCOUNT_STATUS_TP_CD
                ::SHARE_ACCOUNT_NUMBER
                ::PARTY_STATUS_TP_CD
                ::PERSON_ORG_CODE
                ::PARTY_MEMBER_TYPE_TP_CD
                ::PARTY_SECONDARY_TP_CD
                ::PARTY_VIP_TP_CD
                ::INFORMATION_FORMAT_TP_CD
                ::EMPLOYEE_ID
                ::LOB_REL_TP_CD
                ::LOB_TP_CD
                ::CHANNEL_TP_CD
                ::SOURCE_IDENT_TP_CD
                ::sunlight_id
                ::email
                ::CONT_ID
                ::ADDR_LINE_ONE
                ::ADDR_LINE_TWO
                ::ADDR_LINE_THREE
                ::CITY_NAME
                ::COUNTY_TP_CD
                ::POSTAL_CODE
                ::COUNTRY_TP_CD
                ::ADDR_USAGE_TP_CD
                ::START_DT
                ::END_DT
                ::FOREIGN_INDICATOR
                ::ADDRESS_OVERRIDE_IND
                ::LATITUDE_DEGREES
                ::LONGITUDE_DEGREES
                ::EXT_GONE_AWAY_TP_CD
                ::EXT_GONE_AWAY_DT
                ::INT_GONE_AWAY_TP_CD
                ::INT_GONE_AWAY_DT
                ::CONT_ID
                ::PREFERRED_IND
                ::CONT_METH_CAT_CD
                ::CONT_METH_TP_CD
                ::REF_NUM
                ::PPREF_INSTANCE_PK
                ::SOURCE_IDENT_TP_CD
                ::PPREF_REASON_TP_CD
                ::LOB_NAME
                ::PPREF_TP_CD
                ::VALUE_STRING]))

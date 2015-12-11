// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.interfaces.a;

import com.target.mothership.model.common.a.b;
import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.j;
import com.target.mothership.util.o;

public class d extends b
{
    public static final class a extends Enum
        implements j
    {

        private static final a $VALUES[];
        public static final a ERR_ACCOUNT_IN_USE;
        public static final a ERR_ADDRESS2_LINE2_PATTERN;
        public static final a ERR_ADDRESS_ID_INVALID;
        public static final a ERR_ADDRESS_ID_PATTERN;
        public static final a ERR_ADDRESS_LINE1_PATTERN;
        public static final a ERR_ADDRESS_LINE1_REQUIRED;
        public static final a ERR_CARD_EXPIRY_MONTH_REQUIRED;
        public static final a ERR_CARD_EXPIRY_YEAR_REQUIRED;
        public static final a ERR_CARD_INFORMATION_INVALID;
        public static final a ERR_CARD_NAME_PATTERN;
        public static final a ERR_CARD_NAME_REQUIRED;
        public static final a ERR_CARD_NUMBER_INVALID;
        public static final a ERR_CARD_NUMBER_REQUIRED;
        public static final a ERR_CARD_TYPE_INVALID;
        public static final a ERR_CARD_TYPE_REQUIRED;
        public static final a ERR_CART_EMPTY;
        public static final a ERR_CART_UNKNOWN;
        public static final a ERR_CITY_PATTERN;
        public static final a ERR_CITY_REQUIRED;
        public static final a ERR_COUNTRY_REQUIRED;
        public static final a ERR_CVV_PATTERN;
        public static final a ERR_CVV_REQUIRED;
        public static final a ERR_FIRST_NAME_PATTERN;
        public static final a ERR_FIRST_NAME_REQUIRED;
        public static final a ERR_LAST_NAME_PATTERN;
        public static final a ERR_LAST_NAME_REQUIRED;
        public static final a ERR_MEMBER_CARD_INFO_ID_INVALID;
        public static final a ERR_MEMBER_CARD_INFO_ID_PATTERN;
        public static final a ERR_MEMBER_CARD_INFO_ID_REQUIRED;
        public static final a ERR_PHONE_PATTERN;
        public static final a ERR_PHONE_REQUIRED;
        public static final a ERR_REAUTH_REQUIRED;
        public static final a ERR_STATE_MAX_LENGTH;
        public static final a ERR_STATE_REQUIRED;
        public static final a ERR_TC_PIN_PATTERN;
        public static final a ERR_TC_PIN_REQUIRED;
        public static final a ERR_TIMEOUT;
        public static final a ERR_TOKEN_EXPIRED;
        public static final a ERR_TOO_MANY_REQUESTS;
        public static final a ERR_ZIP_CODE_PATTERN;
        public static final a ERR_ZIP_CODE_REQUIRED;
        private c mErrorCodes[];

        public static a a(com.target.mothership.model.cart.a.j j1)
        {
            c c1;
            c1 = j1.a();
            if (c1 != c._ERR_CMD_INVALID_PARAM)
            {
                break MISSING_BLOCK_LABEL_62;
            }
            if (!o.g(j1.b()))
            {
                break MISSING_BLOCK_LABEL_58;
            }
            if (!j1.b().startsWith("memberCardInfoId"))
            {
                break MISSING_BLOCK_LABEL_41;
            }
            j1 = ERR_MEMBER_CARD_INFO_ID_INVALID;
            return j1;
            if (j1.b().startsWith("addressId"))
            {
                return ERR_ADDRESS_ID_INVALID;
            }
            return ERR_CART_UNKNOWN;
            a a1;
            a aa[];
            c ac[];
            int i;
            int k;
            int l;
            int i1;
            aa = values();
            l = aa.length;
            i = 0;
              goto _L1
            continue; /* Loop/switch isn't completed */
            i++;
        }

        public static a a(c c1)
        {
            a aa[] = values();
            int l = aa.length;
            for (int i = 0; i < l; i++)
            {
                a a1 = aa[i];
                c ac[] = a1.a();
                int i1 = ac.length;
                for (int k = 0; k < i1; k++)
                {
                    if (ac[k] == c1)
                    {
                        return a1;
                    }
                }

            }

            return ERR_CART_UNKNOWN;
        }

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/mothership/model/cart/interfaces/a/d$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        public c[] a()
        {
            return mErrorCodes;
        }

        static 
        {
            ERR_MEMBER_CARD_INFO_ID_REQUIRED = new a("ERR_MEMBER_CARD_INFO_ID_REQUIRED", 0, new c[] {
                c._ERR_REQUIRED_MEMBERCARDINFOID
            });
            ERR_MEMBER_CARD_INFO_ID_PATTERN = new a("ERR_MEMBER_CARD_INFO_ID_PATTERN", 1, new c[] {
                c._ERR_PATTERN_MEMBERCARDINFOID
            });
            ERR_MEMBER_CARD_INFO_ID_INVALID = new a("ERR_MEMBER_CARD_INFO_ID_INVALID", 2, new c[0]);
            ERR_CVV_REQUIRED = new a("ERR_CVV_REQUIRED", 3, new c[] {
                c._ERR_REQUIRED_CVV
            });
            ERR_CVV_PATTERN = new a("ERR_CVV_PATTERN", 4, new c[] {
                c._ERR_MIN_LENGTH_CVV, c._ERR_MAX_LENGTH_CVV, c._ERR_PATTERN_CVV
            });
            ERR_TC_PIN_REQUIRED = new a("ERR_TC_PIN_REQUIRED", 5, new c[] {
                c._ERR_REQUIRED_TCPINNUM
            });
            ERR_TC_PIN_PATTERN = new a("ERR_TC_PIN_PATTERN", 6, new c[] {
                c._ERR_PATTERN_TCPINNUM, c._ERR_MIN_LENGTH_TCPINNUM, c._ERR_MAX_LENGTH_TCPINNUM
            });
            ERR_CARD_TYPE_REQUIRED = new a("ERR_CARD_TYPE_REQUIRED", 7, new c[] {
                c._ERR_REQUIRED_CARDTYPE
            });
            ERR_CARD_TYPE_INVALID = new a("ERR_CARD_TYPE_INVALID", 8, new c[] {
                c._ERR_INVALID_CARDTYPE
            });
            ERR_CARD_NUMBER_REQUIRED = new a("ERR_CARD_NUMBER_REQUIRED", 9, new c[] {
                c._ERR_REQUIRED_CARDNUMBER
            });
            ERR_CARD_NUMBER_INVALID = new a("ERR_CARD_NUMBER_INVALID", 10, new c[] {
                c._ERR_INVALID_CARDNUMBER
            });
            ERR_CARD_INFORMATION_INVALID = new a("ERR_CARD_INFORMATION_INVALID", 11, new c[] {
                c._ERR_INVALID_CARD_INFORMATION
            });
            ERR_CARD_NAME_REQUIRED = new a("ERR_CARD_NAME_REQUIRED", 12, new c[] {
                c._ERR_REQUIRED_CARDNAME
            });
            ERR_CARD_NAME_PATTERN = new a("ERR_CARD_NAME_PATTERN", 13, new c[] {
                c._ERR_MAX_LENGTH_CARDNAME, c._ERR_PATTERN_CARDNAME
            });
            ERR_CARD_EXPIRY_MONTH_REQUIRED = new a("ERR_CARD_EXPIRY_MONTH_REQUIRED", 14, new c[] {
                c._ERR_REQUIRED_EXPIRYMONTH
            });
            ERR_CARD_EXPIRY_YEAR_REQUIRED = new a("ERR_CARD_EXPIRY_YEAR_REQUIRED", 15, new c[] {
                c._ERR_REQUIRED_EXPIRYYEAR
            });
            ERR_ADDRESS_ID_PATTERN = new a("ERR_ADDRESS_ID_PATTERN", 16, new c[] {
                c._ERR_PATTERN_ADDRESSID
            });
            ERR_ADDRESS_ID_INVALID = new a("ERR_ADDRESS_ID_INVALID", 17, new c[0]);
            ERR_FIRST_NAME_REQUIRED = new a("ERR_FIRST_NAME_REQUIRED", 18, new c[] {
                c._ERR_REQUIRED_FIRSTNAME
            });
            ERR_FIRST_NAME_PATTERN = new a("ERR_FIRST_NAME_PATTERN", 19, new c[] {
                c._ERR_MAX_LENGTH_FIRSTNAME, c._ERR_PATTERN_FIRSTNAME
            });
            ERR_LAST_NAME_REQUIRED = new a("ERR_LAST_NAME_REQUIRED", 20, new c[] {
                c._ERR_REQUIRED_LASTNAME
            });
            ERR_LAST_NAME_PATTERN = new a("ERR_LAST_NAME_PATTERN", 21, new c[] {
                c._ERR_MAX_LENGTH_LASTNAME, c._ERR_PATTERN_LASTNAME
            });
            ERR_ADDRESS_LINE1_REQUIRED = new a("ERR_ADDRESS_LINE1_REQUIRED", 22, new c[] {
                c._ERR_REQUIRED_ADDRESS1
            });
            ERR_ADDRESS_LINE1_PATTERN = new a("ERR_ADDRESS_LINE1_PATTERN", 23, new c[] {
                c._ERR_MAX_LENGTH_ADDRESS1, c._ERR_PATTERN_ADDRESS1
            });
            ERR_ADDRESS2_LINE2_PATTERN = new a("ERR_ADDRESS2_LINE2_PATTERN", 24, new c[] {
                c._ERR_MAX_LENGTH_ADDRESS2, c._ERR_PATTERN_ADDRESS2
            });
            ERR_CITY_REQUIRED = new a("ERR_CITY_REQUIRED", 25, new c[] {
                c._ERR_REQUIRED_CITY
            });
            ERR_CITY_PATTERN = new a("ERR_CITY_PATTERN", 26, new c[] {
                c._ERR_MAX_LENGTH_CITY, c._ERR_PATTERN_CITY
            });
            ERR_COUNTRY_REQUIRED = new a("ERR_COUNTRY_REQUIRED", 27, new c[] {
                c._ERR_REQUIRED_COUNTRY
            });
            ERR_STATE_REQUIRED = new a("ERR_STATE_REQUIRED", 28, new c[] {
                c._ERR_REQUIRED_STATE
            });
            ERR_STATE_MAX_LENGTH = new a("ERR_STATE_MAX_LENGTH", 29, new c[] {
                c._ERR_MAX_LENGTH_STATE
            });
            ERR_ZIP_CODE_REQUIRED = new a("ERR_ZIP_CODE_REQUIRED", 30, new c[] {
                c._ERR_REQUIRED_ZIPCODE
            });
            ERR_ZIP_CODE_PATTERN = new a("ERR_ZIP_CODE_PATTERN", 31, new c[] {
                c._ERR_MAX_LENGTH_ZIPCODE, c._ERR_PATTERN_ZIPCODE
            });
            ERR_PHONE_REQUIRED = new a("ERR_PHONE_REQUIRED", 32, new c[] {
                c._ERR_REQUIRED_PHONE
            });
            ERR_PHONE_PATTERN = new a("ERR_PHONE_PATTERN", 33, new c[] {
                c._ERR_PATTERN_PHONE
            });
            ERR_CART_EMPTY = new a("ERR_CART_EMPTY", 34, new c[] {
                c._ERR_NO_PENDING_ORDERS, c._ERR_MISSING_ORDERITEMS
            });
            ERR_TOKEN_EXPIRED = new a("ERR_TOKEN_EXPIRED", 35, new c[] {
                c.INVALID_ACCESS_TOKEN, c.EXPIRED_ACCESS_TOKEN
            });
            ERR_REAUTH_REQUIRED = new a("ERR_REAUTH_REQUIRED", 36, new c[] {
                c.SCOPE_1_ACCESS_LEVEL_REQUIRED
            });
            ERR_ACCOUNT_IN_USE = new a("ERR_ACCOUNT_IN_USE", 37, new c[] {
                c._ERR_INVALID_COOKIE
            });
            ERR_TIMEOUT = new a("ERR_TIMEOUT", 38, new c[] {
                c.ERR_TIMEOUT
            });
            ERR_TOO_MANY_REQUESTS = new a("ERR_TOO_MANY_REQUESTS", 39, new c[] {
                c.TAPI_VPA
            });
            ERR_CART_UNKNOWN = new a("ERR_CART_UNKNOWN", 40, new c[] {
                c._ERR_UNKNOWN
            });
            $VALUES = (new a[] {
                ERR_MEMBER_CARD_INFO_ID_REQUIRED, ERR_MEMBER_CARD_INFO_ID_PATTERN, ERR_MEMBER_CARD_INFO_ID_INVALID, ERR_CVV_REQUIRED, ERR_CVV_PATTERN, ERR_TC_PIN_REQUIRED, ERR_TC_PIN_PATTERN, ERR_CARD_TYPE_REQUIRED, ERR_CARD_TYPE_INVALID, ERR_CARD_NUMBER_REQUIRED, 
                ERR_CARD_NUMBER_INVALID, ERR_CARD_INFORMATION_INVALID, ERR_CARD_NAME_REQUIRED, ERR_CARD_NAME_PATTERN, ERR_CARD_EXPIRY_MONTH_REQUIRED, ERR_CARD_EXPIRY_YEAR_REQUIRED, ERR_ADDRESS_ID_PATTERN, ERR_ADDRESS_ID_INVALID, ERR_FIRST_NAME_REQUIRED, ERR_FIRST_NAME_PATTERN, 
                ERR_LAST_NAME_REQUIRED, ERR_LAST_NAME_PATTERN, ERR_ADDRESS_LINE1_REQUIRED, ERR_ADDRESS_LINE1_PATTERN, ERR_ADDRESS2_LINE2_PATTERN, ERR_CITY_REQUIRED, ERR_CITY_PATTERN, ERR_COUNTRY_REQUIRED, ERR_STATE_REQUIRED, ERR_STATE_MAX_LENGTH, 
                ERR_ZIP_CODE_REQUIRED, ERR_ZIP_CODE_PATTERN, ERR_PHONE_REQUIRED, ERR_PHONE_PATTERN, ERR_CART_EMPTY, ERR_TOKEN_EXPIRED, ERR_REAUTH_REQUIRED, ERR_ACCOUNT_IN_USE, ERR_TIMEOUT, ERR_TOO_MANY_REQUESTS, 
                ERR_CART_UNKNOWN
            });
        }

        private transient a(String s, int i, c ac[])
        {
            super(s, i);
            mErrorCodes = ac;
        }
    }


    public d()
    {
    }

    public a[] a()
    {
        return a.values();
    }

    public j[] c()
    {
        return a();
    }
}

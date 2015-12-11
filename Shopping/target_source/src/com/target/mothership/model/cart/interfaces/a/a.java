// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.interfaces.a;

import com.target.mothership.model.common.a.b;
import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.j;

public class com.target.mothership.model.cart.interfaces.a.a extends b
{
    public static final class a extends Enum
        implements j
    {

        private static final a $VALUES[];
        public static final a ERR_ACCOUNT_IN_USE;
        public static final a ERR_CART_ADDRESS1_MAX_LENGTH;
        public static final a ERR_CART_ADDRESS1_PATTERN_INVALID;
        public static final a ERR_CART_ADDRESS1_REQUIRED;
        public static final a ERR_CART_ADDRESS2_MAX_LENGTH;
        public static final a ERR_CART_ADDRESS2_PATTERN_INVALID;
        public static final a ERR_CART_ADDRESSID_INVALID;
        public static final a ERR_CART_ADDRESS_IDENTIFIER_INVALID;
        public static final a ERR_CART_ADDRESS_PARAMETERS_REQUIRED;
        public static final a ERR_CART_CITY_MAX_LENGTH;
        public static final a ERR_CART_CITY_PATTERN_INVALID;
        public static final a ERR_CART_CITY_REQUIRED;
        public static final a ERR_CART_FIRST_NAME_MAX_LENGTH;
        public static final a ERR_CART_FIRST_NAME_PATTERN_INVALID;
        public static final a ERR_CART_FIRST_NAME_REQUIRED;
        public static final a ERR_CART_FROMNAME_MAX_LENGTH;
        public static final a ERR_CART_GIFTCARDFROMNAME_REQUIRED;
        public static final a ERR_CART_GIFTCARDTOEMAIL_REQUIRED;
        public static final a ERR_CART_GIFTCARDTONAME_REQUIRED;
        public static final a ERR_CART_LAST_NAME_MAX_LENGTH;
        public static final a ERR_CART_LAST_NAME_PATTERN_INVALID;
        public static final a ERR_CART_LAST_NAME_REQUIRED;
        public static final a ERR_CART_MIDDLE_NAME_MAX_LENGTH;
        public static final a ERR_CART_MIDDLE_NAME_PATTERN_INVALID;
        public static final a ERR_CART_MOBILEGIFTCARDTOPHONE_REQUIRED;
        public static final a ERR_CART_PHONETYPE_PATTERN_INVALID;
        public static final a ERR_CART_PHONE_PATTERN_INVALID;
        public static final a ERR_CART_PHONE_REQUIRED;
        public static final a ERR_CART_SHIPMODEID_INVALID;
        public static final a ERR_CART_SHIPPING_RESTRICTED;
        public static final a ERR_CART_STATE_MAX_LENGTH;
        public static final a ERR_CART_STATE_REQUIRED;
        public static final a ERR_CART_TONAME_MAX_LENGTH;
        public static final a ERR_CART_UNKNOWN;
        public static final a ERR_CART_ZIPCODE_MAX_LENGTH;
        public static final a ERR_CART_ZIPCODE_PATTERN_INVALID;
        public static final a ERR_CART_ZIPCODE_REQUIRED;
        public static final a ERR_REAUTH_REQUIRED;
        public static final a ERR_TOKEN_EXPIRED;
        public static final a ERR_TOO_MANY_REQUESTS;
        private c mCodes[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/mothership/model/cart/interfaces/a/a$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        public c[] a()
        {
            return mCodes;
        }

        static 
        {
            ERR_CART_FIRST_NAME_REQUIRED = new a("ERR_CART_FIRST_NAME_REQUIRED", 0, new c[] {
                c._ERR_REQUIRED_FIRSTNAME
            });
            ERR_CART_FIRST_NAME_PATTERN_INVALID = new a("ERR_CART_FIRST_NAME_PATTERN_INVALID", 1, new c[] {
                c._ERR_PATTERN_FIRSTNAME
            });
            ERR_CART_FIRST_NAME_MAX_LENGTH = new a("ERR_CART_FIRST_NAME_MAX_LENGTH", 2, new c[] {
                c._ERR_MAX_LENGTH_FIRSTNAME
            });
            ERR_CART_MIDDLE_NAME_PATTERN_INVALID = new a("ERR_CART_MIDDLE_NAME_PATTERN_INVALID", 3, new c[] {
                c._ERR_PATTERN_MIDDLENAME
            });
            ERR_CART_MIDDLE_NAME_MAX_LENGTH = new a("ERR_CART_MIDDLE_NAME_MAX_LENGTH", 4, new c[] {
                c._ERR_MAX_LENGTH_MIDDLENAME
            });
            ERR_CART_LAST_NAME_REQUIRED = new a("ERR_CART_LAST_NAME_REQUIRED", 5, new c[] {
                c._ERR_REQUIRED_LASTNAME
            });
            ERR_CART_LAST_NAME_PATTERN_INVALID = new a("ERR_CART_LAST_NAME_PATTERN_INVALID", 6, new c[] {
                c._ERR_PATTERN_LASTNAME
            });
            ERR_CART_LAST_NAME_MAX_LENGTH = new a("ERR_CART_LAST_NAME_MAX_LENGTH", 7, new c[] {
                c._ERR_MAX_LENGTH_LASTNAME
            });
            ERR_CART_ADDRESS1_REQUIRED = new a("ERR_CART_ADDRESS1_REQUIRED", 8, new c[] {
                c._ERR_REQUIRED_ADDRESS1
            });
            ERR_CART_ADDRESS1_MAX_LENGTH = new a("ERR_CART_ADDRESS1_MAX_LENGTH", 9, new c[] {
                c._ERR_MAX_LENGTH_ADDRESS1
            });
            ERR_CART_ADDRESS1_PATTERN_INVALID = new a("ERR_CART_ADDRESS1_PATTERN_INVALID", 10, new c[] {
                c._ERR_PATTERN_ADDRESS1
            });
            ERR_CART_ADDRESS2_MAX_LENGTH = new a("ERR_CART_ADDRESS2_MAX_LENGTH", 11, new c[] {
                c._ERR_MAX_LENGTH_ADDRESS2
            });
            ERR_CART_ADDRESS2_PATTERN_INVALID = new a("ERR_CART_ADDRESS2_PATTERN_INVALID", 12, new c[] {
                c._ERR_PATTERN_ADDRESS2
            });
            ERR_CART_CITY_REQUIRED = new a("ERR_CART_CITY_REQUIRED", 13, new c[] {
                c._ERR_REQUIRED_CITY
            });
            ERR_CART_CITY_PATTERN_INVALID = new a("ERR_CART_CITY_PATTERN_INVALID", 14, new c[] {
                c._ERR_PATTERN_CITY
            });
            ERR_CART_ZIPCODE_REQUIRED = new a("ERR_CART_ZIPCODE_REQUIRED", 15, new c[] {
                c._ERR_REQUIRED_ZIPCODE
            });
            ERR_CART_ZIPCODE_PATTERN_INVALID = new a("ERR_CART_ZIPCODE_PATTERN_INVALID", 16, new c[] {
                c._ERR_PATTERN_ZIPCODE
            });
            ERR_CART_PHONE_REQUIRED = new a("ERR_CART_PHONE_REQUIRED", 17, new c[] {
                c._ERR_REQUIRED_PHONE
            });
            ERR_CART_PHONE_PATTERN_INVALID = new a("ERR_CART_PHONE_PATTERN_INVALID", 18, new c[] {
                c._ERR_PATTERN_PHONE
            });
            ERR_CART_STATE_MAX_LENGTH = new a("ERR_CART_STATE_MAX_LENGTH", 19, new c[] {
                c._ERR_MAX_LENGTH_STATE
            });
            ERR_CART_ZIPCODE_MAX_LENGTH = new a("ERR_CART_ZIPCODE_MAX_LENGTH", 20, new c[] {
                c._ERR_MAX_LENGTH_ZIPCODE
            });
            ERR_CART_PHONETYPE_PATTERN_INVALID = new a("ERR_CART_PHONETYPE_PATTERN_INVALID", 21, new c[] {
                c._ERR_PATTERN_PHONETYPE
            });
            ERR_CART_ADDRESSID_INVALID = new a("ERR_CART_ADDRESSID_INVALID", 22, new c[] {
                c._ERR_INVALID_ADDRESSID
            });
            ERR_CART_SHIPMODEID_INVALID = new a("ERR_CART_SHIPMODEID_INVALID", 23, new c[] {
                c._ERR_INVALID_SHIPMODEID
            });
            ERR_CART_GIFTCARDFROMNAME_REQUIRED = new a("ERR_CART_GIFTCARDFROMNAME_REQUIRED", 24, new c[] {
                c._ERR_REQUIRED_GIFTCARDFROMNAME
            });
            ERR_CART_GIFTCARDTONAME_REQUIRED = new a("ERR_CART_GIFTCARDTONAME_REQUIRED", 25, new c[] {
                c._ERR_REQUIRED_GIFTCARDTONAME
            });
            ERR_CART_GIFTCARDTOEMAIL_REQUIRED = new a("ERR_CART_GIFTCARDTOEMAIL_REQUIRED", 26, new c[] {
                c._ERR_REQUIRED_GIFTCARDTOEMAIL
            });
            ERR_CART_MOBILEGIFTCARDTOPHONE_REQUIRED = new a("ERR_CART_MOBILEGIFTCARDTOPHONE_REQUIRED", 27, new c[] {
                c._ERR_REQUIRED_MOBILEGIFTCARDTOPHONE
            });
            ERR_CART_FROMNAME_MAX_LENGTH = new a("ERR_CART_FROMNAME_MAX_LENGTH", 28, new c[] {
                c._ERR_MAX_LENGTH_FROMNAME
            });
            ERR_CART_TONAME_MAX_LENGTH = new a("ERR_CART_TONAME_MAX_LENGTH", 29, new c[] {
                c._ERR_MAX_LENGTH_TONAME
            });
            ERR_CART_SHIPPING_RESTRICTED = new a("ERR_CART_SHIPPING_RESTRICTED", 30, new c[] {
                c._ERR_SHIPPINGUPDATE_RESTRICTED
            });
            ERR_CART_ADDRESS_IDENTIFIER_INVALID = new a("ERR_CART_ADDRESS_IDENTIFIER_INVALID", 31, new c[] {
                c._ERR_INVALID_ADDRESS_IDENTIFIER
            });
            ERR_CART_ADDRESS_PARAMETERS_REQUIRED = new a("ERR_CART_ADDRESS_PARAMETERS_REQUIRED", 32, new c[] {
                c._ERR_ADDRESS_PARAMETERS_REQUIRED
            });
            ERR_CART_CITY_MAX_LENGTH = new a("ERR_CART_CITY_MAX_LENGTH", 33, new c[] {
                c._ERR_MAX_LENGTH_CITY
            });
            ERR_CART_STATE_REQUIRED = new a("ERR_CART_STATE_REQUIRED", 34, new c[] {
                c._ERR_REQUIRED_STATE
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
            ERR_TOO_MANY_REQUESTS = new a("ERR_TOO_MANY_REQUESTS", 38, new c[] {
                c.TAPI_VPA
            });
            ERR_CART_UNKNOWN = new a("ERR_CART_UNKNOWN", 39, new c[] {
                c._ERR_UNKNOWN
            });
            $VALUES = (new a[] {
                ERR_CART_FIRST_NAME_REQUIRED, ERR_CART_FIRST_NAME_PATTERN_INVALID, ERR_CART_FIRST_NAME_MAX_LENGTH, ERR_CART_MIDDLE_NAME_PATTERN_INVALID, ERR_CART_MIDDLE_NAME_MAX_LENGTH, ERR_CART_LAST_NAME_REQUIRED, ERR_CART_LAST_NAME_PATTERN_INVALID, ERR_CART_LAST_NAME_MAX_LENGTH, ERR_CART_ADDRESS1_REQUIRED, ERR_CART_ADDRESS1_MAX_LENGTH, 
                ERR_CART_ADDRESS1_PATTERN_INVALID, ERR_CART_ADDRESS2_MAX_LENGTH, ERR_CART_ADDRESS2_PATTERN_INVALID, ERR_CART_CITY_REQUIRED, ERR_CART_CITY_PATTERN_INVALID, ERR_CART_ZIPCODE_REQUIRED, ERR_CART_ZIPCODE_PATTERN_INVALID, ERR_CART_PHONE_REQUIRED, ERR_CART_PHONE_PATTERN_INVALID, ERR_CART_STATE_MAX_LENGTH, 
                ERR_CART_ZIPCODE_MAX_LENGTH, ERR_CART_PHONETYPE_PATTERN_INVALID, ERR_CART_ADDRESSID_INVALID, ERR_CART_SHIPMODEID_INVALID, ERR_CART_GIFTCARDFROMNAME_REQUIRED, ERR_CART_GIFTCARDTONAME_REQUIRED, ERR_CART_GIFTCARDTOEMAIL_REQUIRED, ERR_CART_MOBILEGIFTCARDTOPHONE_REQUIRED, ERR_CART_FROMNAME_MAX_LENGTH, ERR_CART_TONAME_MAX_LENGTH, 
                ERR_CART_SHIPPING_RESTRICTED, ERR_CART_ADDRESS_IDENTIFIER_INVALID, ERR_CART_ADDRESS_PARAMETERS_REQUIRED, ERR_CART_CITY_MAX_LENGTH, ERR_CART_STATE_REQUIRED, ERR_TOKEN_EXPIRED, ERR_REAUTH_REQUIRED, ERR_ACCOUNT_IN_USE, ERR_TOO_MANY_REQUESTS, ERR_CART_UNKNOWN
            });
        }

        private transient a(String s, int i, c ac[])
        {
            super(s, i);
            mCodes = ac;
        }
    }


    public com.target.mothership.model.cart.interfaces.a.a()
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

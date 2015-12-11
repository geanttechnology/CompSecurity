// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.interfaces.a;

import com.target.mothership.model.common.a.b;
import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.j;

public class l extends b
{
    public static final class a extends Enum
        implements j
    {

        private static final a $VALUES[];
        public static final a ERR_ACCOUNT_IN_USE;
        public static final a ERR_ADDRESS_LINE1_MAX_LENGTH;
        public static final a ERR_ADDRESS_LINE1_PATTERN;
        public static final a ERR_ADDRESS_LINE1_REQUIRED;
        public static final a ERR_ADDRESS_LINE2_MAX_LENGTH;
        public static final a ERR_ADDRESS_LINE2_PATTERN;
        public static final a ERR_CITY_MAX_LENGTH;
        public static final a ERR_CITY_PATTERN;
        public static final a ERR_CITY_REQUIRED;
        public static final a ERR_FIRSTNAME_MAX_LENGTH;
        public static final a ERR_FIRSTNAME_PATTERN;
        public static final a ERR_FIRSTNAME_REQUIRED;
        public static final a ERR_INVALID_ADDRESS_ID;
        public static final a ERR_INVALID_ADDRESS_OWNER;
        public static final a ERR_LASTNAME_MAX_LENGTH;
        public static final a ERR_LASTNAME_PATTERN;
        public static final a ERR_LASTNAME_REQUIRED;
        public static final a ERR_MIDDLENAME_MAX_LENGTH;
        public static final a ERR_MIDDLENAME_PATTERN;
        public static final a ERR_PHONE_PATTERN;
        public static final a ERR_PHONE_REQUIRED;
        public static final a ERR_REAUTH_REQUIRED;
        public static final a ERR_STATE_PATTERN;
        public static final a ERR_STATE_REQUIRED;
        public static final a ERR_TOKEN_EXPIRED;
        public static final a ERR_TOO_MANY_REQUESTS;
        public static final a ERR_ZIPCODE_MAX_LENGTH;
        public static final a ERR_ZIPCODE_PATTERN;
        public static final a ERR_ZIPCODE_REQUIRED;
        public static final a UNKNOWN;
        private c mCodes[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/mothership/model/guest/interfaces/a/l$a, s);
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
            ERR_INVALID_ADDRESS_OWNER = new a("ERR_INVALID_ADDRESS_OWNER", 0, new c[] {
                c._ERR_INVALID_ADDRESS_OWNER
            });
            ERR_INVALID_ADDRESS_ID = new a("ERR_INVALID_ADDRESS_ID", 1, new c[] {
                c._ERR_CMD_INVALID_PARAM
            });
            ERR_FIRSTNAME_REQUIRED = new a("ERR_FIRSTNAME_REQUIRED", 2, new c[] {
                c._ERR_REQUIRED_FIRSTNAME
            });
            ERR_FIRSTNAME_MAX_LENGTH = new a("ERR_FIRSTNAME_MAX_LENGTH", 3, new c[] {
                c._ERR_MAX_LENGTH_FIRSTNAME
            });
            ERR_FIRSTNAME_PATTERN = new a("ERR_FIRSTNAME_PATTERN", 4, new c[] {
                c._ERR_PATTERN_FIRSTNAME
            });
            ERR_MIDDLENAME_PATTERN = new a("ERR_MIDDLENAME_PATTERN", 5, new c[] {
                c._ERR_PATTERN_MIDDLENAME
            });
            ERR_MIDDLENAME_MAX_LENGTH = new a("ERR_MIDDLENAME_MAX_LENGTH", 6, new c[] {
                c._ERR_MAX_LENGTH_MIDDLENAME
            });
            ERR_LASTNAME_REQUIRED = new a("ERR_LASTNAME_REQUIRED", 7, new c[] {
                c._ERR_REQUIRED_LASTNAME
            });
            ERR_LASTNAME_PATTERN = new a("ERR_LASTNAME_PATTERN", 8, new c[] {
                c._ERR_PATTERN_LASTNAME
            });
            ERR_LASTNAME_MAX_LENGTH = new a("ERR_LASTNAME_MAX_LENGTH", 9, new c[] {
                c._ERR_MAX_LENGTH_LASTNAME
            });
            ERR_ADDRESS_LINE1_REQUIRED = new a("ERR_ADDRESS_LINE1_REQUIRED", 10, new c[] {
                c._ERR_REQUIRED_ADDRESS1
            });
            ERR_ADDRESS_LINE1_PATTERN = new a("ERR_ADDRESS_LINE1_PATTERN", 11, new c[] {
                c._ERR_PATTERN_ADDRESS1
            });
            ERR_ADDRESS_LINE1_MAX_LENGTH = new a("ERR_ADDRESS_LINE1_MAX_LENGTH", 12, new c[] {
                c._ERR_MAX_LENGTH_ADDRESS1
            });
            ERR_ADDRESS_LINE2_PATTERN = new a("ERR_ADDRESS_LINE2_PATTERN", 13, new c[] {
                c._ERR_PATTERN_ADDRESS2
            });
            ERR_ADDRESS_LINE2_MAX_LENGTH = new a("ERR_ADDRESS_LINE2_MAX_LENGTH", 14, new c[] {
                c._ERR_MAX_LENGTH_ADDRESS2
            });
            ERR_CITY_REQUIRED = new a("ERR_CITY_REQUIRED", 15, new c[] {
                c._ERR_REQUIRED_CITY
            });
            ERR_CITY_PATTERN = new a("ERR_CITY_PATTERN", 16, new c[] {
                c._ERR_PATTERN_CITY
            });
            ERR_CITY_MAX_LENGTH = new a("ERR_CITY_MAX_LENGTH", 17, new c[] {
                c._ERR_MAX_LENGTH_CITY
            });
            ERR_STATE_REQUIRED = new a("ERR_STATE_REQUIRED", 18, new c[] {
                c._ERR_REQUIRED_STATE
            });
            ERR_STATE_PATTERN = new a("ERR_STATE_PATTERN", 19, new c[] {
                c._ERR_MAX_LENGTH_STATE
            });
            ERR_ZIPCODE_REQUIRED = new a("ERR_ZIPCODE_REQUIRED", 20, new c[] {
                c._ERR_REQUIRED_ZIPCODE
            });
            ERR_ZIPCODE_PATTERN = new a("ERR_ZIPCODE_PATTERN", 21, new c[] {
                c._ERR_PATTERN_ZIPCODE
            });
            ERR_ZIPCODE_MAX_LENGTH = new a("ERR_ZIPCODE_MAX_LENGTH", 22, new c[] {
                c._ERR_MAX_LENGTH_ZIPCODE
            });
            ERR_PHONE_REQUIRED = new a("ERR_PHONE_REQUIRED", 23, new c[] {
                c._ERR_REQUIRED_PHONE
            });
            ERR_PHONE_PATTERN = new a("ERR_PHONE_PATTERN", 24, new c[] {
                c._ERR_PATTERN_PHONE
            });
            ERR_TOKEN_EXPIRED = new a("ERR_TOKEN_EXPIRED", 25, new c[] {
                c.INVALID_ACCESS_TOKEN, c.EXPIRED_ACCESS_TOKEN
            });
            ERR_REAUTH_REQUIRED = new a("ERR_REAUTH_REQUIRED", 26, new c[] {
                c.SCOPE_1_ACCESS_LEVEL_REQUIRED
            });
            ERR_ACCOUNT_IN_USE = new a("ERR_ACCOUNT_IN_USE", 27, new c[] {
                c._ERR_INVALID_COOKIE
            });
            ERR_TOO_MANY_REQUESTS = new a("ERR_TOO_MANY_REQUESTS", 28, new c[] {
                c.TAPI_VPA
            });
            UNKNOWN = new a("UNKNOWN", 29, new c[] {
                c._ERR_UNKNOWN
            });
            $VALUES = (new a[] {
                ERR_INVALID_ADDRESS_OWNER, ERR_INVALID_ADDRESS_ID, ERR_FIRSTNAME_REQUIRED, ERR_FIRSTNAME_MAX_LENGTH, ERR_FIRSTNAME_PATTERN, ERR_MIDDLENAME_PATTERN, ERR_MIDDLENAME_MAX_LENGTH, ERR_LASTNAME_REQUIRED, ERR_LASTNAME_PATTERN, ERR_LASTNAME_MAX_LENGTH, 
                ERR_ADDRESS_LINE1_REQUIRED, ERR_ADDRESS_LINE1_PATTERN, ERR_ADDRESS_LINE1_MAX_LENGTH, ERR_ADDRESS_LINE2_PATTERN, ERR_ADDRESS_LINE2_MAX_LENGTH, ERR_CITY_REQUIRED, ERR_CITY_PATTERN, ERR_CITY_MAX_LENGTH, ERR_STATE_REQUIRED, ERR_STATE_PATTERN, 
                ERR_ZIPCODE_REQUIRED, ERR_ZIPCODE_PATTERN, ERR_ZIPCODE_MAX_LENGTH, ERR_PHONE_REQUIRED, ERR_PHONE_PATTERN, ERR_TOKEN_EXPIRED, ERR_REAUTH_REQUIRED, ERR_ACCOUNT_IN_USE, ERR_TOO_MANY_REQUESTS, UNKNOWN
            });
        }

        private transient a(String s, int i, c ac[])
        {
            super(s, i);
            mCodes = ac;
        }
    }


    public l()
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

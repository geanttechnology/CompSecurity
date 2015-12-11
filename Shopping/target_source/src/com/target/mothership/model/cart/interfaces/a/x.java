// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.interfaces.a;

import com.target.mothership.model.common.a.b;
import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.j;

public class x extends b
{
    public static final class a extends Enum
        implements j
    {

        private static final a $VALUES[];
        public static final a ERR_ACCOUNT_IN_USE;
        public static final a ERR_CART_EMPTY;
        public static final a ERR_CART_UNKNOWN;
        public static final a ERR_EMAIL_PATTERN;
        public static final a ERR_EMAIL_REQUIRED;
        public static final a ERR_FIRST_NAME_PATTERN;
        public static final a ERR_FIRST_NAME_REQUIRED;
        public static final a ERR_LAST_NAME_PATTERN;
        public static final a ERR_LAST_NAME_REQUIRED;
        public static final a ERR_MOBILE_PATTERN;
        public static final a ERR_NOMINEE_EMAIL_PATTERN;
        public static final a ERR_NOMINEE_EMAIL_REQUIRED;
        public static final a ERR_NOMINEE_FIRST_NAME_PATTERN;
        public static final a ERR_NOMINEE_FIRST_NAME_REQUIRED;
        public static final a ERR_NOMINEE_LAST_NAME_PATTERN;
        public static final a ERR_NOMINEE_LAST_NAME_REQUIRED;
        public static final a ERR_NO_ADDRESS;
        public static final a ERR_NO_PUIS_ITEM;
        public static final a ERR_REAUTH_REQUIRED;
        public static final a ERR_TOKEN_EXPIRED;
        public static final a ERR_TOO_MANY_REQUESTS;
        private c mErrorCodes[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/mothership/model/cart/interfaces/a/x$a, s);
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
            ERR_FIRST_NAME_REQUIRED = new a("ERR_FIRST_NAME_REQUIRED", 0, new c[] {
                c._ERR_REQUIRED_USERFIRSTNAME
            });
            ERR_FIRST_NAME_PATTERN = new a("ERR_FIRST_NAME_PATTERN", 1, new c[] {
                c._ERR_MAX_LENGTH_USERFIRSTNAME, c._ERR_PATTERN_USERFIRSTNAME
            });
            ERR_NOMINEE_FIRST_NAME_REQUIRED = new a("ERR_NOMINEE_FIRST_NAME_REQUIRED", 2, new c[] {
                c._ERR_REQUIRED_NOMINEEFIRSTNAME
            });
            ERR_NOMINEE_FIRST_NAME_PATTERN = new a("ERR_NOMINEE_FIRST_NAME_PATTERN", 3, new c[] {
                c._ERR_MAX_LENGTH_NOMINEEFIRSTNAME, c._ERR_PATTERN_NOMINEEFIRSTNAME
            });
            ERR_LAST_NAME_REQUIRED = new a("ERR_LAST_NAME_REQUIRED", 4, new c[] {
                c._ERR_REQUIRED_USERLASTNAME
            });
            ERR_LAST_NAME_PATTERN = new a("ERR_LAST_NAME_PATTERN", 5, new c[] {
                c._ERR_MAX_LENGTH_USERLASTNAME, c._ERR_PATTERN_USERLASTNAME
            });
            ERR_NOMINEE_LAST_NAME_REQUIRED = new a("ERR_NOMINEE_LAST_NAME_REQUIRED", 6, new c[] {
                c._ERR_REQUIRED_NOMINEELASTNAME
            });
            ERR_NOMINEE_LAST_NAME_PATTERN = new a("ERR_NOMINEE_LAST_NAME_PATTERN", 7, new c[] {
                c._ERR_MAX_LENGTH_NOMINEELASTNAME, c._ERR_PATTERN_NOMINEELASTNAME
            });
            ERR_EMAIL_REQUIRED = new a("ERR_EMAIL_REQUIRED", 8, new c[] {
                c._ERR_REQUIRED_EMAILID, c._ERR_REQUIRED_EMAIL
            });
            ERR_EMAIL_PATTERN = new a("ERR_EMAIL_PATTERN", 9, new c[] {
                c._ERR_PATTERN_EMAILID
            });
            ERR_NOMINEE_EMAIL_REQUIRED = new a("ERR_NOMINEE_EMAIL_REQUIRED", 10, new c[] {
                c._ERR_REQUIRED_NOMINEEEMAIL
            });
            ERR_NOMINEE_EMAIL_PATTERN = new a("ERR_NOMINEE_EMAIL_PATTERN", 11, new c[] {
                c._ERR_PATTERN_NOMINEEEMAIL
            });
            ERR_MOBILE_PATTERN = new a("ERR_MOBILE_PATTERN", 12, new c[] {
                c._ERR_PATTERN_MOBILE
            });
            ERR_NO_PUIS_ITEM = new a("ERR_NO_PUIS_ITEM", 13, new c[] {
                c._ERR_EMPTY_PICKUPSTOREITEM
            });
            ERR_NO_ADDRESS = new a("ERR_NO_ADDRESS", 14, new c[] {
                c.ADDRESS_NULL
            });
            ERR_TOKEN_EXPIRED = new a("ERR_TOKEN_EXPIRED", 15, new c[] {
                c.INVALID_ACCESS_TOKEN, c.EXPIRED_ACCESS_TOKEN
            });
            ERR_REAUTH_REQUIRED = new a("ERR_REAUTH_REQUIRED", 16, new c[] {
                c.SCOPE_1_ACCESS_LEVEL_REQUIRED
            });
            ERR_ACCOUNT_IN_USE = new a("ERR_ACCOUNT_IN_USE", 17, new c[] {
                c._ERR_INVALID_COOKIE
            });
            ERR_CART_EMPTY = new a("ERR_CART_EMPTY", 18, new c[] {
                c._ERR_NO_PENDING_ORDERS, c._ERR_MISSING_ORDERITEMS
            });
            ERR_TOO_MANY_REQUESTS = new a("ERR_TOO_MANY_REQUESTS", 19, new c[] {
                c.TAPI_VPA
            });
            ERR_CART_UNKNOWN = new a("ERR_CART_UNKNOWN", 20, new c[] {
                c._ERR_UNKNOWN
            });
            $VALUES = (new a[] {
                ERR_FIRST_NAME_REQUIRED, ERR_FIRST_NAME_PATTERN, ERR_NOMINEE_FIRST_NAME_REQUIRED, ERR_NOMINEE_FIRST_NAME_PATTERN, ERR_LAST_NAME_REQUIRED, ERR_LAST_NAME_PATTERN, ERR_NOMINEE_LAST_NAME_REQUIRED, ERR_NOMINEE_LAST_NAME_PATTERN, ERR_EMAIL_REQUIRED, ERR_EMAIL_PATTERN, 
                ERR_NOMINEE_EMAIL_REQUIRED, ERR_NOMINEE_EMAIL_PATTERN, ERR_MOBILE_PATTERN, ERR_NO_PUIS_ITEM, ERR_NO_ADDRESS, ERR_TOKEN_EXPIRED, ERR_REAUTH_REQUIRED, ERR_ACCOUNT_IN_USE, ERR_CART_EMPTY, ERR_TOO_MANY_REQUESTS, 
                ERR_CART_UNKNOWN
            });
        }

        private transient a(String s, int i, c ac[])
        {
            super(s, i);
            mErrorCodes = ac;
        }
    }


    public x()
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

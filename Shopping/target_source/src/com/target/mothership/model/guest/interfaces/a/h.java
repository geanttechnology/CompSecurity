// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.interfaces.a;

import com.target.mothership.model.common.a.b;
import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.j;

public class h extends b
{
    public static final class a extends Enum
        implements j
    {

        private static final a $VALUES[];
        public static final a ERR_ACCOUNT_IN_USE;
        public static final a ERR_INVALID_ORDER_NUMBER;
        public static final a ERR_REAUTH_REQUIRED;
        public static final a ERR_REQUIRED_ORDER_NUMBER;
        public static final a ERR_TOKEN_EXPIRED;
        public static final a ERR_TOO_MANY_REQUESTS;
        public static final a UNKNOWN;
        private c mCodes[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/mothership/model/guest/interfaces/a/h$a, s);
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
            ERR_REQUIRED_ORDER_NUMBER = new a("ERR_REQUIRED_ORDER_NUMBER", 0, new c[] {
                c._ERR_REQUIRED_CUSTORDERNUMBER
            });
            ERR_INVALID_ORDER_NUMBER = new a("ERR_INVALID_ORDER_NUMBER", 1, new c[] {
                c._ERR_INVALID_CUSTORDERNUMBER, c._ERR_PATTERN_CUSTORDERNUMBER
            });
            ERR_TOKEN_EXPIRED = new a("ERR_TOKEN_EXPIRED", 2, new c[] {
                c.INVALID_ACCESS_TOKEN, c.EXPIRED_ACCESS_TOKEN
            });
            ERR_REAUTH_REQUIRED = new a("ERR_REAUTH_REQUIRED", 3, new c[] {
                c.SCOPE_1_ACCESS_LEVEL_REQUIRED
            });
            ERR_ACCOUNT_IN_USE = new a("ERR_ACCOUNT_IN_USE", 4, new c[] {
                c._ERR_INVALID_COOKIE
            });
            ERR_TOO_MANY_REQUESTS = new a("ERR_TOO_MANY_REQUESTS", 5, new c[] {
                c.TAPI_VPA
            });
            UNKNOWN = new a("UNKNOWN", 6, new c[] {
                c._ERR_UNKNOWN
            });
            $VALUES = (new a[] {
                ERR_REQUIRED_ORDER_NUMBER, ERR_INVALID_ORDER_NUMBER, ERR_TOKEN_EXPIRED, ERR_REAUTH_REQUIRED, ERR_ACCOUNT_IN_USE, ERR_TOO_MANY_REQUESTS, UNKNOWN
            });
        }

        private transient a(String s, int i, c ac[])
        {
            super(s, i);
            mCodes = ac;
        }
    }


    public h()
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

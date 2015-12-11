// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.interfaces.a;

import com.target.mothership.model.common.a.b;
import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.j;

public class i extends b
{
    public static final class a extends Enum
        implements j
    {

        private static final a $VALUES[];
        public static final a ERR_ACCOUNT_IN_USE;
        public static final a ERR_NO_ORDER_HISTORY_DATA;
        public static final a ERR_REAUTH_REQUIRED;
        public static final a ERR_TOKEN_EXPIRED;
        public static final a ERR_TOO_MANY_REQUESTS;
        public static final a ERR_UNREGISTERED_USER;
        public static final a UNKNOWN;
        private c mCodes[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/mothership/model/guest/interfaces/a/i$a, s);
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
            ERR_UNREGISTERED_USER = new a("ERR_UNREGISTERED_USER", 0, new c[] {
                c._ERR_UNREGISTERED_USER
            });
            ERR_NO_ORDER_HISTORY_DATA = new a("ERR_NO_ORDER_HISTORY_DATA", 1, new c[] {
                c.ERR_NO_ORDER_LIST_DATA
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
                ERR_UNREGISTERED_USER, ERR_NO_ORDER_HISTORY_DATA, ERR_TOKEN_EXPIRED, ERR_REAUTH_REQUIRED, ERR_ACCOUNT_IN_USE, ERR_TOO_MANY_REQUESTS, UNKNOWN
            });
        }

        private transient a(String s, int k, c ac[])
        {
            super(s, k);
            mCodes = ac;
        }
    }


    public i()
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

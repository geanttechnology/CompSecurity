// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.interfaces.a;

import com.target.mothership.model.common.a.b;
import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.j;

public class f extends b
{
    public static final class a extends Enum
        implements j
    {

        private static final a $VALUES[];
        public static final a ERR_ACCOUNT_IN_USE;
        public static final a ERR_INVALID_ADDRESS_ID;
        public static final a ERR_INVALID_ADDRESS_OWNER;
        public static final a ERR_INVALID_ADDRESS_TYPE;
        public static final a ERR_REAUTH_REQUIRED;
        public static final a ERR_TOKEN_EXPIRED;
        public static final a ERR_TOO_MANY_REQUESTS;
        public static final a UNKNOWN;
        private c mCodes[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/mothership/model/guest/interfaces/a/f$a, s);
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
            ERR_INVALID_ADDRESS_ID = new a("ERR_INVALID_ADDRESS_ID", 0, new c[] {
                c._ERR_CMD_INVALID_PARAM, c._ERR_lCMD_INVALID_PARAM
            });
            ERR_INVALID_ADDRESS_OWNER = new a("ERR_INVALID_ADDRESS_OWNER", 1, new c[] {
                c._ERR_INVALID_ADDRESS_OWNER
            });
            ERR_INVALID_ADDRESS_TYPE = new a("ERR_INVALID_ADDRESS_TYPE", 2, new c[] {
                c._ERR_INVALID_ADDRTYPE
            });
            ERR_TOKEN_EXPIRED = new a("ERR_TOKEN_EXPIRED", 3, new c[] {
                c.INVALID_ACCESS_TOKEN, c.EXPIRED_ACCESS_TOKEN
            });
            ERR_REAUTH_REQUIRED = new a("ERR_REAUTH_REQUIRED", 4, new c[] {
                c.SCOPE_1_ACCESS_LEVEL_REQUIRED
            });
            ERR_ACCOUNT_IN_USE = new a("ERR_ACCOUNT_IN_USE", 5, new c[] {
                c._ERR_INVALID_COOKIE
            });
            ERR_TOO_MANY_REQUESTS = new a("ERR_TOO_MANY_REQUESTS", 6, new c[] {
                c.TAPI_VPA
            });
            UNKNOWN = new a("UNKNOWN", 7, new c[] {
                c._ERR_UNKNOWN
            });
            $VALUES = (new a[] {
                ERR_INVALID_ADDRESS_ID, ERR_INVALID_ADDRESS_OWNER, ERR_INVALID_ADDRESS_TYPE, ERR_TOKEN_EXPIRED, ERR_REAUTH_REQUIRED, ERR_ACCOUNT_IN_USE, ERR_TOO_MANY_REQUESTS, UNKNOWN
            });
        }

        private transient a(String s, int i, c ac[])
        {
            super(s, i);
            mCodes = ac;
        }
    }


    public f()
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

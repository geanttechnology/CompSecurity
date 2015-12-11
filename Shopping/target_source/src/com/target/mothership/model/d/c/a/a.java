// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.d.c.a;

import com.target.mothership.model.common.a.b;
import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.j;

public class com.target.mothership.model.d.c.a.a extends b
{
    public static final class a extends Enum
        implements j
    {

        private static final a $VALUES[];
        public static final a ERR_INVALID_ALARM_CODE;
        public static final a ERR_INVALID_STORE_ID;
        public static final a ERR_TOKEN_EXPIRED;
        public static final a ERR_UNKNOWN;
        private c mErrorCodes[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/mothership/model/d/c/a/a$a, s);
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
            ERR_INVALID_STORE_ID = new a("ERR_INVALID_STORE_ID", 0, new c[] {
                c._ERR_INVALID_STORE_ID
            });
            ERR_INVALID_ALARM_CODE = new a("ERR_INVALID_ALARM_CODE", 1, new c[] {
                c._ERR_INVALID_ALARM_CODE
            });
            ERR_TOKEN_EXPIRED = new a("ERR_TOKEN_EXPIRED", 2, new c[] {
                c.INVALID_ACCESS_TOKEN, c.EXPIRED_ACCESS_TOKEN
            });
            ERR_UNKNOWN = new a("ERR_UNKNOWN", 3, new c[] {
                c._ERR_UNKNOWN
            });
            $VALUES = (new a[] {
                ERR_INVALID_STORE_ID, ERR_INVALID_ALARM_CODE, ERR_TOKEN_EXPIRED, ERR_UNKNOWN
            });
        }

        private transient a(String s, int i, c ac[])
        {
            super(s, i);
            mErrorCodes = ac;
        }
    }


    public com.target.mothership.model.d.c.a.a()
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

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.interfaces.a;

import com.google.a.a.e;
import com.target.mothership.model.common.a.f;
import com.target.mothership.model.common.a.j;

public interface c
    extends f
{
    public static final class a extends Enum
        implements j
    {

        private static final a $VALUES[];
        public static final a ERR_ACCOUNT_IN_USE;
        public static final a ERR_ACCOUNT_LOCKED;
        public static final a ERR_INVALID_ACCOUNT_OR_PASSWORD;
        public static final a ERR_INVALID_EMAIL;
        public static final a ERR_REQUIRED_FIELD_EMAIL;
        public static final a ERR_REQUIRED_FIELD_PASSWORD;
        public static final a ERR_TOKEN_EXPIRED;
        public static final a ERR_TOO_MANY_REQUESTS;
        public static final a ERR_UNKNOWN;
        private com.target.mothership.model.common.a.c mErrorCodes[];

        public static a a(com.target.mothership.model.common.a.c c1)
        {
            a aa[] = values();
            int l = aa.length;
            for (int i = 0; i < l; i++)
            {
                a a1 = aa[i];
                com.target.mothership.model.common.a.c ac[] = a1.a();
                int i1 = ac.length;
                for (int k = 0; k < i1; k++)
                {
                    if (ac[k] == c1)
                    {
                        return a1;
                    }
                }

            }

            return ERR_UNKNOWN;
        }

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/mothership/model/guest/interfaces/a/c$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        public com.target.mothership.model.common.a.c[] a()
        {
            return mErrorCodes;
        }

        static 
        {
            ERR_ACCOUNT_LOCKED = new a("ERR_ACCOUNT_LOCKED", 0, new com.target.mothership.model.common.a.c[] {
                com.target.mothership.model.common.a.c._ERR_LOCKED_ACCOUNT
            });
            ERR_INVALID_ACCOUNT_OR_PASSWORD = new a("ERR_INVALID_ACCOUNT_OR_PASSWORD", 1, new com.target.mothership.model.common.a.c[] {
                com.target.mothership.model.common.a.c._ERR_INVALID_EMAILPASSWORD
            });
            ERR_INVALID_EMAIL = new a("ERR_INVALID_EMAIL", 2, new com.target.mothership.model.common.a.c[] {
                com.target.mothership.model.common.a.c._ERR_PATTERN_LOGON_ID
            });
            ERR_REQUIRED_FIELD_PASSWORD = new a("ERR_REQUIRED_FIELD_PASSWORD", 3, new com.target.mothership.model.common.a.c[] {
                com.target.mothership.model.common.a.c._ERR_REQUIRED_LOGON_PASSWORD
            });
            ERR_REQUIRED_FIELD_EMAIL = new a("ERR_REQUIRED_FIELD_EMAIL", 4, new com.target.mothership.model.common.a.c[] {
                com.target.mothership.model.common.a.c._ERR_REQUIRED_LOGON_ID
            });
            ERR_TOKEN_EXPIRED = new a("ERR_TOKEN_EXPIRED", 5, new com.target.mothership.model.common.a.c[] {
                com.target.mothership.model.common.a.c.INVALID_ACCESS_TOKEN, com.target.mothership.model.common.a.c.EXPIRED_ACCESS_TOKEN
            });
            ERR_ACCOUNT_IN_USE = new a("ERR_ACCOUNT_IN_USE", 6, new com.target.mothership.model.common.a.c[] {
                com.target.mothership.model.common.a.c._ERR_INVALID_COOKIE
            });
            ERR_TOO_MANY_REQUESTS = new a("ERR_TOO_MANY_REQUESTS", 7, new com.target.mothership.model.common.a.c[] {
                com.target.mothership.model.common.a.c.TAPI_VPA
            });
            ERR_UNKNOWN = new a("ERR_UNKNOWN", 8, new com.target.mothership.model.common.a.c[] {
                com.target.mothership.model.common.a.c._ERR_UNKNOWN
            });
            $VALUES = (new a[] {
                ERR_ACCOUNT_LOCKED, ERR_INVALID_ACCOUNT_OR_PASSWORD, ERR_INVALID_EMAIL, ERR_REQUIRED_FIELD_PASSWORD, ERR_REQUIRED_FIELD_EMAIL, ERR_TOKEN_EXPIRED, ERR_ACCOUNT_IN_USE, ERR_TOO_MANY_REQUESTS, ERR_UNKNOWN
            });
        }

        private transient a(String s, int i, com.target.mothership.model.common.a.c ac[])
        {
            super(s, i);
            mErrorCodes = ac;
        }
    }


    public abstract e b();
}

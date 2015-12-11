// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons.interfaces.a;

import com.target.mothership.model.common.a.b;
import com.target.mothership.model.common.a.j;

public class c extends b
{
    public static final class a extends Enum
        implements j
    {

        private static final a $VALUES[];
        public static final a COUPON_ERR_EXECUTION_FAILED;
        public static final a COUPON_ERR_INSTANCE_KEY;
        public static final a COUPON_ERR_INVALID_CREDENTIALS;
        public static final a COUPON_ERR_REQUEST_EXPIRED;
        public static final a COUPON_ERR_UNKNOWN;
        private com.target.mothership.model.common.a.c mErrorCodes[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/mothership/model/coupons/interfaces/a/c$a, s);
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
            COUPON_ERR_EXECUTION_FAILED = new a("COUPON_ERR_EXECUTION_FAILED", 0, new com.target.mothership.model.common.a.c[] {
                com.target.mothership.model.common.a.c._ERR_EXECUTION_FAILED, com.target.mothership.model.common.a.c._ERR_UNEXPECTED_SERVER_ERROR, com.target.mothership.model.common.a.c._ERR_UNSUPPORTED_SERVICE_OR_VERSION_MISMATCH
            });
            COUPON_ERR_INVALID_CREDENTIALS = new a("COUPON_ERR_INVALID_CREDENTIALS", 1, new com.target.mothership.model.common.a.c[] {
                com.target.mothership.model.common.a.c._ERR_BAD_AUTH_CREDENTIALS, com.target.mothership.model.common.a.c._ERR_AUTH_FAILURE
            });
            COUPON_ERR_INSTANCE_KEY = new a("COUPON_ERR_INSTANCE_KEY", 2, new com.target.mothership.model.common.a.c[] {
                com.target.mothership.model.common.a.c._ERR_INSTANCE_KEY_DISABLED, com.target.mothership.model.common.a.c._ERR_UNABLE_TO_LOCATE_INSTANCE_KEY
            });
            COUPON_ERR_REQUEST_EXPIRED = new a("COUPON_ERR_REQUEST_EXPIRED", 3, new com.target.mothership.model.common.a.c[] {
                com.target.mothership.model.common.a.c._ERR_EXPIRED
            });
            COUPON_ERR_UNKNOWN = new a("COUPON_ERR_UNKNOWN", 4, new com.target.mothership.model.common.a.c[] {
                com.target.mothership.model.common.a.c._ERR_UNKNOWN
            });
            $VALUES = (new a[] {
                COUPON_ERR_EXECUTION_FAILED, COUPON_ERR_INVALID_CREDENTIALS, COUPON_ERR_INSTANCE_KEY, COUPON_ERR_REQUEST_EXPIRED, COUPON_ERR_UNKNOWN
            });
        }

        private transient a(String s, int i, com.target.mothership.model.common.a.c ac[])
        {
            super(s, i);
            mErrorCodes = ac;
        }
    }


    public c()
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

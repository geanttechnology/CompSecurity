// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons.interfaces.a;

import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.j;

public class b extends com.target.mothership.model.common.a.b
{
    public static final class a extends Enum
        implements j
    {

        private static final a $VALUES[];
        public static final a COUPON_ERR_EXECUTION_FAILED;
        public static final a COUPON_ERR_INSTANCE_KEY;
        public static final a COUPON_ERR_INVALID_CREDENTIALS;
        public static final a COUPON_ERR_PIN_MISMATCH;
        public static final a COUPON_ERR_REQUEST_EXPIRED;
        public static final a COUPON_ERR_UNKNOWN;
        private c mErrorCodes[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/mothership/model/coupons/interfaces/a/b$a, s);
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
            COUPON_ERR_EXECUTION_FAILED = new a("COUPON_ERR_EXECUTION_FAILED", 0, new c[] {
                c._ERR_EXECUTION_FAILED, c._ERR_UNEXPECTED_SERVER_ERROR, c._ERR_UNSUPPORTED_SERVICE_OR_VERSION_MISMATCH
            });
            COUPON_ERR_INVALID_CREDENTIALS = new a("COUPON_ERR_INVALID_CREDENTIALS", 1, new c[] {
                c._ERR_BAD_AUTH_CREDENTIALS, c._ERR_AUTH_FAILURE
            });
            COUPON_ERR_PIN_MISMATCH = new a("COUPON_ERR_PIN_MISMATCH", 2, new c[] {
                c._ERR_PIN_MISMATCH
            });
            COUPON_ERR_INSTANCE_KEY = new a("COUPON_ERR_INSTANCE_KEY", 3, new c[] {
                c._ERR_INSTANCE_KEY_DISABLED, c._ERR_UNABLE_TO_LOCATE_INSTANCE_KEY
            });
            COUPON_ERR_REQUEST_EXPIRED = new a("COUPON_ERR_REQUEST_EXPIRED", 4, new c[] {
                c._ERR_EXPIRED
            });
            COUPON_ERR_UNKNOWN = new a("COUPON_ERR_UNKNOWN", 5, new c[] {
                c._ERR_UNKNOWN
            });
            $VALUES = (new a[] {
                COUPON_ERR_EXECUTION_FAILED, COUPON_ERR_INVALID_CREDENTIALS, COUPON_ERR_PIN_MISMATCH, COUPON_ERR_INSTANCE_KEY, COUPON_ERR_REQUEST_EXPIRED, COUPON_ERR_UNKNOWN
            });
        }

        private transient a(String s, int i, c ac[])
        {
            super(s, i);
            mErrorCodes = ac;
        }
    }


    public b()
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

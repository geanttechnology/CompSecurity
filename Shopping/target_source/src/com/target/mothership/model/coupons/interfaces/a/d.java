// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons.interfaces.a;

import com.target.mothership.model.common.a.b;
import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.j;

public class d extends b
{
    public static final class a extends Enum
        implements j
    {

        private static final a $VALUES[];
        public static final a COUPON_ERR_DENIED_SMS_DELIVERY;
        public static final a COUPON_ERR_EXECUTION_FAILED;
        public static final a COUPON_ERR_FAILED_SMS_DELIVERY;
        public static final a COUPON_ERR_INSTANCE_KEY;
        public static final a COUPON_ERR_INVALID_PHONE_NUMBER;
        public static final a COUPON_ERR_MOBILE_OPERATOR_UNSUPPORTED;
        public static final a COUPON_ERR_PROVIDER_DETAILS_NOT_FOUND;
        public static final a COUPON_ERR_REQUEST_EXPIRED;
        public static final a COUPON_ERR_UNKNOWN;
        private c mErrorCodes[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/mothership/model/coupons/interfaces/a/d$a, s);
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
            COUPON_ERR_INVALID_PHONE_NUMBER = new a("COUPON_ERR_INVALID_PHONE_NUMBER", 1, new c[] {
                c._ERR_PHONE_NUMBER_ERROR, c._ERR_BAD_AUTH_CREDENTIALS
            });
            COUPON_ERR_MOBILE_OPERATOR_UNSUPPORTED = new a("COUPON_ERR_MOBILE_OPERATOR_UNSUPPORTED", 2, new c[] {
                c._ERR_MOBILE_OPERATOR_UNSUPPORTED
            });
            COUPON_ERR_PROVIDER_DETAILS_NOT_FOUND = new a("COUPON_ERR_PROVIDER_DETAILS_NOT_FOUND", 3, new c[] {
                c._ERR_PROVIDER_DETAILS_NOT_FOUND
            });
            COUPON_ERR_INSTANCE_KEY = new a("COUPON_ERR_INSTANCE_KEY", 4, new c[] {
                c._ERR_INSTANCE_KEY_DISABLED, c._ERR_UNABLE_TO_LOCATE_INSTANCE_KEY
            });
            COUPON_ERR_FAILED_SMS_DELIVERY = new a("COUPON_ERR_FAILED_SMS_DELIVERY", 5, new c[] {
                c._ERR_NO_SMS_DELIVERY_DETAILS, c._ERR_SMS_DELIVERY_FAILED
            });
            COUPON_ERR_DENIED_SMS_DELIVERY = new a("COUPON_ERR_DENIED_SMS_DELIVERY", 6, new c[] {
                c._ERR_DENIED
            });
            COUPON_ERR_REQUEST_EXPIRED = new a("COUPON_ERR_REQUEST_EXPIRED", 7, new c[] {
                c._ERR_EXPIRED
            });
            COUPON_ERR_UNKNOWN = new a("COUPON_ERR_UNKNOWN", 8, new c[] {
                c._ERR_UNKNOWN
            });
            $VALUES = (new a[] {
                COUPON_ERR_EXECUTION_FAILED, COUPON_ERR_INVALID_PHONE_NUMBER, COUPON_ERR_MOBILE_OPERATOR_UNSUPPORTED, COUPON_ERR_PROVIDER_DETAILS_NOT_FOUND, COUPON_ERR_INSTANCE_KEY, COUPON_ERR_FAILED_SMS_DELIVERY, COUPON_ERR_DENIED_SMS_DELIVERY, COUPON_ERR_REQUEST_EXPIRED, COUPON_ERR_UNKNOWN
            });
        }

        private transient a(String s, int i, c ac[])
        {
            super(s, i);
            mErrorCodes = ac;
        }
    }


    public d()
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

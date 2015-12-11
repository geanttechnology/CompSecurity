// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.interfaces.a;

import com.target.mothership.model.common.a.b;
import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.j;

public class e extends b
{
    public static final class a extends Enum
        implements j
    {

        private static final a $VALUES[];
        public static final a ERR_ACCOUNT_IN_USE;
        public static final a ERR_CART_EMPTY;
        public static final a ERR_CART_UNKNOWN;
        public static final a ERR_PROMO_CODE_DUPLICATE;
        public static final a ERR_PROMO_CODE_INVALID;
        public static final a ERR_PROMO_CODE_NOT_ELIGIBLE;
        public static final a ERR_PROMO_CODE_REQUIRED;
        public static final a ERR_REAUTH_REQUIRED;
        public static final a ERR_TIMEOUT;
        public static final a ERR_TOKEN_EXPIRED;
        public static final a ERR_TOO_MANY_REQUESTS;
        private c mCodes[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/mothership/model/cart/interfaces/a/e$a, s);
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
            ERR_PROMO_CODE_REQUIRED = new a("ERR_PROMO_CODE_REQUIRED", 0, new c[] {
                c._ERR_REQUIRED_PROMOCODE
            });
            ERR_PROMO_CODE_INVALID = new a("ERR_PROMO_CODE_INVALID", 1, new c[] {
                c.ERR_PROMOTION_CODE_INVALID
            });
            ERR_PROMO_CODE_NOT_ELIGIBLE = new a("ERR_PROMO_CODE_NOT_ELIGIBLE", 2, new c[] {
                c.ERR_PROMOTION_CODE_NOT_YET_APPLIED
            });
            ERR_PROMO_CODE_DUPLICATE = new a("ERR_PROMO_CODE_DUPLICATE", 3, new c[] {
                c.ERR_PROMOTION_CODE_DUPLICATED
            });
            ERR_CART_EMPTY = new a("ERR_CART_EMPTY", 4, new c[] {
                c._ERR_NO_PENDING_ORDERS, c._ERR_MISSING_ORDERITEMS
            });
            ERR_TOKEN_EXPIRED = new a("ERR_TOKEN_EXPIRED", 5, new c[] {
                c.INVALID_ACCESS_TOKEN, c.EXPIRED_ACCESS_TOKEN
            });
            ERR_REAUTH_REQUIRED = new a("ERR_REAUTH_REQUIRED", 6, new c[] {
                c.SCOPE_1_ACCESS_LEVEL_REQUIRED
            });
            ERR_ACCOUNT_IN_USE = new a("ERR_ACCOUNT_IN_USE", 7, new c[] {
                c._ERR_INVALID_COOKIE
            });
            ERR_TIMEOUT = new a("ERR_TIMEOUT", 8, new c[] {
                c.ERR_TIMEOUT
            });
            ERR_TOO_MANY_REQUESTS = new a("ERR_TOO_MANY_REQUESTS", 9, new c[] {
                c.TAPI_VPA
            });
            ERR_CART_UNKNOWN = new a("ERR_CART_UNKNOWN", 10, new c[] {
                c._ERR_UNKNOWN
            });
            $VALUES = (new a[] {
                ERR_PROMO_CODE_REQUIRED, ERR_PROMO_CODE_INVALID, ERR_PROMO_CODE_NOT_ELIGIBLE, ERR_PROMO_CODE_DUPLICATE, ERR_CART_EMPTY, ERR_TOKEN_EXPIRED, ERR_REAUTH_REQUIRED, ERR_ACCOUNT_IN_USE, ERR_TIMEOUT, ERR_TOO_MANY_REQUESTS, 
                ERR_CART_UNKNOWN
            });
        }

        private transient a(String s, int i, c ac[])
        {
            super(s, i);
            mCodes = ac;
        }
    }


    public e()
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

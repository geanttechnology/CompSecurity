// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.interfaces.a;

import com.target.mothership.model.common.a.b;
import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.j;

public class t extends b
{
    public static final class a extends Enum
        implements j
    {

        private static final a $VALUES[];
        public static final a ERR_ACCOUNT_IN_USE;
        public static final a ERR_CART_EMPTY;
        public static final a ERR_CART_UNKNOWN;
        public static final a ERR_GIFT_CARD_NOT_APPLIED;
        public static final a ERR_INVALID_PIID;
        public static final a ERR_PAYMENT_NOT_APPLIED;
        public static final a ERR_REAUTH_REQUIRED;
        public static final a ERR_TOKEN_EXPIRED;
        public static final a ERR_TOO_MANY_REQUESTS;
        private c mErrorCodes[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/mothership/model/cart/interfaces/a/t$a, s);
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
            ERR_PAYMENT_NOT_APPLIED = new a("ERR_PAYMENT_NOT_APPLIED", 0, new c[] {
                c._ERR_PAYMENT_NOT_APPLIED
            });
            ERR_GIFT_CARD_NOT_APPLIED = new a("ERR_GIFT_CARD_NOT_APPLIED", 1, new c[] {
                c._ERR_NO_GC_APPLIED
            });
            ERR_INVALID_PIID = new a("ERR_INVALID_PIID", 2, new c[] {
                c._ERR_INVALID_PIID
            });
            ERR_CART_EMPTY = new a("ERR_CART_EMPTY", 3, new c[] {
                c._ERR_NO_PENDING_ORDERS, c._ERR_MISSING_ORDERITEMS
            });
            ERR_TOKEN_EXPIRED = new a("ERR_TOKEN_EXPIRED", 4, new c[] {
                c.INVALID_ACCESS_TOKEN, c.EXPIRED_ACCESS_TOKEN
            });
            ERR_REAUTH_REQUIRED = new a("ERR_REAUTH_REQUIRED", 5, new c[] {
                c.SCOPE_1_ACCESS_LEVEL_REQUIRED
            });
            ERR_ACCOUNT_IN_USE = new a("ERR_ACCOUNT_IN_USE", 6, new c[] {
                c._ERR_INVALID_COOKIE
            });
            ERR_TOO_MANY_REQUESTS = new a("ERR_TOO_MANY_REQUESTS", 7, new c[] {
                c.TAPI_VPA
            });
            ERR_CART_UNKNOWN = new a("ERR_CART_UNKNOWN", 8, new c[] {
                c._ERR_UNKNOWN
            });
            $VALUES = (new a[] {
                ERR_PAYMENT_NOT_APPLIED, ERR_GIFT_CARD_NOT_APPLIED, ERR_INVALID_PIID, ERR_CART_EMPTY, ERR_TOKEN_EXPIRED, ERR_REAUTH_REQUIRED, ERR_ACCOUNT_IN_USE, ERR_TOO_MANY_REQUESTS, ERR_CART_UNKNOWN
            });
        }

        private transient a(String s, int i, c ac[])
        {
            super(s, i);
            mErrorCodes = ac;
        }
    }


    public t()
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

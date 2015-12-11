// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.interfaces.a;

import com.target.mothership.model.common.a.b;
import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.j;

public class r extends b
{
    public static final class a extends Enum
        implements j
    {

        private static final a $VALUES[];
        public static final a CHECKOUT_ADDRESS_NULL;
        public static final a ERR_ACCOUNT_IN_USE;
        public static final a ERR_CART_UNKNOWN;
        public static final a ERR_REAUTH_REQUIRED;
        public static final a ERR_TOKEN_EXPIRED;
        public static final a ERR_TOO_MANY_REQUESTS;
        public static final a PAYPAL_SCENARIO;
        public static final a _ERR_GENERIC_PAYPAL;
        public static final a _ERR_MISSING_ORDERITEMS;
        public static final a _ERR_NO_PENDING_ORDERS;
        public static final a _ERR_VALIDATE_PAYPAL;
        private c mErrorCodes[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/mothership/model/cart/interfaces/a/r$a, s);
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
            CHECKOUT_ADDRESS_NULL = new a("CHECKOUT_ADDRESS_NULL", 0, new c[] {
                c.CHECKOUT_ADDRESS_NULL
            });
            PAYPAL_SCENARIO = new a("PAYPAL_SCENARIO", 1, new c[] {
                c.PAYPAL_SCENARIO
            });
            _ERR_GENERIC_PAYPAL = new a("_ERR_GENERIC_PAYPAL", 2, new c[] {
                c._ERR_GENERIC_PAYPAL
            });
            _ERR_VALIDATE_PAYPAL = new a("_ERR_VALIDATE_PAYPAL", 3, new c[] {
                c._ERR_VALIDATE_PAYPAL
            });
            _ERR_MISSING_ORDERITEMS = new a("_ERR_MISSING_ORDERITEMS", 4, new c[] {
                c._ERR_MISSING_ORDERITEMS
            });
            _ERR_NO_PENDING_ORDERS = new a("_ERR_NO_PENDING_ORDERS", 5, new c[] {
                c._ERR_NO_PENDING_ORDERS
            });
            ERR_TOKEN_EXPIRED = new a("ERR_TOKEN_EXPIRED", 6, new c[] {
                c.INVALID_ACCESS_TOKEN, c.EXPIRED_ACCESS_TOKEN
            });
            ERR_REAUTH_REQUIRED = new a("ERR_REAUTH_REQUIRED", 7, new c[] {
                c.SCOPE_1_ACCESS_LEVEL_REQUIRED
            });
            ERR_ACCOUNT_IN_USE = new a("ERR_ACCOUNT_IN_USE", 8, new c[] {
                c._ERR_INVALID_COOKIE
            });
            ERR_TOO_MANY_REQUESTS = new a("ERR_TOO_MANY_REQUESTS", 9, new c[] {
                c.TAPI_VPA
            });
            ERR_CART_UNKNOWN = new a("ERR_CART_UNKNOWN", 10, new c[] {
                c._ERR_UNKNOWN
            });
            $VALUES = (new a[] {
                CHECKOUT_ADDRESS_NULL, PAYPAL_SCENARIO, _ERR_GENERIC_PAYPAL, _ERR_VALIDATE_PAYPAL, _ERR_MISSING_ORDERITEMS, _ERR_NO_PENDING_ORDERS, ERR_TOKEN_EXPIRED, ERR_REAUTH_REQUIRED, ERR_ACCOUNT_IN_USE, ERR_TOO_MANY_REQUESTS, 
                ERR_CART_UNKNOWN
            });
        }

        private transient a(String s, int i, c ac[])
        {
            super(s, i);
            mErrorCodes = ac;
        }
    }


    public r()
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

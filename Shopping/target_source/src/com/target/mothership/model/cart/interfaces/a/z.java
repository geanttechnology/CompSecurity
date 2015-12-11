// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.interfaces.a;

import com.target.mothership.model.common.a.b;
import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.j;

public class z extends b
{
    public static final class a extends Enum
        implements j
    {

        private static final a $VALUES[];
        public static final a ERR_ACCOUNT_IN_USE;
        public static final a ERR_CART_EMPTY;
        public static final a ERR_CART_UNKNOWN;
        public static final a ERR_ORDER_ITEM_ID_INVALID;
        public static final a ERR_ORDER_ITEM_ID_PATTERN;
        public static final a ERR_ORDER_ITEM_ID_REQUIRED;
        public static final a ERR_TOKEN_EXPIRED;
        public static final a ERR_TOO_MANY_REQUESTS;
        private c mErrorCodes[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/mothership/model/cart/interfaces/a/z$a, s);
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
            ERR_ORDER_ITEM_ID_REQUIRED = new a("ERR_ORDER_ITEM_ID_REQUIRED", 0, new c[] {
                c._ERR_REQUIRED_ORDERITEMID
            });
            ERR_ORDER_ITEM_ID_INVALID = new a("ERR_ORDER_ITEM_ID_INVALID", 1, new c[] {
                c._ERR_BAD_PARMS
            });
            ERR_ORDER_ITEM_ID_PATTERN = new a("ERR_ORDER_ITEM_ID_PATTERN", 2, new c[] {
                c._ERR_PATTERN_ORDERITEMID
            });
            ERR_CART_EMPTY = new a("ERR_CART_EMPTY", 3, new c[] {
                c._ERR_NO_PENDING_ORDERS, c._ERR_MISSING_ORDERITEMS
            });
            ERR_TOKEN_EXPIRED = new a("ERR_TOKEN_EXPIRED", 4, new c[] {
                c.INVALID_ACCESS_TOKEN, c.EXPIRED_ACCESS_TOKEN
            });
            ERR_ACCOUNT_IN_USE = new a("ERR_ACCOUNT_IN_USE", 5, new c[] {
                c._ERR_INVALID_COOKIE
            });
            ERR_TOO_MANY_REQUESTS = new a("ERR_TOO_MANY_REQUESTS", 6, new c[] {
                c.TAPI_VPA
            });
            ERR_CART_UNKNOWN = new a("ERR_CART_UNKNOWN", 7, new c[] {
                c._ERR_UNKNOWN
            });
            $VALUES = (new a[] {
                ERR_ORDER_ITEM_ID_REQUIRED, ERR_ORDER_ITEM_ID_INVALID, ERR_ORDER_ITEM_ID_PATTERN, ERR_CART_EMPTY, ERR_TOKEN_EXPIRED, ERR_ACCOUNT_IN_USE, ERR_TOO_MANY_REQUESTS, ERR_CART_UNKNOWN
            });
        }

        private transient a(String s, int i, c ac[])
        {
            super(s, i);
            mErrorCodes = ac;
        }
    }


    public z()
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

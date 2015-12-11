// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.interfaces.a;

import com.target.mothership.model.common.a.b;
import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.j;

public class w extends b
{
    public static final class a extends Enum
        implements j
    {

        private static final a $VALUES[];
        public static final a ERR_ACCOUNT_IN_USE;
        public static final a ERR_CART_UNKNOWN;
        public static final a ERR_FULFILLMENT_ITEM_ONLINE_ONLY;
        public static final a ERR_FULFILLMENT_LIMITED_ITEM_IN_STORE;
        public static final a ERR_FULFILLMENT_ORDER_ITEM_ID_INVALID;
        public static final a ERR_FULFILLMENT_ORDER_ITEM_ID_MISSING;
        public static final a ERR_FULFILLMENT_ORDER_ITEM_ID_PATTERN_INVALID;
        public static final a ERR_FULFILLMENT_PICKUP_STORE_ID_INVALID;
        public static final a ERR_FULFILLMENT_PICKUP_STORE_ID_PATTERN_INVALID;
        public static final a ERR_FULFILLMENT_PICKUP_STORE_ID_REQUIRED;
        public static final a ERR_FULFILLMENT_SHOP_INVENTORY_NOT_SUFFICIENT;
        public static final a ERR_REAUTH_REQUIRED;
        public static final a ERR_TOKEN_EXPIRED;
        public static final a ERR_TOO_MANY_REQUESTS;
        private c mErrorCodes[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/mothership/model/cart/interfaces/a/w$a, s);
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
            ERR_FULFILLMENT_ORDER_ITEM_ID_MISSING = new a("ERR_FULFILLMENT_ORDER_ITEM_ID_MISSING", 0, new c[] {
                c._ERR_REQUIRED_ORDERITEMID
            });
            ERR_FULFILLMENT_ORDER_ITEM_ID_INVALID = new a("ERR_FULFILLMENT_ORDER_ITEM_ID_INVALID", 1, new c[] {
                c._ERR_BAD_PARMS
            });
            ERR_FULFILLMENT_ORDER_ITEM_ID_PATTERN_INVALID = new a("ERR_FULFILLMENT_ORDER_ITEM_ID_PATTERN_INVALID", 2, new c[] {
                c._ERR_PATTERN_ORDERITEMID
            });
            ERR_FULFILLMENT_PICKUP_STORE_ID_REQUIRED = new a("ERR_FULFILLMENT_PICKUP_STORE_ID_REQUIRED", 3, new c[] {
                c._ERR_REQUIRED_PICKUPSTOREID
            });
            ERR_FULFILLMENT_PICKUP_STORE_ID_PATTERN_INVALID = new a("ERR_FULFILLMENT_PICKUP_STORE_ID_PATTERN_INVALID", 4, new c[] {
                c._ERR_PATTERN_PICKUPSTOREID
            });
            ERR_FULFILLMENT_PICKUP_STORE_ID_INVALID = new a("ERR_FULFILLMENT_PICKUP_STORE_ID_INVALID", 5, new c[] {
                c._ERR_INVALID_PICKUPSTOREID
            });
            ERR_FULFILLMENT_ITEM_ONLINE_ONLY = new a("ERR_FULFILLMENT_ITEM_ONLINE_ONLY", 6, new c[] {
                c._ERR_ITEM_ONLINE_ONLY
            });
            ERR_FULFILLMENT_LIMITED_ITEM_IN_STORE = new a("ERR_FULFILLMENT_LIMITED_ITEM_IN_STORE", 7, new c[] {
                c.SHOP_INVENTORY_FIRST_ITEM_FOR_STORE
            });
            ERR_FULFILLMENT_SHOP_INVENTORY_NOT_SUFFICIENT = new a("ERR_FULFILLMENT_SHOP_INVENTORY_NOT_SUFFICIENT", 8, new c[] {
                c.SHOP_INVENTORY_EQUAL_FOR_STORE
            });
            ERR_TOKEN_EXPIRED = new a("ERR_TOKEN_EXPIRED", 9, new c[] {
                c.INVALID_ACCESS_TOKEN, c.EXPIRED_ACCESS_TOKEN
            });
            ERR_REAUTH_REQUIRED = new a("ERR_REAUTH_REQUIRED", 10, new c[] {
                c.SCOPE_1_ACCESS_LEVEL_REQUIRED
            });
            ERR_ACCOUNT_IN_USE = new a("ERR_ACCOUNT_IN_USE", 11, new c[] {
                c._ERR_INVALID_COOKIE
            });
            ERR_TOO_MANY_REQUESTS = new a("ERR_TOO_MANY_REQUESTS", 12, new c[] {
                c.TAPI_VPA
            });
            ERR_CART_UNKNOWN = new a("ERR_CART_UNKNOWN", 13, new c[] {
                c._ERR_UNKNOWN
            });
            $VALUES = (new a[] {
                ERR_FULFILLMENT_ORDER_ITEM_ID_MISSING, ERR_FULFILLMENT_ORDER_ITEM_ID_INVALID, ERR_FULFILLMENT_ORDER_ITEM_ID_PATTERN_INVALID, ERR_FULFILLMENT_PICKUP_STORE_ID_REQUIRED, ERR_FULFILLMENT_PICKUP_STORE_ID_PATTERN_INVALID, ERR_FULFILLMENT_PICKUP_STORE_ID_INVALID, ERR_FULFILLMENT_ITEM_ONLINE_ONLY, ERR_FULFILLMENT_LIMITED_ITEM_IN_STORE, ERR_FULFILLMENT_SHOP_INVENTORY_NOT_SUFFICIENT, ERR_TOKEN_EXPIRED, 
                ERR_REAUTH_REQUIRED, ERR_ACCOUNT_IN_USE, ERR_TOO_MANY_REQUESTS, ERR_CART_UNKNOWN
            });
        }

        private transient a(String s, int i, c ac[])
        {
            super(s, i);
            mErrorCodes = ac;
        }
    }


    public w()
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

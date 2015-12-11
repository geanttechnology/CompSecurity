// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.interfaces.a;

import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.j;

public class b extends com.target.mothership.model.common.a.b
{
    public static final class a extends Enum
        implements j
    {

        private static final a $VALUES[];
        public static final a ERR_ACCOUNT_IN_USE;
        public static final a ERR_CART_AGE_CHECK_FAILURE;
        public static final a ERR_CART_DELIVERYTYPE_MISSING;
        public static final a ERR_CART_INVENTORY_NOT_AVAILABLE;
        public static final a ERR_CART_LIMITED_QUANTITY_ADD_ERROR;
        public static final a ERR_CART_MAX_INVENTORY_REACHED;
        public static final a ERR_CART_MAX_LENGTH_QUANTITY_REACHED;
        public static final a ERR_CART_MAX_LINE_ITEMS;
        public static final a ERR_CART_MAX_LINE_QUANTITY_REACHED;
        public static final a ERR_CART_MAX_STORE_INVENTORY_REACHED;
        public static final a ERR_CART_MOVE_TO_CART_FAILED;
        public static final a ERR_CART_ORDERITEMID_INVALID;
        public static final a ERR_CART_ORDERITEMID_MISSING;
        public static final a ERR_CART_ORDERITEMID_PATTERN_INVALID;
        public static final a ERR_CART_PRODUCTID_MISSING;
        public static final a ERR_CART_PRODUCT_DETAILS_PASSED_WITH_VARIATION;
        public static final a ERR_CART_QUANTITY_MISSING;
        public static final a ERR_CART_QUANTITY_PATTERN_INVALID;
        public static final a ERR_CART_REGISTRYID_MISSING;
        public static final a ERR_CART_REGISTRY_TYPE_MISSING;
        public static final a ERR_CART_SAVEFORLATER_LIST_EMPTY;
        public static final a ERR_CART_STORE_ONLY_ITEM_ADD_ERROR;
        public static final a ERR_CART_UNKNOWN;
        public static final a ERR_REAUTH_REQUIRED;
        public static final a ERR_TOKEN_EXPIRED;
        public static final a ERR_TOO_MANY_REQUESTS;
        private c mCode[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/mothership/model/cart/interfaces/a/b$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        public c[] a()
        {
            return mCode;
        }

        static 
        {
            ERR_CART_PRODUCT_DETAILS_PASSED_WITH_VARIATION = new a("ERR_CART_PRODUCT_DETAILS_PASSED_WITH_VARIATION", 0, new c[] {
                c._ERR_INVALID_PRODUCT_DETAIL
            });
            ERR_CART_ORDERITEMID_INVALID = new a("ERR_CART_ORDERITEMID_INVALID", 1, new c[] {
                c._ERR_INVALID_INPUT
            });
            ERR_CART_ORDERITEMID_MISSING = new a("ERR_CART_ORDERITEMID_MISSING", 2, new c[] {
                c._ERR_REQUIRED_ORDERITEMID
            });
            ERR_CART_ORDERITEMID_PATTERN_INVALID = new a("ERR_CART_ORDERITEMID_PATTERN_INVALID", 3, new c[] {
                c._ERR_PATTERN_ORDERITEMID
            });
            ERR_CART_SAVEFORLATER_LIST_EMPTY = new a("ERR_CART_SAVEFORLATER_LIST_EMPTY", 4, new c[] {
                c._ERR_NO_SAVEFORLATER_LIST_EMPTY
            });
            ERR_CART_MAX_INVENTORY_REACHED = new a("ERR_CART_MAX_INVENTORY_REACHED", 5, new c[] {
                c.SHOP_INVENTORY_EQUAL, c.SHOP_MAX_PURCHASE_LIMIT_EQUAL
            });
            ERR_CART_MAX_STORE_INVENTORY_REACHED = new a("ERR_CART_MAX_STORE_INVENTORY_REACHED", 6, new c[] {
                c.SHOP_INVENTORY_EQUAL_FOR_STORE
            });
            ERR_CART_MAX_LENGTH_QUANTITY_REACHED = new a("ERR_CART_MAX_LENGTH_QUANTITY_REACHED", 7, new c[] {
                c._ERR_MAX_LENGTH_QUANTITY
            });
            ERR_CART_MAX_LINE_QUANTITY_REACHED = new a("ERR_CART_MAX_LINE_QUANTITY_REACHED", 8, new c[] {
                c.ERR_MAX_LINE_QUANTITY
            });
            ERR_CART_MAX_LINE_ITEMS = new a("ERR_CART_MAX_LINE_ITEMS", 9, new c[] {
                c.SHOP_ERR_LINE_ITEMS
            });
            ERR_CART_INVENTORY_NOT_AVAILABLE = new a("ERR_CART_INVENTORY_NOT_AVAILABLE", 10, new c[] {
                c.ERR_INV_UNAVAILABLE
            });
            ERR_CART_MOVE_TO_CART_FAILED = new a("ERR_CART_MOVE_TO_CART_FAILED", 11, new c[] {
                c._ERR_MOVE_TO_CART
            });
            ERR_CART_PRODUCTID_MISSING = new a("ERR_CART_PRODUCTID_MISSING", 12, new c[] {
                c._ERR_REQUIRED_PRODUCTID
            });
            ERR_CART_QUANTITY_MISSING = new a("ERR_CART_QUANTITY_MISSING", 13, new c[] {
                c._ERR_REQUIRED_QUANTITY
            });
            ERR_CART_QUANTITY_PATTERN_INVALID = new a("ERR_CART_QUANTITY_PATTERN_INVALID", 14, new c[] {
                c._ERR_PATTERN_QUANTITY
            });
            ERR_CART_REGISTRY_TYPE_MISSING = new a("ERR_CART_REGISTRY_TYPE_MISSING", 15, new c[] {
                c._ERR_REQUIRED_REGISTRY_TYPE
            });
            ERR_CART_DELIVERYTYPE_MISSING = new a("ERR_CART_DELIVERYTYPE_MISSING", 16, new c[] {
                c._ERR_REQUIRED_DELIVERYTYPE
            });
            ERR_CART_REGISTRYID_MISSING = new a("ERR_CART_REGISTRYID_MISSING", 17, new c[] {
                c.ERR_REQUIRED_REGISTRYID
            });
            ERR_CART_AGE_CHECK_FAILURE = new a("ERR_CART_AGE_CHECK_FAILURE", 18, new c[] {
                c.ESRBRATING_FAILURE, c.ESRBRATING_MATURE_TEXT
            });
            ERR_CART_STORE_ONLY_ITEM_ADD_ERROR = new a("ERR_CART_STORE_ONLY_ITEM_ADD_ERROR", 19, new c[] {
                c.ERR_ADD_TO_CART_NOT_PERMITTED_FOR_STORE_ONLY_ITEM_FROMESTORE
            });
            ERR_CART_LIMITED_QUANTITY_ADD_ERROR = new a("ERR_CART_LIMITED_QUANTITY_ADD_ERROR", 20, new c[] {
                c.SHOP_MAX_PURCHASE_LIMIT_SECOND_ITEM
            });
            ERR_TOKEN_EXPIRED = new a("ERR_TOKEN_EXPIRED", 21, new c[] {
                c.INVALID_ACCESS_TOKEN, c.EXPIRED_ACCESS_TOKEN
            });
            ERR_REAUTH_REQUIRED = new a("ERR_REAUTH_REQUIRED", 22, new c[] {
                c.SCOPE_1_ACCESS_LEVEL_REQUIRED
            });
            ERR_ACCOUNT_IN_USE = new a("ERR_ACCOUNT_IN_USE", 23, new c[] {
                c._ERR_INVALID_COOKIE
            });
            ERR_TOO_MANY_REQUESTS = new a("ERR_TOO_MANY_REQUESTS", 24, new c[] {
                c.TAPI_CART_VPA, c.TAPI_VPA
            });
            ERR_CART_UNKNOWN = new a("ERR_CART_UNKNOWN", 25, new c[] {
                c._ERR_UNKNOWN
            });
            $VALUES = (new a[] {
                ERR_CART_PRODUCT_DETAILS_PASSED_WITH_VARIATION, ERR_CART_ORDERITEMID_INVALID, ERR_CART_ORDERITEMID_MISSING, ERR_CART_ORDERITEMID_PATTERN_INVALID, ERR_CART_SAVEFORLATER_LIST_EMPTY, ERR_CART_MAX_INVENTORY_REACHED, ERR_CART_MAX_STORE_INVENTORY_REACHED, ERR_CART_MAX_LENGTH_QUANTITY_REACHED, ERR_CART_MAX_LINE_QUANTITY_REACHED, ERR_CART_MAX_LINE_ITEMS, 
                ERR_CART_INVENTORY_NOT_AVAILABLE, ERR_CART_MOVE_TO_CART_FAILED, ERR_CART_PRODUCTID_MISSING, ERR_CART_QUANTITY_MISSING, ERR_CART_QUANTITY_PATTERN_INVALID, ERR_CART_REGISTRY_TYPE_MISSING, ERR_CART_DELIVERYTYPE_MISSING, ERR_CART_REGISTRYID_MISSING, ERR_CART_AGE_CHECK_FAILURE, ERR_CART_STORE_ONLY_ITEM_ADD_ERROR, 
                ERR_CART_LIMITED_QUANTITY_ADD_ERROR, ERR_TOKEN_EXPIRED, ERR_REAUTH_REQUIRED, ERR_ACCOUNT_IN_USE, ERR_TOO_MANY_REQUESTS, ERR_CART_UNKNOWN
            });
        }

        private transient a(String s, int i, c ac[])
        {
            super(s, i);
            mCode = ac;
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

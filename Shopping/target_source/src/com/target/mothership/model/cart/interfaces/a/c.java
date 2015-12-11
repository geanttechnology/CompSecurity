// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.interfaces.a;

import com.target.mothership.model.common.a.b;
import com.target.mothership.model.common.a.j;

public class c extends b
{
    public static final class a extends Enum
        implements j
    {

        private static final a $VALUES[];
        public static final a ERR_ACCOUNT_IN_USE;
        public static final a ERR_CART_EMPTY;
        public static final a ERR_CART_UNKNOWN;
        public static final a ERR_GIFT_CARD_ACCESS_NUMBER_PATTERN;
        public static final a ERR_GIFT_CARD_ACCESS_NUMBER_REQUIRED;
        public static final a ERR_GIFT_CARD_ALREADY_USED;
        public static final a ERR_GIFT_CARD_DETAILS_INVALID;
        public static final a ERR_GIFT_CARD_MAX_LIMIT;
        public static final a ERR_GIFT_CARD_NUMBER_PATTERN;
        public static final a ERR_GIFT_CARD_NUMBER_REQUIRED;
        public static final a ERR_REAUTH_REQUIRED;
        public static final a ERR_TIMEOUT;
        public static final a ERR_TOKEN_EXPIRED;
        public static final a ERR_TOO_MANY_REQUESTS;
        public static final a PAYPAL_SCENARIO;
        private com.target.mothership.model.common.a.c mCodes[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/mothership/model/cart/interfaces/a/c$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        public com.target.mothership.model.common.a.c[] a()
        {
            return mCodes;
        }

        static 
        {
            ERR_GIFT_CARD_NUMBER_REQUIRED = new a("ERR_GIFT_CARD_NUMBER_REQUIRED", 0, new com.target.mothership.model.common.a.c[] {
                com.target.mothership.model.common.a.c._ERR_REQUIRED_GIFTCARDNUMBER
            });
            ERR_GIFT_CARD_NUMBER_PATTERN = new a("ERR_GIFT_CARD_NUMBER_PATTERN", 1, new com.target.mothership.model.common.a.c[] {
                com.target.mothership.model.common.a.c._ERR_PATTERN_GIFTCARDNUMBER, com.target.mothership.model.common.a.c._ERR_MAX_LENGTH_GIFTCARDNUMBER, com.target.mothership.model.common.a.c._ERR_MIN_LENGTH_GIFTCARDNUMBER
            });
            ERR_GIFT_CARD_ACCESS_NUMBER_REQUIRED = new a("ERR_GIFT_CARD_ACCESS_NUMBER_REQUIRED", 2, new com.target.mothership.model.common.a.c[] {
                com.target.mothership.model.common.a.c._ERR_REQUIRED_ACCESSNUMBER
            });
            ERR_GIFT_CARD_ACCESS_NUMBER_PATTERN = new a("ERR_GIFT_CARD_ACCESS_NUMBER_PATTERN", 3, new com.target.mothership.model.common.a.c[] {
                com.target.mothership.model.common.a.c._ERR_PATTERN_ACCESSNUMBER, com.target.mothership.model.common.a.c._ERR_LENGTH_ACCESSNUMBER
            });
            ERR_GIFT_CARD_DETAILS_INVALID = new a("ERR_GIFT_CARD_DETAILS_INVALID", 4, new com.target.mothership.model.common.a.c[] {
                com.target.mothership.model.common.a.c._ERR_INVALID_GIFTCARD_DETAILS_1
            });
            ERR_GIFT_CARD_MAX_LIMIT = new a("ERR_GIFT_CARD_MAX_LIMIT", 5, new com.target.mothership.model.common.a.c[] {
                com.target.mothership.model.common.a.c.MAX_GIFTCARD_LIMIT
            });
            ERR_GIFT_CARD_ALREADY_USED = new a("ERR_GIFT_CARD_ALREADY_USED", 6, new com.target.mothership.model.common.a.c[] {
                com.target.mothership.model.common.a.c.ALREADY_USED_GIFT_CARD
            });
            ERR_CART_EMPTY = new a("ERR_CART_EMPTY", 7, new com.target.mothership.model.common.a.c[] {
                com.target.mothership.model.common.a.c._ERR_MISSING_ORDERITEMS, com.target.mothership.model.common.a.c._ERR_NO_PENDING_ORDERS
            });
            PAYPAL_SCENARIO = new a("PAYPAL_SCENARIO", 8, new com.target.mothership.model.common.a.c[] {
                com.target.mothership.model.common.a.c.PAYPAL_SCENARIO
            });
            ERR_TOKEN_EXPIRED = new a("ERR_TOKEN_EXPIRED", 9, new com.target.mothership.model.common.a.c[] {
                com.target.mothership.model.common.a.c.INVALID_ACCESS_TOKEN, com.target.mothership.model.common.a.c.EXPIRED_ACCESS_TOKEN
            });
            ERR_REAUTH_REQUIRED = new a("ERR_REAUTH_REQUIRED", 10, new com.target.mothership.model.common.a.c[] {
                com.target.mothership.model.common.a.c.SCOPE_1_ACCESS_LEVEL_REQUIRED
            });
            ERR_ACCOUNT_IN_USE = new a("ERR_ACCOUNT_IN_USE", 11, new com.target.mothership.model.common.a.c[] {
                com.target.mothership.model.common.a.c._ERR_INVALID_COOKIE
            });
            ERR_TOO_MANY_REQUESTS = new a("ERR_TOO_MANY_REQUESTS", 12, new com.target.mothership.model.common.a.c[] {
                com.target.mothership.model.common.a.c.TAPI_VPA
            });
            ERR_TIMEOUT = new a("ERR_TIMEOUT", 13, new com.target.mothership.model.common.a.c[] {
                com.target.mothership.model.common.a.c.ERR_TIMEOUT
            });
            ERR_CART_UNKNOWN = new a("ERR_CART_UNKNOWN", 14, new com.target.mothership.model.common.a.c[] {
                com.target.mothership.model.common.a.c._ERROR_DAS_UNAVAILABLE, com.target.mothership.model.common.a.c._ERR_CONNECTION_FAILED, com.target.mothership.model.common.a.c._ERR_UNKNOWN
            });
            $VALUES = (new a[] {
                ERR_GIFT_CARD_NUMBER_REQUIRED, ERR_GIFT_CARD_NUMBER_PATTERN, ERR_GIFT_CARD_ACCESS_NUMBER_REQUIRED, ERR_GIFT_CARD_ACCESS_NUMBER_PATTERN, ERR_GIFT_CARD_DETAILS_INVALID, ERR_GIFT_CARD_MAX_LIMIT, ERR_GIFT_CARD_ALREADY_USED, ERR_CART_EMPTY, PAYPAL_SCENARIO, ERR_TOKEN_EXPIRED, 
                ERR_REAUTH_REQUIRED, ERR_ACCOUNT_IN_USE, ERR_TOO_MANY_REQUESTS, ERR_TIMEOUT, ERR_CART_UNKNOWN
            });
        }

        private transient a(String s, int i, com.target.mothership.model.common.a.c ac[])
        {
            super(s, i);
            mCodes = ac;
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

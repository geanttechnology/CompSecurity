// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.interfaces.a;

import com.target.mothership.model.common.a.b;
import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.j;

public class h extends b
{
    public static final class a extends Enum
        implements j
    {

        private static final a $VALUES[];
        public static final a ERR_ACCOUNT_IN_USE;
        public static final a ERR_CART_EMPTY;
        public static final a ERR_CART_UNKNOWN;
        public static final a ERR_CVV_PATTERN;
        public static final a ERR_CVV_REQUIRED;
        public static final a ERR_DECLINE_CVV_INVALID;
        public static final a ERR_DECLINE_MAX_RETRIES;
        public static final a ERR_DECLINE_TARGET_DEBIT_CARD;
        public static final a ERR_DECLINE_TC_PIN_INVALID;
        public static final a ERR_INVALID_PAYMENT;
        public static final a ERR_NO_ADDRESS;
        public static final a ERR_REAUTH_REQUIRED;
        public static final a ERR_TC_PIN_PATTERN;
        public static final a ERR_TC_PIN_REQUIRED;
        public static final a ERR_TOKEN_EXPIRED;
        public static final a ERR_TOO_MANY_REQUESTS;
        public static final a ERR_TRACK_EMAIL_REQUIRED;
        public static final a ERR_VALIDATE_PAYMENT_INSTRUCTION;
        private c mErrorCodes[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/mothership/model/cart/interfaces/a/h$a, s);
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
            ERR_TC_PIN_REQUIRED = new a("ERR_TC_PIN_REQUIRED", 0, new c[] {
                c._ERR_REQUIRED_TCPINNUM, c.ERR_TDC_WITHOUT_PIN
            });
            ERR_DECLINE_TC_PIN_INVALID = new a("ERR_DECLINE_TC_PIN_INVALID", 1, new c[] {
                c.DECLINE_CARD_INVALID_PIN
            });
            ERR_DECLINE_TARGET_DEBIT_CARD = new a("ERR_DECLINE_TARGET_DEBIT_CARD", 2, new c[] {
                c.DECLINE_CARD_TARGET_DEBIT, c.DECLINE_CARD_NEGATIVE
            });
            ERR_TC_PIN_PATTERN = new a("ERR_TC_PIN_PATTERN", 3, new c[] {
                c._ERR_MAX_LENGTH_TCPINNUM, c._ERR_MIN_LENGTH_TCPINNUM, c._ERR_PATTERN_TCPINNUM
            });
            ERR_CVV_REQUIRED = new a("ERR_CVV_REQUIRED", 4, new c[] {
                c._ERR_REQUIRED_CVVNUM
            });
            ERR_CVV_PATTERN = new a("ERR_CVV_PATTERN", 5, new c[] {
                c._ERR_LENGTH_CVVNUM, c._ERR_PATTERN_CVVNUM
            });
            ERR_DECLINE_CVV_INVALID = new a("ERR_DECLINE_CVV_INVALID", 6, new c[] {
                c.DECLINE_CARD
            });
            ERR_DECLINE_MAX_RETRIES = new a("ERR_DECLINE_MAX_RETRIES", 7, new c[] {
                c.DECLINE_EXCEEDED_MAX
            });
            ERR_VALIDATE_PAYMENT_INSTRUCTION = new a("ERR_VALIDATE_PAYMENT_INSTRUCTION", 8, new c[] {
                c._ERR_PAYMENT_VALIDATE_PI
            });
            ERR_INVALID_PAYMENT = new a("ERR_INVALID_PAYMENT", 9, new c[] {
                c.ERR_INVALID_PAYMENT
            });
            ERR_NO_ADDRESS = new a("ERR_NO_ADDRESS", 10, new c[] {
                c.ADDRESS_NULL
            });
            ERR_TRACK_EMAIL_REQUIRED = new a("ERR_TRACK_EMAIL_REQUIRED", 11, new c[] {
                c.NO_TRACKING_EMAIL_ID_ERR
            });
            ERR_CART_EMPTY = new a("ERR_CART_EMPTY", 12, new c[] {
                c._ERR_MISSING_ORDERITEMS, c._ERR_NO_PENDING_ORDERS
            });
            ERR_TOKEN_EXPIRED = new a("ERR_TOKEN_EXPIRED", 13, new c[] {
                c.INVALID_ACCESS_TOKEN, c.EXPIRED_ACCESS_TOKEN
            });
            ERR_REAUTH_REQUIRED = new a("ERR_REAUTH_REQUIRED", 14, new c[] {
                c.SCOPE_1_ACCESS_LEVEL_REQUIRED
            });
            ERR_ACCOUNT_IN_USE = new a("ERR_ACCOUNT_IN_USE", 15, new c[] {
                c._ERR_INVALID_COOKIE
            });
            ERR_TOO_MANY_REQUESTS = new a("ERR_TOO_MANY_REQUESTS", 16, new c[] {
                c.TAPI_VPA
            });
            ERR_CART_UNKNOWN = new a("ERR_CART_UNKNOWN", 17, new c[] {
                c._ERR_UNKNOWN
            });
            $VALUES = (new a[] {
                ERR_TC_PIN_REQUIRED, ERR_DECLINE_TC_PIN_INVALID, ERR_DECLINE_TARGET_DEBIT_CARD, ERR_TC_PIN_PATTERN, ERR_CVV_REQUIRED, ERR_CVV_PATTERN, ERR_DECLINE_CVV_INVALID, ERR_DECLINE_MAX_RETRIES, ERR_VALIDATE_PAYMENT_INSTRUCTION, ERR_INVALID_PAYMENT, 
                ERR_NO_ADDRESS, ERR_TRACK_EMAIL_REQUIRED, ERR_CART_EMPTY, ERR_TOKEN_EXPIRED, ERR_REAUTH_REQUIRED, ERR_ACCOUNT_IN_USE, ERR_TOO_MANY_REQUESTS, ERR_CART_UNKNOWN
            });
        }

        private transient a(String s, int i, c ac[])
        {
            super(s, i);
            mErrorCodes = ac;
        }
    }


    public h()
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

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.interfaces.a;

import com.target.mothership.model.common.a.b;
import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.j;

public class g extends b
{
    public static final class a extends Enum
        implements j
    {

        private static final a $VALUES[];
        public static final a ERR_ACCOUNT_IN_USE;
        public static final a ERR_CART_EMPTY;
        public static final a ERR_CART_UNKNOWN;
        public static final a ERR_REAUTH_REQUIRED;
        public static final a ERR_TEAM_MEMBER_DISCOUNT_ALREADY_APPLIED;
        public static final a ERR_TEAM_MEMBER_NUMBER_INVALID;
        public static final a ERR_TEAM_MEMBER_NUMBER_PATTERN;
        public static final a ERR_TEAM_MEMBER_NUMBER_REQUIRED;
        public static final a ERR_TOKEN_EXPIRED;
        public static final a ERR_TOO_MANY_REQUESTS;
        private c mErrorCodes[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/mothership/model/cart/interfaces/a/g$a, s);
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
            ERR_TEAM_MEMBER_NUMBER_REQUIRED = new a("ERR_TEAM_MEMBER_NUMBER_REQUIRED", 0, new c[] {
                c._ERR_REQUIRED_EMPLOYEENUMBER
            });
            ERR_TEAM_MEMBER_NUMBER_INVALID = new a("ERR_TEAM_MEMBER_NUMBER_INVALID", 1, new c[] {
                c.ERR_TMD_CODE_INVALID
            });
            ERR_TEAM_MEMBER_NUMBER_PATTERN = new a("ERR_TEAM_MEMBER_NUMBER_PATTERN", 2, new c[] {
                c._ERR_MAX_LENGTH_EMPLOYEENUMBER, c._ERR_PATTERN_EMPLOYEENUMBER, c._ERR_PATTERN_CVV
            });
            ERR_TEAM_MEMBER_DISCOUNT_ALREADY_APPLIED = new a("ERR_TEAM_MEMBER_DISCOUNT_ALREADY_APPLIED", 3, new c[] {
                c._ERR_DISCOUNT_ALREADY_APPLIED
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
            ERR_TOO_MANY_REQUESTS = new a("ERR_TOO_MANY_REQUESTS", 8, new c[] {
                c.TAPI_VPA
            });
            ERR_CART_UNKNOWN = new a("ERR_CART_UNKNOWN", 9, new c[] {
                c._ERR_UNKNOWN
            });
            $VALUES = (new a[] {
                ERR_TEAM_MEMBER_NUMBER_REQUIRED, ERR_TEAM_MEMBER_NUMBER_INVALID, ERR_TEAM_MEMBER_NUMBER_PATTERN, ERR_TEAM_MEMBER_DISCOUNT_ALREADY_APPLIED, ERR_CART_EMPTY, ERR_TOKEN_EXPIRED, ERR_REAUTH_REQUIRED, ERR_ACCOUNT_IN_USE, ERR_TOO_MANY_REQUESTS, ERR_CART_UNKNOWN
            });
        }

        private transient a(String s, int i, c ac[])
        {
            super(s, i);
            mErrorCodes = ac;
        }
    }


    public g()
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

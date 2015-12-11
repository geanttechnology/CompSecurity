// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.interfaces.a;

import com.target.mothership.services.x;

public interface com.target.mothership.model.product.interfaces.a.a
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a ERR_BAD_ARGUMENT;
        public static final a ERR_REQUEST_PARAM_IS_NULL;
        public static final a ERR_REQUIRED_MAX_PRICE;
        public static final a ERR_REQUIRED_MIN_PRICE;
        public static final a ERR_STORE_ID_NOT_SET;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/mothership/model/product/interfaces/a/a$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            ERR_STORE_ID_NOT_SET = new a("ERR_STORE_ID_NOT_SET", 0);
            ERR_BAD_ARGUMENT = new a("ERR_BAD_ARGUMENT", 1);
            ERR_REQUEST_PARAM_IS_NULL = new a("ERR_REQUEST_PARAM_IS_NULL", 2);
            ERR_REQUIRED_MAX_PRICE = new a("ERR_REQUIRED_MAX_PRICE", 3);
            ERR_REQUIRED_MIN_PRICE = new a("ERR_REQUIRED_MIN_PRICE", 4);
            $VALUES = (new a[] {
                ERR_STORE_ID_NOT_SET, ERR_BAD_ARGUMENT, ERR_REQUEST_PARAM_IS_NULL, ERR_REQUIRED_MAX_PRICE, ERR_REQUIRED_MIN_PRICE
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    public abstract x a();
}

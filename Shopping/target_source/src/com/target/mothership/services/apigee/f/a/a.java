// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.f.a;

import com.google.b.l;
import com.google.b.o;
import com.google.b.s;
import com.google.b.t;
import com.target.mothership.services.k;
import java.lang.reflect.Type;

public class com.target.mothership.services.apigee.f.a.a extends k
{
    public static class a
        implements t
    {

        public l a(com.target.mothership.services.apigee.f.a.a a1, Type type, s s)
        {
            type = new o();
            type.a("giftCardNumber", com.target.mothership.services.apigee.f.a.a.a(a1));
            type.a("accessNumber", com.target.mothership.services.apigee.f.a.a.b(a1));
            if (com.target.mothership.services.apigee.f.a.a.c(a1).booleanValue())
            {
                a1 = "Y";
            } else
            {
                a1 = "N";
            }
            type.a("defaultPayment", a1);
            return type;
        }

        public l serialize(Object obj, Type type, s s)
        {
            return a((com.target.mothership.services.apigee.f.a.a)obj, type, s);
        }

        public a()
        {
        }
    }


    private String mAccessNumber;
    private String mGiftCardNumber;
    private Boolean mIsDefaultPayment;

    public com.target.mothership.services.apigee.f.a.a(String s, String s1)
    {
        mGiftCardNumber = s;
        mAccessNumber = s1;
        mIsDefaultPayment = Boolean.valueOf(false);
    }

    static String a(com.target.mothership.services.apigee.f.a.a a1)
    {
        return a1.mGiftCardNumber;
    }

    static String b(com.target.mothership.services.apigee.f.a.a a1)
    {
        return a1.mAccessNumber;
    }

    static Boolean c(com.target.mothership.services.apigee.f.a.a a1)
    {
        return a1.mIsDefaultPayment;
    }
}

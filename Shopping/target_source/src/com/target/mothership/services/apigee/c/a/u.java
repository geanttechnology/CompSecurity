// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.c.a;

import com.google.b.l;
import com.google.b.o;
import com.google.b.s;
import com.google.b.t;
import com.target.mothership.model.common.c;
import java.lang.reflect.Type;
import java.util.List;

public class u
{
    public static class a
        implements t
    {

        public l a(u u1, Type type, s s1)
        {
            type = new o();
            type.a("firstName", u.a(u1));
            type.a("middleName", u.b(u1));
            type.a("lastName", com.target.mothership.services.apigee.c.a.u.c(u1));
            type.a("addressLine", s1.a(u.d(u1)));
            type.a("city", u.e(u1));
            type.a("state", u.f(u1));
            type.a("zipCode", u.g(u1));
            type.a("phoneType", u.h(u1).toString());
            type.a("phone", u.i(u1));
            type.a("identifier", u.j(u1));
            if (u.k(u1))
            {
                u1 = "Y";
            } else
            {
                u1 = "N";
            }
            type.a("skipAddressValidation", u1);
            return type;
        }

        public l serialize(Object obj, Type type, s s1)
        {
            return a((u)obj, type, s1);
        }

        public a()
        {
        }
    }


    private String mCity;
    private String mFirstName;
    private String mIdentifier;
    private String mLastName;
    private String mMiddleInitial;
    private String mPhone;
    private c mPhoneType;
    private boolean mSkipAddressValidation;
    private String mState;
    private List mStreetAddress;
    private String mZipCode;

    public u(String s, String s1, List list, String s2, String s3, String s4, String s5, 
            c c1)
    {
        mFirstName = s;
        mLastName = s1;
        mStreetAddress = list;
        mCity = s2;
        mState = s3;
        mZipCode = s4;
        mPhoneType = c1;
        mPhone = s5;
        mSkipAddressValidation = false;
        mMiddleInitial = null;
        mIdentifier = null;
    }

    static String a(u u1)
    {
        return u1.mFirstName;
    }

    static String b(u u1)
    {
        return u1.mMiddleInitial;
    }

    static String c(u u1)
    {
        return u1.mLastName;
    }

    static List d(u u1)
    {
        return u1.mStreetAddress;
    }

    static String e(u u1)
    {
        return u1.mCity;
    }

    static String f(u u1)
    {
        return u1.mState;
    }

    static String g(u u1)
    {
        return u1.mZipCode;
    }

    static c h(u u1)
    {
        return u1.mPhoneType;
    }

    static String i(u u1)
    {
        return u1.mPhone;
    }

    static String j(u u1)
    {
        return u1.mIdentifier;
    }

    static boolean k(u u1)
    {
        return u1.mSkipAddressValidation;
    }

    public void a(String s)
    {
        mIdentifier = s;
    }

    public void a(boolean flag)
    {
        mSkipAddressValidation = flag;
    }
}

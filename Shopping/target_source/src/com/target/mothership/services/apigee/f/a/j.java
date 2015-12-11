// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.f.a;

import com.google.b.l;
import com.google.b.o;
import com.google.b.s;
import com.google.b.t;
import com.target.mothership.model.common.c;
import com.target.mothership.services.k;
import java.lang.reflect.Type;
import java.util.List;

public class j extends k
{
    public static class a
        implements t
    {

        public l a(j j1, Type type, s s1)
        {
            o o1 = new o();
            o1.a("firstName", j.a(j1));
            o1.a("middleName", j.b(j1));
            o1.a("lastName", com.target.mothership.services.apigee.f.a.j.c(j1));
            o1.a("addressLine", s1.a(j.d(j1)));
            o1.a("city", j.e(j1));
            o1.a("state", j.f(j1));
            o1.a("zipCode", j.g(j1));
            o1.a("addressType", com.target.mothership.model.common.a.Shipping.toString());
            o1.a("phoneType", j.h(j1).toString());
            o1.a("phone", j.i(j1));
            if (j.j(j1))
            {
                type = "Y";
            } else
            {
                type = "N";
            }
            o1.a("saveAsDefault", type);
            if (com.target.mothership.services.apigee.f.a.j.k(j1))
            {
                j1 = "Y";
            } else
            {
                j1 = "N";
            }
            o1.a("skipAddressValidation", j1);
            return o1;
        }

        public l serialize(Object obj, Type type, s s1)
        {
            return a((j)obj, type, s1);
        }

        public a()
        {
        }
    }


    private String mCity;
    private String mFirstName;
    private String mLastName;
    private String mMiddleInitial;
    private String mPhone;
    private c mPhoneType;
    private boolean mSaveAsDefault;
    private boolean mSkipAddressValidation;
    private String mState;
    private List mStreetAddress;
    private String mZipCode;

    public j(String s, String s1, List list, String s2, String s3, String s4, String s5, 
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
        mSaveAsDefault = false;
        mSkipAddressValidation = false;
        mMiddleInitial = null;
    }

    static String a(j j1)
    {
        return j1.mFirstName;
    }

    static String b(j j1)
    {
        return j1.mMiddleInitial;
    }

    static String c(j j1)
    {
        return j1.mLastName;
    }

    static List d(j j1)
    {
        return j1.mStreetAddress;
    }

    static String e(j j1)
    {
        return j1.mCity;
    }

    static String f(j j1)
    {
        return j1.mState;
    }

    static String g(j j1)
    {
        return j1.mZipCode;
    }

    static c h(j j1)
    {
        return j1.mPhoneType;
    }

    static String i(j j1)
    {
        return j1.mPhone;
    }

    static boolean j(j j1)
    {
        return j1.mSaveAsDefault;
    }

    static boolean k(j j1)
    {
        return j1.mSkipAddressValidation;
    }

    public void a(String s)
    {
        mMiddleInitial = s;
    }

    public void a(boolean flag)
    {
        mSaveAsDefault = flag;
    }

    public void b(boolean flag)
    {
        mSkipAddressValidation = flag;
    }
}

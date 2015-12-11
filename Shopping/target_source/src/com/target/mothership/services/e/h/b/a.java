// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.e.h.b;

import com.google.b.f;
import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.p;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class com.target.mothership.services.e.h.b.a
{
    public static class a
        implements k
    {

        public com.target.mothership.services.e.h.b.a a(l l, Type type, j j)
            throws p
        {
            l = (com.target.mothership.services.e.h.b.a)(new f()).a(l, com/target/mothership/services/e/h/b/a);
            if (l.e() == null && l.a() != null && !l.a().isEmpty() && l.b() != null && l.g() != null && l.f() != null)
            {
                com.target.mothership.services.e.h.b.a.a(l, (new StringBuilder()).append((String)l.a().get(0)).append("  ").append(l.b()).append(" ").append(l.g()).append(" ").append(l.f()).toString());
            }
            return l;
        }

        public Object deserialize(l l, Type type, j j)
            throws p
        {
            return a(l, type, j);
        }

        public a()
        {
        }
    }


    private ArrayList mAddressLines;
    private String mCity;
    private String mCountry;
    private String mCounty;
    private String mFormattedAddress;
    private String mPostalCode;
    private String mStateOrProvince;

    public com.target.mothership.services.e.h.b.a()
    {
        mAddressLines = new ArrayList();
    }

    static String a(com.target.mothership.services.e.h.b.a a1, String s)
    {
        a1.mFormattedAddress = s;
        return s;
    }

    public ArrayList a()
    {
        return mAddressLines;
    }

    public String b()
    {
        return mCity;
    }

    public String c()
    {
        return mCountry;
    }

    public String d()
    {
        return mCounty;
    }

    public String e()
    {
        return mFormattedAddress;
    }

    public String f()
    {
        return mPostalCode;
    }

    public String g()
    {
        return mStateOrProvince;
    }
}

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

public class e extends k
{
    public static class a
        implements t
    {

        public l a(e e1, Type type, s s)
        {
            type = new o();
            type.a("firstName", e.a(e1));
            type.a("middleName", e.b(e1));
            type.a("lastName", e.c(e1));
            type.a("logonId", e.d(e1));
            type.a("logonPassword", e.e(e1));
            type.a("logonPasswordVerify", e.f(e1));
            type.a("sendMeEmail", e.g(e1).toString());
            return type;
        }

        public l serialize(Object obj, Type type, s s)
        {
            return a((e)obj, type, s);
        }

        public a()
        {
        }
    }


    private String mAccount;
    private String mFirstName;
    private String mLastName;
    private String mMiddleName;
    private String mPassword;
    private String mPasswordVerify;
    private Boolean mSendEmail;

    public e(String s, String s1, String s2, String s3, String s4, String s5, boolean flag)
    {
        mFirstName = s;
        mMiddleName = s1;
        mLastName = s2;
        mAccount = s3;
        mPassword = s4;
        mPasswordVerify = s5;
        mSendEmail = Boolean.valueOf(flag);
    }

    static String a(e e1)
    {
        return e1.mFirstName;
    }

    static String b(e e1)
    {
        return e1.mMiddleName;
    }

    static String c(e e1)
    {
        return e1.mLastName;
    }

    static String d(e e1)
    {
        return e1.mAccount;
    }

    static String e(e e1)
    {
        return e1.mPassword;
    }

    static String f(e e1)
    {
        return e1.mPasswordVerify;
    }

    static Boolean g(e e1)
    {
        return e1.mSendEmail;
    }
}

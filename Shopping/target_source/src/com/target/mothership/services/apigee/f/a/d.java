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

public class d extends k
{
    public static class a
        implements t
    {

        public l a(d d1, Type type, s s)
        {
            type = new o();
            type.a("newEmail", d.a(d1));
            type.a("confirmEmail", d.b(d1));
            if (d.c(d1))
            {
                d1 = "true";
            } else
            {
                d1 = "false";
            }
            type.a("sendMeEmail", d1);
            return type;
        }

        public l serialize(Object obj, Type type, s s)
        {
            return a((d)obj, type, s);
        }

        public a()
        {
        }
    }


    private String mConfirmEmail;
    private String mNewEmail;
    private boolean mSendMeEmail;

    static String a(d d1)
    {
        return d1.mNewEmail;
    }

    static String b(d d1)
    {
        return d1.mConfirmEmail;
    }

    static boolean c(d d1)
    {
        return d1.mSendMeEmail;
    }
}

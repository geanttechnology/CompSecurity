// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.f.a;

import com.google.b.l;
import com.google.b.o;
import com.google.b.s;
import com.google.b.t;
import java.lang.reflect.Type;

public class k
{
    public static class a
        implements t
    {

        private l b(k k1, Type type, s s)
        {
            k1 = new o();
            k1.a("userAction", "SetAsDefault");
            return k1;
        }

        private l c(k k1, Type type, s s)
        {
            k1 = new o();
            k1.a("defaultPayment", "N");
            k1.a("userAction", "Edit");
            k1.a("skipAddressValidation", "Y");
            return k1;
        }

        public l a(k k1, Type type, s s)
        {
            if (k.a(k1))
            {
                return b(k1, type, s);
            } else
            {
                return c(k1, type, s);
            }
        }

        public l serialize(Object obj, Type type, s s)
        {
            return a((k)obj, type, s);
        }

        public a()
        {
        }
    }


    private boolean mSetToDefault;

    static boolean a(k k1)
    {
        return k1.mSetToDefault;
    }
}

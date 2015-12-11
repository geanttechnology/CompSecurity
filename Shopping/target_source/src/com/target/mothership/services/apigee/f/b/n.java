// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.f.b;

import com.google.b.i;
import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.o;
import com.google.b.p;
import java.lang.reflect.Type;

public class n
{
    public static class a
        implements k
    {

        public n a(l l1, Type type, j j)
            throws p
        {
            type = new n();
            l1 = l1.m();
            if (l1.a("CheckoutProfile"))
            {
                l1 = l1.b("CheckoutProfile").n();
                if (l1.a() > 0)
                {
                    l1 = l1.a(0).m();
                    if (l1.a("protocolData"))
                    {
                        l1 = l1.b("protocolData").n();
                        if (l1.a() > 0)
                        {
                            l1 = l1.a(0).m();
                            if (l1.a("name") && l1.b("name").c().equalsIgnoreCase("memberCardInfoId"))
                            {
                                n.a(type, l1.b("value").c());
                            }
                        }
                    }
                }
            }
            return type;
        }

        public Object deserialize(l l1, Type type, j j)
            throws p
        {
            return a(l1, type, j);
        }

        public a()
        {
        }
    }


    private String mCardInfoId;

    public n()
    {
    }

    static String a(n n1, String s)
    {
        n1.mCardInfoId = s;
        return s;
    }

    public String a()
    {
        return mCardInfoId;
    }
}

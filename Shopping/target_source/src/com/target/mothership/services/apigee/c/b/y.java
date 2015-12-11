// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.c.b;

import com.google.b.f;
import com.google.b.i;
import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.o;
import com.google.b.p;
import com.target.a.a.b;
import java.lang.reflect.Type;
import java.util.Iterator;

public class y
{
    public static class a
        implements k
    {

        public y a(l l1, Type type, j j)
            throws p
        {
label0:
            {
                type = (y)(new f()).a(l1, type);
                l1 = l1.m();
                if (!l1.a("paymentInstruction"))
                {
                    break label0;
                }
                j = l1.b("paymentInstruction").n().iterator();
                o o1;
label1:
                do
                {
                    if (j.hasNext())
                    {
                        Object obj = ((l)j.next()).m();
                        if (!((o) (obj)).a("protocolData"))
                        {
                            continue;
                        }
                        obj = ((o) (obj)).b("protocolData").n().iterator();
                        do
                        {
                            if (!((Iterator) (obj)).hasNext())
                            {
                                continue label1;
                            }
                            o1 = ((l)((Iterator) (obj)).next()).m();
                        } while (!o1.a("name") || !o1.a("value") || !"token".equals(o1.b("name").c()));
                        break;
                    }
                    break label0;
                } while (true);
                y.a(type, o1.b("value").c());
                return type;
            }
            com.target.a.a.b.a(y.d(), (new StringBuilder()).append(com/target/mothership/services/apigee/c/b/y.getSimpleName()).append(" somehow included no token inside ").append("the protocol data array").toString());
            com.target.a.a.b.a(y.d(), l1.toString());
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


    private static final String TAG = com/target/mothership/services/apigee/c/b/y.getSimpleName();
    private String mCmd;
    private String mRedirectUrl;
    private String mToken;

    public y()
    {
    }

    static String a(y y1, String s)
    {
        y1.mToken = s;
        return s;
    }

    static String d()
    {
        return TAG;
    }

    public String a()
    {
        return mCmd;
    }

    public String b()
    {
        return mRedirectUrl;
    }

    public String c()
    {
        return mToken;
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.f.b;

import android.support.v4.f.a;
import com.google.b.i;
import com.google.b.j;
import com.google.b.k;
import com.google.b.o;
import com.google.b.p;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;

public class l
{
    public static class a
        implements k
    {

        public l a(com.google.b.l l1, Type type, j j)
            throws p
        {
            type = new l();
            l1 = l1.m();
            if (l1.a("protocolData"))
            {
                l1 = l1.b("protocolData").n().iterator();
                do
                {
                    if (!l1.hasNext())
                    {
                        break;
                    }
                    j = ((com.google.b.l)l1.next()).m();
                    if (j.a("name") && j.a("value"))
                    {
                        com.target.mothership.services.apigee.f.b.l.a(type).put(j.b("name").c(), j.b("value").c());
                    }
                } while (true);
            }
            return type;
        }

        public Object deserialize(com.google.b.l l1, Type type, j j)
            throws p
        {
            return a(l1, type, j);
        }

        public a()
        {
        }
    }


    private Map mProtocolDataMap;

    public l()
    {
        mProtocolDataMap = new android.support.v4.f.a();
    }

    static Map a(l l1)
    {
        return l1.mProtocolDataMap;
    }

    public String a()
    {
        return (String)mProtocolDataMap.get("memberCardInfoId");
    }

    public String b()
    {
        return (String)mProtocolDataMap.get("giftCardNumber");
    }

    public String c()
    {
        return (String)mProtocolDataMap.get("giftCardAccessCode");
    }

    public String d()
    {
        return (String)mProtocolDataMap.get("giftCardBalance");
    }

    public String e()
    {
        return (String)mProtocolDataMap.get("cardNickName");
    }

    public String f()
    {
        return (String)mProtocolDataMap.get("barcodeImageUrl");
    }
}

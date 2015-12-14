// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import java.util.ArrayList;

public class i
{

    public static String a(String s)
    {
        if (s.equals("DEMO1"))
        {
            return "http://bc-demo1.cyberlink.com/api/init";
        }
        if (s.equals("DEMO2"))
        {
            return "http://bc-demo2.cyberlink.com/api/init";
        }
        if (s.equals("DEMO3"))
        {
            return "http://bc-demo3.cyberlink.com/api/init";
        }
        if (s.equals("DEMO4"))
        {
            return "http://bc-demo4.cyberlink.com/api/init";
        }
        if (s.equals("DEMO5"))
        {
            return "http://bc-demo5.cyberlink.com/api/init";
        } else
        {
            return "http://bc-api.cyberlink.com/api/init";
        }
    }

    public static String[] a()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("PRODUCTION");
        arraylist.add("DEMO1");
        arraylist.add("DEMO2");
        arraylist.add("DEMO3");
        arraylist.add("DEMO4");
        arraylist.add("DEMO5");
        String as[] = new String[arraylist.size()];
        arraylist.toArray(as);
        return as;
    }
}

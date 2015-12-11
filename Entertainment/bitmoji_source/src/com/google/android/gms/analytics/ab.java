// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class ab
{

    private final Map tW = new HashMap();
    private final Map tX = new HashMap();
    private final boolean tY;
    private final String tZ;

    ab(String s, boolean flag)
    {
        tY = flag;
        tZ = s;
    }

    void c(String s, int i)
    {
        if (!tY)
        {
            return;
        }
        Integer integer1 = (Integer)tW.get(s);
        Integer integer = integer1;
        if (integer1 == null)
        {
            integer = Integer.valueOf(0);
        }
        tW.put(s, Integer.valueOf(integer.intValue() + i));
    }

    String cn()
    {
        if (!tY)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(tZ);
        String s;
        for (Iterator iterator = tW.keySet().iterator(); iterator.hasNext(); stringbuilder.append("&").append(s).append("=").append(tW.get(s)))
        {
            s = (String)iterator.next();
        }

        String s1;
        for (Iterator iterator1 = tX.keySet().iterator(); iterator1.hasNext(); stringbuilder.append("&").append(s1).append("=").append((String)tX.get(s1)))
        {
            s1 = (String)iterator1.next();
        }

        return stringbuilder.toString();
    }
}

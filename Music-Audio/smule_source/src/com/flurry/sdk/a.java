// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.flurry.sdk:
//            au, gd, b

public class a
{

    private static final String a = com/flurry/sdk/a.getSimpleName();
    private final au b;
    private final Map c;
    private final b d;

    public a(au au1, Map map, b b1)
    {
        b = au1;
        c = map;
        d = b1;
    }

    public static au c(String s)
    {
        au aau[] = au.values();
        int j = aau.length;
        for (int i = 0; i < j; i++)
        {
            au au1 = aau[i];
            if (au1.toString().equals(s))
            {
                gd.a(5, a, (new StringBuilder()).append("Action Type for name: ").append(s).append(" is ").append(au1).toString());
                return au1;
            }
        }

        return au.a;
    }

    public au a()
    {
        return b;
    }

    public String a(String s)
    {
        if (c == null || TextUtils.isEmpty(s))
        {
            return null;
        } else
        {
            return (String)c.get(s);
        }
    }

    public String a(String s, String s1)
    {
        if (c == null || TextUtils.isEmpty(s))
        {
            return null;
        } else
        {
            return (String)c.put(s, s1);
        }
    }

    public String b(String s)
    {
        if (c == null || TextUtils.isEmpty(s))
        {
            return null;
        } else
        {
            return (String)c.remove(s);
        }
    }

    public Map b()
    {
        return c;
    }

    public b c()
    {
        return d;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("action=");
        stringbuilder.append(b.toString());
        stringbuilder.append(",params=");
        java.util.Map.Entry entry;
        for (Iterator iterator = c.entrySet().iterator(); iterator.hasNext(); stringbuilder.append((new StringBuilder()).append(",key=").append((String)entry.getKey()).append(",value=").append((String)entry.getValue()).toString()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        stringbuilder.append(",");
        stringbuilder.append(",fTriggeringEvent=");
        stringbuilder.append(d);
        return stringbuilder.toString();
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.config;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package cz.msebera.android.httpclient.config:
//            Lookup

public final class Registry
    implements Lookup
{

    private final Map map;

    Registry(Map map1)
    {
        map = new ConcurrentHashMap(map1);
    }

    public Object lookup(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return map.get(s.toLowerCase(Locale.ENGLISH));
        }
    }

    public String toString()
    {
        return map.toString();
    }
}

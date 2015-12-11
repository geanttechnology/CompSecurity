// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.legacy.orbitconfig.json;

import com.google.b.b.g;
import com.google.b.i;
import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.o;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.shazam.server.legacy.orbitconfig.json:
//            ConfigEntry

public class LegacyJsonConfig
{
    public static class Deserializer
        implements k
    {

        public LegacyJsonConfig deserialize(l l1, Type type, j j1)
        {
            type = new LegacyJsonConfig();
            l1 = (i)l1.g().a.get("elements");
            if (l1 != null)
            {
                ConfigEntry configentry;
                for (l1 = l1.iterator(); l1.hasNext(); ((LegacyJsonConfig) (type)).configElements.put(configentry.getKey(), configentry.getValue()))
                {
                    configentry = (ConfigEntry)j1.a((l)l1.next(), com/shazam/server/legacy/orbitconfig/json/ConfigEntry);
                }

            }
            return type;
        }

        public volatile Object deserialize(l l1, Type type, j j1)
        {
            return deserialize(l1, type, j1);
        }

        public Deserializer()
        {
        }
    }


    private final Map configElements = new HashMap();

    public LegacyJsonConfig()
    {
    }

    public String getConfigProperty(String s, String s1)
    {
        if (configElements.containsKey(s))
        {
            return (String)configElements.get(s);
        } else
        {
            return s1;
        }
    }

}

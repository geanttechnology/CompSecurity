// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package android.support.v7:
//            wd

public final class uu extends wd
{

    private Map a;

    public uu()
    {
        a = new HashMap(4);
    }

    public Map a()
    {
        return Collections.unmodifiableMap(a);
    }

    public void a(uu uu1)
    {
        uu1.a.putAll(a);
    }

    public volatile void a(wd wd1)
    {
        a((uu)wd1);
    }

    public String toString()
    {
        HashMap hashmap = new HashMap();
        java.util.Map.Entry entry;
        for (Iterator iterator = a.entrySet().iterator(); iterator.hasNext(); hashmap.put((new StringBuilder()).append("dimension").append(entry.getKey()).toString(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        return a(hashmap);
    }
}

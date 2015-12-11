// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.common.internal.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package android.support.v7:
//            wd

public class ld
{

    Map a;

    public ld()
    {
        a = new HashMap();
    }

    public ld a(String s)
    {
        a("id", s);
        return this;
    }

    void a(String s, String s1)
    {
        x.a(s, "Name should be non-null");
        a.put(s, s1);
    }

    public ld b(String s)
    {
        a("nm", s);
        return this;
    }

    public ld c(String s)
    {
        a("cr", s);
        return this;
    }

    public ld d(String s)
    {
        a("ps", s);
        return this;
    }

    public Map e(String s)
    {
        HashMap hashmap = new HashMap();
        java.util.Map.Entry entry;
        for (Iterator iterator = a.entrySet().iterator(); iterator.hasNext(); hashmap.put((new StringBuilder()).append(s).append((String)entry.getKey()).toString(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        return hashmap;
    }

    public String toString()
    {
        return wd.a(a);
    }
}

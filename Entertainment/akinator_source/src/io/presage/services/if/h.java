// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.services.if;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package io.presage.services.if:
//            a, e

public final class h extends a
    implements e
{

    private String a;
    private String b;

    public h()
    {
    }

    public final String b()
    {
        return a;
    }

    public final void b(String s)
    {
        a = s;
    }

    public final void c(String s)
    {
        b = s;
    }

    public final Map d()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("_id", a());
        hashmap.put("search", a);
        hashmap.put("date", b);
        return hashmap;
    }

    public final String f()
    {
        StringBuilder stringbuilder = new StringBuilder(a());
        stringbuilder.append(":");
        stringbuilder.append(a);
        stringbuilder.append(":");
        stringbuilder.append(b);
        return stringbuilder.toString();
    }
}

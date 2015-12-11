// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class crw
{

    public static final crw a;
    private static final Map d;
    public final crx b;
    public final String c;

    private crw(crx crx1)
    {
        this(crx1, "");
    }

    public crw(crx crx1, String s)
    {
        b = (crx)b.a(crx1);
        c = cxd.a(b.a(s));
    }

    public static crw a(cnd cnd1)
    {
        crx crx1 = (crx)d.get(cnd1.a);
        if (crx1 == null)
        {
            crx1 = crx.f;
        }
        return new crw(crx1, cxd.a(cnd1.c));
    }

    public final String toString()
    {
        String s = String.valueOf(b);
        String s1 = c;
        return (new StringBuilder(String.valueOf(s).length() + 23 + String.valueOf(s1).length())).append("AdError: type=").append(s).append(" message=").append(s1).toString();
    }

    static 
    {
        a = new crw(crx.a);
        HashMap hashmap = new HashMap();
        hashmap.put("net.dns", crx.c);
        hashmap.put("net.connect", crx.d);
        hashmap.put("net.timeout", crx.e);
        hashmap.put("net.closed", crx.e);
        hashmap.put("net.nomobiledata", crx.b);
        hashmap.put("fmt.noneavailable", crx.g);
        d = Collections.unmodifiableMap(hashmap);
    }
}

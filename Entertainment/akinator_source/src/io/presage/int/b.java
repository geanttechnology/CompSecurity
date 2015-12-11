// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.int;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package io.presage.int:
//            g

public abstract class b
    implements g
{

    private String a;
    private Map b;
    private List c;

    public b(String s)
    {
        a = s;
        b = new HashMap();
        c = new ArrayList();
    }

    public final Map a()
    {
        return b;
    }

    public final void a(List list)
    {
        c = list;
    }

    public final void a(Map map)
    {
        b = map;
    }

    public final List b()
    {
        return c;
    }

    public final String c()
    {
        return a;
    }
}

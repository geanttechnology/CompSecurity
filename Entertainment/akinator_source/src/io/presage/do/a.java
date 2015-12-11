// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.do;

import io.presage.actions.d;
import io.presage.actions.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package io.presage.do:
//            e

public final class a
{

    protected ArrayList a;
    protected e b;
    private d c;

    public a(ArrayList arraylist, e e1)
    {
        a = arraylist;
        b = e1;
    }

    private d a()
    {
        if (c == null)
        {
            c = d.a();
        }
        return c;
    }

    public final g a(String s)
    {
        if (s.equals("home"))
        {
            a();
            return d.a("home", "intent", new e(new ArrayList()));
        }
        for (Iterator iterator = a.iterator(); iterator.hasNext();)
        {
            Map map = (Map)iterator.next();
            if (map.get("name").equals(s))
            {
                a();
                return d.a((String)map.get("name"), (String)map.get("type"), b.a((ArrayList)map.get("params")));
            }
        }

        return null;
    }
}

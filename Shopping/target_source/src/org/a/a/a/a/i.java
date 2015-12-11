// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.a.a;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package org.a.a.a.a:
//            d

public class i
    implements Iterable
{

    private final List a = new LinkedList();
    private final Map b = new HashMap();

    public i()
    {
    }

    public d a(String s)
    {
        if (s == null)
        {
            return null;
        }
        s = s.toLowerCase(Locale.ROOT);
        s = (List)b.get(s);
        if (s != null && !s.isEmpty())
        {
            return (d)s.get(0);
        } else
        {
            return null;
        }
    }

    public void a(d d1)
    {
        if (d1 == null)
        {
            return;
        }
        String s = d1.a().toLowerCase(Locale.ROOT);
        List list = (List)b.get(s);
        Object obj = list;
        if (list == null)
        {
            obj = new LinkedList();
            b.put(s, obj);
        }
        ((List) (obj)).add(d1);
        a.add(d1);
    }

    public Iterator iterator()
    {
        return Collections.unmodifiableList(a).iterator();
    }

    public String toString()
    {
        return a.toString();
    }
}

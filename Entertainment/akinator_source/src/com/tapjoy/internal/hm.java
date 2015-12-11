// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.tapjoy.internal:
//            hq

public final class hm
    implements Iterable
{

    private final List a = new LinkedList();
    private final Map b = new HashMap();

    public hm()
    {
    }

    public final hq a(String s)
    {
        if (s == null)
        {
            return null;
        }
        s = s.toLowerCase(Locale.US);
        s = (List)b.get(s);
        if (s != null && !s.isEmpty())
        {
            return (hq)s.get(0);
        } else
        {
            return null;
        }
    }

    public final void a(hq hq1)
    {
        if (hq1 == null)
        {
            return;
        }
        String s = hq1.a.toLowerCase(Locale.US);
        List list = (List)b.get(s);
        Object obj = list;
        if (list == null)
        {
            obj = new LinkedList();
            b.put(s, obj);
        }
        ((List) (obj)).add(hq1);
        a.add(hq1);
    }

    public final Iterator iterator()
    {
        return Collections.unmodifiableList(a).iterator();
    }

    public final String toString()
    {
        return a.toString();
    }
}

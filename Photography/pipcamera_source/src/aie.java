// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class aie
    implements Iterable
{

    private final List a = new LinkedList();
    private final Map b = new HashMap();

    public aie()
    {
    }

    public aih a(String s)
    {
        if (s == null)
        {
            return null;
        }
        s = s.toLowerCase(Locale.US);
        s = (List)b.get(s);
        if (s != null && !s.isEmpty())
        {
            return (aih)s.get(0);
        } else
        {
            return null;
        }
    }

    public void a(aih aih1)
    {
        if (aih1 == null)
        {
            return;
        }
        String s = aih1.a().toLowerCase(Locale.US);
        List list = (List)b.get(s);
        Object obj = list;
        if (list == null)
        {
            obj = new LinkedList();
            b.put(s, obj);
        }
        ((List) (obj)).add(aih1);
        a.add(aih1);
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

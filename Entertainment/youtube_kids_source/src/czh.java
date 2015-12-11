// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class czh
{

    public final List a;

    public czh(List list)
    {
        a = (List)b.a(list);
    }

    public Map a()
    {
        HashMap hashmap = new HashMap();
        s s1;
        for (Iterator iterator = a.iterator(); iterator.hasNext(); hashmap.put(s1.getClass().toString(), s1.d()))
        {
            s1 = (s)iterator.next();
        }

        return hashmap;
    }
}

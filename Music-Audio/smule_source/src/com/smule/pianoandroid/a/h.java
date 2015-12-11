// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.a;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.smule.pianoandroid.a:
//            f

abstract class h extends f
{

    private h()
    {
        super(null);
    }

    h(c._cls1 _pcls1)
    {
        this();
    }

    private boolean a(List list)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            Object obj = list.next();
            if (obj == null)
            {
                return false;
            }
            if (!(obj instanceof Comparable))
            {
                return false;
            }
        }

        return true;
    }

    public abstract boolean a(int i);

    public boolean a(Map map)
    {
        Object obj = a(a, map);
        if (!a(((List) (obj))))
        {
            return false;
        }
        map = ((Map) (((List) (obj)).get(0)));
        obj = ((List) (obj)).get(1);
        int i;
        if (map instanceof Number)
        {
            i = Long.valueOf(((Number)map).longValue()).compareTo(Long.valueOf(((Number)obj).longValue()));
        } else
        {
            i = String.valueOf(map).compareTo(String.valueOf(obj));
        }
        return a(i);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.a;

import com.smule.android.c.aa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.smule.pianoandroid.a:
//            e, c, a

class k extends e
{

    protected List a;

    private k()
    {
        super(null);
        a = new ArrayList();
    }

    k(c._cls1 _pcls1)
    {
        this();
    }

    public int a()
    {
        return 0;
    }

    public List a(List list, Map map)
    {
        ArrayList arraylist = new ArrayList(list.size());
        for (list = list.iterator(); list.hasNext();)
        {
            Object obj = list.next();
            if ((obj instanceof String) && ((String)obj).startsWith("$"))
            {
                arraylist.add(c.a(map, ((String)obj).substring(1)));
            } else
            {
                arraylist.add(obj);
            }
        }

        return arraylist;
    }

    public a a_(Map map)
    {
        if (map.size() != 1)
        {
            aa.b(c.a(), (new StringBuilder()).append("Expected one condition key. Got : ").append(map).toString());
            map = null;
        } else
        {
            a = (List)map.get((String)map.keySet().iterator().next());
            int i = a();
            map = this;
            if (a.size() != i)
            {
                aa.b(c.a(), String.format("Expected %d operands, go %d", new Object[] {
                    Integer.valueOf(i), Integer.valueOf(a.size())
                }));
                return this;
            }
        }
        return map;
    }
}

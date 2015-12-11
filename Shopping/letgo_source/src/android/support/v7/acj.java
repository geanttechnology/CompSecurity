// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package android.support.v7:
//            aat, lt, ado

public abstract class acj extends aat
{

    private static final String a;
    private static final String b;

    public acj(String s)
    {
        super(s, new String[] {
            a, b
        });
    }

    public lv.a a(Map map)
    {
        for (Iterator iterator = map.values().iterator(); iterator.hasNext();)
        {
            if ((lv.a)iterator.next() == ado.f())
            {
                return ado.e(Boolean.valueOf(false));
            }
        }

        lv.a a1 = (lv.a)map.get(a);
        lv.a a2 = (lv.a)map.get(b);
        boolean flag;
        if (a1 == null || a2 == null)
        {
            flag = false;
        } else
        {
            flag = a(a1, a2, map);
        }
        return ado.e(Boolean.valueOf(flag));
    }

    public boolean a()
    {
        return true;
    }

    protected abstract boolean a(lv.a a1, lv.a a2, Map map);

    public volatile String b()
    {
        return super.b();
    }

    public volatile Set c()
    {
        return super.c();
    }

    static 
    {
        a = lt.p.toString();
        b = lt.q.toString();
    }
}

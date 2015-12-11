// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class cz extends dk
    implements Map
{

    private de d;

    public cz()
    {
    }

    private de a()
    {
        if (d == null)
        {
            d = new da(this);
        }
        return d;
    }

    public Set entrySet()
    {
        de de1 = a();
        if (de1.a == null)
        {
            de1.a = new dg(de1);
        }
        return de1.a;
    }

    public Set keySet()
    {
        de de1 = a();
        if (de1.b == null)
        {
            de1.b = new dh(de1);
        }
        return de1.b;
    }

    public void putAll(Map map)
    {
        int i = c + map.size();
        if (super.a.length < i)
        {
            int ai[] = super.a;
            Object aobj[] = super.b;
            super.a(i);
            if (super.c > 0)
            {
                System.arraycopy(ai, 0, super.a, 0, super.c);
                System.arraycopy(((Object) (aobj)), 0, ((Object) (super.b)), 0, super.c << 1);
            }
            dk.a(ai, aobj, super.c);
        }
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); put(entry.getKey(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
        }

    }

    public Collection values()
    {
        de de1 = a();
        if (de1.c == null)
        {
            de1.c = new dj(de1);
        }
        return de1.c;
    }
}

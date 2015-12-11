// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package jumiomobile:
//            pz

public class py extends pz
{

    private double b;

    public py(double d, int i, String s)
    {
        super(s);
        b = d / (double)i;
    }

    public py(List list, String s)
    {
        super(s);
        int i = list.size();
        list = list.iterator();
        long l;
        for (l = 0L; list.hasNext(); l = ((Long)list.next()).longValue() + l) { }
        if (i == 0)
        {
            b = 0.0D;
            return;
        } else
        {
            b = (float)l / (float)i;
            return;
        }
    }

    public Double a()
    {
        return Double.valueOf(b);
    }

    public Object b()
    {
        return a();
    }

    public String toString()
    {
        return (new StringBuilder()).append(c()).append(": ").append(a()).toString();
    }
}

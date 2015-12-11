// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.support.v7:
//            oy

static class d
{

    private final String a;
    private final int b;
    private final List c;
    private final String d;

    public String a()
    {
        return a;
    }

    public int b()
    {
        return b;
    }

    public Iterable c()
    {
        return c;
    }

    public String d()
    {
        return d;
    }

    public (String s, int i, List list, String s1)
    {
        a = s;
        b = i;
        if (list == null)
        {
            c = new ArrayList();
        } else
        {
            c = list;
        }
        d = s1;
    }
}

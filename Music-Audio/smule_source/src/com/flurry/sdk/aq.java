// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.Collections;
import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            dt, cy

public class aq
{

    private cy a;
    private dt b;
    private List c;

    public aq()
    {
        b = new dt();
    }

    public cy a()
    {
        return a;
    }

    public void a(cy cy)
    {
        a = cy;
    }

    public void a(dt dt1)
    {
        b = dt1;
    }

    public void a(List list)
    {
        c = list;
    }

    public dt b()
    {
        return b;
    }

    public List c()
    {
        if (c == null)
        {
            return Collections.emptyList();
        } else
        {
            return c;
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.Set;

// Referenced classes of package com.flurry.sdk:
//            ig, je, ii

public final class ij extends ig
{

    private final je a = new je();

    public ij()
    {
    }

    public void a(String s, ig ig1)
    {
        Object obj = ig1;
        if (ig1 == null)
        {
            obj = ii.a;
        }
        a.put(s, obj);
    }

    public boolean equals(Object obj)
    {
        return obj == this || (obj instanceof ij) && ((ij)obj).a.equals(a);
    }

    public int hashCode()
    {
        return a.hashCode();
    }

    public Set o()
    {
        return a.entrySet();
    }
}

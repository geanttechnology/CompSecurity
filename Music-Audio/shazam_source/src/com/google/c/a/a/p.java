// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.c.a.a;


// Referenced classes of package com.google.c.a.a:
//            j, i

public final class p extends j
{

    public p()
    {
    }

    protected final i a()
    {
        return i.k;
    }

    public final boolean a(String s)
    {
        for (s = c(s); !s.startsWith("urlto:") && !s.startsWith("URLTO:") || s.indexOf(':', 6) < 0;)
        {
            return false;
        }

        return true;
    }
}

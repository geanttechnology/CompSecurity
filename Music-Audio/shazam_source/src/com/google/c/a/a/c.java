// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.c.a.a;


// Referenced classes of package com.google.c.a.a:
//            a, i

public final class c extends a
{

    public c()
    {
    }

    protected final i a()
    {
        return i.a;
    }

    public final boolean a(String s)
    {
        for (s = c(s); !s.startsWith("MECARD:") || com.google.c.a.a.a.a("N:", s, true) == null;)
        {
            return false;
        }

        return true;
    }
}

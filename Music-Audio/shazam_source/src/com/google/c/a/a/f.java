// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.c.a.a;


// Referenced classes of package com.google.c.a.a:
//            j, i, g

public final class f extends j
{

    public f()
    {
    }

    protected final i a()
    {
        return i.b;
    }

    public final boolean a(String s)
    {
        s = c(s);
        if (s.startsWith("mailto:") || s.startsWith("MAILTO:"))
        {
            return true;
        } else
        {
            return g.b(s);
        }
    }
}

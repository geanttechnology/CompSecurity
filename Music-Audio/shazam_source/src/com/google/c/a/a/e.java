// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.c.a.a;


// Referenced classes of package com.google.c.a.a:
//            a, i, o

public final class e extends a
{

    public e()
    {
    }

    protected final i a()
    {
        return i.j;
    }

    public final boolean a(String s)
    {
        if (s.startsWith("MEBKM:"))
        {
            if ((s = com.google.c.a.a.a.a("URL:", s, true)) != null)
            {
                return o.b(s[0]);
            }
        }
        return false;
    }
}

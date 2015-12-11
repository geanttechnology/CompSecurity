// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ae;


// Referenced classes of package com.shazam.android.ae:
//            p, n

public final class c
    implements p
{

    private final p b[];

    public transient c(p ap[])
    {
        b = ap;
    }

    public final void a(n n, String s, String s1)
    {
        p ap[] = b;
        int j = ap.length;
        for (int i = 0; i < j; i++)
        {
            ap[i].a(n, s, s1);
        }

    }

    public final void a(n n, String s, String s1, Throwable throwable)
    {
        p ap[] = b;
        int j = ap.length;
        for (int i = 0; i < j; i++)
        {
            ap[i].a(n, s, s1, throwable);
        }

    }

    public final transient void a(n n, String s, Throwable throwable, String s1, Object aobj[])
    {
        p ap[] = b;
        int j = ap.length;
        for (int i = 0; i < j; i++)
        {
            ap[i].a(n, s, throwable, s1, aobj);
        }

    }
}

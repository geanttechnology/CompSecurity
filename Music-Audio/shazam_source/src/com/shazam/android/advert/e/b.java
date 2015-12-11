// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.advert.e;


// Referenced classes of package com.shazam.android.advert.e:
//            g, f

public final class b
    implements g
{

    private final g b[];

    public transient b(g ag[])
    {
        b = ag;
    }

    public final void a(int i)
    {
        g ag[] = b;
        int k = ag.length;
        for (int j = 0; j < k; j++)
        {
            ag[j].a(i);
        }

    }

    public final void a(f f)
    {
        g ag[] = b;
        int j = ag.length;
        for (int i = 0; i < j; i++)
        {
            ag[i].a(f);
        }

    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.af;


// Referenced classes of package com.shazam.android.j.af:
//            c

public final class b
    implements c
{

    private final c a[];

    public transient b(c ac[])
    {
        a = ac;
    }

    public final void a()
    {
        c ac[] = a;
        int j = ac.length;
        for (int i = 0; i < j; i++)
        {
            ac[i].a();
        }

    }
}

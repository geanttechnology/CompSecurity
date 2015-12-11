// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.advert.e;


// Referenced classes of package com.shazam.android.advert.e:
//            e

public final class c
    implements e
{

    private final e b[];

    private transient c(e ae[])
    {
        b = ae;
    }

    public static transient e a(e ae[])
    {
        return new c(ae);
    }

    public final void a()
    {
        e ae[] = b;
        int j = ae.length;
        for (int i = 0; i < j; i++)
        {
            ae[i].a();
        }

    }
}

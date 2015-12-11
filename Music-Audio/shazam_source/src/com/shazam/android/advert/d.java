// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.advert;


// Referenced classes of package com.shazam.android.advert:
//            l, ShazamAdView, b, a

public final class d
    implements l
{

    private final l a[];

    public transient d(l al[])
    {
        a = al;
    }

    public final void a()
    {
        l al[] = a;
        int j = al.length;
        for (int i = 0; i < j; i++)
        {
            al[i].a();
        }

    }

    public final void a(ShazamAdView shazamadview, b b1, a a1, String s)
    {
        l al[] = a;
        int j = al.length;
        for (int i = 0; i < j; i++)
        {
            al[i].a(shazamadview, b1, a1, s);
        }

    }

    public final void a(ShazamAdView shazamadview, b b1, String s)
    {
        l al[] = a;
        int j = al.length;
        for (int i = 0; i < j; i++)
        {
            al[i].a(shazamadview, b1, s);
        }

    }

    public final void b()
    {
    }

    public final void b(ShazamAdView shazamadview, b b1, String s)
    {
        l al[] = a;
        int j = al.length;
        for (int i = 0; i < j; i++)
        {
            al[i].b(shazamadview, b1, s);
        }

    }

    public final void c()
    {
    }
}

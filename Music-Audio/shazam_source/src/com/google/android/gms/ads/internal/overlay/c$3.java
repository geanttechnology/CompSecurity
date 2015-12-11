// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.overlay;


// Referenced classes of package com.google.android.gms.ads.internal.overlay:
//            c, h

final class b
    implements Runnable
{

    final String a;
    final String b;
    final c c;

    public final void run()
    {
        if (com.google.android.gms.ads.internal.overlay.c.a(c) != null)
        {
            com.google.android.gms.ads.internal.overlay.c.a(c).a(a, b);
        }
    }

    (c c1, String s, String s1)
    {
        c = c1;
        a = s;
        b = s1;
        super();
    }
}

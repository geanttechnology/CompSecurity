// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.overlay;


// Referenced classes of package com.google.android.gms.ads.internal.overlay:
//            zzc, g

final class b
    implements Runnable
{

    final String a;
    final String b;
    final zzc c;

    public final void run()
    {
        if (zzc.a(c) != null)
        {
            zzc.a(c).a(a, b);
        }
    }

    (zzc zzc1, String s, String s1)
    {
        c = zzc1;
        a = s;
        b = s1;
        super();
    }
}

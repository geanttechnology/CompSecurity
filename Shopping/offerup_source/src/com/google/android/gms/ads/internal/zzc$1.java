// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzhs;

// Referenced classes of package com.google.android.gms.ads.internal:
//            zzc

class zzoB
    implements Runnable
{

    final com.google.android.gms.internal.za zzoB;
    final zzc zzoC;

    public void run()
    {
        zzoC.zzb(new zzhs(zzoB, null, null, null, null, null, null));
    }

    (zzc zzc1, com.google.android.gms.internal.za za)
    {
        zzoC = zzc1;
        zzoB = za;
        super();
    }
}

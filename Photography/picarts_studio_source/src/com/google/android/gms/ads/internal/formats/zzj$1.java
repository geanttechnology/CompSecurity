// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.formats;

import android.widget.FrameLayout;
import com.google.android.gms.internal.zziz;

// Referenced classes of package com.google.android.gms.ads.internal.formats:
//            zzj, zzh

class zzxa
    implements Runnable
{

    final zzh zzxa;
    final zzj zzxb;

    public void run()
    {
        zziz zziz1 = zzxa.zzdC();
        if (zziz1 != null)
        {
            zzj.zza(zzxb).addView(zziz1.getView());
        }
    }

    (zzj zzj1, zzh zzh1)
    {
        zzxb = zzj1;
        zzxa = zzh1;
        super();
    }
}

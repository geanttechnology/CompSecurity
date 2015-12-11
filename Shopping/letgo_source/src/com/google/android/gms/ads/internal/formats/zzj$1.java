// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.formats;

import android.support.v7.ul;
import android.widget.FrameLayout;

// Referenced classes of package com.google.android.gms.ads.internal.formats:
//            zzj, zzh

class zzwu
    implements Runnable
{

    final zzh zzwu;
    final zzj zzwv;

    public void run()
    {
        ul ul1 = zzwu.zzdy();
        if (ul1 != null)
        {
            zzj.zza(zzwv).addView(ul1.getWebView());
        }
    }

    (zzj zzj1, zzh zzh1)
    {
        zzwv = zzj1;
        zzwu = zzh1;
        super();
    }
}

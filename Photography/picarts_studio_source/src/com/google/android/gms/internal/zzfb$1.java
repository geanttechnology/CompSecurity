// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.DialogInterface;
import com.google.android.gms.ads.internal.zzp;

// Referenced classes of package com.google.android.gms.internal:
//            zzfb, zzid

class zzAa
    implements android.content.nterface.OnClickListener
{

    final zzfb zzAa;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = zzAa.createIntent();
        zzp.zzbv().zzb(zzfb.zza(zzAa), dialoginterface);
    }

    (zzfb zzfb1)
    {
        zzAa = zzfb1;
        super();
    }
}

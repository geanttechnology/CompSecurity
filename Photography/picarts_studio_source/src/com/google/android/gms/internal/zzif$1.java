// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.content.Intent;
import com.google.android.gms.ads.internal.zzp;

// Referenced classes of package com.google.android.gms.internal:
//            zzif, zzid

class zzIM
    implements android.content.nterface.OnClickListener
{

    final String zzIM;
    final zzif zzIN;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        zzp.zzbv().zzb(zzif.zza(zzIN), Intent.createChooser((new Intent("android.intent.action.SEND")).setType("text/plain").putExtra("android.intent.extra.TEXT", zzIM), "Share via"));
    }

    (zzif zzif1, String s)
    {
        zzIN = zzif1;
        zzIM = s;
        super();
    }
}

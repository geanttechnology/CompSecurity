// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.cast.internal.zzo;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zzkd, zzkg

class a extends a
{

    final zzkd zzWd;
    final int zzWf;
    final String zzWg;
    final JSONObject zzWh;

    public void execute()
    {
        int i = zzkg.zzaR(zzWf);
        if (i == 0)
        {
            zzmk().zza(-1L, 2001, null);
            zzkd.zzmj().zzf("sendPlayerRequest for unsupported playerState: %d", new Object[] {
                Integer.valueOf(zzWf)
            });
            return;
        } else
        {
            zzkd.zza(zzWd, zzWg, i, zzWh, zzmk());
            return;
        }
    }

    l(zzkd zzkd1, int i, String s, JSONObject jsonobject)
    {
        zzWd = zzkd1;
        zzWf = i;
        zzWg = s;
        zzWh = jsonobject;
        super(zzkd1);
    }
}

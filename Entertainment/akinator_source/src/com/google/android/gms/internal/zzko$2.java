// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.cast.internal.zzo;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zzko, zzkr

class a extends a
{

    final zzko zzXV;
    final int zzXX;
    final String zzXY;
    final JSONObject zzXZ;

    public void execute()
    {
        int i = zzkr.zzaY(zzXX);
        if (i == 0)
        {
            zzmG().zza(-1L, 2001, null);
            zzko.zzmF().zzf("sendPlayerRequest for unsupported playerState: %d", new Object[] {
                Integer.valueOf(zzXX)
            });
            return;
        } else
        {
            zzko.zza(zzXV, zzXY, i, zzXZ, zzmG());
            return;
        }
    }

    l(zzko zzko1, int i, String s, JSONObject jsonobject)
    {
        zzXV = zzko1;
        zzXX = i;
        zzXY = s;
        zzXZ = jsonobject;
        super(zzko1);
    }
}

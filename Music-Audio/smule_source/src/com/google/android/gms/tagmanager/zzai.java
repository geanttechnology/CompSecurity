// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zza;
import java.util.Map;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzak, zzcp, zzdf

class zzai extends zzak
{

    private static final String ID;
    private final zzcp zzaCm;

    public zzai(zzcp zzcp1)
    {
        super(ID, new String[0]);
        zzaCm = zzcp1;
    }

    public com.google.android.gms.internal.zzd.zza zzD(Map map)
    {
        map = zzaCm.zzxv();
        if (map == null)
        {
            return zzdf.zzxW();
        } else
        {
            return zzdf.zzE(map);
        }
    }

    public boolean zzwn()
    {
        return false;
    }

    static 
    {
        ID = zza.zzK.toString();
    }
}

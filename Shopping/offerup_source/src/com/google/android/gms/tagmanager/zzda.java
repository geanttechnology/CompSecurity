// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import java.util.Map;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzak, zzdf

class zzda extends zzak
{

    private static final String ID;

    public zzda()
    {
        super(ID, new String[0]);
    }

    public boolean zzCo()
    {
        return false;
    }

    public com.google.android.gms.internal.zzag.zza zzI(Map map)
    {
        return zzdf.zzQ(Long.valueOf(System.currentTimeMillis()));
    }

    static 
    {
        ID = zzad.zzbH.toString();
    }
}

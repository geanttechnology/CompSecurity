// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import java.util.Map;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzak, zzdf

class zzcr extends zzak
{

    private static final String ID;

    public zzcr()
    {
        super(ID, new String[0]);
    }

    public boolean zzCo()
    {
        return true;
    }

    public com.google.android.gms.internal.zzag.zza zzI(Map map)
    {
        return zzdf.zzQ(Integer.valueOf(android.os.Build.VERSION.SDK_INT));
    }

    static 
    {
        ID = zzad.zzbF.toString();
    }
}

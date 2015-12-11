// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.internal.zzad;
import java.util.Map;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzak, zzdf, zzbg

class zzg extends zzak
{

    private static final String ID;
    private final Context mContext;

    public zzg(Context context)
    {
        super(ID, new String[0]);
        mContext = context;
    }

    public boolean zzCo()
    {
        return true;
    }

    public com.google.android.gms.internal.zzag.zza zzI(Map map)
    {
        try
        {
            map = mContext.getPackageManager();
            map = zzdf.zzQ(map.getApplicationLabel(map.getApplicationInfo(mContext.getPackageName(), 0)).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            zzbg.zzb("App name is not found.", map);
            return zzdf.zzDX();
        }
        return map;
    }

    static 
    {
        ID = zzad.zzbi.toString();
    }
}

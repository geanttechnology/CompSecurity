// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzak, zzdf

public class zzbb extends zzak
{

    private static final String ID;

    public zzbb()
    {
        super(ID, new String[0]);
    }

    public volatile String zzCT()
    {
        return super.zzCT();
    }

    public volatile Set zzCU()
    {
        return super.zzCU();
    }

    public boolean zzCo()
    {
        return false;
    }

    public com.google.android.gms.internal.zzag.zza zzI(Map map)
    {
        map = Locale.getDefault();
        if (map == null)
        {
            return zzdf.zzDX();
        }
        map = map.getLanguage();
        if (map == null)
        {
            return zzdf.zzDX();
        } else
        {
            return zzdf.zzQ(map.toLowerCase());
        }
    }

    static 
    {
        ID = zzad.zzby.toString();
    }
}

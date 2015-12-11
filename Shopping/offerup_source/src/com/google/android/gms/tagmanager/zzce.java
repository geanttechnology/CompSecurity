// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzak, zzdf

class zzce extends zzak
{

    private static final String ID;
    private static final String zzaYe;
    private static final String zzaYf;
    private static final String zzaYg;
    private static final String zzaYh;

    public zzce()
    {
        super(ID, new String[] {
            zzaYe, zzaYf
        });
    }

    public boolean zzCo()
    {
        return true;
    }

    public com.google.android.gms.internal.zzag.zza zzI(Map map)
    {
        Object obj = (com.google.android.gms.internal.zzag.zza)map.get(zzaYe);
        com.google.android.gms.internal.zzag.zza zza = (com.google.android.gms.internal.zzag.zza)map.get(zzaYf);
        if (obj == null || obj == zzdf.zzDX() || zza == null || zza == zzdf.zzDX())
        {
            return zzdf.zzDX();
        }
        byte byte0 = 64;
        if (zzdf.zzk((com.google.android.gms.internal.zzag.zza)map.get(zzaYg)).booleanValue())
        {
            byte0 = 66;
        }
        map = (com.google.android.gms.internal.zzag.zza)map.get(zzaYh);
        int i;
        if (map != null)
        {
            map = zzdf.zzi(map);
            if (map == zzdf.zzDS())
            {
                return zzdf.zzDX();
            }
            int j = map.intValue();
            i = j;
            if (j < 0)
            {
                return zzdf.zzDX();
            }
        } else
        {
            i = 1;
        }
        try
        {
            map = zzdf.zzg(((com.google.android.gms.internal.zzag.zza) (obj)));
            obj = zzdf.zzg(zza);
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            return zzdf.zzDX();
        }
        zza = null;
        obj = Pattern.compile(((String) (obj)), byte0).matcher(map);
        map = zza;
        if (!((Matcher) (obj)).find())
        {
            break MISSING_BLOCK_LABEL_186;
        }
        map = zza;
        if (((Matcher) (obj)).groupCount() >= i)
        {
            map = ((Matcher) (obj)).group(i);
        }
        if (map != null)
        {
            break MISSING_BLOCK_LABEL_194;
        }
        return zzdf.zzDX();
        map = zzdf.zzQ(map);
        return map;
    }

    static 
    {
        ID = zzad.zzbR.toString();
        zzaYe = zzae.zzdz.toString();
        zzaYf = zzae.zzdA.toString();
        zzaYg = zzae.zzfr.toString();
        zzaYh = zzae.zzfl.toString();
    }
}

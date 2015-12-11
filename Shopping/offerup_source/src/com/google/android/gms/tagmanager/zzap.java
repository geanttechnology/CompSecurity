// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzak, zzdf, zzk, zzbg

class zzap extends zzak
{

    private static final String ID;
    private static final String zzaWU;
    private static final String zzaWW;
    private static final String zzaXa;

    public zzap()
    {
        super(ID, new String[] {
            zzaWU
        });
    }

    private byte[] zzd(String s, byte abyte0[])
    {
        s = MessageDigest.getInstance(s);
        s.update(abyte0);
        return s.digest();
    }

    public boolean zzCo()
    {
        return true;
    }

    public com.google.android.gms.internal.zzag.zza zzI(Map map)
    {
        Object obj = (com.google.android.gms.internal.zzag.zza)map.get(zzaWU);
        if (obj == null || obj == zzdf.zzDX())
        {
            return zzdf.zzDX();
        }
        String s = zzdf.zzg(((com.google.android.gms.internal.zzag.zza) (obj)));
        obj = (com.google.android.gms.internal.zzag.zza)map.get(zzaXa);
        if (obj == null)
        {
            obj = "MD5";
        } else
        {
            obj = zzdf.zzg(((com.google.android.gms.internal.zzag.zza) (obj)));
        }
        map = (com.google.android.gms.internal.zzag.zza)map.get(zzaWW);
        if (map == null)
        {
            map = "text";
        } else
        {
            map = zzdf.zzg(map);
        }
        if ("text".equals(map))
        {
            map = s.getBytes();
        } else
        if ("base16".equals(map))
        {
            map = zzk.zzez(s);
        } else
        {
            zzbg.e((new StringBuilder("Hash: unknown input format: ")).append(map).toString());
            return zzdf.zzDX();
        }
        try
        {
            map = zzdf.zzQ(zzk.zzi(zzd(((String) (obj)), map)));
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            zzbg.e((new StringBuilder("Hash: unknown algorithm: ")).append(((String) (obj))).toString());
            return zzdf.zzDX();
        }
        return map;
    }

    static 
    {
        ID = zzad.zzbN.toString();
        zzaWU = zzae.zzdz.toString();
        zzaXa = zzae.zzdq.toString();
        zzaWW = zzae.zzft.toString();
    }
}

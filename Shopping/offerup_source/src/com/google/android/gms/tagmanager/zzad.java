// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.internal.zzae;
import java.util.Map;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzak, zzdf, zzk, zzbg

class zzad extends zzak
{

    private static final String ID;
    private static final String zzaWU;
    private static final String zzaWV;
    private static final String zzaWW;
    private static final String zzaWX;

    public zzad()
    {
        super(ID, new String[] {
            zzaWU
        });
    }

    public boolean zzCo()
    {
        return true;
    }

    public com.google.android.gms.internal.zzag.zza zzI(Map map)
    {
        Object obj;
        String s;
        String s1;
        byte byte0;
        obj = (com.google.android.gms.internal.zzag.zza)map.get(zzaWU);
        if (obj == null || obj == zzdf.zzDX())
        {
            return zzdf.zzDX();
        }
        s1 = zzdf.zzg(((com.google.android.gms.internal.zzag.zza) (obj)));
        obj = (com.google.android.gms.internal.zzag.zza)map.get(zzaWW);
        byte byte1;
        if (obj == null)
        {
            s = "text";
        } else
        {
            s = zzdf.zzg(((com.google.android.gms.internal.zzag.zza) (obj)));
        }
        obj = (com.google.android.gms.internal.zzag.zza)map.get(zzaWX);
        if (obj == null)
        {
            obj = "base16";
        } else
        {
            obj = zzdf.zzg(((com.google.android.gms.internal.zzag.zza) (obj)));
        }
        byte1 = 2;
        map = (com.google.android.gms.internal.zzag.zza)map.get(zzaWV);
        byte0 = byte1;
        if (map != null)
        {
            byte0 = byte1;
            if (zzdf.zzk(map).booleanValue())
            {
                byte0 = 3;
            }
        }
        if (!"text".equals(s)) goto _L2; else goto _L1
_L1:
        map = s1.getBytes();
_L8:
        if (!"base16".equals(obj)) goto _L4; else goto _L3
_L3:
        map = zzk.zzi(map);
_L6:
        return zzdf.zzQ(map);
_L2:
        if ("base16".equals(s))
        {
            map = zzk.zzez(s1);
            continue; /* Loop/switch isn't completed */
        }
        if ("base64".equals(s))
        {
            map = Base64.decode(s1, byte0);
            continue; /* Loop/switch isn't completed */
        }
        if ("base64url".equals(s))
        {
            map = Base64.decode(s1, byte0 | 8);
            continue; /* Loop/switch isn't completed */
        } else
        {
            try
            {
                zzbg.e((new StringBuilder("Encode: unknown input format: ")).append(s).toString());
                map = zzdf.zzDX();
            }
            // Misplaced declaration of an exception variable
            catch (Map map)
            {
                zzbg.e("Encode: invalid input:");
                return zzdf.zzDX();
            }
            return map;
        }
_L4:
        if ("base64".equals(obj))
        {
            map = Base64.encodeToString(map, byte0);
            continue; /* Loop/switch isn't completed */
        }
        if (!"base64url".equals(obj))
        {
            break; /* Loop/switch isn't completed */
        }
        map = Base64.encodeToString(map, byte0 | 8);
        if (true) goto _L6; else goto _L5
_L5:
        zzbg.e((new StringBuilder("Encode: unknown output format: ")).append(((String) (obj))).toString());
        return zzdf.zzDX();
        if (true) goto _L8; else goto _L7
_L7:
    }

    static 
    {
        ID = com.google.android.gms.internal.zzad.zzbL.toString();
        zzaWU = zzae.zzdz.toString();
        zzaWV = zzae.zzfX.toString();
        zzaWW = zzae.zzft.toString();
        zzaWX = zzae.zzgf.toString();
    }
}

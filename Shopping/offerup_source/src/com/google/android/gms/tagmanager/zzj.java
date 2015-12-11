// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzdd, zzdf, zzbg, zzar, 
//            zzcv

class zzj extends zzdd
{

    private static final String ID;
    private static final String URL;
    private static final String zzaVJ;
    private static final String zzaVK;
    static final String zzaVL;
    private static final Set zzaVM = new HashSet();
    private final Context mContext;
    private final zza zzaVN;

    public zzj(Context context)
    {
        this(context, ((zza) (new _cls1(context))));
    }

    zzj(Context context, zza zza)
    {
        super(ID, new String[] {
            URL
        });
        zzaVN = zza;
        mContext = context;
    }

    private boolean zzew(String s)
    {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        boolean flag1 = zzey(s);
        if (!flag1) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        if (zzex(s))
        {
            zzaVM.add(s);
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_44;
        s;
        throw s;
        flag = false;
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void zzK(Map map)
    {
        String s;
        if (map.get(zzaVK) != null)
        {
            s = zzdf.zzg((com.google.android.gms.internal.zzag.zza)map.get(zzaVK));
        } else
        {
            s = null;
        }
        if (s == null || !zzew(s)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        android.net.Uri.Builder builder = Uri.parse(zzdf.zzg((com.google.android.gms.internal.zzag.zza)map.get(URL))).buildUpon();
        map = (com.google.android.gms.internal.zzag.zza)map.get(zzaVJ);
        if (map != null)
        {
            map = ((Map) (zzdf.zzl(map)));
            if (!(map instanceof List))
            {
                zzbg.e((new StringBuilder("ArbitraryPixel: additional params not a list: not sending partial hit: ")).append(builder.build().toString()).toString());
                return;
            }
            for (map = ((List)map).iterator(); map.hasNext();)
            {
                Object obj = map.next();
                if (!(obj instanceof Map))
                {
                    zzbg.e((new StringBuilder("ArbitraryPixel: additional params contains non-map: not sending partial hit: ")).append(builder.build().toString()).toString());
                    return;
                }
                obj = ((Map)obj).entrySet().iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                    builder.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                }
            }

        }
        map = builder.build().toString();
        zzaVN.zzCp().zzeN(map);
        zzbg.v((new StringBuilder("ArbitraryPixel: url = ")).append(map).toString());
        if (s == null) goto _L1; else goto _L3
_L3:
        com/google/android/gms/tagmanager/zzj;
        JVM INSTR monitorenter ;
        zzaVM.add(s);
        zzcv.zzb(mContext, zzaVL, s, "true");
        com/google/android/gms/tagmanager/zzj;
        JVM INSTR monitorexit ;
        return;
        map;
        com/google/android/gms/tagmanager/zzj;
        JVM INSTR monitorexit ;
        throw map;
    }

    boolean zzex(String s)
    {
        return mContext.getSharedPreferences(zzaVL, 0).contains(s);
    }

    boolean zzey(String s)
    {
        return zzaVM.contains(s);
    }

    static 
    {
        ID = zzad.zzco.toString();
        URL = zzae.zzhx.toString();
        zzaVJ = zzae.zzdn.toString();
        zzaVK = zzae.zzhw.toString();
        zzaVL = (new StringBuilder("gtm_")).append(ID).append("_unrepeatable").toString();
    }

    private class _cls1
        implements zza
    {

        final Context zzry;

        public zzar zzCp()
        {
            return zzz.zzaO(zzry);
        }

        _cls1(Context context)
        {
            zzry = context;
            super();
        }
    }


    private class zza
    {

        public abstract zzar zzCp();
    }

}

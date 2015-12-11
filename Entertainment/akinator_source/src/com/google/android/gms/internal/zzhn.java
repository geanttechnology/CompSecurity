// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;

// Referenced classes of package com.google.android.gms.internal:
//            zzhz, zzhm, zzhg, zzhh, 
//            zzhi, zzee, zzed, zzhs

public class zzhn extends zzhz
    implements zzhm
{

    private final Context mContext;
    private final zzhs.zza zzDe;
    private final String zzGY;
    private final ArrayList zzHp = new ArrayList();
    private final ArrayList zzHq = new ArrayList();
    private final HashSet zzHr = new HashSet();
    private final zzhg zzHs;
    private final Object zzpd = new Object();

    public zzhn(Context context, String s, zzhs.zza zza1, zzhg zzhg1)
    {
        mContext = context;
        zzGY = s;
        zzDe = zza1;
        zzHs = zzhg1;
    }

    static zzhg zza(zzhn zzhn1)
    {
        return zzhn1.zzHs;
    }

    private void zzk(String s, String s1)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        zzhh zzhh1 = zzHs.zzau(s);
        if (zzhh1 == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        if (zzhh1.zzgd() != null && zzhh1.zzgc() != null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        s1 = new zzhi(mContext, s, zzGY, s1, zzDe, zzhh1, this);
        zzHp.add(s1.zzgz());
        zzHq.add(s);
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void onStop()
    {
    }

    public void zzav(String s)
    {
        synchronized (zzpd)
        {
            zzHr.add(s);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void zzb(String s, int i)
    {
    }

    public void zzbn()
    {
        int i;
        for (Iterator iterator = zzDe.zzHx.zzyW.iterator(); iterator.hasNext();)
        {
            Object obj3 = (zzed)iterator.next();
            String s = ((zzed) (obj3)).zzyT;
            obj3 = ((zzed) (obj3)).zzyO.iterator();
            while (((Iterator) (obj3)).hasNext()) 
            {
                zzk((String)((Iterator) (obj3)).next(), s);
            }
        }

        i = 0;
_L2:
        if (i >= zzHp.size())
        {
            break MISSING_BLOCK_LABEL_361;
        }
        ((Future)zzHp.get(i)).get();
label0:
        {
            synchronized (zzpd)
            {
                if (!zzHr.contains(zzHq.get(i)))
                {
                    break label0;
                }
                Object obj2 = (String)zzHq.get(i);
                obj2 = new zzhs(zzDe.zzHC.zzEn, null, zzDe.zzHD.zzyY, -2, zzDe.zzHD.zzyZ, zzDe.zzHD.zzEM, zzDe.zzHD.orientation, zzDe.zzHD.zzzc, zzDe.zzHC.zzEq, zzDe.zzHD.zzEK, (zzed)zzDe.zzHx.zzyW.get(i), null, ((String) (obj2)), zzDe.zzHx, null, zzDe.zzHD.zzEL, zzDe.zzqn, zzDe.zzHD.zzEJ, zzDe.zzHz, zzDe.zzHD.zzEO, zzDe.zzHD.zzEP, zzDe.zzHw, null);
                zza.zzJt.post(new _cls1(((zzhs) (obj2))));
            }
            return;
        }
        obj;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_545;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        Object obj1;
        obj1;
        zzhs zzhs1 = new zzhs(zzDe.zzHC.zzEn, null, zzDe.zzHD.zzyY, 3, zzDe.zzHD.zzyZ, zzDe.zzHD.zzEM, zzDe.zzHD.orientation, zzDe.zzHD.zzzc, zzDe.zzHC.zzEq, zzDe.zzHD.zzEK, null, null, null, zzDe.zzHx, null, zzDe.zzHD.zzEL, zzDe.zzqn, zzDe.zzHD.zzEJ, zzDe.zzHz, zzDe.zzHD.zzEO, zzDe.zzHD.zzEP, zzDe.zzHw, null);
        zza.zzJt.post(new _cls2(zzhs1));
        return;
        zzhs1;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}

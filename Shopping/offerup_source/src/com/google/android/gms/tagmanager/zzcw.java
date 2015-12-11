// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzl

class zzcw
    implements zzl
{

    private final Map zzaZh = new HashMap();
    private final int zzaZi;
    private final zzm.zza zzaZj;
    private int zzaZk;

    zzcw(int i, zzm.zza zza)
    {
        zzaZi = i;
        zzaZj = zza;
    }

    public Object get(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        obj = zzaZh.get(obj);
        this;
        JVM INSTR monitorexit ;
        return obj;
        obj;
        throw obj;
    }

    public void zzf(Object obj, Object obj1)
    {
        this;
        JVM INSTR monitorenter ;
        if (obj != null && obj1 != null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        throw new NullPointerException("key == null || value == null");
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        zzaZk = zzaZk + zzaZj.sizeOf(obj, obj1);
        if (zzaZk > zzaZi)
        {
            Iterator iterator = zzaZh.entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                zzaZk = zzaZk - zzaZj.sizeOf(entry.getKey(), entry.getValue());
                iterator.remove();
            } while (zzaZk > zzaZi);
        }
        zzaZh.put(obj, obj1);
        this;
        JVM INSTR monitorexit ;
    }
}

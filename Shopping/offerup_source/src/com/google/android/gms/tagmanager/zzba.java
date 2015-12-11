// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.util.LruCache;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzl

class zzba
    implements zzl
{

    private LruCache zzaXu;

    zzba(int i, zzm.zza zza)
    {
        zzaXu = new _cls1(i, zza);
    }

    public Object get(Object obj)
    {
        return zzaXu.get(obj);
    }

    public void zzf(Object obj, Object obj1)
    {
        zzaXu.put(obj, obj1);
    }

    private class _cls1 extends LruCache
    {

        final zzm.zza zzaXv;
        final zzba zzaXw;

        protected int sizeOf(Object obj, Object obj1)
        {
            return zzaXv.sizeOf(obj, obj1);
        }

        _cls1(int i, zzm.zza zza)
        {
            zzaXw = zzba.this;
            zzaXv = zza;
            super(i);
        }
    }

}

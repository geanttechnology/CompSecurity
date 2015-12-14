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

    private LruCache zzaMe;

    zzba(int i, zzm.zza zza)
    {
        zzaMe = new _cls1(i, zza);
    }

    public Object get(Object obj)
    {
        return zzaMe.get(obj);
    }

    public void zzf(Object obj, Object obj1)
    {
        zzaMe.put(obj, obj1);
    }

    private class _cls1 extends LruCache
    {

        final zzm.zza zzaMf;
        final zzba zzaMg;

        protected int sizeOf(Object obj, Object obj1)
        {
            return zzaMf.sizeOf(obj, obj1);
        }

        _cls1(int i, zzm.zza zza)
        {
            zzaMg = zzba.this;
            zzaMf = zza;
            super(i);
        }
    }

}

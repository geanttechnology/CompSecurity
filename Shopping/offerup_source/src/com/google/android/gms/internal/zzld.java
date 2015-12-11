// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;

public abstract class zzld
    implements zzlm.zzb
{

    private final DataHolder zzabq;

    protected zzld(DataHolder dataholder)
    {
        zzabq = dataholder;
    }

    protected abstract void zza(Object obj, DataHolder dataholder);

    public void zznN()
    {
        if (zzabq != null)
        {
            zzabq.close();
        }
    }

    public final void zzq(Object obj)
    {
        zza(obj, zzabq);
    }
}

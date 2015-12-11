// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Looper;
import com.google.android.gms.common.internal.zzx;

public final class zzlm
{

    private volatile Object mListener;
    private final zza zzacG;

    public zzlm(Looper looper, Object obj)
    {
        zzacG = new zza(looper);
        mListener = zzx.zzb(obj, "Listener must not be null");
    }

    public final void clear()
    {
        mListener = null;
    }

    public final void zza(zzb zzb1)
    {
        zzx.zzb(zzb1, "Notifier must not be null");
        zzb1 = zzacG.obtainMessage(1, zzb1);
        zzacG.sendMessage(zzb1);
    }

    final void zzb(zzb zzb1)
    {
        Object obj = mListener;
        if (obj == null)
        {
            zzb1.zznN();
            return;
        }
        try
        {
            zzb1.zzq(obj);
            return;
        }
        catch (RuntimeException runtimeexception)
        {
            zzb1.zznN();
            throw runtimeexception;
        }
    }

    private class zza extends Handler
    {

        final zzlm zzacH;

        public final void handleMessage(Message message)
        {
            boolean flag = true;
            if (message.what != 1)
            {
                flag = false;
            }
            zzx.zzaa(flag);
            zzacH.zzb((zzb)message.obj);
        }

        public zza(Looper looper)
        {
            zzacH = zzlm.this;
            super(looper);
        }
    }


    private class zzb
    {

        public abstract void zznN();

        public abstract void zzq(Object obj);
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.internal.zzv;

public final class zzi
{

    private volatile Object mListener;
    private final zza zzQQ;

    zzi(Looper looper, Object obj)
    {
        zzQQ = new zza(looper);
        mListener = zzv.zzb(obj, "Listener must not be null");
    }

    public void clear()
    {
        mListener = null;
    }

    public void zza(zzb zzb1)
    {
        zzv.zzb(zzb1, "Notifier must not be null");
        zzb1 = zzQQ.obtainMessage(1, zzb1);
        zzQQ.sendMessage(zzb1);
    }

    void zzb(zzb zzb1)
    {
        Object obj = mListener;
        if (obj == null)
        {
            zzb1.zzkJ();
            return;
        }
        try
        {
            zzb1.zzk(obj);
            return;
        }
        catch (RuntimeException runtimeexception)
        {
            zzb1.zzkJ();
            throw runtimeexception;
        }
    }

    private class zza extends Handler
    {

        final zzi zzQR;

        public void handleMessage(Message message)
        {
            boolean flag = true;
            if (message.what != 1)
            {
                flag = false;
            }
            zzv.zzQ(flag);
            zzQR.zzb((zzb)message.obj);
        }

        public zza(Looper looper)
        {
            zzQR = zzi.this;
            super(looper);
        }
    }


    private class zzb
    {

        public abstract void zzk(Object obj);

        public abstract void zzkJ();
    }

}

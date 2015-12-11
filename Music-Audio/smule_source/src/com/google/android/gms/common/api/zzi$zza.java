// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.internal.zzv;

// Referenced classes of package com.google.android.gms.common.api:
//            zzi

final class zzQR extends Handler
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
        zzQR.zzb((zzQR)message.obj);
    }

    public (zzi zzi1, Looper looper)
    {
        zzQR = zzi1;
        super(looper);
    }
}

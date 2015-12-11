// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

// Referenced classes of package com.google.android.gms.internal:
//            zzli

final class zzacr extends Handler
{

    final zzli zzacr;

    public final void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            Log.w("GoogleApiClientImpl", (new StringBuilder("Unknown message id: ")).append(message.what).toString());
            return;

        case 1: // '\001'
            zzli.zze(zzacr);
            return;

        case 2: // '\002'
            zzli.zzd(zzacr);
            return;

        case 3: // '\003'
            ((zzacr)message.obj).zzg(zzacr);
            return;

        case 4: // '\004'
            throw (RuntimeException)message.obj;
        }
    }

    (zzli zzli1, Looper looper)
    {
        zzacr = zzli1;
        super(looper);
    }
}

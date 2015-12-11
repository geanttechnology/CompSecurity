// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.internal:
//            zzlm

final class zzacH extends Handler
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
        zzacH.zzb((zzacH)message.obj);
    }

    public x(zzlm zzlm1, Looper looper)
    {
        zzacH = zzlm1;
        super(looper);
    }
}

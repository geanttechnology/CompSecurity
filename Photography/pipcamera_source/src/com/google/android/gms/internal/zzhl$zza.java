// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.google.android.gms.internal:
//            zzhl

final class <init> extends BroadcastReceiver
{

    final zzhl zzGn;

    public void onReceive(Context context, Intent intent)
    {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction()))
        {
            zzhl.zza(zzGn, true);
        } else
        if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()))
        {
            zzhl.zza(zzGn, false);
            return;
        }
    }

    private (zzhl zzhl1)
    {
        zzGn = zzhl1;
        super();
    }

    zzGn(zzhl zzhl1, zzGn zzgn)
    {
        this(zzhl1);
    }
}

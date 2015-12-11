// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.google.android.gms.internal:
//            zzid

final class <init> extends BroadcastReceiver
{

    final zzid zzIH;

    public final void onReceive(Context context, Intent intent)
    {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction()))
        {
            zzid.zza(zzIH, true);
        } else
        if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()))
        {
            zzid.zza(zzIH, false);
            return;
        }
    }

    private (zzid zzid1)
    {
        zzIH = zzid1;
        super();
    }

    zzIH(zzid zzid1, zzIH zzih)
    {
        this(zzid1);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.google.android.gms.d:
//            gm

private final class <init> extends BroadcastReceiver
{

    final gm a;

    public final void onReceive(Context context, Intent intent)
    {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction()))
        {
            gm.a(a, true);
        } else
        if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()))
        {
            gm.a(a, false);
            return;
        }
    }

    private ver(gm gm1)
    {
        a = gm1;
        super();
    }

    public ver(gm gm1, byte byte0)
    {
        this(gm1);
    }
}

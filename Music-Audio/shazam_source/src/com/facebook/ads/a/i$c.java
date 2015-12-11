// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.facebook.ads.a:
//            i

private final class <init> extends BroadcastReceiver
{

    final i a;

    public final void onReceive(Context context, Intent intent)
    {
        context = intent.getAction();
        if ("android.intent.action.SCREEN_OFF".equals(context))
        {
            i.h(a);
        } else
        if ("android.intent.action.SCREEN_ON".equals(context))
        {
            i.c(a);
            return;
        }
    }

    private (i j)
    {
        a = j;
        super();
    }

    stReceiver(i j, byte byte0)
    {
        this(j);
    }
}

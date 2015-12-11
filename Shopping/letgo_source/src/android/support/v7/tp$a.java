// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package android.support.v7:
//            tp

private final class <init> extends BroadcastReceiver
{

    final tp a;

    public void onReceive(Context context, Intent intent)
    {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction()))
        {
            tp.a(a, true);
        } else
        if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()))
        {
            tp.a(a, false);
            return;
        }
    }

    private tReceiver(tp tp1)
    {
        a = tp1;
        super();
    }

    tReceiver(tp tp1, tReceiver treceiver)
    {
        this(tp1);
    }
}

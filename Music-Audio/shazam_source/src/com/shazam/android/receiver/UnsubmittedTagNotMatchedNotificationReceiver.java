// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.shazam.i.b.ar.a.b;

public class UnsubmittedTagNotMatchedNotificationReceiver extends BroadcastReceiver
{

    private final com.shazam.android.al.b a;

    public UnsubmittedTagNotMatchedNotificationReceiver()
    {
        this(b.a());
    }

    public UnsubmittedTagNotMatchedNotificationReceiver(com.shazam.android.al.b b1)
    {
        a = b1;
    }

    public void onReceive(Context context, Intent intent)
    {
        String s = String.format("%s %s", new Object[] {
            context.getString(0x7f0900bc), context.getString(0x7f0900bd)
        });
        a.a(s, context.getString(0x7f090142), intent.getIntExtra("NumNoMatches", 0));
    }
}

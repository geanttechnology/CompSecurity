// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.shazam.android.fragment.b.b;
import com.shazam.i.b.w.a.a;

public class AutoTagMatchedReceiver extends BroadcastReceiver
{

    private final b a;

    public AutoTagMatchedReceiver()
    {
        this(com.shazam.i.b.w.a.a.a());
    }

    public AutoTagMatchedReceiver(b b1)
    {
        a = b1;
    }

    public static IntentFilter a(int i)
    {
        IntentFilter intentfilter = new IntentFilter("com.shazam.android.intent.actions.AUTO_TAG_BADGE_COUNT_CHANGED");
        intentfilter.setPriority(i);
        return intentfilter;
    }

    public void onReceive(Context context, Intent intent)
    {
        if (!intent.getBooleanExtra("extraAutoTagIsDupe", false))
        {
            a.b();
            context.sendOrderedBroadcast(new Intent("com.shazam.android.intent.actions.AUTO_TAG_BADGE_COUNT_CHANGED"), null);
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.shazam.android.wearcom.a;
import com.shazam.i.b.an.b;

public class WearableTagNotMatchedReceiver extends BroadcastReceiver
{

    private final a a = b.a();

    public WearableTagNotMatchedReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        context = intent.getStringExtra("nodeId");
        intent = a;
        com.shazam.android.wearcom.a.b.a a1 = new com.shazam.android.wearcom.a.b.a();
        a1.d = context;
        a1.a = "nomatch";
        intent.a(a1.a());
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tapjoy.internal.gf;

public class GCMReceiver extends BroadcastReceiver
{

    public GCMReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        boolean flag = gf.a(context).a(intent);
        if (isOrderedBroadcast())
        {
            setResult(-1, null, null);
            if (flag)
            {
                abortBroadcast();
            }
        }
    }
}

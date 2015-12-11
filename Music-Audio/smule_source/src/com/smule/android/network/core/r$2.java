// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

// Referenced classes of package com.smule.android.network.core:
//            r

final class init> extends BroadcastReceiver
{

    final Runnable a;

    public void onReceive(Context context, Intent intent)
    {
        Log.i(r.a(), "Network connectivity changed.");
        if (r.a(context))
        {
            Log.i(r.a(), "Network just connected");
            a.run();
        }
    }

    (Runnable runnable)
    {
        a = runnable;
        super();
    }
}

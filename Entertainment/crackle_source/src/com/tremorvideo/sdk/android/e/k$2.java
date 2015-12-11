// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.tremorvideo.sdk.android.e:
//            k

class <init> extends BroadcastReceiver
{

    final k a;
    private int b;

    public void onReceive(Context context, Intent intent)
    {
        if (intent.getAction().equals("android.intent.action.CONFIGURATION_CHANGED"))
        {
            int i = k.c(a);
            if (i != b)
            {
                b = i;
                k.a(a, b);
            }
        }
    }

    (k k1)
    {
        a = k1;
        super();
    }
}

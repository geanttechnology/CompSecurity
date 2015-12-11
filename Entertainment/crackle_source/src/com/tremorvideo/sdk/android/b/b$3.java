// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.tremorvideo.sdk.android.b:
//            b, a

class <init> extends BroadcastReceiver
{

    final b a;

    public void onReceive(Context context, Intent intent)
    {
        if (a.c)
        {
            b.a(a).d();
        }
    }

    (b b1)
    {
        a = b1;
        super();
    }
}

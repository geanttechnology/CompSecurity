// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia.a:
//            b, a

class a extends BroadcastReceiver
{

    final b a;

    public void onReceive(Context context, Intent intent)
    {
        a.c = true;
        b.a(a).k();
    }

    (b b1)
    {
        a = b1;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            i, a

class  extends BroadcastReceiver
{

    final i a;

    public void onReceive(Context context, Intent intent)
    {
        if (a.b)
        {
            i.a(a).d();
        }
    }

    (i j)
    {
        a = j;
        super();
    }
}

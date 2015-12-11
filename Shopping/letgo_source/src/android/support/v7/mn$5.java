// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package android.support.v7:
//            mn

class tReceiver extends BroadcastReceiver
{

    final mn a;

    public void onReceive(Context context, Intent intent)
    {
        a.b(false);
    }

    tReceiver(mn mn1)
    {
        a = mn1;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.socialin.android.net:
//            c, b

final class iver extends BroadcastReceiver
{

    private c a;

    public final void onReceive(Context context, Intent intent)
    {
        if (a.c != null)
        {
            a.c.a(intent);
        }
    }

    iver(c c1)
    {
        a = c1;
        super();
    }
}

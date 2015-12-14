// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.clipart;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.socialin.android.photo.clipart:
//            c

final class d extends BroadcastReceiver
{

    private c a;

    private d(c c1)
    {
        a = c1;
        super();
    }

    d(c c1, byte byte0)
    {
        this(c1);
    }

    public final void onReceive(Context context, Intent intent)
    {
        if (c.b(a) != null && !c.b(a).isFinishing())
        {
            c.q(a);
        }
    }
}

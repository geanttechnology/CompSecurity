// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.b.a.a.j;

// Referenced classes of package com.offerup.android.activities:
//            k

final class x extends BroadcastReceiver
{

    private k a;

    private x(k k1)
    {
        a = k1;
        super();
    }

    x(k k1, byte byte0)
    {
        this(k1);
    }

    public final void onReceive(Context context, Intent intent)
    {
        k.a(a, j.a().c());
    }
}

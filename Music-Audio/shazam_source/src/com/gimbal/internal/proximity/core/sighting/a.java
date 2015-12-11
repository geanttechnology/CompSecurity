// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.sighting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.gimbal.internal.c.c;
import com.gimbal.internal.proximity.core.f.d;
import java.util.ArrayList;

// Referenced classes of package com.gimbal.internal.proximity.core.sighting:
//            h, Sighting, b

public class a extends BroadcastReceiver
    implements h
{

    private static final com.gimbal.a.a a = com.gimbal.internal.c.c.e(com/gimbal/internal/proximity/core/sighting/a.getName());
    private d b;
    private b c;
    private Context d;

    public a(Context context, b b1)
    {
        d = context;
        c = b1;
        new c();
        b = new d();
        new ArrayList();
        if (d != null)
        {
            context = new IntentFilter();
            context.addAction("com.qrs.gimbalproximity.SHOULD_DELETE_SESSION_DATA");
            d.registerReceiver(this, context);
        }
        com.gimbal.internal.proximity.core.d.a.a("Analytics");
    }

    public final void a(Sighting sighting)
    {
        (new StringBuilder("Received Sighting:")).append(sighting);
        if (sighting != null && sighting.getPayload() != null)
        {
            c.a(sighting);
        }
    }

    public void onReceive(Context context, Intent intent)
    {
        intent.getAction();
        if ("com.qrs.gimbalproximity.SHOULD_DELETE_SESSION_DATA".equals(intent.getAction()))
        {
            b.a();
        }
    }

    static 
    {
        com.gimbal.internal.c.c.f(com/gimbal/internal/proximity/core/sighting/a.getName());
    }
}

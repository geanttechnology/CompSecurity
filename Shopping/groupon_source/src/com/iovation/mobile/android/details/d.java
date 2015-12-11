// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.iovation.mobile.android.details;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

// Referenced classes of package com.iovation.mobile.android.details:
//            i, j

public class d
    implements i
{

    public d()
    {
    }

    public void a(Context context, j j1)
    {
        context = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int k = context.getIntExtra("level", -1);
        int l = context.getIntExtra("scale", -1);
        j1.a("BATL", Float.toString((float)k / (float)l));
    }
}

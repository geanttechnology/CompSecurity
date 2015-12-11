// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.ads.a.b.t;
import com.facebook.ads.a.b.u;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.facebook.ads:
//            k

private final class <init> extends BroadcastReceiver
{

    boolean a;
    final k b;

    public final void onReceive(Context context, Intent intent)
    {
        context = intent.getAction().split(":")[0];
        if ("com.facebook.ads.native.impression".equals(context))
        {
            k.g(b).a();
        } else
        if ("com.facebook.ads.native.click".equals(context))
        {
            context = new HashMap();
            context.put("mil", Boolean.valueOf(true));
            k.e(b).b(context);
            return;
        }
    }

    private t(k k1)
    {
        b = k1;
        super();
    }

    castReceiver(k k1, byte byte0)
    {
        this(k1);
    }
}

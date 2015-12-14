// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.uma;

import android.content.Context;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.uma:
//            UMA, g, f

final class a extends Thread
{

    final Context a;

    public void run()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("google_play_advertising_id", g.d(a));
        hashmap.put("android_id", g.b(a));
        Log.v("UMA", (new StringBuilder()).append("ID: ").append(hashmap).toString());
        UMA.a("_UMA_ID", hashmap, 1, 0.0D);
        UMA.c().c();
    }

    (Context context)
    {
        a = context;
        super();
    }
}

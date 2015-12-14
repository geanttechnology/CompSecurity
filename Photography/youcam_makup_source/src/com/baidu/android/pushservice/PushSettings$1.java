// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.android.pushservice;

import android.content.Context;
import com.baidu.android.pushservice.apiproxy.BridgePushSettings;

// Referenced classes of package com.baidu.android.pushservice:
//            PushSettings, LoadExecutor

class b extends Thread
{

    private final Context a;
    private final boolean b;

    public void run()
    {
        if (!LoadExecutor.loadPush(a))
        {
            return;
        } else
        {
            BridgePushSettings.enableDebugMode(a, b);
            return;
        }
    }

    PushSettings(Context context, boolean flag)
    {
        a = context;
        b = flag;
        super();
    }
}

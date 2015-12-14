// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.android.pushservice;

import android.content.Context;
import com.baidu.android.pushservice.apiproxy.BridgePushManager;

// Referenced classes of package com.baidu.android.pushservice:
//            PushManager

class a
    implements Runnable
{

    private final Context a;

    public void run()
    {
        BridgePushManager.disableLbs(a);
    }

    PushManager(Context context)
    {
        a = context;
        super();
    }
}

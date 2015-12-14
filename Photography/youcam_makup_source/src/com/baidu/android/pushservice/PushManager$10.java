// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.android.pushservice;

import android.content.Context;
import com.baidu.android.pushservice.apiproxy.BridgePushManager;

// Referenced classes of package com.baidu.android.pushservice:
//            PushManager

class c
    implements Runnable
{

    private final Context a;
    private final int b;
    private final int c;

    public void run()
    {
        BridgePushManager.fetchMessages(a, b, c);
    }

    PushManager(Context context, int i, int j)
    {
        a = context;
        b = i;
        c = j;
        super();
    }
}

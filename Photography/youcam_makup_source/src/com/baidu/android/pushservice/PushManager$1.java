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
    private final String b;
    private final String c;

    public void run()
    {
        BridgePushManager.init(a, b, c);
    }

    ePushManager(Context context, String s, String s1)
    {
        a = context;
        b = s;
        c = s1;
        super();
    }
}

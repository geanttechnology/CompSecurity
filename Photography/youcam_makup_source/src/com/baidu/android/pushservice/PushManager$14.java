// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.android.pushservice;

import android.content.Context;
import com.baidu.android.pushservice.apiproxy.BridgePushManager;

// Referenced classes of package com.baidu.android.pushservice:
//            PushManager

class e
    implements Runnable
{

    private final Context a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;

    public void run()
    {
        BridgePushManager.sendMsgToUser(a, b, c, d, e);
    }

    PushManager(Context context, String s, String s1, String s2, String s3)
    {
        a = context;
        b = s;
        c = s1;
        d = s2;
        e = s3;
        super();
    }
}

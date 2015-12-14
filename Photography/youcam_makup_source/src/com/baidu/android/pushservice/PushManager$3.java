// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.android.pushservice;

import android.app.Activity;
import com.baidu.android.pushservice.apiproxy.BridgePushManager;

// Referenced classes of package com.baidu.android.pushservice:
//            PushManager

class a
    implements Runnable
{

    private final Activity a;

    public void run()
    {
        BridgePushManager.activityStoped(a);
    }

    ePushManager(Activity activity)
    {
        a = activity;
        super();
    }
}

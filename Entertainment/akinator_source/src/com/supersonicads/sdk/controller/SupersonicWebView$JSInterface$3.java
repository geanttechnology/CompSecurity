// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.controller;

import android.util.Log;
import com.supersonicads.sdk.listeners.OnRewardedVideoListener;

// Referenced classes of package com.supersonicads.sdk.controller:
//            SupersonicWebView

class val.message
    implements Runnable
{

    final ail this$1;
    final String val$message;

    public void run()
    {
        String s1 = val$message;
        String s = s1;
        if (s1 == null)
        {
            s = "We're sorry, some error occurred. we will investigate it";
        }
        Log.d(SupersonicWebView.access$300(_fld0), (new StringBuilder()).append("onRVInitFail(message:").append(val$message).append(")").toString());
        SupersonicWebView.access$2300(_fld0).onRVInitFail(s);
    }

    ()
    {
        this$1 = final_;
        val$message = String.this;
        super();
    }
}

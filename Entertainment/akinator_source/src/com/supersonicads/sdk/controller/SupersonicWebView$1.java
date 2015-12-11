// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.controller;

import android.os.CountDownTimer;
import com.supersonicads.sdk.utils.Logger;

// Referenced classes of package com.supersonicads.sdk.controller:
//            SupersonicWebView

class this._cls0 extends CountDownTimer
{

    final SupersonicWebView this$0;

    public void onFinish()
    {
        Logger.i(SupersonicWebView.access$300(SupersonicWebView.this), "Global Controller Timer Finish");
        SupersonicWebView.access$902(SupersonicWebView.this, true);
    }

    public void onTick(long l)
    {
        Logger.i(SupersonicWebView.access$300(SupersonicWebView.this), (new StringBuilder()).append("Global Controller Timer Tick ").append(l).toString());
    }

    (long l, long l1)
    {
        this$0 = SupersonicWebView.this;
        super(l, l1);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.controller;

import android.os.CountDownTimer;
import com.supersonicads.sdk.utils.Logger;

// Referenced classes of package com.supersonicads.sdk.controller:
//            SupersonicWebView

class this._cls1 extends CountDownTimer
{

    final is._cls0 this$1;

    public void onFinish()
    {
        Logger.i(SupersonicWebView.access$300(_fld0), "Close Event Timer Finish");
        if (SupersonicWebView.access$700(_fld0))
        {
            SupersonicWebView.access$702(_fld0, false);
            return;
        } else
        {
            engageEnd("forceClose");
            return;
        }
    }

    public void onTick(long l)
    {
        Logger.i(SupersonicWebView.access$300(_fld0), (new StringBuilder()).append("Close Event Timer Tick ").append(l).toString());
    }

    Y(long l, long l1)
    {
        this$1 = this._cls1.this;
        super(l, l1);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.controller;

import android.util.Log;
import com.supersonicads.sdk.listeners.OnInterstitialListener;

// Referenced classes of package com.supersonicads.sdk.controller:
//            SupersonicWebView

class this._cls1
    implements Runnable
{

    final tialInitSuccess this$1;

    public void run()
    {
        Log.d(SupersonicWebView.access$300(_fld0), "onInterstitialInitSuccess()");
        SupersonicWebView.access$2700(_fld0).onInterstitialInitSuccess();
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}

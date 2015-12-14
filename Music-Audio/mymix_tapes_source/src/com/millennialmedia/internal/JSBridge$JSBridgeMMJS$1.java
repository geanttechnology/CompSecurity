// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import com.millennialmedia.MMLog;
import com.millennialmedia.internal.utils.Utils;

// Referenced classes of package com.millennialmedia.internal:
//            JSBridge, MMWebView

class val.mmWebView
    implements com.millennialmedia.internal.utils.stener
{

    final val.callbackId this$1;
    final String val$callbackId;
    final MMWebView val$mmWebView;

    public void onError(String s)
    {
        MMLog.e(JSBridge.access$000(), s);
        invokeCallback(val$callbackId, new Object[] {
            Boolean.valueOf(false)
        });
    }

    public void onSuccess()
    {
        Utils.showToast(val$mmWebView.getContext(), "Event added to calendar");
        invokeCallback(val$callbackId, new Object[] {
            Boolean.valueOf(true)
        });
    }

    public void onUIDisplayed()
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), "Calendar activity started");
        }
        JSBridge.access$300(_fld0).onAdLeftApplication();
        invokeCallback(val$callbackId, new Object[] {
            Boolean.valueOf(true)
        });
    }

    r()
    {
        this$1 = final_r;
        val$callbackId = s;
        val$mmWebView = MMWebView.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.controller;

import com.supersonicads.sdk.listeners.OnGenericFunctionListener;

// Referenced classes of package com.supersonicads.sdk.controller:
//            SupersonicWebView

class val.message
    implements Runnable
{

    final val.message this$1;
    final String val$message;

    public void run()
    {
        SupersonicWebView.access$5200(_fld0).onGFFail(val$message);
    }

    ()
    {
        this$1 = final_;
        val$message = String.this;
        super();
    }
}

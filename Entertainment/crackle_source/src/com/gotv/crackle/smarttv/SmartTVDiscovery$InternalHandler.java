// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.smarttv;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.gotv.crackle.smarttv:
//            SmartTVDiscovery

private class <init> extends Handler
{

    final SmartTVDiscovery this$0;

    public void handleMessage(Message message)
    {
        updateDeviceList();
    }

    private ()
    {
        this$0 = SmartTVDiscovery.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

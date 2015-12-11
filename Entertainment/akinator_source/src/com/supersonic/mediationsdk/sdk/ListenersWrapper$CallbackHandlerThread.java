// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk.sdk;

import android.os.Handler;
import android.os.Looper;

// Referenced classes of package com.supersonic.mediationsdk.sdk:
//            ListenersWrapper

private class <init> extends Thread
{

    private Handler mCallbackHandler;
    final ListenersWrapper this$0;

    public Handler getCallbackHandler()
    {
        return mCallbackHandler;
    }

    public void run()
    {
        Looper.prepare();
        mCallbackHandler = new Handler();
        Looper.loop();
    }

    private ()
    {
        this$0 = ListenersWrapper.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

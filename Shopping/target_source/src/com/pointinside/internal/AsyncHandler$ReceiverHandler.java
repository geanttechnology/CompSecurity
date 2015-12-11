// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.internal;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.pointinside.internal:
//            AsyncHandler

private class <init> extends Handler
{

    final AsyncHandler this$0;

    public void handleMessage(Message message)
    {
        onWorkComplete(message.what, message.obj);
    }

    private ()
    {
        this$0 = AsyncHandler.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

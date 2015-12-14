// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;


// Referenced classes of package com.millennialmedia.internal:
//            JSBridge

class val.onFinishCallbackId
    implements com.millennialmedia.internal.utils.FinishCallbackId
{

    final val.onStartCallbackId this$1;
    final String val$onFinishCallbackId;
    final String val$onStartCallbackId;

    public void onError()
    {
        invokeCallback(val$onFinishCallbackId, new Object[] {
            Boolean.valueOf(false)
        });
    }

    public void onFinished()
    {
        invokeCallback(val$onFinishCallbackId, new Object[] {
            Boolean.valueOf(true)
        });
    }

    public void onStarted()
    {
        invokeCallback(val$onStartCallbackId, new Object[0]);
    }

    ner()
    {
        this$1 = final_ner;
        val$onStartCallbackId = s;
        val$onFinishCallbackId = String.this;
        super();
    }
}

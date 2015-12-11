// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package com.pointinside.internal:
//            AsyncHandler

protected class this._cls0 extends Handler
{

    final AsyncHandler this$0;

    public void handleMessage(Message message)
    {
        int i = message.what;
        Object obj = (this._cls0)message.obj;
        message = ((Message) (doInWorkerThread(i, ((ad) (obj)).ams)));
        obj = ((ams) (obj)).eiver.obtainMessage();
        obj.what = i;
        obj.obj = message;
        ((Message) (obj)).sendToTarget();
    }

    public _cls9(Looper looper)
    {
        this$0 = AsyncHandler.this;
        super(looper);
    }
}

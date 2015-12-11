// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import co.vine.android.util.CrashUtil;

// Referenced classes of package co.vine.android.service:
//            RealTimeChatService

private class mResponder
    implements Runnable
{

    private final int mActionCode;
    private final Bundle mBundle;
    private final Messenger mResponder;
    final RealTimeChatService this$0;

    public void run()
    {
        Message message;
        Process.setThreadPriority(10);
        RealTimeChatService.access$1200(RealTimeChatService.this, mActionCode, mBundle);
        if (!mBundle.getBoolean("respond", true))
        {
            break MISSING_BLOCK_LABEL_61;
        }
        message = Message.obtain();
        message.what = mActionCode;
        message.setData(mBundle);
        mResponder.send(message);
        return;
        Exception exception;
        exception;
        CrashUtil.logException(exception, "Error sending service response", new Object[0]);
        return;
    }

    public (int i, Bundle bundle, Messenger messenger)
    {
        this$0 = RealTimeChatService.this;
        super();
        mActionCode = i;
        mBundle = bundle;
        mResponder = messenger;
    }
}

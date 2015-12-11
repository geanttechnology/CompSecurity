// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import co.vine.android.util.CrashUtil;

// Referenced classes of package co.vine.android.service:
//            VineService

private class mStartId
    implements Runnable
{

    private final int mActionCode;
    private final Bundle mBundle;
    private final String mReasonPhrase;
    private final Messenger mResponder;
    private final int mStartId;
    private final int mStatusCode;
    final VineService this$0;

    public void run()
    {
        if (mResponder != null)
        {
            Message message = new Message();
            message.what = mActionCode;
            message.arg1 = mStatusCode;
            Bundle bundle = message.getData();
            bundle.putString("reason_phrase", mReasonPhrase);
            bundle.putAll(mBundle);
            try
            {
                mResponder.send(message);
            }
            catch (Exception exception)
            {
                CrashUtil.logException(exception, "Error sending service response", new Object[0]);
            }
        }
        if (mStartId > 0)
        {
            attemptStop(mStartId);
        }
    }

    public (Messenger messenger, int i, int j, String s, Bundle bundle, int k)
    {
        this$0 = VineService.this;
        super();
        mResponder = messenger;
        mActionCode = i;
        mStatusCode = j;
        mReasonPhrase = s;
        mBundle = bundle;
        mStartId = k;
    }
}

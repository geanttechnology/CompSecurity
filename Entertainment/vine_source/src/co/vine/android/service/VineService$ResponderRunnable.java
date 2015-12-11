// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import android.os.Bundle;

// Referenced classes of package co.vine.android.service:
//            VineService, VineServiceResponder

private class mStartId
    implements Runnable
{

    private final int mActionCode;
    private final Bundle mBundle;
    private final String mReasonPhrase;
    private final VineServiceResponder mResponder;
    private final int mStartId;
    private final int mStatusCode;
    final VineService this$0;

    public void run()
    {
        if (mResponder != null)
        {
            mResponder.onServiceResponse(mActionCode, mStatusCode, mReasonPhrase, mBundle);
        }
        if (mStartId > 0)
        {
            attemptStop(mStartId);
        }
    }

    public (VineServiceResponder vineserviceresponder, int i, int j, String s, Bundle bundle, int k)
    {
        this$0 = VineService.this;
        super();
        mResponder = vineserviceresponder;
        mActionCode = i;
        mStatusCode = j;
        mReasonPhrase = s;
        mBundle = bundle;
        mStartId = k;
    }
}

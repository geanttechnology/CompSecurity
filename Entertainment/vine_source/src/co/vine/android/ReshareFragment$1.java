// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import co.vine.android.client.AppController;

// Referenced classes of package co.vine.android:
//            CaptchaRequestHelper, ReshareFragment, PendingCaptchaRequest

class er extends CaptchaRequestHelper
{

    final ReshareFragment this$0;

    protected void handleFailedCaptchaRequest(PendingCaptchaRequest pendingcaptcharequest)
    {
        pendingcaptcharequest = mAppController.generateReqIdForCanceledCaptcha();
        mAppController.failRequest(pendingcaptcharequest, mPendingCaptchaRequest.actionCode, mPendingCaptchaRequest.bundle);
    }

    protected void handleRetryCaptchaRequest(PendingCaptchaRequest pendingcaptcharequest)
    {
        mAppController.retryRequest(mPendingCaptchaRequest.actionCode, mPendingCaptchaRequest.bundle);
    }

    est()
    {
        this$0 = ReshareFragment.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;


// Referenced classes of package co.vine.android:
//            CaptchaRequestHelper, PendingRequestHelper, PendingCaptchaRequest

class nit> extends CaptchaRequestHelper
{

    final PendingRequestHelper this$0;

    protected void handleFailedCaptchaRequest(PendingCaptchaRequest pendingcaptcharequest)
    {
        PendingRequestHelper.this.handleFailedCaptchaRequest(pendingcaptcharequest);
    }

    protected void handleRetryCaptchaRequest(PendingCaptchaRequest pendingcaptcharequest)
    {
        PendingRequestHelper.this.handleRetryCaptchaRequest(pendingcaptcharequest);
    }

    ()
    {
        this$0 = PendingRequestHelper.this;
        super();
    }
}

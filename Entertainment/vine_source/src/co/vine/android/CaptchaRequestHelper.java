// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

// Referenced classes of package co.vine.android:
//            PendingCaptchaRequest, CaptchaActivity

public abstract class CaptchaRequestHelper
{

    public static final int REQUEST_CODE_CAPTCHA = 11;
    protected static final String STATE_PENDING_CAPTCHA_REQUEST = "state_pending_captcha_request";
    protected PendingCaptchaRequest mPendingCaptchaRequest;

    public CaptchaRequestHelper()
    {
    }

    protected abstract void handleFailedCaptchaRequest(PendingCaptchaRequest pendingcaptcharequest);

    public void handlePendingCaptchaRequest()
    {
        if (mPendingCaptchaRequest == null) goto _L2; else goto _L1
_L1:
        if (mPendingCaptchaRequest.state != 3) goto _L4; else goto _L3
_L3:
        handleFailedCaptchaRequest(mPendingCaptchaRequest);
_L6:
        mPendingCaptchaRequest = null;
_L2:
        return;
_L4:
        if (mPendingCaptchaRequest.state == 2)
        {
            handleRetryCaptchaRequest(mPendingCaptchaRequest);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected abstract void handleRetryCaptchaRequest(PendingCaptchaRequest pendingcaptcharequest);

    public boolean onActivityResult(int i, int j, Intent intent)
    {
        switch (i)
        {
        default:
            return false;

        case 11: // '\013'
            break;
        }
        if (mPendingCaptchaRequest == null || intent == null) goto _L2; else goto _L1
_L1:
        intent = intent.getStringExtra("rid");
        if (j != -1 || !intent.equals(mPendingCaptchaRequest.reqId)) goto _L4; else goto _L3
_L3:
        mPendingCaptchaRequest.state = 2;
_L2:
        return true;
_L4:
        if (j == 2 && intent.equals(mPendingCaptchaRequest.reqId))
        {
            mPendingCaptchaRequest.state = 3;
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void onCaptchaRequired(Activity activity, String s, int i, Bundle bundle, String s1)
    {
        setPendingCaptchaRequest(new PendingCaptchaRequest(s, i, bundle));
        if (activity != null)
        {
            activity.startActivityForResult(CaptchaActivity.getIntent(activity, s1, s), 11);
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putParcelable("state_pending_captcha_request", mPendingCaptchaRequest);
    }

    public void restorePendingCaptchaRequest(Bundle bundle)
    {
        mPendingCaptchaRequest = (PendingCaptchaRequest)bundle.getParcelable("state_pending_captcha_request");
    }

    public void setPendingCaptchaRequest(PendingCaptchaRequest pendingcaptcharequest)
    {
        mPendingCaptchaRequest = pendingcaptcharequest;
    }
}

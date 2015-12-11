// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.graphics.Bitmap;
import android.net.http.SslError;
import com.amazon.android.webkit.AmazonWebView;
import com.amazon.identity.auth.device.token.TokenCallbackHelpers;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            AbstractMAPWebViewClient, MAPWebViewActivityInterface, MAPWebViewEventHelper, MAPWebViewHelper

public class MAPWebViewClient extends AbstractMAPWebViewClient
{

    private static final String LOG_TAG = com/amazon/identity/auth/device/api/MAPWebViewClient.getName();
    private final MAPWebViewActivityInterface mActivity;

    public MAPWebViewClient(MAPWebViewActivityInterface mapwebviewactivityinterface)
    {
        mActivity = mapwebviewactivityinterface;
    }

    public void handleSSLError(SslError sslerror)
    {
        MAPWebViewEventHelper.setError(TokenCallbackHelpers.getErrorBundle(MAPAccountManager.RegistrationError.NETWORK_FAILURE.value(), (new StringBuilder("SSL error: ")).append(sslerror.toString()).toString()), mActivity.getEventCallback());
    }

    public void onPageStarted(AmazonWebView amazonwebview, String s, Bitmap bitmap)
    {
        String s1 = LOG_TAG;
        if (mActivity.getWebWebViewHelper().handleAuthentication(mActivity.getActivity(), s))
        {
            return;
        } else
        {
            super.onPageStarted(amazonwebview, s, bitmap);
            return;
        }
    }

    public boolean shouldOverrideUrlLoading(AmazonWebView amazonwebview, String s)
    {
        String s1 = LOG_TAG;
        super.shouldOverrideUrlLoading(amazonwebview, s);
        return mActivity.getWebWebViewHelper().handleAuthentication(mActivity.getActivity(), s);
    }

}

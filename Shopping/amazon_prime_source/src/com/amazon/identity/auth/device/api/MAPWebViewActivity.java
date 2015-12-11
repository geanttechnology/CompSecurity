// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.app.Activity;
import android.os.Bundle;
import com.amazon.android.webkit.AmazonWebView;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            MAPWebViewActivityInterface, MAPWebViewHelper, AmazonWebViewUtils, Callback

public abstract class MAPWebViewActivity extends Activity
    implements MAPWebViewActivityInterface
{

    private static final String LOG_TAG = com/amazon/identity/auth/device/api/MAPWebViewActivity.getName();
    public MAPWebViewHelper mWebViewHelper;

    public MAPWebViewActivity()
    {
    }

    public Activity getActivity()
    {
        return this;
    }

    public final Callback getAuthActivityCallback()
    {
        return new Callback() {

            final MAPWebViewActivity this$0;

            public void onError(Bundle bundle)
            {
                handleAuthResultError(bundle);
            }

            public void onSuccess(Bundle bundle)
            {
                handleAuthSuccessResult(bundle);
            }

            
            {
                this$0 = MAPWebViewActivity.this;
                super();
            }
        };
    }

    public Callback getEventCallback()
    {
        return null;
    }

    public Bundle getOptions()
    {
        return null;
    }

    public abstract AmazonWebView getWebView();

    public final MAPWebViewHelper getWebWebViewHelper()
    {
        return mWebViewHelper;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        AmazonWebViewUtils.initAmazonWebViewFactory(this);
        mWebViewHelper = new MAPWebViewHelper(this, getWebView(), getEventCallback(), getAuthActivityCallback(), getOptions());
        mWebViewHelper.handleOnCreate(this, bundle);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        mWebViewHelper.saveInstanceState(bundle);
    }

    protected void setParseOptionsFromURL(boolean flag)
    {
        mWebViewHelper.setParseUrl(flag);
    }



}

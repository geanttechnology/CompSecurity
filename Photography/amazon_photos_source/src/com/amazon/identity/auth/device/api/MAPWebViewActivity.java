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
                String s = 
// JavaClassFileOutputException: get_constant: invalid tag

            public void onSuccess(Bundle bundle)
            {
                String s = 
// JavaClassFileOutputException: get_constant: invalid tag

            
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
        onCreate(bundle);
        AmazonWebViewUtils.initAmazonWebViewFactory(this);
        mWebViewHelper = new MAPWebViewHelper(this, getWebView(), getEventCallback(), getAuthActivityCallback(), getOptions());
        String s = LOG_TAG;
        mWebViewHelper.handleOnCreate(this, bundle);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        onSaveInstanceState(bundle);
        mWebViewHelper.saveInstanceState(bundle);
    }

    protected void setParseOptionsFromURL(boolean flag)
    {
        mWebViewHelper.setParseUrl(flag);
    }



/*
    static void access$000(MAPWebViewActivity mapwebviewactivity, Bundle bundle)
    {
        String s = LOG_TAG;
        mapwebviewactivity.mWebViewHelper.handleAuthSuccessResult(bundle);
        return;
    }

*/


/*
    static void access$100(MAPWebViewActivity mapwebviewactivity, Bundle bundle)
    {
        String s = LOG_TAG;
        mapwebviewactivity.mWebViewHelper.handleAuthResultError(bundle);
        return;
    }

*/
}

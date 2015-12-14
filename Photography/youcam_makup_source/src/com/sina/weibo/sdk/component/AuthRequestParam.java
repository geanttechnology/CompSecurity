// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.WeiboAuthListener;

// Referenced classes of package com.sina.weibo.sdk.component:
//            BrowserRequestParamBase, BrowserLauncher, WeiboSdkBrowser, WeiboCallbackManager

public class AuthRequestParam extends BrowserRequestParamBase
{

    public static final String EXTRA_KEY_AUTHINFO = "key_authinfo";
    public static final String EXTRA_KEY_LISTENER = "key_listener";
    private AuthInfo mAuthInfo;
    private WeiboAuthListener mAuthListener;
    private String mAuthListenerKey;

    public AuthRequestParam(Context context)
    {
        super(context);
        mLaucher = BrowserLauncher.AUTH;
    }

    public void execRequest(Activity activity, int i)
    {
        if (i == 3)
        {
            if (mAuthListener != null)
            {
                mAuthListener.onCancel();
            }
            WeiboSdkBrowser.closeBrowser(activity, mAuthListenerKey, null);
        }
    }

    public AuthInfo getAuthInfo()
    {
        return mAuthInfo;
    }

    public WeiboAuthListener getAuthListener()
    {
        return mAuthListener;
    }

    public String getAuthListenerKey()
    {
        return mAuthListenerKey;
    }

    public void onCreateRequestParamBundle(Bundle bundle)
    {
        if (mAuthInfo != null)
        {
            bundle.putBundle("key_authinfo", mAuthInfo.getAuthBundle());
        }
        if (mAuthListener != null)
        {
            WeiboCallbackManager weibocallbackmanager = WeiboCallbackManager.getInstance(mContext);
            mAuthListenerKey = weibocallbackmanager.genCallbackKey();
            weibocallbackmanager.setWeiboAuthListener(mAuthListenerKey, mAuthListener);
            bundle.putString("key_listener", mAuthListenerKey);
        }
    }

    protected void onSetupRequestParam(Bundle bundle)
    {
        Bundle bundle1 = bundle.getBundle("key_authinfo");
        if (bundle1 != null)
        {
            mAuthInfo = AuthInfo.parseBundleData(mContext, bundle1);
        }
        mAuthListenerKey = bundle.getString("key_listener");
        if (!TextUtils.isEmpty(mAuthListenerKey))
        {
            mAuthListener = WeiboCallbackManager.getInstance(mContext).getWeiboAuthListener(mAuthListenerKey);
        }
    }

    public void setAuthInfo(AuthInfo authinfo)
    {
        mAuthInfo = authinfo;
    }

    public void setAuthListener(WeiboAuthListener weiboauthlistener)
    {
        mAuthListener = weiboauthlistener;
    }
}

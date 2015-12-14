// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.WeiboAuthListener;

// Referenced classes of package com.sina.weibo.sdk.component:
//            BrowserRequestParamBase, BrowserLauncher, WeiboCallbackManager

public class GameRequestParam extends BrowserRequestParamBase
{

    private String mAppKey;
    private WeiboAuthListener mAuthListener;
    private String mAuthListenerKey;
    private String mToken;

    public GameRequestParam(Context context)
    {
        super(context);
        mLaucher = BrowserLauncher.WIDGET;
    }

    private String buildUrl(String s)
    {
        s = Uri.parse(s).buildUpon();
        s.appendQueryParameter("version", "0031205000");
        if (!TextUtils.isEmpty(mAppKey))
        {
            s.appendQueryParameter("source", mAppKey);
        }
        if (!TextUtils.isEmpty(mToken))
        {
            s.appendQueryParameter("access_token", mToken);
        }
        return s.build().toString();
    }

    public void execRequest(Activity activity, int i)
    {
    }

    public String getAppKey()
    {
        return mAppKey;
    }

    public WeiboAuthListener getAuthListener()
    {
        return mAuthListener;
    }

    public String getAuthListenerKey()
    {
        return mAuthListenerKey;
    }

    public String getToken()
    {
        return mToken;
    }

    public void onCreateRequestParamBundle(Bundle bundle)
    {
        bundle.putString("access_token", mToken);
        bundle.putString("source", mAppKey);
        WeiboCallbackManager weibocallbackmanager = WeiboCallbackManager.getInstance(mContext);
        if (mAuthListener != null)
        {
            mAuthListenerKey = weibocallbackmanager.genCallbackKey();
            weibocallbackmanager.setWeiboAuthListener(mAuthListenerKey, mAuthListener);
            bundle.putString("key_listener", mAuthListenerKey);
        }
    }

    protected void onSetupRequestParam(Bundle bundle)
    {
        mAppKey = bundle.getString("source");
        mToken = bundle.getString("access_token");
        mAuthListenerKey = bundle.getString("key_listener");
        if (!TextUtils.isEmpty(mAuthListenerKey))
        {
            mAuthListener = WeiboCallbackManager.getInstance(mContext).getWeiboAuthListener(mAuthListenerKey);
        }
        mUrl = buildUrl(mUrl);
    }

    public void setAppKey(String s)
    {
        mAppKey = s;
    }

    public void setAuthListener(WeiboAuthListener weiboauthlistener)
    {
        mAuthListener = weiboauthlistener;
    }

    public void setToken(String s)
    {
        mToken = s;
    }
}

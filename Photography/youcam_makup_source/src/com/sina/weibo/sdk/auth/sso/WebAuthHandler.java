// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.auth.sso;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.component.AuthRequestParam;
import com.sina.weibo.sdk.component.WeiboSdkBrowser;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.NetworkHelper;
import com.sina.weibo.sdk.utils.UIUtils;
import com.sina.weibo.sdk.utils.Utility;

class WebAuthHandler
{

    private static final String NETWORK_NOT_AVAILABLE_EN = "Network is not available";
    private static final String NETWORK_NOT_AVAILABLE_ZH_CN = "\u65E0\u6CD5\u8FDE\u63A5\u5230\u7F51\u7EDC\uFF0C\u8BF7\u68C0\u67E5\u7F51\u7EDC\u914D\u7F6E";
    private static final String NETWORK_NOT_AVAILABLE_ZH_TW = "\u7121\u6CD5\u9023\u63A5\u5230\u7DB2\u7EDC\uFF0C\u8ACB\u6AA2\u67E5\u7DB2\u7EDC\u914D\u7F6E";
    private static final String OAUTH2_BASE_URL = "https://open.weibo.cn/oauth2/authorize?";
    private static final int OBTAIN_AUTH_CODE = 0;
    private static final int OBTAIN_AUTH_TOKEN = 1;
    private static final String TAG = com/sina/weibo/sdk/auth/sso/WebAuthHandler.getName();
    private AuthInfo mAuthInfo;
    private Context mContext;

    public WebAuthHandler(Context context, AuthInfo authinfo)
    {
        mContext = context;
        mAuthInfo = authinfo;
    }

    private void startDialog(WeiboAuthListener weiboauthlistener, int i)
    {
        if (weiboauthlistener == null)
        {
            return;
        }
        Object obj = new WeiboParameters(mAuthInfo.getAppKey());
        ((WeiboParameters) (obj)).put("client_id", mAuthInfo.getAppKey());
        ((WeiboParameters) (obj)).put("redirect_uri", mAuthInfo.getRedirectUrl());
        ((WeiboParameters) (obj)).put("scope", mAuthInfo.getScope());
        ((WeiboParameters) (obj)).put("response_type", "code");
        ((WeiboParameters) (obj)).put("version", "0031205000");
        String s = Utility.getAid(mContext, mAuthInfo.getAppKey());
        if (!TextUtils.isEmpty(s))
        {
            ((WeiboParameters) (obj)).put("aid", s);
        }
        if (1 == i)
        {
            ((WeiboParameters) (obj)).put("packagename", mAuthInfo.getPackageName());
            ((WeiboParameters) (obj)).put("key_hash", mAuthInfo.getKeyHash());
        }
        obj = (new StringBuilder("https://open.weibo.cn/oauth2/authorize?")).append(((WeiboParameters) (obj)).encodeUrl()).toString();
        if (!NetworkHelper.hasInternetPermission(mContext))
        {
            UIUtils.showAlert(mContext, "Error", "Application requires permission to access the Internet");
            return;
        } else
        {
            AuthRequestParam authrequestparam = new AuthRequestParam(mContext);
            authrequestparam.setAuthInfo(mAuthInfo);
            authrequestparam.setAuthListener(weiboauthlistener);
            authrequestparam.setUrl(((String) (obj)));
            authrequestparam.setSpecifyTitle("\u5FAE\u535A\u767B\u5F55");
            weiboauthlistener = authrequestparam.createRequestParamBundle();
            obj = new Intent(mContext, com/sina/weibo/sdk/component/WeiboSdkBrowser);
            ((Intent) (obj)).putExtras(weiboauthlistener);
            mContext.startActivity(((Intent) (obj)));
            return;
        }
    }

    public void anthorize(WeiboAuthListener weiboauthlistener)
    {
        authorize(weiboauthlistener, 1);
    }

    public void authorize(WeiboAuthListener weiboauthlistener, int i)
    {
        startDialog(weiboauthlistener, i);
    }

    public AuthInfo getAuthInfo()
    {
        return mAuthInfo;
    }

}

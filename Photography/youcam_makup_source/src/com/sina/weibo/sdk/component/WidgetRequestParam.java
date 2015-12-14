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
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.Utility;

// Referenced classes of package com.sina.weibo.sdk.component:
//            BrowserRequestParamBase, BrowserLauncher, WeiboSdkBrowser, WeiboCallbackManager

public class WidgetRequestParam extends BrowserRequestParamBase
{

    public static final String EXTRA_KEY_WIDGET_CALLBACK = "key_widget_callback";
    public static final String REQ_PARAM_ATTENTION_FUID = "fuid";
    public static final String REQ_PARAM_COMMENT_CATEGORY = "category";
    public static final String REQ_PARAM_COMMENT_CONTENT = "content";
    public static final String REQ_PARAM_COMMENT_TOPIC = "q";
    private String mAppKey;
    private String mAppPackage;
    private String mAttentionFuid;
    private WeiboAuthListener mAuthListener;
    private String mAuthListenerKey;
    private String mCommentCategory;
    private String mCommentContent;
    private String mCommentTopic;
    private String mHashKey;
    private String mToken;
    private WidgetRequestCallback mWidgetRequestCallback;
    private String mWidgetRequestCallbackKey;

    public WidgetRequestParam(Context context)
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
        String s1 = Utility.getAid(mContext, mAppKey);
        if (!TextUtils.isEmpty(s1))
        {
            s.appendQueryParameter("aid", s1);
        }
        if (!TextUtils.isEmpty(mAppPackage))
        {
            s.appendQueryParameter("packagename", mAppPackage);
        }
        if (!TextUtils.isEmpty(mHashKey))
        {
            s.appendQueryParameter("key_hash", mHashKey);
        }
        if (!TextUtils.isEmpty(mAttentionFuid))
        {
            s.appendQueryParameter("fuid", mAttentionFuid);
        }
        if (!TextUtils.isEmpty(mCommentTopic))
        {
            s.appendQueryParameter("q", mCommentTopic);
        }
        if (!TextUtils.isEmpty(mCommentContent))
        {
            s.appendQueryParameter("content", mCommentContent);
        }
        if (!TextUtils.isEmpty(mCommentCategory))
        {
            s.appendQueryParameter("category", mCommentCategory);
        }
        return s.build().toString();
    }

    public void execRequest(Activity activity, int i)
    {
        if (i == 3)
        {
            WeiboSdkBrowser.closeBrowser(activity, mAuthListenerKey, mWidgetRequestCallbackKey);
        }
    }

    public String getAppKey()
    {
        return mAppKey;
    }

    public String getAttentionFuid()
    {
        return mAttentionFuid;
    }

    public WeiboAuthListener getAuthListener()
    {
        return mAuthListener;
    }

    public String getAuthListenerKey()
    {
        return mAuthListenerKey;
    }

    public String getCommentCategory()
    {
        return mCommentCategory;
    }

    public String getCommentContent()
    {
        return mCommentContent;
    }

    public String getCommentTopic()
    {
        return mCommentTopic;
    }

    public String getToken()
    {
        return mToken;
    }

    public WidgetRequestCallback getWidgetRequestCallback()
    {
        return mWidgetRequestCallback;
    }

    public String getWidgetRequestCallbackKey()
    {
        return mWidgetRequestCallbackKey;
    }

    public void onCreateRequestParamBundle(Bundle bundle)
    {
        mAppPackage = mContext.getPackageName();
        if (!TextUtils.isEmpty(mAppPackage))
        {
            mHashKey = MD5.hexdigest(Utility.getSign(mContext, mAppPackage));
        }
        bundle.putString("access_token", mToken);
        bundle.putString("source", mAppKey);
        bundle.putString("packagename", mAppPackage);
        bundle.putString("key_hash", mHashKey);
        bundle.putString("fuid", mAttentionFuid);
        bundle.putString("q", mCommentTopic);
        bundle.putString("content", mCommentContent);
        bundle.putString("category", mCommentCategory);
        WeiboCallbackManager weibocallbackmanager = WeiboCallbackManager.getInstance(mContext);
        if (mAuthListener != null)
        {
            mAuthListenerKey = weibocallbackmanager.genCallbackKey();
            weibocallbackmanager.setWeiboAuthListener(mAuthListenerKey, mAuthListener);
            bundle.putString("key_listener", mAuthListenerKey);
        }
        if (mWidgetRequestCallback != null)
        {
            mWidgetRequestCallbackKey = weibocallbackmanager.genCallbackKey();
            weibocallbackmanager.setWidgetRequestCallback(mWidgetRequestCallbackKey, mWidgetRequestCallback);
            bundle.putString("key_widget_callback", mWidgetRequestCallbackKey);
        }
    }

    protected void onSetupRequestParam(Bundle bundle)
    {
        mAppKey = bundle.getString("source");
        mAppPackage = bundle.getString("packagename");
        mHashKey = bundle.getString("key_hash");
        mToken = bundle.getString("access_token");
        mAttentionFuid = bundle.getString("fuid");
        mCommentTopic = bundle.getString("q");
        mCommentContent = bundle.getString("content");
        mCommentCategory = bundle.getString("category");
        mAuthListenerKey = bundle.getString("key_listener");
        if (!TextUtils.isEmpty(mAuthListenerKey))
        {
            mAuthListener = WeiboCallbackManager.getInstance(mContext).getWeiboAuthListener(mAuthListenerKey);
        }
        mWidgetRequestCallbackKey = bundle.getString("key_widget_callback");
        if (!TextUtils.isEmpty(mWidgetRequestCallbackKey))
        {
            mWidgetRequestCallback = WeiboCallbackManager.getInstance(mContext).getWidgetRequestCallback(mWidgetRequestCallbackKey);
        }
        mUrl = buildUrl(mUrl);
    }

    public void setAppKey(String s)
    {
        mAppKey = s;
    }

    public void setAttentionFuid(String s)
    {
        mAttentionFuid = s;
    }

    public void setAuthListener(WeiboAuthListener weiboauthlistener)
    {
        mAuthListener = weiboauthlistener;
    }

    public void setCommentCategory(String s)
    {
        mCommentCategory = s;
    }

    public void setCommentContent(String s)
    {
        mCommentContent = s;
    }

    public void setCommentTopic(String s)
    {
        mCommentTopic = s;
    }

    public void setToken(String s)
    {
        mToken = s;
    }

    public void setWidgetRequestCallback(WidgetRequestCallback widgetrequestcallback)
    {
        mWidgetRequestCallback = widgetrequestcallback;
    }
}

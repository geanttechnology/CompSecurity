// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;

// Referenced classes of package com.sina.weibo.sdk.component:
//            BrowserLauncher

public abstract class BrowserRequestParamBase
{

    public static final int EXEC_REQUEST_ACTION_CANCEL = 3;
    public static final int EXEC_REQUEST_ACTION_ERROR = 2;
    public static final int EXEC_REQUEST_ACTION_OK = 1;
    public static final String EXTRA_KEY_LAUNCHER = "key_launcher";
    protected static final String EXTRA_KEY_SPECIFY_TITLE = "key_specify_title";
    protected static final String EXTRA_KEY_URL = "key_url";
    protected Context mContext;
    protected BrowserLauncher mLaucher;
    protected String mSpecifyTitle;
    protected String mUrl;

    public BrowserRequestParamBase(Context context)
    {
        mContext = context.getApplicationContext();
    }

    public Bundle createRequestParamBundle()
    {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(mUrl))
        {
            bundle.putString("key_url", mUrl);
        }
        if (mLaucher != null)
        {
            bundle.putSerializable("key_launcher", mLaucher);
        }
        if (!TextUtils.isEmpty(mSpecifyTitle))
        {
            bundle.putString("key_specify_title", mSpecifyTitle);
        }
        onCreateRequestParamBundle(bundle);
        return bundle;
    }

    public abstract void execRequest(Activity activity, int i);

    public BrowserLauncher getLauncher()
    {
        return mLaucher;
    }

    public String getSpecifyTitle()
    {
        return mSpecifyTitle;
    }

    public String getUrl()
    {
        return mUrl;
    }

    protected abstract void onCreateRequestParamBundle(Bundle bundle);

    protected abstract void onSetupRequestParam(Bundle bundle);

    public void setLauncher(BrowserLauncher browserlauncher)
    {
        mLaucher = browserlauncher;
    }

    public void setSpecifyTitle(String s)
    {
        mSpecifyTitle = s;
    }

    public void setUrl(String s)
    {
        mUrl = s;
    }

    public void setupRequestParam(Bundle bundle)
    {
        mUrl = bundle.getString("key_url");
        mLaucher = (BrowserLauncher)bundle.getSerializable("key_launcher");
        mSpecifyTitle = bundle.getString("key_specify_title");
        onSetupRequestParam(bundle);
    }
}

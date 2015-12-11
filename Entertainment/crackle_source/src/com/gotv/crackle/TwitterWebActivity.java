// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.gotv.crackle.base.BaseActivity;
import com.gotv.crackle.data.TwitterWebClient;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class TwitterWebActivity extends BaseActivity
{

    public static final String SHARE_ITEM_TITLE = "share_title";
    public static final String SHARE_LINK = "share_link";
    private ProgressBar mProgress;
    private WebView mWebView;

    public TwitterWebActivity()
    {
    }

    public void onAppSdkEvent(long l, int i, String s)
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03007a);
        Object obj = getIntent();
        mProgress = (ProgressBar)findViewById(0x7f0a0198);
        mWebView = (WebView)findViewById(0x7f0a0197);
        mWebView.setWebViewClient(new TwitterWebClient(this, mProgress));
        bundle = ((Intent) (obj)).getStringExtra("share_link");
        obj = ((Intent) (obj)).getStringExtra("share_title");
        bundle = (new StringBuilder()).append(getResources().getString(0x7f0b00c1)).append(" ").append(((String) (obj))).append(" ").append(getResources().getString(0x7f0b00c2)).append(" ").append(bundle).toString();
        try
        {
            mWebView.loadUrl((new StringBuilder()).append("https://twitter.com/intent/tweet?status=").append(URLEncoder.encode(bundle, "UTF-8")).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            return;
        }
    }

    protected void performMenuAction(int i)
    {
    }
}

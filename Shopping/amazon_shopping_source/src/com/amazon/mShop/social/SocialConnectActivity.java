// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.social;

import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import com.amazon.mShop.actionBar.ActionBarHelper;
import com.amazon.mShop.mash.nav.AmazonNavManager;
import com.amazon.mShop.web.MShopModalWebActivity;
import com.amazon.mShop.web.MShopWebViewClient;
import com.amazon.mShop.web.MShopWebViewContainer;
import org.apache.cordova.CordovaInterface;

// Referenced classes of package com.amazon.mShop.social:
//            SocialConnectHelper

public class SocialConnectActivity extends MShopModalWebActivity
{
    private class SocialNavManager extends AmazonNavManager
    {

        final SocialConnectActivity this$0;

        protected void handleDismissAll(WebView webview, Uri uri)
        {
            SocialConnectActivity socialconnectactivity = SocialConnectActivity.this;
            boolean flag;
            if (uri != null && uri.getQueryParameter("do_not_show_again") != null && "1".equals(uri.getQueryParameter("do_not_show_again")))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            socialconnectactivity.mSocialConnectDoNotShowAgain = flag;
            super.handleDismissAll(webview, uri);
        }

        private SocialNavManager()
        {
            this$0 = SocialConnectActivity.this;
            super();
        }

    }

    private class SocialWebViewClient extends MShopWebViewClient
    {

        final SocialConnectActivity this$0;

        public SocialWebViewClient(CordovaInterface cordovainterface)
        {
            this$0 = SocialConnectActivity.this;
            super(cordovainterface, new SocialNavManager());
        }
    }


    private boolean mSocialConnectDoNotShowAgain;

    public SocialConnectActivity()
    {
    }

    protected MShopWebViewClient createWebViewClient()
    {
        return new SocialWebViewClient(this);
    }

    protected MShopWebViewContainer createWebViewContainer()
    {
        return new MShopWebViewContainer(this, null, createWebViewClient(), this);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setStopBehavior(0);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        SocialConnectHelper.socialConnectFinished(mSocialConnectDoNotShowAgain);
    }

    protected void onResume()
    {
        super.onResume();
        ActionBarHelper.hideActionBar(this);
    }

    public boolean onSearchRequested()
    {
        return false;
    }

    public boolean onSearchRequested(String s, boolean flag)
    {
        return false;
    }

    protected void registerPushNotification()
    {
    }

    protected void updateGNOMenuItems()
    {
    }


/*
    static boolean access$002(SocialConnectActivity socialconnectactivity, boolean flag)
    {
        socialconnectactivity.mSocialConnectDoNotShowAgain = flag;
        return flag;
    }

*/
}

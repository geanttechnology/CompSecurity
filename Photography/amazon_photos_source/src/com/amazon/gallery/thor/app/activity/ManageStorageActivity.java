// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.webkit.WebView;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.network.http.rest.account.SubscriptionInfoCache;
import com.amazon.gallery.thor.view.PhotosNavigationPane;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            AuthenticatedWebViewActivity

public class ManageStorageActivity extends AuthenticatedWebViewActivity
{
    private class JSManageStorageInterface
    {

        final ManageStorageActivity this$0;

        public void campaignReady()
        {
            runOnUiThread(new Runnable() {

                final JSManageStorageInterface this$1;

                public void run()
                {
                    onPageReady();
                }

            
            {
                this$1 = JSManageStorageInterface.this;
                super();
            }
            });
        }

        public void close()
        {
            finish();
        }

        private JSManageStorageInterface()
        {
            this$0 = ManageStorageActivity.this;
            super();
        }

    }


    private static final String JS_INTERFACE_NAME = "PhotosClient";
    private PhotosNavigationPane navPane;

    public ManageStorageActivity()
    {
    }

    protected void initNavBar(TagDao tagdao, MediaItemDao mediaitemdao)
    {
        super.initNavBar(tagdao, mediaitemdao);
        navPane = (PhotosNavigationPane)findViewById(0x7f0c014e);
    }

    public void onPause()
    {
        if (getWebView().getVisibility() == 0)
        {
            ((SubscriptionInfoCache)getApplicationBean(Keys.SUBSCRIPTION_INFO_CACHE)).fetchAllAsync(null);
        }
        getWebView().removeJavascriptInterface("PhotosClient");
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        if (navPane != null)
        {
            navPane.select(0x7f0c0272);
        }
        getWebView().addJavascriptInterface(new JSManageStorageInterface(), "PhotosClient");
    }
}

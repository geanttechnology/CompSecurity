// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.fastBrowse;

import android.app.Activity;
import android.content.res.Resources;
import android.net.Uri;
import android.webkit.WebView;
import com.amazon.mShop.gno.GNODrawer;
import com.amazon.mShop.navigation.AppNavigator;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.Maps;
import com.amazon.mShop.web.MShopWebViewContainer;
import com.amazon.retailsearch.android.categoryBrowse.CategoryBrowseController;

// Referenced classes of package com.amazon.mShop.fastBrowse:
//            FastBrowseActivity

class this._cls0
    implements com.amazon.retailsearch.android.fastBrowse.BackUrlListener
{

    final FastBrowseActivity this$0;

    public void onBlockGno()
    {
        getGNODrawer().lock();
    }

    public void onCloseGno()
    {
        getGNODrawer().close();
        getWebViewContainer().setVisibility(4);
    }

    public void onReturn(String s)
    {
        s = CategoryBrowseController.buildCategoryBrowseLink(Uri.parse(s));
        calcWebviewStartTime();
        FastBrowseActivity.access$000(FastBrowseActivity.this);
        if (s.contains("/s/browse/categories"))
        {
            FastBrowseActivity.access$102(FastBrowseActivity.this, true);
            getWebViewContainer().setVisibility(4);
        } else
        {
            FastBrowseActivity.access$102(FastBrowseActivity.this, false);
            getWebView().loadUrl(s);
            getWebViewContainer().setVisibility(0);
        }
        FastBrowseActivity.access$200(FastBrowseActivity.this, s);
    }

    public void onReturnAIV()
    {
        AppNavigator.navigate(getActivity(), com.amazon.mShop.navigation.iv_webview, Maps.of("url", getActivity().getResources().getString(com.amazon.mShop.android.lib.nu_aiv_url), "forceClearHistory", Boolean.valueOf(false)));
    }

    public void onReturnAPP()
    {
        ActivityUtils.startAppstoreActivity(getActivity(), com.amazon.mShop.navigation.as_gateway.ame());
    }

    public void onUnblockGno()
    {
        getGNODrawer().unlock();
    }

    tegoryBrowseController()
    {
        this$0 = FastBrowseActivity.this;
        super();
    }
}

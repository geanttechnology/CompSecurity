// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.categoryBrowse;

import android.content.Intent;
import android.text.TextUtils;
import android.webkit.WebBackForwardList;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.amazon.mShop.search.ScopedSearch;
import com.amazon.mShop.util.Util;
import com.amazon.mShop.web.MShopWebActivity;
import com.amazon.mShop.web.MShopWebViewContainer;
import com.amazon.mobile.mash.constants.WebConstants;
import com.amazon.retailsearch.android.categoryBrowse.CategoryBrowseController;
import com.amazon.retailsearch.android.fastBrowse.RefinementsLoader;
import com.amazon.searchapp.retailsearch.model.RefinementLink;
import com.amazon.searchapp.retailsearch.model.SearchResult;
import com.amazon.searchapp.retailsearch.model.TrackingInfo;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.cordova.Config;

// Referenced classes of package com.amazon.mShop.categoryBrowse:
//            CategoryMetadata

public class CategoryBrowseActivity extends MShopWebActivity
    implements ScopedSearch
{

    private ConcurrentHashMap mMetadataCache;

    public CategoryBrowseActivity()
    {
        mMetadataCache = new ConcurrentHashMap();
    }

    protected MShopWebViewContainer createWebViewContainer()
    {
        MShopWebViewContainer mshopwebviewcontainer = super.createWebViewContainer();
        String s = String.format("%s Mobile", new Object[] {
            mshopwebviewcontainer.getWebView().getSettings().getUserAgentString()
        });
        mshopwebviewcontainer.getWebView().getSettings().setUserAgentString(s);
        return mshopwebviewcontainer;
    }

    public CategoryMetadata getCategoryMetadata()
    {
        if (mMetadataCache != null && getWebViewContainer() != null && getWebView() != null && !TextUtils.isEmpty(getWebView().getUrl()))
        {
            return (CategoryMetadata)mMetadataCache.get(getWebView().getUrl());
        } else
        {
            return null;
        }
    }

    public int getCurrentDepartmentDepth()
    {
        WebBackForwardList webbackforwardlist = getWebView().copyBackForwardList();
        if (webbackforwardlist == null)
        {
            return -1;
        } else
        {
            return webbackforwardlist.getSize() - 1;
        }
    }

    public void getSearchMetadata(final String url)
    {
        if (mMetadataCache.get(url) != null)
        {
            return;
        } else
        {
            (new Thread(new Runnable() {

                final CategoryBrowseActivity this$0;
                final String val$url;

                public void run()
                {
                    (new RefinementsLoader(new com.amazon.retailsearch.android.fastBrowse.RefinementsLoader.RefinementResultListener() {

                        final _cls1 this$1;

                        public void onError(Exception exception)
                        {
                        }

                        public void onResult(SearchResult searchresult)
                        {
                            if (searchresult != null && searchresult.getTrackingInfo() != null && searchresult.getRefinements() != null)
                            {
                                RefinementLink refinementlink = CategoryBrowseController.getCurrentRefinement(searchresult.getRefinements());
                                if (refinementlink != null)
                                {
                                    mMetadataCache.put(url, new CategoryMetadata(refinementlink.getText(), refinementlink.getUrl(), searchresult.getTrackingInfo().getSearchAlias()));
                                }
                            }
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    }, url)).getRefinements();
                }

            
            {
                this$0 = CategoryBrowseActivity.this;
                url = s;
                super();
            }
            })).start();
            return;
        }
    }

    protected void onNewIntent(Intent intent)
    {
        setIntent(intent);
        Config.init(this);
        calcWebviewStartTime();
        intent = intent.getStringExtra(WebConstants.getWebViewUrlKey());
        if (!Util.isEmpty(intent))
        {
            if (intent.contains("/s/browse?node=aps"))
            {
                getWebView().clearHistory();
            }
            getWebView().stopLoading();
            getWebView().loadUrl(intent);
            getSearchMetadata(intent);
        }
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.fastBrowse;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebBackForwardList;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ViewAnimator;
import com.amazon.mShop.categoryBrowse.CategoryMetadata;
import com.amazon.mShop.gno.GNODrawer;
import com.amazon.mShop.navigation.AppNavigator;
import com.amazon.mShop.search.ScopedSearch;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.Maps;
import com.amazon.mShop.util.Util;
import com.amazon.mShop.web.MShopWebActivity;
import com.amazon.mShop.web.MShopWebViewContainer;
import com.amazon.mobile.mash.constants.WebConstants;
import com.amazon.retailsearch.android.categoryBrowse.CategoryBrowseController;
import com.amazon.retailsearch.android.fastBrowse.FastBrowseBaseView;
import com.amazon.retailsearch.android.fastBrowse.RefinementsLoader;
import com.amazon.searchapp.retailsearch.model.RefinementLink;
import com.amazon.searchapp.retailsearch.model.SearchResult;
import com.amazon.searchapp.retailsearch.model.TrackingInfo;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.cordova.Config;

public class FastBrowseActivity extends MShopWebActivity
    implements ScopedSearch
{

    private FastBrowseBaseView mBrowseBaseView;
    private View mBrowseView;
    private com.amazon.mShop.gno.GNODrawer.GNODrawerListener mGNODrawerListener;
    private boolean mIsRoot;
    private ConcurrentHashMap mMetadataCache;
    private com.amazon.retailsearch.android.fastBrowse.FastBrowseBaseView.OnBackUrlListener mOnBackUrlListener;

    public FastBrowseActivity()
    {
        mMetadataCache = new ConcurrentHashMap();
    }

    private void clearWebViewData()
    {
        getWebView().stopLoading();
        getWebViewContainer().clearHistory();
    }

    private void getSearchMetadata(final String url)
    {
        if (mMetadataCache.get(url) != null)
        {
            return;
        } else
        {
            (new Thread(new Runnable() {

                final FastBrowseActivity this$0;
                final String val$url;

                public void run()
                {
                    (new RefinementsLoader(new com.amazon.retailsearch.android.fastBrowse.RefinementsLoader.RefinementResultListener() {

                        final _cls3 this$1;

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
                this$1 = _cls3.this;
                super();
            }
                    }, url)).getRefinements();
                }

            
            {
                this$0 = FastBrowseActivity.this;
                url = s;
                super();
            }
            })).start();
            return;
        }
    }

    public void beginBackwardTransition(String s)
    {
    }

    public void beginForwardTransition(String s)
    {
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

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        if (4 == keyevent.getKeyCode() && keyevent.getAction() == 0 && mBrowseBaseView.isRightMenuOpen() && mBrowseBaseView.isRightMenuLock())
        {
            finish();
            return true;
        }
        if (4 == keyevent.getKeyCode() && keyevent.getAction() == 0 && mBrowseBaseView.isRightMenuOpen())
        {
            mBrowseBaseView.unlockAndCloseRightMenu();
            return true;
        }
        if (4 == keyevent.getKeyCode() && keyevent.getAction() == 0 && getGNODrawer().isClosed())
        {
            mBrowseBaseView.backOne(getWebView().getUrl());
            return true;
        } else
        {
            return super.dispatchKeyEvent(keyevent);
        }
    }

    public CategoryMetadata getCategoryMetadata()
    {
        if (!mIsRoot && mMetadataCache != null && getWebView() != null && !TextUtils.isEmpty(getWebView().getUrl()))
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
            return 0;
        } else
        {
            return webbackforwardlist.getSize();
        }
    }

    protected void initLayout()
    {
        super.initLayout();
        mBrowseView = (ViewGroup)getLayoutInflater().inflate(com.amazon.mShop.android.lib.R.layout.fast_browse_layout, null);
        mBrowseBaseView = (FastBrowseBaseView)mBrowseView.findViewById(com.amazon.mShop.android.lib.R.id.fastbrowse_view);
        mOnBackUrlListener = new com.amazon.retailsearch.android.fastBrowse.FastBrowseBaseView.OnBackUrlListener() {

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
                clearWebViewData();
                if (s.contains("/s/browse/categories"))
                {
                    mIsRoot = true;
                    getWebViewContainer().setVisibility(4);
                } else
                {
                    mIsRoot = false;
                    getWebView().loadUrl(s);
                    getWebViewContainer().setVisibility(0);
                }
                getSearchMetadata(s);
            }

            public void onReturnAIV()
            {
                AppNavigator.navigate(getActivity(), com.amazon.mShop.navigation.AppNavigator.Target.aiv_webview, Maps.of("url", getActivity().getResources().getString(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_url), "forceClearHistory", Boolean.valueOf(false)));
            }

            public void onReturnAPP()
            {
                ActivityUtils.startAppstoreActivity(getActivity(), com.amazon.mShop.navigation.AppNavigator.Target.mas_gateway.name());
            }

            public void onUnblockGno()
            {
                getGNODrawer().unlock();
            }

            
            {
                this$0 = FastBrowseActivity.this;
                super();
            }
        };
        mBrowseBaseView.useListener(mOnBackUrlListener);
        mGNODrawerListener = new com.amazon.mShop.gno.GNODrawer.GNODrawerListener() {

            final FastBrowseActivity this$0;

            public void onDrawerClosed(GNODrawer gnodrawer)
            {
                if (mBrowseBaseView.isListRoot())
                {
                    mBrowseBaseView.openAndLockRightMenu();
                }
            }

            public void onDrawerOpened(GNODrawer gnodrawer)
            {
                mBrowseBaseView.unlockAndCloseRightMenu();
            }

            public void onDrawerSlide(GNODrawer gnodrawer, float f)
            {
            }

            
            {
                this$0 = FastBrowseActivity.this;
                super();
            }
        };
        getGNODrawer().addListener(mGNODrawerListener);
        ViewAnimator viewanimator;
        ViewGroup viewgroup;
        if (!mIsRoot)
        {
            mBrowseBaseView.updateListView(getUrl());
            mBrowseBaseView.config();
        } else
        {
            mBrowseBaseView.load();
        }
        viewanimator = getViewAnimator();
        viewgroup = (ViewGroup)viewanimator.getParent();
        viewgroup.removeView(viewanimator);
        mBrowseBaseView.useView(viewanimator);
        viewgroup.addView(mBrowseView);
    }

    protected void loadUrl()
    {
        if (getUrl().contains("/s/browse?node=aps"))
        {
            mIsRoot = true;
            return;
        } else
        {
            mIsRoot = false;
            super.loadUrl();
            return;
        }
    }

    protected void onNewIntent(Intent intent)
    {
label0:
        {
            setIntent(intent);
            Config.init(this);
            calcWebviewStartTime();
            intent = intent.getStringExtra(WebConstants.getWebViewUrlKey());
            if (!Util.isEmpty(intent))
            {
                clearWebViewData();
                getWebView().loadUrl(intent);
                getSearchMetadata(intent);
                if (!intent.contains("/s/browse?node=aps"))
                {
                    break label0;
                }
                mIsRoot = true;
                mBrowseBaseView.updateListView(null);
            }
            return;
        }
        mIsRoot = false;
        mBrowseBaseView.updateListView(intent);
    }



/*
    static boolean access$102(FastBrowseActivity fastbrowseactivity, boolean flag)
    {
        fastbrowseactivity.mIsRoot = flag;
        return flag;
    }

*/



}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewAnimator;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonAlertDialog;
import com.amazon.mShop.actionBar.ActionBarHelper;
import com.amazon.mShop.android.platform.dex.SecondDexEntry;
import com.amazon.mShop.appstore.AppstoreUtils;
import com.amazon.mShop.barcodeSearch.BarcodeSearchResultsView;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.control.search.AdvSearchResultsBrowser;
import com.amazon.mShop.gno.GNODrawerHelper;
import com.amazon.mShop.net.PageMetricsObserver;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.search.image.SnapItSearchResultsView;
import com.amazon.mShop.sso.SSOUtil;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.Util;
import com.amazon.mShop.voice.MShopVoicePackageProxy;
import com.amazon.retailsearch.android.api.display.results.listeners.ResultItemSelectionListener;
import com.amazon.retailsearch.android.api.display.results.listeners.SearchChangedListener;
import com.amazon.retailsearch.android.api.query.RetailSearchQuery;
import com.amazon.retailsearch.android.ui.entry.RetailSearchEntryView;
import com.amazon.retailsearch.android.ui.results.ResultsDisplay;
import com.amazon.retailsearch.metrics.SearchMetricsListener;
import com.amazon.searchapp.retailsearch.client.SearchMethod;
import com.amazon.shopapp.voice.mshop.MShopVoiceModule;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.mShop.search:
//            AppStoreResultItemListener, ResultItemListener, RetailSearchEntryViewListener, SearchResultsContainer

public class SearchActivity extends AmazonActivity
    implements SearchChangedListener, SearchMetricsListener
{

    private static final String TAG = com/amazon/mShop/search/SearchActivity.getSimpleName();
    public static boolean downKeyFromSearch = false;
    private static String sDepartmentFilter = null;
    private static String sDepartmentName = null;
    private static String sDepartmentSearchUrl = null;
    private static Map sLocalizedSearchTerm = new HashMap();
    private static String sPreviousSearchTerm = null;
    private static String sSearchAlias = null;
    private static boolean sShouldShowBarcodeEntry = false;
    private PageMetricsObserver mATFPageMetricsObserver;
    private ResultsDisplay mResultsDisplay;
    private View mResultsDisplayLayout;
    private PageMetricsObserver mSRDSPageMetricsObserver;
    private RetailSearchEntryView mSearchEntryView;
    private ResultItemSelectionListener resultItemListener;

    public SearchActivity()
    {
        mATFPageMetricsObserver = null;
        mSRDSPageMetricsObserver = null;
    }

    private void adjustActionBar()
    {
        if (getCurrentView() instanceof RetailSearchEntryView)
        {
            ActionBarHelper.onOrientationChanged(this);
        }
    }

    public static void clearPreviousSearchTermForLocales(List list)
    {
        sPreviousSearchTerm = "";
        if (!Util.isEmpty(list))
        {
            String s;
            for (list = list.iterator(); list.hasNext(); sLocalizedSearchTerm.put(s, ""))
            {
                s = (String)list.next();
            }

        }
    }

    private boolean containsSearchResultsView(ViewGroup viewgroup)
    {
        boolean flag1 = false;
        int j = viewgroup.getChildCount();
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < j)
                {
                    if (!viewgroup.getChildAt(i).equals(mResultsDisplayLayout))
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i++;
        } while (true);
    }

    private ResultItemSelectionListener createResultItemListener()
    {
        if (AppstoreUtils.isAppstoreAvailable())
        {
            return new AppStoreResultItemListener(this);
        } else
        {
            return new ResultItemListener(this);
        }
    }

    private void doBarcodeSearch(String s, String s1)
    {
        View view = getCurrentView();
        if (view != null && (view instanceof BarcodeSearchResultsView))
        {
            super.popView(false, false);
        }
        setSearchRootView(new BarcodeSearchResultsView(this, s, s1, getBarcodeClickStreamOrigin()), false);
    }

    private void doImageSearch()
    {
        setSearchRootView(new SnapItSearchResultsView(this), false);
    }

    private String getBarcodeClickStreamOrigin()
    {
        if (getIntent().getBooleanExtra("barcodeActivatedFromHome", false))
        {
            return ClickStreamTag.ORIGIN_VIEW_IT_BARCODE_ACTIVATED_FROM_HOME.getTag();
        }
        if (getIntent().getBooleanExtra("barcodeActivatedFromDeepLink", false))
        {
            return ClickStreamTag.ORIGIN_VIEW_IT_BARCODE_ACTIVATED_FROM_DEEP_LINK.getTag();
        } else
        {
            return ClickStreamTag.ORIGIN_VIEW_IT_BARCODE_ACTIVATED_FROM_SEARCH.getTag();
        }
    }

    public static String getCurrentDepartmentFilter()
    {
        return sDepartmentFilter;
    }

    public static String getCurrentDepartmentName()
    {
        return sDepartmentName;
    }

    public static String getPreviousSearchTerm()
    {
        sPreviousSearchTerm = (String)sLocalizedSearchTerm.get(AppLocale.getInstance().getCurrentLocaleName());
        return sPreviousSearchTerm;
    }

    private ResultItemSelectionListener getResultItemListener()
    {
        this;
        JVM INSTR monitorenter ;
        ResultItemSelectionListener resultitemselectionlistener;
        if (resultItemListener == null)
        {
            resultItemListener = createResultItemListener();
        }
        resultitemselectionlistener = resultItemListener;
        this;
        JVM INSTR monitorexit ;
        return resultitemselectionlistener;
        Exception exception;
        exception;
        throw exception;
    }

    public static boolean getShouldShowBarcodeEntry()
    {
        return sShouldShowBarcodeEntry;
    }

    private void handleOnActivityResultFromSnapIt(int i)
    {
        if (1003 == i)
        {
            doImageSearch();
        } else
        if (i == 0 && super.getCurrentView() == null)
        {
            finish();
            return;
        }
    }

    private void initRetailSearchEntryView(RetailSearchEntryView retailsearchentryview, Intent intent)
    {
        boolean flag1 = true;
        boolean flag;
        boolean flag2;
        if (intent != null && intent.getData() != null && !"?".equals(intent.getDataString()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            intent = intent.getData().getQueryParameter("paramQueryText");
        } else
        {
            intent = null;
        }
        retailsearchentryview.setSearchTerm(intent);
        retailsearchentryview.setCurrentDepartmentName(getCurrentDepartmentName());
        retailsearchentryview.setSearchUrl(sDepartmentSearchUrl);
        retailsearchentryview.setSearchAlias(sSearchAlias);
        retailsearchentryview.setPreviousSearchTerm(getPreviousSearchTerm());
        flag2 = MShopVoiceModule.getInstance().voiceSearchInSuggestionsEnabled();
        retailsearchentryview.setVoiceEnabled(flag2);
        retailsearchentryview.setShowBarcodeEntry(true);
        retailsearchentryview.setFlowEnabled(false);
        retailsearchentryview.setHasSnapIt(false);
        retailsearchentryview.setShowVisualScan(false);
        retailsearchentryview.setListener(new RetailSearchEntryViewListener(this));
        if (ActivityUtils.isFlowEnabled(this))
        {
            retailsearchentryview.setFlowEnabled(true);
            intent = MShopVoiceModule.getInstance().flowButtonTreatment();
            if ("T1".equals(intent))
            {
                retailsearchentryview.setShowBarcodeEntry(false);
            } else
            if ("T2".equals(intent))
            {
                retailsearchentryview.setShowBarcodeEntry(false);
                retailsearchentryview.setShowVisualScan(true);
            } else
            {
                if (flag2)
                {
                    flag1 = false;
                }
                retailsearchentryview.setShowBarcodeEntry(flag1);
            }
        }
        retailsearchentryview.updateEntryView();
    }

    public static void setPreviousSearchTerm(String s)
    {
        sPreviousSearchTerm = s;
        sLocalizedSearchTerm.put(AppLocale.getInstance().getCurrentLocaleName(), s);
    }

    private void setSearchRootView(View view, boolean flag)
    {
        int i;
label0:
        {
            pushView(view, flag);
            view = getViewAnimator();
            i = view.getChildCount();
            if (i > 1)
            {
                view.setInAnimation(null);
                view.setOutAnimation(null);
                if (!(view.getChildAt(i - 2) instanceof RetailSearchEntryView))
                {
                    break label0;
                }
                view.removeViews(0, i - 2);
                view.setDisplayedChild(1);
            }
            return;
        }
        view.removeViews(0, i - 1);
        view.setDisplayedChild(0);
    }

    public static void setShouldShowBarcodeEntry(boolean flag)
    {
        sShouldShowBarcodeEntry = flag;
    }

    private void update()
    {
        Intent intent;
label0:
        {
            intent = getIntent();
            if (intent != null)
            {
                String s1 = intent.getStringExtra("clickStreamOrigin");
                String s = s1;
                if (Util.isEmpty(s1))
                {
                    s = ClickStreamTag.ORIGIN_SEARCH.getTag();
                }
                setClickStreamOrigin(s);
                if (!intent.getBooleanExtra("SHOW_SEARCH_ENTRY_VIEW", false))
                {
                    break label0;
                }
                updateCurrentDepartmentInfo(intent);
                setSearchEntryViewAsRoot(intent, false);
            }
            return;
        }
        doSearch(intent);
    }

    private void updateActionBarForSearch()
    {
        View view = findViewById(com.amazon.mShop.android.lib.R.id.action_bar_search);
        if (view != null)
        {
            view.setVisibility(8);
        }
    }

    public static void updateCurrentDepartmentInfo(Intent intent)
    {
        String s;
        String s1;
        String s2;
        if (intent == null)
        {
            break MISSING_BLOCK_LABEL_234;
        }
        s = intent.getStringExtra("CATEGORY_URL");
        s1 = intent.getStringExtra("CATEGORY_NAME");
        s2 = intent.getStringExtra("CATEGORY_ALIAS");
        if (Util.isEmpty(s) || Util.isEmpty(s1) || Util.isEmpty(s2)) goto _L2; else goto _L1
_L1:
        sDepartmentSearchUrl = s;
        sDepartmentName = s1;
        sSearchAlias = s2;
_L4:
        return;
_L2:
        String s3;
        sDepartmentSearchUrl = null;
        sDepartmentName = null;
        sSearchAlias = null;
        s = null;
        s3 = null;
        s2 = null;
        if (intent.getData() != null)
        {
            s = intent.getData().getQueryParameter("paramDepartmentFilter");
            s1 = intent.getData().getQueryParameter("paramDepartmentName");
            s3 = intent.getData().getQueryParameter("paramSuggestionDepartmentFilter");
            s2 = intent.getData().getQueryParameter("paramSuggestionDepartmentName");
        }
        boolean flag;
        if (intent != null && !Util.isEmpty(intent.getDataString()) && !"?".equals(intent.getDataString()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!Util.isEmpty(s) && !Util.isEmpty(s1) && !flag)
        {
            sDepartmentFilter = s;
            sDepartmentName = s1;
            return;
        }
        if (!Util.isEmpty(s) || !Util.isEmpty(s1) || !Util.isEmpty(s3) || !Util.isEmpty(s2)) goto _L4; else goto _L3
_L3:
        sDepartmentFilter = null;
        sDepartmentName = null;
        return;
        sDepartmentFilter = null;
        sDepartmentName = null;
        return;
    }

    private void updateSearchAsView(View view)
    {
label0:
        {
            if (view != null)
            {
                if (!(view instanceof RetailSearchEntryView))
                {
                    break label0;
                }
                updateSearchButton(false);
            }
            return;
        }
        if (view.equals(mResultsDisplayLayout))
        {
            updateSearchButton(false);
            return;
        }
        if ((view instanceof ViewGroup) && containsSearchResultsView((ViewGroup)view))
        {
            updateSearchButton(false);
            return;
        } else
        {
            updateSearchButton(true);
            return;
        }
    }

    private void updateSearchButton(boolean flag)
    {
        View view = findViewById(com.amazon.mShop.android.lib.R.id.action_bar_search);
        if (view != null)
        {
            int i;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            view.setVisibility(i);
            view.setOnClickListener(new android.view.View.OnClickListener() {

                final SearchActivity this$0;

                public void onClick(View view1)
                {
                    GNODrawerHelper.closeDrawerAndExecute(SearchActivity.this, true, new Runnable() {

                        final _cls3 this$1;

                        public void run()
                        {
                            setSearchEntryViewAsRoot(getIntent(), false);
                        }

            
            {
                this$1 = _cls3.this;
                super();
            }
                    });
                }

            
            {
                this$0 = SearchActivity.this;
                super();
            }
            });
        }
    }

    public static SearchResultsContainer wrapSearchBar(AmazonActivity amazonactivity, View view, String s)
    {
        if (view.getParent() != null && (view.getParent() instanceof ViewGroup))
        {
            ViewGroup viewgroup = (ViewGroup)view.getParent();
            if (viewgroup.indexOfChild(view) >= 0)
            {
                viewgroup.removeView(view);
            }
        }
        amazonactivity = new SearchResultsContainer(amazonactivity);
        amazonactivity.setSearchTerm(s);
        amazonactivity.setSearchResultView(view);
        amazonactivity.updateSearchBar(sDepartmentFilter, sDepartmentName);
        return amazonactivity;
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        if (keyevent.getAction() == 0)
        {
            downKeyFromSearch = true;
        }
        if (4 == keyevent.getKeyCode() && keyevent.getAction() == 0)
        {
            View view = getCurrentView();
            if (view != null && (view instanceof BarcodeSearchResultsView))
            {
                ActivityUtils.startBarcodeActivity(this, null);
                return true;
            }
        }
        return super.dispatchKeyEvent(keyevent);
    }

    public void doSearch(Intent intent)
    {
        Object obj;
        if ("android.intent.action.VIEW".equals(intent.getAction()))
        {
            obj = intent.getDataString();
            if (((String) (obj)).equals(""))
            {
                super.popToRoot();
                finish();
            } else
            {
                if (((String) (obj)).equals("BARCODE_SEARCH_QUERY_KEYWORD"))
                {
                    ActivityUtils.startBarcodeActivity(this, intent.getStringExtra("REFMARKER"));
                    return;
                }
                if (((String) (obj)).equals("IMAGE_SEARCH_QUERY_KEYWORD"))
                {
                    if (ActivityUtils.isFlowEnabled(this))
                    {
                        if (intent.getBooleanExtra("flowActivatedFromDeepLink", false))
                        {
                            ActivityUtils.startFlowActivity(this, ClickStreamTag.ORIGIN_VIEW_IT_FLOW_ACTIVATED_FROM_DEEP_LINK.getTag(), "deep_link_fl");
                            return;
                        } else
                        {
                            ActivityUtils.startFlowActivity(this, ClickStreamTag.ORIGIN_VIEW_IT_FLOW_ACTIVATED_FROM_SEARCH.getTag(), "sr_fl");
                            return;
                        }
                    } else
                    {
                        ActivityUtils.startSnapItActivity(this, "sr_snap");
                        return;
                    }
                }
                if (((String) (obj)).equals("VOICE_SEARCH_QUERY_KEYWORD"))
                {
                    try
                    {
                        MShopVoicePackageProxy.getInstance().openVoiceSearch(this, true);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Intent intent)
                    {
                        Log.e(TAG, "Failed to open voice search", intent);
                    }
                    return;
                }
            }
        }
        if (intent.getData() != null)
        {
            updateCurrentDepartmentInfo(intent);
            String s1 = AdvSearchResultsBrowser.validateQuery(intent.getData().getQueryParameter("paramQueryText"));
            Object obj2 = (RetailSearchQuery)intent.getParcelableExtra(RetailSearchQuery.INTENT_EXTRA_KEY);
            obj = intent.getData().getQueryParameter("paramDataUrl");
            if (!Util.isEmpty(((String) (obj))))
            {
                obj = RetailSearchQuery.fromUrl(((String) (obj)));
            } else
            {
                obj = obj2;
                if (obj2 == null)
                {
                    obj = obj2;
                    if (!Util.isEmpty(s1))
                    {
                        String s = intent.getData().getQueryParameter("paramDepartmentFilter");
                        obj = s;
                        if (Util.isEmpty(s))
                        {
                            obj = intent.getData().getQueryParameter("paramSuggestionDepartmentFilter");
                        }
                        s = ((String) (obj));
                        if (!Util.isEmpty(((String) (obj))))
                        {
                            String as[] = ((String) (obj)).split(":");
                            s = ((String) (obj));
                            if (as != null)
                            {
                                s = ((String) (obj));
                                if (as.length > 0)
                                {
                                    s = as[as.length - 1];
                                }
                            }
                        }
                        if (Util.isEmpty(s))
                        {
                            obj = new RetailSearchQuery(s1);
                        } else
                        {
                            obj = new RetailSearchQuery(s, s1);
                        }
                    }
                }
            }
            obj2 = SearchMethod.find(intent.getData().getQueryParameter("paramMethod"));
            if (obj != null && obj2 != null)
            {
                ((RetailSearchQuery) (obj)).setSearchMethod(((SearchMethod) (obj2)));
            }
            obj2 = intent.getData().getQueryParameter("paramAsrRequestId");
            if (!Util.isEmpty(((String) (obj2))))
            {
                ((RetailSearchQuery) (obj)).setAsrRequestId(((String) (obj2)));
            }
            intent = intent.getData().getQueryParameter("paramUtteranceId");
            if (!Util.isEmpty(intent))
            {
                ((RetailSearchQuery) (obj)).setUtteranceId(intent);
            }
            setPreviousSearchTerm(s1);
            setSearchRootView(wrapSearchBar(this, mResultsDisplayLayout, s1), true);
            mResultsDisplay.search(((RetailSearchQuery) (obj)));
            return;
        } else
        {
            updateCurrentDepartmentInfo(null);
            Object obj1 = AdvSearchResultsBrowser.validateQuery(intent.getStringExtra("query"));
            intent = ((Intent) (obj1));
            if (Util.isEmpty(((String) (obj1))))
            {
                intent = sPreviousSearchTerm;
                obj1 = getCurrentView();
                if (obj1 != null)
                {
                    ((View) (obj1)).setVisibility(4);
                }
                startSearch(sPreviousSearchTerm, true, null, false);
            }
            obj1 = new RetailSearchQuery(intent);
            setSearchRootView(wrapSearchBar(this, mResultsDisplayLayout, intent), true);
            mResultsDisplay.search(((RetailSearchQuery) (obj1)));
            return;
        }
    }

    public ClassLoader getClassLoader()
    {
        ClassLoader classloader1 = SecondDexEntry.getInstance().getClassLoader();
        ClassLoader classloader = classloader1;
        if (classloader1 == null)
        {
            classloader = super.getClassLoader();
        }
        return classloader;
    }

    protected void handleForceSignIn()
    {
        if (isLaunchedFromPublicUrl())
        {
            SSOUtil.handleSigninPrompt(this);
        }
    }

    public boolean isActionBarSearchIconFadeable()
    {
        return true;
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (i != 18 || getCurrentView() != null) goto _L2; else goto _L1
_L1:
        finish();
_L6:
        return;
_L2:
        if (i != 4 || j != -1) goto _L4; else goto _L3
_L3:
        if (intent != null)
        {
            String s = intent.getStringExtra("BARCODE_STRING");
            if (!Util.isEmpty(s))
            {
                doBarcodeSearch(s, null);
            }
        }
_L8:
        if (i == 10)
        {
            handleOnActivityResultFromSnapIt(j);
        }
        super.onActivityResult(i, j, intent);
        return;
_L4:
        if (i != 4 || j != 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        intent = super.getCurrentView();
        if (intent == null)
        {
            finish();
            return;
        }
        if (!(intent instanceof BarcodeSearchResultsView)) goto _L6; else goto _L5
_L5:
        popView(true, false);
        return;
        if (i != 4 || j == -1) goto _L8; else goto _L7
_L7:
        intent = (new com.amazon.mShop.AmazonAlertDialog.Builder(this)).setMessage(getResources().getString(com.amazon.mShop.android.lib.R.string.bc_picture_format_unspport_message));
        android.content.DialogInterface.OnClickListener onclicklistener = new android.content.DialogInterface.OnClickListener() {

            final SearchActivity this$0;

            public void onClick(DialogInterface dialoginterface, int k)
            {
                if (getCurrentView() == null)
                {
                    finish();
                }
            }

            
            {
                this$0 = SearchActivity.this;
                super();
            }
        };
        intent.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final SearchActivity this$0;

            public void onCancel(DialogInterface dialoginterface)
            {
                if (getCurrentView() == null)
                {
                    finish();
                }
            }

            
            {
                this$0 = SearchActivity.this;
                super();
            }
        });
        intent.setPositiveButton(com.amazon.mShop.android.lib.R.string.alert_ok_button, onclicklistener);
        intent.create().show();
        return;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        adjustActionBar();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setTitle(com.amazon.mShop.android.lib.R.string.search);
        mResultsDisplayLayout = LayoutInflater.from(this).inflate(com.amazon.mShop.android.lib.R.layout.retail_search_layout, null);
        mResultsDisplay = (ResultsDisplay)getSupportFragmentManager().findFragmentById(com.amazon.mShop.android.lib.R.id.results_view);
        mResultsDisplay.addListener(getResultItemListener());
        mResultsDisplay.addListener(this);
        mResultsDisplay.addListener(this);
        if (bundle != null)
        {
            setPreviousSearchTerm(bundle.getString("PersistedSearchTerm"));
        }
        setStopBehavior(0);
        update();
        updateActionBarForSearch();
    }

    protected void onDestroy()
    {
        super.onDestroy();
        super.removeAllViews();
        if (mResultsDisplay != null)
        {
            if (resultItemListener != null)
            {
                mResultsDisplay.removeListener(resultItemListener);
            }
            mResultsDisplay.removeListener(this);
            mResultsDisplay.removeListener(this);
        }
    }

    public void onKeywordChanged(String s)
    {
        setPreviousSearchTerm(s);
        View view = getCurrentView();
        if (view != null && (view instanceof SearchResultsContainer))
        {
            ((SearchResultsContainer)view).setSearchTerm(s);
        }
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        setIntent(intent);
        setShouldShowBarcodeEntry(true);
        update();
        updateActionBarForSearch();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("PersistedSearchTerm", getPreviousSearchTerm());
    }

    public void onSearchATFReached()
    {
        if (mATFPageMetricsObserver == null || mATFPageMetricsObserver.isFinished())
        {
            return;
        } else
        {
            mATFPageMetricsObserver.onComplete();
            return;
        }
    }

    public boolean onSearchRequested()
    {
        View view = getCurrentView();
        if (view != null && (view instanceof RetailSearchEntryView))
        {
            return true;
        } else
        {
            showSearchEntryView(null, false);
            return true;
        }
    }

    public void onSearchSRDSCompleted()
    {
        if (mSRDSPageMetricsObserver == null || mSRDSPageMetricsObserver.isFinished())
        {
            return;
        } else
        {
            mSRDSPageMetricsObserver.onComplete();
            return;
        }
    }

    public void onSearchSRDSStarted()
    {
        if (mSRDSPageMetricsObserver != null && !mSRDSPageMetricsObserver.isFinished())
        {
            mSRDSPageMetricsObserver.onCancelled();
        }
        mSRDSPageMetricsObserver = PageMetricsObserver.start("SearchExperienceRequestLatency");
    }

    public void onSearchStarted()
    {
        if (mATFPageMetricsObserver != null && !mATFPageMetricsObserver.isFinished())
        {
            mATFPageMetricsObserver.onCancelled();
        }
        mATFPageMetricsObserver = PageMetricsObserver.start("SearchExperienceTapToATF");
    }

    protected void onStop()
    {
        setSkipStopBehavior(true);
        super.onStop();
    }

    protected void onViewPopped(View view, View view1)
    {
        updateSearchAsView(view1);
    }

    protected void onViewPushed(View view)
    {
        updateSearchAsView(view);
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        if (flag && getViewAnimator().getChildCount() > 0)
        {
            View view = getCurrentView();
            if (view instanceof RetailSearchEntryView)
            {
                ((RetailSearchEntryView)view).updateEntryView();
                adjustActionBar();
            }
        }
    }

    public boolean popView(boolean flag, boolean flag1)
    {
        flag = super.popView(flag, flag1);
        if (flag)
        {
            View view = getCurrentView();
            if (view instanceof RetailSearchEntryView)
            {
                ((RetailSearchEntryView)view).updateEntryView();
            }
        }
        return flag;
    }

    public void setRootView(View view)
    {
        setRootView(view, true);
        onViewPushed(view);
    }

    public void setSearchEntryViewAsRoot(Intent intent, boolean flag)
    {
        updateCurrentDepartmentInfo(intent);
        mSearchEntryView = (RetailSearchEntryView)View.inflate(this, com.amazon.mShop.android.lib.R.layout.rs_search_entry_view, null);
        initRetailSearchEntryView(mSearchEntryView, intent);
        setRootView(mSearchEntryView);
        adjustActionBar();
    }

    public void showSearchEntryView(Intent intent, boolean flag)
    {
        updateCurrentDepartmentInfo(intent);
        View view;
        if (intent == null)
        {
            setIntent(new Intent());
        } else
        {
            setIntent(intent);
        }
        if (intent == null || Util.isEmpty(intent.getStringExtra("clickStreamOrigin")))
        {
            setClickStreamOrigin(ClickStreamTag.ORIGIN_SEARCH.getTag());
        } else
        {
            setClickStreamOrigin(intent.getStringExtra("clickStreamOrigin"));
        }
        view = getCurrentView();
        if (view == null)
        {
            mSearchEntryView = (RetailSearchEntryView)View.inflate(this, com.amazon.mShop.android.lib.R.layout.rs_search_entry_view, null);
            initRetailSearchEntryView(mSearchEntryView, intent);
            setRootView(mSearchEntryView);
        } else
        {
label0:
            {
                if (!(view instanceof RetailSearchEntryView))
                {
                    break label0;
                }
                mSearchEntryView = (RetailSearchEntryView)view;
                initRetailSearchEntryView(mSearchEntryView, intent);
                new com.amazon.mShop.AmazonActivity.RetailSearchDelayedInitializer(this, mSearchEntryView, false);
            }
        }
_L3:
        adjustActionBar();
        return;
        int i;
        mSearchEntryView = (RetailSearchEntryView)View.inflate(this, com.amazon.mShop.android.lib.R.layout.rs_search_entry_view, null);
        initRetailSearchEntryView(mSearchEntryView, intent);
        pushView(mSearchEntryView, flag);
        intent = getViewAnimator();
        i = intent.getChildCount();
        if (i <= 2) goto _L2; else goto _L1
_L1:
        i -= 3;
_L4:
        if (i >= 0)
        {
            if (!(intent.getChildAt(i) instanceof RetailSearchEntryView))
            {
                break MISSING_BLOCK_LABEL_251;
            }
            intent.setInAnimation(null);
            intent.setOutAnimation(null);
            intent.removeViewAt(i);
        }
_L2:
        removeTemporaryBlankView();
          goto _L3
        i--;
          goto _L4
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.search;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewAnimator;
import com.amazon.now.AmazonActivity;
import com.amazon.now.ChromeStyle;
import com.amazon.now.cart.CartController;
import com.amazon.now.cart.CartItem;
import com.amazon.now.cart.CartResponse;
import com.amazon.now.detail.DetailsActivity;
import com.amazon.now.location.Store;
import com.amazon.now.mash.NavManager;
import com.amazon.now.permissions.PermissionsHelper;
import com.amazon.now.util.AppUtils;
import com.amazon.now.util.LocationUtil;
import com.amazon.now.voice.VoiceSearchInitializer;
import com.amazon.retailsearch.android.api.display.RetailSearchDisplayComponentProvider;
import com.amazon.retailsearch.android.api.display.results.ResultsDisplay;
import com.amazon.retailsearch.android.api.display.results.ResultsInfoBarWidgetType;
import com.amazon.retailsearch.android.api.display.results.item.RetailSearchResultItem;
import com.amazon.retailsearch.android.api.display.results.listeners.ResultItemSelectionListener;
import com.amazon.retailsearch.android.api.display.results.listeners.SearchChangedListener;
import com.amazon.retailsearch.android.api.display.results.listeners.UrlLoadListener;
import com.amazon.retailsearch.android.api.init.RetailSearchInitializer;
import com.amazon.retailsearch.android.api.query.RetailSearchQuery;
import com.amazon.retailsearch.android.ui.UIUtils;
import com.amazon.retailsearch.android.ui.buttons.AddToCartState;
import com.amazon.retailsearch.android.ui.entry.RetailSearchEntryBar;
import com.amazon.retailsearch.android.ui.entry.RetailSearchEntryView;
import com.amazon.retailsearch.data.stores.SearchStore;
import com.amazon.retailsearch.data.stores.StoreManager;
import com.amazon.retailsearch.interaction.AddToCartInteractionListener;
import com.amazon.retailsearch.metrics.SearchMetricsListener;
import com.amazon.searchapp.retailsearch.client.SearchMethod;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.now.search:
//            RetailSearchEntryViewListener, SearchResultsContainer

public class SearchActivity extends AmazonActivity
    implements ResultItemSelectionListener, SearchChangedListener, UrlLoadListener, AddToCartInteractionListener, SearchMetricsListener
{

    public static final String FLAG_SEARCH_CATEGORY_ALIAS = "CATEGORY_ALIAS";
    public static final String FLAG_SEARCH_CATEGORY_NAME = "CATEGORY_NAME";
    public static final String FLAG_SEARCH_CATEGORY_URL = "CATEGORY_URL";
    public static final String INTENT_KEY_STORE_DISCIMINATOR = "intentKeyStoreDiscriminator";
    public static final String KEY_SEARCH_METHOD = "com.amazon.now.search.method";
    public static final String KEY_VOICE_SEARCH_ASR_REQUEST_ID = "com.amazon.now.search.voice.asrRequestId";
    public static final String KEY_VOICE_SEARCH_INTERPRETATION_NUMBER = "com.amazon.now.search.voice.interpretationNumber";
    public static final String KEY_VOICE_SEARCH_UTTERANCE_ID = "com.amazon.now.search.voice.utteranceId";
    public static final String SEARCH_PARAM_DATA_URL = "paramDataUrl";
    public static final String SEARCH_PARAM_DEPARTMENT_FILTER = "paramDepartmentFilter";
    public static final String SEARCH_PARAM_DEPARTMENT_NAME = "paramDepartmentName";
    public static final String SEARCH_PARAM_MERCHANT_ID = "paramMerchantId";
    public static final String SEARCH_PARAM_QUERY_TEXT = "paramQueryText";
    public static final String SEARCH_SUGGESTION_DEPARTMENT_FILTER = "paramSuggestionDepartmentFilter";
    public static final String SEARCH_SUGGESTION_DEPARTMENT_NAME = "paramSuggestionDepartmentName";
    public static final String SHOW_SEARCH_ENTRY_VIEW = "SHOW_SEARCH_ENTRY_VIEW";
    private static final String TAG = com/amazon/now/search/SearchActivity.getSimpleName();
    private static String sDepartmentFilter = null;
    private static String sDepartmentName = null;
    private static String sDepartmentSearchUrl = null;
    private static Map sLocalizedSearchTerm = new HashMap();
    private static String sPreviousSearchTerm = null;
    private static String sSearchAlias = null;
    private int curStoreColor;
    private ResultsDisplay mResultsDisplay;
    private View mResultsDisplayLayout;
    private RetailSearchEntryView mSearchEntryView;

    public SearchActivity()
    {
    }

    private int getChromeColor(String s)
    {
        if (mResultsDisplay == null || mResultsDisplay.getStoreManager() == null)
        {
            return curStoreColor;
        }
        s = mResultsDisplay.getStoreManager().getStoreColor(s);
        try
        {
            curStoreColor = Color.parseColor(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e(TAG, "Invalid color, default color will be used.");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e(TAG, "Provided Merchant Id has no corresponding color.");
        }
        return curStoreColor;
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
        sPreviousSearchTerm = (String)sLocalizedSearchTerm.get("en_us");
        return sPreviousSearchTerm;
    }

    private void initRetailSearchEntryView(RetailSearchEntryView retailsearchentryview, Intent intent, boolean flag)
    {
        String s;
        Object obj;
        final ImageView mic;
        boolean flag1;
        boolean flag2;
        if (intent != null && intent.getData() != null && !"?".equals(intent.getDataString()))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1)
        {
            s = intent.getData().getQueryParameter("paramQueryText");
        } else
        {
            s = null;
        }
        obj = (ViewStub)retailsearchentryview.findViewById(0x7f0e012c);
        ((ViewStub) (obj)).setLayoutResource(0x7f030073);
        mic = (ImageView)((ViewStub) (obj)).inflate();
        if (AppUtils.getConfigBoolean(0x7f090000) && getPackageManager().hasSystemFeature("android.hardware.microphone"))
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        obj = (RetailSearchEntryBar)retailsearchentryview.findViewById(0x7f0e0127);
        if (mic != null && VoiceSearchInitializer.hasInitialized() && flag2)
        {
            mic.setVisibility(0);
            mic.setOnClickListener(new android.view.View.OnClickListener() {

                final SearchActivity this$0;

                public void onClick(View view)
                {
                    PermissionsHelper.launchVoiceSearch(SearchActivity.this);
                }

            
            {
                this$0 = SearchActivity.this;
                super();
            }
            });
            if (mic.getTag() == null)
            {
                ((TextView)((RetailSearchEntryBar) (obj)).findViewById(0x7f0e012b)).addTextChangedListener(new TextWatcher() {

                    final SearchActivity this$0;
                    final ImageView val$mic;

                    public void afterTextChanged(Editable editable)
                    {
                    }

                    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
                    {
                    }

                    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
                    {
                        if (i == 0)
                        {
                            charsequence = mic;
                            if (k > 0)
                            {
                                i = 8;
                            } else
                            {
                                i = 0;
                            }
                            charsequence.setVisibility(i);
                        }
                    }

            
            {
                this$0 = SearchActivity.this;
                mic = imageview;
                super();
            }
                });
                mic.setTag(Boolean.TRUE);
            }
        }
        if (flag1)
        {
            intent = intent.getData().getQueryParameter("paramMerchantId");
        } else
        {
            intent = null;
        }
        if (!TextUtils.isEmpty(intent))
        {
            curStoreColor = getChromeColor(intent);
        }
        ((RetailSearchEntryBar) (obj)).updateBackgroundColor(curStoreColor);
        retailsearchentryview.setSearchTerm(s);
        retailsearchentryview.setCurrentDepartmentName(getCurrentDepartmentName());
        retailsearchentryview.setSearchUrl(sDepartmentSearchUrl);
        retailsearchentryview.setSearchAlias(sSearchAlias);
        if (flag)
        {
            retailsearchentryview.setPreviousSearchTerm(getPreviousSearchTerm());
        }
        retailsearchentryview.setVoiceEnabled(false);
        retailsearchentryview.setShowBarcodeEntry(false);
        retailsearchentryview.setShowBarcodeIconForFlow(false);
        retailsearchentryview.setHasSnapIt(false);
        retailsearchentryview.setFlowEnabled(false);
        retailsearchentryview.setCustomHintText(true);
        retailsearchentryview.setListener(new RetailSearchEntryViewListener(this));
        retailsearchentryview.updateEntryView();
    }

    public static void setPreviousSearchTerm(String s)
    {
        sPreviousSearchTerm = s;
        sLocalizedSearchTerm.put("en_us", s);
    }

    private void setSearchRootView(View view, boolean flag)
    {
        int i;
label0:
        {
            pushView(view);
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

    private void update(Intent intent)
    {
label0:
        {
            if (intent != null)
            {
                if (!intent.getBooleanExtra("SHOW_SEARCH_ENTRY_VIEW", false))
                {
                    break label0;
                }
                setSearchEntryViewAsRoot(intent, false);
            }
            return;
        }
        doSearch(intent);
    }

    private void updateActionBarForSearch()
    {
        View view = findViewById(0x7f0e002f);
        if (view != null)
        {
            view.setVisibility(8);
            ((RelativeLayout)view.getParent()).setBackgroundColor(curStoreColor);
        }
    }

    public static void updateCurrentDepartmentInfo(Intent intent)
    {
        String s;
        String s1;
        String s2;
        if (intent == null || intent.getData() == null)
        {
            break MISSING_BLOCK_LABEL_216;
        }
        s = intent.getStringExtra("CATEGORY_URL");
        s1 = intent.getStringExtra("CATEGORY_NAME");
        s2 = intent.getStringExtra("CATEGORY_ALIAS");
        if (TextUtils.isEmpty(s) || TextUtils.isEmpty(s1) || TextUtils.isEmpty(s2)) goto _L2; else goto _L1
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
        s = intent.getData().getQueryParameter("paramDepartmentFilter");
        s1 = intent.getData().getQueryParameter("paramDepartmentName");
        s2 = intent.getData().getQueryParameter("paramSuggestionDepartmentFilter");
        s3 = intent.getData().getQueryParameter("paramSuggestionDepartmentName");
        boolean flag;
        if (!TextUtils.isEmpty(intent.getDataString()) && !"?".equals(intent.getDataString()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1) && !flag)
        {
            sDepartmentFilter = s;
            sDepartmentName = s1;
            return;
        }
        if (!TextUtils.isEmpty(s) || !TextUtils.isEmpty(s1) || !TextUtils.isEmpty(s2) || !TextUtils.isEmpty(s3)) goto _L4; else goto _L3
_L3:
        sDepartmentFilter = null;
        sDepartmentName = null;
        return;
        sDepartmentFilter = null;
        sDepartmentName = null;
        return;
    }

    private void updateSearchStoreMap()
    {
        Object obj = LocationUtil.getStoreList();
        if (obj != null)
        {
            HashMap hashmap = new HashMap();
            obj = ((List) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                Object obj1 = (Store)((Iterator) (obj)).next();
                if (obj1 != null)
                {
                    obj1 = new SearchStore(((Store) (obj1)).getStoreName(), ((Store) (obj1)).getMerchantId(), ((Store) (obj1)).getStoreUrl(), ((Store) (obj1)).getImageUrl(), ((Store) (obj1)).getBadgeUrl(), ((Store) (obj1)).getStoreColor());
                    hashmap.put(((SearchStore) (obj1)).getMerchantId(), obj1);
                }
            } while (true);
            if (mResultsDisplay != null)
            {
                StoreManager storemanager = mResultsDisplay.getStoreManager();
                if (storemanager != null)
                {
                    storemanager.updateStoreMap(hashmap);
                }
            }
        }
    }

    public static SearchResultsContainer wrapSearchBar(AmazonActivity amazonactivity, View view, String s, int i)
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
        ((RetailSearchEntryBar)amazonactivity.findViewById(0x7f0e0127)).updateBackgroundColor(i);
        amazonactivity.setSearchTerm(s);
        amazonactivity.setSearchResultView(view);
        amazonactivity.updateSearchBar(sDepartmentFilter, sDepartmentName);
        return amazonactivity;
    }

    public void addToCart(String s, String s1, String s2, String s3, String s4, int i, final com.amazon.retailsearch.interaction.AddToCartInteractionListener.SearchCartCallback callback)
    {
        String s5 = "";
        if (!TextUtils.isEmpty(s4))
        {
            s5 = (new StringBuilder()).append("sr_add_sc_").append(s4).toString();
        } else
        {
            Log.w(TAG, "sr passed to the cart isEmpty. Metrics will be incorrect.");
        }
        CartController.getInstance().addToCart(null, s, s1, s2, s3, s4, s5, i, new com.amazon.now.cart.CartController.CartCallback() {

            final SearchActivity this$0;
            final com.amazon.retailsearch.interaction.AddToCartInteractionListener.SearchCartCallback val$callback;
            final Context val$context;

            public void onFailure(CartResponse cartresponse, String s6)
            {
                if (callback != null)
                {
                    if (cartresponse != null)
                    {
                        callback.error(cartresponse.getItemCount(), cartresponse.getItemId(), cartresponse.getStockOnHand());
                    } else
                    {
                        callback.error();
                    }
                }
                CartController.getInstance().addToCartFailureMessage(context, s6);
            }

            public void onSuccess(CartResponse cartresponse)
            {
                if (callback != null && cartresponse != null)
                {
                    callback.success(cartresponse.getItemCount(), cartresponse.getItemId(), cartresponse.getStockOnHand());
                    return;
                } else
                {
                    CartController.getInstance().addToCartSuccessMessage(context);
                    return;
                }
            }

            
            {
                this$0 = SearchActivity.this;
                callback = searchcartcallback;
                context = context1;
                super();
            }
        });
    }

    public void doSearch(Intent intent)
    {
        if (intent.getData() == null) goto _L2; else goto _L1
_L1:
        Object obj;
        RetailSearchQuery retailsearchquery;
        String s1;
        updateCurrentDepartmentInfo(intent);
        s1 = intent.getData().getQueryParameter("paramQueryText");
        retailsearchquery = (RetailSearchQuery)intent.getParcelableExtra(RetailSearchQuery.INTENT_EXTRA_KEY);
        obj = intent.getData().getQueryParameter("paramDataUrl");
        if (TextUtils.isEmpty(((CharSequence) (obj)))) goto _L4; else goto _L3
_L3:
        obj = RetailSearchQuery.fromUrl(((String) (obj)));
_L5:
        if (intent.hasExtra("com.amazon.now.search.method"))
        {
            ((RetailSearchQuery) (obj)).setSearchMethod(SearchMethod.find(intent.getStringExtra("com.amazon.now.search.method")));
        }
        if (intent.hasExtra("com.amazon.now.search.voice.asrRequestId"))
        {
            ((RetailSearchQuery) (obj)).setAsrRequestId(intent.getStringExtra("com.amazon.now.search.voice.asrRequestId"));
        }
        if (intent.hasExtra("com.amazon.now.search.voice.utteranceId"))
        {
            ((RetailSearchQuery) (obj)).setUtteranceId(intent.getStringExtra("com.amazon.now.search.voice.utteranceId"));
        }
        if (intent.hasExtra("com.amazon.now.search.voice.interpretationNumber"))
        {
            ((RetailSearchQuery) (obj)).setInterpretationNum(intent.getIntExtra("com.amazon.now.search.voice.interpretationNumber", 0));
        }
        setPreviousSearchTerm(s1);
        intent = intent.getData().getQueryParameter("paramMerchantId");
        if (!TextUtils.isEmpty(intent))
        {
            curStoreColor = getChromeColor(intent);
        }
        intent = getIntent().getStringExtra("intentKeyStoreDiscriminator");
        if (!TextUtils.isEmpty(intent))
        {
            ((RetailSearchQuery) (obj)).setStoreDiscriminator(intent);
        }
        setSearchRootView(wrapSearchBar(this, mResultsDisplayLayout, s1, curStoreColor), true);
        mResultsDisplay.search(((RetailSearchQuery) (obj)));
        return;
_L4:
        obj = retailsearchquery;
        if (retailsearchquery == null)
        {
            obj = retailsearchquery;
            if (!TextUtils.isEmpty(s1))
            {
                String s = intent.getData().getQueryParameter("paramDepartmentFilter");
                obj = s;
                if (TextUtils.isEmpty(s))
                {
                    obj = intent.getData().getQueryParameter("paramSuggestionDepartmentFilter");
                }
                s = ((String) (obj));
                if (!TextUtils.isEmpty(((CharSequence) (obj))))
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
                if (TextUtils.isEmpty(s))
                {
                    obj = new RetailSearchQuery(s1);
                } else
                {
                    obj = new RetailSearchQuery(s, s1);
                }
            }
        }
        if (true) goto _L5; else goto _L2
_L2:
        updateCurrentDepartmentInfo(null);
        Object obj1 = intent.getStringExtra("query");
        intent = ((Intent) (obj1));
        if (TextUtils.isEmpty(((CharSequence) (obj1))))
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
        setSearchRootView(wrapSearchBar(this, mResultsDisplayLayout, intent, curStoreColor), true);
        mResultsDisplay.search(((RetailSearchQuery) (obj1)));
        return;
    }

    public void finish()
    {
        super.finish();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mResultsDisplayLayout = LayoutInflater.from(this).inflate(0x7f030022, getViewAnimator(), false);
        mResultsDisplay = RetailSearchDisplayComponentProvider.inflateResultsDisplay((ViewStub)mResultsDisplayLayout.findViewById(0x7f0e00ad));
        mResultsDisplay.removeAllListeners();
        mResultsDisplay.addListener(this);
        mResultsDisplay.addListener(this);
        mResultsDisplay.addListener(this);
        mResultsDisplay.addListener(this);
        mResultsDisplay.addListener(this);
        curStoreColor = getResources().getColor(0x7f0d0022);
        updateSearchStoreMap();
        mResultsDisplay.setResultsInfoBarWidgetType(ResultsInfoBarWidgetType.STYLED_LABEL, null);
        if (bundle != null)
        {
            setPreviousSearchTerm(bundle.getString("PersistedSearchTerm"));
        }
        update(getIntent());
        updateActionBarForSearch();
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if (mResultsDisplay != null)
        {
            mResultsDisplay.removeAllListeners();
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

    public void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        update(intent);
        updateActionBarForSearch();
    }

    public void onPause()
    {
        super.onPause();
        UIUtils.closeSoftKeyboard(getViewAnimator());
    }

    public void onResultItemSelected(RetailSearchResultItem retailsearchresultitem)
    {
        if (retailsearchresultitem == null || TextUtils.isEmpty(retailsearchresultitem.getDetailPageUrlPath()))
        {
            return;
        } else
        {
            Intent intent = new Intent(this, com/amazon/now/detail/DetailsActivity);
            intent.putExtra("asinPath", retailsearchresultitem.getDetailPageUrlPath());
            startActivity(intent);
            return;
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("PersistedSearchTerm", getPreviousSearchTerm());
    }

    public void onSearchATFReached()
    {
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
    }

    public void onSearchSRDSStarted()
    {
    }

    public void onSearchStarted()
    {
    }

    public void onStoresUpdated()
    {
        super.onStoresUpdated();
        updateSearchStoreMap();
    }

    public void onUrlLoad(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return;
        } else
        {
            NavManager.getInstance().navigate(s, this);
            return;
        }
    }

    public void setSearchEntryViewAsRoot(Intent intent, boolean flag)
    {
        updateCurrentDepartmentInfo(intent);
        mSearchEntryView = (RetailSearchEntryView)View.inflate(this, 0x7f030057, null);
        initRetailSearchEntryView(mSearchEntryView, intent, false);
        setRootView(mSearchEntryView, new ChromeStyle(com.amazon.now.ChromeStyle.ChromeLayout.NORMAL));
    }

    public void showSearchEntryView(Intent intent, boolean flag)
    {
        View view;
        updateCurrentDepartmentInfo(intent);
        if (intent == null)
        {
            setIntent(new Intent());
        } else
        {
            setIntent(intent);
        }
        view = getCurrentView();
        if (view != null) goto _L2; else goto _L1
_L1:
        mSearchEntryView = (RetailSearchEntryView)View.inflate(this, 0x7f030057, null);
        initRetailSearchEntryView(mSearchEntryView, intent, true);
        setRootView(mSearchEntryView, new ChromeStyle(com.amazon.now.ChromeStyle.ChromeLayout.NORMAL));
_L4:
        return;
_L2:
        if (view instanceof RetailSearchEntryView)
        {
            mSearchEntryView = (RetailSearchEntryView)view;
            initRetailSearchEntryView(mSearchEntryView, intent, true);
            new RetailSearchInitializer();
            return;
        }
        mSearchEntryView = (RetailSearchEntryView)View.inflate(this, 0x7f030057, null);
        initRetailSearchEntryView(mSearchEntryView, intent, true);
        pushView(mSearchEntryView);
        intent = getViewAnimator();
        int i = intent.getChildCount();
        if (i > 2)
        {
            i -= 3;
            while (i >= 0) 
            {
                if (intent.getChildAt(i) instanceof RetailSearchEntryView)
                {
                    intent.setInAnimation(null);
                    intent.setOutAnimation(null);
                    intent.removeViewAt(i);
                    return;
                }
                i--;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void updateCartState(String s, String s1, String s2, AddToCartState addtocartstate)
    {
        s = CartController.getInstance().getCartItem(s, s1, s2);
        if (s != null && s.getQuantity() > 0 && !TextUtils.isEmpty(s.getItemId()) && s.getStockOnHand() > 0)
        {
            addtocartstate.update(s.getQuantity(), s.getItemId(), s.getStockOnHand());
        }
    }

    public void updateQuantity(String s, String s1, String s2, String s3, int i, final com.amazon.retailsearch.interaction.AddToCartInteractionListener.SearchCartCallback callback)
    {
        CartController.getInstance().updateQuantity(null, s, i, s1, new com.amazon.now.cart.CartController.CartCallback() {

            final SearchActivity this$0;
            final com.amazon.retailsearch.interaction.AddToCartInteractionListener.SearchCartCallback val$callback;
            final Context val$context;

            public void onFailure(CartResponse cartresponse, String s4)
            {
                if (callback != null)
                {
                    if (cartresponse != null)
                    {
                        callback.error(cartresponse.getItemCount(), cartresponse.getItemId(), cartresponse.getStockOnHand());
                    } else
                    {
                        callback.error();
                    }
                }
                CartController.getInstance().quantityChangeFailureMessage(context, s4);
            }

            public void onSuccess(CartResponse cartresponse)
            {
                if (callback != null && cartresponse != null)
                {
                    callback.success(cartresponse.getItemCount(), cartresponse.getItemId(), cartresponse.getStockOnHand());
                    return;
                } else
                {
                    CartController.getInstance().quantityChangeSuccessMessage(context);
                    return;
                }
            }

            
            {
                this$0 = SearchActivity.this;
                callback = searchcartcallback;
                context = context1;
                super();
            }
        });
    }

}

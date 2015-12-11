// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import com.ebay.common.Preferences;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.net.api.search.SellerOfferParameters;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.BaseActivity;
import com.ebay.mobile.activities.QuickSearchHandler;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.eBayDictionaryProvider;
import com.ebay.mobile.search.SearchLandingPage.SearchLandingPageActivity;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;

public class MainSearchActivity extends BaseActivity
    implements android.app.SearchManager.OnCancelListener, android.app.SearchManager.OnDismissListener
{
    private class ProxyListener
        implements android.widget.SearchView.OnQueryTextListener
    {

        final MainSearchActivity this$0;

        public boolean onQueryTextChange(String s)
        {
            if (TextUtils.isEmpty(s))
            {
                MyApp.getPrefs().removeUserPref("searchLastKeywords");
            } else
            {
                MyApp.getPrefs().setUserPref("searchLastKeywords", s);
            }
            return false;
        }

        public boolean onQueryTextSubmit(String s)
        {
            return false;
        }

        private ProxyListener()
        {
            this$0 = MainSearchActivity.this;
            super();
        }

    }


    public static final String EXTRA_SEARCH_TEXT = "searchBoxText";
    public static final String EXTRA_SELLER_ID = "sellerId";
    public static final String EXTRA_SELLER_OFFER = "sellerOffer";
    private String searchHintText;
    private SearchView searchView;
    private String sellerId;
    private SellerOfferParameters sellerOffer;
    private boolean shouldTrack;

    public MainSearchActivity()
    {
        shouldTrack = true;
    }

    private boolean displayDropdown(LinearLayout linearlayout)
    {
        boolean flag;
        boolean flag1;
        flag = false;
        flag1 = false;
        if (linearlayout == null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L9:
        flag = flag1;
        if (i >= linearlayout.getChildCount()) goto _L2; else goto _L3
_L3:
        View view = linearlayout.getChildAt(i);
        if (!(view instanceof LinearLayout)) goto _L5; else goto _L4
_L4:
        flag = displayDropdown((LinearLayout)view);
_L7:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        return flag;
_L5:
        flag = flag1;
        if (view instanceof AutoCompleteTextView)
        {
            int j = (view.getLeft() + view.getRight()) / 2;
            int k = (view.getBottom() + view.getTop()) / 2;
            long l = SystemClock.uptimeMillis();
            view.dispatchTouchEvent(MotionEvent.obtain(l, 39L + l, 0, j, k, 0));
            view.dispatchTouchEvent(MotionEvent.obtain(40L + l, 80L + l, 1, j, k, 0));
            flag = true;
        }
        if (true) goto _L7; else goto _L6
_L6:
        i++;
        flag1 = flag;
        if (true) goto _L9; else goto _L8
_L8:
    }

    private void processSearchIntent(Intent intent)
    {
        if (intent != null && "android.intent.action.SEARCH".equals(intent.getAction()))
        {
            shouldTrack = false;
            Intent intent1 = new Intent(intent);
            intent1.setComponent(new ComponentName(this, com/ebay/mobile/activities/QuickSearchHandler));
            if (sellerId != null || sellerOffer != null)
            {
                Object obj = intent.getBundleExtra("app_data");
                Bundle bundle = ((Bundle) (obj));
                if (obj == null)
                {
                    bundle = new Bundle();
                }
                SearchParameters searchparameters = (SearchParameters)bundle.getParcelable("search_param");
                obj = searchparameters;
                if (searchparameters == null)
                {
                    obj = eBayDictionaryProvider.getLockedSearchParameters(this, intent.getStringExtra("query"));
                }
                obj.sellerId = sellerId;
                if (sellerOffer != null)
                {
                    obj.sellerOffer = new SellerOfferParameters(sellerOffer.offerType, sellerOffer.offerId, sellerOffer.sellerName, sellerOffer.seedCategoryId);
                }
                bundle.putParcelable("search_param", ((android.os.Parcelable) (obj)));
                intent1.putExtra("app_data", bundle);
            }
            startActivity(intent1);
            finish();
        }
    }

    private boolean showSearchBox()
    {
        boolean flag1 = false;
        boolean flag = false;
        searchView = (SearchView)findViewById(0x7f10055f);
        if (searchView == null)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        Object obj = (SearchManager)getSystemService("search");
        flag = flag1;
        try
        {
            obj = ((SearchManager) (obj)).getSearchableInfo(new ComponentName(this, getClass()));
        }
        catch (Exception exception)
        {
            searchView.setVisibility(8);
            return flag;
        }
        flag = flag1;
        searchView.setSearchableInfo(((android.app.SearchableInfo) (obj)));
        flag = flag1;
        searchView.setIconified(false);
        flag = flag1;
        searchView.setIconifiedByDefault(false);
        flag = flag1;
        searchView.setSubmitButtonEnabled(true);
        flag = flag1;
        searchView.setQuery(MyApp.getPrefs().getUserPref("searchLastKeywords", ""), false);
        flag = flag1;
        searchView.setQueryHint(searchHintText);
        flag = flag1;
        searchView.setOnQueryTextListener(new ProxyListener());
        flag = true;
        flag1 = true;
        displayDropdown(searchView);
        flag = flag1;
        return flag;
    }

    public String getTrackingEventName()
    {
        return "EnterSearch";
    }

    public void onCancel()
    {
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getIntent();
        if (DeviceConfiguration.getAsync().get(com.ebay.nautilus.domain.dcs.DcsDomain.Search.B.vqLandingPage))
        {
            startActivity((new Intent(this, com/ebay/mobile/search/SearchLandingPage/SearchLandingPageActivity)).putExtras(bundle));
            finish();
        } else
        {
            setContentView(0x7f0301c7);
            sellerOffer = (SellerOfferParameters)bundle.getParcelableExtra("sellerOffer");
            sellerId = bundle.getStringExtra("sellerId");
            processSearchIntent(bundle);
            searchHintText = bundle.getStringExtra("searchBoxText");
            if (searchHintText == null)
            {
                searchHintText = Util.getCommonSearchHint(this);
            }
            if (!showSearchBox())
            {
                searchView = null;
            }
            if (searchView == null)
            {
                bundle = (SearchManager)getSystemService("search");
                bundle.setOnCancelListener(this);
                bundle.setOnDismissListener(this);
                return;
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return false;
    }

    public void onDismiss()
    {
    }

    public void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        if (DeviceConfiguration.getAsync().get(com.ebay.nautilus.domain.dcs.DcsDomain.Search.B.vqLandingPage))
        {
            startActivity((new Intent(this, com/ebay/mobile/search/SearchLandingPage/SearchLandingPageActivity)).putExtras(intent));
            finish();
            return;
        }
        if (!"android.intent.action.SEARCH".equals(intent.getAction()))
        {
            startActivity(intent);
            finish();
            return;
        } else
        {
            processSearchIntent(intent);
            return;
        }
    }

    public void onPause()
    {
        getWindow().setSoftInputMode(3);
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        resumeUi();
        if (shouldTrack)
        {
            (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).addSourceIdentification(getIntent()).send(this);
        }
    }

    public boolean onSearchRequested()
    {
        return false;
    }

    public void resumeUi()
    {
        if (searchView != null)
        {
            getWindow().setSoftInputMode(5);
            return;
        } else
        {
            startSearch(MyApp.getPrefs().getUserPref("searchLastKeywords", ""), true, null, false);
            return;
        }
    }
}

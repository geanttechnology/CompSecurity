// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ebay.common.UserCache;
import com.ebay.common.net.api.followinterest.FollowSvcShared;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.util.EbaySettings;
import com.ebay.mobile.activities.QuickSearchHandler;
import com.ebay.mobile.activities.SavedSearchResultListActivity;
import com.ebay.mobile.activities.ShowWebViewActivity;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.following.BrowseFollowingActivity;
import com.ebay.mobile.myebay.ReminderItemsActivity;
import com.ebay.mobile.notifications.ItemCache;
import com.ebay.mobile.search.SavedSearchListActivity;
import com.ebay.mobile.search.SearchResultFragmentActivity;
import com.ebay.mobile.search.SearchUtil;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.shell.app.BaseActivity;
import java.security.InvalidParameterException;

// Referenced classes of package com.ebay.mobile:
//            MyApp, eBayDictionaryProvider

public class ActivityStarter
{

    private ActivityStarter()
    {
    }

    public static Intent getBrowseFollowsIntent(Context context)
    {
        DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
        if (deviceconfiguration.get(DcsBoolean.searchSavedSearchUseFollowInterest) || !deviceconfiguration.get(com.ebay.nautilus.domain.dcs.DcsDomain.Search.B.enableNavigationFallbackForBrowseFollows))
        {
            return new Intent(context, com/ebay/mobile/following/BrowseFollowingActivity);
        } else
        {
            return new Intent(context, com/ebay/mobile/search/SavedSearchListActivity);
        }
    }

    public static Intent getSavedSearchIntent(Context context, EbayContext ebaycontext, String s, Long long1)
    {
        return getSavedSearchIntent(context, ebaycontext, s, long1, true, null);
    }

    private static Intent getSavedSearchIntent(Context context, EbayContext ebaycontext, String s, Long long1, boolean flag, SourceIdentification sourceidentification)
    {
        Object obj;
        obj = null;
        if (!flag && TextUtils.isEmpty(s))
        {
            throw new InvalidParameterException("getSavedSearchIntent requires a non-null savedSearchId when called with requireResultIntent=true");
        }
        if (!MyApp.getDeviceConfiguration().getConfig().get(DcsBoolean.searchSavedSearchUseFollowInterest)) goto _L2; else goto _L1
_L1:
        SearchParameters searchparameters = null;
        if (!TextUtils.isEmpty(s)) goto _L4; else goto _L3
_L3:
        long1 = obj;
        if (flag)
        {
            long1 = BrowseFollowingActivity.getStartActivityIntent(context, true);
        }
_L6:
        if (long1 != null)
        {
            long1.setFlags(0x4000000);
            if (!TextUtils.isEmpty(s))
            {
                long1.putExtra("first_time_run_ss", true);
                long1.putExtra("saved_search_id", s);
            }
            if (sourceidentification != null)
            {
                long1.putExtra("com.ebay.mobile.analytics.sid", sourceidentification);
            }
        }
        return long1;
_L4:
        boolean flag1 = FollowSvcShared.isMain();
        if (flag1)
        {
            searchparameters = SearchUtil.getSearchParametersForFollowedSearchId(context, ebaycontext, s, long1);
        }
        if (!flag1 || searchparameters != null)
        {
            long1 = getSearchResultListIntent(context, searchparameters, null);
        } else
        {
            long1 = obj;
            if (flag)
            {
                (new UserCache(context, ebaycontext)).refreshSavedSearchList();
                long1 = BrowseFollowingActivity.getStartActivityIntent(context, true);
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (!TextUtils.isEmpty(s))
        {
            long1 = new Intent(context, com/ebay/mobile/activities/SavedSearchResultListActivity);
        } else
        {
            long1 = new Intent(context, com/ebay/mobile/search/SavedSearchListActivity);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static Intent getSearchResultListIntent(Context context, SearchParameters searchparameters, String s)
    {
        context = new Intent(context, com/ebay/mobile/search/SearchResultFragmentActivity);
        context.putExtra("search_param", searchparameters);
        context.putExtra("com.ebay.mobile.tracking.BidSource", s);
        context.setFlags(0x4000000);
        return context;
    }

    public static Intent getUciWebViewIntent(Activity activity, String s)
    {
        activity = new Intent(activity, com/ebay/mobile/activities/ShowWebViewActivity);
        activity.putExtra("url", EbaySettings.getUpdateContactInfoUrl(s));
        activity.putExtra("use_sso", true);
        return activity;
    }

    public static boolean startBrowseSavedSearch(Context context, EbayContext ebaycontext)
    {
        boolean flag = true;
        ebaycontext = getSavedSearchIntent(context, ebaycontext, null, null, true, null);
        if (ebaycontext == null)
        {
            return false;
        }
        if (ebaycontext != null)
        {
            context.startActivity(ebaycontext);
        }
        if (ebaycontext == null)
        {
            flag = false;
        }
        return flag;
    }

    public static void startCouponItems(Activity activity, int i, String s)
    {
        Intent intent = new Intent(activity, com/ebay/mobile/myebay/ReminderItemsActivity);
        intent.putExtra("reminders_type", -1);
        intent.putExtra("reminders_type_text", s);
        activity.startActivity(intent);
    }

    public static void startReminderItems(Activity activity, int i, String s)
    {
        Intent intent = new Intent(activity, com/ebay/mobile/myebay/ReminderItemsActivity);
        intent.putExtra("reminders_type", i);
        intent.putExtra("reminders_type_text", s);
        activity.startActivity(intent);
    }

    public static boolean startSavedSearch(Context context, EbayContext ebaycontext, String s, Long long1, SourceIdentification sourceidentification)
    {
        ebaycontext = getSavedSearchIntent(context, ebaycontext, s, long1, false, sourceidentification);
        if (ebaycontext == null)
        {
            return false;
        } else
        {
            (new ItemCache(context)).markSavedSearchViewed(s);
            context.startActivity(ebaycontext);
            return true;
        }
    }

    public static void startSearch(Context context, String s, String s1, String s2, long l, SourceIdentification sourceidentification)
    {
        if (!TextUtils.isEmpty(s))
        {
            Intent intent = new Intent(context, com/ebay/mobile/activities/QuickSearchHandler);
            intent.setAction("android.intent.action.SEARCH");
            intent.addFlags(0x10000000);
            intent.putExtra("query", s);
            if (!TextUtils.isEmpty(s1))
            {
                intent.putExtra("user_query", s1);
            }
            s = "";
            if (!TextUtils.isEmpty(s2))
            {
                s = s2;
            }
            if (l != 0L)
            {
                intent.putExtra("intent_extra_data_key", (new StringBuilder()).append(s).append("|").append(l).toString());
            }
            if (sourceidentification != null)
            {
                intent.putExtra("com.ebay.mobile.analytics.sid", sourceidentification);
            }
            context.startActivity(intent);
        }
    }

    public static void startSearchResultList(Context context, SearchParameters searchparameters, String s)
    {
        context.startActivity(getSearchResultListIntent(context, searchparameters, s));
    }

    public static void startSellerItemsSearchResultList(BaseActivity baseactivity, String s, SourceIdentification sourceidentification)
    {
        startSellerItemsSearchResultList(baseactivity, s, false, sourceidentification);
    }

    public static void startSellerItemsSearchResultList(BaseActivity baseactivity, String s, boolean flag, SourceIdentification sourceidentification)
    {
        SearchParameters searchparameters = eBayDictionaryProvider.getLockedSearchParameters(baseactivity, null);
        searchparameters.sellerId = s;
        searchparameters.searchOtherCountries = flag;
        s = new Intent(baseactivity, com/ebay/mobile/search/SearchResultFragmentActivity$SellerItemsActivity);
        if (sourceidentification != null)
        {
            s.putExtra("com.ebay.mobile.analytics.sid", sourceidentification);
        }
        s.putExtra("search_param", searchparameters);
        s.setFlags(0x4000000);
        baseactivity.startActivity(s);
    }
}

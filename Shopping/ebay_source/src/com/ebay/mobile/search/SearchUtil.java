// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.ebay.common.Preferences;
import com.ebay.common.UserCache;
import com.ebay.common.content.EbayCguidPersister;
import com.ebay.common.content.dm.FollowedEntityDataManager;
import com.ebay.common.model.followinterest.FollowDescriptor;
import com.ebay.common.model.search.EbayCategorySummary;
import com.ebay.common.model.search.SavedSearch;
import com.ebay.common.net.api.followinterest.InterestDescriptor;
import com.ebay.common.net.api.search.KnownSearchExpansion;
import com.ebay.common.net.api.search.SearchConfiguration;
import com.ebay.common.net.api.search.SearchExpansion;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.net.api.search.SearchRewriteDescriptor;
import com.ebay.common.net.api.search.SearchServiceApi;
import com.ebay.common.net.api.search.SearchServiceRequestV1;
import com.ebay.common.net.api.search.SearchServiceRequestV2;
import com.ebay.common.net.api.search.SearchServiceResponse;
import com.ebay.common.net.api.search.idealmodel.RewriteStartSrpListItem;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.eBayDictionaryProvider;
import com.ebay.mobile.notifications.ItemCache;
import com.ebay.mobile.notifications.PollServiceListCache;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.data.PostalCodeSpecification;
import com.ebay.nautilus.domain.dcs.DcsNautilusBoolean;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.net.Connector;
import java.security.MessageDigest;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// Referenced classes of package com.ebay.mobile.search:
//            SavedSearchList

public final class SearchUtil
{
    private static class DcsRefreshObserver extends DataSetObserver
    {

        private EbayContext ebayContext;

        public void onChanged()
        {
            SearchUtil.validateCacheRelevance(SearchUtil.getFollowedEntityDataManager(ebayContext));
        }

        public DcsRefreshObserver(EbayContext ebaycontext)
        {
            ebayContext = ebaycontext.getApplicationContext();
        }
    }

    public static class WatchFollowsObserver extends com.ebay.common.content.dm.FollowedEntityDataManager.WatchFollowsObserverBase
    {

        public SearchParameters getDefaultSearchParameters()
        {
            String s;
            if (observer != null)
            {
                s = observer.getSearchQuery();
            } else
            {
                s = null;
            }
            return eBayDictionaryProvider.getDefaultSearchParameters(context, s);
        }

        protected transient void onDeleteSavedSearchesFromCache(Context context, String as[])
        {
            SavedSearchList savedsearchlist = UserCache.getSavedSearchList();
            ItemCache itemcache = new ItemCache(context);
            int j = as.length;
label0:
            for (int i = 0; i < j; i++)
            {
                String s = as[i];
                Iterator iterator = savedsearchlist.getSearchList().iterator();
                SavedSearch savedsearch;
                do
                {
                    if (!iterator.hasNext())
                    {
                        continue label0;
                    }
                    savedsearch = (SavedSearch)iterator.next();
                } while (TextUtils.isEmpty(savedsearch.id) || !savedsearch.id.equals(s));
                itemcache.deleteSavedSearch(s);
                savedsearchlist.removeById(context, s);
            }

        }

        public WatchFollowsObserver(Context context, com.ebay.common.content.dm.FollowedEntityDataManager.OnFollowedSearchesChanged onfollowedsearcheschanged)
        {
            super(context, onfollowedsearcheschanged);
        }
    }


    private static final String LOG_TAG = "SearchUtil";
    public static final String SAVED_SEARCH_PROVIDER_FOLLOW = "Follow";
    public static final String SAVED_SEARCH_PROVIDER_FUSS = "Fuss";
    public static long SHOW_ALL_LISTINGS = 0L;
    private static DcsRefreshObserver dcsRefreshObserver;

    public SearchUtil()
    {
    }

    public static boolean bopisRefinementEnabled(SearchParameters searchparameters)
    {
        DcsHelper dcshelper = MyApp.getDeviceConfiguration();
        return useSearchService(searchparameters) && dcshelper.isBopisEnabled() && dcshelper.getConfig().get(DcsBoolean.SearchRefinementInStorePickup);
    }

    private static String byteToHex(byte abyte0[])
    {
        Formatter formatter = new Formatter();
        int j = abyte0.length;
        for (int i = 0; i < j; i++)
        {
            formatter.format("%02x", new Object[] {
                Byte.valueOf(abyte0[i])
            });
        }

        abyte0 = formatter.toString();
        formatter.close();
        return abyte0;
    }

    public static boolean ebnRefinementEnabled(SearchParameters searchparameters)
    {
        DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
        return useSearchService(searchparameters) && deviceconfiguration.get(DcsBoolean.eBayNow);
    }

    public static SearchConfiguration getDefaultSearchConfig(boolean flag, EbayCguidPersister ebaycguidpersister)
    {
        DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
        boolean flag3 = deviceconfiguration.get(DcsBoolean.SearchUseSearchService);
        boolean flag4 = deviceconfiguration.get(DcsBoolean.SearchUseSearchServiceV2);
        boolean flag5 = deviceconfiguration.get(DcsBoolean.AutoSearches);
        boolean flag6 = deviceconfiguration.get(DcsBoolean.SearchExpansionEnabled);
        boolean flag7 = deviceconfiguration.get(DcsNautilusBoolean.GBH);
        boolean flag8 = deviceconfiguration.get(DcsBoolean.RLKeywordFallback);
        boolean flag1;
        boolean flag2;
        boolean flag9;
        boolean flag10;
        if (deviceconfiguration.get(DcsBoolean.SearchUseSearchService) && deviceconfiguration.get(com.ebay.nautilus.domain.dcs.DcsDomain.Ads.B.srpShow19791))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag9 = deviceconfiguration.get(DcsBoolean.SearchLocalOnlyConstraint);
        flag10 = deviceconfiguration.get(DcsBoolean.SearchServiceUvcc);
        if (deviceconfiguration.get(DcsNautilusBoolean.PUDO) && deviceconfiguration.get(DcsBoolean.SearchUsePickupDropOffHack))
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        return new SearchConfiguration(flag3, flag4, flag5, flag6, flag7, flag8, flag, flag1, flag9, flag10, flag2, deviceconfiguration.get(DcsBoolean.SearchEEKEnabled), deviceconfiguration.get(DcsBoolean.SearchUseOAuthEndpoint), deviceconfiguration.get(com.ebay.nautilus.domain.dcs.DcsDomain.Ads.I.srpMaxLimitShown19791), deviceconfiguration.get(com.ebay.nautilus.domain.dcs.DcsDomain.Ads.I.srpThresholdResultCount19791), ebaycguidpersister, deviceconfiguration.get(DcsBoolean.itemTitleTranslationEnabled), deviceconfiguration.get(com.ebay.nautilus.domain.dcs.DcsDomain.Search.B.madlanDisplayStrings), deviceconfiguration.get(com.ebay.nautilus.domain.dcs.DcsDomain.Search.B.spellAutoCorrect), deviceconfiguration.get(com.ebay.mobile.dcs.Dcs.App.B.ebayPlus));
    }

    public static int getEbayNowResourceForCountry(EbayCountry ebaycountry)
    {
        return !"GB".equals(ebaycountry.getCountryCode()) ? 0x7f0700d9 : 0x7f0700db;
    }

    public static FollowedEntityDataManager getFollowedEntityDataManager(EbayContext ebaycontext)
    {
        if (Looper.getMainLooper() == Looper.myLooper())
        {
            return (FollowedEntityDataManager)DataManager.get(ebaycontext, FollowedEntityDataManager.KEY);
        }
        ebaycontext = new FutureTask(new Callable(ebaycontext) {

            final EbayContext val$ebayContext;

            public FollowedEntityDataManager call()
                throws Exception
            {
                return (FollowedEntityDataManager)DataManager.get(ebayContext, FollowedEntityDataManager.KEY);
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                ebayContext = ebaycontext;
                super();
            }
        });
        (new Handler(Looper.getMainLooper())).post(ebaycontext);
        try
        {
            ebaycontext = (FollowedEntityDataManager)ebaycontext.get();
        }
        // Misplaced declaration of an exception variable
        catch (EbayContext ebaycontext)
        {
            Log.w("SearchUtil", (new StringBuilder()).append("Unable to obtain FollowedEntityDataManager instance: ").append(ebaycontext.getMessage()).toString());
            return null;
        }
        return ebaycontext;
    }

    public static int getInStorePickupResourceForCountry(EbayCountry ebaycountry)
    {
        ebaycountry = ebaycountry.getCountryCode();
        return !"GB".equals(ebaycountry) && !"AU".equals(ebaycountry) ? 0x7f0700da : 0x7f070ce3;
    }

    public static int getNewFollowItemCountSince(EbayContext ebaycontext, String s, long l)
    {
        Context context = (Context)ebaycontext.getExtension(android/content/Context);
        NautilusKernel.verifyNotMain();
        try
        {
            s = new FutureTask(new Callable(ebaycontext, s) {

                final EbayContext val$ebayContext;
                final String val$searchId;

                public FollowDescriptor call()
                    throws Exception
                {
                    return SearchUtil.getFollowedEntityDataManager(ebayContext).getFollowByInterestId(searchId);
                }

                public volatile Object call()
                    throws Exception
                {
                    return call();
                }

            
            {
                ebayContext = ebaycontext;
                searchId = s;
                super();
            }
            });
            (new Handler(Looper.getMainLooper())).post(s);
            s = ((FollowDescriptor)s.get()).interest.getSearchParameters(eBayDictionaryProvider.getDefaultSearchParameters(context, null));
            s.sinceTime = l;
            s.queryIntent = com.ebay.common.net.api.search.SearchParameters.QueryIntent.CountOnly;
            if (MyApp.getDeviceConfiguration().getConfig().get(DcsBoolean.SearchUseSearchServiceV2))
            {
                s = new SearchServiceRequestV2(s, 1, null, getDefaultSearchConfig(false, MyApp.getPrefs()), 0);
            } else
            {
                s = new SearchServiceRequestV1(s, 1, null, getDefaultSearchConfig(false, MyApp.getPrefs()));
            }
            return ((SearchServiceResponse)ebaycontext.getConnector().sendRequest(s)).getTotalCount();
        }
        // Misplaced declaration of an exception variable
        catch (EbayContext ebaycontext)
        {
            Log.w("SearchUtil", (new StringBuilder()).append("getNewFollowItemCountSince(): ").append(ebaycontext.getMessage()).toString());
            return 0;
        }
        // Misplaced declaration of an exception variable
        catch (EbayContext ebaycontext)
        {
            Log.w("SearchUtil", (new StringBuilder()).append("getNewFollowItemCountSince(): ").append(ebaycontext.getMessage()).toString());
        }
        return 0;
    }

    public static int getPudoResourceForCountry(EbayCountry ebaycountry)
    {
        if (ebaycountry == null)
        {
            throw new IllegalArgumentException("country must not be null");
        }
        int i = 0x7f070ce3;
        if ("GB".equals(ebaycountry.getCountryCode()))
        {
            i = 0x7f070ce4;
        }
        return i;
    }

    public static SearchParameters getSearchParametersForFollowedSearchId(Context context, EbayContext ebaycontext, String s)
    {
        return getSearchParametersForFollowedSearchId(context, ebaycontext, s, Long.valueOf(SHOW_ALL_LISTINGS));
    }

    public static SearchParameters getSearchParametersForFollowedSearchId(Context context, EbayContext ebaycontext, String s, Long long1)
    {
        SearchParameters searchparameters = null;
        if (DeviceConfiguration.getAsync().get(DcsBoolean.searchSavedSearchUseFollowInterest)) goto _L2; else goto _L1
_L1:
        ebaycontext = searchparameters;
_L4:
        return ebaycontext;
_L2:
        FollowDescriptor followdescriptor = getFollowedEntityDataManager(ebaycontext).getFollowByInterestId(s);
        ebaycontext = searchparameters;
        if (followdescriptor == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        searchparameters = followdescriptor.interest.getSearchParameters(eBayDictionaryProvider.getDefaultSearchParameters(context, null));
        ebaycontext = MyApp.getPrefs().getAuthentication();
        if (ebaycontext != null)
        {
            searchparameters.iafToken = ((Authentication) (ebaycontext)).iafToken;
        }
        if (long1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        ebaycontext = searchparameters;
        if (long1.longValue() != SHOW_ALL_LISTINGS)
        {
            searchparameters.sinceTime = long1.longValue();
            return searchparameters;
        }
        if (true) goto _L4; else goto _L3
_L3:
        context = (new ItemCache(context)).getSavedSearches();
        ebaycontext = searchparameters;
        if (context != null)
        {
            context = (com.ebay.mobile.notifications.PollService.SavedSearchPollData)context.get(Long.valueOf(Long.parseLong(s)));
            ebaycontext = searchparameters;
            if (context != null)
            {
                ebaycontext = searchparameters;
                if (PollServiceListCache.hasNew(context))
                {
                    long l = PollServiceListCache.getSinceTime(context);
                    ebaycontext = searchparameters;
                    if (l > 0L)
                    {
                        searchparameters.sinceTime = l;
                        return searchparameters;
                    }
                }
            }
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public static String getTitleForExpansion(Context context, com.ebay.common.content.dm.SearchDataManager.SearchExpansionDescriptor searchexpansiondescriptor, SearchParameters searchparameters)
    {
        KnownSearchExpansion knownsearchexpansion = searchexpansiondescriptor.expansionType;
        if (knownsearchexpansion == KnownSearchExpansion.CATEGORY_AUTORUN_NULL)
        {
            return context.getString(0x7f07095b, new Object[] {
                searchparameters.category.name
            });
        }
        if (knownsearchexpansion == KnownSearchExpansion.CATEGORY_LOW_RESULT)
        {
            return context.getString(0x7f07095a, new Object[] {
                searchparameters.keywords
            });
        }
        if (knownsearchexpansion == KnownSearchExpansion.CROSS_BORDER)
        {
            int i = (int)searchexpansiondescriptor.getAbridgedMatchCount();
            return context.getResources().getQuantityString(0x7f080028, i, new Object[] {
                Integer.valueOf(i)
            });
        }
        if (knownsearchexpansion == KnownSearchExpansion.KEYWORD_REMOVAL)
        {
            int j = searchexpansiondescriptor.getItems().size();
            return context.getResources().getQuantityString(0x7f080029, j, new Object[] {
                Integer.valueOf(j), searchparameters.keywords
            });
        }
        if (knownsearchexpansion == KnownSearchExpansion.SPELL_CHECK_AUTO)
        {
            searchexpansiondescriptor = searchexpansiondescriptor.expansion;
            return context.getString(0x7f07095c, new Object[] {
                (String)((SearchExpansion) (searchexpansiondescriptor)).expansionResult.metaAttributes.get("original_user_query"), (String)((SearchExpansion) (searchexpansiondescriptor)).expansionResult.metaAttributes.get("correction")
            });
        }
        if (knownsearchexpansion == KnownSearchExpansion.SPELL_CHECK_SUGGESTED)
        {
            return context.getString(0x7f07095d, new Object[] {
                (String)searchexpansiondescriptor.expansion.expansionResult.metaAttributes.get("correction")
            });
        } else
        {
            return context.getString(0x7f070959);
        }
    }

    public static String getTitleForRewrite(Context context, RewriteStartSrpListItem rewritestartsrplistitem)
    {
        KnownSearchExpansion knownsearchexpansion = rewritestartsrplistitem.expansionDescriptor.expansionType;
        com.ebay.common.net.api.search.SearchExpansion.ExpansionResult expansionresult = rewritestartsrplistitem.expansionDescriptor.expansion.expansionResult;
        SearchParameters searchparameters = rewritestartsrplistitem.expansionDescriptor.expansionSearchParameters;
        if (expansionresult.rewriteDescriptor != null && !TextUtils.isEmpty(expansionresult.rewriteDescriptor.displayMessage))
        {
            return expansionresult.rewriteDescriptor.displayMessage;
        }
        if (knownsearchexpansion == KnownSearchExpansion.CATEGORY_AUTORUN_NULL)
        {
            if (searchparameters.category == null)
            {
                rewritestartsrplistitem = context.getString(0x7f07096c);
            } else
            {
                rewritestartsrplistitem = searchparameters.category.name;
            }
            return context.getString(0x7f07095b, new Object[] {
                rewritestartsrplistitem
            });
        }
        if (knownsearchexpansion == KnownSearchExpansion.CATEGORY_LOW_RESULT)
        {
            return context.getString(0x7f07095a, new Object[] {
                searchparameters.keywords
            });
        }
        if (knownsearchexpansion == KnownSearchExpansion.CROSS_BORDER)
        {
            int i = (int)expansionresult.abridgedMatchCount;
            return context.getResources().getQuantityString(0x7f080028, i, new Object[] {
                Integer.valueOf(i)
            });
        }
        if (knownsearchexpansion == KnownSearchExpansion.KEYWORD_REMOVAL)
        {
            int j = rewritestartsrplistitem.count;
            return context.getResources().getQuantityString(0x7f080029, j, new Object[] {
                Integer.valueOf(j), searchparameters.keywords
            });
        }
        if (knownsearchexpansion == KnownSearchExpansion.SPELL_CHECK_AUTO)
        {
            return context.getString(0x7f07095c, new Object[] {
                (String)expansionresult.metaAttributes.get("original_user_query"), (String)expansionresult.metaAttributes.get("correction")
            });
        }
        if (knownsearchexpansion == KnownSearchExpansion.SPELL_CHECK_SUGGESTED)
        {
            return context.getString(0x7f07095d, new Object[] {
                (String)expansionresult.metaAttributes.get("correction")
            });
        } else
        {
            return context.getString(0x7f070959);
        }
    }

    public static void initializeDataManager(EbayContext ebaycontext, DataManager datamanager)
    {
        if (datamanager instanceof FollowedEntityDataManager)
        {
            if (dcsRefreshObserver == null)
            {
                dcsRefreshObserver = new DcsRefreshObserver(ebaycontext);
                DeviceConfiguration.registerObserver(dcsRefreshObserver);
            }
            validateCacheRelevance((FollowedEntityDataManager)datamanager);
        }
    }

    public static boolean isSearchLocallyRefined(SearchParameters searchparameters)
    {
        return searchparameters.ebnOnly || searchparameters.inStorePickupOnly || searchparameters.localPickupOnly;
    }

    public static boolean isZipCodeDefault(String s)
    {
        PostalCodeSpecification postalcodespecification = MyApp.getPrefs().getShipToPostalCode();
        if (postalcodespecification != null && postalcodespecification.postalCode != null && s != null)
        {
            return postalcodespecification.postalCode.equals(s);
        } else
        {
            return TextUtils.isEmpty(s);
        }
    }

    public static void purgeFollowCaches(Context context)
    {
        FollowedEntityDataManager.purgeCache(context);
    }

    public static void purgeSavedSearchCaches(EbayContext ebaycontext)
    {
        Context context = (Context)ebaycontext.getExtension(android/content/Context);
        (new UserCache(context, ebaycontext)).clearSavedSearchList();
        (new ItemCache(context)).purgeSavedSearches();
    }

    public static boolean showShippingCosts()
    {
        EbayCountry ebaycountry = EbayApiUtil.getCurrentCountry();
        PostalCodeSpecification postalcodespecification = MyApp.getPrefs().getPostalCode();
        return postalcodespecification != null && ebaycountry != null && ebaycountry.getCountryCode().equals(postalcodespecification.countryCode) && !TextUtils.isEmpty(postalcodespecification.postalCode);
    }

    public static String toSHA1(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return "";
        }
        try
        {
            s = s.getBytes("UTF-8");
            s = byteToHex(MessageDigest.getInstance("SHA1").digest(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("toSHA1", "toSHA1 failed", s);
            return "";
        }
        return s;
    }

    public static boolean useSearchService(SearchParameters searchparameters)
    {
        if (!DeviceConfiguration.getAsync().get(DcsBoolean.SearchUseSearchService))
        {
            return false;
        } else
        {
            return SearchServiceApi.useSearchService(searchparameters, null);
        }
    }

    static void validateCacheRelevance(FollowedEntityDataManager followedentitydatamanager)
    {
        Object obj = DeviceConfiguration.getAsync();
        Context context = MyApp.getApp().getApplicationContext();
        String s = MyApp.getPrefs().getGlobalPref("lastSavedSearchUser", null);
        String s1 = MyApp.getPrefs().getCurrentUser();
        String s2;
        boolean flag;
        boolean flag1;
        if (TextUtils.isEmpty(s1) || !s1.equals(s))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s2 = MyApp.getPrefs().getGlobalPref("lastSavedSearchProvider", "Fuss");
        if (((DeviceConfiguration) (obj)).get(DcsBoolean.searchSavedSearchUseFollowInterest))
        {
            obj = "Follow";
        } else
        {
            obj = "Fuss";
        }
        flag1 = flag;
        if (!((String) (obj)).equals(s2))
        {
            MyApp.getPrefs().setGlobalPref(((String) (obj)), "lastSavedSearchProvider");
            purgeSavedSearchCaches(followedentitydatamanager.getEbayContext());
            flag1 = flag | s2.equals("Follow");
        }
        if (flag1)
        {
            purgeFollowCaches(context);
        }
        if (flag1 || TextUtils.isEmpty(s))
        {
            MyApp.getPrefs().setGlobalPref(s1, "lastSavedSearchUser");
        }
        followedentitydatamanager.configChanged();
    }

}

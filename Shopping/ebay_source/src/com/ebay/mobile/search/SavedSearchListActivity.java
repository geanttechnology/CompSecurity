// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.ebay.android.widget.ButtonBar;
import com.ebay.android.widget.MaxSizeLinearLayout;
import com.ebay.app.AlertDialogFragment;
import com.ebay.app.DialogFragmentCallback;
import com.ebay.common.Preferences;
import com.ebay.common.UserCache;
import com.ebay.common.content.dm.FollowedEntityDataManager;
import com.ebay.common.model.followinterest.FollowType;
import com.ebay.common.model.search.EbayCategorySummary;
import com.ebay.common.model.search.SavedSearch;
import com.ebay.common.net.api.fuss.EbayFussApi;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.util.EbayAsyncTask;
import com.ebay.common.view.util.DialogManager;
import com.ebay.mobile.ActivityStarter;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.ServiceStarter;
import com.ebay.mobile.activities.BaseListActivity;
import com.ebay.mobile.activities.SignInModalActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.notifications.ItemCache;
import com.ebay.mobile.notifications.NotificationPreferenceManager;
import com.ebay.mobile.notifications.NotificationUtil;
import com.ebay.mobile.notifications.PollServiceListCache;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbayCurrency;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.DatedContent;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.PostalCodeSpecification;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

// Referenced classes of package com.ebay.mobile.search:
//            SearchUtil, SavedSearchList

public class SavedSearchListActivity extends BaseListActivity
    implements android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener, android.view.View.OnClickListener, android.widget.AdapterView.OnItemClickListener, android.widget.AdapterView.OnItemLongClickListener, DialogFragmentCallback, com.ebay.common.UserCache.IUpdateSavedSearch
{
    private static final class DeleteSavedSearchesAsyncTask extends EbayAsyncTask
    {

        private final EbayFussApi api;
        private final String iafToken;
        private final List ids;

        protected Boolean doInBackgroundInternal(Object obj)
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
        {
            boolean flag = true;
            obj = ids.iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                String s = (String)((Iterator) (obj)).next();
                if (!api.removeFavoriteSearch(iafToken, s, null))
                {
                    flag = false;
                }
            } while (true);
            return Boolean.valueOf(flag);
        }

        protected volatile Object doInBackgroundInternal(Object obj)
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
        {
            return doInBackgroundInternal(obj);
        }

        protected void onPostExecute(Boolean boolean1)
        {
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Boolean)obj);
        }

        protected DeleteSavedSearchesAsyncTask(EbayContext ebaycontext, String s, List list)
        {
            api = EbayApiUtil.getFindingUserSettingsApi(ebaycontext);
            iafToken = s;
            ids = list;
        }
    }

    private static final class SaveSavedSearchesAsyncTask extends AsyncTask
    {

        private final Context context;
        private final EbayContext ebayContext;
        private final Observer observer;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            NotificationUtil.updateNotificationSubscriptions(context, ebayContext, Arrays.asList(as));
            return null;
        }

        protected volatile void onCancelled(Object obj)
        {
            onCancelled((Void)obj);
        }

        protected void onCancelled(Void void1)
        {
            super.onCancelled(void1);
            if (observer != null)
            {
                observer.onSearchesSaved(false);
            }
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            if (observer != null)
            {
                observer.onSearchesSaved(true);
            }
        }

        public SaveSavedSearchesAsyncTask(SavedSearchListActivity savedsearchlistactivity, Observer observer1)
        {
            observer = observer1;
            context = savedsearchlistactivity.getApplication();
            ebayContext = savedsearchlistactivity.getEbayContext();
        }
    }

    public static interface SaveSavedSearchesAsyncTask.Observer
    {

        public abstract void onSearchesSaved(boolean flag);
    }

    private class SavedSearchAdapter extends ArrayAdapter
    {

        private final String addToast;
        private final android.view.View.OnClickListener checkboxListener = new _cls2();
        private final LayoutInflater inflater;
        private final String removeToast;
        private List skipPositions;
        final SavedSearchListActivity this$0;
        private final android.view.View.OnClickListener toggleImageListener = new _cls1();
        private final Drawable toggleOff;
        private final Drawable toggleOn;

        private boolean isProgressOn()
        {
            return swipeContainer.isRefreshing();
        }

        private void updateSkipPositions()
        {
            skipPositions.clear();
            int i = super.getCount();
            for (Integer integer = Integer.valueOf(0); integer.intValue() < i; integer = Integer.valueOf(integer.intValue() + 1))
            {
                if (TextUtils.isEmpty(((SavedSearch)super.getItem(integer.intValue())).id))
                {
                    skipPositions.add(integer);
                }
            }

        }

        public int getCount()
        {
            return super.getCount() - skipPositions.size();
        }

        public SavedSearch getItem(int i)
        {
            int j = 0;
            Iterator iterator = skipPositions.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                if (((Integer)iterator.next()).intValue() <= i)
                {
                    j++;
                }
            } while (true);
            return (SavedSearch)super.getItem(i + j);
        }

        public volatile Object getItem(int i)
        {
            return getItem(i);
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            boolean flag = false;
            SavedSearch savedsearch = getItem(i);
            viewgroup = view;
            if (savedsearch != null)
            {
                viewgroup = view;
                if (pollMap != null)
                {
                    int j;
                    if (view == null)
                    {
                        view = inflater.inflate(0x7f0301eb, null);
                    } else
                    {
                        view.setVisibility(0);
                    }
                    ((TextView)view.findViewById(0x7f100616)).setText(savedsearch.name);
                    viewgroup = (com.ebay.mobile.notifications.PollService.SavedSearchPollData)pollMap.get(Long.valueOf(Long.parseLong(savedsearch.id)));
                    if (viewgroup != null && PollServiceListCache.hasNew(viewgroup))
                    {
                        j = 1;
                    } else
                    {
                        j = 0;
                    }
                    viewgroup = view.findViewById(0x7f100615);
                    if (j != 0)
                    {
                        j = ((flag) ? 1 : 0);
                    } else
                    {
                        j = 4;
                    }
                    viewgroup.setVisibility(j);
                    viewgroup = (ImageView)view.findViewById(0x7f10006b);
                    if (isMarkedForDeletion(savedsearch))
                    {
                        viewgroup.setImageResource(0x7f020055);
                    } else
                    {
                        viewgroup.setImageResource(0x7f020053);
                    }
                    viewgroup.setOnClickListener(checkboxListener);
                    viewgroup.setTag(Integer.valueOf(i));
                    viewgroup = (ImageView)view.findViewById(0x7f100613);
                    if (notificationPrefs.isNotifyEnabledForSavedSearch(auth.user, savedsearch.id))
                    {
                        viewgroup.setImageDrawable(toggleOn);
                    } else
                    {
                        viewgroup.setImageDrawable(toggleOff);
                    }
                    viewgroup.setTag(Integer.valueOf(i));
                    viewgroup.setOnClickListener(toggleImageListener);
                    viewgroup = view;
                }
            }
            return viewgroup;
        }

        public boolean hasDuplicateIds()
        {
            HashSet hashset = new HashSet();
            int j = getCount();
            int i = 0;
            while (i < j) 
            {
                SavedSearch savedsearch = getItem(i);
                if (!TextUtils.isEmpty(savedsearch.id))
                {
                    if (hashset.contains(savedsearch.id))
                    {
                        return true;
                    }
                    hashset.add(savedsearch.id);
                }
                i++;
            }
            return false;
        }

        public void notifyDataSetChanged()
        {
            super.notifyDataSetChanged();
            updateSkipPositions();
        }

        public boolean onClickCheckboxOrLongClick(View view, SavedSearch savedsearch)
        {
            while (savedsearch == null || isProgressOn() || (ImageView)view.findViewById(0x7f10006b) == null) 
            {
                return false;
            }
            toggleDeleteStatus(savedsearch);
            notifyDataSetChanged();
            return true;
        }




        SavedSearchAdapter(Activity activity)
        {
            this$0 = SavedSearchListActivity.this;
            super(activity, 0x7f0301eb, UserCache.getSavedSearchList().getSearchList());
            skipPositions = new ArrayList();
            updateSkipPositions();
            inflater = activity.getLayoutInflater();
            savedsearchlistactivity = activity.getResources();
            addToast = activity.getString(0x7f07012a);
            removeToast = activity.getString(0x7f070918);
            toggleOn = getDrawable(0x7f020288);
            toggleOff = getDrawable(0x7f020287);
        }
    }

    static interface SavedSearchConstants
    {

        public static final String URL_BUYING_FORMATS_ADS = "CLASSIFIED";
        public static final String URL_BUYING_FORMATS_BID = "AUCTION_NOT_WITH_BIN";
        public static final String URL_BUYING_FORMATS_BIN = "AUCTION_WITH_BIN";
        public static final String URL_CONDITION_NEW = "1";
        public static final String URL_CONDITION_UNSPECIFIED = "0";
        public static final String URL_CONDITION_USED = "2";
        public static final String URL_PARAM_ADS = "LH_CAds";
        public static final String URL_PARAM_AVAILABLE_TO = "LH_AvailTo";
        public static final String URL_PARAM_AVAILABLE_TO_COUNTRY = "_saact";
        public static final String URL_PARAM_BID = "LH_Auction";
        public static final String URL_PARAM_BIN = "LH_BIN";
        public static final String URL_PARAM_BUYING_FORMATS = "fslistingtypes";
        public static final String URL_PARAM_CATEGORY = "_sacat";
        public static final String URL_PARAM_COMPLETED = "LH_Complete";
        public static final String URL_PARAM_CONDITION = "LH_ItemCondition";
        public static final String URL_PARAM_DESCRIPTION_SEARCH = "LH_TitleDesc";
        public static final String URL_PARAM_FREE_SHIPPING = "LH_FS";
        public static final String URL_PARAM_KEYWORDS = "_nkw";
        public static final String URL_PARAM_LOCATED_IN = "LH_LocatedIn";
        public static final String URL_PARAM_LOCATED_IN_COUNTRY = "_salic";
        public static final String URL_PARAM_MAX_DISTANCE = "_sadis";
        public static final String URL_PARAM_PAYPAL_ACCEPTED = "LH_PayPal";
        public static final String URL_PARAM_POSTAL_CODE = "_fpos";
        public static final String URL_PARAM_PRICE_MAX = "_udhi";
        public static final String URL_PARAM_PRICE_MIN = "_udlo";
        public static final String URL_PARAM_PRICE_RANGE = "LH_Price";
        public static final String URL_PARAM_SELLER_ID = "_sasl";
        public static final String URL_PARAM_SORT = "_sop";
        public static final String URL_POSTAL_CODE_DEFAULT = "Zip code";
        public static final int URL_SORT_BEST_MATCH = 12;
        public static final int URL_SORT_ENDING_SOONEST = 1;
        public static final int URL_SORT_NEAREST = 7;
        public static final int URL_SORT_NEWLY_LISTED = 10;
        public static final int URL_SORT_PRICE_HIGHEST = 3;
        public static final int URL_SORT_PRICE_LOWEST = 2;
        public static final int URL_SORT_PRICE_PLUS_SHIPPING_HIGHEST = 16;
        public static final int URL_SORT_PRICE_PLUS_SHIPPING_LOWEST = 15;
    }

    public static class SearchQueryParser
    {

        private SavedSearch _savedSearch;
        private SearchParameters _searchParams;
        private Uri _uri;
        private Authentication auth;

        private boolean isLocSet(String s, String s1)
        {
            s = _uri.getQueryParameter(s);
            if (s != null && s.equals("1"))
            {
                s = _uri.getQueryParameter(s1);
                if (s != null)
                {
                    if (s.equals("1"))
                    {
                        s = EbaySite.US;
                    } else
                    {
                        s = EbaySite.getInstanceFromId(s);
                    }
                    if (s != null && _searchParams.countryId.equals(((EbaySite) (s)).localeCountry))
                    {
                        return true;
                    }
                }
            }
            return false;
        }

        private List mySplit(String s, String s1)
        {
            s = new StringTokenizer(s, s1);
            s1 = new ArrayList();
            for (; s.hasMoreTokens(); s1.add(s.nextToken())) { }
            return s1;
        }

        private void setCategory()
        {
            String s = _uri.getQueryParameter("_sacat");
            if (TextUtils.isEmpty(s) || !TextUtils.isDigitsOnly(s)) goto _L2; else goto _L1
_L1:
            _searchParams.category = new EbayCategorySummary(Long.valueOf(s).longValue(), null);
_L4:
            return;
_L2:
            String s1;
            Object obj = _uri.getPathSegments();
            if (((List) (obj)).size() <= 1)
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = ((List) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    continue; /* Loop/switch isn't completed */
                }
                s1 = (String)((Iterator) (obj)).next();
            } while (TextUtils.isEmpty(s1) || !TextUtils.isDigitsOnly(s1));
            break; /* Loop/switch isn't completed */
            if (true) goto _L4; else goto _L3
_L3:
            _searchParams.category = new EbayCategorySummary(Long.valueOf(s1).longValue(), null);
            return;
        }

        private void setCompletedListings()
        {
            String s = _uri.getQueryParameter("LH_Complete");
            if (s != null && s.equals("1"))
            {
                _searchParams.completedListings = true;
                String s1;
                if (auth == null)
                {
                    s1 = null;
                } else
                {
                    s1 = auth.iafToken;
                }
                _searchParams.iafToken = s1;
            }
        }

        private void setCondition()
        {
            Object obj = _uri.getQueryParameter("LH_ItemCondition");
            if (obj != null)
            {
                obj = mySplit(((String) (obj)), "|").iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break;
                    }
                    String s = (String)((Iterator) (obj)).next();
                    if (s.equals("0"))
                    {
                        _searchParams.condition = "Unspecified";
                    } else
                    if (s.equals("1"))
                    {
                        _searchParams.condition = "New";
                    } else
                    if (s.equals("2"))
                    {
                        _searchParams.condition = "Used";
                    }
                } while (true);
            }
        }

        private void setDescriptionSearch()
        {
            String s = _uri.getQueryParameter("LH_TitleDesc");
            if (s != null && s.equals("1"))
            {
                _searchParams.descriptionSearch = true;
            }
        }

        private void setFreeShipping()
        {
            String s = _uri.getQueryParameter("LH_FS");
            if (s != null && s.equals("1"))
            {
                _searchParams.freeShipping = true;
            }
        }

        private void setKeyword()
        {
            String s = _uri.getQueryParameter("_nkw");
            _searchParams.keywords = s;
            if (TextUtils.isEmpty(s) && !TextUtils.isEmpty(_savedSearch.keywords))
            {
                _searchParams.keywords = _savedSearch.keywords;
            }
        }

        private void setListingFormats()
        {
            Object obj = _uri.getQueryParameter("fslistingtypes");
            boolean flag5 = false;
            boolean flag2 = false;
            boolean flag4 = false;
            boolean flag = false;
            if (obj != null)
            {
                obj = mySplit(((String) (obj)), "|").iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break;
                    }
                    String s1 = (String)((Iterator) (obj)).next();
                    if (s1.equalsIgnoreCase("AUCTION_WITH_BIN"))
                    {
                        _searchParams.buyingFormat = 6;
                        flag = true;
                    } else
                    if (s1.equalsIgnoreCase("AUCTION_NOT_WITH_BIN"))
                    {
                        _searchParams.buyingFormat = 5;
                        flag2 = true;
                    }
                } while (true);
                if (flag2 && flag)
                {
                    _searchParams.buyingFormat = 7;
                }
            } else
            {
                String s = _uri.getQueryParameter("LH_Auction");
                boolean flag1 = flag5;
                if (s != null)
                {
                    flag1 = flag5;
                    if (s.equals("1"))
                    {
                        _searchParams.buyingFormat = 5;
                        flag1 = true;
                    }
                }
                s = _uri.getQueryParameter("LH_BIN");
                boolean flag3 = flag4;
                if (s != null)
                {
                    flag3 = flag4;
                    if (s.equals("1"))
                    {
                        _searchParams.buyingFormat = 6;
                        flag3 = true;
                    }
                }
                if (flag1 && flag3)
                {
                    _searchParams.buyingFormat = 7;
                    return;
                }
            }
        }

        private void setLocation()
        {
            if (isLocSet("LH_LocatedIn", "_salic"))
            {
                _searchParams.searchLocalCountryOnly = true;
            } else
            if (isLocSet("LH_AvailTo", "_saact"))
            {
                _searchParams.searchOtherCountries = true;
                return;
            }
        }

        private void setMaxDistance()
        {
            String s = _uri.getQueryParameter("_fpos");
            String s1 = _uri.getQueryParameter("_sadis");
            try
            {
                if (!TextUtils.isEmpty(s) && !s.equals("Zip code"))
                {
                    _searchParams.buyerPostalCode = s;
                    if (!TextUtils.isEmpty(s1))
                    {
                        _searchParams.maxDistance = Integer.valueOf(s1).intValue();
                    }
                }
                return;
            }
            catch (NumberFormatException numberformatexception)
            {
                Log.w("SavedSearchListActivity", (new StringBuilder()).append("maxDistance NumberFormatException: ").append(_savedSearch.query).toString());
            }
        }

        private void setPayWithPaypal()
        {
            String s = _uri.getQueryParameter("LH_PayPal");
            if (s != null && s.equals("1"))
            {
                _searchParams.paypalAccepted = true;
            }
        }

        private void setPrices()
        {
            String s4 = _uri.getQueryParameter("_udhi");
            String s2 = _uri.getQueryParameter("_udlo");
            String s = s4;
            String s1 = s2;
            if (TextUtils.isEmpty(s4))
            {
                s = s4;
                s1 = s2;
                if (TextUtils.isEmpty(s2))
                {
                    String s5 = _uri.getQueryParameter("LH_Price");
                    s = s4;
                    s1 = s2;
                    if (!TextUtils.isEmpty(s5))
                    {
                        int i = s5.indexOf("..");
                        s = s4;
                        s1 = s2;
                        if (i != -1)
                        {
                            String s3 = s5.substring(0, i);
                            int j = s5.indexOf("@");
                            s = s4;
                            s1 = s3;
                            if (i + 2 < s5.length())
                            {
                                if (j != -1)
                                {
                                    s = s5.substring(i + 2, j);
                                    s1 = s3;
                                } else
                                {
                                    s = s5.substring(i + 2);
                                    s1 = s3;
                                }
                            }
                        }
                    }
                }
            }
            try
            {
                s3 = _searchParams.country.getCurrency().getCurrencyCode();
                if (!TextUtils.isEmpty(s))
                {
                    _searchParams.maxPrice = new ItemCurrency(s3, String.valueOf(NumberFormat.getInstance().parse(s).doubleValue()));
                }
                if (!TextUtils.isEmpty(s1))
                {
                    _searchParams.minPrice = new ItemCurrency(s3, String.valueOf(NumberFormat.getInstance().parse(s1).doubleValue()));
                }
                return;
            }
            catch (ParseException parseexception)
            {
                Log.w("SavedSearchListActivity", (new StringBuilder()).append("min/max price ParseException: ").append(_savedSearch.query).toString());
            }
        }

        private void setSellerId()
        {
            String s = _uri.getQueryParameter("_sasl");
            if (s != null)
            {
                _searchParams.sellerId = s;
            }
        }

        private void setSite()
        {
            EbayCountry ebaycountry = EbayCountry.getInstance(EbaySite.getInstanceFromDomain(_uri.getHost(), EbaySite.US));
            _searchParams.country = ebaycountry;
            _searchParams.countryId = ebaycountry.getCountryCode();
            PostalCodeSpecification postalcodespecification = MyApp.getPrefs().getPostalCode();
            if (postalcodespecification != null && ebaycountry.getCountryCode().equals(postalcodespecification.countryCode) && !TextUtils.isEmpty(postalcodespecification.postalCode))
            {
                _searchParams.buyerPostalCode = postalcodespecification.postalCode;
                return;
            } else
            {
                _searchParams.hideShipping = true;
                return;
            }
        }

        private void setSort()
        {
            String s = _uri.getQueryParameter("_sop");
            if (s == null)
            {
                return;
            }
            switch (Integer.valueOf(s).intValue())
            {
            default:
                return;

            case 1: // '\001'
                _searchParams.sortOrder = "EndTimeSoonest";
                return;

            case 12: // '\f'
                _searchParams.sortOrder = "BestMatch";
                return;

            case 15: // '\017'
                _searchParams.sortOrder = "PricePlusShippingLowest";
                return;

            case 16: // '\020'
                _searchParams.sortOrder = "PricePlusShippingHighest";
                return;

            case 10: // '\n'
                _searchParams.sortOrder = "StartTimeNewest";
                return;

            case 7: // '\007'
                _searchParams.sortOrder = "DistanceNearest";
                return;
            }
        }

        void parse()
        {
            setSite();
            setKeyword();
            setCategory();
            setSellerId();
            setPrices();
            setCondition();
            setListingFormats();
            setCompletedListings();
            setFreeShipping();
            setPayWithPaypal();
            setSort();
            setDescriptionSearch();
            setMaxDistance();
            setLocation();
        }

        public SearchQueryParser(SavedSearch savedsearch, Authentication authentication)
        {
            auth = authentication;
            if (TextUtils.isEmpty(savedsearch.query))
            {
                if (savedsearch.searchParameters != null)
                {
                    savedsearch.keywords = savedsearch.searchParameters.keywords;
                    _savedSearch.setQueryParsed(true);
                    return;
                } else
                {
                    Log.w("SavedSearchListActivity", "SearchQueryParser, invalid input saved search: both query and search params are null");
                    return;
                }
            }
            try
            {
                _uri = Uri.parse(savedsearch.query.replace("+", "%20"));
                _searchParams = savedsearch.searchParameters;
                _savedSearch = savedsearch;
                parse();
                _savedSearch.setQueryParsed(true);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (SavedSearch savedsearch)
            {
                Log.w("SavedSearchListActivity", (new StringBuilder()).append("MalformedURL: ").append(_savedSearch.query).toString());
            }
        }
    }


    private static final int DIALOG_DELETE = 42;
    private static final String LOG_TAG = "SavedSearchListActivity";
    private static final String TODELETE_KEY = "todelete";
    private Authentication auth;
    private boolean bRefreshSearch;
    private ButtonBar bottomRibbon;
    private EbayCountry country;
    private int currentPositionY;
    private ItemCache itemCache;
    private SavedSearchAdapter listAdapter;
    private ListView listView;
    private NotificationPreferenceManager notificationPrefs;
    private boolean notifyChanged;
    private TreeMap pollMap;
    private SwipeRefreshLayout swipeContainer;
    private List toDelete;
    private UserCache userCache;
    private boolean waitingForSignIn;

    public SavedSearchListActivity()
    {
        notifyChanged = false;
        bRefreshSearch = false;
        waitingForSignIn = false;
    }

    private void deleteSearch(List list)
    {
        if (auth != null)
        {
            if (useFollowInterest())
            {
                FollowedEntityDataManager followedentitydatamanager = SearchUtil.getFollowedEntityDataManager(getEbayContext());
                list = list.iterator();
                while (list.hasNext()) 
                {
                    String s = (String)list.next();
                    followedentitydatamanager.deleteFollow(FollowType.INTEREST, s, auth.iafToken);
                }
            } else
            {
                (new DeleteSavedSearchesAsyncTask(getEbayContext(), auth.iafToken, list)).execute(new Object[0]);
                return;
            }
        }
    }

    private void disableButtonBar()
    {
        bottomRibbon.setVisibility(8);
    }

    private void enableButtonBar()
    {
        Button button = (Button)bottomRibbon.findViewById(0x7f10016a);
        Button button1 = (Button)bottomRibbon.findViewById(0x7f10014c);
        bottomRibbon.setVisibility(0);
        button.setOnClickListener(this);
        button1.setOnClickListener(this);
    }

    private SourceIdentification getSourceIdentification()
    {
        return new SourceIdentification("EnterSearch", "sm", "ss");
    }

    private void loadSavedSearchList()
    {
        auth = MyApp.getPrefs().getAuthentication();
        if (auth != null)
        {
            pollMap = itemCache.getSavedSearches();
            Object obj1 = pollMap.values();
            Object obj = new ArrayList();
            SavedSearch savedsearch;
            for (obj1 = ((Collection) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((ArrayList) (obj)).add(savedsearch))
            {
                com.ebay.mobile.notifications.PollService.SavedSearchPollData savedsearchpolldata = (com.ebay.mobile.notifications.PollService.SavedSearchPollData)((Iterator) (obj1)).next();
                savedsearch = new SavedSearch(country, 25);
                savedsearch.id = savedsearchpolldata.searchId;
                savedsearch.name = savedsearchpolldata.searchName;
            }

            obj1 = UserCache.getSavedSearchList();
            if (obj1 != null)
            {
                ((SavedSearchList) (obj1)).setSearchList(((List) (obj)));
                if (itemCache.isSearchNewItemCountsReady() && itemCache.isSearchListReady())
                {
                    listView.setEnabled(true);
                    swipeContainer.setRefreshing(false);
                    String s;
                    com.ebay.mobile.notifications.PollService.SavedSearchPollData savedsearchpolldata1;
                    if (((SavedSearchList) (obj1)).size() == 0)
                    {
                        findViewById(0x7f1003df).setVisibility(0);
                        listView.setVisibility(8);
                    } else
                    {
                        findViewById(0x7f1003df).setVisibility(8);
                        try
                        {
                            if (listView.getHeaderViewsCount() == 0)
                            {
                                setListAdapter(null);
                                View view = getLayoutInflater().inflate(0x7f0301c5, null);
                                listView.addHeaderView(view, null, false);
                            }
                        }
                        catch (IllegalStateException illegalstateexception)
                        {
                            Log.e("SavedSearchListActivity", "loadSavedSearchList exception adding header", illegalstateexception);
                        }
                        listView.setVisibility(0);
                    }
                    listAdapter = new SavedSearchAdapter(this);
                    if (listAdapter.hasDuplicateIds())
                    {
                        userCache.refreshSavedSearchList();
                    }
                    if (toDelete != null)
                    {
                        if (obj == null || ((ArrayList) (obj)).isEmpty())
                        {
                            toDelete.clear();
                        } else
                        {
                            Iterator iterator = toDelete.iterator();
                            while (iterator.hasNext()) 
                            {
                                String s1 = (String)iterator.next();
                                boolean flag1 = false;
                                Iterator iterator1 = ((ArrayList) (obj)).iterator();
                                boolean flag;
                                do
                                {
                                    flag = flag1;
                                    if (!iterator1.hasNext())
                                    {
                                        break;
                                    }
                                    if (!s1.equals(((SavedSearch)iterator1.next()).id))
                                    {
                                        continue;
                                    }
                                    flag = true;
                                    break;
                                } while (true);
                                if (!flag)
                                {
                                    iterator.remove();
                                }
                            }
                        }
                    }
                    if (toDelete == null || toDelete.isEmpty())
                    {
                        disableButtonBar();
                    }
                    setListAdapter(listAdapter);
                    listView.setSelectionFromTop(currentPositionY, 0);
                } else
                {
                    swipeContainer.setRefreshing(true);
                    findViewById(0x7f1003df).setVisibility(8);
                    listView.setVisibility(0);
                }
                s = getIntent().getStringExtra("saved_search_id");
                if (!TextUtils.isEmpty(s))
                {
                    getIntent().removeExtra("saved_search_id");
                    obj1 = null;
                    obj = obj1;
                    if (pollMap != null)
                    {
                        savedsearchpolldata1 = (com.ebay.mobile.notifications.PollService.SavedSearchPollData)pollMap.get(Long.valueOf(Long.parseLong(s)));
                        obj = obj1;
                        if (savedsearchpolldata1 != null)
                        {
                            obj = obj1;
                            if (PollServiceListCache.hasNew(savedsearchpolldata1))
                            {
                                obj = Long.valueOf(PollServiceListCache.getSinceTime(savedsearchpolldata1));
                            }
                        }
                    }
                    ActivityStarter.startSavedSearch(this, getEbayContext(), s, ((Long) (obj)), getSourceIdentification());
                    return;
                }
            }
        }
    }

    private boolean toggleDeleteStatus(SavedSearch savedsearch)
    {
        if (savedsearch != null) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = false;
        if (!isMarkedForDeletion(savedsearch))
        {
            break; /* Loop/switch isn't completed */
        }
        unmarkForDeletion(savedsearch);
        if (toDelete == null || toDelete.size() == 0)
        {
            disableButtonBar();
            return false;
        }
        if (true) goto _L4; else goto _L3
_L3:
        markForDeletion(savedsearch);
        boolean flag1 = true;
        flag = flag1;
        if (toDelete != null)
        {
            flag = flag1;
            if (toDelete.size() > 0)
            {
                enableButtonBar();
                return true;
            }
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    private boolean useFollowInterest()
    {
        return DeviceConfiguration.getAsync().get(DcsBoolean.searchSavedSearchUseFollowInterest);
    }

    public String getTrackingEventName()
    {
        return "SavedSearchList";
    }

    public boolean isMarkedForDeletion(SavedSearch savedsearch)
    {
        while (savedsearch == null || toDelete == null || toDelete.size() == 0) 
        {
            return false;
        }
        return toDelete.contains(savedsearch.id);
    }

    public void markForDeletion(SavedSearch savedsearch)
    {
        if (savedsearch == null)
        {
            return;
        }
        if (toDelete == null)
        {
            toDelete = new ArrayList();
        }
        toDelete.add(savedsearch.id);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        switch (i)
        {
        default:
            return;

        case 65: // 'A'
            break;
        }
        if (j != -1)
        {
            finish();
            return;
        }
        waitingForSignIn = false;
        pollMap = itemCache.getSavedSearches();
        if (pollMap.isEmpty())
        {
            try
            {
                Thread.sleep(1000L);
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent) { }
        }
        loadSavedSearchList();
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131755370: 
            view = new com.ebay.app.AlertDialogFragment.Builder();
            view.setMessage(0x7f070261).setTitle(0x7f07025d).setPositiveButton(0x7f070cc7).setNegativeButton(0x7f070655);
            view.createFromActivity(42).show(getFragmentManager(), null);
            return;

        case 2131755340: 
            break;
        }
        if (toDelete != null)
        {
            toDelete.clear();
        }
        disableButtonBar();
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        ((MaxSizeLinearLayout)findViewById(0x7f1003de)).setMaxWidth((int)getResources().getDimension(0x7f0900cf));
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0301ea);
        listView = getListView();
        listView.setOnItemLongClickListener(this);
        listView.setOnItemClickListener(this);
        auth = MyApp.getPrefs().getAuthentication();
        if (auth == null)
        {
            startActivityForResult(SignInModalActivity.getIntentForSignIn(getTrackingEventName(), this), 65);
            waitingForSignIn = true;
        }
        Util.setAppStatus(this, getString(0x7f070949));
        userCache = new UserCache(this);
        swipeContainer = (SwipeRefreshLayout)findViewById(0x7f100612);
        swipeContainer.setOnRefreshListener(this);
        swipeContainer.setColorSchemeResources(new int[] {
            0x7f0d00df
        });
        bundle = getIntent().getStringExtra("event_type");
        if (!TextUtils.isEmpty(bundle))
        {
            ServiceStarter.startUpdateNotificationCacheService(this, bundle, null);
        }
        bRefreshSearch = getIntent().getBooleanExtra("saved_search_from_notification", false);
        country = EbayApiUtil.getCurrentCountry();
        itemCache = new ItemCache(this);
        notificationPrefs = new NotificationPreferenceManager(this);
        bottomRibbon = (ButtonBar)findViewById(0x7f100611);
    }

    protected Dialog onCreateDialog(int i)
    {
        switch (i)
        {
        default:
            return super.onCreateDialog(i);

        case 2131167174: 
            return DialogManager.createProgressDialog(this, i);
        }
    }

    public void onDialogFragmentResult(DialogFragment dialogfragment, int i, int j)
    {
        i;
        JVM INSTR tableswitch 42 42: default 20
    //                   42 21;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (j == 1)
        {
            removeSearches();
            loadSavedSearchList();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        if (useFollowInterest())
        {
            datamanagercontainer.initialize(FollowedEntityDataManager.KEY, new com.ebay.common.content.dm.FollowedEntityDataManager.SimpleObserver() {

                final SavedSearchListActivity this$0;

                public void onFollowedSearchesLoaded(FollowedEntityDataManager followedentitydatamanager, DatedContent datedcontent)
                {
                    if (isFinishing())
                    {
                        return;
                    } else
                    {
                        loadSavedSearchList();
                        return;
                    }
                }

            
            {
                this$0 = SavedSearchListActivity.this;
                super();
            }
            });
        }
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (i != 0)
        {
            adapterview = (SavedSearch)listView.getItemAtPosition(i);
            currentPositionY = getListView().getFirstVisiblePosition();
            view = (com.ebay.mobile.notifications.PollService.SavedSearchPollData)pollMap.get(Long.valueOf(Long.parseLong(((SavedSearch) (adapterview)).id)));
            boolean flag = PollServiceListCache.hasNew(view);
            adapterview.since = PollServiceListCache.getSinceTime(view);
            adapterview.newItemsOnly = flag;
            listAdapter.notifyDataSetChanged();
            if (TextUtils.isEmpty(((SavedSearch) (adapterview)).searchParameters.iafToken) && auth != null)
            {
                ((SavedSearch) (adapterview)).searchParameters.iafToken = auth.iafToken;
            }
            view = getEbayContext();
            String s = ((SavedSearch) (adapterview)).id;
            if (((SavedSearch) (adapterview)).newItemsOnly)
            {
                adapterview = Long.valueOf(((SavedSearch) (adapterview)).since);
            } else
            {
                adapterview = null;
            }
            if (!ActivityStarter.startSavedSearch(this, view, s, adapterview, getSourceIdentification()) && useFollowInterest())
            {
                userCache.refreshSavedSearchList();
                return;
            }
        }
    }

    public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (SavedSearch)listView.getItemAtPosition(i);
        return listAdapter.onClickCheckboxOrLongClick(view, adapterview);
    }

    public void onPause()
    {
        super.onPause();
        userCache.unregisterSavedSearchHandler(this);
        if (notifyChanged)
        {
            (new SaveSavedSearchesAsyncTask(this, null)).execute(notificationPrefs.getNotifyEnabledSavedSearchIdList(auth.user).toArray(new String[0]));
            notifyChanged = false;
        }
    }

    public void onRefresh()
    {
        listView.setEnabled(false);
        userCache.refreshSavedSearchList();
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        toDelete = bundle.getStringArrayList("todelete");
        if (toDelete != null && toDelete.size() > 0)
        {
            enableButtonBar();
        }
    }

    public void onResume()
    {
        super.onResume();
        if (waitingForSignIn)
        {
            return;
        }
        userCache.registerSavedSearchHandler(this);
        TrackingData trackingdata = new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION);
        trackingdata.addSourceIdentification(getIntent());
        trackingdata.send(this);
        if (getIntent().getBooleanExtra("saved_search_from_notification", false))
        {
            (new TrackingData("SearchResultsFromSSNotification", TrackingType.EVENT)).send(this);
        }
        notifyChanged = false;
        if (auth != null && bRefreshSearch)
        {
            bRefreshSearch = false;
            swipeContainer.setRefreshing(true);
            userCache.refreshSavedSearchList();
            return;
        } else
        {
            loadSavedSearchList();
            return;
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("todelete", (ArrayList)toDelete);
    }

    public void removeSearches()
    {
        ArrayList arraylist;
        Iterator iterator;
        if (toDelete == null || toDelete.size() == 0)
        {
            disableButtonBar();
            return;
        }
        arraylist = new ArrayList();
        iterator = toDelete.iterator();
_L10:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        String s;
        SavedSearchList savedsearchlist;
        int i;
        int j;
        byte byte0;
        boolean flag;
        s = (String)iterator.next();
        flag = notificationPrefs.isNotifyEnabledForSavedSearch(auth.user, s);
        byte0 = -1;
        i = 0;
        savedsearchlist = UserCache.getSavedSearchList();
        j = byte0;
        if (savedsearchlist == null) goto _L4; else goto _L3
_L3:
        Iterator iterator1 = savedsearchlist.getSearchList().iterator();
_L8:
        j = byte0;
        if (!iterator1.hasNext()) goto _L4; else goto _L5
_L5:
        if (!((SavedSearch)iterator1.next()).id.equals(s)) goto _L7; else goto _L6
_L6:
        j = i;
_L4:
        itemCache.deleteSavedSearch(s);
        if (j != -1)
        {
            savedsearchlist.remove(this, j);
            arraylist.add(s);
            if (flag)
            {
                if (useFollowInterest())
                {
                    (new SaveSavedSearchesAsyncTask(this, null)).execute(notificationPrefs.getNotifyEnabledSavedSearchIdList(auth.user).toArray(new String[0]));
                } else
                {
                    notifyChanged = true;
                }
            }
        }
        listAdapter.notifyDataSetChanged();
        continue; /* Loop/switch isn't completed */
_L7:
        i++;
        if (true) goto _L8; else goto _L2
_L2:
        if (arraylist.size() > 0)
        {
            deleteSearch(arraylist);
        }
        toDelete.clear();
        disableButtonBar();
        return;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void unmarkForDeletion(SavedSearch savedsearch)
    {
        while (savedsearch == null || toDelete == null) 
        {
            return;
        }
        toDelete.remove(savedsearch.id);
    }

    public void updateSavedSearch(SavedSearchList savedsearchlist)
    {
        loadSavedSearchList();
    }






/*
    static boolean access$602(SavedSearchListActivity savedsearchlistactivity, boolean flag)
    {
        savedsearchlistactivity.notifyChanged = flag;
        return flag;
    }

*/




    // Unreferenced inner class com/ebay/mobile/search/SavedSearchListActivity$SavedSearchAdapter$1

/* anonymous class */
    class SavedSearchAdapter._cls1
        implements android.view.View.OnClickListener
    {

        final SavedSearchAdapter this$1;

        public void onClick(View view)
        {
            while (auth == null || isProgressOn()) 
            {
                return;
            }
            int i = ((Integer)view.getTag()).intValue();
            SavedSearch savedsearch = getItem(i);
            view = (ImageView)view;
            boolean flag;
            if (!notificationPrefs.isNotifyEnabledForSavedSearch(auth.user, savedsearch.id))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                notificationPrefs.addNotifyEnabledSavedSearchId(auth.user, savedsearch.id);
            } else
            {
                notificationPrefs.removeNotifyEnabledSavedSearchId(auth.user, savedsearch.id);
            }
            if (flag)
            {
                view.setImageResource(0x7f020288);
                Toast.makeText(_fld0, addToast, 0).show();
            } else
            {
                view.setImageResource(0x7f020287);
                Toast.makeText(_fld0, removeToast, 0).show();
            }
            if (useFollowInterest())
            {
                (new SaveSavedSearchesAsyncTask(_fld0, null)).execute(notificationPrefs.getNotifyEnabledSavedSearchIdList(auth.user).toArray(new String[0]));
                return;
            } else
            {
                notifyChanged = true;
                return;
            }
        }

            
            {
                this$1 = SavedSearchAdapter.this;
                super();
            }
    }


    // Unreferenced inner class com/ebay/mobile/search/SavedSearchListActivity$SavedSearchAdapter$2

/* anonymous class */
    class SavedSearchAdapter._cls2
        implements android.view.View.OnClickListener
    {

        final SavedSearchAdapter this$1;

        public void onClick(View view)
        {
            int i = ((Integer)view.getTag()).intValue();
            SavedSearch savedsearch = getItem(i);
            onClickCheckboxOrLongClick(view, savedsearch);
        }

            
            {
                this$1 = SavedSearchAdapter.this;
                super();
            }
    }

}

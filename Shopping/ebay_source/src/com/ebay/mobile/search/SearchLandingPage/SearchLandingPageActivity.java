// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.SearchLandingPage;

import android.app.DialogFragment;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.ebay.app.AlertDialogFragment;
import com.ebay.app.DialogFragmentCallback;
import com.ebay.app.ModalProgressFragment;
import com.ebay.common.Preferences;
import com.ebay.common.UserCache;
import com.ebay.common.analytics.MimsUtil;
import com.ebay.common.model.search.EbayCategorySummary;
import com.ebay.common.model.search.SavedSearch;
import com.ebay.common.net.api.autocomplete.AutoCompleteApi;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.net.api.search.SellerOfferParameters;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.ActivityStarter;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.BaseActivity;
import com.ebay.mobile.activities.QuickSearchHandler;
import com.ebay.mobile.activities.SignInModalActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.eBayDictionaryProvider;
import com.ebay.mobile.following.EditFollowingActivity;
import com.ebay.mobile.notifications.ItemCache;
import com.ebay.mobile.notifications.PollServiceListCache;
import com.ebay.mobile.recents.RecentsDataManager;
import com.ebay.mobile.search.SavedSearchList;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.mobile.util.ScanResult;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.FollowingContentDataManager;
import com.ebay.nautilus.domain.data.FollowingContent;
import com.ebay.nautilus.domain.data.PdsSearchItemAttribute;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.ebay.mobile.search.SearchLandingPage:
//            SearchLandingPageAdapter, SearchPrefixType, SearchSuggestionAdapter

public class SearchLandingPageActivity extends BaseActivity
    implements android.app.SearchManager.OnCancelListener, android.app.SearchManager.OnDismissListener, android.content.DialogInterface.OnCancelListener, android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener, android.view.View.OnClickListener, android.view.View.OnTouchListener, android.widget.AdapterView.OnItemClickListener, DialogFragmentCallback, com.ebay.common.UserCache.IUpdateSavedSearch, SearchLandingPageAdapter.OnClearRecentSearchListener, SearchSuggestionAdapter.SearchSuggestionListener, com.ebay.nautilus.domain.content.dm.FollowingContentDataManager.Observer
{
    private static class DismissSwipeToRefreshTask extends AsyncTask
    {

        private WeakReference activityRef;
        protected CountDownLatch swipeToRefreshLatch;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            if (!isCancelled())
            {
                try
                {
                    swipeToRefreshLatch.await(20L, TimeUnit.SECONDS);
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[]) { }
            }
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            void1 = (SearchLandingPageActivity)activityRef.get();
            if (void1 != null && !void1.isFinishing())
            {
                ((SearchLandingPageActivity) (void1)).refreshLayout.setRefreshing(false);
                void1.dismissSwipeToRefreshTask = null;
            }
        }

        DismissSwipeToRefreshTask(SearchLandingPageActivity searchlandingpageactivity, int i)
        {
            activityRef = new WeakReference(searchlandingpageactivity);
            swipeToRefreshLatch = new CountDownLatch(i);
        }
    }

    private static class GetRecentFromSearchProviderTask extends AsyncTask
    {

        private WeakReference activityRef;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient List doInBackground(Void avoid[])
        {
            ArrayList arraylist = new ArrayList();
            if (!isCancelled())
            {
                avoid = (SearchLandingPageActivity)activityRef.get();
                if (avoid != null)
                {
                    android.net.Uri.Builder builder = (new android.net.Uri.Builder()).scheme("content").authority("com.ebay.mobile.ebaysearch").appendPath("search_suggest_query").appendPath("searchLanding");
                    int i = 5;
                    Cursor cursor = avoid.getApplicationContext().getContentResolver().query(builder.build(), null, null, new String[] {
                        ""
                    }, null);
                    if (cursor != null)
                    {
                        String s1 = SearchPrefixType.SELLER.getName();
                        String s2 = SearchPrefixType.UPC.getName();
                        String s3 = SearchPrefixType.EAN.getName();
                        while (cursor.moveToNext() && i > 0) 
                        {
                            String s = cursor.getString(cursor.getColumnIndex("suggest_text_1"));
                            if (!TextUtils.isEmpty(s))
                            {
                                SearchPrefixType searchprefixtype = SearchPrefixType.NORMAL;
                                avoid = s;
                                if (s.regionMatches(true, 0, s1, 0, s1.length()))
                                {
                                    avoid = s.substring(s1.length());
                                    searchprefixtype = SearchPrefixType.SELLER;
                                } else
                                if (s.regionMatches(true, 0, s2, 0, s2.length()))
                                {
                                    avoid = s.substring(s2.length());
                                    searchprefixtype = SearchPrefixType.UPC;
                                } else
                                if (s.regionMatches(true, 0, s3, 0, s3.length()))
                                {
                                    avoid = s.substring(s3.length());
                                    searchprefixtype = SearchPrefixType.EAN;
                                }
                                arraylist.add(new SearchLandingPageAdapter.RecentsAdapterItem(avoid, SearchLandingPageAdapter.RecentsAdapterItem.ItemType.RECENT_SEARCH, searchprefixtype));
                                i--;
                            }
                        }
                        cursor.close();
                    }
                }
            }
            return arraylist;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((List)obj);
        }

        protected void onPostExecute(List list)
        {
            SearchLandingPageActivity searchlandingpageactivity = (SearchLandingPageActivity)activityRef.get();
            if (searchlandingpageactivity != null && !searchlandingpageactivity.isFinishing())
            {
                searchlandingpageactivity.searchLandingPageAdapter.updateAdapterData(0, list);
            }
        }

        GetRecentFromSearchProviderTask(SearchLandingPageActivity searchlandingpageactivity)
        {
            activityRef = new WeakReference(searchlandingpageactivity);
        }
    }

    private class ProxyListener
        implements android.support.v7.widget.SearchView.OnQueryTextListener
    {

        final SearchLandingPageActivity this$0;

        public boolean onQueryTextChange(String s)
        {
            if (TextUtils.isEmpty(s))
            {
                if (!recentListView.isShown())
                {
                    refreshLayout.setVisibility(0);
                    recentListView.setVisibility(0);
                }
                if (!scanBtn.isShown() && isScanBtnSupported)
                {
                    showHideScanBtn(true);
                }
                if (suggestionListView.isShown())
                {
                    suggestionListView.setVisibility(8);
                    isSuggestionVisible = false;
                }
                suggestionList = null;
                MyApp.getPrefs().removeUserPref("searchLastKeywords");
            } else
            {
                if (recentListView.isShown() || isSuggestionVisible)
                {
                    recentListView.setVisibility(8);
                    refreshLayout.setVisibility(8);
                }
                if (scanBtn.isShown())
                {
                    showHideScanBtn(false);
                }
                MyApp.getPrefs().setUserPref("searchLastKeywords", s);
                showSuggestion(s);
            }
            if (selectedRefinementInfo != null && !selectedRefinementInfo.query.equals(s))
            {
                selectedRefinementInfo = null;
            }
            return true;
        }

        public boolean onQueryTextSubmit(String s)
        {
            boolean flag = false;
            if (selectedRefinementInfo != null)
            {
                s = new SourceIdentification("EnterSearch", "sm", "utq");
                ActivityStarter.startSearch(SearchLandingPageActivity.this, selectedRefinementInfo.query, selectedRefinementInfo.userQuery, selectedRefinementInfo.categoryName, selectedRefinementInfo.categoryId, s);
                selectedRefinementInfo = null;
                flag = true;
            }
            finish();
            return flag;
        }

        private ProxyListener()
        {
            this$0 = SearchLandingPageActivity.this;
            super();
        }

    }

    private final class RecentlySearchedDataObserver extends com.ebay.mobile.recents.RecentsDataManager.SimpleLookUpObserver
    {

        final SearchLandingPageActivity this$0;

        public void onAllSearchItemDeleteComplete(RecentsDataManager recentsdatamanager, Content content)
        {
            ModalProgressFragment.hide(getFragmentManager());
            recentsdatamanager = searchLandingPageAdapter.getList(0);
            if (recentsdatamanager != null && ((com.ebay.nautilus.shell.widget.CompositeArrayAdapter.Section) (recentsdatamanager)).list != null)
            {
                updateEmptyListForType(0);
            }
        }

        public void onGetRecentlySearchedData(RecentsDataManager recentsdatamanager, Content content)
        {
            if (!isFinishing())
            {
                if (content != null && content.getData() != null)
                {
                    recentsdatamanager = new ArrayList();
                    PdsSearchItemAttribute pdssearchitemattribute;
                    SearchLandingPageAdapter.RecentsAdapterItem.Config config;
                    for (content = ((List)content.getData()).iterator(); content.hasNext(); recentsdatamanager.add(new SearchLandingPageAdapter.RecentsAdapterItem(pdssearchitemattribute.attributeValue, SearchLandingPageAdapter.RecentsAdapterItem.ItemType.RECENT_SEARCH, getSearchType(pdssearchitemattribute), config)))
                    {
                        pdssearchitemattribute = (PdsSearchItemAttribute)content.next();
                        config = new SearchLandingPageAdapter.RecentsAdapterItem.Config();
                        if (!TextUtils.isEmpty(pdssearchitemattribute.categoryId))
                        {
                            config.categoryId = Long.valueOf(pdssearchitemattribute.categoryId).longValue();
                        }
                        if (!recentSearchItems.isEmpty())
                        {
                            config.profileImgUrl = (String)recentSearchItems.get(pdssearchitemattribute.attributeValue);
                        }
                    }

                    searchLandingPageAdapter.updateAdapterData(0, recentsdatamanager);
                } else
                {
                    updateEmptyListForType(0);
                }
                if (refreshLayout.isRefreshing() && dismissSwipeToRefreshTask != null && dismissSwipeToRefreshTask.swipeToRefreshLatch != null)
                {
                    dismissSwipeToRefreshTask.swipeToRefreshLatch.countDown();
                    return;
                }
            }
        }

        private RecentlySearchedDataObserver()
        {
            this$0 = SearchLandingPageActivity.this;
            super();
        }

    }

    private static class SearchSuggestionTask extends AsyncTask
    {

        private WeakReference activityRef;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient ArrayList doInBackground(String as[])
        {
            Object obj = null;
            ArrayList arraylist = obj;
            if (!isCancelled())
            {
                SearchLandingPageActivity searchlandingpageactivity = (SearchLandingPageActivity)activityRef.get();
                arraylist = obj;
                if (searchlandingpageactivity != null)
                {
                    arraylist = obj;
                    if (as != null)
                    {
                        arraylist = obj;
                        if (as.length > 0)
                        {
                            as = as[0];
                            try
                            {
                                as = as.toLowerCase(Locale.getDefault()).trim();
                                arraylist = EbayApiUtil.getAutoCompleteApi(searchlandingpageactivity.getEbayContext(), MyApp.getPrefs().getCurrentCountry()).autoFillSuggestions(as);
                            }
                            // Misplaced declaration of an exception variable
                            catch (String as[])
                            {
                                return null;
                            }
                            // Misplaced declaration of an exception variable
                            catch (String as[])
                            {
                                return null;
                            }
                        }
                    }
                }
            }
            return arraylist;
        }

        protected void onCancelled()
        {
            SearchLandingPageActivity searchlandingpageactivity = (SearchLandingPageActivity)activityRef.get();
            if (searchlandingpageactivity != null && !searchlandingpageactivity.isFinishing())
            {
                searchlandingpageactivity.progress.setVisibility(8);
            }
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((ArrayList)obj);
        }

        protected void onPostExecute(ArrayList arraylist)
        {
            SearchLandingPageActivity searchlandingpageactivity = (SearchLandingPageActivity)activityRef.get();
            if (searchlandingpageactivity != null && !searchlandingpageactivity.isFinishing())
            {
                if (arraylist != null)
                {
                    searchlandingpageactivity.suggestionList = arraylist;
                    searchlandingpageactivity.suggestionAdapter.updateSuggestionList(searchlandingpageactivity.suggestionList, searchlandingpageactivity.lastQueryUsed);
                }
                searchlandingpageactivity.progress.setVisibility(8);
                if (!searchlandingpageactivity.suggestionListView.isShown())
                {
                    searchlandingpageactivity.suggestionListView.setVisibility(0);
                    searchlandingpageactivity.isSuggestionVisible = true;
                }
            }
        }

        protected void onPreExecute()
        {
            SearchLandingPageActivity searchlandingpageactivity = (SearchLandingPageActivity)activityRef.get();
            if (searchlandingpageactivity != null && !searchlandingpageactivity.isFinishing())
            {
                searchlandingpageactivity.progress.setVisibility(0);
            }
        }

        SearchSuggestionTask(SearchLandingPageActivity searchlandingpageactivity)
        {
            activityRef = new WeakReference(searchlandingpageactivity);
        }
    }


    private static final int DIALOG_CLEAR_RECENT_SEARCHES = 1;
    public static final String EXTRA_SEARCH_TEXT = "searchBoxText";
    public static final String EXTRA_SELLER_ID = "sellerId";
    public static final String EXTRA_SELLER_OFFER = "sellerOffer";
    private static final String STATE_LAST_QUERY = "last_query";
    private static final String STATE_SUGGESTION_LIST = "suggestion_list";
    private static final String STATE_SUGGESTION_VISIBILITY = "suggestion_visibility";
    private View cancelBtn;
    protected DismissSwipeToRefreshTask dismissSwipeToRefreshTask;
    private FollowingContentDataManager followingContentDataManager;
    private String iafToken;
    private boolean isScanBtnSupported;
    protected boolean isSuggestionVisible;
    private boolean isUsingShadedSearchBox;
    private ItemCache itemCache;
    protected String lastQueryUsed;
    private TreeMap pollMap;
    protected View progress;
    private ListView recentListView;
    private Map recentSearchItems;
    private RecentsDataManager recentsDataManager;
    protected SwipeRefreshLayout refreshLayout;
    private View scanBtn;
    private String searchHintText;
    protected SearchLandingPageAdapter searchLandingPageAdapter;
    private SearchView searchView;
    private RecentlySearchedDataObserver searchedDataObserver;
    private SearchSuggestionAdapter.SearchSuggestionInfo selectedRefinementInfo;
    private String sellerId;
    private SellerOfferParameters sellerOffer;
    private boolean shouldTrack;
    protected SearchSuggestionAdapter suggestionAdapter;
    protected ArrayList suggestionList;
    protected ListView suggestionListView;
    private UserCache userCache;

    public SearchLandingPageActivity()
    {
        lastQueryUsed = "";
        suggestionList = null;
        shouldTrack = true;
        isScanBtnSupported = false;
        recentSearchItems = new HashMap();
    }

    private void clearRecents()
    {
label0:
        {
            com.ebay.nautilus.shell.widget.CompositeArrayAdapter.Section section = searchLandingPageAdapter.getList(0);
            if (section != null && section.list != null)
            {
                if (recentsDataManager == null)
                {
                    break label0;
                }
                ModalProgressFragment.show(getFragmentManager(), this);
                recentsDataManager.clearRecentSearches();
            }
            return;
        }
        eBayDictionaryProvider.clearHistory(this);
        updateEmptyListForType(0);
    }

    private SearchPrefixType getSearchType(PdsSearchItemAttribute pdssearchitemattribute)
    {
        if (pdssearchitemattribute != null)
        {
            if (!TextUtils.isEmpty(pdssearchitemattribute.sellerPrefix))
            {
                return SearchPrefixType.SELLER;
            }
            if (!TextUtils.isEmpty(pdssearchitemattribute.productPrefix))
            {
                if (SearchPrefixType.EAN.getName().equalsIgnoreCase(pdssearchitemattribute.productPrefix))
                {
                    return SearchPrefixType.EAN;
                }
                if (SearchPrefixType.UPC.getName().equalsIgnoreCase(pdssearchitemattribute.productPrefix))
                {
                    return SearchPrefixType.UPC;
                }
            }
        }
        return SearchPrefixType.NORMAL;
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

    private void setupSearchBox()
    {
        searchView = (SearchView)findViewById(0x7f10055f);
        Object obj = ((SearchManager)getSystemService("search")).getSearchableInfo(new ComponentName(this, getClass()));
        searchView.setSearchableInfo(((android.app.SearchableInfo) (obj)));
        searchView.setIconified(true);
        searchView.setIconifiedByDefault(false);
        String s = MyApp.getPrefs().getUserPref("searchLastKeywords", "");
        obj = s;
        if (sellerId != null)
        {
            obj = s;
            if (!s.contains("seller:"))
            {
                obj = (new StringBuilder()).append("seller:").append(sellerId).append(" ").toString();
            }
        }
        searchView.setQuery(((CharSequence) (obj)), false);
        searchView.setQueryHint(searchHintText);
        searchView.setOnQueryTextListener(new ProxyListener());
        searchView.setSuggestionsAdapter(null);
        try
        {
            Field field = android/support/v7/widget/SearchView.getDeclaredField("mVoiceButton");
            field.setAccessible(true);
            ((ImageView)field.get(searchView)).setPadding(0, 0, 0, 0);
            return;
        }
        catch (NoSuchFieldException nosuchfieldexception)
        {
            Log.e("SearchView", nosuchfieldexception.getMessage(), nosuchfieldexception);
            return;
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            Log.e("SearchView", illegalaccessexception.getMessage(), illegalaccessexception);
        }
    }

    private void showClearRecentSerachesConfirmation()
    {
        (new com.ebay.app.AlertDialogFragment.Builder()).setTitle(0x7f070960).setMessage(0x7f07095f).setNegativeButton(0x7f0701cc).setPositiveButton(0x7f070cc7).createFromActivity(1).show(getFragmentManager(), null);
    }

    private void showHideScanBtn(boolean flag)
    {
        if (flag)
        {
            scanBtn.setVisibility(0);
            return;
        } else
        {
            scanBtn.setVisibility(8);
            return;
        }
    }

    private void showSuggestion(CharSequence charsequence)
    {
        if (!TextUtils.isEmpty(charsequence))
        {
            if (lastQueryUsed.equals(charsequence.toString().trim()) && isSuggestionVisible && suggestionList != null)
            {
                suggestionAdapter.updateSuggestionList(suggestionList, lastQueryUsed);
                if (!suggestionListView.isShown())
                {
                    suggestionListView.setVisibility(0);
                    return;
                }
            } else
            {
                lastQueryUsed = charsequence.toString();
                (new SearchSuggestionTask(this)).execute(new String[] {
                    lastQueryUsed
                });
                return;
            }
        }
    }

    private void updateEmptyListForType(int i)
    {
        searchLandingPageAdapter.updateAdapterData(i, Collections.emptyList());
    }

    private void updateFollowedMembers(List list)
    {
        if (list != null && !list.isEmpty())
        {
            ArrayList arraylist = new ArrayList();
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                com.ebay.nautilus.domain.data.FollowingContent.FollowedUser followeduser = (com.ebay.nautilus.domain.data.FollowingContent.FollowedUser)list.next();
                SearchLandingPageAdapter.RecentsAdapterItem.Config config = new SearchLandingPageAdapter.RecentsAdapterItem.Config();
                config.profileImgUrl = followeduser.profileImageUrl;
                arraylist.add(new SearchLandingPageAdapter.RecentsAdapterItem(followeduser.username, SearchLandingPageAdapter.RecentsAdapterItem.ItemType.FOLLOWED_MEMBER, SearchPrefixType.SELLER, config));
                if (!TextUtils.isEmpty(followeduser.profileImageUrl))
                {
                    recentSearchItems.put(followeduser.username, followeduser.profileImageUrl);
                }
            } while (true);
            searchLandingPageAdapter.updateAdapterData(2, arraylist);
            if (!recentSearchItems.isEmpty())
            {
                searchLandingPageAdapter.updateRecentSearchImages(recentSearchItems);
                recentSearchItems.clear();
            }
            return;
        } else
        {
            updateEmptyListForType(2);
            return;
        }
    }

    private void updateFollowedSearches(List list)
    {
        if (!itemCache.isSearchListReady()) goto _L2; else goto _L1
_L1:
        if (list == null || list.isEmpty()) goto _L4; else goto _L3
_L3:
        ArrayList arraylist;
        Iterator iterator;
        boolean flag1;
        flag1 = itemCache.isSearchNewItemCountsReady();
        arraylist = new ArrayList();
        iterator = list.iterator();
_L13:
        if (!iterator.hasNext()) goto _L6; else goto _L5
_L5:
        List list1;
        SavedSearch savedsearch;
        SearchLandingPageAdapter.RecentsAdapterItem.Config config;
        savedsearch = (SavedSearch)iterator.next();
        if (TextUtils.isEmpty(savedsearch.id))
        {
            continue; /* Loop/switch isn't completed */
        }
        list = SearchPrefixType.NORMAL;
        config = new SearchLandingPageAdapter.RecentsAdapterItem.Config();
        list1 = list;
        if (savedsearch.searchParameters == null) goto _L8; else goto _L7
_L7:
        if (TextUtils.isEmpty(savedsearch.searchParameters.sellerId)) goto _L10; else goto _L9
_L9:
        list = SearchPrefixType.SELLER;
_L11:
        EbayCategorySummary ebaycategorysummary = savedsearch.searchParameters.category;
        list1 = list;
        if (ebaycategorysummary != null)
        {
            config.categoryId = ebaycategorysummary.id;
            config.categoryName = ebaycategorysummary.name;
            list1 = list;
        }
_L8:
        if (flag1)
        {
            list = (com.ebay.mobile.notifications.PollService.SavedSearchPollData)pollMap.get(Long.valueOf(savedsearch.id));
            boolean flag;
            if (list != null && PollServiceListCache.hasNew(list))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            config.isNewItem = flag;
        }
        config.name = savedsearch.name;
        config.searchId = savedsearch.id;
        arraylist.add(new SearchLandingPageAdapter.RecentsAdapterItem(savedsearch.keywords, SearchLandingPageAdapter.RecentsAdapterItem.ItemType.FOLLOWED_SEARCH, list1, config));
        continue; /* Loop/switch isn't completed */
_L10:
        if (!TextUtils.isEmpty(savedsearch.searchParameters.productId))
        {
            list = SearchPrefixType.EAN;
        }
        if (true) goto _L11; else goto _L6
_L6:
        searchLandingPageAdapter.updateAdapterData(1, arraylist);
_L2:
        return;
_L4:
        updateEmptyListForType(1);
        return;
        if (true) goto _L13; else goto _L12
_L12:
    }

    public void clearRecentSearches()
    {
        showClearRecentSerachesConfirmation();
    }

    public String getTrackingEventName()
    {
        return "EnterSearch";
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        i;
        JVM INSTR lookupswitch 2: default 28
    //                   58: 29
    //                   65: 88;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        if (j == -1)
        {
            intent = new ScanResult(intent.getStringExtra("productid"), intent.getStringExtra("productidtype"));
            SourceIdentification sourceidentification = new SourceIdentification("EnterSearch", "sm", "scan");
            ActivityStarter.startSearch(this, intent.toString(), null, null, 0L, sourceidentification);
            return;
        }
          goto _L1
_L3:
        if (j != -1)
        {
            finish();
            return;
        }
        intent = MyApp.getPrefs().getAuthentication();
        if (intent != null)
        {
            iafToken = ((Authentication) (intent)).iafToken;
            searchedDataObserver = new RecentlySearchedDataObserver();
            recentsDataManager = (RecentsDataManager)getDataManagerContainer().initialize(new com.ebay.mobile.recents.RecentsDataManager.KeyParams(iafToken), searchedDataObserver);
            if (followingContentDataManager != null)
            {
                followingContentDataManager.loadData(this);
            } else
            {
                followingContentDataManager = (FollowingContentDataManager)getDataManagerContainer().initialize(FollowingContentDataManager.KEY, this);
            }
        }
        pollMap = itemCache.getSavedSearches();
        if (pollMap.isEmpty())
        {
            (new Handler()).postDelayed(new Runnable() {

                final SearchLandingPageActivity this$0;

                public void run()
                {
                    pollMap = itemCache.getSavedSearches();
                    userCache.refreshSavedSearchList();
                }

            
            {
                this$0 = SearchLandingPageActivity.this;
                super();
            }
            }, 1000L);
            return;
        } else
        {
            userCache.refreshSavedSearchList();
            return;
        }
    }

    public void onCancel()
    {
        finish();
    }

    public void onCancel(DialogInterface dialoginterface)
    {
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR tableswitch 2131756397 2131756398: default 28
    //                   2131756397 29
    //                   2131756398 34;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        finish();
        return;
_L3:
        view = ScanResult.getScanActivityIntent(this);
        if (view != null)
        {
            view.putExtra("qrcode", true);
            MimsUtil.useProvider(MimsUtil.PROVIDER_ID_REDLASER);
            startActivityForResult(view, 58);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected void onCreate(Bundle bundle)
    {
        boolean flag1 = true;
        super.onCreate(bundle);
        setContentView(0x7f0301d2);
        if (DeviceConfiguration.getAsync().get(com.ebay.nautilus.domain.dcs.DcsDomain.Search.B.boxShaded))
        {
            ((RelativeLayout)findViewById(0x7f10056c)).setBackground(getResources().getDrawable(0x7f02006c));
        }
        itemCache = new ItemCache(this);
        userCache = new UserCache(this);
        Object obj = MyApp.getPrefs().getAuthentication();
        if (obj != null)
        {
            iafToken = ((Authentication) (obj)).iafToken;
        }
        scanBtn = findViewById(0x7f10056e);
        cancelBtn = findViewById(0x7f10056d);
        recentListView = (ListView)findViewById(0x7f100570);
        suggestionListView = (ListView)findViewById(0x7f100571);
        progress = findViewById(0x7f100572);
        refreshLayout = (SwipeRefreshLayout)findViewById(0x7f10056f);
        obj = getIntent();
        sellerOffer = (SellerOfferParameters)((Intent) (obj)).getParcelableExtra("sellerOffer");
        sellerId = ((Intent) (obj)).getStringExtra("sellerId");
        processSearchIntent(((Intent) (obj)));
        searchHintText = ((Intent) (obj)).getStringExtra("searchBoxText");
        if (searchHintText == null)
        {
            searchHintText = Util.getCommonSearchHint(this);
        }
        setupSearchBox();
        refreshLayout.setOnRefreshListener(this);
        suggestionAdapter = new SearchSuggestionAdapter(this, this);
        suggestionListView.setAdapter(suggestionAdapter);
        searchLandingPageAdapter = new SearchLandingPageAdapter(this, this);
        recentListView.setOnTouchListener(this);
        recentListView.setAdapter(searchLandingPageAdapter);
        recentListView.setOnItemClickListener(this);
        suggestionListView.setOnTouchListener(this);
        cancelBtn.setOnClickListener(this);
        scanBtn.setOnClickListener(this);
        if (bundle != null)
        {
            isSuggestionVisible = bundle.getBoolean("suggestion_visibility");
            suggestionList = bundle.getParcelableArrayList("suggestion_list");
            lastQueryUsed = bundle.getString("last_query");
        }
        boolean flag;
        if (ScanResult.getScanActivityIntent(this) != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isScanBtnSupported = flag;
        if (isScanBtnSupported && !isSuggestionVisible)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        showHideScanBtn(flag);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return false;
    }

    public void onDialogFragmentResult(DialogFragment dialogfragment, int i, int j)
    {
        i;
        JVM INSTR tableswitch 1 1: default 20
    //                   1 21;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (j == 1)
        {
            clearRecents();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onDismiss()
    {
    }

    public void onFollowingContentChanged(FollowingContentDataManager followingcontentdatamanager, Content content)
    {
        followingcontentdatamanager = content.getStatus();
        if (followingcontentdatamanager.hasError())
        {
            EbayErrorHandler.handleResultStatus(this, 0, followingcontentdatamanager);
        } else
        {
            followingcontentdatamanager = (FollowingContent)content.getData();
            if (followingcontentdatamanager != null && ((FollowingContent) (followingcontentdatamanager)).followedEntities != null)
            {
                updateFollowedMembers(((FollowingContent) (followingcontentdatamanager)).followedEntities.users);
            }
            if (refreshLayout.isRefreshing() && dismissSwipeToRefreshTask != null && dismissSwipeToRefreshTask.swipeToRefreshLatch != null)
            {
                dismissSwipeToRefreshTask.swipeToRefreshLatch.countDown();
                return;
            }
        }
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        if (!TextUtils.isEmpty(iafToken))
        {
            searchedDataObserver = new RecentlySearchedDataObserver();
            recentsDataManager = (RecentsDataManager)datamanagercontainer.initialize(new com.ebay.mobile.recents.RecentsDataManager.KeyParams(iafToken), searchedDataObserver);
            if (followingContentDataManager != null)
            {
                followingContentDataManager.loadData(this);
                return;
            } else
            {
                followingContentDataManager = (FollowingContentDataManager)datamanagercontainer.initialize(FollowingContentDataManager.KEY, this);
                return;
            }
        } else
        {
            (new GetRecentFromSearchProviderTask(this)).execute(new Void[0]);
            return;
        }
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        int j;
        int k;
        j = searchLandingPageAdapter.getItemViewType(i);
        k = searchLandingPageAdapter.getSectionFromItemPosition(i).listType;
        j;
        JVM INSTR tableswitch 0 3: default 56
    //                   0 126
    //                   1 56
    //                   2 385
    //                   3 57;
           goto _L1 _L2 _L1 _L3 _L4
_L1:
        return;
_L4:
        switch (k)
        {
        default:
            return;

        case 1: // '\001'
            ActivityStarter.startBrowseSavedSearch(this, getEbayContext());
            finish();
            return;

        case 2: // '\002'
            adapterview = new Intent(this, com/ebay/mobile/following/EditFollowingActivity);
            break;
        }
        adapterview.putExtra("followType", 2);
        startActivity(adapterview);
        finish();
        return;
_L2:
        StringBuilder stringbuilder;
        if ((view = (SearchLandingPageAdapter.RecentsAdapterItem)searchLandingPageAdapter.getItem(i)) == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!TextUtils.isEmpty(((SearchLandingPageAdapter.RecentsAdapterItem) (view)).keywords))
        {
            adapterview = ((SearchLandingPageAdapter.RecentsAdapterItem) (view)).keywords;
        } else
        {
            adapterview = ((SearchLandingPageAdapter.RecentsAdapterItem) (view)).name;
        }
        stringbuilder = new StringBuilder();
        k;
        JVM INSTR tableswitch 0 2: default 196
    //                   0 209
    //                   1 283
    //                   2 209;
           goto _L5 _L6 _L7 _L6
_L5:
        finish();
        return;
_L6:
        Object obj = ((SearchLandingPageAdapter.RecentsAdapterItem) (view)).searchtype.getName();
        if (!adapterview.startsWith(((String) (obj))))
        {
            stringbuilder.append(((String) (obj)));
        }
        obj = new SourceIdentification("EnterSearch", "sm", "rs");
        stringbuilder.append(adapterview);
        ActivityStarter.startSearch(this, stringbuilder.toString(), null, ((SearchLandingPageAdapter.RecentsAdapterItem) (view)).categoryName, ((SearchLandingPageAdapter.RecentsAdapterItem) (view)).categoryId, ((SourceIdentification) (obj)));
          goto _L5
_L7:
        adapterview = (com.ebay.mobile.notifications.PollService.SavedSearchPollData)pollMap.get(Long.valueOf(Long.parseLong(((SearchLandingPageAdapter.RecentsAdapterItem) (view)).searchId)));
        l = 0L;
        boolean flag = false;
        if (adapterview != null)
        {
            l = PollServiceListCache.getSinceTime(adapterview);
            flag = PollServiceListCache.hasNew(adapterview);
        }
        SourceIdentification sourceidentification = new SourceIdentification("EnterSearch", "sm", "ss");
        com.ebay.nautilus.kernel.content.EbayContext ebaycontext = getEbayContext();
        view = ((SearchLandingPageAdapter.RecentsAdapterItem) (view)).searchId;
        if (flag)
        {
            adapterview = Long.valueOf(l);
        } else
        {
            adapterview = null;
        }
        ActivityStarter.startSavedSearch(this, ebaycontext, view, adapterview, sourceidentification);
          goto _L5
_L3:
        switch (k)
        {
        default:
            return;

        case 1: // '\001'
        case 2: // '\002'
            break;
        }
        if (MyApp.getPrefs().getAuthentication() != null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i == 0)
        {
            startActivityForResult(SignInModalActivity.getIntentForSignIn(getTrackingEventName(), this), 65);
            return;
        }
        if (true) goto _L1; else goto _L8
_L8:
    }

    public void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
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
        super.onPause();
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(searchView.getWindowToken(), 0);
        if (!TextUtils.isEmpty(iafToken))
        {
            userCache.unregisterSavedSearchHandler(this);
        }
    }

    public void onRefresh()
    {
        int i = 1;
        refreshLayout.setRefreshing(true);
        userCache.refreshSavedSearchList();
        if (recentsDataManager != null)
        {
            recentsDataManager.forceRefresh();
            i = 1 + 1;
        }
        int j = i;
        if (followingContentDataManager != null)
        {
            followingContentDataManager.invalidateAndForceReloadData();
            j = i + 1;
        }
        dismissSwipeToRefreshTask = new DismissSwipeToRefreshTask(this, j);
        dismissSwipeToRefreshTask.execute(new Void[0]);
    }

    public void onResume()
    {
        SavedSearchList savedsearchlist;
label0:
        {
            super.onResume();
            if (shouldTrack)
            {
                (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).addSourceIdentification(getIntent()).send(this);
            }
            if (!TextUtils.isEmpty(iafToken))
            {
                userCache.registerSavedSearchHandler(this);
                pollMap = itemCache.getSavedSearches();
                savedsearchlist = UserCache.getSavedSearchList();
                if (savedsearchlist != null)
                {
                    break label0;
                }
                userCache.refreshSavedSearchList();
            }
            return;
        }
        updateFollowedSearches(savedsearchlist.getSearchList());
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        bundle.putBoolean("suggestion_visibility", isSuggestionVisible);
        if (suggestionList != null)
        {
            bundle.putParcelableArrayList("suggestion_list", suggestionList);
        }
        bundle.putString("last_query", lastQueryUsed);
        super.onSaveInstanceState(bundle);
    }

    public void onSearchQueryRefinementSelected(SearchSuggestionAdapter.SearchSuggestionInfo searchsuggestioninfo)
    {
        selectedRefinementInfo = searchsuggestioninfo;
        searchView.setQuery(searchsuggestioninfo.query, false);
    }

    public void onSearchQuerySubmitted(SearchSuggestionAdapter.SearchSuggestionInfo searchsuggestioninfo)
    {
        Object obj;
        SourceIdentification sourceidentification;
        if (searchsuggestioninfo.isUserSearch)
        {
            obj = new StringBuilder(SearchPrefixType.SELLER.getName());
            ((StringBuilder) (obj)).append(searchsuggestioninfo.query);
            obj = ((StringBuilder) (obj)).toString();
        } else
        {
            obj = searchsuggestioninfo.query;
        }
        if (searchsuggestioninfo.categoryId != 0L)
        {
            sourceidentification = new SourceIdentification("EnterSearch", "sm", "acwc");
        } else
        {
            sourceidentification = new SourceIdentification("EnterSearch", "sm", "ac");
        }
        ActivityStarter.startSearch(this, ((String) (obj)), searchsuggestioninfo.userQuery, searchsuggestioninfo.categoryName, searchsuggestioninfo.categoryId, sourceidentification);
        finish();
    }

    public boolean onSearchRequested()
    {
        return false;
    }

    public void onSetFollowedEntityIsHiddenComplete(FollowingContentDataManager followingcontentdatamanager, Content content)
    {
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        switch (view.getId())
        {
        default:
            return false;

        case 2131756400: 
        case 2131756401: 
            ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
            break;
        }
        return false;
    }

    public void updateSavedSearch(SavedSearchList savedsearchlist)
    {
        if (savedsearchlist != null)
        {
            pollMap = itemCache.getSavedSearches();
            updateFollowedSearches(savedsearchlist.getSearchList());
        }
        if (refreshLayout.isRefreshing() && dismissSwipeToRefreshTask != null && dismissSwipeToRefreshTask.swipeToRefreshLatch != null)
        {
            dismissSwipeToRefreshTask.swipeToRefreshLatch.countDown();
        }
    }



/*
    static TreeMap access$1102(SearchLandingPageActivity searchlandingpageactivity, TreeMap treemap)
    {
        searchlandingpageactivity.pollMap = treemap;
        return treemap;
    }

*/










/*
    static SearchSuggestionAdapter.SearchSuggestionInfo access$702(SearchLandingPageActivity searchlandingpageactivity, SearchSuggestionAdapter.SearchSuggestionInfo searchsuggestioninfo)
    {
        searchlandingpageactivity.selectedRefinementInfo = searchsuggestioninfo;
        return searchsuggestioninfo;
    }

*/


}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.Toast;
import com.ebay.common.Preferences;
import com.ebay.common.content.EbayCguidPersister;
import com.ebay.common.content.dm.FollowedEntityDataManager;
import com.ebay.common.model.followinterest.FollowDescriptor;
import com.ebay.common.model.followinterest.FollowType;
import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.model.search.EbayCategorySummary;
import com.ebay.common.model.widget.DrawerControlListener;
import com.ebay.common.net.api.followinterest.InterestDescriptor;
import com.ebay.common.net.api.search.ISearchEventTracker;
import com.ebay.common.net.api.search.KnownSearchExpansion;
import com.ebay.common.net.api.search.SearchEventTracker;
import com.ebay.common.net.api.search.SearchExpansion;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.net.api.search.SearchResult;
import com.ebay.mobile.ActivityStarter;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.BaseActivity;
import com.ebay.mobile.activities.SignInModalActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.eBayDictionaryProvider;
import com.ebay.mobile.experimentation.Experiments;
import com.ebay.mobile.notifications.ItemCache;
import com.ebay.mobile.notifications.NotificationPreferenceManager;
import com.ebay.mobile.notifications.NotificationTrackingUtil;
import com.ebay.mobile.notifications.NotificationUtil;
import com.ebay.mobile.recents.RecentsDataManager;
import com.ebay.mobile.search.SearchLandingPage.SearchPrefixType;
import com.ebay.mobile.sitespeed.SiteSpeedActivityUtil;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.analytics.DeviceInfoUtil;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.PostalCodeSpecification;
import com.ebay.nautilus.domain.dcs.DcsNautilusBoolean;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.api.experimentation.Treatment;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

// Referenced classes of package com.ebay.mobile.search:
//            RefinementUpdatedListener, SearchActivitySync, SearchUtil, AcknowledgementBar, 
//            SearchRefineBarFragment, SearchResultFragment, SearchRefineFragment, SaveSearchDialogFragment, 
//            RelatedSearchesActivity, DetailMode, DetailLaunchMode, MainSearchActivity

public class SearchResultFragmentActivity extends BaseActivity
    implements android.support.v4.widget.DrawerLayout.DrawerListener, android.view.View.OnClickListener, com.ebay.common.content.dm.FollowedEntityDataManager.OnFollowedSearchesChanged, DrawerControlListener, PromptForStringDialogFragment.PromptForStringCompletedListener, RefinementUpdatedListener, SaveSearchDialogFragment.OnSaveSearchListener, SearchActivitySync, SearchRefineBarFragment.OnSearchRefineBarListener, SearchResultFragment.OnScrollEventListener, SearchResultFragment.OnSearchEventsListener, SearchResultFragment.OnTrackingEventsListener
{
    public static final class FollowSearchOrigin extends Enum
    {

        private static final FollowSearchOrigin $VALUES[];
        public static final FollowSearchOrigin CAROUSEL;
        public static final FollowSearchOrigin FLOATING_BAR;
        public static final FollowSearchOrigin GLOBAL_HEADER;
        public static final FollowSearchOrigin OTHER;

        public static FollowSearchOrigin valueOf(String s)
        {
            return (FollowSearchOrigin)Enum.valueOf(com/ebay/mobile/search/SearchResultFragmentActivity$FollowSearchOrigin, s);
        }

        public static FollowSearchOrigin[] values()
        {
            return (FollowSearchOrigin[])$VALUES.clone();
        }

        static 
        {
            FLOATING_BAR = new FollowSearchOrigin("FLOATING_BAR", 0);
            CAROUSEL = new FollowSearchOrigin("CAROUSEL", 1);
            GLOBAL_HEADER = new FollowSearchOrigin("GLOBAL_HEADER", 2);
            OTHER = new FollowSearchOrigin("OTHER", 3);
            $VALUES = (new FollowSearchOrigin[] {
                FLOATING_BAR, CAROUSEL, GLOBAL_HEADER, OTHER
            });
        }

        private FollowSearchOrigin(String s, int i)
        {
            super(s, i);
        }
    }

    private static class RefollowData
    {

        public String iafToken;
        public FollowDescriptor originalFollow;
        public com.ebay.mobile.notifications.PollService.SavedSearchPollData pollData;

        public RefollowData(FollowDescriptor followdescriptor, com.ebay.mobile.notifications.PollService.SavedSearchPollData savedsearchpolldata, String s)
        {
            originalFollow = followdescriptor;
            pollData = savedsearchpolldata;
            iafToken = s;
        }
    }

    private static class RefollowObserver extends com.ebay.common.content.dm.FollowedEntityDataManager.SimpleObserver
    {

        private final BaseActivity baseActivity;
        private final RefollowData data;
        private final com.ebay.common.content.dm.FollowedEntityDataManager.OnFollowedSearchesChanged observer;

        public void onSearchFollowed(Content content)
        {
            if (data.originalFollow.notifications != null && data.originalFollow.notifications.contains(com.ebay.common.model.followinterest.FollowDescriptor.NotificationEnum.PUSH))
            {
                (new ItemCache(baseActivity)).addSavedSearch(data.originalFollow.getInterestId(), data.originalFollow.getInterestTitle(), data.pollData.newItemCount, data.pollData.pollTime, data.pollData.viewTime, data.pollData.sinceTime);
                content = new NotificationPreferenceManager(baseActivity);
                String s = MyApp.getPrefs().getAuthentication().user;
                if (data.originalFollow.notifications != null && data.originalFollow.notifications.contains(com.ebay.common.model.followinterest.FollowDescriptor.NotificationEnum.PUSH))
                {
                    content.addNotifyEnabledSavedSearchId(s, data.originalFollow.getInterestId());
                } else
                {
                    content.removeNotifyEnabledSavedSearchId(s, data.originalFollow.getInterestId());
                }
                if (observer != null)
                {
                    observer.onSearchFollowed(data.originalFollow);
                }
                (new UpdateNotificationTask(baseActivity, content, s)).execute(new Void[0]);
            }
        }

        public RefollowObserver(BaseActivity baseactivity, RefollowData refollowdata, com.ebay.common.content.dm.FollowedEntityDataManager.OnFollowedSearchesChanged onfollowedsearcheschanged)
        {
            baseActivity = baseactivity;
            data = refollowdata;
            observer = onfollowedsearcheschanged;
        }
    }

    public static final class RelatedSearchesResultsActivity extends SearchResultFragmentActivity
    {

        protected boolean isRelatedSearchesSupported()
        {
            return false;
        }

        public RelatedSearchesResultsActivity()
        {
        }
    }

    public static final class SellerItemsActivity extends SearchResultFragmentActivity
    {

        protected boolean onNewSearchParametersDelivered(SearchParameters searchparameters)
        {
            boolean flag;
            if (searchparameters.keywords != null && searchparameters.keywords.startsWith("seller:"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            return !flag && searchParameters.sellerId.equals(searchparameters.sellerId);
        }

        public SellerItemsActivity()
        {
        }
    }

    private static class UndoUnfollowListener extends AcknowledgementBar.SimpleListener
    {

        private final BaseActivity baseActivity;
        private final FollowedEntityDataManager followedEntityDataManager;
        private final com.ebay.common.content.dm.FollowedEntityDataManager.OnFollowedSearchesChanged observer;

        public void onAction(RefollowData refollowdata)
        {
            followedEntityDataManager.followExistingInterest(refollowdata.originalFollow.interest, refollowdata.originalFollow.getInterestTitle(), refollowdata.iafToken, new RefollowObserver(baseActivity, refollowdata, observer));
        }

        public volatile void onAction(Object obj)
        {
            onAction((RefollowData)obj);
        }

        public UndoUnfollowListener(BaseActivity baseactivity, FollowedEntityDataManager followedentitydatamanager, com.ebay.common.content.dm.FollowedEntityDataManager.OnFollowedSearchesChanged onfollowedsearcheschanged)
        {
            baseActivity = baseactivity;
            followedEntityDataManager = followedentitydatamanager;
            observer = onfollowedsearcheschanged;
        }
    }

    private static class UpdateNotificationTask extends AsyncTask
    {

        private final BaseActivity baseActivity;
        private NotificationPreferenceManager notificationPrefs;
        private String userId;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            NotificationUtil.updateNotificationSubscriptions(baseActivity, baseActivity.getEbayContext(), notificationPrefs.getNotifyEnabledSavedSearchIdList(userId));
            return null;
        }

        public UpdateNotificationTask(BaseActivity baseactivity, NotificationPreferenceManager notificationpreferencemanager, String s)
        {
            baseActivity = baseactivity;
            notificationPrefs = notificationpreferencemanager;
            userId = s;
        }
    }


    private static String ACTION_FOLLOW_SEARCH = "followSearch";
    private static String ACTION_ON_COMPLETE = "postSignInAction";
    public static final String EXTRA_OPEN_REFINE_PANEL = "open_refine_panel";
    private static final String INSTANCE_STATE_BROWSE_CATEGORIES_SEARCH = "search_browse_categories";
    private static final String INSTANCE_STATE_SEARCH_PARAMETERS = "search_parameters";
    private static final String INSTANCE_STATE_SEARCH_VIEW = "search_view";
    private static String KEY_FOLLOW_ORIGIN = "followOrigin";
    private AcknowledgementBar ackBar;
    private String bidSource;
    private boolean browseCategoriesSearch;
    private int cachedHeaderHeight;
    private int currentViewType;
    private DrawerLayout drawer;
    private FollowDescriptor existingFollow;
    private SearchUtil.WatchFollowsObserver followObserver;
    private FollowedEntityDataManager followedEntityDataManager;
    private Treatment hideFollowBarTreatment;
    private boolean icsCrashHackIgnoreBack;
    private Boolean isFollowBarEnabled;
    private boolean isRefinementToolsAnimating;
    private FollowSearchOrigin pendingFollowRequestedOrigin;
    private SearchParameters placeholderSearchParameters;
    private RecentsDataManager recentsDataManager;
    private String referrer;
    private boolean refinementToolsVisible;
    private Boolean requestShowRefinementTools;
    protected SearchParameters searchParameters;
    private SearchRefineFragment searchRefineFragment;
    private SourceIdentification trackingSid;
    private String trackingUserQuery;
    private AcknowledgementBar.Listener undoUnfollowListener;

    public SearchResultFragmentActivity()
    {
        icsCrashHackIgnoreBack = false;
        refinementToolsVisible = true;
        requestShowRefinementTools = null;
        drawer = null;
        ackBar = null;
        searchRefineFragment = null;
        trackingSid = null;
        browseCategoriesSearch = false;
        cachedHeaderHeight = 0;
        pendingFollowRequestedOrigin = null;
        followObserver = new SearchUtil.WatchFollowsObserver(this, this);
        existingFollow = null;
        isFollowBarEnabled = null;
        hideFollowBarTreatment = null;
        currentViewType = 0;
    }

    private void calculatResultVerticalSpacingAfterLayout()
    {
        final ViewGroup refinementLayout = (ViewGroup)findViewById(0x7f100600);
        refinementLayout.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final SearchResultFragmentActivity this$0;
            final ViewGroup val$refinementLayout;

            public void onGlobalLayout()
            {
                findViewById(0x7f1005fe).requestFocus();
                calculateResultVerticalSpacing(false);
                refinementLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }

            
            {
                this$0 = SearchResultFragmentActivity.this;
                refinementLayout = viewgroup;
                super();
            }
        });
    }

    private String getIafToken()
    {
        Authentication authentication = MyApp.getPrefs().getAuthentication();
        if (authentication != null)
        {
            return authentication.iafToken;
        } else
        {
            return null;
        }
    }

    private SearchParameters getParamsFromIntent(Intent intent)
    {
        SearchParameters searchparameters = (SearchParameters)intent.getParcelableExtra("search_param");
        Object obj = searchparameters;
        if (searchparameters == null)
        {
            obj = searchparameters;
            if (intent.hasExtra("saved_search_id"))
            {
                obj = intent.getStringExtra("saved_search_id");
                if (!TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    searchparameters = SearchUtil.getSearchParametersForFollowedSearchId(this, getEbayContext(), ((String) (obj)));
                }
                obj = searchparameters;
                if (searchparameters != null)
                {
                    intent.removeExtra("saved_search_id");
                    obj = searchparameters;
                }
            }
        }
        return ((SearchParameters) (obj));
    }

    private void hideTransientDecorations()
    {
        if (ackBar != null)
        {
            ackBar.dismiss();
        }
    }

    private boolean redirectForDeferredSavedSearchResolution()
    {
        if (getIntent().hasExtra("saved_search_id") && !areSearchParametersReady() && !isFinishing())
        {
            Intent intent = getIntent();
            finish();
            String s = intent.getStringExtra("saved_search_id");
            SearchParameters searchparameters = null;
            if (!TextUtils.isEmpty(s))
            {
                searchparameters = SearchUtil.getSearchParametersForFollowedSearchId(this, getEbayContext(), s);
            }
            if (searchparameters != null)
            {
                intent.removeExtra("saved_search_id");
                intent.putExtra("search_param", searchparameters);
                startActivity(intent);
            } else
            {
                ActivityStarter.startBrowseSavedSearch(this, getEbayContext());
            }
            return true;
        } else
        {
            return false;
        }
    }

    private void setRefinementToolbarVisibility(boolean flag)
    {
        Object obj;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        obj = (SearchRefineBarFragment)getFragmentManager().findFragmentById(0x7f100601);
        if (obj != null)
        {
            obj = ((SearchRefineBarFragment) (obj)).getView();
            if (obj != null)
            {
                ((View) (obj)).setVisibility(i);
            }
        }
        if (isFollowBarEnabled())
        {
            ((ViewGroup)findViewById(0x7f100606)).setVisibility(i);
        }
    }

    private void showRefinementTools(boolean flag)
    {
        if (!isRefinementToolsAnimating)
        {
            isRefinementToolsAnimating = true;
            showRefinementToolsTranslateAnimation(flag);
            return;
        } else
        {
            requestShowRefinementTools = Boolean.valueOf(flag);
            return;
        }
    }

    private void showRefinementToolsTranslateAnimation(final boolean show)
    {
        final ViewGroup refinementLayout = (ViewGroup)findViewById(0x7f100600);
        int i = refinementLayout.getBottom() - refinementLayout.getTop();
        TranslateAnimation translateanimation;
        if (show)
        {
            translateanimation = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
        } else
        {
            translateanimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i);
        }
        translateanimation.setDuration(350L);
        translateanimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final SearchResultFragmentActivity this$0;
            final ViewGroup val$refinementLayout;
            final boolean val$show;

            public void onAnimationEnd(Animation animation)
            {
                animation = refinementLayout;
                int j;
                if (show)
                {
                    j = 0;
                } else
                {
                    j = 4;
                }
                animation.setVisibility(j);
                isRefinementToolsAnimating = false;
                if (requestShowRefinementTools != null)
                {
                    showRefinementTools(requestShowRefinementTools.booleanValue());
                    requestShowRefinementTools = null;
                }
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                this$0 = SearchResultFragmentActivity.this;
                refinementLayout = viewgroup;
                show = flag;
                super();
            }
        });
        refinementLayout.startAnimation(translateanimation);
        if (isFollowBarEnabled())
        {
            final ViewGroup followLayout = (ViewGroup)findViewById(0x7f100606);
            i = followLayout.getBottom() - followLayout.getTop();
            if (show)
            {
                translateanimation = new TranslateAnimation(0.0F, 0.0F, i, 0.0F);
            } else
            {
                translateanimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, i);
            }
            translateanimation.setDuration(350L);
            translateanimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

                final SearchResultFragmentActivity this$0;
                final ViewGroup val$followLayout;
                final boolean val$show;

                public void onAnimationEnd(Animation animation)
                {
                    animation = followLayout;
                    int j;
                    if (show)
                    {
                        j = 0;
                    } else
                    {
                        j = 4;
                    }
                    animation.setVisibility(j);
                }

                public void onAnimationRepeat(Animation animation)
                {
                }

                public void onAnimationStart(Animation animation)
                {
                }

            
            {
                this$0 = SearchResultFragmentActivity.this;
                followLayout = viewgroup;
                show = flag;
                super();
            }
            });
            followLayout.startAnimation(translateanimation);
        }
        hideTransientDecorations();
    }

    private void trackBackcodeSuccess(String s, String s1, String s2)
    {
        TrackingData trackingdata = new TrackingData("BarcodeScanning", TrackingType.EVENT);
        trackingdata.addKeyValuePair("mfls", s2);
        trackingdata.addKeyValuePair("bct", s1);
        trackingdata.addKeyValuePair("bcd", s);
        trackingdata.send(this);
    }

    private void trackZrpEvent(String s)
    {
        trackZrpEvent(s, null);
    }

    private void trackZrpEvent(String s, Treatment treatment)
    {
        TrackingData trackingdata = new TrackingData("NullSearch", TrackingType.EVENT);
        trackingdata.addKeyValuePair("mfls", s);
        if (treatment != null && !treatment.isDefault)
        {
            trackingdata.addExperimentEventTargetTags(treatment);
        }
        trackingdata.send(this);
    }

    private void updateFollowButtons()
    {
        SearchRefineBarFragment searchrefinebarfragment = (SearchRefineBarFragment)getFragmentManager().findFragmentById(0x7f100601);
        if (searchrefinebarfragment != null)
        {
            searchrefinebarfragment.onFollowsChanged();
        }
        int i;
        if (isFollowBarEnabled())
        {
            Object obj = (Button)findViewById(0x7f100607);
            if (obj != null)
            {
                Resources resources = getResources();
                if (isFollowing())
                {
                    i = 0x7f0d00df;
                } else
                {
                    i = 0x7f0d00dd;
                }
                ((Button) (obj)).setTextColor(resources.getColor(i));
                resources = getResources();
                if (isFollowing())
                {
                    i = 0x7f070944;
                } else
                {
                    i = 0x7f070941;
                }
                ((Button) (obj)).setText(resources.getString(i));
            }
        }
        if (getResources().getBoolean(0x7f0b0007))
        {
            obj = getResources();
            if (isFollowing())
            {
                i = 0x7f070956;
            } else
            {
                i = 0x7f070955;
            }
            setFollowButtonText(((Resources) (obj)).getString(i));
        }
    }

    private void updateRecentSearch(SearchResult searchresult)
    {
label0:
        {
            boolean flag;
label1:
            {
                if (recentsDataManager == null)
                {
                    break label0;
                }
                boolean flag1 = false;
                flag = flag1;
                if (searchresult.expansions == null)
                {
                    break label1;
                }
                Iterator iterator = searchresult.expansions.iterator();
                SearchExpansion searchexpansion;
                do
                {
                    flag = flag1;
                    if (!iterator.hasNext())
                    {
                        break label1;
                    }
                    searchexpansion = (SearchExpansion)iterator.next();
                } while (!KnownSearchExpansion.SPELL_CHECK_AUTO.serviceExpansionName.equals(searchexpansion.expansionType) && !KnownSearchExpansion.SPELL_CHECK_SUGGESTED.serviceExpansionName.equals(searchexpansion.expansionType) || !searchexpansion.expansionResult.promotedToPrimary);
                flag = true;
            }
            SearchParameters searchparameters = searchresult.getOriginalSearchParameters();
            Object obj;
            Object obj1;
            long l;
            boolean flag2;
            if (!TextUtils.isEmpty(searchparameters.sellerId))
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (!TextUtils.isEmpty(searchparameters.sellerId))
            {
                obj1 = searchparameters.sellerId;
            } else
            {
                obj1 = searchparameters.productId;
            }
            if (TextUtils.isEmpty(((CharSequence) (obj1))))
            {
                obj = searchparameters.keywords;
            } else
            {
                obj = obj1;
                if (flag2)
                {
                    obj = obj1;
                    if (!TextUtils.isEmpty(searchparameters.keywords))
                    {
                        obj = (new StringBuilder()).append(((String) (obj1))).append(" ").append(searchparameters.keywords).toString();
                    }
                }
            }
            obj1 = searchparameters.category;
            if (obj1 != null)
            {
                l = ((EbayCategorySummary) (obj1)).id;
            } else
            {
                l = 0L;
            }
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                recentsDataManager.addRecentSearch(((String) (obj)), flag2, l, searchresult.totalItemCount, flag, searchparameters.productIdType);
            }
        }
    }

    public boolean areSearchParametersReady()
    {
        return searchParameters != placeholderSearchParameters;
    }

    protected int calculateHeaderHeight(boolean flag)
    {
        int i;
        int j;
        if (flag)
        {
            i = cachedHeaderHeight;
        } else
        {
            i = findViewById(0x7f100600).getHeight();
            cachedHeaderHeight = i;
        }
        j = i;
        if (i > 0)
        {
            j = i;
            if (searchParameters.sellerOffer == null)
            {
                j = i - findViewById(0x7f100602).getHeight();
            }
        }
        return j;
    }

    protected void calculateResultVerticalSpacing(boolean flag)
    {
        int i = calculateHeaderHeight(flag);
        if (i > 0)
        {
            ((SearchResultFragment)getFragmentManager().findFragmentById(0x7f1005ff)).cacheHeaderHeight(i);
        }
    }

    public void closeDrawer(int i)
    {
        if (i == 5 && drawer.isDrawerOpen(i))
        {
            drawer.closeDrawer(i);
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        if (icsCrashHackIgnoreBack)
        {
            return true;
        } else
        {
            return super.dispatchKeyEvent(keyevent);
        }
    }

    public EbayCguidPersister getCguidPersister()
    {
        return MyApp.getPrefs();
    }

    public DcsHelper getDeviceConfiguration()
    {
        return MyApp.getDeviceConfiguration();
    }

    protected android.view.View.OnClickListener getFollowButtonClickListener()
    {
        if (getResources().getBoolean(0x7f0b0007))
        {
            return new android.view.View.OnClickListener() {

                final SearchResultFragmentActivity this$0;

                public void onClick(View view)
                {
                    if (!isFollowing())
                    {
                        onFollowSearch(FollowSearchOrigin.GLOBAL_HEADER);
                        return;
                    } else
                    {
                        onUnfollowSearch();
                        return;
                    }
                }

            
            {
                this$0 = SearchResultFragmentActivity.this;
                super();
            }
            };
        } else
        {
            return null;
        }
    }

    public int getOpenDrawer()
    {
        return !drawer.isDrawerOpen(5) ? 0 : 5;
    }

    public SearchParameters getSearchParameters()
    {
        return searchParameters;
    }

    public String getSearchQuery()
    {
        return getSearchParameters().keywords;
    }

    public ISearchEventTracker getSearchTracker(SearchParameters searchparameters, Bundle bundle)
    {
        return new SearchEventTracker(searchparameters, bundle, EbaySite.getInstanceFromId(searchparameters.country.getSiteId()), getCguidPersister());
    }

    protected android.view.View.OnClickListener getSearchViewClickListener()
    {
        return new android.view.View.OnClickListener() {

            final SearchResultFragmentActivity this$0;

            public void onClick(View view)
            {
                view = new SourceIdentification("SearchResultsViewed");
                Intent intent = new Intent(SearchResultFragmentActivity.this, com/ebay/mobile/search/MainSearchActivity);
                intent.putExtra("com.ebay.mobile.analytics.sid", view);
                intent.putExtra("sellerId", searchParameters.sellerId);
                intent.putExtra("sellerOffer", searchParameters.sellerOffer);
                startActivityForResult(intent, -1);
            }

            
            {
                this$0 = SearchResultFragmentActivity.this;
                super();
            }
        };
    }

    public int getSearchViewType()
    {
        if (!DeviceConfiguration.getAsync().get(DcsBoolean.LargeSearchImages))
        {
            return 0;
        } else
        {
            return currentViewType;
        }
    }

    public Bundle getTrackingBundle()
    {
        Intent intent = getIntent();
        SourceIdentification sourceidentification = (SourceIdentification)intent.getParcelableExtra("com.ebay.mobile.analytics.sid");
        if (sourceidentification == null)
        {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.ebay.mobile.analytics.sid", sourceidentification);
        bundle.putString("sqp", trackingUserQuery);
        if (searchParameters.sellerId != null)
        {
            bundle.putString("sn", searchParameters.sellerId);
            bundle.putString("sQr", (new StringBuilder()).append("seller:").append(searchParameters.sellerId).toString());
        }
        intent.removeExtra("com.ebay.mobile.analytics.sid");
        intent.removeExtra("user_query");
        return bundle;
    }

    public String getTrackingEventName()
    {
        return "SearchResultsViewed";
    }

    public String getUser()
    {
        return MyApp.getPrefs().getCurrentUser();
    }

    protected SearchParameters initializeSearchParameters()
    {
        SearchParameters searchparameters1 = getParamsFromIntent(getIntent());
        SearchParameters searchparameters;
        if (searchparameters1 == null)
        {
            searchparameters = placeholderSearchParameters;
        } else
        {
            searchparameters = searchparameters1;
            if (searchparameters1.aspectHistogram != null)
            {
                searchparameters = searchparameters1;
                if (!searchparameters1.aspectHistogram.hasCheck())
                {
                    searchparameters1.aspectHistogram = null;
                    return searchparameters1;
                }
            }
        }
        return searchparameters;
    }

    public boolean isCategoryRefinementSupported()
    {
        return searchParameters.sellerId != null || !browseCategoriesSearch && !TextUtils.isEmpty(searchParameters.keywords);
    }

    public boolean isFollowBarEnabled()
    {
        if (isFollowBarEnabled != null)
        {
            return isFollowBarEnabled.booleanValue();
        }
        boolean flag;
        if (!((SearchRefineBarFragment)getFragmentManager().findFragmentById(0x7f100601)).isTabletLayout() && DeviceConfiguration.getAsync().get(DcsBoolean.SearchEnableFollowBar))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isFollowBarEnabled = Boolean.valueOf(flag);
        if (isFollowBarEnabled.booleanValue())
        {
            hideFollowBarTreatment = Experiments.getHideFollowBarTreatment(getSearchParameters().country.getSite(), getEbayContext());
            isFollowBarEnabled = Boolean.valueOf(com.ebay.mobile.experimentation.Experiments.FollowBarExperimentDefinition.isFollowBarVisible(hideFollowBarTreatment));
        } else
        {
            hideFollowBarTreatment = null;
        }
        return isFollowBarEnabled.booleanValue();
    }

    public boolean isFollowing()
    {
        return existingFollow != null;
    }

    public boolean isGbhSearch()
    {
        while (!DeviceConfiguration.getAsync().get(DcsNautilusBoolean.GBH) || searchParameters.country.isSite()) 
        {
            return false;
        }
        return true;
    }

    public boolean isNearEnabled()
    {
        return !isGbhSearch() && !MyApp.getPrefs().getUserIsPpa();
    }

    public boolean isRelatedSearchesEnabled()
    {
        return isRelatedSearchesSupported();
    }

    protected boolean isRelatedSearchesSupported()
    {
        return searchParameters.sellerId == null && searchParameters.productId == null && searchParameters.aspectHistogram == null && DeviceConfiguration.getAsync().get(DcsBoolean.RelatedSearches);
    }

    public boolean isSignedIn()
    {
        return MyApp.getPrefs().isSignedIn();
    }

    public boolean isUseMyLocationEnabled()
    {
        return DeviceConfiguration.getAsync().get(DcsBoolean.UseMyCurrentLocation);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        i;
        JVM INSTR tableswitch 65 65: default 28
    //                   65 29;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (!isFinishing() && j == -1)
        {
            if (searchParameters.iafToken == null)
            {
                searchParameters.iafToken = intent.getStringExtra("iaf_token");
            }
            String s = intent.getStringExtra(ACTION_ON_COMPLETE);
            if (ACTION_FOLLOW_SEARCH.equals(s))
            {
                String s1 = intent.getStringExtra(KEY_FOLLOW_ORIGIN);
                intent = FollowSearchOrigin.OTHER;
                if (!TextUtils.isEmpty(s1))
                {
                    intent = FollowSearchOrigin.valueOf(s1);
                }
                if (SearchUtil.showShippingCosts() && TextUtils.isEmpty(searchParameters.buyerPostalCode))
                {
                    searchParameters.buyerPostalCode = MyApp.getPrefs().getPostalCode().postalCode;
                    pendingFollowRequestedOrigin = intent;
                    onSearchRefinement(searchParameters, searchParameters.aspectHistogram);
                    return;
                }
                updateIsFollowed();
                if (!isFollowing())
                {
                    onFollowSearch(intent);
                    return;
                }
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onBackPressed()
    {
        if (drawer.isDrawerOpen(5))
        {
            drawer.closeDrawer(5);
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    public void onBarcodeSearchComplete(String s, String s1)
    {
        trackBackcodeSuccess(s, s1, "SF");
    }

    public void onBarcodeSearchFailed(String s, String s1)
    {
        TrackingData trackingdata = new TrackingData("BarcodeScanning", TrackingType.EVENT);
        trackingdata.addKeyValuePair("mfls", "SN");
        trackingdata.addKeyValuePair("bct", s1);
        trackingdata.addKeyValuePair("bcd", s);
        trackingdata.send(this);
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131756551: 
            break;
        }
        if (!isFollowing())
        {
            onFollowSearch(FollowSearchOrigin.FLOATING_BAR);
            return;
        } else
        {
            onUnfollowSearch();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (getResources().getInteger(0x7f0c0003) > 1)
        {
            viewIconsSelected.put(1, 0x7f020248);
            viewIconsUnselected.put(1, 0x7f020247);
        }
        placeholderSearchParameters = eBayDictionaryProvider.getDefaultSearchParameters(this, null);
        if (bundle == null)
        {
            currentViewType = MyApp.getPrefs().getPrefSearchView(0);
            searchParameters = initializeSearchParameters();
            boolean flag;
            if (searchParameters.category != null && TextUtils.isEmpty(searchParameters.keywords) && searchParameters.sellerId == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            browseCategoriesSearch = flag;
        } else
        {
            searchParameters = (SearchParameters)bundle.getParcelable("search_parameters");
            currentViewType = bundle.getInt("search_view");
            browseCategoriesSearch = bundle.getBoolean("search_browse_categories");
        }
        setContentView(0x7f0301e6);
        setTitle("");
        drawer = (DrawerLayout)findViewById(0x7f1005fc);
        drawer.setFocusableInTouchMode(false);
        if (DeviceConfiguration.getAsync().get(DcsBoolean.searchSavedSearchUseFollowInterest))
        {
            ackBar = (new AcknowledgementBar(this, (ViewGroup)findViewById(0x7f1005fd), 0x7f03001b)).enableDismissControl(DeviceConfiguration.getAsync().get(com.ebay.nautilus.domain.dcs.DcsDomain.Search.B.enableSrpUndoDismissButton));
        }
        bundle = getIntent();
        referrer = bundle.getStringExtra("com.ebay.mobile.tracking.Referrer");
        bidSource = bundle.getStringExtra("com.ebay.mobile.tracking.BidSource");
        trackingSid = (SourceIdentification)bundle.getParcelableExtra("com.ebay.mobile.analytics.sid");
        trackingUserQuery = bundle.getStringExtra("user_query");
        searchParameters.iafToken = getIafToken();
        searchRefineFragment = (SearchRefineFragment)getFragmentManager().findFragmentById(0x7f100608);
        findViewById(0x7f100607).setOnClickListener(this);
        calculatResultVerticalSpacingAfterLayout();
        drawer.setDrawerListener(this);
        drawer.setDrawerLockMode(1);
    }

    public void onDrawerClosed(View view)
    {
        Util.hideSoftInput(this, view);
    }

    public void onDrawerOpened(View view)
    {
        if (!((SearchResultFragment)getFragmentManager().findFragmentById(0x7f1005ff)).hasResults())
        {
            trackZrpEvent("NSRR");
        }
        onRefineOpen();
        if (!refinementToolsVisible)
        {
            showRefinementTools(true);
        }
        hideTransientDecorations();
        searchRefineFragment.updatePanelState();
    }

    public void onDrawerSlide(View view, float f)
    {
    }

    public void onDrawerStateChanged(int i)
    {
        if (i == 1 || i == 2)
        {
            searchRefineFragment.updatePanelState();
        }
    }

    public void onFollowSearch(FollowSearchOrigin followsearchorigin)
    {
        if (((SearchResultFragment)getFragmentManager().findFragmentById(0x7f1005ff)).getItemCount() == 0)
        {
            trackZrpEvent("NSRS", hideFollowBarTreatment);
        }
        if (hideFollowBarTreatment == null) goto _L2; else goto _L1
_L1:
        Object obj = null;
        static class _cls6
        {

            static final int $SwitchMap$com$ebay$mobile$search$SearchResultFragmentActivity$FollowSearchOrigin[];

            static 
            {
                $SwitchMap$com$ebay$mobile$search$SearchResultFragmentActivity$FollowSearchOrigin = new int[FollowSearchOrigin.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$search$SearchResultFragmentActivity$FollowSearchOrigin[FollowSearchOrigin.FLOATING_BAR.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$search$SearchResultFragmentActivity$FollowSearchOrigin[FollowSearchOrigin.CAROUSEL.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$search$SearchResultFragmentActivity$FollowSearchOrigin[FollowSearchOrigin.GLOBAL_HEADER.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$search$SearchResultFragmentActivity$FollowSearchOrigin[FollowSearchOrigin.OTHER.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls6..SwitchMap.com.ebay.mobile.search.SearchResultFragmentActivity.FollowSearchOrigin[followsearchorigin.ordinal()];
        JVM INSTR tableswitch 1 2: default 68
    //                   1 155
    //                   2 162;
           goto _L3 _L4 _L5
_L3:
        if (obj != null)
        {
            (new TrackingData(((String) (obj)), TrackingType.EVENT)).addExperimentEventTargetTags(hideFollowBarTreatment).send(this);
        }
_L2:
        obj = getSearchParameters().clone();
        if (searchRefineFragment.searchRequiresExplicitRootCategory() && ((SearchParameters) (obj)).category == null)
        {
            obj.category = new EbayCategorySummary(0L, null);
        }
        if (((SearchParameters) (obj)).completedListings)
        {
            Toast.makeText(this, getString(0x7f070131), 1).show();
            return;
        }
        break; /* Loop/switch isn't completed */
_L4:
        obj = "SavedSearchResults";
        continue; /* Loop/switch isn't completed */
_L5:
        obj = "NewSavedSearch";
        if (true) goto _L3; else goto _L6
_L6:
        if (((SearchParameters) (obj)).productId != null)
        {
            Toast.makeText(this, getString(0x7f070132), 1).show();
            return;
        }
        if (((SearchParameters) (obj)).sellerOffer != null)
        {
            Toast.makeText(this, getString(0x7f070134), 1).show();
            return;
        }
        if (isSignedIn())
        {
            SaveSearchDialogFragment.newInstance(((SearchParameters) (obj)), getUser()).show(getFragmentManager(), "dialog");
            return;
        } else
        {
            Intent intent = SignInModalActivity.getIntentForSignIn(getTrackingEventName(), this);
            intent.putExtra(ACTION_ON_COMPLETE, ACTION_FOLLOW_SEARCH);
            intent.putExtra(KEY_FOLLOW_ORIGIN, followsearchorigin.toString());
            startActivityForResult(intent, 65);
            return;
        }
    }

    public void onFollowedInterestDeleted(String s)
    {
        updateIsFollowed();
        updateFollowButtons();
    }

    public void onFollowedInterestsLoaded(Map map)
    {
        if (redirectForDeferredSavedSearchResolution())
        {
            return;
        } else
        {
            updateIsFollowed();
            updateFollowButtons();
            return;
        }
    }

    public void onIafTokenFailure()
    {
        MyApp.signOutForIafTokenFailure(this);
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        Object obj = MyApp.getPrefs().getAuthentication();
        if (obj != null)
        {
            obj = ((Authentication) (obj)).iafToken;
        } else
        {
            obj = "";
        }
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            recentsDataManager = (RecentsDataManager)datamanagercontainer.initialize(new com.ebay.mobile.recents.RecentsDataManager.KeyParams(((String) (obj))), null);
        }
        if (DeviceConfiguration.getAsync().get(DcsBoolean.searchSavedSearchUseFollowInterest))
        {
            followedEntityDataManager = (FollowedEntityDataManager)datamanagercontainer.initialize(FollowedEntityDataManager.KEY, followObserver);
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                followedEntityDataManager.getFollows(((String) (obj)), getSearchParameters().country.getSite(), false);
            }
            undoUnfollowListener = new UndoUnfollowListener(this, followedEntityDataManager, this);
        }
    }

    protected void onNewIntent(Intent intent)
    {
        SiteSpeedActivityUtil.initSiteSpeedData(this, getTrackingEventName());
        super.onNewIntent(intent);
        referrer = intent.getStringExtra("com.ebay.mobile.tracking.Referrer");
        bidSource = intent.getStringExtra("com.ebay.mobile.tracking.BidSource");
        trackingSid = (SourceIdentification)intent.getParcelableExtra("com.ebay.mobile.analytics.sid");
        trackingUserQuery = intent.getStringExtra("user_query");
        setIntent(intent);
        intent = getParamsFromIntent(intent);
        searchParameters.productId = null;
        searchParameters.productIdType = null;
        if (onNewSearchParametersDelivered(intent))
        {
            searchParameters.keywords = ((SearchParameters) (intent)).keywords;
        } else
        {
            searchParameters = initializeSearchParameters();
            searchRefineFragment.onSearchContextChanged();
        }
        intent = MyApp.getPrefs().getAuthentication();
        if (intent != null)
        {
            searchParameters.iafToken = ((Authentication) (intent)).iafToken;
        }
        ((SearchResultFragment)getFragmentManager().findFragmentById(0x7f1005ff)).restartSearch(searchParameters, true, searchRefineFragment.searchRequiresExplicitRootCategory());
        searchRefineFragment.reset();
    }

    protected boolean onNewSearchParametersDelivered(SearchParameters searchparameters)
    {
        EbayCategorySummary ebaycategorysummary = searchparameters.category;
        String s;
        boolean flag;
        boolean flag1;
        if (searchParameters.keywords != null)
        {
            s = searchParameters.keywords.toLowerCase(Locale.getDefault());
        } else
        {
            s = null;
        }
        if (searchparameters.keywords != null)
        {
            searchparameters = searchparameters.keywords.toLowerCase(Locale.getDefault());
        } else
        {
            searchparameters = null;
        }
        if (searchparameters != null && (TextUtils.isEmpty(s) || searchparameters.contains(s)))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (ebaycategorysummary == null || ebaycategorysummary.equals(searchParameters.category))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        return flag1 && (flag || browseCategoriesSearch);
    }

    public void onPromptForStringCompleted(String s, boolean flag, String s1, Bundle bundle)
    {
        searchRefineFragment.onPromptForStringCompleted(s, flag, s1, bundle);
    }

    public void onPromptOfEbayNowCorrection()
    {
        Object obj = MyApp.getPrefs().getShipToPostalCode();
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = ((PostalCodeSpecification) (obj)).postalCode;
        }
        if (!TextUtils.equals(searchParameters.buyerPostalCode, ((CharSequence) (obj))))
        {
            obj = new TrackingData("SearchRefinements", TrackingType.EVENT);
            ((TrackingData) (obj)).addKeyValuePair("uzc", searchParameters.buyerPostalCode);
            ((TrackingData) (obj)).send(this);
        }
    }

    public void onRefineAspect()
    {
        (new TrackingData("RefineAspect", TrackingType.PAGE_IMPRESSION)).send(this);
    }

    public void onRefineAuctionType()
    {
        (new TrackingData("RefineAuctionType", TrackingType.PAGE_IMPRESSION)).send(this);
    }

    public void onRefineCategory()
    {
        (new TrackingData("RefineCategory", TrackingType.PAGE_IMPRESSION)).send(this);
    }

    public void onRefineCondition()
    {
        (new TrackingData("RefineItemCondition", TrackingType.PAGE_IMPRESSION)).send(this);
    }

    public void onRefineMaxDistance()
    {
        (new TrackingData("RefineMaxDistance", TrackingType.PAGE_IMPRESSION)).send(this);
    }

    public void onRefineNear()
    {
        (new TrackingData("RefineNear", TrackingType.PAGE_IMPRESSION)).send(this);
    }

    public void onRefineOpen()
    {
        (new TrackingData("RefineSearch", TrackingType.PAGE_IMPRESSION)).send(this);
    }

    public void onRefinePreferredLocation()
    {
        (new TrackingData("RefineSearchPreferredLocation", TrackingType.PAGE_IMPRESSION)).send(this);
    }

    public void onRefinePriceRange()
    {
        (new TrackingData("RefinePriceRange", TrackingType.PAGE_IMPRESSION)).send(this);
    }

    public void onRefineSort(String s)
    {
        (new TrackingData(s, TrackingType.PAGE_IMPRESSION)).send(this);
    }

    public void onRelatedSearchItemClicked(ArrayList arraylist)
    {
        icsCrashHackIgnoreBack = true;
        Intent intent = new Intent(this, com/ebay/mobile/search/RelatedSearchesActivity);
        intent.putStringArrayListExtra("related_searches", arraylist);
        intent.putExtra("com.ebay.mobile.tracking.Referrer", referrer);
        intent.putExtra("com.ebay.mobile.tracking.BidSource", bidSource);
        intent.putExtra("search_param", searchParameters);
        startActivity(intent);
    }

    public void onRelatedSearchesAvailable()
    {
        TrackingData trackingdata = new TrackingData("RelatedSearchAvailable", TrackingType.EVENT);
        trackingdata.addKeyValuePair("mfls", "sra");
        trackingdata.send(this);
    }

    public void onRequestTermination()
    {
        finish();
    }

    public void onResume()
    {
        super.onResume();
        icsCrashHackIgnoreBack = false;
        sendPageImpression();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("search_parameters", searchParameters);
        bundle.putInt("search_view", currentViewType);
        bundle.putBoolean("search_browse_categories", browseCategoriesSearch);
    }

    public void onSaveSearch()
    {
        (new TrackingData("SavedSearchSave", TrackingType.EVENT)).addExperimentEventTargetTags(hideFollowBarTreatment).send(this);
    }

    public void onScrollDown()
    {
        if (refinementToolsVisible)
        {
            showRefinementTools(false);
            refinementToolsVisible = false;
        }
    }

    public void onScrollUp()
    {
        if (!refinementToolsVisible)
        {
            showRefinementTools(true);
            refinementToolsVisible = true;
        }
    }

    public void onSearchComplete(SearchResult searchresult)
    {
        Object obj = searchresult.getRedLaserCorrectedSearch();
        if (obj != null)
        {
            obj = ((com.ebay.common.net.api.search.SearchResult.RedLaserCorrectedSearch) (obj)).getSearchParameters();
            trackBackcodeSuccess(((SearchParameters) (obj)).productId, ((SearchParameters) (obj)).productIdType, "RLFB");
        }
        searchParameters = searchresult.getSearchParameters();
        boolean flag1 = browseCategoriesSearch;
        boolean flag;
        if (searchParameters.category != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        browseCategoriesSearch = flag & flag1;
        updateIsFollowed();
        searchRefineFragment.setSearchParameters(searchParameters, searchresult.aspects, searchresult.categories);
        drawer.setDrawerLockMode(0);
        DeviceConfiguration.getAsync().get(DcsBoolean.LargeSearchImages);
        ((SearchRefineBarFragment)getFragmentManager().findFragmentById(0x7f100601)).updateFragmentState(searchresult);
        setRefinementToolbarVisibility(true);
        calculateResultVerticalSpacing(true);
        if (searchresult.totalItemCount > 0)
        {
            obj = getIntent();
            if (((Intent) (obj)).getBooleanExtra("open_refine_panel", false))
            {
                ((Intent) (obj)).removeExtra("open_refine_panel");
                drawer.openDrawer(5);
            }
        }
        updateFollowButtons();
        showRefinementTools(true);
        obj = searchresult.getKeywords();
        updateRecentSearch(searchresult);
        if (browseCategoriesSearch)
        {
            setSearchViewText(getString(0x7f0705a8, new Object[] {
                searchParameters.category.name
            }));
        } else
        if (searchParameters.sellerId != null)
        {
            if (TextUtils.isEmpty(searchParameters.keywords))
            {
                setSearchViewText(getString(0x7f0705a8, new Object[] {
                    searchParameters.sellerId
                }));
            } else
            {
                setSearchViewText((new StringBuilder()).append("seller:").append(searchParameters.sellerId).append(" ").append(searchParameters.keywords).toString());
            }
        } else
        if (searchParameters.productId != null)
        {
            if (SearchPrefixType.EAN.getName().startsWith(searchParameters.productIdType) || SearchPrefixType.UPC.getName().startsWith(searchParameters.productIdType))
            {
                setSearchViewText((new StringBuilder()).append(searchParameters.productIdType).append(":").append(searchParameters.productId).toString());
            } else
            {
                setSearchViewText(((String) (obj)));
            }
        } else
        {
            setSearchViewText(searchParameters.keywords);
        }
        if (pendingFollowRequestedOrigin != null)
        {
            if (!isFollowing())
            {
                onFollowSearch(pendingFollowRequestedOrigin);
            }
            pendingFollowRequestedOrigin = null;
        }
    }

    public void onSearchError(boolean flag)
    {
        if (flag)
        {
            showRefinementTools(true);
        }
    }

    public void onSearchFollowed(FollowDescriptor followdescriptor)
    {
        updateIsFollowed();
        updateFollowButtons();
    }

    public void onSearchItemClicked(long l, Date date, ItemCurrency itemcurrency, boolean flag, com.ebay.common.ConstantsCommon.ItemKind itemkind, int i)
    {
        String s = null;
        if (searchParameters.inStorePickupOnly || searchParameters.ebnOnly)
        {
            s = searchParameters.buyerPostalCode;
        }
        ItemViewActivity.StartActivity(this, l, date, itemkind, referrer, bidSource, i, s, searchParameters.inStorePickupOnly, searchParameters.ebnOnly, searchParameters.searchOtherCountries, itemcurrency, flag);
    }

    public void onSearchRefinement(SearchParameters searchparameters, EbayAspectHistogram ebayaspecthistogram)
    {
        searchparameters.aspectHistogram = ebayaspecthistogram;
        ((SearchResultFragment)getFragmentManager().findFragmentById(0x7f1005ff)).applyRefinements(searchparameters, searchRefineFragment.searchRequiresExplicitRootCategory());
    }

    public void onSearchStarted(SearchParameters searchparameters)
    {
        searchParameters = searchparameters;
        setTitle("");
        setSearchViewText("");
        if (!browseCategoriesSearch && searchparameters.sellerId == null)
        {
            setSearchViewText(searchparameters.keywords);
        }
        setRefinementToolbarVisibility(false);
        if (!drawer.isDrawerOpen(5))
        {
            drawer.setDrawerLockMode(1);
        }
    }

    public void onShowRefinement(DetailMode detailmode, DetailLaunchMode detaillaunchmode)
    {
        searchRefineFragment.refine(detailmode, detaillaunchmode);
        drawer.openDrawer(5);
    }

    public void onUnfollowSearch()
    {
        if (followedEntityDataManager != null && isFollowing())
        {
            Object obj = (com.ebay.mobile.notifications.PollService.SavedSearchPollData)(new ItemCache(this)).getSavedSearches().get(Long.valueOf(existingFollow.interest.interestId));
            obj = new RefollowData(existingFollow, ((com.ebay.mobile.notifications.PollService.SavedSearchPollData) (obj)), searchParameters.iafToken);
            followedEntityDataManager.deleteFollow(FollowType.INTEREST, existingFollow.getInterestId(), getIafToken());
            DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
            if (deviceconfiguration.get(DcsBoolean.searchSavedSearchUseFollowInterest) && deviceconfiguration.get(com.ebay.nautilus.domain.dcs.DcsDomain.Search.B.enableSrpUnfollowAcknowledgement))
            {
                ackBar.show(getString(0x7f070b8b), existingFollow.getInterestTitle(), obj, undoUnfollowListener);
            }
        }
    }

    public void onViewSwitched(int i)
    {
        SearchResultFragment searchresultfragment;
        currentViewType = i;
        searchresultfragment = (SearchResultFragment)getFragmentManager().findFragmentById(0x7f1005ff);
        currentViewType;
        JVM INSTR tableswitch 0 1: default 44
    //                   0 79
    //                   1 87;
           goto _L1 _L2 _L3
_L1:
        searchRefineFragment.updateViewModeIcons();
        ((SearchRefineBarFragment)getFragmentManager().findFragmentById(0x7f100601)).setViewSwitcherState(i);
        MyApp.getPrefs().setPrefSearchView(currentViewType);
        return;
_L2:
        searchresultfragment.layoutSearchResults(0);
        continue; /* Loop/switch isn't completed */
_L3:
        searchresultfragment.layoutSearchResults(1);
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void onZeroResults(boolean flag)
    {
        if (flag)
        {
            trackZrpEvent("NSR1");
            return;
        } else
        {
            trackZrpEvent("NSR0");
            return;
        }
    }

    public void openDrawer(int i)
    {
        if (i == 5 && !drawer.isDrawerOpen(i))
        {
            onShowRefinement(DetailMode.ROOT, DetailLaunchMode.DEFAULT);
        }
    }

    public void resetSearchParameters(String s)
    {
        EbayCategorySummary ebaycategorysummary = searchParameters.category;
        com.ebay.common.net.api.search.SellerOfferParameters sellerofferparameters = searchParameters.sellerOffer;
        String s1 = searchParameters.sellerId;
        searchParameters = eBayDictionaryProvider.getDefaultSearchParameters(this, s);
        if (browseCategoriesSearch)
        {
            searchParameters.category = ebaycategorysummary;
        }
        if (sellerofferparameters != null)
        {
            searchParameters.sellerOffer = sellerofferparameters;
        }
        if (s1 != null)
        {
            searchParameters.sellerId = s1;
        }
        ((SearchResultFragment)getFragmentManager().findFragmentById(0x7f1005ff)).restartSearch(searchParameters, true, false);
    }

    protected void sendPageImpression()
    {
        TrackingData trackingdata = new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION);
        trackingdata.addExperimentServedTags(((SearchResultFragment)getFragmentManager().findFragmentById(0x7f1005ff)).adsExperimentState);
        Object obj;
        if (DeviceInfoUtil.isPortrait(this))
        {
            obj = "p";
        } else
        {
            obj = "l";
        }
        trackingdata.addKeyValuePair("ort", ((String) (obj)));
        if (hideFollowBarTreatment != null && !hideFollowBarTreatment.isDefault)
        {
            trackingdata.addExperimentServedTags(hideFollowBarTreatment);
        }
        if (trackingSid != null)
        {
            trackingdata.addSourceIdentification(trackingSid);
            trackingSid = null;
            trackingUserQuery = null;
        }
        trackingdata.send(this);
        obj = getIntent();
        if (((Intent) (obj)).getBooleanExtra("saved_search_from_notification", false))
        {
            TrackingData trackingdata1 = new TrackingData("SearchResultsFromSSNotification", TrackingType.EVENT);
            trackingdata1.addKeyValuePair("ssrid", ((Intent) (obj)).getStringExtra("saved_search_id"));
            NotificationTrackingUtil.addNotificationTracking(this, trackingdata1, ((Intent) (obj)), com.ebay.common.model.mdns.NotificationPreference.EventType.SVDSRCH.name());
            trackingdata1.send(this);
        }
    }

    public void setSearchViewType(int i)
    {
        onViewSwitched(i);
    }

    public void updateIsFollowed()
    {
        if (followObserver != null && followedEntityDataManager != null)
        {
            FollowDescriptor followdescriptor = followObserver.getFollow(searchParameters);
            if (followdescriptor != null)
            {
                existingFollow = followdescriptor;
                return;
            }
        }
        existingFollow = null;
    }



/*
    static boolean access$002(SearchResultFragmentActivity searchresultfragmentactivity, boolean flag)
    {
        searchresultfragmentactivity.isRefinementToolsAnimating = flag;
        return flag;
    }

*/



/*
    static Boolean access$102(SearchResultFragmentActivity searchresultfragmentactivity, Boolean boolean1)
    {
        searchresultfragmentactivity.requestShowRefinementTools = boolean1;
        return boolean1;
    }

*/

}

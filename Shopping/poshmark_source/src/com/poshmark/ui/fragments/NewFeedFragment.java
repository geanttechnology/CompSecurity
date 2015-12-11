// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplication;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.config.NewRelicWrapper;
import com.poshmark.data_model.adapters.HetroFeedListAdapter;
import com.poshmark.data_model.models.Feed;
import com.poshmark.data_model.models.ListingDetails;
import com.poshmark.data_model.models.inner_models.Comment;
import com.poshmark.data_model.models.inner_models.FeedAutoRefreshFeature;
import com.poshmark.data_model.models.inner_models.FeedLazyLoadFeature;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.ListingNotificationHandler;
import com.poshmark.notifications.ListingNotificationManager;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.notifications.SynchronousBroadcastListener;
import com.poshmark.notifications.SynchronousBroadcastManager;
import com.poshmark.triggers.PMTriggerManager;
import com.poshmark.triggers.RateAppTrigger;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.customviews.PMButton;
import com.poshmark.ui.customviews.PMListView;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.DateUtils;
import com.poshmark.utils.FeatureManager;
import com.poshmark.utils.FeedCacheHelper;
import com.poshmark.utils.FeedDeserializer;
import com.poshmark.utils.NewRelicCustomInteractions;
import com.poshmark.utils.PMLoveDialog;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, FindPeopleFragment

public class NewFeedFragment extends PMFragment
    implements ListingNotificationHandler, SynchronousBroadcastListener
{

    HetroFeedListAdapter adapter;
    FeedCacheHelper cacheHelper;
    Feed feedData;
    PMListView feedListView;
    boolean isFragmentBeingPoppedOfStack;
    boolean isFragmentBeingResurrected;
    PMButton newItemsBubble;
    int pagesScrolled;

    public NewFeedFragment()
    {
        pagesScrolled = 0;
        cacheHelper = new FeedCacheHelper();
        isFragmentBeingResurrected = false;
        isFragmentBeingPoppedOfStack = false;
    }

    private void checkForTrigger()
    {
        if (bUpdateOnShow)
        {
            RateAppTrigger rateapptrigger = PMTriggerManager.getGlobalTriggerManager().getRateAppTrigger();
            if (rateapptrigger != null && rateapptrigger.isValid())
            {
                rateapptrigger.incrementViewCount();
                if (rateapptrigger.shouldFireTrigger())
                {
                    executeAppRateFlow(rateapptrigger);
                }
            }
        }
    }

    private void executeAppRateFlow(RateAppTrigger rateapptrigger)
    {
        (new PMLoveDialog(rateapptrigger)).show(getFragmentManager(), "pmLoveDlg");
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "app", "app_love_alert_displayed", null);
    }

    private Feed generateModel(String s)
    {
        Gson gson = (new GsonBuilder()).registerTypeAdapter(com/poshmark/data_model/models/Feed, new FeedDeserializer()).create();
        if (!(gson instanceof Gson))
        {
            s = ((String) (gson.fromJson(s, com/poshmark/data_model/models/Feed)));
        } else
        {
            s = ((String) (GsonInstrumentation.fromJson((Gson)gson, s, com/poshmark/data_model/models/Feed)));
        }
        return (Feed)s;
    }

    private void getFeed(boolean flag)
    {
        if (!flag)
        {
            if (pagesScrolled > 0)
            {
                Analytics.getInstance().trackEventWithValue(viewNameForAnalytics, "listing", "pages_scrolled_by_user", null, pagesScrolled);
                pagesScrolled = 0;
            }
            showProgressDialogWithMessage(getResources().getString(0x7f060190));
            PMApi.getHetroFeed(null, new PMApiResponseHandler() {

                final NewFeedFragment this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    if (isAdded())
                    {
                        NewFeedFragment.this.handleResponse(pmapiresponse, false);
                    }
                }

            
            {
                this$0 = NewFeedFragment.this;
                super();
            }
            });
        } else
        if (feedData.getNextPageMaxValue() != null)
        {
            pagesScrolled = pagesScrolled + 1;
            PMApi.getHetroFeed(feedData.getNextPageMaxValue(), new PMApiResponseHandler() {

                final NewFeedFragment this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    if (isAdded())
                    {
                        NewFeedFragment.this.handleResponse(pmapiresponse, true);
                    }
                }

            
            {
                this$0 = NewFeedFragment.this;
                super();
            }
            });
            return;
        }
    }

    private void handleResponse(PMApiResponse pmapiresponse, boolean flag)
    {
        hideProgressDialog();
        if (pmapiresponse.hasError()) goto _L2; else goto _L1
_L1:
        Feed feed = generateModel(pmapiresponse.responseString);
        if (flag) goto _L4; else goto _L3
_L3:
        feedData = feed;
        feedData.createHashAndRemoveDups();
        feedListView.setListData(feedData);
        feedListView.updateList();
        feedListView.setSelection(0);
        cacheHelper.saveFeed(pmapiresponse.responseString);
_L6:
        return;
_L4:
        feedData.append(feed);
        feedListView.updateList();
        return;
_L2:
        if (!flag)
        {
            showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.LOAD_MY_FEED, PMApplication.getContext().getString(0x7f0600e7)));
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void setupFeedList()
    {
        boolean flag2 = false;
        boolean flag5 = false;
        boolean flag4 = false;
        Object obj = null;
        String s = obj;
        boolean flag3 = flag4;
        if (cacheHelper.isCachedFeedAvailable())
        {
            java.util.Date date = cacheHelper.getLastCachedDate();
            FeedAutoRefreshFeature feedautorefreshfeature = FeatureManager.getGlobalFeatureManager().getFeedAutoRefreshFeature();
            boolean flag = flag5;
            if (feedautorefreshfeature != null)
            {
                flag = flag5;
                if (feedautorefreshfeature.isEnabled())
                {
                    flag = flag5;
                    if (!DateUtils.isDateWithinPastWindow(date, feedautorefreshfeature.geAutoRefreshIntervalInSeconds(), com.poshmark.utils.DateUtils.TIME_UNIT.SECONDS))
                    {
                        flag = true;
                    }
                }
            }
            FeedLazyLoadFeature feedlazyloadfeature = FeatureManager.getGlobalFeatureManager().getFeedLazyLoadFeature();
            s = obj;
            flag2 = flag;
            flag3 = flag4;
            if (feedlazyloadfeature != null)
            {
                s = obj;
                flag2 = flag;
                flag3 = flag4;
                if (feedautorefreshfeature.isEnabled())
                {
                    String s1 = feedlazyloadfeature.getTitle();
                    s = s1;
                    flag2 = flag;
                    flag3 = flag4;
                    if (!DateUtils.isDateWithinPastWindow(date, feedlazyloadfeature.geBubbleDisplayIntervalInSeconds(), com.poshmark.utils.DateUtils.TIME_UNIT.SECONDS))
                    {
                        flag3 = true;
                        flag2 = flag;
                        s = s1;
                    }
                }
            }
        }
        boolean flag1;
        if (feedData != null)
        {
            feedListView.setListData(feedData);
            flag1 = flag2;
            if (bUpdateOnShow)
            {
                NewRelicWrapper.startCustomInteraction(NewRelicCustomInteractions.USER_TRIGGERED_FEED_REFRESH);
                flag1 = flag2;
            }
        } else
        if (isFragmentBeingResurrected)
        {
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "app", "feed_resurrected", null);
            if (cacheHelper.isCachedFeedAvailable())
            {
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "app", "cached_items_displayed", null);
                feedData = generateModel(cacheHelper.getCachedFeed());
                feedListView.setListData(feedData);
                feedListView.updateList();
                feedListView.setSelection(0);
                flag1 = flag2;
            } else
            {
                flag1 = true;
                NewRelicWrapper.startCustomInteraction(NewRelicCustomInteractions.APP_FOREGROUND_FEED_REFRESH);
            }
        } else
        {
            NewRelicWrapper.startCustomInteraction(NewRelicCustomInteractions.APP_LAUNCH_FEED_REFRESH);
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "app", "feed_cold_start", null);
            flag1 = true;
        }
        if (PMApplicationSession.GetPMSession().isLoggedIn())
        {
            if (flag1 || bUpdateOnShow)
            {
                bUpdateOnShow = false;
                newItemsBubble.setVisibility(8);
                showProgressDialogWithMessage(getResources().getString(0x7f060190));
                getFeed(false);
            } else
            if (flag3)
            {
                if (s != null)
                {
                    newItemsBubble.setText(s);
                }
                newItemsBubble.setCompoundDrawablesWithIntrinsicBounds(0x7f02010d, 0, 0, 0);
                newItemsBubble.setVisibility(0);
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "app", "new_items_bubble_displayed", null);
                return;
            }
        }
    }

    private void showFindPeopleFragment()
    {
        ((PMActivity)getActivity()).launchFragmentInNewActivity(null, com/poshmark/ui/fragments/FindPeopleFragment, null);
    }

    public void addCommentToListing(String s, Comment comment)
    {
        if (feedData != null)
        {
            feedListView.updateList();
        }
    }

    public void deleteListing(String s)
    {
        if (feedData != null)
        {
            feedListView.updateList();
        }
    }

    public String getTrackingLabel()
    {
        return "fd2";
    }

    public void handleNotification(Intent intent)
    {
        if (intent.getAction().equals("com.poshmark.intents.LOGOUT_COMPLETE"))
        {
            feedData = null;
            cacheHelper.clearCachedFeed();
        }
        if (intent.getAction().equals("com.poshmark.intents.LOGIN_COMPLETE") && PMApplicationSession.GetPMSession().isLoggedIn())
        {
            if (getUserVisibleHint())
            {
                showProgressDialogWithMessage(getResources().getString(0x7f060190));
                getFeed(false);
            } else
            {
                bUpdateOnShow = true;
            }
        }
        if (intent.getAction().equals("com.poshmark.intents.UPDATE_FEED") && PMApplicationSession.GetPMSession().isLoggedIn())
        {
            getFeed(false);
        }
    }

    public void handleSynchronousBroadcastMsg(String s, Object obj)
    {
        if (!s.equals("com.poshmark.intents.LOGOUT_COMPLETE"));
    }

    public void likeListing(String s, boolean flag)
    {
        if (feedData != null)
        {
            feedListView.updateList();
        }
    }

    public void newListingCreated()
    {
        bUpdateOnShow = true;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        adapter = new HetroFeedListAdapter(getActivity(), this, null, 0x80000000);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.LOGIN_COMPLETE", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.LOGOUT_COMPLETE", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.UPDATE_FEED", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.APP_UPGRADED", this);
        ListingNotificationManager.getListingNotificationManager().registerListingMessageHandler(this);
        isFragmentBeingResurrected = getArguments().getBoolean("RESURRECTION", false);
        isFragmentBeingPoppedOfStack = getArguments().getBoolean("FRAGMENT_BEING_POPPED_OFF_STACK", false);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f03003e, viewgroup, false);
        feedListView = (PMListView)layoutinflater.findViewById(0x7f0c010d);
        feedListView.setup(adapter, null, null, new com.poshmark.ui.customviews.PMListView.LoadMoreItemsListener() {

            final NewFeedFragment this$0;

            public void loadItems(boolean flag)
            {
                getFeed(true);
            }

            
            {
                this$0 = NewFeedFragment.this;
                super();
            }
        });
        newItemsBubble = (PMButton)layoutinflater.findViewById(0x7f0c010e);
        newItemsBubble.setOnClickListener(new android.view.View.OnClickListener() {

            final NewFeedFragment this$0;

            public void onClick(View view)
            {
                NewRelicWrapper.startCustomInteraction(NewRelicCustomInteractions.USER_TRIGGERED_FEED_REFRESH);
                newItemsBubble.setVisibility(8);
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "new_items_bubble_clicked", null);
                PMApi.getViewTrackingInfo("fd");
                getFeed(false);
            }

            
            {
                this$0 = NewFeedFragment.this;
                super();
            }
        });
        return layoutinflater;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
    }

    public void onPMResume()
    {
        super.onPMResume();
        SynchronousBroadcastManager.getSyncronousBroadcastManager().registerSynchronousBroadcastListener("com.poshmark.intents.LOGOUT_COMPLETE", this);
        if (getUserVisibleHint())
        {
            checkForTrigger();
            setupFeedList();
        }
    }

    public void onStop()
    {
        super.onStop();
        adapter.clearImageList();
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "listings_feed_screen";
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        showLogoAsTitle();
        showRefreshButton(true);
        setRefreshActionButtonListener(new android.view.View.OnClickListener() {

            final NewFeedFragment this$0;

            public void onClick(View view)
            {
                NewRelicWrapper.startCustomInteraction(NewRelicCustomInteractions.USER_TRIGGERED_FEED_REFRESH);
                newItemsBubble.setVisibility(8);
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "refresh_myfeed_clicked", null);
                PMApi.getViewTrackingInfo("fd");
                getFeed(false);
            }

            
            {
                this$0 = NewFeedFragment.this;
                super();
            }
        });
        showFindPeopleButton(true);
        showSearchButton(true);
        setSearchActionButtonListener(new android.view.View.OnClickListener() {

            final NewFeedFragment this$0;

            public void onClick(View view)
            {
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "app", "search_listings_button_clicked", null);
                view = new Bundle();
                view.putInt("TAB_INDEX", 1);
                PMNotificationManager.fireNotification("com.poshmark.intents.SWITCH_TAB", view);
            }

            
            {
                this$0 = NewFeedFragment.this;
                super();
            }
        });
        setFindPeopleActionButtonListener(new android.view.View.OnClickListener() {

            final NewFeedFragment this$0;

            public void onClick(View view)
            {
                showFindPeopleFragment();
            }

            
            {
                this$0 = NewFeedFragment.this;
                super();
            }
        });
    }

    public void updateListing(ListingDetails listingdetails)
    {
        if (feedData != null)
        {
            feedListView.updateList();
        }
    }



}

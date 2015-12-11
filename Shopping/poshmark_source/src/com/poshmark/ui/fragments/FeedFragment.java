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
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplication;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.adapters.FeedListAdapter;
import com.poshmark.data_model.models.Feed_v1;
import com.poshmark.data_model.models.ListingDetails;
import com.poshmark.data_model.models.PMData;
import com.poshmark.data_model.models.inner_models.Comment;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.ListingNotificationHandler;
import com.poshmark.notifications.ListingNotificationManager;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.notifications.SynchronousBroadcastListener;
import com.poshmark.notifications.SynchronousBroadcastManager;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.customviews.PMListView;
import com.poshmark.ui.model.ActionErrorContext;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, FindPeopleFragment

public class FeedFragment extends PMFragment
    implements ListingNotificationHandler, SynchronousBroadcastListener
{

    FeedListAdapter adapter;
    Feed_v1 feedData;
    PMListView feedListView;

    public FeedFragment()
    {
    }

    private void getFeed(boolean flag)
    {
        if (!flag)
        {
            showProgressDialogWithMessage(getResources().getString(0x7f060190));
            PMApi.getFeed(null, new PMApiResponseHandler() {

                final FeedFragment this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    if (isAdded())
                    {
                        FeedFragment.this.handleResponse(pmapiresponse, false);
                    }
                }

            
            {
                this$0 = FeedFragment.this;
                super();
            }
            });
        } else
        if (feedData.getNextPageMaxValue() != null)
        {
            PMApi.getFeed(feedData.getNextPageMaxValue(), new PMApiResponseHandler() {

                final FeedFragment this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    if (isAdded())
                    {
                        FeedFragment.this.handleResponse(pmapiresponse, true);
                    }
                }

            
            {
                this$0 = FeedFragment.this;
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
        if (flag) goto _L4; else goto _L3
_L3:
        feedData = (Feed_v1)pmapiresponse.data;
        feedData.createHashAndRemoveDups();
        feedListView.setListData(feedData);
        feedListView.updateList();
        feedListView.setSelection(0);
_L6:
        return;
_L4:
        feedData.append((PMData)pmapiresponse.data);
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
        if (feedData != null)
        {
            feedListView.setListData(feedData);
        }
        if (PMApplicationSession.GetPMSession().isLoggedIn() && (feedData == null || bUpdateOnShow))
        {
            bUpdateOnShow = false;
            showProgressDialogWithMessage(getResources().getString(0x7f060190));
            getFeed(false);
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
            feedData.addNewComment(s, comment);
            feedListView.updateList();
        }
    }

    public void deleteListing(String s)
    {
        if (feedData != null)
        {
            feedData.deleteListing(s);
            feedListView.updateList();
        }
    }

    public String getTrackingLabel()
    {
        return "fd";
    }

    public void handleNotification(Intent intent)
    {
        if (intent.getAction().equals("com.poshmark.intents.LOGOUT_COMPLETE"))
        {
            feedData = null;
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
            feedData.updateLikeStatus(s, flag);
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
        adapter = new FeedListAdapter(getActivity(), this, null, 0x80000000);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.LOGIN_COMPLETE", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.LOGOUT_COMPLETE", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.UPDATE_FEED", this);
        ListingNotificationManager.getListingNotificationManager().registerListingMessageHandler(this);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f03003e, viewgroup, false);
        feedListView = (PMListView)layoutinflater.findViewById(0x7f0c010d);
        feedListView.setup(adapter, null, null, new com.poshmark.ui.customviews.PMListView.LoadMoreItemsListener() {

            final FeedFragment this$0;

            public void loadItems(boolean flag)
            {
                getFeed(true);
            }

            
            {
                this$0 = FeedFragment.this;
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

            final FeedFragment this$0;

            public void onClick(View view)
            {
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "refresh_myfeed_clicked", null);
                PMApi.getViewTrackingInfo("fd");
                getFeed(false);
            }

            
            {
                this$0 = FeedFragment.this;
                super();
            }
        });
        showFindPeopleButton(true);
        showSearchButton(true);
        setSearchActionButtonListener(new android.view.View.OnClickListener() {

            final FeedFragment this$0;

            public void onClick(View view)
            {
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "app", "search_listings_button_clicked", null);
                view = new Bundle();
                view.putInt("TAB_INDEX", 1);
                PMNotificationManager.fireNotification("com.poshmark.intents.SWITCH_TAB", view);
            }

            
            {
                this$0 = FeedFragment.this;
                super();
            }
        });
        setFindPeopleActionButtonListener(new android.view.View.OnClickListener() {

            final FeedFragment this$0;

            public void onClick(View view)
            {
                showFindPeopleFragment();
            }

            
            {
                this$0 = FeedFragment.this;
                super();
            }
        });
    }

    public void updateListing(ListingDetails listingdetails)
    {
        if (feedData != null)
        {
            feedData.updateListing(listingdetails);
            feedListView.updateList();
        }
    }



}

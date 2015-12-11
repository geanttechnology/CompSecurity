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
import android.widget.CursorAdapter;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplication;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.controllers.GlobalPartiesController;
import com.poshmark.controllers.UserStateSummaryController;
import com.poshmark.data_model.adapters.ListingSummaryAdapter;
import com.poshmark.data_model.models.ListingDetails;
import com.poshmark.data_model.models.PMData;
import com.poshmark.data_model.models.PartyEvent;
import com.poshmark.data_model.models.PartyEventListings;
import com.poshmark.data_model.models.SearchResults;
import com.poshmark.data_model.models.UserStateSummary;
import com.poshmark.data_model.models.inner_models.Comment;
import com.poshmark.data_model.models.inner_models.PartyRoomInfo;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.ListingNotificationHandler;
import com.poshmark.notifications.ListingNotificationManager;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.ui.customviews.ListingsFilterWidget;
import com.poshmark.ui.customviews.PMListView;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.ui.customviews.RoundedImageView;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.FilterResultsManager;
import com.poshmark.utils.NumberUtils;
import com.poshmark.utils.SearchFilterModel;
import com.poshmark.utils.ViewUtils;
import com.poshmark.utils.view_holders.PartyHeaderViewHolder;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFilterableFragment, PartyShowroomListFragment, PartyInviteFragment

public class PartyFragment extends PMFilterableFragment
    implements ListingNotificationHandler
{

    private CursorAdapter adapter;
    private boolean bIsActiveParty;
    private PartyEvent event;
    private PMData eventData;
    private String eventId;
    private PMListView eventListView;
    private View headerView;
    private PartyRoomInfo selectedShowroom;
    private PartyHeaderViewHolder viewHolder;

    public PartyFragment()
    {
        selectedShowroom = null;
        eventData = null;
        bIsActiveParty = false;
    }

    private void createPartyHeaderView()
    {
        headerView = LayoutInflater.from(getActivity()).inflate(0x7f030096, null);
        viewHolder = new PartyHeaderViewHolder();
        viewHolder.partyCovershotImageView = (RoundedImageView)headerView.findViewById(0x7f0c023e);
        viewHolder.showroomCovershotLayout = (LinearLayout)headerView.findViewById(0x7f0c023f);
        viewHolder.showroomCovershotIconView = (ImageView)headerView.findViewById(0x7f0c0240);
        viewHolder.showroomTitleTextView = (PMTextView)headerView.findViewById(0x7f0c0241);
        viewHolder.showroomDescriptionTextView = (PMTextView)headerView.findViewById(0x7f0c0242);
        viewHolder.filterWidgetLayout = (LinearLayout)headerView.findViewById(0x7f0c0069);
        filterWidget = (ListingsFilterWidget)headerView.findViewById(0x7f0c006a);
        filterWidget.setOwnerFragment(this);
        hideFilterButtonsForSingleFacet();
        viewHolder.hostLabel = (PMTextView)headerView.findViewById(0x7f0c0243);
        List list = event.getHosts();
        if (list.size() <= 1)
        {
            viewHolder.hostLabel.setText(0x7f060140);
        } else
        {
            viewHolder.hostLabel.setText(0x7f060142);
        }
        viewHolder.hostImagesLayout = (GridLayout)headerView.findViewById(0x7f0c0244);
        ViewUtils.populatePartyHostsInLayout(getActivity(), list, viewHolder.hostImagesLayout);
        viewHolder.timerIconView = (ImageView)headerView.findViewById(0x7f0c0245);
        viewHolder.listingCountIconView = (ImageView)headerView.findViewById(0x7f0c0246);
        viewHolder.partyInfoTextView = (PMTextView)headerView.findViewById(0x7f0c0247);
        if (event.isHappeningNow())
        {
            viewHolder.timerIconView.setVisibility(0);
            viewHolder.listingCountIconView.setVisibility(8);
            viewHolder.partyInfoTextView.setText(event.getFormattedPendingTime());
        } else
        if (event.isPastEvent())
        {
            viewHolder.timerIconView.setVisibility(8);
            viewHolder.listingCountIconView.setVisibility(0);
            int i = event.getListingCount();
            String s;
            if (i == 0)
            {
                s = getString(0x7f0601d2);
            } else
            if (i == 1)
            {
                s = (new StringBuilder()).append(Integer.toString(i)).append(" ").append(getString(0x7f060167)).toString();
            } else
            {
                s = (new StringBuilder()).append(Integer.toString(i)).append(" ").append(getString(0x7f06018f)).toString();
            }
            viewHolder.partyInfoTextView.setText(s);
        }
        viewHolder.showroomsIconView = (ImageView)headerView.findViewById(0x7f0c0248);
        viewHolder.showroomsLabel = (PMTextView)headerView.findViewById(0x7f0c0249);
        viewHolder.showroomsLabel.setOnClickListener(new android.view.View.OnClickListener() {

            final PartyFragment this$0;

            public void onClick(View view)
            {
                ((PMContainerActivity)getActivity()).launchDialogFragmentForResult(null, com/poshmark/ui/fragments/PartyShowroomListFragment, event, PartyFragment.this, 1);
            }

            
            {
                this$0 = PartyFragment.this;
                super();
            }
        });
        viewHolder.viewDetailsLabel = (PMTextView)headerView.findViewById(0x7f0c024a);
        viewHolder.viewDetailsLabel.setOnClickListener(new android.view.View.OnClickListener() {

            final PartyFragment this$0;

            public void onClick(View view)
            {
                view = new Bundle();
                view.putString("ID", eventId);
                ((PMActivity)getActivity()).launchFragment(view, com/poshmark/ui/fragments/PartyInviteFragment, event);
            }

            
            {
                this$0 = PartyFragment.this;
                super();
            }
        });
        if (event.hasShowrooms())
        {
            viewHolder.showroomsIconView.setVisibility(0);
            viewHolder.showroomsLabel.setVisibility(0);
            viewHolder.viewDetailsLabel.setVisibility(8);
        } else
        {
            viewHolder.showroomsIconView.setVisibility(8);
            viewHolder.showroomsLabel.setVisibility(8);
            viewHolder.viewDetailsLabel.setVisibility(0);
        }
        updateHeaderForSelectedShowroom();
    }

    private void getPartyListings(boolean flag)
    {
        if (selectedShowroom == null || selectedShowroom.isDefault())
        {
            if (bIsActiveParty)
            {
                if (isFilterApplied)
                {
                    loadFilterResults(flag);
                    return;
                } else
                {
                    getFilterManager().getSearchModel().clearAvailability();
                    getFilterManager().getSearchModel().enableMySizeFilter(false);
                    getFilterManager().getSearchModel().clearCount();
                    loadEventListings(flag);
                    viewHolder.filterWidgetLayout.setVisibility(0);
                    return;
                }
            }
            if (!isFilterApplied)
            {
                UserStateSummary userstatesummary = UserStateSummaryController.getGlobalInteractionsController().getUserStateSummary();
                if (userstatesummary != null && userstatesummary.user_info.isMySizeAvailable())
                {
                    getFilterManager().getSearchModel().enableMySizeFilter(true);
                }
                getFilterManager().getSearchModel().setAvailability("available");
            }
            loadFilterResults(flag);
            return;
        } else
        {
            viewHolder.filterWidgetLayout.setVisibility(8);
            loadEventListings(flag);
            return;
        }
    }

    private void handleFilterResultsResponse(PMApiResponse pmapiresponse, boolean flag)
    {
        hideProgressDialog();
        if (!pmapiresponse.hasError())
        {
            Object obj = getFilterManager().getSearchModel().getLabelForAnalytics();
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "listings_filtered", ((String) (obj)));
            obj = (SearchResults)pmapiresponse.data;
            if (!flag)
            {
                eventData = ((PMData) (obj));
                eventListView.setListData(eventData);
                eventListView.updateList();
                eventListView.setSelection(0);
                if (((SearchResults) (obj)).isEmpty())
                {
                    eventListView.showDefaultEmptyContentView();
                }
                saveFacetLists(((SearchResults)pmapiresponse.data).getFacets());
                return;
            } else
            {
                eventData.append(((PMData) (obj)));
                eventListView.updateList();
                return;
            }
        } else
        {
            showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.LOAD_LISTING));
            return;
        }
    }

    private void handlePastEventResponse(PMApiResponse pmapiresponse, boolean flag)
    {
        hideProgressDialog();
        if (pmapiresponse.hasError()) goto _L2; else goto _L1
_L1:
        if (flag) goto _L4; else goto _L3
_L3:
        eventData = (PMData)pmapiresponse.data;
        eventData.createHashAndRemoveDups();
        eventListView.setListData(eventData);
        eventListView.updateList();
        eventListView.setSelection(0);
        if (((PartyEventListings)pmapiresponse.data).isEmpty())
        {
            eventListView.showDefaultEmptyContentView();
        }
_L6:
        return;
_L4:
        eventData.append((PMData)pmapiresponse.data);
        eventListView.updateList();
        return;
_L2:
        if (!flag)
        {
            showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.LOAD_PARTY_LISTINGS, PMApplication.getContext().getString(0x7f0600ea)));
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void loadEventListings(boolean flag)
    {
        String s = null;
        if (selectedShowroom != null)
        {
            s = selectedShowroom.getId();
        }
        if (!flag)
        {
            eventListView.removeEmptyContentView();
            PMApi.getEventSummaryListings(eventId, s, null, new PMApiResponseHandler() {

                final PartyFragment this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    if (isAdded() && !pmapiresponse.hasError())
                    {
                        handlePastEventResponse(pmapiresponse, false);
                    }
                }

            
            {
                this$0 = PartyFragment.this;
                super();
            }
            });
            return;
        } else
        {
            PMApi.getEventSummaryListings(eventId, s, eventData.getNextPageMaxValue(), new PMApiResponseHandler() {

                final PartyFragment this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    if (isAdded() && !pmapiresponse.hasError())
                    {
                        handlePastEventResponse(pmapiresponse, true);
                    }
                }

            
            {
                this$0 = PartyFragment.this;
                super();
            }
            });
            return;
        }
    }

    private void loadFilterResults(boolean flag)
    {
        Object obj = getFilterManager().getSearchModel();
        ((SearchFilterModel) (obj)).getPrimaryFilters().addEvent(event.getId());
        getFilterManager().setFacet("brand");
        getFilterManager().setFacet("category_v2");
        getFilterManager().setFacet("size");
        getFilterManager().setFacet("color");
        getFilterManager().getSearchModel().clearCount();
        if (flag)
        {
            ((SearchFilterModel) (obj)).setNextPageId(eventData.getNextPageMaxValue());
        }
        Gson gson = (new GsonBuilder()).create();
        if (!(gson instanceof Gson))
        {
            obj = gson.toJson(obj);
        } else
        {
            obj = GsonInstrumentation.toJson((Gson)gson, obj);
        }
        if (flag)
        {
            PMApi.getSearchResults(((String) (obj)), eventData.getNextPageMaxValue(), null, null, new PMApiResponseHandler() {

                final PartyFragment this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    if (isAdded())
                    {
                        handleFilterResultsResponse(pmapiresponse, true);
                    }
                }

            
            {
                this$0 = PartyFragment.this;
                super();
            }
            });
            return;
        } else
        {
            eventListView.removeEmptyContentView();
            PMApi.getSearchResults(((String) (obj)), null, "pa", null, new PMApiResponseHandler() {

                final PartyFragment this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    if (isAdded())
                    {
                        handleFilterResultsResponse(pmapiresponse, false);
                        hideFilterButtonsForSingleFacet();
                        viewHolder.filterWidgetLayout.setVisibility(0);
                    }
                }

            
            {
                this$0 = PartyFragment.this;
                super();
            }
            });
            return;
        }
    }

    private void setFilterWidgetVisibility()
    {
        if (selectedShowroom == null || selectedShowroom.isDefault())
        {
            viewHolder.filterWidgetLayout.setVisibility(0);
        }
    }

    private void setShowroom(int i)
    {
        if (event.getCollections().size() > i)
        {
            PartyRoomInfo partyroominfo = (PartyRoomInfo)event.getCollections().get(i);
            if (selectedShowroom != partyroominfo)
            {
                selectedShowroom = partyroominfo;
                updateHeaderForSelectedShowroom();
                showProgressDialogWithMessage(getResources().getString(0x7f060190));
                getPartyListings(false);
            }
            if (selectedShowroom.isDefault())
            {
                showRefreshButton(true);
                return;
            }
        }
    }

    private void setupListView()
    {
        adapter = new ListingSummaryAdapter(getActivity(), this, null, 0x80000000);
        eventListView = (PMListView)getView().findViewById(0x7f0c0259);
        createPartyHeaderView();
        eventListView.setup(adapter, headerView, null, new com.poshmark.ui.customviews.PMListView.LoadMoreItemsListener() {

            final PartyFragment this$0;

            public void loadItems(boolean flag)
            {
                getPartyListings(flag);
            }

            
            {
                this$0 = PartyFragment.this;
                super();
            }
        });
        if (PMApplicationSession.GetPMSession().isLoggedIn())
        {
            if (eventData == null)
            {
                viewHolder.filterWidgetLayout.setVisibility(8);
                showProgressDialogWithMessage(getResources().getString(0x7f060190));
                getPartyListings(false);
            } else
            {
                setFilterWidgetVisibility();
            }
        }
        if (eventData != null)
        {
            eventListView.setListData(eventData);
        }
    }

    private void updateHeaderForSelectedShowroom()
    {
        if (event.hasShowrooms() && selectedShowroom != null)
        {
            if (selectedShowroom.isDefault())
            {
                viewHolder.partyCovershotImageView.setVisibility(0);
                viewHolder.showroomCovershotLayout.setVisibility(8);
                viewHolder.showroomTitleTextView.setVisibility(0);
                viewHolder.showroomDescriptionTextView.setVisibility(0);
                ImageLoader.getInstance().loadImage(event.getCovershot(), viewHolder.partyCovershotImageView.listener);
            } else
            {
                viewHolder.partyCovershotImageView.setVisibility(8);
                viewHolder.showroomCovershotLayout.setVisibility(0);
                viewHolder.showroomTitleTextView.setVisibility(0);
                viewHolder.showroomDescriptionTextView.setVisibility(0);
                viewHolder.showroomCovershotLayout.setBackgroundColor(getResources().getColor(selectedShowroom.getCovershotBGColor()));
                viewHolder.showroomCovershotIconView.setImageDrawable(getResources().getDrawable(selectedShowroom.getWhiteOutlineIconDrawable()));
            }
            if (event.isPastEvent() && selectedShowroom.getPostCount() >= 0)
            {
                viewHolder.partyInfoTextView.setText(NumberUtils.getIntegerAsGroupedString(selectedShowroom.getPostCount()));
            }
            viewHolder.showroomTitleTextView.setText((new StringBuilder()).append(selectedShowroom.getName()).append(" ").append(getString(0x7f06026d)).toString());
            viewHolder.showroomDescriptionTextView.setText(selectedShowroom.getDescription());
            return;
        } else
        {
            viewHolder.partyCovershotImageView.setVisibility(0);
            viewHolder.showroomCovershotLayout.setVisibility(8);
            viewHolder.showroomTitleTextView.setVisibility(8);
            viewHolder.showroomDescriptionTextView.setVisibility(8);
            ImageLoader.getInstance().loadImage(event.getCovershot(), viewHolder.partyCovershotImageView.listener);
            return;
        }
    }

    public void addCommentToListing(String s, Comment comment)
    {
    }

    public void deleteListing(String s)
    {
    }

    public void filterContent()
    {
        eventData = null;
        isFilterApplied = true;
    }

    public void fireSearch()
    {
        isFilterApplied = true;
        ((PMContainerActivity)getActivity()).toggleDrawer();
        showProgressDialogWithMessage(getString(0x7f060190));
        loadFilterResults(false);
    }

    public String getTrackingLabel()
    {
        return "pa";
    }

    public void handleNotification(final Intent intent)
    {
        if (!intent.getAction().equals("com.poshmark.intents.FILTER_SELECTION_ACTION")) goto _L2; else goto _L1
_L1:
        if (facetsAvailable()) goto _L4; else goto _L3
_L3:
        showProgressDialogWithMessage(null);
        getFilterManager().getSearchModel().setCount("1");
        getFilterManager().setFacet("brand");
        getFilterManager().setFacet("category_v2");
        getFilterManager().setFacet("size");
        getFilterManager().getSearchModel().getPrimaryFilters().addEvent(event.getId());
        String s = getFilterManager().getSearchRequestString();
        if (eventData != null)
        {
            PMApi.getSearchResults(s, eventData.getNextPageMaxValue(), null, null, new PMApiResponseHandler() {

                final PartyFragment this$0;
                final Intent val$intent;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    if (isAdded() && !pmapiresponse.hasError())
                    {
                        saveFacetLists(((SearchResults)pmapiresponse.data).getFacets());
                        handleNotification(intent);
                    }
                }

            
            {
                this$0 = PartyFragment.this;
                intent = intent1;
                super();
            }
            });
        }
_L6:
        return;
_L4:
        super.handleNotification(intent);
        return;
_L2:
        super.handleNotification(intent);
        if (intent.getAction().equals("com.poshmark.intents.EVENTS_FETCH_COMPLETE") && event == null)
        {
            event = GlobalPartiesController.getGlobalPartiesController().getParty(eventId);
            if (event != null)
            {
                bIsActiveParty = GlobalPartiesController.getGlobalPartiesController().isCurrentParty(event.getId());
                setupListView();
                setupActionBar();
                return;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void likeListing(String s, boolean flag)
    {
    }

    public void newListingCreated()
    {
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (event != null)
        {
            setupListView();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        ListingNotificationManager.getListingNotificationManager().registerListingMessageHandler(this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.EVENTS_FETCH_COMPLETE", this);
        bundle = ((Bundle) (getFragmentDataOfType(com/poshmark/data_model/models/PartyEvent)));
        if (bundle == null) goto _L2; else goto _L1
_L1:
        event = (PartyEvent)bundle;
        eventId = event.getId();
        bIsActiveParty = GlobalPartiesController.getGlobalPartiesController().isCurrentParty(event.getId());
        if (event.hasShowrooms())
        {
            selectedShowroom = event.getDefaultShowroom();
        }
_L4:
        ListingNotificationManager.getListingNotificationManager().registerListingMessageHandler(this);
        return;
_L2:
        eventId = getArguments().getString("ID");
        if (GlobalPartiesController.getGlobalPartiesController().isModelPopulated())
        {
            event = GlobalPartiesController.getGlobalPartiesController().getParty(eventId);
            if (event != null)
            {
                if (event.hasShowrooms())
                {
                    selectedShowroom = event.getDefaultShowroom();
                }
                bIsActiveParty = GlobalPartiesController.getGlobalPartiesController().isCurrentParty(event.getId());
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        return layoutinflater.inflate(0x7f030099, viewgroup, false);
    }

    public void onFragmentResult(Bundle bundle, int i)
    {
        super.onFragmentResult(bundle, i);
        if (i == 1)
        {
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "party", "party_change_showroom", null);
            setShowroom(bundle.getInt("SHOWROOM_INDEX"));
        }
    }

    public void onPause()
    {
        super.onPause();
        PMNotificationManager.getNotificationManager().unregisterAllEvents(this);
    }

    public void onResume()
    {
        super.onResume();
        if (eventListView != null)
        {
            eventListView.updateList();
        }
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "party_feed_screen";
    }

    public void setupActionBar()
    {
        if (getUserVisibleHint())
        {
            super.setupActionBar();
            if (event != null)
            {
                setTitle(event.getTitle());
                showRefreshButton(true);
                setRefreshActionButtonListener(new android.view.View.OnClickListener() {

                    final PartyFragment this$0;

                    public void onClick(View view)
                    {
                        Analytics.getInstance().trackEvent(viewNameForAnalytics, "party", "refresh_party_clicked", null);
                        getPartyListings(false);
                    }

            
            {
                this$0 = PartyFragment.this;
                super();
            }
                });
            }
        }
    }

    public void updateListing(ListingDetails listingdetails)
    {
    }






}

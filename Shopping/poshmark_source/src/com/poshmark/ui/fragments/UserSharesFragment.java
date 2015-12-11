// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplication;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.adapters.ListingSummaryAdapter;
import com.poshmark.data_model.models.ListingDetails;
import com.poshmark.data_model.models.ListingSummaryCollection;
import com.poshmark.data_model.models.PMData;
import com.poshmark.data_model.models.PMErrorType;
import com.poshmark.data_model.models.inner_models.Comment;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiError;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.ListingNotificationHandler;
import com.poshmark.notifications.ListingNotificationManager;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.customviews.PMListView;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.ui.customviews.RoundedImageView;
import com.poshmark.ui.customviews.UserFollowButtonLayout;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.user.UserInfoDetails;
import com.poshmark.utils.view_holders.SharesHeaderViewHolder;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, ClosetFragment, UserListFragment

public class UserSharesFragment extends PMFragment
    implements ListingNotificationHandler
{

    android.view.View.OnClickListener aboutButtonClickListener;
    private ListingSummaryAdapter adapter;
    android.view.View.OnClickListener closetOnClickListener;
    private View emptyListHeader;
    android.view.View.OnClickListener followerOnClickListener;
    android.view.View.OnClickListener followingOnClickListener;
    private View headerView;
    private ListingSummaryCollection listingSummaryCollectionData;
    private UserInfoDetails profileData;
    private SharesHeaderViewHolder sharesHeaderViewHolder;
    private PMListView sharesListView;
    private String userName;

    public UserSharesFragment()
    {
        adapter = null;
        listingSummaryCollectionData = null;
        profileData = null;
        emptyListHeader = null;
        aboutButtonClickListener = new android.view.View.OnClickListener() {

            final UserSharesFragment this$0;

            public void onClick(View view)
            {
                if (profileData != null)
                {
                    if (view instanceof RoundedImageView)
                    {
                        Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "profile_image_tapped", null);
                    }
                    view = new Bundle();
                    view.putString("NAME", userName);
                    ((PMActivity)getActivity()).launchFragment(view, com/poshmark/ui/fragments/ClosetFragment, null);
                }
            }

            
            {
                this$0 = UserSharesFragment.this;
                super();
            }
        };
        closetOnClickListener = new android.view.View.OnClickListener() {

            final UserSharesFragment this$0;

            public void onClick(View view)
            {
                if (profileData != null)
                {
                    view = new Bundle();
                    view.putString("NAME", profileData.getPMUserId());
                    ((PMActivity)getActivity()).launchFragment(view, com/poshmark/ui/fragments/ClosetFragment, null);
                }
            }

            
            {
                this$0 = UserSharesFragment.this;
                super();
            }
        };
        followerOnClickListener = new android.view.View.OnClickListener() {

            final UserSharesFragment this$0;

            public void onClick(View view)
            {
                if (profileData != null)
                {
                    view = new Bundle();
                    view.putString("MODE", UserListFragment.USER_LIST_MODE.PM_FOLLOWERS_MODE.name());
                    view.putString("ID", profileData.getPMUserId());
                    ((PMActivity)getActivity()).launchFragment(view, com/poshmark/ui/fragments/UserListFragment, null);
                }
            }

            
            {
                this$0 = UserSharesFragment.this;
                super();
            }
        };
        followingOnClickListener = new android.view.View.OnClickListener() {

            final UserSharesFragment this$0;

            public void onClick(View view)
            {
                if (profileData != null)
                {
                    view = new Bundle();
                    view.putString("MODE", UserListFragment.USER_LIST_MODE.PM_FOLLOWING_MODE.name());
                    view.putString("ID", profileData.getPMUserId());
                    ((PMActivity)getActivity()).launchFragment(view, com/poshmark/ui/fragments/UserListFragment, null);
                }
            }

            
            {
                this$0 = UserSharesFragment.this;
                super();
            }
        };
    }

    private void getUserShares(boolean flag)
    {
        if (flag)
        {
            PMApi.getUserSharesList(profileData.getPMUserId(), listingSummaryCollectionData.getNextPageMaxValue(), new PMApiResponseHandler() {

                final UserSharesFragment this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    if (isAdded())
                    {
                        UserSharesFragment.this.handleResponse(pmapiresponse, true);
                    }
                }

            
            {
                this$0 = UserSharesFragment.this;
                super();
            }
            });
            return;
        } else
        {
            showProgressDialogWithMessage(getString(0x7f060190));
            PMApi.getUserSharesList(profileData.getPMUserId(), null, new PMApiResponseHandler() {

                final UserSharesFragment this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    if (isAdded())
                    {
                        UserSharesFragment.this.handleResponse(pmapiresponse, false);
                    }
                }

            
            {
                this$0 = UserSharesFragment.this;
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
        listingSummaryCollectionData = (ListingSummaryCollection)pmapiresponse.data;
        listingSummaryCollectionData.createHashAndRemoveDups();
        sharesListView.removeEmptyContentView();
        sharesListView.setListData(listingSummaryCollectionData);
        sharesListView.updateList();
        sharesListView.setSelection(0);
        if (listingSummaryCollectionData.isEmpty())
        {
            showCustomEmptyListingsMessage();
        }
_L6:
        return;
_L4:
        listingSummaryCollectionData.append((PMData)pmapiresponse.data);
        sharesListView.updateList();
        return;
_L2:
        if (!flag)
        {
            showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.LOAD_CLOSET, PMApplication.getContext().getString(0x7f0600eb)));
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void setupClosetList()
    {
        sharesListView = (PMListView)getView().findViewById(0x7f0c00c0);
        sharesListView.setup(adapter, headerView, null, new com.poshmark.ui.customviews.PMListView.LoadMoreItemsListener() {

            final UserSharesFragment this$0;

            public void loadItems(boolean flag)
            {
                getUserShares(flag);
            }

            
            {
                this$0 = UserSharesFragment.this;
                super();
            }
        });
        if (profileData == null)
        {
            showProgressDialogWithMessage(getString(0x7f060190));
            PMApi.getUserProfile(userName, new PMApiResponseHandler() {

                final UserSharesFragment this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
label0:
                    {
                        if (isAdded())
                        {
                            if (pmapiresponse.hasError())
                            {
                                break label0;
                            }
                            profileData = (UserInfoDetails)pmapiresponse.data;
                            getUserShares(false);
                            updateProfileCard();
                            setupActionBar();
                        }
                        return;
                    }
                    hideProgressDialog();
                    int i;
                    if (pmapiresponse.apiError.pmErrorType == PMErrorType.HTTP_NOT_FOUND || pmapiresponse.apiError.pmErrorType == PMErrorType.HTTP_GONE)
                    {
                        i = 0x7f0600dd;
                    } else
                    {
                        i = 0x7f0600eb;
                    }
                    showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.LOAD_USER_PROFILE, getString(i)));
                }

            
            {
                this$0 = UserSharesFragment.this;
                super();
            }
            });
            return;
        } else
        {
            sharesListView.setListData(listingSummaryCollectionData);
            updateProfileCard();
            return;
        }
    }

    private void setupHeaderView(View view)
    {
        headerView = LayoutInflater.from(getActivity()).inflate(0x7f0300cd, null);
        sharesHeaderViewHolder = new SharesHeaderViewHolder();
        sharesHeaderViewHolder.bgCovershotImageView = (ImageView)headerView.findViewById(0x7f0c0062);
        sharesHeaderViewHolder.avataarImageView = (RoundedImageView)headerView.findViewById(0x7f0c00c1);
        sharesHeaderViewHolder.titleView = (TextView)headerView.findViewById(0x7f0c0261);
        sharesHeaderViewHolder.followFollowingButtonLayout = (UserFollowButtonLayout)headerView.findViewById(0x7f0c0066);
        sharesHeaderViewHolder.followButtonWrapper = (LinearLayout)headerView.findViewById(0x7f0c0218);
    }

    private void updateProfileCard()
    {
label0:
        {
            if (getUserVisibleHint() && profileData != null)
            {
                getView();
                RoundedImageView roundedimageview = sharesHeaderViewHolder.avataarImageView;
                if (roundedimageview != null)
                {
                    ImageLoader imageloader = ImageLoader.getInstance();
                    String s = profileData.getUserSmallPicUrl();
                    if (s != null)
                    {
                        imageloader.displayImage(s, roundedimageview);
                        roundedimageview.setOnClickListener(aboutButtonClickListener);
                    }
                }
                setTitle((new StringBuilder()).append("@").append(profileData.getDisplayHandle()).toString());
                sharesHeaderViewHolder.titleView.setText((new StringBuilder()).append("@").append(profileData.getDisplayHandle()).toString());
                ImageLoader imageloader1 = ImageLoader.getInstance();
                if (profileData.getUserSmallPicUrl() != null)
                {
                    imageloader1.displayImage(profileData.getUserSmallPicUrl(), roundedimageview);
                    imageloader1.displayImage(profileData.getUserSmallPicUrl(), sharesHeaderViewHolder.bgCovershotImageView);
                }
                if (!profileData.getPMUserId().equals(PMApplicationSession.GetPMSession().getUserId()))
                {
                    break label0;
                }
                sharesHeaderViewHolder.followButtonWrapper.setVisibility(8);
            }
            return;
        }
        sharesHeaderViewHolder.followButtonWrapper.setVisibility(0);
        sharesHeaderViewHolder.followFollowingButtonLayout.setUser(profileData.getPMUserId(), profileData.isCallerFollowing());
        sharesHeaderViewHolder.followFollowingButtonLayout.setListener(new com.poshmark.ui.customviews.UserFollowButtonLayout.UserFollowButtonListener() {

            final UserSharesFragment this$0;

            public void onFollowClick()
            {
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "follow_tapped", null);
            }

            public void onFollowingClick()
            {
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "unfollow_tapped", null);
            }

            
            {
                this$0 = UserSharesFragment.this;
                super();
            }
        });
    }

    public void addCommentToListing(String s, Comment comment)
    {
    }

    public void deleteListing(String s)
    {
        if (s.equals(PMApplicationSession.GetPMSession().getUserId()))
        {
            bUpdateOnShow = true;
        }
    }

    public String getTrackingLabel()
    {
        return "ush";
    }

    public void handleNotification(Intent intent)
    {
        if (intent.getAction().equals("com.poshmark.intents.USER_FOLLOW_STATUS_CHANGED"))
        {
            intent = intent.getBundleExtra("RESULT");
            String s = intent.getString("USER");
            boolean flag = intent.getBoolean("IS_FOLLOWING");
            if (profileData != null && s.equalsIgnoreCase(profileData.getPMUserId()))
            {
                profileData.setCallerIsFollowing(flag);
                sharesHeaderViewHolder.followFollowingButtonLayout.setUser(s, flag);
            }
        }
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
        setupClosetList();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        adapter = new ListingSummaryAdapter(getActivity(), this, null, 0x80000000);
        userName = getArguments().getString("NAME").trim().replaceAll("\n", "");
        profileData = (UserInfoDetails)getFragmentDataOfType(com/poshmark/user/UserInfoDetails);
        if (profileData != null)
        {
            bUpdateOnShow = true;
        }
        ListingNotificationManager.getListingNotificationManager().registerListingMessageHandler(this);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f030026, viewgroup, false);
        setupHeaderView(layoutinflater);
        return layoutinflater;
    }

    public void onPMResume()
    {
        super.onPMResume();
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.USER_FOLLOW_STATUS_CHANGED", this);
        if (getUserVisibleHint())
        {
            if (bUpdateOnShow)
            {
                bUpdateOnShow = false;
                getUserShares(false);
            } else
            {
                sharesListView.updateList();
                if (listingSummaryCollectionData != null && listingSummaryCollectionData.isEmpty())
                {
                    showCustomEmptyListingsMessage();
                    return;
                }
            }
        }
    }

    public void onPause()
    {
        super.onPause();
        PMNotificationManager.getNotificationManager().unregisterAllEvents(this);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        PMNotificationManager.getNotificationManager().unregisterAllEvents(this);
    }

    public void onStop()
    {
        super.onStop();
        adapter.clearImageList();
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "shared_listings_page";
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        if (profileData == null)
        {
            setTitle("");
            return;
        }
        String s = profileData.getDisplayStatus();
        if (s != null)
        {
            setSubTitle(s);
        }
        if (PMApplicationSession.GetPMSession().getUserId().equalsIgnoreCase(profileData.getPMUserId()))
        {
            setTitle("My Shares");
            return;
        } else
        {
            setTitle("Shares");
            return;
        }
    }

    public void showCustomEmptyListingsMessage()
    {
        LayoutInflater layoutinflater = LayoutInflater.from(getActivity());
        if (emptyListHeader == null)
        {
            emptyListHeader = layoutinflater.inflate(0x7f030029, null);
        }
        if (profileData.getListingCount() > 0)
        {
            PMTextView pmtextview = (PMTextView)emptyListHeader.findViewById(0x7f0c00cc);
            pmtextview.setVisibility(0);
            pmtextview.setText(String.format(getString(0x7f060266), new Object[] {
                profileData.getUserName()
            }));
            pmtextview.setOnClickListener(closetOnClickListener);
        } else
        {
            emptyListHeader.findViewById(0x7f0c00cc).setVisibility(8);
        }
        sharesListView.showEmptyContentView(emptyListHeader);
    }

    public void updateListing(ListingDetails listingdetails)
    {
        if (listingdetails.getUserId().equals(PMApplicationSession.GetPMSession().getUserId()))
        {
            bUpdateOnShow = true;
        }
    }



/*
    static UserInfoDetails access$002(UserSharesFragment usersharesfragment, UserInfoDetails userinfodetails)
    {
        usersharesfragment.profileData = userinfodetails;
        return userinfodetails;
    }

*/




}

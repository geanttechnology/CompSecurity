// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplication;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.config.NewRelicWrapper;
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
import com.poshmark.ui.customviews.ListingsFilterWidget;
import com.poshmark.ui.customviews.PMListView;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.ui.customviews.RoundedImageView;
import com.poshmark.ui.customviews.UserFollowButtonLayout;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.user.UserInfoDetails;
import com.poshmark.utils.FilterResultsManager;
import com.poshmark.utils.ImageUtils;
import com.poshmark.utils.NewRelicCustomInteractions;
import com.poshmark.utils.SearchFilterModel;
import com.poshmark.utils.StringUtils;
import com.poshmark.utils.view_holders.ClosetHeaderViewHolder;
import java.util.UUID;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFilterableFragment, ViewBundleFragment, ClosetDrawerFragment, ShareFragment, 
//            UserListFragment, UserSharesFragment, AboutMePageFragment, EditProfileFormFragment

public class ClosetFragment extends PMFilterableFragment
    implements ListingNotificationHandler
{

    android.view.View.OnClickListener aboutButtonClickListener;
    private ListingSummaryAdapter adapter;
    private boolean bUseFilter;
    private ClosetHeaderViewHolder closetHeaderViewHolder;
    private PMListView closetListView;
    android.widget.AdapterView.OnItemClickListener drawerItemlistener;
    private View emptyListHeader;
    android.view.View.OnClickListener followerOnClickListener;
    android.view.View.OnClickListener followingOnClickListener;
    private View headerView;
    private ListingSummaryCollection listingSummaryCollectionData;
    private UserInfoDetails profileData;
    android.view.View.OnClickListener sharesOnClickListener;
    private String userName;

    public ClosetFragment()
    {
        adapter = null;
        profileData = null;
        bUseFilter = false;
        emptyListHeader = null;
        followerOnClickListener = new android.view.View.OnClickListener() {

            final ClosetFragment this$0;

            public void onClick(View view)
            {
                if (profileData != null)
                {
                    view = new Bundle();
                    view.putString("MODE", UserListFragment.USER_LIST_MODE.PM_FOLLOWERS_MODE.name());
                    view.putString("ID", profileData.getPMUserId());
                    view.putInt("DISPLAY_COUNT", profileData.getFollowersCount());
                    PMActivity pmactivity = (PMActivity)getActivity();
                    if (pmactivity != null && pmactivity.isActivityInForeground())
                    {
                        pmactivity.launchFragment(view, com/poshmark/ui/fragments/UserListFragment, null);
                    }
                }
            }

            
            {
                this$0 = ClosetFragment.this;
                super();
            }
        };
        followingOnClickListener = new android.view.View.OnClickListener() {

            final ClosetFragment this$0;

            public void onClick(View view)
            {
                if (profileData != null)
                {
                    view = new Bundle();
                    view.putString("MODE", UserListFragment.USER_LIST_MODE.PM_FOLLOWING_MODE.name());
                    view.putString("ID", profileData.getPMUserId());
                    view.putInt("DISPLAY_COUNT", profileData.getFollowingCount());
                    PMActivity pmactivity = (PMActivity)getActivity();
                    if (pmactivity != null && pmactivity.isActivityInForeground())
                    {
                        pmactivity.launchFragment(view, com/poshmark/ui/fragments/UserListFragment, null);
                    }
                }
            }

            
            {
                this$0 = ClosetFragment.this;
                super();
            }
        };
        sharesOnClickListener = new android.view.View.OnClickListener() {

            final ClosetFragment this$0;

            public void onClick(View view)
            {
                if (profileData != null)
                {
                    view = new Bundle();
                    view.putString("NAME", profileData.getPMUserId());
                    PMActivity pmactivity = (PMActivity)getActivity();
                    if (pmactivity != null && pmactivity.isActivityInForeground())
                    {
                        pmactivity.launchFragment(view, com/poshmark/ui/fragments/UserSharesFragment, profileData);
                    }
                }
            }

            
            {
                this$0 = ClosetFragment.this;
                super();
            }
        };
        aboutButtonClickListener = new android.view.View.OnClickListener() {

            final ClosetFragment this$0;

            public void onClick(View view)
            {
                if (profileData != null)
                {
                    if (view instanceof RoundedImageView)
                    {
                        Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "profile_image_tapped", null);
                    }
                    view = new Bundle();
                    view.putString("URL", (new StringBuilder()).append("https://www.poshmark.com/mapp/users/").append(profileData.getPMUserId()).append("/about_me").toString());
                    view.putString("ANALYTICS_PAGE_NAME", "AboutPage");
                    ((PMActivity)getActivity()).launchFragmentInNewActivity(view, com/poshmark/ui/fragments/AboutMePageFragment, null);
                }
            }

            
            {
                this$0 = ClosetFragment.this;
                super();
            }
        };
        drawerItemlistener = new android.widget.AdapterView.OnItemClickListener() {

            final ClosetFragment this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
            }

            
            {
                this$0 = ClosetFragment.this;
                super();
            }
        };
    }

    private void getUserCloset(boolean flag)
    {
        if (flag)
        {
            if (bUseFilter)
            {
                getFilterManager().getSearchModel().setNextPageId(listingSummaryCollectionData.getNextPageMaxValue());
                String s = getFilterManager().getSearchRequestString();
                PMApi.getUserClosetFiltered(profileData.getPMUserId(), listingSummaryCollectionData.getNextPageMaxValue(), s, new PMApiResponseHandler() {

                    final ClosetFragment this$0;

                    public void handleResponse(PMApiResponse pmapiresponse)
                    {
                        if (isAdded())
                        {
                            ClosetFragment.this.handleResponse(pmapiresponse, true);
                        }
                    }

            
            {
                this$0 = ClosetFragment.this;
                super();
            }
                });
                return;
            } else
            {
                PMApi.getUserCloset(profileData.getPMUserId(), listingSummaryCollectionData.getNextPageMaxValue(), new PMApiResponseHandler() {

                    final ClosetFragment this$0;

                    public void handleResponse(PMApiResponse pmapiresponse)
                    {
                        if (isAdded())
                        {
                            ClosetFragment.this.handleResponse(pmapiresponse, true);
                        }
                    }

            
            {
                this$0 = ClosetFragment.this;
                super();
            }
                });
                return;
            }
        }
        showProgressDialogWithMessage(getString(0x7f060190));
        if (bUseFilter)
        {
            String s1 = getFilterManager().getSearchRequestString();
            PMApi.getUserClosetFiltered(profileData.getPMUserId(), null, s1, new PMApiResponseHandler() {

                final ClosetFragment this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    if (isAdded())
                    {
                        ClosetFragment.this.handleResponse(pmapiresponse, false);
                    }
                }

            
            {
                this$0 = ClosetFragment.this;
                super();
            }
            });
            return;
        } else
        {
            PMApi.getUserCloset(profileData.getPMUserId(), null, new PMApiResponseHandler() {

                final ClosetFragment this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    if (isAdded())
                    {
                        ClosetFragment.this.handleResponse(pmapiresponse, false);
                    }
                }

            
            {
                this$0 = ClosetFragment.this;
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
        closetListView.removeEmptyContentView();
        closetListView.setListData(listingSummaryCollectionData);
        closetListView.updateList();
        if (listingSummaryCollectionData.isEmpty())
        {
            showCustomEmptyListingsMessage();
        }
_L6:
        return;
_L4:
        listingSummaryCollectionData.append((PMData)pmapiresponse.data);
        closetListView.updateList();
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
        closetListView = (PMListView)getView().findViewById(0x7f0c00c0);
        closetListView.setup(adapter, headerView, null, new com.poshmark.ui.customviews.PMListView.LoadMoreItemsListener() {

            final ClosetFragment this$0;

            public void loadItems(boolean flag)
            {
                getUserCloset(flag);
            }

            
            {
                this$0 = ClosetFragment.this;
                super();
            }
        });
        if (profileData == null)
        {
            showProgressDialogWithMessage(getString(0x7f060190));
            PMApi.getUserProfile(userName, new PMApiResponseHandler() {

                final ClosetFragment this$0;

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
                            getUserCloset(false);
                            updateProfileCard();
                            setupActionBar();
                            closetHeaderViewHolder.filterWidgetLayout.setVisibility(0);
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
                this$0 = ClosetFragment.this;
                super();
            }
            });
            return;
        }
        closetListView.setListData(listingSummaryCollectionData);
        if (listingSummaryCollectionData == null || listingSummaryCollectionData.isEmpty())
        {
            showCustomEmptyListingsMessage();
        }
        updateProfileCard();
        closetHeaderViewHolder.filterWidgetLayout.setVisibility(0);
    }

    private void setupDrawerButton()
    {
    }

    private void setupHeaderView(View view)
    {
        headerView = LayoutInflater.from(getActivity()).inflate(0x7f03008f, null);
        closetHeaderViewHolder = new ClosetHeaderViewHolder();
        closetHeaderViewHolder.bgCovershotImageView = (ImageView)headerView.findViewById(0x7f0c0062);
        closetHeaderViewHolder.avataarImageView = (RoundedImageView)headerView.findViewById(0x7f0c00c1);
        closetHeaderViewHolder.closetTitleView = (TextView)headerView.findViewById(0x7f0c00c8);
        closetHeaderViewHolder.listingsCountView = (TextView)headerView.findViewById(0x7f0c00c2);
        closetHeaderViewHolder.listingsLableView = (TextView)headerView.findViewById(0x7f0c00c3);
        closetHeaderViewHolder.followerCountView = (TextView)headerView.findViewById(0x7f0c00c4);
        closetHeaderViewHolder.followerLabelView = (TextView)headerView.findViewById(0x7f0c00c5);
        closetHeaderViewHolder.followingCountView = (TextView)headerView.findViewById(0x7f0c00c6);
        closetHeaderViewHolder.sharesLabelView = (TextView)headerView.findViewById(0x7f0c021d);
        closetHeaderViewHolder.sharesCountView = (TextView)headerView.findViewById(0x7f0c021c);
        closetHeaderViewHolder.followingLabelView = (TextView)headerView.findViewById(0x7f0c00c7);
        closetHeaderViewHolder.userFollowButtonLayout = (UserFollowButtonLayout)headerView.findViewById(0x7f0c0066);
        closetHeaderViewHolder.editProfileButton = (Button)headerView.findViewById(0x7f0c0219);
        closetHeaderViewHolder.aboutButton = (Button)headerView.findViewById(0x7f0c0217);
        closetHeaderViewHolder.followerLabelView.setOnClickListener(followerOnClickListener);
        closetHeaderViewHolder.followerCountView.setOnClickListener(followerOnClickListener);
        closetHeaderViewHolder.followingLabelView.setOnClickListener(followingOnClickListener);
        closetHeaderViewHolder.followingCountView.setOnClickListener(followingOnClickListener);
        closetHeaderViewHolder.sharesCountView.setOnClickListener(sharesOnClickListener);
        closetHeaderViewHolder.sharesLabelView.setOnClickListener(sharesOnClickListener);
        closetHeaderViewHolder.filterWidgetLayout = (LinearLayout)headerView.findViewById(0x7f0c0069);
        filterWidget = (ListingsFilterWidget)headerView.findViewById(0x7f0c006a);
        filterWidget.setOwnerFragment(this);
    }

    private void updateProfileCard()
    {
        if (getUserVisibleHint() && profileData != null)
        {
            View view = getView();
            Object obj = closetHeaderViewHolder.avataarImageView;
            if (obj != null)
            {
                ImageLoader imageloader = ImageLoader.getInstance();
                String s = profileData.getUserSmallPicUrl();
                if (s != null)
                {
                    imageloader.displayImage(s, closetHeaderViewHolder.bgCovershotImageView);
                }
            }
            setTitle((new StringBuilder()).append("@").append(profileData.getDisplayHandle()).toString());
            closetHeaderViewHolder.closetTitleView.setText(profileData.getClosetTitle());
            int i = profileData.getListingCount();
            Object obj1;
            if (i > 1)
            {
                closetHeaderViewHolder.listingsLableView.setText(getString(0x7f06018f));
            } else
            {
                closetHeaderViewHolder.listingsLableView.setText(getString(0x7f060167));
            }
            closetHeaderViewHolder.listingsCountView.setText(Integer.toString(i));
            if (profileData.getFollowersCount() > 1)
            {
                closetHeaderViewHolder.followerLabelView.setText(getString(0x7f060133));
            } else
            {
                closetHeaderViewHolder.followerLabelView.setText(getString(0x7f060132));
            }
            obj1 = StringUtils.abbreviatedStringRepresentationOfNumber(profileData.getFollowersCount());
            closetHeaderViewHolder.followerCountView.setText(((CharSequence) (obj1)));
            obj1 = StringUtils.abbreviatedStringRepresentationOfNumber(profileData.getFollowingCount());
            closetHeaderViewHolder.followingCountView.setText(((CharSequence) (obj1)));
            obj1 = StringUtils.abbreviatedStringRepresentationOfNumber(profileData.getShareCount());
            closetHeaderViewHolder.sharesCountView.setText(((CharSequence) (obj1)));
            obj1 = ImageLoader.getInstance();
            if (profileData.getUserSmallPicUrl() != null)
            {
                ((ImageLoader) (obj1)).loadImage(profileData.getUserSmallPicUrl(), ((RoundedImageView) (obj)).listener);
            } else
            {
                ((RoundedImageView) (obj)).setBitmap(0x7f0200d4);
            }
            ((RoundedImageView) (obj)).setOnClickListener(aboutButtonClickListener);
            closetHeaderViewHolder.aboutButton.setVisibility(0);
            closetHeaderViewHolder.aboutButton.setOnClickListener(aboutButtonClickListener);
            obj = (LinearLayout)view.findViewById(0x7f0c0218);
            if (profileData.getPMUserId().equals(PMApplicationSession.GetPMSession().getUserId()))
            {
                ((LinearLayout) (obj)).setVisibility(8);
                closetHeaderViewHolder.editProfileButton.setVisibility(0);
                closetHeaderViewHolder.editProfileButton.setOnClickListener(new android.view.View.OnClickListener() {

                    final ClosetFragment this$0;

                    public void onClick(View view1)
                    {
                        view1 = new Bundle();
                        view1.putInt("MODE", EditProfileFormFragment.PROFILE_MODE.PROFILE_MODE_EDIT.ordinal());
                        ((PMActivity)getActivity()).launchFragment(view1, com/poshmark/ui/fragments/EditProfileFormFragment, null);
                    }

            
            {
                this$0 = ClosetFragment.this;
                super();
            }
                });
            } else
            {
                ((LinearLayout) (obj)).setVisibility(0);
                closetHeaderViewHolder.userFollowButtonLayout.setUser(profileData.getPMUserId(), profileData.isCallerFollowing());
                closetHeaderViewHolder.userFollowButtonLayout.setListener(new com.poshmark.ui.customviews.UserFollowButtonLayout.UserFollowButtonListener() {

                    final ClosetFragment this$0;

                    public void onFollowClick()
                    {
                        Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "follow_tapped", null);
                        profileData.setCallerIsFollowing(true);
                        profileData.setFollowersCount(profileData.getFollowersCount() + 1);
                        String s1 = StringUtils.abbreviatedStringRepresentationOfNumber(profileData.getFollowersCount());
                        closetHeaderViewHolder.followerCountView.setText(s1);
                    }

                    public void onFollowingClick()
                    {
                        Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "unfollow_tapped", null);
                        profileData.setCallerIsFollowing(false);
                        profileData.setFollowersCount(profileData.getFollowersCount() - 1);
                        String s1 = StringUtils.abbreviatedStringRepresentationOfNumber(profileData.getFollowersCount());
                        closetHeaderViewHolder.followerCountView.setText(s1);
                    }

            
            {
                this$0 = ClosetFragment.this;
                super();
            }
                });
                view.invalidate();
            }
            getFilterManager().getSearchModel().getPrimaryFilters().addUser(profileData.getPMUserId());
            getFilterManager().setFacet("brand");
            getFilterManager().setFacet("category_v2");
            getFilterManager().setFacet("category_feature");
            getFilterManager().setFacet("size");
            getFilterManager().setFacet("color");
        }
    }

    public void addCommentToListing(String s, Comment comment)
    {
    }

    public void blockUser()
    {
        showProgressDialogWithMessage(getString(0x7f06021e));
        PMApi.blockUser(profileData.getPMUserId(), new PMApiResponseHandler() {

            final ClosetFragment this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
label0:
                {
                    if (isAdded())
                    {
                        hideProgressDialog();
                        if (pmapiresponse.hasError())
                        {
                            break label0;
                        }
                        profileData.setBlockedFlag(true);
                        showAutoHideSuccessMessage(getString(0x7f0602b6));
                        pmapiresponse = new Bundle();
                        pmapiresponse.putParcelable("PARENT_ID", new ParcelUuid(fragmentId));
                        pmapiresponse.putBoolean("BLOCK_USER_STATUS", true);
                        PMNotificationManager.fireNotification("com.poshmark.intents.SET_BLOCK_USER_STATUS_ACTION", pmapiresponse);
                    }
                    return;
                }
                showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.BLOCK_USER, getString(0x7f0600d4)));
            }

            
            {
                this$0 = ClosetFragment.this;
                super();
            }
        });
    }

    public void deleteListing(String s)
    {
        if (listingSummaryCollectionData != null && listingSummaryCollectionData.hasListing(s))
        {
            bUpdateOnShow = true;
        }
    }

    public void filterContent()
    {
        bUpdateOnShow = true;
        bUseFilter = true;
    }

    public String getTrackingLabel()
    {
        return "cl";
    }

    public void handleNotification(final Intent intent)
    {
        if (!intent.getAction().equals("com.poshmark.intents.FILTER_SELECTION_ACTION")) goto _L2; else goto _L1
_L1:
        if (facetsAvailable()) goto _L4; else goto _L3
_L3:
        showProgressDialogWithMessage(null);
        getFilterManager().getSearchModel().setCount("1");
        String s = getFilterManager().getSearchRequestString();
        PMApi.getUserClosetFacets(profileData.getPMUserId(), s, new PMApiResponseHandler() {

            final ClosetFragment this$0;
            final Intent val$intent;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                hideProgressDialog();
                getFilterManager().getSearchModel().clearCount();
                if (isAdded() && !pmapiresponse.hasError())
                {
                    saveFacetLists(((ListingSummaryCollection)pmapiresponse.data).getFacets());
                    handleNotification(intent);
                }
            }

            
            {
                this$0 = ClosetFragment.this;
                intent = intent1;
                super();
            }
        });
_L6:
        return;
_L4:
        super.handleNotification(intent);
        return;
_L2:
        if (!intent.getAction().equals("com.poshmark.intents.BLOCK_USER_ACTION"))
        {
            break; /* Loop/switch isn't completed */
        }
        intent = (ParcelUuid)intent.getBundleExtra("RESULT").getParcelable("PARENT_ID");
        if (fragmentId.equals(intent.getUuid()))
        {
            blockUser();
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
        if (!intent.getAction().equals("com.poshmark.intents.UNBLOCK_USER_ACTION"))
        {
            break; /* Loop/switch isn't completed */
        }
        intent = (ParcelUuid)intent.getBundleExtra("RESULT").getParcelable("PARENT_ID");
        if (fragmentId.equals(intent.getUuid()))
        {
            unblockUser();
            return;
        }
        if (true) goto _L6; else goto _L7
_L7:
        if (!intent.getAction().equals("com.poshmark.intents.REPORT_USER_ACTION"))
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj = intent.getBundleExtra("RESULT");
        intent = (ParcelUuid)((Bundle) (obj)).getParcelable("PARENT_ID");
        obj = ((Bundle) (obj)).getString("REPORT_REASON");
        if (fragmentId.equals(intent.getUuid()))
        {
            reportUser(((String) (obj)));
            return;
        }
        if (true) goto _L6; else goto _L8
_L8:
        if (!intent.getAction().equals("com.poshmark.intents.SHARE_CLOSET_ACTION"))
        {
            break; /* Loop/switch isn't completed */
        }
        intent = (ParcelUuid)intent.getBundleExtra("RESULT").getParcelable("PARENT_ID");
        if (fragmentId.equals(intent.getUuid()))
        {
            shareCloset();
            return;
        }
        if (true) goto _L6; else goto _L9
_L9:
        if (!intent.getAction().equals("com.poshmark.intents.USER_FOLLOW_STATUS_CHANGED"))
        {
            continue; /* Loop/switch isn't completed */
        }
        intent = intent.getBundleExtra("RESULT");
        String s1 = intent.getString("USER");
        boolean flag = intent.getBoolean("IS_FOLLOWING");
        if (profileData != null && s1.equalsIgnoreCase(profileData.getPMUserId()))
        {
            profileData.setCallerIsFollowing(flag);
            closetHeaderViewHolder.userFollowButtonLayout.setUser(s1, flag);
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (!intent.getAction().equals("com.poshmark.intents.VIEW_BUNDLE_ACTION")) goto _L6; else goto _L10
_L10:
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "bundle", "view_bundle_tapped", null);
        intent = (ParcelUuid)intent.getBundleExtra("RESULT").getParcelable("PARENT_ID");
        if (fragmentId.equals(intent.getUuid()))
        {
            intent = getParentActivity();
            Bundle bundle = new Bundle();
            bundle.putString("ID", profileData.getPMUserId());
            intent.launchFragment(bundle, com/poshmark/ui/fragments/ViewBundleFragment, null);
            return;
        }
        if (true) goto _L6; else goto _L11
_L11:
    }

    public boolean isLoggedInUserCloset()
    {
        String s = PMApplicationSession.GetPMSession().getUserName();
        String s1 = PMApplicationSession.GetPMSession().getUserId();
        return s.equals(userName) || s1.equals(userName);
    }

    public boolean isUserBlocked()
    {
        if (profileData != null)
        {
            return profileData.isUserBlocked();
        } else
        {
            return false;
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
        bundle = getArguments().getString("NAME");
        if (bundle == null) goto _L2; else goto _L1
_L1:
        userName = bundle.trim().replaceAll("\n", "");
_L4:
        fragmentType = PMFragment.FRAGMENT_TYPE.HAS_DRAWER;
        getFilterManager().getSearchModel().enableMySizeFilter(false);
        ListingNotificationManager.getListingNotificationManager().registerListingMessageHandler(this);
        NewRelicWrapper.startCustomInteraction(NewRelicCustomInteractions.CLOSET);
        return;
_L2:
        bundle = getArguments().getString("ID");
        if (bundle != null)
        {
            userName = bundle.trim().replaceAll("\n", "");
        }
        if (true) goto _L4; else goto _L3
_L3:
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
        if (!getUserVisibleHint()) goto _L2; else goto _L1
_L1:
        if (!bUpdateOnShow) goto _L4; else goto _L3
_L3:
        bUpdateOnShow = false;
        getUserCloset(false);
_L2:
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.BLOCK_USER_ACTION", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.UNBLOCK_USER_ACTION", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.REPORT_USER_ACTION", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.SHARE_CLOSET_ACTION", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.USER_FOLLOW_STATUS_CHANGED", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.VIEW_BUNDLE_ACTION", this);
        return;
_L4:
        closetListView.updateList();
        if (listingSummaryCollectionData != null && listingSummaryCollectionData.isEmpty())
        {
            showCustomEmptyListingsMessage();
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void onPause()
    {
        super.onPause();
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

    public void reportUser(String s)
    {
        showProgressDialogWithMessage(getString(0x7f060229));
        PMApi.reportUser(userName, s, new PMApiResponseHandler() {

            final ClosetFragment this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
label0:
                {
                    if (isAdded())
                    {
                        hideProgressDialog();
                        if (pmapiresponse.hasError())
                        {
                            break label0;
                        }
                        showAutoHideSuccessMessage(getString(0x7f060228));
                    }
                    return;
                }
                showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.REPORT_USER, PMApplication.getContext().getString(0x7f0600f6)));
            }

            
            {
                this$0 = ClosetFragment.this;
                super();
            }
        });
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "user_profile_screen";
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        if (profileData == null)
        {
            setTitle("");
            return;
        }
        Object obj = profileData.getDisplayStatus();
        if (obj != null)
        {
            setSubTitle(((String) (obj)));
        }
        setTitle((new StringBuilder()).append("@").append(profileData.getDisplayHandle()).toString());
        obj = new Bundle();
        ((Bundle) (obj)).putParcelable("PARENT_FRAGMENT_ID", new ParcelUuid(fragmentId));
        ((Bundle) (obj)).putString("USER_ID", profileData.getPMUserId());
        ((Bundle) (obj)).putBoolean("BLOCK_USER_STATUS", profileData.isUserBlocked());
        setDrawerActionButton(com/poshmark/ui/fragments/ClosetDrawerFragment, this, 0x7f0c003e, obj);
    }

    public void shareCloset()
    {
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "mycloset_share_button_tapped", null);
        Uri uri = ImageUtils.takeScreenshot(getView());
        Bundle bundle = new Bundle();
        bundle.putString("MODE", com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_CLOSET.name());
        bundle.putString("IMAGE_URI", uri.toString());
        ((PMActivity)getActivity()).launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/ShareFragment, profileData);
    }

    public void showCustomEmptyListingsMessage()
    {
        LayoutInflater layoutinflater = LayoutInflater.from(getActivity());
        if (emptyListHeader == null)
        {
            emptyListHeader = layoutinflater.inflate(0x7f030028, null);
        }
        if (profileData.getShareCount() > 0)
        {
            PMTextView pmtextview = (PMTextView)emptyListHeader.findViewById(0x7f0c00cb);
            pmtextview.setVisibility(0);
            pmtextview.setText(String.format(getString(0x7f060267), new Object[] {
                profileData.getUserName()
            }));
            pmtextview.setOnClickListener(sharesOnClickListener);
        } else
        {
            emptyListHeader.findViewById(0x7f0c00cb).setVisibility(8);
        }
        closetListView.showEmptyContentView(emptyListHeader);
    }

    public void unblockUser()
    {
        showProgressDialogWithMessage(getString(0x7f06021e));
        PMApi.unblockUser(profileData.getPMUserId(), new PMApiResponseHandler() {

            final ClosetFragment this$0;

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
                        showAutoHideSuccessMessage(getString(0x7f0602b8));
                        profileData.setBlockedFlag(false);
                        pmapiresponse = new Bundle();
                        pmapiresponse.putParcelable("PARENT_ID", new ParcelUuid(fragmentId));
                        pmapiresponse.putBoolean("BLOCK_USER_STATUS", false);
                        PMNotificationManager.fireNotification("com.poshmark.intents.SET_BLOCK_USER_STATUS_ACTION", pmapiresponse);
                    }
                    return;
                }
                showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.UNBLOCK_USER, getString(0x7f0600fd)));
            }

            
            {
                this$0 = ClosetFragment.this;
                super();
            }
        });
    }

    public void updateListing(ListingDetails listingdetails)
    {
        if (listingdetails.getUserId().equals(PMApplicationSession.GetPMSession().getUserId()))
        {
            bUpdateOnShow = true;
        }
    }




/*
    static UserInfoDetails access$102(ClosetFragment closetfragment, UserInfoDetails userinfodetails)
    {
        closetfragment.profileData = userinfodetails;
        return userinfodetails;
    }

*/



}

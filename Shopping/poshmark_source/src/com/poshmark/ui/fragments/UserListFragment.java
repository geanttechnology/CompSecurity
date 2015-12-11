// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.adapters.UserListAdapter;
import com.poshmark.data_model.models.PMData;
import com.poshmark.data_model.models.UserReferenceList;
import com.poshmark.data_model.models.inner_models.UserReference;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.customviews.CollectionSortWidget;
import com.poshmark.ui.customviews.PMListView;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.CollectionSortWidgetListener;
import com.poshmark.utils.ImageUtils;
import com.poshmark.utils.ViewUtils;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, ClosetFragment

public class UserListFragment extends PMFragment
    implements CollectionSortWidgetListener
{
    public static final class USER_LIST_MODE extends Enum
    {

        private static final USER_LIST_MODE $VALUES[];
        public static final USER_LIST_MODE CLOSETS_SHARED_FIRST;
        public static final USER_LIST_MODE FB_FRIENDS_MODE;
        public static final USER_LIST_MODE LIKES_MODE;
        public static final USER_LIST_MODE NEWLY_JOINED_CLOSETS;
        public static final USER_LIST_MODE NEWLY_OPENED_CLOSETS;
        public static final USER_LIST_MODE PM_FOLLOWERS_MODE;
        public static final USER_LIST_MODE PM_FOLLOWING_MODE;
        public static final USER_LIST_MODE SEARCH_PEOPLE_MODE;
        public static final USER_LIST_MODE SECONDARY_SUGGESTED_USERS_MODE;
        public static final USER_LIST_MODE SUGGESTED_USERS_MODE;
        public static final USER_LIST_MODE TWITTER_FRIENDS_MODE;

        public static USER_LIST_MODE valueOf(String s)
        {
            return (USER_LIST_MODE)Enum.valueOf(com/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE, s);
        }

        public static USER_LIST_MODE[] values()
        {
            return (USER_LIST_MODE[])$VALUES.clone();
        }

        static 
        {
            SUGGESTED_USERS_MODE = new USER_LIST_MODE("SUGGESTED_USERS_MODE", 0);
            SECONDARY_SUGGESTED_USERS_MODE = new USER_LIST_MODE("SECONDARY_SUGGESTED_USERS_MODE", 1);
            FB_FRIENDS_MODE = new USER_LIST_MODE("FB_FRIENDS_MODE", 2);
            TWITTER_FRIENDS_MODE = new USER_LIST_MODE("TWITTER_FRIENDS_MODE", 3);
            PM_FOLLOWERS_MODE = new USER_LIST_MODE("PM_FOLLOWERS_MODE", 4);
            PM_FOLLOWING_MODE = new USER_LIST_MODE("PM_FOLLOWING_MODE", 5);
            SEARCH_PEOPLE_MODE = new USER_LIST_MODE("SEARCH_PEOPLE_MODE", 6);
            CLOSETS_SHARED_FIRST = new USER_LIST_MODE("CLOSETS_SHARED_FIRST", 7);
            NEWLY_OPENED_CLOSETS = new USER_LIST_MODE("NEWLY_OPENED_CLOSETS", 8);
            NEWLY_JOINED_CLOSETS = new USER_LIST_MODE("NEWLY_JOINED_CLOSETS", 9);
            LIKES_MODE = new USER_LIST_MODE("LIKES_MODE", 10);
            $VALUES = (new USER_LIST_MODE[] {
                SUGGESTED_USERS_MODE, SECONDARY_SUGGESTED_USERS_MODE, FB_FRIENDS_MODE, TWITTER_FRIENDS_MODE, PM_FOLLOWERS_MODE, PM_FOLLOWING_MODE, SEARCH_PEOPLE_MODE, CLOSETS_SHARED_FIRST, NEWLY_OPENED_CLOSETS, NEWLY_JOINED_CLOSETS, 
                LIKES_MODE
            });
        }

        private USER_LIST_MODE(String s, int i)
        {
            super(s, i);
        }
    }


    private String Id;
    private UserListAdapter adapter;
    Bitmap backgroundBmp;
    ImageView backgroundImageView;
    private int displayCount;
    private View headerView;
    android.view.View.OnClickListener itemClickListener;
    private USER_LIST_MODE mode;
    UserReferenceList model;
    private String screenStackTag;
    private String subTitle;
    private String title;
    private PMListView userListView;

    public UserListFragment()
    {
        model = null;
        displayCount = 0;
        title = null;
        subTitle = null;
        itemClickListener = new android.view.View.OnClickListener() {

            final UserListFragment this$0;

            public void onClick(View view)
            {
                Object obj = (UserReference)view.getTag();
                view = new Bundle();
                view.putString("NAME", ((UserReference) (obj)).getUserName());
                obj = (PMActivity)getActivity();
                if (obj != null && ((PMActivity) (obj)).isActivityInForeground())
                {
                    ((PMActivity) (obj)).launchFragment(view, com/poshmark/ui/fragments/ClosetFragment, null);
                }
            }

            
            {
                this$0 = UserListFragment.this;
                super();
            }
        };
    }

    private void fetchNewlyJoinedClosets()
    {
        mode = USER_LIST_MODE.NEWLY_JOINED_CLOSETS;
        Analytics.getInstance().trackView("newly_joined_closets_screen");
        showProgressDialogWithMessage(getString(0x7f060190));
        PMApi.getNewlyJoinedClosets(Id, null, new PMApiResponseHandler() {

            final UserListFragment this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                UserListFragment.this.handleResponse(pmapiresponse, false);
            }

            
            {
                this$0 = UserListFragment.this;
                super();
            }
        });
    }

    private void fetchNewlyOpenedClosets()
    {
        mode = USER_LIST_MODE.NEWLY_OPENED_CLOSETS;
        Analytics.getInstance().trackView("newly_opened_closets_screen");
        showProgressDialogWithMessage(getString(0x7f060190));
        PMApi.getNewlyOpenedClosets(Id, null, new PMApiResponseHandler() {

            final UserListFragment this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                UserListFragment.this.handleResponse(pmapiresponse, false);
            }

            
            {
                this$0 = UserListFragment.this;
                super();
            }
        });
    }

    private void handleResponse(PMApiResponse pmapiresponse, boolean flag)
    {
        if (!isAdded()) goto _L2; else goto _L1
_L1:
        hideProgressDialog();
        if (pmapiresponse.hasError()) goto _L4; else goto _L3
_L3:
        if (flag) goto _L6; else goto _L5
_L5:
        model = (UserReferenceList)pmapiresponse.data;
        userListView.removeEmptyContentView();
        userListView.setListData(model);
        userListView.updateList();
_L2:
        return;
_L6:
        model.append((PMData)pmapiresponse.data);
        userListView.updateList();
        return;
_L4:
        if (!flag)
        {
            showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.FETCH_USERLIST));
            return;
        }
        if (true) goto _L2; else goto _L7
_L7:
    }

    private void setScreenTagBasedOnMode()
    {
        static class _cls11
        {

            static final int $SwitchMap$com$poshmark$ui$customviews$CollectionSortWidget$SortType[];
            static final int $SwitchMap$com$poshmark$ui$fragments$UserListFragment$USER_LIST_MODE[];

            static 
            {
                $SwitchMap$com$poshmark$ui$customviews$CollectionSortWidget$SortType = new int[com.poshmark.ui.customviews.CollectionSortWidget.SortType.values().length];
                try
                {
                    $SwitchMap$com$poshmark$ui$customviews$CollectionSortWidget$SortType[com.poshmark.ui.customviews.CollectionSortWidget.SortType.Left.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$customviews$CollectionSortWidget$SortType[com.poshmark.ui.customviews.CollectionSortWidget.SortType.Right.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                $SwitchMap$com$poshmark$ui$fragments$UserListFragment$USER_LIST_MODE = new int[USER_LIST_MODE.values().length];
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$UserListFragment$USER_LIST_MODE[USER_LIST_MODE.LIKES_MODE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$UserListFragment$USER_LIST_MODE[USER_LIST_MODE.PM_FOLLOWERS_MODE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$UserListFragment$USER_LIST_MODE[USER_LIST_MODE.PM_FOLLOWING_MODE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$UserListFragment$USER_LIST_MODE[USER_LIST_MODE.FB_FRIENDS_MODE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$UserListFragment$USER_LIST_MODE[USER_LIST_MODE.TWITTER_FRIENDS_MODE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$UserListFragment$USER_LIST_MODE[USER_LIST_MODE.SUGGESTED_USERS_MODE.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$UserListFragment$USER_LIST_MODE[USER_LIST_MODE.SECONDARY_SUGGESTED_USERS_MODE.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$UserListFragment$USER_LIST_MODE[USER_LIST_MODE.SEARCH_PEOPLE_MODE.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$UserListFragment$USER_LIST_MODE[USER_LIST_MODE.CLOSETS_SHARED_FIRST.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$UserListFragment$USER_LIST_MODE[USER_LIST_MODE.NEWLY_OPENED_CLOSETS.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$UserListFragment$USER_LIST_MODE[USER_LIST_MODE.NEWLY_JOINED_CLOSETS.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls11..SwitchMap.com.poshmark.ui.fragments.UserListFragment.USER_LIST_MODE[mode.ordinal()])
        {
        default:
            return;

        case 8: // '\b'
            screenStackTag = new String("sp");
            break;
        }
    }

    private void setupHeaderView()
    {
        headerView = LayoutInflater.from(getActivity()).inflate(0x7f0300ca, null);
        backgroundImageView = (ImageView)headerView.findViewById(0x7f0c0062);
        CollectionSortWidget collectionsortwidget = (CollectionSortWidget)headerView.findViewById(0x7f0c0068);
        collectionsortwidget.setSortSelectionListener(this);
        collectionsortwidget.setLeftButtonText(getResources().getString(0x7f060138));
        collectionsortwidget.setRightButtonText(getResources().getString(0x7f06015e));
        if (mode == USER_LIST_MODE.NEWLY_OPENED_CLOSETS)
        {
            collectionsortwidget.selectLeftButton();
            return;
        }
        if (mode == USER_LIST_MODE.NEWLY_JOINED_CLOSETS)
        {
            collectionsortwidget.selectRightButton();
            return;
        } else
        {
            collectionsortwidget.selectLeftButton();
            return;
        }
    }

    private void setupListView()
    {
        if (mode == USER_LIST_MODE.NEWLY_OPENED_CLOSETS || mode == USER_LIST_MODE.NEWLY_JOINED_CLOSETS)
        {
            setupHeaderView();
        }
        userListView = (PMListView)getView().findViewById(0x7f0c02f6);
        adapter = new UserListAdapter(getActivity(), this, null, 0x80000000);
        userListView.setup(adapter, headerView, null, new com.poshmark.ui.customviews.PMListView.LoadMoreItemsListener() {

            final UserListFragment this$0;

            public void loadItems(boolean flag)
            {
                if (flag)
                {
                    PMApi.getDiscoveredClosets(Id, model.getNextPageMaxValue(), new PMApiResponseHandler() {

                        final _cls7 this$1;

                        public void handleResponse(PMApiResponse pmapiresponse)
                        {
                            UserListFragment.this.handleResponse(pmapiresponse, true);
                        }

            
            {
                this$1 = _cls7.this;
                super();
            }
                    });
                }
            }

            
            {
                this$0 = UserListFragment.this;
                super();
            }
        });
        adapter.setOnItemClickListener(itemClickListener);
    }

    public String getTrackingLabel()
    {
        return screenStackTag;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setupListView();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f0300c9, viewgroup, false);
        _cls11..SwitchMap.com.poshmark.ui.fragments.UserListFragment.USER_LIST_MODE[mode.ordinal()];
        JVM INSTR tableswitch 1 11: default 88
    //                   1 90
    //                   2 106
    //                   3 149
    //                   4 192
    //                   5 208
    //                   6 224
    //                   7 224
    //                   8 240
    //                   9 256
    //                   10 272
    //                   11 288;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L7 _L8 _L9 _L10 _L11
_L6:
        break MISSING_BLOCK_LABEL_208;
_L7:
        break MISSING_BLOCK_LABEL_224;
_L8:
        break MISSING_BLOCK_LABEL_240;
_L9:
        break MISSING_BLOCK_LABEL_256;
_L10:
        break MISSING_BLOCK_LABEL_272;
_L1:
        break; /* Loop/switch isn't completed */
_L11:
        break MISSING_BLOCK_LABEL_288;
_L12:
        return layoutinflater;
_L2:
        title = getResources().getString(0x7f060165);
        return layoutinflater;
_L3:
        setTitle(0x7f060133);
        if (Id != null && Id.equalsIgnoreCase(PMApplicationSession.GetPMSession().getUserId()))
        {
            subTitle = Integer.toString(displayCount);
            return layoutinflater;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        setTitle(0x7f060134);
        if (Id != null && Id.equalsIgnoreCase(PMApplicationSession.GetPMSession().getUserId()))
        {
            subTitle = Integer.toString(displayCount);
            return layoutinflater;
        }
        if (true) goto _L12; else goto _L5
_L5:
        title = getResources().getString(0x7f060109);
        return layoutinflater;
        title = getResources().getString(0x7f0602a1);
        return layoutinflater;
        title = getResources().getString(0x7f060292);
        return layoutinflater;
        title = getResources().getString(0x7f0601fd);
        return layoutinflater;
        title = getResources().getString(0x7f06025a);
        return layoutinflater;
        title = getResources().getString(0x7f060107);
        return layoutinflater;
        title = getResources().getString(0x7f060107);
        return layoutinflater;
    }

    public void onPMResume()
    {
        super.onPMResume();
        if (model != null || Id == null)
        {
            break MISSING_BLOCK_LABEL_281;
        }
        showProgressDialogWithMessage(getString(0x7f060190));
        _cls11..SwitchMap.com.poshmark.ui.fragments.UserListFragment.USER_LIST_MODE[mode.ordinal()];
        JVM INSTR tableswitch 1 11: default 96
    //                   1 170
    //                   2 188
    //                   3 206
    //                   4 96
    //                   5 96
    //                   6 96
    //                   7 96
    //                   8 96
    //                   9 224
    //                   10 243
    //                   11 262;
           goto _L1 _L2 _L3 _L4 _L1 _L1 _L1 _L1 _L1 _L5 _L6 _L7
_L1:
        try
        {
            if (backgroundImageView != null)
            {
                int i = getActivity().getWindowManager().getDefaultDisplay().getWidth();
                int j = (int)ViewUtils.dipToPixels(getActivity().getApplicationContext(), 120F);
                backgroundBmp = ImageUtils.loadScaledBitmapFromResource(getResources(), 0x7f020112, i, j, true);
                if (backgroundBmp != null)
                {
                    backgroundImageView.setImageBitmap(backgroundBmp);
                }
            }
            return;
        }
        catch (Exception exception)
        {
            return;
        }
_L2:
        PMApi.getLikersforListing(Id, new PMApiResponseHandler() {

            final UserListFragment this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                UserListFragment.this.handleResponse(pmapiresponse, false);
            }

            
            {
                this$0 = UserListFragment.this;
                super();
            }
        });
          goto _L1
_L3:
        PMApi.getFollowersList(Id, new PMApiResponseHandler() {

            final UserListFragment this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                UserListFragment.this.handleResponse(pmapiresponse, false);
            }

            
            {
                this$0 = UserListFragment.this;
                super();
            }
        });
          goto _L1
_L4:
        PMApi.getFollowingList(Id, new PMApiResponseHandler() {

            final UserListFragment this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                UserListFragment.this.handleResponse(pmapiresponse, false);
            }

            
            {
                this$0 = UserListFragment.this;
                super();
            }
        });
          goto _L1
_L5:
        PMApi.getDiscoveredClosets(Id, null, new PMApiResponseHandler() {

            final UserListFragment this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                UserListFragment.this.handleResponse(pmapiresponse, false);
            }

            
            {
                this$0 = UserListFragment.this;
                super();
            }
        });
          goto _L1
_L6:
        PMApi.getNewlyOpenedClosets(Id, null, new PMApiResponseHandler() {

            final UserListFragment this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                UserListFragment.this.handleResponse(pmapiresponse, false);
            }

            
            {
                this$0 = UserListFragment.this;
                super();
            }
        });
          goto _L1
_L7:
        PMApi.getNewlyJoinedClosets(Id, null, new PMApiResponseHandler() {

            final UserListFragment this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                UserListFragment.this.handleResponse(pmapiresponse, false);
            }

            
            {
                this$0 = UserListFragment.this;
                super();
            }
        });
          goto _L1
        userListView.removeEmptyContentView();
        userListView.setListData(model);
        userListView.updateList();
          goto _L1
    }

    public void onPause()
    {
        super.onPause();
        if (backgroundImageView != null)
        {
            backgroundImageView.setImageBitmap(null);
            if (backgroundBmp != null)
            {
                backgroundBmp.recycle();
                backgroundBmp = null;
            }
        }
    }

    protected void pullParametersFromState(Bundle bundle)
    {
        mode = USER_LIST_MODE.valueOf(getArguments().getString("MODE"));
        Id = getArguments().getString("ID");
        displayCount = getArguments().getInt("DISPLAY_COUNT", 0);
        model = (UserReferenceList)getFragmentDataOfType(com/poshmark/data_model/models/UserReferenceList);
        setScreenTagBasedOnMode();
    }

    public void setViewNameForAnalytics()
    {
        switch (_cls11..SwitchMap.com.poshmark.ui.fragments.UserListFragment.USER_LIST_MODE[mode.ordinal()])
        {
        case 9: // '\t'
        case 10: // '\n'
        default:
            return;

        case 1: // '\001'
            viewNameForAnalytics = "listing_user_likes_screen";
            return;

        case 2: // '\002'
            viewNameForAnalytics = "followers_screen";
            return;

        case 3: // '\003'
            viewNameForAnalytics = "following_screen";
            return;

        case 6: // '\006'
            viewNameForAnalytics = "suggested_users_screen";
            return;

        case 7: // '\007'
            viewNameForAnalytics = "secondary_suggested_users_screen";
            return;

        case 4: // '\004'
            viewNameForAnalytics = "facebook_connections_screen";
            return;

        case 5: // '\005'
            viewNameForAnalytics = "twitter_connections_screen";
            return;

        case 8: // '\b'
            viewNameForAnalytics = "newly_opened_closets_screen";
            return;

        case 11: // '\013'
            viewNameForAnalytics = "newly_joined_closets_screen";
            break;
        }
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        if (title != null)
        {
            setTitle(title);
        }
        if (subTitle != null)
        {
            setSubTitle(subTitle);
        }
    }

    public void sortWidgetClicked(com.poshmark.ui.customviews.CollectionSortWidget.SortType sorttype)
    {
        switch (_cls11..SwitchMap.com.poshmark.ui.customviews.CollectionSortWidget.SortType[sorttype.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            fetchNewlyOpenedClosets();
            return;

        case 2: // '\002'
            fetchNewlyJoinedClosets();
            break;
        }
    }


}

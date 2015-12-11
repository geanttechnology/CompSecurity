// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.adapters.UserListAdapter;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.PMData;
import com.poshmark.data_model.models.UserReferenceList;
import com.poshmark.data_model.models.inner_models.UserReference;
import com.poshmark.fb_tmblr_twitter.ExtServiceConnectInterface;
import com.poshmark.fb_tmblr_twitter.ExtServiceConnectManager;
import com.poshmark.fb_tmblr_twitter.FBPermissionStates;
import com.poshmark.fb_tmblr_twitter.FbHelper;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiError;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.MainActivity;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.customviews.PMButton;
import com.poshmark.ui.customviews.PMEditText;
import com.poshmark.ui.model.ActionErrorContext;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, UserListFragment, ClosetFragment, MappPageFragment

public class FindPeopleFragment extends PMFragment
{

    private static String screenTag = "su";
    private UserListAdapter adapter;
    UserReferenceList fbUserList;
    private View headerView;
    android.view.View.OnClickListener itemClickListener;
    private ListView peopleListView;
    private PMButton searchButton;
    private PMEditText searchEditText;
    UserReferenceList searchResultsList;
    String searchString;
    UserReferenceList suggestedUserList;
    UserReferenceList twitterUserList;

    public FindPeopleFragment()
    {
        itemClickListener = new android.view.View.OnClickListener() {

            final FindPeopleFragment this$0;

            public void onClick(View view)
            {
                view = (UserReference)view.getTag();
                PMActivity pmactivity = (PMActivity)getActivity();
                if (pmactivity != null && pmactivity.isActivityInForeground())
                {
                    Bundle bundle = new Bundle();
                    bundle.putString("NAME", view.getUserName());
                    ((PMActivity)getActivity()).launchFragment(bundle, com/poshmark/ui/fragments/ClosetFragment, null);
                }
            }

            
            {
                this$0 = FindPeopleFragment.this;
                super();
            }
        };
    }

    private void fetchFBFriends()
    {
        if (fbUserList == null)
        {
            FbHelper.getInstance().link(this, 5, 5, FbHelper.FB_CONNECT_FRIENDS_REQUEST);
        }
    }

    private void fetchFbFriendsFromPM()
    {
        showProgressDialogWithMessage(getString(0x7f060190));
        PMApi.getFacebookFriends(new PMApiResponseHandler() {

            final FindPeopleFragment this$0;

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
                        fbUserList = (UserReferenceList)pmapiresponse.data;
                        launchUserListFragment(fbUserList, UserListFragment.USER_LIST_MODE.FB_FRIENDS_MODE);
                    }
                    return;
                }
                showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.FETCH_FACEBOOK_PM_USERS));
            }

            
            {
                this$0 = FindPeopleFragment.this;
                super();
            }
        });
    }

    private void fetchTwitterFriends()
    {
        if (twitterUserList == null)
        {
            showProgressDialogWithMessage(getString(0x7f060190));
            PMApi.getTwitterConnections(new PMApiResponseHandler() {

                final FindPeopleFragment this$0;

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
                            twitterUserList = (UserReferenceList)pmapiresponse.data;
                            showTwitterFriends();
                        }
                        return;
                    }
                    showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.FETCH_TWITTER_PM_USERS));
                }

            
            {
                this$0 = FindPeopleFragment.this;
                super();
            }
            });
        }
    }

    private void findUsers()
    {
        searchString = searchEditText.getText().toString();
        showProgressDialogWithMessage(getString(0x7f06023b));
        PMApi.searchUsers(searchString, new PMApiResponseHandler() {

            final FindPeopleFragment this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
label0:
                {
label1:
                    {
                        if (isAdded())
                        {
                            hideProgressDialog();
                            if (pmapiresponse.hasError())
                            {
                                break label0;
                            }
                            searchResultsList = (UserReferenceList)pmapiresponse.data;
                            if (searchResultsList.getConnectionInfoList().size() <= 0)
                            {
                                break label1;
                            }
                            launchUserListFragment(searchResultsList, UserListFragment.USER_LIST_MODE.SEARCH_PEOPLE_MODE);
                        }
                        return;
                    }
                    showAutoHideProgressDialogWithMessage(getString(0x7f0601d3));
                    return;
                }
                showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.FETCH_FACEBOOK_PM_USERS));
            }

            
            {
                this$0 = FindPeopleFragment.this;
                super();
            }
        });
    }

    private void launchUserListFragment(UserReferenceList userreferencelist, UserListFragment.USER_LIST_MODE user_list_mode)
    {
        PMActivity pmactivity = (PMActivity)getActivity();
        if (pmactivity != null && pmactivity.isActivityInForeground())
        {
            Bundle bundle = new Bundle();
            bundle.putString("MODE", user_list_mode.name());
            pmactivity.launchFragment(bundle, com/poshmark/ui/fragments/UserListFragment, userreferencelist);
        }
    }

    private void setupFindPeopleList()
    {
        if (suggestedUserList == null)
        {
            showProgressDialogWithMessage(getResources().getString(0x7f060190));
            PMApi.getSuggestedUsers(PMApplicationSession.GetPMSession().getUserId(), false, 0, new PMApiResponseHandler() {

                final FindPeopleFragment this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
label0:
                    {
                        hideProgressDialog();
                        if (isAdded())
                        {
                            if (pmapiresponse.hasError())
                            {
                                break label0;
                            }
                            suggestedUserList = (UserReferenceList)pmapiresponse.data;
                            updateUsersList();
                        }
                        return;
                    }
                    showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.FETCH_SUGGESTED_USERS));
                }

            
            {
                this$0 = FindPeopleFragment.this;
                super();
            }
            });
        }
    }

    private void setupHeaderView()
    {
        headerView = LayoutInflater.from(getActivity()).inflate(0x7f030054, null);
        searchEditText = (PMEditText)headerView.findViewById(0x7f0c0151);
        searchButton = (PMButton)headerView.findViewById(0x7f0c0039);
        if (searchString != null && searchString.length() > 0)
        {
            searchEditText.setText(searchString);
        }
        searchEditText.setOnKeyListener(new android.view.View.OnKeyListener() {

            final FindPeopleFragment this$0;

            public boolean onKey(View view, int i, KeyEvent keyevent)
            {
                if (keyevent.getAction() == 0 && (i == 84 || i == 66))
                {
                    if (searchEditText.getText().toString().length() > 0)
                    {
                        findUsers();
                    }
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                this$0 = FindPeopleFragment.this;
                super();
            }
        });
        searchButton.setOnClickListener(new android.view.View.OnClickListener() {

            final FindPeopleFragment this$0;

            public void onClick(View view)
            {
                if (searchEditText.getText().toString().length() == 0)
                {
                    searchEditText.requestFocus();
                    showKeyboard();
                    return;
                } else
                {
                    hideKeyboard();
                    findUsers();
                    return;
                }
            }

            
            {
                this$0 = FindPeopleFragment.this;
                super();
            }
        });
        ((LinearLayout)headerView.findViewById(0x7f0c0152)).setOnClickListener(new android.view.View.OnClickListener() {

            final FindPeopleFragment this$0;

            public void onClick(View view)
            {
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "load_contacts", null);
                view = new Bundle();
                view.putString("URL", "https://www.poshmark.com/mapp/find_people/contacts");
                ((PMActivity)getActivity()).launchFragmentInNewActivity(view, com/poshmark/ui/fragments/MappPageFragment, null);
            }

            
            {
                this$0 = FindPeopleFragment.this;
                super();
            }
        });
        ((LinearLayout)headerView.findViewById(0x7f0c0154)).setOnClickListener(new android.view.View.OnClickListener() {

            final FindPeopleFragment this$0;

            public void onClick(View view)
            {
                showFBFriends();
            }

            
            {
                this$0 = FindPeopleFragment.this;
                super();
            }
        });
        ((LinearLayout)headerView.findViewById(0x7f0c0156)).setOnClickListener(new android.view.View.OnClickListener() {

            final FindPeopleFragment this$0;

            public void onClick(View view)
            {
                showTwitterFriends();
            }

            
            {
                this$0 = FindPeopleFragment.this;
                super();
            }
        });
        ((LinearLayout)headerView.findViewById(0x7f0c0157)).setOnClickListener(new android.view.View.OnClickListener() {

            final FindPeopleFragment this$0;

            public void onClick(View view)
            {
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "load_new_closets", null);
                view = new Bundle();
                view.putString("ID", PMApplicationSession.GetPMSession().getUserId());
                view.putString("MODE", UserListFragment.USER_LIST_MODE.NEWLY_OPENED_CLOSETS.name());
                PMActivity pmactivity = getParentActivity();
                if (pmactivity != null && pmactivity.isActivityInForeground())
                {
                    pmactivity.launchFragment(view, com/poshmark/ui/fragments/UserListFragment, null);
                }
            }

            
            {
                this$0 = FindPeopleFragment.this;
                super();
            }
        });
    }

    private void showFBFriends()
    {
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "load_facebook_friends", null);
        if (FbHelper.getInstance().isPermissionEnabled(FBPermissionStates.FRIENDS_PERMISSION))
        {
            if (fbUserList == null)
            {
                fetchFBFriends();
                return;
            } else
            {
                launchUserListFragment(fbUserList, UserListFragment.USER_LIST_MODE.FB_FRIENDS_MODE);
                return;
            }
        } else
        {
            FbHelper.getInstance().link(this, 5, 5, FbHelper.FB_CONNECT_FRIENDS_REQUEST);
            return;
        }
    }

    private void showNewClosets()
    {
    }

    private void showTwitterFriends()
    {
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "load_twitter_friends", null);
        if (PMApplicationSession.GetPMSession().getTwitterToken() != null)
        {
            if (twitterUserList == null)
            {
                fetchTwitterFriends();
                return;
            } else
            {
                launchUserListFragment(twitterUserList, UserListFragment.USER_LIST_MODE.TWITTER_FRIENDS_MODE);
                return;
            }
        } else
        {
            showProgressDialogWithMessage(getString(0x7f060190));
            ExtServiceConnectManager.getGlobalConnectManager().twitterLink(this, new ExtServiceConnectInterface() {

                final FindPeopleFragment this$0;

                public void error(PMApiError pmapierror)
                {
                    hideProgressDialog();
                    showError(new ActionErrorContext(pmapierror, com.poshmark.ui.model.ActionErrorContext.ActionContext.LINK_TWITTER));
                }

                public void success(int i, Bundle bundle)
                {
                    hideProgressDialog();
                    fetchTwitterFriends();
                }

            
            {
                this$0 = FindPeopleFragment.this;
                super();
            }
            });
            return;
        }
    }

    private void updateUsersList()
    {
        if (suggestedUserList != null)
        {
            CustomMatrixCursor custommatrixcursor = new CustomMatrixCursor(new String[] {
                PMData.ID_COL, PMData.DATA_COL
            });
            suggestedUserList.fillCursor(custommatrixcursor);
            adapter.changeCursor(custommatrixcursor);
            adapter.notifyDataSetChanged();
            adapter.setOnItemClickListener(itemClickListener);
        }
    }

    public String getTrackingLabel()
    {
        return "su";
    }

    public void handleNotification(Intent intent)
    {
        if (intent.getAction().equals("com.poshmark.intents.LOGOUT_COMPLETE"))
        {
            suggestedUserList = null;
        }
        if (intent.getAction().equals("com.poshmark.intents.LOGIN_COMPLETE"))
        {
            bUpdateOnShow = true;
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        fragmentType = PMFragment.FRAGMENT_TYPE.REGULAR;
        adapter = new UserListAdapter(getActivity(), this, null, 0x80000000);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.LOGIN_COMPLETE", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.LOGOUT_COMPLETE", this);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f030053, viewgroup, false);
        setupHeaderView();
        peopleListView = (ListView)layoutinflater.findViewById(0x7f0c0150);
        peopleListView.addHeaderView(headerView);
        peopleListView.setAdapter(adapter);
        return layoutinflater;
    }

    public void onFragmentResult(Bundle bundle, int i)
    {
        if (i == FbHelper.FB_CONNECT_FRIENDS_REQUEST && bundle != null)
        {
            if (!bundle.getBoolean("HAS_ERROR", false))
            {
                if ((bundle.getInt("ACCESS_LEVEL", 0) & 4) != 0)
                {
                    fetchFbFriendsFromPM();
                }
            } else
            {
                bundle = bundle.getString("ERROR_JSON");
                if (bundle != null)
                {
                    FbHelper.showFBLinkError(PMApiError.deserialize(bundle), this);
                    return;
                }
            }
        }
    }

    public void onPMResume()
    {
        super.onPMResume();
        if (getUserVisibleHint())
        {
            PMApi.getViewTrackingInfo(screenTag);
            setupFindPeopleList();
        }
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "search_people_screen";
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        if (getActivity().getClass() != com/poshmark/ui/MainActivity)
        {
            setTitle(getString(0x7f060129));
        } else
        {
            showLogoAsTitle();
        }
        showRefreshButton(false);
    }








}

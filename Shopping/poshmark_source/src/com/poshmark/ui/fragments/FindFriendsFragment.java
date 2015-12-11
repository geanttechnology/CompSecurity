// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplicationSession;
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
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.model.ActionErrorContext;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, UserListFragment, MappPageFragment

public class FindFriendsFragment extends PMFragment
{
    static interface FetchFBFriendsCompletionsCallback
    {

        public abstract void callFinished(boolean flag);
    }


    UserReferenceList fbList;
    UserReferenceList suggestedUserList;
    UserReferenceList twitterList;

    public FindFriendsFragment()
    {
        suggestedUserList = null;
        fbList = null;
        twitterList = null;
    }

    private void fetchFbFriends(final FetchFBFriendsCompletionsCallback callback)
    {
        if (fbList == null || fbList.isEmpty())
        {
            showProgressDialogWithMessage(getString(0x7f060190));
            PMApi.getFacebookFriends(new PMApiResponseHandler() {

                final FindFriendsFragment this$0;
                final FetchFBFriendsCompletionsCallback val$callback;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    if (isAdded())
                    {
                        hideProgressDialog();
                        if (!pmapiresponse.hasError())
                        {
                            fbList = (UserReferenceList)pmapiresponse.data;
                            updateFacebookPanel();
                            if (callback != null)
                            {
                                callback.callFinished(true);
                            }
                        } else
                        {
                            showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.FETCH_FACEBOOK_PM_USERS));
                            if (callback != null)
                            {
                                callback.callFinished(false);
                                return;
                            }
                        }
                    }
                }

            
            {
                this$0 = FindFriendsFragment.this;
                callback = fetchfbfriendscompletionscallback;
                super();
            }
            });
        }
    }

    private void fetchTwFriends()
    {
        if (twitterList == null)
        {
            showProgressDialogWithMessage(getString(0x7f060190));
            PMApi.getTwitterConnections(new PMApiResponseHandler() {

                final FindFriendsFragment this$0;

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
                            twitterList = (UserReferenceList)pmapiresponse.data;
                            updateTwitterPanel();
                        }
                        return;
                    }
                    showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.FETCH_TWITTER_PM_USERS));
                }

            
            {
                this$0 = FindFriendsFragment.this;
                super();
            }
            });
        }
    }

    private void getExternalConnections()
    {
        boolean flag = FbHelper.getInstance().isPermissionEnabled(FBPermissionStates.FRIENDS_PERMISSION);
        if (fbList != null) goto _L2; else goto _L1
_L1:
        if (!flag) goto _L4; else goto _L3
_L3:
        fetchFbFriends(new FetchFBFriendsCompletionsCallback() {

            final FindFriendsFragment this$0;

            public void callFinished(boolean flag1)
            {
                if (flag1)
                {
                    getSuggestedUsers();
                }
            }

            
            {
                this$0 = FindFriendsFragment.this;
                super();
            }
        });
_L6:
        if (suggestedUserList != null)
        {
            updateSuggestedUsersPanel();
        }
        return;
_L4:
        if (suggestedUserList == null)
        {
            getSuggestedUsers();
        }
        continue; /* Loop/switch isn't completed */
_L2:
        updateFacebookPanel();
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void getSuggestedUsers()
    {
        if (suggestedUserList == null)
        {
            showProgressDialogWithMessage(getString(0x7f060190));
            PMApi.getSuggestedUsers(PMApplicationSession.GetPMSession().getUserId(), true, 0, new PMApiResponseHandler() {

                final FindFriendsFragment this$0;

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
                            suggestedUserList = (UserReferenceList)pmapiresponse.data;
                            updateSuggestedUsersPanel();
                        }
                        return;
                    }
                    showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.FETCH_SUGGESTED_USERS));
                }

            
            {
                this$0 = FindFriendsFragment.this;
                super();
            }
            });
            return;
        } else
        {
            updateSuggestedUsersPanel();
            return;
        }
    }

    private void launchUserListFragment(UserReferenceList userreferencelist, UserListFragment.USER_LIST_MODE user_list_mode)
    {
        PMActivity pmactivity = (PMActivity)getActivity();
        Bundle bundle = new Bundle();
        bundle.putString("MODE", user_list_mode.name());
        pmactivity.launchFragment(bundle, com/poshmark/ui/fragments/UserListFragment, userreferencelist);
    }

    private void populateUserPanels()
    {
        if (PMApplicationSession.GetPMSession().getFacebookToken() == null);
    }

    private void setupContactsPanel()
    {
        ((RelativeLayout)getView().findViewById(0x7f0c013a)).setOnClickListener(new android.view.View.OnClickListener() {

            final FindFriendsFragment this$0;

            public void onClick(View view)
            {
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "load_contacts", null);
                view = new Bundle();
                view.putString("URL", "https://www.poshmark.com/mapp/find_people/contacts");
                ((PMActivity)getActivity()).launchFragmentInNewActivity(view, com/poshmark/ui/fragments/MappPageFragment, null);
            }

            
            {
                this$0 = FindFriendsFragment.this;
                super();
            }
        });
    }

    private void setupFacebookPanel()
    {
        ((RelativeLayout)getView().findViewById(0x7f0c013e)).setOnClickListener(new android.view.View.OnClickListener() {

            final FindFriendsFragment this$0;

            public void onClick(View view)
            {
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "load_facebook_friends", null);
                if (FbHelper.getInstance().isPermissionEnabled(FBPermissionStates.FRIENDS_PERMISSION) && fbList != null && fbList.getConnectionInfoList().size() > 0)
                {
                    launchUserListFragment(fbList, UserListFragment.USER_LIST_MODE.FB_FRIENDS_MODE);
                    return;
                } else
                {
                    FbHelper.getInstance().link(FindFriendsFragment.this, 5, 5, FbHelper.FB_CONNECT_FRIENDS_REQUEST);
                    return;
                }
            }

            
            {
                this$0 = FindFriendsFragment.this;
                super();
            }
        });
    }

    private void setupSuggestedUsersPanel()
    {
        ((RelativeLayout)getView().findViewById(0x7f0c014a)).setOnClickListener(new android.view.View.OnClickListener() {

            final FindFriendsFragment this$0;

            public void onClick(View view)
            {
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "onramp_suggested_users_viewed", null);
                if (suggestedUserList != null && suggestedUserList.getConnectionInfoList().size() > 0)
                {
                    launchUserListFragment(suggestedUserList, UserListFragment.USER_LIST_MODE.SUGGESTED_USERS_MODE);
                }
            }

            
            {
                this$0 = FindFriendsFragment.this;
                super();
            }
        });
    }

    private void setupTwitterPanel()
    {
        ((RelativeLayout)getView().findViewById(0x7f0c0144)).setOnClickListener(new android.view.View.OnClickListener() {

            final FindFriendsFragment this$0;

            public void onClick(View view)
            {
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "load_twitter_friends", null);
                if (PMApplicationSession.GetPMSession().getTwitterToken() != null && twitterList != null && twitterList.getConnectionInfoList().size() > 0)
                {
                    launchUserListFragment(twitterList, UserListFragment.USER_LIST_MODE.TWITTER_FRIENDS_MODE);
                    return;
                } else
                {
                    showProgressDialogWithMessage(getString(0x7f060190));
                    ExtServiceConnectManager.getGlobalConnectManager().twitterLink(FindFriendsFragment.this, new ExtServiceConnectInterface() {

                        final _cls5 this$1;

                        public void error(PMApiError pmapierror)
                        {
                            if (isAdded())
                            {
                                hideProgressDialog();
                                showError(new ActionErrorContext(pmapierror, com.poshmark.ui.model.ActionErrorContext.ActionContext.LINK_TWITTER));
                            }
                        }

                        public void success(int i, Bundle bundle)
                        {
                            if (isAdded())
                            {
                                hideProgressDialog();
                                fetchTwFriends();
                            }
                        }

            
            {
                this$1 = _cls5.this;
                super();
            }
                    });
                    return;
                }
            }

            
            {
                this$0 = FindFriendsFragment.this;
                super();
            }
        });
    }

    private void updateFacebookPanel()
    {
        Object obj = fbList.getConnectionInfoList();
        if (!((List) (obj)).isEmpty())
        {
            ((TextView)getView().findViewById(0x7f0c0141)).setText(getString(0x7f060109));
            String s = String.format(getActivity().getResources().getString(0x7f06010d), new Object[] {
                Integer.toString(((List) (obj)).size())
            });
            TextView textview = (TextView)getView().findViewById(0x7f0c0142);
            textview.setVisibility(0);
            textview.setText(s);
            obj = ((List) (obj)).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                Object obj1 = (UserReference)((Iterator) (obj)).next();
                ImageView imageview = new ImageView(getActivity());
                android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-2, -2);
                layoutparams.height = 70;
                layoutparams.width = 70;
                layoutparams.setMargins(10, 10, 10, 10);
                imageview.setLayoutParams(layoutparams);
                if (((UserReference) (obj1)).getAvataar() == null)
                {
                    imageview.setImageDrawable(getActivity().getResources().getDrawable(0x7f0200d4));
                } else
                {
                    ImageLoader.getInstance().displayImage(((UserReference) (obj1)).getAvataar(), imageview);
                }
                obj1 = (LinearLayout)getView().findViewById(0x7f0c0143);
                ((LinearLayout) (obj1)).setVisibility(0);
                ((LinearLayout) (obj1)).addView(imageview);
            }
        }
    }

    private void updateSuggestedUsersPanel()
    {
        ((TextView)getView().findViewById(0x7f0c014d)).setText(getString(0x7f060292));
        Object obj = suggestedUserList.getConnectionInfoList();
        if (!((List) (obj)).isEmpty())
        {
            String s = String.format(getActivity().getResources().getString(0x7f060291), new Object[] {
                Integer.toString(((List) (obj)).size())
            });
            TextView textview = (TextView)getView().findViewById(0x7f0c014e);
            textview.setVisibility(0);
            textview.setText(s);
            obj = ((List) (obj)).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                Object obj1 = (UserReference)((Iterator) (obj)).next();
                ImageView imageview = new ImageView(getActivity());
                android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-2, -2);
                layoutparams.width = 70;
                layoutparams.height = 70;
                layoutparams.setMargins(10, 10, 10, 10);
                imageview.setLayoutParams(layoutparams);
                if (((UserReference) (obj1)).getAvataar() == null)
                {
                    imageview.setImageDrawable(getActivity().getResources().getDrawable(0x7f0200d4));
                } else
                {
                    ImageLoader.getInstance().displayImage(((UserReference) (obj1)).getAvataar(), imageview);
                }
                obj1 = (LinearLayout)getView().findViewById(0x7f0c014f);
                ((LinearLayout) (obj1)).setVisibility(0);
                ((LinearLayout) (obj1)).addView(imageview);
            }
        }
    }

    private void updateTwitterPanel()
    {
        ((TextView)getView().findViewById(0x7f0c0147)).setText(getString(0x7f0602a1));
        Object obj = twitterList.getConnectionInfoList();
        if (!((List) (obj)).isEmpty())
        {
            String s = String.format(getActivity().getResources().getString(0x7f06029f), new Object[] {
                Integer.toString(((List) (obj)).size())
            });
            TextView textview = (TextView)getView().findViewById(0x7f0c0148);
            textview.setVisibility(0);
            textview.setText(s);
            obj = ((List) (obj)).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                Object obj1 = (UserReference)((Iterator) (obj)).next();
                ImageView imageview = new ImageView(getActivity());
                android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-2, -2);
                layoutparams.height = 70;
                layoutparams.width = 70;
                layoutparams.setMargins(10, 10, 10, 10);
                imageview.setLayoutParams(layoutparams);
                if (((UserReference) (obj1)).getAvataar() == null)
                {
                    imageview.setImageDrawable(getActivity().getResources().getDrawable(0x7f0200d4));
                } else
                {
                    ImageLoader.getInstance().displayImage(((UserReference) (obj1)).getAvataar(), imageview);
                }
                obj1 = (LinearLayout)getView().findViewById(0x7f0c0149);
                ((LinearLayout) (obj1)).setVisibility(0);
                ((LinearLayout) (obj1)).addView(imageview);
            }
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setTitle(0x7f0601fd);
        setupContactsPanel();
        setupTwitterPanel();
        setupFacebookPanel();
        setupSuggestedUsersPanel();
        getExternalConnections();
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (FacebookSdk.isFacebookRequestCode(i))
        {
            FbHelper.getInstance().getCallbackManager().onActivityResult(i, j, intent);
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        return layoutinflater.inflate(0x7f030052, viewgroup, false);
    }

    public void onDestroyView()
    {
        super.onDestroyView();
    }

    public void onFragmentResult(Bundle bundle, int i)
    {
        if (i == FbHelper.FB_CONNECT_FRIENDS_REQUEST && bundle != null)
        {
            if (!bundle.getBoolean("HAS_ERROR", false))
            {
                if ((bundle.getInt("ACCESS_LEVEL", 0) & 4) != 0)
                {
                    fetchFbFriends(null);
                }
            } else
            {
                bundle = bundle.getString("ERROR_JSON");
                if (bundle != null)
                {
                    FbHelper.showFBLinkError(PMApiError.deserialize(bundle), this, com.poshmark.ui.model.ActionErrorContext.Severity.HIGH);
                    return;
                }
            }
        }
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "on_ramp_following_screen";
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        Button button = getNextActionButton();
        button.setText(getString(0x7f0600bf));
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final FindFriendsFragment this$0;

            public void onClick(View view)
            {
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "completed_on_ramp", null);
                finishActivity();
            }

            
            {
                this$0 = FindFriendsFragment.this;
                super();
            }
        });
    }






}

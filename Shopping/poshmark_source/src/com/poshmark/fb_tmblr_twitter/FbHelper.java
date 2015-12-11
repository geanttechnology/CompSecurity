// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.fb_tmblr_twitter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.poshmark.application.PMApplication;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.models.ExternalPermissions;
import com.poshmark.data_model.models.ExternalServiceInfo;
import com.poshmark.data_model.models.FbUserInfo;
import com.poshmark.data_model.models.PMErrorType;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiError;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.DateUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

// Referenced classes of package com.poshmark.fb_tmblr_twitter:
//            FBPermissionStates, FBConnectCallback, ExtServiceUserInfoInterface

public class FbHelper
{
    public static final class AccessLevel extends Enum
    {

        private static final AccessLevel $VALUES[];
        public static final AccessLevel ACCESS_LEVEL_PUBLISH;
        public static final AccessLevel ACCESS_LEVEL_READ;
        public static final AccessLevel ACCESS_LEVEL_READ_PLUS_EMAIL;
        public static final AccessLevel ACCESS_LEVEL_READ_PLUS_EMAIL_PLUS_FRIENDS;
        public static final AccessLevel ACCESS_LEVEL_READ_PLUS_FRIENDS;
        public static final AccessLevel ACCESS_LEVEL_UNKNOWN;

        public static AccessLevel valueOf(String s)
        {
            return (AccessLevel)Enum.valueOf(com/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel, s);
        }

        public static AccessLevel[] values()
        {
            return (AccessLevel[])$VALUES.clone();
        }

        static 
        {
            ACCESS_LEVEL_UNKNOWN = new AccessLevel("ACCESS_LEVEL_UNKNOWN", 0);
            ACCESS_LEVEL_READ = new AccessLevel("ACCESS_LEVEL_READ", 1);
            ACCESS_LEVEL_READ_PLUS_EMAIL = new AccessLevel("ACCESS_LEVEL_READ_PLUS_EMAIL", 2);
            ACCESS_LEVEL_READ_PLUS_EMAIL_PLUS_FRIENDS = new AccessLevel("ACCESS_LEVEL_READ_PLUS_EMAIL_PLUS_FRIENDS", 3);
            ACCESS_LEVEL_READ_PLUS_FRIENDS = new AccessLevel("ACCESS_LEVEL_READ_PLUS_FRIENDS", 4);
            ACCESS_LEVEL_PUBLISH = new AccessLevel("ACCESS_LEVEL_PUBLISH", 5);
            $VALUES = (new AccessLevel[] {
                ACCESS_LEVEL_UNKNOWN, ACCESS_LEVEL_READ, ACCESS_LEVEL_READ_PLUS_EMAIL, ACCESS_LEVEL_READ_PLUS_EMAIL_PLUS_FRIENDS, ACCESS_LEVEL_READ_PLUS_FRIENDS, ACCESS_LEVEL_PUBLISH
            });
        }

        private AccessLevel(String s, int i)
        {
            super(s, i);
        }
    }

    private static class SingletonHolder
    {

        public static final FbHelper INSTANCE = new FbHelper();


        private SingletonHolder()
        {
        }
    }


    public static int CALLING_CODE_BASEMENT = 0;
    public static int FB_CONNECT_AUTO_TIMELINE_REQUEST = 0;
    public static int FB_CONNECT_FRIENDS_REQUEST = 0;
    public static int FB_CONNECT_PUBLISH_REQUEST = 0;
    public static int FB_CONNECT_READ_REQUEST = 0;
    public static final String SERVICE_ID = "fb";
    public int FB_REQUEST_FROM_PM_ACTIVITY;
    AccessTokenTracker accessTokenTracker = new AccessTokenTracker() {

        final FbHelper this$0;

        protected void onCurrentAccessTokenChanged(AccessToken accesstoken, AccessToken accesstoken1)
        {
            if (!handleTokenChange.get() || accesstoken == null) goto _L2; else goto _L1
_L1:
            if (accesstoken1 != null) goto _L4; else goto _L3
_L3:
            PMApi.unlinkExternalService("fb", null);
            PMApplicationSession.GetPMSession().clearFacebookInfo();
_L6:
            handleTokenChange.set(false);
_L2:
            return;
_L4:
            accesstoken = createTokenFromPMData();
            if (accesstoken != null && isTokenUpdated(accesstoken, accesstoken1))
            {
                accesstoken = getExternalConnectionInfoFromAccessToken(accesstoken1);
                PMApplicationSession.GetPMSession().updateFacebookData(accesstoken);
                accesstoken = DateUtils.getStringFromUTCDate(accesstoken1.getExpires());
                PMApi.saveExternalServiceInfo("fb", accesstoken1.getToken(), accesstoken, null, null);
            }
            if (true) goto _L6; else goto _L5
_L5:
        }

            
            {
                this$0 = FbHelper.this;
                super();
            }
    };
    private FBConnectCallback callback;
    CallbackManager callbackManager;
    PMFragment fragment;
    private UUID fragmentId;
    AtomicBoolean handleTokenChange;
    FacebookCallback loginCallback = new FacebookCallback() {

        final FbHelper this$0;

        public void onCancel()
        {
        }

        public void onError(FacebookException facebookexception)
        {
        }

        public void onSuccess(LoginResult loginresult)
        {
            Object obj = loginresult.getRecentlyGrantedPermissions();
            int i = inferCurrentAccessLevelFromSet(((Set) (obj)));
            loginresult = loginresult.getAccessToken();
            loginresult.getToken();
            obj = DateUtils.getStringFromUTCDate(loginresult.getExpires());
            if (PMApplicationSession.GetPMSession().isLoggedIn())
            {
                linkWithPM(loginresult.getToken(), ((String) (obj)), i);
                return;
            }
            if (callback != null)
            {
                callback.success(i, loginresult.getToken(), ((String) (obj)));
                return;
            } else
            {
                returnResult(i, loginresult.getToken(), ((String) (obj)));
                return;
            }
        }

        public volatile void onSuccess(Object obj)
        {
            onSuccess((LoginResult)obj);
        }

            
            {
                this$0 = FbHelper.this;
                super();
            }
    };
    private Bundle savedCallingFragmentBundle;

    private FbHelper()
    {
        handleTokenChange = new AtomicBoolean(false);
        accessTokenTracker.startTracking();
        callbackManager = com.facebook.CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callbackManager, loginCallback);
    }


    private AccessToken createTokenFromPMData()
    {
        Object obj = null;
        ExternalServiceInfo externalserviceinfo = PMApplicationSession.GetPMSession().getFacebookInfo();
        if (externalserviceinfo.ext_access_token != null)
        {
            obj = new ArrayList();
            ArrayList arraylist = new ArrayList();
            if (externalserviceinfo.ext_permissions != null)
            {
                if (externalserviceinfo.ext_permissions.public_profile == 1)
                {
                    ((List) (obj)).add(FBPermissionStates.READ_PERMISSION);
                } else
                {
                    arraylist.add(FBPermissionStates.READ_PERMISSION);
                }
                if (externalserviceinfo.ext_permissions.publish_actions == 1)
                {
                    ((List) (obj)).add(FBPermissionStates.PUBLISH_PERMISSION);
                } else
                {
                    arraylist.add(FBPermissionStates.PUBLISH_PERMISSION);
                }
                if (externalserviceinfo.ext_permissions.email == 1)
                {
                    ((List) (obj)).add(FBPermissionStates.EMAIL_PERMISSION);
                } else
                {
                    arraylist.add(FBPermissionStates.EMAIL_PERMISSION);
                }
                if (externalserviceinfo.ext_permissions.user_friends == 1)
                {
                    ((List) (obj)).add(FBPermissionStates.FRIENDS_PERMISSION);
                } else
                {
                    arraylist.add(FBPermissionStates.FRIENDS_PERMISSION);
                }
            }
            obj = new AccessToken(externalserviceinfo.ext_access_token, PMApplication.getContext().getString(0x7f06010b), externalserviceinfo.ext_user_id, ((java.util.Collection) (obj)), arraylist, null, DateUtils.getDateFromString(externalserviceinfo.ext_token_expr), null);
        }
        return ((AccessToken) (obj));
    }

    private PMFragment getCurrentFragmentCaller()
    {
        Object obj = PMApplication.getApplicationObject().getTopActivity();
        if (obj != null)
        {
            try
            {
                obj = (PMFragment)((PMActivity) (obj)).getSupportFragmentManager().getFragment(savedCallingFragmentBundle, fragmentId.toString());
                fragment = ((PMFragment) (obj));
            }
            catch (IllegalStateException illegalstateexception)
            {
                return null;
            }
            return ((PMFragment) (obj));
        } else
        {
            return null;
        }
    }

    private ExternalServiceInfo getExternalConnectionInfoFromAccessToken(AccessToken accesstoken)
    {
        ExternalServiceInfo externalserviceinfo = new ExternalServiceInfo();
        externalserviceinfo.ext_access_token = accesstoken.getToken();
        externalserviceinfo.ext_user_id = accesstoken.getUserId();
        externalserviceinfo.ext_token_expr = DateUtils.getStringFromUTCDate(accesstoken.getExpires());
        externalserviceinfo.ext_permissions = new ExternalPermissions();
        accesstoken = accesstoken.getPermissions();
        if (accesstoken.contains(FBPermissionStates.FRIENDS_PERMISSION))
        {
            externalserviceinfo.ext_permissions.user_friends = 1;
        }
        if (accesstoken.contains(FBPermissionStates.READ_PERMISSION))
        {
            externalserviceinfo.ext_permissions.public_profile = 1;
        }
        if (accesstoken.contains(FBPermissionStates.PUBLISH_PERMISSION))
        {
            externalserviceinfo.ext_permissions.publish_actions = 1;
        }
        if (accesstoken.contains(FBPermissionStates.EMAIL_PERMISSION))
        {
            externalserviceinfo.ext_permissions.email = 1;
        }
        return externalserviceinfo;
    }

    public static FbHelper getInstance()
    {
        return SingletonHolder.INSTANCE;
    }

    private int inferCurrentAccessLevelFromSet(Set set)
    {
        int i = 0;
        for (set = set.iterator(); set.hasNext();)
        {
            i |= FBPermissionStates.getMaskFromString((String)set.next());
        }

        return i;
    }

    private boolean isTokenUpdated(AccessToken accesstoken, AccessToken accesstoken1)
    {
label0:
        {
            boolean flag3 = false;
            HashSet hashset = new HashSet(accesstoken.getPermissions());
            HashSet hashset1 = new HashSet(accesstoken1.getPermissions());
            hashset.remove("contact_email");
            hashset1.remove("contact_email");
            boolean flag;
            boolean flag1;
            boolean flag2;
            boolean flag4;
            if (!accesstoken.getToken().equals(accesstoken1.getToken()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!hashset.equals(hashset1))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            flag4 = accesstoken.getUserId().endsWith(accesstoken1.getUserId());
            if (!flag)
            {
                flag2 = flag3;
                if (!flag1)
                {
                    break label0;
                }
            }
            flag2 = flag3;
            if (flag4)
            {
                flag2 = true;
            }
        }
        return flag2;
    }

    private void link(PMFragment pmfragment, int i, int j)
    {
        LoginManager.getInstance().logOut();
        fragment = pmfragment;
        savedCallingFragmentBundle = new Bundle();
        fragmentId = fragment.getFragmentId();
        fragment.getActivity().getSupportFragmentManager().putFragment(savedCallingFragmentBundle, fragmentId.toString(), fragment);
        ArrayList arraylist = new ArrayList();
        populatePermissionRequestList(arraylist, i, j);
        if ((i & 8) != 0)
        {
            LoginManager.getInstance().logInWithPublishPermissions(pmfragment.getActivity(), arraylist);
            return;
        } else
        {
            LoginManager.getInstance().logInWithReadPermissions(pmfragment.getActivity(), arraylist);
            return;
        }
    }

    private void populatePermissionRequestList(List list, int i, int j)
    {
        list.addAll(FBPermissionStates.getPermissionStringSet(j));
    }

    private void returnError(PMApiError pmapierror)
    {
        PMActivity pmactivity;
        pmactivity = PMApplication.getApplicationObject().getTopActivity();
        if (pmactivity == null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        fragment = (PMFragment)pmactivity.getSupportFragmentManager().getFragment(savedCallingFragmentBundle, fragmentId.toString());
        if (fragment != null)
        {
            Bundle bundle = new Bundle();
            bundle.putBoolean("HAS_ERROR", true);
            bundle.putString("ERROR_JSON", PMApiError.serialize(pmapierror));
            fragment.onFragmentResult(bundle, FB_REQUEST_FROM_PM_ACTIVITY);
        }
        return;
        pmapierror;
    }

    private void returnResult(int i, String s, String s1)
    {
        PMActivity pmactivity;
        pmactivity = PMApplication.getApplicationObject().getTopActivity();
        if (pmactivity == null)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        fragment = (PMFragment)pmactivity.getSupportFragmentManager().getFragment(savedCallingFragmentBundle, fragmentId.toString());
        if (fragment != null)
        {
            Bundle bundle = new Bundle();
            bundle.putBoolean("HAS_ERROR", false);
            bundle.putInt("ACCESS_LEVEL", i);
            bundle.putString("ACCESS_TOKEN", s);
            bundle.putString("FB_DATE", s1);
            fragment.onFragmentResult(bundle, FB_REQUEST_FROM_PM_ACTIVITY);
        }
        return;
        s;
    }

    public static void showFBLinkError(PMApiError pmapierror, PMFragment pmfragment)
    {
        showFBLinkError(pmapierror, pmfragment, com.poshmark.ui.model.ActionErrorContext.Severity.LOW);
    }

    public static void showFBLinkError(PMApiError pmapierror, PMFragment pmfragment, com.poshmark.ui.model.ActionErrorContext.Severity severity)
    {
label0:
        {
            if (pmfragment != null && pmfragment.isAdded())
            {
                if (pmapierror.pmErrorType != PMErrorType.EXTERNAL_ID_TAKEN_ERROR)
                {
                    break label0;
                }
                pmfragment.showError(new ActionErrorContext(pmapierror, com.poshmark.ui.model.ActionErrorContext.ActionContext.LINK_FACEBOOK, null, severity, null, pmfragment.getString(0x7f0600dc)));
            }
            return;
        }
        pmfragment.showError(new ActionErrorContext(pmapierror, com.poshmark.ui.model.ActionErrorContext.ActionContext.LINK_FACEBOOK, pmfragment.getString(0x7f0600db), severity));
    }

    public CallbackManager getCallbackManager()
    {
        return callbackManager;
    }

    public void getMe(final ExtServiceUserInfoInterface callback)
    {
        final AccessToken accessToken = AccessToken.getCurrentAccessToken();
        if (accessToken != null && accessToken.getToken() != null)
        {
            callback = GraphRequest.newMeRequest(accessToken, new com.facebook.GraphRequest.GraphJSONObjectCallback() {

                final FbHelper this$0;
                final AccessToken val$accessToken;
                final ExtServiceUserInfoInterface val$callback;

                public void onCompleted(JSONObject jsonobject, GraphResponse graphresponse)
                {
                    if (graphresponse.getError() == null)
                    {
                        jsonobject = (new GsonBuilder()).create();
                        graphresponse = graphresponse.getRawResponse();
                        String s;
                        Bundle bundle;
                        if (!(jsonobject instanceof Gson))
                        {
                            jsonobject = ((JSONObject) (jsonobject.fromJson(graphresponse, com/poshmark/data_model/models/FbUserInfo)));
                        } else
                        {
                            jsonobject = ((JSONObject) (GsonInstrumentation.fromJson((Gson)jsonobject, graphresponse, com/poshmark/data_model/models/FbUserInfo)));
                        }
                        jsonobject = (FbUserInfo)jsonobject;
                        graphresponse = accessToken.getToken();
                        s = DateUtils.getStringFromUTCDate(accessToken.getExpires());
                        bundle = new Bundle();
                        bundle.putString("TOKEN", graphresponse);
                        bundle.putString("EXPIRY_DATE", s);
                        bundle.putString("FIRST_NAME", ((FbUserInfo) (jsonobject)).first_name);
                        bundle.putString("LAST_NAME", ((FbUserInfo) (jsonobject)).last_name);
                        bundle.putString("EMAIL", ((FbUserInfo) (jsonobject)).email);
                        bundle.putString("HANDLE", ((FbUserInfo) (jsonobject)).name);
                        bundle.putString("USERID", ((FbUserInfo) (jsonobject)).id);
                        bundle.putBoolean("FB_SIGNUP", true);
                        callback.success(bundle);
                        return;
                    } else
                    {
                        jsonobject = new PMApiError(null, null, 200, PMErrorType.FB_LOGIN_ERROR);
                        callback.error(jsonobject);
                        return;
                    }
                }

            
            {
                this$0 = FbHelper.this;
                accessToken = accesstoken;
                callback = extserviceuserinfointerface;
                super();
            }
            });
            accessToken = new Bundle();
            accessToken.putString("fields", "id, email,name, first_name,last_name, link");
            callback.setParameters(accessToken);
            callback.executeAsync();
        }
    }

    public boolean isPermissionEnabled(String s)
    {
        boolean flag1 = false;
        AccessToken accesstoken = AccessToken.getCurrentAccessToken();
        boolean flag = flag1;
        if (accesstoken != null)
        {
            flag = flag1;
            if (accesstoken.getPermissions().contains(s))
            {
                flag = true;
            }
        }
        return flag;
    }

    public void link(PMFragment pmfragment, int i, int j, int k)
    {
        FB_REQUEST_FROM_PM_ACTIVITY = k;
        link(pmfragment, i, j);
    }

    public void link(PMFragment pmfragment, int i, int j, FBConnectCallback fbconnectcallback)
    {
        callback = fbconnectcallback;
        link(pmfragment, i, j);
    }

    public void linkWithPM(final String accessToken, final String formattedDate, final int currentGrantedPermissions)
    {
        fragment = getCurrentFragmentCaller();
        Log.d("FB_STATUS", "linkWithPM called");
        PMApi.fbLink(accessToken, formattedDate, new PMApiResponseHandler() {

            final FbHelper this$0;
            final String val$accessToken;
            final int val$currentGrantedPermissions;
            final String val$formattedDate;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                if (fragment != null && fragment.isAdded())
                {
                    fragment.hideProgressDialog();
                }
                if (!pmapiresponse.hasError())
                {
                    Log.d("FB_STATUS", "linkWithPM success");
                    pmapiresponse = (ExternalServiceInfo)pmapiresponse.data;
                    PMApplicationSession.GetPMSession().updateFacebookData(pmapiresponse);
                    if (callback != null)
                    {
                        callback.success(currentGrantedPermissions, accessToken, formattedDate);
                        return;
                    } else
                    {
                        returnResult(currentGrantedPermissions, accessToken, formattedDate);
                        return;
                    }
                }
                logout();
                if (callback != null)
                {
                    callback.error(pmapiresponse.apiError);
                    return;
                } else
                {
                    returnError(pmapiresponse.apiError);
                    return;
                }
            }

            
            {
                this$0 = FbHelper.this;
                currentGrantedPermissions = i;
                accessToken = s;
                formattedDate = s1;
                super();
            }
        });
    }

    public void logout()
    {
        LoginManager.getInstance().logOut();
    }

    public void refreshAndSyncFbTokenState()
    {
        if (AccessToken.getCurrentAccessToken() == null)
        {
            AccessToken accesstoken = createTokenFromPMData();
            if (accesstoken != null)
            {
                AccessToken.setCurrentAccessToken(accesstoken);
                handleTokenChange.set(true);
                AccessToken.refreshCurrentAccessTokenAsync();
            }
            return;
        } else
        {
            handleTokenChange.set(true);
            AccessToken.refreshCurrentAccessTokenAsync();
            return;
        }
    }

    static 
    {
        CALLING_CODE_BASEMENT = 2000;
        FB_CONNECT_FRIENDS_REQUEST = 800;
        FB_CONNECT_PUBLISH_REQUEST = 801;
        FB_CONNECT_READ_REQUEST = 802;
        FB_CONNECT_AUTO_TIMELINE_REQUEST = 803;
    }







}

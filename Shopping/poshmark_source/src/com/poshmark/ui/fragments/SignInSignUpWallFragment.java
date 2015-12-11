// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.config.Env;
import com.poshmark.config.EnvConfig;
import com.poshmark.data_model.models.PMErrorType;
import com.poshmark.fb_tmblr_twitter.ExtServiceUserInfoInterface;
import com.poshmark.fb_tmblr_twitter.FbHelper;
import com.poshmark.fb_tmblr_twitter.GooglePlusHelper;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiError;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.user.UserInfo;
import com.poshmark.utils.DeepLinkUtils;
import com.poshmark.utils.DeferredDeepLinkManager;
import com.poshmark.utils.FbDeferredDeepLinkManager;
import com.poshmark.utils.MetricsTrackingUtils;
import com.poshmark.utils.PMSetIPDialog;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, EmailLoginFragment, SignupFormFragment

public class SignInSignUpWallFragment extends PMFragment
{

    public static final int LOGIN_REQUEST = 1;
    public static final int SIGNIN_ACTIVITY_BACK_PRESSED = 2;
    Bundle fbDeferredDeepLink;
    Button fbLoginBtn;
    Button googleLoginBtn;
    Button signInBtn;
    Button signUpBtn;

    public SignInSignUpWallFragment()
    {
    }

    private void doFbLogin()
    {
        FbHelper.getInstance().link(this, 1, 7, FbHelper.FB_CONNECT_READ_REQUEST);
    }

    private void handleFbLoginResult(Bundle bundle)
    {
        if (bundle != null)
        {
            if (!bundle.getBoolean("HAS_ERROR", false))
            {
                int i = bundle.getInt("ACCESS_LEVEL", 0);
                String s = bundle.getString("ACCESS_TOKEN", null);
                bundle = bundle.getString("FB_DATE", null);
                if (s != null && bundle != null && (i & 1) == 1)
                {
                    fbLloginComplete(s, bundle);
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

    private void login(UserInfo userinfo)
    {
        PMApplicationSession.GetPMSession().saveSession(userinfo);
        PMNotificationManager.fireNotification("com.poshmark.intents.LOGIN_COMPLETE");
        Analytics.getInstance().trackEvent("login_screen", "user", "login", null);
        finishActivity();
    }

    private void setupButtonHandlers()
    {
        fbLoginBtn = (Button)getView().findViewById(0x7f0c02dc);
        fbLoginBtn.setOnClickListener(new android.view.View.OnClickListener() {

            final SignInSignUpWallFragment this$0;

            public void onClick(View view)
            {
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "fb_connect_click", null);
                doFbLogin();
            }

            
            {
                this$0 = SignInSignUpWallFragment.this;
                super();
            }
        });
        googleLoginBtn = (Button)getView().findViewById(0x7f0c02dd);
        googleLoginBtn.setOnClickListener(new android.view.View.OnClickListener() {

            final SignInSignUpWallFragment this$0;

            public void onClick(View view)
            {
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "gp_connect_click", null);
                GooglePlusHelper.getInstance().link(SignInSignUpWallFragment.this, new ExtServiceUserInfoInterface() {

                    final _cls3 this$1;

                    public void error(PMApiError pmapierror)
                    {
                        GooglePlusHelper.showGoogleLinkError(pmapierror, _fld0, com.poshmark.ui.model.ActionErrorContext.Severity.HIGH);
                    }

                    public void success(Bundle bundle)
                    {
                        googleLoginComplete(bundle);
                    }

            
            {
                this$1 = _cls3.this;
                super();
            }
                });
            }

            
            {
                this$0 = SignInSignUpWallFragment.this;
                super();
            }
        });
        signInBtn = (Button)getView().findViewById(0x7f0c02d8);
        signInBtn.setOnClickListener(new android.view.View.OnClickListener() {

            final SignInSignUpWallFragment this$0;

            public void onClick(View view)
            {
                view = (PMActivity)getActivity();
                if (view != null && view.isActivityInForeground())
                {
                    view.launchFragment(null, com/poshmark/ui/fragments/EmailLoginFragment, null);
                }
            }

            
            {
                this$0 = SignInSignUpWallFragment.this;
                super();
            }
        });
        signUpBtn = (Button)getView().findViewById(0x7f0c02d9);
        signUpBtn.setOnClickListener(new android.view.View.OnClickListener() {

            final SignInSignUpWallFragment this$0;

            public void onClick(View view)
            {
                ((PMActivity)getActivity()).launchFragment(null, com/poshmark/ui/fragments/SignupFormFragment, null);
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "email_signup_flow_initiated", null);
            }

            
            {
                this$0 = SignInSignUpWallFragment.this;
                super();
            }
        });
    }

    public void fbLloginComplete(String s, String s1)
    {
        if (isAdded())
        {
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "fb_connect_success", null);
            showProgressDialogWithMessage(getString(0x7f060190));
            HashMap hashmap = new HashMap();
            Object obj = DeepLinkUtils.getDeepLinkHash();
            if (((Map) (obj)).size() > 0)
            {
                hashmap.put("stack", MetricsTrackingUtils.getTrackingStackAsJson((Activity)getView().getContext()));
                Gson gson = (new GsonBuilder()).create();
                java.lang.reflect.Type type = (new TypeToken() {

                    final SignInSignUpWallFragment this$0;

            
            {
                this$0 = SignInSignUpWallFragment.this;
                super();
            }
                }).getType();
                if (!(gson instanceof Gson))
                {
                    obj = gson.toJson(obj, type);
                } else
                {
                    obj = GsonInstrumentation.toJson((Gson)gson, obj, type);
                }
                hashmap.put("deeplinks", obj);
            }
            PMApi.saveExternalServiceInfo("fb", s, s1, hashmap, new PMApiResponseHandler() {

                final SignInSignUpWallFragment this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    if (isAdded())
                    {
                        hideProgressDialog();
                        if (!pmapiresponse.hasError())
                        {
                            FbDeferredDeepLinkManager.INSTANCE.markAsExpired();
                            DeferredDeepLinkManager.INSTANCE.markAsExpired();
                            login((UserInfo)pmapiresponse.data);
                        } else
                        if (pmapiresponse.apiError.pmError != null && pmapiresponse.apiError.pmErrorType == PMErrorType.HTTP_NOT_FOUND)
                        {
                            Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "facebook_signup_flow_initiated", null);
                            showProgressDialogWithMessage(getString(0x7f060190));
                            FbHelper.getInstance().getMe(new ExtServiceUserInfoInterface() {

                                final _cls7 this$1;

                                public void error(PMApiError pmapierror)
                                {
                                    hideProgressDialog();
                                    showError(new ActionErrorContext(pmapierror, com.poshmark.ui.model.ActionErrorContext.ActionContext.USER_SIGNUP));
                                }

                                public void success(Bundle bundle)
                                {
                                    hideProgressDialog();
                                    PMActivity pmactivity = (PMActivity)getActivity();
                                    if (pmactivity != null && pmactivity.isActivityInForeground())
                                    {
                                        pmactivity.launchFragment(bundle, com/poshmark/ui/fragments/SignupFormFragment, null);
                                    }
                                }

            
            {
                this$1 = _cls7.this;
                super();
            }
                            });
                            return;
                        }
                    }
                }

            
            {
                this$0 = SignInSignUpWallFragment.this;
                super();
            }
            });
        }
    }

    public String getTrackingLabel()
    {
        return "nus";
    }

    public void googleLoginComplete(final Bundle googleLoginBundle)
    {
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "gp_connect_success", null);
        showProgressDialogWithMessage(getString(0x7f060190));
        PMApi.gpLogin(googleLoginBundle.getString("TOKEN"), new PMApiResponseHandler() {

            final SignInSignUpWallFragment this$0;
            final Bundle val$googleLoginBundle;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                if (isAdded())
                {
                    hideProgressDialog();
                    if (!pmapiresponse.hasError())
                    {
                        login((UserInfo)pmapiresponse.data);
                    } else
                    if (pmapiresponse.apiError.pmError != null && pmapiresponse.apiError.pmErrorType == PMErrorType.HTTP_NOT_FOUND)
                    {
                        Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "gp_signup_flow_initiated", null);
                        ((PMActivity)getActivity()).launchFragment(googleLoginBundle, com/poshmark/ui/fragments/SignupFormFragment, null);
                        return;
                    }
                }
            }

            
            {
                this$0 = SignInSignUpWallFragment.this;
                googleLoginBundle = bundle;
                super();
            }
        });
    }

    public boolean handleBack()
    {
        finishActivityWithResult(2, null);
        return true;
    }

    public void handleNotification(Intent intent)
    {
        if (intent.getAction().equals("com.poshmark.intents.PROFILE_UPDATED") && isAdded() && getView() != null)
        {
            setCustomBanner();
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setupButtonHandlers();
        setCustomBanner();
        if (EnvConfig.ENV == Env.DEV && "https://api.poshmark.com" == null)
        {
            (new PMSetIPDialog()).show(getFragmentManager(), "pmLoveDlg");
        }
    }

    public void onCreate(Bundle bundle)
    {
        bShouldHideActionBar = true;
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        return layoutinflater.inflate(0x7f0300bd, viewgroup, false);
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    public void onFragmentResult(Bundle bundle, int i)
    {
        if (i == FbHelper.FB_CONNECT_READ_REQUEST && isAdded())
        {
            handleFbLoginResult(bundle);
        }
    }

    public void onPMResume()
    {
        super.onPMResume();
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.PROFILE_UPDATED", this);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        PMNotificationManager.getNotificationManager().unregisterAllEvents(this);
    }

    public void setCustomBanner()
    {
        if (FbDeferredDeepLinkManager.INSTANCE.getCurrentDeepLinkProcessingState() == com.poshmark.utils.FbDeferredDeepLinkManager.DL_STATE.DL_RECEIVED)
        {
            String s = FbDeferredDeepLinkManager.INSTANCE.getImageUrl();
            if (s != null)
            {
                ImageLoader.getInstance().loadImage(s, new ImageLoadingListener() {

                    final SignInSignUpWallFragment this$0;

                    public void onLoadingCancelled(String s1, View view)
                    {
                    }

                    public void onLoadingComplete(String s1, View view, Bitmap bitmap)
                    {
                        ((ImageView)getView().findViewById(0x7f0c02d7)).setImageBitmap(bitmap);
                        replaceTrackingLabel("nus_dl");
                        s1 = new HashMap();
                        s1.put("ev", "fbdl");
                        s1.put("s", "dlrc");
                        s1.put("lrf", FbDeferredDeepLinkManager.INSTANCE.getDeepLinkUrl());
                        PMApi.trackDeepLink(s1);
                    }

                    public void onLoadingFailed(String s1, View view, FailReason failreason)
                    {
                    }

                    public void onLoadingStarted(String s1, View view)
                    {
                    }

            
            {
                this$0 = SignInSignUpWallFragment.this;
                super();
            }
                });
            }
        }
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "login_screen";
    }


}

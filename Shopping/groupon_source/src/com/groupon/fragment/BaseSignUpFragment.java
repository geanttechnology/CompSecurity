// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;
import com.f2prateek.dart.Dart;
import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.Plus;
import com.groupon.Channel;
import com.groupon.abtest.GoogleSignInAbTestHelper;
import com.groupon.abtest.NewCartAbTestHelper;
import com.groupon.activity.FacebookAppUtils;
import com.groupon.activity.Login;
import com.groupon.callbacks.GoogleServerAuthHandler;
import com.groupon.models.country.Country;
import com.groupon.network.HttpResponseException;
import com.groupon.service.LoginService;
import com.groupon.service.ShoppingCartService;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.googlesmartlock.GoogleSmartLockService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.CountryUtil;
import com.groupon.util.DialogManager;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.GoogleSignInCallbacks;
import com.groupon.util.LoginUtil;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.inject.Lazy;
import roboguice.util.Ln;
import roboguice.util.Strings;

public class BaseSignUpFragment extends Fragment
    implements com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener, GoogleSignInCallbacks
{

    private static final String GOOGLE_WEB_CLIENT_ID = "169314272487.apps.googleusercontent.com";
    private static final String SCOPE_EMAIL = "email";
    public static final String TRACKING_VALUES_GOOGLE_LOG_IN_BUTTON = "google_login_button";
    public static final String TRACKING_VALUES_GOOGLE_LOG_IN_CLICK = "google_login_click";
    public static final String TRACKING_VALUES_GOOGLE_SIGN_UP_BUTTON = "google_signup_button";
    public static final String TRACKING_VALUES_GOOGLE_SIGN_UP_CLICK = "google_signup_click";
    protected String GOOGLE_SMARTLOCK_AUTOMATICALLY_LOGIN_ALREADY_PERFORMED_EXTRA_KEY;
    protected String TRACKING_VALUES_SMARTLOCK_TRIGGER;
    protected String TRACKING_VALUES_SMARTLOCK_TRIGGER_ONBOARDING;
    protected String TRACKING_VALUES_SMARTLOCK_TRIGGER_ORGANIC;
    protected String TRACKING_VALUES_SMARTLOCK_TRIGGER_PURCHASE;
    protected AbTestService abTestService;
    private Context applicationContext;
    protected CallbackManager callbackManager;
    protected NewCartAbTestHelper cartAbTestHelper;
    Channel channel;
    protected CountryUtil countryUtil;
    protected CurrentCountryManager currentCountryManager;
    protected DialogManager dialogManager;
    protected FacebookAppUtils facebookAppUtils;
    private GoogleApiClient googleApiClient;
    private GoogleServerAuthHandler googleServerAuthHandler;
    protected GoogleSignInAbTestHelper googleSignInAbTestHelper;
    protected GoogleSmartLockService googleSmartLockService;
    protected Handler handler;
    Boolean isComingFromCheckout;
    boolean isComingFromOnboarding;
    protected boolean isGoogleSmartLock1511;
    private boolean isResolvingGoogleConnectionFailure;
    protected Logger logger;
    protected LoginService loginService;
    protected LoginUtil loginUtil;
    protected ShoppingCartService shoppingCartService;
    private boolean shouldResolveGoogleConnectionFailure;
    protected String trigger;

    public BaseSignUpFragment()
    {
        isComingFromCheckout = Boolean.valueOf(false);
        TRACKING_VALUES_SMARTLOCK_TRIGGER = "LogIn Flow %s";
        TRACKING_VALUES_SMARTLOCK_TRIGGER_ONBOARDING = "Onboarding";
        TRACKING_VALUES_SMARTLOCK_TRIGGER_PURCHASE = "PurchaseFunnel";
        TRACKING_VALUES_SMARTLOCK_TRIGGER_ORGANIC = "Organic";
        GOOGLE_SMARTLOCK_AUTOMATICALLY_LOGIN_ALREADY_PERFORMED_EXTRA_KEY = "is_google_smartlock_already_performed";
        shouldResolveGoogleConnectionFailure = false;
        isResolvingGoogleConnectionFailure = false;
    }

    private GoogleApiClient buildGoogleApiClient()
    {
        return (new com.google.android.gms.common.api.GoogleApiClient.Builder(getActivity())).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(Plus.API).addScope(new Scope("profile")).addScope(new Scope("email")).requestServerAuthCode("169314272487.apps.googleusercontent.com", googleServerAuthHandler).build();
    }

    private void resolveSignInError(ConnectionResult connectionresult)
    {
        if (isAdded() && connectionresult.hasResolution())
        {
            Ln.d("Google sign in: resolving signin Error", new Object[0]);
            try
            {
                connectionresult.startResolutionForResult(getActivity(), getGoogleSignInRequestCode());
                isResolvingGoogleConnectionFailure = true;
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ConnectionResult connectionresult)
            {
                Ln.e("Sign in intent could not be sent.", new Object[] {
                    connectionresult
                });
            }
            googleApiClient.connect();
            return;
        } else
        {
            Ln.d("Google sign in: no resolution from google", new Object[0]);
            googleCleanUp();
            handler.post(new Runnable() {

                final BaseSignUpFragment this$0;

                public void run()
                {
                    Toast.makeText(applicationContext, 0x7f080164, 0).show();
                }

            
            {
                this$0 = BaseSignUpFragment.this;
                super();
            }
            });
            return;
        }
    }

    protected void facebookCleanUp()
    {
    }

    public void fbRequestNewReadPermission()
    {
        loginService.getFacebookLoginSubservice(getActivity()).requestNewReadPermissions(callbackManager, new Function0() {

            final BaseSignUpFragment this$0;

            public void execute()
            {
                onFbSuccess();
            }

            
            {
                this$0 = BaseSignUpFragment.this;
                super();
            }
        }, new Function0() {

            final BaseSignUpFragment this$0;

            public void execute()
            {
                onFbCancel();
            }

            
            {
                this$0 = BaseSignUpFragment.this;
                super();
            }
        }, new Function1() {

            final BaseSignUpFragment this$0;

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((Throwable)obj);
            }

            public void execute(Throwable throwable)
            {
                onFbException(throwable);
            }

            
            {
                this$0 = BaseSignUpFragment.this;
                super();
            }
        });
    }

    public void fbSignUp()
    {
        loginService.getFacebookLoginSubservice(getActivity()).login(callbackManager, new Function0() {

            final BaseSignUpFragment this$0;

            public void execute()
            {
                onFbSuccess();
            }

            
            {
                this$0 = BaseSignUpFragment.this;
                super();
            }
        }, new Function0() {

            final BaseSignUpFragment this$0;

            public void execute()
            {
                onFbCancel();
            }

            
            {
                this$0 = BaseSignUpFragment.this;
                super();
            }
        }, new Function1() {

            final BaseSignUpFragment this$0;

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((Throwable)obj);
            }

            public void execute(Throwable throwable)
            {
                onFbException(throwable);
            }

            
            {
                this$0 = BaseSignUpFragment.this;
                super();
            }
        });
    }

    public int getGoogleSignInRequestCode()
    {
        return 40000;
    }

    protected Login getLoginRedesign()
    {
        return (Login)getActivity();
    }

    protected void getShoppingCartItems()
    {
        if (currentCountryManager.getCurrentCountry().isUSACompatible() && cartAbTestHelper.isShoppingCartEnabled())
        {
            shoppingCartService.refreshCachedCart();
        }
    }

    protected void googleCleanUp()
    {
        if (googleApiClient.isConnected())
        {
            Plus.AccountApi.clearDefaultAccount(googleApiClient);
        }
        googleApiClient.disconnect();
    }

    public void googleSignUp()
    {
        Ln.d("Google sign in: googleSignUp", new Object[0]);
        if (!googleApiClient.isConnecting())
        {
            googleServerAuthHandler.setGoogleSignInCallbacks(this);
            shouldResolveGoogleConnectionFailure = true;
            googleApiClient.connect();
        }
    }

    protected void handleAuthenticationError()
    {
        dialogManager.showAlertDialog(null, Integer.valueOf(0x7f0804db), Integer.valueOf(0x7f080336), new android.content.DialogInterface.OnClickListener() {

            final BaseSignUpFragment this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                fbRequestNewReadPermission();
            }

            
            {
                this$0 = BaseSignUpFragment.this;
                super();
            }
        }, Integer.valueOf(0x7f080084), new android.content.DialogInterface.OnClickListener() {

            final BaseSignUpFragment this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                onFbCancel();
            }

            
            {
                this$0 = BaseSignUpFragment.this;
                super();
            }
        }, false, true);
    }

    protected boolean isFacebookAuthenticationIssue(HttpResponseException httpresponseexception)
    {
        return httpresponseexception.getStatusCode() == 401 && httpresponseexception.getMessage().contains("oauth/facebook_authenticate") && loginService.getFacebookLoginSubservice(getActivity()).shouldRequestNewReadPermissionsForCredentials();
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        RoboGuice.getInjector(getActivity()).injectMembers(this);
        Dart.inject(this);
        googleServerAuthHandler = new GoogleServerAuthHandler(getActivity());
        googleApiClient = buildGoogleApiClient();
        isGoogleSmartLock1511 = abTestService.isVariantEnabled("googleSmartLock1511", "On");
        if (!isGoogleSmartLock1511) goto _L2; else goto _L1
_L1:
        googleSmartLockService = (GoogleSmartLockService)(new Lazy(getActivity()) {

            final BaseSignUpFragment this$0;

            
            {
                this$0 = BaseSignUpFragment.this;
                super(context);
            }
        }).get();
        googleSmartLockService.setActivityForCallback(getActivity());
        bundle = TRACKING_VALUES_SMARTLOCK_TRIGGER_ORGANIC;
        if (!isComingFromCheckout.booleanValue()) goto _L4; else goto _L3
_L3:
        bundle = TRACKING_VALUES_SMARTLOCK_TRIGGER_PURCHASE;
_L6:
        trigger = String.format(TRACKING_VALUES_SMARTLOCK_TRIGGER, new Object[] {
            bundle
        });
_L2:
        applicationContext = getActivity().getApplicationContext();
        return;
_L4:
        if (isComingFromOnboarding)
        {
            bundle = TRACKING_VALUES_SMARTLOCK_TRIGGER_ONBOARDING;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        callbackManager.onActivityResult(i, j, intent);
        if (i == 40000 || i == 40001)
        {
            boolean flag;
            if (j == -1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            shouldResolveGoogleConnectionFailure = flag;
            isResolvingGoogleConnectionFailure = false;
            if (!googleApiClient.isConnecting())
            {
                googleApiClient.connect();
            }
        }
    }

    public void onConnected(Bundle bundle)
    {
        Ln.d("Google sign in: Connected to google", new Object[0]);
        shouldResolveGoogleConnectionFailure = false;
        isResolvingGoogleConnectionFailure = false;
    }

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        Ln.d("Google Sign in: Connection failed.", new Object[0]);
        if (!isResolvingGoogleConnectionFailure && shouldResolveGoogleConnectionFailure)
        {
            resolveSignInError(connectionresult);
            return;
        } else
        {
            googleCleanUp();
            isResolvingGoogleConnectionFailure = false;
            shouldResolveGoogleConnectionFailure = false;
            return;
        }
    }

    public void onConnectionSuspended(int i)
    {
        Ln.d("Google sign in: Connection suspended, reconnecting", new Object[0]);
        onGoogleSignInCancel();
        googleApiClient.connect();
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (googleSmartLockService != null)
        {
            googleSmartLockService.resetCallbacks();
        }
    }

    protected void onFbCancel()
        throws RuntimeException
    {
        facebookCleanUp();
        LoginManager.getInstance().logOut();
    }

    protected void onFbException(Throwable throwable)
        throws RuntimeException
    {
        facebookCleanUp();
        if ((throwable instanceof HttpResponseException) && isFacebookAuthenticationIssue((HttpResponseException)throwable))
        {
            handler.post(new Runnable() {

                final BaseSignUpFragment this$0;

                public void run()
                {
                    handleAuthenticationError();
                }

            
            {
                this$0 = BaseSignUpFragment.this;
                super();
            }
            });
            return;
        } else
        {
            LoginManager.getInstance().logOut();
            handler.post(new Runnable() {

                final BaseSignUpFragment this$0;

                public void run()
                {
                    Toast.makeText(getActivity().getApplicationContext(), getString(0x7f08017d, new Object[] {
                        countryUtil.getDisplayNameByIsoName(currentCountryManager.getCurrentCountry())
                    }), 1).show();
                }

            
            {
                this$0 = BaseSignUpFragment.this;
                super();
            }
            });
            return;
        }
    }

    protected void onFbSuccess()
    {
        Intent intent = getLoginRedesign().getNext();
        String s;
        if (intent != null)
        {
            s = intent.getStringExtra("flow");
        } else
        {
            s = "";
        }
        if (Strings.equals(s, "checkout"))
        {
            String s1;
            Logger logger1;
            if (intent != null && intent.hasExtra("dealId"))
            {
                s = intent.getStringExtra("dealId");
            } else
            {
                s = "";
            }
            logger.logClick("", "facebook_signin_click", "checkout", s);
            logger1 = logger;
            if (Strings.notEmpty(s))
            {
                s1 = "purchase_flow";
            } else
            {
                s1 = "other";
            }
            logger1.logLogin("", s1, s, Logger.NULL_NST_FIELD);
        }
        getActivity().setResult(-1);
        getShoppingCartItems();
        facebookCleanUp();
        loginUtil.startNextActivity(intent);
        getActivity().finish();
    }

    public void onGoogleSignInCancel()
        throws RuntimeException
    {
        Ln.d("Google sign in: onGoogleSignInCancel", new Object[0]);
        googleCleanUp();
    }

    public void onGoogleSignInException(Throwable throwable)
        throws RuntimeException
    {
        Ln.d("Google sign in: onGoogleSignInException", new Object[0]);
        handler.post(new Runnable() {

            final BaseSignUpFragment this$0;

            public void run()
            {
                Toast.makeText(getActivity().getApplicationContext(), 0x7f080215, 0).show();
            }

            
            {
                this$0 = BaseSignUpFragment.this;
                super();
            }
        });
        googleCleanUp();
    }

    public void onGoogleSignInSuccess()
    {
        Intent intent = getLoginRedesign().getNext();
        String s;
        if (intent != null)
        {
            s = intent.getStringExtra("flow");
        } else
        {
            s = "";
        }
        if (Strings.equals(s, "checkout"))
        {
            String s1;
            Logger logger1;
            if (intent != null && intent.hasExtra("dealId"))
            {
                s = intent.getStringExtra("dealId");
            } else
            {
                s = "";
            }
            logger.logClick("", "google_login_click", "checkout", s);
            logger1 = logger;
            if (Strings.notEmpty(s))
            {
                s1 = "purchase_flow";
            } else
            {
                s1 = "other";
            }
            logger1.logLogin("", s1, s, Logger.NULL_NST_FIELD);
        }
        saveGoogleExperience();
        getActivity().setResult(-1);
        getShoppingCartItems();
        googleCleanUp();
        loginUtil.startNextActivity(intent);
        getActivity().finish();
    }

    public void onStart()
    {
        super.onStart();
    }

    public void onStop()
    {
        super.onStop();
        googleApiClient.disconnect();
    }

    protected void saveGoogleExperience()
    {
        if (googleSignInAbTestHelper.isGoogleLoginUSCA1508Enabled())
        {
            AbTestService abtestservice = abTestService;
            String s;
            if (googleSignInAbTestHelper.isGoogleLoginUSCA1508Top())
            {
                s = "Top_Google";
            } else
            {
                s = "Bottom_Google";
            }
            abtestservice.setOverride("previous_googleLoginUSCA1508", s);
        }
    }

    public void setCallbackManager(CallbackManager callbackmanager)
    {
        callbackManager = callbackmanager;
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import android.provider.SearchRecentSuggestions;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.Toast;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.inject.Provider;
import com.groupon.db.ClearDealsRunnable;
import com.groupon.db.dao.DaoDealSummary;
import com.groupon.db.dao.DaoMyGrouponItem;
import com.groupon.db.dao.DaoMyGrouponItemSummary;
import com.groupon.db.dao.DaoPagination;
import com.groupon.dogfood.DogfoodHelper;
import com.groupon.http.GrouponOkHttpClient;
import com.groupon.models.country.Country;
import com.groupon.models.signup.SignupResponse;
import com.groupon.network.HttpResponseException;
import com.groupon.service.core.CoreServicesInitializer;
import com.groupon.service.core.UserManager;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.sso.SSOHelper;
import com.groupon.sso.UserCredential;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.CheckedFunction0;
import com.groupon.util.CountryUtil;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.GoogleNowAuthAlarmUtil;
import com.groupon.util.IncentivesUtil;
import com.groupon.util.VolatileBillingInfoProvider;
import com.groupon.util.VolatileTravelerNameProvider;
import com.squareup.okhttp.Cache;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.inject.Lazy;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.service:
//            ConfigurationChangedProvider, SignUpService, ShippingService

public class LoginService
    implements ConfigurationChangedProvider
{
    public static class ClearMyGrouponsRunnable extends Thread
    {

        private DaoMyGrouponItem daoMyGrouponItem;
        private DaoMyGrouponItemSummary daoMyGrouponItemSummary;
        private DaoPagination daoPagination;

        private List getGrouponCategoriesList()
        {
            return Arrays.asList(new String[] {
                "available_groupons", "expiring_groupons", "nearby_groupons", "all_groupons"
            });
        }

        public void run()
        {
            try
            {
                daoMyGrouponItem.clearAll();
                daoMyGrouponItemSummary.clearAll();
                daoPagination.deleteByChannelIds(getGrouponCategoriesList());
                return;
            }
            catch (Exception exception)
            {
                Ln.w(exception);
            }
        }

        public ClearMyGrouponsRunnable(DaoMyGrouponItem daomygrouponitem, DaoMyGrouponItemSummary daomygrouponitemsummary, DaoPagination daopagination)
        {
            daoMyGrouponItem = daomygrouponitem;
            daoMyGrouponItemSummary = daomygrouponitemsummary;
            daoPagination = daopagination;
        }
    }

    public static class FacebookLoginSubservice
    {

        private Context context;
        private Handler handler;
        private Provider logger;
        private ArraySharedPreferences loginPrefs;
        private UserManager userManager;

        private void exchangeFacebookToken(AccessToken accesstoken, CheckedFunction0 checkedfunction0, Function0 function0, Function1 function1)
        {
            accesstoken = "https:/oauth/facebook_authenticate". new SignUpService(new Object[] {
                "facebook_access_token", accesstoken.getToken()
            }, checkedfunction0, function1) {

                final FacebookLoginSubservice this$0;
                final Function1 val$onException;
                final CheckedFunction0 val$onSuccess;

                public void onException(Exception exception)
                {
                    if (onException != null && (exception instanceof HttpResponseException) && ((HttpResponseException)exception).getStatusCode() == 401)
                    {
                        onException.execute(exception);
                        return;
                    } else
                    {
                        super.onException(exception);
                        return;
                    }
                }

                protected void onSuccess(SignupResponse signupresponse)
                    throws Exception
                {
                    Ln.d("FACEBOOK: onSuccess /oauth/facebook_authenticate", new Object[0]);
                    userManager.updateUserDetails(signupresponse.user);
                    LoginService.setAccessToken(loginPrefs.edit(), signupresponse.accessToken).apply();
                    ((Logger)logger.get()).forceLogRotate();
                    if (onSuccess != null)
                    {
                        onSuccess.execute();
                    }
                }

            transient 
            {
                this$0 = final_facebookloginsubservice;
                onSuccess = checkedfunction0;
                onException = function1;
                super(final_context, String.this, aobj);
            }
            };
            accesstoken.method("POST");
            accesstoken.handler(handler);
            accesstoken.execute();
        }

        private void executeLoginRequest(CallbackManager callbackmanager, final Function0 onSuccess, final Function0 onCancel, Function1 function1)
        {
            LoginManager.getInstance().registerCallback(callbackmanager, function1. new FacebookCallback() {

                final FacebookLoginSubservice this$0;
                final Function0 val$onCancel;
                final Function1 val$onException;
                final Function0 val$onSuccess;

                public void onCancel()
                {
                    Ln.d("FACEBOOK: login CANCEL", new Object[0]);
                    onCancel.execute();
                }

                public void onError(FacebookException facebookexception)
                {
                    Ln.d("FACEBOOK: login ERROR", new Object[0]);
                    onException.execute(facebookexception);
                }

                public void onSuccess(LoginResult loginresult)
                {
                    Ln.d("FACEBOOK: login SUCCESS", new Object[0]);
                    loginresult = loginresult.getAccessToken();
                    exchangeFacebookToken(loginresult, onSuccess, onCancel, onException);
                }

                public volatile void onSuccess(Object obj)
                {
                    onSuccess((LoginResult)obj);
                }

            
            {
                this$0 = final_facebookloginsubservice;
                onSuccess = function0;
                onCancel = function0_1;
                onException = Function1.this;
                super();
            }
            });
            callbackmanager = new ArrayList(Arrays.asList(context.getResources().getStringArray(0x7f0f0009)));
            LoginManager.getInstance().logInWithReadPermissions((Activity)context, callbackmanager);
        }

        public void login(CallbackManager callbackmanager, Function0 function0, Function0 function0_1, Function1 function1)
        {
            AccessToken accesstoken = AccessToken.getCurrentAccessToken();
            if (accesstoken == null)
            {
                executeLoginRequest(callbackmanager, function0, function0_1, function1);
                return;
            } else
            {
                exchangeFacebookToken(accesstoken, function0, function0_1, function1);
                return;
            }
        }

        public void requestNewReadPermissions(CallbackManager callbackmanager, Function0 function0, Function0 function0_1, Function1 function1)
        {
            if (AccessToken.getCurrentAccessToken() != null)
            {
                executeLoginRequest(callbackmanager, function0, function0_1, function1);
            }
        }

        public boolean shouldRequestNewReadPermissionsForCredentials()
        {
            AccessToken accesstoken = AccessToken.getCurrentAccessToken();
            if (accesstoken != null)
            {
                return accesstoken.getDeclinedPermissions().contains("email");
            } else
            {
                return false;
            }
        }





        public FacebookLoginSubservice()
        {
        }
    }


    private static AtomicInteger RELOGIN_ATTEMPTS = new AtomicInteger();
    public static final String SHOULD_REFRESH_DEALS_AFTER_LOGIN = "should_refresh_deals_after_login";
    protected static final ThreadPoolExecutor THREAD_POOL_EXECUTOR;
    private Application application;
    private Lazy billingInfo;
    private ArraySharedPreferences cookiePrefs;
    private CurrentCountryManager currentCountryManager;
    private Lazy daoDealSummary;
    private Lazy daoGrouponItem;
    private Lazy daoGrouponItemSummary;
    private Lazy daoPagination;
    private DogfoodHelper dogfoodHelper;
    private Lazy googleNowAuthAlarmUtil;
    private Lazy grouponOkHttpClient;
    private Lazy incentivesUtil;
    private Lazy logger;
    private ArraySharedPreferences loginPrefs;
    private String referrer;
    private Lazy serviceInitializer;
    private Lazy travelerNameProvider;
    private Lazy userManager;

    public LoginService()
    {
    }

    private void clearCookies()
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            clearCookiesLollipop();
            return;
        } else
        {
            CookieSyncManager cookiesyncmanager = CookieSyncManager.createInstance(application);
            cookiesyncmanager.startSync();
            CookieManager.getInstance().removeAllCookie();
            cookiesyncmanager.stopSync();
            return;
        }
    }

    public static android.content.SharedPreferences.Editor setAccessToken(android.content.SharedPreferences.Editor editor, String s)
    {
        editor.putString("accessToken", s);
        editor.putLong("accessTokenConfigured", System.currentTimeMillis());
        return editor;
    }

    public void clearAuthToken()
    {
        setAccessToken(loginPrefs.edit(), "").apply();
    }

    protected void clearCookiesLollipop()
    {
        CookieManager.getInstance().removeAllCookies(null);
    }

    public String getAccessToken()
    {
        return loginPrefs.getString("accessToken", null);
    }

    public Serializable getConfigurationState()
    {
        return Long.valueOf(loginPrefs.getLong("accessTokenConfigured", 0L));
    }

    public String getConsumerId()
    {
        return loginPrefs.getString("consumerId", null);
    }

    public String getEmail()
    {
        return ((UserManager)userManager.get()).getPrimaryEmailAddress();
    }

    public FacebookLoginSubservice getFacebookLoginSubservice(Activity activity)
    {
        return (FacebookLoginSubservice)RoboGuice.getInjector(activity).getInstance(com/groupon/service/LoginService$FacebookLoginSubservice);
    }

    public String getFirstName()
    {
        if (isLoggedIn())
        {
            return loginPrefs.getString("firstName", "");
        } else
        {
            return null;
        }
    }

    public String getFormattedGBucksAmount()
    {
        if (isLoggedIn())
        {
            return loginPrefs.getString("formattedAmount", "");
        } else
        {
            return null;
        }
    }

    public String getFullName()
    {
        if (isLoggedIn())
        {
            StringBuilder stringbuilder = new StringBuilder();
            ArraySharedPreferences arraysharedpreferences = loginPrefs;
            String s;
            if (currentCountryManager.getCurrentCountry().isJapan())
            {
                s = "lastName";
            } else
            {
                s = "firstName";
            }
            stringbuilder = stringbuilder.append(arraysharedpreferences.getString(s, "")).append(" ");
            arraysharedpreferences = loginPrefs;
            if (currentCountryManager.getCurrentCountry().isJapan())
            {
                s = "firstName";
            } else
            {
                s = "lastName";
            }
            return stringbuilder.append(arraysharedpreferences.getString(s, "")).toString().trim();
        } else
        {
            return null;
        }
    }

    public Integer getGBucksAmount()
    {
        if (isLoggedIn())
        {
            return Integer.valueOf(loginPrefs.getInt("amount", 0));
        } else
        {
            return null;
        }
    }

    public String getLastName()
    {
        if (isLoggedIn())
        {
            return loginPrefs.getString("lastName", "");
        } else
        {
            return null;
        }
    }

    public String getUserId()
    {
        return loginPrefs.getString("userId", null);
    }

    public String getUsername()
    {
        UserCredential usercredential = SSOHelper.getAppAccount(application, currentCountryManager.getCurrentCountry().isoName);
        if (usercredential != null)
        {
            return usercredential.getUsername();
        } else
        {
            return null;
        }
    }

    public boolean hasAccessToken()
    {
        return Strings.notEmpty(loginPrefs.getString("accessToken", null));
    }

    public boolean hasFacebookSession()
    {
        AccessToken accesstoken = AccessToken.getCurrentAccessToken();
        if (accesstoken != null)
        {
            long l = accesstoken.getExpires().getTime();
            if (accesstoken.getToken() != null && (l == 0L || System.currentTimeMillis() < l))
            {
                return true;
            }
        }
        return false;
    }

    public boolean hasGoogleIdToken()
    {
        return Strings.notEmpty(loginPrefs.getString("googleIdToken", null));
    }

    public void init()
    {
        daoGrouponItem = new Lazy(application) {

            final LoginService this$0;

            
            {
                this$0 = LoginService.this;
                super(context);
            }
        };
        daoGrouponItemSummary = new Lazy(application) {

            final LoginService this$0;

            
            {
                this$0 = LoginService.this;
                super(context);
            }
        };
        daoPagination = new Lazy(application) {

            final LoginService this$0;

            
            {
                this$0 = LoginService.this;
                super(context);
            }
        };
        daoDealSummary = new Lazy(application) {

            final LoginService this$0;

            
            {
                this$0 = LoginService.this;
                super(context);
            }
        };
        userManager = new Lazy(application) {

            final LoginService this$0;

            
            {
                this$0 = LoginService.this;
                super(context);
            }
        };
        billingInfo = new Lazy(application) {

            final LoginService this$0;

            
            {
                this$0 = LoginService.this;
                super(context);
            }
        };
        logger = new Lazy(application) {

            final LoginService this$0;

            
            {
                this$0 = LoginService.this;
                super(context);
            }
        };
        travelerNameProvider = new Lazy(application) {

            final LoginService this$0;

            
            {
                this$0 = LoginService.this;
                super(context);
            }
        };
        serviceInitializer = new Lazy(application) {

            final LoginService this$0;

            
            {
                this$0 = LoginService.this;
                super(context);
            }
        };
        incentivesUtil = new Lazy(application) {

            final LoginService this$0;

            
            {
                this$0 = LoginService.this;
                super(context);
            }
        };
        grouponOkHttpClient = new Lazy(application) {

            final LoginService this$0;

            
            {
                this$0 = LoginService.this;
                super(context);
            }
        };
        googleNowAuthAlarmUtil = new Lazy(application) {

            final LoginService this$0;

            
            {
                this$0 = LoginService.this;
                super(context);
            }
        };
    }

    public boolean isLoggedIn()
    {
        return isLoggedInViaFacebook() || isLoggedInViaEmail() || isLoggedInViaGoogle();
    }

    public boolean isLoggedInViaEmail()
    {
        Object obj = currentCountryManager.getCurrentCountry();
        if (obj != null)
        {
            if ((obj = SSOHelper.getAppAccount(application, ((Country) (obj)).isoName)) != null && Strings.notEmpty(((UserCredential) (obj)).getUsername()) && Strings.notEmpty(((UserCredential) (obj)).getPassword()) && Strings.notEmpty(loginPrefs.getString("accessToken", null)))
            {
                return true;
            }
        }
        return false;
    }

    public boolean isLoggedInViaFacebook()
    {
        return hasAccessToken() && hasFacebookSession();
    }

    public boolean isLoggedInViaGoogle()
    {
        return hasAccessToken() && hasGoogleIdToken();
    }

    public void login(String s, String s1, CheckedFunction0 checkedfunction0)
    {
        login(s, s1, checkedfunction0, null, null);
    }

    public void login(String s, String s1, CheckedFunction0 checkedfunction0, Function1 function1, Function0 function0)
    {
        ((CoreServicesInitializer)serviceInitializer.get()).resetAllServicesToNotUpToDate(new Class[0]);
        s = new SignUpService(checkedfunction0, function1, function0) {

            final LoginService this$0;
            final Function1 val$onException;
            final Function0 val$onFinally;
            final CheckedFunction0 val$onSuccess;
            final String val$password;
            final String val$username;

            protected void onException(Exception exception)
            {
                if (onException != null)
                {
                    onException.execute(exception);
                    return;
                }
                if ((exception instanceof HttpResponseException) && ((HttpResponseException)exception).getStatusCode() == 401)
                {
                    Toast.makeText(application, String.format(application.getString(0x7f08017d), new Object[] {
                        countryUtil.getDisplayNameByIsoName(currentCountryManager.getCurrentCountry())
                    }), 0).show();
                    return;
                } else
                {
                    super.onException(exception);
                    return;
                }
            }

            protected void onFinally()
            {
                if (onFinally == null)
                {
                    super.onFinally();
                    return;
                } else
                {
                    onFinally.execute();
                    return;
                }
            }

            protected void onSuccess(SignupResponse signupresponse)
                throws Exception
            {
                UserCredential usercredential = new UserCredential(username, password, currentCountryManager.getCurrentCountry().isoName, username);
                SSOHelper.addOrUpdateAccountForApp(application, usercredential);
                ((UserManager)userManager.get()).updateUserDetails(signupresponse.user);
                dogfoodHelper.logEmailAddress();
                LoginService.setAccessToken(loginPrefs.edit(), signupresponse.accessToken).apply();
                prefs.edit().putBoolean("hasLoggedInAtleastOnce", true).apply();
                ((Logger)logger.get()).forceLogRotate();
                LoginService.RELOGIN_ATTEMPTS.set(0);
                loginPrefs.edit().putBoolean("should_refresh_deals_after_login", true).apply();
                if (onSuccess != null)
                {
                    onSuccess.execute();
                    return;
                } else
                {
                    super.onSuccess(signupresponse);
                    return;
                }
            }

            transient 
            {
                this$0 = LoginService.this;
                username = s1;
                password = s2;
                onSuccess = checkedfunction0;
                onException = function1;
                onFinally = function0;
                super(final_context, final_s, final_aobj);
            }
        };
        s.method("POST");
        s.execute();
    }

    public void logout()
    {
        ((GoogleNowAuthAlarmUtil)googleNowAuthAlarmUtil.get()).cancelAlarmIfSet();
        clearCookies();
        ((CoreServicesInitializer)serviceInitializer.get()).resetAllServicesToNotUpToDate(new Class[0]);
        ((VolatileBillingInfoProvider)billingInfo.get()).clear();
        ((ShippingService)RoboGuice.getInjector(application).getInstance(com/groupon/service/ShippingService)).clearStore();
        Cache cache = ((GrouponOkHttpClient)grouponOkHttpClient.get()).getCache();
        if (cache != null)
        {
            try
            {
                cache.evictAll();
            }
            catch (IOException ioexception)
            {
                Ln.e(ioexception);
            }
        }
        ((VolatileTravelerNameProvider)travelerNameProvider.get()).clear();
        RELOGIN_ATTEMPTS.set(0);
        loginPrefs.edit().clear().apply();
        SSOHelper.deleteAccountForApp(application);
        (new SearchRecentSuggestions(application, "com.groupon.recent.locations.authority", 3)).clearHistory();
        if (FacebookSdk.isInitialized())
        {
            LoginManager.getInstance().logOut();
        }
        cookiePrefs.edit().remove("_thepoint").apply();
        if (((IncentivesUtil)incentivesUtil.get()).isExperimentEnabled())
        {
            THREAD_POOL_EXECUTOR.execute(new ClearDealsRunnable((DaoDealSummary)daoDealSummary.get()));
        } else
        {
            loginPrefs.edit().putBoolean("should_refresh_deals_after_login", true).apply();
        }
        THREAD_POOL_EXECUTOR.execute(new ClearMyGrouponsRunnable((DaoMyGrouponItem)daoGrouponItem.get(), (DaoMyGrouponItemSummary)daoGrouponItemSummary.get(), (DaoPagination)daoPagination.get()));
        ((Logger)logger.get()).forceLogRotate();
    }

    public void relogin(CheckedFunction0 checkedfunction0, final Function1 onException, Function0 function0)
    {
label0:
        {
            if (RELOGIN_ATTEMPTS.incrementAndGet() == 1)
            {
                onException = new Function1() {

                    final LoginService this$0;
                    final Function1 val$onException;

                    public void execute(Exception exception)
                        throws RuntimeException
                    {
                        LoginService.THREAD_POOL_EXECUTOR.execute(new ClearMyGrouponsRunnable((DaoMyGrouponItem)daoGrouponItem.get(), (DaoMyGrouponItemSummary)daoGrouponItemSummary.get(), (DaoPagination)daoPagination.get()));
                        if (onException != null)
                        {
                            onException.execute(exception);
                        }
                    }

                    public volatile void execute(Object obj)
                        throws Exception
                    {
                        execute((Exception)obj);
                    }

            
            {
                this$0 = LoginService.this;
                onException = function1;
                super();
            }
                };
                UserCredential usercredential = SSOHelper.getAppAccount(application, currentCountryManager.getCurrentCountry().isoName);
                if (usercredential == null || usercredential.getUsername() == null || usercredential.getPassword() == null)
                {
                    break label0;
                }
                login(usercredential.getUsername(), usercredential.getPassword(), checkedfunction0, onException, function0);
            }
            return;
        }
        login(null, null, checkedfunction0, onException, function0);
    }

    static 
    {
        THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }










}

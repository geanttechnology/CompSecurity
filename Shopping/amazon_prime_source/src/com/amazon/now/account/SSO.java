// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.account;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.CustomerAttributeStore;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.identity.auth.device.api.MAPCallbackErrorException;
import com.amazon.identity.auth.device.api.MAPFuture;
import com.amazon.identity.auth.device.api.SigninOption;
import com.amazon.mobile.mash.error.MASHError;
import com.amazon.now.AmazonActivity;
import com.amazon.now.cookie.NowAppContextCookie;
import com.amazon.now.location.Location;
import com.amazon.now.platform.AndroidPlatform;
import com.amazon.now.util.AppUtils;
import com.amazon.now.util.DataStore;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.apache.cordova.CallbackContext;

// Referenced classes of package com.amazon.now.account:
//            User, MAPCookiesFetcher

public class SSO
{
    private static class MAPSignInCallback
        implements Callback
    {

        private Activity mActivity;
        private SignInCallback mCallback;

        public void onError(Bundle bundle)
        {
            Log.e(SSO.TAG, "Register via MAPR5 was a failure");
            if (mCallback != null)
            {
                mCallback.failure();
            }
        }

        public void onSuccess(Bundle bundle)
        {
            bundle = bundle.getString("com.amazon.dcp.sso.property.account.acctId");
            SSO.sLastAuthentication = SystemClock.elapsedRealtime();
            DataStore.putLong("lastAuthentication", SSO.sLastAuthentication);
            SSO.notifyUserSignedIn(bundle, null);
            if (mCallback != null)
            {
                mCallback.success(mActivity);
                return;
            } else
            {
                AndroidPlatform.getInstance().invokeLater(new Runnable() {

                    final MAPSignInCallback this$0;

                    public void run()
                    {
                        mActivity.recreate();
                    }

            
            {
                this$0 = MAPSignInCallback.this;
                super();
            }
                });
                return;
            }
        }


        public MAPSignInCallback(Activity activity, SignInCallback signincallback)
        {
            mActivity = activity;
            mCallback = signincallback;
        }
    }

    public static interface SignInCallback
    {

        public abstract void failure();

        public abstract void success(Activity activity);
    }


    private static final String TAG = com/amazon/now/account/SSO.getSimpleName();
    private static final Executor sExecutor = Executors.newFixedThreadPool(1);
    private static long sLastAuthentication = -1L;

    public SSO()
    {
    }

    public static void authenticateUser(Activity activity, SignInCallback signincallback)
    {
        MAPAccountManager mapaccountmanager = getMAPAccountManager();
        Bundle bundle = setUpRegistrationBundle(activity);
        if (!TextUtils.isEmpty(mapaccountmanager.getAccount()))
        {
            syncCookies(true, new Callback(signincallback, activity) {

                final Activity val$activity;
                final SignInCallback val$callback;

                public void onError(Bundle bundle1)
                {
                }

                public void onSuccess(Bundle bundle1)
                {
                    if (callback != null)
                    {
                        callback.success(activity);
                        return;
                    } else
                    {
                        activity.recreate();
                        return;
                    }
                }

            
            {
                callback = signincallback;
                activity = activity1;
                super();
            }
            });
            return;
        } else
        {
            signincallback = new MAPSignInCallback(activity, signincallback);
            mapaccountmanager.registerAccountWithUI(activity, SigninOption.WebviewSignin, bundle, signincallback);
            return;
        }
    }

    public static void confirmCredentials(Activity activity, Callback callback)
    {
        MAPAccountManager mapaccountmanager = getMAPAccountManager();
        Bundle bundle = setUpRegistrationBundle(activity);
        bundle.putString("com.amazon.dcp.sso.property.account.acctId", mapaccountmanager.getAccount());
        mapaccountmanager.authenticateAccountWithUI(activity, SigninOption.WebviewConfirmCredentials, bundle, callback);
    }

    public static void deRegisterUser(Activity activity, CallbackContext callbackcontext)
    {
        AmazonActivity amazonactivity;
        MAPAccountManager mapaccountmanager;
        if (activity instanceof AmazonActivity)
        {
            amazonactivity = (AmazonActivity)activity;
        } else
        {
            amazonactivity = null;
        }
        if (amazonactivity != null)
        {
            amazonactivity.showSpinner();
        }
        sLastAuthentication = 0L;
        DataStore.putLong("lastAuthentication", 0L);
        mapaccountmanager = getMAPAccountManager();
        mapaccountmanager.deregisterAccount(mapaccountmanager.getAccount(), new Callback(activity, mapaccountmanager, amazonactivity, callbackcontext) {

            final MAPAccountManager val$accountManager;
            final Activity val$activity;
            final AmazonActivity val$amazonActivity;
            final CallbackContext val$callback;

            public void onError(Bundle bundle)
            {
                Log.e(SSO.TAG, "deregister failed");
                if (callback != null)
                {
                    callback.error(MASHError.UNKNOWN.toJSONObejct());
                }
                AppUtils.goHome(activity);
            }

            public void onSuccess(Bundle bundle)
            {
                AndroidPlatform.getInstance().runOnUiThread(new Runnable() {

                    final _cls4 this$0;

                    public void run()
                    {
                        Object obj;
                        if (AppUtils.isAppDebuggable(activity))
                        {
                            obj = accountManager.getAccount();
                            if (obj == null)
                            {
                                Log.v(SSO.TAG, "deregister completed: account is null");
                            } else
                            {
                                Log.v(SSO.TAG, (new StringBuilder()).append("deregister completed: ").append(((String) (obj))).toString());
                                Log.v(SSO.TAG, (new StringBuilder()).append("isAccountRegistered : ").append(accountManager.isAccountRegistered(((String) (obj)))).toString());
                            }
                        }
                        User.removeUser();
                        obj = CookieManager.getInstance();
                        if (android.os.Build.VERSION.SDK_INT < 21)
                        {
                            ((CookieManager) (obj)).removeAllCookie();
                            if (amazonActivity != null)
                            {
                                amazonActivity.hideSpinner();
                            }
                            if (callback != null)
                            {
                                NowAppContextCookie.syncCookie();
                                callback.success();
                            } else
                            {
                                Location.resetLocation();
                            }
                            AppUtils.resetActivityStack(activity);
                            return;
                        } else
                        {
                            ((CookieManager) (obj)).removeAllCookies(new ValueCallback() {

                                final _cls1 this$1;

                                public void onReceiveValue(Boolean boolean1)
                                {
                                    if (amazonActivity != null)
                                    {
                                        amazonActivity.hideSpinner();
                                    }
                                    if (callback != null)
                                    {
                                        NowAppContextCookie.syncCookie();
                                        callback.success();
                                    } else
                                    {
                                        Location.resetLocation();
                                    }
                                    AppUtils.resetActivityStack(activity);
                                }

                                public volatile void onReceiveValue(Object obj)
                                {
                                    onReceiveValue((Boolean)obj);
                                }

            
            {
                this$1 = _cls1.this;
                super();
            }
                            });
                            return;
                        }
                    }

            
            {
                this$0 = _cls4.this;
                super();
            }
                });
            }

            
            {
                activity = activity1;
                accountManager = mapaccountmanager;
                amazonActivity = amazonactivity;
                callback = callbackcontext;
                super();
            }
        });
    }

    public static String getAccount()
    {
        String s1 = getMAPAccountManager().getAccount();
        String s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = null;
        }
        return s;
    }

    private static String getCustomerAttribute(String s, String s1)
    {
        String s2;
        Context context = AndroidPlatform.getInstance().getApplicationContext();
        s2 = null;
        if (TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_40;
        }
        s = CustomerAttributeStore.getInstance(context).getAttribute(s, s1, null);
        s2 = CustomerAttributeStore.getValueOrAttributeDefault((Bundle)s.get());
        return s2;
        s;
_L2:
        Log.e(TAG, "Exception during fetching customer attributes from MAP", s);
        return null;
        s;
        continue; /* Loop/switch isn't completed */
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static String getFullNameFromCustomerAttribute(String s)
    {
        return getCustomerAttribute(s, "com.amazon.dcp.sso.property.username");
    }

    public static MAPAccountManager getMAPAccountManager()
    {
        return new MAPAccountManager(AndroidPlatform.getInstance().getApplicationContext());
    }

    public static String getMAPDomain(Context context)
    {
        if (AppUtils.isAppDebuggable(context) && AppUtils.isDevo())
        {
            return context.getString(0x7f070078);
        } else
        {
            return context.getString(0x7f070072);
        }
    }

    public static void notifyUserSignedIn(String s, Callback callback)
    {
        sExecutor.execute(new Runnable(s, callback) {

            final String val$acctID;
            final Callback val$callback;

            public void run()
            {
                User.saveUser(null, SSO.getFullNameFromCustomerAttribute(acctID), SSO.getCustomerAttribute(acctID, "COR"), SSO.getCustomerAttribute(acctID, "PFM"));
                SSO.syncCookies(false, callback);
            }

            
            {
                acctID = s;
                callback = callback1;
                super();
            }
        });
    }

    public static void notifyUserSignedOut()
    {
        User.removeUser();
    }

    public static void promptToDeregister(Activity activity)
    {
        if (User.isSignedIn())
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
            builder.setTitle(0x7f070071);
            builder.setMessage(String.format(activity.getResources().getString(0x7f070070), new Object[] {
                User.getUserName()
            }));
            builder.setCancelable(true);
            builder.setPositiveButton(0x7f07006e, new android.content.DialogInterface.OnClickListener(activity) {

                final Activity val$activity;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    SSO.deRegisterUser(activity, null);
                }

            
            {
                activity = activity1;
                super();
            }
            });
            builder.setNegativeButton(0x7f07006d, new android.content.DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            });
            if (!activity.isFinishing())
            {
                builder.create().show();
            }
        }
    }

    private static Bundle setUpRegistrationBundle(Activity activity)
    {
        Bundle bundle = new Bundle();
        Bundle bundle1 = new Bundle();
        bundle1.putString("pageId", activity.getString(0x7f07008f));
        bundle1.putString("openid.assoc_handle", activity.getString(0x7f07008e));
        bundle.putBundle("com.amazon.identity.ap.request.parameters", bundle1);
        bundle.putString("com.amazon.identity.ap.domain", getMAPDomain(activity));
        bundle.putSerializable("progressbar_state", com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ProgressBarState.SPINNER_MEDIUM);
        bundle.putSerializable("progressbar_position", com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ScreenPosition.CENTER_CENTER);
        bundle.putInt("AuthPortalActivityUIOptions.requestedOrientation", 1);
        return bundle;
    }

    public static boolean shouldReauthenticate()
    {
        boolean flag = true;
        if (!AppUtils.isAmazonDevice()) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        if (sLastAuthentication < 0L)
        {
            sLastAuthentication = DataStore.getLong("lastAuthentication");
        }
        if (sLastAuthentication != 0L)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!TextUtils.isEmpty(getMAPAccountManager().getAccount())) goto _L4; else goto _L3
_L3:
        return false;
        if (SystemClock.elapsedRealtime() - sLastAuthentication > 0x48190800L) goto _L4; else goto _L5
_L5:
        return false;
    }

    public static boolean syncCookies(boolean flag, Callback callback)
    {
        String s = getAccount();
        if (s != null)
        {
            (new MAPCookiesFetcher(AndroidPlatform.getInstance().getApplicationContext(), s)).getCookies(flag, callback);
            return true;
        } else
        {
            return false;
        }
    }

    public static void updateLastAuthenticationTime()
    {
        sLastAuthentication = SystemClock.elapsedRealtime();
        DataStore.putLong("lastAuthentication", sLastAuthentication);
    }







/*
    static long access$302(long l)
    {
        sLastAuthentication = l;
        return l;
    }

*/
}

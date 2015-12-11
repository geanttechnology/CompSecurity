// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.callbacks;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.google.android.gms.common.api.Scope;
import com.google.inject.Provider;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.models.country.Country;
import com.groupon.models.error.GoogleAuthenticationException;
import com.groupon.models.signup.SignupResponse;
import com.groupon.models.signup.User;
import com.groupon.service.LoginService;
import com.groupon.service.SignUpService;
import com.groupon.service.core.UserManager;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.CountryUtil;
import com.groupon.util.GoogleSignInCallbacks;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Ln;

public class GoogleServerAuthHandler
    implements com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks
{

    private static final String ACCESS_TOKEN = "access_token";
    private static final String COUNTRY_CODE = "countryCode";
    public static final String GOOGLE_ID_TOKEN = "googleIdToken";
    private static final String GOOGLE_SIGN_IN_SERVER_REDIRECT_ID = "urn:ietf:wg:oauth:2.0:oob";
    private static final String ID_TOKEN = "idToken";
    private static final String ONE_TIME_CODE = "oneTimeCode";
    private static final String REDIRECT_ID = "redirect_uri";
    private static final String SCOPE_CONTACTS = "https://www.googleapis.com/auth/contacts.readonly";
    private static final String TOKEN = "token";
    private static final String TOKEN_TYPE = "token_type";
    private WeakReference contextRef;
    private CountryUtil countryUtil;
    private CurrentCountryManager currentCountryManager;
    private String deviceId;
    GoogleSignInCallbacks googleSignInCallbacks;
    private Handler handler;
    private Provider logger;
    private ArraySharedPreferences loginPrefs;
    final Set scopeSetFromServer = new HashSet();
    private UserManager userManager;

    public GoogleServerAuthHandler(Context context)
    {
        contextRef = new WeakReference(context);
        RoboGuice.getInjector(context).injectMembers(this);
    }

    private void refreshUserWithConsumerId(String s, String s1, String s2)
    {
        Ln.d("Google sign in: making /users/%s call", new Object[0]);
        s = new SignUpService(s2, s, s1) {

            final GoogleServerAuthHandler this$0;
            final String val$accessToken;
            final String val$consumerId;
            final String val$googleIdToken;

            public void onException(Exception exception)
            {
                Ln.d("Google sign in: exception making /users/%s call", new Object[] {
                    consumerId
                });
                if (googleSignInCallbacks != null)
                {
                    googleSignInCallbacks.onGoogleSignInException(exception);
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
                Ln.d("Google Sign in: onSuccess /users/%s", new Object[] {
                    consumerId
                });
                userManager.updateUserDetails((Context)contextRef.get(), signupresponse.user);
                signupresponse = loginPrefs.edit();
                LoginService.setAccessToken(signupresponse, accessToken);
                GoogleServerAuthHandler.setGoogleIdToken(signupresponse, googleIdToken).apply();
                ((Logger)logger.get()).forceLogRotate();
                if (googleSignInCallbacks != null)
                {
                    googleSignInCallbacks.onGoogleSignInSuccess();
                }
            }

            transient 
            {
                this$0 = GoogleServerAuthHandler.this;
                consumerId = s1;
                accessToken = s2;
                googleIdToken = s3;
                super(final_context, final_s, final_aobj);
            }
        };
        s.method("GET");
        s.handler(handler);
        s.execute();
    }

    public static android.content.SharedPreferences.Editor setGoogleIdToken(android.content.SharedPreferences.Editor editor, String s)
    {
        editor.putString("googleIdToken", s);
        return editor;
    }

    public com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks.CheckResult onCheckServerAuthorization(String s, Set set)
    {
        set = currentCountryManager.getCurrentCountry();
        set = (new SyncHttp((Context)contextRef.get(), com/groupon/models/signup/SignupResponse, "https:/oauth/google_authenticate", new Object[] {
            "redirect_uri", "urn:ietf:wg:oauth:2.0:oob", "token", s, "token_type", "idToken", "device_id", deviceId, "locale", countryUtil.getLocale(set), 
            "countryCode", ((Country) (set)).shortName
        })).method("POST");
        try
        {
            set = (SignupResponse)set.call();
            Ln.d("Google sign in: onSuccess /oauth/google_authenticate", new Object[0]);
            refreshUserWithConsumerId(((SignupResponse) (set)).accessToken, s, ((SignupResponse) (set)).user.consumerId);
            s = com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks.CheckResult.newAuthNotRequiredResult();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Ln.d("Google sign in: onException", new Object[0]);
            if ((s instanceof GoogleAuthenticationException) && ((GoogleAuthenticationException)s).requiredScopes != null)
            {
                s = ((GoogleAuthenticationException)s).requiredScopes;
                scopeSetFromServer.add(new Scope("https://www.googleapis.com/auth/contacts.readonly"));
                for (s = s.iterator(); s.hasNext(); scopeSetFromServer.add(new Scope(set)))
                {
                    set = (String)s.next();
                }

                return com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks.CheckResult.newAuthRequiredResult(scopeSetFromServer);
            }
            if (googleSignInCallbacks != null)
            {
                googleSignInCallbacks.onGoogleSignInException(s);
            } else
            {
                handler.post(new Runnable() {

                    final GoogleServerAuthHandler this$0;

                    public void run()
                    {
                        Toast.makeText((Context)contextRef.get(), 0x7f080215, 0).show();
                    }

            
            {
                this$0 = GoogleServerAuthHandler.this;
                super();
            }
                });
            }
            return com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks.CheckResult.newAuthNotRequiredResult();
        }
        return s;
    }

    public boolean onUploadServerAuthCode(String s, String s1)
    {
        Ln.d("Google sign in: uploading server auth token", new Object[0]);
        Country country = currentCountryManager.getCurrentCountry();
        s = new SignUpService("https:/oauth/google_authenticate", new Object[] {
            "redirect_uri", "urn:ietf:wg:oauth:2.0:oob", "token", s1, "token_type", "oneTimeCode", "device_id", deviceId, "locale", countryUtil.getLocale(country), 
            "countryCode", country.shortName
        }, s) {

            final GoogleServerAuthHandler this$0;
            final String val$idToken;

            public void onException(Exception exception)
            {
                Ln.d("Google sign in: onException", new Object[0]);
                if (googleSignInCallbacks != null)
                {
                    googleSignInCallbacks.onGoogleSignInException(exception);
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
                Ln.d("Google sign in: onSuccess /oauth/google_authenticate", new Object[0]);
                refreshUserWithConsumerId(signupresponse.accessToken, idToken, signupresponse.user.consumerId);
            }

            transient 
            {
                this$0 = GoogleServerAuthHandler.this;
                idToken = s1;
                super(final_context, s, aobj);
            }
        };
        s.method("POST");
        s.handler(handler);
        s.execute();
        return true;
    }

    public void setGoogleSignInCallbacks(GoogleSignInCallbacks googlesignincallbacks)
    {
        googleSignInCallbacks = googlesignincallbacks;
    }





}

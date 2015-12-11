// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.login;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.Validate;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

// Referenced classes of package com.facebook.login:
//            LoginBehavior, DefaultAudience, LoginResult, LoginFragment, 
//            LoginLogger, StartActivityDelegate, LoginClient

public class LoginManager
{
    private static class ActivityStartActivityDelegate
        implements StartActivityDelegate
    {

        private final Activity activity;

        public Activity getActivityContext()
        {
            return activity;
        }

        public void startActivityForResult(Intent intent, int i)
        {
            activity.startActivityForResult(intent, i);
        }

        ActivityStartActivityDelegate(Activity activity1)
        {
            Validate.notNull(activity1, "activity");
            activity = activity1;
        }
    }


    private static final Set OTHER_PUBLISH_PERMISSIONS = getOtherPublishPermissions();
    private static volatile LoginManager instance;
    private Context context;
    private DefaultAudience defaultAudience;
    private LoginBehavior loginBehavior;
    private LoginLogger loginLogger;
    private HashMap pendingLoggingExtras;
    private LoginClient.Request pendingLoginRequest;

    LoginManager()
    {
        loginBehavior = LoginBehavior.SSO_WITH_FALLBACK;
        defaultAudience = DefaultAudience.FRIENDS;
        Validate.sdkInitialized();
    }

    static LoginResult computeLoginResult(LoginClient.Request request, AccessToken accesstoken)
    {
        Set set = request.getPermissions();
        HashSet hashset = new HashSet(accesstoken.getPermissions());
        if (request.isRerequest())
        {
            hashset.retainAll(set);
        }
        request = new HashSet(set);
        request.removeAll(hashset);
        return new LoginResult(accesstoken, hashset, request);
    }

    private LoginClient.Request createLoginRequest(Collection collection)
    {
        LoginBehavior loginbehavior = loginBehavior;
        boolean flag;
        if (collection != null)
        {
            collection = new HashSet(collection);
        } else
        {
            collection = new HashSet();
        }
        collection = new LoginClient.Request(loginbehavior, Collections.unmodifiableSet(collection), defaultAudience, FacebookSdk.getApplicationId(), UUID.randomUUID().toString());
        if (AccessToken.getCurrentAccessToken() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        collection.setRerequest(flag);
        return collection;
    }

    private void finishLogin(AccessToken accesstoken, FacebookException facebookexception, boolean flag, FacebookCallback facebookcallback)
    {
        if (accesstoken != null)
        {
            AccessToken.setCurrentAccessToken(accesstoken);
            Profile.fetchProfileForCurrentAccessToken();
        }
        if (facebookcallback == null) goto _L2; else goto _L1
_L1:
        LoginResult loginresult;
        if (accesstoken != null)
        {
            loginresult = computeLoginResult(pendingLoginRequest, accesstoken);
        } else
        {
            loginresult = null;
        }
        if (flag || loginresult != null && loginresult.getRecentlyGrantedPermissions().size() == 0)
        {
            facebookcallback.onCancel();
            return;
        }
        if (facebookexception == null) goto _L4; else goto _L3
_L3:
        facebookcallback.onError(facebookexception);
_L2:
        context = null;
        loginLogger = null;
        return;
_L4:
        if (accesstoken != null)
        {
            facebookcallback.onSuccess(loginresult);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    private Intent getFacebookActivityIntent(LoginClient.Request request)
    {
        Intent intent = new Intent();
        intent.setClass(FacebookSdk.getApplicationContext(), com/facebook/FacebookActivity);
        intent.setAction(request.getLoginBehavior().toString());
        intent.putExtras(LoginFragment.populateIntentExtras(request));
        return intent;
    }

    public static LoginManager getInstance()
    {
        if (instance != null) goto _L2; else goto _L1
_L1:
        com/facebook/login/LoginManager;
        JVM INSTR monitorenter ;
        if (instance == null)
        {
            instance = new LoginManager();
        }
        com/facebook/login/LoginManager;
        JVM INSTR monitorexit ;
_L2:
        return instance;
        Exception exception;
        exception;
        com/facebook/login/LoginManager;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private LoginLogger getLogger()
    {
        if (loginLogger == null || !loginLogger.getApplicationId().equals(pendingLoginRequest.getApplicationId()))
        {
            loginLogger = new LoginLogger(context, pendingLoginRequest.getApplicationId());
        }
        return loginLogger;
    }

    private static Set getOtherPublishPermissions()
    {
        return Collections.unmodifiableSet(new HashSet() {

            
            {
                add("ads_management");
                add("create_event");
                add("rsvp_event");
            }
        });
    }

    static boolean isPublishPermission(String s)
    {
        return s != null && (s.startsWith("publish") || s.startsWith("manage") || OTHER_PUBLISH_PERMISSIONS.contains(s));
    }

    private void logCompleteLogin(LoginClient.Result.Code code, Map map, Exception exception)
    {
        if (pendingLoginRequest == null)
        {
            getLogger().logUnexpectedError("fb_mobile_login_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.");
            return;
        } else
        {
            getLogger().logCompleteLogin(pendingLoginRequest.getAuthId(), pendingLoggingExtras, code, map, exception);
            return;
        }
    }

    private void logStartLogin()
    {
        getLogger().logStartLogin(pendingLoginRequest);
    }

    private boolean resolveIntent(Intent intent)
    {
        return FacebookSdk.getApplicationContext().getPackageManager().resolveActivity(intent, 0) != null;
    }

    private void startLogin(StartActivityDelegate startactivitydelegate, LoginClient.Request request)
        throws FacebookException
    {
        pendingLoginRequest = request;
        pendingLoggingExtras = new HashMap();
        context = startactivitydelegate.getActivityContext();
        logStartLogin();
        CallbackManagerImpl.registerStaticCallback(com.facebook.internal.CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new com.facebook.internal.CallbackManagerImpl.Callback() {

            final LoginManager this$0;

            public boolean onActivityResult(int i, Intent intent)
            {
                return LoginManager.this.onActivityResult(i, intent);
            }

            
            {
                this$0 = LoginManager.this;
                super();
            }
        });
        boolean flag = tryFacebookActivity(startactivitydelegate, request);
        request = pendingLoggingExtras;
        if (flag)
        {
            startactivitydelegate = "1";
        } else
        {
            startactivitydelegate = "0";
        }
        request.put("try_login_activity", startactivitydelegate);
        if (!flag)
        {
            startactivitydelegate = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
            logCompleteLogin(LoginClient.Result.Code.ERROR, null, startactivitydelegate);
            pendingLoginRequest = null;
            throw startactivitydelegate;
        } else
        {
            return;
        }
    }

    private boolean tryFacebookActivity(StartActivityDelegate startactivitydelegate, LoginClient.Request request)
    {
        request = getFacebookActivityIntent(request);
        if (!resolveIntent(request))
        {
            return false;
        }
        try
        {
            startactivitydelegate.startActivityForResult(request, LoginClient.getLoginRequestCode());
        }
        // Misplaced declaration of an exception variable
        catch (StartActivityDelegate startactivitydelegate)
        {
            return false;
        }
        return true;
    }

    private void validateReadPermissions(Collection collection)
    {
        if (collection != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s;
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            s = (String)collection.next();
        } while (!isPublishPermission(s));
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        throw new FacebookException(String.format("Cannot pass a publish or manage permission (%s) to a request for read authorization", new Object[] {
            s
        }));
    }

    public void logInWithReadPermissions(Activity activity, Collection collection)
    {
        validateReadPermissions(collection);
        collection = createLoginRequest(collection);
        startLogin(new ActivityStartActivityDelegate(activity), collection);
    }

    public void logOut()
    {
        AccessToken.setCurrentAccessToken(null);
        Profile.setCurrentProfile(null);
    }

    boolean onActivityResult(int i, Intent intent)
    {
        return onActivityResult(i, intent, null);
    }

    boolean onActivityResult(int i, Intent intent, FacebookCallback facebookcallback)
    {
        if (pendingLoginRequest == null)
        {
            return false;
        }
        Object obj4 = null;
        Object obj2 = null;
        Object obj5 = null;
        Object obj3 = null;
        Object obj = LoginClient.Result.Code.ERROR;
        LoginClient.Result.Code code = null;
        boolean flag = false;
        boolean flag1 = false;
        Intent intent1;
        Object obj1;
        if (intent != null)
        {
            LoginClient.Result result = (LoginClient.Result)intent.getParcelableExtra("com.facebook.LoginFragment:Result");
            intent = ((Intent) (obj));
            obj = obj4;
            obj1 = code;
            intent1 = obj5;
            if (result != null)
            {
                code = result.code;
                if (i == -1)
                {
                    if (result.code == LoginClient.Result.Code.SUCCESS)
                    {
                        intent = result.token;
                        flag = flag1;
                        obj = obj2;
                    } else
                    {
                        obj = new FacebookAuthorizationException(result.errorMessage);
                        flag = flag1;
                        intent = obj3;
                    }
                } else
                {
                    obj = obj2;
                    flag = flag1;
                    intent = obj3;
                    if (i == 0)
                    {
                        flag = true;
                        obj = obj2;
                        intent = obj3;
                    }
                }
                obj1 = result.loggingExtras;
                intent1 = intent;
                intent = code;
            }
        } else
        {
            intent = ((Intent) (obj));
            obj = obj4;
            obj1 = code;
            intent1 = obj5;
            if (i == 0)
            {
                flag = true;
                intent = LoginClient.Result.Code.CANCEL;
                obj = obj4;
                obj1 = code;
                intent1 = obj5;
            }
        }
        obj2 = obj;
        if (obj == null)
        {
            obj2 = obj;
            if (intent1 == null)
            {
                obj2 = obj;
                if (!flag)
                {
                    obj2 = new FacebookException("Unexpected call to LoginManager.onActivityResult");
                }
            }
        }
        logCompleteLogin(intent, ((Map) (obj1)), ((Exception) (obj2)));
        finishLogin(intent1, ((FacebookException) (obj2)), flag, facebookcallback);
        return true;
    }

    public void registerCallback(CallbackManager callbackmanager, final FacebookCallback callback)
    {
        if (!(callbackmanager instanceof CallbackManagerImpl))
        {
            throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
        } else
        {
            ((CallbackManagerImpl)callbackmanager).registerCallback(com.facebook.internal.CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new com.facebook.internal.CallbackManagerImpl.Callback() {

                final LoginManager this$0;
                final FacebookCallback val$callback;

                public boolean onActivityResult(int i, Intent intent)
                {
                    return LoginManager.this.onActivityResult(i, intent, callback);
                }

            
            {
                this$0 = LoginManager.this;
                callback = facebookcallback;
                super();
            }
            });
            return;
        }
    }

}

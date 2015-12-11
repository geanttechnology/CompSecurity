// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.login;

import android.app.Activity;
import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FragmentWrapper;
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
//            LoginBehavior, DefaultAudience, LoginResult, LoginLogger, 
//            StartActivityDelegate, LoginClient

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

    private static class FragmentStartActivityDelegate
        implements StartActivityDelegate
    {

        private final FragmentWrapper fragment;

        public Activity getActivityContext()
        {
            return fragment.getActivity();
        }

        public void startActivityForResult(Intent intent, int i)
        {
            fragment.startActivityForResult(intent, i);
        }

        FragmentStartActivityDelegate(FragmentWrapper fragmentwrapper)
        {
            Validate.notNull(fragmentwrapper, "fragment");
            fragment = fragmentwrapper;
        }
    }

    private static class LoginLoggerHolder
    {

        private static volatile LoginLogger logger;

        private static LoginLogger getLogger(Context context)
        {
            com/facebook/login/LoginManager$LoginLoggerHolder;
            JVM INSTR monitorenter ;
            if (context == null) goto _L2; else goto _L1
_L1:
            if (context != null) goto _L4; else goto _L3
_L3:
            context = null;
_L6:
            com/facebook/login/LoginManager$LoginLoggerHolder;
            JVM INSTR monitorexit ;
            return context;
_L2:
            context = FacebookSdk.getApplicationContext();
            continue; /* Loop/switch isn't completed */
_L4:
            if (logger == null)
            {
                logger = new LoginLogger(context, FacebookSdk.getApplicationId());
            }
            context = logger;
            if (true) goto _L6; else goto _L5
_L5:
            context;
            throw context;
            if (true) goto _L1; else goto _L7
_L7:
        }


        private LoginLoggerHolder()
        {
        }
    }


    private static final String MANAGE_PERMISSION_PREFIX = "manage";
    private static final Set OTHER_PUBLISH_PERMISSIONS = getOtherPublishPermissions();
    private static final String PUBLISH_PERMISSION_PREFIX = "publish";
    private static volatile LoginManager instance;
    private DefaultAudience defaultAudience;
    private LoginBehavior loginBehavior;

    LoginManager()
    {
        loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
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

    private LoginClient.Request createLoginRequestFromResponse(GraphResponse graphresponse)
    {
        Validate.notNull(graphresponse, "response");
        graphresponse = graphresponse.getRequest().getAccessToken();
        if (graphresponse != null)
        {
            graphresponse = graphresponse.getPermissions();
        } else
        {
            graphresponse = null;
        }
        return createLoginRequest(graphresponse);
    }

    private void finishLogin(AccessToken accesstoken, LoginClient.Request request, FacebookException facebookexception, boolean flag, FacebookCallback facebookcallback)
    {
        if (accesstoken != null)
        {
            AccessToken.setCurrentAccessToken(accesstoken);
            Profile.fetchProfileForCurrentAccessToken();
        }
        if (facebookcallback != null)
        {
            if (accesstoken != null)
            {
                request = computeLoginResult(request, accesstoken);
            } else
            {
                request = null;
            }
            if (flag || request != null && request.getRecentlyGrantedPermissions().size() == 0)
            {
                facebookcallback.onCancel();
            } else
            {
                if (facebookexception != null)
                {
                    facebookcallback.onError(facebookexception);
                    return;
                }
                if (accesstoken != null)
                {
                    facebookcallback.onSuccess(request);
                    return;
                }
            }
        }
    }

    private Intent getFacebookActivityIntent(LoginClient.Request request)
    {
        Intent intent = new Intent();
        intent.setClass(FacebookSdk.getApplicationContext(), com/facebook/FacebookActivity);
        intent.setAction(request.getLoginBehavior().toString());
        Bundle bundle = new Bundle();
        bundle.putParcelable("request", request);
        intent.putExtras(bundle);
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

    private void logCompleteLogin(Context context, LoginClient.Result.Code code, Map map, Exception exception, boolean flag, LoginClient.Request request)
    {
        LoginLogger loginlogger = LoginLoggerHolder.getLogger(context);
        if (loginlogger == null)
        {
            return;
        }
        if (request == null)
        {
            loginlogger.logUnexpectedError("fb_mobile_login_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.");
            return;
        }
        HashMap hashmap = new HashMap();
        if (flag)
        {
            context = "1";
        } else
        {
            context = "0";
        }
        hashmap.put("try_login_activity", context);
        loginlogger.logCompleteLogin(request.getAuthId(), hashmap, code, map, exception);
    }

    private void logInWithPublishPermissions(FragmentWrapper fragmentwrapper, Collection collection)
    {
        validatePublishPermissions(collection);
        collection = createLoginRequest(collection);
        startLogin(new FragmentStartActivityDelegate(fragmentwrapper), collection);
    }

    private void logInWithReadPermissions(FragmentWrapper fragmentwrapper, Collection collection)
    {
        validateReadPermissions(collection);
        collection = createLoginRequest(collection);
        startLogin(new FragmentStartActivityDelegate(fragmentwrapper), collection);
    }

    private void logStartLogin(Context context, LoginClient.Request request)
    {
        context = LoginLoggerHolder.getLogger(context);
        if (context != null && request != null)
        {
            context.logStartLogin(request);
        }
    }

    private void resolveError(FragmentWrapper fragmentwrapper, GraphResponse graphresponse)
    {
        startLogin(new FragmentStartActivityDelegate(fragmentwrapper), createLoginRequestFromResponse(graphresponse));
    }

    private boolean resolveIntent(Intent intent)
    {
        return FacebookSdk.getApplicationContext().getPackageManager().resolveActivity(intent, 0) != null;
    }

    private void startLogin(StartActivityDelegate startactivitydelegate, LoginClient.Request request)
        throws FacebookException
    {
        logStartLogin(startactivitydelegate.getActivityContext(), request);
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
        if (!tryFacebookActivity(startactivitydelegate, request))
        {
            FacebookException facebookexception = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
            logCompleteLogin(startactivitydelegate.getActivityContext(), LoginClient.Result.Code.ERROR, null, facebookexception, false, request);
            throw facebookexception;
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

    private void validatePublishPermissions(Collection collection)
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
        } while (isPublishPermission(s));
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        throw new FacebookException(String.format("Cannot pass a read permission (%s) to a request for publish authorization", new Object[] {
            s
        }));
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

    public DefaultAudience getDefaultAudience()
    {
        return defaultAudience;
    }

    public LoginBehavior getLoginBehavior()
    {
        return loginBehavior;
    }

    public void logInWithPublishPermissions(Activity activity, Collection collection)
    {
        validatePublishPermissions(collection);
        collection = createLoginRequest(collection);
        startLogin(new ActivityStartActivityDelegate(activity), collection);
    }

    public void logInWithPublishPermissions(Fragment fragment, Collection collection)
    {
        logInWithPublishPermissions(new FragmentWrapper(fragment), collection);
    }

    public void logInWithPublishPermissions(android.support.v4.app.Fragment fragment, Collection collection)
    {
        logInWithPublishPermissions(new FragmentWrapper(fragment), collection);
    }

    public void logInWithReadPermissions(Activity activity, Collection collection)
    {
        validateReadPermissions(collection);
        collection = createLoginRequest(collection);
        startLogin(new ActivityStartActivityDelegate(activity), collection);
    }

    public void logInWithReadPermissions(Fragment fragment, Collection collection)
    {
        logInWithReadPermissions(new FragmentWrapper(fragment), collection);
    }

    public void logInWithReadPermissions(android.support.v4.app.Fragment fragment, Collection collection)
    {
        logInWithReadPermissions(new FragmentWrapper(fragment), collection);
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
        Object obj6 = null;
        Object obj3 = null;
        Object obj7 = null;
        Object obj4 = null;
        Object obj = LoginClient.Result.Code.ERROR;
        LoginClient.Result.Code code = null;
        Object obj5 = null;
        boolean flag = false;
        boolean flag1 = false;
        Object obj1;
        LoginClient.Request request;
        Object obj2;
        if (intent != null)
        {
            LoginClient.Result result = (LoginClient.Result)intent.getParcelableExtra("com.facebook.LoginFragment:Result");
            obj2 = code;
            intent = obj6;
            request = obj5;
            obj1 = obj7;
            if (result != null)
            {
                request = result.request;
                code = result.code;
                if (i == -1)
                {
                    if (result.code == LoginClient.Result.Code.SUCCESS)
                    {
                        obj = result.token;
                        flag = flag1;
                        intent = ((Intent) (obj3));
                    } else
                    {
                        intent = new FacebookAuthorizationException(result.errorMessage);
                        obj = obj4;
                        flag = flag1;
                    }
                } else
                {
                    intent = ((Intent) (obj3));
                    obj = obj4;
                    flag = flag1;
                    if (i == 0)
                    {
                        flag = true;
                        intent = ((Intent) (obj3));
                        obj = obj4;
                    }
                }
                obj2 = result.loggingExtras;
                obj1 = obj;
                obj = code;
            }
        } else
        {
            obj2 = code;
            intent = obj6;
            request = obj5;
            obj1 = obj7;
            if (i == 0)
            {
                flag = true;
                obj = LoginClient.Result.Code.CANCEL;
                obj2 = code;
                intent = obj6;
                request = obj5;
                obj1 = obj7;
            }
        }
        obj3 = intent;
        if (intent == null)
        {
            obj3 = intent;
            if (obj1 == null)
            {
                obj3 = intent;
                if (!flag)
                {
                    obj3 = new FacebookException("Unexpected call to LoginManager.onActivityResult");
                }
            }
        }
        logCompleteLogin(null, ((LoginClient.Result.Code) (obj)), ((Map) (obj2)), ((Exception) (obj3)), true, request);
        finishLogin(((AccessToken) (obj1)), request, ((FacebookException) (obj3)), flag, facebookcallback);
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

    public void resolveError(Activity activity, GraphResponse graphresponse)
    {
        startLogin(new ActivityStartActivityDelegate(activity), createLoginRequestFromResponse(graphresponse));
    }

    public void resolveError(Fragment fragment, GraphResponse graphresponse)
    {
        resolveError(new FragmentWrapper(fragment), graphresponse);
    }

    public void resolveError(android.support.v4.app.Fragment fragment, GraphResponse graphresponse)
    {
        resolveError(new FragmentWrapper(fragment), graphresponse);
    }

    public LoginManager setDefaultAudience(DefaultAudience defaultaudience)
    {
        defaultAudience = defaultaudience;
        return this;
    }

    public LoginManager setLoginBehavior(LoginBehavior loginbehavior)
    {
        loginBehavior = loginbehavior;
        return this;
    }

}

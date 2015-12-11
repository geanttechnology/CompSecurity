// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.auth;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import java.util.Collection;
import org.json.JSONObject;

public class FacebookService
{
    public static interface SessionOpenCallback
    {

        public abstract void onOpened();
    }

    public static interface UserCallback
    {

        public abstract void error();

        public abstract void success(JSONObject jsonobject);
    }


    private static final String TAG = "FacebookService";
    CallbackManager callbackManager;

    public FacebookService()
    {
    }

    public String getToken()
    {
        if (AccessToken.getCurrentAccessToken() == null)
        {
            return null;
        } else
        {
            return AccessToken.getCurrentAccessToken().getToken();
        }
    }

    public void getUser(final UserCallback callback)
    {
        GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new com.facebook.GraphRequest.GraphJSONObjectCallback() {

            final FacebookService this$0;
            final UserCallback val$callback;

            public void onCompleted(JSONObject jsonobject, GraphResponse graphresponse)
            {
                if (jsonobject != null)
                {
                    callback.success(jsonobject);
                } else
                if (graphresponse.getError() != null)
                {
                    callback.error();
                    return;
                }
            }

            
            {
                this$0 = FacebookService.this;
                callback = usercallback;
                super();
            }
        }).executeAsync();
    }

    public boolean isSessionOpened()
    {
        return getToken() != null;
    }

    public void logActivate(Activity activity)
    {
        if ("b4m".equals("production"))
        {
            AppEventsLogger.activateApp(activity);
        }
    }

    public void logDeactivate(Activity activity)
    {
        if ("b4m".equals("production"))
        {
            AppEventsLogger.deactivateApp(activity);
        }
    }

    public void logout()
    {
        LoginManager.getInstance().logOut();
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (callbackManager != null)
        {
            callbackManager.onActivityResult(i, j, intent);
        }
    }

    public void openActiveSession(Activity activity, boolean flag, final SessionOpenCallback openCallback, Collection collection)
    {
        if (callbackManager == null)
        {
            openCallback = new FacebookCallback() {

                final FacebookService this$0;
                final SessionOpenCallback val$openCallback;

                public void onCancel()
                {
                }

                public void onError(FacebookException facebookexception)
                {
                    Log.e("FacebookService", (new StringBuilder()).append("Facebook login failed: ").append(facebookexception.getMessage()).toString());
                }

                public void onSuccess(LoginResult loginresult)
                {
                    if (loginresult.getAccessToken() != null)
                    {
                        openCallback.onOpened();
                    }
                }

                public volatile void onSuccess(Object obj)
                {
                    onSuccess((LoginResult)obj);
                }

            
            {
                this$0 = FacebookService.this;
                openCallback = sessionopencallback;
                super();
            }
            };
            callbackManager = com.facebook.CallbackManager.Factory.create();
            LoginManager.getInstance().registerCallback(callbackManager, openCallback);
        }
        if (flag)
        {
            LoginManager.getInstance().logInWithReadPermissions(activity, collection);
        }
    }
}

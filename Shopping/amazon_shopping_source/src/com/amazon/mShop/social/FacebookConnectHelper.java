// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.social;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.web.MShopWebView;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.Settings;
import com.facebook.internal.Utility;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.mShop.social:
//            SocialConnectHelper

public class FacebookConnectHelper
{
    public class FacebookConnectCallback
    {

        private String jsFailureCallback;
        private String jsSuccessCallback;
        final FacebookConnectHelper this$0;
        private MShopWebView webView;

        private void callBackWebView(String s)
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(s. new Runnable() {

                final FacebookConnectCallback this$1;
                final String val$callbackUrl;

                public void run()
                {
                    webView.loadUrl(callbackUrl);
                }

            
            {
                this$1 = final_facebookconnectcallback;
                callbackUrl = String.this;
                super();
            }
            });
        }

        public void executeFailureCallback(String s)
        {
            callBackWebView((new StringBuilder()).append(jsFailureCallback).append("('").append(s).append("')").toString());
        }

        public void executeSuccessCallback(String s)
        {
            callBackWebView((new StringBuilder()).append(jsSuccessCallback).append("('").append(s).append("')").toString());
        }


        public FacebookConnectCallback(MShopWebView mshopwebview, String s, String s1)
        {
            this$0 = FacebookConnectHelper.this;
            super();
            webView = mshopwebview;
            jsSuccessCallback = (new StringBuilder()).append("javascript:").append(s).toString();
            jsFailureCallback = (new StringBuilder()).append("javascript:").append(s1).toString();
        }
    }


    protected static final boolean DEBUG_ENABLED = DebugSettings.isDebugEnabled();
    private FacebookConnectCallback callback;
    private Context context;
    private List publishPermissions;
    private List readPermissions;

    public FacebookConnectHelper()
    {
        readPermissions = new ArrayList();
        publishPermissions = new ArrayList();
    }

    private void onSessionStateChange(Session session, SessionState sessionstate, Exception exception)
    {
        if (DEBUG_ENABLED)
        {
            Log.d("FacebookConnectActivity", (new StringBuilder()).append("Facebook session state changed: ").append(session).append(":").append(session.getDeclinedPermissions()).append(":").append(exception).toString());
        }
        if (exception != null)
        {
            callback.executeFailureCallback(exception.getMessage());
        }
        if (!SessionState.OPENED.equals(sessionstate)) goto _L2; else goto _L1
_L1:
        if (session.getDeclinedPermissions().isEmpty()) goto _L4; else goto _L3
_L3:
        callback.executeFailureCallback("PERMISSIONS_DENIED");
_L6:
        return;
_L4:
        if (Utility.isSubset(publishPermissions, session.getPermissions()))
        {
            callback.executeSuccessCallback(session.getAccessToken());
            return;
        } else
        {
            sessionstate = new com.facebook.Session.NewPermissionsRequest((Activity)context, publishPermissions);
            sessionstate.setCallback(new com.facebook.Session.StatusCallback() {

                final FacebookConnectHelper this$0;

                public void call(Session session1, SessionState sessionstate1, Exception exception1)
                {
                    onSessionStateChange(session1, sessionstate1, exception1);
                }

            
            {
                this$0 = FacebookConnectHelper.this;
                super();
            }
            });
            session.requestNewPublishPermissions(sessionstate);
            return;
        }
_L2:
        if (SessionState.OPENED_TOKEN_UPDATED.equals(sessionstate))
        {
            callback.executeSuccessCallback(session.getAccessToken());
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void launchFacebookLogin(MShopWebView mshopwebview, Bundle bundle, Context context1)
    {
        context = context1;
        Settings.setPlatformCompatibilityEnabled(true);
        String s1 = (String)bundle.get("permissions");
        String s = (String)bundle.get("appID");
        callback = new FacebookConnectCallback(mshopwebview, (String)bundle.get("successCallback"), (String)bundle.get("failureCallback"));
        if (!SocialConnectHelper.isFacebookSDKLoaded())
        {
            callback.executeFailureCallback("FB_SDK_LOAD_FAILED");
            return;
        }
        mshopwebview = s1.split(",");
        int j = mshopwebview.length;
        int i = 0;
        while (i < j) 
        {
            bundle = mshopwebview[i];
            if (Session.isPublishPermission(bundle))
            {
                publishPermissions.add(bundle);
            } else
            {
                readPermissions.add(bundle);
            }
            i++;
        }
        bundle = (new com.facebook.Session.Builder(context1)).setApplicationId(s).build();
        mshopwebview = bundle;
        if (bundle.getState() == SessionState.CREATED_TOKEN_LOADED)
        {
            bundle.closeAndClearTokenInformation();
            mshopwebview = (new com.facebook.Session.Builder(context1)).setApplicationId(s).build();
        }
        Session.setActiveSession(mshopwebview);
        mshopwebview.openForRead((new com.facebook.Session.OpenRequest((Activity)context1)).setCallback(new com.facebook.Session.StatusCallback() {

            final FacebookConnectHelper this$0;

            public void call(Session session, SessionState sessionstate, Exception exception)
            {
                onSessionStateChange(session, sessionstate, exception);
            }

            
            {
                this$0 = FacebookConnectHelper.this;
                super();
            }
        }).setPermissions(readPermissions));
    }


}

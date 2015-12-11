// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.b.h;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.Date;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.facebook:
//            GraphRequest, HttpMethod, FacebookSdk, AccessTokenCache, 
//            GraphRequestBatch, AccessToken, AccessTokenSource

final class AccessTokenManager
{

    static final String ACTION_CURRENT_ACCESS_TOKEN_CHANGED = "com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED";
    static final String EXTRA_NEW_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN";
    static final String EXTRA_OLD_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN";
    private static final String ME_PERMISSIONS_GRAPH_PATH = "me/permissions";
    static final String SHARED_PREFERENCES_NAME = "com.facebook.AccessTokenManager.SharedPreferences";
    static final String TAG = "AccessTokenManager";
    private static final String TOKEN_EXTEND_GRAPH_PATH = "oauth/access_token";
    private static final int TOKEN_EXTEND_RETRY_SECONDS = 3600;
    private static final int TOKEN_EXTEND_THRESHOLD_SECONDS = 0x15180;
    private static volatile AccessTokenManager instance;
    private final AccessTokenCache accessTokenCache;
    private AccessToken currentAccessToken;
    private Date lastAttemptedTokenExtendDate;
    private final h localBroadcastManager;
    private AtomicBoolean tokenRefreshInProgress;

    AccessTokenManager(h h1, AccessTokenCache accesstokencache)
    {
        tokenRefreshInProgress = new AtomicBoolean(false);
        lastAttemptedTokenExtendDate = new Date(0L);
        Validate.notNull(h1, "localBroadcastManager");
        Validate.notNull(accesstokencache, "accessTokenCache");
        localBroadcastManager = h1;
        accessTokenCache = accesstokencache;
    }

    private static GraphRequest createExtendAccessTokenRequest(AccessToken accesstoken, GraphRequest.Callback callback)
    {
        Bundle bundle = new Bundle();
        bundle.putString("grant_type", "fb_extend_sso_token");
        return new GraphRequest(accesstoken, "oauth/access_token", bundle, HttpMethod.GET, callback);
    }

    private static GraphRequest createGrantedPermissionsRequest(AccessToken accesstoken, GraphRequest.Callback callback)
    {
        return new GraphRequest(accesstoken, "me/permissions", new Bundle(), HttpMethod.GET, callback);
    }

    static AccessTokenManager getInstance()
    {
        if (instance != null) goto _L2; else goto _L1
_L1:
        com/facebook/AccessTokenManager;
        JVM INSTR monitorenter ;
        if (instance == null)
        {
            instance = new AccessTokenManager(h.a(FacebookSdk.getApplicationContext()), new AccessTokenCache());
        }
        com/facebook/AccessTokenManager;
        JVM INSTR monitorexit ;
_L2:
        return instance;
        Exception exception;
        exception;
        com/facebook/AccessTokenManager;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void refreshCurrentAccessTokenImpl()
    {
        final AccessToken accessToken;
        for (accessToken = currentAccessToken; accessToken == null || !tokenRefreshInProgress.compareAndSet(false, true);)
        {
            return;
        }

        Validate.runningOnUiThread();
        lastAttemptedTokenExtendDate = new Date();
        final HashSet permissions = new HashSet();
        final HashSet declinedPermissions = new HashSet();
        final AtomicBoolean permissionsCallSucceeded = new AtomicBoolean(false);
        final RefreshResult refreshResult = new RefreshResult(null);
        GraphRequestBatch graphrequestbatch = new GraphRequestBatch(new GraphRequest[] {
            createGrantedPermissionsRequest(accessToken, new _cls2()), createExtendAccessTokenRequest(accessToken, new _cls3())
        });
        graphrequestbatch.addCallback(new _cls4());
        graphrequestbatch.executeAsync();
    }

    private void sendCurrentAccessTokenChangedBroadcast(AccessToken accesstoken, AccessToken accesstoken1)
    {
        Intent intent = new Intent("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN", accesstoken);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN", accesstoken1);
        localBroadcastManager.a(intent);
    }

    private void setCurrentAccessToken(AccessToken accesstoken, boolean flag)
    {
        AccessToken accesstoken1 = currentAccessToken;
        currentAccessToken = accesstoken;
        tokenRefreshInProgress.set(false);
        lastAttemptedTokenExtendDate = new Date(0L);
        if (flag)
        {
            if (accesstoken != null)
            {
                accessTokenCache.save(accesstoken);
            } else
            {
                accessTokenCache.clear();
                Utility.clearFacebookCookies(FacebookSdk.getApplicationContext());
            }
        }
        if (!Utility.areObjectsEqual(accesstoken1, accesstoken))
        {
            sendCurrentAccessTokenChangedBroadcast(accesstoken1, accesstoken);
        }
    }

    private boolean shouldExtendAccessToken()
    {
        if (currentAccessToken != null)
        {
            Long long1 = Long.valueOf((new Date()).getTime());
            if (currentAccessToken.getSource().canExtendToken() && long1.longValue() - lastAttemptedTokenExtendDate.getTime() > 0x36ee80L && long1.longValue() - currentAccessToken.getLastRefresh().getTime() > 0x5265c00L)
            {
                return true;
            }
        }
        return false;
    }

    final void extendAccessTokenIfNeeded()
    {
        if (!shouldExtendAccessToken())
        {
            return;
        } else
        {
            refreshCurrentAccessToken();
            return;
        }
    }

    final AccessToken getCurrentAccessToken()
    {
        return currentAccessToken;
    }

    final boolean loadCurrentAccessToken()
    {
        boolean flag = false;
        AccessToken accesstoken = accessTokenCache.load();
        if (accesstoken != null)
        {
            setCurrentAccessToken(accesstoken, false);
            flag = true;
        }
        return flag;
    }

    final void refreshCurrentAccessToken()
    {
        if (Looper.getMainLooper().equals(Looper.myLooper()))
        {
            refreshCurrentAccessTokenImpl();
            return;
        } else
        {
            (new Handler(Looper.getMainLooper())).post(new _cls1());
            return;
        }
    }

    final void setCurrentAccessToken(AccessToken accesstoken)
    {
        setCurrentAccessToken(accesstoken, true);
    }



    private class RefreshResult
    {

        public String accessToken;
        public int expiresAt;

        private RefreshResult()
        {
        }

        RefreshResult(_cls1 _pcls1)
        {
            this();
        }
    }


    private class _cls2
        implements GraphRequest.Callback
    {

        final AccessTokenManager this$0;
        final Set val$declinedPermissions;
        final Set val$permissions;
        final AtomicBoolean val$permissionsCallSucceeded;

        public void onCompleted(GraphResponse graphresponse)
        {
            graphresponse = graphresponse.getJSONObject();
            if (graphresponse != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            if ((graphresponse = graphresponse.optJSONArray("data")) != null)
            {
                permissionsCallSucceeded.set(true);
                int i = 0;
                while (i < graphresponse.length()) 
                {
                    Object obj = graphresponse.optJSONObject(i);
                    if (obj != null)
                    {
                        String s = ((JSONObject) (obj)).optString("permission");
                        obj = ((JSONObject) (obj)).optString("status");
                        if (!Utility.isNullOrEmpty(s) && !Utility.isNullOrEmpty(((String) (obj))))
                        {
                            obj = ((String) (obj)).toLowerCase(Locale.US);
                            if (((String) (obj)).equals("granted"))
                            {
                                permissions.add(s);
                            } else
                            if (((String) (obj)).equals("declined"))
                            {
                                declinedPermissions.add(s);
                            } else
                            {
                                Log.w("AccessTokenManager", (new StringBuilder("Unexpected status: ")).append(((String) (obj))).toString());
                            }
                        }
                    }
                    i++;
                }
            }
            if (true) goto _L1; else goto _L3
_L3:
        }

        _cls2()
        {
            this$0 = AccessTokenManager.this;
            permissionsCallSucceeded = atomicboolean;
            permissions = set;
            declinedPermissions = set1;
            super();
        }
    }


    private class _cls3
        implements GraphRequest.Callback
    {

        final AccessTokenManager this$0;
        final RefreshResult val$refreshResult;

        public void onCompleted(GraphResponse graphresponse)
        {
            graphresponse = graphresponse.getJSONObject();
            if (graphresponse == null)
            {
                return;
            } else
            {
                refreshResult.accessToken = graphresponse.optString("access_token");
                refreshResult.expiresAt = graphresponse.optInt("expires_at");
                return;
            }
        }

        _cls3()
        {
            this$0 = AccessTokenManager.this;
            refreshResult = refreshresult;
            super();
        }
    }


    private class _cls4
        implements GraphRequestBatch.Callback
    {

        final AccessTokenManager this$0;
        final AccessToken val$accessToken;
        final Set val$declinedPermissions;
        final Set val$permissions;
        final AtomicBoolean val$permissionsCallSucceeded;
        final RefreshResult val$refreshResult;

        public void onBatchCompleted(GraphRequestBatch graphrequestbatch)
        {
            if (AccessTokenManager.getInstance().getCurrentAccessToken() == null || AccessTokenManager.getInstance().getCurrentAccessToken().getUserId() != accessToken.getUserId())
            {
                return;
            }
            int i;
            if (permissionsCallSucceeded.get() || refreshResult.accessToken != null)
            {
                break MISSING_BLOCK_LABEL_75;
            }
            i = refreshResult.expiresAt;
            if (i == 0)
            {
                tokenRefreshInProgress.set(false);
                return;
            }
            if (refreshResult.accessToken == null) goto _L2; else goto _L1
_L1:
            graphrequestbatch = refreshResult.accessToken;
_L9:
            String s;
            String s1;
            s = accessToken.getApplicationId();
            s1 = accessToken.getUserId();
            if (!permissionsCallSucceeded.get()) goto _L4; else goto _L3
_L3:
            Set set = permissions;
_L10:
            if (!permissionsCallSucceeded.get()) goto _L6; else goto _L5
_L5:
            Set set1 = declinedPermissions;
_L11:
            AccessTokenSource accesstokensource = accessToken.getSource();
            if (refreshResult.expiresAt == 0) goto _L8; else goto _L7
_L7:
            Date date = new Date((long)refreshResult.expiresAt * 1000L);
_L12:
            graphrequestbatch = new AccessToken(graphrequestbatch, s, s1, set, set1, accesstokensource, date, new Date());
            AccessTokenManager.getInstance().setCurrentAccessToken(graphrequestbatch);
            tokenRefreshInProgress.set(false);
            return;
_L2:
            graphrequestbatch = accessToken.getToken();
              goto _L9
_L4:
            set = accessToken.getPermissions();
              goto _L10
_L6:
            set1 = accessToken.getDeclinedPermissions();
              goto _L11
_L8:
            date = accessToken.getExpires();
              goto _L12
            graphrequestbatch;
            tokenRefreshInProgress.set(false);
            throw graphrequestbatch;
              goto _L9
        }

        _cls4()
        {
            this$0 = AccessTokenManager.this;
            accessToken = accesstoken;
            permissionsCallSucceeded = atomicboolean;
            refreshResult = refreshresult;
            permissions = set;
            declinedPermissions = set1;
            super();
        }
    }


    private class _cls1
        implements Runnable
    {

        final AccessTokenManager this$0;

        public void run()
        {
            refreshCurrentAccessTokenImpl();
        }

        _cls1()
        {
            this$0 = AccessTokenManager.this;
            super();
        }
    }

}

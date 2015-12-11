// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.facebook:
//            GraphRequest, HttpMethod, FacebookSdk, AccessTokenCache, 
//            FacebookException, GraphRequestBatch, AccessToken, AccessTokenSource, 
//            GraphResponse

final class AccessTokenManager
{
    private static class RefreshResult
    {

        public String accessToken;
        public int expiresAt;

        private RefreshResult()
        {
        }

    }


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
    private final LocalBroadcastManager localBroadcastManager;
    private AtomicBoolean tokenRefreshInProgress;

    AccessTokenManager(LocalBroadcastManager localbroadcastmanager, AccessTokenCache accesstokencache)
    {
        tokenRefreshInProgress = new AtomicBoolean(false);
        lastAttemptedTokenExtendDate = new Date(0L);
        Validate.notNull(localbroadcastmanager, "localBroadcastManager");
        Validate.notNull(accesstokencache, "accessTokenCache");
        localBroadcastManager = localbroadcastmanager;
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
            instance = new AccessTokenManager(LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext()), new AccessTokenCache());
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

    private void refreshCurrentAccessTokenImpl(final AccessToken.AccessTokenRefreshCallback callback)
    {
        final AccessToken accessToken = currentAccessToken;
        if (accessToken == null)
        {
            if (callback != null)
            {
                callback.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
            }
        } else
        if (!tokenRefreshInProgress.compareAndSet(false, true))
        {
            if (callback != null)
            {
                callback.OnTokenRefreshFailed(new FacebookException("Refresh already in progress"));
                return;
            }
        } else
        {
            lastAttemptedTokenExtendDate = new Date();
            final HashSet permissions = new HashSet();
            final HashSet declinedPermissions = new HashSet();
            final AtomicBoolean permissionsCallSucceeded = new AtomicBoolean(false);
            final RefreshResult refreshResult = new RefreshResult();
            GraphRequestBatch graphrequestbatch = new GraphRequestBatch(new GraphRequest[] {
                createGrantedPermissionsRequest(accessToken, new GraphRequest.Callback() {

                    final AccessTokenManager this$0;
                    final Set val$declinedPermissions;
                    final Set val$permissions;
                    final AtomicBoolean val$permissionsCallSucceeded;

                    public void onCompleted(GraphResponse graphresponse)
                    {
                        graphresponse = graphresponse.getJSONObject();
                        if (graphresponse != null)
                        {
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
                                                Log.w("AccessTokenManager", (new StringBuilder()).append("Unexpected status: ").append(((String) (obj))).toString());
                                            }
                                        }
                                    }
                                    i++;
                                }
                            }
                        }
                    }

            
            {
                this$0 = AccessTokenManager.this;
                permissionsCallSucceeded = atomicboolean;
                permissions = set;
                declinedPermissions = set1;
                super();
            }
                }), createExtendAccessTokenRequest(accessToken, new GraphRequest.Callback() {

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

            
            {
                this$0 = AccessTokenManager.this;
                refreshResult = refreshresult;
                super();
            }
                })
            });
            graphrequestbatch.addCallback(new GraphRequestBatch.Callback() {

                final AccessTokenManager this$0;
                final AccessToken val$accessToken;
                final AccessToken.AccessTokenRefreshCallback val$callback;
                final Set val$declinedPermissions;
                final Set val$permissions;
                final AtomicBoolean val$permissionsCallSucceeded;
                final RefreshResult val$refreshResult;

                public void onBatchCompleted(GraphRequestBatch graphrequestbatch1)
                {
                    if (AccessTokenManager.getInstance().getCurrentAccessToken() != null && AccessTokenManager.getInstance().getCurrentAccessToken().getUserId() == accessToken.getUserId()) goto _L2; else goto _L1
_L1:
                    if (callback != null)
                    {
                        callback.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
                    }
                    tokenRefreshInProgress.set(false);
                    if (callback != null && false)
                    {
                        callback.OnTokenRefreshed(null);
                    }
_L10:
                    return;
_L2:
                    if (permissionsCallSucceeded.get() || refreshResult.accessToken != null || refreshResult.expiresAt != 0)
                    {
                        break MISSING_BLOCK_LABEL_174;
                    }
                    if (callback != null)
                    {
                        callback.OnTokenRefreshFailed(new FacebookException("Failed to refresh access token"));
                    }
                    tokenRefreshInProgress.set(false);
                    if (callback != null && false)
                    {
                        callback.OnTokenRefreshed(null);
                    }
                    return;
                    if (refreshResult.accessToken == null) goto _L4; else goto _L3
_L3:
                    graphrequestbatch1 = refreshResult.accessToken;
_L11:
                    String s;
                    String s1;
                    s = accessToken.getApplicationId();
                    s1 = accessToken.getUserId();
                    if (!permissionsCallSucceeded.get()) goto _L6; else goto _L5
_L5:
                    Set set = permissions;
_L12:
                    if (!permissionsCallSucceeded.get()) goto _L8; else goto _L7
_L7:
                    Set set1 = declinedPermissions;
_L13:
                    Date date;
                    AccessTokenSource accesstokensource;
                    accesstokensource = accessToken.getSource();
                    if (refreshResult.expiresAt == 0)
                    {
                        break MISSING_BLOCK_LABEL_379;
                    }
                    date = new Date((long)refreshResult.expiresAt * 1000L);
_L14:
                    graphrequestbatch1 = new AccessToken(graphrequestbatch1, s, s1, set, set1, accesstokensource, date, new Date());
                    AccessTokenManager.getInstance().setCurrentAccessToken(graphrequestbatch1);
                    tokenRefreshInProgress.set(false);
                    if (callback == null || graphrequestbatch1 == null) goto _L10; else goto _L9
_L9:
                    callback.OnTokenRefreshed(graphrequestbatch1);
                    return;
_L4:
                    graphrequestbatch1 = accessToken.getToken();
                      goto _L11
_L6:
                    set = accessToken.getPermissions();
                      goto _L12
_L8:
                    set1 = accessToken.getDeclinedPermissions();
                      goto _L13
                    date = accessToken.getExpires();
                      goto _L14
                    Exception exception;
                    exception;
                    graphrequestbatch1 = null;
_L16:
                    tokenRefreshInProgress.set(false);
                    if (callback != null && graphrequestbatch1 != null)
                    {
                        callback.OnTokenRefreshed(graphrequestbatch1);
                    }
                    throw exception;
                    exception;
                    if (true) goto _L16; else goto _L15
_L15:
                      goto _L11
                }

            
            {
                this$0 = AccessTokenManager.this;
                accessToken = accesstoken;
                callback = accesstokenrefreshcallback;
                permissionsCallSucceeded = atomicboolean;
                refreshResult = refreshresult;
                permissions = set;
                declinedPermissions = set1;
                super();
            }
            });
            graphrequestbatch.executeAsync();
            return;
        }
    }

    private void sendCurrentAccessTokenChangedBroadcast(AccessToken accesstoken, AccessToken accesstoken1)
    {
        Intent intent = new Intent("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN", accesstoken);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN", accesstoken1);
        localBroadcastManager.sendBroadcast(intent);
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

    void extendAccessTokenIfNeeded()
    {
        if (!shouldExtendAccessToken())
        {
            return;
        } else
        {
            refreshCurrentAccessToken(null);
            return;
        }
    }

    AccessToken getCurrentAccessToken()
    {
        return currentAccessToken;
    }

    boolean loadCurrentAccessToken()
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

    void refreshCurrentAccessToken(final AccessToken.AccessTokenRefreshCallback callback)
    {
        if (Looper.getMainLooper().equals(Looper.myLooper()))
        {
            refreshCurrentAccessTokenImpl(callback);
            return;
        } else
        {
            (new Handler(Looper.getMainLooper())).post(new Runnable() {

                final AccessTokenManager this$0;
                final AccessToken.AccessTokenRefreshCallback val$callback;

                public void run()
                {
                    refreshCurrentAccessTokenImpl(callback);
                }

            
            {
                this$0 = AccessTokenManager.this;
                callback = accesstokenrefreshcallback;
                super();
            }
            });
            return;
        }
    }

    void setCurrentAccessToken(AccessToken accesstoken)
    {
        setCurrentAccessToken(accesstoken, true);
    }


}

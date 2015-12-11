// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import java.util.Date;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.facebook:
//            AccessTokenManager, AccessToken, FacebookException, GraphRequestBatch

class val.declinedPermissions
    implements lback
{

    final AccessTokenManager this$0;
    final AccessToken val$accessToken;
    final enRefreshCallback val$callback;
    final Set val$declinedPermissions;
    final Set val$permissions;
    final AtomicBoolean val$permissionsCallSucceeded;
    final freshResult val$refreshResult;

    public void onBatchCompleted(GraphRequestBatch graphrequestbatch)
    {
        if (AccessTokenManager.getInstance().getCurrentAccessToken() != null && AccessTokenManager.getInstance().getCurrentAccessToken().getUserId() == val$accessToken.getUserId()) goto _L2; else goto _L1
_L1:
        if (val$callback != null)
        {
            val$callback.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
        }
        AccessTokenManager.access$200(AccessTokenManager.this).set(false);
        if (val$callback != null && false)
        {
            val$callback.OnTokenRefreshed(null);
        }
_L10:
        return;
_L2:
        if (val$permissionsCallSucceeded.get() || val$refreshResult.accessToken != null || val$refreshResult.expiresAt != 0)
        {
            break MISSING_BLOCK_LABEL_174;
        }
        if (val$callback != null)
        {
            val$callback.OnTokenRefreshFailed(new FacebookException("Failed to refresh access token"));
        }
        AccessTokenManager.access$200(AccessTokenManager.this).set(false);
        if (val$callback != null && false)
        {
            val$callback.OnTokenRefreshed(null);
        }
        return;
        if (val$refreshResult.accessToken == null) goto _L4; else goto _L3
_L3:
        graphrequestbatch = val$refreshResult.accessToken;
_L11:
        String s;
        String s1;
        s = val$accessToken.getApplicationId();
        s1 = val$accessToken.getUserId();
        if (!val$permissionsCallSucceeded.get()) goto _L6; else goto _L5
_L5:
        Set set = val$permissions;
_L12:
        if (!val$permissionsCallSucceeded.get()) goto _L8; else goto _L7
_L7:
        Set set1 = val$declinedPermissions;
_L13:
        Date date;
        AccessTokenSource accesstokensource;
        accesstokensource = val$accessToken.getSource();
        if (val$refreshResult.expiresAt == 0)
        {
            break MISSING_BLOCK_LABEL_379;
        }
        date = new Date((long)val$refreshResult.expiresAt * 1000L);
_L14:
        graphrequestbatch = new AccessToken(graphrequestbatch, s, s1, set, set1, accesstokensource, date, new Date());
        AccessTokenManager.getInstance().setCurrentAccessToken(graphrequestbatch);
        AccessTokenManager.access$200(AccessTokenManager.this).set(false);
        if (val$callback == null || graphrequestbatch == null) goto _L10; else goto _L9
_L9:
        val$callback.OnTokenRefreshed(graphrequestbatch);
        return;
_L4:
        graphrequestbatch = val$accessToken.getToken();
          goto _L11
_L6:
        set = val$accessToken.getPermissions();
          goto _L12
_L8:
        set1 = val$accessToken.getDeclinedPermissions();
          goto _L13
        date = val$accessToken.getExpires();
          goto _L14
        Exception exception;
        exception;
        graphrequestbatch = null;
_L16:
        AccessTokenManager.access$200(AccessTokenManager.this).set(false);
        if (val$callback != null && graphrequestbatch != null)
        {
            val$callback.OnTokenRefreshed(graphrequestbatch);
        }
        throw exception;
        exception;
        if (true) goto _L16; else goto _L15
_L15:
          goto _L11
    }

    freshResult()
    {
        this$0 = final_accesstokenmanager;
        val$accessToken = accesstoken;
        val$callback = enrefreshcallback;
        val$permissionsCallSucceeded = atomicboolean;
        val$refreshResult = freshresult;
        val$permissions = set;
        val$declinedPermissions = Set.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.amazon.identity.auth.device.callback.CallbackFuture;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.utils.BundleUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.TimeUtil;
import com.amazon.identity.auth.request.AuthenticatedRequestHelpers;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            AuthenticationMethod, TokenManagement, MAPCallbackErrorException, TokenKeys, 
//            AuthenticationType, MAPFuture

class InProcessOauthAuthenticationMethod extends AuthenticationMethod
{

    private static final long GET_OAUTH_CREDENTIAL_TIME_OUT_MS;
    private static final String TAG = com/amazon/identity/auth/device/api/InProcessOauthAuthenticationMethod.getName();
    private final String mPackageName;
    private final TokenManagement mTokenManagement;

    public InProcessOauthAuthenticationMethod(Context context, String s, String s1, AuthenticationType authenticationtype)
    {
        super(context, s, authenticationtype);
        mTokenManagement = (TokenManagement)mContext.getSystemService("dcp_token_mangement");
        mPackageName = s1;
    }

    protected MAPFuture getAuthenticationBundle(Uri uri, String s, Map map, byte abyte0[], CallbackFuture callbackfuture)
        throws IOException
    {
        uri = uri.getScheme();
        if (uri == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        if ("https".equals(uri.toLowerCase(Locale.US)))
        {
            break MISSING_BLOCK_LABEL_43;
        }
        AuthenticationMethod.callbackError(callbackfuture, 3, "OAuth authentication has to be over https");
        MAPLog.w(TAG, "OAuth authentication has to be over https");
        return callbackfuture;
        uri = TokenKeys.getAccessTokenKeyForPackage(mPackageName);
        uri = mTokenManagement.getValue(mDirectedId, uri, null, GET_OAUTH_CREDENTIAL_TIME_OUT_MS);
        if (uri != null)
        {
            break MISSING_BLOCK_LABEL_151;
        }
        AuthenticationMethod.callbackError(callbackfuture, 2, "Could not authenticate request because we could not get an access token");
        MAPLog.e(TAG, "Could not authenticate request because we could not get an access token");
        return callbackfuture;
        uri;
        uri = uri.getErrorBundle();
        AuthenticationMethod.callbackError(callbackfuture, 6, (new StringBuilder("Getting Access Token failed because of callback error. Error Bundle: ")).append(BundleUtils.toString(uri)).toString());
        MAPLog.e(TAG, (new StringBuilder("Getting Access Token failed because of callback error. Error Bundle: ")).append(BundleUtils.toString(uri)).toString());
        return callbackfuture;
        s = new Bundle();
        AuthenticatedRequestHelpers.setHeaderInBundle(s, "x-amz-access-token", uri);
        if (callbackfuture == null)
        {
            break MISSING_BLOCK_LABEL_351;
        }
        callbackfuture.onSuccess(s);
        return callbackfuture;
        uri;
        Thread.currentThread().interrupt();
        AuthenticationMethod.callbackError(callbackfuture, 6, (new StringBuilder("Getting Access Token failed because of InterruptedException. This can happen if the caller kills the thread or asnc task that is calling MAP's api. Exception message: ")).append(uri.getMessage()).toString());
        MAPLog.e(TAG, (new StringBuilder("Getting Access Token failed because of InterruptedException. This can happen if the caller kills the thread or asnc task that is calling MAP's api. Exception message: ")).append(uri.getMessage()).toString(), uri);
        return callbackfuture;
        uri;
        AuthenticationMethod.callbackError(callbackfuture, 6, (new StringBuilder("Getting Access Token failed failed because of ExecutionException. This can happen when the thread or task was aborted. Exception message: ")).append(uri.getMessage()).toString());
        MAPLog.e(TAG, (new StringBuilder("Getting Access Token failed failed because of ExecutionException. This can happen when the thread or task was aborted. Exception message: ")).append(uri.getMessage()).toString(), uri);
        return callbackfuture;
        uri;
        AuthenticationMethod.callbackError(callbackfuture, 6, (new StringBuilder("Getting Access Token failed because of TimeoutException. This happens when the timeout passed into the future object occurs. Exception message: ")).append(uri.getMessage()).toString());
        MAPLog.e(TAG, (new StringBuilder("Getting Access Token failed because of TimeoutException. This happens when the timeout passed into the future object occurs. Exception message: ")).append(uri.getMessage()).toString(), uri);
        return callbackfuture;
    }

    static 
    {
        GET_OAUTH_CREDENTIAL_TIME_OUT_MS = TimeUtil.fromMinutesTo(2L, TimeUnit.MILLISECONDS);
    }
}

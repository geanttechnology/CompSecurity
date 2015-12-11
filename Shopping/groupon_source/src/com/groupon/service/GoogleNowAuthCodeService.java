// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.GoogleNowAuthState;
import com.google.android.gms.search.SearchAuth;
import com.google.android.gms.search.SearchAuthApi;
import com.groupon.foundations.service.BaseIntentService;
import com.groupon.http.GrouponOkHttpClient;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.network.HttpResponseException;
import com.groupon.receiver.GoogleNowAuthWakefulBroadcastReceiver;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.GoogleNowAuthAlarmUtil;
import com.groupon.util.ObjectMapperWrapper;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;
import java.io.IOException;
import roboguice.inject.Lazy;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.service:
//            LoginService

public class GoogleNowAuthCodeService extends BaseIntentService
{
    public static class TokenValidityResponse
    {

        public boolean valid;

        public TokenValidityResponse()
        {
        }
    }

    public static class UpdateTokenRequestBody
    {

        public final String authorizationCode;
        public final String consumerId;

        public UpdateTokenRequestBody(String s, String s1)
        {
            consumerId = s;
            authorizationCode = s1;
        }
    }


    public static final int ALARM_SERVICE_REQUEST_CODE = 0;
    public static final int ALARM_SERVICE_RETRY_REQUEST_CODE = 1;
    private static final String CHECK_TOKEN_VALIDITY_EVENT_ACTION = "checkValidity";
    public static final String GOOGLE_NOW_REFRESH_AUTH_CODE_PATH = "/google-now/token/authorization-code";
    private static final String GOOGLE_NOW_REFRESH_TOKEN_EVENT_CATEGORY = "GoogleNowRefreshToken";
    public static final String GOOGLE_NOW_VERIFY_TOKEN_PATH = "/google-now/token/refresh-token/%s/verify";
    private static final String IS_VALID_TOKEN_EVENT_ACTION = "isValid";
    private static final String REQUEST_TOKEN_EVENT_ACTION = "requestToken";
    private static final String REVOKE_CREDENTIALS_URL = "https://accounts.google.com/o/oauth2/revoke?token=%s";
    private static final String SEND_TOKEN_EVENT_ACTION = "sendToken";
    private static final String SERVER_CLIENT_ID = "169314272487.apps.googleusercontent.com";
    private Context context;
    private Lazy googleNowAuthAlarmUtil;
    private Lazy grouponOkHttpClient;
    private Logger logger;
    private LoginService loginService;
    private ObjectMapperWrapper objectMapper;

    public GoogleNowAuthCodeService()
    {
        super(com/groupon/service/GoogleNowAuthCodeService.getCanonicalName());
    }

    private GoogleNowAuthState getGoogleNowToken()
    {
        GoogleApiClient googleapiclient;
        Object obj;
        obj = SearchAuth.SearchAuthApi;
        googleapiclient = (new com.google.android.gms.common.api.GoogleApiClient.Builder(context)).addApi(SearchAuth.API).build();
        googleapiclient.connect();
        Status status;
        obj = (com.google.android.gms.search.SearchAuthApi.GoogleNowAuthResult)((SearchAuthApi) (obj)).getGoogleNowAuth(googleapiclient, "169314272487.apps.googleusercontent.com").await();
        status = ((com.google.android.gms.search.SearchAuthApi.GoogleNowAuthResult) (obj)).getStatus();
        if (status == null)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        if (!status.isSuccess())
        {
            break MISSING_BLOCK_LABEL_99;
        }
        logger.logGeneralEvent("GoogleNowRefreshToken", "requestToken", "", 1, Logger.NULL_NST_FIELD);
        obj = ((com.google.android.gms.search.SearchAuthApi.GoogleNowAuthResult) (obj)).getGoogleNowAuthState();
        googleapiclient.disconnect();
        return ((GoogleNowAuthState) (obj));
        googleapiclient.disconnect();
_L2:
        logger.logGeneralEvent("GoogleNowRefreshToken", "requestToken", "", 0, Logger.NULL_NST_FIELD);
        return null;
        Object obj1;
        obj1;
        Ln.e(((Throwable) (obj1)));
        googleapiclient.disconnect();
        if (true) goto _L2; else goto _L1
_L1:
        obj1;
        googleapiclient.disconnect();
        throw obj1;
    }

    private void revokeAndRetry(String s)
        throws Exception
    {
        s = (new com.squareup.okhttp.Request.Builder()).url(String.format("https://accounts.google.com/o/oauth2/revoke?token=%s", new Object[] {
            s
        })).build();
        try
        {
            ((GrouponOkHttpClient)grouponOkHttpClient.get()).newCall(s).execute();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Ln.e(s);
        }
        s = getGoogleNowToken();
        if (s != null && !Strings.isEmpty(s.getAuthCode()))
        {
            sendAuthCodeToServer(s.getAuthCode());
        }
    }

    private void sendAuthCodeToServer(String s)
        throws Exception
    {
        logger.logGeneralEvent("GoogleNowRefreshToken", "sendToken", "", 0, Logger.NULL_NST_FIELD);
        Object obj = new UpdateTokenRequestBody(loginService.getConsumerId(), s);
        s = (new com.squareup.okhttp.Headers.Builder()).add("Content-Type", "application/json").build();
        obj = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), objectMapper.writeValueAsString(obj));
        (new SyncHttp(context, java/lang/Void, "/google-now/token/authorization-code", s, ((RequestBody) (obj)))).method("PUT").call();
    }

    private boolean verifyTokenValidity(String s)
        throws Exception
    {
        int i = 0;
        logger.logGeneralEvent("GoogleNowRefreshToken", "checkValidity", "", 0, Logger.NULL_NST_FIELD);
        boolean flag;
        try
        {
            flag = ((TokenValidityResponse)(new SyncHttp(context, com/groupon/service/GoogleNowAuthCodeService$TokenValidityResponse, String.format("/google-now/token/refresh-token/%s/verify", new Object[] {
                s
            }))).call()).valid;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            if ((s instanceof HttpResponseException) && ((HttpResponseException)s).getStatusCode() == 404)
            {
                flag = false;
            } else
            {
                throw s;
            }
        }
        s = logger;
        if (flag)
        {
            i = 1;
        }
        s.logGeneralEvent("GoogleNowRefreshToken", "isValid", "", i, Logger.NULL_NST_FIELD);
        return flag;
    }

    public void init()
    {
        grouponOkHttpClient = new Lazy(context) {

            final GoogleNowAuthCodeService this$0;

            
            {
                this$0 = GoogleNowAuthCodeService.this;
                super(context1);
            }
        };
        googleNowAuthAlarmUtil = new Lazy(context) {

            final GoogleNowAuthCodeService this$0;

            
            {
                this$0 = GoogleNowAuthCodeService.this;
                super(context1);
            }
        };
    }

    public void onHandleIntent(Intent intent)
    {
        if (!loginService.isLoggedIn()) goto _L2; else goto _L1
_L1:
        if (verifyTokenValidity(loginService.getConsumerId())) goto _L4; else goto _L3
_L3:
        GoogleNowAuthState googlenowauthstate = getGoogleNowToken();
        if (googlenowauthstate == null) goto _L4; else goto _L5
_L5:
        if (Strings.isEmpty(googlenowauthstate.getAuthCode())) goto _L7; else goto _L6
_L6:
        sendAuthCodeToServer(googlenowauthstate.getAuthCode());
_L4:
        GoogleNowAuthWakefulBroadcastReceiver.completeWakefulIntent(intent);
_L2:
        return;
_L7:
        if (TextUtils.isEmpty(googlenowauthstate.getAccessToken())) goto _L4; else goto _L8
_L8:
        revokeAndRetry(googlenowauthstate.getAccessToken());
          goto _L4
        Object obj;
        obj;
        Ln.e(((Throwable) (obj)));
        ((GoogleNowAuthAlarmUtil)googleNowAuthAlarmUtil.get()).setUpAlarmWhenException(intent);
        GoogleNowAuthWakefulBroadcastReceiver.completeWakefulIntent(intent);
        return;
        obj;
        GoogleNowAuthWakefulBroadcastReceiver.completeWakefulIntent(intent);
        throw obj;
    }
}

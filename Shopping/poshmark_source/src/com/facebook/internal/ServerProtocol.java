// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.Collection;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook.internal:
//            Utility, BundleJSONConverter, Logger

public final class ServerProtocol
{

    private static final String DIALOG_AUTHORITY_FORMAT = "m.%s";
    public static final String DIALOG_CANCEL_URI = "fbconnect://cancel";
    public static final String DIALOG_PARAM_ACCESS_TOKEN = "access_token";
    public static final String DIALOG_PARAM_APP_ID = "app_id";
    public static final String DIALOG_PARAM_AUTH_TYPE = "auth_type";
    public static final String DIALOG_PARAM_CLIENT_ID = "client_id";
    public static final String DIALOG_PARAM_DEFAULT_AUDIENCE = "default_audience";
    public static final String DIALOG_PARAM_DISPLAY = "display";
    public static final String DIALOG_PARAM_DISPLAY_TOUCH = "touch";
    public static final String DIALOG_PARAM_E2E = "e2e";
    public static final String DIALOG_PARAM_LEGACY_OVERRIDE = "legacy_override";
    public static final String DIALOG_PARAM_REDIRECT_URI = "redirect_uri";
    public static final String DIALOG_PARAM_RESPONSE_TYPE = "response_type";
    public static final String DIALOG_PARAM_RETURN_SCOPES = "return_scopes";
    public static final String DIALOG_PARAM_SCOPE = "scope";
    public static final String DIALOG_PARAM_SDK_VERSION = "sdk";
    public static final String DIALOG_PATH = "dialog/";
    public static final String DIALOG_REDIRECT_URI = "fbconnect://success";
    public static final String DIALOG_REREQUEST_AUTH_TYPE = "rerequest";
    public static final String DIALOG_RESPONSE_TYPE_TOKEN_AND_SIGNED_REQUEST = "token,signed_request";
    public static final String DIALOG_RETURN_SCOPES_TRUE = "true";
    public static final String FALLBACK_DIALOG_DISPLAY_VALUE_TOUCH = "touch";
    public static final String FALLBACK_DIALOG_PARAM_APP_ID = "app_id";
    public static final String FALLBACK_DIALOG_PARAM_BRIDGE_ARGS = "bridge_args";
    public static final String FALLBACK_DIALOG_PARAM_KEY_HASH = "android_key_hash";
    public static final String FALLBACK_DIALOG_PARAM_METHOD_ARGS = "method_args";
    public static final String FALLBACK_DIALOG_PARAM_METHOD_RESULTS = "method_results";
    public static final String FALLBACK_DIALOG_PARAM_VERSION = "version";
    public static final String GRAPH_API_VERSION = "v2.4";
    private static final String GRAPH_URL_FORMAT = "https://graph.%s";
    private static final String GRAPH_VIDEO_URL_FORMAT = "https://graph-video.%s";
    private static final String TAG = com/facebook/internal/ServerProtocol.getName();
    public static final String errorConnectionFailure = "CONNECTION_FAILURE";
    public static final Collection errorsProxyAuthDisabled = Utility.unmodifiableCollection(new String[] {
        "service_disabled", "AndroidAuthKillSwitchException"
    });
    public static final Collection errorsUserCanceled = Utility.unmodifiableCollection(new String[] {
        "access_denied", "OAuthAccessDeniedException"
    });

    public ServerProtocol()
    {
    }

    public static final String getAPIVersion()
    {
        return "v2.4";
    }

    public static final String getDialogAuthority()
    {
        return String.format("m.%s", new Object[] {
            FacebookSdk.getFacebookDomain()
        });
    }

    public static final String getGraphUrlBase()
    {
        return String.format("https://graph.%s", new Object[] {
            FacebookSdk.getFacebookDomain()
        });
    }

    public static final String getGraphVideoUrlBase()
    {
        return String.format("https://graph-video.%s", new Object[] {
            FacebookSdk.getFacebookDomain()
        });
    }

    public static Bundle getQueryParamsForPlatformActivityIntentWebFallback(String s, int i, Bundle bundle)
    {
        Object obj;
        obj = FacebookSdk.getApplicationSignature(FacebookSdk.getApplicationContext());
        if (Utility.isNullOrEmpty(((String) (obj))))
        {
            return null;
        }
        Bundle bundle1 = new Bundle();
        bundle1.putString("android_key_hash", ((String) (obj)));
        bundle1.putString("app_id", FacebookSdk.getApplicationId());
        bundle1.putInt("version", i);
        bundle1.putString("display", "touch");
        obj = new Bundle();
        ((Bundle) (obj)).putString("action_id", s);
        s = bundle;
        if (bundle == null)
        {
            s = new Bundle();
        }
        try
        {
            obj = BundleJSONConverter.convertToJSON(((Bundle) (obj)));
            bundle = BundleJSONConverter.convertToJSON(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Logger.log(LoggingBehavior.DEVELOPER_ERRORS, 6, TAG, (new StringBuilder()).append("Error creating Url -- ").append(s).toString());
            return null;
        }
        if (obj != null && bundle != null) goto _L2; else goto _L1
_L2:
        if (obj instanceof JSONObject) goto _L4; else goto _L3
_L3:
        s = ((JSONObject) (obj)).toString();
_L9:
        bundle1.putString("bridge_args", s);
        if (bundle instanceof JSONObject) goto _L6; else goto _L5
_L5:
        s = bundle.toString();
_L7:
        bundle1.putString("method_args", s);
        return bundle1;
_L4:
        s = JSONObjectInstrumentation.toString((JSONObject)obj);
        continue; /* Loop/switch isn't completed */
_L6:
        s = JSONObjectInstrumentation.toString((JSONObject)bundle);
          goto _L7
_L1:
        return null;
        if (true) goto _L9; else goto _L8
_L8:
    }

}

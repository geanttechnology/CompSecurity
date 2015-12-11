// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsLogger;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook.login:
//            LoginBehavior, LoginClient, DefaultAudience

class LoginLogger
{

    private final AppEventsLogger appEventsLogger;
    private String applicationId;

    LoginLogger(Context context, String s)
    {
        applicationId = s;
        appEventsLogger = AppEventsLogger.newLogger(context, s);
    }

    static Bundle newAuthorizationLoggingBundle(String s)
    {
        Bundle bundle = new Bundle();
        bundle.putLong("1_timestamp_ms", System.currentTimeMillis());
        bundle.putString("0_auth_logger_id", s);
        bundle.putString("3_method", "");
        bundle.putString("2_result", "");
        bundle.putString("5_error_message", "");
        bundle.putString("4_error_code", "");
        bundle.putString("6_extras", "");
        return bundle;
    }

    public String getApplicationId()
    {
        return applicationId;
    }

    public void logAuthorizationMethodComplete(String s, String s1, String s2, String s3, String s4, Map map)
    {
        s = newAuthorizationLoggingBundle(s);
        if (s2 != null)
        {
            s.putString("2_result", s2);
        }
        if (s3 != null)
        {
            s.putString("5_error_message", s3);
        }
        if (s4 != null)
        {
            s.putString("4_error_code", s4);
        }
        if (map != null && !map.isEmpty())
        {
            s.putString("6_extras", (new JSONObject(map)).toString());
        }
        s.putString("3_method", s1);
        appEventsLogger.logSdkEvent("fb_mobile_login_method_complete", null, s);
    }

    public void logAuthorizationMethodStart(String s, String s1)
    {
        s = newAuthorizationLoggingBundle(s);
        s.putString("3_method", s1);
        appEventsLogger.logSdkEvent("fb_mobile_login_method_start", null, s);
    }

    public void logCompleteLogin(String s, Map map, LoginClient.Result.Code code, Map map1, Exception exception)
    {
        Bundle bundle;
        bundle = newAuthorizationLoggingBundle(s);
        if (code != null)
        {
            bundle.putString("2_result", code.getLoggingValue());
        }
        if (exception != null && exception.getMessage() != null)
        {
            bundle.putString("5_error_message", exception.getMessage());
        }
        s = null;
        if (!map.isEmpty())
        {
            s = new JSONObject(map);
        }
        code = s;
        if (map1 == null) goto _L2; else goto _L1
_L1:
        map = s;
        if (s == null)
        {
            map = new JSONObject();
        }
        s = map1.entrySet().iterator();
_L3:
        code = map;
        if (!s.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        code = (java.util.Map.Entry)s.next();
        map.put((String)code.getKey(), code.getValue());
        if (true) goto _L3; else goto _L2
        s;
        code = map;
_L2:
        if (code != null)
        {
            bundle.putString("6_extras", code.toString());
        }
        appEventsLogger.logSdkEvent("fb_mobile_login_complete", null, bundle);
        return;
    }

    public void logStartLogin(LoginClient.Request request)
    {
        Bundle bundle = newAuthorizationLoggingBundle(request.getAuthId());
        try
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("login_behavior", request.getLoginBehavior().toString());
            jsonobject.put("request_code", LoginClient.getLoginRequestCode());
            jsonobject.put("permissions", TextUtils.join(",", request.getPermissions()));
            jsonobject.put("default_audience", request.getDefaultAudience().toString());
            jsonobject.put("isReauthorize", request.isRerequest());
            bundle.putString("6_extras", jsonobject.toString());
        }
        // Misplaced declaration of an exception variable
        catch (LoginClient.Request request) { }
        appEventsLogger.logSdkEvent("fb_mobile_login_start", null, bundle);
    }

    public void logUnexpectedError(String s, String s1)
    {
        logUnexpectedError(s, s1, "");
    }

    public void logUnexpectedError(String s, String s1, String s2)
    {
        Bundle bundle = newAuthorizationLoggingBundle("");
        bundle.putString("2_result", LoginClient.Result.Code.ERROR.getLoggingValue());
        bundle.putString("5_error_message", s1);
        bundle.putString("3_method", s2);
        appEventsLogger.logSdkEvent(s, null, bundle);
    }
}

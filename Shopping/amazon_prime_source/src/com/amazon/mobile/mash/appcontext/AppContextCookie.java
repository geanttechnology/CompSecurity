// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.appcontext;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.amazon.mobile.mash.util.MASHDebug;
import com.amazon.mobile.mash.util.Util;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.mobile.mash.appcontext:
//            AppContext

public final class AppContextCookie
{

    public static final String APP_CTXT_COOKIE_KEY = "amzn-app-ctxt";
    private static final String TAG = com/amazon/mobile/mash/appcontext/AppContextCookie.getSimpleName();
    private final AppContext mAppContext;

    public AppContextCookie(AppContext appcontext)
    {
        mAppContext = appcontext;
    }

    private String buildCookieValue(Context context)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(mAppContext.getAppContextSchemaVersion());
        stringbuilder.append(" ");
        stringbuilder.append(getAppContextInfo(context).toString());
        return Uri.encode(stringbuilder.toString());
    }

    private JSONObject getAppContextInfo(Context context)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("an", mAppContext.getAppName());
            jsonobject.put("av", mAppContext.getAppVersion());
            jsonobject.put("xv", mAppContext.getMASHApiVersion());
            jsonobject.put("os", mAppContext.getOSName());
            jsonobject.put("ov", mAppContext.getOSVersion());
            jsonobject.put("cp", mAppContext.getCapability());
            jsonobject.put("uiv", mAppContext.getMASHUrlIntercepterVersion());
            JSONObject jsonobject1 = new JSONObject();
            jsonobject.put("di", jsonobject1);
            jsonobject1.put("pr", mAppContext.getDeviceProductLine());
            jsonobject1.put("md", mAppContext.getDeviceModal());
            jsonobject1.put("v", mAppContext.getDeviceModalVersion());
            jsonobject1.put("mf", mAppContext.getDeviceManufacturer());
            jsonobject1.put("dsn", mAppContext.getDeviceDmsSerialNumber());
            jsonobject1.put("dti", mAppContext.getDeviceDmsDeviceType());
            jsonobject1.put("ca", mAppContext.getDeviceCarrier(context));
            jsonobject1.put("ct", mAppContext.getDeviceConnectionType(context));
            jsonobject1 = new JSONObject();
            jsonobject.put("dm", jsonobject1);
            jsonobject1.put("w", mAppContext.getDeviceDisplayWidth(context));
            jsonobject1.put("h", mAppContext.getDeviceDisplayHeight(context));
            jsonobject1.put("ld", mAppContext.getDeviceLogicalDensity(context));
            jsonobject1.put("dx", mAppContext.getDevicePhysicalDensityX(context));
            jsonobject1.put("dy", mAppContext.getDevicePhysicalDensityY(context));
            if (MASHDebug.isEnabled())
            {
                context = new JSONObject();
                jsonobject.put("dbg", context);
                if (mAppContext.getDebugWeinreServerSatus())
                {
                    context.put("weinre_server_host", mAppContext.getDebugWeinreServerHost());
                    context.put("weinre_server_port", mAppContext.getDebugWeinreServerPort());
                }
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            if (!Util.isEmpty(context.getMessage()))
            {
                Log.e(TAG, context.getMessage());
                return jsonobject;
            }
        }
        return jsonobject;
    }

    public String getCookieValue(Context context)
    {
        return buildCookieValue(context);
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import android.content.Context;
import com.facebook.LoggingBehavior;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.facebook.internal:
//            Utility, Logger, AttributionIdentifiers

public class AppEventsLoggerUtility
{

    private static final Map API_ACTIVITY_TYPE_TO_STRING = new _cls1();

    public AppEventsLoggerUtility()
    {
    }

    public static JSONObject getJSONObjectForGraphAPICall(GraphAPIActivityType graphapiactivitytype, AttributionIdentifiers attributionidentifiers, String s, boolean flag, Context context)
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("event", API_ACTIVITY_TYPE_TO_STRING.get(graphapiactivitytype));
        Utility.setAppEventAttributionParameters(jsonobject, attributionidentifiers, s, flag);
        try
        {
            Utility.setAppEventExtendedDeviceInfoParameters(jsonobject, context);
        }
        // Misplaced declaration of an exception variable
        catch (GraphAPIActivityType graphapiactivitytype)
        {
            Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Fetching extended device info parameters failed: '%s'", new Object[] {
                graphapiactivitytype.toString()
            });
        }
        jsonobject.put("application_package_name", context.getPackageName());
        return jsonobject;
    }


    /* member class not found */
    class _cls1 {}

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import com.espn.androidplayersdk.utilities.Utils;
import java.util.HashMap;
import org.apache.http.HttpEntity;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            FeedsCommListener, DeviceData, EPSDKPrefs

class this._cls1
    implements FeedsCommListener
{

    final handleError this$1;

    public void handleError(int i)
    {
        Utils.sdkLog("Device ID failed. Setting defaults.", 2, null);
        (new EPSDKPrefs()).putBooleanField("config", "isDeviceIdentified", false);
        (new EPSDKPrefs()).putField("config", "deviceType", "handset");
    }

    public void update(HttpEntity httpentity, String s)
    {
    }

    public void update(JSONObject jsonobject, String s, HashMap hashmap)
    {
        if (!jsonobject.has("access_token") || jsonobject.isNull("access_token"))
        {
            break MISSING_BLOCK_LABEL_228;
        }
        Utils.sdkLog("Device token success. Requesting device ID", 2, null);
        jsonobject = (new StringBuilder("http://api.devicedata.go.com/deviceDataWS/rs/composite-views/deviceatlas/devices/oneshot?oauth_token=")).append(jsonobject.getString("access_token")).toString();
        jsonobject = tRequest(jsonobject);
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_222;
        }
        if (!jsonobject.has("capabilities") || jsonobject.isNull("capabilities"))
        {
            break MISSING_BLOCK_LABEL_222;
        }
        Utils.sdkLog("Device Data received", 2, null);
        jsonobject = jsonobject.getJSONObject("capabilities");
        if (!jsonobject.has("isTablet") && jsonobject.isNull("isTablet"))
        {
            break MISSING_BLOCK_LABEL_216;
        }
        if ("1".equalsIgnoreCase(jsonobject.getString("isTablet")))
        {
            Utils.sdkLog("Device is a tablet", 2, null);
            (new EPSDKPrefs()).putBooleanField("config", "isDeviceIdentified", true);
            (new EPSDKPrefs()).putField("config", "deviceType", "tablet");
            return;
        }
        try
        {
            Utils.sdkLog("Device is a phone", 2, null);
            (new EPSDKPrefs()).putBooleanField("config", "isDeviceIdentified", true);
            (new EPSDKPrefs()).putField("config", "deviceType", "handset");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            Utils.sdkLog("Error: Device ID failed", 5, jsonobject);
        }
        handleError(0);
        return;
        handleError(0);
        return;
        handleError(0);
        return;
        handleError(0);
        return;
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}

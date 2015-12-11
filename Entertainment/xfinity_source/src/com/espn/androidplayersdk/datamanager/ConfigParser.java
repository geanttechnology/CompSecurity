// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import com.espn.androidplayersdk.utilities.Utils;
import java.util.HashMap;
import org.json.JSONObject;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            JSONParserAbstract, EPSDKPrefs

class ConfigParser extends JSONParserAbstract
{

    boolean sendSuccessBroadcast;

    ConfigParser()
    {
        sendSuccessBroadcast = true;
    }

    public void errorHandler(int i)
    {
        if (i == 2)
        {
            sendBroadcast("com.espn.action.CONFIG_DATA_ERROR");
        }
    }

    public void parse(JSONObject jsonobject, HashMap hashmap)
    {
        Utils.sdkLog("ConfigParser", 3, null);
        if (!jsonobject.has("status") || jsonobject.isNull("status") || !jsonobject.getString("status").equalsIgnoreCase("success")) goto _L2; else goto _L1
_L1:
        if (jsonobject.has("config") && !jsonobject.isNull("config"))
        {
            jsonobject = jsonobject.getJSONObject("config");
            if (jsonobject.has("baseApiUrl") && !jsonobject.isNull("baseApiUrl"))
            {
                (new EPSDKPrefs()).putField("config", "url", jsonobject.getString("baseApiUrl"));
            }
            if (jsonobject.has("baseVODApiUrl") && !jsonobject.isNull("baseVODApiUrl"))
            {
                (new EPSDKPrefs()).putField("config", "vodUrl", jsonobject.getString("baseVODApiUrl"));
            }
            if (jsonobject.has("eventPollingUrl") && !jsonobject.isNull("eventPollingUrl"))
            {
                (new EPSDKPrefs()).putField("config", "poolingInterval", jsonobject.getString("eventPollingUrl"));
            }
            if (jsonobject.has("apikey") && !jsonobject.isNull("apikey"))
            {
                (new EPSDKPrefs()).putField("config", "apiKey", jsonobject.getString("apikey"));
            }
            if (jsonobject.has("analytics") && !jsonobject.isNull("analytics"))
            {
                hashmap = jsonobject.getJSONObject("analytics");
                if (hashmap.has("conviva") && !hashmap.isNull("conviva"))
                {
                    JSONObject jsonobject1 = hashmap.getJSONObject("conviva");
                    if (jsonobject1.has("customerKey") && !jsonobject1.isNull("customerKey"))
                    {
                        (new EPSDKPrefs()).putField("config", "convivakey", jsonobject1.getString("customerKey"));
                    }
                    if (jsonobject1.has("playerName") && !jsonobject1.isNull("playerName"))
                    {
                        (new EPSDKPrefs()).putField("config", "playerName", jsonobject1.getString("playerName"));
                    }
                }
                if (hashmap.has("omniture") && !hashmap.isNull("omniture"))
                {
                    hashmap = hashmap.getJSONObject("omniture");
                    if (hashmap.has("trackingServer") && !hashmap.isNull("trackingServer"))
                    {
                        (new EPSDKPrefs()).putField("config", "trackingServer", hashmap.getString("trackingServer"));
                    }
                    if (hashmap.has("trackingServerSecure") && !hashmap.isNull("trackingServerSecure"))
                    {
                        (new EPSDKPrefs()).putField("config", "trackingServerSecure", hashmap.getString("trackingServerSecure"));
                    }
                    if (hashmap.has("currencyCode") && !hashmap.isNull("currencyCode"))
                    {
                        (new EPSDKPrefs()).putField("config", "currencyCode", hashmap.getString("currencyCode"));
                    }
                    if (hashmap.has("androidReportSuite") && !hashmap.isNull("androidReportSuite"))
                    {
                        (new EPSDKPrefs()).putField("config", "suite", hashmap.getString("androidReportSuite"));
                    }
                }
            }
            if (jsonobject.has("networks") && !jsonobject.isNull("networks"))
            {
                (new EPSDKPrefs()).putField("config", "network", jsonobject.getString("networks"));
            }
        }
_L6:
        if (sendSuccessBroadcast)
        {
            sendBroadcast("com.espn.action.CONFIG_UPDATED");
        }
_L3:
        return;
_L2:
        try
        {
            sendSuccessBroadcast = false;
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (HashMap hashmap) { }
        finally
        {
            if (sendSuccessBroadcast)
            {
                sendBroadcast("com.espn.action.CONFIG_UPDATED");
            }
            throw jsonobject;
        }
        if ((new StringBuilder("ConfigParser: Error: ")).append(hashmap.getMessage()).toString() == null)
        {
            break MISSING_BLOCK_LABEL_637;
        }
        jsonobject = hashmap.getMessage();
_L4:
        Utils.sdkLog(jsonobject, 5, hashmap);
        errorHandler(2);
        sendSuccessBroadcast = false;
        if (sendSuccessBroadcast)
        {
            sendBroadcast("com.espn.action.CONFIG_UPDATED");
            return;
        }
          goto _L3
        jsonobject = "";
          goto _L4
        if (true) goto _L6; else goto _L5
_L5:
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import android.content.ContentValues;
import com.espn.androidplayersdk.utilities.Utils;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            JSONParserAbstract, DataManager, FeedsDB

class SportsParser extends JSONParserAbstract
{

    boolean sendPartialErrorBroadcast;
    boolean sendSuccessBroadcast;

    SportsParser()
    {
        sendSuccessBroadcast = false;
        sendPartialErrorBroadcast = false;
    }

    public void errorHandler(int i)
    {
        if (i == 2)
        {
            sendBroadcast("com.espn.action.SPORT_DATA_ERROR");
        }
    }

    public void parse(JSONObject jsonobject, HashMap hashmap)
    {
        Utils.sdkLog("SportsParser", 3, null);
        ContentValues contentvalues;
        JSONArray jsonarray;
        int j;
        DataManager.feedsDbConn.delAllRows("sport", "sportMetaSportRelation= ?", new String[] {
            "101"
        });
        contentvalues = new ContentValues();
        jsonarray = jsonobject.getJSONArray("categories");
        j = jsonarray.length();
        if (j <= 0) goto _L2; else goto _L1
_L1:
        sendSuccessBroadcast = true;
        int i = 0;
_L17:
        if (i < j) goto _L4; else goto _L3
_L3:
        contentvalues = new ContentValues();
        if (hashmap == null)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        boolean flag = hashmap.containsKey("ttl");
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        contentvalues.put("TTL", Utils.getExpiryTime(Integer.parseInt((String)hashmap.get("ttl"))));
_L11:
        if (!jsonobject.has("omniture") || jsonobject.isNull("omniture")) goto _L6; else goto _L5
_L5:
        contentvalues.put("omnitureJason", jsonobject.getJSONObject("omniture").toString());
_L12:
        contentvalues.put("sportrelationId", "101");
        DataManager.feedsDbConn.insertOrUpdateMetaSportTable(contentvalues);
_L2:
        if (!sendSuccessBroadcast) goto _L8; else goto _L7
_L7:
        sendBroadcast("com.espn.action.SPORT_UPDATED");
_L14:
        return;
_L4:
        contentvalues.clear();
        JSONObject jsonobject1 = jsonarray.getJSONObject(i);
        if (jsonobject1.has("id") && !jsonobject1.isNull("id"))
        {
            contentvalues.put("soprtId", jsonobject1.getString("id"));
        }
        if (jsonobject1.has("name") && !jsonobject1.isNull("name"))
        {
            contentvalues.put("sportName", jsonobject1.getString("name"));
        }
        if (jsonobject1.has("abbreviation") && !jsonobject1.isNull("abbreviation"))
        {
            contentvalues.put("sportAbbre", jsonobject1.getString("abbreviation"));
        }
        contentvalues.put("sportMetaSportRelation", "101");
        DataManager.feedsDbConn.insertIntoSportsTable(contentvalues);
_L10:
        i++;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        Utils.sdkLog("SportsParser", 5, exception);
        sendSuccessBroadcast = false;
        sendPartialErrorBroadcast = true;
        if (true) goto _L10; else goto _L9
_L9:
        jsonobject;
        Utils.sdkLog("SportsParser", 5, jsonobject);
        sendSuccessBroadcast = false;
        sendPartialErrorBroadcast = false;
        errorHandler(2);
        if (sendSuccessBroadcast)
        {
            sendBroadcast("com.espn.action.SPORT_UPDATED");
            return;
        }
        continue; /* Loop/switch isn't completed */
        hashmap;
        Utils.sdkLog("SportsParser", 5, hashmap);
        contentvalues.put("TTL", "");
          goto _L11
        jsonobject;
        if (sendSuccessBroadcast)
        {
            sendBroadcast("com.espn.action.SPORT_UPDATED");
        } else
        if (sendPartialErrorBroadcast)
        {
            sendBroadcast("com.espn.action.SPORT_PARTIAL_DATA_ERROR");
        }
        throw jsonobject;
_L6:
        contentvalues.put("omnitureJason", "");
          goto _L12
        if (!sendPartialErrorBroadcast) goto _L14; else goto _L13
_L13:
        sendBroadcast("com.espn.action.SPORT_PARTIAL_DATA_ERROR");
        return;
_L8:
        if (!sendPartialErrorBroadcast) goto _L14; else goto _L15
_L15:
        sendBroadcast("com.espn.action.SPORT_PARTIAL_DATA_ERROR");
        return;
        if (true) goto _L17; else goto _L16
_L16:
    }
}

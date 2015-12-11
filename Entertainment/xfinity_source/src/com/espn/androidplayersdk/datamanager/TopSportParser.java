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

class TopSportParser extends JSONParserAbstract
{

    boolean sendPartialErrorBroadcast;
    boolean sendSuccessBroadcast;

    TopSportParser()
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
        Utils.sdkLog("TopSportParser", 3, null);
        Object obj;
        ContentValues contentvalues;
        int j;
        DataManager.feedsDbConn.delAllRows("sport", "sportMetaSportRelation= ?", new String[] {
            "102"
        });
        obj = jsonobject.getJSONArray("categories");
        contentvalues = new ContentValues();
        j = ((JSONArray) (obj)).length();
        if (j <= 0) goto _L2; else goto _L1
_L1:
        sendSuccessBroadcast = true;
        int i = 0;
_L16:
        if (i < j) goto _L4; else goto _L3
_L3:
        obj = new ContentValues();
        if (hashmap == null)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        boolean flag = hashmap.containsKey("ttl");
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        ((ContentValues) (obj)).put("TTL", Utils.getExpiryTime(Integer.parseInt((String)hashmap.get("ttl"))));
_L11:
        if (!jsonobject.has("omniture") || jsonobject.isNull("omniture")) goto _L6; else goto _L5
_L5:
        ((ContentValues) (obj)).put("omnitureJason", jsonobject.getJSONObject("omniture").toString());
_L12:
        ((ContentValues) (obj)).put("sportrelationId", "102");
        DataManager.feedsDbConn.insertOrUpdateMetaSportTable(((ContentValues) (obj)));
_L2:
        Exception exception;
        if (sendSuccessBroadcast)
        {
            sendBroadcast("com.espn.action.SPORT_UPDATED");
        } else
        if (sendPartialErrorBroadcast)
        {
            sendBroadcast("com.espn.action.SPORT_PARTIAL_DATA_ERROR");
            return;
        }
        return;
_L4:
        JSONObject jsonobject1 = ((JSONArray) (obj)).getJSONObject(i);
        contentvalues.clear();
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
        if (jsonobject1.has("leagueId") && !jsonobject1.isNull("leagueId"))
        {
            contentvalues.put("sportLeagueId", jsonobject1.getString("leagueId"));
        }
        if (jsonobject1.has("shortName") && !jsonobject1.isNull("shortName"))
        {
            contentvalues.put("sportShortName", jsonobject1.getString("shortName"));
        }
        if (jsonobject1.has("type") && !jsonobject1.isNull("type"))
        {
            contentvalues.put("sportType", jsonobject1.getString("type"));
        }
        if (jsonobject1.has("links") && !jsonobject1.isNull("links"))
        {
            jsonobject1 = jsonobject1.getJSONObject("links");
            if (jsonobject1.has("api") && !jsonobject1.isNull("api"))
            {
                jsonobject1 = jsonobject1.getJSONObject("api");
                if (jsonobject1.has("video") && !jsonobject1.isNull("video"))
                {
                    jsonobject1 = jsonobject1.getJSONObject("video");
                    if (jsonobject1.has("href") && !jsonobject1.isNull("href"))
                    {
                        contentvalues.put("sportVodUrl", (new StringBuilder(String.valueOf(jsonobject1.getString("href")))).append("?").toString());
                    }
                }
            }
        }
        if (!"subcategory".equalsIgnoreCase(contentvalues.getAsString("sportType"))) goto _L8; else goto _L7
_L7:
        contentvalues.put("sportListingUrl", (new StringBuilder("/listings?subcategories=")).append(contentvalues.getAsString("soprtId")).append("&").toString());
        contentvalues.put("sportListingtop", (new StringBuilder("subcategories/")).append(contentvalues.getAsString("sportAbbre")).append("/listings/top?").toString());
_L10:
        contentvalues.put("sportMetaSportRelation", "102");
        DataManager.feedsDbConn.insertIntoSportsTable(contentvalues);
          goto _L9
_L8:
        contentvalues.put("sportListingUrl", (new StringBuilder("/listings?categories=")).append(contentvalues.getAsString("soprtId")).append("&").toString());
        contentvalues.put("sportListingtop", (new StringBuilder("categories/")).append(contentvalues.getAsString("sportAbbre")).append("/listings/top?").toString());
          goto _L10
        exception;
        Utils.sdkLog("TopSportParser", 5, exception);
        sendSuccessBroadcast = false;
        sendPartialErrorBroadcast = true;
          goto _L9
        jsonobject;
        Utils.sdkLog("TopSportParser", 5, jsonobject);
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
        Utils.sdkLog("TopSportParser", 5, hashmap);
        ((ContentValues) (obj)).put("TTL", "");
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
        ((ContentValues) (obj)).put("omnitureJason", "");
          goto _L12
        if (!sendPartialErrorBroadcast) goto _L14; else goto _L13
_L13:
        break MISSING_BLOCK_LABEL_819;
_L14:
        break MISSING_BLOCK_LABEL_175;
        sendBroadcast("com.espn.action.SPORT_PARTIAL_DATA_ERROR");
        return;
_L9:
        i++;
        if (true) goto _L16; else goto _L15
_L15:
    }
}

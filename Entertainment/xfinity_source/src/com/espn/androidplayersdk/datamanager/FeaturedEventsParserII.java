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

class FeaturedEventsParserII extends JSONParserAbstract
{

    int contentType;
    boolean sendPartialErrorBroadcast;
    boolean sendSuccessBroadcast;

    FeaturedEventsParserII()
    {
        sendSuccessBroadcast = false;
        sendPartialErrorBroadcast = false;
        contentType = 0;
    }

    public void errorHandler(int i)
    {
        if (i == 1 || i == 2)
        {
            if (contentType == 14)
            {
                sendBroadcast("com.espn.action.FEATURED_BEST_OF_EVENT_DATA_ERROR");
            } else
            {
                if (contentType == 13)
                {
                    sendBroadcast("com.espn.action.FEATURED_MUST_SEE_EVENT_DATA_ERROR");
                    return;
                }
                if (contentType == 15)
                {
                    sendBroadcast("com.espn.action.FEATURED_TOP_VOD_EVENT_DATA_ERROR");
                    return;
                }
            }
        }
    }

    public void parse(JSONObject jsonobject, HashMap hashmap)
    {
        Utils.sdkLog("FeaturedEventsParserII", 3, null);
        ContentValues contentvalues;
        ContentValues contentvalues1;
        contentvalues1 = new ContentValues();
        contentvalues = new ContentValues();
        if (hashmap.containsKey("featuredType"))
        {
            contentType = ((Integer)hashmap.get("featuredType")).intValue();
        }
        if (hashmap.containsKey("eventWhere") && hashmap.containsKey("eventWhereArg"))
        {
            DataManager.feedsDbConn.delAllRows("featuredEvents", (String)hashmap.get("eventWhere"), (String[])hashmap.get("eventWhereArg"));
        }
        if (!jsonobject.has("videos") || jsonobject.isNull("videos")) goto _L2; else goto _L1
_L1:
        JSONArray jsonarray;
        int j;
        jsonarray = jsonobject.getJSONArray("videos");
        j = jsonarray.length();
        if (j <= 0) goto _L2; else goto _L3
_L3:
        sendSuccessBroadcast = true;
        int i = 0;
_L22:
        if (i < j) goto _L5; else goto _L4
_L4:
        if (hashmap == null) goto _L7; else goto _L6
_L6:
        boolean flag = hashmap.containsKey("ttl");
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_184;
        }
        contentvalues.put("ttl", Utils.getExpiryTime(Integer.parseInt((String)hashmap.get("ttl"))));
_L14:
        if (hashmap.containsKey("featuredType"))
        {
            contentvalues.put("eventRelationId", (Integer)hashmap.get("featuredType"));
        }
        if (hashmap.containsKey("sportId"))
        {
            contentvalues.put("sportId", (String)hashmap.get("sportId"));
        }
_L7:
        contentvalues.put("eventsType", "featuredII");
        if (jsonobject.has("omniture") && !jsonobject.isNull("omniture"))
        {
            contentvalues.put("omnitureJson", jsonobject.getJSONObject("omniture").toString());
        }
        if (jsonobject.has("resultsLimit") && !jsonobject.isNull("resultsLimit"))
        {
            contentvalues.put("count", jsonobject.getString("resultsLimit"));
        }
        DataManager.feedsDbConn.insertOrUpdateMetaEventsTable(contentvalues);
_L2:
        if (!sendSuccessBroadcast) goto _L9; else goto _L8
_L8:
        if (contentType != 14) goto _L11; else goto _L10
_L10:
        sendBroadcast("com.espn.action.FEATURED_BEST_OF_EVENT_UPDATED");
_L16:
        return;
_L5:
        contentvalues1.clear();
        JSONObject jsonobject1 = jsonarray.getJSONObject(i);
        if (jsonobject1.has("headline") && !jsonobject1.isNull("headline"))
        {
            contentvalues1.put("eventName", jsonobject1.getString("headline"));
            contentvalues1.put("showName", jsonobject1.getString("headline"));
        }
        if (jsonobject1.has("description") && !jsonobject1.isNull("description"))
        {
            contentvalues1.put("description", jsonobject1.getString("description"));
        }
        if (jsonobject1.has("id") && !jsonobject1.isNull("id"))
        {
            contentvalues1.put("eventId", jsonobject1.getString("id"));
        }
        if (jsonobject1.has("posterImages") && !jsonobject1.isNull("posterImages"))
        {
            JSONObject jsonobject2 = jsonobject1.getJSONObject("posterImages");
            if (jsonobject2.has("default") && !jsonobject2.isNull("default"))
            {
                JSONObject jsonobject4 = jsonobject2.getJSONObject("default");
                if (jsonobject4.has("href") && !jsonobject4.isNull("href"))
                {
                    contentvalues1.put("imageMed", jsonobject4.getString("href"));
                    contentvalues1.put("imageSmall", jsonobject4.getString("href"));
                }
            }
            if (jsonobject2.has("full") && !jsonobject2.isNull("full"))
            {
                jsonobject2 = jsonobject2.getJSONObject("full");
                if (jsonobject2.has("href") && !jsonobject2.isNull("href"))
                {
                    contentvalues1.put("imageLarge", jsonobject2.getString("href"));
                }
            }
        }
        if (jsonobject1.has("links") && !jsonobject1.isNull("links"))
        {
            JSONObject jsonobject3 = jsonobject1.getJSONObject("links");
            if (jsonobject3.has("source") && !jsonobject3.isNull("source"))
            {
                jsonobject3 = jsonobject3.getJSONObject("source");
                if (jsonobject3.has("HLS") && !jsonobject3.isNull("HLS"))
                {
                    jsonobject3 = jsonobject3.getJSONObject("HLS");
                    if (jsonobject3.has("href") && !jsonobject3.isNull("href"))
                    {
                        contentvalues1.put("videoURLLarge", jsonobject3.getString("href"));
                        contentvalues1.put("videoURLMed", jsonobject3.getString("href"));
                        contentvalues1.put("videoURLSmall", jsonobject3.getString("href"));
                    }
                    if (jsonobject3.has("HD") && !jsonobject3.isNull("HD"))
                    {
                        jsonobject3 = jsonobject3.getJSONObject("HD");
                        if (jsonobject3.has("href") && !jsonobject3.isNull("href"))
                        {
                            contentvalues1.put("videoURLHD", jsonobject3.getString("href"));
                        }
                    }
                }
            }
        }
        if (jsonobject1.has("duration") && !jsonobject1.isNull("duration"))
        {
            contentvalues1.put("endTime", jsonobject1.getString("duration"));
        }
        if (jsonobject1.has("tracking") && !jsonobject1.isNull("tracking"))
        {
            jsonobject1 = jsonobject1.getJSONObject("tracking");
            if (jsonobject1.has("sportName") && !jsonobject1.isNull("sportName"))
            {
                contentvalues1.put("SPORT", jsonobject1.getString("sportName"));
            }
            if (jsonobject1.has("leagueName") && !jsonobject1.isNull("leagueName"))
            {
                contentvalues1.put("leagueName", jsonobject1.getString("leagueName"));
            }
            if (jsonobject1.has("coverageType") && !jsonobject1.isNull("coverageType"))
            {
                contentvalues1.put("coverageType", jsonobject1.getString("coverageType"));
            }
        }
        contentvalues1.put("broadcastStartTime", "");
        contentvalues1.put("eventType", "VOD");
        contentvalues1.put("guid", "");
        contentvalues1.put("omnitureJson", "");
        contentvalues1.put("parentalRating", "");
        contentvalues1.put("seekInSeconds", "");
        contentvalues1.put("simulcastAiringId", "");
        contentvalues1.put("networkCode", "");
        contentvalues1.put("networkName", "");
        contentvalues1.put("networkId", "");
        contentvalues1.put("league", "");
        contentvalues1.put("startTime", "");
        contentvalues1.put("networkResourceId", "");
        if (hashmap == null)
        {
            break MISSING_BLOCK_LABEL_1180;
        }
        if (hashmap.containsKey("featuredType"))
        {
            contentvalues1.put("metaEventRelationId", (Integer)hashmap.get("featuredType"));
        }
        if (hashmap.containsKey("sportId"))
        {
            contentvalues1.put("sportId", (String)hashmap.get("sportId"));
        }
        DataManager.feedsDbConn.insertIntoFeaturedEventsTable(contentvalues1);
_L13:
        i++;
        continue; /* Loop/switch isn't completed */
        Exception exception1;
        exception1;
        Utils.sdkLog("FeaturedEventsParserII", 5, exception1);
        sendSuccessBroadcast = false;
        sendPartialErrorBroadcast = true;
        if (true) goto _L13; else goto _L12
_L12:
        jsonobject;
        Utils.sdkLog("FeaturedEventsParserII", 5, jsonobject);
        sendSuccessBroadcast = false;
        sendPartialErrorBroadcast = false;
        errorHandler(2);
        if (!sendSuccessBroadcast)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (contentType == 14)
        {
            sendBroadcast("com.espn.action.FEATURED_BEST_OF_EVENT_UPDATED");
            return;
        }
        break MISSING_BLOCK_LABEL_1312;
        Exception exception;
        exception;
        Utils.sdkLog("FeaturedEventsParserII", 5, exception);
        contentvalues.put("ttl", "");
          goto _L14
        jsonobject;
        if (sendSuccessBroadcast)
        {
            if (contentType == 14)
            {
                sendBroadcast("com.espn.action.FEATURED_BEST_OF_EVENT_UPDATED");
            } else
            if (contentType == 13)
            {
                sendBroadcast("com.espn.action.FEATURED_MUST_SEE_EVENT_UPDATED");
            } else
            if (contentType == 15)
            {
                sendBroadcast("com.espn.action.FEATURED_TOP_VOD_EVENT_UPDATED");
            }
        } else
        if (sendPartialErrorBroadcast)
        {
            if (contentType == 14)
            {
                sendBroadcast("com.espn.action.FEATURED_BEST_OF_EVENT_PARTIAL_DATA_ERROR");
            } else
            if (contentType == 13)
            {
                sendBroadcast("com.espn.action.FEATURED_MUST_SEE_EVENT_PARTIAL_DATA_ERROR");
            } else
            if (contentType == 15)
            {
                sendBroadcast("com.espn.action.FEATURED_TOP_VOD_EVENT_PARTIAL_DATA_ERROR");
            }
        }
        throw jsonobject;
        if (contentType == 13)
        {
            sendBroadcast("com.espn.action.FEATURED_MUST_SEE_EVENT_UPDATED");
            return;
        }
        if (contentType != 15) goto _L16; else goto _L15
_L15:
        sendBroadcast("com.espn.action.FEATURED_TOP_VOD_EVENT_UPDATED");
        return;
        if (!sendPartialErrorBroadcast) goto _L16; else goto _L17
_L17:
        if (contentType == 14)
        {
            sendBroadcast("com.espn.action.FEATURED_BEST_OF_EVENT_PARTIAL_DATA_ERROR");
            return;
        }
        if (contentType == 13)
        {
            sendBroadcast("com.espn.action.FEATURED_MUST_SEE_EVENT_PARTIAL_DATA_ERROR");
            return;
        }
        if (contentType == 15)
        {
            sendBroadcast("com.espn.action.FEATURED_TOP_VOD_EVENT_PARTIAL_DATA_ERROR");
            return;
        }
          goto _L16
_L11:
        if (contentType == 13)
        {
            sendBroadcast("com.espn.action.FEATURED_MUST_SEE_EVENT_UPDATED");
            return;
        }
        if (contentType != 15) goto _L16; else goto _L18
_L18:
        sendBroadcast("com.espn.action.FEATURED_TOP_VOD_EVENT_UPDATED");
        return;
_L9:
        if (!sendPartialErrorBroadcast) goto _L16; else goto _L19
_L19:
        if (contentType == 14)
        {
            sendBroadcast("com.espn.action.FEATURED_BEST_OF_EVENT_PARTIAL_DATA_ERROR");
            return;
        }
        if (contentType == 13)
        {
            sendBroadcast("com.espn.action.FEATURED_MUST_SEE_EVENT_PARTIAL_DATA_ERROR");
            return;
        }
        if (contentType != 15) goto _L16; else goto _L20
_L20:
        sendBroadcast("com.espn.action.FEATURED_TOP_VOD_EVENT_PARTIAL_DATA_ERROR");
        return;
        if (true) goto _L22; else goto _L21
_L21:
    }
}

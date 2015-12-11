// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import android.content.ContentValues;
import com.espn.androidplayersdk.utilities.EPEventType;
import com.espn.androidplayersdk.utilities.Utils;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            JSONParserAbstract, DataManager, FeedsDB

class EventsByLeagueParser extends JSONParserAbstract
{

    String contentType;
    int eventRequestType;
    boolean sendPartialErrorBroadcast;
    boolean sendSuccessBroadcast;

    EventsByLeagueParser()
    {
        sendSuccessBroadcast = false;
        sendPartialErrorBroadcast = false;
        contentType = "";
        eventRequestType = 0;
    }

    void broadcastIntent(Boolean boolean1, Boolean boolean2, Integer integer, int i)
    {
        if (boolean1 == null) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 7 8: default 28
    //                   7 29
    //                   8 98;
           goto _L3 _L4 _L5
_L3:
        return;
_L4:
        if (contentType.equals(EPEventType.LIVE.getEventStr()))
        {
            sendBroadcast("com.espn.action.SPORTEVENTSBYLEAGUE_LIVE_UPDATED");
            return;
        }
        if (contentType.equals(EPEventType.UPCOMING.getEventStr()))
        {
            sendBroadcast("com.espn.action.SPORTEVENTSBYLEAGUE_UPCOMING_UPDATED");
            return;
        }
        if (contentType.equals(EPEventType.REPLAY.getEventStr()))
        {
            sendBroadcast("com.espn.action.SPORTEVENTSBYLEAGUE_REPLAY_UPDATED");
            return;
        }
          goto _L3
_L5:
        if (contentType.equals(EPEventType.LIVE.getEventStr()))
        {
            sendBroadcast("com.espn.action.CHANNELEVENTSBYLEAGUE_LIVE_UPDATED");
            return;
        }
        if (contentType.equals(EPEventType.UPCOMING.getEventStr()))
        {
            sendBroadcast("com.espn.action.CHANNELEVENTSBYLEAGUE_UPCOMING_UPDATED");
            return;
        }
        if (!contentType.equals(EPEventType.REPLAY.getEventStr())) goto _L3; else goto _L6
_L6:
        sendBroadcast("com.espn.action.CHANNELEVENTSBYLEAGUE_REPLAY_UPDATED");
        return;
_L2:
        if (boolean2 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        switch (i)
        {
        default:
            return;

        case 7: // '\007'
            if (contentType.equals(EPEventType.LIVE.getEventStr()))
            {
                sendBroadcast("com.espn.action.SPORTEVENTSBYLEAGUE_LIVE_PARTIAL_DATA_ERROR");
                return;
            }
            if (contentType.equals(EPEventType.UPCOMING.getEventStr()))
            {
                sendBroadcast("com.espn.action.SPORTEVENTSBYLEAGUE_UPCOMING_PARTIAL_DATA_ERROR");
                return;
            }
            if (contentType.equals(EPEventType.REPLAY.getEventStr()))
            {
                sendBroadcast("com.espn.action.SPORTEVENTSBYLEAGUE_REPLAY_PARTIAL_DATA_ERROR");
                return;
            }
            break;

        case 8: // '\b'
            if (contentType.equals(EPEventType.LIVE.getEventStr()))
            {
                sendBroadcast("com.espn.action.CHANNELEVENTSBYLEAGUE_LIVE_PARTIAL_DATA_ERROR");
                return;
            }
            if (contentType.equals(EPEventType.UPCOMING.getEventStr()))
            {
                sendBroadcast("com.espn.action.CHANNELEVENTSBYLEAGUE_UPCOMING_PARTIAL_DATA_ERROR");
                return;
            }
            if (contentType.equals(EPEventType.REPLAY.getEventStr()))
            {
                sendBroadcast("com.espn.action.CHANNELEVENTSBYLEAGUE_REPLAY_PARTIAL_DATA_ERROR");
                return;
            }
            break;
        }
        continue; /* Loop/switch isn't completed */
        if (integer == null) goto _L3; else goto _L7
_L7:
        switch (i)
        {
        default:
            return;

        case 7: // '\007'
            if (contentType.equals(EPEventType.LIVE.getEventStr()))
            {
                sendBroadcast("com.espn.action.SPORTEVENTSBYLEAGUE_LIVE_DATA_ERROR");
                return;
            }
            if (contentType.equals(EPEventType.UPCOMING.getEventStr()))
            {
                sendBroadcast("com.espn.action.SPORTEVENTSBYLEAGUE_UPCOMING_DATA_ERROR");
                return;
            }
            if (contentType.equals(EPEventType.REPLAY.getEventStr()))
            {
                sendBroadcast("com.espn.action.SPORTEVENTSBYLEAGUE_REPLAY_DATA_ERROR");
                return;
            }
            break;

        case 8: // '\b'
            if (contentType.equals(EPEventType.LIVE.getEventStr()))
            {
                sendBroadcast("com.espn.action.CHANNELEVENTSBYLEAGUE_LIVE_DATA_ERROR");
                return;
            }
            if (contentType.equals(EPEventType.UPCOMING.getEventStr()))
            {
                sendBroadcast("com.espn.action.CHANNELEVENTSBYLEAGUE_UPCOMING_DATA_ERROR");
                return;
            }
            if (contentType.equals(EPEventType.REPLAY.getEventStr()))
            {
                sendBroadcast("com.espn.action.CHANNELEVENTSBYLEAGUE_REPLAY_DATA_ERROR");
                return;
            }
            break;
        }
        if (true) goto _L3; else goto _L8
_L8:
    }

    public void errorHandler(int i)
    {
        if (i == 1 || i == 2)
        {
            broadcastIntent(null, null, Integer.valueOf(i), eventRequestType);
        }
    }

    public void parse(JSONObject jsonobject, HashMap hashmap)
    {
        Utils.sdkLog("EventsByLeagueParser", 3, null);
        ContentValues contentvalues;
        ContentValues contentvalues1;
        JSONArray jsonarray;
        int l;
        contentvalues1 = new ContentValues();
        contentvalues = new ContentValues();
        if (hashmap.containsKey("eventType"))
        {
            contentType = (String)hashmap.get("eventType");
        }
        if (hashmap.containsKey("relationType"))
        {
            eventRequestType = Integer.parseInt((String)hashmap.get("relationType"));
        }
        if (hashmap.containsKey("eventWhere") && hashmap.containsKey("eventWhereArg"))
        {
            DataManager.feedsDbConn.delAllRows("events", (String)hashmap.get("eventWhere"), (String[])hashmap.get("eventWhereArg"));
        }
        jsonarray = jsonobject.getJSONArray("categories");
        l = jsonarray.length();
        if (l <= 0) goto _L2; else goto _L1
_L1:
        int i = 0;
_L27:
        if (i < l) goto _L4; else goto _L3
_L3:
        if (hashmap == null)
        {
            break MISSING_BLOCK_LABEL_183;
        }
        boolean flag = hashmap.containsKey("ttl");
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_183;
        }
        contentvalues.put("ttl", Utils.getExpiryTime(Integer.parseInt((String)hashmap.get("ttl"))));
_L19:
        if (hashmap == null)
        {
            break MISSING_BLOCK_LABEL_211;
        }
        if (hashmap.containsKey("sportId"))
        {
            contentvalues.put("sportId", (String)hashmap.get("sportId"));
        }
        if (hashmap == null) goto _L6; else goto _L5
_L5:
        if (!hashmap.containsKey("eventType")) goto _L6; else goto _L7
_L7:
        contentvalues.put("eventsType", (String)hashmap.get("eventType"));
_L20:
        if (jsonobject.has("omniture") && !jsonobject.isNull("omniture"))
        {
            contentvalues.put("omnitureJson", jsonobject.getJSONObject("omniture").toString());
        }
        if (jsonobject.has("resultsCount") && !jsonobject.isNull("resultsCount"))
        {
            contentvalues.put("count", jsonobject.getString("resultsCount"));
        }
        contentvalues.put("eventRelationId", (String)hashmap.get("relationType"));
        DataManager.feedsDbConn.insertOrUpdateMetaEventsTable(contentvalues);
_L2:
        if (!sendSuccessBroadcast) goto _L9; else goto _L8
_L8:
        broadcastIntent(Boolean.valueOf(true), null, null, eventRequestType);
_L22:
        return;
_L4:
        JSONArray jsonarray1;
        int i1;
        contentvalues1.clear();
        jsonarray1 = jsonarray.getJSONObject(i).getJSONArray("subcategories");
        i1 = jsonarray1.length();
        if (i1 <= 0) goto _L11; else goto _L10
_L10:
        int j = 0;
          goto _L12
_L25:
        Object obj;
        int j1;
        obj = jsonarray1.getJSONObject(j);
        if (((JSONObject) (obj)).has("id") && !((JSONObject) (obj)).isNull("id"))
        {
            contentvalues1.put("league", ((JSONObject) (obj)).getString("id"));
        }
        if (((JSONObject) (obj)).has("name") && !((JSONObject) (obj)).isNull("name"))
        {
            contentvalues1.put("leagueName", ((JSONObject) (obj)).getString("name"));
        }
        obj = ((JSONObject) (obj)).getJSONArray("listings");
        j1 = ((JSONArray) (obj)).length();
        if (j1 <= 0) goto _L14; else goto _L13
_L13:
        sendSuccessBroadcast = true;
        int k = 0;
_L17:
        if (k < j1) goto _L15; else goto _L14
_L14:
        j++;
        continue; /* Loop/switch isn't completed */
_L15:
        JSONObject jsonobject1 = ((JSONArray) (obj)).getJSONObject(k);
        if (jsonobject1.has("broadcastStartTime") && !jsonobject1.isNull("broadcastStartTime"))
        {
            contentvalues1.put("broadcastStartTime", jsonobject1.getString("broadcastStartTime"));
        }
        if (jsonobject1.has("description") && !jsonobject1.isNull("description"))
        {
            contentvalues1.put("description", jsonobject1.getString("description"));
        }
        if (jsonobject1.has("blackouts") && !jsonobject1.isNull("blackouts"))
        {
            contentvalues1.put("coverageType", jsonobject1.getJSONArray("blackouts").toString());
        }
        if (jsonobject1.has("categories") && !jsonobject1.isNull("categories"))
        {
            Object obj1 = jsonobject1.getJSONArray("categories");
            if (((JSONArray) (obj1)).length() > 0)
            {
                obj1 = ((JSONArray) (obj1)).getJSONObject(0);
                if (((JSONObject) (obj1)).has("name") && !((JSONObject) (obj1)).isNull("name"))
                {
                    contentvalues1.put("SPORT", ((JSONObject) (obj1)).getString("name"));
                }
                if (((JSONObject) (obj1)).has("abbreviation") && !((JSONObject) (obj1)).isNull("abbreviation"))
                {
                    contentvalues1.put("sportCode", ((JSONObject) (obj1)).getString("abbreviation"));
                }
            }
        }
        if (jsonobject1.has("program") && !jsonobject1.isNull("program"))
        {
            JSONObject jsonobject2 = jsonobject1.getJSONObject("program");
            if (jsonobject2.has("code") && !jsonobject2.isNull("code"))
            {
                contentvalues1.put("programingCode", jsonobject2.getString("code"));
            }
        }
        if (jsonobject1.has("type") && !jsonobject1.isNull("type"))
        {
            contentvalues1.put("eventType", jsonobject1.getString("type"));
        }
        if (jsonobject1.has("endTime") && !jsonobject1.isNull("endTime"))
        {
            contentvalues1.put("endTime", jsonobject1.getString("endTime"));
        }
        if (jsonobject1.has("broadcasts") && !jsonobject1.isNull("broadcasts"))
        {
            Object obj2 = jsonobject1.getJSONArray("broadcasts");
            if (((JSONArray) (obj2)).length() > 0)
            {
                obj2 = ((JSONArray) (obj2)).getJSONObject(0);
                if (((JSONObject) (obj2)).has("abbreviation") && !((JSONObject) (obj2)).isNull("abbreviation"))
                {
                    contentvalues1.put("networkCode", ((JSONObject) (obj2)).getString("abbreviation"));
                }
                if (((JSONObject) (obj2)).has("name") && !((JSONObject) (obj2)).isNull("name"))
                {
                    contentvalues1.put("networkName", ((JSONObject) (obj2)).getString("name"));
                }
                if (((JSONObject) (obj2)).has("ncsId") && !((JSONObject) (obj2)).isNull("ncsId"))
                {
                    contentvalues1.put("networkId", ((JSONObject) (obj2)).getString("ncsId"));
                    contentvalues.put("networkId", ((JSONObject) (obj2)).getString("ncsId"));
                }
                if (((JSONObject) (obj2)).has("adobeResource") && !((JSONObject) (obj2)).isNull("adobeResource"))
                {
                    contentvalues1.put("networkResourceId", ((JSONObject) (obj2)).getString("adobeResource"));
                }
            }
        }
        if (jsonobject1.has("guid") && !jsonobject1.isNull("guid"))
        {
            contentvalues1.put("guid", jsonobject1.getString("guid"));
        }
        if (jsonobject1.has("startTime") && !jsonobject1.isNull("startTime"))
        {
            contentvalues1.put("startTime", jsonobject1.getString("startTime"));
        }
        if (jsonobject1.has("id") && !jsonobject1.isNull("id"))
        {
            contentvalues1.put("eventId", jsonobject1.getString("id"));
        }
        if (jsonobject1.has("name") && !jsonobject1.isNull("name"))
        {
            contentvalues1.put("showName", jsonobject1.getString("name"));
        }
        if (jsonobject1.has("simulcastAiringId") && !jsonobject1.isNull("simulcastAiringId"))
        {
            contentvalues1.put("simulcastAiringId", jsonobject1.getString("simulcastAiringId"));
        }
        if (jsonobject1.has("seekInSeconds") && !jsonobject1.isNull("seekInSeconds"))
        {
            contentvalues1.put("seekInSeconds", jsonobject1.getString("seekInSeconds"));
        }
        if (jsonobject1.has("parentalRating") && !jsonobject1.isNull("parentalRating"))
        {
            contentvalues1.put("parentalRating", jsonobject1.getString("parentalRating"));
        }
        if (jsonobject1.has("omniture") && !jsonobject1.isNull("omniture"))
        {
            contentvalues1.put("omnitureJson", jsonobject1.getJSONObject("omniture").toString());
        }
        if (jsonobject1.has("thumbnails") && !jsonobject1.isNull("thumbnails"))
        {
            JSONObject jsonobject3 = jsonobject1.getJSONObject("thumbnails");
            if (jsonobject3.has("small") && !jsonobject3.isNull("small"))
            {
                JSONObject jsonobject7 = jsonobject3.getJSONObject("small");
                if (jsonobject7.has("href") && !jsonobject7.isNull("href"))
                {
                    contentvalues1.put("imageSmall", jsonobject7.getString("href"));
                }
            }
            if (jsonobject3.has("medium") && !jsonobject3.isNull("medium"))
            {
                JSONObject jsonobject8 = jsonobject3.getJSONObject("medium");
                if (jsonobject8.has("href") && !jsonobject8.isNull("href"))
                {
                    contentvalues1.put("imageMed", jsonobject8.getString("href"));
                }
            }
            if (jsonobject3.has("large") && !jsonobject3.isNull("large"))
            {
                jsonobject3 = jsonobject3.getJSONObject("large");
                if (jsonobject3.has("href") && !jsonobject3.isNull("href"))
                {
                    contentvalues1.put("imageLarge", jsonobject3.getString("href"));
                }
            }
        }
        if (jsonobject1.has("name") && !jsonobject1.isNull("name"))
        {
            contentvalues1.put("eventName", jsonobject1.getString("name"));
        }
        if (jsonobject1.has("links") && !jsonobject1.isNull("links"))
        {
            jsonobject1 = jsonobject1.getJSONObject("links");
            if (jsonobject1.has("source") && !jsonobject1.isNull("source"))
            {
                jsonobject1 = jsonobject1.getJSONObject("source");
                if (jsonobject1.has("hls") && !jsonobject1.isNull("hls"))
                {
                    jsonobject1 = jsonobject1.getJSONObject("hls");
                    if (jsonobject1.has("default") && !jsonobject1.isNull("default"))
                    {
                        JSONObject jsonobject4 = jsonobject1.getJSONObject("default");
                        if (jsonobject4.has("href") && !jsonobject4.isNull("href"))
                        {
                            contentvalues1.put("videoURLDefault", jsonobject4.getString("href"));
                        }
                    }
                    if (jsonobject1.has("high") && !jsonobject1.isNull("high"))
                    {
                        JSONObject jsonobject5 = jsonobject1.getJSONObject("high");
                        if (jsonobject5.has("href") && !jsonobject5.isNull("href"))
                        {
                            contentvalues1.put("videoURLLarge", jsonobject5.getString("href"));
                        }
                    }
                    if (jsonobject1.has("mid") && !jsonobject1.isNull("mid"))
                    {
                        JSONObject jsonobject6 = jsonobject1.getJSONObject("mid");
                        if (jsonobject6.has("href") && !jsonobject6.isNull("href"))
                        {
                            contentvalues1.put("videoURLMed", jsonobject6.getString("href"));
                        }
                    }
                    if (jsonobject1.has("low") && !jsonobject1.isNull("low"))
                    {
                        jsonobject1 = jsonobject1.getJSONObject("low");
                        if (jsonobject1.has("href") && !jsonobject1.isNull("href"))
                        {
                            contentvalues1.put("videoURLSmall", jsonobject1.getString("href"));
                        }
                    }
                }
            }
        }
        contentvalues1.put("metaEventRelationId", (String)hashmap.get("relationType"));
        if (hashmap == null)
        {
            break MISSING_BLOCK_LABEL_2076;
        }
        if (hashmap.containsKey("sportId"))
        {
            contentvalues1.put("sportId", (String)hashmap.get("sportId"));
        }
        DataManager.feedsDbConn.insertIntoEventsTable(contentvalues1);
_L18:
        k++;
        if (true) goto _L17; else goto _L16
_L16:
        Exception exception2;
        exception2;
        Utils.sdkLog("EventsByLeagueParser", 5, exception2);
        sendSuccessBroadcast = false;
        sendPartialErrorBroadcast = true;
          goto _L18
        Exception exception1;
        exception1;
        Exception exception;
        try
        {
            Utils.sdkLog("EventsByLeagueParser", 5, exception1);
            sendSuccessBroadcast = false;
            sendPartialErrorBroadcast = true;
            break; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject) { }
        finally
        {
            if (!sendSuccessBroadcast) goto _L0; else goto _L0
        }
        Utils.sdkLog("EventsByLeagueParser", 5, jsonobject);
        sendSuccessBroadcast = false;
        sendPartialErrorBroadcast = false;
        errorHandler(2);
        if (sendSuccessBroadcast)
        {
            broadcastIntent(Boolean.valueOf(true), null, null, eventRequestType);
            return;
        }
        continue; /* Loop/switch isn't completed */
        exception;
        Utils.sdkLog("EventsByLeagueParser", 5, exception);
        contentvalues.put("ttl", "");
          goto _L19
        broadcastIntent(Boolean.valueOf(true), null, null, eventRequestType);
_L23:
        throw jsonobject;
_L6:
        contentvalues.put("eventsType", "");
          goto _L20
        if (!sendPartialErrorBroadcast) goto _L22; else goto _L21
_L21:
        broadcastIntent(null, Boolean.valueOf(true), null, eventRequestType);
        return;
        if (sendPartialErrorBroadcast)
        {
            broadcastIntent(null, Boolean.valueOf(true), null, eventRequestType);
        }
          goto _L23
_L9:
        if (!sendPartialErrorBroadcast) goto _L22; else goto _L24
_L24:
        broadcastIntent(null, Boolean.valueOf(true), null, eventRequestType);
        return;
_L12:
        if (j < i1) goto _L25; else goto _L11
_L11:
        i++;
        if (true) goto _L27; else goto _L26
_L26:
    }
}

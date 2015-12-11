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
//            ParserException, DataManager, FeedsDB

class GenericParser
{

    GenericParser()
    {
    }

    protected static ContentValues parseAndInsertLinearEvent(JSONObject jsonobject, HashMap hashmap)
        throws Exception
    {
        ContentValues contentvalues = new ContentValues();
        if (jsonobject.has("broadcastStartTime") && !jsonobject.isNull("broadcastStartTime"))
        {
            contentvalues.put("broadcastStartTime", jsonobject.getString("broadcastStartTime"));
        }
        if (jsonobject.has("description") && !jsonobject.isNull("description"))
        {
            contentvalues.put("description", jsonobject.getString("description"));
        }
        if (jsonobject.has("blackouts") && !jsonobject.isNull("blackouts"))
        {
            contentvalues.put("blackoutsJason", jsonobject.getJSONArray("blackouts").toString());
        }
        if (jsonobject.has("categories") && !jsonobject.isNull("categories"))
        {
            Object obj = jsonobject.getJSONArray("categories");
            if (((JSONArray) (obj)).length() > 0)
            {
                obj = ((JSONArray) (obj)).getJSONObject(0);
                if (((JSONObject) (obj)).has("name") && !((JSONObject) (obj)).isNull("name"))
                {
                    contentvalues.put("SPORT", ((JSONObject) (obj)).getString("name"));
                }
                if (((JSONObject) (obj)).has("abbreviation") && !((JSONObject) (obj)).isNull("abbreviation"))
                {
                    contentvalues.put("sportCode", ((JSONObject) (obj)).getString("abbreviation"));
                }
            }
        }
        if (jsonobject.has("program") && !jsonobject.isNull("program"))
        {
            JSONObject jsonobject1 = jsonobject.getJSONObject("program");
            if (jsonobject1.has("code") && !jsonobject1.isNull("code"))
            {
                contentvalues.put("programingCode", jsonobject1.getString("code"));
            }
        }
        if (jsonobject.has("type") && !jsonobject.isNull("type"))
        {
            contentvalues.put("eventType", jsonobject.getString("type"));
        }
        if (jsonobject.has("endTime") && !jsonobject.isNull("endTime"))
        {
            contentvalues.put("endTime", jsonobject.getString("endTime"));
        }
        if (jsonobject.has("subcategories") && !jsonobject.isNull("subcategories"))
        {
            Object obj1 = jsonobject.getJSONArray("subcategories");
            if (((JSONArray) (obj1)).length() > 0)
            {
                obj1 = ((JSONArray) (obj1)).getJSONObject(0);
                if (((JSONObject) (obj1)).has("id") && !((JSONObject) (obj1)).isNull("id"))
                {
                    contentvalues.put("league", ((JSONObject) (obj1)).getString("id"));
                }
                if (((JSONObject) (obj1)).has("name") && !((JSONObject) (obj1)).isNull("name"))
                {
                    contentvalues.put("leagueName", ((JSONObject) (obj1)).getString("name"));
                }
            }
        }
        if (jsonobject.has("broadcasts") && !jsonobject.isNull("broadcasts"))
        {
            Object obj2 = jsonobject.getJSONArray("broadcasts");
            if (((JSONArray) (obj2)).length() > 0)
            {
                obj2 = ((JSONArray) (obj2)).getJSONObject(0);
                if (((JSONObject) (obj2)).has("abbreviation") && !((JSONObject) (obj2)).isNull("abbreviation"))
                {
                    contentvalues.put("networkCode", ((JSONObject) (obj2)).getString("abbreviation"));
                }
                if (((JSONObject) (obj2)).has("name") && !((JSONObject) (obj2)).isNull("name"))
                {
                    contentvalues.put("networkName", ((JSONObject) (obj2)).getString("name"));
                }
                if (((JSONObject) (obj2)).has("ncsId") && !((JSONObject) (obj2)).isNull("ncsId"))
                {
                    contentvalues.put("networkId", ((JSONObject) (obj2)).getString("ncsId"));
                }
                if (((JSONObject) (obj2)).has("adobeResource") && !((JSONObject) (obj2)).isNull("adobeResource"))
                {
                    contentvalues.put("networkResourceId", ((JSONObject) (obj2)).getString("adobeResource"));
                }
            }
        }
        if (jsonobject.has("guid") && !jsonobject.isNull("guid"))
        {
            contentvalues.put("guid", jsonobject.getString("guid"));
        }
        if (jsonobject.has("startTime") && !jsonobject.isNull("startTime"))
        {
            contentvalues.put("startTime", jsonobject.getString("startTime"));
        }
        if (jsonobject.has("id") && !jsonobject.isNull("id"))
        {
            contentvalues.put("eventId", jsonobject.getString("id"));
        }
        if (jsonobject.has("name") && !jsonobject.isNull("name"))
        {
            contentvalues.put("showName", jsonobject.getString("name"));
        }
        if (jsonobject.has("simulcastAiringId") && !jsonobject.isNull("simulcastAiringId"))
        {
            contentvalues.put("simulcastAiringId", jsonobject.getString("simulcastAiringId"));
        }
        if (jsonobject.has("seekInSeconds") && !jsonobject.isNull("seekInSeconds"))
        {
            contentvalues.put("seekInSeconds", jsonobject.getString("seekInSeconds"));
        }
        if (jsonobject.has("parentalRating") && !jsonobject.isNull("parentalRating"))
        {
            contentvalues.put("parentalRating", jsonobject.getString("parentalRating"));
        }
        if (jsonobject.has("omniture") && !jsonobject.isNull("omniture"))
        {
            contentvalues.put("omnitureJson", jsonobject.getJSONObject("omniture").toString());
        }
        if (jsonobject.has("thumbnails") && !jsonobject.isNull("thumbnails"))
        {
            JSONObject jsonobject2 = jsonobject.getJSONObject("thumbnails");
            if (jsonobject2.has("small") && !jsonobject2.isNull("small"))
            {
                JSONObject jsonobject6 = jsonobject2.getJSONObject("small");
                if (jsonobject6.has("href") && !jsonobject6.isNull("href"))
                {
                    contentvalues.put("imageSmall", jsonobject6.getString("href"));
                }
            }
            if (jsonobject2.has("medium") && !jsonobject2.isNull("medium"))
            {
                JSONObject jsonobject7 = jsonobject2.getJSONObject("medium");
                if (jsonobject7.has("href") && !jsonobject7.isNull("href"))
                {
                    contentvalues.put("imageMed", jsonobject7.getString("href"));
                }
            }
            if (jsonobject2.has("large") && !jsonobject2.isNull("large"))
            {
                jsonobject2 = jsonobject2.getJSONObject("large");
                if (jsonobject2.has("href") && !jsonobject2.isNull("href"))
                {
                    contentvalues.put("imageLarge", jsonobject2.getString("href"));
                }
            }
        }
        if (jsonobject.has("name") && !jsonobject.isNull("name"))
        {
            contentvalues.put("eventName", jsonobject.getString("name"));
        }
        if (jsonobject.has("streamUrl") && !jsonobject.isNull("streamUrl"))
        {
            contentvalues.put("videoURLSmall", jsonobject.getString("streamUrl"));
        }
        if (jsonobject.has("links") && !jsonobject.isNull("links"))
        {
            jsonobject = jsonobject.getJSONObject("links");
            if (jsonobject.has("source") && !jsonobject.isNull("source"))
            {
                jsonobject = jsonobject.getJSONObject("source");
                if (jsonobject.has("hls") && !jsonobject.isNull("hls"))
                {
                    jsonobject = jsonobject.getJSONObject("hls");
                    if (jsonobject.has("default") && !jsonobject.isNull("default"))
                    {
                        JSONObject jsonobject3 = jsonobject.getJSONObject("default");
                        if (jsonobject3.has("href") && !jsonobject3.isNull("href"))
                        {
                            contentvalues.put("videoURLDefault", jsonobject3.getString("href"));
                        }
                    }
                    if (jsonobject.has("high") && !jsonobject.isNull("high"))
                    {
                        JSONObject jsonobject4 = jsonobject.getJSONObject("high");
                        if (jsonobject4.has("href") && !jsonobject4.isNull("href"))
                        {
                            contentvalues.put("videoURLLarge", jsonobject4.getString("href"));
                        }
                    }
                    if (jsonobject.has("mid") && !jsonobject.isNull("mid"))
                    {
                        JSONObject jsonobject5 = jsonobject.getJSONObject("mid");
                        if (jsonobject5.has("href") && !jsonobject5.isNull("href"))
                        {
                            contentvalues.put("videoURLMed", jsonobject5.getString("href"));
                        }
                    }
                    if (jsonobject.has("low") && !jsonobject.isNull("low"))
                    {
                        jsonobject = jsonobject.getJSONObject("low");
                        if (jsonobject.has("href") && !jsonobject.isNull("href"))
                        {
                            contentvalues.put("videoURLSmall", jsonobject.getString("href"));
                        }
                    }
                }
            }
        }
        if (hashmap != null)
        {
            if (hashmap.containsKey("featuredType"))
            {
                contentvalues.put("metaEventRelationId", (Integer)hashmap.get("featuredType"));
            }
            if (hashmap.containsKey("sportId"))
            {
                contentvalues.put("sportId", (String)hashmap.get("sportId"));
            }
            if (hashmap.containsKey("eventType"))
            {
                contentvalues.put("eventType", (String)hashmap.get("eventType"));
            }
        }
        return contentvalues;
    }

    protected static ContentValues parseAndInsertVODEvent(JSONObject jsonobject, HashMap hashmap)
        throws Exception
    {
label0:
        {
            ContentValues contentvalues = new ContentValues();
            if (jsonobject.has("headline") && !jsonobject.isNull("headline"))
            {
                contentvalues.put("eventName", jsonobject.getString("headline"));
                contentvalues.put("showName", jsonobject.getString("headline"));
            }
            if (jsonobject.has("description") && !jsonobject.isNull("description"))
            {
                contentvalues.put("description", jsonobject.getString("description"));
            }
            if (jsonobject.has("id") && !jsonobject.isNull("id"))
            {
                contentvalues.put("eventId", jsonobject.getString("id"));
            }
            if (jsonobject.has("posterImages") && !jsonobject.isNull("posterImages"))
            {
                JSONObject jsonobject1 = jsonobject.getJSONObject("posterImages");
                if (jsonobject1.has("default") && !jsonobject1.isNull("default"))
                {
                    JSONObject jsonobject3 = jsonobject1.getJSONObject("default");
                    if (jsonobject3.has("href") && !jsonobject3.isNull("href"))
                    {
                        contentvalues.put("imageMed", jsonobject3.getString("href"));
                        contentvalues.put("imageSmall", jsonobject3.getString("href"));
                    }
                }
                if (jsonobject1.has("full") && !jsonobject1.isNull("full"))
                {
                    jsonobject1 = jsonobject1.getJSONObject("full");
                    if (jsonobject1.has("href") && !jsonobject1.isNull("href"))
                    {
                        contentvalues.put("imageLarge", jsonobject1.getString("href"));
                    }
                }
            }
            if (jsonobject.has("links") && !jsonobject.isNull("links"))
            {
                JSONObject jsonobject2 = jsonobject.getJSONObject("links");
                if (jsonobject2.has("source") && !jsonobject2.isNull("source"))
                {
                    jsonobject2 = jsonobject2.getJSONObject("source");
                    if (!jsonobject2.has("HLS") || jsonobject2.isNull("HLS"))
                    {
                        break label0;
                    }
                    jsonobject2 = jsonobject2.getJSONObject("HLS");
                    if (jsonobject2.has("href") && !jsonobject2.isNull("href"))
                    {
                        contentvalues.put("videoURLLarge", jsonobject2.getString("href"));
                        contentvalues.put("videoURLMed", jsonobject2.getString("href"));
                        contentvalues.put("videoURLSmall", jsonobject2.getString("href"));
                    }
                    if (jsonobject2.has("HD") && !jsonobject2.isNull("HD"))
                    {
                        jsonobject2 = jsonobject2.getJSONObject("HD");
                        if (jsonobject2.has("href") && !jsonobject2.isNull("href"))
                        {
                            contentvalues.put("videoURLHD", jsonobject2.getString("href"));
                        }
                    }
                }
            }
            if (jsonobject.has("duration") && !jsonobject.isNull("duration"))
            {
                contentvalues.put("endTime", jsonobject.getString("duration"));
            }
            contentvalues.put("blackoutsJason", "");
            contentvalues.put("broadcastStartTime", "");
            contentvalues.put("eventType", "VOD");
            contentvalues.put("guid", "");
            contentvalues.put("omnitureJson", "");
            contentvalues.put("parentalRating", "");
            contentvalues.put("seekInSeconds", "");
            contentvalues.put("simulcastAiringId", "");
            contentvalues.put("networkCode", "");
            contentvalues.put("networkName", "");
            contentvalues.put("networkId", "");
            contentvalues.put("league", "");
            contentvalues.put("leagueName", "");
            contentvalues.put("SPORT", "");
            contentvalues.put("startTime", "");
            contentvalues.put("networkResourceId", "");
            if (hashmap != null)
            {
                if (hashmap.containsKey("featuredType"))
                {
                    contentvalues.put("metaEventRelationId", (Integer)hashmap.get("featuredType"));
                }
                if (hashmap.containsKey("sportId"))
                {
                    contentvalues.put("sportId", (String)hashmap.get("sportId"));
                }
            }
            return contentvalues;
        }
        throw new ParserException("No HLS Video");
    }

    protected static boolean parseAndUpdateMetaData(HashMap hashmap, String s, String s1, String s2)
        throws Exception
    {
        ContentValues contentvalues = new ContentValues();
        if (hashmap != null)
        {
            if (hashmap.containsKey("ttl"))
            {
                try
                {
                    contentvalues.put("ttl", Utils.getExpiryTime(Integer.parseInt((String)hashmap.get("ttl"))));
                }
                catch (Exception exception)
                {
                    Utils.sdkLog("GenericParser; Error: ", 5, exception);
                    contentvalues.put("ttl", "");
                }
            }
            if (hashmap.containsKey("featuredType"))
            {
                contentvalues.put("eventRelationId", (Integer)hashmap.get("featuredType"));
            }
            if (hashmap.containsKey("sportId"))
            {
                contentvalues.put("sportId", (String)hashmap.get("sportId"));
            }
        }
        if (s2 != null)
        {
            contentvalues.put("networkId", s2);
        }
        contentvalues.put("eventsType", s);
        contentvalues.put("omnitureJson", "");
        contentvalues.put("count", s1);
        DataManager.feedsDbConn.insertOrUpdateMetaEventsTable(contentvalues);
        return true;
    }
}

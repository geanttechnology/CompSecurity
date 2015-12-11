// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import android.content.ContentValues;
import com.espn.androidplayersdk.utilities.Utils;
import java.util.HashMap;
import org.apache.http.HttpEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            EPEvents, DataManager, FeedsDB, FeedsManagerAPI, 
//            FeedsCommListener

class EventByIdRequest extends Thread
{

    String eventId;
    FeedsCommListener listener = new FeedsCommListener() {

        final EventByIdRequest this$0;

        public void handleError(int i)
        {
            mCallBack.onEventRetrivalError(i);
        }

        public void update(HttpEntity httpentity, String s)
        {
        }

        public void update(JSONObject jsonobject, String s, HashMap hashmap)
        {
            jsonobject = parse(jsonobject, hashmap);
            if (jsonobject != null)
            {
                try
                {
                    mCallBack.onEventUpdate(jsonobject);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (JSONObject jsonobject)
                {
                    Utils.sdkLog("EventByIdRequest", 5, jsonobject);
                    mCallBack.onEventRetrivalError(9);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (JSONObject jsonobject)
                {
                    Utils.sdkLog("EventByIdRequest", 5, jsonobject);
                }
                break MISSING_BLOCK_LABEL_74;
            }
            mCallBack.onEventRetrivalError(8);
            return;
            mCallBack.onEventRetrivalError(9);
            return;
        }

            
            {
                this$0 = EventByIdRequest.this;
                super();
            }
    };
    EPCatalogManager.Callback mCallBack;

    EventByIdRequest()
    {
    }

    EventByIdRequest(String s, EPCatalogManager.Callback callback)
    {
        eventId = s;
        mCallBack = callback;
    }

    EPEvents parse(JSONObject jsonobject)
        throws JSONException, Exception
    {
        Utils.sdkLog("EventByIdRequest:", 3, null);
        Object obj = null;
        JSONArray jsonarray = jsonobject.getJSONArray("listings");
        jsonobject = obj;
        if (jsonarray.length() > 0)
        {
            JSONObject jsonobject1 = jsonarray.getJSONObject(0);
            jsonobject = new HashMap();
            if (jsonobject1.has("name") && !jsonobject1.isNull("name"))
            {
                jsonobject.put("eventName", jsonobject1.getString("name"));
                jsonobject.put("showName", jsonobject1.getString("name"));
            }
            if (jsonobject1.has("id") && !jsonobject1.isNull("id"))
            {
                jsonobject.put("eventId", jsonobject1.getString("id"));
            }
            if (jsonobject1.has("simulcastAiringId") && !jsonobject1.isNull("simulcastAiringId"))
            {
                jsonobject.put("simulcastAiringId", jsonobject1.getString("simulcastAiringId"));
            }
            if (jsonobject1.has("type") && !jsonobject1.isNull("type"))
            {
                jsonobject.put("eventType", jsonobject1.getString("type"));
            }
            if (jsonobject1.has("broadcastStartTime") && !jsonobject1.isNull("broadcastStartTime"))
            {
                jsonobject.put("broadcastStartTime", jsonobject1.getString("broadcastStartTime"));
            }
            if (jsonobject1.has("startTime") && !jsonobject1.isNull("startTime"))
            {
                jsonobject.put("startTime", jsonobject1.getString("startTime"));
            }
            if (jsonobject1.has("endTime") && !jsonobject1.isNull("endTime"))
            {
                jsonobject.put("endTime", jsonobject1.getString("endTime"));
            }
            if (jsonobject1.has("thumbnails") && !jsonobject1.isNull("thumbnails"))
            {
                JSONObject jsonobject2 = jsonobject1.getJSONObject("thumbnails");
                if (jsonobject2.has("small") && !jsonobject2.isNull("small"))
                {
                    JSONObject jsonobject3 = jsonobject2.getJSONObject("small");
                    if (jsonobject3.has("href") && !jsonobject3.isNull("href"))
                    {
                        jsonobject.put("imageSmall", jsonobject3.getString("href"));
                    }
                }
                if (jsonobject2.has("medium") && !jsonobject2.isNull("medium"))
                {
                    JSONObject jsonobject4 = jsonobject2.getJSONObject("medium");
                    if (jsonobject4.has("href") && !jsonobject4.isNull("href"))
                    {
                        jsonobject.put("imageMed", jsonobject4.getString("href"));
                    }
                }
                if (jsonobject2.has("large") && !jsonobject2.isNull("large"))
                {
                    jsonobject2 = jsonobject2.getJSONObject("large");
                    if (jsonobject2.has("href") && !jsonobject2.isNull("href"))
                    {
                        jsonobject.put("imageLarge", jsonobject2.getString("href"));
                    }
                }
            }
            if (jsonobject1.has("subcategories") && !jsonobject1.isNull("subcategories"))
            {
                Object obj1 = jsonobject1.getJSONArray("subcategories");
                if (((JSONArray) (obj1)).length() > 0)
                {
                    obj1 = ((JSONArray) (obj1)).getJSONObject(0);
                    if (((JSONObject) (obj1)).has("id") && !((JSONObject) (obj1)).isNull("id"))
                    {
                        jsonobject.put("league", ((JSONObject) (obj1)).getString("id"));
                    }
                    if (((JSONObject) (obj1)).has("name") && !((JSONObject) (obj1)).isNull("name"))
                    {
                        jsonobject.put("leagueName", ((JSONObject) (obj1)).getString("name"));
                    }
                }
            }
            if (jsonobject1.has("parentalRating") && !jsonobject1.isNull("parentalRating"))
            {
                jsonobject.put("parentalRating", jsonobject1.getString("parentalRating"));
            }
            if (jsonobject1.has("seekInSeconds") && !jsonobject1.isNull("seekInSeconds"))
            {
                jsonobject.put("seekInSeconds", jsonobject1.getString("seekInSeconds"));
            }
            if (jsonobject1.has("broadcasts") && !jsonobject1.isNull("broadcasts"))
            {
                Object obj2 = jsonobject1.getJSONArray("broadcasts");
                if (((JSONArray) (obj2)).length() > 0)
                {
                    obj2 = ((JSONArray) (obj2)).getJSONObject(0);
                    if (((JSONObject) (obj2)).has("abbreviation") && !((JSONObject) (obj2)).isNull("abbreviation"))
                    {
                        jsonobject.put("networkCode", ((JSONObject) (obj2)).getString("abbreviation"));
                    }
                    if (((JSONObject) (obj2)).has("name") && !((JSONObject) (obj2)).isNull("name"))
                    {
                        jsonobject.put("networkName", ((JSONObject) (obj2)).getString("name"));
                    }
                    if (((JSONObject) (obj2)).has("ncsId") && !((JSONObject) (obj2)).isNull("ncsId"))
                    {
                        jsonobject.put("networkId", ((JSONObject) (obj2)).getString("ncsId"));
                    }
                    if (((JSONObject) (obj2)).has("adobeResource") && !((JSONObject) (obj2)).isNull("adobeResource"))
                    {
                        jsonobject.put("networkResourceId", ((JSONObject) (obj2)).getString("adobeResource"));
                    }
                }
            }
            if (jsonobject1.has("description") && !jsonobject1.isNull("description"))
            {
                jsonobject.put("description", jsonobject1.getString("description"));
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
                            jsonobject1 = jsonobject1.getJSONObject("default");
                            if (jsonobject1.has("href") && !jsonobject1.isNull("href"))
                            {
                                jsonobject.put("defaultStartSessionUrl", jsonobject1.getString("href"));
                            }
                        }
                    }
                }
            }
            jsonobject = new EPEvents(jsonobject);
        }
        return jsonobject;
    }

    EPEvents parse(JSONObject jsonobject, HashMap hashmap)
        throws JSONException, Exception
    {
        Utils.sdkLog("EventByIdRequest.parse()", 3, null);
        hashmap = null;
        HashMap hashmap1 = new HashMap();
        ContentValues contentvalues = new ContentValues();
        JSONArray jsonarray = jsonobject.getJSONArray("listings");
        jsonobject = hashmap;
        if (jsonarray.length() > 0)
        {
            jsonobject = jsonarray.getJSONObject(0);
            if (jsonobject.has("broadcastStartTime") && !jsonobject.isNull("broadcastStartTime"))
            {
                contentvalues.put("broadcastStartTime", jsonobject.getString("broadcastStartTime"));
                hashmap1.put("broadcastStartTime", jsonobject.getString("broadcastStartTime"));
            }
            if (jsonobject.has("description") && !jsonobject.isNull("description"))
            {
                contentvalues.put("description", jsonobject.getString("description"));
                hashmap1.put("description", jsonobject.getString("description"));
            }
            if (jsonobject.has("blackouts") && !jsonobject.isNull("blackouts"))
            {
                contentvalues.put("coverageType", jsonobject.getJSONArray("blackouts").toString());
            }
            if (jsonobject.has("categories") && !jsonobject.isNull("categories"))
            {
                hashmap = jsonobject.getJSONArray("categories");
                if (hashmap.length() > 0)
                {
                    hashmap = hashmap.getJSONObject(0);
                    if (hashmap.has("name") && !hashmap.isNull("name"))
                    {
                        contentvalues.put("SPORT", hashmap.getString("name"));
                    }
                    if (hashmap.has("abbreviation") && !hashmap.isNull("abbreviation"))
                    {
                        contentvalues.put("sportCode", hashmap.getString("abbreviation"));
                    }
                }
            }
            if (jsonobject.has("program") && !jsonobject.isNull("program"))
            {
                hashmap = jsonobject.getJSONObject("program");
                if (hashmap.has("code") && !hashmap.isNull("code"))
                {
                    contentvalues.put("programingCode", hashmap.getString("code"));
                }
            }
            if (jsonobject.has("type") && !jsonobject.isNull("type"))
            {
                contentvalues.put("eventType", jsonobject.getString("type"));
                hashmap1.put("eventType", jsonobject.getString("type"));
            }
            if (jsonobject.has("endTime") && !jsonobject.isNull("endTime"))
            {
                contentvalues.put("endTime", jsonobject.getString("endTime"));
                hashmap1.put("endTime", jsonobject.getString("endTime"));
            }
            if (jsonobject.has("subcategories") && !jsonobject.isNull("subcategories"))
            {
                hashmap = jsonobject.getJSONArray("subcategories");
                if (hashmap.length() > 0)
                {
                    hashmap = hashmap.getJSONObject(0);
                    if (hashmap.has("id") && !hashmap.isNull("id"))
                    {
                        hashmap1.put("league", hashmap.getString("id"));
                    }
                    if (hashmap.has("name") && !hashmap.isNull("name"))
                    {
                        hashmap1.put("leagueName", hashmap.getString("name"));
                    }
                }
            }
            if (jsonobject.has("broadcasts") && !jsonobject.isNull("broadcasts"))
            {
                hashmap = jsonobject.getJSONArray("broadcasts");
                if (hashmap.length() > 0)
                {
                    hashmap = hashmap.getJSONObject(0);
                    if (hashmap.has("abbreviation") && !hashmap.isNull("abbreviation"))
                    {
                        contentvalues.put("networkCode", hashmap.getString("abbreviation"));
                        hashmap1.put("networkCode", hashmap.getString("abbreviation"));
                    }
                    if (hashmap.has("name") && !hashmap.isNull("name"))
                    {
                        contentvalues.put("networkName", hashmap.getString("name"));
                        hashmap1.put("networkName", hashmap.getString("name"));
                    }
                    if (hashmap.has("ncsId") && !hashmap.isNull("ncsId"))
                    {
                        contentvalues.put("networkId", hashmap.getString("ncsId"));
                        hashmap1.put("networkId", hashmap.getString("ncsId"));
                    }
                    if (hashmap.has("adobeResource") && !hashmap.isNull("adobeResource"))
                    {
                        contentvalues.put("networkResourceId", hashmap.getString("adobeResource"));
                        hashmap1.put("networkResourceId", hashmap.getString("adobeResource"));
                    }
                }
            }
            if (jsonobject.has("guid") && !jsonobject.isNull("guid"))
            {
                hashmap1.put("guid", jsonobject.getString("guid"));
                contentvalues.put("guid", jsonobject.getString("guid"));
            }
            if (jsonobject.has("startTime") && !jsonobject.isNull("startTime"))
            {
                contentvalues.put("startTime", jsonobject.getString("startTime"));
                hashmap1.put("startTime", jsonobject.getString("startTime"));
            }
            if (jsonobject.has("id") && !jsonobject.isNull("id"))
            {
                contentvalues.put("eventId", jsonobject.getString("id"));
                hashmap1.put("eventId", jsonobject.getString("id"));
            }
            if (jsonobject.has("name") && !jsonobject.isNull("name"))
            {
                contentvalues.put("showName", jsonobject.getString("name"));
                hashmap1.put("eventName", jsonobject.getString("name"));
                hashmap1.put("showName", jsonobject.getString("name"));
            }
            if (jsonobject.has("simulcastAiringId") && !jsonobject.isNull("simulcastAiringId"))
            {
                contentvalues.put("simulcastAiringId", jsonobject.getString("simulcastAiringId"));
                hashmap1.put("simulcastAiringId", jsonobject.getString("simulcastAiringId"));
            }
            if (jsonobject.has("seekInSeconds") && !jsonobject.isNull("seekInSeconds"))
            {
                contentvalues.put("seekInSeconds", jsonobject.getString("seekInSeconds"));
                hashmap1.put("seekInSeconds", jsonobject.getString("seekInSeconds"));
            }
            if (jsonobject.has("parentalRating") && !jsonobject.isNull("parentalRating"))
            {
                contentvalues.put("parentalRating", jsonobject.getString("parentalRating"));
                hashmap1.put("parentalRating", jsonobject.getString("parentalRating"));
            }
            if (jsonobject.has("omniture") && !jsonobject.isNull("omniture"))
            {
                contentvalues.put("omnitureJson", jsonobject.getJSONObject("omniture").toString());
            }
            if (jsonobject.has("thumbnails") && !jsonobject.isNull("thumbnails"))
            {
                hashmap = jsonobject.getJSONObject("thumbnails");
                if (hashmap.has("small") && !hashmap.isNull("small"))
                {
                    JSONObject jsonobject1 = hashmap.getJSONObject("small");
                    if (jsonobject1.has("href") && !jsonobject1.isNull("href"))
                    {
                        contentvalues.put("imageSmall", jsonobject1.getString("href"));
                        hashmap1.put("imageSmall", jsonobject1.getString("href"));
                    }
                }
                if (hashmap.has("medium") && !hashmap.isNull("medium"))
                {
                    JSONObject jsonobject2 = hashmap.getJSONObject("medium");
                    if (jsonobject2.has("href") && !jsonobject2.isNull("href"))
                    {
                        contentvalues.put("imageMed", jsonobject2.getString("href"));
                        hashmap1.put("imageMed", jsonobject2.getString("href"));
                    }
                }
                if (hashmap.has("large") && !hashmap.isNull("large"))
                {
                    hashmap = hashmap.getJSONObject("large");
                    if (hashmap.has("href") && !hashmap.isNull("href"))
                    {
                        contentvalues.put("imageLarge", hashmap.getString("href"));
                        hashmap1.put("imageLarge", hashmap.getString("href"));
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
                            hashmap = jsonobject.getJSONObject("default");
                            if (hashmap.has("href") && !hashmap.isNull("href"))
                            {
                                contentvalues.put("videoURLDefault", hashmap.getString("href"));
                                hashmap1.put("defaultStartSessionUrl", hashmap.getString("href"));
                            }
                        }
                        if (jsonobject.has("high") && !jsonobject.isNull("high"))
                        {
                            hashmap = jsonobject.getJSONObject("high");
                            if (hashmap.has("href") && !hashmap.isNull("href"))
                            {
                                contentvalues.put("videoURLLarge", hashmap.getString("href"));
                            }
                        }
                        if (jsonobject.has("mid") && !jsonobject.isNull("mid"))
                        {
                            hashmap = jsonobject.getJSONObject("mid");
                            if (hashmap.has("href") && !hashmap.isNull("href"))
                            {
                                contentvalues.put("videoURLMed", hashmap.getString("href"));
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
            contentvalues.put("metaEventRelationId", "6");
            DataManager.feedsDbConn.insertIntoEventsTable(contentvalues);
            jsonobject = new EPEvents(hashmap1);
        }
        return jsonobject;
    }

    public void run()
    {
        super.run();
        (new FeedsManagerAPI(listener)).getEventById(eventId);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import com.espn.androidplayersdk.listenerinterface.SearchCallback;
import com.espn.androidplayersdk.utilities.EPEventType;
import com.espn.androidplayersdk.utilities.Utils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.http.HttpEntity;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            EPEvents, FeedsManagerAPI, FeedsCommListener

class SearchAPI
{

    SearchCallback callback;
    FeedsCommListener searchListener;

    protected SearchAPI(SearchCallback searchcallback)
    {
        searchListener = new FeedsCommListener() {

            final SearchAPI this$0;

            public void handleError(int i)
            {
                callback.onSearchFailed(i);
            }

            public void update(HttpEntity httpentity, String s)
            {
            }

            public void update(JSONObject jsonobject, String s, HashMap hashmap)
            {
                jsonobject = parse(jsonobject);
                if (jsonobject != null)
                {
                    callback.onSearchSuccess(jsonobject);
                    return;
                } else
                {
                    callback.onSearchFailed(7);
                    return;
                }
            }

            
            {
                this$0 = SearchAPI.this;
                super();
            }
        };
        callback = searchcallback;
    }

    ArrayList parse(JSONObject jsonobject)
    {
        Object obj1 = null;
        Object obj = new ArrayList();
        int j;
        jsonobject = jsonobject.getJSONArray("listings");
        j = jsonobject.length();
        if (j <= 0) goto _L2; else goto _L1
_L1:
        int i = 0;
_L4:
        if (i >= j)
        {
            return ((ArrayList) (obj));
        }
        obj1 = new HashMap();
        JSONObject jsonobject1 = jsonobject.getJSONObject(i);
        if (jsonobject1.has("broadcastStartTime") && !jsonobject1.isNull("broadcastStartTime"))
        {
            ((HashMap) (obj1)).put("broadcastStartTime", jsonobject1.getString("broadcastStartTime"));
        }
        if (jsonobject1.has("description") && !jsonobject1.isNull("description"))
        {
            ((HashMap) (obj1)).put("description", jsonobject1.getString("description"));
        }
        if (jsonobject1.has("categories") && !jsonobject1.isNull("categories"))
        {
            Object obj2 = jsonobject1.getJSONArray("categories");
            if (((JSONArray) (obj2)).length() > 0)
            {
                obj2 = ((JSONArray) (obj2)).getJSONObject(0);
                if (((JSONObject) (obj2)).has("name") && !((JSONObject) (obj2)).isNull("name"))
                {
                    ((HashMap) (obj1)).put("SPORT", ((JSONObject) (obj2)).getString("name"));
                }
                if (((JSONObject) (obj2)).has("abbreviation") && !((JSONObject) (obj2)).isNull("abbreviation"))
                {
                    ((HashMap) (obj1)).put("sportCode", ((JSONObject) (obj2)).getString("abbreviation"));
                }
            }
        }
        if (jsonobject1.has("program") && !jsonobject1.isNull("program"))
        {
            JSONObject jsonobject2 = jsonobject1.getJSONObject("program");
            if (jsonobject2.has("code") && !jsonobject2.isNull("code"))
            {
                ((HashMap) (obj1)).put("programingCode", jsonobject2.getString("code"));
            }
        }
        if (jsonobject1.has("type") && !jsonobject1.isNull("type"))
        {
            ((HashMap) (obj1)).put("eventType", jsonobject1.getString("type"));
        }
        if (jsonobject1.has("endTime") && !jsonobject1.isNull("endTime"))
        {
            ((HashMap) (obj1)).put("endTime", jsonobject1.getString("endTime"));
        }
        if (jsonobject1.has("subcategories") && !jsonobject1.isNull("subcategories"))
        {
            Object obj3 = jsonobject1.getJSONArray("subcategories");
            if (((JSONArray) (obj3)).length() > 0)
            {
                obj3 = ((JSONArray) (obj3)).getJSONObject(0);
                if (((JSONObject) (obj3)).has("id") && !((JSONObject) (obj3)).isNull("id"))
                {
                    ((HashMap) (obj1)).put("league", ((JSONObject) (obj3)).getString("id"));
                }
                if (((JSONObject) (obj3)).has("name") && !((JSONObject) (obj3)).isNull("name"))
                {
                    ((HashMap) (obj1)).put("leagueName", ((JSONObject) (obj3)).getString("name"));
                }
            }
        }
        if (jsonobject1.has("broadcasts") && !jsonobject1.isNull("broadcasts"))
        {
            Object obj4 = jsonobject1.getJSONArray("broadcasts");
            if (((JSONArray) (obj4)).length() > 0)
            {
                obj4 = ((JSONArray) (obj4)).getJSONObject(0);
                if (((JSONObject) (obj4)).has("code") && !((JSONObject) (obj4)).isNull("code"))
                {
                    ((HashMap) (obj1)).put("networkCode", ((JSONObject) (obj4)).getString("code"));
                }
                if (((JSONObject) (obj4)).has("name") && !((JSONObject) (obj4)).isNull("name"))
                {
                    ((HashMap) (obj1)).put("networkName", ((JSONObject) (obj4)).getString("name"));
                }
                if (((JSONObject) (obj4)).has("ncsId") && !((JSONObject) (obj4)).isNull("ncsId"))
                {
                    ((HashMap) (obj1)).put("networkId", ((JSONObject) (obj4)).getString("ncsId"));
                }
                if (((JSONObject) (obj4)).has("adobeResource") && !((JSONObject) (obj4)).isNull("adobeResource"))
                {
                    ((HashMap) (obj1)).put("networkResourceId", ((JSONObject) (obj4)).getString("adobeResource"));
                }
            }
        }
        if (jsonobject1.has("startTime") && !jsonobject1.isNull("startTime"))
        {
            ((HashMap) (obj1)).put("startTime", jsonobject1.getString("startTime"));
        }
        if (jsonobject1.has("id") && !jsonobject1.isNull("id"))
        {
            ((HashMap) (obj1)).put("eventId", jsonobject1.getString("id"));
        }
        if (jsonobject1.has("name") && !jsonobject1.isNull("name"))
        {
            ((HashMap) (obj1)).put("showName", jsonobject1.getString("name"));
        }
        if (jsonobject1.has("simulcastAiringId") && !jsonobject1.isNull("simulcastAiringId"))
        {
            ((HashMap) (obj1)).put("simulcastAiringId", jsonobject1.getString("simulcastAiringId"));
        }
        if (jsonobject1.has("seekInSeconds") && !jsonobject1.isNull("seekInSeconds"))
        {
            ((HashMap) (obj1)).put("seekInSeconds", jsonobject1.getString("seekInSeconds"));
        }
        if (jsonobject1.has("parentalRating") && !jsonobject1.isNull("parentalRating"))
        {
            ((HashMap) (obj1)).put("parentalRating", jsonobject1.getString("parentalRating"));
        }
        if (jsonobject1.has("thumbnails") && !jsonobject1.isNull("thumbnails"))
        {
            JSONObject jsonobject3 = jsonobject1.getJSONObject("thumbnails");
            if (jsonobject3.has("small") && !jsonobject3.isNull("small"))
            {
                JSONObject jsonobject4 = jsonobject3.getJSONObject("small");
                if (jsonobject4.has("href") && !jsonobject4.isNull("href"))
                {
                    ((HashMap) (obj1)).put("imageSmall", jsonobject4.getString("href"));
                }
            }
            if (jsonobject3.has("medium") && !jsonobject3.isNull("medium"))
            {
                JSONObject jsonobject5 = jsonobject3.getJSONObject("medium");
                if (jsonobject5.has("href") && !jsonobject5.isNull("href"))
                {
                    ((HashMap) (obj1)).put("imageMed", jsonobject5.getString("href"));
                }
            }
            if (jsonobject3.has("large") && !jsonobject3.isNull("large"))
            {
                jsonobject3 = jsonobject3.getJSONObject("large");
                if (jsonobject3.has("href") && !jsonobject3.isNull("href"))
                {
                    ((HashMap) (obj1)).put("imageLarge", jsonobject3.getString("href"));
                }
            }
        }
        if (jsonobject1.has("name") && !jsonobject1.isNull("name"))
        {
            ((HashMap) (obj1)).put("eventName", jsonobject1.getString("name"));
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
                            ((HashMap) (obj1)).put("defaultStartSessionUrl", jsonobject1.getString("href"));
                        }
                    }
                }
            }
        }
        ((ArrayList) (obj)).add(new EPEvents(((HashMap) (obj1))));
_L5:
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        obj1;
        Utils.sdkLog("SearchParser - Error: ", 5, ((Exception) (obj1)));
          goto _L5
        jsonobject;
_L6:
        Utils.sdkLog("SearchParser - Error: ", 5, jsonobject);
        return ((ArrayList) (obj));
        jsonobject;
        obj = obj1;
        if (true) goto _L6; else goto _L2
_L2:
        return ((ArrayList) (obj));
    }

    String parseKeywords(String s)
    {
        return s.trim().replace(" ", ",");
    }

    protected void search(String s, String s1, int i, int j)
    {
        String as[] = new String[2];
        setDateRange(s1, 360, as);
        (new FeedsManagerAPI(searchListener)).searchFeed(parseKeywords(s), s1, i, j, as[0], as[1]);
    }

    transient void setDateRange(String s, int i, String as[])
    {
        Date date;
        SimpleDateFormat simpledateformat;
        GregorianCalendar gregoriancalendar;
        gregoriancalendar = new GregorianCalendar(TimeZone.getDefault(), Locale.US);
        simpledateformat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        date = new Date();
        if (!s.equals(EPEventType.UPCOMING.getEventStr())) goto _L2; else goto _L1
_L1:
        gregoriancalendar.add(5, i);
        s = gregoriancalendar.getTime();
_L3:
        as[0] = simpledateformat.format(date).replace("-", "");
        as[1] = simpledateformat.format(s).replace("-", "");
        return;
_L2:
        if (!s.equals(EPEventType.REPLAY.getEventStr()))
        {
            break MISSING_BLOCK_LABEL_136;
        }
        gregoriancalendar.add(5, -i);
        s = date;
        try
        {
            date = gregoriancalendar.getTime();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Utils.sdkLog("Error: ", 5, s);
            return;
        }
          goto _L3
        s = gregoriancalendar.getTime();
          goto _L3
    }
}

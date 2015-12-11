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

class FeaturedCategoryParser extends JSONParserAbstract
{

    boolean sendPartialErrorBroadcast;
    boolean sendSuccessBroadcast;

    FeaturedCategoryParser()
    {
        sendSuccessBroadcast = false;
        sendPartialErrorBroadcast = false;
    }

    public void errorHandler(int i)
    {
        if (i == 1 || i == 2)
        {
            sendBroadcast("com.espn.action.ACTION_FEATURED_CATEGORY_DATA_ERROR");
        }
    }

    public void parse(JSONObject jsonobject, HashMap hashmap)
    {
        ContentValues contentvalues;
        ContentValues contentvalues1;
        contentvalues1 = new ContentValues();
        contentvalues = new ContentValues();
        Utils.sdkLog("FeaturedCategoryParser", 3, null);
        if (!jsonobject.has("features") || jsonobject.isNull("features")) goto _L2; else goto _L1
_L1:
        JSONArray jsonarray;
        int j;
        jsonarray = jsonobject.getJSONArray("features");
        j = jsonarray.length();
        if (j <= 0) goto _L2; else goto _L3
_L3:
        if (hashmap.containsKey("eventWhere") && hashmap.containsKey("eventWhereArg"))
        {
            DataManager.feedsDbConn.delAllRows("featuredCategories", null, null);
        }
        sendSuccessBroadcast = true;
        int i = 0;
          goto _L4
_L2:
        if (hashmap == null)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        boolean flag = hashmap.containsKey("ttl");
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        contentvalues.put("ttl", Utils.getExpiryTime(Integer.parseInt((String)hashmap.get("ttl"))));
_L15:
        if (!hashmap.containsKey("eventType")) goto _L6; else goto _L5
_L5:
        contentvalues.put("eventsType", (String)hashmap.get("eventType"));
_L16:
        if (!jsonobject.has("omniture") || jsonobject.isNull("omniture")) goto _L8; else goto _L7
_L7:
        contentvalues.put("omnitureJson", jsonobject.getJSONObject("omniture").toString());
_L17:
        if (!jsonobject.has("resultsCount") || jsonobject.isNull("resultsCount")) goto _L10; else goto _L9
_L9:
        contentvalues.put("count", jsonobject.getString("resultsCount"));
_L18:
        contentvalues.put("eventRelationId", Integer.valueOf(30));
        DataManager.feedsDbConn.insertOrUpdateMetaEventsTable(contentvalues);
        if (!sendSuccessBroadcast) goto _L12; else goto _L11
_L11:
        sendBroadcast("com.espn.action.ACTION_FEATURED_CATEGORY_UPDATE");
_L20:
        return;
_L22:
        contentvalues1.clear();
        JSONObject jsonobject1 = jsonarray.getJSONObject(i);
        contentvalues1.put("categoryId", jsonobject1.getString("id"));
        contentvalues1.put("name", jsonobject1.getString("name"));
        contentvalues1.put("abbre", jsonobject1.getString("abbreviation"));
        if (jsonobject1.has("shortName") && !jsonobject1.isNull("shortName"))
        {
            contentvalues1.put("shortName", jsonobject1.getString("shortName"));
        }
        contentvalues1.put("type", jsonobject1.getString("type"));
        if (jsonobject1.has("images") && !jsonobject1.isNull("images"))
        {
            JSONObject jsonobject2 = jsonobject1.getJSONObject("images");
            if (jsonobject2.has("edgartv") && !jsonobject2.isNull("edgartv"))
            {
                jsonobject2 = jsonobject2.getJSONObject("edgartv");
                if (jsonobject2.has("href") && !jsonobject2.isNull("href"))
                {
                    contentvalues1.put("imageUrl", jsonobject2.getString("href"));
                }
            }
        }
        if (jsonobject1.has("links") && !jsonobject1.isNull("links"))
        {
            jsonobject1 = jsonobject1.getJSONObject("links");
            if (jsonobject1.has("api") && !jsonobject1.isNull("api"))
            {
                jsonobject1 = jsonobject1.getJSONObject("api");
                if (jsonobject1.has("listings") && !jsonobject1.isNull("listings"))
                {
                    JSONObject jsonobject3 = jsonobject1.getJSONObject("listings");
                    if (jsonobject3.has("href") && !jsonobject3.isNull("href"))
                    {
                        contentvalues1.put("listingUrl", jsonobject3.getString("href"));
                    }
                }
                if (jsonobject1.has("video") && !jsonobject1.isNull("video"))
                {
                    jsonobject1 = jsonobject1.getJSONObject("video");
                    if (jsonobject1.has("href") && !jsonobject1.isNull("href"))
                    {
                        contentvalues1.put("vodUrl", jsonobject1.getString("href"));
                    }
                }
            }
        }
        DataManager.feedsDbConn.insertIntoFeaturedCategoriesTable(contentvalues1);
_L14:
        i++;
        continue; /* Loop/switch isn't completed */
        Exception exception1;
        exception1;
        Utils.sdkLog("FeaturedCategoryParser", 5, exception1);
        sendSuccessBroadcast = false;
        sendPartialErrorBroadcast = true;
        if (true) goto _L14; else goto _L13
_L13:
        jsonobject;
        Utils.sdkLog("FeaturedCategoryParser", 5, jsonobject);
        sendSuccessBroadcast = false;
        sendPartialErrorBroadcast = false;
        errorHandler(2);
        if (sendSuccessBroadcast)
        {
            sendBroadcast("com.espn.action.ACTION_FEATURED_CATEGORY_UPDATE");
            return;
        }
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        Utils.sdkLog("FeaturedCategoryParser", 5, exception);
        contentvalues.put("ttl", "");
          goto _L15
        jsonobject;
        if (sendSuccessBroadcast)
        {
            sendBroadcast("com.espn.action.ACTION_FEATURED_CATEGORY_UPDATE");
        } else
        if (sendPartialErrorBroadcast)
        {
            sendBroadcast("com.espn.action.ACTION_FEATURED_CATEGORY_PARTIAL_DATA_ERROR");
        }
        throw jsonobject;
_L6:
        contentvalues.put("eventsType", "");
          goto _L16
_L8:
        contentvalues.put("omnitureJson", "");
          goto _L17
_L10:
        contentvalues.put("count", "");
          goto _L18
        if (!sendPartialErrorBroadcast) goto _L20; else goto _L19
_L19:
        sendBroadcast("com.espn.action.ACTION_FEATURED_CATEGORY_PARTIAL_DATA_ERROR");
        return;
_L12:
        if (!sendPartialErrorBroadcast) goto _L20; else goto _L21
_L21:
        sendBroadcast("com.espn.action.ACTION_FEATURED_CATEGORY_PARTIAL_DATA_ERROR");
        return;
_L4:
        if (i < j) goto _L22; else goto _L2
    }
}

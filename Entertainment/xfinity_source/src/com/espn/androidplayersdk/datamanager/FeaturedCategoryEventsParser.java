// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import com.espn.androidplayersdk.utilities.EPFeaturedEventType;
import com.espn.androidplayersdk.utilities.Utils;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            JSONParserAbstract, DataManager, GenericParser, FeedsDB, 
//            ParserException

class FeaturedCategoryEventsParser extends JSONParserAbstract
{

    boolean sendSuccessBroadcast;

    FeaturedCategoryEventsParser()
    {
        sendSuccessBroadcast = false;
    }

    public void errorHandler(int i)
    {
        if (i == 1 || i == 2)
        {
            sendBroadcast("com.espn.action.ACTION_FEATURED_CATEGORY_EVENT_DATA_ERROR");
        }
    }

    void getListings(JSONObject jsonobject, HashMap hashmap)
        throws Exception
    {
        if (!jsonobject.has("listings") || jsonobject.isNull("listings")) goto _L2; else goto _L1
_L1:
        int j;
        jsonobject = jsonobject.getJSONArray("listings");
        j = jsonobject.length();
        if (j <= 0) goto _L2; else goto _L3
_L3:
        int i;
        sendSuccessBroadcast = true;
        i = 0;
_L6:
        if (i < j) goto _L4; else goto _L2
_L2:
        return;
_L4:
        DataManager.feedsDbConn.insertIntoFeaturedEventsTable(GenericParser.parseAndInsertLinearEvent(jsonobject.getJSONObject(i), hashmap));
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void parse(JSONObject jsonobject, HashMap hashmap)
    {
        Utils.sdkLog("FeaturedCategoryEventsParser", 3, null);
        if (hashmap.containsKey("eventWhere") && hashmap.containsKey("eventWhereArg"))
        {
            DataManager.feedsDbConn.delAllRows("featuredEvents", (String)hashmap.get("eventWhere"), (String[])hashmap.get("eventWhereArg"));
        }
        if ((EPFeaturedEventType)hashmap.get("featuredCatEventType") != EPFeaturedEventType.VOD) goto _L2; else goto _L1
_L1:
        Object obj1 = "VOD";
        Object obj2;
        int j;
        obj2 = jsonobject.getJSONArray("videos");
        j = ((JSONArray) (obj2)).length();
        Object obj = obj1;
        if (j <= 0) goto _L4; else goto _L3
_L3:
        sendSuccessBroadcast = true;
        int i = 0;
          goto _L5
_L4:
        obj2 = "";
        obj1 = obj2;
        if (!jsonobject.has("resultsCount"))
        {
            break MISSING_BLOCK_LABEL_142;
        }
        obj1 = obj2;
        if (!jsonobject.isNull("resultsCount"))
        {
            obj1 = jsonobject.getString("resultsCount");
        }
        GenericParser.parseAndUpdateMetaData(hashmap, ((String) (obj)), ((String) (obj1)), null);
        if (sendSuccessBroadcast)
        {
            sendBroadcast("com.espn.action.ACTION_FEATURED_CATEGORY_EVENT_UPDATE");
        }
_L9:
        return;
_L14:
        DataManager.feedsDbConn.insertIntoFeaturedEventsTable(GenericParser.parseAndInsertVODEvent(((JSONArray) (obj2)).getJSONObject(i), hashmap));
_L7:
        i++;
        continue; /* Loop/switch isn't completed */
        obj;
        Utils.sdkLog("FeaturedCategoryEventsParser: No HLS Video", 3, ((Exception) (obj)));
        if (true) goto _L7; else goto _L6
_L6:
        jsonobject;
        Utils.sdkLog("FeaturedCategoryEventsParser", 5, jsonobject);
        sendSuccessBroadcast = false;
        errorHandler(2);
        if (!sendSuccessBroadcast) goto _L9; else goto _L8
_L8:
        sendBroadcast("com.espn.action.ACTION_FEATURED_CATEGORY_EVENT_UPDATE");
        return;
_L2:
        obj1 = hashmap.get("eventType").toString();
        if (!jsonobject.has("categories") || jsonobject.isNull("categories")) goto _L11; else goto _L10
_L10:
        j = jsonobject.getJSONArray("categories").length();
        obj = obj1;
        if (j <= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        sendSuccessBroadcast = true;
        i = 0;
_L12:
        obj = obj1;
        if (i >= j)
        {
            continue; /* Loop/switch isn't completed */
        }
        getListings(jsonobject, hashmap);
        i++;
        if (true) goto _L12; else goto _L11
_L11:
        getListings(jsonobject, hashmap);
        obj = obj1;
        continue; /* Loop/switch isn't completed */
        jsonobject;
        if (sendSuccessBroadcast)
        {
            sendBroadcast("com.espn.action.ACTION_FEATURED_CATEGORY_EVENT_UPDATE");
        }
        throw jsonobject;
_L5:
        if (i < j) goto _L14; else goto _L13
_L13:
        obj = obj1;
        if (true) goto _L4; else goto _L15
_L15:
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import com.espn.androidplayersdk.utilities.Utils;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            JSONParserAbstract, ParserException, DataManager, FeedsDB, 
//            GenericParser

class TrendingEventsParser extends JSONParserAbstract
{

    boolean sendSuccessBroadcast;

    TrendingEventsParser()
    {
        sendSuccessBroadcast = false;
    }

    public void errorHandler(int i)
    {
        if (i == 1 || i == 2)
        {
            sendBroadcast("com.espn.action.FEATURED_TRENDING_EVENT_DATA_ERROR");
        }
    }

    public void parse(JSONObject jsonobject, HashMap hashmap)
    {
        if (hashmap.containsKey("eventWhere") && hashmap.containsKey("eventWhereArg"))
        {
            DataManager.feedsDbConn.delAllRows("featuredEvents", (String)hashmap.get("eventWhere"), (String[])hashmap.get("eventWhereArg"));
        }
        if (!jsonobject.has("listings") || jsonobject.isNull("listings")) goto _L2; else goto _L1
_L1:
        Object obj;
        int j;
        obj = jsonobject.getJSONArray("listings");
        j = ((JSONArray) (obj)).length();
        if (j <= 0) goto _L2; else goto _L3
_L3:
        sendSuccessBroadcast = true;
        int i = 0;
          goto _L4
_L2:
        if (!jsonobject.has("videos") || jsonobject.isNull("videos")) goto _L6; else goto _L5
_L5:
        obj = jsonobject.getJSONArray("videos");
        j = ((JSONArray) (obj)).length();
        if (j <= 0) goto _L6; else goto _L7
_L7:
        sendSuccessBroadcast = true;
        i = 0;
          goto _L8
_L6:
        String s;
        s = "";
        obj = s;
        if (!jsonobject.has("resultsCount"))
        {
            break MISSING_BLOCK_LABEL_173;
        }
        obj = s;
        if (!jsonobject.isNull("resultsCount"))
        {
            obj = jsonobject.getString("resultsCount");
        }
        GenericParser.parseAndUpdateMetaData(hashmap, "trending", ((String) (obj)), null);
        if (sendSuccessBroadcast)
        {
            sendBroadcast("com.espn.action.FEATURED_TRENDING_EVENT_UPDATED");
        }
_L12:
        return;
_L13:
        DataManager.feedsDbConn.insertIntoFeaturedEventsTable(GenericParser.parseAndInsertLinearEvent(((JSONArray) (obj)).getJSONObject(i), hashmap));
        i++;
        continue; /* Loop/switch isn't completed */
_L14:
        DataManager.feedsDbConn.insertIntoFeaturedEventsTable(GenericParser.parseAndInsertVODEvent(((JSONArray) (obj)).getJSONObject(i), hashmap));
_L10:
        i++;
        continue; /* Loop/switch isn't completed */
        ParserException parserexception;
        parserexception;
        Utils.sdkLog("TopSportEventParser: No HLS Video", 3, parserexception);
        if (true) goto _L10; else goto _L9
_L9:
        jsonobject;
        Utils.sdkLog("TrendingEventsParser", 5, jsonobject);
        sendSuccessBroadcast = false;
        errorHandler(2);
        if (!sendSuccessBroadcast) goto _L12; else goto _L11
_L11:
        sendBroadcast("com.espn.action.FEATURED_TRENDING_EVENT_UPDATED");
        return;
        jsonobject;
        if (sendSuccessBroadcast)
        {
            sendBroadcast("com.espn.action.FEATURED_TRENDING_EVENT_UPDATED");
        }
        throw jsonobject;
_L4:
        if (i < j) goto _L13; else goto _L2
_L8:
        if (i < j) goto _L14; else goto _L6
    }
}

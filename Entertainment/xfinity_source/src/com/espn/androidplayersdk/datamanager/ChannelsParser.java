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

class ChannelsParser extends JSONParserAbstract
{

    boolean sendPartialErrorBroadcast;
    boolean sendSuccessBroadcast;

    ChannelsParser()
    {
        sendSuccessBroadcast = false;
        sendPartialErrorBroadcast = false;
    }

    public void errorHandler(int i)
    {
        if (i == 2)
        {
            sendBroadcast("com.espn.action.CHANNEL_DATA_ERROR");
        }
    }

    public void parse(JSONObject jsonobject, HashMap hashmap)
    {
        Utils.sdkLog("ChannelsParser.parse", 3, null);
        ContentValues contentvalues;
        JSONArray jsonarray;
        int j;
        contentvalues = new ContentValues();
        jsonarray = jsonobject.getJSONArray("networks");
        DataManager.feedsDbConn.delAllRows("channel", null, null);
        j = jsonarray.length();
        if (j <= 0) goto _L2; else goto _L1
_L1:
        sendSuccessBroadcast = true;
        int i = 0;
_L17:
        if (i < j) goto _L4; else goto _L3
_L3:
        Object obj = new ContentValues();
        if (hashmap == null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        boolean flag = hashmap.containsKey("ttl");
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        ((ContentValues) (obj)).put("TTL", Utils.getExpiryTime(Integer.parseInt((String)hashmap.get("ttl"))));
_L10:
        if (jsonobject.has("omniture") && !jsonobject.isNull("omniture"))
        {
            ((ContentValues) (obj)).put("omnitureJason", jsonobject.getJSONObject("omniture").toString());
        }
        DataManager.feedsDbConn.insertOrUpdateMetaChannelTable(((ContentValues) (obj)));
_L2:
        if (!sendSuccessBroadcast) goto _L6; else goto _L5
_L5:
        sendBroadcast("com.espn.action.CHANNELS_UPDATED");
_L14:
        return;
_L4:
        contentvalues.clear();
        obj = jsonarray.getJSONObject(i);
        if (((JSONObject) (obj)).has("name") && !((JSONObject) (obj)).isNull("name"))
        {
            contentvalues.put("channelName", ((JSONObject) (obj)).getString("name"));
        }
        if (((JSONObject) (obj)).has("type") && !((JSONObject) (obj)).isNull("type"))
        {
            contentvalues.put("type", ((JSONObject) (obj)).getString("type"));
        }
        if (((JSONObject) (obj)).has("id") && !((JSONObject) (obj)).isNull("id"))
        {
            contentvalues.put("id", ((JSONObject) (obj)).getString("id"));
        }
        if (((JSONObject) (obj)).has("abbreviation") && !((JSONObject) (obj)).isNull("abbreviation"))
        {
            contentvalues.put("code", ((JSONObject) (obj)).getString("abbreviation"));
        }
        if (((JSONObject) (obj)).has("isActive") && !((JSONObject) (obj)).isNull("isActive"))
        {
            contentvalues.put("isActive", ((JSONObject) (obj)).getString("isActive"));
        }
        if (((JSONObject) (obj)).has("adobeResource") && !((JSONObject) (obj)).isNull("adobeResource"))
        {
            contentvalues.put("resourceId", ((JSONObject) (obj)).getString("adobeResource"));
        }
        if (((JSONObject) (obj)).has("images") && !((JSONObject) (obj)).isNull("images"))
        {
            obj = ((JSONObject) (obj)).getJSONObject("images");
            if (((JSONObject) (obj)).has("small") && !((JSONObject) (obj)).isNull("small"))
            {
                contentvalues.put("ImageSmall", ((JSONObject) (obj)).getJSONObject("small").getString("href"));
            }
            if (((JSONObject) (obj)).has("slates") && !((JSONObject) (obj)).isNull("slates"))
            {
                obj = ((JSONObject) (obj)).getJSONObject("slates");
                if (((JSONObject) (obj)).has("small") && !((JSONObject) (obj)).isNull("small"))
                {
                    contentvalues.put("slateImageSmall", ((JSONObject) (obj)).getJSONObject("small").getString("href"));
                }
                if (((JSONObject) (obj)).has("medium") && !((JSONObject) (obj)).isNull("medium"))
                {
                    contentvalues.put("slateImageMedium", ((JSONObject) (obj)).getJSONObject("medium").getString("href"));
                }
                if (((JSONObject) (obj)).has("large") && !((JSONObject) (obj)).isNull("large"))
                {
                    contentvalues.put("slateImageLarge", ((JSONObject) (obj)).getJSONObject("large").getString("href"));
                }
            }
        }
        DataManager.feedsDbConn.insertIntoChannelsTable(contentvalues);
_L8:
        i++;
        continue; /* Loop/switch isn't completed */
        obj;
        if ((new StringBuilder("ChannelsParser: Error: ")).append(((Exception) (obj)).getMessage()).toString() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = ((Exception) (obj)).getMessage();
_L9:
        Utils.sdkLog(((String) (obj)), 5, null);
        sendSuccessBroadcast = false;
        sendPartialErrorBroadcast = true;
        if (true) goto _L8; else goto _L7
        jsonobject;
        if ((new StringBuilder("ChannelsParser: Error: ")).append(jsonobject.getMessage()).toString() == null)
        {
            break MISSING_BLOCK_LABEL_754;
        }
        jsonobject = jsonobject.getMessage();
_L12:
        Utils.sdkLog(jsonobject, 5, null);
        sendSuccessBroadcast = false;
        sendPartialErrorBroadcast = false;
        errorHandler(2);
        if (sendSuccessBroadcast)
        {
            sendBroadcast("com.espn.action.CHANNELS_UPDATED");
            return;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        obj = "";
          goto _L9
        hashmap;
        if ((new StringBuilder("ChannelsParser: Error: ")).append(hashmap.getMessage()).toString() == null)
        {
            break MISSING_BLOCK_LABEL_748;
        }
        hashmap = hashmap.getMessage();
_L11:
        Utils.sdkLog(hashmap, 5, null);
        ((ContentValues) (obj)).put("TTL", "");
          goto _L10
        jsonobject;
        if (sendSuccessBroadcast)
        {
            sendBroadcast("com.espn.action.CHANNELS_UPDATED");
        } else
        if (sendPartialErrorBroadcast)
        {
            sendBroadcast("com.espn.action.CHANNEL_PARTIAL_DATA_ERROR");
        }
        throw jsonobject;
        hashmap = "";
          goto _L11
        jsonobject = "";
          goto _L12
        if (!sendPartialErrorBroadcast) goto _L14; else goto _L13
_L13:
        sendBroadcast("com.espn.action.CHANNEL_PARTIAL_DATA_ERROR");
        return;
_L6:
        if (!sendPartialErrorBroadcast) goto _L14; else goto _L15
_L15:
        sendBroadcast("com.espn.action.CHANNEL_PARTIAL_DATA_ERROR");
        return;
        if (true) goto _L17; else goto _L16
_L16:
    }
}

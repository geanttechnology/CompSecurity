// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.event;

import com.exacttarget.etpushsdk.data.Message;
import com.exacttarget.etpushsdk.data.Region;
import com.exacttarget.etpushsdk.util.l;
import com.exacttarget.etpushsdk.util.m;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.exacttarget.etpushsdk.event:
//            GeofenceResponse, IEventFactory

public class GeofenceResponseEvent extends GeofenceResponse
    implements IEventFactory
{

    private static final String TAG = "~!GeofenceResponseEvent";

    public GeofenceResponseEvent()
    {
    }

    public GeofenceResponseEvent fromJson(String s)
    {
        Object obj;
        Region region;
        Object obj1;
        ArrayList arraylist;
        int i;
        int j;
        try
        {
            s = new JSONObject(s);
            obj = s.getJSONObject("refreshCenter");
            setRefreshCenter(new l(Double.valueOf(((JSONObject) (obj)).getDouble("latitude")), Double.valueOf(((JSONObject) (obj)).getDouble("longitude"))));
            setRefreshRadius(Integer.valueOf(s.getInt("refreshRadius")));
            s = s.optJSONArray("fences");
            obj = new ArrayList();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            m.c("~!GeofenceResponseEvent", s.getMessage(), s);
            return null;
        }
        if (s == null) goto _L2; else goto _L1
_L1:
        i = 0;
_L5:
        if (i >= s.length())
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = s.getJSONObject(i);
        region = new Region();
        region.setId(((JSONObject) (obj1)).getString("id"));
        region.setCenter(new l(Double.valueOf(((JSONObject) (obj1)).getJSONObject("center").getDouble("latitude")), Double.valueOf(((JSONObject) (obj1)).getJSONObject("center").getDouble("longitude"))));
        region.setRadius(Integer.valueOf(((JSONObject) (obj1)).getInt("radius")));
        region.setLocationType(Integer.valueOf(((JSONObject) (obj1)).getInt("locationType")));
        region.setName(((JSONObject) (obj1)).getString("name"));
        region.setDescription(((JSONObject) (obj1)).getString("description"));
        obj1 = ((JSONObject) (obj1)).optJSONArray("messages");
        arraylist = new ArrayList();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_280;
        }
        j = 0;
_L4:
        if (j >= ((JSONArray) (obj1)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(new Message(((JSONArray) (obj1)).getJSONObject(j)));
        j++;
        if (true) goto _L4; else goto _L3
_L3:
        region.setMessages(arraylist);
        ((List) (obj)).add(region);
        i++;
        if (true) goto _L5; else goto _L2
_L2:
        setFences(((List) (obj)));
        return this;
    }

    public volatile Object fromJson(String s)
    {
        return fromJson(s);
    }

    public void setDatabaseIds(GeofenceResponseEvent geofenceresponseevent, List list)
    {
    }

    public volatile void setDatabaseIds(Object obj, List list)
    {
        setDatabaseIds((GeofenceResponseEvent)obj, list);
    }
}

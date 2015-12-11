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
//            BeaconResponse, IEventFactory

public class BeaconResponseEvent extends BeaconResponse
    implements IEventFactory
{

    private static final String TAG = "~!BeaconResponseEvent";

    public BeaconResponseEvent()
    {
    }

    public BeaconResponseEvent fromJson(String s)
    {
        ArrayList arraylist;
        Region region;
        Object obj;
        ArrayList arraylist1;
        int i;
        int j;
        try
        {
            s = (new JSONObject(s)).optJSONArray("beacons");
            arraylist = new ArrayList();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            m.c("~!BeaconResponseEvent", s.getMessage(), s);
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
        obj = s.getJSONObject(i);
        region = new Region();
        region.setId(((JSONObject) (obj)).getString("id"));
        region.setCenter(new l(Double.valueOf(((JSONObject) (obj)).getJSONObject("center").getDouble("latitude")), Double.valueOf(((JSONObject) (obj)).getJSONObject("center").getDouble("longitude"))));
        region.setLocationType(Integer.valueOf(((JSONObject) (obj)).getInt("locationType")));
        region.setName(((JSONObject) (obj)).getString("name"));
        region.setDescription(((JSONObject) (obj)).getString("description"));
        region.setMajor(Integer.valueOf(((JSONObject) (obj)).getInt("major")));
        region.setMinor(Integer.valueOf(((JSONObject) (obj)).getInt("minor")));
        region.setGuid(((JSONObject) (obj)).getString("proximityUuid"));
        obj = ((JSONObject) (obj)).optJSONArray("messages");
        arraylist1 = new ArrayList();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_254;
        }
        j = 0;
_L4:
        if (j >= ((JSONArray) (obj)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist1.add(new Message(((JSONArray) (obj)).getJSONObject(j)));
        j++;
        if (true) goto _L4; else goto _L3
_L3:
        region.setMessages(arraylist1);
        arraylist.add(region);
        i++;
        if (true) goto _L5; else goto _L2
_L2:
        setBeacons(arraylist);
        return this;
    }

    public volatile Object fromJson(String s)
    {
        return fromJson(s);
    }

    public void setDatabaseIds(BeaconResponseEvent beaconresponseevent, List list)
    {
    }

    public volatile void setDatabaseIds(Object obj, List list)
    {
        setDatabaseIds((BeaconResponseEvent)obj, list);
    }
}

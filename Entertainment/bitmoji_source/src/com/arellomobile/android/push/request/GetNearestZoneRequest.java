// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push.request;

import android.content.Context;
import android.location.Location;
import com.arellomobile.android.push.data.PushZoneLocation;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.arellomobile.android.push.request:
//            PushRequest

public class GetNearestZoneRequest extends PushRequest
{

    private Location location;
    private PushZoneLocation zoneLocation;

    public GetNearestZoneRequest(Location location1)
    {
        location = location1;
    }

    protected void buildParams(Context context, Map map)
    {
        map.put("lat", Double.valueOf(location.getLatitude()));
        map.put("lng", Double.valueOf(location.getLongitude()));
    }

    public String getMethod()
    {
        return "getNearestZone";
    }

    public PushZoneLocation getNearestLocation()
    {
        return zoneLocation;
    }

    public void parseResponse(JSONObject jsonobject)
        throws JSONException
    {
        try
        {
            jsonobject = jsonobject.getJSONObject("response");
            zoneLocation = new PushZoneLocation();
            zoneLocation.setName(jsonobject.getString("name"));
            zoneLocation.setLat(jsonobject.getDouble("lat"));
            zoneLocation.setLng(jsonobject.getDouble("lng"));
            zoneLocation.setDistanceTo(jsonobject.getLong("distance"));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            zoneLocation = null;
        }
        throw jsonobject;
    }
}

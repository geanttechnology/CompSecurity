// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.location;

import com.urbanairship.Logger;
import com.urbanairship.analytics.Event;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.urbanairship.location:
//            ProximityRegion, CircularRegion

public class RegionEvent extends Event
{

    private static final String BOUNDARY_EVENT = "action";
    public static final int BOUNDARY_EVENT_ENTER = 1;
    public static final int BOUNDARY_EVENT_EXIT = 2;
    private static final String CIRCULAR_REGION = "circular_region";
    private static final String CIRCULAR_REGION_RADIUS = "radius";
    private static final String LATITUDE = "latitude";
    private static final String LONGITUDE = "longitude";
    public static final int MAX_CHARACTER_LENGTH = 255;
    public static final double MAX_LATITUDE = 90D;
    public static final double MAX_LONGITUDE = 180D;
    public static final double MIN_LATITUDE = -90D;
    public static final double MIN_LONGITUDE = -180D;
    private static final String PROXIMITY_REGION = "proximity";
    private static final String PROXIMITY_REGION_ID = "proximity_id";
    private static final String PROXIMITY_REGION_MAJOR = "major";
    private static final String PROXIMITY_REGION_MINOR = "minor";
    private static final String PROXIMITY_REGION_RSSI = "rssi";
    private static final String REGION_ID = "region_id";
    private static final String SOURCE = "source";
    public static final String TYPE = "region_event";
    private final int boundaryEvent;
    private CircularRegion circularRegion;
    private ProximityRegion proximityRegion;
    private final String regionId;
    private final String source;

    public RegionEvent(String s, String s1, int i)
    {
        regionId = s;
        source = s1;
        boundaryEvent = i;
    }

    static boolean regionEventCharacterCountIsValid(String s)
    {
        return s.length() <= 255 && s.length() > 0;
    }

    static boolean regionEventLatitudeIsValid(Double double1)
    {
        return double1.doubleValue() <= 90D && double1.doubleValue() >= -90D;
    }

    static boolean regionEventLongitudeIsValid(Double double1)
    {
        return double1.doubleValue() <= 180D && double1.doubleValue() >= -180D;
    }

    protected final JSONObject getEventData()
    {
        JSONObject jsonobject = new JSONObject();
        if (isValid()) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((JSONObject) (obj));
_L2:
        jsonobject.putOpt("region_id", regionId);
        jsonobject.putOpt("source", source);
        if (boundaryEvent == 1)
        {
            obj = "enter";
        } else
        {
            obj = "exit";
        }
        try
        {
            jsonobject.putOpt("action", obj);
            if (proximityRegion != null && proximityRegion.isValid())
            {
                obj = new JSONObject();
                ((JSONObject) (obj)).putOpt("proximity_id", proximityRegion.getProximityId());
                ((JSONObject) (obj)).putOpt("major", Integer.valueOf(proximityRegion.getMajor()));
                ((JSONObject) (obj)).putOpt("minor", Integer.valueOf(proximityRegion.getMinor()));
                ((JSONObject) (obj)).putOpt("latitude", Double.toString(proximityRegion.getLatitude().doubleValue()));
                ((JSONObject) (obj)).putOpt("longitude", Double.toString(proximityRegion.getLongitude().doubleValue()));
                ((JSONObject) (obj)).putOpt("rssi", proximityRegion.getRssi());
                jsonobject.putOpt("proximity", obj);
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Logger.error((new StringBuilder("Error constructing JSON data for ")).append(getType()).toString());
            return jsonobject;
        }
        obj = jsonobject;
        if (circularRegion == null) goto _L4; else goto _L3
_L3:
        obj = jsonobject;
        if (!circularRegion.isValid()) goto _L4; else goto _L5
_L5:
        obj = new JSONObject();
        ((JSONObject) (obj)).putOpt("radius", String.format(Locale.US, "%.1f", new Object[] {
            Double.valueOf(circularRegion.getRadius())
        }));
        ((JSONObject) (obj)).putOpt("latitude", String.format(Locale.US, "%.7f", new Object[] {
            Double.valueOf(circularRegion.getLatitude())
        }));
        ((JSONObject) (obj)).putOpt("longitude", String.format(Locale.US, "%.7f", new Object[] {
            Double.valueOf(circularRegion.getLongitude())
        }));
        jsonobject.putOpt("circular_region", obj);
        return jsonobject;
    }

    public final String getType()
    {
        return "region_event";
    }

    public boolean isValid()
    {
        if (regionId == null || source == null)
        {
            Logger.error("The region ID and source must not be null.");
            return false;
        }
        if (!regionEventCharacterCountIsValid(regionId))
        {
            Logger.error("The region ID must not be greater than 255 or less than 1 characters in length.");
            return false;
        }
        if (!regionEventCharacterCountIsValid(source))
        {
            Logger.error("The source must not be greater than 255 or less than 1 characters in length.");
            return false;
        }
        if (boundaryEvent <= 0 || boundaryEvent > 2)
        {
            Logger.error("The boundary event must either be an entrance (1) or an exit (2).");
            return false;
        } else
        {
            return true;
        }
    }

    public void setCircularRegion(CircularRegion circularregion)
    {
        circularRegion = circularregion;
    }

    public void setProximityRegion(ProximityRegion proximityregion)
    {
        proximityRegion = proximityregion;
    }
}

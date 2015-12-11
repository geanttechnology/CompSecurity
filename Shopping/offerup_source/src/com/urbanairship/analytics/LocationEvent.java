// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.analytics;

import android.location.Location;
import com.urbanairship.Logger;
import com.urbanairship.util.UAStringUtil;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.urbanairship.analytics:
//            Event

public class LocationEvent extends Event
{

    static final String FOREGROUND_KEY = "foreground";
    static final String H_ACCURACY_KEY = "h_accuracy";
    static final String LATITUDE_KEY = "lat";
    static final String LONGITUDE_KEY = "long";
    static final String PROVIDER_KEY = "provider";
    static final String REQUESTED_ACCURACY_KEY = "requested_accuracy";
    static final String TYPE = "location";
    static final String UPDATE_DISTANCE_KEY = "update_dist";
    static final String UPDATE_TYPE_KEY = "update_type";
    static final String V_ACCURACY_KEY = "v_accuracy";
    private final String accuracy;
    private final String foreground;
    private final String latitude;
    private final String longitude;
    private final String provider;
    private final String requestedAccuracy;
    private final String updateDistance;
    private final UpdateType updateType;

    public LocationEvent(Location location, UpdateType updatetype, int i, int j, boolean flag)
    {
        latitude = String.format(Locale.US, "%.6f", new Object[] {
            Double.valueOf(location.getLatitude())
        });
        longitude = String.format(Locale.US, "%.6f", new Object[] {
            Double.valueOf(location.getLongitude())
        });
        String s;
        if (UAStringUtil.isEmpty(location.getProvider()))
        {
            s = "UNKNOWN";
        } else
        {
            s = location.getProvider();
        }
        provider = s;
        accuracy = String.valueOf(location.getAccuracy());
        if (i >= 0)
        {
            location = String.valueOf(i);
        } else
        {
            location = "NONE";
        }
        requestedAccuracy = location;
        if (j >= 0)
        {
            location = String.valueOf(j);
        } else
        {
            location = "NONE";
        }
        updateDistance = location;
        if (flag)
        {
            location = "true";
        } else
        {
            location = "false";
        }
        foreground = location;
        updateType = updatetype;
    }

    protected final JSONObject getEventData()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("lat", latitude);
            jsonobject.put("long", longitude);
            jsonobject.put("requested_accuracy", requestedAccuracy);
            jsonobject.put("update_type", updateType.toString());
            jsonobject.put("provider", provider);
            jsonobject.put("h_accuracy", accuracy);
            jsonobject.put("v_accuracy", "NONE");
            jsonobject.put("foreground", foreground);
            jsonobject.put("update_dist", updateDistance);
        }
        catch (JSONException jsonexception)
        {
            Logger.error("LocationEvent - Error constructing JSON data.", jsonexception);
            return jsonobject;
        }
        return jsonobject;
    }

    public String getType()
    {
        return "location";
    }

    private class UpdateType extends Enum
    {

        private static final UpdateType $VALUES[];
        public static final UpdateType CONTINUOUS;
        public static final UpdateType SINGLE;

        public static UpdateType valueOf(String s)
        {
            return (UpdateType)Enum.valueOf(com/urbanairship/analytics/LocationEvent$UpdateType, s);
        }

        public static UpdateType[] values()
        {
            return (UpdateType[])$VALUES.clone();
        }

        static 
        {
            CONTINUOUS = new UpdateType("CONTINUOUS", 0);
            SINGLE = new UpdateType("SINGLE", 1);
            $VALUES = (new UpdateType[] {
                CONTINUOUS, SINGLE
            });
        }

        private UpdateType(String s, int i)
        {
            super(s, i);
        }
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.event;

import com.exacttarget.etpushsdk.data.LocationUpdate;
import com.exacttarget.etpushsdk.util.m;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

// Referenced classes of package com.exacttarget.etpushsdk.event:
//            IEventFactory

public class LocationUpdateEvent extends LocationUpdate
    implements IEventFactory
{

    private static final String TAG = "~!LocationUpdateEvent";

    public LocationUpdateEvent()
    {
    }

    public LocationUpdateEvent fromJson(String s)
    {
        int i = 0;
        SimpleDateFormat simpledateformat;
        String as[];
        String s1;
        int j;
        try
        {
            simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
            s = new JSONObject(s);
            setDeviceId(s.getString("deviceId"));
            setLatitude(Double.valueOf(s.getDouble("latitude")));
            setLongitude(Double.valueOf(s.getDouble("longitude")));
            setAccuracy(Integer.valueOf(s.getInt("accuracy")));
            setTimestamp(simpledateformat.parse("1970-01-01T00:00:00.001Z"));
            as = new String[2];
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            m.c("~!LocationUpdateEvent", s.getMessage(), s);
            return null;
        }
        as[0] = "location_DateTime_Utc";
        as[1] = "location_datetime_utc";
        j = as.length;
_L2:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        s1 = as[i];
        if (!s.has(s1))
        {
            break MISSING_BLOCK_LABEL_161;
        }
        m.a("~!LocationUpdateEvent", String.format("Key: %s", new Object[] {
            s1
        }));
        setTimestamp(simpledateformat.parse(s.getString(s1)));
        return this;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public volatile Object fromJson(String s)
    {
        return fromJson(s);
    }

    public void setDatabaseIds(LocationUpdateEvent locationupdateevent, List list)
    {
    }

    public volatile void setDatabaseIds(Object obj, List list)
    {
        setDatabaseIds((LocationUpdateEvent)obj, list);
    }
}

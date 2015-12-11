// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.reporting;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.rdio.android.core.reporting:
//            PlayEvent, PlayEventType

public class TrackPlayEvent extends PlayEvent
{

    private int deviceType;
    public boolean hasPlayedPastSignificantTime;
    public boolean isOfflineStream;
    public String parentKey;
    public boolean recordedPause;
    public boolean shouldSendToServer;
    public String streamType;
    private JSONArray subEvents;
    private String trackKey;

    public TrackPlayEvent(int i, String s, PlayEventType playeventtype)
    {
        super(playeventtype);
        subEvents = new JSONArray();
        trackKey = s;
        deviceType = i;
    }

    public void addSubEvent(PlayEvent playevent)
    {
        subEvents.put(playevent.toJson());
    }

    public String getTrackKey()
    {
        return trackKey;
    }

    public JSONObject toJson()
    {
        JSONObject jsonobject = super.toJson();
        try
        {
            jsonobject.put("key", trackKey);
            jsonobject.put("streamType", streamType);
            jsonobject.put("sourceKey", parentKey);
            jsonobject.put("tethered", isOfflineStream);
            jsonobject.put("events", subEvents);
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return jsonobject;
        }
        return jsonobject;
    }
}

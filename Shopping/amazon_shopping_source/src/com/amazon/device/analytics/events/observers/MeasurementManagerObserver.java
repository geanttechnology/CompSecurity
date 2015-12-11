// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.analytics.events.observers;

import android.content.Context;
import com.amazon.device.analytics.configuration.Configuration;
import com.amazon.device.analytics.events.Event;
import com.amazon.device.analytics.events.adapters.MeasurementEventAdapter;
import com.amazon.device.analytics.log.Logger;
import com.amazon.device.analytics.log.Logging;
import com.amazon.device.analytics.util.JSONBuilder;
import com.amazon.device.analytics.util.JSONSerializable;
import com.amazon.sdk.availability.MeasurementManager;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.analytics.events.observers:
//            EventObserver

public class MeasurementManagerObserver
    implements EventObserver, JSONSerializable
{

    private static Logger logger = Logging.getLogger(com/amazon/device/analytics/events/observers/MeasurementManagerObserver);
    MeasurementEventAdapter adapter;
    Context context;
    MeasurementManager manager;

    public MeasurementManagerObserver(Context context1, MeasurementManager measurementmanager, Configuration configuration)
    {
        this(context1, measurementmanager, new MeasurementEventAdapter(configuration));
    }

    protected MeasurementManagerObserver(Context context1, MeasurementManager measurementmanager, MeasurementEventAdapter measurementeventadapter)
    {
        context = context1;
        manager = measurementmanager;
        adapter = measurementeventadapter;
    }

    public void notify(Event event)
    {
        event = adapter.translateFromEvent(event);
        if (event == null)
        {
            logger.e("Failed to translate Event to a Measurement");
            return;
        } else
        {
            manager.putMeasurement(context, event);
            return;
        }
    }

    public JSONObject toJSONObject()
    {
        return (new JSONBuilder(this)).toJSONObject();
    }

    public String toString()
    {
        JSONObject jsonobject = toJSONObject();
        String s;
        try
        {
            s = jsonobject.toString(4);
        }
        catch (JSONException jsonexception)
        {
            return jsonobject.toString();
        }
        return s;
    }

}

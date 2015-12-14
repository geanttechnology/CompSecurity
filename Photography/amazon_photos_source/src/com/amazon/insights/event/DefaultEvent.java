// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.event;

import com.amazon.insights.Event;
import com.amazon.insights.InsightsCredentials;
import com.amazon.insights.core.InsightsContext;
import com.amazon.insights.core.idresolver.Id;
import com.amazon.insights.core.log.Logger;
import com.amazon.insights.core.system.AppDetails;
import com.amazon.insights.core.system.DeviceDetails;
import com.amazon.insights.core.system.System;
import com.amazon.insights.core.util.DateUtil;
import com.amazon.insights.core.util.JSONBuilder;
import com.amazon.insights.core.util.JSONSerializable;
import com.amazon.insights.core.util.SDKInfo;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.insights.event:
//            InternalEvent

public final class DefaultEvent
    implements JSONSerializable, InternalEvent
{

    private static Logger logger = Logger.getLogger(com/amazon/insights/event/DefaultEvent);
    private final AppDetails appDetails;
    private final String applicationKey;
    private final Map attributes = new ConcurrentHashMap();
    private final DeviceDetails deviceDetails;
    private final String eventType;
    private final Map metrics = new ConcurrentHashMap();
    private final String sdkName;
    private final String sdkVersion;
    private final Long timestamp;
    private final Id uniqueId;

    DefaultEvent(String s, Map map, Map map1, String s1, SDKInfo sdkinfo, Long long1, Id id, 
            AppDetails appdetails, DeviceDetails devicedetails)
    {
        applicationKey = s1;
        sdkName = sdkinfo.getName();
        sdkVersion = sdkinfo.getVersion();
        timestamp = long1;
        uniqueId = id;
        eventType = s;
        appDetails = appdetails;
        deviceDetails = devicedetails;
        if (map != null)
        {
            for (s = map.entrySet().iterator(); s.hasNext(); addAttribute((String)map.getKey(), (String)map.getValue()))
            {
                map = (java.util.Map.Entry)s.next();
            }

        }
        if (map1 != null)
        {
            for (s = map1.entrySet().iterator(); s.hasNext(); addMetric((String)map.getKey(), (Number)map.getValue()))
            {
                map = (java.util.Map.Entry)s.next();
            }

        }
    }

    public static DefaultEvent createFromEvent(InsightsContext insightscontext, Long long1, Event event)
    {
        return new DefaultEvent(event.getEventType(), event.getAllAttributes(), event.getAllMetrics(), insightscontext.getCredentials().getApplicationKey(), insightscontext.getSDKInfo(), long1, insightscontext.getUniqueId(), insightscontext.getSystem().getAppDetails(), insightscontext.getSystem().getDeviceDetails());
    }

    public static DefaultEvent newInstance(InsightsContext insightscontext, Long long1, String s)
    {
        return new DefaultEvent(s, null, null, insightscontext.getCredentials().getApplicationKey(), insightscontext.getSDKInfo(), long1, insightscontext.getUniqueId(), insightscontext.getSystem().getAppDetails(), insightscontext.getSystem().getDeviceDetails());
    }

    public void addAttribute(String s, String s1)
    {
        if (s == null)
        {
            return;
        }
        if (s1 != null)
        {
            attributes.put(s, s1);
            return;
        } else
        {
            attributes.remove(s);
            return;
        }
    }

    public void addMetric(String s, Number number)
    {
        if (s == null)
        {
            return;
        }
        if (number != null)
        {
            metrics.put(s, number);
            return;
        } else
        {
            metrics.remove(s);
            return;
        }
    }

    public Map getAllAttributes()
    {
        return Collections.unmodifiableMap(attributes);
    }

    public Map getAllMetrics()
    {
        return Collections.unmodifiableMap(metrics);
    }

    public String getApplicationKey()
    {
        return applicationKey;
    }

    public String getAttribute(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return (String)attributes.get(s);
        }
    }

    public Long getEventTimestamp()
    {
        return timestamp;
    }

    public String getEventType()
    {
        return eventType;
    }

    public Id getUniqueId()
    {
        return uniqueId;
    }

    public boolean hasAttribute(String s)
    {
        if (s == null)
        {
            return false;
        } else
        {
            return attributes.containsKey(s);
        }
    }

    public boolean hasMetric(String s)
    {
        if (s == null)
        {
            return false;
        } else
        {
            return metrics.containsKey(s);
        }
    }

    public JSONObject toJSONObject()
    {
        Object obj = deviceDetails.locale();
        JSONBuilder jsonbuilder;
        if (obj != null)
        {
            obj = ((Locale) (obj)).toString();
        } else
        {
            obj = "UNKNOWN";
        }
        jsonbuilder = new JSONBuilder(this);
        jsonbuilder.withAttribute("application_key", getApplicationKey());
        jsonbuilder.withAttribute("event_type", getEventType());
        jsonbuilder.withAttribute("unique_id", getUniqueId().getValue());
        jsonbuilder.withAttribute("timestamp", DateUtil.isoDateFromMillis(getEventTimestamp().longValue()));
        jsonbuilder.withAttribute("platform", deviceDetails.platform());
        jsonbuilder.withAttribute("platform_version", deviceDetails.platformVersion());
        jsonbuilder.withAttribute("make", deviceDetails.manufacturer());
        jsonbuilder.withAttribute("model", deviceDetails.model());
        jsonbuilder.withAttribute("locale", obj);
        jsonbuilder.withAttribute("sdk_version", sdkVersion);
        jsonbuilder.withAttribute("sdk_name", sdkName);
        jsonbuilder.withAttribute("app_version_name", appDetails.versionName());
        jsonbuilder.withAttribute("app_version_code", appDetails.versionCode());
        jsonbuilder.withAttribute("app_package_name", appDetails.packageName());
        obj = new JSONObject();
        for (Iterator iterator = getAllAttributes().entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            try
            {
                ((JSONObject) (obj)).put((String)entry.getKey(), entry.getValue());
            }
            catch (JSONException jsonexception) { }
        }

        JSONObject jsonobject = new JSONObject();
        Iterator iterator1 = getAllMetrics().entrySet().iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry1 = (java.util.Map.Entry)iterator1.next();
            if (((Number)entry1.getValue()).getClass() != null)
            {
                try
                {
                    jsonobject.put((String)entry1.getKey(), new BigDecimal(((Number)entry1.getValue()).toString()));
                }
                catch (JSONException jsonexception1)
                {
                    logger.w((new StringBuilder()).append("error serializing metric. key:'").append((String)entry1.getKey()).append("', value: ").append(((Number)entry1.getValue()).toString()).toString(), jsonexception1);
                }
            }
        } while (true);
        if (((JSONObject) (obj)).length() > 0)
        {
            jsonbuilder.withAttribute("attributes", obj);
        }
        if (jsonobject.length() > 0)
        {
            jsonbuilder.withAttribute("metrics", jsonobject);
        }
        return jsonbuilder.toJSONObject();
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

    public volatile Event withAttribute(String s, String s1)
    {
        return withAttribute(s, s1);
    }

    public DefaultEvent withAttribute(String s, String s1)
    {
        addAttribute(s, s1);
        return this;
    }

    public volatile Event withMetric(String s, Number number)
    {
        return withMetric(s, number);
    }

    public DefaultEvent withMetric(String s, Number number)
    {
        addMetric(s, number);
        return this;
    }

}

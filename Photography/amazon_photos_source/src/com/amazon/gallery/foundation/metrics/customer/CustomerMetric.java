// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.metrics.customer;

import com.amazon.gallery.foundation.utils.log.GLogger;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.gallery.foundation.metrics.customer:
//            CustomerMetricsInfo

public class CustomerMetric
{
    public static final class Type extends Enum
    {

        private static final Type $VALUES[];
        public static final Type EVENT;
        public static final Type FIRST_START;
        public static final Type SESSION;

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(com/amazon/gallery/foundation/metrics/customer/CustomerMetric$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])$VALUES.clone();
        }

        static 
        {
            EVENT = new Type("EVENT", 0);
            SESSION = new Type("SESSION", 1);
            FIRST_START = new Type("FIRST_START", 2);
            $VALUES = (new Type[] {
                EVENT, SESSION, FIRST_START
            });
        }

        private Type(String s, int i)
        {
            super(s, i);
        }
    }


    public static final String TAG = com/amazon/gallery/foundation/metrics/customer/CustomerMetric.getName();
    private String endDateUtc;
    private int eventCount;
    private String eventName;
    private String eventTag;
    private String fileDuration;
    private String fileExtension;
    private String fileSizeBytes;
    private final CustomerMetricsInfo info;
    private String pageName;
    private final String sessionId;
    private String startDateUtc;
    private final Type type;

    public CustomerMetric(Type type1, CustomerMetricsInfo customermetricsinfo, String s)
    {
        eventCount = 1;
        fileExtension = "";
        fileSizeBytes = null;
        fileDuration = null;
        eventTag = null;
        type = type1;
        info = customermetricsinfo;
        sessionId = s;
    }

    private static String adjust(String s, int i)
    {
        String s1 = s;
        if (s != null)
        {
            s1 = s;
            if (s.length() > i)
            {
                GLogger.v(TAG, "Too long filed (%d of %d): %s", new Object[] {
                    Integer.valueOf(s.length()), Integer.valueOf(i), s
                });
                s1 = s.substring(0, i);
            }
        }
        return s1;
    }

    public JSONObject getMetricAsJson()
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("SESSION_ID", adjust(sessionId, 64));
        jsonobject.put("CLIENT_ID", adjust(info.getClientId(), 30));
        jsonobject.put("EVENT_NAME", adjust(eventName, 30));
        jsonobject.put("START_DATETIME_UTC", startDateUtc);
        jsonobject.put("END_DATETIME_UTC", endDateUtc);
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$gallery$foundation$metrics$customer$CustomerMetric$Type[];

            static 
            {
                $SwitchMap$com$amazon$gallery$foundation$metrics$customer$CustomerMetric$Type = new int[Type.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$foundation$metrics$customer$CustomerMetric$Type[Type.EVENT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$foundation$metrics$customer$CustomerMetric$Type[Type.SESSION.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$foundation$metrics$customer$CustomerMetric$Type[Type.FIRST_START.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.amazon.gallery.foundation.metrics.customer.CustomerMetric.Type[type.ordinal()];
        JVM INSTR tableswitch 1 3: default 421
    //                   1 120
    //                   2 256
    //                   3 293;
           goto _L1 _L2 _L3 _L4
_L2:
        jsonobject.put("CUSTOMER_ID", adjust(info.getCustomerId(), 64));
        jsonobject.put("PAGE_NAME", adjust(pageName, 30));
        jsonobject.put("EVENT_TAG", adjust(eventTag, 64));
        jsonobject.put("EVENT_COUNT", eventCount);
        jsonobject.put("FILE_EXTENSION", adjust(fileExtension, 10));
        jsonobject.put("FILE_SIZE_BYTES", fileSizeBytes);
        jsonobject.put("FILE_DURATION", fileDuration);
        return jsonobject;
        JSONException jsonexception;
        jsonexception;
        GLogger.ex(TAG, (new StringBuilder()).append("Failed to write metric as JSON: ").append(toString()).toString(), jsonexception);
        return jsonobject;
_L3:
        jsonobject.put("CUSTOMER_ID", adjust(info.getCustomerId(), 64));
        jsonobject.put("EVENT_TAG", adjust(eventTag, 64));
_L4:
        jsonobject.put("CLIENT_VERSION", adjust(info.getAppVersionName(), 30));
        jsonobject.put("CLIENT_TAG", adjust(info.getClientTag(), 30));
        jsonobject.put("DEVICE_PLATFORM", adjust(info.getPlatform(), 30));
        jsonobject.put("DEVICE_VERSION", adjust(info.getPlatformVersionName(), 64));
        jsonobject.put("DEVICE_MODEL", adjust(info.getModel(), 64));
        jsonobject.put("DEVICE_SERIAL_NUMBER", adjust(info.getDSN(), 64));
        return jsonobject;
_L1:
        return jsonobject;
    }

    public CustomerMetric setEndDateUtc(String s)
    {
        endDateUtc = s;
        return this;
    }

    public CustomerMetric setEventCount(int i)
    {
        eventCount = i;
        return this;
    }

    public CustomerMetric setEventName(String s)
    {
        eventName = s;
        return this;
    }

    public CustomerMetric setEventTag(String s)
    {
        eventTag = s;
        return this;
    }

    public CustomerMetric setExtra(Map map)
    {
        if (map != null)
        {
            setFileSizeBytes((String)map.get("fileSize"));
            setFileDuration((String)map.get("fileDuration"));
            setFileExtension((String)map.get("fileExtension"));
            setEventTag((String)map.get("tag"));
        }
        return this;
    }

    public CustomerMetric setFileDuration(String s)
    {
        fileDuration = s;
        return this;
    }

    public CustomerMetric setFileExtension(String s)
    {
        fileExtension = s;
        return this;
    }

    public CustomerMetric setFileSizeBytes(String s)
    {
        fileSizeBytes = s;
        return this;
    }

    public CustomerMetric setPageName(String s)
    {
        pageName = s;
        return this;
    }

    public CustomerMetric setStartDateUtc(String s)
    {
        startDateUtc = s;
        return this;
    }

    public String toString()
    {
        return getMetricAsJson().toString();
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.sdk.availability:
//            StringUtil

public class Measurement
{

    private static final Map GLOBAL_METADATA = new HashMap();
    private static String defaultClientId;
    private static String defaultClientVersion;
    private String clientId;
    private String clientVersion;
    private JSONObject measurement;
    private String measurementId;
    private String measurementName;
    private Long measurementTimestamp;
    private Number measurementValueNumber;
    private Map metadata;

    public Measurement()
    {
        metadata = new HashMap();
        measurementId = UUID.randomUUID().toString();
    }

    public static void setDefaultClientId(String s)
    {
        defaultClientId = s;
    }

    public static void setDefaultClientVersion(String s)
    {
        defaultClientVersion = s;
    }

    public static void setGlobalMetadata(String s, String s1)
    {
        GLOBAL_METADATA.put(s, s1);
    }

    public JSONObject build()
    {
        Object obj;
        obj = getClientId();
        String s = getClientVersion();
        if (StringUtil.isEmpty(((String) (obj))))
        {
            throw new IllegalArgumentException("missing client id");
        }
        if (StringUtil.isEmpty(s))
        {
            throw new IllegalArgumentException("missing client version");
        }
        if (StringUtil.isEmpty(measurementName))
        {
            throw new IllegalArgumentException("missing measurement name");
        }
        if (measurementValueNumber == null)
        {
            measurementValueNumber = Long.valueOf(0L);
        }
        if (measurementTimestamp == null)
        {
            measurementTimestamp = Long.valueOf(System.currentTimeMillis());
        }
        measurement = new JSONObject();
        try
        {
            measurement.put("clientId", obj);
            measurement.put("clientVersion", s);
            measurement.put("measurementName", measurementName);
            measurement.put("measurementValueNumber", measurementValueNumber);
            measurement.put("measurementId", measurementId);
            obj = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
            measurement.put("measurementTimestamp", ((SimpleDateFormat) (obj)).format(new Date(measurementTimestamp.longValue())));
            obj = new JSONObject();
            String s1;
            for (Iterator iterator = GLOBAL_METADATA.keySet().iterator(); iterator.hasNext(); ((JSONObject) (obj)).put(s1, GLOBAL_METADATA.get(s1)))
            {
                s1 = (String)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new IllegalArgumentException("unable to serialize measurement", ((Throwable) (obj)));
        }
        String s2;
        for (Iterator iterator1 = metadata.keySet().iterator(); iterator1.hasNext(); ((JSONObject) (obj)).put(s2, metadata.get(s2)))
        {
            s2 = (String)iterator1.next();
        }

        measurement.put("metadata", obj);
        return measurement;
    }

    public String getClientId()
    {
        if (clientId == null)
        {
            return defaultClientId;
        } else
        {
            return clientId;
        }
    }

    public String getClientVersion()
    {
        if (clientVersion == null)
        {
            return defaultClientVersion;
        } else
        {
            return clientVersion;
        }
    }

    public Measurement setClientId(String s)
    {
        clientId = s;
        return this;
    }

    public Measurement setClientVersion(String s)
    {
        clientVersion = s;
        return this;
    }

    public Measurement setMeasurementName(String s)
    {
        measurementName = s;
        return this;
    }

    public Measurement setMeasurementTimestamp(long l)
    {
        measurementTimestamp = Long.valueOf(l);
        return this;
    }

    public Measurement setMeasurementValueNumber(Number number)
    {
        measurementValueNumber = number;
        return this;
    }

    public Measurement setMetadata(String s, String s1)
    {
        metadata.put(s, s1);
        return this;
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append(String.format("{\n\t\"clientId\" : \"%s\",\n\t\"clientVersion\" : \"%s\",\n\t\"measurementName\" : \"%s\",\n\t\"measurementValueNumber\" : %d,\n\t\"measurementTimestamp\" : %d,\n\t\"metadata\" : {\n", new Object[] {
            clientId, clientVersion, measurementName, measurementValueNumber, measurementTimestamp
        }));
        String s;
        for (Iterator iterator = GLOBAL_METADATA.keySet().iterator(); iterator.hasNext(); stringbuffer.append(String.format("\t\t\"%s\" : \"%s\",\n", new Object[] {
    s, GLOBAL_METADATA.get(s)
})))
        {
            s = (String)iterator.next();
        }

        String s1;
        for (Iterator iterator1 = metadata.keySet().iterator(); iterator1.hasNext(); stringbuffer.append(String.format("\t\t\"%s\" : \"%s\",\n", new Object[] {
    s1, metadata.get(s1)
})))
        {
            s1 = (String)iterator1.next();
        }

        stringbuffer.append("\t}\n}");
        return stringbuffer.toString();
    }

}

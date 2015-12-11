// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import android.os.SystemClock;
import android.text.TextUtils;
import com.ebay.nautilus.kernel.util.DefaultHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.ebay.nautilus.kernel.net:
//            Request, AsBeacon

public class LogTrackPerf
{

    private static final String HEADER_RLOG_ID = "x-ebay-soa-rlogid";
    private static final String HEADER_RLOG_ID_FORM2 = "rlogid";
    private static final String HEADER_RLOG_ID_FORM3 = "x-ebay-api-cal-tranaction-id";
    public static final String UNKNOWN = "Unknown";
    private AsBeacon beacon;
    public final boolean beaconOnly;
    private String bytesSent;
    private boolean ignore;
    private final String operationName;
    private long operationStartTime;
    private Long parseDuration;
    private long parseStart;
    private long requestDuration;
    private long responseDuration;
    protected Map responseHeaders;
    private final String serviceName;
    private long start;

    public LogTrackPerf(AsBeacon asbeacon)
    {
        operationName = null;
        serviceName = null;
        beacon = asbeacon;
        beaconOnly = true;
    }

    public LogTrackPerf(LogTrackPerf logtrackperf)
    {
        serviceName = logtrackperf.serviceName;
        operationName = logtrackperf.operationName;
        operationStartTime = logtrackperf.operationStartTime;
        start = logtrackperf.start;
        requestDuration = logtrackperf.requestDuration;
        responseDuration = logtrackperf.responseDuration;
        ignore = logtrackperf.ignore;
        parseDuration = logtrackperf.parseDuration;
        bytesSent = logtrackperf.bytesSent;
        beacon = logtrackperf.beacon;
        beaconOnly = logtrackperf.beaconOnly;
        responseHeaders = logtrackperf.responseHeaders;
    }

    public LogTrackPerf(Request request)
    {
        this(request.getServiceName(), request.getOperationName());
        beacon = request.beacon;
    }

    public LogTrackPerf(String s, String s1)
    {
        beacon = null;
        beaconOnly = false;
        serviceName = DefaultHelper.forString(s, "Unknown");
        operationName = DefaultHelper.forString(s1, "Unknown");
        setOperationStartTime(System.currentTimeMillis());
        startTimer();
    }

    static HashMap createHeaderMap(Map map)
    {
        if (map != null) goto _L2; else goto _L1
_L1:
        map = null;
_L4:
        return map;
_L2:
        HashMap hashmap = new HashMap(map.size());
        Iterator iterator = map.entrySet().iterator();
        do
        {
            map = hashmap;
            if (!iterator.hasNext())
            {
                continue;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            Object obj = (String)entry.getKey();
            map = ((Map) (obj));
            if (obj != null)
            {
                map = ((String) (obj)).toLowerCase(Locale.US);
            }
            obj = (List)entry.getValue();
            if (obj != null && !((List) (obj)).isEmpty())
            {
                hashmap.put(map, (String)((List) (obj)).get(((List) (obj)).size() - 1));
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void startTimer()
    {
        start = SystemClock.elapsedRealtime();
    }

    public AsBeacon getBeacon()
    {
        return beacon;
    }

    public String getBytesSent()
    {
        return bytesSent;
    }

    public String getOperationName()
    {
        return operationName;
    }

    public long getOperationStartTime()
    {
        return operationStartTime;
    }

    public Long getParseDuration()
    {
        return parseDuration;
    }

    public long getRequestDuration()
    {
        return requestDuration;
    }

    public long getResponseDuration()
    {
        return responseDuration;
    }

    public transient String getResponseHeader(String as[])
    {
        if (responseHeaders != null) goto _L2; else goto _L1
_L1:
        String s = null;
_L4:
        return s;
_L2:
        int i;
        int j;
        s = null;
        j = as.length;
        i = 0;
_L6:
        if (i >= j) goto _L4; else goto _L3
_L3:
        String s1;
        s = as[i];
        s1 = (String)responseHeaders.get(s.toLowerCase(Locale.US));
        s = s1;
        if (!TextUtils.isEmpty(s1)) goto _L4; else goto _L5
_L5:
        i++;
        s = s1;
          goto _L6
    }

    public Map getResponseHeaders()
    {
        return responseHeaders;
    }

    public String getRlogId()
    {
        return getResponseHeader(new String[] {
            "x-ebay-soa-rlogid", "rlogid", "x-ebay-api-cal-tranaction-id"
        });
    }

    public String getServiceName()
    {
        return serviceName;
    }

    public long getTotalDuration()
    {
        return requestDuration + responseDuration;
    }

    public void ignore()
    {
        ignore = true;
    }

    public boolean isIgnore()
    {
        return ignore;
    }

    public void setBytesSent(String s)
    {
        bytesSent = s;
    }

    public void setOperationStartTime(long l)
    {
        operationStartTime = l;
    }

    public void setResponseHeaders(Map map)
    {
        responseHeaders = createHeaderMap(map);
    }

    public void startParseTimer()
    {
        parseStart = SystemClock.elapsedRealtime();
    }

    public void stopParseTimer()
    {
        if (parseStart > 0L)
        {
            parseDuration = Long.valueOf(SystemClock.elapsedRealtime() - parseStart);
            parseStart = 0L;
        }
    }

    public long stopRequestTimer()
    {
        requestDuration = SystemClock.elapsedRealtime() - start;
        startTimer();
        return requestDuration;
    }

    public long stopResponseTimer()
    {
        responseDuration = SystemClock.elapsedRealtime() - start;
        startTimer();
        return responseDuration;
    }
}

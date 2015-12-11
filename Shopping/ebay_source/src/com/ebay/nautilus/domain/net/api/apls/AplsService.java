// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.apls;

import android.text.TextUtils;
import com.ebay.nautilus.kernel.net.AsBeacon;
import com.ebay.nautilus.kernel.net.LogTrackPerf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.ebay.nautilus.domain.net.api.apls:
//            AplsFormatHelper

public final class AplsService
{
    public static final class Operation
    {

        public final List calls = new ArrayList();
        public final String name;

        public void addPerf(long l, LogTrackPerf logtrackperf)
        {
            logtrackperf = new Call(l, logtrackperf);
            calls.add(logtrackperf);
        }

        public Operation(String s)
        {
            name = s;
        }
    }

    public static final class Operation.Call
    {

        public final Integer beaconId;
        public final String bytesRcvd;
        public final String bytesSent;
        public final Long parseDuration;
        private final long perf;
        public final String rlogId;
        private final long start;

        public String getPerf()
        {
            return AplsFormatHelper.perfIntervalFormat(perf);
        }

        public String getStart()
        {
            return AplsFormatHelper.perfIntervalFormat(start);
        }

        public Operation.Call(long l, LogTrackPerf logtrackperf)
        {
            Object obj = logtrackperf.getBeacon();
            start = AplsService.relativeStart(l, logtrackperf.getOperationStartTime());
            perf = logtrackperf.getTotalDuration();
            if (obj != null)
            {
                obj = Integer.valueOf(((AsBeacon) (obj)).id);
            } else
            {
                obj = null;
            }
            beaconId = ((Integer) (obj));
            bytesSent = logtrackperf.getBytesSent();
            bytesRcvd = logtrackperf.getResponseHeader(new String[] {
                "Content-Length"
            });
            parseDuration = logtrackperf.getParseDuration();
            rlogId = logtrackperf.getRlogId();
        }
    }


    public final String name;
    protected final Map operations = new HashMap();

    public AplsService(String s)
    {
        name = s;
    }

    protected static long relativeStart(long l, long l1)
    {
        return Math.max(0L, l1 - l);
    }

    public void addPerf(long l, LogTrackPerf logtrackperf)
    {
        String s = logtrackperf.getOperationName();
        Object obj = logtrackperf.getServiceName();
        if (!TextUtils.equals(name, ((CharSequence) (obj))))
        {
            throw new IllegalArgumentException("The performance data service name does not match this service name");
        }
        Operation operation = (Operation)operations.get(s);
        obj = operation;
        if (operation == null)
        {
            obj = new Operation(s);
            operations.put(s, obj);
        }
        ((Operation) (obj)).addPerf(l, logtrackperf);
    }

    public Collection getOperations()
    {
        return operations.values();
    }
}

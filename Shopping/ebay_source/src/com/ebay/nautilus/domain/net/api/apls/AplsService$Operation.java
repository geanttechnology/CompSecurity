// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.apls;

import com.ebay.nautilus.kernel.net.AsBeacon;
import com.ebay.nautilus.kernel.net.LogTrackPerf;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.net.api.apls:
//            AplsService, AplsFormatHelper

public static final class name
{
    public static final class Call
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

        public Call(long l, LogTrackPerf logtrackperf)
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


    public final List calls = new ArrayList();
    public final String name;

    public void addPerf(long l, LogTrackPerf logtrackperf)
    {
        logtrackperf = new Call(l, logtrackperf);
        calls.add(logtrackperf);
    }

    public Call.rlogId(String s)
    {
        name = s;
    }
}

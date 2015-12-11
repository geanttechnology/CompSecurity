// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.TrafficStats;
import android.os.SystemClock;
import android.util.EventLog;
import java.io.FilterInputStream;
import java.io.InputStream;

final class ana extends FilterInputStream
{

    private amz a;

    public ana(amz amz1, InputStream inputstream)
    {
        a = amz1;
        super(inputstream);
    }

    public final void close()
    {
        super.close();
        long l = SystemClock.elapsedRealtime();
        long l2 = amz.a(a);
        long l4 = TrafficStats.getUidTxBytes(amz.b(a));
        long l6 = TrafficStats.getUidRxBytes(amz.b(a));
        EventLog.writeEvent(52001, new Object[] {
            amz.c(a), Long.valueOf(amz.d(a)), Long.valueOf(l - l2), Long.valueOf(l4 - amz.e(a)), Long.valueOf(l6 - amz.f(a))
        });
        return;
        Exception exception;
        exception;
        long l1 = SystemClock.elapsedRealtime();
        long l3 = amz.a(a);
        long l5 = TrafficStats.getUidTxBytes(amz.b(a));
        long l7 = TrafficStats.getUidRxBytes(amz.b(a));
        EventLog.writeEvent(52001, new Object[] {
            amz.c(a), Long.valueOf(amz.d(a)), Long.valueOf(l1 - l3), Long.valueOf(l5 - amz.e(a)), Long.valueOf(l7 - amz.f(a))
        });
        throw exception;
    }
}

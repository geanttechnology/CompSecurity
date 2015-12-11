// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.api.v1;

import com.newrelic.agent.android.api.common.ConnectionState;
import com.newrelic.agent.android.api.common.MachineMeasurements;
import com.newrelic.agent.android.instrumentation.Location;
import com.newrelic.agent.android.transport.TransportException;
import java.io.InterruptedIOException;
import java.util.Collection;

// Referenced classes of package com.newrelic.agent.android.api.v1:
//            DeviceInfo

public interface NewRelicApi
{

    public abstract DeviceInfo getDeviceInfo();

    public abstract void reset();

    public abstract void sendConnect()
        throws InterruptedIOException, TransportException;

    public abstract void sendData(double d, Collection collection, Collection collection1, MachineMeasurements machinemeasurements)
        throws InterruptedIOException, TransportException;

    public abstract void sendData(double d, Collection collection, Collection collection1, MachineMeasurements machinemeasurements, double d1)
        throws InterruptedIOException, TransportException;

    public abstract void setConnectionState(ConnectionState connectionstate);

    public abstract void setLocation(Location location);
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.devicetodevice;

import amazon.communication.Message;
import amazon.communication.MissingCredentialsException;
import amazon.communication.ResponseHandler;
import amazon.communication.connection.Connection;
import amazon.communication.connection.IllegalConnectionStateException;
import amazon.communication.connection.TransmissionFailedException;
import amazon.communication.devicetodevice.WakeupConnection;
import amazon.communication.identity.DeviceIdentity;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.dp.logger.DPLogger;
import org.apache.http.client.methods.HttpRequestBase;

// Referenced classes of package com.amazon.communication.devicetodevice:
//            D2DMessage, D2DApplicationProtocol

public class WakeupConnectionImpl
    implements WakeupConnection
{

    private static final DPLogger log = new DPLogger("TComm.WakeupConnectionImpl");
    private final Connection mConnection;
    private final D2DApplicationProtocol mD2DProtocol;
    private final String mSourceApplication;
    private final DeviceIdentity mTargetDevice;

    public WakeupConnectionImpl(Connection connection, D2DApplicationProtocol d2dapplicationprotocol, DeviceIdentity deviceidentity, String s)
    {
        mConnection = connection;
        mD2DProtocol = d2dapplicationprotocol;
        mTargetDevice = deviceidentity;
        mSourceApplication = s;
    }

    public void addConnectionListener(amazon.communication.connection.Connection.ConnectionListener connectionlistener)
    {
        mConnection.addConnectionListener(connectionlistener);
    }

    public int getConnectionState()
    {
        return mConnection.getConnectionState();
    }

    public void release()
    {
        mConnection.release();
    }

    public void removeConnectionListener(amazon.communication.connection.Connection.ConnectionListener connectionlistener)
    {
        mConnection.removeConnectionListener(connectionlistener);
    }

    public void sendMessage(Message message, int i, MetricEvent metricevent)
        throws TransmissionFailedException, IllegalConnectionStateException, MissingCredentialsException
    {
        mConnection.sendMessage(message, i, metricevent);
    }

    public void sendMessageWithWakeup(Message message, int i, MetricEvent metricevent, String s)
        throws TransmissionFailedException, IllegalConnectionStateException, MissingCredentialsException
    {
        D2DMessage d2dmessage = new D2DMessage();
        d2dmessage.destination = mTargetDevice;
        d2dmessage.destinationApp = s;
        d2dmessage.originApp = mSourceApplication;
        d2dmessage.messageType = "DMC";
        d2dmessage.message = message;
        d2dmessage.channel = i;
        message = mD2DProtocol.encode(d2dmessage);
        mConnection.sendMessage(message, 60100, metricevent);
    }

    public void sendRequest(HttpRequestBase httprequestbase, ResponseHandler responsehandler, MetricEvent metricevent)
    {
        throw new UnsupportedOperationException("sendRequest not supported on D2D connections");
    }

}

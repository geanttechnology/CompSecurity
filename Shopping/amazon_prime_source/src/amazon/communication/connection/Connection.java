// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication.connection;

import amazon.communication.Message;
import amazon.communication.MissingCredentialsException;
import amazon.communication.ResponseHandler;
import com.amazon.client.metrics.MetricEvent;
import org.apache.http.client.methods.HttpRequestBase;

// Referenced classes of package amazon.communication.connection:
//            TransmissionFailedException, IllegalConnectionStateException, ConnectionClosedDetails

public interface Connection
{
    public static interface ConnectionListener
    {

        public abstract void onClosed(Connection connection, ConnectionClosedDetails connectioncloseddetails);

        public abstract void onOpened(Connection connection);
    }


    public abstract void addConnectionListener(ConnectionListener connectionlistener);

    public abstract int getConnectionState();

    public abstract void release();

    public abstract void removeConnectionListener(ConnectionListener connectionlistener);

    public abstract void sendMessage(Message message, int i, MetricEvent metricevent)
        throws TransmissionFailedException, IllegalConnectionStateException, MissingCredentialsException;

    public abstract void sendRequest(HttpRequestBase httprequestbase, ResponseHandler responsehandler, MetricEvent metricevent)
        throws TransmissionFailedException, IllegalConnectionStateException, MissingCredentialsException;
}

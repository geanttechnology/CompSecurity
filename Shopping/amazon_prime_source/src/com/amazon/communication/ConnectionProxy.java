// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import amazon.communication.Message;
import amazon.communication.MissingCredentialsException;
import amazon.communication.ResponseHandler;
import amazon.communication.connection.Connection;
import amazon.communication.connection.ConnectionClosedDetails;
import amazon.communication.connection.IllegalConnectionStateException;
import amazon.communication.connection.TransmissionFailedException;
import amazon.communication.rlm.ReliableConnection;
import android.os.RemoteException;
import com.amazon.client.metrics.DataPointEnvelope;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.client.metrics.MetricsException;
import com.amazon.communication.connection.ClosedConnectionReasonFactory;
import com.amazon.dp.logger.DPLogger;
import com.dp.utils.FailFast;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.params.HttpConnectionParams;

// Referenced classes of package com.amazon.communication:
//            IConnection, MessageEnvelope, ErrorCodeWithDataPointsEnvelope, ErrorCodeWithDataPoints, 
//            PlainTextHttpRequestResponseConverter, ResponseHandlerProxy

public class ConnectionProxy extends IConnectionListener.Stub
    implements Connection, ReliableConnection
{

    private static final DPLogger log = new DPLogger("TComm.ConnectionProxy");
    private IConnection mConnection;
    private Object mConnectionLock;
    private final boolean mIsRequestResponseOnly;
    private final Set mListeners = Collections.synchronizedSet(new HashSet(2));
    private int mState;
    private Object mStateLock;

    public ConnectionProxy(boolean flag)
    {
        mState = 0;
        mStateLock = new Object();
        mConnectionLock = new Object();
        log.verbose("constructor", "Creating new connection proxy", new Object[] {
            "requestResponseOnly", Boolean.valueOf(flag)
        });
        mIsRequestResponseOnly = flag;
        mConnection = null;
    }

    public static void addHeadersFromParams(HttpRequestBase httprequestbase)
    {
        org.apache.http.params.HttpParams httpparams = httprequestbase.getParams();
        if (httpparams != null)
        {
            httprequestbase.addHeader("x-amz-connection-timeout-ms", Integer.toString(HttpConnectionParams.getConnectionTimeout(httpparams)));
            httprequestbase.addHeader("x-amz-socket-timeout-ms", Integer.toString(HttpConnectionParams.getSoTimeout(httpparams)));
        }
    }

    private boolean isValidState(int i)
    {
        return i >= 0 && i <= 4;
    }

    private void notifyStateClosed(int i, String s)
    {
        log.debug("notifyStateClosed", "connection closed", new Object[] {
            "statusCode", Integer.valueOf(i), "closeReason", ClosedConnectionReasonFactory.getReasonForStatusCode(i), "message", s
        });
        Set set = mListeners;
        set;
        JVM INSTR monitorenter ;
        for (Iterator iterator = mListeners.iterator(); iterator.hasNext(); ((amazon.communication.connection.Connection.ConnectionListener)iterator.next()).onClosed(this, new ConnectionClosedDetails(i, s))) { }
        break MISSING_BLOCK_LABEL_109;
        s;
        set;
        JVM INSTR monitorexit ;
        throw s;
        set;
        JVM INSTR monitorexit ;
    }

    private void notifyStateOpened()
    {
        Set set = mListeners;
        set;
        JVM INSTR monitorenter ;
        for (Iterator iterator = mListeners.iterator(); iterator.hasNext(); ((amazon.communication.connection.Connection.ConnectionListener)iterator.next()).onOpened(this)) { }
        break MISSING_BLOCK_LABEL_49;
        Exception exception;
        exception;
        set;
        JVM INSTR monitorexit ;
        throw exception;
        set;
        JVM INSTR monitorexit ;
    }

    public void addConnectionListener(amazon.communication.connection.Connection.ConnectionListener connectionlistener)
    {
        log.verbose("addConnectionListener", "Adding connection listener", new Object[] {
            "listener", connectionlistener
        });
        if (connectionlistener == null)
        {
            throw new IllegalArgumentException("Connection listener cannot be null");
        } else
        {
            mListeners.add(connectionlistener);
            return;
        }
    }

    public int getConnectionState()
    {
        return mState;
    }

    public void onConnectionSetInitialState(int i)
        throws RemoteException
    {
        log.verbose("onConnectionSetInitialState", "Setting initial connection state", new Object[] {
            "state", Integer.valueOf(i)
        });
        FailFast.expectTrue(isValidState(i));
        synchronized (mStateLock)
        {
            mState = i;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        catch (RuntimeException runtimeexception)
        {
            log.warn("onConnectionSetInitialState", "Exception occurred!", new Object[] {
                runtimeexception
            });
            throw runtimeexception;
        }
    }

    public void onConnectionStateChanged(int i, int j, String s)
        throws RemoteException
    {
        log.verbose("onConnectionStateChanged", "Connection state changed", new Object[] {
            "state", Integer.valueOf(i), "statusCode", Integer.valueOf(j), "message", s
        });
        FailFast.expectTrue(isValidState(i));
        int k;
        synchronized (mStateLock)
        {
            k = mState;
            mState = i;
        }
        if (k == 4 || i != 4) goto _L2; else goto _L1
_L1:
        notifyStateClosed(j, s);
_L4:
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw s;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log.warn("onConnectionStateChanged", "Exception occurred!", new Object[] {
                s
            });
        }
        throw s;
_L2:
        if (k == 2 || i != 2) goto _L4; else goto _L3
_L3:
        notifyStateOpened();
        return;
    }

    public void release()
    {
        log.verbose("release", "Releasing connectionProxy", new Object[0]);
        if (mConnection == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        synchronized (mStateLock)
        {
            mState = 0;
        }
        synchronized (mConnectionLock)
        {
            mConnection.release();
        }
        mConnection = null;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        obj;
        log.warn("release", "Error releasing connection, service unavailable", new Object[] {
            obj
        });
        mConnection = null;
        return;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        Object obj1;
        obj1;
        log.warn("release", "Error releasing connection, service unavailable", new Object[] {
            obj1
        });
        mConnection = null;
        return;
        obj1;
        mConnection = null;
        throw obj1;
    }

    public void removeConnectionListener(amazon.communication.connection.Connection.ConnectionListener connectionlistener)
    {
label0:
        {
            log.verbose("removeConnectionListener", "Removing connection listener", new Object[] {
                "listener", connectionlistener
            });
            if (connectionlistener == null)
            {
                throw new IllegalArgumentException("Connection listener cannot be null");
            }
            synchronized (mListeners)
            {
                if (!mListeners.contains(connectionlistener))
                {
                    break label0;
                }
                mListeners.remove(connectionlistener);
            }
            return;
        }
        throw new IllegalArgumentException("Connection listener isn't registered to connection");
        connectionlistener;
        set;
        JVM INSTR monitorexit ;
        throw connectionlistener;
    }

    public void sendMessage(Message message, int i, MetricEvent metricevent)
        throws IllegalConnectionStateException, TransmissionFailedException, MissingCredentialsException
    {
        log.verbose("sendMessage", "Sending message", new Object[] {
            "message", message, "channel", Integer.valueOf(i)
        });
        if (mIsRequestResponseOnly)
        {
            throw new UnsupportedOperationException("Cannot send a TComm message on a Request/Response only connection");
        }
        if (message == null || message.getPayloadSize() == 0)
        {
            throw new IllegalArgumentException("Message must not be null or empty");
        }
        if (metricevent == null)
        {
            throw new IllegalArgumentException("MetricEvent must not be null");
        }
        metricevent.startTimer("TimeSendMessage");
        Object obj = mStateLock;
        obj;
        JVM INSTR monitorenter ;
        if (mState != 2)
        {
            throw new IllegalConnectionStateException("Connection is not open", mState);
        }
        break MISSING_BLOCK_LABEL_164;
        message;
        obj;
        JVM INSTR monitorexit ;
        throw message;
        message;
        throw new TransmissionFailedException("Error while communicating with service", message);
        message;
        metricevent.stopTimer("TimeSendMessage");
        throw message;
        obj;
        JVM INSTR monitorexit ;
        synchronized (mConnectionLock)
        {
            message = MessageEnvelope.createInstance(message);
            message = mConnection.sendMessage(message, i);
        }
        message = message.toErrorCodeWithDataPoints();
        i = message.getCode();
        message = DataPointEnvelope.convertFromEnvelopes(message.getDataPoints());
        metricevent.addDataPoints(message);
        metricevent.addCounter("CountSendMessageDataPoints", message.size());
        if (i != 3003)
        {
            break MISSING_BLOCK_LABEL_287;
        }
        throw new MissingCredentialsException("No Amazon account on the device");
        message;
        throw new TransmissionFailedException("Error while communicating with service", message);
        message;
        obj1;
        JVM INSTR monitorexit ;
        throw message;
        message;
        throw new TransmissionFailedException("DataPoint(s) corrupted", message);
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_302;
        }
        throw new TransmissionFailedException("Sending message failed");
        metricevent.stopTimer("TimeSendMessage");
        return;
    }

    public void sendReliableMessage(Message message, int i, int j, MetricEvent metricevent)
        throws IllegalConnectionStateException, TransmissionFailedException, MissingCredentialsException
    {
        log.verbose("sendReliableMessage", "Sending Reliable message", new Object[] {
            "message", message, "channel", Integer.valueOf(i)
        });
        if (mIsRequestResponseOnly)
        {
            throw new UnsupportedOperationException("Cannot send a TComm message on a Request/Response only connection");
        }
        if (message == null || message.getPayloadSize() == 0)
        {
            throw new IllegalArgumentException("Message must not be null or empty");
        }
        if (metricevent == null)
        {
            throw new IllegalArgumentException("MetricEvent must not be null");
        }
        metricevent.startTimer("TimeSendReliableMessage");
        Object obj = mStateLock;
        obj;
        JVM INSTR monitorenter ;
        if (mState != 2)
        {
            throw new IllegalConnectionStateException("Connection is not open", mState);
        }
        break MISSING_BLOCK_LABEL_169;
        message;
        obj;
        JVM INSTR monitorexit ;
        throw message;
        message;
        throw new TransmissionFailedException("Error while communicating with service", message);
        message;
        metricevent.stopTimer("TimeSendReliableMessage");
        throw message;
        obj;
        JVM INSTR monitorexit ;
        synchronized (mConnectionLock)
        {
            message = MessageEnvelope.createInstance(message);
            message = mConnection.sendReliableMessage(message, j, i);
        }
        message = message.toErrorCodeWithDataPoints();
        i = message.getCode();
        message = DataPointEnvelope.convertFromEnvelopes(message.getDataPoints());
        metricevent.addDataPoints(message);
        metricevent.addCounter("CountSendMessageDataPoints", message.size());
        if (i != 3003)
        {
            break MISSING_BLOCK_LABEL_295;
        }
        throw new MissingCredentialsException("No Amazon account on device");
        message;
        throw new TransmissionFailedException("Error while communicating with service", message);
        message;
        obj1;
        JVM INSTR monitorexit ;
        throw message;
        message;
        throw new TransmissionFailedException("Datapoint(s) corrupted", message);
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_310;
        }
        throw new TransmissionFailedException("Sending reliable message failed");
        metricevent.stopTimer("TimeSendReliableMessage");
        return;
    }

    public void sendRequest(HttpRequestBase httprequestbase, ResponseHandler responsehandler, MetricEvent metricevent)
        throws IllegalConnectionStateException, TransmissionFailedException, MissingCredentialsException
    {
        log.verbose("sendRequest", "Sending request", new Object[] {
            "request", httprequestbase
        });
        if (httprequestbase == null)
        {
            throw new IllegalArgumentException("Request must not be null");
        }
        if (responsehandler == null)
        {
            throw new IllegalArgumentException("ResponseHandler must not be null");
        }
        if (metricevent == null)
        {
            throw new IllegalArgumentException("MetricEvent must not be null");
        }
        metricevent.startTimer("TimeSendRequest");
        Object obj = mStateLock;
        obj;
        JVM INSTR monitorenter ;
        if (mState != 2)
        {
            throw new IllegalConnectionStateException("Not connected", mState);
        }
        break MISSING_BLOCK_LABEL_163;
        httprequestbase;
        obj;
        JVM INSTR monitorexit ;
        throw httprequestbase;
        httprequestbase;
        log.verbose("sendRequest", "request sending failed", new Object[] {
            httprequestbase
        });
        throw new TransmissionFailedException("Error while communicating with service", httprequestbase);
        httprequestbase;
        metricevent.stopTimer("TimeSendRequest");
        throw httprequestbase;
        obj;
        JVM INSTR monitorexit ;
        addHeadersFromParams(httprequestbase);
        obj = MessageEnvelope.createInstance(PlainTextHttpRequestResponseConverter.getInstance().convertRequestToMessage(httprequestbase));
        synchronized (mConnectionLock)
        {
            responsehandler = mConnection.sendRequest(((MessageEnvelope) (obj)), new ResponseHandlerProxy(responsehandler, PlainTextHttpRequestResponseConverter.getInstance()));
        }
        int i;
        httprequestbase = responsehandler.toErrorCodeWithDataPoints();
        i = httprequestbase.getCode();
        httprequestbase = DataPointEnvelope.convertFromEnvelopes(httprequestbase.getDataPoints());
        metricevent.addDataPoints(httprequestbase);
        metricevent.addCounter("CountSendRequestDataPoints", httprequestbase.size());
        if (i != 3003)
        {
            break MISSING_BLOCK_LABEL_326;
        }
        throw new MissingCredentialsException("No Amazon account on the device.");
        httprequestbase;
        log.verbose("sendRequest", "request sending failed", new Object[] {
            httprequestbase
        });
        throw new TransmissionFailedException("Error while communicating with service", httprequestbase);
        responsehandler;
        httprequestbase;
        JVM INSTR monitorexit ;
        throw responsehandler;
        httprequestbase;
        throw new TransmissionFailedException("DataPoint(s) corrupted", httprequestbase);
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_342;
        }
        throw new TransmissionFailedException("Sending request failed");
        metricevent.stopTimer("TimeSendRequest");
        return;
    }

    public void setConnectionInterface(IConnection iconnection)
    {
        if (iconnection == null)
        {
            throw new IllegalArgumentException("connection must not be null.");
        }
        if (mConnection != null)
        {
            throw new IllegalStateException("Connection is already set");
        } else
        {
            mConnection = iconnection;
            return;
        }
    }

}

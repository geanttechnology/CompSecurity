// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication.srr;

import amazon.communication.ConnectionInterruptedException;
import amazon.communication.MissingCredentialsException;
import amazon.communication.RequestFailedException;
import amazon.communication.ResponseHandler;
import amazon.communication.connection.Connection;
import amazon.communication.connection.ConnectionClosedDetails;
import amazon.communication.connection.IllegalConnectionStateException;
import amazon.communication.connection.TransmissionFailedException;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.communication.ReleaseConnectionResponseHandler;
import com.amazon.communication.time.GlobalTimeSource;
import com.amazon.communication.time.TimeSource;
import com.amazon.dp.logger.DPFormattedMessage;
import com.amazon.dp.logger.DPLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

public class SrrConnectionListener
    implements amazon.communication.connection.Connection.ConnectionListener
{

    private static final DPLogger log = new DPLogger("TComm.SrrConnectionListener");
    private final long mCreationTime;
    private final MetricEvent mMetricEvent;
    private final AtomicBoolean mOnOpenedCalled = new AtomicBoolean(false);
    private final HttpRequestBase mRequest;
    private final ResponseHandler mResponseHandler;
    private final int mTimeoutInMillis;

    public SrrConnectionListener(HttpRequestBase httprequestbase, ResponseHandler responsehandler, int i, MetricEvent metricevent)
    {
        mCreationTime = GlobalTimeSource.INSTANCE.currentTimeMillis();
        mRequest = httprequestbase;
        mResponseHandler = responsehandler;
        mTimeoutInMillis = i;
        mMetricEvent = metricevent;
    }

    public void onClosed(Connection connection, ConnectionClosedDetails connectioncloseddetails)
    {
        Object obj;
        if (connection != null)
        {
            try
            {
                log.verbose("onClosed", "releasing connection", new Object[0]);
                connection.release();
            }
            // Misplaced declaration of an exception variable
            catch (Connection connection)
            {
                log.warn("onClosed", "unexpected exception while releasing connection", new Object[] {
                    connection
                });
            }
        }
        obj = null;
        connection = obj;
        if (connectioncloseddetails != null)
        {
            connection = obj;
            if (connectioncloseddetails.getDetailsCode() != 0)
            {
                connection = new ConnectionInterruptedException(connectioncloseddetails);
            }
        }
        if (connection != null || !mOnOpenedCalled.get())
        {
            if (connection != null)
            {
                connection = new RequestFailedException(connection);
            } else
            {
                connection = new RequestFailedException("Connection closed even before onOpened was called");
            }
            mResponseHandler.onError(mRequest, connection);
        }
    }

    public void onOpened(Connection connection)
    {
        log.verbose("onOpened", "connection opened; about to send request", new Object[] {
            "currentThread.getId", Long.valueOf(Thread.currentThread().getId())
        });
        if (!mOnOpenedCalled.compareAndSet(false, true))
        {
            log.verbose("onOpened", "seems like onOpened was already called for this instance; not firing a duplicate request", new Object[] {
                "currentThread.getId", Long.valueOf(Thread.currentThread().getId())
            });
            return;
        }
        int i = (int)(GlobalTimeSource.INSTANCE.currentTimeMillis() - mCreationTime);
        int j = mTimeoutInMillis - i;
        if (j < 1)
        {
            DPFormattedMessage dpformattedmessage = new DPFormattedMessage("onOpened", "no time left to make the actual request", new Object[] {
                "currentThread.getId", Long.valueOf(Thread.currentThread().getId()), "mCreationTime", Long.valueOf(mCreationTime), "connectionEstablishmentTime", Integer.valueOf(i), "mTimeoutInMillis", Integer.valueOf(mTimeoutInMillis)
            });
            log.verbose(dpformattedmessage);
            connection.release();
            mResponseHandler.onError(mRequest, new RequestFailedException(dpformattedmessage.toString()));
            return;
        }
        org.apache.http.params.HttpParams httpparams = mRequest.getParams();
        Object obj = httpparams;
        if (httpparams == null)
        {
            obj = new BasicHttpParams();
        }
        HttpConnectionParams.setConnectionTimeout(((org.apache.http.params.HttpParams) (obj)), j);
        HttpConnectionParams.setSoTimeout(((org.apache.http.params.HttpParams) (obj)), j);
        mRequest.setParams(((org.apache.http.params.HttpParams) (obj)));
        obj = new ReleaseConnectionResponseHandler(connection, mResponseHandler);
        try
        {
            connection.sendRequest(mRequest, ((ResponseHandler) (obj)), mMetricEvent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Connection connection)
        {
            log.verbose("onOpened", "exception", new Object[] {
                "currentThread.getId", Long.valueOf(Thread.currentThread().getId()), connection
            });
            mResponseHandler.onError(mRequest, new RequestFailedException("Illegal connection state when making http request", connection));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Connection connection)
        {
            log.verbose("onOpened", "exception", new Object[] {
                "currentThread.getId", Long.valueOf(Thread.currentThread().getId()), connection
            });
            mResponseHandler.onError(mRequest, new RequestFailedException("Cannot send data", connection));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Connection connection)
        {
            log.verbose("onOpened", "exception", new Object[] {
                "currentThread.getId", Long.valueOf(Thread.currentThread().getId()), connection
            });
        }
        mResponseHandler.onError(mRequest, new RequestFailedException("No Amazon account on the device", connection));
    }

}

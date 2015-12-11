// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication.srr;

import amazon.communication.CommunicationManager;
import amazon.communication.ConnectionAcquisitionFailedException;
import amazon.communication.MissingCredentialsException;
import amazon.communication.RequestFailedException;
import amazon.communication.ResponseHandler;
import amazon.communication.TimeoutException;
import amazon.communication.authentication.RequestContext;
import amazon.communication.connection.CompressionOption;
import amazon.communication.connection.Connection;
import amazon.communication.connection.ConnectionPolicyException;
import amazon.communication.connection.Policy;
import amazon.communication.identity.IRServiceEndpoint;
import amazon.communication.identity.IdentityResolver;
import amazon.communication.identity.ServiceIdentity;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.client.metrics.MetricsException;
import com.amazon.communication.BlockingResponseHandler;
import com.amazon.communication.utils.HttpResponseWithDataPoints;
import com.amazon.dp.logger.DPLogger;
import org.apache.http.HttpResponse;

// Referenced classes of package amazon.communication.srr:
//            SingleRequestResponseManager, SrrManager, SrrRequest, SrrConnectionListener

public class TCommSrrManager
    implements SingleRequestResponseManager, SrrManager
{

    private static final DPLogger log = new DPLogger("TComm.SrrManager");
    private CommunicationManager mCommunicationManager;
    private final Policy mPolicy;

    public TCommSrrManager(CommunicationManager communicationmanager, Policy policy)
    {
        if (communicationmanager == null)
        {
            throw new IllegalArgumentException("CommunicationManager cannot be null");
        }
        if (policy == null)
        {
            throw new IllegalArgumentException("Policy cannot be null");
        } else
        {
            mCommunicationManager = communicationmanager;
            mPolicy = policy;
            return;
        }
    }

    private int getTimeoutFromSrrRequest(SrrRequest srrrequest)
        throws ConnectionAcquisitionFailedException
    {
        int j = srrrequest.getTimeout();
        if (j < 0)
        {
            throw new IllegalArgumentException("Timeout must not be negative!");
        }
        srrrequest = srrrequest.getEndpointIdentity();
        if (!(srrrequest instanceof ServiceIdentity))
        {
            throw new IllegalArgumentException("Can only make SRR requests to service endpoints.");
        }
        int i = j;
        if (j == 0)
        {
            IdentityResolver identityresolver = mCommunicationManager.getIdentityResolver();
            if (identityresolver == null)
            {
                throw new ConnectionAcquisitionFailedException("Could not contact Identity Resolver");
            }
            srrrequest = identityresolver.resolveServiceEndpoint((ServiceIdentity)srrrequest);
            if (srrrequest == null)
            {
                throw new ConnectionAcquisitionFailedException("Could not find desired endpoint in Identity Resolver");
            }
            i = srrrequest.getTimeout();
        }
        return i;
    }

    private Policy overrideConnectionPolicy(SrrRequest srrrequest)
        throws IllegalAccessException, ConnectionPolicyException
    {
        Policy policy = mPolicy;
        Object obj = policy;
        if (!policy.getCompressionOption().equals(srrrequest.getCompressionOption()) || policy.isWiFiNecessary() != srrrequest.isWiFiNecessary() || srrrequest.getRequestContext() != null)
        {
            boolean flag = policy.isAnonymousCredentialsAllowed();
            if (srrrequest.getRequestContext() != null)
            {
                flag = isAnonymousCredentialsAllowed(srrrequest.getRequestContext());
            }
            obj = (new amazon.communication.connection.Policy.Builder()).setCompressionOption(srrrequest.getCompressionOption()).setPriority(policy.getPriority()).setIsLowLatencyNecessary(policy.isLowLatencyNecessary()).setIsRequestResponseOnly(policy.isRequestResponseOnly());
            boolean flag1;
            if (policy.isClearText() && srrrequest.isClearTextAllowed())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            obj = ((amazon.communication.connection.Policy.Builder) (obj)).setIsClearText(flag1).setIsWiFiNecessary(srrrequest.isWiFiNecessary()).setIsAnonymousCredentialsAllowed(flag).build();
        }
        return ((Policy) (obj));
    }

    protected boolean isAnonymousCredentialsAllowed(RequestContext requestcontext)
    {
        return false;
    }

    public void makeRequestAsync(SrrRequest srrrequest, ResponseHandler responsehandler)
        throws RequestFailedException, MissingCredentialsException
    {
        MetricEvent metricevent;
        amazon.communication.identity.EndpointIdentity endpointidentity;
        org.apache.http.client.methods.HttpRequestBase httprequestbase;
        int i;
        httprequestbase = srrrequest.getRequest();
        endpointidentity = srrrequest.getEndpointIdentity();
        metricevent = srrrequest.getMetricEvent();
        try
        {
            i = getTimeoutFromSrrRequest(srrrequest);
        }
        // Misplaced declaration of an exception variable
        catch (SrrRequest srrrequest)
        {
            log.verbose("makeRequestAsync", "exception", new Object[] {
                "currentThread.getId", Long.valueOf(Thread.currentThread().getId()), srrrequest
            });
            throw new RequestFailedException("Connection cannot be established.", srrrequest);
        }
        if (i < 0)
        {
            throw new IllegalArgumentException("Timeout value should be nonnegative integer");
        }
        if (responsehandler == null)
        {
            throw new IllegalArgumentException("ResponseHandler cannot be null");
        }
        log.verbose("makeRequestAsync", "acquire connection", new Object[] {
            "currentThread.getId", Long.valueOf(Thread.currentThread().getId())
        });
        responsehandler = new SrrConnectionListener(httprequestbase, responsehandler, i, metricevent);
        srrrequest = overrideConnectionPolicy(srrrequest);
        metricevent.startTimer("TimeAcquireConnection");
        srrrequest = mCommunicationManager.acquireConnection(endpointidentity, srrrequest, responsehandler);
        metricevent.stopTimer("TimeAcquireConnection");
        if (srrrequest == null)
        {
            break MISSING_BLOCK_LABEL_389;
        }
        if (srrrequest.getConnectionState() == 2)
        {
            responsehandler.onOpened(srrrequest);
            return;
        }
        break MISSING_BLOCK_LABEL_389;
        srrrequest;
        try
        {
            metricevent.stopTimer("TimeAcquireConnection");
            throw srrrequest;
        }
        // Misplaced declaration of an exception variable
        catch (SrrRequest srrrequest)
        {
            log.verbose("makeRequestAsync", "user exception", new Object[] {
                "currentThread.getId", Long.valueOf(Thread.currentThread().getId()), srrrequest
            });
            throw srrrequest;
        }
        // Misplaced declaration of an exception variable
        catch (SrrRequest srrrequest)
        {
            log.verbose("makeRequestAsync", "exception", new Object[] {
                "currentThread.getId", Long.valueOf(Thread.currentThread().getId()), srrrequest
            });
            throw new RequestFailedException("Connection cannot be established.", srrrequest);
        }
        // Misplaced declaration of an exception variable
        catch (SrrRequest srrrequest)
        {
            log.verbose("makeRequestAsync", "exception", new Object[] {
                "currentThread.getId", Long.valueOf(Thread.currentThread().getId()), srrrequest
            });
            throw new RequestFailedException(srrrequest);
        }
        // Misplaced declaration of an exception variable
        catch (SrrRequest srrrequest)
        {
            log.verbose("makeRequestAsync", "exception", new Object[] {
                "currentThread.getId", Long.valueOf(Thread.currentThread().getId()), srrrequest
            });
        }
        throw new RequestFailedException(srrrequest);
    }

    public HttpResponse makeRequestSync(SrrRequest srrrequest)
        throws TimeoutException, RequestFailedException, MissingCredentialsException
    {
        try
        {
            Object obj = new BlockingResponseHandler(getTimeoutFromSrrRequest(srrrequest));
            makeRequestAsync(srrrequest, ((ResponseHandler) (obj)));
            obj = ((BlockingResponseHandler) (obj)).waitForResponse();
            srrrequest.getMetricEvent().addDataPoints(((HttpResponseWithDataPoints) (obj)).getDataPoints());
            srrrequest = ((HttpResponseWithDataPoints) (obj)).getResponse();
        }
        // Misplaced declaration of an exception variable
        catch (SrrRequest srrrequest)
        {
            log.verbose("makeRequestSync", "user Exception", new Object[] {
                "currentThread.getId", Long.valueOf(Thread.currentThread().getId()), srrrequest
            });
            throw srrrequest;
        }
        // Misplaced declaration of an exception variable
        catch (SrrRequest srrrequest)
        {
            log.verbose("makeRequestSync", "exception", new Object[] {
                "currentThread.getId", Long.valueOf(Thread.currentThread().getId()), srrrequest
            });
            throw new RequestFailedException("Connection cannot be established.", srrrequest);
        }
        // Misplaced declaration of an exception variable
        catch (SrrRequest srrrequest)
        {
            log.verbose("makeRequestSync", "exception", new Object[] {
                "currentThread.getId", Long.valueOf(Thread.currentThread().getId()), srrrequest
            });
            throw new RequestFailedException("InterruptedException when making http request.", srrrequest);
        }
        // Misplaced declaration of an exception variable
        catch (SrrRequest srrrequest)
        {
            log.verbose("makeRequestSync", "exception", new Object[] {
                "currentThread.getId", Long.valueOf(Thread.currentThread().getId()), srrrequest
            });
            throw new RequestFailedException("DataPoints corrupted when making http request.", srrrequest);
        }
        return srrrequest;
    }

}

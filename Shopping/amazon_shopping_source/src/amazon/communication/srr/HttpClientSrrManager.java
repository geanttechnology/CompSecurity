// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication.srr;

import amazon.communication.MissingCredentialsException;
import amazon.communication.RequestFailedException;
import amazon.communication.TimeoutException;
import amazon.communication.authentication.RequestSigner;
import amazon.communication.authentication.SigningException;
import amazon.communication.connection.CompressionOption;
import amazon.communication.identity.EndpointIdentity;
import amazon.communication.identity.IRServiceEndpoint;
import amazon.communication.identity.IdentityResolver;
import amazon.communication.identity.ServiceIdentity;
import amazon.communication.identity.UrlEndpointIdentity;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.communication.HttpResponseDecompressor;
import com.amazon.communication.HttpResponseValidator;
import com.amazon.dp.logger.DPFormattedMessage;
import com.amazon.dp.logger.DPLogger;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.params.HttpConnectionParams;

// Referenced classes of package amazon.communication.srr:
//            SrrManager, SrrRequest

public class HttpClientSrrManager
    implements SrrManager
{

    private static final DPLogger log = new DPLogger("TComm.HttpClientSrrManager");
    private final HttpClient mHttpClient;
    private IdentityResolver mIdentityResolver;
    private final RequestSigner mRequestSigner;

    public HttpClientSrrManager(HttpClient httpclient, RequestSigner requestsigner)
    {
        if (httpclient == null)
        {
            throw new IllegalArgumentException("The HttpClient must not be null");
        }
        if (requestsigner == null)
        {
            throw new IllegalArgumentException("The RequestSigner must not be null");
        } else
        {
            mHttpClient = httpclient;
            mRequestSigner = requestsigner;
            return;
        }
    }

    public HttpResponse makeRequestSync(SrrRequest srrrequest)
        throws TimeoutException, RequestFailedException, MissingCredentialsException
    {
        HttpRequestBase httprequestbase;
        MetricEvent metricevent;
        EndpointIdentity endpointidentity;
        int i;
        if (srrrequest == null)
        {
            throw new IllegalArgumentException("The SrrRequest cannot be null");
        }
        metricevent = srrrequest.getMetricEvent();
        if (metricevent == null)
        {
            throw new IllegalArgumentException("The SrrRequest must have a MetricEvent");
        }
        int j = srrrequest.getTimeout();
        if (j < 0)
        {
            throw new IllegalArgumentException("The SrrRequest must have a non-negative timeout");
        }
        i = j;
        if (j == 0)
        {
            i = 10000;
        }
        validateConnectivityRequirements(srrrequest);
        endpointidentity = srrrequest.getEndpointIdentity();
        httprequestbase = null;
        if (!(endpointidentity instanceof UrlEndpointIdentity)) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = new URI(endpointidentity.toString());
        obj = new HttpHost(((URI) (obj)).getHost(), ((URI) (obj)).getPort(), ((URI) (obj)).getScheme());
_L4:
        if (obj == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("HttpClientSrrManager only supports UriEndpointIdentity, or ServiceIdentity if IdentityResolver is set. identity: ").append(EndpointIdentity.logSafe(endpointidentity)).toString());
        }
        break; /* Loop/switch isn't completed */
_L2:
        obj = httprequestbase;
        if (!(endpointidentity instanceof ServiceIdentity))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = httprequestbase;
        if (mIdentityResolver == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = mIdentityResolver.resolveServiceEndpoint((ServiceIdentity)endpointidentity);
        if (obj == null)
        {
            try
            {
                throw new IllegalArgumentException("irEndpoint is null");
            }
            // Misplaced declaration of an exception variable
            catch (SrrRequest srrrequest)
            {
                throw new IllegalArgumentException("Improperly formatted URL", srrrequest);
            }
        }
        if (srrrequest.isClearTextAllowed() && ((IRServiceEndpoint) (obj)).getClearTextConnection() == amazon.communication.identity.IRServiceEndpoint.ClearTextConnection.ALLOWED)
        {
            obj = new HttpHost(((IRServiceEndpoint) (obj)).getHostname(), ((IRServiceEndpoint) (obj)).getPort().intValue(), amazon.communication.identity.IRServiceEndpoint.Scheme.HTTP.toString());
            continue; /* Loop/switch isn't completed */
        }
        obj = new HttpHost(((IRServiceEndpoint) (obj)).getHostname(), ((IRServiceEndpoint) (obj)).getSecurePort().intValue(), amazon.communication.identity.IRServiceEndpoint.Scheme.HTTPS.toString());
        if (true) goto _L4; else goto _L3
_L3:
        boolean flag;
        httprequestbase = srrrequest.getRequest();
        flag = false;
        if (srrrequest.getCompressionOption() == CompressionOption.REQUIRED || srrrequest.getCompressionOption() == CompressionOption.ALLOWED)
        {
            httprequestbase.addHeader("Accept-Encoding", "gzip");
            flag = true;
        }
        metricevent.startTimer("TimeSignRequest");
        httprequestbase.setURI(URIUtils.rewriteURI(httprequestbase.getURI(), ((HttpHost) (obj))));
        mRequestSigner.signRequest(httprequestbase, srrrequest.getRequestContext());
        metricevent.stopTimer("TimeSignRequest");
        HttpConnectionParams.setConnectionTimeout(mHttpClient.getParams(), i);
        HttpConnectionParams.setSoTimeout(mHttpClient.getParams(), i);
        metricevent.startTimer("TimeHttpClientExecuteRequest");
        srrrequest = mHttpClient.execute(httprequestbase);
        metricevent.stopTimer("TimeHttpClientExecuteRequest");
        HttpResponseValidator.validateContentLength(srrrequest);
        if (!HttpResponseDecompressor.decompressResponseIfNecessary(srrrequest) || flag)
        {
            break MISSING_BLOCK_LABEL_477;
        }
        log.warn("makeRequestSync", "HttpResponse was compressed but request does not expect compression", new Object[0]);
        return srrrequest;
        srrrequest;
        DPFormattedMessage dpformattedmessage = new DPFormattedMessage("makeRequestSync", "Failed to parse the URI for the request.", new Object[] {
            "destination", EndpointIdentity.logSafe(endpointidentity), srrrequest
        });
        log.error(dpformattedmessage);
        throw new RequestFailedException(dpformattedmessage.toString(), srrrequest);
        srrrequest;
        metricevent.stopTimer("TimeSignRequest");
        throw srrrequest;
        srrrequest;
        DPFormattedMessage dpformattedmessage1 = new DPFormattedMessage("makeRequestSync", "Failed to sign request.", new Object[] {
            "destination", EndpointIdentity.logSafe(endpointidentity), srrrequest
        });
        log.error(dpformattedmessage1);
        throw new RequestFailedException(dpformattedmessage1.toString(), srrrequest);
        srrrequest;
        DPFormattedMessage dpformattedmessage4;
        try
        {
            metricevent.stopTimer("TimeHttpClientExecuteRequest");
            throw srrrequest;
        }
        // Misplaced declaration of an exception variable
        catch (SrrRequest srrrequest)
        {
            DPFormattedMessage dpformattedmessage2 = new DPFormattedMessage("makeRequestSync", "Timed out connecting for the request.", new Object[] {
                "destination", EndpointIdentity.logSafe(endpointidentity), srrrequest
            });
            log.error(dpformattedmessage2);
            throw new TimeoutException(dpformattedmessage2.toString(), srrrequest);
        }
        // Misplaced declaration of an exception variable
        catch (SrrRequest srrrequest)
        {
            DPFormattedMessage dpformattedmessage3 = new DPFormattedMessage("makeRequestSync", "Timed out making the request.", new Object[] {
                "destination", EndpointIdentity.logSafe(endpointidentity), srrrequest
            });
            log.error(dpformattedmessage3);
            throw new TimeoutException(dpformattedmessage3.toString(), srrrequest);
        }
        // Misplaced declaration of an exception variable
        catch (SrrRequest srrrequest)
        {
            dpformattedmessage4 = new DPFormattedMessage("makeRequestSync", "Failed to execute the request.", new Object[] {
                "destination", EndpointIdentity.logSafe(endpointidentity), srrrequest
            });
        }
        log.error(dpformattedmessage4);
        throw new RequestFailedException(dpformattedmessage4.toString(), srrrequest);
    }

    protected void validateConnectivityRequirements(SrrRequest srrrequest)
        throws RequestFailedException
    {
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import android.text.TextUtils;
import android.util.Log;
import com.ebay.nautilus.kernel.content.EbayAppInfo;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.io.DirectByteArrayInputStream;
import com.ebay.nautilus.kernel.util.ExceptionUtil;
import com.ebay.nautilus.kernel.util.NetworkUtil;
import com.ebay.nautilus.kernel.util.StreamUtil;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;

// Referenced classes of package com.ebay.nautilus.kernel.net:
//            Request, Response, IoError, HttpClientImpl, 
//            RequestLoggerFactory, LogTrackError, IHeaders, NetworkLog, 
//            LogTrackManager, IResponseDataHandler, LogTrackPerf, IRequestLogger, 
//            IResponseHeaderHandler, HttpError, HttpUrlConnectionHelper

public interface Connector
{
    public static class BuildRequestDataException extends ClientErrorException
    {

        private static final long serialVersionUID = 1L;

        public static BuildRequestDataException create(Throwable throwable)
        {
            String s = throwable.getLocalizedMessage();
            if (TextUtils.isEmpty(s))
            {
                return new BuildRequestDataException(throwable);
            } else
            {
                return new BuildRequestDataException(s, throwable);
            }
        }

        public BuildRequestDataException()
        {
        }

        public BuildRequestDataException(String s)
        {
            super(s);
        }

        public BuildRequestDataException(String s, Throwable throwable)
        {
            super(s);
            initCause(throwable);
        }

        public BuildRequestDataException(Throwable throwable)
        {
            initCause(throwable);
        }
    }

    public static class ClientErrorException extends IOException
    {

        private static final long serialVersionUID = 1L;

        public static boolean isClientError(ResultStatus resultstatus)
        {
            if (resultstatus != null) goto _L2; else goto _L1
_L1:
            return false;
_L2:
            if ((resultstatus = resultstatus.getMessages()) == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            resultstatus = resultstatus.iterator();
            com.ebay.nautilus.kernel.content.ResultStatus.Message message;
            do
            {
                if (!resultstatus.hasNext())
                {
                    continue; /* Loop/switch isn't completed */
                }
                message = (com.ebay.nautilus.kernel.content.ResultStatus.Message)resultstatus.next();
            } while (!(message instanceof IoError) || !(((IoError)message).getException() instanceof ClientErrorException));
            break; /* Loop/switch isn't completed */
            if (true) goto _L1; else goto _L3
_L3:
            return true;
        }

        public ClientErrorException()
        {
        }

        public ClientErrorException(String s)
        {
            super(s);
        }
    }

    public static class HostErrorException extends IOException
    {

        private static final long serialVersionUID = 1L;
        private final int responseCode;

        public final int getResponseCode()
        {
            return responseCode;
        }

        public HostErrorException(int i, String s)
        {
            super(s);
            responseCode = i;
        }
    }

    public static class Impl
        implements Connector
    {

        protected final EbayContext ebayContext;

        private static RequestController createController(EbayContext ebaycontext, Request request)
        {
            if (NetworkUtil.useHttpClient())
            {
                return new RequestControllerHttpClient(ebaycontext, request);
            } else
            {
                return new RequestControllerHttpUrlConnection(ebaycontext, request);
            }
        }

        public Response sendRequest(Request request)
            throws InterruptedException
        {
            Object obj = createController(ebayContext, request);
            Response response;
            try
            {
                ((RequestController) (obj)).sendRequest(ebayContext);
                response = ((RequestController) (obj)).getResponse();
                if (response.hasFailureValidation())
                {
                    request.validateFailure(ebayContext, response);
                }
            }
            // Misplaced declaration of an exception variable
            catch (Request request)
            {
                obj = ((RequestController) (obj)).getResponse();
                ((Response) (obj)).addResultMessage(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                    new IoError(request)
                });
                return ((Response) (obj));
            }
            return response;
        }

        public Impl(EbayContext ebaycontext)
        {
            ebayContext = ebaycontext;
        }
    }

    private static class Impl.HttpRequestFactory
    {

        private static final HashMap entityEnclosingRequestBase;
        private static final HashMap requestBase;

        public static HttpEntityEnclosingRequestBase createEntityEnclosingRequest(String s, String s1)
            throws ProtocolException
        {
            Object obj = s1;
            s1 = ((String) (obj));
            if (TextUtils.isEmpty(((CharSequence) (obj))))
            {
                s1 = "POST";
            }
            obj = (HttpRequestTypeFactory)entityEnclosingRequestBase.get(s1.toUpperCase(Locale.US));
            if (obj == null)
            {
                throw new ProtocolException((new StringBuilder()).append("The request body is only supported by POST and PUT. Here a body was included for ").append(s1).toString());
            } else
            {
                return (HttpEntityEnclosingRequestBase)((HttpRequestTypeFactory) (obj)).create(s);
            }
        }

        public static HttpRequestBase createRequest(String s, String s1)
            throws ProtocolException
        {
            Object obj = s1;
            s1 = ((String) (obj));
            if (TextUtils.isEmpty(((CharSequence) (obj))))
            {
                s1 = "GET";
            }
            obj = (HttpRequestTypeFactory)requestBase.get(s1.toUpperCase(Locale.US));
            if (obj == null)
            {
                throw new ProtocolException((new StringBuilder()).append("Unexpected http method: ").append(s1).toString());
            } else
            {
                return ((HttpRequestTypeFactory) (obj)).create(s);
            }
        }

        static 
        {
            requestBase = new HashMap();
            entityEnclosingRequestBase = new HashMap();
            HttpRequestTypeFactory httprequesttypefactory = new Impl.HttpRequestFactory.HttpRequestTypeFactory() {

                public HttpGet create(String s)
                {
                    return new HttpGet(s);
                }

                public volatile HttpRequestBase create(String s)
                {
                    return create(s);
                }

            };
            HttpRequestTypeFactory httprequesttypefactory1 = new Impl.HttpRequestFactory.HttpRequestTypeFactory() {

                public HttpHead create(String s)
                {
                    return new HttpHead(s);
                }

                public volatile HttpRequestBase create(String s)
                {
                    return create(s);
                }

            };
            HttpRequestTypeFactory httprequesttypefactory2 = new Impl.HttpRequestFactory.HttpRequestTypeFactory() {

                public HttpOptions create(String s)
                {
                    return new HttpOptions(s);
                }

                public volatile HttpRequestBase create(String s)
                {
                    return create(s);
                }

            };
            HttpRequestTypeFactory httprequesttypefactory3 = new Impl.HttpRequestFactory.HttpRequestTypeFactory() {

                public volatile HttpRequestBase create(String s)
                {
                    return create(s);
                }

                public HttpTrace create(String s)
                {
                    return new HttpTrace(s);
                }

            };
            HttpRequestTypeFactory httprequesttypefactory4 = new Impl.HttpRequestFactory.HttpRequestTypeFactory() {

                public HttpDelete create(String s)
                {
                    return new HttpDelete(s);
                }

                public volatile HttpRequestBase create(String s)
                {
                    return create(s);
                }

            };
            HttpRequestTypeFactory httprequesttypefactory5 = new Impl.HttpRequestFactory.HttpRequestTypeFactory() {

                public HttpPost create(String s)
                {
                    return new HttpPost(s);
                }

                public volatile HttpRequestBase create(String s)
                {
                    return create(s);
                }

            };
            HttpRequestTypeFactory httprequesttypefactory6 = new Impl.HttpRequestFactory.HttpRequestTypeFactory() {

                public HttpPut create(String s)
                {
                    return new HttpPut(s);
                }

                public volatile HttpRequestBase create(String s)
                {
                    return create(s);
                }

            };
            requestBase.put("GET", httprequesttypefactory);
            requestBase.put("HEAD", httprequesttypefactory1);
            requestBase.put("OPTIONS", httprequesttypefactory2);
            requestBase.put("TRACE", httprequesttypefactory3);
            requestBase.put("DELETE", httprequesttypefactory4);
            requestBase.put("POST", httprequesttypefactory5);
            requestBase.put("PUT", httprequesttypefactory6);
            entityEnclosingRequestBase.put("POST", httprequesttypefactory5);
            entityEnclosingRequestBase.put("PUT", httprequesttypefactory6);
        }

        private Impl.HttpRequestFactory()
        {
        }
    }

    private static interface Impl.HttpRequestFactory.HttpRequestTypeFactory
    {

        public abstract HttpRequestBase create(String s);
    }

    private static abstract class Impl.RequestController
    {

        protected final ParseResponseDataException checkForInterruptedIoException(ParseResponseDataException parseresponsedataexception)
            throws InterruptedIOException
        {
            for (Throwable throwable = parseresponsedataexception.getCause(); throwable != null; throwable = throwable.getCause())
            {
                if (throwable instanceof InterruptedIOException)
                {
                    throw (InterruptedIOException)throwable;
                }
            }

            return parseresponsedataexception;
        }

        public abstract Response getResponse();

        protected final boolean invalidDeviceClock()
        {
            return System.currentTimeMillis() <= 0x15025d92800L;
        }

        public abstract void sendRequest(EbayContext ebaycontext)
            throws IOException, InterruptedException;

        private Impl.RequestController()
        {
        }

    }

    private static final class Impl.RequestControllerHttpClient extends Impl.RequestController
    {

        private static final long RETRY_BACKOFF_MULTIPLIER = 200L;
        private static HttpClient ebayHttpClient = HttpClientImpl.newInstance();
        private static final int logPriority = 3;
        private boolean gzipCompressed;
        private HttpResponse httpResponse;
        private final String logTag;
        private int maxTries;
        private byte preCompressedRequestData[];
        private boolean receiveStarted;
        private final Request.Recoverable recoverable;
        private final Request request;
        private byte requestData[];
        private IHeaders requestHeaders;
        private final IRequestLogger requestLogger;
        private long requestTime;
        private Response response;
        private int responseCode;
        private String responseContentType;
        private IResponseDataHandler responseDataHandler;
        private String responseMessage;
        private InputStream responseStream;
        private long sleepUntil;
        private LogTrackPerf trackPerf;
        private int tryCount;

        private LogTrackError buildLogTrackError(LogTrackPerf logtrackperf, Exception exception)
        {
            String s = "Unknown";
            if (exception == null) goto _L2; else goto _L1
_L1:
            if (exception instanceof ClientErrorException)
            {
                s = "NonFatalException";
            } else
            {
                s = "NetworkError";
            }
_L4:
            logtrackperf = new LogTrackError(logtrackperf, request.getRequestUrl().toString(), request.getClass().getSimpleName(), com/ebay/nautilus/kernel/net/Connector.getSimpleName(), s, exception);
            logtrackperf.setHttpResponseInfo(responseCode, responseMessage, responseContentType);
            exception = requestHeaders.getFirstHeader("Content-Type");
            logtrackperf.getUserData().put("httpRequestContentType", exception);
            logtrackperf.setContent(requestHeaders.getAllHeaders(), null, null);
            if (response != null)
            {
                logtrackperf.setResultStatus(request.getEbayContext(), response.getResultStatus());
            }
            return logtrackperf;
_L2:
            if (!response.hasSuccessResponseCode())
            {
                s = "HTTPError";
            } else
            if (response.getResultStatus().hasError())
            {
                s = "APIError";
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        private void cleanUp()
        {
            if (httpResponse != null)
            {
                if (responseStream != null)
                {
                    StreamUtil.closeQuietly(responseStream);
                    responseStream = null;
                }
                HttpEntity httpentity = httpResponse.getEntity();
                if (httpentity != null)
                {
                    try
                    {
                        httpentity.consumeContent();
                    }
                    catch (IOException ioexception)
                    {
                        StreamUtil.logCloseQuietly("Ignoring IOException while closing response", ioexception);
                    }
                }
                httpResponse = null;
            }
        }

        private void complete(IOException ioexception, boolean flag)
        {
            if (flag)
            {
                finishTracking(ioexception);
            }
            cleanUp();
        }

        private byte[] compress(byte abyte0[])
        {
            byte abyte2[];
            ByteArrayOutputStream bytearrayoutputstream;
            bytearrayoutputstream = new ByteArrayOutputStream(8192);
            abyte2 = abyte0;
            GZIPOutputStream gzipoutputstream = new GZIPOutputStream(bytearrayoutputstream);
            byte abyte1[] = abyte2;
            gzipoutputstream.write(abyte0);
            abyte1 = abyte2;
            gzipoutputstream.close();
            abyte1 = abyte2;
            abyte2 = bytearrayoutputstream.toByteArray();
            abyte1 = abyte2;
            if (!NetworkLog.fwLogNetwork.isLoggable)
            {
                break MISSING_BLOCK_LABEL_99;
            }
            abyte1 = abyte2;
            NetworkLog.fwLogNetwork.log((new StringBuilder()).append("Gzip Compression: ").append(abyte0.length).append(" -> ").append(abyte2.length).toString());
            StreamUtil.closeQuietly(bytearrayoutputstream);
            return abyte2;
            abyte0;
            abyte1 = abyte2;
_L4:
            if (NetworkLog.fwLogNetwork.isLoggable)
            {
                NetworkLog.fwLogNetwork.log("Gzip Compression request failed, sending uncompressed data", abyte0);
            }
            StreamUtil.closeQuietly(bytearrayoutputstream);
            return abyte1;
            abyte0;
_L2:
            StreamUtil.closeQuietly(bytearrayoutputstream);
            throw abyte0;
            abyte0;
            if (true) goto _L2; else goto _L1
_L1:
            abyte0;
            if (true) goto _L4; else goto _L3
_L3:
        }

        private void finishTracking(IOException ioexception)
        {
            if (trackPerf == null)
            {
                return;
            }
            if ((ioexception != null || !response.hasSuccessResponseCode() || response.hasReportableResultStatusError()) && request.isErrorReportable())
            {
                LogTrackError logtrackerror = buildLogTrackError(trackPerf, ioexception);
                request.appendErrorData(logtrackerror, response, ioexception);
                LogTrackManager.addLogErrorData(logtrackerror);
            }
            if (request.isTrafficReportable())
            {
                LogTrackManager.addLogPerfData(trackPerf);
            }
            trackPerf = null;
        }

        private boolean isPreReadInputStream()
        {
            return logTag != null || NetworkLog.fwLogNetwork.isLoggable;
        }

        private void parse()
            throws ParseResponseDataException, InterruptedException, IOException
        {
            if (Thread.interrupted())
            {
                throw new InterruptedException();
            }
            if (responseDataHandler != null && responseStream != null)
            {
                responseDataHandler.parse(responseStream);
            }
            trackPerf.stopResponseTimer();
            return;
            Object obj;
            obj;
            throw checkForInterruptedIoException(((ParseResponseDataException) (obj)));
            obj;
            trackPerf.stopResponseTimer();
            throw obj;
        }

        private void prepare()
            throws BuildRequestDataException, InterruptedException
        {
            if (Thread.interrupted())
            {
                throw new InterruptedException();
            }
            byte abyte0[] = request.buildRequest();
            preCompressedRequestData = abyte0;
            requestData = abyte0;
            if (requestData != null && request.isGzipCompress())
            {
                requestData = compress(preCompressedRequestData);
                boolean flag;
                if (requestData != preCompressedRequestData)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                gzipCompressed = flag;
            }
            if (recoverable != null)
            {
                maxTries = maxTries + recoverable.getRetryCount();
            }
        }

        private void receive()
            throws IOException, InterruptedException
        {
            byte abyte0[];
label0:
            {
                if (Thread.interrupted())
                {
                    throw new InterruptedException();
                }
                Object obj = httpResponse.getStatusLine();
                responseCode = ((StatusLine) (obj)).getStatusCode();
                responseMessage = ((StatusLine) (obj)).getReasonPhrase();
                if (Thread.interrupted())
                {
                    throw new InterruptedException();
                }
                obj = httpResponse.getFirstHeader("Content-Type");
                if (obj != null)
                {
                    responseContentType = ((Header) (obj)).getValue();
                }
                trackPerf.setResponseHeaders(HttpClientImpl.getHeaders(httpResponse).getAllHeaders());
                receiveStarted = true;
                response.setResponseCode(responseCode, responseMessage);
                response.setRequestTime(requestTime);
                if (requestLogger != null && !response.hasSuccessResponseCode())
                {
                    requestLogger.logHostError(responseCode);
                }
                obj = response.getHeaderHandler();
                if (obj != null)
                {
                    ((IResponseHeaderHandler) (obj)).readHeaders(HttpClientImpl.getHeaders(httpResponse));
                }
                responseDataHandler = response.getDataHandler();
                if (responseDataHandler != null || NetworkLog.fwLogNetwork.isLoggable || logTag != null)
                {
                    abyte0 = httpResponse.getEntity();
                    if (abyte0 != null)
                    {
                        if (!isPreReadInputStream())
                        {
                            break label0;
                        }
                        abyte0 = EntityUtils.toByteArray(abyte0);
                        if (logTag != null)
                        {
                            NetworkLog.logContent(3, logTag, null, abyte0, HttpClientImpl.getHeaders(httpResponse));
                        }
                        if (NetworkLog.fwLogNetwork.isLoggable)
                        {
                            NetworkLog.logContent(abyte0, responseContentType);
                        }
                        if (abyte0 != null)
                        {
                            responseStream = new DirectByteArrayInputStream(abyte0);
                        }
                    }
                }
                return;
            }
            responseStream = new BufferedInputStream(abyte0.getContent(), 8192);
        }

        private void send()
            throws IOException, InterruptedException
        {
            if (Thread.interrupted())
            {
                throw new InterruptedException();
            }
            tryCount = tryCount + 1;
            HttpUriRequest httpurirequest = setupRequest(request, requestData);
            if (logTag != null)
            {
                NetworkLog.logContent(3, logTag, request.getRequestUrl(), preCompressedRequestData, requestHeaders);
            }
            httpResponse = trackedSend(ebayHttpClient, httpurirequest);
        }

        private void setCompleteResponse()
        {
            if (requestLogger != null)
            {
                requestLogger.setCompleteResponse(response);
            }
        }

        private HttpUriRequest setupRequest(Request request1, byte abyte0[])
            throws ProtocolException, IOException
        {
            Object obj = request1.getRequestUrl().toString();
            String s = request1.getUserAgent();
            String s1 = request1.getHttpMethod();
            int i;
            if (abyte0 != null)
            {
                obj = Impl.HttpRequestFactory.createEntityEnclosingRequest(((String) (obj)), s1);
                ((HttpEntityEnclosingRequestBase) (obj)).setEntity(new ByteArrayEntity(abyte0));
                abyte0 = ((byte []) (obj));
            } else
            {
                abyte0 = Impl.HttpRequestFactory.createRequest(((String) (obj)), s1);
            }
            abyte0.addHeader("Cache-Control", "no-cache");
            if (s != null)
            {
                abyte0.addHeader("User-Agent", s);
            }
            if (gzipCompressed)
            {
                abyte0.addHeader("Content-Encoding", "gzip");
            }
            requestHeaders = HttpClientImpl.getHeaders(abyte0);
            request1.onAddHeaders(requestHeaders);
            i = request1.getTimeout();
            if (i != 60000)
            {
                HttpConnectionParams.setSoTimeout(abyte0.getParams(), i);
            }
            return abyte0;
        }

        private boolean shouldRetry(IOException ioexception)
        {
            Response response1;
            if (receiveStarted)
            {
                response1 = response;
            } else
            {
                response1 = null;
            }
            if (tryCount < maxTries && recoverable != null && recoverable.hasRecoverableError(response1, ioexception))
            {
                recoverable.clearResponse();
                response = request.getResponse();
                sleepUntil = System.currentTimeMillis() + 200L * (long)tryCount;
                return true;
            } else
            {
                return false;
            }
        }

        private void sleep()
            throws InterruptedException
        {
            if (sleepUntil > 0L)
            {
                long l1 = sleepUntil - System.currentTimeMillis();
                if (l1 > 0L)
                {
                    long l = l1;
                    if (l1 > (long)maxTries * 200L)
                    {
                        l = 200L * (long)maxTries;
                    }
                    Thread.sleep(l);
                }
            }
        }

        private HttpResponse trackedSend(HttpClient httpclient, HttpUriRequest httpurirequest)
            throws IOException
        {
            LogTrackPerf logtrackperf;
            int i;
            requestTime = System.currentTimeMillis();
            if (requestLogger != null)
            {
                requestLogger.setRequestTime(requestTime);
            }
            trackPerf = new LogTrackPerf(request);
            logtrackperf = trackPerf;
            if (requestData == null)
            {
                break MISSING_BLOCK_LABEL_107;
            }
            i = requestData.length;
_L1:
            logtrackperf.setBytesSent(String.valueOf(i));
            httpclient = httpclient.execute(httpurirequest);
            if (requestLogger != null)
            {
                requestLogger.setResponseTime(System.currentTimeMillis());
            }
            trackPerf.stopRequestTimer();
            return httpclient;
            i = 0;
              goto _L1
            httpclient;
            trackPerf.stopRequestTimer();
            throw httpclient;
        }

        public Response getResponse()
        {
            return response;
        }

        public void sendRequest(EbayContext ebaycontext)
            throws IOException, InterruptedException
        {
            if (invalidDeviceClock())
            {
                throw new InvalidDeviceClockException();
            }
            request.setContext(ebaycontext);
            prepare();
_L4:
            boolean flag;
            request.initialize(response);
            flag = response.getResultStatus().hasError();
            if (!flag) goto _L2; else goto _L1
_L1:
            complete(null, false);
            request.setContext(null);
_L6:
            return;
_L2:
            ebaycontext = null;
            sleep();
            send();
            receive();
            parse();
_L5:
            complete(ebaycontext, true);
            if (shouldRetry(ebaycontext)) goto _L4; else goto _L3
_L3:
            if (ebaycontext == null)
            {
                break MISSING_BLOCK_LABEL_172;
            }
            throw ebaycontext;
            ebaycontext;
            complete(null, false);
            request.setContext(null);
            throw ebaycontext;
            IOException ioexception;
            ioexception;
            ebaycontext = ioexception;
            if (ExceptionUtil.isInterruptedException(ebaycontext))
            {
                throw ExceptionUtil.convertToInterruptedException(ebaycontext);
            }
            Log.w("Connector", (new StringBuilder()).append("").append(ioexception.getMessage()).toString(), ioexception);
              goto _L5
            setCompleteResponse();
            complete(null, false);
            request.setContext(null);
            if (!response.hasSuccessResponseCode())
            {
                ebaycontext = new HttpError(response.responseCode, response.responseMessage);
                List list = response.getResultStatus().getMessages();
                if (list != null)
                {
                    list.add(0, ebaycontext);
                    return;
                } else
                {
                    response.addResultMessage(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                        ebaycontext
                    });
                    return;
                }
            }
              goto _L6
        }


        public Impl.RequestControllerHttpClient(EbayContext ebaycontext, Request request1)
        {
            requestData = null;
            responseStream = null;
            responseDataHandler = null;
            httpResponse = null;
            requestTime = 0L;
            maxTries = 1;
            tryCount = 0;
            sleepUntil = 0L;
            requestLogger = RequestLoggerFactory.createLogger(request1);
            request = request1;
            response = request1.getResponse();
            Request.Recoverable recoverable1;
            if (request1 instanceof Request.Recoverable)
            {
                recoverable1 = (Request.Recoverable)request1;
            } else
            {
                recoverable1 = null;
            }
            recoverable = recoverable1;
            if (ebaycontext.getAppInfo().isDebuggable())
            {
                request1 = request1.getClass().getSimpleName();
                if (request1.endsWith("Request"))
                {
                    int j = request1.length() - 7;
                    int i = j;
                    if (j > 23)
                    {
                        i = 23;
                    }
                    ebaycontext = request1.substring(0, i);
                } else
                {
                    ebaycontext = request1;
                    if (request1.length() > 23)
                    {
                        ebaycontext = request1.substring(0, 23);
                    }
                }
                if (!Log.isLoggable(ebaycontext, 3))
                {
                    ebaycontext = null;
                }
                logTag = ebaycontext;
                return;
            } else
            {
                logTag = null;
                return;
            }
        }
    }

    private static final class Impl.RequestControllerHttpUrlConnection extends Impl.RequestController
    {

        private static final long RETRY_BACKOFF_MULTIPLIER = 200L;
        private static final int logPriority = 3;
        private boolean gzipCompressed;
        private HttpURLConnection httpUrlConnection;
        private final String logTag;
        private int maxTries;
        private byte preCompressedRequestData[];
        private boolean receiveStarted;
        private final Request.Recoverable recoverable;
        private final Request request;
        private byte requestData[];
        private Map requestHeaderMap;
        private IHeaders requestHeaders;
        private final IRequestLogger requestLogger;
        private long requestTime;
        private Response response;
        private int responseCode;
        private String responseContentType;
        private IResponseDataHandler responseDataHandler;
        private String responseMessage;
        private InputStream responseStream;
        private long sleepUntil;
        private LogTrackPerf trackPerf;
        private int tryCount;

        private LogTrackError buildLogTrackError(LogTrackPerf logtrackperf, Exception exception)
        {
            String s = "Unknown";
            if (exception == null) goto _L2; else goto _L1
_L1:
            if (exception instanceof ClientErrorException)
            {
                s = "NonFatalException";
            } else
            {
                s = "NetworkError";
            }
_L4:
            logtrackperf = new LogTrackError(logtrackperf, request.getRequestUrl().toString(), request.getClass().getSimpleName(), com/ebay/nautilus/kernel/net/Connector.getSimpleName(), s, exception);
            logtrackperf.setHttpResponseInfo(responseCode, responseMessage, responseContentType);
            exception = httpUrlConnection.getRequestProperty("Content-Type");
            logtrackperf.getUserData().put("httpRequestContentType", exception);
            logtrackperf.setContent(requestHeaderMap, null, null);
            if (response != null)
            {
                logtrackperf.setResultStatus(request.getEbayContext(), response.getResultStatus());
            }
            return logtrackperf;
_L2:
            if (!response.hasSuccessResponseCode())
            {
                s = "HTTPError";
            } else
            if (response.getResultStatus().hasError())
            {
                s = "APIError";
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        private void cleanUp()
        {
            if (httpUrlConnection != null)
            {
                if (responseStream != null)
                {
                    StreamUtil.closeQuietly(responseStream);
                    responseStream = null;
                }
                httpUrlConnection.disconnect();
                httpUrlConnection = null;
            }
        }

        private void complete(IOException ioexception, boolean flag)
        {
            if (flag)
            {
                finishTracking(ioexception);
            }
            cleanUp();
        }

        private byte[] compress(byte abyte0[])
        {
            byte abyte1[];
            byte abyte2[];
            ByteArrayOutputStream bytearrayoutputstream;
            bytearrayoutputstream = new ByteArrayOutputStream(8192);
            abyte2 = abyte0;
            abyte1 = abyte2;
            GZIPOutputStream gzipoutputstream = new GZIPOutputStream(bytearrayoutputstream);
            abyte1 = abyte2;
            gzipoutputstream.write(abyte0);
            abyte1 = abyte2;
            gzipoutputstream.close();
            abyte1 = abyte2;
            abyte2 = bytearrayoutputstream.toByteArray();
            abyte1 = abyte2;
            if (!NetworkLog.fwLogNetwork.isLoggable)
            {
                break MISSING_BLOCK_LABEL_101;
            }
            abyte1 = abyte2;
            NetworkLog.fwLogNetwork.log((new StringBuilder()).append("Gzip Compression: ").append(abyte0.length).append(" -> ").append(abyte2.length).toString());
            StreamUtil.closeQuietly(bytearrayoutputstream);
            return abyte2;
            abyte0;
            if (NetworkLog.fwLogNetwork.isLoggable)
            {
                NetworkLog.fwLogNetwork.log("Gzip Compression request failed, sending uncompressed data", abyte0);
            }
            StreamUtil.closeQuietly(bytearrayoutputstream);
            return abyte1;
            abyte0;
            StreamUtil.closeQuietly(bytearrayoutputstream);
            throw abyte0;
        }

        private void finishTracking(IOException ioexception)
        {
            if (trackPerf == null)
            {
                return;
            }
            if ((ioexception != null || !response.hasSuccessResponseCode() || response.hasReportableResultStatusError()) && request.isErrorReportable())
            {
                LogTrackError logtrackerror = buildLogTrackError(trackPerf, ioexception);
                request.appendErrorData(logtrackerror, response, ioexception);
                LogTrackManager.addLogErrorData(logtrackerror);
            }
            if (request.isTrafficReportable())
            {
                LogTrackManager.addLogPerfData(trackPerf);
            }
            trackPerf = null;
        }

        private boolean isPreReadInputStream()
        {
            return logTag != null || NetworkLog.fwLogNetwork.isLoggable;
        }

        private void parse()
            throws ParseResponseDataException, InterruptedException, IOException
        {
            if (Thread.interrupted())
            {
                throw new InterruptedException();
            }
            if (responseDataHandler != null && responseStream != null)
            {
                trackPerf.startParseTimer();
                responseDataHandler.parse(responseStream);
            }
            trackPerf.stopResponseTimer();
            trackPerf.stopParseTimer();
            return;
            Object obj;
            obj;
            throw checkForInterruptedIoException(((ParseResponseDataException) (obj)));
            obj;
            trackPerf.stopResponseTimer();
            trackPerf.stopParseTimer();
            throw obj;
        }

        private void prepare()
            throws BuildRequestDataException, InterruptedException
        {
            if (Thread.interrupted())
            {
                throw new InterruptedException();
            }
            byte abyte0[] = request.buildRequest();
            preCompressedRequestData = abyte0;
            requestData = abyte0;
            if (requestData != null && request.isGzipCompress())
            {
                requestData = compress(preCompressedRequestData);
                boolean flag;
                if (requestData != preCompressedRequestData)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                gzipCompressed = flag;
            }
            if (recoverable != null)
            {
                maxTries = maxTries + recoverable.getRetryCount();
            }
        }

        private void receive()
            throws IOException, InterruptedException
        {
            InputStream inputstream1;
label0:
            {
                if (Thread.interrupted())
                {
                    throw new InterruptedException();
                }
                HttpURLConnection httpurlconnection = httpUrlConnection;
                responseCode = httpurlconnection.getResponseCode();
                responseMessage = httpurlconnection.getResponseMessage();
                if (Thread.interrupted())
                {
                    throw new InterruptedException();
                }
                responseContentType = httpurlconnection.getContentType();
                trackPerf.setResponseHeaders(httpUrlConnection.getHeaderFields());
                receiveStarted = true;
                response.setResponseCode(responseCode, responseMessage);
                response.setRequestTime(requestTime);
                if (requestLogger != null && !response.hasSuccessResponseCode())
                {
                    requestLogger.logHostError(responseCode);
                }
                IResponseHeaderHandler iresponseheaderhandler = response.getHeaderHandler();
                if (iresponseheaderhandler != null)
                {
                    iresponseheaderhandler.readHeaders(HttpUrlConnectionHelper.getResponseHeaders(httpurlconnection));
                }
                responseDataHandler = response.getDataHandler();
                if (responseDataHandler != null || NetworkLog.fwLogNetwork.isLoggable || logTag != null)
                {
                    InputStream inputstream = null;
                    if (!NetworkUtil.isHttpClass2xx(responseCode))
                    {
                        inputstream = httpurlconnection.getErrorStream();
                    }
                    inputstream1 = inputstream;
                    if (inputstream == null)
                    {
                        inputstream1 = httpurlconnection.getInputStream();
                    }
                    if (inputstream1 != null)
                    {
                        if (!isPreReadInputStream())
                        {
                            break label0;
                        }
                        byte abyte0[] = StreamUtil.streamToBytes(inputstream1);
                        if (logTag != null)
                        {
                            NetworkLog.logContent(3, logTag, null, abyte0, HttpUrlConnectionHelper.getResponseHeaders(httpurlconnection));
                        }
                        if (NetworkLog.fwLogNetwork.isLoggable)
                        {
                            NetworkLog.logContent(null, abyte0, HttpUrlConnectionHelper.getResponseHeaders(httpurlconnection));
                        }
                        if (abyte0 != null)
                        {
                            responseStream = new DirectByteArrayInputStream(abyte0);
                        }
                    }
                }
                return;
            }
            responseStream = new BufferedInputStream(inputstream1, 8192);
        }

        private void send()
            throws IOException, InterruptedException
        {
            if (Thread.interrupted())
            {
                throw new InterruptedException();
            }
            tryCount = tryCount + 1;
            httpUrlConnection = setupRequest(request, requestData);
            if (logTag != null)
            {
                NetworkLog.logContent(3, logTag, request.getRequestUrl(), preCompressedRequestData, requestHeaders);
            }
            if (NetworkLog.fwLogNetwork.isLoggable)
            {
                NetworkLog.logContent(request.getRequestUrl(), preCompressedRequestData, requestHeaders);
            }
            trackedSend(requestData);
        }

        private void setCompleteResponse()
        {
            if (requestLogger != null)
            {
                requestLogger.setCompleteResponse(response);
            }
        }

        private HttpURLConnection setupRequest(Request request1, byte abyte0[])
            throws ProtocolException, IOException
        {
            boolean flag = true;
            URL url = request1.getRequestUrl();
            String s1 = request1.getUserAgent();
            int i = request1.getTimeout();
            Object obj = request1.getHttpMethod();
            String s = ((String) (obj));
            if (obj == null)
            {
                if (abyte0 == null)
                {
                    s = "GET";
                } else
                {
                    s = "POST";
                }
            }
            obj = (HttpURLConnection)url.openConnection();
            ((HttpURLConnection) (obj)).setDoInput(true);
            if (abyte0 == null)
            {
                flag = false;
            }
            ((HttpURLConnection) (obj)).setDoOutput(flag);
            ((HttpURLConnection) (obj)).setUseCaches(false);
            ((HttpURLConnection) (obj)).setReadTimeout(i);
            ((HttpURLConnection) (obj)).setConnectTimeout(i);
            ((HttpURLConnection) (obj)).setRequestMethod(s);
            if (abyte0 != null)
            {
                ((HttpURLConnection) (obj)).setFixedLengthStreamingMode(abyte0.length);
            }
            if (s1 != null)
            {
                ((HttpURLConnection) (obj)).addRequestProperty("User-Agent", s1);
            }
            if (gzipCompressed)
            {
                ((HttpURLConnection) (obj)).addRequestProperty("Content-Encoding", "gzip");
            }
            requestHeaders = HttpUrlConnectionHelper.getRequestHeaders(((HttpURLConnection) (obj)));
            request1.onAddHeaders(requestHeaders);
            requestHeaderMap = requestHeaders.getAllHeaders();
            return ((HttpURLConnection) (obj));
        }

        private boolean shouldRetry(IOException ioexception)
        {
            Response response1;
            if (receiveStarted)
            {
                response1 = response;
            } else
            {
                response1 = null;
            }
            if (tryCount < maxTries && recoverable != null && recoverable.hasRecoverableError(response1, ioexception))
            {
                recoverable.clearResponse();
                response = request.getResponse();
                sleepUntil = System.currentTimeMillis() + 200L * (long)tryCount;
                return true;
            } else
            {
                return false;
            }
        }

        private void sleep()
            throws InterruptedException
        {
            if (sleepUntil > 0L)
            {
                long l1 = sleepUntil - System.currentTimeMillis();
                if (l1 > 0L)
                {
                    long l = l1;
                    if (l1 > (long)maxTries * 200L)
                    {
                        l = 200L * (long)maxTries;
                    }
                    Thread.sleep(l);
                }
            }
        }

        private void trackedSend(byte abyte0[])
            throws IOException
        {
            requestTime = System.currentTimeMillis();
            if (requestLogger != null)
            {
                requestLogger.setRequestTime(requestTime);
            }
            trackPerf = new LogTrackPerf(request);
            if (abyte0 == null)
            {
                break MISSING_BLOCK_LABEL_124;
            }
            trackPerf.setBytesSent(String.valueOf(abyte0.length));
            abyte0 = httpUrlConnection.getOutputStream();
            abyte0.write(requestData);
            StreamUtil.closeQuietly(abyte0);
_L1:
            if (requestLogger != null)
            {
                requestLogger.setResponseTime(System.currentTimeMillis());
            }
            trackPerf.stopRequestTimer();
            return;
            Exception exception;
            exception;
            StreamUtil.closeQuietly(abyte0);
            throw exception;
            abyte0;
            trackPerf.stopRequestTimer();
            throw abyte0;
            trackPerf.setBytesSent("0");
              goto _L1
        }

        public Response getResponse()
        {
            return response;
        }

        public void sendRequest(EbayContext ebaycontext)
            throws IOException, InterruptedException
        {
            if (invalidDeviceClock())
            {
                throw new InvalidDeviceClockException();
            }
            request.setContext(ebaycontext);
            prepare();
_L4:
            boolean flag;
            request.initialize(response);
            flag = response.getResultStatus().hasError();
            if (!flag) goto _L2; else goto _L1
_L1:
            complete(null, false);
            request.setContext(null);
_L6:
            return;
_L2:
            ebaycontext = null;
            sleep();
            send();
            receive();
            parse();
_L5:
            complete(ebaycontext, true);
            if (shouldRetry(ebaycontext)) goto _L4; else goto _L3
_L3:
            if (ebaycontext == null)
            {
                break MISSING_BLOCK_LABEL_172;
            }
            throw ebaycontext;
            ebaycontext;
            complete(null, false);
            request.setContext(null);
            throw ebaycontext;
            IOException ioexception;
            ioexception;
            ebaycontext = ioexception;
            if (ExceptionUtil.isInterruptedException(ebaycontext))
            {
                throw ExceptionUtil.convertToInterruptedException(ebaycontext);
            }
            Log.w("Connector", (new StringBuilder()).append("").append(ioexception.getMessage()).toString(), ioexception);
              goto _L5
            setCompleteResponse();
            complete(null, false);
            request.setContext(null);
            if (!response.hasSuccessResponseCode())
            {
                ebaycontext = new HttpError(response.responseCode, response.responseMessage);
                List list = response.getResultStatus().getMessages();
                if (list != null)
                {
                    list.add(0, ebaycontext);
                    return;
                } else
                {
                    response.addResultMessage(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                        ebaycontext
                    });
                    return;
                }
            }
              goto _L6
        }

        public Impl.RequestControllerHttpUrlConnection(EbayContext ebaycontext, Request request1)
        {
            maxTries = 1;
            requestLogger = RequestLoggerFactory.createLogger(request1);
            request = request1;
            response = request1.getResponse();
            Request.Recoverable recoverable1;
            if (request1 instanceof Request.Recoverable)
            {
                recoverable1 = (Request.Recoverable)request1;
            } else
            {
                recoverable1 = null;
            }
            recoverable = recoverable1;
            if (ebaycontext.getAppInfo().isDebuggable())
            {
                request1 = request1.getClass().getSimpleName();
                if (request1.endsWith("Request"))
                {
                    int j = request1.length() - 7;
                    int i = j;
                    if (j > 23)
                    {
                        i = 23;
                    }
                    ebaycontext = request1.substring(0, i);
                } else
                {
                    ebaycontext = request1;
                    if (request1.length() > 23)
                    {
                        ebaycontext = request1.substring(0, 23);
                    }
                }
                if (!Log.isLoggable(ebaycontext, 3))
                {
                    ebaycontext = null;
                }
                logTag = ebaycontext;
                return;
            } else
            {
                logTag = null;
                return;
            }
        }
    }

    public static final class InvalidDeviceClockException extends IOException
    {

        public InvalidDeviceClockException()
        {
        }
    }

    public static final class Legacy
    {

        public static Response sendRequest(EbayContext ebaycontext, Request request)
            throws IOException, InterruptedException
        {
            ebaycontext = ebaycontext.getConnector().sendRequest(request);
            request = ebaycontext.getResultStatus().getMessages();
            if (request != null && !request.isEmpty())
            {
                request = (com.ebay.nautilus.kernel.content.ResultStatus.Message)request.get(request.size() - 1);
                if (request instanceof IoError)
                {
                    throw ((IoError)request).getException();
                }
            }
            return ebaycontext;
        }

        public Legacy()
        {
        }
    }

    public static class ParseResponseDataException extends ClientErrorException
    {

        private static final long serialVersionUID = 1L;

        public static ParseResponseDataException create(Throwable throwable)
        {
            String s = throwable.getLocalizedMessage();
            if (TextUtils.isEmpty(s))
            {
                return new ParseResponseDataException(throwable);
            } else
            {
                return new ParseResponseDataException(s, throwable);
            }
        }

        public ParseResponseDataException()
        {
        }

        public ParseResponseDataException(String s)
        {
            super(s);
        }

        public ParseResponseDataException(String s, Throwable throwable)
        {
            super(s);
            initCause(throwable);
        }

        public ParseResponseDataException(Throwable throwable)
        {
            initCause(throwable);
        }
    }


    public static final String ACCEPT_ENCODING = "accept-encoding";
    public static final String CHARSET_PARAM = "; charset=";
    public static final String CONTENT_ENCODING = "Content-Encoding";
    public static final String CONTENT_LENGTH = "Content-Length";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String CONTENT_TYPE_APPLICATION_XML = "application/xml";
    public static final String CONTENT_TYPE_APPLICATION_XML_ENCODING = "application/xml; charset=UTF-8";
    public static final String CONTENT_TYPE_IMAGE_JPEG = "image/jpeg";
    public static final String CONTENT_TYPE_JSON = "application/json";
    public static final String CONTENT_TYPE_MULTIPART = "multipart/form-data; boundary=";
    public static final String CONTENT_TYPE_OCTET_STREAM = "application/octet-stream";
    public static final String CONTENT_TYPE_SOAP_XML = "application/soap+xml; charset=UTF-8";
    public static final String CONTENT_TYPE_TEXT_XML = "text/xml";
    public static final String CONTENT_TYPE_TEXT_XML_ENCODING = "text/xml; charset=UTF-8";
    public static final String DEFAULT_CONTENT_CHARSET = "ISO-8859-1";
    public static final int DEFAULT_REQUEST_TIMEOUT = 60000;
    public static final String ENCODING_GZIP = "gzip";
    public static final String ENCODING_JSON = "JSON";
    public static final String ENCODING_XML = "XML";
    public static final String HTTP_ACCEPT = "accept";
    public static final String HTTP_ACCEPT_LANGUAGE = "accept-language";
    public static final String USER_AGENT = "User-Agent";
    public static final String UTF_8 = "UTF-8";

    public abstract Response sendRequest(Request request)
        throws InterruptedException;
}

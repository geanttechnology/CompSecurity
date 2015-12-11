// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

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
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

// Referenced classes of package com.ebay.nautilus.kernel.net:
//            Connector, RequestLoggerFactory, Request, LogTrackError, 
//            Response, NetworkLog, LogTrackManager, LogTrackPerf, 
//            IResponseDataHandler, IRequestLogger, HttpUrlConnectionHelper, IResponseHeaderHandler, 
//            IHeaders, HttpError

private static final class logTag extends logTag
{

    private static final long RETRY_BACKOFF_MULTIPLIER = 200L;
    private static final int logPriority = 3;
    private boolean gzipCompressed;
    private HttpURLConnection httpUrlConnection;
    private final String logTag;
    private int maxTries;
    private byte preCompressedRequestData[];
    private boolean receiveStarted;
    private final response recoverable;
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
        if (exception instanceof logTag)
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
        if (!NetworkLog.fwLogNetwork.leanUp)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        abyte1 = abyte2;
        NetworkLog.fwLogNetwork.leanUp((new StringBuilder()).append("Gzip Compression: ").append(abyte0.length).append(" -> ").append(abyte2.length).toString());
        StreamUtil.closeQuietly(bytearrayoutputstream);
        return abyte2;
        abyte0;
        if (NetworkLog.fwLogNetwork.leanUp)
        {
            NetworkLog.fwLogNetwork.leanUp("Gzip Compression request failed, sending uncompressed data", abyte0);
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
        return logTag != null || NetworkLog.fwLogNetwork.ogTag;
    }

    private void parse()
        throws logTag, InterruptedException, IOException
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
        throw checkForInterruptedIoException(((checkForInterruptedIoException) (obj)));
        obj;
        trackPerf.stopResponseTimer();
        trackPerf.stopParseTimer();
        throw obj;
    }

    private void prepare()
        throws trackPerf, InterruptedException
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
            maxTries = maxTries + recoverable.recoverable();
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
            if (responseDataHandler != null || NetworkLog.fwLogNetwork.esponseDataHandler || logTag != null)
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
                    if (NetworkLog.fwLogNetwork.ogTag)
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
        if (NetworkLog.fwLogNetwork.equestHeaders)
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
        if (tryCount < maxTries && recoverable != null && recoverable.recoverable(response1, ioexception))
        {
            recoverable.recoverable();
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
            throw new invalidDeviceClock();
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
                response.addResultMessage(new com.ebay.nautilus.kernel.content.onse[] {
                    ebaycontext
                });
                return;
            }
        }
          goto _L6
    }

    public (EbayContext ebaycontext, Request request1)
    {
        super(null);
        maxTries = 1;
        requestLogger = RequestLoggerFactory.createLogger(request1);
        request = request1;
        response = request1.getResponse();
         ;
        if (request1 instanceof response)
        {
             = (response)request1;
        } else
        {
             = null;
        }
        recoverable = ;
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

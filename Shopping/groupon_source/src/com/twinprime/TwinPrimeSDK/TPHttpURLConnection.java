// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPCFHttp, TwinPrimeSDK, TPCookieManager, TPHttpConnectionCore, 
//            TPLog, TPInputStream, TPEventLog, TPFilterInputStream, 
//            TPControlChannelStateMachine, XcpMsgStrategy, TPOobManager, TPGlobals, 
//            TwinPrimeSDKPvt

class TPHttpURLConnection extends HttpURLConnection
{
    class TPOobAckTimerTask extends TimerTask
    {

        final TPHttpURLConnection this$0;

        private void privRun()
        {
            if (TPLog.LOG13.isLoggable("TPHttpURLConnection"))
            {
                Log.d("TPHttpURLConnection", (new StringBuilder()).append("TPOobAckTimer - ").append(tpConnCore.tpcfHttp.originAddress).toString());
            }
            sendOutOfBandAck();
        }

        public void run()
        {
            try
            {
                privRun();
                return;
            }
            catch (Throwable throwable)
            {
                TwinPrimeSDKPvt.disableSDK();
            }
        }

        TPOobAckTimerTask()
        {
            this$0 = TPHttpURLConnection.this;
            super();
        }
    }


    final String LOG_TAG = "TPHttpURLConnection";
    int acksSent;
    int acksSuppressed;
    int content_length;
    String http_client;
    long lastSeq;
    int lastSeqDup;
    String locationResponse;
    private HttpURLConnection pimpl;
    boolean processed;
    boolean processing_redirect;
    boolean redirect;
    int redirections;
    long serverFlowId;
    int serverInstanceId;
    long serverObjId;
    int timer_callback_cnt;
    int totalBytes;
    TPHttpConnectionCore tpConnCore;
    TPInputStream tpErrorStream;
    TPFilterInputStream tpInputStream;
    TimerTask tpOobAckTimerTask;

    protected TPHttpURLConnection(TPCFHttp tpcfhttp)
        throws IOException
    {
        super(tpcfhttp.url);
        content_length = 0;
        locationResponse = null;
        tpInputStream = null;
        tpErrorStream = null;
        timer_callback_cnt = 0;
        totalBytes = 0;
        redirections = 5;
        processing_redirect = false;
        redirect = true;
        processed = false;
        http_client = TwinPrimeSDK.EVENTLOG_HTTP_CLIENT_HTTPURLCONNECTION;
        TPCookieManager.setSelfAsDefault();
        tpConnCore = new TPHttpConnectionCore(tpcfhttp);
        pimpl = (HttpURLConnection)tpConnCore.tpcfHttp.url.openConnection();
    }

    private TPInputStream getTPErrorStream()
    {
        ByteArrayOutputStream bytearrayoutputstream;
        Object obj;
        byte abyte0[];
        bytearrayoutputstream = new ByteArrayOutputStream(50000);
        obj = pimpl.getErrorStream();
        abyte0 = new byte[5000];
        if (obj == null)
        {
            return null;
        }
_L2:
        int i = ((InputStream) (obj)).read(abyte0);
        if (i == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        bytearrayoutputstream.write(abyte0, 0, i);
        if (true) goto _L2; else goto _L1
_L4:
        if (tpConnCore.will_accelerate)
        {
            tpConnCore.tpcfHttp.releasePort();
        }
        return new TPInputStream(new ByteArrayInputStream(bytearrayoutputstream.toByteArray()), tpConnCore.tpEvLog);
_L1:
        try
        {
            ((InputStream) (obj)).close();
            endLogging();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            if (TPLog.LOG10.isLoggable("TPHttpURLConnection"))
            {
                ((IOException) (obj)).printStackTrace();
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void getTPInputStream()
    {
        boolean flag;
        flag = false;
        if (tpInputStream == null && !processing_redirect)
        {
            handleRedirect();
        }
        if (tpInputStream != null) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        TPEventLog tpeventlog;
        int i;
        try
        {
            responseCode = pimpl.getResponseCode();
            tpConnCore.tpEvLog.connection_open_time = (int)((new Date()).getTime() - tpConnCore.tpEvLog.start_time);
            obj = pimpl.getHeaderField("X-Twinprime-Flow-ID");
        }
        catch (IOException ioexception)
        {
            handleException(ioexception);
            return;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        tpConnCore.tpEvLog.flow_info = ((String) (obj));
        parseFlowId(((String) (obj)));
        tpConnCore.tpEvLog.first_data_time = (int)((new Date()).getTime() - tpConnCore.tpEvLog.start_time);
        TPCookieManager.removeAcceleratorIPCookies();
        i = pimpl.getResponseCode();
        tpConnCore.tpEvLog.status_code = i;
        tpConnCore.tpEvLog.content_type = pimpl.getContentType();
        if (i / 100 != 3)
        {
            redirections = 0;
        }
        pimpl.getHeaderFields();
        obj = pimpl.getHeaderField("Content-Encoding");
        obj1 = tpConnCore.tpEvLog;
        i = ((flag) ? 1 : 0);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_238;
        }
        i = ((flag) ? 1 : 0);
        if (((String) (obj)).contains("gzip"))
        {
            i = 1;
        }
        obj1.is_compressed = (short)i;
        content_length = totalBytes;
        obj1 = pimpl.getInputStream();
        tpeventlog = tpConnCore.tpEvLog;
        if (!tpConnCore.will_accelerate)
        {
            break MISSING_BLOCK_LABEL_309;
        }
        obj = tpConnCore.tpcfHttp;
_L3:
        tpInputStream = new TPFilterInputStream(((InputStream) (obj1)), tpeventlog, ((TPCFHttp) (obj)));
        startOobAckTimer(100L);
_L2:
        return;
        obj = null;
          goto _L3
    }

    private void handleRedirect()
    {
        processing_redirect = true;
_L12:
        responseCode = pimpl.getResponseCode();
        Object obj;
        obj = pimpl.getClass().getDeclaredField("httpEngine");
        ((Field) (obj)).setAccessible(true);
        obj = ((Field) (obj)).get(pimpl);
        Field field = obj.getClass().getDeclaredField("responseSource");
        field.setAccessible(true);
        obj = field.get(obj).toString();
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (!"network".equalsIgnoreCase(((String) (obj)).toString())) goto _L4; else goto _L3
_L3:
        tpConnCore.tpEvLog.response_source = TwinPrimeSDK.EVENTLOG_RESPONSE_SOURCE_NETWORK;
_L2:
        obj = pimpl.getHeaderField("Location");
        if (obj != null) goto _L6; else goto _L5
_L5:
        try
        {
            redirections = 0;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            if (TPLog.LOG10.isLoggable("TPHttpURLConnection"))
            {
                ((IOException) (obj)).printStackTrace();
            }
            redirections = 0;
        }
_L11:
        processing_redirect = false;
        return;
_L4:
        if (!"cache".equalsIgnoreCase(((String) (obj)).toString())) goto _L8; else goto _L7
_L7:
        tpConnCore.tpEvLog.response_source = TwinPrimeSDK.EVENTLOG_RESPONSE_SOURCE_CACHE;
          goto _L2
        obj;
        if (!TPLog.LOG10.isLoggable("TPHttpURLConnection")) goto _L2; else goto _L9
_L9:
        ((Exception) (obj)).printStackTrace();
          goto _L2
_L8:
        if (!"conditional_cache".equalsIgnoreCase(((String) (obj)).toString())) goto _L2; else goto _L10
_L10:
        tpConnCore.tpEvLog.response_source = TwinPrimeSDK.EVENTLOG_RESPONSE_SOURCE_CONDITIONAL_CACHE;
          goto _L2
_L6:
label0:
        {
            obj = new URL(tpConnCore.tpcfHttp.originURL, ((String) (obj)));
            locationResponse = ((URL) (obj)).toString();
            if (redirect && ((URL) (obj)).getProtocol().equalsIgnoreCase("http") && (responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307 || responseCode == 300))
            {
                break label0;
            }
            redirections = 0;
        }
          goto _L11
        freeResources();
        tpConnCore.tpEvLog.data_completed_time = (int)((new Date()).getTime() - tpConnCore.tpEvLog.start_time);
        tpConnCore.tpEvLog.bytes_downloaded = totalBytes;
        tpConnCore.tpEvLog.error_string = "Success";
        endLogging();
        tpConnCore = new TPHttpConnectionCore(new TPCFHttp(((URL) (obj)), 0, tpConnCore.tpcfHttp.requested_acceleration));
        pimpl = (HttpURLConnection)tpConnCore.tpcfHttp.url.openConnection();
        initialize();
        int i;
        i = redirections - 1;
        redirections = i;
        if (i > 0) goto _L12; else goto _L11
    }

    private void processRequest()
    {
        if (processed)
        {
            return;
        } else
        {
            initialize();
            getTPInputStream();
            processed = true;
            return;
        }
    }

    private void setHttpMethod()
    {
        tpConnCore.tpEvLog.setHttpMethod(pimpl.getRequestMethod());
    }

    public void addRequestProperty(String s, String s1)
    {
        pimpl.addRequestProperty(s, s1);
    }

    public void connect()
        throws IOException
    {
        processRequest();
        pimpl.connect();
    }

    public void disconnect()
    {
        pimpl.disconnect();
        if (tpConnCore.tpEvLog != null)
        {
            tpConnCore.tpEvLog.end_time = (new Date()).getTime();
        }
    }

    protected void endLogging()
        throws IOException
    {
        stopOobAckTimer();
        tpConnCore.tpEvLog.calcStats();
        pimpl.getHeaderFields();
        String s = pimpl.getHeaderField("Content-Encoding");
        TPEventLog tpeventlog = tpConnCore.tpEvLog;
        int i;
        if (s != null && s.contains("gzip"))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        tpeventlog.is_compressed = (short)i;
        s = pimpl.getHeaderField("X-Twinprime-Flow-ID");
        if (s != null)
        {
            tpConnCore.tpEvLog.flow_info = s;
        }
        tpConnCore.tpEvLog.status_code = responseCode;
        tpConnCore.tpEvLog.http_client = http_client;
        s = pimpl.getHeaderField("X-Android-Response-Source");
        if (s != null && s.contains("CACHE"))
        {
            tpConnCore.tpEvLog.bypass_reason = "cached-response";
            if (tpConnCore.will_accelerate)
            {
                tpConnCore.tpEvLog.is_accelerated = 1;
            } else
            {
                tpConnCore.tpEvLog.is_accelerated = 0;
            }
        }
        tpConnCore.finishEventLog();
    }

    void freeResources()
    {
        byte abyte0[] = new byte[1000];
        InputStream inputstream;
        for (inputstream = pimpl.getInputStream(); inputstream.read(abyte0) != -1;) { }
        inputstream.close();
_L1:
        Exception exception1;
        InputStream inputstream1;
        try
        {
            tpInputStream = null;
            tpErrorStream = null;
            return;
        }
        catch (Exception exception)
        {
            if (TPLog.LOG10.isLoggable("TPHttpURLConnection"))
            {
                exception.printStackTrace();
            }
        }
        break MISSING_BLOCK_LABEL_129;
        exception1;
        for (inputstream1 = pimpl.getErrorStream(); inputstream1.read(abyte0) != -1;) { }
        inputstream1.close();
        if (TPLog.LOG10.isLoggable("TPHttpURLConnection"))
        {
            Log.e("TPHttpURLConnection", (new StringBuilder()).append("exception with TPHttpURLConnection: ").append(tpConnCore.tpcfHttp.originAddress).toString());
            exception1.printStackTrace();
        }
          goto _L1
    }

    public boolean getAllowUserInteraction()
    {
        return pimpl.getAllowUserInteraction();
    }

    public int getConnectTimeout()
    {
        return pimpl.getConnectTimeout();
    }

    public Object getContent()
        throws IOException
    {
        processRequest();
        return pimpl.getContent();
    }

    public Object getContent(Class aclass[])
        throws IOException
    {
        processRequest();
        return pimpl.getContent(aclass);
    }

    public String getContentEncoding()
    {
        processRequest();
        return pimpl.getContentEncoding();
    }

    public int getContentLength()
    {
        processRequest();
        return pimpl.getContentLength();
    }

    public String getContentType()
    {
        processRequest();
        return pimpl.getContentType();
    }

    public long getDate()
    {
        processRequest();
        return pimpl.getDate();
    }

    public boolean getDefaultUseCaches()
    {
        return pimpl.getDefaultUseCaches();
    }

    public boolean getDoInput()
    {
        return pimpl.getDoInput();
    }

    public boolean getDoOutput()
    {
        return pimpl.getDoOutput();
    }

    public InputStream getErrorStream()
    {
        if (!processing_redirect)
        {
            handleRedirect();
        }
        if (tpErrorStream == null)
        {
            tpErrorStream = getTPErrorStream();
        }
        return tpErrorStream;
    }

    public long getExpiration()
    {
        processRequest();
        return pimpl.getExpiration();
    }

    public String getHeaderField(int i)
    {
        processRequest();
        return pimpl.getHeaderField(i);
    }

    public String getHeaderField(String s)
    {
        processRequest();
        if (s.equalsIgnoreCase("Content-Length"))
        {
            return String.valueOf(content_length);
        }
        if (s.equalsIgnoreCase("Location"))
        {
            return locationResponse;
        } else
        {
            return pimpl.getHeaderField(s);
        }
    }

    public long getHeaderFieldDate(String s, long l)
    {
        processRequest();
        return pimpl.getHeaderFieldDate(s, l);
    }

    public int getHeaderFieldInt(String s, int i)
    {
        processRequest();
        return pimpl.getHeaderFieldInt(s, i);
    }

    public String getHeaderFieldKey(int i)
    {
        processRequest();
        return pimpl.getHeaderFieldKey(i);
    }

    public Map getHeaderFields()
    {
        processRequest();
        return pimpl.getHeaderFields();
    }

    public long getIfModifiedSince()
    {
        return pimpl.getIfModifiedSince();
    }

    public InputStream getInputStream()
        throws IOException
    {
        processRequest();
        if (tpInputStream == null && tpConnCore.tpcfHttp != null && tpConnCore.tpcfHttp.originAddress != null)
        {
            throw new FileNotFoundException(tpConnCore.tpcfHttp.originAddress);
        } else
        {
            return tpInputStream;
        }
    }

    public boolean getInstanceFollowRedirects()
    {
        return redirect;
    }

    public long getLastModified()
    {
        processRequest();
        return pimpl.getLastModified();
    }

    public OutputStream getOutputStream()
        throws IOException
    {
        return pimpl.getOutputStream();
    }

    public Permission getPermission()
        throws IOException
    {
        return pimpl.getPermission();
    }

    public int getReadTimeout()
    {
        return pimpl.getReadTimeout();
    }

    public String getRequestMethod()
    {
        return pimpl.getRequestMethod();
    }

    public Map getRequestProperties()
    {
        return pimpl.getRequestProperties();
    }

    public String getRequestProperty(String s)
    {
        return pimpl.getRequestProperty(s);
    }

    public int getResponseCode()
        throws IOException
    {
        processRequest();
        responseCode = pimpl.getResponseCode();
        return responseCode;
    }

    public String getResponseMessage()
        throws IOException
    {
        processRequest();
        return pimpl.getResponseMessage();
    }

    public URL getURL()
    {
        return pimpl.getURL();
    }

    public boolean getUseCaches()
    {
        return pimpl.getUseCaches();
    }

    protected void handleException(IOException ioexception)
    {
        if (ioexception instanceof FileNotFoundException)
        {
            tpConnCore.tpEvLog.error_string = (new StringBuilder()).append(responseMessage).append(" - File not found: ").append(ioexception.getMessage()).toString();
        } else
        if (ioexception instanceof EOFException)
        {
            tpConnCore.tpEvLog.error_string = (new StringBuilder()).append(responseCode).append(" - End of file reached: ").append(ioexception.getMessage()).toString();
        } else
        {
            tpConnCore.tpEvLog.error_string = (new StringBuilder()).append(responseCode).append(" - General I/O exception").append(ioexception.getMessage()).toString();
        }
        tpErrorStream = getTPErrorStream();
    }

    void initialize()
    {
        tpConnCore.tpEvLog.start_time = (new Date()).getTime();
        tpConnCore.tpEvLog.http_client = http_client;
        pimpl.setInstanceFollowRedirects(false);
        if (TPLog.LOG10.isLoggable("TPHttpURLConnection"))
        {
            StringBuilder stringbuilder = (new StringBuilder()).append("Connection to ").append(tpConnCore.tpcfHttp.originAddress);
            String s;
            if (tpConnCore.will_accelerate)
            {
                s = " accelerated [";
            } else
            {
                s = " NOT accelerated [";
            }
            Log.i("TPHttpURLConnection", stringbuilder.append(s).append(url.getHost()).append("]").toString());
        }
        setHttpMethod();
    }

    void parseFlowId(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        StringTokenizer stringtokenizer;
        return;
_L2:
        if ((stringtokenizer = new StringTokenizer(s, ":")).countTokens() < 3) goto _L1; else goto _L3
_L3:
        serverInstanceId = Integer.parseInt(stringtokenizer.nextToken());
        serverFlowId = Long.parseLong(stringtokenizer.nextToken());
        serverObjId = Long.parseLong(stringtokenizer.nextToken());
_L5:
        tpConnCore.tpEvLog.flow_info = s;
        return;
        NoSuchElementException nosuchelementexception;
        nosuchelementexception;
        if (TPLog.LOG10.isLoggable("TPHttpURLConnection"))
        {
            nosuchelementexception.printStackTrace();
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    void sendOutOfBandAck()
    {
        long l = Math.max(TPControlChannelStateMachine.getInstance().acc_strategy.oob_ack, 20L);
        boolean flag1 = true;
        boolean flag = true;
        if (serverFlowId == 0L)
        {
            if (TPLog.LOG13.isLoggable("TPHttpURLConnection"))
            {
                Log.d("TPHttpURLConnection", "serverFlowId == 0");
            }
        } else
        {
            long l1 = tpInputStream.totalBytes;
            if (l1 == lastSeq)
            {
                if (TPLog.LOG13.isLoggable("TPHttpURLConnection"))
                {
                    Log.d("TPHttpURLConnection", "seq == lastSeq");
                }
                lastSeqDup = lastSeqDup + 1;
                if (lastSeqDup >= 2)
                {
                    acksSuppressed = acksSuppressed + 1;
                    flag = false;
                }
                if (timer_callback_cnt >= 3 && timer_callback_cnt < 6)
                {
                    l *= Math.round(Math.pow(10D, timer_callback_cnt - 2));
                } else
                if (timer_callback_cnt >= 6)
                {
                    l = -1L;
                    flag = false;
                }
                timer_callback_cnt = timer_callback_cnt + 1;
            } else
            {
                lastSeqDup = 0;
                timer_callback_cnt = 0;
                flag = flag1;
            }
            if (l > 0L)
            {
                startOobAckTimer(l);
            }
            if (flag)
            {
                sendOutOfBandAckInternal(l1);
                return;
            }
        }
    }

    void sendOutOfBandAckInternal(long l)
    {
        TPControlChannelStateMachine.getInstance().tpOobManager.sendOutOfBandAck(serverInstanceId, serverFlowId, serverObjId, l);
        lastSeq = l;
        acksSent = acksSent + 1;
    }

    public void setAllowUserInteraction(boolean flag)
    {
        pimpl.setAllowUserInteraction(flag);
    }

    public void setChunkedStreamingMode(int i)
    {
        pimpl.setChunkedStreamingMode(i);
    }

    public void setConnectTimeout(int i)
        throws IllegalArgumentException
    {
        pimpl.setConnectTimeout(i);
    }

    public void setDefaultUseCaches(boolean flag)
    {
        pimpl.setDefaultUseCaches(flag);
    }

    public void setDoInput(boolean flag)
        throws IllegalAccessError
    {
        pimpl.setDoInput(flag);
    }

    public void setDoOutput(boolean flag)
        throws IllegalAccessError
    {
        pimpl.setDoOutput(flag);
    }

    public void setFixedLengthStreamingMode(int i)
    {
        pimpl.setFixedLengthStreamingMode(i);
    }

    public void setIfModifiedSince(long l)
        throws IllegalStateException
    {
        pimpl.setIfModifiedSince(l);
    }

    public void setInstanceFollowRedirects(boolean flag)
    {
        redirect = flag;
    }

    public void setReadTimeout(int i)
    {
        pimpl.setReadTimeout(i);
    }

    public void setRequestMethod(String s)
        throws ProtocolException
    {
        pimpl.setRequestMethod(s);
    }

    public void setRequestProperty(String s, String s1)
        throws IllegalStateException, NullPointerException
    {
        pimpl.setRequestProperty(s, s1);
    }

    public void setUseCaches(boolean flag)
    {
        pimpl.setUseCaches(flag);
    }

    void startOobAckTimer(long l)
    {
        if (TPControlChannelStateMachine.getInstance().acc_strategy.oob_ack != 0)
        {
            tpOobAckTimerTask = new TPOobAckTimerTask();
            TPGlobals.getTimer().schedule(tpOobAckTimerTask, l);
        }
    }

    void stopOobAckTimer()
    {
        if (tpOobAckTimerTask != null)
        {
            tpOobAckTimerTask.cancel();
            TPGlobals.getTimer().purge();
        }
    }

    public String toString()
    {
        String s = getClass().getName();
        return String.format(Locale.US, "%s:%s", new Object[] {
            s, tpConnCore.tpcfHttp.originAddress
        });
    }

    public boolean usingProxy()
    {
        return pimpl.usingProxy();
    }
}

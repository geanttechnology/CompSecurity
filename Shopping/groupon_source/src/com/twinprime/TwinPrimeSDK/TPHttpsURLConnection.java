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
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.security.cert.Certificate;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPProxyDaemon, TPCFHttp, TwinPrimeSDK, TPHttpConnectionCore, 
//            TPOptionManager, TPControlChannelStateMachine, TPVTPManager, TPEventLog, 
//            TPLog, TPInputStream, TPCookieManager, TPTLSFactory, 
//            XcpMsgStrategy

class TPHttpsURLConnection extends HttpsURLConnection
{

    static Proxy permProxy;
    final String LOG_TAG = "TPHttpsURLConnection";
    int content_length;
    String http_client;
    private HttpsURLConnection pimpl;
    boolean processed;
    boolean processing_redirect;
    boolean redirect;
    int redirections;
    TPHttpConnectionCore tpConnCore;
    TPInputStream tpErrorStream;
    TPInputStream tpInputStream;

    protected TPHttpsURLConnection(TPCFHttp tpcfhttp)
        throws IOException
    {
        super(tpcfhttp.url);
        content_length = 0;
        redirections = 5;
        processing_redirect = false;
        redirect = true;
        processed = false;
        http_client = TwinPrimeSDK.EVENTLOG_HTTP_CLIENT_HTTPURLCONNECTION;
        tpConnCore = new TPHttpConnectionCore(tpcfhttp);
        if (!tpConnCore.will_accelerate)
        {
            if (TPOptionManager.getHTTPSProxy() == TPOptionManager.TPOptionHTTPSProxy.TPOptionHTTPSProxy_local)
            {
                TPControlChannelStateMachine.getInstance().tpVtpManager.releaseVtp(tpcfhttp.vtp);
            } else
            {
                tpcfhttp.releasePort();
            }
            url = tpcfhttp.originURL;
        }
        initialize();
    }

    private void endLogging()
        throws IOException
    {
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
            tpConnCore.tpEvLog.is_accelerated = 1;
        }
        tpConnCore.tpEvLog.endLoggingEvent();
        tpConnCore.tpEvLog = null;
    }

    private TPInputStream getTPErrorStream()
    {
        ByteArrayOutputStream bytearrayoutputstream;
        Object obj;
        byte abyte0[];
        bytearrayoutputstream = new ByteArrayOutputStream(50000);
        obj = pimpl.getErrorStream();
        abyte0 = new byte[5000];
_L3:
        int i = ((InputStream) (obj)).read(abyte0);
        if (i == -1) goto _L2; else goto _L1
_L1:
        bytearrayoutputstream.write(abyte0, 0, i);
          goto _L3
        obj;
        if (TPLog.LOG10.isLoggable("TPHttpsURLConnection"))
        {
            ((IOException) (obj)).printStackTrace();
        }
_L4:
        return new TPInputStream(new ByteArrayInputStream(bytearrayoutputstream.toByteArray()), tpConnCore.tpEvLog);
_L2:
        ((InputStream) (obj)).close();
        if (tpConnCore.will_accelerate)
        {
            if (TPOptionManager.getHTTPSProxy() != TPOptionManager.TPOptionHTTPSProxy.TPOptionHTTPSProxy_local)
            {
                break MISSING_BLOCK_LABEL_136;
            }
            TPVTPManager.getInstance().releaseVtp(tpConnCore.tpcfHttp.vtp);
        }
_L5:
        endLogging();
          goto _L4
        tpConnCore.tpcfHttp.releasePort();
          goto _L5
    }

    private void handleRedirect()
    {
        if (!redirect)
        {
            return;
        }
        processing_redirect = true;
_L6:
        if (redirections <= 0) goto _L2; else goto _L1
_L1:
        int i = pimpl.getResponseCode();
        if (i == 301 || i == 302 || i == 303 || i == 307) goto _L4; else goto _L3
_L3:
        Object obj;
        try
        {
            redirections = 0;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            if (TPLog.LOG10.isLoggable("TPHttpsURLConnection"))
            {
                ((IOException) (obj)).printStackTrace();
            }
            redirections = 0;
        }
_L2:
        processing_redirect = false;
        return;
_L4:
        obj = pimpl.getHeaderField("Location");
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        redirections = 0;
          goto _L2
label0:
        {
            obj = new URL(tpConnCore.tpcfHttp.originURL, ((String) (obj)));
            if (((URL) (obj)).getProtocol().equalsIgnoreCase("https"))
            {
                break label0;
            }
            redirections = 0;
        }
          goto _L2
        freeResources();
        url = ((URL) (obj));
        tpConnCore.tpcfHttp = new TPCFHttp(((URL) (obj)), 0);
        initialize();
        redirections = redirections - 1;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void processRequest()
    {
        if (processed)
        {
            return;
        } else
        {
            getTPInputStream();
            handleRedirect();
            processed = true;
            return;
        }
    }

    private void setHttpMethod()
    {
        tpConnCore.tpEvLog.setHttpMethod(pimpl.getRequestMethod());
    }

    public void connect()
        throws IOException
    {
        handleRedirect();
        pimpl.connect();
    }

    public void disconnect()
    {
        pimpl.disconnect();
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
            if (TPLog.LOG10.isLoggable("TPHttpsURLConnection"))
            {
                exception.printStackTrace();
            }
        }
        break MISSING_BLOCK_LABEL_129;
        exception1;
        for (inputstream1 = pimpl.getErrorStream(); inputstream1.read(abyte0) != -1;) { }
        inputstream1.close();
        if (TPLog.LOG10.isLoggable("TPHttpsURLConnection"))
        {
            Log.e("TPHttpsURLConnection", (new StringBuilder()).append("exception with TPHttpURLConnection: ").append(tpConnCore.tpcfHttp.originAddress).toString());
            exception1.printStackTrace();
        }
          goto _L1
    }

    public String getCipherSuite()
    {
        return pimpl.getCipherSuite();
    }

    public InputStream getErrorStream()
    {
        if (tpErrorStream == null)
        {
            tpErrorStream = getTPErrorStream();
        }
        return tpInputStream;
    }

    public String getHeaderField(int i)
    {
        return pimpl.getHeaderField(i);
    }

    public String getHeaderField(String s)
    {
        if (s.equalsIgnoreCase("Content-Length"))
        {
            return String.valueOf(content_length);
        } else
        {
            return pimpl.getHeaderField(s);
        }
    }

    public int getHeaderFieldInt(String s, int i)
    {
        return pimpl.getHeaderFieldInt(s, i);
    }

    public String getHeaderFieldKey(int i)
    {
        return pimpl.getHeaderFieldKey(i);
    }

    public Map getHeaderFields()
    {
        return pimpl.getHeaderFields();
    }

    public InputStream getInputStream()
        throws IOException
    {
        processRequest();
        return tpInputStream;
    }

    public boolean getInstanceFollowRedirects()
    {
        return redirect;
    }

    public Certificate[] getLocalCertificates()
    {
        return pimpl.getLocalCertificates();
    }

    public OutputStream getOutputStream()
        throws IOException
    {
        return pimpl.getOutputStream();
    }

    public int getResponseCode()
        throws IOException
    {
        processRequest();
        return pimpl.getResponseCode();
    }

    public Certificate[] getServerCertificates()
        throws SSLPeerUnverifiedException
    {
        return pimpl.getServerCertificates();
    }

    public void getTPInputStream()
    {
        if (tpInputStream != null)
        {
            break MISSING_BLOCK_LABEL_484;
        }
        if (!processing_redirect)
        {
            handleRedirect();
        }
        int i = pimpl.getContentLength();
        byte abyte0[];
        Object obj;
        TPCFHttp.TransferStream transferstream;
        InputStream inputstream;
        int j;
        if (i <= 0)
        {
            i = 32768;
        }
        transferstream = new TPCFHttp.TransferStream(i);
        abyte0 = new byte[4096];
        i = 0;
        inputstream = pimpl.getInputStream();
        TPCookieManager.removeAcceleratorIPCookies();
        responseCode = pimpl.getResponseCode();
        tpConnCore.tpEvLog.content_type = pimpl.getContentType();
        tpConnCore.tpEvLog.first_data_time = (int)((new Date()).getTime() - tpConnCore.tpEvLog.start_time);
_L1:
        j = inputstream.read(abyte0, 0, 1024);
label0:
        {
            if (j == -1)
            {
                break label0;
            }
            try
            {
                transferstream.write(abyte0, 0, j);
                abyte0 = new byte[4096];
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                tpConnCore.tpEvLog.error_string = (new StringBuilder()).append(responseCode).append(" - File not found: ").append(((FileNotFoundException) (obj)).getMessage()).toString();
                tpErrorStream = getTPErrorStream();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                tpConnCore.tpEvLog.error_string = (new StringBuilder()).append(responseCode).append(" - End of file reached: ").append(((EOFException) (obj)).getMessage()).toString();
                tpErrorStream = getTPErrorStream();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                if (TPLog.LOG11.isLoggable("TPHttpsURLConnection"))
                {
                    ((IOException) (obj)).printStackTrace();
                }
                tpConnCore.tpEvLog.error_string = (new StringBuilder()).append(responseCode).append(" - General I/O exception").append(((IOException) (obj)).getMessage()).toString();
                tpErrorStream = getTPErrorStream();
                return;
            }
            i += j;
        }
          goto _L1
        inputstream.close();
        if (tpConnCore.will_accelerate)
        {
            if (TPOptionManager.getHTTPSProxy() != TPOptionManager.TPOptionHTTPSProxy.TPOptionHTTPSProxy_local)
            {
                break MISSING_BLOCK_LABEL_298;
            }
            TPControlChannelStateMachine.getInstance().tpVtpManager.releaseVtp(tpConnCore.tpcfHttp.vtp);
        }
_L3:
        tpConnCore.tpEvLog.data_completed_time = (int)((new Date()).getTime() - tpConnCore.tpEvLog.start_time);
        tpConnCore.tpEvLog.bytes_downloaded = i;
        tpConnCore.tpEvLog.error_string = "Success";
        endLogging();
        content_length = i;
        tpInputStream = new TPInputStream(((TPCFHttp.TransferStream)transferstream).convert(), tpConnCore.tpEvLog);
        return;
        tpConnCore.tpcfHttp.releasePort();
        if (true) goto _L3; else goto _L2
_L2:
    }

    void initialize()
        throws IOException
    {
        TPCookieManager.setSelfAsDefault();
        Object obj;
        if (tpConnCore.will_accelerate)
        {
            StringBuilder stringbuilder;
            if (TPOptionManager.getHTTPSProxy() == TPOptionManager.TPOptionHTTPSProxy.TPOptionHTTPSProxy_remote)
            {
                obj = new InetSocketAddress(TPControlChannelStateMachine.getInstance().accIPAddrStr, tpConnCore.tpcfHttp.port);
                obj = new Proxy(java.net.Proxy.Type.HTTP, ((java.net.SocketAddress) (obj)));
            } else
            {
                obj = permProxy;
            }
            if (TPLog.LOG13.isLoggable("TPHttpsURLConnection"))
            {
                Log.d("TPHttpsURLConnection", (new StringBuilder()).append("usingProxy: ").append(obj).toString());
            }
            HttpConnectionParams.setTcpNoDelay(new BasicHttpParams(), true);
            if (TPLog.LOG13.isLoggable("TPHttpsURLConnection"))
            {
                Log.d("TPHttpsURLConnection", (new StringBuilder()).append("before openConnection: ").append((new Date()).getTime()).toString());
            }
            pimpl = (HttpsURLConnection)tpConnCore.tpcfHttp.url.openConnection(((Proxy) (obj)));
            if (TPLog.LOG13.isLoggable("TPHttpsURLConnection"))
            {
                Log.d("TPHttpsURLConnection", (new StringBuilder()).append("after openConnection: ").append((new Date()).getTime()).toString());
            }
            try
            {
                pimpl.setSSLSocketFactory(TPTLSFactory.getInstance());
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                if (TPLog.LOG10.isLoggable("TPHttpsURLConnection"))
                {
                    ((NoClassDefFoundError) (obj)).printStackTrace();
                }
            }
            pimpl.setDoInput(true);
            pimpl.setInstanceFollowRedirects(false);
            pimpl.addRequestProperty("X-Forwarded-For", TPControlChannelStateMachine.getInstance().accessIPAddrStr);
        } else
        {
            pimpl = (HttpsURLConnection)tpConnCore.tpcfHttp.url.openConnection();
        }
        tpConnCore.tpEvLog.start_time = (new Date()).getTime();
        if (TPLog.LOG13.isLoggable("TPHttpsURLConnection"))
        {
            Log.d("TPHttpsURLConnection", (new StringBuilder()).append("original URL: ").append(tpConnCore.tpcfHttp.originAddress).toString());
            Log.d("TPHttpsURLConnection", (new StringBuilder()).append("accelerated URL: ").append(tpConnCore.tpcfHttp.url).toString());
            Log.d("TPHttpsURLConnection", (new StringBuilder()).append("accIPAddrStr: ").append(TPControlChannelStateMachine.getInstance().accIPAddrStr).toString());
            Log.d("TPHttpsURLConnection", (new StringBuilder()).append("port: ").append(tpConnCore.tpcfHttp.port).toString());
            Log.d("TPHttpsURLConnection", (new StringBuilder()).append("TPControlChannel.getInstance().accHttpPort: ").append(TPControlChannelStateMachine.getInstance().acc_strategy.http_server_port).toString());
        }
        if (TPLog.LOG13.isLoggable("TPHttpsURLConnection"))
        {
            stringbuilder = (new StringBuilder()).append("Connection to ").append(tpConnCore.tpcfHttp.originAddress);
            if (tpConnCore.will_accelerate)
            {
                obj = " accelerated [";
            } else
            {
                obj = " NOT accelerated [";
            }
            Log.d("TPHttpsURLConnection", stringbuilder.append(((String) (obj))).append(url.getHost()).append("]").toString());
        }
        setHttpMethod();
    }

    public void setDoOutput(boolean flag)
        throws IllegalAccessError
    {
        pimpl.setDoOutput(flag);
    }

    public void setInstanceFollowRedirects(boolean flag)
    {
        redirect = flag;
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

    static 
    {
        permProxy = null;
        InetSocketAddress inetsocketaddress = new InetSocketAddress("localhost", TPProxyDaemon.getInstance().getPermProxyPort());
        if (permProxy == null)
        {
            permProxy = new Proxy(java.net.Proxy.Type.HTTP, inetsocketaddress);
        }
    }
}

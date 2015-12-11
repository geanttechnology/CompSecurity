// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.Vector;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPControlChannelStateMachine, TPEventLog, TwinPrimeSDKPvt, XcpMsgStrategy, 
//            TPOptionManager, TPLog, TPVTPManager, TPProxyDaemon, 
//            TPVTP

class TPCFHttp
{
    private static class ReusablePorts
    {

        private String LOG_TAG;
        private Vector availablePorts;
        private Vector inUsePorts;
        int type;

        int getNextAvailablePort(boolean flag)
        {
            this;
            JVM INSTR monitorenter ;
            if (flag) goto _L2; else goto _L1
_L1:
            if (availablePorts.size() <= 0) goto _L2; else goto _L3
_L3:
            int j;
            j = ((Integer)availablePorts.get(0)).intValue();
            availablePorts.remove(0);
            inUsePorts.add(Integer.valueOf(j));
            int i = j;
            if (!TPLog.LOG13.isLoggable(LOG_TAG))
            {
                break MISSING_BLOCK_LABEL_101;
            }
            Log.d(LOG_TAG, (new StringBuilder()).append("Reusing port: ").append(j).toString());
            i = j;
_L5:
            this;
            JVM INSTR monitorexit ;
            return i;
_L2:
            j = TPCFHttp.getHTTPRandomPort();
            inUsePorts.add(Integer.valueOf(j));
            i = j;
            if (!TPLog.LOG13.isLoggable(LOG_TAG))
            {
                continue; /* Loop/switch isn't completed */
            }
            Log.d(LOG_TAG, (new StringBuilder()).append("Getting new random port: ").append(j).toString());
            i = j;
            if (true) goto _L5; else goto _L4
_L4:
            Exception exception;
            exception;
            throw exception;
        }

        void releasePort(int i, boolean flag)
        {
            this;
            JVM INSTR monitorenter ;
            if (inUsePorts.contains(Integer.valueOf(i)))
            {
                inUsePorts.remove(Integer.valueOf(i));
                if (TPLog.LOG13.isLoggable(LOG_TAG))
                {
                    Log.d(LOG_TAG, (new StringBuilder()).append("Found the port in inuse, removing it from there: ").append(i).toString());
                }
            }
            if (availablePorts.contains(Integer.valueOf(i)) || !flag)
            {
                break MISSING_BLOCK_LABEL_138;
            }
            availablePorts.add(Integer.valueOf(i));
            if (TPLog.LOG13.isLoggable(LOG_TAG))
            {
                Log.d(LOG_TAG, (new StringBuilder()).append("Adding newly available port to availablePorts : ").append(i).toString());
            }
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        ReusablePorts(int i)
        {
            availablePorts = new Vector();
            inUsePorts = new Vector();
            type = i;
            switch (i)
            {
            default:
                LOG_TAG = "TPCFHttp - Default";
                return;

            case 1: // '\001'
                LOG_TAG = "TPCFHttp - OkHttp";
                return;

            case 0: // '\0'
                LOG_TAG = "TPCFHttp - Java.net";
                return;
            }
        }
    }

    static class TransferStream extends ByteArrayOutputStream
    {

        public ByteArrayInputStream convert()
        {
            return new ByteArrayInputStream(buf, 0, count);
        }

        public TransferStream(int i)
        {
            super(i);
        }
    }


    private static String LOG_TAG = "TPCFHttp";
    private static int TPCFHTTP_ACC_HTTP_PORT_LOW = 10000;
    private static int TPCFHTTP_ACC_HTTP_PORT_RANGESIZE = 2000;
    private static ReusablePorts javaNetReusablePorts = new ReusablePorts(0);
    private static ReusablePorts okhttpReusablePorts = new ReusablePorts(1);
    static boolean tpPolicySuppressLog;
    String address;
    String originAddress;
    URL originURL;
    int port;
    Boolean requested_acceleration;
    boolean shouldAccelerate;
    TPEventLog tpEventLog;
    int type;
    URL url;
    TPVTP vtp;

    TPCFHttp(URL url1, int i)
    {
        originURL = null;
        originAddress = null;
        url = null;
        address = null;
        port = 0;
        originURL = url1;
        originAddress = url1.toString();
        type = i;
        initialize();
    }

    TPCFHttp(URL url1, int i, Boolean boolean1)
    {
        originURL = null;
        originAddress = null;
        url = null;
        address = null;
        port = 0;
        URI uri = getOriginalURI(url1.toURI());
        if (uri != null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        try
        {
            originURL = url1;
            originAddress = url1.toString();
            type = i;
            requested_acceleration = boolean1;
        }
        // Misplaced declaration of an exception variable
        catch (URL url1) { }
        // Misplaced declaration of an exception variable
        catch (URL url1) { }
        initialize();
        return;
        originURL = uri.toURL();
        originAddress = originURL.toString();
        address = url1.toString();
        url = url1;
        port = url1.getPort();
        break MISSING_BLOCK_LABEL_66;
    }

    static int getHTTPRandomPort()
    {
        Random random = new Random();
        return TPCFHTTP_ACC_HTTP_PORT_LOW + random.nextInt(TPCFHTTP_ACC_HTTP_PORT_RANGESIZE);
    }

    protected static URI getOriginalURI(URI uri)
    {
        uri = uri.toString();
        if (uri.indexOf("uri=") <= 0)
        {
            return null;
        }
        int i;
        try
        {
            uri = uri.substring(uri.indexOf("uri=") + 4);
            i = uri.indexOf('&');
        }
        // Misplaced declaration of an exception variable
        catch (URI uri)
        {
            return null;
        }
        if (i <= 0)
        {
            i = uri.length();
        }
        return new URI(URLDecoder.decode(uri.substring(0, i), Charset.defaultCharset().displayName()));
    }

    protected static boolean isRewritten(URI uri)
    {
        if (uri == null)
        {
            return false;
        } else
        {
            return uri.getHost().equalsIgnoreCase(TPControlChannelStateMachine.getInstance().accIPAddrStr);
        }
    }

    int getNextAvailablePort(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        type;
        JVM INSTR tableswitch 1 1: default 52
    //                   1 36;
           goto _L1 _L2
_L1:
        int i = javaNetReusablePorts.getNextAvailablePort(flag);
_L4:
        this;
        JVM INSTR monitorexit ;
        return i;
_L2:
        i = okhttpReusablePorts.getNextAvailablePort(flag);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    void initialize()
    {
        tpEventLog = new TPEventLog();
        shouldAccelerate = TwinPrimeSDKPvt.shouldAccelerate(originURL, tpEventLog, requested_acceleration);
        if (address != null || url != null) goto _L2; else goto _L1
_L1:
        setAcceleratedURL();
_L4:
        initializeEventLog();
        return;
_L2:
        if (!shouldAccelerate)
        {
            address = originAddress;
            url = originURL;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    void initializeEventLog()
    {
        tpEventLog.setUrl(originURL);
        tpEventLog.original_url = originAddress;
        if (shouldAccelerate)
        {
            tpEventLog.is_accelerated = 1;
            tpEventLog.strategy.http_server_port = port;
        } else
        {
            tpEventLog.is_accelerated = 0;
        }
        if (originAddress.equalsIgnoreCase("http://east.t.twinprime.com/touch.html") || TPOptionManager.getPerformanceLogOption() == TPOptionManager.TPOptionPerformanceLog.TPOptionPerformanceLog_disable || !tpPolicySuppressLog)
        {
            tpEventLog.outputctl = false;
            return;
        } else
        {
            tpEventLog.outputctl = true;
            return;
        }
    }

    void releasePort()
    {
        this;
        JVM INSTR monitorenter ;
        if (port == -1) goto _L2; else goto _L1
_L1:
        type;
        JVM INSTR tableswitch 1 1: default 87
    //                   1 57;
           goto _L3 _L4
_L3:
        javaNetReusablePorts.releasePort(port, originURL.getProtocol().equalsIgnoreCase("http"));
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        okhttpReusablePorts.releasePort(port, originURL.getProtocol().equalsIgnoreCase("http"));
        if (true) goto _L2; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }

    void setAcceleratedURL()
    {
        long l;
        l = Long.parseLong("1408066761629000000");
        if (TPLog.LOG13.isLoggable(LOG_TAG))
        {
            Log.d(LOG_TAG, (new StringBuilder()).append("originServerURL [").append(originAddress).append("]").toString());
        }
        if (shouldAccelerate && originURL != null) goto _L2; else goto _L1
_L1:
        address = originAddress;
        url = originURL;
_L12:
        return;
_L2:
        Object obj;
        String s;
        long l1;
        boolean flag;
        obj = URLEncoder.encode(originURL.toString(), "UTF-8");
        flag = originAddress.equalsIgnoreCase("http://east.t.twinprime.com/touch.html");
        l1 = TPControlChannelStateMachine.getInstance().sessionId;
        s = TPControlChannelStateMachine.getInstance().accIPAddrStr;
        if (!flag) goto _L4; else goto _L3
_L3:
        port = (short)getNextAvailablePort(true);
_L16:
        if (!originURL.getProtocol().equals("https")) goto _L6; else goto _L5
_L5:
        address = originAddress;
        url = originURL;
        if (TPOptionManager.getHTTPSProxy() == TPOptionManager.TPOptionHTTPSProxy.TPOptionHTTPSProxy_remote) goto _L8; else goto _L7
_L7:
        int j = originURL.getPort();
        if (j <= 0) goto _L10; else goto _L9
_L9:
        int i = j;
        if (j <= 65535) goto _L11; else goto _L10
_L11:
        releasePort();
        vtp = TPControlChannelStateMachine.getInstance().tpVtpManager.getVtpMapping(originURL.getHost(), (short)i);
        port = TPProxyDaemon.getInstance().getPermProxyPort();
_L8:
        if (TPLog.LOG13.isLoggable(LOG_TAG))
        {
            Log.d(LOG_TAG, (new StringBuilder()).append("accelerated url: ").append(address).toString());
            return;
        }
          goto _L12
        obj;
        if (!TPLog.LOG10.isLoggable(LOG_TAG)) goto _L12; else goto _L13
_L13:
        Log.e(LOG_TAG, ((UnsupportedEncodingException) (obj)).getLocalizedMessage());
        ((UnsupportedEncodingException) (obj)).printStackTrace();
        return;
_L4:
        j = TPOptionManager.getAcceleratorHttpPort();
        i = j;
        if (j > 0) goto _L15; else goto _L14
_L14:
        i = TPControlChannelStateMachine.getInstance().acc_strategy.http_server_port;
          goto _L15
_L19:
        port = (short)i;
          goto _L16
        obj;
        if (!TPLog.LOG10.isLoggable(LOG_TAG)) goto _L12; else goto _L17
_L17:
        ((IOException) (obj)).printStackTrace();
        return;
_L20:
        i = getNextAvailablePort(false);
        break; /* Loop/switch isn't completed */
_L6:
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder(((String) (obj)).length() * 2);
        stringbuilder.append("/?");
        if (TPOptionManager.getSendSessionID() == TPOptionManager.TPOptionSendSessionID.TPOptionSendSessionID_enable)
        {
            stringbuilder.append("sid=");
            stringbuilder.append(l1);
            stringbuilder.append("&");
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_490;
        }
        stringbuilder.append("cmd=warm");
_L18:
        url = new URL("http", s, port, stringbuilder.toString(), null);
        address = url.toString();
          goto _L8
        stringbuilder.append("uri=");
        stringbuilder.append(((String) (obj)));
        stringbuilder.append("&cookie=");
        stringbuilder.append(l);
          goto _L18
_L10:
        i = 443;
          goto _L11
_L15:
        if (i <= 0) goto _L20; else goto _L19
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.twinprime.msgpack.MessageTypeException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.PriorityBlockingQueue;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            XcpMsgInitRep, XcpMsgContextRep, TPOptionManager, TPLog, 
//            TPDiscoveryClient, TPCCNetworkHandler, TPThread, TPControlChannelMessage, 
//            XcpMsgUtils, XcpMsg, TPCache, TPURLConnection, 
//            TPUtility, XcpMsgContextReq, XcpMsgInitReq, XcpMsgSdkOpt, 
//            TwinPrimeSDKPvt, TPAggZip, XcpMsgStrategy, TPCFHttp, 
//            TPEventLog, TPVTPManager, TPOobManager

class TPControlChannelStateMachine extends Thread
{

    private static int nonce = 0;
    private static Thread thread_holder = null;
    private static TPControlChannelStateMachine tpccStateMachine;
    private String accBackupName;
    private InetAddress accIPAddr;
    private ArrayList accIPAddrList;
    String accIPAddrStr;
    TPAggZip accLogsBuf;
    private String accName;
    private int accPort;
    XcpMsgStrategy acc_strategy;
    private long accessIPAddr;
    String accessIPAddrStr;
    private Context appContext;
    TPAggZip bypLogsBuf;
    private String cookie;
    private int customer_id;
    private int discExpirySec;
    private long extIPAddr;
    boolean isDailyActive;
    boolean isMonthlyActive;
    private short portHigh;
    private short portLow;
    PriorityBlockingQueue queue;
    int retries;
    private String sdkKey;
    long sessionId;
    boolean shouldAcceleratePolicy;
    private int state;
    TPOobManager tpOobManager;
    TPVTPManager tpVtpManager;
    TPCCNetworkHandler tpccNetworkHandler;

    TPControlChannelStateMachine()
    {
        queue = new PriorityBlockingQueue(10);
        accIPAddrList = null;
        shouldAcceleratePolicy = true;
        XcpMsgInitRep.addToUtils();
        XcpMsgContextRep.addToUtils();
    }

    static Context getAppContext()
    {
        return getInstance().appContext;
    }

    private boolean getFullUrls(boolean flag)
    {
        while (flag || TPOptionManager.getLogFullURLOption() == TPOptionManager.TPOptionLogFullURL.TPOptionLogFullURL_enable) 
        {
            return true;
        }
        return false;
    }

    public static TPControlChannelStateMachine getInstance()
    {
        com/twinprime/TwinPrimeSDK/TPControlChannelStateMachine;
        JVM INSTR monitorenter ;
        TPControlChannelStateMachine tpcontrolchannelstatemachine;
        if (tpccStateMachine == null)
        {
            tpccStateMachine = new TPControlChannelStateMachine();
        }
        tpcontrolchannelstatemachine = tpccStateMachine;
        com/twinprime/TwinPrimeSDK/TPControlChannelStateMachine;
        JVM INSTR monitorexit ;
        return tpcontrolchannelstatemachine;
        Exception exception;
        exception;
        throw exception;
    }

    private static void log_executionPoint(String s)
    {
        if (TPLog.isNotInTPDevelop())
        {
            return;
        } else
        {
            int i = Thread.currentThread().getStackTrace()[3].getLineNumber();
            String s1 = Thread.currentThread().getStackTrace()[3].getFileName();
            String s2 = Thread.currentThread().getName();
            System.err.println((new StringBuilder()).append(s2).append("_").append(s1).append(": ").append(i).append("  ").append(s).toString());
            return;
        }
    }

    private void privRun()
    {
_L1:
        state;
        JVM INSTR tableswitch 0 6: default 48
    //                   0 51
    //                   1 362
    //                   2 597
    //                   3 742
    //                   4 943
    //                   5 1155
    //                   6 1196;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L2:
        Object obj;
        TPDiscoveryClient.TPDiscState tpdiscstate;
        if (TPLog.LOG2.isLoggable("TPControlChannelSM"))
        {
            TPLog.LOG2.i("TPControlChannelSM", "Initializing Control Channel");
        }
        obj = new TPDiscoveryClient(appContext, sdkKey, accName, customer_id);
        ((TPDiscoveryClient) (obj)).discover();
        tpdiscstate = ((TPDiscoveryClient) (obj)).getDiscoveryState();
        static class _cls1
        {

            static final int $SwitchMap$com$twinprime$TwinPrimeSDK$TPDiscoveryClient$TPDiscState[];

            static 
            {
                $SwitchMap$com$twinprime$TwinPrimeSDK$TPDiscoveryClient$TPDiscState = new int[TPDiscoveryClient.TPDiscState.values().length];
                try
                {
                    $SwitchMap$com$twinprime$TwinPrimeSDK$TPDiscoveryClient$TPDiscState[TPDiscoveryClient.TPDiscState.TPSDK_DISC_COMPLETE_SUCCESS.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$twinprime$TwinPrimeSDK$TPDiscoveryClient$TPDiscState[TPDiscoveryClient.TPDiscState.TPSDK_DISC_ERR.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$twinprime$TwinPrimeSDK$TPDiscoveryClient$TPDiscState[TPDiscoveryClient.TPDiscState.TPSDK_DISC_FATAL_ERR.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.twinprime.TwinPrimeSDK.TPDiscoveryClient.TPDiscState[tpdiscstate.ordinal()];
        JVM INSTR tableswitch 1 3: default 140
    //                   1 233
    //                   2 291
    //                   3 326;
           goto _L9 _L10 _L11 _L12
_L9:
        if (TPLog.LOG13.isLoggable("TPControlChannelSM"))
        {
            Log.d("TPControlChannelSM", (new StringBuilder()).append("Giving up on discovery for now.. unexpected discovery state: ").append(tpdiscstate).toString());
        }
        log_executionPoint("state = ERROR");
        state = 4;
_L13:
        if (TPLog.LOG13.isLoggable("TPControlChannelSM"))
        {
            Log.d("TPControlChannelSM", (new StringBuilder()).append("End of discovery state[").append(state).append("]").toString());
        }
          goto _L1
_L10:
        cookie = ((TPDiscoveryClient) (obj)).getCookie();
        sessionId = ((TPDiscoveryClient) (obj)).getSessionId();
        discExpirySec = Math.max(((TPDiscoveryClient) (obj)).getExpiry(), 60);
        nonce = ((TPDiscoveryClient) (obj)).getNonce();
        accIPAddrList = ((TPDiscoveryClient) (obj)).getAccIPAddrList();
        log_executionPoint("state = DISC_COMPLETED");
        state = 1;
          goto _L13
_L11:
        if (TPLog.LOG2.isLoggable("TPControlChannelSM"))
        {
            TPLog.LOG2.e("TPControlChannelSM", "Discovery failed");
        }
        log_executionPoint("state = ERROR");
        state = 4;
          goto _L13
_L12:
        if (TPLog.LOG2.isLoggable("TPControlChannelSM"))
        {
            TPLog.LOG2.e("TPControlChannelSM", "Discovery failed");
        }
        log_executionPoint("state = FATAL_ERROR");
        state = 5;
          goto _L13
_L3:
        int i = 0;
_L16:
        if (i >= accIPAddrList.size()) goto _L15; else goto _L14
_L14:
        if (tpccNetworkHandler != null)
        {
            tpccNetworkHandler.kill();
        }
        tpccNetworkHandler = new TPCCNetworkHandler((InetAddress)accIPAddrList.get(i), 1514, queue);
        (new TPThread(tpccNetworkHandler)).start();
        accIPAddrStr = ((InetAddress)accIPAddrList.get(i)).getHostAddress();
        accIPAddr = (InetAddress)accIPAddrList.get(i);
_L15:
        Object obj1;
        if (tpccNetworkHandler == null)
        {
            log_executionPoint("state = ERROR");
            state = 4;
        } else
        {
            obj1 = getInitReq();
            ByteBuffer bytebuffer = getContextReq();
            if (!writeMessage(((ByteBuffer) (obj1)), true) || !writeMessage(bytebuffer, true))
            {
                log_executionPoint("state = ERROR");
                state = 4;
            } else
            {
                log_executionPoint("state = INIT_SENT");
                state = 2;
            }
        }
          goto _L1
        obj1;
        tpccNetworkHandler = null;
        if (TPLog.LOG10.isLoggable("TPControlChannelSM"))
        {
            Log.e("TPControlChannelSM", (new StringBuilder()).append("IOException ").append(((IOException) (obj1)).getMessage()).append(" while connecting to the control channel").toString());
        }
        i++;
          goto _L16
_L4:
        obj1 = (TPControlChannelMessage)queue.take();
        if (((TPControlChannelMessage) (obj1)).type != 2) goto _L18; else goto _L17
_L17:
        log_executionPoint("state = ERROR");
        state = 4;
          goto _L1
_L18:
        if (((TPControlChannelMessage) (obj1)).buffer == null) goto _L1; else goto _L19
_L19:
        obj1 = XcpMsgUtils.getInstance().getXcpObjForBytes(((TPControlChannelMessage) (obj1)).buffer.array());
        if (obj1 == null) goto _L21; else goto _L20
_L20:
        try
        {
            ((XcpMsg) (obj1)).process();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            if (TPLog.LOG10.isLoggable("TPControlChannelSM"))
            {
                Log.d("TPControlChannelSM", "TPCcontrolChannelStateMachine interrupted while waiting for INIT_REP");
            }
            log_executionPoint("state = ERROR");
            state = 4;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            if (TPLog.LOG10.isLoggable("TPControlChannelSM"))
            {
                Log.d("TPControlChannelSM", "Error parsing response data");
            }
            log_executionPoint("state = ERROR");
            state = 4;
        }
          goto _L1
_L21:
        log_executionPoint("state = ERROR");
        state = 4;
          goto _L1
_L5:
        obj1 = (TPControlChannelMessage)queue.take();
        if (((TPControlChannelMessage) (obj1)).type != 2) goto _L23; else goto _L22
_L22:
        if (TPLog.LOG11.isLoggable("TPControlChannelSM"))
        {
            Log.d("TPControlChannelSM", "Something happened. Setting state to ERROR");
        }
        log_executionPoint("state = ERROR");
        state = 4;
          goto _L1
_L23:
        if (((TPControlChannelMessage) (obj1)).type != 3) goto _L25; else goto _L24
_L24:
        TPCache.setOkHttpCacheMap();
          goto _L1
_L25:
        if (((TPControlChannelMessage) (obj1)).type != 4) goto _L27; else goto _L26
_L26:
        state = 6;
          goto _L1
_L27:
        obj1 = XcpMsgUtils.getInstance().getXcpObjForBytes(((TPControlChannelMessage) (obj1)).buffer.array());
        if (obj1 != null)
        {
            try
            {
                ((XcpMsg) (obj1)).process();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                if (TPLog.LOG10.isLoggable("TPControlChannelSM"))
                {
                    Log.d("TPControlChannelSM", (new StringBuilder()).append("TPCcontrolChannelStateMachine interrupted [").append(state).append("]").toString());
                }
                log_executionPoint("state = ERROR");
                state = 4;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                if (TPLog.LOG10.isLoggable("TPControlChannelSM"))
                {
                    Log.d("TPControlChannelSM", "Error parsing response data");
                }
                log_executionPoint("state = ERROR");
                state = 4;
            }
        }
          goto _L1
_L6:
        queue = new PriorityBlockingQueue(10);
        if (tpccNetworkHandler != null)
        {
            tpccNetworkHandler.kill();
        }
        if (retries <= 0) goto _L29; else goto _L28
_L28:
        if (TPLog.LOG2.isLoggable("TPControlChannelSM"))
        {
            TPLog.LOG2.w("TPControlChannelSM", "Initialization failed:  Will retry later.");
        }
        this;
        JVM INSTR monitorenter ;
        sleep(1000L);
        this;
        JVM INSTR monitorexit ;
_L30:
        log_executionPoint("state = INIT");
        state = 0;
        retries = retries - 1;
          goto _L1
        obj1;
        this;
        JVM INSTR monitorexit ;
        try
        {
            throw obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1) { }
          goto _L30
_L29:
        if (TPLog.LOG2.isLoggable("TPControlChannelSM"))
        {
            TPLog.LOG2.w("TPControlChannelSM", "Initialization failed");
        }
        this;
        JVM INSTR monitorenter ;
        wait();
        retries = 3;
        log_executionPoint("state = INIT");
        state = 0;
        this;
        JVM INSTR monitorexit ;
          goto _L1
        obj1;
        this;
        JVM INSTR monitorexit ;
        try
        {
            throw obj1;
        }
        catch (InterruptedException interruptedexception) { }
        if (TPLog.LOG10.isLoggable("TPControlChannelSM"))
        {
            Log.d("TPControlChannelSM", (new StringBuilder()).append("TPCcontrolChannelStateMachine interrupted [").append(state).append("]").toString());
        }
        log_executionPoint("state = ERROR");
        state = 4;
          goto _L1
_L7:
        if (tpccNetworkHandler != null)
        {
            tpccNetworkHandler.kill();
        }
        tpccStateMachine = null;
        if (TPLog.LOG1.isLoggable("TPControlChannelSM"))
        {
            TPLog.LOG1.e("TPControlChannelSM", "Initialization failed");
        }
_L32:
        return;
_L8:
        if (tpccNetworkHandler != null)
        {
            tpccNetworkHandler.kill();
        }
        tpccStateMachine = null;
        if (TPLog.LOG13.isLoggable("TPControlChannelSM"))
        {
            Log.d("TPControlChannelSM", "TPCcontrolChannelStateMachine stopped");
            return;
        }
        if (true) goto _L32; else goto _L31
_L31:
    }

    private void startWarmConnections(int i)
    {
        byte abyte0[];
        ArrayList arraylist;
        int j;
        if (TPLog.LOG10.isLoggable("TPControlChannelSM"))
        {
            Log.i("TPControlChannelSM", (new StringBuilder()).append("Starting java.net warm connections ").append(i).toString());
        }
        abyte0 = new byte[1000];
        arraylist = new ArrayList();
        j = 0;
_L2:
        if (j >= i)
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add((HttpURLConnection)TPURLConnection.openConnection("http://east.t.twinprime.com/touch.html", true));
        j++;
        if (true) goto _L2; else goto _L1
_L8:
        if (j >= i) goto _L4; else goto _L3
_L3:
        Object obj = (HttpURLConnection)arraylist.get(j);
        InputStream inputstream;
        for (inputstream = ((HttpURLConnection) (obj)).getInputStream(); inputstream.read(abyte0) != -1;) { }
        inputstream.close();
_L6:
        if (TPLog.LOG10.isLoggable("TPControlChannelSM"))
        {
            Log.i("TPControlChannelSM", (new StringBuilder()).append("Warm connection-").append(j + 1).append(" is set up").toString());
        }
          goto _L5
        Exception exception1;
        exception1;
        for (obj = ((HttpURLConnection) (obj)).getErrorStream(); ((InputStream) (obj)).read(abyte0) != -1;) { }
        ((InputStream) (obj)).close();
        if (TPLog.LOG13.isLoggable("TPControlChannelSM"))
        {
            Log.e("TPControlChannelSM", (new StringBuilder()).append("Exception with warm connection-").append(j + 1).append(" url: ").append("http://east.t.twinprime.com/touch.html").toString());
            exception1.printStackTrace();
        }
          goto _L6
        Exception exception;
        exception;
        if (TPLog.LOG10.isLoggable("TPControlChannelSM"))
        {
            exception.printStackTrace();
        }
_L4:
        return;
_L1:
        j = 0;
        continue; /* Loop/switch isn't completed */
_L5:
        j++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    static boolean writeMessage(ByteBuffer bytebuffer)
    {
        return writeMessage(bytebuffer, false);
    }

    private static boolean writeMessage(ByteBuffer bytebuffer, boolean flag)
    {
        if (TPLog.LOG13.isLoggable("TPControlChannelSM"))
        {
            Log.d("TPControlChannelSM", (new StringBuilder()).append("Writing ").append(bytebuffer.capacity()).append(" bytes.").toString());
        }
        if (flag || getInstance().state == 3)
        {
            flag = getInstance().tpccNetworkHandler.queueMessage(bytebuffer);
            if (TPLog.LOG13.isLoggable("TPControlChannelSM"))
            {
                Log.d("TPControlChannelSM", (new StringBuilder()).append("written: ").append(flag).toString());
            }
            return flag;
        } else
        {
            return false;
        }
    }

    ByteBuffer getContextReq()
    {
        TPUtility tputility = TPUtility.getInstance();
        tputility.initDeviceInfo(appContext);
        return ByteBuffer.wrap(tputility.getXcpMsgContextReq().getMessage());
    }

    ByteBuffer getInitReq()
    {
        String s;
        XcpMsgInitReq xcpmsginitreq;
        boolean flag = true;
        setDailyMonthlyActive();
        xcpmsginitreq = new XcpMsgInitReq();
        xcpmsginitreq.sid = sessionId;
        int i;
        if (isMonthlyActive)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        xcpmsginitreq.monthly_active = i;
        if (isDailyActive)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        xcpmsginitreq.daily_active = i;
        xcpmsginitreq.app_id = appContext.getPackageName();
        xcpmsginitreq.app_name = appContext.getApplicationInfo().loadLabel(appContext.getPackageManager()).toString();
        xcpmsginitreq.sdk_version = "1.18.0.1";
        xcpmsginitreq.cookie = cookie;
        xcpmsginitreq.expiry = discExpirySec;
        xcpmsginitreq.sdk_options = new XcpMsgSdkOpt();
        xcpmsginitreq.nonce = nonce;
        xcpmsginitreq.app_guid = TwinPrimeSDKPvt.getInstance().getAppGuid();
        if (appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0).versionName == null) goto _L2; else goto _L1
_L1:
        s = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0).versionName;
_L3:
        xcpmsginitreq.app_version = s;
_L4:
        if (TPLog.LOG13.isLoggable("TPControlChannelSM"))
        {
            Log.d("TPControlChannelSM", xcpmsginitreq.toString());
        }
        return ByteBuffer.wrap(xcpmsginitreq.getMessage());
_L2:
        s = "";
          goto _L3
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        xcpmsginitreq.app_version = "";
          goto _L4
    }

    int getStateMachineState()
    {
        return state;
    }

    void initWithKey(Context context, String s, String s1, String s2, int i, int j)
    {
        appContext = context;
        sdkKey = s;
        accName = s1;
        accBackupName = s2;
        accPort = i;
        customer_id = j;
        accLogsBuf = new TPAggZip("acc-logs", 4000, 2);
        bypLogsBuf = new TPAggZip("byp-logs", 4000, 2);
        retries = 3;
        log_executionPoint("state = INIT");
        state = 0;
    }

    boolean isReady()
    {
        return state == 3;
    }

    void poke()
    {
        if (tpccStateMachine == null)
        {
            return;
        }
        this;
        JVM INSTR monitorenter ;
        if (state == 4)
        {
            notify();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void processContextRep(XcpMsgContextRep xcpmsgcontextrep)
    {
        if (TPLog.LOG13.isLoggable("TPControlChannelSM"))
        {
            TPLog.LOG13.d("TPControlChannelSM", xcpmsgcontextrep.toString());
        }
        if (xcpmsgcontextrep.strategy.bypass == 1)
        {
            xcpmsgcontextrep.strategy.warm_connections_okhttp = 0;
            xcpmsgcontextrep.strategy.warm_connections = 0;
        }
        if (xcpmsgcontextrep.strategy.warm_connections > 20)
        {
            xcpmsgcontextrep.strategy.warm_connections = 20;
        }
        if (xcpmsgcontextrep.strategy.warm_connections_okhttp > 20)
        {
            xcpmsgcontextrep.strategy.warm_connections_okhttp = 20;
        }
        acc_strategy = xcpmsgcontextrep.strategy;
        int i;
        int j;
        boolean flag;
        if (xcpmsgcontextrep.strategy.bypass != 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        shouldAcceleratePolicy = flag;
        TPLog.setPolicyLogLevel(xcpmsgcontextrep.strategy.trace_level);
        if (xcpmsgcontextrep.strategy.suppress_log != 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        TPCFHttp.tpPolicySuppressLog = flag;
        i = xcpmsgcontextrep.strategy.agg_acc_log_sec;
        accLogsBuf.secThreshold = i;
        i = xcpmsgcontextrep.strategy.agg_byp_log_sec;
        bypLogsBuf.secThreshold = i;
        if (xcpmsgcontextrep.strategy.log_full_url == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        TPEventLog.tpPolicyLogFullURL = getFullUrls(flag);
        if (TPOptionManager.getCache() == TPOptionManager.TPOptionCache.TPOptionCache_enable)
        {
            TPCache.installHttpResponseCache();
        }
        if (TPLog.LOG2.isLoggable("TPControlChannelSM"))
        {
            String s = (new StringBuilder()).append("Initialization complete: begin accelerating requests (").append(accIPAddrStr).append(":").append(sessionId).append(")").toString();
            TPLog.LOG2.i("TPControlChannelSM", s);
        }
        retries = 3;
        log_executionPoint("state = COMPLETED_SUCCESS");
        state = 3;
        i = xcpmsgcontextrep.strategy.warm_connections;
        j = xcpmsgcontextrep.strategy.warm_connections_okhttp;
        if (i != 0)
        {
            startWarmConnections(i);
        }
        if (j == 0)
        {
            break MISSING_BLOCK_LABEL_385;
        }
        if (TPLog.LOG13.isLoggable("TPControlChannelSM"))
        {
            Log.d("TPControlChannelSM", "See if we need okhttp client warm connections");
        }
        Class.forName("com.twinprime.TwinPrimeSDK.TPOkHttpClient").getMethod("startWarmConnections", new Class[] {
            java/lang/Integer
        }).invoke(null, new Object[] {
            Integer.valueOf(j)
        });
_L2:
        return;
        xcpmsgcontextrep;
        if (!TPLog.LOG13.isLoggable("TPControlChannelSM")) goto _L2; else goto _L1
_L1:
        Log.d("TPControlChannelSM", (new StringBuilder()).append("Exception: ").append(xcpmsgcontextrep.getClass().getName()).toString());
        Log.d("TPControlChannelSM", "Will not attempt to create okhttp warm connections");
        return;
        xcpmsgcontextrep;
        if (!TPLog.LOG13.isLoggable("TPControlChannelSM")) goto _L2; else goto _L3
_L3:
        Log.d("TPControlChannelSM", (new StringBuilder()).append("Exception: ").append(xcpmsgcontextrep.getClass().getName()).toString());
        Log.d("TPControlChannelSM", "Will not attempt to create okhttp warm connections");
        return;
        xcpmsgcontextrep;
        if (TPLog.LOG13.isLoggable("TPControlChannelSM"))
        {
            Log.d("TPControlChannelSM", (new StringBuilder()).append("Exception: ").append(xcpmsgcontextrep.getClass().getName()).toString());
            Log.d("TPControlChannelSM", "Will not attempt to create okhttp warm connections");
            return;
        }
          goto _L2
    }

    void processInitRep(XcpMsgInitRep xcpmsginitrep)
    {
        if (TPLog.LOG13.isLoggable("TPControlChannelSM"))
        {
            Log.d("TPControlChannelSM", xcpmsginitrep.toString());
        }
        sessionId = xcpmsginitrep.sid;
        portLow = xcpmsginitrep.nat_port_low;
        portHigh = xcpmsginitrep.nat_port_high;
        extIPAddr = xcpmsginitrep.nat_ipaddr;
        accessIPAddr = xcpmsginitrep.access_ipaddr;
        accessIPAddrStr = String.format("%d.%d.%d.%d", new Object[] {
            Long.valueOf((accessIPAddr & 0xffffffffff000000L) >> 24), Long.valueOf((accessIPAddr & 0xff0000L) >> 16), Long.valueOf((accessIPAddr & 65280L) >> 8), Long.valueOf(accessIPAddr & 255L)
        });
        if (xcpmsginitrep.status != 1)
        {
            if (TPLog.LOG10.isLoggable("TPControlChannelSM"))
            {
                TPLog.LOG10.e("TPControlChannelSM", (new StringBuilder()).append("ERROR: InitRep received with status ").append(xcpmsginitrep.status).toString());
            }
            log_executionPoint("state = ERROR");
            state = 4;
        } else
        if (xcpmsginitrep.status == 1 && sessionId != 0L)
        {
            if (portLow > 0 && portHigh > 0)
            {
                tpVtpManager = new TPVTPManager();
                tpVtpManager.init(portLow, portHigh);
            }
            tpOobManager = new TPOobManager();
            return;
        }
    }

    public void run()
    {
        Thread.currentThread().setName("TPControlChannelSM");
        try
        {
            privRun();
            return;
        }
        catch (Throwable throwable)
        {
            state = 5;
        }
        if (tpccNetworkHandler != null)
        {
            tpccNetworkHandler.kill();
        }
        TwinPrimeSDKPvt.disableSDK();
    }

    void setDailyMonthlyActive()
    {
        boolean flag2 = true;
        boolean flag = true;
        Object obj = appContext.getSharedPreferences("com.twinprime.preferences", 0);
        String s1 = ((SharedPreferences) (obj)).getString("monthlyactive", null);
        if (TPLog.LOG13.isLoggable("TPControlChannelSM"))
        {
            Log.d("TPControlChannelSM", (new StringBuilder()).append("isMonthlyActive cookie: ").append(s1).toString());
        }
        String s = (new SimpleDateFormat("MM-dd-yyyy")).format(new Date());
        if (s1 == null)
        {
            isDailyActive = true;
            isMonthlyActive = true;
        } else
        {
            String s2 = (new SimpleDateFormat("MM-yyyy")).format(new Date());
            String as[] = s1.split("-");
            if (as.length < 3)
            {
                isDailyActive = true;
                if (s1.equals(s2))
                {
                    flag = false;
                }
                isMonthlyActive = flag;
            } else
            {
                boolean flag1;
                if (!s1.equals(s))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                isDailyActive = flag1;
                if (!s2.equals((new StringBuilder()).append(as[0]).append("-").append(as[2]).toString()))
                {
                    flag1 = flag2;
                } else
                {
                    flag1 = false;
                }
                isMonthlyActive = flag1;
            }
        }
        if (isDailyActive)
        {
            obj = ((SharedPreferences) (obj)).edit();
            ((android.content.SharedPreferences.Editor) (obj)).putString("monthlyactive", s);
            ((android.content.SharedPreferences.Editor) (obj)).commit();
        }
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            XcpMsgAddReq, TPLog, TPControlChannelStateMachine, TPVTP, 
//            XcpMsgStrategy, TwinPrimeSDKPvt

public class TPVTPManager
{
    class TPVTPTimer extends TimerTask
    {

        final TPVTPManager this$0;
        TPVTP tpvtp;

        private void privRun()
        {
            removeVtp(tpvtp);
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

        TPVTPTimer(TPVTP tpvtp1)
        {
            this$0 = TPVTPManager.this;
            super();
            tpvtp = tpvtp1;
        }
    }


    private static TPVTPManager tpvtpManager;
    private ArrayList availableVTP;
    private HashMap reflectorNatFwdingTable;
    Timer timer;

    public TPVTPManager()
    {
    }

    static TPVTPManager getInstance()
    {
        if (tpvtpManager == null)
        {
            tpvtpManager = new TPVTPManager();
        }
        return tpvtpManager;
    }

    private void pushVtp(short word0)
    {
        availableVTP.add(Short.valueOf(word0));
    }

    private void sendAddReq(short word0, long l, short word1, String s)
        throws IOException
    {
        if (word0 != 0)
        {
            XcpMsgAddReq xcpmsgaddreq = new XcpMsgAddReq();
            xcpmsgaddreq.nat_port = word0;
            xcpmsgaddreq.origin_ipaddr = 0L;
            xcpmsgaddreq.origin_port = word1;
            xcpmsgaddreq.dns_name = s;
            xcpmsgaddreq.dns_name_len = s.length();
            if (TPLog.LOG13.isLoggable("TPVTPManager"))
            {
                Log.d("TPVTPManager", (new StringBuilder()).append("xcpMsgAddReq: ").append(xcpmsgaddreq.toString()).toString());
            }
            TPControlChannelStateMachine.writeMessage(ByteBuffer.wrap(xcpmsgaddreq.getMessage()));
        }
    }

    TPVTP getVtpMapping(String s, short word0)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        short word1 = 0;
        TPVTP tpvtp;
        if (TPLog.LOG13.isLoggable("TPVTPManager"))
        {
            Log.d("TPVTPManager", "getVtpMapping starts");
            Log.d("TPVTPManager", (new StringBuilder()).append("reflectorNatFwdingTable.size(): ").append(reflectorNatFwdingTable.size()).toString());
        }
        tpvtp = (TPVTP)reflectorNatFwdingTable.get(s);
        if (tpvtp != null) goto _L2; else goto _L1
_L1:
        tpvtp = new TPVTP();
        tpvtp.host = s;
        tpvtp.nat_port = popVtp();
        if (tpvtp.nat_port != 0) goto _L4; else goto _L3
_L3:
        tpvtp = null;
_L7:
        sendAddReq(word1, 0L, word0, s);
_L5:
        if (TPLog.LOG13.isLoggable("TPVTPManager"))
        {
            Log.d("TPVTPManager", (new StringBuilder()).append("popVtp ends: ").append(tpvtp.refcount).toString());
            Log.d("TPVTPManager", "getVtpMapping ends");
        }
        this;
        JVM INSTR monitorexit ;
        return tpvtp;
_L4:
        tpvtp.refcount = 1;
        if (TPLog.LOG13.isLoggable("TPVTPManager"))
        {
            Log.d("TPVTPManager", (new StringBuilder()).append("fwd table add (").append(s).append(" , ").append(tpvtp).append(")").toString());
        }
        reflectorNatFwdingTable.put(s, tpvtp);
        word1 = tpvtp.nat_port;
        continue; /* Loop/switch isn't completed */
_L2:
        if (TPLog.LOG13.isLoggable("TPVTPManager"))
        {
            Log.d("TPVTPManager", (new StringBuilder()).append(" recycling vtp: ").append(tpvtp).toString());
        }
        tpvtp.refcount = tpvtp.refcount + 1;
          goto _L5
        s;
        throw s;
        if (true) goto _L7; else goto _L6
_L6:
    }

    void init(short word0, short word1)
    {
        availableVTP = new ArrayList();
        for (; word0 <= word1; word0++)
        {
            pushVtp(word0);
        }

        reflectorNatFwdingTable = new HashMap(100);
    }

    short popVtp()
    {
        short word0 = 0;
        this;
        JVM INSTR monitorenter ;
        int i;
        if (TPLog.LOG13.isLoggable("TPVTPManager"))
        {
            Log.d("TPVTPManager", "popVtp starts");
            Log.d("TPVTPManager", (new StringBuilder()).append("availableVTP.size(): ").append(availableVTP.size()).toString());
        }
        i = availableVTP.size();
        if (i != 0) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return word0;
_L2:
        short word1;
        word1 = ((Short)availableVTP.get(0)).shortValue();
        availableVTP.remove(0);
        word0 = word1;
        if (!TPLog.LOG13.isLoggable("TPVTPManager"))
        {
            continue; /* Loop/switch isn't completed */
        }
        Log.d("TPVTPManager", (new StringBuilder()).append("vtp: ").append(word1).toString());
        word0 = word1;
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    void releaseVtp(TPVTP tpvtp)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        timer = new Timer();
        if (TPControlChannelStateMachine.getInstance().acc_strategy.vtp_timeout_sec <= 0)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        i = TPControlChannelStateMachine.getInstance().acc_strategy.vtp_timeout_sec;
_L1:
        timer.schedule(new TPVTPTimer(tpvtp), i * 1000);
        this;
        JVM INSTR monitorexit ;
        return;
        i = 60;
          goto _L1
        tpvtp;
        throw tpvtp;
    }

    void removeVtp(TPVTP tpvtp)
    {
        this;
        JVM INSTR monitorenter ;
        short word0;
        tpvtp.refcount = tpvtp.refcount - 1;
        if (tpvtp.refcount != 0)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        if (TPLog.LOG13.isLoggable("TPVTPManager"))
        {
            Log.d("TPVTPManager", (new StringBuilder()).append("remove fwd entry for vtp:").append(tpvtp).toString());
        }
        word0 = tpvtp.nat_port;
        reflectorNatFwdingTable.remove(tpvtp.host);
        pushVtp(tpvtp.nat_port);
        sendAddReq(word0, 0L, (short)0, "");
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        tpvtp;
        if (TPLog.LOG10.isLoggable("TPVTPManager"))
        {
            TPLog.LOG10.d("TPVTPManager", tpvtp.getMessage());
        }
        if (true) goto _L2; else goto _L1
_L1:
        tpvtp;
        throw tpvtp;
    }
}

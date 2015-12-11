// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import java.util.Hashtable;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            XcpMsg, XcpMsgUtils, TPLog

class XcpMsgDiscRep extends XcpMsg
{

    static final Long DISC_REP_ACC_IPADDR = Long.valueOf(4L);
    static final Long DISC_REP_ACC_IPADDR_OBS = Long.valueOf(2L);
    static final Long DISC_REP_COOKIE = Long.valueOf(1L);
    static final Long DISC_REP_EXPIRY = Long.valueOf(3L);
    static final Long DISC_REP_MAX_PAYLOAD_FORMAT = Long.valueOf(7L);
    static final Long DISC_REP_MAX_XCP_VERSION = Long.valueOf(6L);
    static final Long DISC_REP_REGION = Long.valueOf(5L);
    static final Long DISC_REP_SID = Long.valueOf(0L);
    long accIpAddrs[];
    String cookie;
    int expiry;
    int ipAddrCt;
    long ipAddrObs;
    long sessionId;

    XcpMsgDiscRep(Hashtable hashtable)
    {
        cookie = (String)hashtable.get(DISC_REP_COOKIE);
        sessionId = XcpMsgUtils.getLongFromMap(hashtable, DISC_REP_SID);
        expiry = XcpMsgUtils.getIntFromMap(hashtable, DISC_REP_EXPIRY);
        ipAddrObs = XcpMsgUtils.getIntFromMap(hashtable, DISC_REP_ACC_IPADDR_OBS);
        accIpAddrs = XcpMsgUtils.getlongArrayFromMap(hashtable, DISC_REP_ACC_IPADDR);
        ipAddrCt = accIpAddrs.length;
    }

    public void process()
    {
    }

    public String toDebugString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append((new StringBuilder()).append("XcpMsgDiscRep:\n\tsessionId [").append(sessionId).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tipAddrObs [").append(ipAddrObs).append("]").toString());
        for (int i = 0; i < ipAddrCt; i++)
        {
            stringbuffer.append((new StringBuilder()).append("\n\taccIpAddr[").append(i).append("] [").append(accIpAddrs[i]).append("]").toString());
        }

        stringbuffer.append((new StringBuilder()).append("\n\tipAddrCt [").append(ipAddrCt).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\texpiry [").append(expiry).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tcookie [").append(cookie).append("]").toString());
        return stringbuffer.toString();
    }

    public String toString()
    {
        if (TPLog.LOG13.isLoggable("XCP"))
        {
            return toDebugString();
        } else
        {
            return super.toString();
        }
    }

}

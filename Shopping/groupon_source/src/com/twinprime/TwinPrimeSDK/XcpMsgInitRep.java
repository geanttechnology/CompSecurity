// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import java.util.Hashtable;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            XcpMsg, XcpMsgUtils, TPControlChannelStateMachine, TPLog

class XcpMsgInitRep extends XcpMsg
{
    private static class FactoryWorker
        implements XcpMsgUtils.XcpMsgCreator
    {

        public XcpMsg createXcpMsgFromMap(Hashtable hashtable)
        {
            return new XcpMsgInitRep(hashtable);
        }

        private FactoryWorker()
        {
        }

    }


    private static final Long INIT_RESP_ACCESS_IP = Long.valueOf(6L);
    private static final Long INIT_RESP_NAT_IPADDR = Long.valueOf(3L);
    private static final Long INIT_RESP_NAT_PORT_HIGH = Long.valueOf(2L);
    private static final Long INIT_RESP_NAT_PORT_LOW = Long.valueOf(1L);
    private static final Long INIT_RESP_SID = Long.valueOf(0L);
    private static final Long INIT_RESP_STATUS = Long.valueOf(5L);
    private static final Long INIT_RESP_TSECR = Long.valueOf(4L);
    long access_ipaddr;
    long nat_ipaddr;
    short nat_port_high;
    short nat_port_low;
    long sid;
    int status;

    XcpMsgInitRep()
    {
    }

    XcpMsgInitRep(Hashtable hashtable)
    {
        status = XcpMsgUtils.getIntFromMap(hashtable, INIT_RESP_STATUS);
        nat_port_low = (short)XcpMsgUtils.getIntFromMap(hashtable, INIT_RESP_NAT_PORT_LOW);
        nat_port_high = (short)XcpMsgUtils.getIntFromMap(hashtable, INIT_RESP_NAT_PORT_HIGH);
        nat_ipaddr = XcpMsgUtils.getLongFromMap(hashtable, INIT_RESP_NAT_IPADDR);
        sid = XcpMsgUtils.getLongFromMap(hashtable, INIT_RESP_SID);
        access_ipaddr = XcpMsgUtils.getLongFromMap(hashtable, INIT_RESP_ACCESS_IP);
    }

    static void addToUtils()
    {
        XcpMsgUtils.addXcpType(2, new FactoryWorker());
    }

    void process()
    {
        TPControlChannelStateMachine.getInstance().processInitRep(this);
    }

    public String toDebugString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append((new StringBuilder()).append("XcpMsgInitRep:\n\tstatus [").append(status).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tnat_port_low [").append(nat_port_low).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tnat_port_high [").append(nat_port_high).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tnat_ipaddr [").append(nat_ipaddr).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tsid [").append(sid).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tnat_ipaddr [").append(access_ipaddr).append("]").toString());
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

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import java.util.Hashtable;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            XcpMsgUtils, JNILibrary, TPLog

class XcpMsgAddReq
{

    String dns_name;
    long dns_name_len;
    Hashtable map;
    short nat_port;
    long origin_ipaddr;
    short origin_port;

    XcpMsgAddReq()
    {
        dns_name = "";
    }

    byte[] getMessage()
    {
        map = new Hashtable();
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(0), Long.valueOf(origin_ipaddr));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(1), Short.valueOf(origin_port));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(2), Short.valueOf(nat_port));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(4), Long.valueOf(dns_name_len));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(5), dns_name);
        return JNILibrary.encodeMessage(map, 3, true);
    }

    public String toDebugString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append((new StringBuilder()).append("XcpMsgAddReq:\n\torigin_ipaddr [").append(origin_ipaddr).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\torigin_port [").append(origin_port).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tnat_port [").append(nat_port).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tdns_name_len [").append(dns_name_len).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tdns_name [").append(dns_name).append("]").toString());
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

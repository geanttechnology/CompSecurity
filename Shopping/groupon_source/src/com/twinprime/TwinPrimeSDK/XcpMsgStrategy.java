// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import java.util.Hashtable;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            XcpMsgUtils, TPLog

class XcpMsgStrategy
    implements Cloneable
{

    static final Long STRATEGY_AGG_ACC_LONG_SEC = Long.valueOf(9L);
    static final Long STRATEGY_AGG_BYP_LOG_SEC = Long.valueOf(10L);
    static final Long STRATEGY_BYPASS = Long.valueOf(1L);
    static final Long STRATEGY_DEF_REQ_TIMEOUT_MS = Long.valueOf(8L);
    static final Long STRATEGY_HTTP_SERVER_PORT = Long.valueOf(0L);
    static final Long STRATEGY_LOG_FULL_URL = Long.valueOf(13L);
    static final Long STRATEGY_LOG_HTTPS_URL = Long.valueOf(12L);
    static final Long STRATEGY_MIN_REQ_TIMEOUT_MS = Long.valueOf(7L);
    static final Long STRATEGY_OOB_ACK = Long.valueOf(3L);
    static final Long STRATEGY_OOB_PROVISIONAL = Long.valueOf(6L);
    static final Long STRATEGY_SUPPRESS_LOG = Long.valueOf(4L);
    static final Long STRATEGY_TRACE_LEVEL = Long.valueOf(2L);
    static final Long STRATEGY_VTP_TIMEOUT_SEC = Long.valueOf(11L);
    static final Long STRATEGY_WARM_CONNECTIONS = Long.valueOf(5L);
    static final Long STRATEGY_WARM_CONNECTIONS_OKHTTP = Long.valueOf(14L);
    int agg_acc_log_sec;
    int agg_byp_log_sec;
    int bypass;
    int def_req_timeout_ms;
    int http_server_port;
    int log_full_url;
    int log_https_url;
    Hashtable map;
    int min_req_timeout_ms;
    int oob_ack;
    int oob_provisional;
    int suppress_log;
    int trace_level;
    int vtp_timeout_sec;
    int warm_connections;
    int warm_connections_okhttp;

    XcpMsgStrategy()
    {
    }

    XcpMsgStrategy(Hashtable hashtable)
    {
        http_server_port = XcpMsgUtils.getIntFromMap(hashtable, STRATEGY_HTTP_SERVER_PORT);
        bypass = XcpMsgUtils.getIntFromMap(hashtable, STRATEGY_BYPASS);
        trace_level = XcpMsgUtils.getIntFromMap(hashtable, STRATEGY_TRACE_LEVEL);
        oob_ack = XcpMsgUtils.getIntFromMap(hashtable, STRATEGY_OOB_ACK);
        suppress_log = XcpMsgUtils.getIntFromMap(hashtable, STRATEGY_SUPPRESS_LOG);
        warm_connections = XcpMsgUtils.getIntFromMap(hashtable, STRATEGY_WARM_CONNECTIONS);
        oob_provisional = XcpMsgUtils.getIntFromMap(hashtable, STRATEGY_OOB_PROVISIONAL);
        min_req_timeout_ms = XcpMsgUtils.getIntFromMap(hashtable, STRATEGY_MIN_REQ_TIMEOUT_MS);
        def_req_timeout_ms = XcpMsgUtils.getIntFromMap(hashtable, STRATEGY_DEF_REQ_TIMEOUT_MS);
        agg_acc_log_sec = XcpMsgUtils.getIntFromMap(hashtable, STRATEGY_AGG_ACC_LONG_SEC);
        agg_byp_log_sec = XcpMsgUtils.getIntFromMap(hashtable, STRATEGY_AGG_BYP_LOG_SEC);
        vtp_timeout_sec = XcpMsgUtils.getIntFromMap(hashtable, STRATEGY_VTP_TIMEOUT_SEC);
        log_https_url = XcpMsgUtils.getIntFromMap(hashtable, STRATEGY_LOG_HTTPS_URL);
        log_full_url = XcpMsgUtils.getIntFromMap(hashtable, STRATEGY_LOG_FULL_URL);
        warm_connections_okhttp = XcpMsgUtils.getIntFromMap(hashtable, STRATEGY_WARM_CONNECTIONS_OKHTTP);
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return super.clone();
    }

    Hashtable getMap()
    {
        map = new Hashtable();
        XcpMsgUtils.conditionalAdd(map, STRATEGY_HTTP_SERVER_PORT, Integer.valueOf(http_server_port));
        XcpMsgUtils.conditionalAdd(map, STRATEGY_BYPASS, Integer.valueOf(bypass));
        XcpMsgUtils.conditionalAdd(map, STRATEGY_TRACE_LEVEL, Integer.valueOf(trace_level));
        XcpMsgUtils.conditionalAdd(map, STRATEGY_OOB_ACK, Integer.valueOf(oob_ack));
        XcpMsgUtils.conditionalAdd(map, STRATEGY_SUPPRESS_LOG, Integer.valueOf(suppress_log));
        XcpMsgUtils.conditionalAdd(map, STRATEGY_WARM_CONNECTIONS, Integer.valueOf(warm_connections));
        XcpMsgUtils.conditionalAdd(map, STRATEGY_OOB_PROVISIONAL, Integer.valueOf(oob_provisional));
        XcpMsgUtils.conditionalAdd(map, STRATEGY_MIN_REQ_TIMEOUT_MS, Integer.valueOf(min_req_timeout_ms));
        XcpMsgUtils.conditionalAdd(map, STRATEGY_DEF_REQ_TIMEOUT_MS, Integer.valueOf(def_req_timeout_ms));
        XcpMsgUtils.conditionalAdd(map, STRATEGY_AGG_ACC_LONG_SEC, Integer.valueOf(agg_acc_log_sec));
        XcpMsgUtils.conditionalAdd(map, STRATEGY_AGG_BYP_LOG_SEC, Integer.valueOf(agg_byp_log_sec));
        XcpMsgUtils.conditionalAdd(map, STRATEGY_VTP_TIMEOUT_SEC, Integer.valueOf(vtp_timeout_sec));
        XcpMsgUtils.conditionalAdd(map, STRATEGY_LOG_HTTPS_URL, Integer.valueOf(log_https_url));
        XcpMsgUtils.conditionalAdd(map, STRATEGY_LOG_FULL_URL, Integer.valueOf(log_full_url));
        XcpMsgUtils.conditionalAdd(map, STRATEGY_WARM_CONNECTIONS_OKHTTP, Integer.valueOf(warm_connections_okhttp));
        return map;
    }

    public String toDebugString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append((new StringBuilder()).append("\t\tXcpMsgStrategy:\n\t\t\thttp_server_port [").append(http_server_port).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\t\t\tbypass [").append(bypass).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\t\t\ttrace_level [").append(trace_level).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\t\t\toob_ack [").append(oob_ack).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\t\t\tsuppress_log [").append(suppress_log).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\t\t\twarm_connections [").append(warm_connections).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\t\t\toob_provisional [").append(oob_provisional).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\t\t\tmin_req_timeout_ms [").append(min_req_timeout_ms).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\t\t\tdef_req_timeout_ms [").append(def_req_timeout_ms).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\t\t\tagg_acc_log_sec [").append(agg_acc_log_sec).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\t\t\tagg_byp_log_sec [").append(agg_byp_log_sec).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\t\t\tvtp_timeout_sec [").append(vtp_timeout_sec).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\t\t\tlog_https_url [").append(log_https_url).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\t\t\tlog_full_url [").append(log_full_url).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\t\t\twarm_connections_okhttp [").append(warm_connections_okhttp).append("]").toString());
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

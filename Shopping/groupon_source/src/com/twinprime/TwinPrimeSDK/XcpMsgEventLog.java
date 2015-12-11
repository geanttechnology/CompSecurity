// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import java.util.Hashtable;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            XcpMsgUtils, XcpMsgStrategy, JNILibrary, TPLog

class XcpMsgEventLog
    implements Cloneable
{

    String bypass_reason;
    int bytes_downloaded;
    int connection_open_time;
    String content_type;
    int data_completed_time;
    long end_time;
    String error_string;
    String event_name;
    long event_time;
    int first_data_time;
    String flow_info;
    int header_completed_time;
    String http_client;
    short http_method;
    int is_accelerated;
    short is_compressed;
    Hashtable map;
    long max_bandwidth;
    int max_pkt_size;
    int max_pulse;
    int median1x_pulses;
    int median2x_pulses;
    int median_pulse;
    long min_bandwidth;
    int min_pkt_size;
    int min_pulse;
    int ott_pulses;
    int pkts_ct;
    int response_source;
    short retry;
    int rtt_estimate;
    long start_time;
    int status_code;
    XcpMsgStrategy strategy;
    String url;
    int url_hashed;

    XcpMsgEventLog()
    {
        error_string = "";
        flow_info = "";
        content_type = "";
        http_client = "";
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return super.clone();
    }

    byte[] getMessage()
    {
        map = new Hashtable();
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(0), Long.valueOf(start_time));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(1), Long.valueOf(end_time));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(2), Integer.valueOf(bytes_downloaded));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(3), Integer.valueOf(connection_open_time));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(4), Integer.valueOf(rtt_estimate));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(5), Short.valueOf(is_compressed));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(6), Short.valueOf(http_method));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(7), Integer.valueOf(status_code));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(8), Long.valueOf(min_bandwidth));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(9), Long.valueOf(max_bandwidth));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(10), Integer.valueOf(is_accelerated));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(11), url);
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(12), event_name);
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(13), error_string);
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(14), Integer.valueOf(first_data_time));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(15), Integer.valueOf(header_completed_time));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(16), Integer.valueOf(data_completed_time));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(17), Integer.valueOf(median_pulse));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(18), Integer.valueOf(min_pulse));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(19), Integer.valueOf(max_pulse));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(20), Integer.valueOf(median1x_pulses));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(21), Integer.valueOf(median2x_pulses));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(22), Integer.valueOf(ott_pulses));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(23), Integer.valueOf(pkts_ct));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(24), Integer.valueOf(min_pkt_size));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(25), Integer.valueOf(max_pkt_size));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(26), flow_info);
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(27), Long.valueOf(event_time));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(28), Short.valueOf(retry));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(29), strategy.getMap());
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(30), bypass_reason);
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(31), content_type);
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(32), http_client);
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(33), Integer.valueOf(url_hashed));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(34), Integer.valueOf(response_source));
        return JNILibrary.encodeMessage(map, 9, true);
    }

    public String toDebugString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("XcpMsgEventLog:\n\tstart_time [").append(start_time).append("]");
        stringbuffer.append("\n\tend_time [").append(end_time).append("]");
        stringbuffer.append("\n\tbytes_downloaded [").append(bytes_downloaded).append("]");
        stringbuffer.append("\n\tconnection_open_time [").append(connection_open_time).append("]");
        stringbuffer.append("\n\trtt_estimate [").append(rtt_estimate).append("]");
        stringbuffer.append("\n\tis_compressed [").append(is_compressed).append("]");
        stringbuffer.append("\n\thttp_method [").append(http_method).append("]");
        stringbuffer.append("\n\tstatus_code [").append(status_code).append("]");
        stringbuffer.append("\n\tmin_bandwidth [").append(min_bandwidth).append("]");
        stringbuffer.append("\n\tmax_bandwidth [").append(max_bandwidth).append("]");
        stringbuffer.append("\n\tis_accelerated [").append(is_accelerated).append("]");
        stringbuffer.append("\n\turl [").append(url).append("]");
        stringbuffer.append("\n\turl_hashed [").append(url_hashed).append("]");
        stringbuffer.append("\n\tevent_name [").append(event_name).append("]");
        stringbuffer.append("\n\terror_string [").append(error_string).append("]");
        stringbuffer.append("\n\tfirst_data_time [").append(first_data_time).append("]");
        stringbuffer.append("\n\theader_completed_time [").append(header_completed_time).append("]");
        stringbuffer.append("\n\tdata_completed_time [").append(data_completed_time).append("]");
        stringbuffer.append("\n\tmedian_pulse [").append(median_pulse).append("]");
        stringbuffer.append("\n\tmin_pulse [").append(min_pulse).append("]");
        stringbuffer.append("\n\tmax_pulse [").append(max_pulse).append("]");
        stringbuffer.append("\n\tmedian1x_pulses [").append(median1x_pulses).append("]");
        stringbuffer.append("\n\tmedian2x_pulses [").append(median2x_pulses).append("]");
        stringbuffer.append("\n\tott_pulses [").append(ott_pulses).append("]");
        stringbuffer.append("\n\tpkts_ct [").append(pkts_ct).append("]");
        stringbuffer.append("\n\tmin_pkt_size [").append(min_pkt_size).append("]");
        stringbuffer.append("\n\tmax_pkt_size [").append(max_pkt_size).append("]");
        stringbuffer.append("\n\tflow_info [").append(flow_info).append("]");
        stringbuffer.append("\n\tevent_time [").append(event_time).append("]");
        stringbuffer.append("\n\tretry [").append(retry).append("]");
        stringbuffer.append("\n\tstrategy [\n").append(strategy.toString()).append("\n\t]");
        stringbuffer.append("\n\tbypass_reason [").append(bypass_reason).append("]");
        stringbuffer.append("\n\tcontent_type [").append(content_type).append("]");
        stringbuffer.append("\n\thttp_client [").append(http_client).append("]");
        stringbuffer.append("\n\tresponse_source [").append(response_source).append("]");
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

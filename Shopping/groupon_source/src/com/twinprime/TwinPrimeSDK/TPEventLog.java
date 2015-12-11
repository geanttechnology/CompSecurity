// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import android.util.Log;
import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            XcpMsgEventLog, TPControlChannelStateMachine, XcpMsgStrategy, TPLog, 
//            TPAggZip

class TPEventLog
{
    static interface Listener
    {

        public abstract void eventFlushed(XcpMsgEventLog xcpmsgeventlog);
    }


    static String EVENTLOG_DEFAULT_EVENT_NAME;
    private static String LOG_TAG = "TPEventLog";
    static String event_name;
    static long event_time = (new Date()).getTime();
    static Listener logListener = null;
    static boolean tpPolicyLogFullURL;
    String bypass_reason;
    int bytes_downloaded;
    int connection_open_time;
    String content_type;
    int ctBw;
    int curBw;
    int data_completed_time;
    long end_time;
    String error_string;
    int first_data_time;
    String flow_info;
    int header_completed_time;
    String http_client;
    short http_method;
    int is_accelerated;
    short is_compressed;
    long lastPktTs;
    long maxBandwidth;
    int maxPktSize;
    int maxPulse;
    long max_bandwidth;
    int max_pkt_size;
    int max_pulse;
    int median1x_pulses;
    int median2x_pulses;
    int median_pulse;
    long minBandwidth;
    int minPktSize;
    int minPulse;
    long min_bandwidth;
    int min_pkt_size;
    int min_pulse;
    String original_url;
    int ottPulses;
    int ott_pulses;
    boolean outputctl;
    boolean outputlog;
    final int pktPulse[];
    int pktPulsesCt;
    int pkts_ct;
    int response_source;
    int rtt_estimate;
    long startBwTs;
    long start_time;
    int status_code;
    XcpMsgStrategy strategy;
    long sumBw;
    int sumPulse;
    String url;
    boolean urlIsHashed;
    XcpMsgEventLog xcpMsgEventLog;

    TPEventLog()
    {
        TPControlChannelStateMachine tpcontrolchannelstatemachine;
        error_string = "";
        bypass_reason = "";
        flow_info = "";
        http_client = "";
        content_type = "";
        response_source = 0;
        xcpMsgEventLog = new XcpMsgEventLog();
        lastPktTs = 0L;
        startBwTs = 0L;
        pktPulse = new int[200];
        original_url = "";
        Arrays.fill(pktPulse, 0);
        start_time = (new Date()).getTime();
        tpcontrolchannelstatemachine = TPControlChannelStateMachine.getInstance();
        if (tpcontrolchannelstatemachine == null)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        if (tpcontrolchannelstatemachine.acc_strategy != null)
        {
            strategy = (XcpMsgStrategy)tpcontrolchannelstatemachine.acc_strategy.clone();
        }
_L1:
        return;
        CloneNotSupportedException clonenotsupportedexception;
        clonenotsupportedexception;
        strategy = new XcpMsgStrategy();
        if (TPLog.LOG10.isLoggable(LOG_TAG))
        {
            clonenotsupportedexception.printStackTrace();
            return;
        }
          goto _L1
    }

    static void endLoggingEvent(XcpMsgEventLog xcpmsgeventlog)
        throws IOException
    {
        byte abyte0[] = xcpmsgeventlog.getMessage();
        Object obj = TPControlChannelStateMachine.getInstance();
        if (xcpmsgeventlog.is_accelerated == 0)
        {
            obj = ((TPControlChannelStateMachine) (obj)).bypLogsBuf;
        } else
        {
            obj = ((TPControlChannelStateMachine) (obj)).accLogsBuf;
        }
        ((TPAggZip) (obj)).aggregate(abyte0);
        if (logListener != null)
        {
            logListener.eventFlushed(xcpmsgeventlog);
        }
    }

    private String getEncodedString(String s)
    {
        try
        {
            s = getHexString(MessageDigest.getInstance("SHA1").digest(s.getBytes()));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return "";
        }
        return s;
    }

    static String getHexString(byte abyte0[])
    {
        StringBuffer stringbuffer = new StringBuffer();
        for (int i = 0; i < abyte0.length; i++)
        {
            stringbuffer.append(String.format("%02X", new Object[] {
                Byte.valueOf(abyte0[i])
            }).toLowerCase());
        }

        return stringbuffer.toString();
    }

    private void getXcpMsgEventLog()
    {
        xcpMsgEventLog.start_time = start_time;
        xcpMsgEventLog.end_time = end_time;
        xcpMsgEventLog.bytes_downloaded = bytes_downloaded;
        xcpMsgEventLog.connection_open_time = connection_open_time;
        xcpMsgEventLog.first_data_time = first_data_time;
        xcpMsgEventLog.header_completed_time = header_completed_time;
        xcpMsgEventLog.data_completed_time = data_completed_time;
        xcpMsgEventLog.rtt_estimate = rtt_estimate;
        xcpMsgEventLog.is_compressed = is_compressed;
        xcpMsgEventLog.http_method = http_method;
        xcpMsgEventLog.status_code = status_code;
        xcpMsgEventLog.min_bandwidth = min_bandwidth;
        xcpMsgEventLog.max_bandwidth = max_bandwidth;
        xcpMsgEventLog.median_pulse = median_pulse;
        xcpMsgEventLog.min_pulse = min_pulse;
        xcpMsgEventLog.max_pulse = max_pulse;
        xcpMsgEventLog.median1x_pulses = median1x_pulses;
        xcpMsgEventLog.median2x_pulses = median2x_pulses;
        xcpMsgEventLog.ott_pulses = ott_pulses;
        xcpMsgEventLog.pkts_ct = pkts_ct;
        xcpMsgEventLog.min_pkt_size = min_pkt_size;
        xcpMsgEventLog.max_pkt_size = max_pkt_size;
        xcpMsgEventLog.is_accelerated = is_accelerated;
        xcpMsgEventLog.event_time = event_time;
        xcpMsgEventLog.url = url;
        XcpMsgEventLog xcpmsgeventlog = xcpMsgEventLog;
        int i;
        if (urlIsHashed)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        xcpmsgeventlog.url_hashed = i;
        xcpMsgEventLog.event_name = event_name;
        xcpMsgEventLog.error_string = error_string;
        xcpMsgEventLog.bypass_reason = bypass_reason;
        xcpMsgEventLog.flow_info = flow_info;
        xcpMsgEventLog.strategy = strategy;
        xcpMsgEventLog.http_client = http_client;
        xcpMsgEventLog.content_type = content_type;
        xcpMsgEventLog.response_source = response_source;
    }

    void calcStats()
    {
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        boolean flag;
        int l1;
        i1 = -1;
        k1 = 0;
        j1 = 0;
        l1 = 0;
        k = 0;
        flag = false;
        l = 0;
        for (int i = 0; i < pktPulse.length; i++)
        {
            if (pktPulse[i] > 0 && TPLog.LOG13.isLoggable(LOG_TAG))
            {
                Log.d(LOG_TAG, (new StringBuilder()).append("i [").append(i).append("] = ").append(pktPulse[i]).toString());
            }
        }

        if (pktPulsesCt <= 1) goto _L2; else goto _L1
_L1:
        int j;
        int j3 = pktPulsesCt / 2;
        l1 = 0;
        j = 0;
        flag = false;
        for (int k3 = pktPulsesCt - ottPulses; l1 < k3 && j < 200;)
        {
            Integer integer = Integer.valueOf(pktPulse[j]);
            if (integer != null)
            {
                int i3 = l1 + integer.intValue();
                pktPulse[j] = 0;
                if (flag)
                {
                    j++;
                    l1 = i3;
                } else
                {
                    int i2;
                    int j2;
                    int k2;
                    boolean flag1;
                    int l2;
                    if (i1 == -1)
                    {
                        flag1 = flag;
                        l2 = i1;
                        l1 = k1;
                        i2 = k;
                        j2 = j1;
                        k2 = l;
                        if (i3 >= j3)
                        {
                            if (j != 0)
                            {
                                i1 = j;
                            } else
                            {
                                i1 = 1;
                            }
                            l1 = i1 * 2;
                            j2 = i1 * 3;
                            k2 = l;
                            i2 = k;
                            l2 = i1;
                            flag1 = flag;
                        }
                    } else
                    if (j >= j1)
                    {
                        if (k3 > i3)
                        {
                            l = k3 - i3;
                        } else
                        {
                            l = 0;
                        }
                        flag1 = true;
                        l2 = i1;
                        l1 = k1;
                        i2 = k;
                        j2 = j1;
                        k2 = l;
                    } else
                    {
                        flag1 = flag;
                        l2 = i1;
                        l1 = k1;
                        i2 = k;
                        j2 = j1;
                        k2 = l;
                        if (j >= k1)
                        {
                            i2 = k + integer.intValue();
                            flag1 = flag;
                            l2 = i1;
                            l1 = k1;
                            j2 = j1;
                            k2 = l;
                        }
                    }
                    j++;
                    flag = flag1;
                    i1 = l2;
                    k1 = l1;
                    k = i2;
                    j1 = j2;
                    l = k2;
                    l1 = i3;
                }
            }
        }

        j = i1;
        j1 = k;
        k1 = l;
        if (i1 == -1)
        {
            j = sumPulse / pktPulsesCt;
            k1 = l;
            j1 = k;
        }
_L4:
        if ((long)curBw > maxBandwidth)
        {
            maxBandwidth = curBw;
        }
        if ((long)curBw < minBandwidth)
        {
            minBandwidth = curBw;
        }
        min_bandwidth = minBandwidth * 8L;
        max_bandwidth = maxBandwidth * 8L;
        median_pulse = (j * 1000) / 200;
        min_pulse = (minPulse * 1000) / 200;
        max_pulse = (maxPulse * 1000) / 200;
        median1x_pulses = j1;
        median2x_pulses = k1;
        ott_pulses = ottPulses;
        pkts_ct = pktPulsesCt + 1;
        min_pkt_size = minPktSize;
        max_pkt_size = maxPktSize;
        return;
_L2:
        j = maxPulse;
        j1 = l1;
        k1 = ((flag) ? 1 : 0);
        if (true) goto _L4; else goto _L3
_L3:
    }

    void endLoggingEvent()
    {
        end_time = (new Date()).getTime();
        outputlog = TPLog.LOG13.isLoggable(LOG_TAG);
        calcStats();
        flush();
        if (!bypass_reason.equals("warm-connection"))
        {
            String s;
            if (TPLog.LOG2.isLoggable(LOG_TAG))
            {
                double d = end_time;
                d = (double)(end_time - start_time) / 1000D;
                Object obj = TPLog.LOG2;
                Object obj1 = LOG_TAG;
                StringBuilder stringbuilder = (new StringBuilder()).append("Done retrieving ").append(original_url).append(", bytes: ").append(bytes_downloaded).append(", seconds: ").append(d).append(", Acceleration: ");
                if (is_accelerated == 1)
                {
                    s = "on";
                } else
                {
                    s = "off";
                }
                ((TPLog) (obj)).i(((String) (obj1)), stringbuilder.append(s).toString());
            }
            if (TPLog.LOG10.isLoggable(LOG_TAG))
            {
                obj = LOG_TAG;
                obj1 = (new StringBuilder()).append(bytes_downloaded).append(" bytes read from ").append(url).append(" [").append(end_time - start_time).append(" ms]. Acceleration ");
                if (is_accelerated == 1)
                {
                    s = "on";
                } else
                {
                    s = "off";
                }
                Log.i(((String) (obj)), ((StringBuilder) (obj1)).append(s).toString());
            }
        }
    }

    void flush()
    {
        getXcpMsgEventLog();
        if (outputlog)
        {
            Log.d(LOG_TAG, toString());
        }
        if (!outputctl)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        if (TPLog.LOG10.isLoggable(LOG_TAG))
        {
            Log.i(LOG_TAG, (new StringBuilder()).append("Sending TPEvent for url ").append(url).toString());
        }
        endLoggingEvent(xcpMsgEventLog);
_L2:
        return;
        Exception exception;
        exception;
        if (!TPLog.LOG13.isLoggable(LOG_TAG)) goto _L2; else goto _L1
_L1:
        exception.printStackTrace();
        return;
        if (TPLog.LOG13.isLoggable(LOG_TAG))
        {
            Log.d(LOG_TAG, (new StringBuilder()).append("outputctl prevents sending log for url ").append(url).toString());
            return;
        }
          goto _L2
    }

    String getSanitizeURL(URL url1)
    {
        return (new StringBuilder()).append(url1.getProtocol()).append("://").append(url1.getHost()).append("/").append(getEncodedString(url1.toString())).toString();
    }

    public void setHttpMethod(String s)
    {
        if (s.equalsIgnoreCase("GET"))
        {
            http_method = 0;
            return;
        }
        if (s.equalsIgnoreCase("HEAD"))
        {
            http_method = 1;
            return;
        }
        if (s.equalsIgnoreCase("CHECKOUT"))
        {
            http_method = 2;
            return;
        }
        if (s.equalsIgnoreCase("SHOWMETHOD"))
        {
            http_method = 3;
            return;
        }
        if (s.equalsIgnoreCase("PUT"))
        {
            http_method = 4;
            return;
        }
        if (s.equalsIgnoreCase("DELETE"))
        {
            http_method = 5;
            return;
        }
        if (s.equalsIgnoreCase("POST"))
        {
            http_method = 6;
            return;
        }
        if (s.equalsIgnoreCase("LINK"))
        {
            http_method = 7;
            return;
        }
        if (s.equalsIgnoreCase("UNLINK"))
        {
            http_method = 8;
            return;
        }
        if (s.equalsIgnoreCase("CHECKING"))
        {
            http_method = 9;
            return;
        }
        if (s.equalsIgnoreCase("TEXTSEARCH"))
        {
            http_method = 10;
            return;
        }
        if (s.equalsIgnoreCase("SPACEJUMP"))
        {
            http_method = 11;
            return;
        }
        if (s.equalsIgnoreCase("SEARCH"))
        {
            http_method = 12;
            return;
        } else
        {
            http_method = 13;
            return;
        }
    }

    public void setUrl(URL url1)
    {
        if (tpPolicyLogFullURL)
        {
            urlIsHashed = false;
            url = url1.toString();
            return;
        } else
        {
            urlIsHashed = true;
            url = getSanitizeURL(url1);
            return;
        }
    }

    void storePktTimeSeries(int i)
    {
        long l = (new Date()).getTime();
        if (lastPktTs == 0L)
        {
            curBw = i;
            startBwTs = l;
            lastPktTs = l;
            l = i;
            maxBandwidth = l;
            minBandwidth = l;
            ctBw = 0;
            sumBw = 0;
            maxPktSize = i;
            minPktSize = i;
            ottPulses = 0;
            minPulse = 0;
            maxPulse = 0;
            sumPulse = 0;
            pktPulsesCt = 0;
            return;
        }
        if (l - startBwTs > 1000L)
        {
            if ((long)curBw > maxBandwidth)
            {
                maxBandwidth = curBw;
            }
            if ((long)curBw < minBandwidth)
            {
                minBandwidth = curBw;
            }
            sumBw = sumBw + (long)curBw;
            ctBw = ctBw + 1;
            if (TPLog.LOG13.isLoggable(LOG_TAG))
            {
                Log.e(LOG_TAG, (new StringBuilder()).append("minbw ").append(minBandwidth).append(" maxbw ").append(maxBandwidth).append(" cur ").append(curBw).append(" avg ").append((int)(sumBw / (long)ctBw)).toString());
            }
            curBw = 0;
            startBwTs = l;
        }
        if (i < minPktSize)
        {
            minPktSize = i;
        }
        if (i > maxPktSize)
        {
            maxPktSize = i;
        }
        curBw = curBw + i;
        i = (int)(((l - lastPktTs) * 200L) / 1000L);
        if (i < 200)
        {
            int j = pktPulse[i];
            pktPulse[i] = j + 1;
        } else
        {
            ottPulses = ottPulses + 1;
        }
        if (pktPulsesCt == 0 || i < minPulse)
        {
            minPulse = i;
        }
        if (i > maxPulse)
        {
            maxPulse = i;
        }
        sumPulse = sumPulse + i;
        pktPulsesCt = pktPulsesCt + 1;
        lastPktTs = l;
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append(xcpMsgEventLog.toString());
        return stringbuffer.toString();
    }

    static 
    {
        EVENTLOG_DEFAULT_EVENT_NAME = "default";
        event_name = EVENTLOG_DEFAULT_EVENT_NAME;
    }
}

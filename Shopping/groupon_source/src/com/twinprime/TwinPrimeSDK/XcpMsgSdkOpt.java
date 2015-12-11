// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import java.util.Hashtable;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPOptionManager, XcpMsgUtils, TPLog

class XcpMsgSdkOpt
{

    int certificate_validation;
    int disable_caching;
    int http_acceleration;
    int http_intercept;
    int https_acceleration;
    int https_intercept;
    int limited_http_intercept;
    int log_full_url;
    Hashtable map;
    int performance_log;
    int send_session_id;

    XcpMsgSdkOpt()
    {
        boolean flag;
        flag = true;
        super();
        static class _cls1
        {

            static final int $SwitchMap$com$twinprime$TwinPrimeSDK$TPOptionManager$TPOptionDisableCaching[];

            static 
            {
                $SwitchMap$com$twinprime$TwinPrimeSDK$TPOptionManager$TPOptionDisableCaching = new int[TPOptionManager.TPOptionDisableCaching.values().length];
                try
                {
                    $SwitchMap$com$twinprime$TwinPrimeSDK$TPOptionManager$TPOptionDisableCaching[TPOptionManager.TPOptionDisableCaching.TPOptionDisableCaching_none.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$twinprime$TwinPrimeSDK$TPOptionManager$TPOptionDisableCaching[TPOptionManager.TPOptionDisableCaching.TPOptionDisableCaching_library.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$twinprime$TwinPrimeSDK$TPOptionManager$TPOptionDisableCaching[TPOptionManager.TPOptionDisableCaching.TPOptionDisableCaching_system.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.twinprime.TwinPrimeSDK.TPOptionManager.TPOptionDisableCaching[TPOptionManager.getCachingOption().ordinal()];
        JVM INSTR tableswitch 1 3: default 44
    //                   1 157
    //                   2 165
    //                   3 173;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_173;
_L5:
        int i;
        if (TPOptionManager.getCertVerificationOption() == TPOptionManager.TPOptionHTTPCertificateVerification.TPOptionHTTPCertificateVerification_enable)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        certificate_validation = i;
        if (TPOptionManager.getPerformanceLogOption() == TPOptionManager.TPOptionPerformanceLog.TPOptionPerformanceLog_enable)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        performance_log = i;
        if (TPOptionManager.getSendSessionID() == TPOptionManager.TPOptionSendSessionID.TPOptionSendSessionID_enable)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        send_session_id = i;
        if (TPOptionManager.getLimitedHTTPIntercept() == TPOptionManager.TPOptionLimitedHTTPIntercept.TPOptionLimitedHTTPIntercept_enable)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        limited_http_intercept = i;
        if (TPOptionManager.getLogFullURLOption() == TPOptionManager.TPOptionLogFullURL.TPOptionLogFullURL_enable)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        log_full_url = i;
        if (TPOptionManager.getHTTPAcceleration() == TPOptionManager.TPOptionHTTPAcceleration.TPOptionHTTPAcceleration_enable)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        http_acceleration = i;
        if (TPOptionManager.getHTTPSAcceleration() == TPOptionManager.TPOptionHTTPSAcceleration.TPOptionHTTPSAcceleration_enable)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        https_acceleration = i;
        return;
_L2:
        disable_caching = 0;
          goto _L5
_L3:
        disable_caching = 1;
          goto _L5
        disable_caching = 2;
          goto _L5
    }

    Hashtable getMap()
    {
        map = new Hashtable();
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(0), Integer.valueOf(disable_caching));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(1), Integer.valueOf(certificate_validation));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(2), Integer.valueOf(performance_log));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(4), Integer.valueOf(send_session_id));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(5), Integer.valueOf(http_intercept));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(6), Integer.valueOf(https_intercept));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(7), Integer.valueOf(https_intercept));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(9), Integer.valueOf(log_full_url));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(10), Integer.valueOf(http_acceleration));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(11), Integer.valueOf(https_acceleration));
        return map;
    }

    public String toDebugString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append((new StringBuilder()).append("\t\tXcpMsgSdkOpt:\n\t\t\tdisable_caching [").append(disable_caching).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\t\t\tcertificate_validation [").append(certificate_validation).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\t\t\tperformance_log [").append(performance_log).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\t\t\tsend_session_id [").append(send_session_id).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\t\t\thttp_intercept [").append(http_intercept).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\t\t\thttps_intercept [").append(https_intercept).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\t\t\tlimited_http_intercept [").append(limited_http_intercept).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\t\t\tlog_full_url [").append(log_full_url).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\t\t\thttp_acceleration [").append(http_acceleration).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\t\t\thttps_acceleration [").append(https_acceleration).append("]").toString());
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

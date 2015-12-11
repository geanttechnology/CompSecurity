// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import java.util.Date;
import java.util.Hashtable;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            XcpMsgUtils, XcpMsgSdkOpt, JNILibrary, TPLog

class XcpMsgInitReq
{

    String api_key;
    int app_guid;
    String app_id;
    String app_name;
    String app_version;
    String cookie;
    int daily_active;
    int expiry;
    Hashtable map;
    int monthly_active;
    int nonce;
    XcpMsgSdkOpt sdk_options;
    String sdk_version;
    long sid;

    XcpMsgInitReq()
    {
    }

    byte[] getMessage()
    {
        map = new Hashtable();
        long l = (new Date()).getTime();
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(0), Long.valueOf(l));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(1), app_id);
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(3), sdk_version);
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(4), Integer.valueOf(monthly_active));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(5), Long.valueOf(sid));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(6), Integer.valueOf(nonce));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(7), cookie);
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(8), Integer.valueOf(expiry));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(9), sdk_options.getMap());
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(10), Integer.valueOf(daily_active));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(11), app_version);
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(12), app_name);
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(13), Integer.valueOf(app_guid));
        return JNILibrary.encodeMessage(map, 1, true);
    }

    public String toDebugString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append((new StringBuilder()).append("XcpMsgInitReq:\n\tsid [").append(sid).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tnonce [").append(nonce).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\texpiry [").append(expiry).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tmonthly_active [").append(monthly_active).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tdaily_active [").append(daily_active).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tapp_id [").append(app_id).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tapp_name [").append(app_name).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tapp_version [").append(app_version).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tapi_key [").append(api_key).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tapi_guid [").append(app_guid).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tsdk_version [").append(sdk_version).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tcookie [").append(cookie).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tsdk_options [\n").append(sdk_options).append("\n\t]").toString());
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

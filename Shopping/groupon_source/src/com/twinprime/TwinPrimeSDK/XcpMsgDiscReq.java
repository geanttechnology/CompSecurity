// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import java.util.Hashtable;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            XcpMsg, XcpMsgUtils, JNILibrary, TPLog

class XcpMsgDiscReq extends XcpMsg
{

    String api_key;
    int app_guid;
    String app_id;
    int cust_id;
    String hashed_key;
    Hashtable map;
    int nonce;
    long ts;

    XcpMsgDiscReq()
    {
    }

    byte[] getMessage()
    {
        map = new Hashtable();
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(0), Long.valueOf(ts));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(1), app_id);
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(2), api_key);
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(3), hashed_key);
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(5), Long.valueOf(ts));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(4), Integer.valueOf(cust_id));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(6), Integer.valueOf(app_guid));
        return JNILibrary.encodeMessage(map, 10, false);
    }

    void process()
    {
    }

    public String toDebugString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append((new StringBuilder()).append("XcpMsgDiscReq:\n\tnonce [").append(nonce).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tapp_id [").append(app_id).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tapi_key [").append(api_key).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tapp_guid [").append(app_guid).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\thashed_key [").append(hashed_key).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tts [").append(ts).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tcust_id [").append(cust_id).append("]").toString());
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

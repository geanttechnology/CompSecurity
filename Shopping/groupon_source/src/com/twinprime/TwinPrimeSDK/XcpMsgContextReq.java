// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import java.util.Hashtable;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            XcpMsgUtils, JNILibrary, TPLog

class XcpMsgContextReq
{

    int battery_level;
    int battery_state;
    String bssid;
    String bundle_id;
    String carrier_name;
    String cell_ipaddress;
    String device;
    short inuseRAM;
    double latitude;
    double longitude;
    Hashtable map;
    int mcc;
    int mnc;
    String network_detail;
    int network_type;
    String os_version;
    String time_zone;
    short totalRAM;

    XcpMsgContextReq()
    {
    }

    byte[] getMessage()
    {
        map = new Hashtable();
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(0), Integer.valueOf(network_type));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(2), Integer.valueOf(mcc));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(3), Integer.valueOf(mnc));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(4), Double.valueOf(longitude));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(5), Double.valueOf(latitude));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(6), Integer.valueOf(battery_level));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(7), Integer.valueOf(battery_state));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(8), Short.valueOf(totalRAM));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(9), Short.valueOf(inuseRAM));
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(10), time_zone);
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(11), device);
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(12), carrier_name);
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(13), bundle_id);
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(14), cell_ipaddress);
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(18), bssid);
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(19), os_version);
        XcpMsgUtils.conditionalAdd(map, Integer.valueOf(22), network_detail);
        return JNILibrary.encodeMessage(map, 7, true);
    }

    public String toDebugString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append((new StringBuilder()).append("XcpMsgContextReq:\n\tnetwork_type [").append(network_type).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tmcc [").append(mcc).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tmnc [").append(mnc).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tlongitude [").append(longitude).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tlatitude [").append(latitude).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tbattery_level [").append(battery_level).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tbattery_state [").append(battery_state).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\ttotalRAM [").append(totalRAM).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tinuseRAM [").append(inuseRAM).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\ttime_zone [").append(time_zone).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tdevice [").append(device).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tcarrier_name [").append(carrier_name).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tos_version [").append(os_version).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tbundle_id [").append(bundle_id).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tcell_ipaddress [").append(cell_ipaddress).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tbssid [").append(bssid).append("]").toString());
        stringbuffer.append((new StringBuilder()).append("\n\tnetwork_detail [").append(network_detail).append("]").toString());
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

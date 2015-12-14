// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import java.util.List;

// Referenced classes of package com.tencent.mm.sdk.platformtools:
//            PhoneUtil20Impl, PhoneUtil16Impl

public final class PhoneUtil
{

    public static final String CELL_CDMA = "cdma";
    public static final String CELL_GSM = "gsm";
    private static final int aJ = 17;

    private PhoneUtil()
    {
    }

    public static List getCellInfoList(Context context)
    {
        if (Integer.valueOf(android.os.Build.VERSION.SDK).intValue() >= 5)
        {
            return (new PhoneUtil20Impl()).getCellInfoList(context);
        } else
        {
            return (new PhoneUtil16Impl()).getCellInfoList(context);
        }
    }

    public static String getCellXml(List list)
    {
        if (list != null && list.size() > 0) goto _L2; else goto _L1
_L1:
        String s1 = "";
_L4:
        return s1;
_L2:
        String s = "";
        int i = 0;
        do
        {
            s1 = s;
            if (i >= list.size())
            {
                continue;
            }
            s = (new StringBuilder()).append(s).append("<cell ").toString();
            s = (new StringBuilder()).append(s).append("mcc=\"").append(((CellInfo)list.get(i)).mcc).append("\" ").toString();
            s = (new StringBuilder()).append(s).append("mnc=\"").append(((CellInfo)list.get(i)).mnc).append("\" ").toString();
            s = (new StringBuilder()).append(s).append("lac=\"").append(((CellInfo)list.get(i)).lac).append("\" ").toString();
            s = (new StringBuilder()).append(s).append("type=\"").append(((CellInfo)list.get(i)).type).append("\" ").toString();
            s = (new StringBuilder()).append(s).append("stationId=\"").append(((CellInfo)list.get(i)).stationId).append("\" ").toString();
            s = (new StringBuilder()).append(s).append("networkId=\"").append(((CellInfo)list.get(i)).networkId).append("\" ").toString();
            s = (new StringBuilder()).append(s).append("systemId=\"").append(((CellInfo)list.get(i)).systemId).append("\" ").toString();
            s = (new StringBuilder()).append(s).append("dbm=\"").append(((CellInfo)list.get(i)).dbm).append("\" ").toString();
            s = (new StringBuilder()).append(s).append(" >").toString();
            s = (new StringBuilder()).append(s).append(((CellInfo)list.get(i)).cellid).toString();
            s = (new StringBuilder()).append(s).append("</cell>").toString();
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String getMacXml(List list)
    {
        String s = "";
        if (list != null && list.size() > 0) goto _L2; else goto _L1
_L1:
        String s1 = "";
_L4:
        return s1;
_L2:
        int i = 0;
        do
        {
            s1 = s;
            if (i >= list.size())
            {
                continue;
            }
            if (list.get(i) != null && ((MacInfo)list.get(i)).mac.length() == aJ)
            {
                s = (new StringBuilder()).append(s).append("<mac ").toString();
                s = (new StringBuilder()).append(s).append("macDbm=\"").append(((MacInfo)list.get(i)).dbm).append("\"").toString();
                s = (new StringBuilder()).append(s).append(">").toString();
                s = (new StringBuilder()).append(s).append(((MacInfo)list.get(i)).mac).toString();
                s = (new StringBuilder()).append(s).append("</mac>").toString();
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void getSignalStrength(Context context)
    {
        if (Integer.valueOf(android.os.Build.VERSION.SDK).intValue() >= 5)
        {
            (new PhoneUtil20Impl()).getSignalStrength(context);
            return;
        } else
        {
            (new PhoneUtil16Impl()).getSignalStrength(context);
            return;
        }
    }


    private class CellInfo
    {

        public static final int MAX_CID = 65535;
        public static final int MAX_LAC = 65535;
        public String cellid;
        public String dbm;
        public String lac;
        public String mcc;
        public String mnc;
        public String networkId;
        public String stationId;
        public String systemId;
        public String type;

        public CellInfo(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
                String s7, String s8)
        {
            mcc = s;
            mnc = s1;
            lac = s2;
            type = s5;
            cellid = s3;
            stationId = s6;
            networkId = s7;
            systemId = s8;
            dbm = s4;
        }
    }


    private class MacInfo
    {

        public String dbm;
        public String mac;

        public MacInfo(String s, String s1)
        {
            mac = s;
            dbm = s1;
        }
    }

}

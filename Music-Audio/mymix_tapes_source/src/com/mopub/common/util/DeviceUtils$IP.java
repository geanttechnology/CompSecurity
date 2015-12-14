// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.util;

import org.apache.http.conn.util.InetAddressUtils;

// Referenced classes of package com.mopub.common.util:
//            DeviceUtils

public static final class Utils extends Enum
{

    private static final IPv6 $VALUES[];
    public static final IPv6 IPv4;
    public static final IPv6 IPv6;

    private boolean matches(String s)
    {
        switch (SwitchMap.com.mopub.common.util.DeviceUtils.IP[ordinal()])
        {
        default:
            return false;

        case 1: // '\001'
            return InetAddressUtils.isIPv4Address(s);

        case 2: // '\002'
            return InetAddressUtils.isIPv6Address(s);
        }
    }

    private String toString(String s)
    {
        String s1 = s;
        switch (SwitchMap.com.mopub.common.util.DeviceUtils.IP[ordinal()])
        {
        default:
            s1 = null;
            // fall through

        case 1: // '\001'
            return s1;

        case 2: // '\002'
            return s.split("%")[0];
        }
    }

    public static ordinal valueOf(String s)
    {
        return (ordinal)Enum.valueOf(com/mopub/common/util/DeviceUtils$IP, s);
    }

    public static ordinal[] values()
    {
        return (ordinal[])$VALUES.clone();
    }

    static 
    {
        IPv4 = new <init>("IPv4", 0);
        IPv6 = new <init>("IPv6", 1);
        $VALUES = (new .VALUES[] {
            IPv4, IPv6
        });
    }



    private Utils(String s, int i)
    {
        super(s, i);
    }
}

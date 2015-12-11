// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.configuration;


// Referenced classes of package com.amazon.client.metrics.configuration:
//            MetricsConfigurationException

public final class NetworkType extends Enum
{

    private static final NetworkType $VALUES[];
    public static final NetworkType ETHERNET;
    public static final NetworkType WAN;
    public static final NetworkType WIFI;
    private final String mName;

    private NetworkType(String s, int i, String s1)
    {
        super(s, i);
        mName = s1;
    }

    public static NetworkType fromString(String s)
        throws MetricsConfigurationException
    {
        NetworkType anetworktype[] = values();
        int j = anetworktype.length;
        for (int i = 0; i < j; i++)
        {
            NetworkType networktype = anetworktype[i];
            if (networktype.getName().equalsIgnoreCase(s))
            {
                return networktype;
            }
        }

        throw new MetricsConfigurationException((new StringBuilder()).append(s).append(" is not a valid NetworkType").toString());
    }

    public static NetworkType valueOf(String s)
    {
        return (NetworkType)Enum.valueOf(com/amazon/client/metrics/configuration/NetworkType, s);
    }

    public static NetworkType[] values()
    {
        return (NetworkType[])$VALUES.clone();
    }

    public String getName()
    {
        return mName;
    }

    static 
    {
        WIFI = new NetworkType("WIFI", 0, "Wifi");
        ETHERNET = new NetworkType("ETHERNET", 1, "Ethernet");
        WAN = new NetworkType("WAN", 2, "Wan");
        $VALUES = (new NetworkType[] {
            WIFI, ETHERNET, WAN
        });
    }
}

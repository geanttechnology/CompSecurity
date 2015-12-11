// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.configuration;


// Referenced classes of package com.amazon.client.metrics.configuration:
//            MetricsConfigurationException

public final class TransportType extends Enum
{

    private static final TransportType $VALUES[];
    public static final TransportType HTTP;
    public static final TransportType OUTPUT_STREAM;
    public static final TransportType TCOMM;
    private final String mName;

    private TransportType(String s, int i, String s1)
    {
        super(s, i);
        mName = s1;
    }

    public static TransportType fromString(String s)
        throws MetricsConfigurationException
    {
        TransportType atransporttype[] = values();
        int j = atransporttype.length;
        for (int i = 0; i < j; i++)
        {
            TransportType transporttype = atransporttype[i];
            if (transporttype.getName().equalsIgnoreCase(s))
            {
                return transporttype;
            }
        }

        throw new MetricsConfigurationException((new StringBuilder()).append(s).append(" is not a valid TransportType").toString());
    }

    public static TransportType valueOf(String s)
    {
        return (TransportType)Enum.valueOf(com/amazon/client/metrics/configuration/TransportType, s);
    }

    public static TransportType[] values()
    {
        return (TransportType[])$VALUES.clone();
    }

    public String getName()
    {
        return mName;
    }

    static 
    {
        HTTP = new TransportType("HTTP", 0, "Http");
        TCOMM = new TransportType("TCOMM", 1, "TComm");
        OUTPUT_STREAM = new TransportType("OUTPUT_STREAM", 2, "OutputStream");
        $VALUES = (new TransportType[] {
            HTTP, TCOMM, OUTPUT_STREAM
        });
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.configuration;


// Referenced classes of package com.amazon.client.metrics.configuration:
//            MetricsConfigurationException

public final class BatchTransmitterType extends Enum
{

    private static final BatchTransmitterType $VALUES[];
    public static final BatchTransmitterType NOS;
    public static final BatchTransmitterType PERIODIC;
    public static final BatchTransmitterType URGENT;
    private final String mName;

    private BatchTransmitterType(String s, int i, String s1)
    {
        super(s, i);
        mName = s1;
    }

    public static BatchTransmitterType fromString(String s)
        throws MetricsConfigurationException
    {
        BatchTransmitterType abatchtransmittertype[] = values();
        int j = abatchtransmittertype.length;
        for (int i = 0; i < j; i++)
        {
            BatchTransmitterType batchtransmittertype = abatchtransmittertype[i];
            if (batchtransmittertype.getName().equalsIgnoreCase(s))
            {
                return batchtransmittertype;
            }
        }

        throw new MetricsConfigurationException((new StringBuilder()).append(s).append(" is not a valid BatchTransmitterType").toString());
    }

    public static BatchTransmitterType valueOf(String s)
    {
        return (BatchTransmitterType)Enum.valueOf(com/amazon/client/metrics/configuration/BatchTransmitterType, s);
    }

    public static BatchTransmitterType[] values()
    {
        return (BatchTransmitterType[])$VALUES.clone();
    }

    public String getName()
    {
        return mName;
    }

    static 
    {
        PERIODIC = new BatchTransmitterType("PERIODIC", 0, "Periodic");
        NOS = new BatchTransmitterType("NOS", 1, "Nos");
        URGENT = new BatchTransmitterType("URGENT", 2, "Urgent");
        $VALUES = (new BatchTransmitterType[] {
            PERIODIC, NOS, URGENT
        });
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.configuration;


// Referenced classes of package com.amazon.client.metrics.configuration:
//            MetricsConfigurationException

public final class BatchQueueType extends Enum
{

    private static final BatchQueueType $VALUES[];
    public static final BatchQueueType NON_VOLATILE;
    public static final BatchQueueType SEMI_VOLATILE;
    public static final BatchQueueType VOLATILE;
    private final String mName;

    private BatchQueueType(String s, int i, String s1)
    {
        super(s, i);
        mName = s1;
    }

    public static BatchQueueType fromString(String s)
        throws MetricsConfigurationException
    {
        BatchQueueType abatchqueuetype[] = values();
        int j = abatchqueuetype.length;
        for (int i = 0; i < j; i++)
        {
            BatchQueueType batchqueuetype = abatchqueuetype[i];
            if (batchqueuetype.getName().equalsIgnoreCase(s))
            {
                return batchqueuetype;
            }
        }

        throw new MetricsConfigurationException((new StringBuilder()).append(s).append(" is not a valid BatchQueueType").toString());
    }

    public static BatchQueueType valueOf(String s)
    {
        return (BatchQueueType)Enum.valueOf(com/amazon/client/metrics/configuration/BatchQueueType, s);
    }

    public static BatchQueueType[] values()
    {
        return (BatchQueueType[])$VALUES.clone();
    }

    public String getName()
    {
        return mName;
    }

    static 
    {
        VOLATILE = new BatchQueueType("VOLATILE", 0, "Volatile");
        NON_VOLATILE = new BatchQueueType("NON_VOLATILE", 1, "NonVolatile");
        SEMI_VOLATILE = new BatchQueueType("SEMI_VOLATILE", 2, "SemiVolatile");
        $VALUES = (new BatchQueueType[] {
            VOLATILE, NON_VOLATILE, SEMI_VOLATILE
        });
    }
}

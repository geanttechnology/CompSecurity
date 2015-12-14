// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.configuration;


// Referenced classes of package com.amazon.client.metrics.configuration:
//            MetricsConfigurationException

public final class CodecType extends Enum
{

    private static final CodecType $VALUES[];
    public static final CodecType PROTOCOL_BUFFERS;
    public static final CodecType STRING;
    private final String mName;

    private CodecType(String s, int i, String s1)
    {
        super(s, i);
        mName = s1;
    }

    public static CodecType fromString(String s)
        throws MetricsConfigurationException
    {
        CodecType acodectype[] = values();
        int j = acodectype.length;
        for (int i = 0; i < j; i++)
        {
            CodecType codectype = acodectype[i];
            if (codectype.getName().equalsIgnoreCase(s))
            {
                return codectype;
            }
        }

        throw new MetricsConfigurationException((new StringBuilder()).append(s).append(" is not a valid Codec").toString());
    }

    public static CodecType valueOf(String s)
    {
        return (CodecType)Enum.valueOf(com/amazon/client/metrics/configuration/CodecType, s);
    }

    public static CodecType[] values()
    {
        return (CodecType[])$VALUES.clone();
    }

    public String getName()
    {
        return mName;
    }

    static 
    {
        PROTOCOL_BUFFERS = new CodecType("PROTOCOL_BUFFERS", 0, "ProtocolBuffers");
        STRING = new CodecType("STRING", 1, "String");
        $VALUES = (new CodecType[] {
            PROTOCOL_BUFFERS, STRING
        });
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.codec;

import com.google.protobuf.ProtocolMessageEnum;
import java.util.List;

// Referenced classes of package com.amazon.client.metrics.codec:
//            DeviceMetricsMessage

public static final class value extends Enum
    implements ProtocolMessageEnum
{

    private static final CLICKSTREAM $VALUES[];
    public static final CLICKSTREAM CLICKSTREAM;
    public static final int CLICKSTREAM_VALUE = 3;
    public static final CLICKSTREAM COUNTER;
    public static final int COUNTER_VALUE = 0;
    public static final CLICKSTREAM DISCRETE;
    public static final int DISCRETE_VALUE = 2;
    public static final CLICKSTREAM TIMER;
    public static final int TIMER_VALUE = 1;
    private static final CLICKSTREAM VALUES[] = values();
    private static com.google.protobuf.ge.DataType.values internalValueMap = new com.google.protobuf.Internal.EnumLiteMap() {

        public DeviceMetricsMessage.DataPointMessage.DataType findValueByNumber(int i)
        {
            return DeviceMetricsMessage.DataPointMessage.DataType.valueOf(i);
        }

        public volatile com.google.protobuf.Internal.EnumLite findValueByNumber(int i)
        {
            return findValueByNumber(i);
        }

    };
    private final int index;
    private final int value;

    public static final com.google.protobuf.ge.DataType getDescriptor()
    {
        return (com.google.protobuf.ge.DataType)ptor().getDescriptor().get(0);
    }

    public static com.google.protobuf.ge.getDescriptor internalGetValueMap()
    {
        return internalValueMap;
    }

    public static internalValueMap valueOf(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return COUNTER;

        case 1: // '\001'
            return TIMER;

        case 2: // '\002'
            return DISCRETE;

        case 3: // '\003'
            return CLICKSTREAM;
        }
    }

    public static CLICKSTREAM valueOf(com.google.protobuf.ge.DataType.CLICKSTREAM clickstream)
    {
        if (clickstream.DataType() != getDescriptor())
        {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        } else
        {
            return VALUES[clickstream.VALUES()];
        }
    }

    public static VALUES valueOf(String s)
    {
        return (VALUES)Enum.valueOf(com/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType, s);
    }

    public static VALUES[] values()
    {
        return (VALUES[])$VALUES.clone();
    }

    public final com.google.protobuf.ge.DataType getDescriptorForType()
    {
        return getDescriptor();
    }

    public final int getNumber()
    {
        return value;
    }

    public final com.google.protobuf.ge.DataType getValueDescriptor()
    {
        return (com.google.protobuf.ge.DataType)getDescriptor().getDescriptor().get(index);
    }

    static 
    {
        COUNTER = new <init>("COUNTER", 0, 0, 0);
        TIMER = new <init>("TIMER", 1, 1, 1);
        DISCRETE = new <init>("DISCRETE", 2, 2, 2);
        CLICKSTREAM = new <init>("CLICKSTREAM", 3, 3, 3);
        $VALUES = (new .VALUES[] {
            COUNTER, TIMER, DISCRETE, CLICKSTREAM
        });
    }

    private _cls1(String s, int i, int j, int k)
    {
        super(s, i);
        index = j;
        value = k;
    }
}

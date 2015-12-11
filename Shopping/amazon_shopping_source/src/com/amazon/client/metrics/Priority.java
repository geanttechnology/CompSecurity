// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;


public final class Priority extends Enum
{

    private static final Priority $VALUES[];
    public static final Priority HIGH;
    public static final Priority NORMAL;
    public static final Priority RESERVED_FOR_LOCATION_SERVICE;
    public static final Priority RESERVED_FOR_NON_ANONYMOUS_METRICS;

    private Priority(String s, int i)
    {
        super(s, i);
    }

    public static Priority fromInt(int i)
    {
        if (i < 0 || i > values().length)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("invalid priority ").append(i).toString());
        } else
        {
            return values()[i];
        }
    }

    public static Priority valueOf(String s)
    {
        return (Priority)Enum.valueOf(com/amazon/client/metrics/Priority, s);
    }

    public static Priority[] values()
    {
        return (Priority[])$VALUES.clone();
    }

    static 
    {
        NORMAL = new Priority("NORMAL", 0);
        HIGH = new Priority("HIGH", 1);
        RESERVED_FOR_LOCATION_SERVICE = new Priority("RESERVED_FOR_LOCATION_SERVICE", 2);
        RESERVED_FOR_NON_ANONYMOUS_METRICS = new Priority("RESERVED_FOR_NON_ANONYMOUS_METRICS", 3);
        $VALUES = (new Priority[] {
            NORMAL, HIGH, RESERVED_FOR_LOCATION_SERVICE, RESERVED_FOR_NON_ANONYMOUS_METRICS
        });
    }
}

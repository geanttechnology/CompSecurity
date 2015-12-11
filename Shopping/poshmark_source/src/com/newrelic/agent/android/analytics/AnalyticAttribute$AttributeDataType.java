// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.analytics;


// Referenced classes of package com.newrelic.agent.android.analytics:
//            AnalyticAttribute

public static final class  extends Enum
{

    private static final BOOLEAN $VALUES[];
    public static final BOOLEAN BOOLEAN;
    public static final BOOLEAN FLOAT;
    public static final BOOLEAN STRING;
    public static final BOOLEAN VOID;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        VOID = new <init>("VOID", 0);
        STRING = new <init>("STRING", 1);
        FLOAT = new <init>("FLOAT", 2);
        BOOLEAN = new <init>("BOOLEAN", 3);
        $VALUES = (new .VALUES[] {
            VOID, STRING, FLOAT, BOOLEAN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

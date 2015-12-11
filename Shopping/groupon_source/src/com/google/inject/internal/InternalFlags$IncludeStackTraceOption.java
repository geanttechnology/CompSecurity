// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;


// Referenced classes of package com.google.inject.internal:
//            InternalFlags

public static final class  extends Enum
{

    private static final COMPLETE $VALUES[];
    public static final COMPLETE COMPLETE;
    public static final COMPLETE OFF;
    public static final COMPLETE ONLY_FOR_DECLARING_SOURCE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/inject/internal/InternalFlags$IncludeStackTraceOption, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        OFF = new <init>("OFF", 0);
        ONLY_FOR_DECLARING_SOURCE = new <init>("ONLY_FOR_DECLARING_SOURCE", 1);
        COMPLETE = new <init>("COMPLETE", 2);
        $VALUES = (new .VALUES[] {
            OFF, ONLY_FOR_DECLARING_SOURCE, COMPLETE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

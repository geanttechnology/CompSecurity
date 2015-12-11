// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.profiling;


// Referenced classes of package com.amazon.profiling:
//            ProfilerScope

public final class NullProfilerScope extends Enum
    implements ProfilerScope
{

    private static final NullProfilerScope $VALUES[];
    public static final NullProfilerScope INSTANCE;

    private NullProfilerScope(String s, int i)
    {
        super(s, i);
    }

    public static NullProfilerScope valueOf(String s)
    {
        return (NullProfilerScope)Enum.valueOf(com/amazon/profiling/NullProfilerScope, s);
    }

    public static NullProfilerScope[] values()
    {
        return (NullProfilerScope[])$VALUES.clone();
    }

    static 
    {
        INSTANCE = new NullProfilerScope("INSTANCE", 0);
        $VALUES = (new NullProfilerScope[] {
            INSTANCE
        });
    }
}

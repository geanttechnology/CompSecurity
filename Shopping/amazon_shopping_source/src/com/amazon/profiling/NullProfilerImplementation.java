// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.profiling;


// Referenced classes of package com.amazon.profiling:
//            ProfilerImplementation, NullProfilerScope, ProfilerScope

public final class NullProfilerImplementation extends Enum
    implements ProfilerImplementation
{

    private static final NullProfilerImplementation $VALUES[];
    public static final NullProfilerImplementation INSTANCE;

    private NullProfilerImplementation(String s, int i)
    {
        super(s, i);
    }

    public static NullProfilerImplementation valueOf(String s)
    {
        return (NullProfilerImplementation)Enum.valueOf(com/amazon/profiling/NullProfilerImplementation, s);
    }

    public static NullProfilerImplementation[] values()
    {
        return (NullProfilerImplementation[])$VALUES.clone();
    }

    public void closeScope(ProfilerScope profilerscope)
    {
    }

    public ProfilerScope createMethodProfilerScope(Class class1, String s)
    {
        return NullProfilerScope.INSTANCE;
    }

    public ProfilerScope createProfilerScope(String s)
    {
        return NullProfilerScope.INSTANCE;
    }

    static 
    {
        INSTANCE = new NullProfilerImplementation("INSTANCE", 0);
        $VALUES = (new NullProfilerImplementation[] {
            INSTANCE
        });
    }
}

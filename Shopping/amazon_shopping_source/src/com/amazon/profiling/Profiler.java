// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.profiling;


// Referenced classes of package com.amazon.profiling:
//            NullProfilerImplementation, ProfilerImplementation, ProfilerScope

public abstract class Profiler
{

    private static ProfilerImplementation impl;

    protected Profiler()
    {
    }

    public static ProfilerScope methodScopeStart(Class class1, String s)
    {
        return impl.createMethodProfilerScope(class1, s);
    }

    public static void scopeEnd(ProfilerScope profilerscope)
    {
        impl.closeScope(profilerscope);
    }

    public static ProfilerScope scopeStart(String s)
    {
        return impl.createProfilerScope(s);
    }

    public static void setProfilerFactory(ProfilerImplementation profilerimplementation)
    {
        impl = profilerimplementation;
    }

    static 
    {
        impl = NullProfilerImplementation.INSTANCE;
    }
}

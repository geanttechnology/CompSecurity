// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.profiling;


// Referenced classes of package com.amazon.profiling:
//            ProfilerScope

public interface ProfilerImplementation
{

    public abstract void closeScope(ProfilerScope profilerscope);

    public abstract ProfilerScope createMethodProfilerScope(Class class1, String s);

    public abstract ProfilerScope createProfilerScope(String s);
}

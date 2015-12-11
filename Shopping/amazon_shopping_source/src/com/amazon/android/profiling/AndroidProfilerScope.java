// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.profiling;

import com.amazon.profiling.ProfilerScope;

public class AndroidProfilerScope
    implements ProfilerScope
{

    public final boolean method;
    public final String name;
    public final long start;

    public AndroidProfilerScope(boolean flag, String s, long l)
    {
        method = flag;
        name = s;
        start = l;
    }
}

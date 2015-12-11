// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.spi;

import com.google.inject.internal.util.StackTraceElements;
import java.lang.reflect.Member;

// Referenced classes of package com.google.inject.spi:
//            Dependency

public final class DependencyAndSource
{

    private final Dependency dependency;
    private final Object source;

    public DependencyAndSource(Dependency dependency1, Object obj)
    {
        dependency = dependency1;
        source = obj;
    }

    public String getBindingSource()
    {
        if (source instanceof Class)
        {
            return StackTraceElements.forType((Class)source).toString();
        }
        if (source instanceof Member)
        {
            return StackTraceElements.forMember((Member)source).toString();
        } else
        {
            return source.toString();
        }
    }

    public Dependency getDependency()
    {
        return dependency;
    }

    public String toString()
    {
        Dependency dependency1 = getDependency();
        String s = getBindingSource();
        if (dependency1 != null)
        {
            return (new StringBuilder()).append("Dependency: ").append(dependency1).append(", source: ").append(s).toString();
        } else
        {
            return (new StringBuilder()).append("Source: ").append(s).toString();
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.spi;

import com.google.inject.Key;
import java.lang.reflect.Method;

// Referenced classes of package com.google.inject.spi:
//            HasDependencies

public interface ProvidesMethodBinding
    extends HasDependencies
{

    public abstract Object getEnclosingInstance();

    public abstract Key getKey();

    public abstract Method getMethod();
}

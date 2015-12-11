// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.util;

import com.google.inject.Module;
import java.util.Arrays;
import org.roboguice.shaded.goole.common.collect.ImmutableSet;

// Referenced classes of package com.google.inject.util:
//            Modules

private static final class <init>
    implements <init>
{

    private final ImmutableSet baseModules;

    public Module with(Iterable iterable)
    {
        return new <init>(iterable, baseModules);
    }

    public transient Module with(Module amodule[])
    {
        return with(((Iterable) (Arrays.asList(amodule))));
    }

    private (Iterable iterable)
    {
        baseModules = ImmutableSet.copyOf(iterable);
    }

    Of(Iterable iterable, Of of)
    {
        this(iterable);
    }
}

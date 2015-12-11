// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.util;

import com.google.inject.Binder;
import com.google.inject.Module;
import java.util.Iterator;
import java.util.Set;
import org.roboguice.shaded.goole.common.collect.ImmutableSet;

// Referenced classes of package com.google.inject.util:
//            Modules

private static class tableSet.copyOf
    implements Module
{

    final Set modulesSet;

    public void configure(Binder binder)
    {
        binder = binder.skipSources(new Class[] {
            getClass()
        });
        for (Iterator iterator = modulesSet.iterator(); iterator.hasNext(); binder.install((Module)iterator.next())) { }
    }

    tableSet(Iterable iterable)
    {
        modulesSet = ImmutableSet.copyOf(iterable);
    }
}

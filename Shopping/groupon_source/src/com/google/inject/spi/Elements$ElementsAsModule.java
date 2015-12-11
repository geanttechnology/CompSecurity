// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.spi;

import com.google.inject.Binder;
import com.google.inject.Module;
import java.util.Iterator;

// Referenced classes of package com.google.inject.spi:
//            Elements, Element

private static class elements
    implements Module
{

    private final Iterable elements;

    public void configure(Binder binder)
    {
        for (Iterator iterator = elements.iterator(); iterator.hasNext(); ((Element)iterator.next()).applyTo(binder)) { }
    }

    (Iterable iterable)
    {
        elements = iterable;
    }
}

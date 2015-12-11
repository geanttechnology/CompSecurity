// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal.util;

import java.util.Iterator;
import java.util.List;
import org.roboguice.shaded.goole.common.base.Preconditions;
import org.roboguice.shaded.goole.common.collect.ImmutableSet;
import org.roboguice.shaded.goole.common.collect.Lists;

public final class SourceProvider
{

    public static final SourceProvider DEFAULT_INSTANCE = new SourceProvider(ImmutableSet.of(com/google/inject/internal/util/SourceProvider.getName()));
    public static final Object UNKNOWN_SOURCE = "[unknown source]";
    private final ImmutableSet classNamesToSkip;
    private final SourceProvider parent;

    private SourceProvider(SourceProvider sourceprovider, Iterable iterable)
    {
        parent = sourceprovider;
        org.roboguice.shaded.goole.common.collect.ImmutableSet.Builder builder = ImmutableSet.builder();
        iterable = iterable.iterator();
        do
        {
            if (!iterable.hasNext())
            {
                break;
            }
            String s = (String)iterable.next();
            if (sourceprovider == null || !sourceprovider.shouldBeSkipped(s))
            {
                builder.add(s);
            }
        } while (true);
        classNamesToSkip = builder.build();
    }

    private SourceProvider(Iterable iterable)
    {
        this(null, iterable);
    }

    private static transient List asStrings(Class aclass[])
    {
        java.util.ArrayList arraylist = Lists.newArrayList();
        int j = aclass.length;
        for (int i = 0; i < j; i++)
        {
            arraylist.add(aclass[i].getName());
        }

        return arraylist;
    }

    private boolean shouldBeSkipped(String s)
    {
        return parent != null && parent.shouldBeSkipped(s) || classNamesToSkip.contains(s);
    }

    public StackTraceElement get(StackTraceElement astacktraceelement[])
    {
        Preconditions.checkNotNull(astacktraceelement, "The stack trace elements cannot be null.");
        int j = astacktraceelement.length;
        for (int i = 0; i < j; i++)
        {
            StackTraceElement stacktraceelement = astacktraceelement[i];
            if (!shouldBeSkipped(stacktraceelement.getClassName()))
            {
                return stacktraceelement;
            }
        }

        throw new AssertionError();
    }

    public Object getFromClassNames(List list)
    {
        Preconditions.checkNotNull(list, "The list of module class names cannot be null.");
        for (list = list.iterator(); list.hasNext();)
        {
            String s = (String)list.next();
            if (!shouldBeSkipped(s))
            {
                return new StackTraceElement(s, "configure", null, -1);
            }
        }

        return UNKNOWN_SOURCE;
    }

    public transient SourceProvider plusSkippedClasses(Class aclass[])
    {
        return new SourceProvider(this, asStrings(aclass));
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.spi;

import com.google.inject.Module;
import com.google.inject.internal.util.StackTraceElements;
import java.util.List;
import org.roboguice.shaded.goole.common.base.Preconditions;
import org.roboguice.shaded.goole.common.collect.ImmutableList;

final class ModuleSource
{

    private final String moduleClassName;
    private final ModuleSource parent;
    private final com.google.inject.internal.util.StackTraceElements.InMemoryStackTraceElement partialCallStack[];

    ModuleSource(Module module, StackTraceElement astacktraceelement[])
    {
        this(null, module, astacktraceelement);
    }

    private ModuleSource(ModuleSource modulesource, Module module, StackTraceElement astacktraceelement[])
    {
        Preconditions.checkNotNull(module, "module cannot be null.");
        Preconditions.checkNotNull(astacktraceelement, "partialCallStack cannot be null.");
        parent = modulesource;
        moduleClassName = module.getClass().getName();
        partialCallStack = StackTraceElements.convertToInMemoryStackTraceElement(astacktraceelement);
    }

    ModuleSource createChild(Module module, StackTraceElement astacktraceelement[])
    {
        return new ModuleSource(this, module, astacktraceelement);
    }

    String getModuleClassName()
    {
        return moduleClassName;
    }

    List getModuleClassNames()
    {
        org.roboguice.shaded.goole.common.collect.ImmutableList.Builder builder = ImmutableList.builder();
        for (ModuleSource modulesource = this; modulesource != null; modulesource = modulesource.parent)
        {
            builder.add(modulesource.moduleClassName);
        }

        return builder.build();
    }

    ModuleSource getParent()
    {
        return parent;
    }

    StackTraceElement[] getPartialCallStack()
    {
        return StackTraceElements.convertToStackTraceElement(partialCallStack);
    }

    int getPartialCallStackSize()
    {
        return partialCallStack.length;
    }

    StackTraceElement[] getStackTrace()
    {
        StackTraceElement astacktraceelement[] = new StackTraceElement[getStackTraceSize()];
        int i = 0;
        for (ModuleSource modulesource = this; modulesource != null;)
        {
            StackTraceElement astacktraceelement1[] = StackTraceElements.convertToStackTraceElement(modulesource.partialCallStack);
            int j = astacktraceelement1.length;
            System.arraycopy(astacktraceelement1, 0, astacktraceelement, i, j);
            modulesource = modulesource.parent;
            i += j;
        }

        return astacktraceelement;
    }

    int getStackTraceSize()
    {
        if (parent == null)
        {
            return partialCallStack.length;
        } else
        {
            return parent.getStackTraceSize() + partialCallStack.length;
        }
    }

    int size()
    {
        if (parent == null)
        {
            return 1;
        } else
        {
            return parent.size() + 1;
        }
    }
}

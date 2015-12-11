// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.spi;

import com.google.inject.internal.util.StackTraceElements;
import java.util.List;
import org.roboguice.shaded.goole.common.base.Preconditions;
import org.roboguice.shaded.goole.common.collect.ImmutableList;

// Referenced classes of package com.google.inject.spi:
//            ModuleSource

public final class ElementSource
{

    final Object declaringSource;
    final ModuleSource moduleSource;
    final ElementSource originalElementSource;
    final com.google.inject.internal.util.StackTraceElements.InMemoryStackTraceElement partialCallStack[];

    ElementSource(ElementSource elementsource, Object obj, ModuleSource modulesource, StackTraceElement astacktraceelement[])
    {
        Preconditions.checkNotNull(obj, "declaringSource cannot be null.");
        Preconditions.checkNotNull(modulesource, "moduleSource cannot be null.");
        Preconditions.checkNotNull(astacktraceelement, "partialCallStack cannot be null.");
        originalElementSource = elementsource;
        declaringSource = obj;
        moduleSource = modulesource;
        partialCallStack = StackTraceElements.convertToInMemoryStackTraceElement(astacktraceelement);
    }

    public Object getDeclaringSource()
    {
        return declaringSource;
    }

    public List getModuleClassNames()
    {
        return moduleSource.getModuleClassNames();
    }

    public List getModuleConfigurePositionsInStackTrace()
    {
        int j = moduleSource.size();
        Integer ainteger[] = new Integer[j];
        ainteger[0] = Integer.valueOf(partialCallStack.length - 1);
        ModuleSource modulesource = moduleSource;
        for (int i = 1; i < j; i++)
        {
            int k = modulesource.getPartialCallStackSize();
            ainteger[i] = Integer.valueOf(ainteger[i - 1].intValue() + k);
            modulesource = modulesource.getParent();
        }

        return ImmutableList.copyOf(ainteger);
    }

    public ElementSource getOriginalElementSource()
    {
        return originalElementSource;
    }

    public StackTraceElement[] getStackTrace()
    {
        int i = moduleSource.getStackTraceSize();
        int j = partialCallStack.length;
        StackTraceElement astacktraceelement[] = new StackTraceElement[moduleSource.getStackTraceSize() + j];
        System.arraycopy(StackTraceElements.convertToStackTraceElement(partialCallStack), 0, astacktraceelement, 0, j);
        System.arraycopy(moduleSource.getStackTrace(), 0, astacktraceelement, j, i);
        return astacktraceelement;
    }

    public String toString()
    {
        return getDeclaringSource().toString();
    }
}

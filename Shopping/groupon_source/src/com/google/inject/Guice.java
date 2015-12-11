// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject;

import com.google.inject.internal.InternalInjectorCreator;
import java.util.Arrays;
import java.util.Iterator;

// Referenced classes of package com.google.inject:
//            HierarchyTraversalFilterFactory, AnnotatedGuiceHierarchyTraversalFilter, Stage, Module, 
//            AbstractModule, AnnotationDatabaseFinder, HierarchyTraversalFilter, Injector

public final class Guice
{

    private static AnnotationDatabaseFinder annotationDatabaseFinder;
    private static HierarchyTraversalFilterFactory hierarchyTraversalFilterFactory = new HierarchyTraversalFilterFactory();

    private Guice()
    {
    }

    public static HierarchyTraversalFilter createHierarchyTraversalFilter()
    {
        HierarchyTraversalFilter hierarchytraversalfilter = hierarchyTraversalFilterFactory.createHierarchyTraversalFilter();
        if (annotationDatabaseFinder == null)
        {
            return hierarchytraversalfilter;
        } else
        {
            return new AnnotatedGuiceHierarchyTraversalFilter(annotationDatabaseFinder, hierarchytraversalfilter);
        }
    }

    public static Injector createInjector(Stage stage, Iterable iterable)
    {
        doSetAnnotationDatabaseFinderToModules(iterable);
        return (new InternalInjectorCreator()).stage(stage).addModules(iterable).build();
    }

    public static transient Injector createInjector(Stage stage, Module amodule[])
    {
        return createInjector(stage, ((Iterable) (Arrays.asList(amodule))));
    }

    public static Injector createInjector(Iterable iterable)
    {
        return createInjector(Stage.DEVELOPMENT, iterable);
    }

    public static transient Injector createInjector(Module amodule[])
    {
        return createInjector(((Iterable) (Arrays.asList(amodule))));
    }

    private static void doSetAnnotationDatabaseFinderToModules(Iterable iterable)
    {
        iterable = iterable.iterator();
        do
        {
            if (!iterable.hasNext())
            {
                break;
            }
            Module module = (Module)iterable.next();
            if (module instanceof AbstractModule)
            {
                ((AbstractModule)module).setAnnotationDatabaseFinder(annotationDatabaseFinder);
            }
        } while (true);
    }

    public static AnnotationDatabaseFinder getAnnotationDatabaseFinder()
    {
        return annotationDatabaseFinder;
    }

    public static void setAnnotationDatabasePackageNames(String as[])
    {
        if (as != null && as.length != 0)
        {
            annotationDatabaseFinder = new AnnotationDatabaseFinder(as);
            return;
        } else
        {
            annotationDatabaseFinder = null;
            return;
        }
    }

    public static void setHierarchyTraversalFilterFactory(HierarchyTraversalFilterFactory hierarchytraversalfilterfactory)
    {
        hierarchyTraversalFilterFactory = hierarchytraversalfilterfactory;
    }

}

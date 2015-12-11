// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch;

import com.amazon.ansel.fetch.tools.ref.WeakObjectReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.amazon.ansel.fetch:
//            ResourceLoader, LoaderContext, AbstractLoaderListener

public abstract class LoaderGroup
{
    private class ItemListener extends AbstractLoaderListener
    {

        private final ResourceLoader loader;
        final LoaderGroup this$0;

        public void done()
        {
            loaderDone(loader);
        }

        public ItemListener(ResourceLoader resourceloader)
        {
            this$0 = LoaderGroup.this;
            super();
            loader = resourceloader;
        }
    }


    private final LoaderContext context;
    private final Set loaders;
    private final LoaderGroup parent;

    public LoaderGroup(LoaderContext loadercontext)
    {
        this(loadercontext, null);
    }

    private LoaderGroup(LoaderContext loadercontext, LoaderGroup loadergroup)
    {
        loaders = Collections.newSetFromMap(new ConcurrentHashMap());
        context = loadercontext;
        parent = loadergroup;
    }

    public LoaderGroup(LoaderGroup loadergroup)
    {
        this(loadergroup.getContext(), loadergroup);
    }

    public void cancel()
    {
        for (Iterator iterator = loaders.iterator(); iterator.hasNext(); ((ResourceLoader)iterator.next()).cancel()) { }
    }

    public void execute(ResourceLoader resourceloader)
    {
        loaders.add(resourceloader);
        resourceloader.addListener(new WeakObjectReference(new ItemListener(resourceloader)));
        runLoader(resourceloader);
    }

    public LoaderContext getContext()
    {
        return context;
    }

    protected void loaderDone(ResourceLoader resourceloader)
    {
        loaders.remove(resourceloader);
    }

    protected void runLoader(ResourceLoader resourceloader)
    {
        if (parent != null)
        {
            parent.execute(resourceloader);
            return;
        } else
        {
            resourceloader.execute();
            return;
        }
    }
}

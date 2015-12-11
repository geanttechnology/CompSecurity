// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.Key;
import com.google.inject.spi.Dependency;
import com.google.inject.spi.DependencyAndSource;
import java.util.List;
import java.util.Map;
import org.roboguice.shaded.goole.common.collect.ImmutableList;
import org.roboguice.shaded.goole.common.collect.Lists;
import org.roboguice.shaded.goole.common.collect.Maps;

// Referenced classes of package com.google.inject.internal:
//            ConstructionContext

final class InternalContext
{

    private Map constructionContexts;
    private Dependency dependency;
    private final List state = Lists.newArrayList();

    InternalContext()
    {
        constructionContexts = Maps.newHashMap();
    }

    public ConstructionContext getConstructionContext(Object obj)
    {
        ConstructionContext constructioncontext1 = (ConstructionContext)constructionContexts.get(obj);
        ConstructionContext constructioncontext = constructioncontext1;
        if (constructioncontext1 == null)
        {
            constructioncontext = new ConstructionContext();
            constructionContexts.put(obj, constructioncontext);
        }
        return constructioncontext;
    }

    public Dependency getDependency()
    {
        return dependency;
    }

    public List getDependencyChain()
    {
        org.roboguice.shaded.goole.common.collect.ImmutableList.Builder builder = ImmutableList.builder();
        for (int i = 0; i < state.size(); i += 2)
        {
            builder.add(new DependencyAndSource((Dependency)state.get(i), state.get(i + 1)));
        }

        return builder.build();
    }

    public void popState()
    {
        state.remove(state.size() - 1);
        state.remove(state.size() - 1);
    }

    public void popStateAndSetDependency(Dependency dependency1)
    {
        popState();
        dependency = dependency1;
    }

    public Dependency pushDependency(Dependency dependency1, Object obj)
    {
        Dependency dependency2 = dependency;
        dependency = dependency1;
        state.add(dependency1);
        state.add(obj);
        return dependency2;
    }

    public void pushState(Key key, Object obj)
    {
        List list = state;
        if (key == null)
        {
            key = null;
        } else
        {
            key = Dependency.get(key);
        }
        list.add(key);
        state.add(obj);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger;

import dagger.internal.Binding;
import dagger.internal.Keys;
import dagger.internal.Linker;
import dagger.internal.ModuleAdapter;
import dagger.internal.Plugin;
import dagger.internal.RuntimeAggregatingPlugin;
import dagger.internal.ThrowingErrorHandler;
import dagger.internal.UniqueMap;
import dagger.internal.plugins.loading.ClassloadingPlugin;
import dagger.internal.plugins.reflect.ReflectivePlugin;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ObjectGraph
{

    private final ObjectGraph base;
    private final Map entryPoints;
    private final Linker linker;
    private final Plugin plugin;
    private final Map staticInjections;

    ObjectGraph(ObjectGraph objectgraph, Linker linker1, Plugin plugin1, Map map, Map map1)
    {
        if (linker1 == null)
        {
            throw new NullPointerException("linker");
        }
        if (plugin1 == null)
        {
            throw new NullPointerException("plugin");
        }
        if (map == null)
        {
            throw new NullPointerException("staticInjections");
        }
        if (map1 == null)
        {
            throw new NullPointerException("entryPoints");
        } else
        {
            base = objectgraph;
            linker = linker1;
            plugin = plugin1;
            staticInjections = map;
            entryPoints = map1;
            return;
        }
    }

    public static transient ObjectGraph create(Object aobj[])
    {
        return makeGraph(null, new RuntimeAggregatingPlugin(new Plugin[] {
            new ClassloadingPlugin(), new ReflectivePlugin()
        }), aobj);
    }

    private Binding getEntryPointBinding(String s, String s1)
    {
        Class class1;
        class1 = null;
        ObjectGraph objectgraph = this;
label0:
        do
        {
label1:
            {
                if (objectgraph != null)
                {
                    class1 = (Class)objectgraph.entryPoints.get(s);
                    if (class1 == null)
                    {
                        break label1;
                    }
                }
                if (class1 == null)
                {
                    throw new IllegalArgumentException((new StringBuilder()).append("No entry point for ").append(s).append(". You must explicitly add an entry point to one of your modules.").toString());
                }
                break label0;
            }
            objectgraph = objectgraph.base;
        } while (true);
        Linker linker1 = linker;
        linker1;
        JVM INSTR monitorenter ;
        Binding binding = linker.requestBinding(s1, class1, false);
        if (binding == null)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        s = binding;
        if (binding.isLinked())
        {
            break MISSING_BLOCK_LABEL_130;
        }
        linker.linkRequested();
        s = linker.requestBinding(s1, class1, false);
        linker1;
        JVM INSTR monitorexit ;
        return s;
        s;
        linker1;
        JVM INSTR monitorexit ;
        throw s;
    }

    private static transient ObjectGraph makeGraph(ObjectGraph objectgraph, Plugin plugin1, Object aobj[])
    {
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        LinkedHashMap linkedhashmap1 = new LinkedHashMap();
        UniqueMap uniquemap = new UniqueMap();
        UniqueMap uniquemap1 = new UniqueMap();
        Iterator iterator = RuntimeAggregatingPlugin.getAllModuleAdapters(plugin1, aobj).values().iterator();
        while (iterator.hasNext()) 
        {
            ModuleAdapter moduleadapter = (ModuleAdapter)iterator.next();
            aobj = moduleadapter.entryPoints;
            int k = aobj.length;
            for (int i = 0; i < k; i++)
            {
                linkedhashmap.put(aobj[i], moduleadapter.getModule().getClass());
            }

            aobj = moduleadapter.staticInjections;
            k = aobj.length;
            for (int j = 0; j < k; j++)
            {
                linkedhashmap1.put(aobj[j], null);
            }

            if (moduleadapter.overrides)
            {
                aobj = uniquemap1;
            } else
            {
                aobj = uniquemap;
            }
            moduleadapter.getBindings(((Map) (aobj)));
        }
        if (objectgraph != null)
        {
            aobj = objectgraph.linker;
        } else
        {
            aobj = null;
        }
        aobj = new Linker(((Linker) (aobj)), plugin1, new ThrowingErrorHandler());
        ((Linker) (aobj)).installBindings(uniquemap);
        ((Linker) (aobj)).installBindings(uniquemap1);
        return new ObjectGraph(objectgraph, ((Linker) (aobj)), plugin1, linkedhashmap1, linkedhashmap);
    }

    public Object inject(Object obj)
    {
        String s = Keys.getMembersKey(obj.getClass());
        getEntryPointBinding(s, s).injectMembers(obj);
        return obj;
    }
}

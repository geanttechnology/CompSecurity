// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal;

import dagger.ObjectGraph;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package dagger.internal:
//            Plugin, ModuleAdapter, Binding

public final class RuntimeAggregatingPlugin
    implements Plugin
{

    private static final Logger logger = Logger.getLogger(dagger/ObjectGraph.getName());
    private final Plugin plugins[];

    public transient RuntimeAggregatingPlugin(Plugin aplugin[])
    {
        if (aplugin == null || aplugin.length == 0)
        {
            throw new IllegalArgumentException("Must provide at least one plugin.");
        } else
        {
            plugins = aplugin;
            return;
        }
    }

    private static void collectIncludedModulesRecursively(Plugin plugin, ModuleAdapter moduleadapter, Map map)
    {
        moduleadapter = moduleadapter.includes;
        int j = moduleadapter.length;
        for (int i = 0; i < j; i++)
        {
            Class class1 = moduleadapter[i];
            if (!map.containsKey(class1))
            {
                ModuleAdapter moduleadapter1 = plugin.getModuleAdapter(class1, null);
                map.put(class1, moduleadapter1);
                collectIncludedModulesRecursively(plugin, moduleadapter1, map);
            }
        }

    }

    public static Map getAllModuleAdapters(Plugin plugin, Object aobj[])
    {
        ModuleAdapter amoduleadapter[] = new ModuleAdapter[aobj.length];
        int k1 = aobj.length;
        int l = 0;
        int i = 0;
        while (l < k1) 
        {
            Object obj = aobj[l];
            if (obj instanceof Class)
            {
                int i1 = i + 1;
                amoduleadapter[i] = plugin.getModuleAdapter((Class)obj, null);
                i = i1;
            } else
            {
                int j1 = i + 1;
                amoduleadapter[i] = plugin.getModuleAdapter(obj.getClass(), obj);
                i = j1;
            }
            l++;
        }
        aobj = new LinkedHashMap();
        l = amoduleadapter.length;
        for (int j = 0; j < l; j++)
        {
            ModuleAdapter moduleadapter = amoduleadapter[j];
            ((Map) (aobj)).put(moduleadapter.getModule().getClass(), moduleadapter);
        }

        l = amoduleadapter.length;
        for (int k = 0; k < l; k++)
        {
            collectIncludedModulesRecursively(plugin, amoduleadapter[k], ((Map) (aobj)));
        }

        return ((Map) (aobj));
    }

    private void logNotFound(String s, String s1, RuntimeException runtimeexception)
    {
        if (logger.isLoggable(Level.FINE))
        {
            logger.log(Level.FINE, String.format("%s for %s not found.", new Object[] {
                s, s1
            }), runtimeexception);
        }
    }

    public Binding getAtInjectBinding(String s, String s1, boolean flag)
    {
        int i = 0;
_L2:
        if (i >= plugins.length)
        {
            break; /* Loop/switch isn't completed */
        }
        Binding binding = plugins[i].getAtInjectBinding(s, s1, flag);
        return binding;
        RuntimeException runtimeexception;
        runtimeexception;
        if (i == plugins.length - 1)
        {
            throw runtimeexception;
        }
        logNotFound("Binding", s1, runtimeexception);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        throw new AssertionError();
    }

    public ModuleAdapter getModuleAdapter(Class class1, Object obj)
    {
        int i = 0;
_L3:
        if (i >= plugins.length)
        {
            break; /* Loop/switch isn't completed */
        }
        ModuleAdapter moduleadapter = plugins[i].getModuleAdapter(class1, obj);
        Object obj1;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        obj1 = obj;
_L1:
        moduleadapter.module = obj1;
        return moduleadapter;
        obj1 = moduleadapter.newModule();
          goto _L1
        RuntimeException runtimeexception;
        runtimeexception;
        if (i == plugins.length - 1)
        {
            throw runtimeexception;
        }
        logNotFound("Module adapter", class1.getName(), runtimeexception);
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        throw new AssertionError();
    }

}

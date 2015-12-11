// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf.module;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.amazon.client.framework.acf.ComponentRegistry;
import com.amazon.client.framework.acf.Components;
import com.amazon.client.framework.acf.util.AcfLog;
import com.amazon.client.framework.acf.util.ReflectionHelper;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.client.framework.acf.module:
//            ModuleLoadException, SameSignaturePackageVerifier, Module, PackageVerifier

public class AggregateComponentManager
    implements ComponentRegistry
{
    private static class ModuleData
    {

        public Bundle bundle;
        public ComponentRegistry componentRegistry;
        public final boolean isRequired;
        public Context module;
        public final String packageName;

        public ModuleData(ComponentRegistry componentregistry)
        {
            packageName = null;
            isRequired = false;
            componentRegistry = componentregistry;
        }

        public ModuleData(String s, Bundle bundle1, boolean flag)
        {
            packageName = s;
            bundle = bundle1;
            isRequired = flag;
        }
    }


    private static final String TAG = AcfLog.getTag(com/amazon/client/framework/acf/module/AggregateComponentManager);
    private ClassLoader mClassLoader;
    private final Context mContext;
    private final List mExternalModules;
    private final ComponentRegistry mLocalComponents;
    private PackageVerifier mPackageVerifier;

    public AggregateComponentManager(Context context, ComponentRegistry componentregistry)
    {
        this(context, componentregistry, (String[])null);
    }

    public transient AggregateComponentManager(Context context, ComponentRegistry componentregistry, ClassLoader classloader, String as[])
    {
        if (context == null)
        {
            throw new IllegalArgumentException("Null context object passed into method.");
        }
        mClassLoader = classloader;
        int i;
        if (as == null)
        {
            i = 0;
        } else
        {
            i = as.length;
        }
        mExternalModules = new ArrayList(i);
        mContext = context;
        mLocalComponents = componentregistry;
        Components.register(mLocalComponents, com/amazon/client/framework/acf/ComponentRegistry, this);
        Components.register(mLocalComponents, com/amazon/client/framework/acf/module/AggregateComponentManager, this);
        declareOptionalPackages(as);
    }

    public transient AggregateComponentManager(Context context, ComponentRegistry componentregistry, String as[])
    {
        ClassLoader classloader;
        if (context == null)
        {
            classloader = null;
        } else
        {
            classloader = context.getClass().getClassLoader();
        }
        this(context, componentregistry, classloader, as);
    }

    public transient AggregateComponentManager(Context context, String as[])
    {
        this(context, Components.createDefaultComponentRegistry(context), as);
    }

    private ModuleData getDataForPackage(String s)
    {
        for (Iterator iterator = mExternalModules.iterator(); iterator.hasNext();)
        {
            ModuleData moduledata = (ModuleData)iterator.next();
            if (moduledata.packageName.equals(s))
            {
                return moduledata;
            }
        }

        return null;
    }

    public void addComponentRegistry(ComponentRegistry componentregistry)
    {
        mExternalModules.add(new ModuleData(componentregistry));
    }

    public void declareOptionalPackage(String s, Bundle bundle)
    {
        mExternalModules.add(new ModuleData(s, bundle, false));
    }

    public transient void declareOptionalPackages(String as[])
    {
        if (as != null)
        {
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                String s = as[i];
                mExternalModules.add(new ModuleData(s, null, false));
            }

        }
    }

    public void declareRequiredPackage(String s, Bundle bundle)
    {
        mExternalModules.add(new ModuleData(s, bundle, true));
    }

    public transient void declareRequiredPackages(String as[])
    {
        if (as != null)
        {
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                String s = as[i];
                mExternalModules.add(new ModuleData(s, null, true));
            }

        }
    }

    public ClassLoader getClassLoader()
    {
        return mClassLoader;
    }

    public Object getComponent(String s)
    {
        Object obj = mLocalComponents.getComponent(s);
        Iterator iterator = mExternalModules.iterator();
        do
        {
            ModuleData moduledata;
label0:
            {
                if (iterator.hasNext())
                {
                    moduledata = (ModuleData)iterator.next();
                    if (obj == null)
                    {
                        break label0;
                    }
                }
                return obj;
            }
            if (moduledata.componentRegistry != null)
            {
                if (moduledata.componentRegistry != this)
                {
                    obj = moduledata.componentRegistry.getComponent(s);
                } else
                {
                    Log.i(TAG, "Component registry added to itself.  Did you create a ComponentizedContext without a Component registry?");
                }
            }
        } while (true);
    }

    public Context getLoadedContext(String s)
    {
        s = getDataForPackage(s);
        if (s == null)
        {
            return null;
        } else
        {
            return ((ModuleData) (s)).module;
        }
    }

    public void load()
    {
        if (mExternalModules.size() == 0)
        {
            return;
        }
        ClassLoader classloader = mClassLoader;
        Object obj1 = mPackageVerifier;
        Object obj = obj1;
        if (obj1 == null)
        {
            obj = new SameSignaturePackageVerifier();
        }
        obj1 = mExternalModules.iterator();
        do
        {
            if (((Iterator) (obj1)).hasNext())
            {
                ModuleData moduledata = (ModuleData)((Iterator) (obj1)).next();
                if (moduledata.module == null && moduledata.packageName != null)
                {
                    if (moduledata.isRequired)
                    {
                        moduledata.module = Module.loadModule(mContext, moduledata.packageName, moduledata.bundle, classloader, ((PackageVerifier) (obj)));
                    } else
                    {
                        try
                        {
                            moduledata.module = Module.loadModule(mContext, moduledata.packageName, moduledata.bundle, classloader, ((PackageVerifier) (obj)));
                        }
                        catch (ModuleLoadException moduleloadexception)
                        {
                            Log.v(TAG, (new StringBuilder()).append("External library ").append(moduledata.packageName).append(" not available.").toString());
                        }
                    }
                }
                if (moduledata.module != null)
                {
                    moduledata.componentRegistry = (ComponentRegistry)Components.optional(moduledata.module, com/amazon/client/framework/acf/ComponentRegistry);
                    classloader = moduledata.module.getClassLoader();
                }
            } else
            {
                mClassLoader = classloader;
                return;
            }
        } while (true);
    }

    public List loadedPackages()
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = mExternalModules.iterator(); iterator.hasNext(); arraylist.add(((ModuleData)iterator.next()).packageName)) { }
        return arraylist;
    }

    public void onCreate()
    {
        load();
    }

    public void onDestroy()
    {
        mLocalComponents.onDestroy();
        Iterator iterator = mExternalModules.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ModuleData moduledata = (ModuleData)iterator.next();
            Context context = moduledata.module;
            if (context != null)
            {
                try
                {
                    ReflectionHelper.invokeMethodIfExists(context.getClass(), context, "onDestroy");
                }
                catch (InvocationTargetException invocationtargetexception)
                {
                    throw new RuntimeException(invocationtargetexception);
                }
            } else
            if (moduledata.componentRegistry != null)
            {
                moduledata.componentRegistry.onDestroy();
            }
        } while (true);
        mExternalModules.clear();
    }

    public Object registerComponent(String s, Object obj)
    {
        return mLocalComponents.registerComponent(s, obj);
    }

    public void setPackageVerifier(PackageVerifier packageverifier)
    {
        mPackageVerifier = packageverifier;
    }

    public void unload(String s)
    {
        s = getDataForPackage(s);
        if (s != null)
        {
            Context context = ((ModuleData) (s)).module;
            s.componentRegistry = null;
            s.module = null;
            if (context != null)
            {
                try
                {
                    ReflectionHelper.invokeMethodIfExists(context.getClass(), context, "onDestroy");
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    throw new RuntimeException(s);
                }
            }
        }
    }

}

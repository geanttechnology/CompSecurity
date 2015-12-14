// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.model;

import android.content.Context;
import com.bumptech.glide.load.data.DataFetcher;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.bumptech.glide.load.model:
//            ModelLoader, ModelLoaderFactory

public class GenericLoaderFactory
{

    private static final ModelLoader NULL_MODEL_LOADER = new ModelLoader() {

        public DataFetcher getResourceFetcher(Object obj, int i, int j)
        {
            throw new NoSuchMethodError("This should never be called!");
        }

        public String toString()
        {
            return "NULL_MODEL_LOADER";
        }

    };
    private final Map cachedModelLoaders = new HashMap();
    private final Context context;
    private final Map modelClassToResourceFactories = new HashMap();

    public GenericLoaderFactory(Context context1)
    {
        context = context1.getApplicationContext();
    }

    private void cacheModelLoader(Class class1, Class class2, ModelLoader modelloader)
    {
        Map map = (Map)cachedModelLoaders.get(class1);
        Object obj = map;
        if (map == null)
        {
            obj = new HashMap();
            cachedModelLoaders.put(class1, obj);
        }
        ((Map) (obj)).put(class2, modelloader);
    }

    private void cacheNullLoader(Class class1, Class class2)
    {
        cacheModelLoader(class1, class2, NULL_MODEL_LOADER);
    }

    private ModelLoader getCachedLoader(Class class1, Class class2)
    {
        Map map = (Map)cachedModelLoaders.get(class1);
        class1 = null;
        if (map != null)
        {
            class1 = (ModelLoader)map.get(class2);
        }
        return class1;
    }

    private ModelLoaderFactory getFactory(Class class1, Class class2)
    {
        Object obj1 = (Map)modelClassToResourceFactories.get(class1);
        Object obj = null;
        if (obj1 != null)
        {
            obj = (ModelLoaderFactory)((Map) (obj1)).get(class2);
        }
        obj1 = obj;
        if (obj == null)
        {
            Iterator iterator = modelClassToResourceFactories.keySet().iterator();
label0:
            do
            {
                do
                {
                    do
                    {
                        obj1 = obj;
                        if (!iterator.hasNext())
                        {
                            break label0;
                        }
                        obj1 = (Class)iterator.next();
                    } while (!((Class) (obj1)).isAssignableFrom(class1));
                    obj1 = (Map)modelClassToResourceFactories.get(obj1);
                } while (obj1 == null);
                obj1 = (ModelLoaderFactory)((Map) (obj1)).get(class2);
                obj = obj1;
            } while (obj1 == null);
        }
        return ((ModelLoaderFactory) (obj1));
    }

    public ModelLoader buildModelLoader(Class class1, Class class2)
    {
        this;
        JVM INSTR monitorenter ;
        ModelLoader modelloader = getCachedLoader(class1, class2);
        if (modelloader == null) goto _L2; else goto _L1
_L1:
        boolean flag = NULL_MODEL_LOADER.equals(modelloader);
        if (flag)
        {
            class1 = null;
        } else
        {
            class1 = modelloader;
        }
_L4:
        this;
        JVM INSTR monitorexit ;
        return class1;
_L2:
        ModelLoaderFactory modelloaderfactory = getFactory(class1, class2);
        if (modelloaderfactory == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        modelloader = modelloaderfactory.build(context, this);
        cacheModelLoader(class1, class2, modelloader);
        class1 = modelloader;
        continue; /* Loop/switch isn't completed */
        cacheNullLoader(class1, class2);
        class1 = modelloader;
        if (true) goto _L4; else goto _L3
_L3:
        class1;
        throw class1;
    }

    public ModelLoaderFactory register(Class class1, Class class2, ModelLoaderFactory modelloaderfactory)
    {
        this;
        JVM INSTR monitorenter ;
        Map map;
        cachedModelLoaders.clear();
        map = (Map)modelClassToResourceFactories.get(class1);
        Object obj;
        obj = map;
        if (map != null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        obj = new HashMap();
        modelClassToResourceFactories.put(class1, obj);
        class2 = (ModelLoaderFactory)((Map) (obj)).put(class2, modelloaderfactory);
        class1 = class2;
        if (class2 == null)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        modelloaderfactory = modelClassToResourceFactories.values().iterator();
_L2:
        class1 = class2;
        boolean flag;
        if (!modelloaderfactory.hasNext())
        {
            break MISSING_BLOCK_LABEL_126;
        }
        flag = ((Map)modelloaderfactory.next()).containsValue(class2);
        if (!flag) goto _L2; else goto _L1
_L1:
        class1 = null;
        return class1;
        class1;
        throw class1;
    }

}

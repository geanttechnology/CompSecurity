// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.provider;

import com.bumptech.glide.util.MultiClassKey;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.bumptech.glide.provider:
//            DataLoadProvider, EmptyDataLoadProvider

public class DataLoadProviderRegistry
{

    private static final MultiClassKey GET_KEY = new MultiClassKey();
    private final Map providers = new HashMap();

    public DataLoadProviderRegistry()
    {
    }

    public DataLoadProvider get(Class class1, Class class2)
    {
        synchronized (GET_KEY)
        {
            GET_KEY.set(class1, class2);
            class2 = (DataLoadProvider)providers.get(GET_KEY);
        }
        class1 = class2;
        if (class2 == null)
        {
            class1 = EmptyDataLoadProvider.get();
        }
        return class1;
        class1;
        multiclasskey;
        JVM INSTR monitorexit ;
        throw class1;
    }

    public void register(Class class1, Class class2, DataLoadProvider dataloadprovider)
    {
        providers.put(new MultiClassKey(class1, class2), dataloadprovider);
    }

}

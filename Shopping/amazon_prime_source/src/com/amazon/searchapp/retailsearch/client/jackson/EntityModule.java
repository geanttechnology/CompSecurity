// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.jackson;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;

// Referenced classes of package com.amazon.searchapp.retailsearch.client.jackson:
//            EntityMap

public class EntityModule
{

    private static volatile SimpleModule module;

    public EntityModule()
    {
    }

    public static SimpleModule getModule()
    {
        com/amazon/searchapp/retailsearch/client/jackson/EntityModule;
        JVM INSTR monitorenter ;
        SimpleModule simplemodule;
        if (module == null)
        {
            module = new SimpleModule(com/amazon/searchapp/retailsearch/client/jackson/EntityModule.getSimpleName(), Version.unknownVersion());
            EntityMap.mapTypes(module);
        }
        simplemodule = module;
        com/amazon/searchapp/retailsearch/client/jackson/EntityModule;
        JVM INSTR monitorexit ;
        return simplemodule;
        Exception exception;
        exception;
        throw exception;
    }
}

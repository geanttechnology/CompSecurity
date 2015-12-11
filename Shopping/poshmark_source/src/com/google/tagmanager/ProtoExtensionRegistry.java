// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import com.google.analytics.containertag.proto.Serving;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;

class ProtoExtensionRegistry
{

    private static ExtensionRegistryLite registry;

    ProtoExtensionRegistry()
    {
    }

    public static ExtensionRegistryLite getRegistry()
    {
        com/google/tagmanager/ProtoExtensionRegistry;
        JVM INSTR monitorenter ;
        ExtensionRegistryLite extensionregistrylite;
        if (registry == null)
        {
            registry = ExtensionRegistryLite.newInstance();
            Serving.registerAllExtensions(registry);
        }
        extensionregistrylite = registry;
        com/google/tagmanager/ProtoExtensionRegistry;
        JVM INSTR monitorexit ;
        return extensionregistrylite;
        Exception exception;
        exception;
        throw exception;
    }
}

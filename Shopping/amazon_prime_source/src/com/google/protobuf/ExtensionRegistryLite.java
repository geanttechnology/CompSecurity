// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ExtensionRegistryLite
{

    private static final ExtensionRegistryLite EMPTY = new ExtensionRegistryLite(true);
    private static volatile boolean eagerlyParseMessageSets = false;
    private final Map extensionsByNumber;

    ExtensionRegistryLite()
    {
        extensionsByNumber = new HashMap();
    }

    ExtensionRegistryLite(ExtensionRegistryLite extensionregistrylite)
    {
        if (extensionregistrylite == EMPTY)
        {
            extensionsByNumber = Collections.emptyMap();
            return;
        } else
        {
            extensionsByNumber = Collections.unmodifiableMap(extensionregistrylite.extensionsByNumber);
            return;
        }
    }

    private ExtensionRegistryLite(boolean flag)
    {
        extensionsByNumber = Collections.emptyMap();
    }

    public static ExtensionRegistryLite getEmptyRegistry()
    {
        return EMPTY;
    }

    public static boolean isEagerlyParseMessageSets()
    {
        return eagerlyParseMessageSets;
    }

}

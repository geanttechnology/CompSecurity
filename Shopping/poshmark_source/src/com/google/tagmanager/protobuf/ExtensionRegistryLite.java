// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.tagmanager.protobuf:
//            MessageLite

public class ExtensionRegistryLite
{
    private static final class ObjectIntPair
    {

        private final int number;
        private final Object object;

        public boolean equals(Object obj)
        {
            if (obj instanceof ObjectIntPair)
            {
                if (object == ((ObjectIntPair) (obj = (ObjectIntPair)obj)).object && number == ((ObjectIntPair) (obj)).number)
                {
                    return true;
                }
            }
            return false;
        }

        public int hashCode()
        {
            return System.identityHashCode(object) * 65535 + number;
        }

        ObjectIntPair(Object obj, int i)
        {
            object = obj;
            number = i;
        }
    }


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

    public static ExtensionRegistryLite newInstance()
    {
        return new ExtensionRegistryLite();
    }

    public static void setEagerlyParseMessageSets(boolean flag)
    {
        eagerlyParseMessageSets = flag;
    }

    public final void add(GeneratedMessageLite.GeneratedExtension generatedextension)
    {
        extensionsByNumber.put(new ObjectIntPair(generatedextension.getContainingTypeDefaultInstance(), generatedextension.getNumber()), generatedextension);
    }

    public GeneratedMessageLite.GeneratedExtension findLiteExtensionByNumber(MessageLite messagelite, int i)
    {
        return (GeneratedMessageLite.GeneratedExtension)extensionsByNumber.get(new ObjectIntPair(messagelite, i));
    }

    public ExtensionRegistryLite getUnmodifiable()
    {
        return new ExtensionRegistryLite(this);
    }

}

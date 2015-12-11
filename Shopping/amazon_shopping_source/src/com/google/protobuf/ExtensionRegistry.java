// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.protobuf:
//            ExtensionRegistryLite, Message

public final class ExtensionRegistry extends ExtensionRegistryLite
{
    private static final class DescriptorIntPair
    {

        private final Descriptors.Descriptor descriptor;
        private final int number;

        public boolean equals(Object obj)
        {
            if (obj instanceof DescriptorIntPair)
            {
                if (descriptor == ((DescriptorIntPair) (obj = (DescriptorIntPair)obj)).descriptor && number == ((DescriptorIntPair) (obj)).number)
                {
                    return true;
                }
            }
            return false;
        }

        public int hashCode()
        {
            return descriptor.hashCode() * 65535 + number;
        }

        DescriptorIntPair(Descriptors.Descriptor descriptor1, int i)
        {
            descriptor = descriptor1;
            number = i;
        }
    }

    public static final class ExtensionInfo
    {

        public final Message defaultInstance;
        public final Descriptors.FieldDescriptor descriptor;
    }


    private static final ExtensionRegistry EMPTY = new ExtensionRegistry(true);
    private final Map extensionsByName;
    private final Map extensionsByNumber;

    private ExtensionRegistry()
    {
        extensionsByName = new HashMap();
        extensionsByNumber = new HashMap();
    }

    private ExtensionRegistry(boolean flag)
    {
        super(ExtensionRegistryLite.getEmptyRegistry());
        extensionsByName = Collections.emptyMap();
        extensionsByNumber = Collections.emptyMap();
    }

    public static ExtensionRegistry getEmptyRegistry()
    {
        return EMPTY;
    }

    public ExtensionInfo findExtensionByNumber(Descriptors.Descriptor descriptor, int i)
    {
        return (ExtensionInfo)extensionsByNumber.get(new DescriptorIntPair(descriptor, i));
    }

}

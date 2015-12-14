// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model.deserializer;

import com.amazon.clouddrive.model.deserializer.JsonDeserializer;
import com.amazon.clouddrive.model.deserializer.ListDeserializer;

// Referenced classes of package com.amazon.clouddrive.extended.model.deserializer:
//            NodeExtendedDeserializer

public class ExtendedDeserializers
{

    public static final JsonDeserializer LIST_NODE_EXTENDED_DESERIALIZER;

    static 
    {
        LIST_NODE_EXTENDED_DESERIALIZER = new ListDeserializer(NodeExtendedDeserializer.INSTANCE);
    }
}

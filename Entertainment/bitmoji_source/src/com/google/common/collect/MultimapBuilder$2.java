// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.util.Map;

// Referenced classes of package com.google.common.collect:
//            MultimapBuilder, Maps

static final class ltimapBuilderWithKeys extends ltimapBuilderWithKeys
{

    static transient int val$expectedKeys;

    Map createMap()
    {
        return Maps.newLinkedHashMapWithExpectedSize(val$expectedKeys);
    }

    ltimapBuilderWithKeys(int i)
    {
        val$expectedKeys = i;
        super();
    }
}

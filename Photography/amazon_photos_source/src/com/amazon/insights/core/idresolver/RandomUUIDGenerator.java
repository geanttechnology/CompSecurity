// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.idresolver;

import java.util.UUID;

// Referenced classes of package com.amazon.insights.core.idresolver:
//            UniqueIdGenerator

public class RandomUUIDGenerator
    implements UniqueIdGenerator
{

    public RandomUUIDGenerator()
    {
    }

    public String generateUniqueIdString()
    {
        return UUID.randomUUID().toString();
    }
}

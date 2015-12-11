// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.eventbus;

import com.google.common.cache.CacheLoader;
import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.TypeToken;

// Referenced classes of package com.google.common.eventbus:
//            SubscriberRegistry

static final class  extends CacheLoader
{

    public ImmutableSet load(Class class1)
    {
        return ImmutableSet.copyOf(TypeToken.of(class1).getTypes().Types());
    }

    public volatile Object load(Object obj)
        throws Exception
    {
        return load((Class)obj);
    }

    ()
    {
    }
}

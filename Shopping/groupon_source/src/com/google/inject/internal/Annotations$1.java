// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import java.lang.annotation.Annotation;
import org.roboguice.shaded.goole.common.cache.CacheLoader;

// Referenced classes of package com.google.inject.internal:
//            Annotations

static final class acheLoader extends CacheLoader
{

    public volatile Object load(Object obj)
        throws Exception
    {
        return load((Class)obj);
    }

    public Annotation load(Class class1)
    {
        return Annotations.access$000(class1);
    }

    acheLoader()
    {
    }
}

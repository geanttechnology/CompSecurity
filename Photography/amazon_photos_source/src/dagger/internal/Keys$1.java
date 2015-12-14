// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal;

import javax.inject.Qualifier;

// Referenced classes of package dagger.internal:
//            LruCache, Keys

static final class e extends LruCache
{

    protected Boolean create(Class class1)
    {
        return Boolean.valueOf(class1.isAnnotationPresent(javax/inject/Qualifier));
    }

    protected volatile Object create(Object obj)
    {
        return create((Class)obj);
    }

    e(int i)
    {
        super(i);
    }
}

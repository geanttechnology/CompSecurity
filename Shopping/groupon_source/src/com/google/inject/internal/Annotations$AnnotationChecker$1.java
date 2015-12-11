// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import java.lang.annotation.Annotation;
import java.util.Collection;
import org.roboguice.shaded.goole.common.cache.CacheLoader;

// Referenced classes of package com.google.inject.internal:
//            Annotations

class this._cls0 extends CacheLoader
{

    final load this$0;

    public Boolean load(Class class1)
    {
        class1 = class1.getAnnotations();
        int j = class1.length;
        for (int i = 0; i < j; i++)
        {
            Annotation annotation = class1[i];
            if (cess._mth400(this._cls0.this).contains(annotation.annotationType()))
            {
                return Boolean.valueOf(true);
            }
        }

        return Boolean.valueOf(false);
    }

    public volatile Object load(Object obj)
        throws Exception
    {
        return load((Class)obj);
    }

    ()
    {
        this$0 = this._cls0.this;
        super();
    }
}

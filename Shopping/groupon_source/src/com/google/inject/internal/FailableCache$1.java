// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import org.roboguice.shaded.goole.common.cache.CacheLoader;

// Referenced classes of package com.google.inject.internal:
//            FailableCache, ErrorsException, Errors

class heLoader extends CacheLoader
{

    final FailableCache this$0;

    public Object load(Object obj)
    {
        Errors errors = new Errors();
        Object obj1 = null;
        try
        {
            obj = create(obj, errors);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            errors.merge(((ErrorsException) (obj)).getErrors());
            obj = obj1;
        }
        if (errors.hasErrors())
        {
            return errors;
        } else
        {
            return obj;
        }
    }

    heLoader()
    {
        this$0 = FailableCache.this;
        super();
    }
}

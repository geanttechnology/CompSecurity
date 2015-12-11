// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import java.util.concurrent.ConcurrentMap;
import org.roboguice.shaded.goole.common.cache.CacheBuilder;
import org.roboguice.shaded.goole.common.cache.CacheLoader;
import org.roboguice.shaded.goole.common.cache.LoadingCache;

// Referenced classes of package com.google.inject.internal:
//            ErrorsException, Errors

public abstract class FailableCache
{

    private final LoadingCache _flddelegate = CacheBuilder.newBuilder().build(new CacheLoader() {

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

            
            {
                this$0 = FailableCache.this;
                super();
            }
    });

    public FailableCache()
    {
    }

    protected abstract Object create(Object obj, Errors errors)
        throws ErrorsException;

    public Object get(Object obj, Errors errors)
        throws ErrorsException
    {
        obj = _flddelegate.getUnchecked(obj);
        if (obj instanceof Errors)
        {
            errors.merge((Errors)obj);
            throw errors.toException();
        } else
        {
            return obj;
        }
    }

    boolean remove(Object obj)
    {
        return _flddelegate.asMap().remove(obj) != null;
    }
}

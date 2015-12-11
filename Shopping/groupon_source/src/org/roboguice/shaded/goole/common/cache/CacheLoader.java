// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.cache;

import java.io.Serializable;
import java.util.Map;
import org.roboguice.shaded.goole.common.base.Function;
import org.roboguice.shaded.goole.common.base.Preconditions;
import org.roboguice.shaded.goole.common.base.Supplier;
import org.roboguice.shaded.goole.common.util.concurrent.Futures;
import org.roboguice.shaded.goole.common.util.concurrent.ListenableFuture;

public abstract class CacheLoader
{
    private static final class FunctionToCacheLoader extends CacheLoader
        implements Serializable
    {

        private final Function computingFunction;

        public Object load(Object obj)
        {
            return computingFunction.apply(Preconditions.checkNotNull(obj));
        }

        public FunctionToCacheLoader(Function function)
        {
            computingFunction = (Function)Preconditions.checkNotNull(function);
        }
    }

    public static final class InvalidCacheLoadException extends RuntimeException
    {

        public InvalidCacheLoadException(String s)
        {
            super(s);
        }
    }

    private static final class SupplierToCacheLoader extends CacheLoader
        implements Serializable
    {

        private final Supplier computingSupplier;

        public Object load(Object obj)
        {
            Preconditions.checkNotNull(obj);
            return computingSupplier.get();
        }

        public SupplierToCacheLoader(Supplier supplier)
        {
            computingSupplier = (Supplier)Preconditions.checkNotNull(supplier);
        }
    }

    static final class UnsupportedLoadingOperationException extends UnsupportedOperationException
    {

        UnsupportedLoadingOperationException()
        {
        }
    }


    protected CacheLoader()
    {
    }

    public static CacheLoader from(Function function)
    {
        return new FunctionToCacheLoader(function);
    }

    public static CacheLoader from(Supplier supplier)
    {
        return new SupplierToCacheLoader(supplier);
    }

    public abstract Object load(Object obj)
        throws Exception;

    public Map loadAll(Iterable iterable)
        throws Exception
    {
        throw new UnsupportedLoadingOperationException();
    }

    public ListenableFuture reload(Object obj, Object obj1)
        throws Exception
    {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj1);
        return Futures.immediateFuture(load(obj));
    }
}

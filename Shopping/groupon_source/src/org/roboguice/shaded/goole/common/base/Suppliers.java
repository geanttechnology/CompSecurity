// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.base;

import java.io.Serializable;

// Referenced classes of package org.roboguice.shaded.goole.common.base:
//            Preconditions, Supplier, Objects

public final class Suppliers
{
    static class MemoizingSupplier
        implements Serializable, Supplier
    {

        final Supplier _flddelegate;
        volatile transient boolean initialized;
        transient Object value;

        public Object get()
        {
            if (initialized) goto _L2; else goto _L1
_L1:
            this;
            JVM INSTR monitorenter ;
            Object obj;
            if (initialized)
            {
                break MISSING_BLOCK_LABEL_40;
            }
            obj = _flddelegate.get();
            value = obj;
            initialized = true;
            this;
            JVM INSTR monitorexit ;
            return obj;
            this;
            JVM INSTR monitorexit ;
_L2:
            return value;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public String toString()
        {
            return (new StringBuilder()).append("Suppliers.memoize(").append(_flddelegate).append(")").toString();
        }

        MemoizingSupplier(Supplier supplier)
        {
            _flddelegate = supplier;
        }
    }

    private static class SupplierOfInstance
        implements Serializable, Supplier
    {

        final Object instance;

        public boolean equals(Object obj)
        {
            if (obj instanceof SupplierOfInstance)
            {
                obj = (SupplierOfInstance)obj;
                return Objects.equal(instance, ((SupplierOfInstance) (obj)).instance);
            } else
            {
                return false;
            }
        }

        public Object get()
        {
            return instance;
        }

        public int hashCode()
        {
            return Objects.hashCode(new Object[] {
                instance
            });
        }

        public String toString()
        {
            return (new StringBuilder()).append("Suppliers.ofInstance(").append(instance).append(")").toString();
        }

        SupplierOfInstance(Object obj)
        {
            instance = obj;
        }
    }


    public static Supplier memoize(Supplier supplier)
    {
        if (supplier instanceof MemoizingSupplier)
        {
            return supplier;
        } else
        {
            return new MemoizingSupplier((Supplier)Preconditions.checkNotNull(supplier));
        }
    }

    public static Supplier ofInstance(Object obj)
    {
        return new SupplierOfInstance(obj);
    }
}

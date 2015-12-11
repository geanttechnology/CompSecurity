// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.cache;

import java.util.concurrent.atomic.AtomicLong;
import org.roboguice.shaded.goole.common.base.Supplier;

// Referenced classes of package org.roboguice.shaded.goole.common.cache:
//            LongAdder, LongAddable

final class LongAddables
{
    private static final class PureJavaLongAddable extends AtomicLong
        implements LongAddable
    {

        public void add(long l)
        {
            getAndAdd(l);
        }

        public void increment()
        {
            getAndIncrement();
        }

        private PureJavaLongAddable()
        {
        }

    }


    private static final Supplier SUPPLIER;

    public static LongAddable create()
    {
        return (LongAddable)SUPPLIER.get();
    }

    static 
    {
        Supplier supplier;
        try
        {
            new LongAdder();
            supplier = new Supplier() {

                public volatile Object get()
                {
                    return get();
                }

                public LongAddable get()
                {
                    return new LongAdder();
                }

            };
        }
        catch (Throwable throwable)
        {
            throwable = new Supplier() {

                public volatile Object get()
                {
                    return get();
                }

                public LongAddable get()
                {
                    return new PureJavaLongAddable();
                }

            };
        }
        SUPPLIER = supplier;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.content;


// Referenced classes of package com.ebay.nautilus.kernel.content:
//            EbayContext

public interface EbayContextFactory
{
    public static final class Constant
        implements EbayContextFactory
    {

        private final Object o;

        public Object get(EbayContext ebaycontext)
        {
            return o;
        }

        public Constant(Object obj)
        {
            if (obj == null)
            {
                throw new IllegalArgumentException("o is null");
            } else
            {
                o = obj;
                return;
            }
        }
    }

    public static abstract class Single
        implements EbayContextFactory
    {

        private Object inst;

        protected abstract Object create(EbayContext ebaycontext);

        public final Object get(EbayContext ebaycontext)
        {
            this;
            JVM INSTR monitorenter ;
            if (inst == null)
            {
                inst = create(ebaycontext);
            }
            ebaycontext = ((EbayContext) (inst));
            this;
            JVM INSTR monitorexit ;
            return ebaycontext;
            ebaycontext;
            throw ebaycontext;
        }

        public Single()
        {
        }
    }

    public static final class SingleWrap extends Single
    {

        private final EbayContextFactory inner;

        protected Object create(EbayContext ebaycontext)
        {
            return inner.get(ebaycontext);
        }

        public SingleWrap(EbayContextFactory ebaycontextfactory)
        {
            inner = ebaycontextfactory;
        }
    }


    public abstract Object get(EbayContext ebaycontext);
}

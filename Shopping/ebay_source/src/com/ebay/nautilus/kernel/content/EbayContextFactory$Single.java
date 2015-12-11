// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.content;


// Referenced classes of package com.ebay.nautilus.kernel.content:
//            EbayContextFactory, EbayContext

public static abstract class 
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

    public ()
    {
    }
}

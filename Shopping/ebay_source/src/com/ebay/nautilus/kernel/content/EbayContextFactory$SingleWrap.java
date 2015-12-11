// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.content;


// Referenced classes of package com.ebay.nautilus.kernel.content:
//            EbayContextFactory, EbayContext

public static final class inner extends inner
{

    private final EbayContextFactory inner;

    protected Object create(EbayContext ebaycontext)
    {
        return inner.get(ebaycontext);
    }

    public (EbayContextFactory ebaycontextfactory)
    {
        inner = ebaycontextfactory;
    }
}

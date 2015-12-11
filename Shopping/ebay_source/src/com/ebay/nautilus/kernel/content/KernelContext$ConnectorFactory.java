// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.content;

import com.ebay.nautilus.kernel.net.Connector;

// Referenced classes of package com.ebay.nautilus.kernel.content:
//            EbayContextFactory, KernelContext, EbayContext

private static final class <init>
    implements EbayContextFactory
{

    public Connector get(EbayContext ebaycontext)
    {
        return new com.ebay.nautilus.kernel.net.ory(ebaycontext);
    }

    public volatile Object get(EbayContext ebaycontext)
    {
        return get(ebaycontext);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}

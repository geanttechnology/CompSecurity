// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.test.utils;

import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.EbayContextFactory;
import com.ebay.nautilus.kernel.content.EbayResources;

// Referenced classes of package com.ebay.nautilus.kernel.test.utils:
//            TestEbayContext

private static final class <init>
    implements EbayContextFactory, EbayResources
{

    public EbayResources get(EbayContext ebaycontext)
    {
        return this;
    }

    public volatile Object get(EbayContext ebaycontext)
    {
        return get(ebaycontext);
    }

    public String getString(int i)
    {
        return "test case";
    }

    public transient String getString(int i, Object aobj[])
    {
        return "test case";
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}

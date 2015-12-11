// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.content;

import android.content.Context;
import android.content.ContextWrapper;

// Referenced classes of package com.ebay.nautilus.kernel.content:
//            EbayContextFactory, EbayResources, KernelContext, EbayContext

private static final class  extends ContextWrapper
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

    public (Context context)
    {
        super(context);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile;

import com.ebay.common.PrefUserContext;
import com.ebay.nautilus.domain.content.dm.UserContext;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.mobile:
//            AppContext

private static final class <init> extends com.ebay.nautilus.kernel.content.
{

    protected UserContext create(EbayContext ebaycontext)
    {
        return new PrefUserContext(ebaycontext);
    }

    protected volatile Object create(EbayContext ebaycontext)
    {
        return create(ebaycontext);
    }

    private t()
    {
    }

    t(t t)
    {
        this();
    }
}

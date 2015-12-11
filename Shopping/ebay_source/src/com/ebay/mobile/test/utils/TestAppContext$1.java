// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.test.utils;

import com.ebay.nautilus.kernel.content.EbayAppInfo;
import com.ebay.nautilus.kernel.content.EbayAppInfoImpl;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.mobile.test.utils:
//            TestAppContext

static final class  extends com.ebay.nautilus.kernel.content.y.Single
{

    protected EbayAppInfo create(EbayContext ebaycontext)
    {
        return new EbayAppInfoImpl("com.ebay.mobile", "4.1.5.22", false);
    }

    protected volatile Object create(EbayContext ebaycontext)
    {
        return create(ebaycontext);
    }

    ()
    {
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.test.utils;

import com.ebay.nautilus.domain.content.EbayPreferences;
import com.ebay.nautilus.domain.content.EbayPreferencesImpl;
import com.ebay.nautilus.domain.content.dm.UserContext;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.test.utils.TestSharedPreferences;

// Referenced classes of package com.ebay.nautilus.domain.test.utils:
//            TestDomainContext

private static final class <init> extends com.ebay.nautilus.kernel.content.ry
{

    protected EbayPreferences create(EbayContext ebaycontext)
    {
        return new EbayPreferencesImpl((UserContext)ebaycontext.getExtension(com/ebay/nautilus/domain/content/dm/UserContext), "com.ebay.nautilus.domain", new TestSharedPreferences());
    }

    protected volatile Object create(EbayContext ebaycontext)
    {
        return create(ebaycontext);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}

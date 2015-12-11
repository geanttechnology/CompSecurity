// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.currency;

import com.ebay.nautilus.kernel.util.SimpleMaker;

// Referenced classes of package com.ebay.common.net.api.currency:
//            CurrencyConversionDataManager

static final class rrencyCacheLock
    implements SimpleMaker
{

    public rrencyCacheLock create()
    {
        return new rrencyCacheLock();
    }

    public volatile Object create()
    {
        return create();
    }

    rrencyCacheLock()
    {
    }
}

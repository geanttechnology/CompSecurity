// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import com.ebay.nautilus.domain.content.dm.UserContext;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.nautilus.domain.content:
//            DomainContext, EbayPreferencesImpl, EbayPreferences

private final class <init> extends com.ebay.nautilus.kernel.content.<init>
{

    final create this$0;

    protected EbayPreferences create(EbayContext ebaycontext)
    {
        return new EbayPreferencesImpl((UserContext)ebaycontext.getExtension(com/ebay/nautilus/domain/content/dm/UserContext), "com.ebay.nautilus.domain", this._cls0.this.<init>.references());
    }

    protected volatile Object create(EbayContext ebaycontext)
    {
        return create(ebaycontext);
    }

    private ()
    {
        this$0 = this._cls0.this;
        super();
    }

    this._cls0(this._cls0 _pcls0_1)
    {
        this();
    }
}

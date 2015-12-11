// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.fis;

import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.nautilus.kernel.content.EbayContext;

public abstract class FundingInstrumentServiceNetLoader extends EbaySimpleNetLoader
{

    public FundingInstrumentServiceNetLoader(EbayContext ebaycontext)
    {
        super(ebaycontext);
    }

    public boolean isServiceError()
    {
        return false;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.refine.controllers;

import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.mobile.search.RefinementActor;

// Referenced classes of package com.ebay.mobile.search.refine.controllers:
//            AspectController

public static interface 
    extends RefinementActor
{

    public abstract void aspectUpdated(com.ebay.common.model.search.pectProvider pectprovider);

    public abstract EbayAspectHistogram getAspectHistogram();
}

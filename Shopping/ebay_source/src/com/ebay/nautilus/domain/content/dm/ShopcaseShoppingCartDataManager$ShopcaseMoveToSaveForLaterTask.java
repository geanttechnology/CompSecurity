// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.net.EbayCosRequest;
import com.ebay.nautilus.domain.net.api.shopcase.MoveToSaveForLaterRequest;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            ShopcaseShoppingCartDataManager

public final class  extends 
{

    final ShopcaseShoppingCartDataManager this$0;

    protected EbayCosRequest createRequest()
    {
        return new MoveToSaveForLaterRequest(iafToken, site, itemReferenceId.longValue());
    }

    public (long l, String s, String s1,  )
    {
        this$0 = ShopcaseShoppingCartDataManager.this;
        super(ShopcaseShoppingCartDataManager.this, , s, Long.valueOf(l), Long.toString(l), s1, );
    }
}

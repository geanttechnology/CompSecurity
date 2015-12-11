// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.net.EbayCosRequest;
import com.ebay.nautilus.domain.net.api.shopcase.RemoveLineItemRequest;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            ShopcaseShoppingCartDataManager

public final class nit> extends nit>
{

    final ShopcaseShoppingCartDataManager this$0;

    protected EbayCosRequest createRequest()
    {
        return new RemoveLineItemRequest(iafToken, site, itemReferenceId.longValue());
    }

    public (boolean flag, long l, String s, String s1,  )
    {
        this$0 = ShopcaseShoppingCartDataManager.this;
         1;
        if (flag)
        {
            1 = this._fld0;
        } else
        {
            1 = ER;
        }
        super(ShopcaseShoppingCartDataManager.this, 1, s, Long.valueOf(l), Long.toString(l), s1, );
    }
}

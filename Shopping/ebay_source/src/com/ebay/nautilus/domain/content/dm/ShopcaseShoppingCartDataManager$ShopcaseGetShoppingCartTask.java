// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.net.EbayCosRequest;
import com.ebay.nautilus.domain.net.api.shopcase.GetShoppingCartRequest;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            ShopcaseShoppingCartDataManager

public final class it> extends it>
{

    final ShopcaseShoppingCartDataManager this$0;

    protected EbayCosRequest createRequest()
    {
        return new GetShoppingCartRequest(iafToken, site, action.action);
    }

    public (String s, String s1, boolean flag,  )
    {
        this$0 = ShopcaseShoppingCartDataManager.this;
         1;
        if (flag)
        {
            1 = this._fld0;
        } else
        {
            1 = this._fld0;
        }
        super(ShopcaseShoppingCartDataManager.this, 1, s, null, null, s1, );
    }
}

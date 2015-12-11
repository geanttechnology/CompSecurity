// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.text.TextUtils;
import com.ebay.nautilus.domain.net.EbayCosRequest;
import com.ebay.nautilus.domain.net.api.shopcase.AddToCartRequest;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            ShopcaseShoppingCartDataManager

public final class requestedQuantity extends sk
{

    private final long ebayItemId;
    private final int requestedQuantity;
    final ShopcaseShoppingCartDataManager this$0;
    private final String variationId;

    protected EbayCosRequest createRequest()
    {
        return new AddToCartRequest(iafToken, site, ebayItemId, variationId, requestedQuantity);
    }

    public sk(long l, String s, int i, String s1, String s2, 
            sk sk)
    {
        this$0 = ShopcaseShoppingCartDataManager.this;
        super(ShopcaseShoppingCartDataManager.this, sk, s1, null, TextUtils.concat(new CharSequence[] {
            Long.toString(l), "-", s
        }).toString(), s2, sk);
        ebayItemId = l;
        variationId = s;
        requestedQuantity = i;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import com.target.mothership.model.cart.interfaces.GiftProduct;
import java.util.Comparator;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            al

class this._cls0
    implements Comparator
{

    final al this$0;

    public int a(GiftProduct giftproduct, GiftProduct giftproduct1)
    {
        return al.a(al.this, giftproduct) - al.a(al.this, giftproduct1);
    }

    public int compare(Object obj, Object obj1)
    {
        return a((GiftProduct)obj, (GiftProduct)obj1);
    }

    ftProduct()
    {
        this$0 = al.this;
        super();
    }
}

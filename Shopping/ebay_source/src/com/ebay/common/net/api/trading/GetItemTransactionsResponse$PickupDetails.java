// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.ItemTransaction;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetItemTransactionsResponse

private final class tx extends com.ebay.nautilus.kernel.util.s
{

    final GetItemTransactionsResponse this$0;
    private final ItemTransaction tx;

    public com.ebay.nautilus.kernel.util.s get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("PickupOptions".equals(s1))
        {
            return new <init>(GetItemTransactionsResponse.this, tx);
        } else
        {
            return super.tx(s, s1, s2, attributes);
        }
    }

    public (ItemTransaction itemtransaction)
    {
        this$0 = GetItemTransactionsResponse.this;
        super();
        tx = itemtransaction;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.collections;


// Referenced classes of package com.ebay.mobile.collections:
//            CollectionDetailsActivity, CollectionDetailsAdapter

class up extends android.support.v7.widget.okup
{

    final CollectionDetailsActivity this$0;

    public int getSpanSize(int i)
    {
        switch (CollectionDetailsActivity.access$100(CollectionDetailsActivity.this).getItemViewType(i))
        {
        default:
            return 1;

        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
            return 2;
        }
    }

    up()
    {
        this$0 = CollectionDetailsActivity.this;
        super();
    }
}

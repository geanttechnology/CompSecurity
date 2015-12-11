// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.deals;


// Referenced classes of package com.ebay.mobile.deals:
//            DealsDetailsActivity, DealsContentAdapter

class panSizeLookup extends android.support.v7.widget.izeLookup
{

    final DealsDetailsActivity this$0;

    public int getSpanSize(int i)
    {
        switch (DealsDetailsActivity.access$000(DealsDetailsActivity.this).getItemViewType(i))
        {
        default:
            return 1;

        case 45: // '-'
            return DealsDetailsActivity.access$000(DealsDetailsActivity.this).getNumSpans();
        }
    }

    panSizeLookup()
    {
        this$0 = DealsDetailsActivity.this;
        super();
    }
}

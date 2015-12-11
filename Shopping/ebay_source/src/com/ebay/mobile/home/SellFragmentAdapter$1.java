// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home;

import java.util.List;

// Referenced classes of package com.ebay.mobile.home:
//            SellFragmentAdapter

class .SpanSizeLookup extends android.support.v7.widget.SizeLookup
{

    final SellFragmentAdapter this$0;

    public int getSpanSize(int i)
    {
        return ((Integer)SellFragmentAdapter.access$100(SellFragmentAdapter.this).get(i)).intValue();
    }

    .SpanSizeLookup()
    {
        this$0 = SellFragmentAdapter.this;
        super();
    }
}

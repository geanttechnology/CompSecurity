// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.events;

import android.view.View;
import android.widget.TextView;
import com.ebay.mobile.widget.PriceView;

// Referenced classes of package com.ebay.mobile.events:
//            EventRefineFragment

private static class price extends android.support.v7.widget.ce
{

    public final PriceView price;
    public final TextView rangeTextView;

    public (View view)
    {
        super(view);
        rangeTextView = (TextView)view.findViewById(0x7f1001aa);
        price = (PriceView)view.findViewById(0x7f1001ac);
    }
}

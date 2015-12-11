// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import android.view.View;
import android.widget.TextView;
import com.ebay.mobile.common.view.ViewHolder;

// Referenced classes of package com.ebay.mobile.home.cards:
//            BuyingOverviewHolder

public static class bottomText extends ViewHolder
{

    private TextView bottomText;
    private TextView centerText;
    private TextView topText;




    public (View view)
    {
        super(view);
        topText = (TextView)view.findViewById(0x7f10022d);
        centerText = (TextView)view.findViewById(0x7f10022e);
        bottomText = (TextView)view.findViewById(0x7f10022f);
    }
}

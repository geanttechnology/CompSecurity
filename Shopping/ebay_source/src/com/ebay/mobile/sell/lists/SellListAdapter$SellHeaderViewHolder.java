// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.lists;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.ebay.mobile.sell.lists:
//            SellListAdapter

static class older extends com.ebay.mobile.widget.iewHolder
{

    protected void onBindView(int i, CharSequence charsequence)
    {
        super.onBindView(i, charsequence);
        if (!TextUtils.isEmpty(charsequence))
        {
            textView.setVisibility(0);
            itemView.findViewById(0x7f1001a6).setVisibility(0);
            return;
        } else
        {
            textView.setVisibility(8);
            itemView.findViewById(0x7f1001a6).setVisibility(8);
            return;
        }
    }

    public older(View view)
    {
        super(view);
    }
}

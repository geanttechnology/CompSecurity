// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.connection.myebay;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.ebay.mobile.connection.myebay:
//            BuyingRecyclerAdapter

private class count extends com.ebay.mobile.widget.exViewHolder
    implements android.view.er.ListIndexViewHolder
{

    private final TextView count;
    final BuyingRecyclerAdapter this$0;
    private final TextView title;

    protected void onBindView(int i, int j)
    {
        i = getSectionFromItemPosition(i).e;
        i;
        JVM INSTR tableswitch 4 7: default 44
    //                   4 91
    //                   5 113
    //                   6 124
    //                   7 102;
           goto _L1 _L2 _L3 _L4 _L5
_L4:
        break MISSING_BLOCK_LABEL_124;
_L1:
        String s = "";
_L6:
        if (countCallback != null)
        {
            i = countCallback.etCountForListType(i);
        } else
        {
            i = 0;
        }
        title.setText(s);
        count.setText(Integer.toString(i));
        return;
_L2:
        s = seeMoreBids;
          goto _L6
_L5:
        s = seeMoreOffers;
          goto _L6
_L3:
        s = seeMorePurchases;
          goto _L6
        s = seeMoreLost;
          goto _L6
    }

    public void onClick(View view)
    {
        callback.onItemPressed(getLayoutPosition());
    }

    public erCallback(View view)
    {
        this$0 = BuyingRecyclerAdapter.this;
        super(view);
        title = (TextView)view.findViewById(0x7f1003c7);
        count = (TextView)view.findViewById(0x7f1003c8);
        view.setBackground(getContext().getResources().getDrawable(0x7f020267));
        view.setOnClickListener(this);
    }
}

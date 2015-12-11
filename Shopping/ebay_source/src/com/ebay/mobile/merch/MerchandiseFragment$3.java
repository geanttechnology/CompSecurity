// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.merch;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import com.ebay.nautilus.domain.data.CompactListing;
import java.util.List;

// Referenced classes of package com.ebay.mobile.merch:
//            MerchandiseFragment

class val.showMoreButton
    implements android.view.agment._cls3
{

    final MerchandiseFragment this$0;
    final GridLayout val$gridLayout;
    final LayoutInflater val$inflater;
    final int val$itemWidth;
    final List val$items;
    final int val$itemsInCollection;
    final int val$itemsPerRow;
    final int val$itemsShown;
    final int val$margin;
    final Button val$showMoreButton;

    public void onClick(View view)
    {
        for (int i = val$itemsShown; i < val$itemsInCollection; i++)
        {
            val$gridLayout.addView(MerchandiseFragment.access$200(MerchandiseFragment.this, val$inflater, (CompactListing)val$items.get(i)), MerchandiseFragment.access$300(MerchandiseFragment.this, val$margin, val$itemsPerRow, val$itemWidth, i));
        }

        MerchandiseFragment.access$402(MerchandiseFragment.this, true);
        val$showMoreButton.setVisibility(8);
    }

    ()
    {
        this$0 = final_merchandisefragment;
        val$itemsShown = i;
        val$itemsInCollection = j;
        val$gridLayout = gridlayout;
        val$inflater = layoutinflater;
        val$items = list;
        val$margin = k;
        val$itemsPerRow = l;
        val$itemWidth = i1;
        val$showMoreButton = Button.this;
        super();
    }
}

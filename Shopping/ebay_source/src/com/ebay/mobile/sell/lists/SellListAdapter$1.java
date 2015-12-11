// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.lists;


// Referenced classes of package com.ebay.mobile.sell.lists:
//            SellListAdapter

class this._cls0
    implements com.ebay.mobile.common.ectionModeChangeListener
{

    final SellListAdapter this$0;

    public void onSelectionModeChanged(boolean flag)
    {
        for (int i = 0; i < getItemCount(); i++)
        {
            notifyItemChanged(i);
        }

    }

    onModeChangeListener()
    {
        this$0 = SellListAdapter.this;
        super();
    }
}

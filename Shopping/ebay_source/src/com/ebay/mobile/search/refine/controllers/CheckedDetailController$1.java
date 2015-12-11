// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.refine.controllers;

import android.widget.ListView;
import java.util.BitSet;

// Referenced classes of package com.ebay.mobile.search.refine.controllers:
//            CheckedDetailController

class val.checkedItems
    implements Runnable
{

    final CheckedDetailController this$0;
    final BitSet val$checkedItems;

    public void run()
    {
        int j = val$checkedItems.length();
        for (int i = 0; i < j; i++)
        {
            listView.setItemChecked(i, val$checkedItems.get(i));
        }

        listView.setOnItemClickListener(CheckedDetailController.this);
    }

    I()
    {
        this$0 = final_checkeddetailcontroller;
        val$checkedItems = BitSet.this;
        super();
    }
}

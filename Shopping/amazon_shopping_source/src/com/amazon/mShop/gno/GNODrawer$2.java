// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import android.widget.ListView;

// Referenced classes of package com.amazon.mShop.gno:
//            GNODrawer, GNODrawerItem, GNOItemAdapter

class val.pinToTop
    implements Runnable
{

    final GNODrawer this$0;
    final String val$id;
    final GNODrawerItem val$item;
    final boolean val$pinToTop;

    public void run()
    {
        Object obj = val$item.getParent();
        GNOItemAdapter gnoitemadapter = GNODrawer.getGNOItemAdapter();
        if (obj != null)
        {
            obj = ((GNODrawerItem) (obj)).getId();
        } else
        {
            obj = val$id;
        }
        gnoitemadapter.expandGroup(((String) (obj)));
        if (val$pinToTop)
        {
            int i = GNOItemAdapter.getListViewPosition(GNODrawer.getGNOItemAdapter().getVisibleItemPosition(val$id));
            if (i != -1)
            {
                GNODrawer.access$200(GNODrawer.this).setSelection(i);
            }
        }
    }

    m()
    {
        this$0 = final_gnodrawer;
        val$item = gnodraweritem;
        val$id = s;
        val$pinToTop = Z.this;
        super();
    }
}

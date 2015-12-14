// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.lucasr.smoothie;

import android.os.Handler;
import android.widget.AbsListView;

// Referenced classes of package org.lucasr.smoothie:
//            ItemManager, ItemManaged

private class <init>
    implements android.widget.er
{

    final ItemManager this$0;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        android.widget.er er = ItemManager.access$800(ItemManager.this).getOnScrollListener();
        if (er != null)
        {
            er.onScroll(abslistview, i, j, k);
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        int j;
        boolean flag = false;
        Object obj;
        if (ItemManager.access$400(ItemManager.this) == 2 && i != 2)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (j == 0) goto _L2; else goto _L1
_L1:
        obj = ItemManager.access$500(ItemManager.this).obtainMessage(1, ItemManager.this);
        ItemManager.access$500(ItemManager.this).removeMessages(1);
        if (ItemManager.access$600(ItemManager.this))
        {
            j = ((flag) ? 1 : 0);
        } else
        {
            j = 550;
        }
        ItemManager.access$500(ItemManager.this).sendMessageDelayed(((android.os.Message) (obj)), j);
        ItemManager.access$702(ItemManager.this, true);
_L4:
        ItemManager.access$402(ItemManager.this, i);
        obj = ItemManager.access$800(ItemManager.this).getOnScrollListener();
        if (obj != null)
        {
            ((android.widget.er) (obj)).onScrollStateChanged(abslistview, i);
        }
        return;
_L2:
        if (i == 2)
        {
            ItemManager.access$702(ItemManager.this, false);
            ItemManager.access$500(ItemManager.this).removeMessages(1);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private ()
    {
        this$0 = ItemManager.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

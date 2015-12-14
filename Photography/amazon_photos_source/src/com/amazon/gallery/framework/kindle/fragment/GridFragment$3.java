// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import com.amazon.gallery.foundation.utils.messaging.ItemChangeEvent;
import com.amazon.gallery.framework.kindle.recyclerview.RecyclerAdapter;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            GridFragment

class t
    implements Runnable
{

    final GridFragment this$0;
    final ItemChangeEvent val$event;

    public void run()
    {
        if (val$event.isSingleItemChange())
        {
            mAdapter.notifyItemChanged(val$event.getPosition());
            return;
        } else
        {
            mAdapter.notifyItemRangeChanged(0, mAdapter.getItemCount());
            return;
        }
    }

    t()
    {
        this$0 = final_gridfragment;
        val$event = ItemChangeEvent.this;
        super();
    }
}

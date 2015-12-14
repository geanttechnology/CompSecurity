// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import com.amazon.gallery.foundation.utils.messaging.ItemChangeEvent;
import com.amazon.gallery.framework.kindle.recyclerview.RecyclerAdapter;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            MosaicFragment

class val.event
    implements Runnable
{

    final MosaicFragment this$0;
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

    er()
    {
        this$0 = final_mosaicfragment;
        val$event = ItemChangeEvent.this;
        super();
    }
}

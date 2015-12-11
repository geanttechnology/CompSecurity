// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.view.View;
import com.groupon.db.events.DialogCallbackEvent;
import com.groupon.db.models.Pagination;
import com.groupon.v3.adapter.UniversalListAdapter;
import commonlib.loader.event.UpdateEvent;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.groupon.util:
//            BaseRecyclerViewDelegate

class this._cls0
{

    final BaseRecyclerViewDelegate this$0;

    public void onEvent(UpdateEvent updateevent)
    {
        if (updateevent.getClass() == com/groupon/db/events/DialogCallbackEvent && ((DialogCallbackEvent)updateevent).getEventId().equalsIgnoreCase("negative_click"))
        {
            updateevent = BaseRecyclerViewDelegate.access$000(BaseRecyclerViewDelegate.this).getList();
            if (updateevent.isEmpty() || updateevent.size() == 1 && (updateevent.get(0) instanceof Pagination))
            {
                BaseRecyclerViewDelegate.access$000(BaseRecyclerViewDelegate.this).setList(new ArrayList());
                BaseRecyclerViewDelegate.access$100(BaseRecyclerViewDelegate.this).setVisibility(0);
            }
        }
    }

    ()
    {
        this$0 = BaseRecyclerViewDelegate.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.mapping;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.adapter.callback.IViewCallback;
import com.groupon.v3.trigger.NextPageTrigger;

// Referenced classes of package com.groupon.v3.adapter.mapping:
//            Mapping

public class NextPageTriggerMapping extends Mapping
{

    public NextPageTriggerMapping(IViewCallback iviewcallback)
    {
        super(com/groupon/v3/trigger/NextPageTrigger);
        registerCallback(com/groupon/v3/adapter/callback/IViewCallback, iviewcallback);
    }

    public void bindView(int i, android.support.v7.widget.RecyclerView.ViewHolder viewholder, UniversalListAdapter universallistadapter)
    {
        viewholder = (NextPageTrigger)universallistadapter.getItem(i);
        universallistadapter = (IViewCallback)getCallback(com/groupon/v3/adapter/callback/IViewCallback);
        if (!viewholder.isTriggered())
        {
            viewholder.setTriggered(true);
            if (universallistadapter != null)
            {
                universallistadapter.onPendingViewBound();
            }
        }
    }

    public View createView(Context context)
    {
        return LayoutInflater.from(context).inflate(0x7f0300d8, null);
    }

    public boolean getSpanAllColumns()
    {
        return true;
    }
}

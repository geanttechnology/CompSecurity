// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.mapping;

import android.content.Context;
import android.view.View;
import com.groupon.db.models.Band;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.view.callbacks.BandCardCallbacks;
import com.groupon.view.widgetcards.LimitedListWidgetHeaderCard;

// Referenced classes of package com.groupon.v3.adapter.mapping:
//            Mapping

public class BandCardMapping extends Mapping
{

    public BandCardMapping()
    {
        super(com/groupon/db/models/Band);
    }

    public void bindView(int i, android.support.v7.widget.RecyclerView.ViewHolder viewholder, UniversalListAdapter universallistadapter)
    {
        universallistadapter = (Band)universallistadapter.getItem(i);
        ((LimitedListWidgetHeaderCard)(LimitedListWidgetHeaderCard)viewholder.itemView).setInfo(((Band) (universallistadapter)).message);
        viewholder = (BandCardCallbacks)getCallback(com/groupon/v3/view/callbacks/BandCardCallbacks);
        if (viewholder != null)
        {
            viewholder.onBandBound(universallistadapter);
        }
    }

    public View createView(Context context)
    {
        return new LimitedListWidgetHeaderCard(context);
    }

    public boolean getSpanAllColumns()
    {
        return true;
    }
}

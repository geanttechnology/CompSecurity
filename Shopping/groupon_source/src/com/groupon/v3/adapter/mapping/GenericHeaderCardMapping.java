// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.mapping;

import android.content.Context;
import android.view.View;
import com.groupon.db.models.FauxDealSubsetAttribute;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.view.widgetcards.LimitedListWidgetHeaderCard;

// Referenced classes of package com.groupon.v3.adapter.mapping:
//            Mapping

public class GenericHeaderCardMapping extends Mapping
{

    public GenericHeaderCardMapping()
    {
        super(com/groupon/db/models/FauxDealSubsetAttribute);
    }

    public void bindView(int i, android.support.v7.widget.RecyclerView.ViewHolder viewholder, UniversalListAdapter universallistadapter)
    {
        universallistadapter = (FauxDealSubsetAttribute)universallistadapter.getItem(i);
        ((LimitedListWidgetHeaderCard)viewholder.itemView).setInfo(universallistadapter.getTitle());
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

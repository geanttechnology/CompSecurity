// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart.v3;

import android.view.ViewGroup;
import com.groupon.v3.adapter.UniversalListAdapter;
import java.util.List;

// Referenced classes of package com.groupon.goods.shoppingcart.v3:
//            FixedMapping

public class FixedUniversalListAdapter extends UniversalListAdapter
{

    public FixedUniversalListAdapter()
    {
    }

    public android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        android.content.Context context = viewgroup.getContext();
        return ((FixedMapping)dataMappingList.get(i)).createViewHolder(context, viewgroup);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.mapping;

import android.content.Context;
import android.view.View;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.view.callbacks.FallbackCallback;
import com.groupon.v3.view.holder.GrouponViewHolder;
import com.groupon.view.widgetcards.HiddenCollectionCardView;

// Referenced classes of package com.groupon.v3.adapter.mapping:
//            Mapping, VersionableCard

public class FallbackCardMapping extends Mapping
    implements VersionableCard
{

    public FallbackCardMapping(Class class1)
    {
        super(class1);
    }

    public void bindView(int i, android.support.v7.widget.RecyclerView.ViewHolder viewholder, UniversalListAdapter universallistadapter)
    {
        viewholder = ((android.support.v7.widget.RecyclerView.ViewHolder) (universallistadapter.getItem(i)));
        universallistadapter = (FallbackCallback)getCallback(com/groupon/v3/view/callbacks/FallbackCallback);
        if (universallistadapter != null)
        {
            universallistadapter.onBind(viewholder);
        }
    }

    public View createView(Context context)
    {
        return new HiddenCollectionCardView(context);
    }

    public android.support.v7.widget.RecyclerView.ViewHolder createViewHolder(Context context, UniversalListAdapter universallistadapter)
    {
        return getHolderWithCallback(context, universallistadapter);
    }

    protected GrouponViewHolder getHolderWithCallback(Context context, UniversalListAdapter universallistadapter)
    {
        return new GrouponViewHolder(createView(context));
    }

    public boolean isSupported(Object obj)
    {
        return true;
    }
}

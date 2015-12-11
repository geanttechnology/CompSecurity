// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browsenetworks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xfinity.playerlib.model.tags.Network;

// Referenced classes of package com.xfinity.playerlib.view.browsenetworks:
//            NetworksFragment

private abstract class  extends com.comcast.cim.cmasl.android.util.view.widget.t>
{

    final NetworksFragment this$0;

    protected abstract void bindImageViewItem( , Network network);

    protected void bindItem( , Network network)
    {
        if (.ewItem != null)
        {
            .ewItem.setText(network.getName());
             = .ewItem;
        } else
        if (.iewItem != null)
        {
            bindImageViewItem(, network);
             = .iewItem;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unexpected view type for network: ").append(network).toString());
        }
        .setContentDescription(network.getName());
    }

    protected volatile void bindItem(Object obj, Object obj1)
    {
        bindItem((bindItem)obj, (Network)obj1);
    }

    protected bindItem createViewHolder()
    {
        return new (null);
    }

    protected volatile Object createViewHolder()
    {
        return createViewHolder();
    }

    protected void initializeViewHolder(View view, ViewGroup viewgroup, createViewHolder createviewholder)
    {
        createviewholder.ewItem = (TextView)view.findViewById(com.xfinity.playerlib.orkViewHolder.textViewItem);
        createviewholder.iewItem = (ImageView)view.findViewById(com.xfinity.playerlib.orkViewHolder.imageViewItem);
    }

    protected volatile void initializeViewHolder(View view, ViewGroup viewgroup, Object obj)
    {
        initializeViewHolder(view, viewgroup, (initializeViewHolder)obj);
    }

    public (LayoutInflater layoutinflater)
    {
        this$0 = NetworksFragment.this;
        super(layoutinflater);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.events;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.ebay.mobile.widget.CompositeArrayRecyclerAdapter;

// Referenced classes of package com.ebay.mobile.events:
//            EventItemHeaderViewHolder, EventItemViewHolder

public class EventItemsAdapter extends CompositeArrayRecyclerAdapter
{
    public class EventHeaderInfo
    {

        public String endsInText;
        public String eventBannerImageUrl;
        public String shareUrl;
        final EventItemsAdapter this$0;

        public EventHeaderInfo()
        {
            this$0 = EventItemsAdapter.this;
            super();
        }
    }


    public final EventHeaderInfo headerInfo = new EventHeaderInfo();
    private android.view.View.OnClickListener onClickListener;

    public EventItemsAdapter(Context context, int i, int j)
    {
        super(context, i, j);
    }

    public com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.HeaderViewHolder onCreateHeaderViewHolder(ViewGroup viewgroup)
    {
        return new EventItemHeaderViewHolder(LayoutInflater.from(getContext()).inflate(0x7f03009d, viewgroup, false), headerInfo, onClickListener);
    }

    public com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.ItemViewHolder onCreateItemViewHolder(ViewGroup viewgroup)
    {
        return new EventItemViewHolder(LayoutInflater.from(getContext()).inflate(0x7f03009b, viewgroup, false), onClickListener);
    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        onClickListener = onclicklistener;
    }
}

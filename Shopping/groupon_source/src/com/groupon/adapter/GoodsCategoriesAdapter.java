// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.groupon.adapter.listener.OnCategoryImpressionEventListener;
import com.groupon.adapter.listener.OnCategoryItemClickListener;
import com.groupon.models.category.Category;
import java.util.List;

// Referenced classes of package com.groupon.adapter:
//            BaseGoodsCategoryAdapter

public class GoodsCategoriesAdapter extends BaseGoodsCategoryAdapter
{
    protected final class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder
    {

        protected ImageView categoryImage;
        protected ImageView categoryNewBadge;
        protected TextView categoryTitle;
        final GoodsCategoriesAdapter this$0;

        public ViewHolder(View view)
        {
            this$0 = GoodsCategoriesAdapter.this;
            super(view);
            categoryImage = (ImageView)view.findViewById(0x7f100329);
            categoryTitle = (TextView)view.findViewById(0x7f100304);
            categoryNewBadge = (ImageView)view.findViewById(0x7f10032a);
            view.setOnClickListener(new OnViewClickListener());
        }
    }

    private class ViewHolder.OnViewClickListener
        implements android.view.View.OnClickListener
    {

        final ViewHolder this$1;

        public void onClick(View view)
        {
            if (listener != null)
            {
                listener.onItemClick(itemView, getPosition());
            }
        }

        private ViewHolder.OnViewClickListener()
        {
            this$1 = ViewHolder.this;
            super();
        }

    }


    protected Context context;
    private final int imageColorMask;
    protected OnCategoryItemClickListener listener;

    public GoodsCategoriesAdapter(Context context1, List list)
    {
        super(context1, list);
        imageColorMask = context1.getResources().getColor(0x7f0e00f4);
        context = context1;
    }

    private void fireImpressionEvent(Category category)
    {
        if (onImpressionEventListener != null)
        {
            onImpressionEventListener.onImpressionEvent(category);
        }
    }

    public int getItemCount()
    {
        return items.size();
    }

    public volatile void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        onBindViewHolder((ViewHolder)viewholder, i);
    }

    public void onBindViewHolder(ViewHolder viewholder, int i)
    {
        Category category = (Category)items.get(i);
        fireImpressionEvent(category);
        viewholder.categoryTitle.setText(category.friendlyNameShort);
        viewholder.categoryImage.setImageDrawable(context.getResources().getDrawable(category.imageResId));
        viewholder.categoryImage.setColorFilter(imageColorMask, android.graphics.PorterDuff.Mode.SRC_ATOP);
        viewholder.categoryImage.setTag(Integer.valueOf(imageColorMask));
        viewholder.categoryNewBadge.setVisibility(category.visibility);
    }

    public volatile android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        return onCreateViewHolder(viewgroup, i);
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        return new ViewHolder(inflater.inflate(0x7f030115, viewgroup, false));
    }

    public void setOnItemClickListener(OnCategoryItemClickListener oncategoryitemclicklistener)
    {
        listener = oncategoryitemclicklistener;
    }
}

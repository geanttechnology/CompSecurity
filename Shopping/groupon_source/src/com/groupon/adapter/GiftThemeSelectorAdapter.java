// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.groupon.db.models.DerivedGiftTheme;
import com.groupon.models.gift.DerivedGiftCategory;
import com.groupon.view.GiftThemeImageView;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class GiftThemeSelectorAdapter extends android.support.v7.widget.RecyclerView.Adapter
{
    public static class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder
    {

        public TextView mTextView;
        public LinearLayout themesHolder;

        public ViewHolder(LinearLayout linearlayout)
        {
            super(linearlayout);
            mTextView = (TextView)linearlayout.findViewById(0x7f10007a);
            themesHolder = (LinearLayout)linearlayout.findViewById(0x7f1002f7);
        }
    }


    private Context context;
    private int imageContainerWidth;
    private int imageViewMargin;
    private List list;
    private android.view.View.OnClickListener listener;

    public GiftThemeSelectorAdapter()
    {
    }

    private void init()
    {
        list = Collections.EMPTY_LIST;
    }

    public int getItemCount()
    {
        return list.size();
    }

    public volatile void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        onBindViewHolder((ViewHolder)viewholder, i);
    }

    public void onBindViewHolder(ViewHolder viewholder, int i)
    {
        Object obj1 = (DerivedGiftCategory)list.get(i);
        Object obj = ((DerivedGiftCategory) (obj1)).themeList;
        viewholder.mTextView.setText(((DerivedGiftCategory) (obj1)).category);
        obj1 = viewholder.mTextView.getLayoutParams();
        obj1.width = imageContainerWidth * ((List) (obj)).size() - imageViewMargin;
        viewholder.mTextView.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        viewholder.themesHolder.removeAllViews();
        int j = 0;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            Object obj2 = (DerivedGiftTheme)((Iterator) (obj)).next();
            obj2.categoryIndex = i;
            obj2.subIndex = j;
            obj2 = new GiftThemeImageView(context, null, ((DerivedGiftTheme) (obj2)).imageUrl, ((DerivedGiftTheme) (obj2)));
            ((GiftThemeImageView) (obj2)).setOnClickListener(listener);
            viewholder.themesHolder.addView(((android.view.View) (obj2)));
            j++;
        }

    }

    public volatile android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        return onCreateViewHolder(viewgroup, i);
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        if (context == null)
        {
            context = viewgroup.getContext();
            imageContainerWidth = (int)context.getResources().getDimension(0x7f0b0142);
            imageViewMargin = (int)context.getResources().getDimension(0x7f0b0144);
        }
        return new ViewHolder((LinearLayout)LayoutInflater.from(context).inflate(0x7f030100, viewgroup, false));
    }

    public void setList(List list1)
    {
        list = list1;
    }

    public void setListener(android.view.View.OnClickListener onclicklistener)
    {
        listener = onclicklistener;
    }
}

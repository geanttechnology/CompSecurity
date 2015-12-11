// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.home.channels.ChannelFragment;
import com.ebay.mobile.home.channels.ChannelObserver;
import com.ebay.nautilus.domain.data.UnifiedStream.Category;

// Referenced classes of package com.ebay.mobile.home.cards:
//            DepartmentTitleViewModel

public class DepartmentTitleViewHolder extends ViewHolder
    implements ChannelObserver
{

    public final ImageView arrowView;
    private boolean isArrowEnabled;
    private boolean isArrowVisible;
    private final int marginDifference;
    private final int minimumBottomMargin;
    public final TextView nameView;
    private final int selectedColor;

    public DepartmentTitleViewHolder(View view)
    {
        super(view);
        isArrowEnabled = false;
        isArrowVisible = false;
        Resources resources = view.getResources();
        selectedColor = resources.getColor(0x7f0d00dd);
        minimumBottomMargin = resources.getDimensionPixelSize(0x7f09006a);
        marginDifference = resources.getDimensionPixelSize(0x7f090069) - minimumBottomMargin;
        nameView = (TextView)view.findViewById(0x7f100248);
        if (nameView != null)
        {
            nameView.setOnClickListener(this);
        }
        arrowView = (ImageView)view.findViewById(0x7f100249);
        if (arrowView != null)
        {
            arrowView.setOnClickListener(this);
        }
    }

    private void updateOpenCloseToggle()
    {
        byte byte0 = 4;
        if (isArrowEnabled)
        {
            ImageView imageview = arrowView;
            if (isArrowVisible)
            {
                byte0 = 0;
            }
            imageview.setVisibility(byte0);
        } else
        if (arrowView.getVisibility() == 0)
        {
            arrowView.setVisibility(4);
            return;
        }
    }

    public void bind(ViewModel viewmodel)
    {
        super.bind(viewmodel);
        if (viewmodel instanceof DepartmentTitleViewModel)
        {
            viewmodel = (DepartmentTitleViewModel)viewmodel;
            if (nameView != null)
            {
                nameView.setText(((DepartmentTitleViewModel) (viewmodel)).title);
                nameView.setTextColor(selectedColor);
            }
            if (itemView != null)
            {
                itemView.setVisibility(4);
            }
            isArrowEnabled = false;
            isArrowVisible = true;
        }
    }

    public void onCategoryExpansion(ChannelFragment channelfragment, float f)
    {
        if (channelfragment.hasCarousel())
        {
            channelfragment = itemView;
            int i;
            if (f > 0.0F)
            {
                i = 0;
            } else
            {
                i = 4;
            }
            channelfragment.setVisibility(i);
        }
        arrowView.setRotation(180F * f);
        ((android.view.ViewGroup.MarginLayoutParams)itemView.getLayoutParams()).bottomMargin = minimumBottomMargin + (int)((float)marginDifference - (float)marginDifference * f);
    }

    public void onCategorySelected(ChannelFragment channelfragment, Category category)
    {
    }

    public void onContentLoaded(ChannelFragment channelfragment)
    {
        isArrowEnabled = channelfragment.hasSubChannels();
        updateOpenCloseToggle();
    }

    public void onScrollChanged(ChannelFragment channelfragment, int i, int j)
    {
        if (channelfragment.hasCarousel())
        {
            channelfragment = itemView;
            if (j > 0)
            {
                i = 0;
            } else
            {
                i = 4;
            }
            channelfragment.setVisibility(i);
        }
    }
}

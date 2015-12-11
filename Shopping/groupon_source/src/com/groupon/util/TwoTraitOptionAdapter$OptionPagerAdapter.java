// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.groupon.db.models.Option;
import com.groupon.view.OneTraitMultiOptionListItem;
import java.util.List;

// Referenced classes of package com.groupon.util:
//            TwoTraitOptionAdapter

class displayDiscount extends PagerAdapter
{

    private static final int CLICK_THRESHOLD_MILLIS = 1500;
    private boolean areAllOptionsSingleTrait;
    private boolean displayDiscount;
    private long lastClickMillis;
    private List options;
    private float pageWidth;
    private int rowIndex;
    final TwoTraitOptionAdapter this$0;

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        viewgroup.removeView((View)obj);
    }

    public int getCount()
    {
        return options.size();
    }

    public float getPageWidth(int i)
    {
        if (options.size() > 1)
        {
            return pageWidth / (float)listWidth;
        } else
        {
            return 1.0F;
        }
    }

    public Object instantiateItem(ViewGroup viewgroup, int i)
    {
        OneTraitMultiOptionListItem onetraitmultioptionlistitem = new OneTraitMultiOptionListItem(getContext(), areAllOptionsSingleTrait, displayDiscount);
        if (!areAllOptionsSingleTrait && i == getCount() - 1)
        {
            int j = getContext().getResources().getDimensionPixelSize(0x7f0b0158);
            onetraitmultioptionlistitem.setPadding(onetraitmultioptionlistitem.getPaddingLeft(), onetraitmultioptionlistitem.getPaddingTop(), j, onetraitmultioptionlistitem.getPaddingBottom());
        }
        final Option option = (Option)options.get(i);
        onetraitmultioptionlistitem.setOption(option);
        viewgroup.addView(onetraitmultioptionlistitem, 0);
        onetraitmultioptionlistitem.setOnClickListener(new android.view.View.OnClickListener() {

            final TwoTraitOptionAdapter.OptionPagerAdapter this$1;
            final Option val$option;

            public void onClick(View view)
            {
                if (TwoTraitOptionAdapter.access$100(this$0) != null)
                {
                    long l = SystemClock.elapsedRealtime();
                    if (l - lastClickMillis > 1500L)
                    {
                        TwoTraitOptionAdapter.access$100(this$0).onOptionClick(option, view, rowIndex);
                    }
                    lastClickMillis = l;
                }
            }

            
            {
                this$1 = TwoTraitOptionAdapter.OptionPagerAdapter.this;
                option = option1;
                super();
            }
        });
        return onetraitmultioptionlistitem;
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return obj == view;
    }



/*
    static long access$202(_cls1 _pcls1, long l)
    {
        _pcls1.lastClickMillis = l;
        return l;
    }

*/


    _cls1.val.option(List list, int i, int j, boolean flag, boolean flag1)
    {
        this$0 = TwoTraitOptionAdapter.this;
        super();
        options = list;
        pageWidth = i;
        rowIndex = j;
        areAllOptionsSingleTrait = flag1;
        displayDiscount = flag;
    }
}

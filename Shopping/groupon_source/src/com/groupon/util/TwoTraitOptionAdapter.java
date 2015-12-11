// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Option;
import com.groupon.db.models.Trait;
import com.groupon.view.OneTraitMultiOptionListItem;
import com.groupon.view.PageIndicators;
import com.groupon.view.TwoTraitViewPager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.util:
//            DeviceInfoUtil, BuyUtils

public class TwoTraitOptionAdapter extends ArrayAdapter
{
    public static interface OptionClickListener
    {

        public abstract void onOptionClick(Option option, View view, int i);
    }

    class OptionPagerAdapter extends PagerAdapter
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
            Option option = (Option)options.get(i);
            onetraitmultioptionlistitem.setOption(option);
            viewgroup.addView(onetraitmultioptionlistitem, 0);
            onetraitmultioptionlistitem.setOnClickListener(option. new android.view.View.OnClickListener() {

                final OptionPagerAdapter this$1;
                final Option val$option;

                public void onClick(View view)
                {
                    if (listener != null)
                    {
                        long l = SystemClock.elapsedRealtime();
                        if (l - lastClickMillis > 1500L)
                        {
                            listener.onOptionClick(option, view, rowIndex);
                        }
                        lastClickMillis = l;
                    }
                }

            
            {
                this$1 = final_optionpageradapter;
                option = Option.this;
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
        static long access$202(OptionPagerAdapter optionpageradapter, long l)
        {
            optionpageradapter.lastClickMillis = l;
            return l;
        }

*/


        OptionPagerAdapter(List list, int i, int j, boolean flag, boolean flag1)
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


    private boolean areAllOptionsSingleTrait;
    private BuyUtils buyUtil;
    private DeviceInfoUtil deviceInfoUtil;
    private boolean displayDiscount;
    private LayoutInflater inflater;
    int listWidth;
    private OptionClickListener listener;
    private int maxWidth;
    android.view.ViewGroup.LayoutParams multiOptionLayoutParams;
    private int traitCount;

    public TwoTraitOptionAdapter(Context context, Deal deal, int i)
    {
        super(context, -1);
        RoboGuice.getInjector(context).injectMembers(this);
        traitCount = i;
        maxWidth = context.getResources().getDimensionPixelSize(0x7f0b0156);
        displayDiscount = deal.getDisplayOption("discount", true);
        context = deal.getVerticalTraitName();
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        deal = new ArrayList(deal.getOptions());
        Collections.sort(deal, new Comparator() {

            final TwoTraitOptionAdapter this$0;

            public int compare(Option option1, Option option2)
            {
                boolean flag;
                boolean flag1;
                if (option1.isSoldOut() || buyUtil.isOptionExpired(option1))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (option2.isSoldOut() || buyUtil.isOptionExpired(option2))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (flag == flag1)
                {
                    return 0;
                }
                return !flag ? -1 : 1;
            }

            public volatile int compare(Object obj, Object obj1)
            {
                return compare((Option)obj, (Option)obj1);
            }

            
            {
                this$0 = TwoTraitOptionAdapter.this;
                super();
            }
        });
        for (deal = deal.iterator(); deal.hasNext();)
        {
            Option option = (Option)deal.next();
            Iterator iterator = option.traits.iterator();
            while (iterator.hasNext()) 
            {
                Trait trait = (Trait)iterator.next();
                if (trait.name.equals(context))
                {
                    String s = trait.value;
                    if (!linkedhashmap.containsKey(s))
                    {
                        ArrayList arraylist = new ArrayList();
                        linkedhashmap.put(trait.value, arraylist);
                    }
                    ((List)linkedhashmap.get(s)).add(option);
                }
            }
        }

        context = linkedhashmap.values();
        addAll(context);
        areAllOptionsSingleTrait = true;
        context = context.iterator();
        do
        {
            if (!context.hasNext())
            {
                break;
            }
            if (((List)context.next()).size() <= 1)
            {
                continue;
            }
            areAllOptionsSingleTrait = false;
            break;
        } while (true);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        listWidth = viewgroup.getWidth();
        Resources resources = getContext().getResources();
        PageIndicators pageindicators;
        List list;
        int j;
        int k;
        int l;
        if (view == null)
        {
            view = inflater.inflate(0x7f030117, null);
            viewgroup = (TwoTraitViewPager)view.findViewById(0x7f10032c);
            if (multiOptionLayoutParams == null)
            {
                multiOptionLayoutParams = viewgroup.getLayoutParams();
            }
            viewgroup.setClipChildren(false);
        } else
        {
            viewgroup = (TwoTraitViewPager)view.findViewById(0x7f10032c);
        }
        pageindicators = (PageIndicators)view.findViewById(0x7f1000ac);
        j = resources.getDimensionPixelSize(0x7f0b0156);
        k = resources.getDimensionPixelSize(0x7f0b0157);
        list = (List)getItem(i);
        viewgroup.setAdapter(new OptionPagerAdapter(list, j, i, displayDiscount, areAllOptionsSingleTrait));
        pageindicators.setViewPager(viewgroup);
        l = list.size();
        if (shouldHideViewPagerIndicator() && traitCount > 1)
        {
            i = 8;
        } else
        {
            i = 0;
        }
        setLayoutParams(l, j, k, resources, viewgroup, pageindicators, 3, i);
        return view;
    }

    protected void setLayoutParams(int i, int j, int k, Resources resources, ViewPager viewpager, PageIndicators pageindicators, int l, 
            int i1)
    {
        if (i > 1)
        {
            viewpager.setLayoutParams(multiOptionLayoutParams);
            pageindicators.setVisibility(i1);
        } else
        {
            pageindicators.setVisibility(8);
            if (deviceInfoUtil.isTablet())
            {
                multiOptionLayoutParams.width = maxWidth;
                ((android.widget.LinearLayout.LayoutParams)multiOptionLayoutParams).gravity = 1;
                viewpager.setLayoutParams(multiOptionLayoutParams);
                return;
            }
        }
    }

    public void setOptionClickListener(OptionClickListener optionclicklistener)
    {
        listener = optionclicklistener;
    }

    protected boolean shouldHideViewPagerIndicator()
    {
        boolean flag = false;
        int i = deviceInfoUtil.getDisplayMetrics().widthPixels;
        if (getContext().getResources().getDimensionPixelSize(0x7f0b0156) * 2 <= i)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (deviceInfoUtil.isTablet() || i)
        {
            flag = true;
        }
        return flag;
    }


}

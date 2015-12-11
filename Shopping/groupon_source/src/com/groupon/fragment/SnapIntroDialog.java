// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.groupon.foundations.dialog.BaseDialogFragment;
import com.groupon.view.PageIndicators;

public class SnapIntroDialog extends BaseDialogFragment
{
    private class ArrowChangeOnPageChange
        implements android.support.v4.view.ViewPager.OnPageChangeListener
    {

        final SnapIntroDialog this$0;

        public void onPageScrollStateChanged(int i)
        {
        }

        public void onPageScrolled(int i, float f, int j)
        {
            i;
            JVM INSTR tableswitch 0 2: default 28
        //                       0 40
        //                       1 78
        //                       2 115;
               goto _L1 _L2 _L3 _L4
_L1:
            pageIndicators.setActiveIndicator(i);
            return;
_L2:
            leftArrow.setVisibility(8);
            rightArrow.setVisibility(0);
            gotIt.setVisibility(8);
            continue; /* Loop/switch isn't completed */
_L3:
            leftArrow.setVisibility(0);
            rightArrow.setVisibility(0);
            gotIt.setVisibility(8);
            continue; /* Loop/switch isn't completed */
_L4:
            leftArrow.setVisibility(0);
            rightArrow.setVisibility(8);
            gotIt.setVisibility(0);
            if (true) goto _L1; else goto _L5
_L5:
        }

        public void onPageSelected(int i)
        {
            currentPage = i;
        }

        private ArrowChangeOnPageChange()
        {
            this$0 = SnapIntroDialog.this;
            super();
        }

    }

    private class GroceryIntroAdapter extends PagerAdapter
    {

        private LayoutInflater layoutInflater;
        final SnapIntroDialog this$0;

        public void destroyItem(ViewGroup viewgroup, int i, Object obj)
        {
            ((ViewPager)viewgroup).removeView((LinearLayout)obj);
        }

        public int getCount()
        {
            return 3;
        }

        public Object instantiateItem(ViewGroup viewgroup, int i)
        {
            View view;
            TextView textview;
            ImageView imageview;
            Resources resources;
            layoutInflater = (LayoutInflater)viewgroup.getContext().getSystemService("layout_inflater");
            view = layoutInflater.inflate(0x7f030205, viewgroup, false);
            textview = (TextView)view.findViewById(0x7f10052f);
            imageview = (ImageView)view.findViewById(0x7f10052e);
            resources = getActivity().getResources();
            gotIt.setOnClickListener(new TriggerDismissOnGotIt());
            gotIt.setText(0x7f080218);
            if (i != 0) goto _L2; else goto _L1
_L1:
            textview.setText(0x7f0803ac);
            imageview.setImageDrawable(resources.getDrawable(0x7f0201d5));
_L4:
            viewgroup.addView(view, 0);
            return view;
_L2:
            if (i == 1)
            {
                textview.setText(0x7f0803ad);
                imageview.setImageDrawable(resources.getDrawable(0x7f0201d6));
            } else
            if (i == 2)
            {
                textview.setText(0x7f0803ae);
                imageview.setImageDrawable(resources.getDrawable(0x7f0201d7));
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public boolean isViewFromObject(View view, Object obj)
        {
            return view == obj;
        }

        private GroceryIntroAdapter()
        {
            this$0 = SnapIntroDialog.this;
            super();
        }

    }

    private class TriggerDismissOnCancel
        implements android.view.View.OnClickListener
    {

        final SnapIntroDialog this$0;

        public void onClick(View view)
        {
            dismiss();
        }

        private TriggerDismissOnCancel()
        {
            this$0 = SnapIntroDialog.this;
            super();
        }

    }

    private class TriggerDismissOnGotIt
        implements android.view.View.OnClickListener
    {

        final SnapIntroDialog this$0;

        public void onClick(View view)
        {
            prefs.edit().putBoolean("snap_intro_done", true).apply();
            dismiss();
        }

        private TriggerDismissOnGotIt()
        {
            this$0 = SnapIntroDialog.this;
            super();
        }

    }


    private static final int NUM_INTRO_PAGES = 3;
    public static final String SNAP_INTRO_DONE = "snap_intro_done";
    private int currentPage;
    private TextView gotIt;
    private ImageView leftArrow;
    private PageIndicators pageIndicators;
    protected SharedPreferences prefs;
    private ImageView rightArrow;
    private ViewPager viewPager;

    public SnapIntroDialog()
    {
        currentPage = 0;
    }

    public void onCreate(Bundle bundle)
    {
        onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        getDialog().getWindow().requestFeature(1);
        layoutinflater = layoutinflater.inflate(0x7f030206, viewgroup, false);
        viewgroup = layoutinflater.findViewById(0x7f10047b);
        if (!prefs.getBoolean("snap_intro_done", false))
        {
            viewgroup.setVisibility(4);
        } else
        {
            viewgroup.setVisibility(0);
            viewgroup.setOnClickListener(new TriggerDismissOnCancel());
        }
        viewPager = (ViewPager)layoutinflater.findViewById(0x7f100532);
        viewgroup = new GroceryIntroAdapter();
        viewPager.setAdapter(viewgroup);
        pageIndicators = (PageIndicators)layoutinflater.findViewById(0x7f1000ac);
        gotIt = (TextView)layoutinflater.findViewById(0x7f100534);
        leftArrow = (ImageView)layoutinflater.findViewById(0x7f100533);
        rightArrow = (ImageView)layoutinflater.findViewById(0x7f100126);
        leftArrow.setImageDrawable(getResources().getDrawable(0x7f0201df));
        rightArrow.setImageDrawable(getResources().getDrawable(0x7f0201e0));
        pageIndicators.setViewPager(viewPager);
        leftArrow.setOnClickListener(new ScrollLeftClickListener());
        rightArrow.setOnClickListener(new ScrollRightClickListener());
        viewPager.setOnPageChangeListener(new ArrowChangeOnPageChange());
        return layoutinflater;
    }








/*
    static int access$402(SnapIntroDialog snapintrodialog, int i)
    {
        snapintrodialog.currentPage = i;
        return i;
    }

*/


/*
    static int access$408(SnapIntroDialog snapintrodialog)
    {
        int i = snapintrodialog.currentPage;
        snapintrodialog.currentPage = i + 1;
        return i;
    }

*/


/*
    static int access$410(SnapIntroDialog snapintrodialog)
    {
        int i = snapintrodialog.currentPage;
        snapintrodialog.currentPage = i - 1;
        return i;
    }

*/
}

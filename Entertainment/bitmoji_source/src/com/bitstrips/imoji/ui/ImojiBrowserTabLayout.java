// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import java.util.HashMap;

public class ImojiBrowserTabLayout extends TabLayout
{

    final HashMap selectedTabIcons;
    final HashMap unselectedTabIcons;
    ViewPager viewPager;

    public ImojiBrowserTabLayout(Context context)
    {
        super(context);
        selectedTabIcons = new HashMap();
        unselectedTabIcons = new HashMap();
    }

    public ImojiBrowserTabLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        selectedTabIcons = new HashMap();
        unselectedTabIcons = new HashMap();
    }

    private void init()
    {
        getTabAt(0).setIcon(0x7f0200cf);
        getTabAt(1).setIcon(0x7f0200d0);
        getTabAt(2).setIcon(0x7f0200d3);
        getTabAt(3).setIcon(0x7f0200d6);
        getTabAt(4).setIcon(0x7f0200d9);
        getTabAt(5).setIcon(0x7f0200dc);
        selectedTabIcons.put(Integer.valueOf(0), Integer.valueOf(0x7f0200cf));
        selectedTabIcons.put(Integer.valueOf(1), Integer.valueOf(0x7f0200d2));
        selectedTabIcons.put(Integer.valueOf(2), Integer.valueOf(0x7f0200d5));
        selectedTabIcons.put(Integer.valueOf(3), Integer.valueOf(0x7f0200d8));
        selectedTabIcons.put(Integer.valueOf(4), Integer.valueOf(0x7f0200db));
        selectedTabIcons.put(Integer.valueOf(5), Integer.valueOf(0x7f0200de));
        unselectedTabIcons.put(Integer.valueOf(0), Integer.valueOf(0x7f0200cd));
        unselectedTabIcons.put(Integer.valueOf(1), Integer.valueOf(0x7f0200d0));
        unselectedTabIcons.put(Integer.valueOf(2), Integer.valueOf(0x7f0200d3));
        unselectedTabIcons.put(Integer.valueOf(3), Integer.valueOf(0x7f0200d6));
        unselectedTabIcons.put(Integer.valueOf(4), Integer.valueOf(0x7f0200d9));
        unselectedTabIcons.put(Integer.valueOf(5), Integer.valueOf(0x7f0200dc));
        setOnTabSelectedListener(new android.support.design.widget.TabLayout.OnTabSelectedListener() {

            final ImojiBrowserTabLayout this$0;

            public void onTabReselected(android.support.design.widget.TabLayout.Tab tab)
            {
                if (tab.getPosition() == -1)
                {
                    return;
                } else
                {
                    tab.setIcon(((Integer)selectedTabIcons.get(Integer.valueOf(tab.getPosition()))).intValue());
                    return;
                }
            }

            public void onTabSelected(android.support.design.widget.TabLayout.Tab tab)
            {
                if (tab.getPosition() == -1)
                {
                    return;
                } else
                {
                    tab.setIcon(((Integer)selectedTabIcons.get(Integer.valueOf(tab.getPosition()))).intValue());
                    viewPager.setCurrentItem(tab.getPosition());
                    return;
                }
            }

            public void onTabUnselected(android.support.design.widget.TabLayout.Tab tab)
            {
                if (tab.getPosition() == -1)
                {
                    return;
                } else
                {
                    tab.setIcon(((Integer)unselectedTabIcons.get(Integer.valueOf(tab.getPosition()))).intValue());
                    return;
                }
            }

            
            {
                this$0 = ImojiBrowserTabLayout.this;
                super();
            }
        });
    }

    public void setupWithViewPager(ViewPager viewpager)
    {
        super.setupWithViewPager(viewpager);
        viewPager = viewpager;
        init();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.view;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.fotoable.photocollage.view.compose2.indicate.CirclePageIndicator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import on;
import os;
import oy;

// Referenced classes of package com.fotoable.sketch.view:
//            TTieZhiCollectionPageView

public class TTieZhiCollectionPageScrolllView extends FrameLayout
{

    private on imageWorker;
    private oy lisener;
    public CirclePageIndicator mCirclePageIndicator;
    os mCollectionPagerAdapter;
    ViewPager mCollectionViewPager;
    private Context mContext;
    private List mInfos;
    public Map mRefrenceViewMap;
    private int mSelectedItemIndexAtPage;
    private int mSelectedPageIndex;
    private int perPageItemCount;

    public TTieZhiCollectionPageScrolllView(Context context)
    {
        super(context);
        mInfos = new ArrayList();
        perPageItemCount = 0;
        mRefrenceViewMap = new HashMap();
        mSelectedPageIndex = -1;
        mSelectedItemIndexAtPage = -1;
        init(context);
    }

    public TTieZhiCollectionPageScrolllView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mInfos = new ArrayList();
        perPageItemCount = 0;
        mRefrenceViewMap = new HashMap();
        mSelectedPageIndex = -1;
        mSelectedItemIndexAtPage = -1;
        init(context);
    }

    public TTieZhiCollectionPageScrolllView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mInfos = new ArrayList();
        perPageItemCount = 0;
        mRefrenceViewMap = new HashMap();
        mSelectedPageIndex = -1;
        mSelectedItemIndexAtPage = -1;
        init(context);
    }

    private void init(Context context)
    {
        mContext = context;
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030092, this, true);
        perPageItemCount = TTieZhiCollectionPageView.getItemCountPerLine(mContext) * TTieZhiCollectionPageView.KPageLine;
        mRefrenceViewMap.clear();
        mCollectionViewPager = (ViewPager)findViewById(0x7f0c0253);
        mCollectionPagerAdapter = new os(this);
        mCollectionViewPager.setAdapter(mCollectionPagerAdapter);
        mCirclePageIndicator = (CirclePageIndicator)findViewById(0x7f0c0254);
        mCirclePageIndicator.setViewPager(mCollectionViewPager);
        mCirclePageIndicator.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {

            final TTieZhiCollectionPageScrolllView a;

            public void onPageScrollStateChanged(int i)
            {
            }

            public void onPageScrolled(int i, float f, int j)
            {
            }

            public void onPageSelected(int i)
            {
            }

            
            {
                a = TTieZhiCollectionPageScrolllView.this;
                super();
            }
        });
    }

    public void refresh()
    {
    }

    public void setData(List list, int i)
    {
        if (list == null || list.size() <= 0)
        {
            return;
        } else
        {
            Animation animation = AnimationUtils.loadAnimation(mContext, 0x7f040029);
            mCollectionViewPager.startAnimation(animation);
            (new Handler()).postDelayed(new Runnable(list, i) {

                final List a;
                final int b;
                final TTieZhiCollectionPageScrolllView c;

                public void run()
                {
                    c.mInfos = a;
                    Animation animation1 = AnimationUtils.loadAnimation(c.mContext, 0x7f04002a);
                    if (!c.mRefrenceViewMap.isEmpty())
                    {
                        c.mRefrenceViewMap.clear();
                        c.mSelectedPageIndex = -1;
                        c.mSelectedItemIndexAtPage = -1;
                        c.mCollectionViewPager.removeAllViews();
                        c.mCollectionViewPager.setAdapter(null);
                        c.mCollectionViewPager.setAdapter(c.mCollectionPagerAdapter);
                    }
                    c.mCollectionPagerAdapter.notifyDataSetChanged();
                    c.setSelectedIndex(b);
                    c.mCollectionViewPager.startAnimation(animation1);
                }

            
            {
                c = TTieZhiCollectionPageScrolllView.this;
                a = list;
                b = i;
                super();
            }
            }, animation.getDuration());
            return;
        }
    }

    public void setImageWorker(on on)
    {
        imageWorker = on;
    }

    public void setItemClickLisener(oy oy)
    {
        lisener = oy;
    }

    public void setSelectedIndex(int i)
    {
        if (i < 0)
        {
            mSelectedPageIndex = -1;
            mSelectedItemIndexAtPage = -1;
            return;
        }
        mSelectedPageIndex = i / perPageItemCount;
        mSelectedItemIndexAtPage = i % perPageItemCount;
        if (mRefrenceViewMap.containsKey(Integer.valueOf(mSelectedPageIndex)))
        {
            ((TTieZhiCollectionPageView)mRefrenceViewMap.get(Integer.valueOf(mSelectedPageIndex))).setItemSelected(mSelectedItemIndexAtPage);
        }
        mCollectionViewPager.setCurrentItem(mSelectedPageIndex);
    }



/*
    static List access$002(TTieZhiCollectionPageScrolllView ttiezhicollectionpagescrolllview, List list)
    {
        ttiezhicollectionpagescrolllview.mInfos = list;
        return list;
    }

*/




/*
    static int access$202(TTieZhiCollectionPageScrolllView ttiezhicollectionpagescrolllview, int i)
    {
        ttiezhicollectionpagescrolllview.mSelectedPageIndex = i;
        return i;
    }

*/



/*
    static int access$302(TTieZhiCollectionPageScrolllView ttiezhicollectionpagescrolllview, int i)
    {
        ttiezhicollectionpagescrolllview.mSelectedItemIndexAtPage = i;
        return i;
    }

*/



}

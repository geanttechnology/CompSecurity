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
import awf;
import awu;
import awv;
import aww;
import axt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import viewpagerindicator.CirclePageIndicator;

// Referenced classes of package com.fotoable.sketch.view:
//            TTieZhiCollectionPageView

public class TTieZhiCollectionPageScrolllView extends FrameLayout
{

    private awf imageWorker;
    private axt lisener;
    public CirclePageIndicator mCirclePageIndicator;
    public aww mCollectionPagerAdapter;
    public ViewPager mCollectionViewPager;
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
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300d1, this, true);
        perPageItemCount = TTieZhiCollectionPageView.getItemCountPerLine(mContext) * TTieZhiCollectionPageView.KPageLine;
        mRefrenceViewMap.clear();
        mCollectionViewPager = (ViewPager)findViewById(0x7f0d0340);
        mCollectionPagerAdapter = new aww(this);
        mCollectionViewPager.setAdapter(mCollectionPagerAdapter);
        mCirclePageIndicator = (CirclePageIndicator)findViewById(0x7f0d0341);
        mCirclePageIndicator.setViewPager(mCollectionViewPager);
        mCirclePageIndicator.setOnPageChangeListener(new awu(this));
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
            Animation animation = AnimationUtils.loadAnimation(mContext, 0x7f04003d);
            mCollectionViewPager.startAnimation(animation);
            (new Handler()).postDelayed(new awv(this, list, i), animation.getDuration());
            return;
        }
    }

    public void setImageWorker(awf awf)
    {
        imageWorker = awf;
    }

    public void setItemClickLisener(axt axt)
    {
        lisener = axt;
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
    public static List access$002(TTieZhiCollectionPageScrolllView ttiezhicollectionpagescrolllview, List list)
    {
        ttiezhicollectionpagescrolllview.mInfos = list;
        return list;
    }

*/




/*
    public static int access$202(TTieZhiCollectionPageScrolllView ttiezhicollectionpagescrolllview, int i)
    {
        ttiezhicollectionpagescrolllview.mSelectedPageIndex = i;
        return i;
    }

*/



/*
    public static int access$302(TTieZhiCollectionPageScrolllView ttiezhicollectionpagescrolllview, int i)
    {
        ttiezhicollectionpagescrolllview.mSelectedItemIndexAtPage = i;
        return i;
    }

*/



}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import awf;
import awk;
import axo;
import axp;
import axq;
import axr;
import axt;
import com.fotoable.fotoproedit.view.ui.ProEidtMainActionBarView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import viewpagerindicator.TabPageIndicator;

// Referenced classes of package com.fotoable.sketch.view:
//            TTieZhiLibraryView

public class TTieZhiMainLibraryView extends FrameLayout
{

    public boolean _isFinishLoad;
    public awf imageWorker;
    private axt lisener;
    axr mAdapter;
    public List mData;
    TabPageIndicator mIndicator;
    private ViewPager mPager;
    public Map mRefrenceViewMap;
    ProEidtMainActionBarView topView;

    public TTieZhiMainLibraryView(Context context)
    {
        super(context);
        imageWorker = null;
        mRefrenceViewMap = new HashMap();
        _isFinishLoad = false;
        initView();
    }

    public TTieZhiMainLibraryView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        imageWorker = null;
        mRefrenceViewMap = new HashMap();
        _isFinishLoad = false;
        initView();
    }

    public TTieZhiMainLibraryView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        imageWorker = null;
        mRefrenceViewMap = new HashMap();
        _isFinishLoad = false;
        initView();
    }

    private Object getCurrentView()
    {
        int i = mPager.getCurrentItem();
        return mAdapter.a(i);
    }

    public void handleData(List list)
    {
        mData = list;
        mIndicator.notifyDataSetChanged();
        mAdapter.notifyDataSetChanged();
        refreshView();
    }

    public void initView()
    {
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300d6, this, true);
        topView = (ProEidtMainActionBarView)findViewById(0x7f0d034e);
        topView.hideShareButton();
        topView.setOnTouchListener(new axo(this));
        topView.setOnActionBarItemListener(new axp(this));
        mPager = (ViewPager)findViewById(0x7f0d00f0);
        mAdapter = new axr(this);
        mPager.setAdapter(mAdapter);
        mIndicator = (TabPageIndicator)findViewById(0x7f0d034f);
        mIndicator.setTabAlignType(2);
        mIndicator.setViewPager(mPager);
        mIndicator.setOnPageChangeListener(new axq(this));
    }

    public void initWithImageWorker(awf awf)
    {
        imageWorker = awf;
    }

    public void jumpToIndex(int i)
    {
        mPager.setCurrentItem(i, false);
    }

    public void refreshView()
    {
        if (mRefrenceViewMap.size() > 0)
        {
            Iterator iterator = mRefrenceViewMap.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Integer integer = (Integer)iterator.next();
                if (integer.intValue() < mData.size())
                {
                    ((TTieZhiLibraryView)mRefrenceViewMap.get(integer)).setTieZhiCellLisener(lisener);
                    ((TTieZhiLibraryView)mRefrenceViewMap.get(integer)).setIsFinishLoad(_isFinishLoad);
                    ((TTieZhiLibraryView)mRefrenceViewMap.get(integer)).setData((awk)mData.get(integer.intValue()));
                }
            } while (true);
        }
    }

    public void reload()
    {
        if (mRefrenceViewMap.size() > 0)
        {
            Iterator iterator = mRefrenceViewMap.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Integer integer = (Integer)iterator.next();
                if (integer.intValue() < mData.size())
                {
                    ((TTieZhiLibraryView)mRefrenceViewMap.get(integer)).reloadData();
                }
            } while (true);
        }
    }

    public void setIsFinishLoad(boolean flag)
    {
        _isFinishLoad = flag;
        refreshView();
    }

    public void setItemClickLisener(axt axt)
    {
        lisener = axt;
    }

}

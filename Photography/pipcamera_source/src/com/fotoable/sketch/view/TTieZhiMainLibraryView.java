// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.fotoable.photocollage.view.ProEidtMainActionBarView;
import com.fotoable.photocollage.view.compose2.indicate.TabPageIndicator;
import com.pipcamera.application.PIPCameraApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mb;
import ol;
import on;
import or;
import ox;
import oy;

// Referenced classes of package com.fotoable.sketch.view:
//            TTieZhiLibraryView

public class TTieZhiMainLibraryView extends FrameLayout
{

    public boolean _isFinishLoad;
    public on imageWorker;
    private oy lisener;
    ox mAdapter;
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
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030097, this, true);
        topView = (ProEidtMainActionBarView)findViewById(0x7f0c0261);
        topView.setActionBarTitle(PIPCameraApplication.a.getResources().getString(0x7f060275));
        topView.hideShareButton();
        topView.setOnTouchListener(new android.view.View.OnTouchListener() {

            final TTieZhiMainLibraryView a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                return false;
            }

            
            {
                a = TTieZhiMainLibraryView.this;
                super();
            }
        });
        topView.setOnActionBarItemListener(new mb() {

            final TTieZhiMainLibraryView a;

            public void a()
            {
            }

            public void b()
            {
                ol.a().b();
                if (a.lisener != null)
                {
                    a.lisener.b(false);
                    a.lisener.b();
                }
            }

            
            {
                a = TTieZhiMainLibraryView.this;
                super();
            }
        });
        mPager = (ViewPager)findViewById(0x7f0c0077);
        mAdapter = new ox(this);
        mPager.setAdapter(mAdapter);
        mIndicator = (TabPageIndicator)findViewById(0x7f0c0262);
        mIndicator.setTabAlignType(2);
        mIndicator.setViewPager(mPager);
        mIndicator.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {

            final TTieZhiMainLibraryView a;

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
                a = TTieZhiMainLibraryView.this;
                super();
            }
        });
    }

    public void initWithImageWorker(on on)
    {
        imageWorker = on;
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
                    ((TTieZhiLibraryView)mRefrenceViewMap.get(integer)).setData((or)mData.get(integer.intValue()));
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

    public void setItemClickLisener(oy oy)
    {
        lisener = oy;
    }

}

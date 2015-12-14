// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.view;

import acm;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import apq;
import aqx;
import atz;
import awc;
import awf;
import awg;
import awm;
import axa;
import axb;
import axc;
import axt;
import com.fotoable.sketch.info.TTieZhiInfo;
import java.util.List;
import yp;

public class TTieZhiCollectionView extends FrameLayout
{

    private axt lisener;
    Context mContext;
    public awf mImageWorker;
    private LayoutInflater mInflater;
    private LinearLayout mLayout;
    List mListInfos;
    private HorizontalScrollView mScrollView;
    int mSelectIndex;
    axc mSelectedView;

    public TTieZhiCollectionView(Context context)
    {
        super(context);
        mContext = context;
        init();
    }

    public TTieZhiCollectionView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mContext = context;
        init();
    }

    public TTieZhiCollectionView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mContext = context;
        init();
    }

    private void downloadInfo(TTieZhiInfo ttiezhiinfo)
    {
        if (ttiezhiinfo == null)
        {
            return;
        } else
        {
            awc.a().a(ttiezhiinfo, new axa(this));
            return;
        }
    }

    private void init()
    {
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300d2, this, true);
        mInflater = (LayoutInflater)getContext().getSystemService("layout_inflater");
        mScrollView = (HorizontalScrollView)findViewById(0x7f0d0343);
        mScrollView.setHorizontalScrollBarEnabled(false);
        mScrollView.setVisibility(0);
        mLayout = new LinearLayout(getContext());
        mLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -1));
        mLayout.setOrientation(0);
        mScrollView.addView(mLayout);
    }

    private void onItemViewCliked(TTieZhiInfo ttiezhiinfo, axc axc1)
    {
        if (mSelectedView != axc1)
        {
            if (mSelectedView != null)
            {
                mSelectedView.setSelected(false);
            }
            mSelectedView = axc1;
            mSelectedView.setSelected(true);
            mSelectIndex = mSelectedView.b();
        }
        scrollToVisableByIndex(getIndexByInfo(ttiezhiinfo));
        if (awg.a().b(ttiezhiinfo.resId))
        {
            ttiezhiinfo = awg.a().c(ttiezhiinfo.resId);
            if (lisener != null)
            {
                awg.a().a(ttiezhiinfo.resId);
                lisener.a(ttiezhiinfo, false);
            }
        } else
        if (mContext == null || !(new awm(mContext, ttiezhiinfo)).a())
        {
            downloadInfo(ttiezhiinfo);
            return;
        }
    }

    private void scrollBy(int i)
    {
        (new Handler()).postDelayed(new axb(this, i), 10L);
    }

    private void setShareTagByInfo(ImageView imageview, TTieZhiInfo ttiezhiinfo)
    {
        imageview.setVisibility(4);
        imageview.setImageResource(0x7f0203fa);
        imageview.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        if (!awg.a().b(ttiezhiinfo.resId))
        {
            boolean flag;
            if (ttiezhiinfo.otherAppStoreId != null && !ttiezhiinfo.otherAppStoreId.equalsIgnoreCase("null") && ttiezhiinfo.otherAppStoreId.length() > 4 && !apq.a(getContext(), ttiezhiinfo.otherAppStoreId))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            imageview.setScaleType(android.widget.ImageView.ScaleType.FIT_START);
            imageview.setImageResource(0x7f0202a1);
            imageview.setVisibility(0);
            if (ttiezhiinfo.needSharing && (new atz(getContext())).b() && !aqx.a(ttiezhiinfo))
            {
                imageview.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
                imageview.setImageResource(0x7f0203fa);
                imageview.setVisibility(0);
            }
            if (ttiezhiinfo.needReviewing && !acm.c())
            {
                imageview.setVisibility(0);
                imageview.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
                imageview.setImageResource(0x7f0202a9);
            }
            if (flag)
            {
                imageview.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
                imageview.setImageResource(0x7f020045);
                imageview.setVisibility(0);
            }
        }
    }

    public int getIndexByInfo(TTieZhiInfo ttiezhiinfo)
    {
        if (ttiezhiinfo != null && mListInfos != null)
        {
            for (int i = 0; i < mListInfos.size(); i++)
            {
                TTieZhiInfo ttiezhiinfo1 = (TTieZhiInfo)mListInfos.get(i);
                if (ttiezhiinfo.resId == ttiezhiinfo1.resId)
                {
                    return i;
                }
            }

        }
        return 0;
    }

    public void reloadData()
    {
        int i = 0;
        do
        {
            try
            {
                if (i >= mListInfos.size())
                {
                    break;
                }
                axc axc1 = (axc)mLayout.getChildAt(i);
                axc1.a();
                if (i == mSelectIndex)
                {
                    if (mSelectedView != null)
                    {
                        mSelectedView.setSelected(false);
                    }
                    mSelectedView = axc1;
                    mSelectedView.setSelected(true);
                }
            }
            catch (Exception exception)
            {
                break;
            }
            i++;
        } while (true);
    }

    public void scrollToVisableByIndex(int i)
    {
        int j;
        int k;
        int l;
        int i1;
        int j1;
        if (i < 0)
        {
            return;
        }
        k = mScrollView.getScrollX();
        i1 = yp.a(getContext(), 56F);
        l = i1 * i;
        j = l + i1;
        j1 = mScrollView.getWidth();
        if (l > k) goto _L2; else goto _L1
_L1:
        j = l;
        if (i > 0)
        {
            j = l - i1;
        }
        mScrollView.scrollTo(j, 0);
_L4:
        scrollBy(j);
        return;
_L2:
        if (j >= k + j1)
        {
            k = j - j1;
            j = k;
            if (i < mListInfos.size() - 1)
            {
                j = k + i1;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (i > 0 && i < mListInfos.size() - 1)
        {
            i = l - i1;
            l = i1 + j;
            j = i;
            if (i < k)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (l > k + j1)
            {
                j = l - j1;
                continue; /* Loop/switch isn't completed */
            }
        }
        j = k;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setDataList(List list, int i)
    {
        if (list != null && i < list.size())
        {
            mListInfos = list;
            mLayout.removeAllViews();
            mSelectIndex = i;
            int j = 0;
            while (j < mListInfos.size()) 
            {
                list = new axc(this, getContext());
                list.a((TTieZhiInfo)mListInfos.get(j), j);
                if (j == mSelectIndex)
                {
                    list.setSelected(true);
                    mSelectedView = list;
                } else
                {
                    list.setSelected(false);
                }
                mLayout.addView(list);
                j++;
            }
            scrollToVisableByIndex(i);
        }
    }

    public void setImageWorker(awf awf)
    {
        mImageWorker = awf;
    }

    public void setItemClickLisener(axt axt1)
    {
        lisener = axt1;
    }

    public void setSelectedIndex(int i)
    {
        if (i >= mListInfos.size() || mSelectIndex == i)
        {
            return;
        } else
        {
            mSelectIndex = i;
            reloadData();
            scrollToVisableByIndex(i);
            return;
        }
    }




}

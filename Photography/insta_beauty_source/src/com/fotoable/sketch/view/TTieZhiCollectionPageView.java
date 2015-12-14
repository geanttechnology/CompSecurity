// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.view;

import acm;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import apq;
import aqx;
import atz;
import awf;
import awg;
import awx;
import axt;
import com.fotoable.sketch.info.TTieZhiInfo;
import com.instabeauty.application.InstaBeautyApplication;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import yp;

public class TTieZhiCollectionPageView extends FrameLayout
{

    public static int KPageItemSpace;
    public static int KPageItemViewWidth;
    public static int KPageLine = 2;
    private static final Semaphore semp = new Semaphore(1);
    private List itemViews;
    private FrameLayout mContainerLayout;
    private Context mContext;
    private awf mImageWorker;
    private axt mLisener;
    private List mListInfos;
    private int mSelectIndex;
    private awx mSelectedView;

    public TTieZhiCollectionPageView(Context context)
    {
        super(context);
        itemViews = new ArrayList();
        mListInfos = new ArrayList();
        init(context);
    }

    public TTieZhiCollectionPageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        itemViews = new ArrayList();
        mListInfos = new ArrayList();
        init(context);
    }

    public TTieZhiCollectionPageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        itemViews = new ArrayList();
        mListInfos = new ArrayList();
        init(context);
    }

    private void clearSelectedState()
    {
        if (mSelectedView != null)
        {
            mSelectedView.setSelected(false);
            mSelectedView = null;
        }
    }

    public static int getItemCountPerLine(Context context)
    {
        int j = yp.d(context);
        int i = j / KPageItemViewWidth;
        j -= KPageItemViewWidth * i;
        int k = j / (i + 1);
        j -= (i + 1) * k;
        k = KPageItemViewWidth;
        j /= 2;
        j = KPageLine;
        return i;
    }

    private void init(Context context)
    {
        mContext = context;
        mContainerLayout = new FrameLayout(mContext);
        int i = yp.d(mContext);
        int l = i / KPageItemViewWidth;
        i -= KPageItemViewWidth * l;
        int i1 = i / (l + 1);
        i -= (l + 1) * i1;
        int j1 = KPageItemViewWidth;
        int k1 = i / 2;
        i = KPageLine;
        context = new android.widget.FrameLayout.LayoutParams(yp.d(mContext), i * (j1 + i1) + i1);
        context.gravity = 51;
        context.topMargin = 0;
        context.leftMargin = 0;
        addView(mContainerLayout, context);
        for (int j = 0; j < 2; j++)
        {
            for (int k = 0; k < l; k++)
            {
                context = new awx(this, mContext);
                android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(j1, j1);
                layoutparams.gravity = 51;
                layoutparams.topMargin = (j1 + i1) * j + i1;
                layoutparams.leftMargin = (j1 + i1) * k + i1 + k1;
                mContainerLayout.addView(context, layoutparams);
                itemViews.add(context);
                context.setVisibility(4);
            }

        }

    }

    private void onItemViewCliked(TTieZhiInfo ttiezhiinfo, awx awx1)
    {
        if (mSelectedView != awx1)
        {
            if (mSelectedView != null)
            {
                mSelectedView.setSelected(false);
            }
            mSelectedView = awx1;
            mSelectedView.setSelected(true);
            mSelectIndex = mSelectedView.a();
        }
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

    public void setCollectionPageViewLisener(axt axt)
    {
        mLisener = axt;
    }

    public void setDataList(List list)
    {
        if (list != null)
        {
            mListInfos = list;
            int i = 0;
            while (i < itemViews.size()) 
            {
                if (i < mListInfos.size())
                {
                    list = (awx)itemViews.get(i);
                    list.setVisibility(0);
                    list.a((TTieZhiInfo)mListInfos.get(i), i);
                } else
                {
                    ((awx)itemViews.get(i)).setVisibility(4);
                }
                i++;
            }
        }
    }

    public void setImageWorker(awf awf)
    {
        mImageWorker = awf;
    }

    public void setItemSelected(int i)
    {
        clearSelectedState();
        if (i > 0 && i < mListInfos.size())
        {
            awx awx1 = (awx)itemViews.get(i);
            awx1.setSelected(true);
            mSelectedView = awx1;
            mSelectIndex = mSelectedView.a();
        }
    }

    static 
    {
        KPageItemViewWidth = yp.a(InstaBeautyApplication.a, 60F);
        KPageItemSpace = yp.a(InstaBeautyApplication.a, 5F);
    }






}

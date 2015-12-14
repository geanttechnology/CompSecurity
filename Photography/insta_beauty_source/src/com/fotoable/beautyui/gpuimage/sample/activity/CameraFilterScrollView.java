// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.gpuimage.sample.activity;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import py;
import pz;

// Referenced classes of package com.fotoable.beautyui.gpuimage.sample.activity:
//            CameraFilterItemView

public class CameraFilterScrollView extends HorizontalScrollView
{

    private int mCurSelFlag;
    private CameraFilterItemView mCurSelectedItem;
    private LinearLayout mLayout;
    private pz mListener;

    public CameraFilterScrollView(Context context)
    {
        super(context);
        init();
    }

    public CameraFilterScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    private final void init()
    {
        mLayout = new LinearLayout(getContext());
        mLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -1));
        mLayout.setOrientation(0);
        setScrollbarFadingEnabled(true);
        setOverScrollMode(2);
        setHorizontalScrollBarEnabled(false);
        intialAdjustItems(true);
        mLayout.setWeightSum(5F);
        addView(mLayout);
        mLayout.setBackgroundColor(getResources().getColor(0x7f0c0012));
        setBackgroundColor(0);
    }

    private void setStartScroll(View view)
    {
        int i = getWidth();
        int j = view.getLeft();
        int k = view.getWidth();
        int l = getScrollX();
        if (j - l > i - k * 2 && j - l < i + k)
        {
            smoothScrollTo((j - i) + k * 2, view.getTop());
        }
        if (j - l < k && j - l >= -view.getWidth())
        {
            smoothScrollTo(j - k, view.getTop());
        }
    }

    public View addItem(int i, int j, String s, int k)
    {
        CameraFilterItemView camerafilteritemview = new CameraFilterItemView(getContext(), null);
        camerafilteritemview.setResorce(i, j);
        camerafilteritemview.setTag(Integer.valueOf(k));
        camerafilteritemview.setFilterPath(s);
        camerafilteritemview.setOnClickListener(new py(this));
        mLayout.addView(camerafilteritemview);
        return camerafilteritemview;
    }

    public void intialAdjustItems(boolean flag)
    {
        if (mLayout.getChildCount() > 0)
        {
            mLayout.removeAllViews();
        }
        mCurSelectedItem = (CameraFilterItemView)addItem(0x7f0601a0, 0x7f0201fd, "fotobeauty/filter/lookup.png", 0);
        mCurSelFlag = 0;
        addItem(0x7f060045, 0x7f0201f9, "fotobeauty/filter/00_lb.png", 1);
        addItem(0x7f060138, 0x7f0201f7, "fotobeauty/filter/23_nimin.png", 2);
        addItem(0x7f060281, 0x7f020203, "fotobeauty/filter/01_tm.png", 3);
        addItem(0x7f060067, 0x7f020200, "fotobeauty/filter/02_abao.png", 4);
        addItem(0x7f060042, 0x7f0201f8, "fotobeauty/filter/Libra.png", 5);
        addItem(0x7f06005f, 0x7f020202, "fotobeauty/filter/filter_3.png", 6);
        addItem(0x7f06003c, 0x7f0201f6, "fotobeauty/filter/05_zr.png", 7);
        addItem(0x7f0600cc, 0x7f0201f4, "fotobeauty/filter/06_ld.png", 8);
        addItem(0x7f0601c1, 0x7f0201fe, "fotobeauty/filter/04_rg.png", 9);
        addItem(0x7f06017e, 0x7f0201fb, "fotobeauty/filter/09_fl.png", 10);
        addItem(0x7f060066, 0x7f020204, "fotobeauty/filter/07_nn.png", 11);
        addItem(0x7f06020c, 0x7f0201ff, "fotobeauty/filter/11_ql.png", 12);
        addItem(0x7f060033, 0x7f0201f2, "fotobeauty/filter/03_bw.png", 13);
        mCurSelectedItem.setSelected(true);
    }

    public void setItemSelected(int i)
    {
        for (int j = 0; j < mLayout.getChildCount(); j++)
        {
            View view = mLayout.getChildAt(j);
            if ((view instanceof CameraFilterItemView) && ((CameraFilterItemView)view).getTextRes() == i)
            {
                mCurSelectedItem.setSelected(false);
                mCurSelectedItem = (CameraFilterItemView)view;
                mCurSelectedItem.setSelected(true);
                mCurSelFlag = ((Integer)view.getTag()).intValue();
            }
        }

    }

    public void setListener(pz pz1)
    {
        mListener = pz1;
    }

    public void setScrollSelected(boolean flag)
    {
        View view;
        int i;
        int j;
        int k;
        int l;
        if (flag)
        {
            mCurSelFlag = mCurSelFlag - 1;
            if (mCurSelFlag < 0)
            {
                mCurSelFlag = mLayout.getChildCount() - 1;
            } else
            {
                mCurSelFlag = mCurSelFlag % mLayout.getChildCount();
            }
        } else
        {
            mCurSelFlag = (mCurSelFlag + 1) % mLayout.getChildCount();
        }
        view = mLayout.findViewWithTag(Integer.valueOf(mCurSelFlag));
        if (mCurSelectedItem != null)
        {
            mCurSelectedItem.setSelected(false);
        }
        i = getWidth();
        j = view.getLeft();
        view.getWidth();
        k = getScrollX();
        l = mLayout.getWidth();
        if (j >= k) goto _L2; else goto _L1
_L1:
        smoothScrollTo(j, view.getTop());
_L4:
        mCurSelectedItem = (CameraFilterItemView)view;
        view.setSelected(true);
        mCurSelFlag = ((Integer)view.getTag()).intValue();
        if (mListener != null)
        {
            mListener.a(mCurSelectedItem.getFilterPath(), mCurSelectedItem.getTextRes(), mCurSelectedItem.getText());
        }
        return;
_L2:
        if (j - k > i)
        {
            if (l - j < i)
            {
                smoothScrollTo(l - i, view.getTop());
            } else
            {
                smoothScrollTo(j, view.getTop());
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }



/*
    public static CameraFilterItemView access$002(CameraFilterScrollView camerafilterscrollview, CameraFilterItemView camerafilteritemview)
    {
        camerafilterscrollview.mCurSelectedItem = camerafilteritemview;
        return camerafilteritemview;
    }

*/



/*
    public static int access$202(CameraFilterScrollView camerafilterscrollview, int i)
    {
        camerafilterscrollview.mCurSelFlag = i;
        return i;
    }

*/

}

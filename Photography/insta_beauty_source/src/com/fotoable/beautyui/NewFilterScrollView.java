// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.crashlytics.android.Crashlytics;
import com.wantu.imagerender.ImageGLSurfaceView;
import im;
import iw;
import ix;
import iy;

// Referenced classes of package com.fotoable.beautyui:
//            filterItemView

public class NewFilterScrollView extends HorizontalScrollView
{

    private static final String TAG = "NewFilterScrollView";
    private int filterChangeNum;
    private im mCallback;
    private View mCurSelectedItem;
    private LinearLayout mLayout;
    ImageGLSurfaceView mSurfaceView1;
    private Bitmap smallBmp;

    public NewFilterScrollView(Context context)
    {
        super(context);
        init();
    }

    public NewFilterScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    private final void init()
    {
        mLayout = new LinearLayout(getContext());
        mLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -1));
        mLayout.setOrientation(0);
        mLayout.setBackgroundColor(getResources().getColor(0x7f0c002a));
        setScrollbarFadingEnabled(true);
        setOverScrollMode(2);
        setHorizontalScrollBarEnabled(false);
        addView(mLayout);
        intialPresetItems();
    }

    private void intialPresetItems()
    {
        mCurSelectedItem = addItem(0x7f0c002a, 0x7f0c009d, 0x7f0601a0, 0x7f02035d, 0x7f0601a0);
        mCurSelectedItem.setSelected(true);
        addItem(0x7f0c002a, 0x7f0c009d, 0x7f060045, 0x7f02035d, 0x7f060045);
        addItem(0x7f0c002a, 0x7f0c009d, 0x7f060138, 0x7f02035d, 0x7f060138);
        addItem(0x7f0c002a, 0x7f0c009d, 0x7f060281, 0x7f02035d, 0x7f060281);
        addItem(0x7f0c002a, 0x7f0c009d, 0x7f060067, 0x7f02035d, 0x7f060067);
        addItem(0x7f0c002a, 0x7f0c009d, 0x7f060042, 0x7f02035d, 0x7f060042);
        addItem(0x7f0c002a, 0x7f0c009d, 0x7f06005f, 0x7f02035d, 0x7f06005f);
        addItem(0x7f0c002a, 0x7f0c009d, 0x7f06003c, 0x7f02035d, 0x7f06003c);
        addItem(0x7f0c002a, 0x7f0c009d, 0x7f0600cc, 0x7f02035d, 0x7f0600cc);
        addItem(0x7f0c002a, 0x7f0c009d, 0x7f0601c1, 0x7f02035d, 0x7f0601c1);
        addItem(0x7f0c002a, 0x7f0c009d, 0x7f06017e, 0x7f02035d, 0x7f06017e);
        addItem(0x7f0c002a, 0x7f0c009d, 0x7f060066, 0x7f02035d, 0x7f060066);
        addItem(0x7f0c002a, 0x7f0c009d, 0x7f06020c, 0x7f02035d, 0x7f06020c);
        addItem(0x7f0c002a, 0x7f0c009d, 0x7f060033, 0x7f02035d, 0x7f06009d);
    }

    private void setScrollItemImage(Bitmap bitmap)
    {
        if (filterChangeNum >= mLayout.getChildCount() || bitmap == null)
        {
            if (mSurfaceView1 != null)
            {
                mSurfaceView1.clear();
                mSurfaceView1.onPause();
                mLayout.removeView(mSurfaceView1);
                mSurfaceView1 = null;
            }
        } else
        {
            View view = mLayout.getChildAt(filterChangeNum);
            if (view instanceof filterItemView)
            {
                int i = ((Integer)view.getTag()).intValue();
                if (i != 0x7f06009d);
                if (mSurfaceView1 == null)
                {
                    mSurfaceView1 = new ImageGLSurfaceView(getContext());
                    mLayout.addView(mSurfaceView1);
                    android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)mSurfaceView1.getLayoutParams();
                    layoutparams.height = 2;
                    layoutparams.width = 2;
                    mSurfaceView1.setLayoutParams(layoutparams);
                    mSurfaceView1.setVisibility(0);
                    mSurfaceView1.getHolder().addCallback(new ix(this));
                    mSurfaceView1.onResume();
                }
                mSurfaceView1.processImage(bitmap, getResources().getString(i), 1.0F, new iy(this, this));
                return;
            }
            if (mSurfaceView1 != null)
            {
                mSurfaceView1.clear();
                mSurfaceView1.onPause();
                mLayout.removeView(mSurfaceView1);
                mSurfaceView1 = null;
                return;
            }
        }
    }

    private void setStartScroll(View view)
    {
        int i = getWidth();
        int j = view.getLeft();
        int k = view.getWidth();
        int l = getScrollX();
        mLayout.getWidth();
        if (j - l > i - k * 2 && j - l < i + k)
        {
            smoothScrollTo((j - i) + k * 2, view.getTop());
        }
        if (j - l < k && j - l >= -view.getWidth())
        {
            smoothScrollTo(j - k, view.getTop());
        }
    }

    public View addItem(int i, int j, int k, int l, int i1)
    {
        filterItemView filteritemview;
        try
        {
            filteritemview = new filterItemView(getContext(), null);
            filteritemview.setInitData(0x303030, getResources().getColor(j), k, l);
            filteritemview.setTag(Integer.valueOf(i1));
            filteritemview.setClickable(true);
            filteritemview.setOnClickListener(new iw(this));
            mLayout.addView(filteritemview);
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
            Log.e("NewFilterScrollView", exception.getMessage());
            return null;
        }
        return filteritemview;
    }

    public void needScrollView()
    {
        if (mCurSelectedItem != null)
        {
            setStartScroll(mCurSelectedItem);
        }
    }

    public void setCallback(im im1)
    {
        mCallback = im1;
    }

    public void setItemViewSelected(int i)
    {
        mCurSelectedItem.setSelected(false);
        mCurSelectedItem = null;
        int j = 0;
        do
        {
label0:
            {
                if (j < mLayout.getChildCount())
                {
                    View view = mLayout.getChildAt(i);
                    if (!(view instanceof filterItemView) || ((Integer)view.getTag()).intValue() != i)
                    {
                        break label0;
                    }
                    mCurSelectedItem = view;
                    mCurSelectedItem.setSelected(true);
                }
                return;
            }
            j++;
        } while (true);
    }

    public void setItemViewSelected(String s)
    {
        int i;
        boolean flag;
        flag = false;
        mCurSelectedItem.setSelected(false);
        mCurSelectedItem = null;
        i = 0;
_L9:
        View view;
        if (i >= mLayout.getChildCount())
        {
            break MISSING_BLOCK_LABEL_259;
        }
        view = mLayout.getChildAt(i);
        if (!(view instanceof filterItemView)) goto _L2; else goto _L1
_L1:
        String s1;
        int j = ((Integer)view.getTag()).intValue();
        s1 = getResources().getString(j);
        if (s1 == null || !s1.equals(s)) goto _L2; else goto _L3
_L3:
        mCurSelectedItem = view;
        mCurSelectedItem.setSelected(true);
        smoothScrollTo(view.getWidth() * i, 0);
        if (mCallback != null)
        {
            mCallback.a(((Integer)view.getTag()).intValue(), this, ((filterItemView)view).getText());
        }
        i = 1;
_L11:
        if (i != 0) goto _L5; else goto _L4
_L4:
        getResources().getString(0x7f0600d4);
        i = ((flag) ? 1 : 0);
_L10:
        if (i >= mLayout.getChildCount()) goto _L5; else goto _L6
_L6:
        s = mLayout.getChildAt(i);
        if (!(s instanceof filterItemView)) goto _L8; else goto _L7
_L7:
        mCurSelectedItem = s;
        mCurSelectedItem.setSelected(true);
        if (mCallback != null)
        {
            mCallback.a(((Integer)s.getTag()).intValue(), this, ((filterItemView)s).getText());
        }
_L5:
        return;
_L2:
        i++;
          goto _L9
_L8:
        i++;
          goto _L10
        i = 0;
          goto _L11
    }

    public void setPresetScrollImg(Bitmap bitmap)
    {
        smallBmp = bitmap;
        for (int i = 0; i < mLayout.getChildCount(); i++)
        {
            bitmap = mLayout.getChildAt(i);
            if (bitmap instanceof filterItemView)
            {
                ((filterItemView)bitmap).setImageBmp(smallBmp);
            }
        }

    }

    public void setScrollImage(Bitmap bitmap)
    {
        setPresetScrollImg(bitmap);
        filterChangeNum = 1;
        setScrollItemImage(smallBmp);
    }



/*
    public static View access$002(NewFilterScrollView newfilterscrollview, View view)
    {
        newfilterscrollview.mCurSelectedItem = view;
        return view;
    }

*/




/*
    public static int access$208(NewFilterScrollView newfilterscrollview)
    {
        int i = newfilterscrollview.filterChangeNum;
        newfilterscrollview.filterChangeNum = i + 1;
        return i;
    }

*/



}

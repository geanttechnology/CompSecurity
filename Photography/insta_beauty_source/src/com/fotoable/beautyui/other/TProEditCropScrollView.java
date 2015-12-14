// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.other;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.crashlytics.android.Crashlytics;
import java.util.ArrayList;
import java.util.List;
import xn;
import xo;
import yp;

// Referenced classes of package com.fotoable.beautyui.other:
//            ColorItemView, ItemView

public class TProEditCropScrollView extends HorizontalScrollView
{

    private static final String TAG = "TFilterListScrollView";
    private List bmList;
    private float bmpRatios;
    private xn mCallback;
    private View mCurSelectedItem;
    private LinearLayout mLayout;

    public TProEditCropScrollView(Context context)
    {
        super(context);
        bmList = new ArrayList();
        init();
    }

    public TProEditCropScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        bmList = new ArrayList();
        init();
    }

    private final void init()
    {
        mLayout = new LinearLayout(getContext());
        mLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -1));
        mLayout.setOrientation(0);
        setHorizontalScrollBarEnabled(false);
        addView(mLayout);
    }

    public ColorItemView addItem(int i, String s, String s1)
    {
        ColorItemView coloritemview;
        try
        {
            coloritemview = new ColorItemView(getContext(), null);
            coloritemview.setIconRes(i);
            coloritemview.setText(s1);
            coloritemview.setTextColor(getResources().getColor(0x7f0c00a6));
            coloritemview.setImageFilter(getResources().getColor(0x7f0c00a6));
            coloritemview.setTag(s);
            coloritemview.setClickable(true);
            coloritemview.setOnClickListener(new xo(this));
            i = getResources().getDisplayMetrics().widthPixels;
            if (yp.a(getContext(), 340F) < i)
            {
                coloritemview.setItemWidth(i / 5);
            }
            mLayout.addView(coloritemview);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Crashlytics.logException(s);
            Log.e("TFilterListScrollView", s.getMessage());
            return null;
        }
        return coloritemview;
    }

    public void initItem()
    {
        ColorItemView coloritemview = addItem(0x7f020451, "free", getContext().getResources().getString(0x7f0602cc));
        coloritemview.setSelected(true);
        mCurSelectedItem = coloritemview;
        addItem(0x7f0203a2, "original", getContext().getResources().getString(0x7f0601a0));
        addItem(0x7f020446, "1-1", getContext().getResources().getString(0x7f0602cb));
        addItem(0x7f020452, "goldenV", getContext().getResources().getString(0x7f0602cd));
        addItem(0x7f020447, "2-3", "2:3");
        addItem(0x7f020449, "3-4", "3:4");
        addItem(0x7f020445, "16-9", "16:9");
    }

    public void setCallback(xn xn)
    {
        mCallback = xn;
    }



/*
    public static View access$002(TProEditCropScrollView tproeditcropscrollview, View view)
    {
        tproeditcropscrollview.mCurSelectedItem = view;
        return view;
    }

*/

}

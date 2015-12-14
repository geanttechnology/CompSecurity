// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.view.ui.scroll;

import amw;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;
import xn;

// Referenced classes of package com.fotoable.fotoproedit.view.ui.scroll:
//            ItemView, ColorItemView

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
        ItemView itemview = addItem(0x7f020451, "free", getContext().getResources().getString(0x7f0602cc));
        itemview.setSelected(true);
        mCurSelectedItem = itemview;
    }

    public ItemView addItem(int i, String s, String s1)
    {
        ColorItemView coloritemview;
        try
        {
            coloritemview = new ColorItemView(getContext(), null);
            coloritemview.setIconRes(i);
            coloritemview.setText(s1);
            coloritemview.setTextColor(Color.parseColor("#ee7488"));
            coloritemview.setTag(s);
            coloritemview.setBackgroundDrawable(getResources().getDrawable(0x7f02037c));
            coloritemview.setClickable(true);
            coloritemview.setOnClickListener(new amw(this));
            mLayout.addView(coloritemview);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("TFilterListScrollView", s.getMessage());
            return null;
        }
        return coloritemview;
    }

    public float getBmpRatios()
    {
        return bmpRatios;
    }

    public void setBmpRatios(float f)
    {
        bmpRatios = f;
        if (f < 1.0F)
        {
            addItem(0x7f020449, "3-4", "3:4");
        } else
        {
            addItem(0x7f02044a, "4-3", "4:3");
        }
        if (f < 1.0F)
        {
            addItem(0x7f020452, "goldenV", getContext().getResources().getString(0x7f0602cd));
        } else
        {
            addItem(0x7f020452, "goldenH", getContext().getResources().getString(0x7f0602cd));
        }
        if (f < 1.0F)
        {
            addItem(0x7f020447, "2-3", "2:3");
        } else
        {
            addItem(0x7f020448, "3-2", "3:2");
        }
        addItem(0x7f020446, "1-1", getContext().getResources().getString(0x7f0602cb));
        if (f < 1.0F)
        {
            addItem(0x7f02044b, "9-16", "9:16");
            return;
        } else
        {
            addItem(0x7f020445, "16-9", "16:9");
            return;
        }
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

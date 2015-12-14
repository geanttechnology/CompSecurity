// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.view.compose2.pager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.wantu.model.res.TResInfo;
import ew;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mi;
import mr;

// Referenced classes of package com.fotoable.photocollage.view.compose2.pager:
//            TPageLine

public class TPageMultiLine extends FrameLayout
{

    mi listener;
    List pageLineList;
    int perLine;

    public TPageMultiLine(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        pageLineList = new ArrayList();
        perLine = 0;
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300a9, this, false);
    }

    public void clear()
    {
        for (Iterator iterator = pageLineList.iterator(); iterator.hasNext(); ((TPageLine)iterator.next()).clear()) { }
    }

    public void setItemData(int i, TResInfo tresinfo, boolean flag)
    {
        int j = i / perLine;
        int k = perLine;
        ((TPageLine)pageLineList.get(j)).setItemData(i - k * j, tresinfo, flag);
    }

    public void setItemSelect(TResInfo tresinfo, boolean flag)
    {
        for (Iterator iterator = pageLineList.iterator(); iterator.hasNext(); ((TPageLine)iterator.next()).setItemSelect(tresinfo, flag)) { }
    }

    public void setItemSelectListener(mi mi)
    {
        listener = mi;
        for (Iterator iterator = pageLineList.iterator(); iterator.hasNext(); ((TPageLine)iterator.next()).setItemSelectListener(mi)) { }
    }

    public void setMultiLineInfo(int i, int j, int k, int l, float f, boolean flag)
    {
        Object obj = TPageLine.calcLineItem(getContext(), k, l, f);
        perLine = ((mr) (obj)).c();
        int i1 = ew.a(getContext(), j);
        int j1 = ew.a(getContext(), ((mr) (obj)).b());
        int k1 = (i + 1) * i1 + i * j1;
        int l1 = (int)((float)ew.d(getContext()) * f);
        for (j = 0; j < i; j++)
        {
            obj = new TPageLine(getContext(), null);
            ((TPageLine) (obj)).setView(k, l, f, flag);
            android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, 48);
            layoutparams.height = j1;
            layoutparams.width = l1;
            layoutparams.topMargin = (j + 1) * i1 + j * j1;
            layoutparams.gravity = 48;
            addView(((android.view.View) (obj)), layoutparams);
            pageLineList.add(obj);
            if (listener != null)
            {
                ((TPageLine) (obj)).setItemSelectListener(listener);
            }
        }

        android.view.ViewGroup.LayoutParams layoutparams1 = getLayoutParams();
        obj = layoutparams1;
        if (layoutparams1 == null)
        {
            obj = new android.view.ViewGroup.LayoutParams(l1, k1);
        }
        obj.height = k1;
        obj.width = l1;
        setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        requestLayout();
    }

    public void setMultiLineInfo(int i, int j, int k, int l, int i1, float f, boolean flag)
    {
        Object obj = TPageLine.calcLineItem(ew.d(getContext(), i), l, i1, f);
        perLine = ((mr) (obj)).c();
        int j1 = ew.a(getContext(), k);
        int k1 = ew.a(getContext(), ((mr) (obj)).b());
        int l1 = j * k1 + (j + 1) * j1;
        for (k = 0; k < j; k++)
        {
            obj = new TPageLine(getContext(), null);
            ((TPageLine) (obj)).setView(ew.d(getContext(), i), l, i1, f, flag);
            android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, 48);
            layoutparams.height = k1;
            layoutparams.width = i;
            layoutparams.topMargin = (k + 1) * j1 + k * k1;
            layoutparams.gravity = 48;
            addView(((android.view.View) (obj)), layoutparams);
            pageLineList.add(obj);
            if (listener != null)
            {
                ((TPageLine) (obj)).setItemSelectListener(listener);
            }
        }

        android.view.ViewGroup.LayoutParams layoutparams1 = getLayoutParams();
        obj = layoutparams1;
        if (layoutparams1 == null)
        {
            obj = new android.view.ViewGroup.LayoutParams(i, l1);
        }
        obj.height = l1;
        obj.width = i;
        setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        requestLayout();
    }
}

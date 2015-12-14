// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import bpv;
import bpw;
import bpy;
import bpz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import yo;

// Referenced classes of package com.wantu.view:
//            HorizontalListView

public class TFilterListScrollView extends HorizontalListView
{

    private static final String TAG = "TFilterListScrollView";
    private List items;
    private bpy mCallback;
    private int mCurSelectedIndex;

    public TFilterListScrollView(Context context)
    {
        super(context, null);
        items = new ArrayList();
        mCurSelectedIndex = 0;
        init();
    }

    public TFilterListScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        items = new ArrayList();
        mCurSelectedIndex = 0;
        init();
    }

    private final void init()
    {
        setOnItemClickListener(new bpv(this));
    }

    private void setViewSelected(View view, boolean flag)
    {
        view = view.findViewById(0x7f0d01ef);
        if (view != null)
        {
            view.setSelected(flag);
        }
    }

    private void setVisibleViewSelected(String s, boolean flag)
    {
        int i = 0;
        do
        {
label0:
            {
                if (i < getChildCount())
                {
                    View view = getChildAt(i).findViewById(0x7f0d01ef);
                    if (!((String)view.getTag()).equals(s))
                    {
                        break label0;
                    }
                    view.setSelected(flag);
                }
                return;
            }
            i++;
        } while (true);
    }

    public void addFilterItem(int i, String s)
    {
        bpz bpz1 = new bpz(this);
        bpz1.a = yo.a(getResources().getDrawable(i));
        bpz1.b = s;
        if (items != null)
        {
            items.add(bpz1);
        }
        s = new bpz[items.size()];
        for (i = 0; i < items.size(); i++)
        {
            s[i] = (bpz)items.get(i);
        }

        setAdapter(new bpw(this, getContext(), s));
    }

    public void addFilterItem(Bitmap bitmap, String s)
    {
        bpz bpz1 = new bpz(this);
        bpz1.a = bitmap;
        bpz1.b = s;
        if (items != null)
        {
            items.add(bpz1);
        }
        bitmap = new bpz[items.size()];
        for (int i = 0; i < items.size(); i++)
        {
            bitmap[i] = (bpz)items.get(i);
        }

        setAdapter(new bpw(this, getContext(), bitmap));
    }

    public void cancelSelected()
    {
        mCurSelectedIndex = -1;
        for (int i = 0; i < getChildCount(); i++)
        {
            setViewSelected(getChildAt(i), false);
        }

    }

    public void clear()
    {
        items.clear();
        mCurSelectedIndex = 0;
    }

    public int getIndex(String s)
    {
        Iterator iterator = items.iterator();
        int i = 0;
        do
        {
            if (!iterator.hasNext() || s.equals(((bpz)iterator.next()).b))
            {
                return i;
            }
            i++;
        } while (true);
    }

    public int getItemCount()
    {
        int i = 0;
        if (items != null)
        {
            i = items.size();
        }
        return i;
    }

    public void placeFilterItem(Bitmap bitmap, int i)
    {
        if (i >= items.size())
        {
            return;
        }
        bpz bpz1 = (bpz)items.get(i);
        bpz1.a = bitmap;
        items.set(i, bpz1);
        bitmap = new bpz[items.size()];
        for (i = 0; i < items.size(); i++)
        {
            bitmap[i] = (bpz)items.get(i);
        }

        setAdapter(new bpw(this, getContext(), bitmap));
    }

    public void setCallback(bpy bpy)
    {
        mCallback = bpy;
    }

    public void setItemSelected(int i, Boolean boolean1)
    {
        cancelSelected();
        mCurSelectedIndex = i;
        setVisibleViewSelected(((bpz)items.get(i)).b, boolean1.booleanValue());
    }

    public void setItemSelectedWithNoActionByFilterName(String s)
    {
        cancelSelected();
        Iterator iterator = items.iterator();
        int i = 0;
        do
        {
label0:
            {
                if (iterator.hasNext())
                {
                    if (!s.equals(((bpz)iterator.next()).b))
                    {
                        break label0;
                    }
                    mCurSelectedIndex = i;
                }
                setVisibleViewSelected(s, true);
                return;
            }
            i++;
        } while (true);
    }



/*
    public static int access$102(TFilterListScrollView tfilterlistscrollview, int i)
    {
        tfilterlistscrollview.mCurSelectedIndex = i;
        return i;
    }

*/



}

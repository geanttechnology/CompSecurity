// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.filter;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import com.wantu.view.HorizontalListView;
import gv;
import gx;
import gy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TFilterListScrollView extends HorizontalListView
{

    private static final String TAG = "TFilterListScrollView";
    private List items;
    private gx mCallback;
    private int mCurSelectedIndex;

    public TFilterListScrollView(Context context)
    {
        super(context, null);
        items = new ArrayList();
        mCurSelectedIndex = -1;
        init();
    }

    public TFilterListScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        items = new ArrayList();
        mCurSelectedIndex = -1;
        init();
    }

    private final void init()
    {
        setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final TFilterListScrollView a;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                if (a.mCallback != null)
                {
                    a.cancelSelected();
                    a.setViewSelected(view, true);
                    a.mCurSelectedIndex = i;
                    a.mCallback.a(((gy)a.items.get(i)).b);
                    a.requestLayout();
                    (new Handler()).postAtTime(new Runnable(this, view) {

                        final View a;
                        final _cls1 b;

                        public void run()
                        {
                            int i = a.getLeft();
                            int j = a.getRight();
                            int k = b.a.getWidth();
                            int l = b.a.getChildAt(b.a.getChildCount() - 1).getWidth();
                            if (i - l < 0)
                            {
                                b.a.scrollBy(-l);
                            }
                            if (j + l > k)
                            {
                                b.a.scrollBy(l);
                            }
                        }

            
            {
                b = _pcls1;
                a = view;
                super();
            }
                    }, 300L);
                }
            }

            
            {
                a = TFilterListScrollView.this;
                super();
            }
        });
    }

    private void setViewSelected(View view, boolean flag)
    {
        view = view.findViewById(0x7f0c0127);
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
                    View view = getChildAt(i).findViewById(0x7f0c0127);
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
        gy gy1 = new gy(this);
        gy1.a = i;
        gy1.b = s;
        if (items != null)
        {
            items.add(gy1);
        }
        s = new gy[items.size()];
        for (i = 0; i < items.size(); i++)
        {
            s[i] = (gy)items.get(i);
        }

        setAdapter(new gv(this, getContext(), s));
    }

    public void addFilterItem(Bitmap bitmap, String s)
    {
        gy gy1 = new gy(this);
        gy1.c = bitmap;
        gy1.a = -1;
        gy1.b = s;
        if (items != null)
        {
            items.add(gy1);
        }
        bitmap = new gy[items.size()];
        for (int i = 0; i < items.size(); i++)
        {
            bitmap[i] = (gy)items.get(i);
        }

        setAdapter(new gv(this, getContext(), bitmap));
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
        mCurSelectedIndex = -1;
    }

    public int getIndex(String s)
    {
        Iterator iterator = items.iterator();
        int i = 0;
        do
        {
            if (!iterator.hasNext() || s.equals(((gy)iterator.next()).b))
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
        gy gy1 = (gy)items.get(i);
        gy1.c = bitmap;
        gy1.a = -1;
        items.set(i, gy1);
        bitmap = new gy[items.size()];
        for (i = 0; i < items.size(); i++)
        {
            bitmap[i] = (gy)items.get(i);
        }

        setAdapter(new gv(this, getContext(), bitmap));
    }

    public void setCallback(gx gx)
    {
        mCallback = gx;
    }

    public void setItemSelected(int i, Boolean boolean1)
    {
        cancelSelected();
        mCurSelectedIndex = i;
        if (i < items.size())
        {
            setVisibleViewSelected(((gy)items.get(i)).b, boolean1.booleanValue());
        }
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
                    if (!s.equals(((gy)iterator.next()).b))
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
    static int access$102(TFilterListScrollView tfilterlistscrollview, int i)
    {
        tfilterlistscrollview.mCurSelectedIndex = i;
        return i;
    }

*/



}

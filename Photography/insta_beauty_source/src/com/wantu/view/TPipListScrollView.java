// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import bqt;
import bqu;
import bqw;
import com.fotoable.onLineImage.ImageButtonOnLine;
import com.wantu.model.res.pip.TDFSceneInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

// Referenced classes of package com.wantu.view:
//            HorizontalListView

public class TPipListScrollView extends HorizontalListView
{

    private static final String TAG = "TPipListScrollView2";
    private List items;
    private bqw mCallback;
    private int mCurSelectedIndex;

    public TPipListScrollView(Context context)
    {
        super(context, null);
        items = new ArrayList();
        mCurSelectedIndex = -1;
        init();
    }

    public TPipListScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        items = new ArrayList();
        mCurSelectedIndex = -1;
        init();
    }

    private final void init()
    {
        setOnItemClickListener(new bqt(this));
    }

    private void setViewSelected(View view, boolean flag)
    {
        view = (ImageButtonOnLine)view.findViewById(0x7f0d01c1);
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
                    View view = getChildAt(i);
                    if (!((TDFSceneInfo)view.getTag()).getName().equals(s))
                    {
                        break label0;
                    }
                    setViewSelected(view, flag);
                }
                return;
            }
            i++;
        } while (true);
    }

    public void addPipItem(TDFSceneInfo tdfsceneinfo)
    {
        if (items != null)
        {
            items.add(tdfsceneinfo);
        }
        tdfsceneinfo = new TDFSceneInfo[items.size()];
        for (int i = 0; i < items.size(); i++)
        {
            tdfsceneinfo[i] = (TDFSceneInfo)items.get(i);
        }

        setAdapter(new bqu(this, getContext(), tdfsceneinfo));
    }

    public void cancelSelected()
    {
        mCurSelectedIndex = -1;
        getQueue().size();
        for (int i = 0; i < getChildCount(); i++)
        {
            setViewSelected(getChildAt(i), false);
        }

        invalidate();
    }

    public void removeAllItems()
    {
        items.clear();
        mCurSelectedIndex = -1;
    }

    public void setCallback(bqw bqw)
    {
        mCallback = bqw;
    }

    public void setItemSelected(String s, Boolean boolean1)
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
                    if (!((TDFSceneInfo)iterator.next()).getName().equals(s))
                    {
                        break label0;
                    }
                    mCurSelectedIndex = i;
                }
                setVisibleViewSelected(((TDFSceneInfo)items.get(i)).getName(), boolean1.booleanValue());
                return;
            }
            i++;
        } while (true);
    }



/*
    public static int access$102(TPipListScrollView tpiplistscrollview, int i)
    {
        tpiplistscrollview.mCurSelectedIndex = i;
        return i;
    }

*/



}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import com.fotoable.onLineImage.ImageButtonOnLine;
import com.wantu.model.res.pip.TDFSceneInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import yw;
import yy;

// Referenced classes of package com.wantu.view:
//            HorizontalListView

public class TPipStyleListScrollView extends HorizontalListView
{

    private static final String TAG = "TPipStyleListScrollView";
    private List items;
    private yy mCallback;
    private int mCurSelectedIndex;

    public TPipStyleListScrollView(Context context)
    {
        super(context, null);
        items = new ArrayList();
        mCurSelectedIndex = -1;
        init();
    }

    public TPipStyleListScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        items = new ArrayList();
        mCurSelectedIndex = -1;
        init();
    }

    private final void init()
    {
        setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final TPipStyleListScrollView a;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                if (a.mCallback != null)
                {
                    a.cancelSelected();
                    a.setViewSelected(view, true);
                    a.mCurSelectedIndex = i;
                    a.mCallback.a((TDFSceneInfo)a.items.get(i));
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
                    }, 700L);
                }
            }

            
            {
                a = TPipStyleListScrollView.this;
                super();
            }
        });
    }

    private void setViewSelected(View view, boolean flag)
    {
        view = (ImageButtonOnLine)view.findViewById(0x7f0c0101);
        if (view != null)
        {
            view.setSelected(flag);
        }
    }

    private void setVisibleViewSelected(int i, boolean flag)
    {
        int j = 0;
        do
        {
label0:
            {
                if (j < getChildCount())
                {
                    View view = getChildAt(j);
                    if (((TDFSceneInfo)view.getTag()).resId != i)
                    {
                        break label0;
                    }
                    setViewSelected(view, flag);
                }
                return;
            }
            j++;
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

        setAdapter(new yw(this, getContext(), tdfsceneinfo));
    }

    public void cancelSelected()
    {
        mCurSelectedIndex = -1;
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

    public void setCallback(yy yy)
    {
        mCallback = yy;
    }

    public void setCurrentItemSelected(int i)
    {
        mCurSelectedIndex = i;
    }

    public void setItemSelected(int i, Boolean boolean1)
    {
        cancelSelected();
        Iterator iterator = items.iterator();
        int j = -1;
        int k;
        do
        {
            k = j;
            if (!iterator.hasNext())
            {
                break;
            }
            TDFSceneInfo tdfsceneinfo = (TDFSceneInfo)iterator.next();
            k = j + 1;
            j = k;
            if (tdfsceneinfo.resId != i)
            {
                continue;
            }
            mCurSelectedIndex = k;
            break;
        } while (true);
        if (k >= 0)
        {
            setVisibleViewSelected(((TDFSceneInfo)items.get(k)).resId, boolean1.booleanValue());
        }
    }



/*
    static int access$102(TPipStyleListScrollView tpipstylelistscrollview, int i)
    {
        tpipstylelistscrollview.mCurSelectedIndex = i;
        return i;
    }

*/



}

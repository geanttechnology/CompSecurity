// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.commonview;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;
import qg;

public class PinnedSectionListView extends ListView
{

    private android.widget.AbsListView.OnScrollListener mDelegateOnScrollListener;
    private android.widget.AbsListView.OnScrollListener mOnScrollListener = new android.widget.AbsListView.OnScrollListener() {

        final PinnedSectionListView a;

        public void onScroll(AbsListView abslistview, int i, int j, int k)
        {
        }

        public void onScrollStateChanged(AbsListView abslistview, int i)
        {
            if (a.mDelegateOnScrollListener != null)
            {
                a.mDelegateOnScrollListener.onScrollStateChanged(abslistview, i);
            }
        }

            
            {
                a = PinnedSectionListView.this;
                super();
            }
    };
    qg mPinnedShadow;
    qg mRecycleShadow;
    int mTranslateY;

    public PinnedSectionListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        initView();
    }

    public PinnedSectionListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        initView();
    }

    private void createPinnedShadow(int i)
    {
        qg qg1 = mRecycleShadow;
        Object obj;
        View view;
        int j;
        int k;
        int l;
        if (qg1 == null)
        {
            obj = null;
        } else
        {
            obj = qg1.a;
        }
        mRecycleShadow = null;
        view = getAdapter().getView(i, ((View) (obj)), this);
        obj = (android.widget.AbsListView.LayoutParams)view.getLayoutParams();
        if (obj == null)
        {
            k = 0x80000000;
            j = getHeight();
        } else
        {
            k = android.view.View.MeasureSpec.getMode(((android.widget.AbsListView.LayoutParams) (obj)).height);
            j = android.view.View.MeasureSpec.getSize(((android.widget.AbsListView.LayoutParams) (obj)).height);
        }
        l = k;
        if (k == 0)
        {
            l = 0x40000000;
        }
        k = getHeight() - getListPaddingTop() - getListPaddingBottom();
        if (j > k)
        {
            j = k;
        }
        view.measure(android.view.View.MeasureSpec.makeMeasureSpec(getWidth() - getListPaddingLeft() - getListPaddingRight(), 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(j, l));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        mTranslateY = 0;
        if (qg1 == null)
        {
            obj = new qg();
        } else
        {
            obj = qg1;
        }
        obj.b = i;
        obj.a = view;
        mPinnedShadow = ((qg) (obj));
    }

    private void destroyPinnedShadow()
    {
        mRecycleShadow = mPinnedShadow;
        mPinnedShadow = null;
    }

    private int findCurrentSectionPosition(int i)
    {
        PinnedSectionListAdapter pinnedsectionlistadapter = (PinnedSectionListAdapter)getAdapter();
        if (pinnedsectionlistadapter instanceof SectionIndexer)
        {
            SectionIndexer sectionindexer = (SectionIndexer)pinnedsectionlistadapter;
            int j = sectionindexer.getPositionForSection(sectionindexer.getSectionForPosition(i));
            if (pinnedsectionlistadapter.isItemViewTypePinned(pinnedsectionlistadapter.getItemViewType(j)))
            {
                return j;
            }
        }
        for (; i >= 0; i--)
        {
            if (pinnedsectionlistadapter.isItemViewTypePinned(pinnedsectionlistadapter.getItemViewType(i)))
            {
                return i;
            }
        }

        return -1;
    }

    private int findFirstVisibleSectionPosition(int i, int j)
    {
        PinnedSectionListAdapter pinnedsectionlistadapter = (PinnedSectionListAdapter)getAdapter();
        for (int k = 0; k < j; k++)
        {
            int l = i + k;
            if (pinnedsectionlistadapter.isItemViewTypePinned(pinnedsectionlistadapter.getItemViewType(l)))
            {
                return l;
            }
        }

        return -1;
    }

    private void initView()
    {
        setOnScrollListener(mOnScrollListener);
    }

    protected void dispatchDraw(Canvas canvas)
    {
        super.dispatchDraw(canvas);
        if (mPinnedShadow != null)
        {
            int i = getListPaddingLeft();
            int j = getListPaddingTop();
            View view = mPinnedShadow.a;
            canvas.save();
            canvas.clipRect(i, j, view.getWidth() + i, view.getHeight() + j);
            canvas.translate(i, j + mTranslateY);
            drawChild(canvas, mPinnedShadow.a, getDrawingTime());
            canvas.restore();
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        super.onRestoreInstanceState(parcelable);
        post(new Runnable() {

            final PinnedSectionListView a;

            public void run()
            {
                if (a.getAdapter() != null)
                {
                    int i = a.getFirstVisiblePosition();
                    int j = a.findCurrentSectionPosition(i);
                    if (j != -1)
                    {
                        if (i == j)
                        {
                            a.createPinnedShadow(i);
                            View view = a.getChildAt(i);
                            PinnedSectionListView pinnedsectionlistview = a;
                            if (view == null)
                            {
                                i = 0;
                            } else
                            {
                                i = -view.getTop();
                            }
                            pinnedsectionlistview.mTranslateY = i;
                            return;
                        } else
                        {
                            a.createPinnedShadow(j);
                            return;
                        }
                    }
                }
            }

            
            {
                a = PinnedSectionListView.this;
                super();
            }
        });
    }

    public volatile void setAdapter(Adapter adapter)
    {
        setAdapter((ListAdapter)adapter);
    }

    public void setAdapter(ListAdapter listadapter)
    {
        if (!(listadapter instanceof PinnedSectionListAdapter))
        {
            throw new IllegalArgumentException("Does your adapter implement PinnedSectionListAdapter?");
        }
        if (listadapter.getViewTypeCount() < 2)
        {
            throw new IllegalArgumentException("Does your adapter handle at least two types of views - items and sections?");
        } else
        {
            super.setAdapter(listadapter);
            return;
        }
    }

    public void setOnScrollListener(android.widget.AbsListView.OnScrollListener onscrolllistener)
    {
        if (onscrolllistener == mOnScrollListener)
        {
            super.setOnScrollListener(onscrolllistener);
            return;
        } else
        {
            mDelegateOnScrollListener = onscrolllistener;
            return;
        }
    }

    public void updatePinnedListView(AbsListView abslistview, int i, int j, int k)
    {
        if (mDelegateOnScrollListener != null)
        {
            mDelegateOnScrollListener.onScroll(abslistview, i, j, k);
        }
        if ((PinnedSectionListAdapter)abslistview.getAdapter() != null && j != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        j = findFirstVisibleSectionPosition(i, j);
        if (j != -1)
        {
            break; /* Loop/switch isn't completed */
        }
        i = findCurrentSectionPosition(i);
        if (i != -1)
        {
            if (mPinnedShadow != null)
            {
                if (mPinnedShadow.b == i)
                {
                    mTranslateY = 0;
                    return;
                }
                destroyPinnedShadow();
            }
            createPinnedShadow(i);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        i = abslistview.getChildAt(j - i).getTop();
        k = getListPaddingTop();
        if (mPinnedShadow != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (i < k)
        {
            createPinnedShadow(j);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
        if (j == mPinnedShadow.b)
        {
            if (i > k)
            {
                destroyPinnedShadow();
                j = findCurrentSectionPosition(j - 1);
                if (j > -1)
                {
                    createPinnedShadow(j);
                    j = i - k - mPinnedShadow.a.getHeight();
                    i = j;
                    if (j > 0)
                    {
                        i = 0;
                    }
                    mTranslateY = i;
                    return;
                }
            }
        } else
        {
            int l = mPinnedShadow.a.getHeight() + k;
            if (i < l)
            {
                if (i < k)
                {
                    destroyPinnedShadow();
                    createPinnedShadow(j);
                    return;
                } else
                {
                    mTranslateY = i - l;
                    return;
                }
            } else
            {
                mTranslateY = 0;
                return;
            }
        }
        if (true) goto _L1; else goto _L5
_L5:
    }




    private class PinnedSectionListAdapter
        implements ListAdapter
    {

        public abstract boolean isItemViewTypePinned(int i);
    }

}

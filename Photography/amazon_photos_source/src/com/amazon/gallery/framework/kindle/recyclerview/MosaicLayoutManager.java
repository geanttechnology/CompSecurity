// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.recyclerview;

import android.content.Context;
import android.graphics.RectF;
import android.support.v7.widget.OrientationHelper;
import android.util.SparseArray;
import android.view.View;
import java.util.Arrays;

// Referenced classes of package com.amazon.gallery.framework.kindle.recyclerview:
//            LinearLayoutManager, MosaicGenerationResult, MosaicLayoutCache

public class MosaicLayoutManager extends LinearLayoutManager
{

    private final RectF mClientRect = new RectF();
    private View mViews[];
    private final MosaicLayoutCache mosaicCache;

    public MosaicLayoutManager(Context context, int i, boolean flag, MosaicLayoutCache mosaiclayoutcache)
    {
        super(context, i, flag);
        mosaicCache = mosaiclayoutcache;
    }

    private void ensurePositionToEnd(LinearLayoutManager.LayoutState layoutstate, MosaicGenerationResult mosaicgenerationresult, int i)
    {
        i = mosaicgenerationresult.getOffsetFromGroupStart(i, layoutstate.mCurrentPosition);
        if (i != 0 && Math.abs(i) < 3)
        {
            layoutstate.mCurrentPosition = layoutstate.mCurrentPosition + i;
        }
    }

    private void ensurePositionToStart(LinearLayoutManager.LayoutState layoutstate, MosaicGenerationResult mosaicgenerationresult, int i)
    {
        i = mosaicgenerationresult.getOffsetFromGroupEnd(i, layoutstate.mCurrentPosition);
        if (i != 0)
        {
            layoutstate.mCurrentPosition = layoutstate.mCurrentPosition + i;
        }
    }

    protected View getChildViewAt(int i, int j)
    {
        View view1 = getChildAt(i);
        View view = view1;
        if (i + 1 != j)
        {
            View view2 = getChildAt(i + 1);
            view = view1;
            if (view2.getLeft() < view1.getLeft())
            {
                view = view2;
            }
        }
        return view;
    }

    void layoutChunk(android.support.v7.widget.RecyclerView.Recycler recycler, android.support.v7.widget.RecyclerView.State state, LinearLayoutManager.LayoutState layoutstate, LinearLayoutManager.LayoutChunkResult layoutchunkresult)
    {
        Object obj;
        SparseArray sparsearray;
        int i;
        boolean flag;
        int j;
        int k;
        if (layoutstate.mItemDirection == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i = layoutstate.mCurrentPosition;
        k = -1;
        j = 0;
        obj = mosaicCache.getMosaic(i);
        i = ((MosaicGenerationResult) (obj)).getGroup(i);
        sparsearray = ((MosaicGenerationResult) (obj)).getRectsForGroup(i);
        if (sparsearray == null)
        {
            layoutchunkresult.mFinished = true;
            return;
        }
        int ai[] = new int[sparsearray.size()];
        if (layoutstate.mLayoutDirection == -1)
        {
            ensurePositionToStart(layoutstate, ((MosaicGenerationResult) (obj)), i);
        } else
        {
            ensurePositionToEnd(layoutstate, ((MosaicGenerationResult) (obj)), i);
        }
label0:
        do
        {
label1:
            {
                if (j < sparsearray.size() && layoutstate.hasMore(state))
                {
                    int i1;
                    if (layoutstate.mLayoutDirection == -1)
                    {
                        obj = (RectF)sparsearray.get(sparsearray.keyAt(sparsearray.size() - 1 - j));
                    } else
                    {
                        obj = (RectF)sparsearray.get(sparsearray.keyAt(j));
                    }
                    if (mOrientation == 0)
                    {
                        i = (int)((RectF) (obj)).top;
                        i1 = (int)((RectF) (obj)).width();
                    } else
                    {
                        i = (int)((RectF) (obj)).left;
                        i1 = (int)((RectF) (obj)).height();
                    }
                    if (k != -1 && k == i)
                    {
                        if (layoutstate.mLayoutDirection == -1)
                        {
                            ai[j] = layoutstate.mOffset - i1;
                        } else
                        {
                            ai[j] = layoutstate.mOffset + i1;
                        }
                    } else
                    {
                        ai[j] = layoutstate.mOffset;
                    }
                    obj = layoutstate.next(recycler);
                    if (obj != null)
                    {
                        break label1;
                    }
                }
                if (j == 0)
                {
                    layoutchunkresult.mFinished = true;
                    return;
                }
                break label0;
            }
            mViews[j] = ((View) (obj));
            j++;
            k = i;
        } while (true);
        int j1 = 0;
        i = 0;
        while (i < j) 
        {
            state = mViews[i];
            android.support.v7.widget.RecyclerView.LayoutParams layoutparams;
            int l;
            int k1;
            int l1;
            int i2;
            int j2;
            int k2;
            if (layoutstate.mLayoutDirection == -1)
            {
                recycler = (RectF)sparsearray.get(sparsearray.keyAt(j - 1 - i));
            } else
            {
                recycler = (RectF)sparsearray.get(sparsearray.keyAt(i));
            }
            if (layoutstate.mScrapList == null)
            {
                if (flag)
                {
                    addView(state);
                } else
                {
                    addView(state, 0);
                }
            } else
            if (flag)
            {
                addDisappearingView(state);
            } else
            {
                addDisappearingView(state, 0);
            }
            measureChildWithMargins(state, recycler);
            k1 = mOrientationHelper.getDecoratedMeasurement(state);
            l = j1;
            if (k1 > j1)
            {
                l = k1;
            }
            if (layoutstate.mLayoutDirection == -1)
            {
                k1 = ai[i];
                j1 = k1 - mOrientationHelper.getDecoratedMeasurement(state);
            } else
            {
                j1 = ai[i];
                k1 = j1 + mOrientationHelper.getDecoratedMeasurement(state);
            }
            layoutparams = (android.support.v7.widget.RecyclerView.LayoutParams)state.getLayoutParams();
            l1 = getPaddingTop();
            i2 = (int)((RectF) (recycler)).top;
            j2 = getPaddingTop();
            k2 = (int)((RectF) (recycler)).bottom;
            layoutDecorated(state, j1 + layoutparams.leftMargin, l1 + i2 + layoutparams.topMargin, k1 - layoutparams.rightMargin, (j2 + k2) - layoutparams.bottomMargin);
            if (layoutparams.isItemRemoved() || layoutparams.isItemChanged())
            {
                layoutchunkresult.mIgnoreConsumed = true;
            }
            layoutchunkresult.mFocusable = layoutchunkresult.mFocusable | state.isFocusable();
            i++;
            j1 = l;
        }
        layoutchunkresult.mConsumed = j1;
        Arrays.fill(mViews, null);
    }

    public void measureChildWithMargins(View view, RectF rectf)
    {
        android.support.v7.widget.RecyclerView.LayoutParams layoutparams = (android.support.v7.widget.RecyclerView.LayoutParams)view.getLayoutParams();
        view.measure(getChildMeasureSpec(getWidth(), getPaddingLeft() + getPaddingRight() + layoutparams.leftMargin + layoutparams.rightMargin, (int)rectf.width(), canScrollHorizontally()), getChildMeasureSpec(getHeight(), getPaddingTop() + getPaddingBottom() + layoutparams.topMargin + layoutparams.bottomMargin, (int)rectf.height(), canScrollVertically()));
    }

    void onAnchorReady(android.support.v7.widget.RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorinfo)
    {
        if (mViews == null)
        {
            mViews = new View[3];
        }
    }

    public void onMeasure(android.support.v7.widget.RecyclerView.Recycler recycler, android.support.v7.widget.RecyclerView.State state, int i, int j)
    {
        super.onMeasure(recycler, state, i, j);
        i = android.view.View.MeasureSpec.getSize(i);
        j = android.view.View.MeasureSpec.getSize(j);
        setMeasuredDimension(i, j);
        mClientRect.set(0.0F, 0.0F, i, j);
        mosaicCache.setClientRect(mClientRect);
    }
}

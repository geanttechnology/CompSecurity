// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.adapters.feed;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcelable;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.List;

public class HeaderLayoutManagerFixed extends android.support.v7.widget.RecyclerView.LayoutManager
{

    private static final boolean DEBUG = true;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = 0x80000000;
    private static final float MAX_SCROLL_FACTOR = 0.33F;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    private int mHeaderIncrementFixer;
    private boolean mLastStackFromEnd;
    private int mOrientation;
    OrientationHelper mOrientationHelper;
    private SavedState mPendingSavedState;
    private int mPendingScrollPosition;
    private int mPendingScrollPositionOffset;
    private RenderState mRenderState;
    private boolean mReverseLayout;
    private boolean mShouldReverseLayout;
    private boolean mStackFromEnd;

    public HeaderLayoutManagerFixed(Context context)
    {
        this(context, 1, false);
    }

    public HeaderLayoutManagerFixed(Context context, int i, boolean flag)
    {
        mHeaderIncrementFixer = 0;
        mReverseLayout = false;
        mShouldReverseLayout = false;
        mStackFromEnd = false;
        mPendingScrollPosition = -1;
        mPendingScrollPositionOffset = 0x80000000;
        mPendingSavedState = null;
        setOrientation(i);
        setReverseLayout(flag);
    }

    private int convertFocusDirectionToLayoutDirection(int i)
    {
        int j;
        byte byte0;
        boolean flag;
        int k;
        byte0 = -1;
        flag = true;
        k = 0x80000000;
        j = byte0;
        i;
        JVM INSTR lookupswitch 6: default 72
    //                   1: 100
    //                   2: 102
    //                   17: 132
    //                   33: 104
    //                   66: 144
    //                   130: 117;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L2:
        break MISSING_BLOCK_LABEL_100;
_L1:
        Log.d("LinearLayoutManager", (new StringBuilder()).append("Unknown focus request:").append(i).toString());
        j = 0x80000000;
_L9:
        return j;
_L3:
        return 1;
_L5:
        j = byte0;
        if (mOrientation == 1) goto _L9; else goto _L8
_L8:
        return 0x80000000;
_L7:
        i = k;
        if (mOrientation == 1)
        {
            i = 1;
        }
        return i;
_L4:
        j = byte0;
        if (mOrientation == 0) goto _L9; else goto _L10
_L10:
        return 0x80000000;
_L6:
        if (mOrientation == 0)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0x80000000;
        }
        return i;
    }

    private int fill(android.support.v7.widget.RecyclerView.Recycler recycler, RenderState renderstate, android.support.v7.widget.RecyclerView.State state, boolean flag)
    {
    /* block-local class not found */
    class RenderState {}

        int i1;
        int j1;
        j1 = renderstate.mAvailable;
        if (renderstate.mScrollingOffset != 0x80000000)
        {
            if (renderstate.mAvailable < 0)
            {
                renderstate.mScrollingOffset = renderstate.mScrollingOffset + renderstate.mAvailable;
            }
            recycleByRenderState(recycler, renderstate);
        }
        i1 = renderstate.mAvailable + renderstate.mExtra + mHeaderIncrementFixer;
_L6:
        if (i1 <= 0 || !renderstate.hasMore(state)) goto _L2; else goto _L1
_L1:
        View view = renderstate.next(recycler);
        if (view != null) goto _L4; else goto _L3
_L3:
        if (renderstate.mScrapList == null)
        {
            throw new RuntimeException("received null view when unexpected");
        }
          goto _L2
_L4:
        int i;
        android.support.v7.widget.RecyclerView.LayoutParams layoutparams = (android.support.v7.widget.RecyclerView.LayoutParams)view.getLayoutParams();
    /* block-local class not found */
    class OrientationHelper {}

        int j;
        int k;
        int l;
        int k1;
        if (!layoutparams.isItemRemoved() && mRenderState.mScrapList == null)
        {
            boolean flag2 = mShouldReverseLayout;
            boolean flag1;
            if (renderstate.mLayoutDirection == -1)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag2 == flag1)
            {
                addView(view);
            } else
            {
                addView(view, 0);
            }
        }
        measureChildWithMargins(view, 0, 0);
        k1 = mOrientationHelper.getDecoratedMeasurement(view);
        if (mOrientation == 1)
        {
            if (isLayoutRTL())
            {
                k = getWidth() - getPaddingRight();
                j = k - mOrientationHelper.getDecoratedMeasurementInOther(view);
            } else
            {
                j = getPaddingLeft();
                k = j + mOrientationHelper.getDecoratedMeasurementInOther(view);
            }
            if (renderstate.mLayoutDirection == -1)
            {
                i = renderstate.mOffset;
                l = renderstate.mOffset - k1;
            } else
            {
                l = renderstate.mOffset;
                i = renderstate.mOffset + k1;
            }
        } else
        {
            l = getPaddingTop();
            i = l + mOrientationHelper.getDecoratedMeasurementInOther(view);
            if (renderstate.mLayoutDirection == -1)
            {
                k = renderstate.mOffset;
                j = renderstate.mOffset - k1;
            } else
            {
                j = renderstate.mOffset;
                k = renderstate.mOffset + k1;
            }
        }
        layoutDecorated(view, j + layoutparams.leftMargin, l + layoutparams.topMargin, k - layoutparams.rightMargin, i - layoutparams.bottomMargin);
        Log.d("LinearLayoutManager", (new StringBuilder()).append("laid out child at position ").append(getPosition(view)).append(", with l:").append(layoutparams.leftMargin + j).append(", t:").append(layoutparams.topMargin + l).append(", r:").append(k - layoutparams.rightMargin).append(", b:").append(i - layoutparams.bottomMargin).toString());
        renderstate.mOffset = renderstate.mOffset + renderstate.mLayoutDirection * k1;
        i = i1;
        if (!layoutparams.isItemRemoved())
        {
            renderstate.mAvailable = renderstate.mAvailable - k1;
            i = i1 - k1;
        }
        if (renderstate.mScrollingOffset != 0x80000000)
        {
            renderstate.mScrollingOffset = renderstate.mScrollingOffset + k1;
            if (renderstate.mAvailable < 0)
            {
                renderstate.mScrollingOffset = renderstate.mScrollingOffset + renderstate.mAvailable;
            }
            recycleByRenderState(recycler, renderstate);
        }
        if (!flag || !view.isFocusable()) goto _L5; else goto _L2
_L2:
        validateChildOrder();
        return j1 - renderstate.mAvailable;
_L5:
        i1 = i;
        if (state == null)
        {
            break; /* Loop/switch isn't completed */
        }
        i1 = i;
        if (state.getTargetScrollPosition() != getPosition(view)) goto _L6; else goto _L2
    }

    private int fixLayoutEndGap(int i, android.support.v7.widget.RecyclerView.Recycler recycler, android.support.v7.widget.RecyclerView.State state, boolean flag)
    {
        int j = mOrientationHelper.getEndAfterPadding() - i;
        if (j > 0)
        {
            j = -scrollBy(-j, recycler, state);
            if (flag)
            {
                i = mOrientationHelper.getEndAfterPadding() - (i + j);
                if (i > 0)
                {
                    mOrientationHelper.offsetChildren(i);
                    return i + j;
                }
            }
        } else
        {
            return 0;
        }
        return j;
    }

    private int fixLayoutStartGap(int i, android.support.v7.widget.RecyclerView.Recycler recycler, android.support.v7.widget.RecyclerView.State state, boolean flag)
    {
        int j = i - mOrientationHelper.getStartAfterPadding();
        if (j > 0)
        {
            j = -scrollBy(j, recycler, state);
            if (flag)
            {
                i = (i + j) - mOrientationHelper.getStartAfterPadding();
                if (i > 0)
                {
                    mOrientationHelper.offsetChildren(-i);
                    return j - i;
                }
            }
        } else
        {
            return 0;
        }
        return j;
    }

    private View getChildClosestToEnd()
    {
        int i;
        if (mShouldReverseLayout)
        {
            i = 0;
        } else
        {
            i = getChildCount() - 1;
        }
        return getChildAt(i);
    }

    private View getChildClosestToStart()
    {
        int i;
        if (mShouldReverseLayout)
        {
            i = getChildCount() - 1;
        } else
        {
            i = 0;
        }
        return getChildAt(i);
    }

    private boolean isLayoutRTL()
    {
        return getLayoutDirection() == 1;
    }

    private void logChildren()
    {
        Log.d("LinearLayoutManager", "internal representation of views on the screen");
        for (int i = 0; i < getChildCount(); i++)
        {
            View view = getChildAt(i);
            Log.d("LinearLayoutManager", (new StringBuilder()).append("item ").append(getPosition(view)).append(", coord:").append(mOrientationHelper.getDecoratedStart(view)).toString());
        }

        Log.d("LinearLayoutManager", "==============");
    }

    private void recycleByRenderState(android.support.v7.widget.RecyclerView.Recycler recycler, RenderState renderstate)
    {
        if (renderstate.mLayoutDirection == -1)
        {
            recycleViewsFromEnd(recycler, renderstate.mScrollingOffset);
            return;
        } else
        {
            recycleViewsFromStart(recycler, renderstate.mScrollingOffset);
            return;
        }
    }

    private void recycleChildren(android.support.v7.widget.RecyclerView.Recycler recycler, int i, int j)
    {
        if (i != j) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Log.d("LinearLayoutManager", (new StringBuilder()).append("Recycling ").append(Math.abs(i - j)).append(" items").toString());
        if (j <= i)
        {
            break; /* Loop/switch isn't completed */
        }
        j--;
        while (j >= i) 
        {
            removeAndRecycleViewAt(j, recycler);
            j--;
        }
        if (true) goto _L1; else goto _L3
_L3:
        while (i > j) 
        {
            removeAndRecycleViewAt(i, recycler);
            i--;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    private void recycleViewsFromEnd(android.support.v7.widget.RecyclerView.Recycler recycler, int i)
    {
        int j = getChildCount();
        if (i >= 0) goto _L2; else goto _L1
_L1:
        Log.d("LinearLayoutManager", "Called recycle from end with a negative value. This might happen during layout changes but may be sign of a bug");
_L4:
        return;
_L2:
        int k;
        k = (mOrientationHelper.getEndAfterPadding() - i) + mHeaderIncrementFixer;
        if (!mShouldReverseLayout)
        {
            break; /* Loop/switch isn't completed */
        }
        i = 0;
        while (i < j) 
        {
            View view = getChildAt(i);
            if (mOrientationHelper.getDecoratedStart(view) < k)
            {
                recycleChildren(recycler, 0, i);
                return;
            }
            i++;
        }
        if (true) goto _L4; else goto _L3
_L3:
        i = j - 1;
        while (i >= 0) 
        {
            View view1 = getChildAt(i);
            if (mOrientationHelper.getDecoratedStart(view1) < k)
            {
                recycleChildren(recycler, j - 1, i);
                return;
            }
            i--;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    private void recycleViewsFromStart(android.support.v7.widget.RecyclerView.Recycler recycler, int i)
    {
        if (i >= 0) goto _L2; else goto _L1
_L1:
        Log.d("LinearLayoutManager", "Called recycle from start with a negative value. This might happen during layout changes but may be sign of a bug");
_L4:
        return;
_L2:
        int j;
        int k;
        j = (mOrientationHelper.getStartAfterPadding() + i) - mHeaderIncrementFixer;
        k = getChildCount();
        if (!mShouldReverseLayout)
        {
            break; /* Loop/switch isn't completed */
        }
        i = k - 1;
        while (i >= 0) 
        {
            View view = getChildAt(i);
            if (mOrientationHelper.getDecoratedEnd(view) > j)
            {
                recycleChildren(recycler, k - 1, i);
                return;
            }
            i--;
        }
        if (true) goto _L4; else goto _L3
_L3:
        i = 0;
        while (i < k) 
        {
            View view1 = getChildAt(i);
            if (mOrientationHelper.getDecoratedEnd(view1) > j)
            {
                recycleChildren(recycler, 0, i);
                return;
            }
            i++;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    private void resolveShouldLayoutReverse()
    {
        boolean flag = true;
        if (mOrientation == 1 || !isLayoutRTL())
        {
            mShouldReverseLayout = mReverseLayout;
            return;
        }
        if (mReverseLayout)
        {
            flag = false;
        }
        mShouldReverseLayout = flag;
    }

    private int scrollBy(int i, android.support.v7.widget.RecyclerView.Recycler recycler, android.support.v7.widget.RecyclerView.State state)
    {
        if (getChildCount() == 0 || i == 0)
        {
            return 0;
        }
        ensureRenderState();
        int j;
        int k;
        int l;
        if (i > 0)
        {
            j = 1;
        } else
        {
            j = -1;
        }
        k = Math.abs(i);
        updateRenderState(j, k, true, state);
        l = mRenderState.mScrollingOffset + fill(recycler, mRenderState, state, false);
        if (l < 0)
        {
            Log.d("LinearLayoutManager", "Don't have any more elements to scroll");
            return 0;
        }
        if (k > l)
        {
            j *= l;
        } else
        {
            j = i;
        }
        mOrientationHelper.offsetChildren(-j);
        Log.d("LinearLayoutManager", (new StringBuilder()).append("scroll req: ").append(i).append(" scrolled: ").append(j).toString());
        return j;
    }

    private void updateRenderState(int i, int j, boolean flag, android.support.v7.widget.RecyclerView.State state)
    {
        byte byte0 = -1;
        boolean flag1 = true;
        mRenderState.mExtra = getExtraLayoutSpace(state);
        mRenderState.mLayoutDirection = i;
        if (i == 1)
        {
            state = getChildClosestToEnd();
            RenderState renderstate = mRenderState;
            if (mShouldReverseLayout)
            {
                i = byte0;
            } else
            {
                i = 1;
            }
            renderstate.mItemDirection = i;
            mRenderState.mCurrentPosition = getPosition(state) + mRenderState.mItemDirection;
            mRenderState.mOffset = mOrientationHelper.getDecoratedEnd(state);
            i = mOrientationHelper.getDecoratedEnd(state) - mOrientationHelper.getEndAfterPadding();
        } else
        {
            state = getChildClosestToStart();
            RenderState renderstate1 = mRenderState;
            if (mShouldReverseLayout)
            {
                i = ((flag1) ? 1 : 0);
            } else
            {
                i = -1;
            }
            renderstate1.mItemDirection = i;
            mRenderState.mCurrentPosition = getPosition(state) + mRenderState.mItemDirection;
            mRenderState.mOffset = mOrientationHelper.getDecoratedStart(state);
            i = -mOrientationHelper.getDecoratedStart(state) + mOrientationHelper.getStartAfterPadding();
        }
        mRenderState.mAvailable = j;
        if (flag)
        {
            state = mRenderState;
            state.mAvailable = ((RenderState) (state)).mAvailable - i;
        }
        mRenderState.mScrollingOffset = i;
    }

    private void updateRenderStateToFillEnd(int i, int j)
    {
        mRenderState.mAvailable = mOrientationHelper.getEndAfterPadding() - j;
        RenderState renderstate = mRenderState;
        int k;
        if (mShouldReverseLayout)
        {
            k = -1;
        } else
        {
            k = 1;
        }
        renderstate.mItemDirection = k;
        mRenderState.mCurrentPosition = i;
        mRenderState.mLayoutDirection = 1;
        mRenderState.mOffset = j;
        mRenderState.mScrollingOffset = 0x80000000;
    }

    private void updateRenderStateToFillStart(int i, int j)
    {
        mRenderState.mAvailable = j - mOrientationHelper.getStartAfterPadding();
        mRenderState.mCurrentPosition = i;
        RenderState renderstate = mRenderState;
        if (mShouldReverseLayout)
        {
            i = 1;
        } else
        {
            i = -1;
        }
        renderstate.mItemDirection = i;
        mRenderState.mLayoutDirection = -1;
        mRenderState.mOffset = j;
        mRenderState.mScrollingOffset = 0x80000000;
    }

    private void validateChildOrder()
    {
        boolean flag;
        boolean flag2;
        flag2 = true;
        flag = true;
        Log.d("LinearLayoutManager", (new StringBuilder()).append("validating child count ").append(getChildCount()).toString());
        if (getChildCount() >= 1) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int k;
        int l;
        k = getPosition(getChildAt(0));
        l = mOrientationHelper.getDecoratedStart(getChildAt(0));
        if (!mShouldReverseLayout)
        {
            break; /* Loop/switch isn't completed */
        }
        int i = 1;
        while (i < getChildCount()) 
        {
            View view = getChildAt(i);
            int i1 = getPosition(view);
            int k1 = mOrientationHelper.getDecoratedStart(view);
            if (i1 < k)
            {
                logChildren();
                StringBuilder stringbuilder = (new StringBuilder()).append("detected invalid position. loc invalid? ");
                if (k1 >= l)
                {
                    flag = false;
                }
                throw new RuntimeException(stringbuilder.append(flag).toString());
            }
            if (k1 > l)
            {
                logChildren();
                throw new RuntimeException("detected invalid location");
            }
            i++;
        }
        if (true) goto _L1; else goto _L3
_L3:
        int j = 1;
        while (j < getChildCount()) 
        {
            View view1 = getChildAt(j);
            int j1 = getPosition(view1);
            int l1 = mOrientationHelper.getDecoratedStart(view1);
            if (j1 < k)
            {
                logChildren();
                StringBuilder stringbuilder1 = (new StringBuilder()).append("detected invalid position. loc invalid? ");
                boolean flag1;
                if (l1 < l)
                {
                    flag1 = flag2;
                } else
                {
                    flag1 = false;
                }
                throw new RuntimeException(stringbuilder1.append(flag1).toString());
            }
            if (l1 < l)
            {
                logChildren();
                throw new RuntimeException("detected invalid location");
            }
            j++;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public boolean canScrollHorizontally()
    {
        return mOrientation == 0;
    }

    public boolean canScrollVertically()
    {
        return mOrientation == 1;
    }

    public int computeHorizontalScrollExtent(android.support.v7.widget.RecyclerView.State state)
    {
        return getChildCount();
    }

    public int computeHorizontalScrollOffset(android.support.v7.widget.RecyclerView.State state)
    {
        int i;
        if (getChildCount() == 0)
        {
            i = 0;
        } else
        {
            int j = getPosition(getChildClosestToStart());
            i = j;
            if (mShouldReverseLayout)
            {
                return state.getItemCount() - 1 - j;
            }
        }
        return i;
    }

    public int computeHorizontalScrollRange(android.support.v7.widget.RecyclerView.State state)
    {
        return state.getItemCount();
    }

    public PointF computeScrollVectorForPosition(int i)
    {
        boolean flag = false;
        if (getChildCount() == 0)
        {
            return null;
        }
        if (i < getPosition(getChildAt(0)))
        {
            flag = true;
        }
        if (flag != mShouldReverseLayout)
        {
            i = -1;
        } else
        {
            i = 1;
        }
        if (mOrientation == 0)
        {
            return new PointF(i, 0.0F);
        } else
        {
            return new PointF(0.0F, i);
        }
    }

    public int computeVerticalScrollExtent(android.support.v7.widget.RecyclerView.State state)
    {
        return getChildCount();
    }

    public int computeVerticalScrollOffset(android.support.v7.widget.RecyclerView.State state)
    {
        int i;
        if (getChildCount() == 0)
        {
            i = 0;
        } else
        {
            int j = getPosition(getChildClosestToStart());
            i = j;
            if (mShouldReverseLayout)
            {
                return state.getItemCount() - 1 - j;
            }
        }
        return i;
    }

    public int computeVerticalScrollRange(android.support.v7.widget.RecyclerView.State state)
    {
        return state.getItemCount();
    }

    OrientationHelper createHorizontalOrientationHelper()
    {
        return new _cls4();
    }

    OrientationHelper createVerticalOrientationHelper()
    {
        return new _cls3();
    }

    void ensureRenderState()
    {
        if (mRenderState == null)
        {
            mRenderState = new RenderState(null);
        }
        if (mOrientationHelper == null)
        {
            OrientationHelper orientationhelper;
            if (mOrientation == 0)
            {
                orientationhelper = createHorizontalOrientationHelper();
            } else
            {
                orientationhelper = createVerticalOrientationHelper();
            }
            mOrientationHelper = orientationhelper;
        }
    }

    public int findFirstCompletelyVisibleItemPosition()
    {
        return findOneVisibleChild(0, getChildCount(), true);
    }

    public int findFirstVisibleItemPosition()
    {
        return findOneVisibleChild(0, getChildCount(), false);
    }

    public int findLastCompletelyVisibleItemPosition()
    {
        return findOneVisibleChild(getChildCount() - 1, -1, true);
    }

    public int findLastVisibleItemPosition()
    {
        return findOneVisibleChild(getChildCount() - 1, -1, false);
    }

    int findOneVisibleChild(int i, int j, boolean flag)
    {
        byte byte1 = -1;
        int l = mOrientationHelper.getStartAfterPadding();
        int i1 = mOrientationHelper.getEndAfterPadding();
        byte byte0;
        if (j > i)
        {
            byte0 = 1;
        } else
        {
            byte0 = -1;
        }
        do
        {
label0:
            {
                View view;
label1:
                {
                    int k = byte1;
                    if (i != j)
                    {
                        view = getChildAt(i);
                        k = mOrientationHelper.getDecoratedStart(view);
                        int j1 = mOrientationHelper.getDecoratedEnd(view);
                        if (k >= i1 || j1 <= l)
                        {
                            break label0;
                        }
                        if (!flag)
                        {
                            break label1;
                        }
                        if (k < l || j1 > i1)
                        {
                            break label0;
                        }
                        k = getPosition(view);
                    }
                    return k;
                }
                return getPosition(view);
            }
            i += byte0;
        } while (true);
    }

    public View findViewByPosition(int i)
    {
        int j = getChildCount();
        if (j != 0)
        {
            if ((i -= getPosition(getChildAt(0))) >= 0 && i < j)
            {
                return getChildAt(i);
            }
        }
        return null;
    }

    public android.support.v7.widget.RecyclerView.LayoutParams generateDefaultLayoutParams()
    {
        return new android.support.v7.widget.RecyclerView.LayoutParams(-2, -2);
    }

    protected int getExtraLayoutSpace(android.support.v7.widget.RecyclerView.State state)
    {
        if (state.hasTargetScrollPosition())
        {
            return mOrientationHelper.getTotalSpace();
        } else
        {
            return 0;
        }
    }

    public int getHeaderIncrementFixer()
    {
        return mHeaderIncrementFixer;
    }

    public int getOrientation()
    {
        return mOrientation;
    }

    public boolean getReverseLayout()
    {
        return mReverseLayout;
    }

    public boolean getStackFromEnd()
    {
        return mStackFromEnd;
    }

    public View onFocusSearchFailed(View view, int i, android.support.v7.widget.RecyclerView.Recycler recycler, android.support.v7.widget.RecyclerView.State state)
    {
        resolveShouldLayoutReverse();
        if (getChildCount() != 0) goto _L2; else goto _L1
_L1:
        recycler = null;
_L4:
        return recycler;
_L2:
        i = convertFocusDirectionToLayoutDirection(i);
        if (i == 0x80000000)
        {
            return null;
        }
        View view1;
        if (i == -1)
        {
            view1 = getChildClosestToStart();
        } else
        {
            view1 = getChildClosestToEnd();
        }
        ensureRenderState();
        updateRenderState(i, (int)(0.33F * (float)(mOrientationHelper.getEndAfterPadding() - mOrientationHelper.getStartAfterPadding())), false, state);
        mRenderState.mScrollingOffset = 0x80000000;
        fill(recycler, mRenderState, state, true);
        if (i == -1)
        {
            view = getChildClosestToStart();
        } else
        {
            view = getChildClosestToEnd();
        }
        if (view == view1)
        {
            break; /* Loop/switch isn't completed */
        }
        recycler = view;
        if (view.isFocusable()) goto _L4; else goto _L3
_L3:
        return null;
    }

    public void onLayoutChildren(android.support.v7.widget.RecyclerView.Recycler recycler, android.support.v7.widget.RecyclerView.State state)
    {
        Log.d("LinearLayoutManager", (new StringBuilder()).append("is pre layout:").append(state.isPreLayout()).toString());
    /* block-local class not found */
    class SavedState {}

        if (mPendingSavedState != null)
        {
            setOrientation(mPendingSavedState.mOrientation);
            setReverseLayout(mPendingSavedState.mReverseLayout);
            setStackFromEnd(mPendingSavedState.mStackFromEnd);
            mPendingScrollPosition = mPendingSavedState.mAnchorPosition;
        }
        ensureRenderState();
        resolveShouldLayoutReverse();
        if (mPendingScrollPosition != -1 && (mPendingScrollPosition < 0 || mPendingScrollPosition >= state.getItemCount()))
        {
            mPendingScrollPosition = -1;
            mPendingScrollPositionOffset = 0x80000000;
            Log.e("LinearLayoutManager", (new StringBuilder()).append("ignoring invalid scroll position ").append(mPendingScrollPosition).toString());
        }
        boolean flag = mShouldReverseLayout ^ mStackFromEnd;
        int i;
        int j;
        int k;
        int l;
        boolean flag1;
        if (mLastStackFromEnd != mStackFromEnd)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (mPendingScrollPosition != -1)
        {
            j = mPendingScrollPosition;
            if (mPendingSavedState != null)
            {
                flag = mPendingSavedState.mAnchorLayoutFromEnd;
                RenderState renderstate;
                int k1;
                int l1;
                if (flag)
                {
                    i = mOrientationHelper.getEndAfterPadding() - mPendingSavedState.mAnchorOffset;
                } else
                {
                    i = mOrientationHelper.getStartAfterPadding() + mPendingSavedState.mAnchorOffset;
                }
            } else
            if (mPendingScrollPositionOffset == 0x80000000)
            {
                obj = findViewByPosition(mPendingScrollPosition);
                if (obj != null)
                {
                    i = mOrientationHelper.getDecoratedStart(((View) (obj)));
                    k = mOrientationHelper.getStartAfterPadding();
                    l = mOrientationHelper.getEndAfterPadding();
                    j1 = mOrientationHelper.getDecoratedEnd(((View) (obj)));
                    if (mOrientationHelper.getDecoratedMeasurement(((View) (obj))) > mOrientationHelper.getTotalSpace())
                    {
                        if (flag)
                        {
                            i = mOrientationHelper.getEndAfterPadding();
                        } else
                        {
                            i = mOrientationHelper.getStartAfterPadding();
                        }
                    } else
                    if (i - k < 0)
                    {
                        i = mOrientationHelper.getStartAfterPadding();
                        flag = false;
                    } else
                    if (l - j1 < 0)
                    {
                        i = mOrientationHelper.getEndAfterPadding();
                        flag = true;
                    } else
                    if (flag)
                    {
                        i = mOrientationHelper.getDecoratedEnd(((View) (obj)));
                    } else
                    {
                        i = mOrientationHelper.getDecoratedStart(((View) (obj)));
                    }
                } else
                if (getChildCount() > 0)
                {
                    i = getPosition(getChildAt(0));
                    if (mPendingScrollPosition < i)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (flag == mShouldReverseLayout)
                    {
                        i = mOrientationHelper.getEndAfterPadding();
                        flag = true;
                    } else
                    {
                        i = mOrientationHelper.getStartAfterPadding();
                        flag = false;
                    }
                } else
                if (flag)
                {
                    i = mOrientationHelper.getEndAfterPadding();
                } else
                {
                    i = mOrientationHelper.getStartAfterPadding();
                }
            } else
            if (mShouldReverseLayout)
            {
                i = mOrientationHelper.getEndAfterPadding() - mPendingScrollPositionOffset;
                flag = true;
            } else
            {
                i = mOrientationHelper.getStartAfterPadding() + mPendingScrollPositionOffset;
                flag = false;
            }
        } else
        if (getChildCount() > 0 && i == 0)
        {
            if (flag)
            {
                obj = getChildClosestToEnd();
                i = mOrientationHelper.getDecoratedEnd(((View) (obj)));
                j = getPosition(((View) (obj)));
            } else
            {
                obj = getChildClosestToStart();
                i = mOrientationHelper.getDecoratedStart(((View) (obj)));
                j = getPosition(((View) (obj)));
            }
        } else
        {
            if (flag)
            {
                i = mOrientationHelper.getEndAfterPadding();
            } else
            {
                i = mOrientationHelper.getStartAfterPadding();
            }
            if (mStackFromEnd)
            {
                j = state.getItemCount() - 1;
            } else
            {
                j = 0;
            }
        }
        detachAndScrapAttachedViews(recycler);
        k = getExtraLayoutSpace(state);
        if (state.getTargetScrollPosition() < j)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1 == mShouldReverseLayout)
        {
            l = 0;
        } else
        {
            l = k;
            k = 0;
        }
        updateRenderStateToFillStart(j, i);
        mRenderState.mExtra = l;
        if (!flag)
        {
            renderstate = mRenderState;
            renderstate.mCurrentPosition = renderstate.mCurrentPosition + mRenderState.mItemDirection;
        }
        fill(recycler, mRenderState, state, false);
        l = mRenderState.mOffset;
        updateRenderStateToFillEnd(j, i);
        mRenderState.mExtra = k;
        if (flag)
        {
            renderstate = mRenderState;
            renderstate.mCurrentPosition = renderstate.mCurrentPosition + mRenderState.mItemDirection;
        }
        fill(recycler, mRenderState, state, false);
        k = mRenderState.mOffset;
        i = k;
        j = l;
        if (getChildCount() > 0)
        {
            if (mShouldReverseLayout ^ mStackFromEnd)
            {
                i = fixLayoutEndGap(k, recycler, state, true);
                j = l + i;
                l = fixLayoutStartGap(j, recycler, state, false);
                j += l;
                i = k + i + l;
            } else
            {
                i = fixLayoutStartGap(l, recycler, state, true);
                k += i;
                j1 = fixLayoutEndGap(k, recycler, state, false);
                j = l + i + j1;
                i = k + j1;
            }
        }
        if (getChildCount() > 0 && !state.isPreLayout() && supportsPredictiveItemAnimations())
        {
            int j1 = 0;
            k = 0;
            Object obj = recycler.getScrapList();
            k1 = ((List) (obj)).size();
            l1 = getPosition(getChildAt(0));
            l = 0;
            while (l < k1) 
            {
                android.support.v7.widget.RecyclerView.ViewHolder viewholder = (android.support.v7.widget.RecyclerView.ViewHolder)((List) (obj)).get(l);
                byte byte0;
                if (viewholder.getPosition() < l1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag != mShouldReverseLayout)
                {
                    byte0 = -1;
                } else
                {
                    byte0 = 1;
                }
                if (byte0 == -1)
                {
                    j1 += mOrientationHelper.getDecoratedMeasurement(viewholder.itemView);
                } else
                {
                    k += mOrientationHelper.getDecoratedMeasurement(viewholder.itemView);
                }
                l++;
            }
            Log.d("LinearLayoutManager", (new StringBuilder()).append("for unused scrap, decided to add ").append(j1).append(" towards start and ").append(k).append(" towards end").toString());
            mRenderState.mScrapList = ((List) (obj));
            if (j1 > 0)
            {
                updateRenderStateToFillStart(getPosition(getChildClosestToStart()), j);
                mRenderState.mExtra = j1;
                mRenderState.mAvailable = 0;
                RenderState renderstate1 = mRenderState;
                int i1 = renderstate1.mCurrentPosition;
                if (mShouldReverseLayout)
                {
                    j = 1;
                } else
                {
                    j = -1;
                }
                renderstate1.mCurrentPosition = j + i1;
                fill(recycler, mRenderState, state, false);
            }
            if (k > 0)
            {
                updateRenderStateToFillEnd(getPosition(getChildClosestToEnd()), i);
                mRenderState.mExtra = k;
                mRenderState.mAvailable = 0;
                renderstate1 = mRenderState;
                j = renderstate1.mCurrentPosition;
                if (mShouldReverseLayout)
                {
                    i = -1;
                } else
                {
                    i = 1;
                }
                renderstate1.mCurrentPosition = i + j;
                fill(recycler, mRenderState, state, false);
            }
            mRenderState.mScrapList = null;
        }
        mPendingScrollPosition = -1;
        mPendingScrollPositionOffset = 0x80000000;
        mLastStackFromEnd = mStackFromEnd;
        mPendingSavedState = null;
        validateChildOrder();
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        if (parcelable instanceof SavedState)
        {
            mPendingSavedState = (SavedState)parcelable;
            requestLayout();
            Log.d("LinearLayoutManager", "loaded saved state");
            return;
        } else
        {
            Log.d("LinearLayoutManager", "invalid saved state class");
            return;
        }
    }

    public Parcelable onSaveInstanceState()
    {
        if (mPendingSavedState != null)
        {
            return new SavedState(mPendingSavedState);
        }
        SavedState savedstate = new SavedState();
        if (getChildCount() > 0)
        {
            boolean flag = mLastStackFromEnd ^ mShouldReverseLayout;
            savedstate.mAnchorLayoutFromEnd = flag;
            if (flag)
            {
                View view = getChildClosestToEnd();
                savedstate.mAnchorOffset = mOrientationHelper.getEndAfterPadding() - mOrientationHelper.getDecoratedEnd(view);
                savedstate.mAnchorPosition = getPosition(view);
            } else
            {
                View view1 = getChildClosestToStart();
                savedstate.mAnchorPosition = getPosition(view1);
                savedstate.mAnchorOffset = mOrientationHelper.getDecoratedStart(view1) - mOrientationHelper.getStartAfterPadding();
            }
        } else
        {
            savedstate.mAnchorPosition = 0;
            savedstate.mAnchorOffset = 0;
        }
        savedstate.mStackFromEnd = mStackFromEnd;
        savedstate.mReverseLayout = mReverseLayout;
        savedstate.mOrientation = mOrientation;
        return savedstate;
    }

    public int scrollHorizontallyBy(int i, android.support.v7.widget.RecyclerView.Recycler recycler, android.support.v7.widget.RecyclerView.State state)
    {
        if (mOrientation == 1)
        {
            return 0;
        } else
        {
            return scrollBy(i, recycler, state);
        }
    }

    public void scrollToPosition(int i)
    {
        mPendingScrollPosition = i;
        mPendingScrollPositionOffset = 0x80000000;
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int j)
    {
        mPendingScrollPosition = i;
        mPendingScrollPositionOffset = j;
        requestLayout();
    }

    public int scrollVerticallyBy(int i, android.support.v7.widget.RecyclerView.Recycler recycler, android.support.v7.widget.RecyclerView.State state)
    {
        if (mOrientation == 0)
        {
            return 0;
        } else
        {
            return scrollBy(i, recycler, state);
        }
    }

    public void setHeaderIncrementFixer(View view)
    {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new _cls2(view));
    }

    public void setOrientation(int i)
    {
        if (i != 0 && i != 1)
        {
            throw new IllegalArgumentException("invalid orientation.");
        }
        if (mPendingSavedState != null && mPendingSavedState.mOrientation != i)
        {
            mPendingSavedState.mOrientation = i;
        }
        if (i == mOrientation)
        {
            return;
        } else
        {
            mOrientation = i;
            mOrientationHelper = null;
            requestLayout();
            return;
        }
    }

    public void setReverseLayout(boolean flag)
    {
        if (mPendingSavedState != null && mPendingSavedState.mReverseLayout != flag)
        {
            mPendingSavedState.mReverseLayout = flag;
        }
        if (flag == mReverseLayout)
        {
            return;
        } else
        {
            mReverseLayout = flag;
            requestLayout();
            return;
        }
    }

    public void setStackFromEnd(boolean flag)
    {
        if (mPendingSavedState != null && mPendingSavedState.mStackFromEnd != flag)
        {
            mPendingSavedState.mStackFromEnd = flag;
        }
        if (mStackFromEnd == flag)
        {
            return;
        } else
        {
            mStackFromEnd = flag;
            requestLayout();
            return;
        }
    }

    public void smoothScrollToPosition(RecyclerView recyclerview, android.support.v7.widget.RecyclerView.State state, int i)
    {
        recyclerview = new _cls1(recyclerview.getContext());
        recyclerview.setTargetPosition(i);
        startSmoothScroll(recyclerview);
    }

    public boolean supportsPredictiveItemAnimations()
    {
        return true;
    }


/*
    static int access$102(HeaderLayoutManagerFixed headerlayoutmanagerfixed, int i)
    {
        headerlayoutmanagerfixed.mHeaderIncrementFixer = i;
        return i;
    }

*/

    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls1 {}

}

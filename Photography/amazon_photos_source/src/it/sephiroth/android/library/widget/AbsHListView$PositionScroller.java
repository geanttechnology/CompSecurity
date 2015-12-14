// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;

// Referenced classes of package it.sephiroth.android.library.widget:
//            AbsHListView

public class mExtraScroll
    implements Runnable
{

    private static final int MOVE_DOWN_BOUND = 3;
    private static final int MOVE_DOWN_POS = 1;
    private static final int MOVE_OFFSET = 5;
    private static final int MOVE_UP_BOUND = 4;
    private static final int MOVE_UP_POS = 2;
    private static final int SCROLL_DURATION = 200;
    private int mBoundPos;
    private final int mExtraScroll;
    private int mLastSeenPos;
    private int mMode;
    private int mOffsetFromLeft;
    private int mScrollDuration;
    private int mTargetPos;
    final AbsHListView this$0;

    public void run()
    {
        int i2;
        int j2;
        j2 = getWidth();
        i2 = mFirstPosition;
        mMode;
        JVM INSTR tableswitch 1 5: default 56
    //                   1 57
    //                   2 389
    //                   3 214
    //                   4 509
    //                   5 675;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        return;
_L2:
        int i = getChildCount() - 1;
        i2 += i;
        if (i >= 0)
        {
            if (i2 == mLastSeenPos)
            {
                mViewHelper.ostOnAnimation(this);
                return;
            }
            View view = getChildAt(i);
            int k2 = view.getWidth();
            int k3 = view.getLeft();
            if (i2 < mItemCount - 1)
            {
                i = Math.max(mListPadding.right, mExtraScroll);
            } else
            {
                i = mListPadding.right;
            }
            smoothScrollBy((k2 - (j2 - k3)) + i, mScrollDuration, true);
            mLastSeenPos = i2;
            if (i2 < mTargetPos)
            {
                mViewHelper.ostOnAnimation(this);
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        int j = getChildCount();
        if (i2 != mBoundPos && j > 1 && i2 + j < mItemCount)
        {
            int k = i2 + 1;
            if (k == mLastSeenPos)
            {
                mViewHelper.ostOnAnimation(this);
                return;
            }
            View view1 = getChildAt(1);
            i2 = view1.getWidth();
            j2 = view1.getLeft();
            int l2 = Math.max(mListPadding.right, mExtraScroll);
            if (k < mBoundPos)
            {
                smoothScrollBy(Math.max(0, (i2 + j2) - l2), mScrollDuration, true);
                mLastSeenPos = k;
                mViewHelper.ostOnAnimation(this);
                return;
            }
            if (j2 > l2)
            {
                smoothScrollBy(j2 - l2, mScrollDuration, true);
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (i2 == mLastSeenPos)
        {
            mViewHelper.ostOnAnimation(this);
            return;
        }
        View view2 = getChildAt(0);
        if (view2 != null)
        {
            j2 = view2.getLeft();
            int l;
            if (i2 > 0)
            {
                l = Math.max(mExtraScroll, mListPadding.left);
            } else
            {
                l = mListPadding.left;
            }
            smoothScrollBy(j2 - l, mScrollDuration, true);
            mLastSeenPos = i2;
            if (i2 > mTargetPos)
            {
                mViewHelper.ostOnAnimation(this);
                return;
            }
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L5:
        int i3 = getChildCount() - 2;
        if (i3 >= 0)
        {
            int i1 = i2 + i3;
            if (i1 == mLastSeenPos)
            {
                mViewHelper.ostOnAnimation(this);
                return;
            }
            View view3 = getChildAt(i3);
            i2 = view3.getWidth();
            i3 = view3.getLeft();
            int l3 = Math.max(mListPadding.left, mExtraScroll);
            mLastSeenPos = i1;
            if (i1 > mBoundPos)
            {
                smoothScrollBy(-(j2 - i3 - l3), mScrollDuration, true);
                mViewHelper.ostOnAnimation(this);
                return;
            }
            i1 = j2 - l3;
            i2 = i3 + i2;
            if (i1 > i2)
            {
                smoothScrollBy(-(i1 - i2), mScrollDuration, true);
                return;
            }
        }
        if (true) goto _L1; else goto _L6
_L6:
        int j1;
        int j3;
        int i4;
        if (mLastSeenPos == i2)
        {
            mViewHelper.ostOnAnimation(this);
            return;
        }
        mLastSeenPos = i2;
        j2 = getChildCount();
        j3 = mTargetPos;
        i4 = (i2 + j2) - 1;
        j1 = 0;
        if (j3 >= i2) goto _L8; else goto _L7
_L7:
        j1 = (i2 - j3) + 1;
_L10:
        float f;
        f = Math.min(Math.abs((float)j1 / (float)j2), 1.0F);
        if (j3 < i2)
        {
            j1 = (int)((float)(-getWidth()) * f);
            i2 = (int)((float)mScrollDuration * f);
            smoothScrollBy(j1, i2, true);
            mViewHelper.ostOnAnimation(this);
            return;
        }
        break; /* Loop/switch isn't completed */
_L8:
        if (j3 > i4)
        {
            j1 = j3 - i4;
        }
        if (true) goto _L10; else goto _L9
_L9:
        if (j3 > i4)
        {
            int k1 = (int)((float)getWidth() * f);
            i2 = (int)((float)mScrollDuration * f);
            smoothScrollBy(k1, i2, true);
            mViewHelper.ostOnAnimation(this);
            return;
        } else
        {
            int l1 = getChildAt(j3 - i2).getLeft() - mOffsetFromLeft;
            i2 = (int)((float)mScrollDuration * ((float)Math.abs(l1) / (float)getWidth()));
            smoothScrollBy(l1, i2, true);
            return;
        }
    }

    void scrollToVisible(int i, int j, int k)
    {
        int l;
        int i1;
        int j1;
        int k1;
label0:
        {
            k1 = mFirstPosition;
            int l1 = (k1 + getChildCount()) - 1;
            i1 = mListPadding.left;
            j1 = getWidth() - mListPadding.right;
            if (i < k1 || i > l1)
            {
                Log.w("AbsListView", (new StringBuilder()).append("scrollToVisible called with targetPos ").append(i).append(" not visible [").append(k1).append(", ").append(l1).append("]").toString());
            }
            if (j >= k1)
            {
                l = j;
                if (j <= l1)
                {
                    break label0;
                }
            }
            l = -1;
        }
        View view = getChildAt(i - k1);
        j = view.getLeft();
        int i2 = view.getRight();
        i = 0;
        if (i2 > j1)
        {
            i = i2 - j1;
        }
        if (j < i1)
        {
            i = j - i1;
        }
        if (i == 0)
        {
            return;
        }
        j = i;
        if (l < 0) goto _L2; else goto _L1
_L1:
        View view1 = getChildAt(l - k1);
        l = view1.getLeft();
        j = view1.getRight();
        k1 = Math.abs(i);
        if (i >= 0 || j + k1 <= j1) goto _L4; else goto _L3
_L3:
        j = Math.max(0, j - j1);
_L2:
        smoothScrollBy(j, k);
        return;
_L4:
        j = i;
        if (i > 0)
        {
            j = i;
            if (l - k1 < i1)
            {
                j = Math.min(0, l - i1);
            }
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    void start(final int position)
    {
        stop();
        if (mDataChanged)
        {
            mPositionScrollAfterLayout = new Runnable() {

                final AbsHListView.PositionScroller this$1;
                final int val$position;

                public void run()
                {
                    start(position);
                }

            
            {
                this$1 = AbsHListView.PositionScroller.this;
                position = i;
                super();
            }
            };
        } else
        {
            int i = getChildCount();
            if (i != 0)
            {
                int j = mFirstPosition;
                int k = (j + i) - 1;
                i = Math.max(0, Math.min(getCount() - 1, position));
                if (i < j)
                {
                    position = (j - i) + 1;
                    mMode = 2;
                } else
                if (i > k)
                {
                    position = (i - k) + 1;
                    mMode = 1;
                } else
                {
                    scrollToVisible(i, -1, 200);
                    return;
                }
                if (position > 0)
                {
                    mScrollDuration = 200 / position;
                } else
                {
                    mScrollDuration = 200;
                }
                mTargetPos = i;
                mBoundPos = -1;
                mLastSeenPos = -1;
                mViewHelper.ostOnAnimation(this);
                return;
            }
        }
    }

    void start(final int position, final int boundPosition)
    {
        stop();
        if (boundPosition != -1) goto _L2; else goto _L1
_L1:
        start(position);
_L4:
        return;
_L2:
        int j;
        if (mDataChanged)
        {
            mPositionScrollAfterLayout = new Runnable() {

                final AbsHListView.PositionScroller this$1;
                final int val$boundPosition;
                final int val$position;

                public void run()
                {
                    start(position, boundPosition);
                }

            
            {
                this$1 = AbsHListView.PositionScroller.this;
                position = i;
                boundPosition = j;
                super();
            }
            };
            return;
        }
        j = getChildCount();
        if (j == 0) goto _L4; else goto _L3
_L3:
        int i;
        int k;
        i = mFirstPosition;
        k = (i + j) - 1;
        j = Math.max(0, Math.min(getCount() - 1, position));
        if (j >= i) goto _L6; else goto _L5
_L5:
        k -= boundPosition;
        if (k < 1) goto _L4; else goto _L7
_L7:
        position = (i - j) + 1;
        i = k - 1;
        if (i < position)
        {
            position = i;
            mMode = 4;
        } else
        {
            mMode = 2;
        }
_L9:
        if (position > 0)
        {
            mScrollDuration = 200 / position;
        } else
        {
            mScrollDuration = 200;
        }
        mTargetPos = j;
        mBoundPos = boundPosition;
        mLastSeenPos = -1;
        mViewHelper.ostOnAnimation(this);
        return;
_L6:
        if (j <= k)
        {
            break MISSING_BLOCK_LABEL_234;
        }
        i = boundPosition - i;
        if (i < 1) goto _L4; else goto _L8
_L8:
        position = (j - k) + 1;
        i--;
        if (i < position)
        {
            position = i;
            mMode = 3;
        } else
        {
            mMode = 1;
        }
          goto _L9
        scrollToVisible(j, boundPosition, 200);
        return;
    }

    void startWithOffset(int i, int j)
    {
        startWithOffset(i, j, 200);
    }

    void startWithOffset(final int position, final int postOffset, final int duration)
    {
        stop();
        if (mDataChanged)
        {
            mPositionScrollAfterLayout = new Runnable() {

                final AbsHListView.PositionScroller this$1;
                final int val$duration;
                final int val$position;
                final int val$postOffset;

                public void run()
                {
                    startWithOffset(position, postOffset, duration);
                }

            
            {
                this$1 = AbsHListView.PositionScroller.this;
                position = i;
                postOffset = j;
                duration = k;
                super();
            }
            };
        } else
        {
            int i = getChildCount();
            if (i != 0)
            {
                postOffset += getPaddingLeft();
                mTargetPos = Math.max(0, Math.min(getCount() - 1, position));
                mOffsetFromLeft = postOffset;
                mBoundPos = -1;
                mLastSeenPos = -1;
                mMode = 5;
                position = mFirstPosition;
                int j = (position + i) - 1;
                float f;
                if (mTargetPos < position)
                {
                    position -= mTargetPos;
                } else
                if (mTargetPos > j)
                {
                    position = mTargetPos - j;
                } else
                {
                    position = getChildAt(mTargetPos - position).getLeft();
                    smoothScrollBy(position - postOffset, duration, false);
                    return;
                }
                f = (float)position / (float)i;
                if (f >= 1.0F)
                {
                    duration = (int)((float)duration / f);
                }
                mScrollDuration = duration;
                mLastSeenPos = -1;
                mViewHelper.ostOnAnimation(this);
                return;
            }
        }
    }

    public void stop()
    {
        removeCallbacks(this);
    }

    _cls3.val.duration()
    {
        this$0 = AbsHListView.this;
        super();
        mExtraScroll = ViewConfiguration.get(getContext()).getScaledFadingEdgeLength();
    }
}

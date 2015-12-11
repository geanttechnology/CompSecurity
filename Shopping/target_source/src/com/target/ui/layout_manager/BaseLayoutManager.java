// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.layout_manager;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.a.a;
import android.support.v4.view.a.m;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.x;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.target.ui.util.q;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public abstract class BaseLayoutManager extends android.support.v7.widget.RecyclerView.h
{
    static class SavedState
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState a(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public SavedState[] a(int i1)
            {
                return new SavedState[i1];
            }

            public Object createFromParcel(Parcel parcel)
            {
                return a(parcel);
            }

            public Object[] newArray(int i1)
            {
                return a(i1);
            }

        };
        boolean mAnchorLayoutFromEnd;
        int mAnchorOffset;
        int mAnchorPosition;

        boolean a()
        {
            return mAnchorPosition >= 0;
        }

        void b()
        {
            mAnchorPosition = -1;
        }

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            parcel.writeInt(mAnchorPosition);
            parcel.writeInt(mAnchorOffset);
            if (mAnchorLayoutFromEnd)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
        }


        public SavedState()
        {
        }

        SavedState(Parcel parcel)
        {
            boolean flag = true;
            super();
            mAnchorPosition = parcel.readInt();
            mAnchorOffset = parcel.readInt();
            if (parcel.readInt() != 1)
            {
                flag = false;
            }
            mAnchorLayoutFromEnd = flag;
        }

        public SavedState(SavedState savedstate)
        {
            mAnchorPosition = savedstate.mAnchorPosition;
            mAnchorOffset = savedstate.mAnchorOffset;
            mAnchorLayoutFromEnd = savedstate.mAnchorLayoutFromEnd;
        }
    }

    class a
    {

        int mCoordinate;
        boolean mLayoutFromEnd;
        int mPosition;
        final BaseLayoutManager this$0;

        void a()
        {
            mPosition = -1;
            mCoordinate = 0x80000000;
            mLayoutFromEnd = false;
        }

        public void a(View view)
        {
            if (mLayoutFromEnd)
            {
                mCoordinate = mOrientationHelper.b(view) + mOrientationHelper.b();
            } else
            {
                mCoordinate = mOrientationHelper.a(view);
            }
            mPosition = d(view);
        }

        public boolean a(View view, android.support.v7.widget.RecyclerView.q q)
        {
            android.support.v7.widget.RecyclerView.i i1 = (android.support.v7.widget.RecyclerView.i)view.getLayoutParams();
            if (!i1.c() && i1.e() >= 0 && i1.e() < q.e())
            {
                a(view);
                return true;
            } else
            {
                return false;
            }
        }

        void b()
        {
            int i1;
            if (mLayoutFromEnd)
            {
                i1 = mOrientationHelper.d();
            } else
            {
                i1 = mOrientationHelper.c();
            }
            mCoordinate = i1;
        }

        public String toString()
        {
            return (new StringBuilder()).append("AnchorInfo{mPosition=").append(mPosition).append(", mCoordinate=").append(mCoordinate).append(", mLayoutFromEnd=").append(mLayoutFromEnd).append('}').toString();
        }

        a()
        {
            this$0 = BaseLayoutManager.this;
            super();
        }
    }

    protected static class b
    {

        public int mConsumed;
        public boolean mFinished;
        public boolean mFocusable;
        public boolean mIgnoreConsumed;

        void a()
        {
            mConsumed = 0;
            mFinished = false;
            mIgnoreConsumed = false;
            mFocusable = false;
        }

        protected b()
        {
        }
    }

    static class c
    {

        static final int INVALID_LAYOUT = 0x80000000;
        static final int ITEM_DIRECTION_HEAD = -1;
        static final int ITEM_DIRECTION_TAIL = 1;
        static final int LAYOUT_END = 1;
        static final int LAYOUT_START = -1;
        static final int SCOLLING_OFFSET_NaN = 0x80000000;
        static final String TAG = "LinearLayoutManager#LayoutState";
        int mAvailable;
        int mCurrentPosition;
        int mExtra;
        boolean mIsPreLayout;
        int mItemDirection;
        int mLayoutDirection;
        int mOffset;
        boolean mRecycle;
        List mScrapList;
        int mScrollingOffset;

        private View a()
        {
            android.support.v7.widget.RecyclerView.t t;
            int i1;
            int j1;
            int l1;
            l1 = mScrapList.size();
            i1 = 0x7fffffff;
            j1 = 0;
            t = null;
_L2:
            android.support.v7.widget.RecyclerView.t t1;
            if (j1 >= l1)
            {
                break MISSING_BLOCK_LABEL_161;
            }
            t1 = (android.support.v7.widget.RecyclerView.t)mScrapList.get(j1);
            if (mIsPreLayout)
            {
                break; /* Loop/switch isn't completed */
            }
            Boolean boolean1 = a(t1);
            boolean flag;
            if (boolean1 != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag || !boolean1.booleanValue())
            {
                break; /* Loop/switch isn't completed */
            }
_L4:
            j1++;
            if (true) goto _L2; else goto _L1
_L1:
            int k1 = (t1.e() - mCurrentPosition) * mItemDirection;
            if (k1 < 0 || k1 >= i1) goto _L4; else goto _L3
_L3:
            if (k1 != 0) goto _L6; else goto _L5
_L5:
            if (t1 != null)
            {
                mCurrentPosition = t1.e() + mItemDirection;
                return t1.itemView;
            } else
            {
                return null;
            }
_L6:
            t = t1;
            i1 = k1;
              goto _L4
            t1 = t;
              goto _L5
        }

        private Boolean a(android.support.v7.widget.RecyclerView.t t)
        {
            Method method = android/support/v7/widget/RecyclerView$t.getDeclaredMethod("r", new Class[0]);
            method.setAccessible(true);
            t = (Boolean)method.invoke(t, new Object[0]);
            return t;
            t;
_L2:
            q.a("LinearLayoutManager#LayoutState", (new StringBuilder()).append("Error when trying to call ViewHolder.isRemoved by reflection : ").append(t.getMessage()).toString());
            return null;
            t;
            continue; /* Loop/switch isn't completed */
            t;
            if (true) goto _L2; else goto _L1
_L1:
        }

        View a(android.support.v7.widget.RecyclerView.m m1)
        {
            if (mScrapList != null)
            {
                return a();
            } else
            {
                m1 = m1.c(mCurrentPosition);
                mCurrentPosition = mCurrentPosition + mItemDirection;
                return m1;
            }
        }

        boolean a(android.support.v7.widget.RecyclerView.q q1)
        {
            return mCurrentPosition >= 0 && mCurrentPosition < q1.e();
        }

        c()
        {
            mRecycle = true;
            mExtra = 0;
            mIsPreLayout = false;
            mScrapList = null;
        }
    }

    private static class d
    {

        static int a(android.support.v7.widget.RecyclerView.q q, x x1, View view, View view1, android.support.v7.widget.RecyclerView.h h1, boolean flag)
        {
            if (h1.o() == 0 || q.e() == 0 || view == null || view1 == null)
            {
                return 0;
            }
            if (!flag)
            {
                return Math.abs(h1.d(view) - h1.d(view1)) + 1;
            } else
            {
                int i1 = x1.b(view1);
                int j1 = x1.a(view);
                return Math.min(x1.f(), i1 - j1);
            }
        }

        static int a(android.support.v7.widget.RecyclerView.q q, x x1, View view, View view1, android.support.v7.widget.RecyclerView.h h1, boolean flag, boolean flag1)
        {
            boolean flag2 = false;
            int j1 = ((flag2) ? 1 : 0);
            if (h1.o() != 0)
            {
                j1 = ((flag2) ? 1 : 0);
                if (q.e() != 0)
                {
                    j1 = ((flag2) ? 1 : 0);
                    if (view != null)
                    {
                        if (view1 == null)
                        {
                            j1 = ((flag2) ? 1 : 0);
                        } else
                        {
                            int i1 = Math.min(h1.d(view), h1.d(view1));
                            j1 = Math.max(h1.d(view), h1.d(view1));
                            if (flag1)
                            {
                                i1 = Math.max(0, q.e() - j1 - 1);
                            } else
                            {
                                i1 = Math.max(0, i1);
                            }
                            j1 = i1;
                            if (flag)
                            {
                                int k1 = Math.abs(x1.b(view1) - x1.a(view));
                                int l1 = Math.abs(h1.d(view) - h1.d(view1));
                                float f1 = (float)k1 / (float)(l1 + 1);
                                return Math.round((float)i1 * f1 + (float)(x1.c() - x1.a(view)));
                            }
                        }
                    }
                }
            }
            return j1;
        }

        static int b(android.support.v7.widget.RecyclerView.q q, x x1, View view, View view1, android.support.v7.widget.RecyclerView.h h1, boolean flag)
        {
            if (h1.o() == 0 || q.e() == 0 || view == null || view1 == null)
            {
                return 0;
            }
            if (!flag)
            {
                return q.e();
            } else
            {
                int i1 = x1.b(view1);
                int j1 = x1.a(view);
                int k1 = Math.abs(h1.d(view) - h1.d(view1));
                return (int)(((float)(i1 - j1) / (float)(k1 + 1)) * (float)q.e());
            }
        }
    }


    private static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = 0x80000000;
    private static final float MAX_SCROLL_FACTOR = 0.33F;
    private static final String TAG = "BaseLayoutManager";
    public static final int VERTICAL = 1;
    final a mAnchorInfo;
    private boolean mLastStackFromEnd;
    protected c mLayoutState;
    int mOrientation;
    x mOrientationHelper;
    SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    public BaseLayoutManager(Context context)
    {
        this(context, 1, false);
    }

    public BaseLayoutManager(Context context, int i1, boolean flag)
    {
        mReverseLayout = false;
        mShouldReverseLayout = false;
        mStackFromEnd = false;
        mSmoothScrollbarEnabled = true;
        mPendingScrollPosition = -1;
        mPendingScrollPositionOffset = 0x80000000;
        mPendingSavedState = null;
        mAnchorInfo = new a();
        a(i1);
        a(flag);
    }

    private void A()
    {
        boolean flag = true;
        if (mOrientation == 1 || !f())
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

    private int a(int i1, android.support.v7.widget.RecyclerView.m m1, android.support.v7.widget.RecyclerView.q q, boolean flag)
    {
        int j1 = mOrientationHelper.d() - i1;
        if (j1 > 0)
        {
            int k1 = -c(-j1, m1, q);
            j1 = k1;
            if (flag)
            {
                i1 = mOrientationHelper.d() - (i1 + k1);
                j1 = k1;
                if (i1 > 0)
                {
                    mOrientationHelper.a(i1);
                    j1 = k1 + i1;
                }
            }
            return j1;
        } else
        {
            return 0;
        }
    }

    private View a(int i1, int j1, int k1)
    {
        View view;
        View view1;
        View view2;
        int i2;
        int j2;
        view1 = null;
        g();
        i2 = mOrientationHelper.c();
        j2 = mOrientationHelper.d();
        int l1;
        int k2;
        if (j1 > i1)
        {
            l1 = 1;
        } else
        {
            l1 = -1;
        }
        view = null;
        if (i1 == j1) goto _L2; else goto _L1
_L1:
        view2 = g(i1);
        k2 = d(view2);
        if (k2 < 0 || k2 >= k1)
        {
            break MISSING_BLOCK_LABEL_187;
        }
        if (!((android.support.v7.widget.RecyclerView.i)view2.getLayoutParams()).c()) goto _L4; else goto _L3
_L3:
        if (view != null)
        {
            break MISSING_BLOCK_LABEL_187;
        }
        view = view1;
        view1 = view2;
_L9:
        i1 += l1;
        view2 = view1;
        view1 = view;
        view = view2;
        break MISSING_BLOCK_LABEL_36;
_L4:
        if (mOrientationHelper.a(view2) >= j2) goto _L6; else goto _L5
_L5:
        View view4 = view2;
        if (mOrientationHelper.b(view2) >= i2) goto _L7; else goto _L6
_L6:
        if (view1 != null)
        {
            break MISSING_BLOCK_LABEL_187;
        }
        view1 = view;
        view = view2;
        continue; /* Loop/switch isn't completed */
_L2:
        if (view1 == null)
        {
            view1 = view;
        }
        view4 = view1;
_L7:
        return view4;
        View view3 = view;
        view = view1;
        view1 = view3;
        if (true) goto _L9; else goto _L8
_L8:
    }

    private View a(boolean flag, boolean flag1)
    {
        if (mShouldReverseLayout)
        {
            return a(o() - 1, -1, flag, flag1);
        } else
        {
            return a(0, o(), flag, flag1);
        }
    }

    private void a(android.support.v7.widget.RecyclerView.m m1, int i1)
    {
        if (i1 >= 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int l1;
        l1 = o();
        if (!mShouldReverseLayout)
        {
            break; /* Loop/switch isn't completed */
        }
        int j1 = l1 - 1;
        while (j1 >= 0) 
        {
            View view = g(j1);
            if (mOrientationHelper.b(view) > i1)
            {
                a(m1, l1 - 1, j1);
                return;
            }
            j1--;
        }
        if (true) goto _L1; else goto _L3
_L3:
        int k1 = 0;
        while (k1 < l1) 
        {
            View view1 = g(k1);
            if (mOrientationHelper.b(view1) > i1)
            {
                a(m1, 0, k1);
                return;
            }
            k1++;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    private void a(android.support.v7.widget.RecyclerView.m m1, int i1, int j1)
    {
        if (i1 != j1) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int k1;
        k1 = i1;
        if (j1 <= i1)
        {
            break; /* Loop/switch isn't completed */
        }
        j1--;
        while (j1 >= i1) 
        {
            a(j1, m1);
            j1--;
        }
        if (true) goto _L1; else goto _L3
_L3:
        while (k1 > j1) 
        {
            a(k1, m1);
            k1--;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    private void a(a a1)
    {
        b(a1.mPosition, a1.mCoordinate);
    }

    private int b(int i1)
    {
        int j1;
        byte byte0;
        boolean flag;
        int k1;
        byte0 = -1;
        flag = true;
        k1 = 0x80000000;
        j1 = byte0;
        i1;
        JVM INSTR lookupswitch 6: default 72
    //                   1: 75
    //                   2: 77
    //                   17: 107
    //                   33: 79
    //                   66: 119
    //                   130: 92;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L2:
        break MISSING_BLOCK_LABEL_75;
_L1:
        j1 = 0x80000000;
_L9:
        return j1;
_L3:
        return 1;
_L5:
        j1 = byte0;
        if (mOrientation == 1) goto _L9; else goto _L8
_L8:
        return 0x80000000;
_L7:
        i1 = k1;
        if (mOrientation == 1)
        {
            i1 = 1;
        }
        return i1;
_L4:
        j1 = byte0;
        if (mOrientation == 0) goto _L9; else goto _L10
_L10:
        return 0x80000000;
_L6:
        if (mOrientation == 0)
        {
            i1 = ((flag) ? 1 : 0);
        } else
        {
            i1 = 0x80000000;
        }
        return i1;
    }

    private int b(int i1, android.support.v7.widget.RecyclerView.m m1, android.support.v7.widget.RecyclerView.q q, boolean flag)
    {
        int j1 = i1 - mOrientationHelper.c();
        if (j1 > 0)
        {
            int k1 = -c(j1, m1, q);
            j1 = k1;
            if (flag)
            {
                i1 = (i1 + k1) - mOrientationHelper.c();
                j1 = k1;
                if (i1 > 0)
                {
                    mOrientationHelper.a(-i1);
                    j1 = k1 - i1;
                }
            }
            return j1;
        } else
        {
            return 0;
        }
    }

    private View b(boolean flag, boolean flag1)
    {
        if (mShouldReverseLayout)
        {
            return a(0, o(), flag, flag1);
        } else
        {
            return a(o() - 1, -1, flag, flag1);
        }
    }

    private void b(android.support.v7.widget.RecyclerView.m m1, int i1)
    {
        int j1 = o();
        if (i1 >= 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int k1;
        k1 = mOrientationHelper.e() - i1;
        if (!mShouldReverseLayout)
        {
            break; /* Loop/switch isn't completed */
        }
        i1 = 0;
        while (i1 < j1) 
        {
            View view = g(i1);
            if (mOrientationHelper.a(view) < k1)
            {
                a(m1, 0, i1);
                return;
            }
            i1++;
        }
        if (true) goto _L1; else goto _L3
_L3:
        i1 = j1 - 1;
        while (i1 >= 0) 
        {
            View view1 = g(i1);
            if (mOrientationHelper.a(view1) < k1)
            {
                a(m1, j1 - 1, i1);
                return;
            }
            i1--;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    private void b(android.support.v7.widget.RecyclerView.m m1, android.support.v7.widget.RecyclerView.q q, int i1, int j1)
    {
        if (!q.b() || o() == 0 || q.a() || !b())
        {
            return;
        }
        int l1 = 0;
        int k1 = 0;
        List list = m1.b();
        int j2 = list.size();
        int k2 = d(g(0));
        int i2 = 0;
        while (i2 < j2) 
        {
            android.support.v7.widget.RecyclerView.t t = (android.support.v7.widget.RecyclerView.t)list.get(i2);
            byte byte0;
            boolean flag;
            if (t.e() < k2)
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
                l1 = mOrientationHelper.c(t.itemView) + l1;
            } else
            {
                k1 = mOrientationHelper.c(t.itemView) + k1;
            }
            i2++;
        }
        mLayoutState.mScrapList = list;
        if (l1 > 0)
        {
            c(d(h()), i1);
            mLayoutState.mExtra = l1;
            mLayoutState.mAvailable = 0;
            c c1 = mLayoutState;
            l1 = c1.mCurrentPosition;
            if (mShouldReverseLayout)
            {
                i1 = 1;
            } else
            {
                i1 = -1;
            }
            c1.mCurrentPosition = i1 + l1;
            a(m1, mLayoutState, q, false);
        }
        if (k1 > 0)
        {
            b(d(i()), j1);
            mLayoutState.mExtra = k1;
            mLayoutState.mAvailable = 0;
            c1 = mLayoutState;
            j1 = c1.mCurrentPosition;
            if (mShouldReverseLayout)
            {
                i1 = -1;
            } else
            {
                i1 = 1;
            }
            c1.mCurrentPosition = i1 + j1;
            a(m1, mLayoutState, q, false);
        }
        mLayoutState.mScrapList = null;
    }

    private void b(android.support.v7.widget.RecyclerView.q q, a a1)
    {
        while (d(q, a1) || c(q, a1)) 
        {
            return;
        }
        a1.b();
        int i1;
        if (mStackFromEnd)
        {
            i1 = q.e() - 1;
        } else
        {
            i1 = 0;
        }
        a1.mPosition = i1;
    }

    private void b(a a1)
    {
        c(a1.mPosition, a1.mCoordinate);
    }

    private boolean c(android.support.v7.widget.RecyclerView.q q, a a1)
    {
        boolean flag = false;
        if (o() != 0)
        {
            View view = v();
            if (view != null && a1.a(view, q))
            {
                return true;
            }
            if (mLastStackFromEnd == mStackFromEnd)
            {
                View view1;
                if (a1.mLayoutFromEnd)
                {
                    view1 = k(q);
                } else
                {
                    view1 = l(q);
                }
                if (view1 != null)
                {
                    a1.a(view1);
                    if (!q.a() && b())
                    {
                        if (mOrientationHelper.a(view1) >= mOrientationHelper.d() || mOrientationHelper.b(view1) < mOrientationHelper.c())
                        {
                            flag = true;
                        }
                        if (flag)
                        {
                            int i1;
                            if (a1.mLayoutFromEnd)
                            {
                                i1 = mOrientationHelper.d();
                            } else
                            {
                                i1 = mOrientationHelper.c();
                            }
                            a1.mCoordinate = i1;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private boolean d(android.support.v7.widget.RecyclerView.q q, a a1)
    {
        boolean flag1 = false;
        if (q.a() || mPendingScrollPosition == -1)
        {
            return false;
        }
        if (mPendingScrollPosition < 0 || mPendingScrollPosition >= q.e())
        {
            mPendingScrollPosition = -1;
            mPendingScrollPositionOffset = 0x80000000;
            return false;
        }
        a1.mPosition = mPendingScrollPosition;
        if (mPendingSavedState != null && mPendingSavedState.a())
        {
            a1.mLayoutFromEnd = mPendingSavedState.mAnchorLayoutFromEnd;
            if (a1.mLayoutFromEnd)
            {
                a1.mCoordinate = mOrientationHelper.d() - mPendingSavedState.mAnchorOffset;
                return true;
            } else
            {
                a1.mCoordinate = mOrientationHelper.c() + mPendingSavedState.mAnchorOffset;
                return true;
            }
        }
        if (mPendingScrollPositionOffset == 0x80000000)
        {
            q = c(mPendingScrollPosition);
            if (q != null)
            {
                if (mOrientationHelper.c(q) > mOrientationHelper.f())
                {
                    a1.b();
                    return true;
                }
                if (mOrientationHelper.a(q) - mOrientationHelper.c() < 0)
                {
                    a1.mCoordinate = mOrientationHelper.c();
                    a1.mLayoutFromEnd = false;
                    return true;
                }
                if (mOrientationHelper.d() - mOrientationHelper.b(q) < 0)
                {
                    a1.mCoordinate = mOrientationHelper.d();
                    a1.mLayoutFromEnd = true;
                    return true;
                }
                int i1;
                if (a1.mLayoutFromEnd)
                {
                    i1 = mOrientationHelper.b(q) + mOrientationHelper.b();
                } else
                {
                    i1 = mOrientationHelper.a(q);
                }
                a1.mCoordinate = i1;
                return true;
            }
            if (o() > 0)
            {
                int j1 = d(g(0));
                boolean flag;
                if (mPendingScrollPosition < j1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag == mShouldReverseLayout)
                {
                    flag1 = true;
                }
                a1.mLayoutFromEnd = flag1;
            }
            a1.b();
            return true;
        }
        a1.mLayoutFromEnd = mShouldReverseLayout;
        if (mShouldReverseLayout)
        {
            a1.mCoordinate = mOrientationHelper.d() - mPendingScrollPositionOffset;
            return true;
        } else
        {
            a1.mCoordinate = mOrientationHelper.c() + mPendingScrollPositionOffset;
            return true;
        }
    }

    private int h(android.support.v7.widget.RecyclerView.q q)
    {
        boolean flag1 = false;
        if (o() == 0)
        {
            return 0;
        }
        g();
        x x1 = mOrientationHelper;
        View view;
        boolean flag;
        if (!mSmoothScrollbarEnabled)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view = a(flag, true);
        flag = flag1;
        if (!mSmoothScrollbarEnabled)
        {
            flag = true;
        }
        return com.target.ui.layout_manager.d.a(q, x1, view, b(flag, true), this, mSmoothScrollbarEnabled, mShouldReverseLayout);
    }

    private int i(android.support.v7.widget.RecyclerView.q q)
    {
        boolean flag1 = false;
        if (o() == 0)
        {
            return 0;
        }
        g();
        x x1 = mOrientationHelper;
        View view;
        boolean flag;
        if (!mSmoothScrollbarEnabled)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view = a(flag, true);
        flag = flag1;
        if (!mSmoothScrollbarEnabled)
        {
            flag = true;
        }
        return com.target.ui.layout_manager.d.a(q, x1, view, b(flag, true), this, mSmoothScrollbarEnabled);
    }

    private int j(android.support.v7.widget.RecyclerView.q q)
    {
        boolean flag1 = false;
        if (o() == 0)
        {
            return 0;
        }
        g();
        x x1 = mOrientationHelper;
        View view;
        boolean flag;
        if (!mSmoothScrollbarEnabled)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view = a(flag, true);
        flag = flag1;
        if (!mSmoothScrollbarEnabled)
        {
            flag = true;
        }
        return d.b(q, x1, view, b(flag, true), this, mSmoothScrollbarEnabled);
    }

    private View k(int i1)
    {
        return a(0, o(), i1);
    }

    private View k(android.support.v7.widget.RecyclerView.q q)
    {
        if (mShouldReverseLayout)
        {
            return k(q.e());
        } else
        {
            return l(q.e());
        }
    }

    private View l(int i1)
    {
        return a(o() - 1, -1, i1);
    }

    private View l(android.support.v7.widget.RecyclerView.q q)
    {
        if (mShouldReverseLayout)
        {
            return l(q.e());
        } else
        {
            return k(q.e());
        }
    }

    public int a(int i1, android.support.v7.widget.RecyclerView.m m1, android.support.v7.widget.RecyclerView.q q)
    {
        if (mOrientation == 1)
        {
            return 0;
        } else
        {
            return c(i1, m1, q);
        }
    }

    int a(android.support.v7.widget.RecyclerView.m m1, c c1, android.support.v7.widget.RecyclerView.q q, boolean flag)
    {
        b b1;
        int i1;
        int k1;
        k1 = c1.mAvailable;
        if (c1.mScrollingOffset != 0x80000000)
        {
            if (c1.mAvailable < 0)
            {
                c1.mScrollingOffset = c1.mScrollingOffset + c1.mAvailable;
            }
            a(m1, c1);
        }
        i1 = c1.mAvailable + c1.mExtra;
        b1 = new b();
_L4:
        if (i1 <= 0 || !c1.a(q)) goto _L2; else goto _L1
_L1:
        b1.a();
        a(m1, q, c1, b1);
        if (!b1.mFinished) goto _L3; else goto _L2
_L2:
        return k1 - c1.mAvailable;
_L3:
        int j1;
label0:
        {
            c1.mOffset = c1.mOffset + b1.mConsumed * c1.mLayoutDirection;
            if (b1.mIgnoreConsumed && mLayoutState.mScrapList == null)
            {
                j1 = i1;
                if (q.a())
                {
                    break label0;
                }
            }
            c1.mAvailable = c1.mAvailable - b1.mConsumed;
            j1 = i1 - b1.mConsumed;
        }
        if (c1.mScrollingOffset != 0x80000000)
        {
            c1.mScrollingOffset = c1.mScrollingOffset + b1.mConsumed;
            if (c1.mAvailable < 0)
            {
                c1.mScrollingOffset = c1.mScrollingOffset + c1.mAvailable;
            }
            a(m1, c1);
        }
        i1 = j1;
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        i1 = j1;
        if (!b1.mFocusable) goto _L4; else goto _L2
    }

    protected int a(android.support.v7.widget.RecyclerView.q q)
    {
        if (q.d())
        {
            return mOrientationHelper.f();
        } else
        {
            return 0;
        }
    }

    public android.support.v7.widget.RecyclerView.i a()
    {
        return new android.support.v7.widget.RecyclerView.i(-2, -2);
    }

    View a(int i1, int j1, boolean flag, boolean flag1)
    {
        g();
        int k1 = mOrientationHelper.c();
        int l1 = mOrientationHelper.d();
        View view;
        byte byte0;
        if (j1 > i1)
        {
            byte0 = 1;
        } else
        {
            byte0 = -1;
        }
        view = null;
        for (; i1 != j1; i1 += byte0)
        {
            View view1 = g(i1);
            int i2 = mOrientationHelper.a(view1);
            int j2 = mOrientationHelper.b(view1);
            if (i2 >= l1 || j2 <= k1)
            {
                continue;
            }
            if (!flag || i2 >= k1 && j2 <= l1)
            {
                return view1;
            }
            if (flag1 && view == null)
            {
                view = view1;
            }
        }

        return view;
    }

    public View a(View view, int i1, android.support.v7.widget.RecyclerView.m m1, android.support.v7.widget.RecyclerView.q q)
    {
        A();
        if (o() != 0)
        {
            if ((i1 = b(i1)) != 0x80000000)
            {
                g();
                if (i1 == -1)
                {
                    view = l(q);
                } else
                {
                    view = k(q);
                }
                if (view != null)
                {
                    g();
                    a(i1, (int)(0.33F * (float)mOrientationHelper.f()), false, q);
                    mLayoutState.mScrollingOffset = 0x80000000;
                    mLayoutState.mRecycle = false;
                    a(m1, mLayoutState, q, true);
                    if (i1 == -1)
                    {
                        m1 = h();
                    } else
                    {
                        m1 = i();
                    }
                    if (m1 != view && m1.isFocusable())
                    {
                        return m1;
                    }
                }
            }
        }
        return null;
    }

    public void a(int i1)
    {
        if (i1 != 0 && i1 != 1)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("invalid orientation:").append(i1).toString());
        }
        a(((String) (null)));
        if (i1 == mOrientation)
        {
            return;
        } else
        {
            mOrientation = i1;
            mOrientationHelper = null;
            k();
            return;
        }
    }

    protected void a(int i1, int j1, boolean flag, android.support.v7.widget.RecyclerView.q q)
    {
        byte byte0 = -1;
        boolean flag1 = true;
        mLayoutState.mExtra = a(q);
        mLayoutState.mLayoutDirection = i1;
        if (i1 == 1)
        {
            q = mLayoutState;
            q.mExtra = ((c) (q)).mExtra + mOrientationHelper.g();
            q = i();
            c c1 = mLayoutState;
            if (mShouldReverseLayout)
            {
                i1 = byte0;
            } else
            {
                i1 = 1;
            }
            c1.mItemDirection = i1;
            mLayoutState.mCurrentPosition = d(q) + mLayoutState.mItemDirection;
            mLayoutState.mOffset = mOrientationHelper.b(q);
            i1 = mOrientationHelper.b(q) - mOrientationHelper.d();
        } else
        {
            q = h();
            c c2 = mLayoutState;
            c2.mExtra = c2.mExtra + mOrientationHelper.c();
            c2 = mLayoutState;
            if (mShouldReverseLayout)
            {
                i1 = ((flag1) ? 1 : 0);
            } else
            {
                i1 = -1;
            }
            c2.mItemDirection = i1;
            mLayoutState.mCurrentPosition = d(q) + mLayoutState.mItemDirection;
            mLayoutState.mOffset = mOrientationHelper.a(q);
            i1 = -mOrientationHelper.a(q) + mOrientationHelper.c();
        }
        mLayoutState.mAvailable = j1;
        if (flag)
        {
            q = mLayoutState;
            q.mAvailable = ((c) (q)).mAvailable - i1;
        }
        mLayoutState.mScrollingOffset = i1;
    }

    public void a(Parcelable parcelable)
    {
        if (parcelable instanceof SavedState)
        {
            mPendingSavedState = (SavedState)parcelable;
            k();
        }
    }

    void a(android.support.v7.widget.RecyclerView.m m1, android.support.v7.widget.RecyclerView.q q, c c1, b b1)
    {
        m1 = c1.a(m1);
        if (m1 == null)
        {
            b1.mFinished = true;
            return;
        }
        q = (android.support.v7.widget.RecyclerView.i)m1.getLayoutParams();
        int i1;
        int j1;
        int k1;
        int l1;
        if (c1.mScrapList == null)
        {
            boolean flag2 = mShouldReverseLayout;
            boolean flag;
            if (c1.mLayoutDirection == -1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag2 == flag)
            {
                b(m1);
            } else
            {
                b(m1, 0);
            }
        } else
        {
            boolean flag3 = mShouldReverseLayout;
            boolean flag1;
            if (c1.mLayoutDirection == -1)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag3 == flag1)
            {
                a(((View) (m1)));
            } else
            {
                a(((View) (m1)), 0);
            }
        }
        a(((View) (m1)), 0, 0);
        b1.mConsumed = mOrientationHelper.c(m1);
        if (mOrientation == 1)
        {
            if (f())
            {
                i1 = p() - t();
                j1 = i1 - mOrientationHelper.d(m1);
            } else
            {
                j1 = r();
                i1 = mOrientationHelper.d(m1) + j1;
            }
            if (c1.mLayoutDirection == -1)
            {
                k1 = c1.mOffset;
                l1 = c1.mOffset - b1.mConsumed;
            } else
            {
                l1 = c1.mOffset;
                k1 = c1.mOffset;
                int i2 = b1.mConsumed;
                k1 += i2;
            }
        } else
        {
            l1 = s();
            k1 = mOrientationHelper.d(m1) + l1;
            if (c1.mLayoutDirection == -1)
            {
                i1 = c1.mOffset;
                j1 = c1.mOffset - b1.mConsumed;
            } else
            {
                j1 = c1.mOffset;
                i1 = c1.mOffset;
                int j2 = b1.mConsumed;
                i1 += j2;
            }
        }
        a(((View) (m1)), j1 + ((android.support.v7.widget.RecyclerView.i) (q)).leftMargin, l1 + ((android.support.v7.widget.RecyclerView.i) (q)).topMargin, i1 - ((android.support.v7.widget.RecyclerView.i) (q)).rightMargin, k1 - ((android.support.v7.widget.RecyclerView.i) (q)).bottomMargin);
        if (q.c() || q.d())
        {
            b1.mIgnoreConsumed = true;
        }
        b1.mFocusable = m1.isFocusable();
    }

    protected void a(android.support.v7.widget.RecyclerView.m m1, c c1)
    {
        if (!c1.mRecycle)
        {
            return;
        }
        if (c1.mLayoutDirection == -1)
        {
            b(m1, c1.mScrollingOffset);
            return;
        } else
        {
            a(m1, c1.mScrollingOffset);
            return;
        }
    }

    void a(android.support.v7.widget.RecyclerView.q q, a a1)
    {
    }

    public void a(RecyclerView recyclerview, android.support.v7.widget.RecyclerView.m m1)
    {
        super.a(recyclerview, m1);
        if (mRecycleChildrenOnDetach)
        {
            c(m1);
            m1.a();
        }
    }

    public void a(AccessibilityEvent accessibilityevent)
    {
        super.a(accessibilityevent);
        if (o() > 0)
        {
            accessibilityevent = android.support.v4.view.a.a.a(accessibilityevent);
            accessibilityevent.b(j());
            accessibilityevent.c(z());
        }
    }

    public void a(String s)
    {
        if (mPendingSavedState == null)
        {
            super.a(s);
        }
    }

    public void a(boolean flag)
    {
        a(((String) (null)));
        if (flag == mReverseLayout)
        {
            return;
        } else
        {
            mReverseLayout = flag;
            k();
            return;
        }
    }

    public int b(int i1, android.support.v7.widget.RecyclerView.m m1, android.support.v7.widget.RecyclerView.q q)
    {
        if (mOrientation == 0)
        {
            return 0;
        } else
        {
            return c(i1, m1, q);
        }
    }

    public int b(android.support.v7.widget.RecyclerView.q q)
    {
        return h(q);
    }

    protected void b(int i1, int j1)
    {
        mLayoutState.mAvailable = mOrientationHelper.d() - j1;
        c c1 = mLayoutState;
        int k1;
        if (mShouldReverseLayout)
        {
            k1 = -1;
        } else
        {
            k1 = 1;
        }
        c1.mItemDirection = k1;
        mLayoutState.mCurrentPosition = i1;
        mLayoutState.mLayoutDirection = 1;
        mLayoutState.mOffset = j1;
        mLayoutState.mScrollingOffset = 0x80000000;
    }

    public boolean b()
    {
        return mPendingSavedState == null && mLastStackFromEnd == mStackFromEnd;
    }

    int c(int i1, android.support.v7.widget.RecyclerView.m m1, android.support.v7.widget.RecyclerView.q q)
    {
        if (o() == 0 || i1 == 0)
        {
            return 0;
        }
        mLayoutState.mRecycle = true;
        g();
        int j1;
        int k1;
        int l1;
        if (i1 > 0)
        {
            j1 = 1;
        } else
        {
            j1 = -1;
        }
        k1 = Math.abs(i1);
        a(j1, k1, true, q);
        l1 = mLayoutState.mScrollingOffset + a(m1, mLayoutState, q, false);
        if (l1 < 0)
        {
            return 0;
        }
        if (k1 > l1)
        {
            i1 = j1 * l1;
        }
        mOrientationHelper.a(-i1);
        return i1;
    }

    public int c(android.support.v7.widget.RecyclerView.q q)
    {
        return h(q);
    }

    public Parcelable c()
    {
        if (mPendingSavedState != null)
        {
            return new SavedState(mPendingSavedState);
        }
        SavedState savedstate = new SavedState();
        if (o() > 0)
        {
            g();
            boolean flag = mLastStackFromEnd ^ mShouldReverseLayout;
            savedstate.mAnchorLayoutFromEnd = flag;
            if (flag)
            {
                View view = i();
                savedstate.mAnchorOffset = mOrientationHelper.d() - mOrientationHelper.b(view);
                savedstate.mAnchorPosition = d(view);
                return savedstate;
            } else
            {
                View view1 = h();
                savedstate.mAnchorPosition = d(view1);
                savedstate.mAnchorOffset = mOrientationHelper.a(view1) - mOrientationHelper.c();
                return savedstate;
            }
        } else
        {
            savedstate.b();
            return savedstate;
        }
    }

    public View c(int i1)
    {
        int j1 = o();
        if (j1 != 0)
        {
            if ((i1 -= d(g(0))) >= 0 && i1 < j1)
            {
                return g(i1);
            }
        }
        return null;
    }

    protected void c(int i1, int j1)
    {
        mLayoutState.mAvailable = j1 - mOrientationHelper.c();
        mLayoutState.mCurrentPosition = i1;
        c c1 = mLayoutState;
        if (mShouldReverseLayout)
        {
            i1 = 1;
        } else
        {
            i1 = -1;
        }
        c1.mItemDirection = i1;
        mLayoutState.mLayoutDirection = -1;
        mLayoutState.mOffset = j1;
        mLayoutState.mScrollingOffset = 0x80000000;
    }

    public void c(android.support.v7.widget.RecyclerView.m m1, android.support.v7.widget.RecyclerView.q q)
    {
        if (mPendingSavedState != null && mPendingSavedState.a())
        {
            mPendingScrollPosition = mPendingSavedState.mAnchorPosition;
        }
        g();
        mLayoutState.mRecycle = false;
        A();
        mAnchorInfo.a();
        mAnchorInfo.mLayoutFromEnd = mShouldReverseLayout ^ mStackFromEnd;
        b(q, mAnchorInfo);
        int j1 = a(q);
        int i1;
        int k1;
        int l1;
        boolean flag;
        if (q.d() && q.c() < mAnchorInfo.mPosition)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag == mAnchorInfo.mLayoutFromEnd)
        {
            i1 = j1;
            j1 = 0;
        } else
        {
            i1 = 0;
        }
        k1 = j1 + mOrientationHelper.c();
        l1 = i1 + mOrientationHelper.g();
        i1 = l1;
        j1 = k1;
        if (q.a())
        {
            i1 = l1;
            j1 = k1;
            if (mPendingScrollPosition != -1)
            {
                i1 = l1;
                j1 = k1;
                if (mPendingScrollPositionOffset != 0x80000000)
                {
                    Object obj = c(mPendingScrollPosition);
                    i1 = l1;
                    j1 = k1;
                    if (obj != null)
                    {
                        if (mShouldReverseLayout)
                        {
                            i1 = mOrientationHelper.d() - mOrientationHelper.b(((View) (obj))) - mPendingScrollPositionOffset;
                        } else
                        {
                            i1 = mOrientationHelper.a(((View) (obj)));
                            j1 = mOrientationHelper.c();
                            i1 = mPendingScrollPositionOffset - (i1 - j1);
                        }
                        if (i1 > 0)
                        {
                            j1 = k1 + i1;
                            i1 = l1;
                        } else
                        {
                            i1 = l1 - i1;
                            j1 = k1;
                        }
                    }
                }
            }
        }
        a(q, mAnchorInfo);
        a(m1);
        mLayoutState.mIsPreLayout = q.a();
        if (mAnchorInfo.mLayoutFromEnd)
        {
            b(mAnchorInfo);
            mLayoutState.mExtra = j1;
            a(m1, mLayoutState, q, false);
            k1 = mLayoutState.mOffset;
            j1 = i1;
            if (mLayoutState.mAvailable > 0)
            {
                j1 = i1 + mLayoutState.mAvailable;
            }
            a(mAnchorInfo);
            mLayoutState.mExtra = j1;
            obj = mLayoutState;
            obj.mCurrentPosition = ((c) (obj)).mCurrentPosition + mLayoutState.mItemDirection;
            a(m1, mLayoutState, q, false);
            i1 = mLayoutState.mOffset;
            j1 = k1;
        } else
        {
            a(mAnchorInfo);
            mLayoutState.mExtra = i1;
            a(m1, mLayoutState, q, false);
            k1 = mLayoutState.mOffset;
            i1 = j1;
            if (mLayoutState.mAvailable > 0)
            {
                i1 = j1 + mLayoutState.mAvailable;
            }
            b(mAnchorInfo);
            mLayoutState.mExtra = i1;
            c c1 = mLayoutState;
            c1.mCurrentPosition = c1.mCurrentPosition + mLayoutState.mItemDirection;
            a(m1, mLayoutState, q, false);
            j1 = mLayoutState.mOffset;
            i1 = k1;
        }
        k1 = i1;
        l1 = j1;
        if (o() > 0)
        {
            if (mShouldReverseLayout ^ mStackFromEnd)
            {
                k1 = a(i1, m1, q, true);
                l1 = j1 + k1;
                j1 = b(l1, m1, q, false);
                l1 += j1;
                k1 = i1 + k1 + j1;
            } else
            {
                k1 = b(j1, m1, q, true);
                i1 += k1;
                int i2 = a(i1, m1, q, false);
                l1 = j1 + k1 + i2;
                k1 = i1 + i2;
            }
        }
        b(m1, q, l1, k1);
        if (!q.a())
        {
            mPendingScrollPosition = -1;
            mPendingScrollPositionOffset = 0x80000000;
            mOrientationHelper.a();
        }
        mLastStackFromEnd = mStackFromEnd;
        mPendingSavedState = null;
    }

    public int d(android.support.v7.widget.RecyclerView.q q)
    {
        return i(q);
    }

    public void d(int i1)
    {
        mPendingScrollPosition = i1;
        mPendingScrollPositionOffset = 0x80000000;
        if (mPendingSavedState != null)
        {
            mPendingSavedState.b();
        }
        k();
    }

    public boolean d()
    {
        return mOrientation == 0;
    }

    public int e(android.support.v7.widget.RecyclerView.q q)
    {
        return i(q);
    }

    public boolean e()
    {
        return mOrientation == 1;
    }

    public int f(android.support.v7.widget.RecyclerView.q q)
    {
        return j(q);
    }

    protected boolean f()
    {
        return n() == 1;
    }

    public int g(android.support.v7.widget.RecyclerView.q q)
    {
        return j(q);
    }

    void g()
    {
        if (mLayoutState == null)
        {
            mLayoutState = new c();
        }
        if (mOrientationHelper == null)
        {
            mOrientationHelper = x.a(this, mOrientation);
        }
    }

    protected View h()
    {
        int i1;
        if (mShouldReverseLayout)
        {
            i1 = o() - 1;
        } else
        {
            i1 = 0;
        }
        return g(i1);
    }

    protected View i()
    {
        int i1;
        if (mShouldReverseLayout)
        {
            i1 = 0;
        } else
        {
            i1 = o() - 1;
        }
        return g(i1);
    }

    public int j()
    {
        View view = a(0, o(), false, true);
        if (view == null)
        {
            return -1;
        } else
        {
            return d(view);
        }
    }

    public int z()
    {
        View view = a(o() - 1, -1, false, true);
        if (view == null)
        {
            return -1;
        } else
        {
            return d(view);
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.a.a;
import android.support.v4.view.a.m;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

// Referenced classes of package android.support.v7.widget:
//            x, ac, RecyclerView

public class LinearLayoutManager extends RecyclerView.h
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
        int a;
        int b;
        boolean c;

        boolean a()
        {
            return a >= 0;
        }

        void b()
        {
            a = -1;
        }

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            parcel.writeInt(a);
            parcel.writeInt(b);
            if (c)
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
            a = parcel.readInt();
            b = parcel.readInt();
            if (parcel.readInt() != 1)
            {
                flag = false;
            }
            c = flag;
        }

        public SavedState(SavedState savedstate)
        {
            a = savedstate.a;
            b = savedstate.b;
            c = savedstate.c;
        }
    }

    class a
    {

        int a;
        int b;
        boolean c;
        final LinearLayoutManager d;

        void a()
        {
            a = -1;
            b = 0x80000000;
            c = false;
        }

        public void a(View view)
        {
            if (c)
            {
                b = d.mOrientationHelper.b(view) + d.mOrientationHelper.b();
            } else
            {
                b = d.mOrientationHelper.a(view);
            }
            a = d.d(view);
        }

        public boolean a(View view, RecyclerView.q q)
        {
            RecyclerView.i i1 = (RecyclerView.i)view.getLayoutParams();
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
            if (c)
            {
                i1 = d.mOrientationHelper.d();
            } else
            {
                i1 = d.mOrientationHelper.c();
            }
            b = i1;
        }

        public String toString()
        {
            return (new StringBuilder()).append("AnchorInfo{mPosition=").append(a).append(", mCoordinate=").append(b).append(", mLayoutFromEnd=").append(c).append('}').toString();
        }

        a()
        {
            d = LinearLayoutManager.this;
            super();
        }
    }

    protected static class b
    {

        public int a;
        public boolean b;
        public boolean c;
        public boolean d;

        void a()
        {
            a = 0;
            b = false;
            c = false;
            d = false;
        }

        protected b()
        {
        }
    }

    static class c
    {

        boolean a;
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;
        int h;
        boolean i;
        List j;

        private View a()
        {
            RecyclerView.t t;
            int i1;
            int j1;
            int l1;
            l1 = j.size();
            i1 = 0x7fffffff;
            j1 = 0;
            t = null;
_L2:
            RecyclerView.t t1;
            if (j1 >= l1)
            {
                break MISSING_BLOCK_LABEL_134;
            }
            t1 = (RecyclerView.t)j.get(j1);
            if (i || !t1.r())
            {
                break; /* Loop/switch isn't completed */
            }
_L4:
            j1++;
            if (true) goto _L2; else goto _L1
_L1:
            int k1 = (t1.e() - d) * e;
            if (k1 < 0 || k1 >= i1) goto _L4; else goto _L3
_L3:
            if (k1 != 0) goto _L6; else goto _L5
_L5:
            if (t1 != null)
            {
                d = t1.e() + e;
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

        View a(RecyclerView.m m1)
        {
            if (j != null)
            {
                return a();
            } else
            {
                m1 = m1.c(d);
                d = d + e;
                return m1;
            }
        }

        boolean a(RecyclerView.q q)
        {
            return d >= 0 && d < q.e();
        }

        c()
        {
            a = true;
            h = 0;
            i = false;
            j = null;
        }
    }


    private static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = 0x80000000;
    private static final float MAX_SCROLL_FACTOR = 0.33F;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final a mAnchorInfo;
    private boolean mLastStackFromEnd;
    private c mLayoutState;
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

    public LinearLayoutManager(Context context)
    {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i1, boolean flag)
    {
        mReverseLayout = false;
        mShouldReverseLayout = false;
        mStackFromEnd = false;
        mSmoothScrollbarEnabled = true;
        mPendingScrollPosition = -1;
        mPendingScrollPositionOffset = 0x80000000;
        mPendingSavedState = null;
        mAnchorInfo = new a();
        b(i1);
        a(flag);
    }

    private View A()
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

    private View B()
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

    private int a(int i1)
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

    private int a(int i1, RecyclerView.m m1, RecyclerView.q q, boolean flag)
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
        h();
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
        if (!((RecyclerView.i)view2.getLayoutParams()).c()) goto _L4; else goto _L3
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

    private void a(int i1, int j1, boolean flag, RecyclerView.q q)
    {
        byte byte0 = -1;
        boolean flag1 = true;
        mLayoutState.h = a(q);
        mLayoutState.f = i1;
        if (i1 == 1)
        {
            q = mLayoutState;
            q.h = ((c) (q)).h + mOrientationHelper.g();
            q = B();
            c c1 = mLayoutState;
            if (mShouldReverseLayout)
            {
                i1 = byte0;
            } else
            {
                i1 = 1;
            }
            c1.e = i1;
            mLayoutState.d = d(q) + mLayoutState.e;
            mLayoutState.b = mOrientationHelper.b(q);
            i1 = mOrientationHelper.b(q) - mOrientationHelper.d();
        } else
        {
            q = A();
            c c2 = mLayoutState;
            c2.h = c2.h + mOrientationHelper.c();
            c2 = mLayoutState;
            if (mShouldReverseLayout)
            {
                i1 = ((flag1) ? 1 : 0);
            } else
            {
                i1 = -1;
            }
            c2.e = i1;
            mLayoutState.d = d(q) + mLayoutState.e;
            mLayoutState.b = mOrientationHelper.a(q);
            i1 = -mOrientationHelper.a(q) + mOrientationHelper.c();
        }
        mLayoutState.c = j1;
        if (flag)
        {
            q = mLayoutState;
            q.c = ((c) (q)).c - i1;
        }
        mLayoutState.g = i1;
    }

    private void a(a a1)
    {
        b(a1.a, a1.b);
    }

    private void a(RecyclerView.m m1, int i1)
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

    private void a(RecyclerView.m m1, int i1, int j1)
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

    private void a(RecyclerView.m m1, c c1)
    {
        if (!c1.a)
        {
            return;
        }
        if (c1.f == -1)
        {
            b(m1, c1.g);
            return;
        } else
        {
            a(m1, c1.g);
            return;
        }
    }

    private int b(int i1, RecyclerView.m m1, RecyclerView.q q, boolean flag)
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

    private void b(int i1, int j1)
    {
        mLayoutState.c = mOrientationHelper.d() - j1;
        c c1 = mLayoutState;
        int k1;
        if (mShouldReverseLayout)
        {
            k1 = -1;
        } else
        {
            k1 = 1;
        }
        c1.e = k1;
        mLayoutState.d = i1;
        mLayoutState.f = 1;
        mLayoutState.b = j1;
        mLayoutState.g = 0x80000000;
    }

    private void b(a a1)
    {
        c(a1.a, a1.b);
    }

    private void b(RecyclerView.m m1, int i1)
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

    private void b(RecyclerView.m m1, RecyclerView.q q, int i1, int j1)
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
            RecyclerView.t t = (RecyclerView.t)list.get(i2);
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
        mLayoutState.j = list;
        if (l1 > 0)
        {
            c(d(A()), i1);
            mLayoutState.h = l1;
            mLayoutState.c = 0;
            c c1 = mLayoutState;
            l1 = c1.d;
            if (mShouldReverseLayout)
            {
                i1 = 1;
            } else
            {
                i1 = -1;
            }
            c1.d = i1 + l1;
            a(m1, mLayoutState, q, false);
        }
        if (k1 > 0)
        {
            b(d(B()), j1);
            mLayoutState.h = k1;
            mLayoutState.c = 0;
            c1 = mLayoutState;
            j1 = c1.d;
            if (mShouldReverseLayout)
            {
                i1 = -1;
            } else
            {
                i1 = 1;
            }
            c1.d = i1 + j1;
            a(m1, mLayoutState, q, false);
        }
        mLayoutState.j = null;
    }

    private void b(RecyclerView.q q, a a1)
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
        a1.a = i1;
    }

    private void c(int i1, int j1)
    {
        mLayoutState.c = j1 - mOrientationHelper.c();
        mLayoutState.d = i1;
        c c1 = mLayoutState;
        if (mShouldReverseLayout)
        {
            i1 = 1;
        } else
        {
            i1 = -1;
        }
        c1.e = i1;
        mLayoutState.f = -1;
        mLayoutState.b = j1;
        mLayoutState.g = 0x80000000;
    }

    private boolean c(RecyclerView.q q, a a1)
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
                if (a1.c)
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
                            if (a1.c)
                            {
                                i1 = mOrientationHelper.d();
                            } else
                            {
                                i1 = mOrientationHelper.c();
                            }
                            a1.b = i1;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private boolean d(RecyclerView.q q, a a1)
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
        a1.a = mPendingScrollPosition;
        if (mPendingSavedState != null && mPendingSavedState.a())
        {
            a1.c = mPendingSavedState.c;
            if (a1.c)
            {
                a1.b = mOrientationHelper.d() - mPendingSavedState.b;
                return true;
            } else
            {
                a1.b = mOrientationHelper.c() + mPendingSavedState.b;
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
                    a1.b = mOrientationHelper.c();
                    a1.c = false;
                    return true;
                }
                if (mOrientationHelper.d() - mOrientationHelper.b(q) < 0)
                {
                    a1.b = mOrientationHelper.d();
                    a1.c = true;
                    return true;
                }
                int i1;
                if (a1.c)
                {
                    i1 = mOrientationHelper.b(q) + mOrientationHelper.b();
                } else
                {
                    i1 = mOrientationHelper.a(q);
                }
                a1.b = i1;
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
                a1.c = flag1;
            }
            a1.b();
            return true;
        }
        a1.c = mShouldReverseLayout;
        if (mShouldReverseLayout)
        {
            a1.b = mOrientationHelper.d() - mPendingScrollPositionOffset;
            return true;
        } else
        {
            a1.b = mOrientationHelper.c() + mPendingScrollPositionOffset;
            return true;
        }
    }

    private int h(RecyclerView.q q)
    {
        boolean flag1 = false;
        if (o() == 0)
        {
            return 0;
        }
        h();
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
        return android.support.v7.widget.ac.a(q, x1, view, b(flag, true), this, mSmoothScrollbarEnabled, mShouldReverseLayout);
    }

    private int i(RecyclerView.q q)
    {
        boolean flag1 = false;
        if (o() == 0)
        {
            return 0;
        }
        h();
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
        return android.support.v7.widget.ac.a(q, x1, view, b(flag, true), this, mSmoothScrollbarEnabled);
    }

    private int j(RecyclerView.q q)
    {
        boolean flag1 = false;
        if (o() == 0)
        {
            return 0;
        }
        h();
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
        return ac.b(q, x1, view, b(flag, true), this, mSmoothScrollbarEnabled);
    }

    private View k(int i1)
    {
        return a(0, o(), i1);
    }

    private View k(RecyclerView.q q)
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

    private View l(RecyclerView.q q)
    {
        if (mShouldReverseLayout)
        {
            return l(q.e());
        } else
        {
            return k(q.e());
        }
    }

    private void z()
    {
        boolean flag = true;
        if (mOrientation == 1 || !g())
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

    public int a(int i1, RecyclerView.m m1, RecyclerView.q q)
    {
        if (mOrientation == 1)
        {
            return 0;
        } else
        {
            return c(i1, m1, q);
        }
    }

    int a(RecyclerView.m m1, c c1, RecyclerView.q q, boolean flag)
    {
        b b1;
        int i1;
        int k1;
        k1 = c1.c;
        if (c1.g != 0x80000000)
        {
            if (c1.c < 0)
            {
                c1.g = c1.g + c1.c;
            }
            a(m1, c1);
        }
        i1 = c1.c + c1.h;
        b1 = new b();
_L4:
        if (i1 <= 0 || !c1.a(q)) goto _L2; else goto _L1
_L1:
        b1.a();
        a(m1, q, c1, b1);
        if (!b1.b) goto _L3; else goto _L2
_L2:
        return k1 - c1.c;
_L3:
        int j1;
label0:
        {
            c1.b = c1.b + b1.a * c1.f;
            if (b1.c && mLayoutState.j == null)
            {
                j1 = i1;
                if (q.a())
                {
                    break label0;
                }
            }
            c1.c = c1.c - b1.a;
            j1 = i1 - b1.a;
        }
        if (c1.g != 0x80000000)
        {
            c1.g = c1.g + b1.a;
            if (c1.c < 0)
            {
                c1.g = c1.g + c1.c;
            }
            a(m1, c1);
        }
        i1 = j1;
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        i1 = j1;
        if (!b1.d) goto _L4; else goto _L2
    }

    protected int a(RecyclerView.q q)
    {
        if (q.d())
        {
            return mOrientationHelper.f();
        } else
        {
            return 0;
        }
    }

    public RecyclerView.i a()
    {
        return new RecyclerView.i(-2, -2);
    }

    View a(int i1, int j1, boolean flag, boolean flag1)
    {
        h();
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

    public View a(View view, int i1, RecyclerView.m m1, RecyclerView.q q)
    {
        z();
        if (o() != 0)
        {
            if ((i1 = a(i1)) != 0x80000000)
            {
                h();
                if (i1 == -1)
                {
                    view = l(q);
                } else
                {
                    view = k(q);
                }
                if (view != null)
                {
                    h();
                    a(i1, (int)(0.33F * (float)mOrientationHelper.f()), false, q);
                    mLayoutState.g = 0x80000000;
                    mLayoutState.a = false;
                    a(m1, mLayoutState, q, true);
                    if (i1 == -1)
                    {
                        m1 = A();
                    } else
                    {
                        m1 = B();
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

    public void a(Parcelable parcelable)
    {
        if (parcelable instanceof SavedState)
        {
            mPendingSavedState = (SavedState)parcelable;
            k();
        }
    }

    void a(RecyclerView.m m1, RecyclerView.q q, c c1, b b1)
    {
        m1 = c1.a(m1);
        if (m1 == null)
        {
            b1.b = true;
            return;
        }
        q = (RecyclerView.i)m1.getLayoutParams();
        int i1;
        int j1;
        int k1;
        int l1;
        if (c1.j == null)
        {
            boolean flag2 = mShouldReverseLayout;
            boolean flag;
            if (c1.f == -1)
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
            if (c1.f == -1)
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
        b1.a = mOrientationHelper.c(m1);
        if (mOrientation == 1)
        {
            if (g())
            {
                i1 = p() - t();
                j1 = i1 - mOrientationHelper.d(m1);
            } else
            {
                j1 = r();
                i1 = mOrientationHelper.d(m1) + j1;
            }
            if (c1.f == -1)
            {
                k1 = c1.b;
                l1 = c1.b - b1.a;
            } else
            {
                l1 = c1.b;
                k1 = c1.b;
                int i2 = b1.a;
                k1 += i2;
            }
        } else
        {
            l1 = s();
            k1 = mOrientationHelper.d(m1) + l1;
            if (c1.f == -1)
            {
                i1 = c1.b;
                j1 = c1.b - b1.a;
            } else
            {
                j1 = c1.b;
                i1 = c1.b;
                int j2 = b1.a;
                i1 += j2;
            }
        }
        a(((View) (m1)), j1 + ((RecyclerView.i) (q)).leftMargin, l1 + ((RecyclerView.i) (q)).topMargin, i1 - ((RecyclerView.i) (q)).rightMargin, k1 - ((RecyclerView.i) (q)).bottomMargin);
        if (q.c() || q.d())
        {
            b1.c = true;
        }
        b1.d = m1.isFocusable();
    }

    void a(RecyclerView.q q, a a1)
    {
    }

    public void a(RecyclerView recyclerview, RecyclerView.m m1)
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
            accessibilityevent.b(i());
            accessibilityevent.c(j());
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

    public int b(int i1, RecyclerView.m m1, RecyclerView.q q)
    {
        if (mOrientation == 0)
        {
            return 0;
        } else
        {
            return c(i1, m1, q);
        }
    }

    public int b(RecyclerView.q q)
    {
        return h(q);
    }

    public void b(int i1)
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

    public boolean b()
    {
        return mPendingSavedState == null && mLastStackFromEnd == mStackFromEnd;
    }

    int c(int i1, RecyclerView.m m1, RecyclerView.q q)
    {
        if (o() == 0 || i1 == 0)
        {
            return 0;
        }
        mLayoutState.a = true;
        h();
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
        l1 = mLayoutState.g + a(m1, mLayoutState, q, false);
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

    public int c(RecyclerView.q q)
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
            h();
            boolean flag = mLastStackFromEnd ^ mShouldReverseLayout;
            savedstate.c = flag;
            if (flag)
            {
                View view = B();
                savedstate.b = mOrientationHelper.d() - mOrientationHelper.b(view);
                savedstate.a = d(view);
                return savedstate;
            } else
            {
                View view1 = A();
                savedstate.a = d(view1);
                savedstate.b = mOrientationHelper.a(view1) - mOrientationHelper.c();
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

    public void c(RecyclerView.m m1, RecyclerView.q q)
    {
        if (mPendingSavedState != null && mPendingSavedState.a())
        {
            mPendingScrollPosition = mPendingSavedState.a;
        }
        h();
        mLayoutState.a = false;
        z();
        mAnchorInfo.a();
        mAnchorInfo.c = mShouldReverseLayout ^ mStackFromEnd;
        b(q, mAnchorInfo);
        int j1 = a(q);
        int i1;
        int k1;
        int l1;
        boolean flag;
        if (q.d() && q.c() < mAnchorInfo.a)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag == mAnchorInfo.c)
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
        mLayoutState.i = q.a();
        if (mAnchorInfo.c)
        {
            b(mAnchorInfo);
            mLayoutState.h = j1;
            a(m1, mLayoutState, q, false);
            k1 = mLayoutState.b;
            j1 = i1;
            if (mLayoutState.c > 0)
            {
                j1 = i1 + mLayoutState.c;
            }
            a(mAnchorInfo);
            mLayoutState.h = j1;
            obj = mLayoutState;
            obj.d = ((c) (obj)).d + mLayoutState.e;
            a(m1, mLayoutState, q, false);
            i1 = mLayoutState.b;
            j1 = k1;
        } else
        {
            a(mAnchorInfo);
            mLayoutState.h = i1;
            a(m1, mLayoutState, q, false);
            k1 = mLayoutState.b;
            i1 = j1;
            if (mLayoutState.c > 0)
            {
                i1 = j1 + mLayoutState.c;
            }
            b(mAnchorInfo);
            mLayoutState.h = i1;
            c c1 = mLayoutState;
            c1.d = c1.d + mLayoutState.e;
            a(m1, mLayoutState, q, false);
            j1 = mLayoutState.b;
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

    public int d(RecyclerView.q q)
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

    public int e(RecyclerView.q q)
    {
        return i(q);
    }

    public boolean e()
    {
        return mOrientation == 1;
    }

    public int f()
    {
        return mOrientation;
    }

    public int f(RecyclerView.q q)
    {
        return j(q);
    }

    public int g(RecyclerView.q q)
    {
        return j(q);
    }

    protected boolean g()
    {
        return n() == 1;
    }

    void h()
    {
        if (mLayoutState == null)
        {
            mLayoutState = new c();
        }
        if (mOrientationHelper == null)
        {
            mOrientationHelper = android.support.v7.widget.x.a(this, mOrientation);
        }
    }

    public int i()
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

    public int j()
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

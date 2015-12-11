// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.f.a;
import android.support.v4.view.ag;
import android.support.v4.view.ai;
import android.support.v4.view.as;
import android.support.v4.view.t;
import android.support.v4.widget.g;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package android.support.v7.widget:
//            r, z, q, a

public class RecyclerView extends ViewGroup
{
    static class SavedState extends android.view.View.BaseSavedState
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
        Parcelable a;

        private void a(SavedState savedstate)
        {
            a = savedstate.a;
        }

        static void a(SavedState savedstate, SavedState savedstate1)
        {
            savedstate.a(savedstate1);
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            super.writeToParcel(parcel, i1);
            parcel.writeParcelable(a, 0);
        }


        SavedState(Parcel parcel)
        {
            super(parcel);
            a = parcel.readParcelable(android/support/v7/widget/RecyclerView$h.getClassLoader());
        }

        SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

    public static abstract class a
    {

        private boolean mHasStableIds;
        private final b mObservable = new b();

        public abstract int a();

        public int a(int i1)
        {
            return 0;
        }

        public abstract t a(ViewGroup viewgroup, int i1);

        public final void a(int i1, int j1)
        {
            mObservable.d(i1, j1);
        }

        public void a(c c1)
        {
            mObservable.registerObserver(c1);
        }

        public void a(t t1)
        {
        }

        public abstract void a(t t1, int i1);

        public void a(RecyclerView recyclerview)
        {
        }

        public void a(boolean flag)
        {
            if (c())
            {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            } else
            {
                mHasStableIds = flag;
                return;
            }
        }

        public long b(int i1)
        {
            return -1L;
        }

        public final t b(ViewGroup viewgroup, int i1)
        {
            viewgroup = a(viewgroup, i1);
            viewgroup.mItemViewType = i1;
            return viewgroup;
        }

        public void b(c c1)
        {
            mObservable.unregisterObserver(c1);
        }

        public final void b(t t1, int i1)
        {
            t1.mPosition = i1;
            if (b())
            {
                t1.mItemId = b(i1);
            }
            a(t1, i1);
            t1.a(1, 519);
        }

        public void b(RecyclerView recyclerview)
        {
        }

        public final boolean b()
        {
            return mHasStableIds;
        }

        public boolean b(t t1)
        {
            return false;
        }

        public final void c(int i1)
        {
            mObservable.a(i1, 1);
        }

        public void c(t t1)
        {
        }

        public final boolean c()
        {
            return mObservable.a();
        }

        public final void d()
        {
            mObservable.b();
        }

        public final void d(int i1)
        {
            mObservable.b(i1, 1);
        }

        public void d(t t1)
        {
        }

        public final void e(int i1)
        {
            mObservable.c(i1, 1);
        }

        public a()
        {
            mHasStableIds = false;
        }
    }

    static class b extends Observable
    {

        public void a(int i1, int j1)
        {
            for (int k1 = mObservers.size() - 1; k1 >= 0; k1--)
            {
                ((c)mObservers.get(k1)).a(i1, j1);
            }

        }

        public boolean a()
        {
            return !mObservers.isEmpty();
        }

        public void b()
        {
            for (int i1 = mObservers.size() - 1; i1 >= 0; i1--)
            {
                ((c)mObservers.get(i1)).a();
            }

        }

        public void b(int i1, int j1)
        {
            for (int k1 = mObservers.size() - 1; k1 >= 0; k1--)
            {
                ((c)mObservers.get(k1)).b(i1, j1);
            }

        }

        public void c(int i1, int j1)
        {
            for (int k1 = mObservers.size() - 1; k1 >= 0; k1--)
            {
                ((c)mObservers.get(k1)).c(i1, j1);
            }

        }

        public void d(int i1, int j1)
        {
            for (int k1 = mObservers.size() - 1; k1 >= 0; k1--)
            {
                ((c)mObservers.get(k1)).a(i1, j1, 1);
            }

        }

        b()
        {
        }
    }

    public static abstract class c
    {

        public void a()
        {
        }

        public void a(int i1, int j1)
        {
        }

        public void a(int i1, int j1, int k1)
        {
        }

        public void b(int i1, int j1)
        {
        }

        public void c(int i1, int j1)
        {
        }

        public c()
        {
        }
    }

    public static abstract class d
    {

        private long mAddDuration;
        private long mChangeDuration;
        private ArrayList mFinishedListeners;
        private b mListener;
        private long mMoveDuration;
        private long mRemoveDuration;
        private boolean mSupportsChangeAnimations;

        public abstract void a();

        public void a(long l1)
        {
            mMoveDuration = l1;
        }

        void a(b b1)
        {
            mListener = b1;
        }

        public final void a(t t1, boolean flag)
        {
            d(t1, flag);
            if (mListener != null)
            {
                mListener.d(t1);
            }
        }

        public final boolean a(a a1)
        {
            boolean flag;
label0:
            {
                flag = b();
                if (a1 != null)
                {
                    if (flag)
                    {
                        break label0;
                    }
                    a1.a();
                }
                return flag;
            }
            mFinishedListeners.add(a1);
            return flag;
        }

        public abstract boolean a(t t1);

        public abstract boolean a(t t1, int i1, int j1, int k1, int l1);

        public abstract boolean a(t t1, t t2, int i1, int j1, int k1, int l1);

        public void b(long l1)
        {
            mAddDuration = l1;
        }

        public final void b(t t1, boolean flag)
        {
            c(t1, flag);
        }

        public abstract boolean b();

        public abstract boolean b(t t1);

        public abstract void c();

        public void c(long l1)
        {
            mChangeDuration = l1;
        }

        public abstract void c(t t1);

        public void c(t t1, boolean flag)
        {
        }

        public long d()
        {
            return mMoveDuration;
        }

        public final void d(t t1)
        {
            k(t1);
            if (mListener != null)
            {
                mListener.a(t1);
            }
        }

        public void d(t t1, boolean flag)
        {
        }

        public long e()
        {
            return mAddDuration;
        }

        public final void e(t t1)
        {
            o(t1);
            if (mListener != null)
            {
                mListener.c(t1);
            }
        }

        public long f()
        {
            return mRemoveDuration;
        }

        public final void f(t t1)
        {
            m(t1);
            if (mListener != null)
            {
                mListener.b(t1);
            }
        }

        public long g()
        {
            return mChangeDuration;
        }

        public final void g(t t1)
        {
            j(t1);
        }

        public final void h(t t1)
        {
            n(t1);
        }

        public boolean h()
        {
            return mSupportsChangeAnimations;
        }

        public final void i()
        {
            int j1 = mFinishedListeners.size();
            for (int i1 = 0; i1 < j1; i1++)
            {
                ((a)mFinishedListeners.get(i1)).a();
            }

            mFinishedListeners.clear();
        }

        public final void i(t t1)
        {
            l(t1);
        }

        public void j(t t1)
        {
        }

        public void k(t t1)
        {
        }

        public void l(t t1)
        {
        }

        public void m(t t1)
        {
        }

        public void n(t t1)
        {
        }

        public void o(t t1)
        {
        }

        public d()
        {
            mListener = null;
            mFinishedListeners = new ArrayList();
            mAddDuration = 120L;
            mRemoveDuration = 120L;
            mMoveDuration = 250L;
            mChangeDuration = 250L;
            mSupportsChangeAnimations = true;
        }
    }

    public static interface d.a
    {

        public abstract void a();
    }

    static interface d.b
    {

        public abstract void a(t t1);

        public abstract void b(t t1);

        public abstract void c(t t1);

        public abstract void d(t t1);
    }

    private class e
        implements d.b
    {

        final RecyclerView a;

        public void a(t t1)
        {
            t1.a(true);
            if (!RecyclerView.e(a, t1.itemView) && t1.s())
            {
                a.removeDetachedView(t1.itemView, false);
            }
        }

        public void b(t t1)
        {
            t1.a(true);
            if (!t.b(t1))
            {
                RecyclerView.e(a, t1.itemView);
            }
        }

        public void c(t t1)
        {
            t1.a(true);
            if (!t.b(t1))
            {
                RecyclerView.e(a, t1.itemView);
            }
        }

        public void d(t t1)
        {
            t1.a(true);
            if (t1.mShadowedHolder != null && t1.mShadowingHolder == null)
            {
                t1.mShadowedHolder = null;
                t1.a(-65, t.c(t1));
            }
            t1.mShadowingHolder = null;
            if (!t.b(t1))
            {
                RecyclerView.e(a, t1.itemView);
            }
        }

        private e()
        {
            a = RecyclerView.this;
            super();
        }

    }

    public static abstract class f
    {

        public void a(Canvas canvas, RecyclerView recyclerview)
        {
        }

        public void a(Canvas canvas, RecyclerView recyclerview, q q1)
        {
            a(canvas, recyclerview);
        }

        public void a(Rect rect, int i1, RecyclerView recyclerview)
        {
            rect.set(0, 0, 0, 0);
        }

        public void a(Rect rect, View view, RecyclerView recyclerview, q q1)
        {
            a(rect, ((i)view.getLayoutParams()).e(), recyclerview);
        }

        public void b(Canvas canvas, RecyclerView recyclerview)
        {
        }

        public void b(Canvas canvas, RecyclerView recyclerview, q q1)
        {
            b(canvas, recyclerview);
        }

        public f()
        {
        }
    }

    private static class g
    {

        t a;
        int b;
        int c;
        int d;
        int e;

        g(t t1, int i1, int j1, int k1, int l1)
        {
            a = t1;
            b = i1;
            c = j1;
            d = k1;
            e = l1;
        }
    }

    public static abstract class h
    {

        android.support.v7.widget.q mChildHelper;
        RecyclerView mRecyclerView;
        private boolean mRequestedSimpleAnimations;
        p mSmoothScroller;

        public static int a(int i1, int j1, int k1, boolean flag)
        {
            int l1;
            int i2;
            i2 = 0x40000000;
            l1 = Math.max(0, i1 - j1);
            if (!flag) goto _L2; else goto _L1
_L1:
            if (k1 >= 0)
            {
                i1 = k1;
                j1 = i2;
            } else
            {
                j1 = 0;
                i1 = 0;
            }
_L4:
            return android.view.View.MeasureSpec.makeMeasureSpec(i1, j1);
_L2:
            j1 = i2;
            i1 = k1;
            if (k1 < 0)
            {
                if (k1 == -1)
                {
                    i1 = l1;
                    j1 = i2;
                } else
                if (k1 == -2)
                {
                    j1 = 0x80000000;
                    i1 = l1;
                } else
                {
                    j1 = 0;
                    i1 = 0;
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        private void a(int i1, View view)
        {
            mChildHelper.d(i1);
        }

        static void a(h h1, p p1)
        {
            h1.b(p1);
        }

        private void a(m m1, int i1, View view)
        {
            t t1 = RecyclerView.b(view);
            if (t1.c())
            {
                return;
            }
            if (t1.n() && !t1.r() && !t1.p() && !RecyclerView.f(mRecyclerView).b())
            {
                e(i1);
                m1.b(t1);
                return;
            } else
            {
                f(i1);
                m1.c(view);
                return;
            }
        }

        private void a(View view, int i1, boolean flag)
        {
            t t1;
            i j1;
            t1 = RecyclerView.b(view);
            if (flag || t1.r())
            {
                RecyclerView.c(mRecyclerView, view);
            } else
            {
                RecyclerView.d(mRecyclerView, view);
            }
            j1 = (i)view.getLayoutParams();
            if (!t1.k() && !t1.i()) goto _L2; else goto _L1
_L1:
            if (t1.i())
            {
                t1.j();
            } else
            {
                t1.l();
            }
            mChildHelper.a(view, i1, view.getLayoutParams(), false);
_L4:
            if (j1.d)
            {
                t1.itemView.invalidate();
                j1.d = false;
            }
            return;
_L2:
            if (view.getParent() == mRecyclerView)
            {
                int l1 = mChildHelper.b(view);
                int k1 = i1;
                if (i1 == -1)
                {
                    k1 = mChildHelper.b();
                }
                if (l1 == -1)
                {
                    throw new IllegalStateException((new StringBuilder()).append("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:").append(mRecyclerView.indexOfChild(view)).toString());
                }
                if (l1 != k1)
                {
                    RecyclerView.d(mRecyclerView).a(l1, k1);
                }
            } else
            {
                mChildHelper.a(view, i1, false);
                j1.c = true;
                if (mSmoothScroller != null && mSmoothScroller.c())
                {
                    mSmoothScroller.b(view);
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        static boolean a(h h1)
        {
            return h1.mRequestedSimpleAnimations;
        }

        static boolean a(h h1, boolean flag)
        {
            h1.mRequestedSimpleAnimations = flag;
            return flag;
        }

        private void b(p p1)
        {
            if (mSmoothScroller == p1)
            {
                mSmoothScroller = null;
            }
        }

        public int a(int i1, m m1, q q1)
        {
            return 0;
        }

        public int a(m m1, q q1)
        {
            while (mRecyclerView == null || RecyclerView.f(mRecyclerView) == null || !e()) 
            {
                return 1;
            }
            return RecyclerView.f(mRecyclerView).a();
        }

        public abstract i a();

        public i a(Context context, AttributeSet attributeset)
        {
            return new i(context, attributeset);
        }

        public i a(android.view.ViewGroup.LayoutParams layoutparams)
        {
            if (layoutparams instanceof i)
            {
                return new i((i)layoutparams);
            }
            if (layoutparams instanceof android.view.ViewGroup.MarginLayoutParams)
            {
                return new i((android.view.ViewGroup.MarginLayoutParams)layoutparams);
            } else
            {
                return new i(layoutparams);
            }
        }

        public View a(View view, int i1, m m1, q q1)
        {
            return null;
        }

        public void a(int i1, int j1)
        {
            View view = g(i1);
            if (view == null)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Cannot move a child from non-existing index:").append(i1).toString());
            } else
            {
                f(i1);
                c(view, j1);
                return;
            }
        }

        public void a(int i1, m m1)
        {
            View view = g(i1);
            e(i1);
            m1.a(view);
        }

        public void a(Parcelable parcelable)
        {
        }

        void a(android.support.v4.view.a.d d1)
        {
            a(mRecyclerView.mRecycler, mRecyclerView.mState, d1);
        }

        public void a(a a1, a a2)
        {
        }

        public void a(m m1)
        {
            for (int i1 = o() - 1; i1 >= 0; i1--)
            {
                a(m1, i1, g(i1));
            }

        }

        public void a(m m1, q q1, int i1, int j1)
        {
            RecyclerView.c(mRecyclerView, i1, j1);
        }

        public void a(m m1, q q1, android.support.v4.view.a.d d1)
        {
            d1.b(android/support/v7/widget/RecyclerView.getName());
            if (ai.b(mRecyclerView, -1) || ai.a(mRecyclerView, -1))
            {
                d1.a(8192);
                d1.i(true);
            }
            if (ai.b(mRecyclerView, 1) || ai.a(mRecyclerView, 1))
            {
                d1.a(4096);
                d1.i(true);
            }
            d1.b(android.support.v4.view.a.d.i.a(a(m1, q1), b(m1, q1), e(m1, q1), d(m1, q1)));
        }

        public void a(m m1, q q1, View view, android.support.v4.view.a.d d1)
        {
            int i1;
            int j1;
            if (e())
            {
                i1 = d(view);
            } else
            {
                i1 = 0;
            }
            if (d())
            {
                j1 = d(view);
            } else
            {
                j1 = 0;
            }
            d1.c(android.support.v4.view.a.d.j.a(i1, 1, j1, 1, false, false));
        }

        public void a(m m1, q q1, AccessibilityEvent accessibilityevent)
        {
            boolean flag1 = true;
            m1 = android.support.v4.view.a.a.a(accessibilityevent);
            if (mRecyclerView != null && m1 != null)
            {
                boolean flag = flag1;
                if (!ai.b(mRecyclerView, 1))
                {
                    flag = flag1;
                    if (!ai.b(mRecyclerView, -1))
                    {
                        flag = flag1;
                        if (!ai.a(mRecyclerView, -1))
                        {
                            if (ai.a(mRecyclerView, 1))
                            {
                                flag = flag1;
                            } else
                            {
                                flag = false;
                            }
                        }
                    }
                }
                m1.a(flag);
                if (RecyclerView.f(mRecyclerView) != null)
                {
                    m1.a(RecyclerView.f(mRecyclerView).a());
                    return;
                }
            }
        }

        public void a(p p1)
        {
            if (mSmoothScroller != null && p1 != mSmoothScroller && mSmoothScroller.c())
            {
                mSmoothScroller.a();
            }
            mSmoothScroller = p1;
            mSmoothScroller.a(mRecyclerView, this);
        }

        public void a(RecyclerView recyclerview)
        {
        }

        public void a(RecyclerView recyclerview, int i1, int j1)
        {
        }

        public void a(RecyclerView recyclerview, int i1, int j1, int k1)
        {
        }

        public void a(RecyclerView recyclerview, m m1)
        {
            d(recyclerview);
        }

        public void a(View view)
        {
            a(view, -1);
        }

        public void a(View view, int i1)
        {
            a(view, i1, true);
        }

        public void a(View view, int i1, int j1)
        {
            i k1 = (i)view.getLayoutParams();
            Rect rect = mRecyclerView.h(view);
            int l1 = rect.left;
            int i2 = rect.right;
            int j2 = rect.top;
            int k2 = rect.bottom;
            view.measure(a(p(), l1 + i2 + i1 + (r() + t() + k1.leftMargin + k1.rightMargin), k1.width, d()), a(q(), k2 + j2 + j1 + (s() + u() + k1.topMargin + k1.bottomMargin), k1.height, e()));
        }

        public void a(View view, int i1, int j1, int k1, int l1)
        {
            Rect rect = ((i)view.getLayoutParams()).b;
            view.layout(rect.left + i1, rect.top + j1, k1 - rect.right, l1 - rect.bottom);
        }

        public void a(View view, int i1, i j1)
        {
            t t1 = RecyclerView.b(view);
            if (t1.r())
            {
                RecyclerView.c(mRecyclerView, view);
            } else
            {
                RecyclerView.d(mRecyclerView, view);
            }
            mChildHelper.a(view, i1, j1, t1.r());
        }

        public void a(View view, Rect rect)
        {
            if (mRecyclerView == null)
            {
                rect.set(0, 0, 0, 0);
                return;
            } else
            {
                rect.set(mRecyclerView.h(view));
                return;
            }
        }

        void a(View view, android.support.v4.view.a.d d1)
        {
            t t1 = RecyclerView.b(view);
            if (t1 != null && !t1.r())
            {
                a(mRecyclerView.mRecycler, mRecyclerView.mState, view, d1);
            }
        }

        public void a(View view, m m1)
        {
            c(view);
            m1.a(view);
        }

        public void a(AccessibilityEvent accessibilityevent)
        {
            a(mRecyclerView.mRecycler, mRecyclerView.mState, accessibilityevent);
        }

        public void a(String s1)
        {
            if (mRecyclerView != null)
            {
                mRecyclerView.a(s1);
            }
        }

        boolean a(int i1, Bundle bundle)
        {
            return a(mRecyclerView.mRecycler, mRecyclerView.mState, i1, bundle);
        }

        public boolean a(i i1)
        {
            return i1 != null;
        }

        public boolean a(m m1, q q1, int i1, Bundle bundle)
        {
            if (mRecyclerView != null) goto _L2; else goto _L1
_L1:
            return false;
_L2:
            i1;
            JVM INSTR lookupswitch 2: default 36
        //                       4096: 129
        //                       8192: 62;
               goto _L3 _L4 _L5
_L3:
            int j1;
            i1 = 0;
            j1 = 0;
_L8:
            if (j1 != 0 || i1 != 0)
            {
                mRecyclerView.scrollBy(i1, j1);
                return true;
            }
              goto _L1
_L5:
            int k1;
            int l1;
            int i2;
            if (ai.b(mRecyclerView, -1))
            {
                i1 = -(q() - s() - u());
            } else
            {
                i1 = 0;
            }
            j1 = i1;
            if (!ai.a(mRecyclerView, -1)) goto _L7; else goto _L6
_L6:
            k1 = -(p() - r() - t());
            j1 = i1;
            i1 = k1;
              goto _L8
_L4:
            if (ai.b(mRecyclerView, 1))
            {
                i1 = q() - s() - u();
            } else
            {
                i1 = 0;
            }
            j1 = i1;
            if (!ai.a(mRecyclerView, 1)) goto _L7; else goto _L9
_L9:
            k1 = p();
            l1 = r();
            i2 = t();
            j1 = i1;
            i1 = k1 - l1 - i2;
              goto _L8
_L7:
            i1 = 0;
              goto _L8
        }

        public boolean a(m m1, q q1, View view, int i1, Bundle bundle)
        {
            return false;
        }

        public boolean a(RecyclerView recyclerview, q q1, View view, View view1)
        {
            return a(recyclerview, view, view1);
        }

        public boolean a(RecyclerView recyclerview, View view, Rect rect, boolean flag)
        {
            int j1 = r();
            int l1 = s();
            int k1 = p();
            int l2 = t();
            int i1 = q();
            int i2 = u();
            int i3 = view.getLeft() + rect.left;
            int j2 = view.getTop() + rect.top;
            int j3 = rect.width();
            int k2 = rect.height();
            j1 = Math.min(0, i3 - j1);
            l1 = Math.min(0, j2 - l1);
            k1 = Math.max(0, (j3 + i3) - (k1 - l2));
            i2 = Math.max(0, (k2 + j2) - (i1 - i2));
            if (ai.h(recyclerview) == 1)
            {
                if (k1 != 0)
                {
                    i1 = k1;
                } else
                {
                    i1 = j1;
                }
            } else
            {
                i1 = j1;
                if (j1 == 0)
                {
                    i1 = k1;
                }
            }
            if (l1 != 0)
            {
                j1 = l1;
            } else
            {
                j1 = i2;
            }
            if (i1 != 0 || j1 != 0)
            {
                if (flag)
                {
                    recyclerview.scrollBy(i1, j1);
                } else
                {
                    recyclerview.b(i1, j1);
                }
                return true;
            } else
            {
                return false;
            }
        }

        public boolean a(RecyclerView recyclerview, View view, View view1)
        {
            return m() || RecyclerView.s(recyclerview);
        }

        public boolean a(RecyclerView recyclerview, ArrayList arraylist, int i1, int j1)
        {
            return false;
        }

        boolean a(View view, int i1, Bundle bundle)
        {
            return a(mRecyclerView.mRecycler, mRecyclerView.mState, view, i1, bundle);
        }

        public int b(int i1, m m1, q q1)
        {
            return 0;
        }

        public int b(m m1, q q1)
        {
            while (mRecyclerView == null || RecyclerView.f(mRecyclerView) == null || !d()) 
            {
                return 1;
            }
            return RecyclerView.f(mRecyclerView).a();
        }

        public int b(q q1)
        {
            return 0;
        }

        void b(m m1)
        {
            int j1 = m1.d();
            int i1 = 0;
            while (i1 < j1) 
            {
                View view = m1.e(i1);
                t t1 = RecyclerView.b(view);
                if (!t1.c())
                {
                    if (t1.s())
                    {
                        mRecyclerView.removeDetachedView(view, false);
                    }
                    m1.b(view);
                }
                i1++;
            }
            m1.e();
            if (j1 > 0)
            {
                mRecyclerView.invalidate();
            }
        }

        void b(RecyclerView recyclerview)
        {
            if (recyclerview == null)
            {
                mRecyclerView = null;
                mChildHelper = null;
                return;
            } else
            {
                mRecyclerView = recyclerview;
                mChildHelper = recyclerview.mChildHelper;
                return;
            }
        }

        public void b(RecyclerView recyclerview, int i1, int j1)
        {
        }

        public void b(View view)
        {
            b(view, -1);
        }

        public void b(View view, int i1)
        {
            a(view, i1, false);
        }

        public boolean b()
        {
            return false;
        }

        public int c(q q1)
        {
            return 0;
        }

        public Parcelable c()
        {
            return null;
        }

        public View c(int i1)
        {
            int j1;
            int k1;
            k1 = o();
            j1 = 0;
_L3:
            View view;
            t t1;
            if (j1 >= k1)
            {
                break; /* Loop/switch isn't completed */
            }
            view = g(j1);
            t1 = RecyclerView.b(view);
              goto _L1
_L5:
            j1++;
            if (true) goto _L3; else goto _L2
_L1:
            if (t1 == null || t1.e() != i1 || t1.c() || !mRecyclerView.mState.a() && t1.r()) goto _L5; else goto _L4
_L4:
            return view;
_L2:
            return null;
        }

        public void c(m m1)
        {
            for (int i1 = o() - 1; i1 >= 0; i1--)
            {
                if (!RecyclerView.b(g(i1)).c())
                {
                    a(i1, m1);
                }
            }

        }

        public void c(m m1, q q1)
        {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public void c(RecyclerView recyclerview)
        {
        }

        public void c(RecyclerView recyclerview, int i1, int j1)
        {
        }

        public void c(View view)
        {
            mChildHelper.a(view);
        }

        public void c(View view, int i1)
        {
            a(view, i1, (i)view.getLayoutParams());
        }

        public int d(m m1, q q1)
        {
            return 0;
        }

        public int d(q q1)
        {
            return 0;
        }

        public int d(View view)
        {
            return ((i)view.getLayoutParams()).e();
        }

        public View d(View view, int i1)
        {
            return null;
        }

        public void d(int i1)
        {
        }

        public void d(RecyclerView recyclerview)
        {
        }

        public boolean d()
        {
            return false;
        }

        public int e(q q1)
        {
            return 0;
        }

        public int e(View view)
        {
            Rect rect = ((i)view.getLayoutParams()).b;
            int i1 = view.getMeasuredWidth();
            int j1 = rect.left;
            return rect.right + (i1 + j1);
        }

        public void e(int i1)
        {
            if (g(i1) != null)
            {
                mChildHelper.a(i1);
            }
        }

        public boolean e()
        {
            return false;
        }

        public boolean e(m m1, q q1)
        {
            return false;
        }

        public int f(q q1)
        {
            return 0;
        }

        public int f(View view)
        {
            Rect rect = ((i)view.getLayoutParams()).b;
            int i1 = view.getMeasuredHeight();
            int j1 = rect.top;
            return rect.bottom + (i1 + j1);
        }

        public void f(int i1)
        {
            a(i1, g(i1));
        }

        public int g(q q1)
        {
            return 0;
        }

        public int g(View view)
        {
            return view.getLeft() - m(view);
        }

        public View g(int i1)
        {
            if (mChildHelper != null)
            {
                return mChildHelper.b(i1);
            } else
            {
                return null;
            }
        }

        public int h(View view)
        {
            return view.getTop() - k(view);
        }

        public void h(int i1)
        {
            if (mRecyclerView != null)
            {
                mRecyclerView.c(i1);
            }
        }

        public int i(View view)
        {
            return view.getRight() + n(view);
        }

        public void i(int i1)
        {
            if (mRecyclerView != null)
            {
                mRecyclerView.b(i1);
            }
        }

        public int j(View view)
        {
            return view.getBottom() + l(view);
        }

        public void j(int i1)
        {
        }

        public int k(View view)
        {
            return ((i)view.getLayoutParams()).b.top;
        }

        public void k()
        {
            if (mRecyclerView != null)
            {
                mRecyclerView.requestLayout();
            }
        }

        public int l(View view)
        {
            return ((i)view.getLayoutParams()).b.bottom;
        }

        public boolean l()
        {
            return mRecyclerView != null && RecyclerView.r(mRecyclerView);
        }

        public int m(View view)
        {
            return ((i)view.getLayoutParams()).b.left;
        }

        public boolean m()
        {
            return mSmoothScroller != null && mSmoothScroller.c();
        }

        public int n()
        {
            return ai.h(mRecyclerView);
        }

        public int n(View view)
        {
            return ((i)view.getLayoutParams()).b.right;
        }

        public int o()
        {
            if (mChildHelper != null)
            {
                return mChildHelper.b();
            } else
            {
                return 0;
            }
        }

        public int p()
        {
            if (mRecyclerView != null)
            {
                return mRecyclerView.getWidth();
            } else
            {
                return 0;
            }
        }

        public int q()
        {
            if (mRecyclerView != null)
            {
                return mRecyclerView.getHeight();
            } else
            {
                return 0;
            }
        }

        public int r()
        {
            if (mRecyclerView != null)
            {
                return mRecyclerView.getPaddingLeft();
            } else
            {
                return 0;
            }
        }

        public int s()
        {
            if (mRecyclerView != null)
            {
                return mRecyclerView.getPaddingTop();
            } else
            {
                return 0;
            }
        }

        public int t()
        {
            if (mRecyclerView != null)
            {
                return mRecyclerView.getPaddingRight();
            } else
            {
                return 0;
            }
        }

        public int u()
        {
            if (mRecyclerView != null)
            {
                return mRecyclerView.getPaddingBottom();
            } else
            {
                return 0;
            }
        }

        public View v()
        {
            View view;
            if (mRecyclerView != null)
            {
                if ((view = mRecyclerView.getFocusedChild()) != null && !mChildHelper.c(view))
                {
                    return view;
                }
            }
            return null;
        }

        public int w()
        {
            a a1;
            if (mRecyclerView != null)
            {
                a1 = mRecyclerView.getAdapter();
            } else
            {
                a1 = null;
            }
            if (a1 != null)
            {
                return a1.a();
            } else
            {
                return 0;
            }
        }

        void x()
        {
            if (mSmoothScroller != null)
            {
                mSmoothScroller.a();
            }
        }

        public void y()
        {
            mRequestedSimpleAnimations = true;
        }

        public h()
        {
            mRequestedSimpleAnimations = false;
        }
    }

    public static class i extends android.view.ViewGroup.MarginLayoutParams
    {

        t a;
        final Rect b;
        boolean c;
        boolean d;

        public boolean c()
        {
            return a.r();
        }

        public boolean d()
        {
            return a.p();
        }

        public int e()
        {
            return a.e();
        }

        public i(int i1, int j1)
        {
            super(i1, j1);
            b = new Rect();
            c = true;
            d = false;
        }

        public i(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
            b = new Rect();
            c = true;
            d = false;
        }

        public i(i i1)
        {
            super(i1);
            b = new Rect();
            c = true;
            d = false;
        }

        public i(android.view.ViewGroup.LayoutParams layoutparams)
        {
            super(layoutparams);
            b = new Rect();
            c = true;
            d = false;
        }

        public i(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
        {
            super(marginlayoutparams);
            b = new Rect();
            c = true;
            d = false;
        }
    }

    public static interface j
    {

        public abstract boolean a(RecyclerView recyclerview, MotionEvent motionevent);

        public abstract void b(RecyclerView recyclerview, MotionEvent motionevent);
    }

    public static abstract class k
    {

        public void a(RecyclerView recyclerview, int i1)
        {
        }

        public void a(RecyclerView recyclerview, int i1, int j1)
        {
        }

        public k()
        {
        }
    }

    public static class l
    {

        private SparseArray a;
        private SparseIntArray b;
        private int c;

        private ArrayList b(int i1)
        {
            ArrayList arraylist1 = (ArrayList)a.get(i1);
            ArrayList arraylist = arraylist1;
            if (arraylist1 == null)
            {
                ArrayList arraylist2 = new ArrayList();
                a.put(i1, arraylist2);
                arraylist = arraylist2;
                if (b.indexOfKey(i1) < 0)
                {
                    b.put(i1, 5);
                    arraylist = arraylist2;
                }
            }
            return arraylist;
        }

        public t a(int i1)
        {
            ArrayList arraylist = (ArrayList)a.get(i1);
            if (arraylist != null && !arraylist.isEmpty())
            {
                i1 = arraylist.size() - 1;
                t t1 = (t)arraylist.get(i1);
                arraylist.remove(i1);
                return t1;
            } else
            {
                return null;
            }
        }

        public void a()
        {
            a.clear();
        }

        void a(a a1)
        {
            c = c + 1;
        }

        void a(a a1, a a2, boolean flag)
        {
            if (a1 != null)
            {
                b();
            }
            if (!flag && c == 0)
            {
                a();
            }
            if (a2 != null)
            {
                a(a2);
            }
        }

        public void a(t t1)
        {
            int i1 = t1.h();
            ArrayList arraylist = b(i1);
            if (b.get(i1) <= arraylist.size())
            {
                return;
            } else
            {
                t1.u();
                arraylist.add(t1);
                return;
            }
        }

        void b()
        {
            c = c - 1;
        }

        public l()
        {
            a = new SparseArray();
            b = new SparseIntArray();
            c = 0;
        }
    }

    public final class m
    {

        final ArrayList a = new ArrayList();
        final ArrayList b = new ArrayList();
        final RecyclerView c;
        private ArrayList d;
        private final List e;
        private int f;
        private l g;
        private r h;

        static ArrayList a(m m1)
        {
            return m1.d;
        }

        private void a(ViewGroup viewgroup, boolean flag)
        {
            for (int i1 = viewgroup.getChildCount() - 1; i1 >= 0; i1--)
            {
                View view = viewgroup.getChildAt(i1);
                if (view instanceof ViewGroup)
                {
                    a((ViewGroup)view, true);
                }
            }

            if (!flag)
            {
                return;
            }
            if (viewgroup.getVisibility() == 4)
            {
                viewgroup.setVisibility(0);
                viewgroup.setVisibility(4);
                return;
            } else
            {
                int j1 = viewgroup.getVisibility();
                viewgroup.setVisibility(4);
                viewgroup.setVisibility(j1);
                return;
            }
        }

        private void d(View view)
        {
            if (RecyclerView.o(c) != null && RecyclerView.o(c).isEnabled())
            {
                if (ai.e(view) == 0)
                {
                    ai.c(view, 1);
                }
                if (!ai.b(view))
                {
                    ai.a(view, RecyclerView.p(c).a());
                }
            }
        }

        private void f(t t1)
        {
            if (t1.itemView instanceof ViewGroup)
            {
                a((ViewGroup)t1.itemView, false);
            }
        }

        t a(int i1, int j1, boolean flag)
        {
            int k1;
            boolean flag1;
            int l1;
            flag1 = false;
            l1 = a.size();
            k1 = 0;
_L10:
            if (k1 >= l1) goto _L2; else goto _L1
_L1:
            Object obj = (t)a.get(k1);
            if (((t) (obj)).k() || ((t) (obj)).e() != i1 || ((t) (obj)).n() || !q.d(c.mState) && ((t) (obj)).r()) goto _L4; else goto _L3
_L3:
            if (j1 == -1 || ((t) (obj)).h() == j1) goto _L6; else goto _L5
_L5:
            Log.e("RecyclerView", (new StringBuilder()).append("Scrap view for position ").append(i1).append(" isn't dirty but has").append(" wrong view type! (found ").append(((t) (obj)).h()).append(" but expected ").append(j1).append(")").toString());
_L2:
            if (!flag)
            {
                obj = c.mChildHelper.a(i1, j1);
                if (obj != null)
                {
                    c.mItemAnimator.c(c.a(((View) (obj))));
                }
            }
            k1 = b.size();
            j1 = ((flag1) ? 1 : 0);
_L8:
            if (j1 >= k1)
            {
                break; /* Loop/switch isn't completed */
            }
            obj = (t)b.get(j1);
            if (!((t) (obj)).n() && ((t) (obj)).e() == i1)
            {
                if (!flag)
                {
                    b.remove(j1);
                }
                return ((t) (obj));
            }
            j1++;
            continue; /* Loop/switch isn't completed */
_L6:
            ((t) (obj)).b(32);
            return ((t) (obj));
_L4:
            k1++;
            continue; /* Loop/switch isn't completed */
            if (true) goto _L8; else goto _L7
_L7:
            return null;
            if (true) goto _L10; else goto _L9
_L9:
        }

        t a(long l1, int i1, boolean flag)
        {
            int j1 = a.size() - 1;
_L5:
            if (j1 < 0) goto _L2; else goto _L1
_L1:
            t t2;
            t2 = (t)a.get(j1);
            if (t2.g() != l1 || t2.k())
            {
                continue; /* Loop/switch isn't completed */
            }
            if (i1 != t2.h()) goto _L4; else goto _L3
_L3:
            t t1;
            t2.b(32);
            t1 = t2;
            if (t2.r())
            {
                t1 = t2;
                if (!c.mState.a())
                {
                    t2.a(2, 14);
                    t1 = t2;
                }
            }
_L8:
            return t1;
_L4:
            if (!flag)
            {
                a.remove(j1);
                c.removeDetachedView(t2.itemView, false);
                b(t2.itemView);
            }
            j1--;
              goto _L5
_L2:
            j1 = b.size() - 1;
_L9:
            if (j1 < 0) goto _L7; else goto _L6
_L6:
label0:
            {
                t t3 = (t)b.get(j1);
                if (t3.g() != l1)
                {
                    continue; /* Loop/switch isn't completed */
                }
                if (i1 != t3.h())
                {
                    break label0;
                }
                t1 = t3;
                if (!flag)
                {
                    b.remove(j1);
                    return t3;
                }
            }
              goto _L8
            if (!flag)
            {
                d(j1);
            }
            j1--;
              goto _L9
_L7:
            return null;
              goto _L8
        }

        View a(int i1, boolean flag)
        {
            boolean flag1 = true;
            if (i1 < 0 || i1 >= c.mState.e())
            {
                throw new IndexOutOfBoundsException((new StringBuilder()).append("Invalid item position ").append(i1).append("(").append(i1).append("). Item count:").append(c.mState.e()).toString());
            }
            Object obj;
            Object obj1;
            Object obj2;
            int j1;
            int k1;
            int l1;
            int i2;
            if (c.mState.a())
            {
                obj1 = f(i1);
                if (obj1 != null)
                {
                    j1 = 1;
                } else
                {
                    j1 = 0;
                }
            } else
            {
                obj1 = null;
                j1 = 0;
            }
            obj = obj1;
            if (obj1 != null) goto _L2; else goto _L1
_L1:
            obj1 = a(i1, -1, flag);
            obj = obj1;
            if (obj1 == null) goto _L2; else goto _L3
_L3:
            if (a(((t) (obj1)))) goto _L5; else goto _L4
_L4:
            if (flag) goto _L7; else goto _L6
_L6:
            ((t) (obj1)).b(4);
            if (!((t) (obj1)).i()) goto _L9; else goto _L8
_L8:
            c.removeDetachedView(((t) (obj1)).itemView, false);
            ((t) (obj1)).j();
_L17:
            b(((t) (obj1)));
_L7:
            obj = null;
_L2:
            obj2 = obj;
            l1 = j1;
            if (obj != null) goto _L11; else goto _L10
_L10:
            i2 = c.mAdapterHelper.a(i1);
            if (i2 < 0 || i2 >= RecyclerView.f(c).a())
            {
                throw new IndexOutOfBoundsException((new StringBuilder()).append("Inconsistency detected. Invalid item position ").append(i1).append("(offset:").append(i2).append(").").append("state:").append(c.mState.e()).toString());
            }
            l1 = RecyclerView.f(c).a(i2);
            obj1 = obj;
            k1 = j1;
            if (RecyclerView.f(c).b())
            {
                obj = a(RecyclerView.f(c).b(i2), l1, flag);
                obj1 = obj;
                k1 = j1;
                if (obj != null)
                {
                    obj.mPosition = i2;
                    k1 = 1;
                    obj1 = obj;
                }
            }
            obj = obj1;
            if (obj1 == null)
            {
                obj = obj1;
                if (h != null)
                {
                    obj2 = h.a(this, i1, l1);
                    obj = obj1;
                    if (obj2 != null)
                    {
                        obj1 = c.a(((View) (obj2)));
                        if (obj1 == null)
                        {
                            throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                        }
                        obj = obj1;
                        if (((t) (obj1)).c())
                        {
                            throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                        }
                    }
                }
            }
            obj1 = obj;
            if (obj == null)
            {
                obj = f().a(RecyclerView.f(c).a(i2));
                obj1 = obj;
                if (obj != null)
                {
                    ((t) (obj)).u();
                    obj1 = obj;
                    if (RecyclerView.q())
                    {
                        f(((t) (obj)));
                        obj1 = obj;
                    }
                }
            }
            obj2 = obj1;
            l1 = k1;
              goto _L12
_L9:
            if (((t) (obj1)).k())
            {
                ((t) (obj1)).l();
            }
            continue; /* Loop/switch isn't completed */
_L5:
            j1 = 1;
            obj = obj1;
              goto _L2
_L12:
            if (obj1 != null) goto _L11; else goto _L13
_L13:
            obj1 = RecyclerView.f(c).b(c, RecyclerView.f(c).a(i2));
            j1 = k1;
_L15:
            if (c.mState.a() && ((t) (obj1)).q())
            {
                obj1.mPreLayoutPosition = i1;
                i1 = 0;
            } else
            if (!((t) (obj1)).q() || ((t) (obj1)).o() || ((t) (obj1)).n())
            {
                k1 = c.mAdapterHelper.a(i1);
                RecyclerView.f(c).b(((t) (obj1)), k1);
                d(((t) (obj1)).itemView);
                if (c.mState.a())
                {
                    obj1.mPreLayoutPosition = i1;
                }
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            obj = ((t) (obj1)).itemView.getLayoutParams();
            if (obj == null)
            {
                obj = (i)c.generateDefaultLayoutParams();
                ((t) (obj1)).itemView.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            } else
            if (!c.checkLayoutParams(((android.view.ViewGroup.LayoutParams) (obj))))
            {
                obj = (i)c.generateLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
                ((t) (obj1)).itemView.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            } else
            {
                obj = (i)obj;
            }
            obj.a = ((t) (obj1));
            if (j1 != 0 && i1 != 0)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            obj.d = flag;
            return ((t) (obj1)).itemView;
_L11:
            j1 = l1;
            obj1 = obj2;
            if (true) goto _L15; else goto _L14
_L14:
            if (true) goto _L17; else goto _L16
_L16:
        }

        public void a()
        {
            a.clear();
            c();
        }

        public void a(int i1)
        {
            f = i1;
            for (int j1 = b.size() - 1; j1 >= 0 && b.size() > i1; j1--)
            {
                d(j1);
            }

        }

        void a(int i1, int j1)
        {
            byte byte0;
            int k1;
            int l1;
            int i2;
            int j2;
            if (i1 < j1)
            {
                byte0 = -1;
                k1 = j1;
                l1 = i1;
            } else
            {
                byte0 = 1;
                k1 = i1;
                l1 = j1;
            }
            j2 = b.size();
            i2 = 0;
            while (i2 < j2) 
            {
                t t1 = (t)b.get(i2);
                if (t1 != null && t1.mPosition >= l1 && t1.mPosition <= k1)
                {
                    if (t1.mPosition == i1)
                    {
                        t1.a(j1 - i1, false);
                    } else
                    {
                        t1.a(byte0, false);
                    }
                }
                i2++;
            }
        }

        void a(a a1, a a2, boolean flag)
        {
            a();
            f().a(a1, a2, flag);
        }

        void a(l l1)
        {
            if (g != null)
            {
                g.b();
            }
            g = l1;
            if (l1 != null)
            {
                g.a(c.getAdapter());
            }
        }

        void a(r r1)
        {
            h = r1;
        }

        public void a(View view)
        {
            t t1;
            t1 = RecyclerView.b(view);
            if (t1.s())
            {
                c.removeDetachedView(view, false);
            }
            if (!t1.i()) goto _L2; else goto _L1
_L1:
            t1.j();
_L4:
            b(t1);
            return;
_L2:
            if (t1.k())
            {
                t1.l();
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        boolean a(t t1)
        {
            if (!t1.r())
            {
                if (t1.mPosition < 0 || t1.mPosition >= RecyclerView.f(c).a())
                {
                    throw new IndexOutOfBoundsException((new StringBuilder()).append("Inconsistency detected. Invalid view holder adapter position").append(t1).toString());
                }
                if (!c.mState.a() && RecyclerView.f(c).a(t1.mPosition) != t1.h())
                {
                    return false;
                }
                if (RecyclerView.f(c).b() && t1.g() != RecyclerView.f(c).b(t1.mPosition))
                {
                    return false;
                }
            }
            return true;
        }

        public int b(int i1)
        {
            if (i1 < 0 || i1 >= c.mState.e())
            {
                throw new IndexOutOfBoundsException((new StringBuilder()).append("invalid position ").append(i1).append(". State ").append("item count is ").append(c.mState.e()).toString());
            }
            if (!c.mState.a())
            {
                return i1;
            } else
            {
                return c.mAdapterHelper.a(i1);
            }
        }

        public List b()
        {
            return e;
        }

        void b(int i1, int j1)
        {
            int l1 = b.size();
            for (int k1 = 0; k1 < l1; k1++)
            {
                t t1 = (t)b.get(k1);
                if (t1 != null && t1.e() >= i1)
                {
                    t1.a(j1, true);
                }
            }

        }

        void b(int i1, int j1, boolean flag)
        {
            int k1 = b.size() - 1;
            while (k1 >= 0) 
            {
                t t1 = (t)b.get(k1);
                if (t1 != null)
                {
                    if (t1.e() >= i1 + j1)
                    {
                        t1.a(-j1, flag);
                    } else
                    if (t1.e() >= i1)
                    {
                        d(k1);
                    }
                }
                k1--;
            }
        }

        void b(t t1)
        {
label0:
            {
label1:
                {
                    boolean flag2 = true;
                    boolean flag1 = false;
                    if (t1.i() || t1.itemView.getParent() != null)
                    {
                        StringBuilder stringbuilder = (new StringBuilder()).append("Scrapped or attached views may not be recycled. isScrap:").append(t1.i()).append(" isAttached:");
                        if (t1.itemView.getParent() == null)
                        {
                            flag2 = false;
                        }
                        throw new IllegalArgumentException(stringbuilder.append(flag2).toString());
                    }
                    if (t1.s())
                    {
                        throw new IllegalArgumentException((new StringBuilder()).append("Tmp detached view should be removed from RecyclerView before it can be recycled: ").append(t1).toString());
                    }
                    if (t1.c())
                    {
                        throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
                    }
                    boolean flag;
                    if (RecyclerView.f(c) != null && android.support.v7.widget.t.a(t1) && RecyclerView.f(c).b(t1))
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (!flag && !t1.v())
                    {
                        break label0;
                    }
                    flag = flag1;
                    if (t1.n())
                    {
                        break label1;
                    }
                    if (!q.d(c.mState))
                    {
                        flag = flag1;
                        if (t1.r())
                        {
                            break label1;
                        }
                    }
                    flag = flag1;
                    if (!t1.p())
                    {
                        int i1 = b.size();
                        if (i1 == f && i1 > 0)
                        {
                            d(0);
                        }
                        flag = flag1;
                        if (i1 < f)
                        {
                            b.add(t1);
                            flag = true;
                        }
                    }
                }
                if (!flag)
                {
                    c(t1);
                }
            }
            c.mState.a(t1);
        }

        void b(View view)
        {
            view = RecyclerView.b(view);
            android.support.v7.widget.t.a(view, null);
            view.l();
            b(((t) (view)));
        }

        public View c(int i1)
        {
            return a(i1, false);
        }

        void c()
        {
            for (int i1 = b.size() - 1; i1 >= 0; i1--)
            {
                d(i1);
            }

            b.clear();
        }

        void c(int i1, int j1)
        {
            int l1 = b.size();
            int k1 = 0;
            while (k1 < l1) 
            {
                t t1 = (t)b.get(k1);
                if (t1 != null)
                {
                    int i2 = t1.e();
                    if (i2 >= i1 && i2 < i1 + j1)
                    {
                        t1.b(2);
                    }
                }
                k1++;
            }
        }

        void c(t t1)
        {
            ai.a(t1.itemView, null);
            f().a(t1);
            e(t1);
        }

        void c(View view)
        {
            view = RecyclerView.b(view);
            view.a(this);
            if (!view.p() || !android.support.v7.widget.RecyclerView.g(c))
            {
                if (view.n() && !view.r() && !RecyclerView.f(c).b())
                {
                    throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
                } else
                {
                    a.add(view);
                    return;
                }
            }
            if (d == null)
            {
                d = new ArrayList();
            }
            d.add(view);
        }

        int d()
        {
            return a.size();
        }

        void d(int i1)
        {
            c((t)b.get(i1));
            b.remove(i1);
        }

        void d(t t1)
        {
            if (!t1.p() || !android.support.v7.widget.RecyclerView.g(c) || d == null)
            {
                a.remove(t1);
            } else
            {
                d.remove(t1);
            }
            android.support.v7.widget.t.a(t1, null);
            t1.l();
        }

        View e(int i1)
        {
            return ((t)a.get(i1)).itemView;
        }

        void e()
        {
            a.clear();
        }

        void e(t t1)
        {
            if (RecyclerView.q(c) != null)
            {
                RecyclerView.q(c).a(t1);
            }
            if (RecyclerView.f(c) != null)
            {
                RecyclerView.f(c).a(t1);
            }
            if (c.mState != null)
            {
                c.mState.a(t1);
            }
        }

        l f()
        {
            if (g == null)
            {
                g = new l();
            }
            return g;
        }

        t f(int i1)
        {
            boolean flag;
            int k1;
label0:
            {
                flag = false;
                if (d != null)
                {
                    k1 = d.size();
                    if (k1 != 0)
                    {
                        break label0;
                    }
                }
                return null;
            }
            for (int j1 = 0; j1 < k1; j1++)
            {
                t t1 = (t)d.get(j1);
                if (!t1.k() && t1.e() == i1)
                {
                    t1.b(32);
                    return t1;
                }
            }

            if (RecyclerView.f(c).b())
            {
                i1 = c.mAdapterHelper.a(i1);
                if (i1 > 0 && i1 < RecyclerView.f(c).a())
                {
                    long l1 = RecyclerView.f(c).b(i1);
                    for (i1 = ((flag) ? 1 : 0); i1 < k1; i1++)
                    {
                        t t2 = (t)d.get(i1);
                        if (!t2.k() && t2.g() == l1)
                        {
                            t2.b(32);
                            return t2;
                        }
                    }

                }
            }
            return null;
        }

        void g()
        {
            int j1 = b.size();
            for (int i1 = 0; i1 < j1; i1++)
            {
                t t1 = (t)b.get(i1);
                if (t1 != null)
                {
                    t1.b(512);
                }
            }

        }

        void h()
        {
            if (RecyclerView.f(c) != null && RecyclerView.f(c).b())
            {
                int j1 = b.size();
                for (int i1 = 0; i1 < j1; i1++)
                {
                    t t1 = (t)b.get(i1);
                    if (t1 != null)
                    {
                        t1.b(6);
                    }
                }

            } else
            {
                c();
            }
        }

        void i()
        {
            boolean flag = false;
            int l1 = b.size();
            for (int i1 = 0; i1 < l1; i1++)
            {
                ((t)b.get(i1)).a();
            }

            l1 = a.size();
            for (int j1 = 0; j1 < l1; j1++)
            {
                ((t)a.get(j1)).a();
            }

            if (d != null)
            {
                int i2 = d.size();
                for (int k1 = ((flag) ? 1 : 0); k1 < i2; k1++)
                {
                    ((t)d.get(k1)).a();
                }

            }
        }

        void j()
        {
            int k1 = b.size();
            for (int j1 = 0; j1 < k1; j1++)
            {
                i i1 = (i)((t)b.get(j1)).itemView.getLayoutParams();
                if (i1 != null)
                {
                    i1.c = true;
                }
            }

        }

        public m()
        {
            c = RecyclerView.this;
            super();
            d = null;
            e = Collections.unmodifiableList(a);
            f = 2;
        }
    }

    public static interface n
    {

        public abstract void a(t t1);
    }

    private class o extends c
    {

        final RecyclerView a;

        public void a()
        {
            a.a(null);
            if (RecyclerView.f(a).b())
            {
                android.support.v7.widget.q.a(a.mState, true);
                RecyclerView.j(a);
            } else
            {
                android.support.v7.widget.q.a(a.mState, true);
                RecyclerView.j(a);
            }
            if (!a.mAdapterHelper.d())
            {
                a.requestLayout();
            }
        }

        public void a(int i1, int j1)
        {
            a.a(null);
            if (a.mAdapterHelper.b(i1, j1))
            {
                b();
            }
        }

        public void a(int i1, int j1, int k1)
        {
            a.a(null);
            if (a.mAdapterHelper.a(i1, j1, k1))
            {
                b();
            }
        }

        void b()
        {
            if (RecyclerView.k(a) && RecyclerView.l(a) && RecyclerView.m(a))
            {
                ai.a(a, RecyclerView.n(a));
                return;
            } else
            {
                RecyclerView.c(a, true);
                a.requestLayout();
                return;
            }
        }

        public void b(int i1, int j1)
        {
            a.a(null);
            if (a.mAdapterHelper.c(i1, j1))
            {
                b();
            }
        }

        public void c(int i1, int j1)
        {
            a.a(null);
            if (a.mAdapterHelper.d(i1, j1))
            {
                b();
            }
        }

        private o()
        {
            a = RecyclerView.this;
            super();
        }

    }

    public static abstract class p
    {

        private h mLayoutManager;
        private boolean mPendingInitialRun;
        private RecyclerView mRecyclerView;
        private final a mRecyclingAction = new a(0, 0);
        private boolean mRunning;
        private int mTargetPosition;
        private View mTargetView;

        private void a(int i1, int j1)
        {
            if (!mRunning || mTargetPosition == -1)
            {
                a();
            }
            mPendingInitialRun = false;
            if (mTargetView != null)
            {
                if (a(mTargetView) == mTargetPosition)
                {
                    a(mTargetView, mRecyclerView.mState, mRecyclingAction);
                    android.support.v7.widget.a.a(mRecyclingAction, mRecyclerView);
                    a();
                } else
                {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    mTargetView = null;
                }
            }
            if (mRunning)
            {
                a(i1, j1, mRecyclerView.mState, mRecyclingAction);
                android.support.v7.widget.a.a(mRecyclingAction, mRecyclerView);
            }
        }

        static void a(p p1, int i1, int j1)
        {
            p1.a(i1, j1);
        }

        public int a(View view)
        {
            return mRecyclerView.e(view);
        }

        protected final void a()
        {
            if (!mRunning)
            {
                return;
            } else
            {
                f();
                q.d(mRecyclerView.mState, -1);
                mTargetView = null;
                mTargetPosition = -1;
                mPendingInitialRun = false;
                mRunning = false;
                android.support.v7.widget.h.a(mLayoutManager, this);
                mLayoutManager = null;
                mRecyclerView = null;
                return;
            }
        }

        public void a(int i1)
        {
            mTargetPosition = i1;
        }

        protected abstract void a(int i1, int j1, q q1, a a1);

        void a(RecyclerView recyclerview, h h1)
        {
            mRecyclerView = recyclerview;
            mLayoutManager = h1;
            if (mTargetPosition == -1)
            {
                throw new IllegalArgumentException("Invalid target position");
            } else
            {
                q.d(mRecyclerView.mState, mTargetPosition);
                mRunning = true;
                mPendingInitialRun = true;
                mTargetView = b(d());
                e();
                android.support.v7.widget.RecyclerView.t(mRecyclerView).a();
                return;
            }
        }

        protected abstract void a(View view, q q1, a a1);

        public View b(int i1)
        {
            return RecyclerView.d(mRecyclerView).c(i1);
        }

        protected void b(View view)
        {
            if (a(view) == d())
            {
                mTargetView = view;
            }
        }

        public boolean b()
        {
            return mPendingInitialRun;
        }

        public boolean c()
        {
            return mRunning;
        }

        public int d()
        {
            return mTargetPosition;
        }

        protected abstract void e();

        protected abstract void f();

        public p()
        {
            mTargetPosition = -1;
        }
    }

    public static class p.a
    {

        private int a;
        private int b;
        private int c;
        private Interpolator d;
        private boolean e;
        private int f;

        private void a()
        {
            if (d != null && c < 1)
            {
                throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
            }
            if (c < 1)
            {
                throw new IllegalStateException("Scroll duration must be a positive number");
            } else
            {
                return;
            }
        }

        static void a(p.a a1, RecyclerView recyclerview)
        {
            a1.a(recyclerview);
        }

        private void a(RecyclerView recyclerview)
        {
            if (e)
            {
                a();
                if (d == null)
                {
                    if (c == 0x80000000)
                    {
                        android.support.v7.widget.RecyclerView.t(recyclerview).b(a, b);
                    } else
                    {
                        android.support.v7.widget.RecyclerView.t(recyclerview).a(a, b, c);
                    }
                } else
                {
                    android.support.v7.widget.RecyclerView.t(recyclerview).a(a, b, c, d);
                }
                f = f + 1;
                if (f > 10)
                {
                    Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                }
                e = false;
                return;
            } else
            {
                f = 0;
                return;
            }
        }

        public void a(int i1)
        {
            e = true;
            a = i1;
        }

        public void b(int i1)
        {
            e = true;
            c = i1;
        }

        public p.a(int i1, int j1)
        {
            this(i1, j1, 0x80000000, null);
        }

        public p.a(int i1, int j1, int k1, Interpolator interpolator)
        {
            e = false;
            f = 0;
            a = i1;
            b = j1;
            c = k1;
            d = interpolator;
        }
    }

    public static class q
    {

        android.support.v4.f.a a;
        android.support.v4.f.a b;
        android.support.v4.f.a c;
        int d;
        private int e;
        private SparseArray f;
        private int g;
        private int h;
        private boolean i;
        private boolean j;
        private boolean k;
        private boolean l;

        static int a(q q1, int i1)
        {
            i1 = q1.h + i1;
            q1.h = i1;
            return i1;
        }

        private void a(android.support.v4.f.a a1, t t1)
        {
            int i1 = a1.size() - 1;
            do
            {
label0:
                {
                    if (i1 >= 0)
                    {
                        if (t1 != a1.c(i1))
                        {
                            break label0;
                        }
                        a1.d(i1);
                    }
                    return;
                }
                i1--;
            } while (true);
        }

        static boolean a(q q1)
        {
            return q1.l;
        }

        static boolean a(q q1, boolean flag)
        {
            q1.i = flag;
            return flag;
        }

        static int b(q q1, int i1)
        {
            q1.h = i1;
            return i1;
        }

        static boolean b(q q1)
        {
            return q1.k;
        }

        static boolean b(q q1, boolean flag)
        {
            q1.j = flag;
            return flag;
        }

        static int c(q q1, int i1)
        {
            q1.g = i1;
            return i1;
        }

        static boolean c(q q1)
        {
            return q1.i;
        }

        static boolean c(q q1, boolean flag)
        {
            q1.k = flag;
            return flag;
        }

        static int d(q q1, int i1)
        {
            q1.e = i1;
            return i1;
        }

        static boolean d(q q1)
        {
            return q1.j;
        }

        static boolean d(q q1, boolean flag)
        {
            q1.l = flag;
            return flag;
        }

        public void a(t t1)
        {
            a.remove(t1);
            b.remove(t1);
            if (c != null)
            {
                a(c, t1);
            }
        }

        public boolean a()
        {
            return j;
        }

        public boolean b()
        {
            return l;
        }

        public int c()
        {
            return e;
        }

        public boolean d()
        {
            return e != -1;
        }

        public int e()
        {
            if (j)
            {
                return g - h;
            } else
            {
                return d;
            }
        }

        public String toString()
        {
            return (new StringBuilder()).append("State{mTargetPosition=").append(e).append(", mPreLayoutHolderMap=").append(a).append(", mPostLayoutHolderMap=").append(b).append(", mData=").append(f).append(", mItemCount=").append(d).append(", mPreviousLayoutItemCount=").append(g).append(", mDeletedInvisibleItemCountSincePreviousLayout=").append(h).append(", mStructureChanged=").append(i).append(", mInPreLayout=").append(j).append(", mRunSimpleAnimations=").append(k).append(", mRunPredictiveAnimations=").append(l).append('}').toString();
        }

        public q()
        {
            e = -1;
            a = new android.support.v4.f.a();
            b = new android.support.v4.f.a();
            c = new android.support.v4.f.a();
            d = 0;
            g = 0;
            h = 0;
            i = false;
            j = false;
            k = false;
            l = false;
        }
    }

    public static abstract class r
    {

        public abstract View a(m m1, int i1, int j1);
    }

    private class s
        implements Runnable
    {

        final RecyclerView a;
        private int b;
        private int c;
        private android.support.v4.widget.p d;
        private Interpolator e;
        private boolean f;
        private boolean g;

        private float a(float f1)
        {
            return (float)Math.sin((float)((double)(f1 - 0.5F) * 0.4712389167638204D));
        }

        private int b(int i1, int j1, int k1, int l1)
        {
            int i2 = Math.abs(i1);
            int j2 = Math.abs(j1);
            float f1;
            float f2;
            float f3;
            boolean flag;
            if (i2 > j2)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            k1 = (int)Math.sqrt(k1 * k1 + l1 * l1);
            j1 = (int)Math.sqrt(i1 * i1 + j1 * j1);
            if (flag)
            {
                i1 = a.getWidth();
            } else
            {
                i1 = a.getHeight();
            }
            l1 = i1 / 2;
            f3 = Math.min(1.0F, ((float)j1 * 1.0F) / (float)i1);
            f1 = l1;
            f2 = l1;
            f3 = a(f3);
            if (k1 > 0)
            {
                i1 = Math.round(1000F * Math.abs((f3 * f2 + f1) / (float)k1)) * 4;
            } else
            {
                if (flag)
                {
                    j1 = i2;
                } else
                {
                    j1 = j2;
                }
                i1 = (int)(((float)j1 / (float)i1 + 1.0F) * 300F);
            }
            return Math.min(i1, 2000);
        }

        private void c()
        {
            g = false;
            f = true;
        }

        private void d()
        {
            f = false;
            if (g)
            {
                a();
            }
        }

        void a()
        {
            if (f)
            {
                g = true;
                return;
            } else
            {
                a.removeCallbacks(this);
                ai.a(a, this);
                return;
            }
        }

        public void a(int i1, int j1)
        {
            RecyclerView.b(a, 2);
            c = 0;
            b = 0;
            d.a(0, 0, i1, j1, 0x80000000, 0x7fffffff, 0x80000000, 0x7fffffff);
            a();
        }

        public void a(int i1, int j1, int k1)
        {
            a(i1, j1, k1, RecyclerView.p());
        }

        public void a(int i1, int j1, int k1, int l1)
        {
            a(i1, j1, b(i1, j1, k1, l1));
        }

        public void a(int i1, int j1, int k1, Interpolator interpolator)
        {
            if (e != interpolator)
            {
                e = interpolator;
                d = android.support.v4.widget.p.a(a.getContext(), interpolator);
            }
            RecyclerView.b(a, 2);
            c = 0;
            b = 0;
            d.a(0, 0, i1, j1, k1);
            a();
        }

        public void b()
        {
            a.removeCallbacks(this);
            d.h();
        }

        public void b(int i1, int j1)
        {
            a(i1, j1, 0, 0);
        }

        public void run()
        {
            android.support.v4.widget.p p1;
            p p2;
            c();
            RecyclerView.e(a);
            p1 = d;
            p2 = RecyclerView.d(a).mSmoothScroller;
            if (!p1.g()) goto _L2; else goto _L1
_L1:
            int i1;
            int k1;
            int i2;
            int i4 = p1.b();
            int j4 = p1.c();
            int k3 = i4 - b;
            int l3 = j4 - c;
            int j1 = 0;
            boolean flag3 = false;
            int l1 = 0;
            boolean flag1 = false;
            b = i4;
            c = j4;
            i2 = 0;
            i1 = 0;
            k1 = 0;
            boolean flag2 = false;
            if (RecyclerView.f(a) != null)
            {
                a.b();
                RecyclerView.b(a, true);
                j1 = ((flag3) ? 1 : 0);
                if (k3 != 0)
                {
                    j1 = RecyclerView.d(a).a(k3, a.mRecycler, a.mState);
                    i1 = k3 - j1;
                }
                k1 = ((flag2) ? 1 : 0);
                l1 = ((flag1) ? 1 : 0);
                if (l3 != 0)
                {
                    l1 = RecyclerView.d(a).b(l3, a.mRecycler, a.mState);
                    k1 = l3 - l1;
                }
                if (android.support.v7.widget.RecyclerView.g(a))
                {
                    int j2 = a.mChildHelper.b();
                    for (i2 = 0; i2 < j2; i2++)
                    {
                        View view = a.mChildHelper.b(i2);
                        Object obj = a.a(view);
                        if (obj == null || ((t) (obj)).mShadowingHolder == null)
                        {
                            continue;
                        }
                        obj = ((t) (obj)).mShadowingHolder.itemView;
                        int l2 = view.getLeft();
                        int j3 = view.getTop();
                        if (l2 != ((View) (obj)).getLeft() || j3 != ((View) (obj)).getTop())
                        {
                            ((View) (obj)).layout(l2, j3, ((View) (obj)).getWidth() + l2, ((View) (obj)).getHeight() + j3);
                        }
                    }

                }
                if (p2 != null && !p2.b() && p2.c())
                {
                    i2 = a.mState.e();
                    if (i2 == 0)
                    {
                        p2.a();
                    } else
                    if (p2.d() >= i2)
                    {
                        p2.a(i2 - 1);
                        android.support.v7.widget.p.a(p2, k3 - i1, l3 - k1);
                    } else
                    {
                        android.support.v7.widget.p.a(p2, k3 - i1, l3 - k1);
                    }
                }
                RecyclerView.b(a, false);
                a.a(false);
                i2 = i1;
            }
            if (!RecyclerView.h(a).isEmpty())
            {
                a.invalidate();
            }
            if (ai.a(a) != 2)
            {
                android.support.v7.widget.RecyclerView.a(a, k3, l3);
            }
            if (i2 == 0 && k1 == 0) goto _L4; else goto _L3
_L3:
            int k2 = (int)p1.f();
            boolean flag;
            int i3;
            if (i2 != i4)
            {
                if (i2 < 0)
                {
                    i1 = -k2;
                } else
                if (i2 > 0)
                {
                    i1 = k2;
                } else
                {
                    i1 = 0;
                }
                i3 = i1;
            } else
            {
                i3 = 0;
            }
            if (k1 == j4) goto _L6; else goto _L5
_L5:
            if (k1 >= 0) goto _L8; else goto _L7
_L7:
            i1 = -k2;
_L10:
            if (ai.a(a) != 2)
            {
                a.d(i3, i1);
            }
            if ((i3 != 0 || i2 == i4 || p1.d() == 0) && (i1 != 0 || k1 == j4 || p1.e() == 0))
            {
                p1.h();
            }
_L4:
            if (j1 != 0 || l1 != 0)
            {
                RecyclerView.b(a, j1, l1);
            }
            if (!RecyclerView.i(a))
            {
                a.invalidate();
            }
            if (l3 != 0 && RecyclerView.d(a).e() && l1 == l3)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            if (k3 != 0 && RecyclerView.d(a).d() && j1 == k3)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (k3 == 0 && l3 == 0 || flag || i1 != 0)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            if (p1.a() || i1 == 0)
            {
                RecyclerView.b(a, 0);
            } else
            {
                a();
            }
_L2:
            if (p2 != null && p2.b())
            {
                android.support.v7.widget.p.a(p2, 0, 0);
            }
            d();
            return;
_L8:
            i1 = k2;
            if (k1 <= 0)
            {
                i1 = 0;
            }
            continue; /* Loop/switch isn't completed */
_L6:
            i1 = 0;
            if (true) goto _L10; else goto _L9
_L9:
        }

        public s()
        {
            a = RecyclerView.this;
            super();
            e = RecyclerView.p();
            f = false;
            g = false;
            d = android.support.v4.widget.p.a(getContext(), RecyclerView.p());
        }
    }

    public static abstract class t
    {

        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_BOUND = 1;
        static final int FLAG_CHANGED = 64;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        public final View itemView;
        private int mFlags;
        private int mIsRecyclableCount;
        long mItemId;
        int mItemViewType;
        int mOldPosition;
        int mPosition;
        int mPreLayoutPosition;
        private m mScrapContainer;
        t mShadowedHolder;
        t mShadowingHolder;

        static m a(t t1, m m1)
        {
            t1.mScrapContainer = m1;
            return m1;
        }

        static boolean a(t t1)
        {
            return t1.x();
        }

        static boolean b(t t1)
        {
            return t1.w();
        }

        static int c(t t1)
        {
            return t1.mFlags;
        }

        private boolean w()
        {
            return (mFlags & 0x10) != 0;
        }

        private boolean x()
        {
            return (mFlags & 0x10) == 0 && ai.c(itemView);
        }

        void a()
        {
            mOldPosition = -1;
            mPreLayoutPosition = -1;
        }

        void a(int i1, int j1)
        {
            mFlags = mFlags & ~j1 | i1 & j1;
        }

        void a(int i1, int j1, boolean flag)
        {
            b(8);
            a(j1, flag);
            mPosition = i1;
        }

        void a(int i1, boolean flag)
        {
            if (mOldPosition == -1)
            {
                mOldPosition = mPosition;
            }
            if (mPreLayoutPosition == -1)
            {
                mPreLayoutPosition = mPosition;
            }
            if (flag)
            {
                mPreLayoutPosition = mPreLayoutPosition + i1;
            }
            mPosition = mPosition + i1;
            if (itemView.getLayoutParams() != null)
            {
                ((i)itemView.getLayoutParams()).c = true;
            }
        }

        void a(m m1)
        {
            mScrapContainer = m1;
        }

        public final void a(boolean flag)
        {
            int i1;
            if (flag)
            {
                i1 = mIsRecyclableCount - 1;
            } else
            {
                i1 = mIsRecyclableCount + 1;
            }
            mIsRecyclableCount = i1;
            if (mIsRecyclableCount < 0)
            {
                mIsRecyclableCount = 0;
                Log.e("View", (new StringBuilder()).append("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ").append(this).toString());
            } else
            {
                if (!flag && mIsRecyclableCount == 1)
                {
                    mFlags = mFlags | 0x10;
                    return;
                }
                if (flag && mIsRecyclableCount == 0)
                {
                    mFlags = mFlags & 0xffffffef;
                    return;
                }
            }
        }

        boolean a(int i1)
        {
            return (mFlags & i1) != 0;
        }

        void b()
        {
            if (mOldPosition == -1)
            {
                mOldPosition = mPosition;
            }
        }

        void b(int i1)
        {
            mFlags = mFlags | i1;
        }

        boolean c()
        {
            return (mFlags & 0x80) != 0;
        }

        public final int d()
        {
            if (mPreLayoutPosition == -1)
            {
                return mPosition;
            } else
            {
                return mPreLayoutPosition;
            }
        }

        public final int e()
        {
            if (mPreLayoutPosition == -1)
            {
                return mPosition;
            } else
            {
                return mPreLayoutPosition;
            }
        }

        public final int f()
        {
            ViewParent viewparent = itemView.getParent();
            if (!(viewparent instanceof RecyclerView))
            {
                return -1;
            } else
            {
                return android.support.v7.widget.RecyclerView.a((RecyclerView)viewparent, this);
            }
        }

        public final long g()
        {
            return mItemId;
        }

        public final int h()
        {
            return mItemViewType;
        }

        boolean i()
        {
            return mScrapContainer != null;
        }

        void j()
        {
            mScrapContainer.d(this);
        }

        boolean k()
        {
            return (mFlags & 0x20) != 0;
        }

        void l()
        {
            mFlags = mFlags & 0xffffffdf;
        }

        void m()
        {
            mFlags = mFlags & 0xfffffeff;
        }

        boolean n()
        {
            return (mFlags & 4) != 0;
        }

        boolean o()
        {
            return (mFlags & 2) != 0;
        }

        boolean p()
        {
            return (mFlags & 0x40) != 0;
        }

        boolean q()
        {
            return (mFlags & 1) != 0;
        }

        boolean r()
        {
            return (mFlags & 8) != 0;
        }

        boolean s()
        {
            return (mFlags & 0x100) != 0;
        }

        boolean t()
        {
            return (mFlags & 0x200) != 0;
        }

        public String toString()
        {
            StringBuilder stringbuilder = new StringBuilder((new StringBuilder()).append("ViewHolder{").append(Integer.toHexString(hashCode())).append(" position=").append(mPosition).append(" id=").append(mItemId).append(", oldPos=").append(mOldPosition).append(", pLpos:").append(mPreLayoutPosition).toString());
            if (i())
            {
                stringbuilder.append(" scrap");
            }
            if (n())
            {
                stringbuilder.append(" invalid");
            }
            if (!q())
            {
                stringbuilder.append(" unbound");
            }
            if (o())
            {
                stringbuilder.append(" update");
            }
            if (r())
            {
                stringbuilder.append(" removed");
            }
            if (c())
            {
                stringbuilder.append(" ignored");
            }
            if (p())
            {
                stringbuilder.append(" changed");
            }
            if (s())
            {
                stringbuilder.append(" tmpDetached");
            }
            if (!v())
            {
                stringbuilder.append((new StringBuilder()).append(" not recyclable(").append(mIsRecyclableCount).append(")").toString());
            }
            if (!t())
            {
                stringbuilder.append("undefined adapter position");
            }
            if (itemView.getParent() == null)
            {
                stringbuilder.append(" no parent");
            }
            stringbuilder.append("}");
            return stringbuilder.toString();
        }

        void u()
        {
            mFlags = 0;
            mPosition = -1;
            mOldPosition = -1;
            mItemId = -1L;
            mPreLayoutPosition = -1;
            mIsRecyclableCount = 0;
            mShadowedHolder = null;
            mShadowingHolder = null;
        }

        public final boolean v()
        {
            return (mFlags & 0x10) == 0 && !ai.c(itemView);
        }

        public t(View view)
        {
            mPosition = -1;
            mOldPosition = -1;
            mItemId = -1L;
            mItemViewType = -1;
            mPreLayoutPosition = -1;
            mShadowedHolder = null;
            mShadowingHolder = null;
            mIsRecyclableCount = 0;
            mScrapContainer = null;
            if (view == null)
            {
                throw new IllegalArgumentException("itemView may not be null");
            } else
            {
                itemView = view;
                return;
            }
        }
    }


    private static final boolean DEBUG = false;
    private static final boolean DISPATCH_TEMP_DETACH = false;
    private static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
    public static final int HORIZONTAL = 0;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final int MAX_SCROLL_DURATION = 2000;
    public static final long NO_ID = -1L;
    public static final int NO_POSITION = -1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    public static final int VERTICAL = 1;
    private static final Interpolator sQuinticInterpolator = new Interpolator() {

        public float getInterpolation(float f1)
        {
            f1--;
            return f1 * (f1 * f1 * f1 * f1) + 1.0F;
        }

    };
    private z mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    private j mActiveOnItemTouchListener;
    private a mAdapter;
    android.support.v7.widget.a mAdapterHelper;
    private boolean mAdapterUpdateDuringMeasure;
    private android.support.v4.widget.g mBottomGlow;
    android.support.v7.widget.q mChildHelper;
    private boolean mClipToPadding;
    private boolean mDataSetHasChangedAfterLayout;
    final List mDisappearingViewsInLayoutPass;
    private boolean mEatRequestLayout;
    private boolean mFirstLayoutComplete;
    private boolean mHasFixedSize;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private boolean mIsAttached;
    d mItemAnimator;
    private d.b mItemAnimatorListener;
    private Runnable mItemAnimatorRunner = new Runnable() {

        final RecyclerView a;

        public void run()
        {
            if (a.mItemAnimator != null)
            {
                a.mItemAnimator.a();
            }
            android.support.v7.widget.RecyclerView.a(a, false);
        }

            
            {
                a = RecyclerView.this;
                super();
            }
    };
    private final ArrayList mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastTouchX;
    private int mLastTouchY;
    private h mLayout;
    private boolean mLayoutRequestEaten;
    private android.support.v4.widget.g mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int mMinMaxLayoutPositions[];
    private final o mObserver;
    private final ArrayList mOnItemTouchListeners;
    private SavedState mPendingSavedState;
    private final boolean mPostUpdatesOnAnimation;
    private boolean mPostedAnimatorRunner;
    final m mRecycler;
    private n mRecyclerListener;
    private android.support.v4.widget.g mRightGlow;
    private boolean mRunningLayoutOrScroll;
    private k mScrollListener;
    private int mScrollPointerId;
    private int mScrollState;
    final q mState;
    private final Rect mTempRect;
    private android.support.v4.widget.g mTopGlow;
    private int mTouchSlop;
    private final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    private final s mViewFlinger;

    public RecyclerView(Context context)
    {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeset, int i1)
    {
        boolean flag1 = false;
        super(context, attributeset, i1);
        mObserver = new o();
        mRecycler = new m();
        mDisappearingViewsInLayoutPass = new ArrayList();
        mUpdateChildViewsRunnable = new Runnable() {

            final RecyclerView a;

            public void run()
            {
                if (android.support.v7.widget.RecyclerView.a(a))
                {
                    if (RecyclerView.b(a))
                    {
                        a.i();
                        return;
                    }
                    if (a.mAdapterHelper.d())
                    {
                        a.b();
                        a.mAdapterHelper.b();
                        if (!RecyclerView.c(a))
                        {
                            a.m();
                        }
                        a.a(true);
                        return;
                    }
                }
            }

            
            {
                a = RecyclerView.this;
                super();
            }
        };
        mTempRect = new Rect();
        mItemDecorations = new ArrayList();
        mOnItemTouchListeners = new ArrayList();
        mDataSetHasChangedAfterLayout = false;
        mRunningLayoutOrScroll = false;
        mItemAnimator = new android.support.v7.widget.r();
        mScrollState = 0;
        mScrollPointerId = -1;
        mViewFlinger = new s();
        mState = new q();
        mItemsAddedOrRemoved = false;
        mItemsChanged = false;
        mItemAnimatorListener = new e();
        mPostedAnimatorRunner = false;
        mMinMaxLayoutPositions = new int[2];
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mPostUpdatesOnAnimation = flag;
        context = ViewConfiguration.get(context);
        mTouchSlop = context.getScaledTouchSlop();
        mMinFlingVelocity = context.getScaledMinimumFlingVelocity();
        mMaxFlingVelocity = context.getScaledMaximumFlingVelocity();
        flag = flag1;
        if (ai.a(this) == 2)
        {
            flag = true;
        }
        setWillNotDraw(flag);
        mItemAnimator.a(mItemAnimatorListener);
        a();
        r();
        if (ai.e(this) == 0)
        {
            ai.c(this, 1);
        }
        mAccessibilityManager = (AccessibilityManager)getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new z(this));
    }

    private void A()
    {
        if (mDataSetHasChangedAfterLayout)
        {
            return;
        }
        mDataSetHasChangedAfterLayout = true;
        int j1 = mChildHelper.c();
        for (int i1 = 0; i1 < j1; i1++)
        {
            t t1 = b(mChildHelper.c(i1));
            if (t1 != null && !t1.c())
            {
                t1.b(512);
            }
        }

        mRecycler.g();
    }

    static int a(RecyclerView recyclerview, t t1)
    {
        return recyclerview.c(t1);
    }

    private void a(android.support.v4.f.a a1)
    {
        int j1 = mDisappearingViewsInLayoutPass.size();
        int i1 = 0;
        while (i1 < j1) 
        {
            View view = (View)mDisappearingViewsInLayoutPass.get(i1);
            t t1 = b(view);
            g g1 = (g)mState.a.remove(t1);
            if (!mState.a())
            {
                mState.b.remove(t1);
            }
            if (a1.remove(view) != null)
            {
                mLayout.a(view, mRecycler);
            } else
            if (g1 != null)
            {
                a(g1);
            } else
            {
                a(new g(t1, view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            }
            i1++;
        }
        mDisappearingViewsInLayoutPass.clear();
    }

    private void a(a a1, boolean flag, boolean flag1)
    {
        if (mAdapter != null)
        {
            mAdapter.b(mObserver);
            mAdapter.b(this);
        }
        if (!flag || flag1)
        {
            if (mItemAnimator != null)
            {
                mItemAnimator.c();
            }
            if (mLayout != null)
            {
                mLayout.c(mRecycler);
                mLayout.b(mRecycler);
            }
            mRecycler.a();
        }
        mAdapterHelper.a();
        a a2 = mAdapter;
        mAdapter = a1;
        if (a1 != null)
        {
            a1.a(mObserver);
            a1.a(this);
        }
        if (mLayout != null)
        {
            mLayout.a(a2, mAdapter);
        }
        mRecycler.a(a2, mAdapter, flag);
        android.support.v7.widget.q.a(mState, true);
        n();
    }

    private void a(g g1)
    {
        View view = g1.a.itemView;
        b(g1.a);
        int i1 = g1.b;
        int j1 = g1.c;
        int k1 = view.getLeft();
        int l1 = view.getTop();
        if (i1 != k1 || j1 != l1)
        {
            g1.a.a(false);
            view.layout(k1, l1, view.getWidth() + k1, view.getHeight() + l1);
            if (mItemAnimator.a(g1.a, i1, j1, k1, l1))
            {
                x();
            }
        } else
        {
            g1.a.a(false);
            if (mItemAnimator.a(g1.a))
            {
                x();
                return;
            }
        }
    }

    private void a(t t1, Rect rect, int i1, int j1)
    {
        View view = t1.itemView;
        if (rect != null && (rect.left != i1 || rect.top != j1))
        {
            t1.a(false);
            if (mItemAnimator.a(t1, rect.left, rect.top, i1, j1))
            {
                x();
            }
        } else
        {
            t1.a(false);
            if (mItemAnimator.b(t1))
            {
                x();
                return;
            }
        }
    }

    private void a(t t1, t t2)
    {
        t1.a(false);
        b(t1);
        t1.mShadowedHolder = t2;
        mRecycler.d(t1);
        int k1 = t1.itemView.getLeft();
        int l1 = t1.itemView.getTop();
        int i1;
        int j1;
        if (t2 == null || t2.c())
        {
            j1 = l1;
            i1 = k1;
        } else
        {
            i1 = t2.itemView.getLeft();
            j1 = t2.itemView.getTop();
            t2.a(false);
            t2.mShadowingHolder = t1;
        }
        if (mItemAnimator.a(t1, t2, k1, l1, i1, j1))
        {
            x();
        }
    }

    static void a(RecyclerView recyclerview, int i1)
    {
        recyclerview.detachViewFromParent(i1);
    }

    static void a(RecyclerView recyclerview, int i1, int j1)
    {
        recyclerview.i(i1, j1);
    }

    static void a(RecyclerView recyclerview, View view)
    {
        recyclerview.k(view);
    }

    static void a(RecyclerView recyclerview, View view, int i1, android.view.ViewGroup.LayoutParams layoutparams)
    {
        recyclerview.attachViewToParent(view, i1, layoutparams);
    }

    private void a(int ai1[])
    {
        int j2 = mChildHelper.b();
        if (j2 == 0)
        {
            ai1[0] = 0;
            ai1[1] = 0;
            return;
        }
        int i1 = 0x7fffffff;
        int l1 = 0x80000000;
        int k1 = 0;
        while (k1 < j2) 
        {
            t t1 = b(mChildHelper.b(k1));
            if (!t1.c())
            {
                int i2 = t1.e();
                int j1 = i1;
                if (i2 < i1)
                {
                    j1 = i2;
                }
                if (i2 > l1)
                {
                    l1 = i2;
                    i1 = j1;
                } else
                {
                    i1 = j1;
                }
            }
            k1++;
        }
        ai1[0] = i1;
        ai1[1] = l1;
    }

    static boolean a(RecyclerView recyclerview)
    {
        return recyclerview.mFirstLayoutComplete;
    }

    static boolean a(RecyclerView recyclerview, boolean flag)
    {
        recyclerview.mPostedAnimatorRunner = flag;
        return flag;
    }

    private boolean a(MotionEvent motionevent)
    {
        int k1 = motionevent.getAction();
        if (k1 == 3 || k1 == 0)
        {
            mActiveOnItemTouchListener = null;
        }
        int l1 = mOnItemTouchListeners.size();
        for (int i1 = 0; i1 < l1; i1++)
        {
            j j1 = (j)mOnItemTouchListeners.get(i1);
            if (j1.a(this, motionevent) && k1 != 3)
            {
                mActiveOnItemTouchListener = j1;
                return true;
            }
        }

        return false;
    }

    static t b(View view)
    {
        if (view == null)
        {
            return null;
        } else
        {
            return ((i)view.getLayoutParams()).a;
        }
    }

    private void b(t t1)
    {
        View view = t1.itemView;
        boolean flag;
        if (view.getParent() == this)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mRecycler.d(a(view));
        if (t1.s())
        {
            mChildHelper.a(view, -1, view.getLayoutParams(), true);
            return;
        }
        if (!flag)
        {
            mChildHelper.a(view, true);
            return;
        } else
        {
            mChildHelper.d(view);
            return;
        }
    }

    static void b(RecyclerView recyclerview, int i1)
    {
        recyclerview.setScrollState(i1);
    }

    static void b(RecyclerView recyclerview, int i1, int j1)
    {
        recyclerview.l(i1, j1);
    }

    static void b(RecyclerView recyclerview, View view)
    {
        recyclerview.j(view);
    }

    static boolean b(RecyclerView recyclerview)
    {
        return recyclerview.mDataSetHasChangedAfterLayout;
    }

    static boolean b(RecyclerView recyclerview, boolean flag)
    {
        recyclerview.mRunningLayoutOrScroll = flag;
        return flag;
    }

    private boolean b(MotionEvent motionevent)
    {
        int i1 = motionevent.getAction();
        if (mActiveOnItemTouchListener == null) goto _L2; else goto _L1
_L1:
        if (i1 != 0) goto _L4; else goto _L3
_L3:
        mActiveOnItemTouchListener = null;
_L2:
        if (i1 == 0) goto _L6; else goto _L5
_L5:
        int k1;
        k1 = mOnItemTouchListeners.size();
        i1 = 0;
_L7:
        if (i1 >= k1)
        {
            break; /* Loop/switch isn't completed */
        }
        j j1 = (j)mOnItemTouchListeners.get(i1);
        if (j1.a(this, motionevent))
        {
            mActiveOnItemTouchListener = j1;
            return true;
        }
        i1++;
        continue; /* Loop/switch isn't completed */
_L4:
        mActiveOnItemTouchListener.b(this, motionevent);
        if (i1 == 3 || i1 == 1)
        {
            mActiveOnItemTouchListener = null;
        }
        return true;
        if (true) goto _L7; else goto _L6
_L6:
        return false;
    }

    private int c(t t1)
    {
        if (t1.a(520))
        {
            return -1;
        } else
        {
            return mAdapterHelper.b(t1.mPosition);
        }
    }

    static void c(RecyclerView recyclerview, int i1, int j1)
    {
        recyclerview.j(i1, j1);
    }

    static void c(RecyclerView recyclerview, View view)
    {
        recyclerview.m(view);
    }

    private void c(MotionEvent motionevent)
    {
        int i1 = android.support.v4.view.t.b(motionevent);
        if (android.support.v4.view.t.b(motionevent, i1) == mScrollPointerId)
        {
            int j1;
            if (i1 == 0)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            mScrollPointerId = android.support.v4.view.t.b(motionevent, i1);
            j1 = (int)(android.support.v4.view.t.c(motionevent, i1) + 0.5F);
            mLastTouchX = j1;
            mInitialTouchX = j1;
            i1 = (int)(android.support.v4.view.t.d(motionevent, i1) + 0.5F);
            mLastTouchY = i1;
            mInitialTouchY = i1;
        }
    }

    static boolean c(RecyclerView recyclerview)
    {
        return recyclerview.mLayoutRequestEaten;
    }

    static boolean c(RecyclerView recyclerview, boolean flag)
    {
        recyclerview.mAdapterUpdateDuringMeasure = flag;
        return flag;
    }

    static h d(RecyclerView recyclerview)
    {
        return recyclerview.mLayout;
    }

    static void d(RecyclerView recyclerview, View view)
    {
        recyclerview.l(view);
    }

    static void e(RecyclerView recyclerview)
    {
        recyclerview.s();
    }

    static boolean e(RecyclerView recyclerview, View view)
    {
        return recyclerview.i(view);
    }

    static a f(RecyclerView recyclerview)
    {
        return recyclerview.mAdapter;
    }

    static boolean g(RecyclerView recyclerview)
    {
        return recyclerview.w();
    }

    static ArrayList h(RecyclerView recyclerview)
    {
        return recyclerview.mItemDecorations;
    }

    private void h(int i1, int j1)
    {
        if (i1 < 0)
        {
            d();
            mLeftGlow.a((float)(-i1) / (float)getWidth());
        } else
        if (i1 > 0)
        {
            e();
            mRightGlow.a((float)i1 / (float)getWidth());
        }
        if (j1 < 0)
        {
            f();
            mTopGlow.a((float)(-j1) / (float)getHeight());
        } else
        if (j1 > 0)
        {
            g();
            mBottomGlow.a((float)j1 / (float)getHeight());
        }
        if (i1 != 0 || j1 != 0)
        {
            ai.d(this);
        }
    }

    private void i(int i1, int j1)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (mLeftGlow != null)
        {
            flag = flag1;
            if (!mLeftGlow.a())
            {
                flag = flag1;
                if (i1 > 0)
                {
                    flag = mLeftGlow.c();
                }
            }
        }
        flag1 = flag;
        if (mRightGlow != null)
        {
            flag1 = flag;
            if (!mRightGlow.a())
            {
                flag1 = flag;
                if (i1 < 0)
                {
                    flag1 = flag | mRightGlow.c();
                }
            }
        }
        flag = flag1;
        if (mTopGlow != null)
        {
            flag = flag1;
            if (!mTopGlow.a())
            {
                flag = flag1;
                if (j1 > 0)
                {
                    flag = flag1 | mTopGlow.c();
                }
            }
        }
        flag1 = flag;
        if (mBottomGlow != null)
        {
            flag1 = flag;
            if (!mBottomGlow.a())
            {
                flag1 = flag;
                if (j1 < 0)
                {
                    flag1 = flag | mBottomGlow.c();
                }
            }
        }
        if (flag1)
        {
            ai.d(this);
        }
    }

    static boolean i(RecyclerView recyclerview)
    {
        return recyclerview.awakenScrollBars();
    }

    private boolean i(View view)
    {
        b();
        boolean flag = mChildHelper.e(view);
        if (flag)
        {
            view = b(view);
            mRecycler.d(view);
            mRecycler.b(view);
        }
        a(false);
        return flag;
    }

    private void j(int i1, int j1)
    {
        int l1 = android.view.View.MeasureSpec.getMode(i1);
        int k1 = android.view.View.MeasureSpec.getMode(j1);
        i1 = android.view.View.MeasureSpec.getSize(i1);
        j1 = android.view.View.MeasureSpec.getSize(j1);
        switch (l1)
        {
        default:
            i1 = ai.q(this);
            // fall through

        case -2147483648: 
        case 1073741824: 
            switch (k1)
            {
            default:
                j1 = ai.r(this);
                // fall through

            case -2147483648: 
            case 1073741824: 
                setMeasuredDimension(i1, j1);
                break;
            }
            break;
        }
    }

    static void j(RecyclerView recyclerview)
    {
        recyclerview.A();
    }

    private void j(View view)
    {
        if (mAdapter != null)
        {
            mAdapter.d(b(view));
        }
        g(view);
    }

    private void k(View view)
    {
        if (mAdapter != null)
        {
            mAdapter.c(b(view));
        }
        f(view);
    }

    private boolean k(int i1, int j1)
    {
        int l1;
        boolean flag1;
        flag1 = false;
        l1 = mChildHelper.b();
        if (l1 != 0) goto _L2; else goto _L1
_L1:
        boolean flag;
label0:
        {
            if (i1 == 0)
            {
                flag = flag1;
                if (j1 == 0)
                {
                    break label0;
                }
            }
            flag = true;
        }
_L4:
        return flag;
_L2:
        int k1 = 0;
        do
        {
            flag = flag1;
            if (k1 >= l1)
            {
                continue; /* Loop/switch isn't completed */
            }
            t t1 = b(mChildHelper.b(k1));
            int i2;
            if (!t1.c())
            {
                if ((i2 = t1.e()) < i1 || i2 > j1)
                {
                    return true;
                }
            }
            k1++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    static boolean k(RecyclerView recyclerview)
    {
        return recyclerview.mPostUpdatesOnAnimation;
    }

    private void l(int i1, int j1)
    {
        onScrollChanged(0, 0, 0, 0);
        if (mScrollListener != null)
        {
            mScrollListener.a(this, i1, j1);
        }
    }

    private void l(View view)
    {
        mDisappearingViewsInLayoutPass.remove(view);
    }

    static boolean l(RecyclerView recyclerview)
    {
        return recyclerview.mHasFixedSize;
    }

    private void m(View view)
    {
        if (!mDisappearingViewsInLayoutPass.contains(view))
        {
            mDisappearingViewsInLayoutPass.add(view);
        }
    }

    static boolean m(RecyclerView recyclerview)
    {
        return recyclerview.mIsAttached;
    }

    static Runnable n(RecyclerView recyclerview)
    {
        return recyclerview.mUpdateChildViewsRunnable;
    }

    static AccessibilityManager o(RecyclerView recyclerview)
    {
        return recyclerview.mAccessibilityManager;
    }

    static z p(RecyclerView recyclerview)
    {
        return recyclerview.mAccessibilityDelegate;
    }

    static Interpolator p()
    {
        return sQuinticInterpolator;
    }

    static n q(RecyclerView recyclerview)
    {
        return recyclerview.mRecyclerListener;
    }

    static boolean q()
    {
        return FORCE_INVALIDATE_DISPLAY_LIST;
    }

    private void r()
    {
        mChildHelper = new android.support.v7.widget.q(new q.b() {

            final RecyclerView a;

            public int a()
            {
                return a.getChildCount();
            }

            public int a(View view)
            {
                return a.indexOfChild(view);
            }

            public void a(int i1)
            {
                View view = a.getChildAt(i1);
                if (view != null)
                {
                    RecyclerView.b(a, view);
                }
                a.removeViewAt(i1);
            }

            public void a(View view, int i1)
            {
                a.addView(view, i1);
                android.support.v7.widget.RecyclerView.a(a, view);
            }

            public void a(View view, int i1, android.view.ViewGroup.LayoutParams layoutparams)
            {
                t t1 = RecyclerView.b(view);
                if (t1 != null)
                {
                    if (!t1.s() && !t1.c())
                    {
                        throw new IllegalArgumentException((new StringBuilder()).append("Called attach on a child which is not detached: ").append(t1).toString());
                    }
                    t1.m();
                }
                android.support.v7.widget.RecyclerView.a(a, view, i1, layoutparams);
            }

            public t b(View view)
            {
                return RecyclerView.b(view);
            }

            public View b(int i1)
            {
                return a.getChildAt(i1);
            }

            public void b()
            {
                int j1 = a();
                for (int i1 = 0; i1 < j1; i1++)
                {
                    RecyclerView.b(a, b(i1));
                }

                a.removeAllViews();
            }

            public void c(int i1)
            {
                Object obj = b(i1);
                if (obj != null)
                {
                    obj = RecyclerView.b(((View) (obj)));
                    if (obj != null)
                    {
                        if (((t) (obj)).s() && !((t) (obj)).c())
                        {
                            throw new IllegalArgumentException((new StringBuilder()).append("called detach on an already detached child ").append(obj).toString());
                        }
                        ((t) (obj)).b(256);
                    }
                }
                android.support.v7.widget.RecyclerView.a(a, i1);
            }

            
            {
                a = RecyclerView.this;
                super();
            }
        });
    }

    static boolean r(RecyclerView recyclerview)
    {
        return recyclerview.mClipToPadding;
    }

    private void s()
    {
        mUpdateChildViewsRunnable.run();
    }

    static boolean s(RecyclerView recyclerview)
    {
        return recyclerview.mRunningLayoutOrScroll;
    }

    private void setScrollState(int i1)
    {
        if (i1 != mScrollState)
        {
            mScrollState = i1;
            if (i1 != 2)
            {
                t();
            }
            if (mScrollListener != null)
            {
                mScrollListener.a(this, i1);
            }
            if (mLayout != null)
            {
                mLayout.j(i1);
                return;
            }
        }
    }

    static s t(RecyclerView recyclerview)
    {
        return recyclerview.mViewFlinger;
    }

    private void t()
    {
        mViewFlinger.b();
        if (mLayout != null)
        {
            mLayout.x();
        }
    }

    private void u()
    {
        boolean flag1 = false;
        if (mLeftGlow != null)
        {
            flag1 = mLeftGlow.c();
        }
        boolean flag = flag1;
        if (mTopGlow != null)
        {
            flag = flag1 | mTopGlow.c();
        }
        flag1 = flag;
        if (mRightGlow != null)
        {
            flag1 = flag | mRightGlow.c();
        }
        flag = flag1;
        if (mBottomGlow != null)
        {
            flag = flag1 | mBottomGlow.c();
        }
        if (flag)
        {
            ai.d(this);
        }
    }

    private void v()
    {
        if (mVelocityTracker != null)
        {
            mVelocityTracker.clear();
        }
        u();
        setScrollState(0);
    }

    private boolean w()
    {
        return mItemAnimator != null && mItemAnimator.h();
    }

    private void x()
    {
        if (!mPostedAnimatorRunner && mIsAttached)
        {
            ai.a(this, mItemAnimatorRunner);
            mPostedAnimatorRunner = true;
        }
    }

    private boolean y()
    {
        return mItemAnimator != null && mLayout.b();
    }

    private void z()
    {
        boolean flag2 = true;
        if (mDataSetHasChangedAfterLayout)
        {
            mAdapterHelper.a();
            n();
            mLayout.a(this);
        }
        q q1;
        boolean flag;
        boolean flag1;
        if (mItemAnimator != null && mLayout.b())
        {
            mAdapterHelper.b();
        } else
        {
            mAdapterHelper.e();
        }
        if (mItemsAddedOrRemoved && !mItemsChanged || mItemsAddedOrRemoved || mItemsChanged && w())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        q1 = mState;
        if (mFirstLayoutComplete && mItemAnimator != null && (mDataSetHasChangedAfterLayout || flag || android.support.v7.widget.h.a(mLayout)) && (!mDataSetHasChangedAfterLayout || mAdapter.b()))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        q.c(q1, flag1);
        q1 = mState;
        if (q.b(mState) && flag && !mDataSetHasChangedAfterLayout && y())
        {
            flag1 = flag2;
        } else
        {
            flag1 = false;
        }
        q.d(q1, flag1);
    }

    long a(t t1)
    {
        if (mAdapter.b())
        {
            return t1.g();
        } else
        {
            return (long)t1.mPosition;
        }
    }

    t a(int i1, boolean flag)
    {
        int k1 = mChildHelper.c();
        for (int j1 = 0; j1 < k1; j1++)
        {
            t t1 = b(mChildHelper.c(j1));
            if (t1 != null && !t1.r() && (flag ? t1.mPosition == i1 : t1.e() == i1))
            {
                return t1;
            }
        }

        return null;
    }

    public t a(long l1)
    {
        int j1 = mChildHelper.c();
        for (int i1 = 0; i1 < j1; i1++)
        {
            t t1 = b(mChildHelper.c(i1));
            if (t1 != null && t1.g() == l1)
            {
                return t1;
            }
        }

        return null;
    }

    public t a(View view)
    {
        ViewParent viewparent = view.getParent();
        if (viewparent != null && viewparent != this)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("View ").append(view).append(" is not a direct child of ").append(this).toString());
        } else
        {
            return b(view);
        }
    }

    public View a(float f1, float f2)
    {
        for (int i1 = mChildHelper.b() - 1; i1 >= 0; i1--)
        {
            View view = mChildHelper.b(i1);
            float f3 = ai.o(view);
            float f4 = ai.p(view);
            if (f1 >= (float)view.getLeft() + f3 && f1 <= f3 + (float)view.getRight() && f2 >= (float)view.getTop() + f4 && f2 <= (float)view.getBottom() + f4)
            {
                return view;
            }
        }

        return null;
    }

    void a()
    {
        mAdapterHelper = new android.support.v7.widget.a(new a.a() {

            final RecyclerView a;

            public t a(int i1)
            {
                return a.a(i1, true);
            }

            public void a(int i1, int j1)
            {
                a.a(i1, j1, true);
                a.mItemsAddedOrRemoved = true;
                android.support.v7.widget.q.a(a.mState, j1);
            }

            public void a(a.b b1)
            {
                c(b1);
            }

            public void b(int i1, int j1)
            {
                a.a(i1, j1, false);
                a.mItemsAddedOrRemoved = true;
            }

            public void b(a.b b1)
            {
                c(b1);
            }

            public void c(int i1, int j1)
            {
                a.g(i1, j1);
                a.mItemsChanged = true;
            }

            void c(a.b b1)
            {
                switch (b1.a)
                {
                default:
                    return;

                case 0: // '\0'
                    RecyclerView.d(a).a(a, b1.b, b1.c);
                    return;

                case 1: // '\001'
                    RecyclerView.d(a).b(a, b1.b, b1.c);
                    return;

                case 2: // '\002'
                    RecyclerView.d(a).c(a, b1.b, b1.c);
                    return;

                case 3: // '\003'
                    RecyclerView.d(a).a(a, b1.b, b1.c, 1);
                    break;
                }
            }

            public void d(int i1, int j1)
            {
                a.f(i1, j1);
                a.mItemsAddedOrRemoved = true;
            }

            public void e(int i1, int j1)
            {
                a.e(i1, j1);
                a.mItemsAddedOrRemoved = true;
            }

            
            {
                a = RecyclerView.this;
                super();
            }
        });
    }

    void a(int i1, int j1, boolean flag)
    {
        int l1 = mChildHelper.c();
        int k1 = 0;
        while (k1 < l1) 
        {
            t t1 = b(mChildHelper.c(k1));
            if (t1 != null && !t1.c())
            {
                if (t1.mPosition >= i1 + j1)
                {
                    t1.a(-j1, flag);
                    android.support.v7.widget.q.a(mState, true);
                } else
                if (t1.mPosition >= i1)
                {
                    t1.a(i1 - 1, -j1, flag);
                    android.support.v7.widget.q.a(mState, true);
                }
            }
            k1++;
        }
        mRecycler.b(i1, j1, flag);
        requestLayout();
    }

    public void a(f f1)
    {
        a(f1, -1);
    }

    public void a(f f1, int i1)
    {
        if (mLayout != null)
        {
            mLayout.a("Cannot add item decoration during a scroll  or layout");
        }
        if (mItemDecorations.isEmpty())
        {
            setWillNotDraw(false);
        }
        if (i1 < 0)
        {
            mItemDecorations.add(f1);
        } else
        {
            mItemDecorations.add(i1, f1);
        }
        j();
        requestLayout();
    }

    public void a(j j1)
    {
        mOnItemTouchListeners.add(j1);
    }

    void a(String s1)
    {
        if (mRunningLayoutOrScroll)
        {
            if (s1 == null)
            {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
            } else
            {
                throw new IllegalStateException(s1);
            }
        } else
        {
            return;
        }
    }

    void a(boolean flag)
    {
        if (mEatRequestLayout)
        {
            if (flag && mLayoutRequestEaten && mLayout != null && mAdapter != null)
            {
                i();
            }
            mEatRequestLayout = false;
            mLayoutRequestEaten = false;
        }
    }

    boolean a(int i1, int j1)
    {
        int l1 = 0;
        boolean flag2 = false;
        int j2 = 0;
        boolean flag = false;
        int k1 = 0;
        boolean flag3 = false;
        int i2 = 0;
        boolean flag1 = false;
        s();
        if (mAdapter != null)
        {
            b();
            mRunningLayoutOrScroll = true;
            k1 = ((flag3) ? 1 : 0);
            l1 = ((flag2) ? 1 : 0);
            if (i1 != 0)
            {
                k1 = mLayout.a(i1, mRecycler, mState);
                l1 = i1 - k1;
            }
            i2 = ((flag1) ? 1 : 0);
            j2 = ((flag) ? 1 : 0);
            if (j1 != 0)
            {
                i2 = mLayout.b(j1, mRecycler, mState);
                j2 = j1 - i2;
            }
            if (w())
            {
                int l2 = mChildHelper.b();
                int k2 = 0;
                while (k2 < l2) 
                {
                    View view = mChildHelper.b(k2);
                    Object obj = a(view);
                    if (obj == null || ((t) (obj)).mShadowingHolder == null)
                    {
                        continue;
                    }
                    obj = ((t) (obj)).mShadowingHolder;
                    int i3;
                    int j3;
                    if (obj != null)
                    {
                        obj = ((t) (obj)).itemView;
                    } else
                    {
                        obj = null;
                    }
                    if (obj == null)
                    {
                        continue;
                    }
                    i3 = view.getLeft();
                    j3 = view.getTop();
                    if (i3 != ((View) (obj)).getLeft() || j3 != ((View) (obj)).getTop())
                    {
                        ((View) (obj)).layout(i3, j3, ((View) (obj)).getWidth() + i3, ((View) (obj)).getHeight() + j3);
                    }
                    k2++;
                }
            }
            mRunningLayoutOrScroll = false;
            a(false);
        }
        if (!mItemDecorations.isEmpty())
        {
            invalidate();
        }
        if (ai.a(this) != 2)
        {
            i(i1, j1);
            h(l1, j2);
        }
        if (k1 != 0 || i2 != 0)
        {
            l(k1, i2);
        }
        if (!awakenScrollBars())
        {
            invalidate();
        }
        return k1 != 0 || i2 != 0;
    }

    public void a_(int i1)
    {
        c();
        if (mLayout == null)
        {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        } else
        {
            mLayout.d(i1);
            awakenScrollBars();
            return;
        }
    }

    public void addFocusables(ArrayList arraylist, int i1, int j1)
    {
        if (!mLayout.a(this, arraylist, i1, j1))
        {
            super.addFocusables(arraylist, i1, j1);
        }
    }

    void b()
    {
        if (!mEatRequestLayout)
        {
            mEatRequestLayout = true;
            mLayoutRequestEaten = false;
        }
    }

    public void b(int i1)
    {
        int k1 = mChildHelper.b();
        for (int j1 = 0; j1 < k1; j1++)
        {
            mChildHelper.b(j1).offsetTopAndBottom(i1);
        }

    }

    public void b(int i1, int j1)
    {
        boolean flag = false;
        if (mLayout == null)
        {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else
        {
            if (!mLayout.d())
            {
                i1 = 0;
            }
            if (!mLayout.e())
            {
                j1 = ((flag) ? 1 : 0);
            }
            if (i1 != 0 || j1 != 0)
            {
                mViewFlinger.b(i1, j1);
                return;
            }
        }
    }

    public int c(View view)
    {
        return d(view);
    }

    public void c()
    {
        setScrollState(0);
        t();
    }

    public void c(int i1)
    {
        int k1 = mChildHelper.b();
        for (int j1 = 0; j1 < k1; j1++)
        {
            mChildHelper.b(j1).offsetLeftAndRight(i1);
        }

    }

    public boolean c(int i1, int j1)
    {
        if (mLayout != null) goto _L2; else goto _L1
_L1:
        Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
_L4:
        return false;
_L2:
        int k1;
        boolean flag1;
label0:
        {
            boolean flag = mLayout.d();
            flag1 = mLayout.e();
            if (flag)
            {
                k1 = i1;
                if (Math.abs(i1) >= mMinFlingVelocity)
                {
                    break label0;
                }
            }
            k1 = 0;
        }
label1:
        {
            if (flag1)
            {
                i1 = j1;
                if (Math.abs(j1) >= mMinFlingVelocity)
                {
                    break label1;
                }
            }
            i1 = 0;
        }
        j1 = Math.max(-mMaxFlingVelocity, Math.min(k1, mMaxFlingVelocity));
        i1 = Math.max(-mMaxFlingVelocity, Math.min(i1, mMaxFlingVelocity));
        if (j1 != 0 || i1 != 0)
        {
            mViewFlinger.a(j1, i1);
            return true;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return (layoutparams instanceof i) && mLayout.a((i)layoutparams);
    }

    protected int computeHorizontalScrollExtent()
    {
        if (mLayout.d())
        {
            return mLayout.d(mState);
        } else
        {
            return 0;
        }
    }

    protected int computeHorizontalScrollOffset()
    {
        if (mLayout.d())
        {
            return mLayout.b(mState);
        } else
        {
            return 0;
        }
    }

    protected int computeHorizontalScrollRange()
    {
        if (mLayout.d())
        {
            return mLayout.f(mState);
        } else
        {
            return 0;
        }
    }

    protected int computeVerticalScrollExtent()
    {
        if (mLayout.e())
        {
            return mLayout.e(mState);
        } else
        {
            return 0;
        }
    }

    protected int computeVerticalScrollOffset()
    {
        if (mLayout.e())
        {
            return mLayout.c(mState);
        } else
        {
            return 0;
        }
    }

    protected int computeVerticalScrollRange()
    {
        if (mLayout.e())
        {
            return mLayout.g(mState);
        } else
        {
            return 0;
        }
    }

    public int d(View view)
    {
        view = b(view);
        if (view != null)
        {
            return view.f();
        } else
        {
            return -1;
        }
    }

    void d()
    {
        if (mLeftGlow != null)
        {
            return;
        }
        mLeftGlow = new android.support.v4.widget.g(getContext());
        if (mClipToPadding)
        {
            mLeftGlow.a(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
            return;
        } else
        {
            mLeftGlow.a(getMeasuredHeight(), getMeasuredWidth());
            return;
        }
    }

    void d(int i1, int j1)
    {
        if (i1 < 0)
        {
            d();
            mLeftGlow.a(-i1);
        } else
        if (i1 > 0)
        {
            e();
            mRightGlow.a(i1);
        }
        if (j1 < 0)
        {
            f();
            mTopGlow.a(-j1);
        } else
        if (j1 > 0)
        {
            g();
            mBottomGlow.a(j1);
        }
        if (i1 != 0 || j1 != 0)
        {
            ai.d(this);
        }
    }

    public void draw(Canvas canvas)
    {
        boolean flag = true;
        boolean flag1 = false;
        super.draw(canvas);
        int k1 = mItemDecorations.size();
        for (int i1 = 0; i1 < k1; i1++)
        {
            ((f)mItemDecorations.get(i1)).b(canvas, this, mState);
        }

        int j1;
        if (mLeftGlow != null && !mLeftGlow.a())
        {
            int l1 = canvas.save();
            int i2;
            if (mClipToPadding)
            {
                j1 = getPaddingBottom();
            } else
            {
                j1 = 0;
            }
            canvas.rotate(270F);
            canvas.translate(j1 + -getHeight(), 0.0F);
            if (mLeftGlow != null && mLeftGlow.a(canvas))
            {
                k1 = 1;
            } else
            {
                k1 = 0;
            }
            canvas.restoreToCount(l1);
        } else
        {
            k1 = 0;
        }
        j1 = k1;
        if (mTopGlow != null)
        {
            j1 = k1;
            if (!mTopGlow.a())
            {
                l1 = canvas.save();
                if (mClipToPadding)
                {
                    canvas.translate(getPaddingLeft(), getPaddingTop());
                }
                if (mTopGlow != null && mTopGlow.a(canvas))
                {
                    j1 = 1;
                } else
                {
                    j1 = 0;
                }
                j1 = k1 | j1;
                canvas.restoreToCount(l1);
            }
        }
        k1 = j1;
        if (mRightGlow != null)
        {
            k1 = j1;
            if (!mRightGlow.a())
            {
                l1 = canvas.save();
                i2 = getWidth();
                if (mClipToPadding)
                {
                    k1 = getPaddingTop();
                } else
                {
                    k1 = 0;
                }
                canvas.rotate(90F);
                canvas.translate(-k1, -i2);
                if (mRightGlow != null && mRightGlow.a(canvas))
                {
                    k1 = 1;
                } else
                {
                    k1 = 0;
                }
                k1 = j1 | k1;
                canvas.restoreToCount(l1);
            }
        }
        j1 = k1;
        if (mBottomGlow != null)
        {
            j1 = k1;
            if (!mBottomGlow.a())
            {
                l1 = canvas.save();
                canvas.rotate(180F);
                if (mClipToPadding)
                {
                    canvas.translate(-getWidth() + getPaddingRight(), -getHeight() + getPaddingBottom());
                } else
                {
                    canvas.translate(-getWidth(), -getHeight());
                }
                j1 = ((flag1) ? 1 : 0);
                if (mBottomGlow != null)
                {
                    j1 = ((flag1) ? 1 : 0);
                    if (mBottomGlow.a(canvas))
                    {
                        j1 = 1;
                    }
                }
                j1 = k1 | j1;
                canvas.restoreToCount(l1);
            }
        }
        if (j1 == 0 && mItemAnimator != null && mItemDecorations.size() > 0 && mItemAnimator.b())
        {
            j1 = ((flag) ? 1 : 0);
        }
        if (j1 != 0)
        {
            ai.d(this);
        }
    }

    public int e(View view)
    {
        view = b(view);
        if (view != null)
        {
            return view.e();
        } else
        {
            return -1;
        }
    }

    void e()
    {
        if (mRightGlow != null)
        {
            return;
        }
        mRightGlow = new android.support.v4.widget.g(getContext());
        if (mClipToPadding)
        {
            mRightGlow.a(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
            return;
        } else
        {
            mRightGlow.a(getMeasuredHeight(), getMeasuredWidth());
            return;
        }
    }

    void e(int i1, int j1)
    {
        int j2 = mChildHelper.c();
        byte byte0;
        int k1;
        int l1;
        int i2;
        if (i1 < j1)
        {
            byte0 = -1;
            k1 = j1;
            l1 = i1;
        } else
        {
            byte0 = 1;
            k1 = i1;
            l1 = j1;
        }
        i2 = 0;
        while (i2 < j2) 
        {
            t t1 = b(mChildHelper.c(i2));
            if (t1 != null && t1.mPosition >= l1 && t1.mPosition <= k1)
            {
                if (t1.mPosition == i1)
                {
                    t1.a(j1 - i1, false);
                } else
                {
                    t1.a(byte0, false);
                }
                android.support.v7.widget.q.a(mState, true);
            }
            i2++;
        }
        mRecycler.a(i1, j1);
        requestLayout();
    }

    void f()
    {
        if (mTopGlow != null)
        {
            return;
        }
        mTopGlow = new android.support.v4.widget.g(getContext());
        if (mClipToPadding)
        {
            mTopGlow.a(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
            return;
        } else
        {
            mTopGlow.a(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
    }

    void f(int i1, int j1)
    {
        int l1 = mChildHelper.c();
        for (int k1 = 0; k1 < l1; k1++)
        {
            t t1 = b(mChildHelper.c(k1));
            if (t1 != null && !t1.c() && t1.mPosition >= i1)
            {
                t1.a(j1, false);
                android.support.v7.widget.q.a(mState, true);
            }
        }

        mRecycler.b(i1, j1);
        requestLayout();
    }

    public void f(View view)
    {
    }

    public View focusSearch(View view, int i1)
    {
        View view2 = mLayout.d(view, i1);
        if (view2 == null)
        {
            view2 = FocusFinder.getInstance().findNextFocus(this, view, i1);
            View view1 = view2;
            if (view2 == null)
            {
                view1 = view2;
                if (mAdapter != null)
                {
                    view1 = view2;
                    if (mLayout != null)
                    {
                        b();
                        view1 = mLayout.a(view, i1, mRecycler, mState);
                        a(false);
                    }
                }
            }
            view2 = view1;
            if (view1 == null)
            {
                return super.focusSearch(view, i1);
            }
        }
        return view2;
    }

    void g()
    {
        if (mBottomGlow != null)
        {
            return;
        }
        mBottomGlow = new android.support.v4.widget.g(getContext());
        if (mClipToPadding)
        {
            mBottomGlow.a(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
            return;
        } else
        {
            mBottomGlow.a(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
    }

    void g(int i1, int j1)
    {
        int l1 = mChildHelper.c();
        int k1 = 0;
        do
        {
            if (k1 >= l1)
            {
                break;
            }
            View view = mChildHelper.c(k1);
            t t1 = b(view);
            if (t1 != null && !t1.c() && t1.mPosition >= i1 && t1.mPosition < i1 + j1)
            {
                t1.b(2);
                if (w())
                {
                    t1.b(64);
                }
                ((i)view.getLayoutParams()).c = true;
            }
            k1++;
        } while (true);
        mRecycler.c(i1, j1);
    }

    public void g(View view)
    {
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        if (mLayout == null)
        {
            throw new IllegalStateException("RecyclerView has no LayoutManager");
        } else
        {
            return mLayout.a();
        }
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        if (mLayout == null)
        {
            throw new IllegalStateException("RecyclerView has no LayoutManager");
        } else
        {
            return mLayout.a(getContext(), attributeset);
        }
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (mLayout == null)
        {
            throw new IllegalStateException("RecyclerView has no LayoutManager");
        } else
        {
            return mLayout.a(layoutparams);
        }
    }

    public a getAdapter()
    {
        return mAdapter;
    }

    public z getCompatAccessibilityDelegate()
    {
        return mAccessibilityDelegate;
    }

    public d getItemAnimator()
    {
        return mItemAnimator;
    }

    public h getLayoutManager()
    {
        return mLayout;
    }

    public l getRecycledViewPool()
    {
        return mRecycler.f();
    }

    public int getScrollState()
    {
        return mScrollState;
    }

    Rect h(View view)
    {
        i i1 = (i)view.getLayoutParams();
        if (!i1.c)
        {
            return i1.b;
        }
        Rect rect = i1.b;
        rect.set(0, 0, 0, 0);
        int k1 = mItemDecorations.size();
        for (int j1 = 0; j1 < k1; j1++)
        {
            mTempRect.set(0, 0, 0, 0);
            ((f)mItemDecorations.get(j1)).a(mTempRect, view, this, mState);
            rect.left = rect.left + mTempRect.left;
            rect.top = rect.top + mTempRect.top;
            rect.right = rect.right + mTempRect.right;
            rect.bottom = rect.bottom + mTempRect.bottom;
        }

        i1.c = false;
        return rect;
    }

    void h()
    {
        mBottomGlow = null;
        mTopGlow = null;
        mRightGlow = null;
        mLeftGlow = null;
    }

    void i()
    {
        if (mAdapter != null) goto _L2; else goto _L1
_L1:
        Log.e("RecyclerView", "No adapter attached; skipping layout");
_L16:
        return;
_L2:
        if (mLayout == null)
        {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        mDisappearingViewsInLayoutPass.clear();
        b();
        mRunningLayoutOrScroll = true;
        z();
        q q2 = mState;
        Object obj;
        if (q.b(mState) && mItemsChanged && w())
        {
            obj = new android.support.v4.f.a();
        } else
        {
            obj = null;
        }
        q2.c = ((android.support.v4.f.a) (obj));
        mItemsChanged = false;
        mItemsAddedOrRemoved = false;
        q.b(mState, android.support.v7.widget.q.a(mState));
        mState.d = mAdapter.a();
        a(mMinMaxLayoutPositions);
        if (q.b(mState))
        {
            mState.a.clear();
            mState.b.clear();
            int k2 = mChildHelper.b();
            int i1 = 0;
            while (i1 < k2) 
            {
                obj = b(mChildHelper.b(i1));
                if (!((t) (obj)).c() && (!((t) (obj)).n() || mAdapter.b()))
                {
                    View view1 = ((t) (obj)).itemView;
                    mState.a.put(obj, new g(((t) (obj)), view1.getLeft(), view1.getTop(), view1.getRight(), view1.getBottom()));
                }
                i1++;
            }
        }
        if (!android.support.v7.widget.q.a(mState)) goto _L4; else goto _L3
_L3:
        Object obj2;
        int k1;
        k();
        if (mState.c != null)
        {
            int l2 = mChildHelper.b();
            for (int j1 = 0; j1 < l2; j1++)
            {
                t t1 = b(mChildHelper.b(j1));
                if (t1.p() && !t1.r() && !t1.c())
                {
                    long l3 = a(t1);
                    mState.c.put(Long.valueOf(l3), t1);
                    mState.a.remove(t1);
                }
            }

        }
        boolean flag = q.c(mState);
        android.support.v7.widget.q.a(mState, false);
        mLayout.c(mRecycler, mState);
        android.support.v7.widget.q.a(mState, flag);
        obj2 = new android.support.v4.f.a();
        k1 = 0;
_L9:
        if (k1 >= mChildHelper.b()) goto _L6; else goto _L5
_L5:
        View view = mChildHelper.b(k1);
        if (!b(view).c()) goto _L8; else goto _L7
_L7:
        k1++;
          goto _L9
_L8:
        int i3 = 0;
_L12:
        if (i3 >= mState.a.size())
        {
            break MISSING_BLOCK_LABEL_1685;
        }
        if (((t)mState.a.b(i3)).itemView != view) goto _L11; else goto _L10
_L10:
        i3 = 1;
_L18:
        if (i3 == 0)
        {
            ((android.support.v4.f.a) (obj2)).put(view, new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        }
          goto _L7
_L11:
        i3++;
          goto _L12
_L6:
        l();
        mAdapterHelper.c();
_L17:
        mState.d = mAdapter.a();
        q.b(mState, 0);
        q.b(mState, false);
        mLayout.c(mRecycler, mState);
        android.support.v7.widget.q.a(mState, false);
        mPendingSavedState = null;
        q q1 = mState;
        int l1;
        long l4;
        boolean flag1;
        if (q.b(mState) && mItemAnimator != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        q.c(q1, flag1);
        if (!q.b(mState)) goto _L14; else goto _L13
_L13:
        Object obj1;
        long l6;
        {
            if (mState.c != null)
            {
                obj1 = new android.support.v4.f.a();
            } else
            {
                obj1 = null;
            }
            i3 = mChildHelper.b();
            l1 = 0;
            while (l1 < i3) 
            {
                t t2 = b(mChildHelper.b(l1));
                if (!t2.c())
                {
                    View view3 = t2.itemView;
                    long l5 = a(t2);
                    if (obj1 != null && mState.c.get(Long.valueOf(l5)) != null)
                    {
                        ((android.support.v4.f.a) (obj1)).put(Long.valueOf(l5), t2);
                    } else
                    {
                        mState.b.put(t2, new g(t2, view3.getLeft(), view3.getTop(), view3.getRight(), view3.getBottom()));
                    }
                }
                l1++;
            }
            a(((android.support.v4.f.a) (obj2)));
            for (int i2 = mState.a.size() - 1; i2 >= 0; i2--)
            {
                t t3 = (t)mState.a.b(i2);
                if (!mState.b.containsKey(t3))
                {
                    g g1 = (g)mState.a.c(i2);
                    mState.a.d(i2);
                    View view4 = g1.a.itemView;
                    mRecycler.d(g1.a);
                    a(g1);
                }
            }

            int j2 = mState.b.size();
            if (j2 > 0)
            {
                j2--;
                while (j2 >= 0) 
                {
                    t t4 = (t)mState.b.b(j2);
                    g g4 = (g)mState.b.c(j2);
                    if (mState.a.isEmpty() || !mState.a.containsKey(t4))
                    {
                        mState.b.d(j2);
                        Rect rect;
                        if (obj2 != null)
                        {
                            rect = (Rect)((android.support.v4.f.a) (obj2)).get(t4.itemView);
                        } else
                        {
                            rect = null;
                        }
                        a(t4, rect, g4.b, g4.c);
                    }
                    j2--;
                }
            }
            i3 = mState.b.size();
            for (j2 = 0; j2 < i3; j2++)
            {
                obj2 = (t)mState.b.b(j2);
                g g2 = (g)mState.b.c(j2);
                g g3 = (g)mState.a.get(obj2);
                if (g3 == null || g2 == null || g3.b == g2.b && g3.c == g2.c)
                {
                    continue;
                }
                ((t) (obj2)).a(false);
                if (mItemAnimator.a(((t) (obj2)), g3.b, g3.c, g2.b, g2.c))
                {
                    x();
                }
            }

            View view2;
            if (mState.c != null)
            {
                j2 = mState.c.size();
            } else
            {
                j2 = 0;
            }
            j2--;
        }
        if (j2 < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        l6 = ((Long)mState.c.b(j2)).longValue();
        obj2 = (t)mState.c.get(Long.valueOf(l6));
        view2 = ((t) (obj2)).itemView;
        if (!((t) (obj2)).c() && android.support.v7.widget.m.a(mRecycler) != null && android.support.v7.widget.m.a(mRecycler).contains(obj2))
        {
            a(((t) (obj2)), (t)((android.support.v4.f.a) (obj1)).get(Long.valueOf(l6)));
        }
        j2--;
        if (true) goto _L15; else goto _L14
_L15:
        break MISSING_BLOCK_LABEL_1443;
_L14:
        a(false);
        mLayout.b(mRecycler);
        q.c(mState, mState.d);
        mDataSetHasChangedAfterLayout = false;
        q.c(mState, false);
        q.d(mState, false);
        mRunningLayoutOrScroll = false;
        android.support.v7.widget.h.a(mLayout, false);
        if (android.support.v7.widget.m.a(mRecycler) != null)
        {
            android.support.v7.widget.m.a(mRecycler).clear();
        }
        mState.c = null;
        if (k(mMinMaxLayoutPositions[0], mMinMaxLayoutPositions[1]))
        {
            l(0, 0);
            return;
        }
          goto _L16
_L4:
        l();
        mAdapterHelper.e();
        if (mState.c != null)
        {
            i3 = mChildHelper.b();
            for (l1 = 0; l1 < i3; l1++)
            {
                obj1 = b(mChildHelper.b(l1));
                if (((t) (obj1)).p() && !((t) (obj1)).r() && !((t) (obj1)).c())
                {
                    l4 = a(((t) (obj1)));
                    mState.c.put(Long.valueOf(l4), obj1);
                    mState.a.remove(obj1);
                }
            }

        }
        obj2 = null;
          goto _L17
        i3 = 0;
          goto _L18
    }

    void j()
    {
        int j1 = mChildHelper.c();
        for (int i1 = 0; i1 < j1; i1++)
        {
            ((i)mChildHelper.c(i1).getLayoutParams()).c = true;
        }

        mRecycler.j();
    }

    void k()
    {
        int j1 = mChildHelper.c();
        for (int i1 = 0; i1 < j1; i1++)
        {
            t t1 = b(mChildHelper.c(i1));
            if (!t1.c())
            {
                t1.b();
            }
        }

    }

    void l()
    {
        int j1 = mChildHelper.c();
        for (int i1 = 0; i1 < j1; i1++)
        {
            t t1 = b(mChildHelper.c(i1));
            if (!t1.c())
            {
                t1.a();
            }
        }

        mRecycler.i();
    }

    void m()
    {
        int j1 = mChildHelper.b();
        int i1 = 0;
        while (i1 < j1) 
        {
            t t1 = b(mChildHelper.b(i1));
            if (t1 != null && !t1.c())
            {
                if (t1.r() || t1.n())
                {
                    requestLayout();
                } else
                if (t1.o())
                {
                    int k1 = mAdapter.a(t1.mPosition);
                    if (t1.h() == k1)
                    {
                        if (!t1.p() || !w())
                        {
                            mAdapter.b(t1, t1.mPosition);
                        } else
                        {
                            requestLayout();
                        }
                    } else
                    {
                        t1.b(4);
                        requestLayout();
                    }
                }
            }
            i1++;
        }
    }

    void n()
    {
        int j1 = mChildHelper.c();
        for (int i1 = 0; i1 < j1; i1++)
        {
            t t1 = b(mChildHelper.c(i1));
            if (t1 != null && !t1.c())
            {
                t1.b(6);
            }
        }

        j();
        mRecycler.h();
    }

    public void o()
    {
        if (mItemDecorations.size() == 0)
        {
            return;
        }
        if (mLayout != null)
        {
            mLayout.a("Cannot invalidate item decorations during a scroll or layout");
        }
        j();
        requestLayout();
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        mIsAttached = true;
        mFirstLayoutComplete = false;
        if (mLayout != null)
        {
            mLayout.c(this);
        }
        mPostedAnimatorRunner = false;
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (mItemAnimator != null)
        {
            mItemAnimator.c();
        }
        mFirstLayoutComplete = false;
        c();
        mIsAttached = false;
        if (mLayout != null)
        {
            mLayout.a(this, mRecycler);
        }
        removeCallbacks(mItemAnimatorRunner);
    }

    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int j1 = mItemDecorations.size();
        for (int i1 = 0; i1 < j1; i1++)
        {
            ((f)mItemDecorations.get(i1)).a(canvas, this, mState);
        }

    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        byte byte0 = -1;
        if (!a(motionevent)) goto _L2; else goto _L1
_L1:
        v();
_L11:
        return true;
_L2:
        int i1;
        int k1;
        boolean flag;
        boolean flag1;
        flag = mLayout.d();
        flag1 = mLayout.e();
        if (mVelocityTracker == null)
        {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(motionevent);
        k1 = android.support.v4.view.t.a(motionevent);
        i1 = android.support.v4.view.t.b(motionevent);
        k1;
        JVM INSTR tableswitch 0 6: default 112
    //                   0 122
    //                   1 473
    //                   2 251
    //                   3 483
    //                   4 112
    //                   5 197
    //                   6 465;
           goto _L3 _L4 _L5 _L6 _L7 _L3 _L8 _L9
_L7:
        break MISSING_BLOCK_LABEL_483;
_L3:
        break; /* Loop/switch isn't completed */
_L4:
        break; /* Loop/switch isn't completed */
_L12:
        if (mScrollState != 1)
        {
            return false;
        }
        if (true) goto _L11; else goto _L10
_L10:
        mScrollPointerId = android.support.v4.view.t.b(motionevent, 0);
        i1 = (int)(motionevent.getX() + 0.5F);
        mLastTouchX = i1;
        mInitialTouchX = i1;
        i1 = (int)(motionevent.getY() + 0.5F);
        mLastTouchY = i1;
        mInitialTouchY = i1;
        if (mScrollState == 2)
        {
            getParent().requestDisallowInterceptTouchEvent(true);
            setScrollState(1);
        }
          goto _L12
_L8:
        mScrollPointerId = android.support.v4.view.t.b(motionevent, i1);
        int l1 = (int)(android.support.v4.view.t.c(motionevent, i1) + 0.5F);
        mLastTouchX = l1;
        mInitialTouchX = l1;
        i1 = (int)(android.support.v4.view.t.d(motionevent, i1) + 0.5F);
        mLastTouchY = i1;
        mInitialTouchY = i1;
          goto _L12
_L6:
        int i2 = android.support.v4.view.t.a(motionevent, mScrollPointerId);
        if (i2 < 0)
        {
            Log.e("RecyclerView", (new StringBuilder()).append("Error processing scroll; pointer index for id ").append(mScrollPointerId).append(" not found. Did any MotionEvents get skipped?").toString());
            return false;
        }
        int j1 = (int)(android.support.v4.view.t.c(motionevent, i2) + 0.5F);
        i2 = (int)(android.support.v4.view.t.d(motionevent, i2) + 0.5F);
        if (mScrollState != 1)
        {
            j1 -= mInitialTouchX;
            int k2 = i2 - mInitialTouchY;
            if (flag && Math.abs(j1) > mTouchSlop)
            {
                int j2 = mInitialTouchX;
                int l2 = mTouchSlop;
                if (j1 < 0)
                {
                    j1 = -1;
                } else
                {
                    j1 = 1;
                }
                mLastTouchX = j1 * l2 + j2;
                j1 = 1;
            } else
            {
                j1 = 0;
            }
            j2 = j1;
            if (flag1)
            {
                j2 = j1;
                if (Math.abs(k2) > mTouchSlop)
                {
                    j2 = mInitialTouchY;
                    l2 = mTouchSlop;
                    if (k2 < 0)
                    {
                        j1 = byte0;
                    } else
                    {
                        j1 = 1;
                    }
                    mLastTouchY = j2 + j1 * l2;
                    j2 = 1;
                }
            }
            if (j2 != 0)
            {
                setScrollState(1);
            }
        }
          goto _L12
_L9:
        c(motionevent);
          goto _L12
_L5:
        mVelocityTracker.clear();
          goto _L12
        v();
          goto _L12
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        b();
        i();
        a(false);
        mFirstLayoutComplete = true;
    }

    protected void onMeasure(int i1, int j1)
    {
        if (mAdapterUpdateDuringMeasure)
        {
            b();
            z();
            if (android.support.v7.widget.q.a(mState))
            {
                q.b(mState, true);
            } else
            {
                mAdapterHelper.e();
                q.b(mState, false);
            }
            mAdapterUpdateDuringMeasure = false;
            a(false);
        }
        if (mAdapter != null)
        {
            mState.d = mAdapter.a();
        } else
        {
            mState.d = 0;
        }
        if (mLayout == null)
        {
            j(i1, j1);
        } else
        {
            mLayout.a(mRecycler, mState, i1, j1);
        }
        q.b(mState, false);
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        mPendingSavedState = (SavedState)parcelable;
        super.onRestoreInstanceState(mPendingSavedState.getSuperState());
        if (mLayout != null && mPendingSavedState.a != null)
        {
            mLayout.a(mPendingSavedState.a);
        }
    }

    protected Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        if (mPendingSavedState != null)
        {
            android.support.v7.widget.SavedState.a(savedstate, mPendingSavedState);
            return savedstate;
        }
        if (mLayout != null)
        {
            savedstate.a = mLayout.c();
            return savedstate;
        } else
        {
            savedstate.a = null;
            return savedstate;
        }
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        if (i1 != k1 || j1 != l1)
        {
            h();
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        byte byte0 = -1;
        if (b(motionevent))
        {
            v();
            return true;
        }
        boolean flag = mLayout.d();
        boolean flag1 = mLayout.e();
        if (mVelocityTracker == null)
        {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(motionevent);
        int l1 = android.support.v4.view.t.a(motionevent);
        int i1 = android.support.v4.view.t.b(motionevent);
        switch (l1)
        {
        case 4: // '\004'
        default:
            return true;

        case 0: // '\0'
            mScrollPointerId = android.support.v4.view.t.b(motionevent, 0);
            i1 = (int)(motionevent.getX() + 0.5F);
            mLastTouchX = i1;
            mInitialTouchX = i1;
            i1 = (int)(motionevent.getY() + 0.5F);
            mLastTouchY = i1;
            mInitialTouchY = i1;
            return true;

        case 5: // '\005'
            mScrollPointerId = android.support.v4.view.t.b(motionevent, i1);
            int i2 = (int)(android.support.v4.view.t.c(motionevent, i1) + 0.5F);
            mLastTouchX = i2;
            mInitialTouchX = i2;
            i1 = (int)(android.support.v4.view.t.d(motionevent, i1) + 0.5F);
            mLastTouchY = i1;
            mInitialTouchY = i1;
            return true;

        case 2: // '\002'
            int j1 = android.support.v4.view.t.a(motionevent, mScrollPointerId);
            if (j1 < 0)
            {
                Log.e("RecyclerView", (new StringBuilder()).append("Error processing scroll; pointer index for id ").append(mScrollPointerId).append(" not found. Did any MotionEvents get skipped?").toString());
                return false;
            }
            int k2 = (int)(android.support.v4.view.t.c(motionevent, j1) + 0.5F);
            int l2 = (int)(android.support.v4.view.t.d(motionevent, j1) + 0.5F);
            if (mScrollState != 1)
            {
                int k1 = k2 - mInitialTouchX;
                int i3 = l2 - mInitialTouchY;
                float f1;
                float f2;
                int j2;
                if (flag && Math.abs(k1) > mTouchSlop)
                {
                    j2 = mInitialTouchX;
                    int j3 = mTouchSlop;
                    if (k1 < 0)
                    {
                        k1 = -1;
                    } else
                    {
                        k1 = 1;
                    }
                    mLastTouchX = k1 * j3 + j2;
                    k1 = 1;
                } else
                {
                    k1 = 0;
                }
                j2 = k1;
                if (flag1)
                {
                    j2 = k1;
                    if (Math.abs(i3) > mTouchSlop)
                    {
                        j2 = mInitialTouchY;
                        j3 = mTouchSlop;
                        if (i3 < 0)
                        {
                            k1 = byte0;
                        } else
                        {
                            k1 = 1;
                        }
                        mLastTouchY = j2 + k1 * j3;
                        j2 = 1;
                    }
                }
                if (j2 != 0)
                {
                    setScrollState(1);
                }
            }
            if (mScrollState == 1)
            {
                k1 = mLastTouchX;
                j2 = mLastTouchY;
                if (flag)
                {
                    k1 = -(k2 - k1);
                } else
                {
                    k1 = 0;
                }
                if (flag1)
                {
                    j2 = -(l2 - j2);
                } else
                {
                    j2 = 0;
                }
                if (a(k1, j2))
                {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
            }
            mLastTouchX = k2;
            mLastTouchY = l2;
            return true;

        case 6: // '\006'
            c(motionevent);
            return true;

        case 1: // '\001'
            mVelocityTracker.computeCurrentVelocity(1000, mMaxFlingVelocity);
            if (flag)
            {
                f1 = -ag.a(mVelocityTracker, mScrollPointerId);
            } else
            {
                f1 = 0.0F;
            }
            if (flag1)
            {
                f2 = -ag.b(mVelocityTracker, mScrollPointerId);
            } else
            {
                f2 = 0.0F;
            }
            if (f1 == 0.0F && f2 == 0.0F || !c((int)f1, (int)f2))
            {
                setScrollState(0);
            }
            mVelocityTracker.clear();
            u();
            return true;

        case 3: // '\003'
            v();
            return true;
        }
    }

    protected void removeDetachedView(View view, boolean flag)
    {
        t t1 = b(view);
        if (t1 != null)
        {
            if (t1.s())
            {
                t1.m();
            } else
            if (!t1.c())
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Called removeDetachedView with a view which is not flagged as tmp detached.").append(t1).toString());
            }
        }
        j(view);
        super.removeDetachedView(view, flag);
    }

    public void requestChildFocus(View view, View view1)
    {
        boolean flag = false;
        if (!mLayout.a(this, mState, view, view1) && view1 != null)
        {
            mTempRect.set(0, 0, view1.getWidth(), view1.getHeight());
            offsetDescendantRectToMyCoords(view1, mTempRect);
            offsetRectIntoDescendantCoords(view, mTempRect);
            Rect rect = mTempRect;
            if (!mFirstLayoutComplete)
            {
                flag = true;
            }
            requestChildRectangleOnScreen(view, rect, flag);
        }
        super.requestChildFocus(view, view1);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean flag)
    {
        return mLayout.a(this, view, rect, flag);
    }

    public void requestLayout()
    {
        if (!mEatRequestLayout)
        {
            super.requestLayout();
            return;
        } else
        {
            mLayoutRequestEaten = true;
            return;
        }
    }

    public void scrollBy(int i1, int j1)
    {
        if (mLayout == null)
        {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else
        {
            boolean flag = mLayout.d();
            boolean flag1 = mLayout.e();
            if (flag || flag1)
            {
                if (!flag)
                {
                    i1 = 0;
                }
                if (!flag1)
                {
                    j1 = 0;
                }
                a(i1, j1);
                return;
            }
        }
    }

    public void scrollTo(int i1, int j1)
    {
        throw new UnsupportedOperationException("RecyclerView does not support scrolling to an absolute position.");
    }

    public void setAccessibilityDelegateCompat(z z1)
    {
        mAccessibilityDelegate = z1;
        ai.a(this, mAccessibilityDelegate);
    }

    public void setAdapter(a a1)
    {
        a(a1, false, true);
        requestLayout();
    }

    public void setClipToPadding(boolean flag)
    {
        if (flag != mClipToPadding)
        {
            h();
        }
        mClipToPadding = flag;
        super.setClipToPadding(flag);
        if (mFirstLayoutComplete)
        {
            requestLayout();
        }
    }

    public void setHasFixedSize(boolean flag)
    {
        mHasFixedSize = flag;
    }

    public void setItemAnimator(d d1)
    {
        if (mItemAnimator != null)
        {
            mItemAnimator.c();
            mItemAnimator.a(null);
        }
        mItemAnimator = d1;
        if (mItemAnimator != null)
        {
            mItemAnimator.a(mItemAnimatorListener);
        }
    }

    public void setItemViewCacheSize(int i1)
    {
        mRecycler.a(i1);
    }

    public void setLayoutManager(h h1)
    {
        if (h1 == mLayout)
        {
            return;
        }
        if (mLayout != null)
        {
            if (mIsAttached)
            {
                mLayout.a(this, mRecycler);
            }
            mLayout.b(null);
        }
        mRecycler.a();
        mChildHelper.a();
        mLayout = h1;
        if (h1 != null)
        {
            if (h1.mRecyclerView != null)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("LayoutManager ").append(h1).append(" is already attached to a RecyclerView: ").append(h1.mRecyclerView).toString());
            }
            mLayout.b(this);
            if (mIsAttached)
            {
                mLayout.c(this);
            }
        }
        requestLayout();
    }

    public void setOnScrollListener(k k1)
    {
        mScrollListener = k1;
    }

    public void setRecycledViewPool(l l1)
    {
        mRecycler.a(l1);
    }

    public void setRecyclerListener(n n1)
    {
        mRecyclerListener = n1;
    }

    public void setScrollingTouchSlop(int i1)
    {
        ViewConfiguration viewconfiguration = ViewConfiguration.get(getContext());
        switch (i1)
        {
        default:
            Log.w("RecyclerView", (new StringBuilder()).append("setScrollingTouchSlop(): bad argument constant ").append(i1).append("; using default value").toString());
            // fall through

        case 0: // '\0'
            mTouchSlop = viewconfiguration.getScaledTouchSlop();
            return;

        case 1: // '\001'
            mTouchSlop = as.a(viewconfiguration);
            break;
        }
    }

    public void setViewCacheExtension(r r1)
    {
        mRecycler.a(r1);
    }

    static 
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT == 19 || android.os.Build.VERSION.SDK_INT == 20)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        FORCE_INVALIDATE_DISPLAY_LIST = flag;
    }
}

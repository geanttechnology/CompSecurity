// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;

// Referenced classes of package android.support.v7.widget:
//            RecyclerView

public static abstract class mTargetPosition
{
    public static class a
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

        static void a(a a1, RecyclerView recyclerview)
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
                        RecyclerView.t(recyclerview).b(a, b);
                    } else
                    {
                        RecyclerView.t(recyclerview).a(a, b, c);
                    }
                } else
                {
                    RecyclerView.t(recyclerview).a(a, b, c, d);
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

        public void a(int i)
        {
            e = true;
            a = i;
        }

        public void b(int i)
        {
            e = true;
            c = i;
        }

        public a(int i, int j)
        {
            this(i, j, 0x80000000, null);
        }

        public a(int i, int j, int k, Interpolator interpolator)
        {
            e = false;
            f = 0;
            a = i;
            b = j;
            c = k;
            d = interpolator;
        }
    }


    private mTargetPosition mLayoutManager;
    private boolean mPendingInitialRun;
    private RecyclerView mRecyclerView;
    private final a mRecyclingAction = new a(0, 0);
    private boolean mRunning;
    private int mTargetPosition;
    private View mTargetView;

    private void a(int i, int j)
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
                a.a(mRecyclingAction, mRecyclerView);
                a();
            } else
            {
                Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                mTargetView = null;
            }
        }
        if (mRunning)
        {
            a(i, j, mRecyclerView.mState, mRecyclingAction);
            a.a(mRecyclingAction, mRecyclerView);
        }
    }

    static void a(mRecyclerView mrecyclerview, int i, int j)
    {
        mrecyclerview.a(i, j);
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
            d(mRecyclerView.mState, -1);
            mTargetView = null;
            mTargetPosition = -1;
            mPendingInitialRun = false;
            mRunning = false;
            a(mLayoutManager, this);
            mLayoutManager = null;
            mRecyclerView = null;
            return;
        }
    }

    public void a(int i)
    {
        mTargetPosition = i;
    }

    protected abstract void a(int i, int j, a a1, a a2);

    void a(RecyclerView recyclerview, a a1)
    {
        mRecyclerView = recyclerview;
        mLayoutManager = a1;
        if (mTargetPosition == -1)
        {
            throw new IllegalArgumentException("Invalid target position");
        } else
        {
            d(mRecyclerView.mState, mTargetPosition);
            mRunning = true;
            mPendingInitialRun = true;
            mTargetView = b(d());
            e();
            RecyclerView.t(mRecyclerView).a();
            return;
        }
    }

    protected abstract void a(View view, a a1, a a2);

    public View b(int i)
    {
        return RecyclerView.d(mRecyclerView).c(i);
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

    public a.d()
    {
        mTargetPosition = -1;
    }
}

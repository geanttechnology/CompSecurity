// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream;

import android.support.v4.view.ai;
import android.support.v4.view.ba;
import android.support.v4.view.be;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class com.target.ui.fragment.cardstream.a extends android.support.v7.widget.RecyclerView.d
{
    private static class a
    {

        public int fromX;
        public int fromY;
        public android.support.v7.widget.RecyclerView.t holder;
        public int toX;
        public int toY;

        private a(android.support.v7.widget.RecyclerView.t t, int i, int k, int l, int i1)
        {
            holder = t;
            fromX = i;
            fromY = k;
            toX = l;
            toY = i1;
        }

    }

    protected static class b
        implements be
    {

        public void a(View view)
        {
        }

        public void b(View view)
        {
        }

        public void c(View view)
        {
        }

        protected b()
        {
        }
    }


    protected ArrayList mAddAnimations;
    private ArrayList mAdditions;
    protected ArrayList mMoveAnimations;
    private ArrayList mMoves;
    private ArrayList mPendingAdditions;
    private ArrayList mPendingMoves;
    private ArrayList mPendingRemovals;
    protected RecyclerView mRecyclerView;
    protected ArrayList mRemoveAnimations;

    public com.target.ui.fragment.cardstream.a(RecyclerView recyclerview)
    {
        mPendingRemovals = new ArrayList();
        mPendingAdditions = new ArrayList();
        mPendingMoves = new ArrayList();
        mAdditions = new ArrayList();
        mMoves = new ArrayList();
        mAddAnimations = new ArrayList();
        mMoveAnimations = new ArrayList();
        mRemoveAnimations = new ArrayList();
        mRecyclerView = recyclerview;
    }

    static ArrayList a(com.target.ui.fragment.cardstream.a a1)
    {
        return a1.mMoves;
    }

    static ArrayList b(com.target.ui.fragment.cardstream.a a1)
    {
        return a1.mAdditions;
    }

    public void a()
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        if (!mPendingRemovals.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!mPendingMoves.isEmpty())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!mPendingAdditions.isEmpty())
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (flag || flag1 || flag2)
        {
            for (Iterator iterator = mPendingRemovals.iterator(); iterator.hasNext(); r((android.support.v7.widget.RecyclerView.t)iterator.next())) { }
            mPendingRemovals.clear();
            Runnable runnable;
            if (flag1)
            {
                mMoves.addAll(mPendingMoves);
                mPendingMoves.clear();
                runnable = new Runnable() {

                    final com.target.ui.fragment.cardstream.a this$0;

                    public void run()
                    {
                        a a1;
                        for (Iterator iterator1 = com.target.ui.fragment.cardstream.a.a(com.target.ui.fragment.cardstream.a.this).iterator(); iterator1.hasNext(); b(a1.holder, a1.fromX, a1.fromY, a1.toX, a1.toY))
                        {
                            a1 = (a)iterator1.next();
                        }

                        com.target.ui.fragment.cardstream.a.a(com.target.ui.fragment.cardstream.a.this).clear();
                    }

            
            {
                this$0 = com.target.ui.fragment.cardstream.a.this;
                super();
            }
                };
                View view;
                if (flag)
                {
                    ai.a(((a)mMoves.get(0)).holder.itemView, runnable, f());
                } else
                {
                    runnable.run();
                }
            }
            if (flag2)
            {
                mAdditions.addAll(mPendingAdditions);
                mPendingAdditions.clear();
                runnable = new Runnable() {

                    final com.target.ui.fragment.cardstream.a this$0;

                    public void run()
                    {
                        android.support.v7.widget.RecyclerView.t t;
                        for (Iterator iterator1 = com.target.ui.fragment.cardstream.a.b(com.target.ui.fragment.cardstream.a.this).iterator(); iterator1.hasNext(); q(t))
                        {
                            t = (android.support.v7.widget.RecyclerView.t)iterator1.next();
                        }

                        com.target.ui.fragment.cardstream.a.b(com.target.ui.fragment.cardstream.a.this).clear();
                    }

            
            {
                this$0 = com.target.ui.fragment.cardstream.a.this;
                super();
            }
                };
                if (flag || flag1)
                {
                    view = ((android.support.v7.widget.RecyclerView.t)mAdditions.get(0)).itemView;
                    long l;
                    long l1;
                    if (flag)
                    {
                        l = f();
                    } else
                    {
                        l = 0L;
                    }
                    if (flag1)
                    {
                        l1 = d();
                    } else
                    {
                        l1 = 0L;
                    }
                    ai.a(view, runnable, l1 + l);
                    return;
                } else
                {
                    runnable.run();
                    return;
                }
            }
        }
    }

    public boolean a(android.support.v7.widget.RecyclerView.t t)
    {
        mPendingRemovals.add(t);
        return true;
    }

    public boolean a(android.support.v7.widget.RecyclerView.t t, int i, int k, int l, int i1)
    {
        View view = t.itemView;
        int j1 = l - i;
        int k1 = i1 - k;
        if (j1 == 0 && k1 == 0)
        {
            e(t);
            return false;
        }
        if (j1 != 0)
        {
            ai.a(view, -j1);
        }
        if (k1 != 0)
        {
            ai.b(view, -k1);
        }
        mPendingMoves.add(new a(t, i, k, l, i1));
        return true;
    }

    protected void b(final android.support.v7.widget.RecyclerView.t holder, final int deltaX, final int deltaY, int i, int k)
    {
        View view = holder.itemView;
        deltaX = i - deltaX;
        deltaY = k - deltaY;
        ai.s(view).a();
        if (deltaX != 0)
        {
            ai.s(view).b(0.0F);
        }
        if (deltaY != 0)
        {
            ai.s(view).c(0.0F);
        }
        ai.s(view).a(d()).a(new b() {

            final com.target.ui.fragment.cardstream.a this$0;
            final int val$deltaX;
            final int val$deltaY;
            final android.support.v7.widget.RecyclerView.t val$holder;

            public void b(View view1)
            {
                e(holder);
                mMoveAnimations.remove(holder);
                j();
            }

            public void c(View view1)
            {
                if (deltaX != 0)
                {
                    ai.a(view1, 0.0F);
                }
                if (deltaY != 0)
                {
                    ai.b(view1, 0.0F);
                }
            }

            
            {
                this$0 = com.target.ui.fragment.cardstream.a.this;
                deltaX = i;
                deltaY = k;
                holder = t;
                super();
            }
        }).b();
        mMoveAnimations.add(holder);
    }

    public boolean b()
    {
        return !mMoveAnimations.isEmpty() || !mRemoveAnimations.isEmpty() || !mAddAnimations.isEmpty() || !mMoves.isEmpty() || !mAdditions.isEmpty();
    }

    public boolean b(android.support.v7.widget.RecyclerView.t t)
    {
        p(t);
        mPendingAdditions.add(t);
        return true;
    }

    public void c()
    {
        for (int i = mPendingMoves.size() - 1; i >= 0; i--)
        {
            a a1 = (a)mPendingMoves.get(i);
            View view = a1.holder.itemView;
            ai.s(view).a();
            ai.b(view, 0.0F);
            ai.a(view, 0.0F);
            e(a1.holder);
            mPendingMoves.remove(a1);
        }

        for (int k = mPendingRemovals.size() - 1; k >= 0; k--)
        {
            android.support.v7.widget.RecyclerView.t t = (android.support.v7.widget.RecyclerView.t)mPendingRemovals.get(k);
            d(t);
            mPendingRemovals.remove(t);
        }

        for (int l = mPendingAdditions.size() - 1; l >= 0; l--)
        {
            android.support.v7.widget.RecyclerView.t t1 = (android.support.v7.widget.RecyclerView.t)mPendingAdditions.get(l);
            ai.c(t1.itemView, 1.0F);
            f(t1);
            mPendingAdditions.remove(t1);
        }

        if (!b())
        {
            return;
        }
        for (int i1 = mMoveAnimations.size() - 1; i1 >= 0; i1--)
        {
            android.support.v7.widget.RecyclerView.t t2 = (android.support.v7.widget.RecyclerView.t)mMoveAnimations.get(i1);
            View view1 = t2.itemView;
            ai.s(view1).a();
            ai.b(view1, 0.0F);
            ai.a(view1, 0.0F);
            e(t2);
            mMoveAnimations.remove(t2);
        }

        for (int j1 = mRemoveAnimations.size() - 1; j1 >= 0; j1--)
        {
            android.support.v7.widget.RecyclerView.t t3 = (android.support.v7.widget.RecyclerView.t)mRemoveAnimations.get(j1);
            View view2 = t3.itemView;
            ai.s(view2).a();
            ai.c(view2, 1.0F);
            d(t3);
            mRemoveAnimations.remove(t3);
        }

        for (int k1 = mAddAnimations.size() - 1; k1 >= 0; k1--)
        {
            android.support.v7.widget.RecyclerView.t t4 = (android.support.v7.widget.RecyclerView.t)mAddAnimations.get(k1);
            View view3 = t4.itemView;
            ai.s(view3).a();
            ai.c(view3, 1.0F);
            f(t4);
            mAddAnimations.remove(t4);
        }

        mMoves.clear();
        mAdditions.clear();
        i();
    }

    public void c(android.support.v7.widget.RecyclerView.t t)
    {
        View view = t.itemView;
        ai.s(view).a();
        if (mPendingMoves.contains(t))
        {
            ai.b(view, 0.0F);
            ai.a(view, 0.0F);
            e(t);
            mPendingMoves.remove(t);
        }
        if (mPendingRemovals.contains(t))
        {
            d(t);
            mPendingRemovals.remove(t);
        }
        if (mPendingAdditions.contains(t))
        {
            ai.c(view, 1.0F);
            f(t);
            mPendingAdditions.remove(t);
        }
        if (mMoveAnimations.contains(t))
        {
            ai.b(view, 0.0F);
            ai.a(view, 0.0F);
            e(t);
            mMoveAnimations.remove(t);
        }
        if (mRemoveAnimations.contains(t))
        {
            ai.c(view, 1.0F);
            d(t);
            mRemoveAnimations.remove(t);
        }
        if (mAddAnimations.contains(t))
        {
            ai.c(view, 1.0F);
            f(t);
            mAddAnimations.remove(t);
        }
        j();
    }

    protected void j()
    {
        if (!b())
        {
            i();
        }
    }

    protected abstract void p(android.support.v7.widget.RecyclerView.t t);

    protected abstract void q(android.support.v7.widget.RecyclerView.t t);

    protected abstract void r(android.support.v7.widget.RecyclerView.t t);
}

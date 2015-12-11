// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.a;

import android.support.v4.view.ai;
import android.support.v4.view.ba;
import android.support.v4.view.be;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class com.target.ui.a.a extends android.support.v7.widget.RecyclerView.d
{
    private static class a
    {

        public int fromX;
        public int fromY;
        public android.support.v7.widget.RecyclerView.t newHolder;
        public android.support.v7.widget.RecyclerView.t oldHolder;
        public int toX;
        public int toY;

        public String toString()
        {
            return (new StringBuilder()).append("ChangeInfo{oldHolder=").append(oldHolder).append(", newHolder=").append(newHolder).append(", fromX=").append(fromX).append(", fromY=").append(fromY).append(", toX=").append(toX).append(", toY=").append(toY).append('}').toString();
        }

        private a(android.support.v7.widget.RecyclerView.t t, android.support.v7.widget.RecyclerView.t t1)
        {
            oldHolder = t;
            newHolder = t1;
        }

        private a(android.support.v7.widget.RecyclerView.t t, android.support.v7.widget.RecyclerView.t t1, int i, int k, int l, int i1)
        {
            this(t, t1);
            fromX = i;
            fromY = k;
            toX = l;
            toY = i1;
        }

    }

    private static class b
    {

        public int fromX;
        public int fromY;
        public android.support.v7.widget.RecyclerView.t holder;
        public int toX;
        public int toY;

        private b(android.support.v7.widget.RecyclerView.t t, int i, int k, int l, int i1)
        {
            holder = t;
            fromX = i;
            fromY = k;
            toX = l;
            toY = i1;
        }

    }

    private static class c
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

        private c()
        {
        }

    }


    private static final boolean DEBUG = false;
    private ArrayList mAddAnimations;
    private ArrayList mAdditionsList;
    private ArrayList mChangeAnimations;
    private ArrayList mChangesList;
    private android.support.v7.widget.RecyclerView.d.a mListener;
    private ArrayList mMoveAnimations;
    private ArrayList mMovesList;
    private ArrayList mPendingAdditions;
    private ArrayList mPendingChanges;
    private ArrayList mPendingMoves;
    private ArrayList mPendingRemovals;
    private ArrayList mRemoveAnimations;

    public com.target.ui.a.a()
    {
        mPendingRemovals = new ArrayList();
        mPendingAdditions = new ArrayList();
        mPendingMoves = new ArrayList();
        mPendingChanges = new ArrayList();
        mAdditionsList = new ArrayList();
        mMovesList = new ArrayList();
        mChangesList = new ArrayList();
        mAddAnimations = new ArrayList();
        mMoveAnimations = new ArrayList();
        mRemoveAnimations = new ArrayList();
        mChangeAnimations = new ArrayList();
    }

    static ArrayList a(com.target.ui.a.a a1)
    {
        return a1.mMovesList;
    }

    private void a(final a changeInfo)
    {
        final ba oldViewAnim = changeInfo.oldHolder.itemView;
        final View newView = changeInfo.newHolder;
        if (newView != null)
        {
            newView = ((android.support.v7.widget.RecyclerView.t) (newView)).itemView;
        } else
        {
            newView = null;
        }
        mChangeAnimations.add(changeInfo.oldHolder);
        oldViewAnim = ai.s(oldViewAnim).a(g());
        oldViewAnim.b(changeInfo.toX - changeInfo.fromX);
        oldViewAnim.c(changeInfo.toY - changeInfo.fromY);
        oldViewAnim.a(0.0F).a(new c() {

            final com.target.ui.a.a this$0;
            final a val$changeInfo;
            final ba val$oldViewAnim;

            public void a(View view)
            {
                com.target.ui.a.a.this.b(changeInfo.oldHolder, true);
            }

            public void b(View view)
            {
                oldViewAnim.a(null);
                ai.c(view, 1.0F);
                ai.a(view, 0.0F);
                ai.b(view, 0.0F);
                com.target.ui.a.a.this.a(changeInfo.oldHolder, true);
                com.target.ui.a.a.g(com.target.ui.a.a.this).remove(changeInfo.oldHolder);
                j();
            }

            
            {
                this$0 = com.target.ui.a.a.this;
                changeInfo = a2;
                oldViewAnim = ba1;
                super();
            }
        }).b();
        if (newView != null)
        {
            mChangeAnimations.add(changeInfo.newHolder);
            final ba newViewAnimation = ai.s(newView);
            newViewAnimation.b(0.0F).c(0.0F).a(g()).a(1.0F).a(new c() {

                final com.target.ui.a.a this$0;
                final a val$changeInfo;
                final View val$newView;
                final ba val$newViewAnimation;

                public void a(View view)
                {
                    com.target.ui.a.a.this.b(changeInfo.newHolder, false);
                }

                public void b(View view)
                {
                    newViewAnimation.a(null);
                    ai.c(newView, 1.0F);
                    ai.a(newView, 0.0F);
                    ai.b(newView, 0.0F);
                    com.target.ui.a.a.this.a(changeInfo.newHolder, false);
                    com.target.ui.a.a.g(com.target.ui.a.a.this).remove(changeInfo.newHolder);
                    j();
                }

            
            {
                this$0 = com.target.ui.a.a.this;
                changeInfo = a2;
                newViewAnimation = ba1;
                newView = view;
                super();
            }
            }).b();
        }
    }

    static void a(com.target.ui.a.a a1, android.support.v7.widget.RecyclerView.t t)
    {
        a1.q(t);
    }

    static void a(com.target.ui.a.a a1, android.support.v7.widget.RecyclerView.t t, int i, int k, int l, int i1)
    {
        a1.b(t, i, k, l, i1);
    }

    static void a(com.target.ui.a.a a1, a a2)
    {
        a1.a(a2);
    }

    private void a(List list, android.support.v7.widget.RecyclerView.t t)
    {
        for (int i = list.size() - 1; i >= 0; i--)
        {
            a a1 = (a)list.get(i);
            if (a(a1, t) && a1.oldHolder == null && a1.newHolder == null)
            {
                list.remove(a1);
            }
        }

    }

    private boolean a(a a1, android.support.v7.widget.RecyclerView.t t)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = false;
        if (a1.newHolder != t) goto _L2; else goto _L1
_L1:
        a1.newHolder = null;
_L6:
        ai.c(t.itemView, 1.0F);
        ai.a(t.itemView, 0.0F);
        ai.b(t.itemView, 0.0F);
        a(t, flag);
        flag = true;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (a1.oldHolder != t) goto _L4; else goto _L3
_L3:
        a1.oldHolder = null;
        flag = true;
        if (true) goto _L6; else goto _L5
_L5:
    }

    static ArrayList b(com.target.ui.a.a a1)
    {
        return a1.mChangesList;
    }

    private void b(final android.support.v7.widget.RecyclerView.t holder, final int deltaX, final int deltaY, int i, int k)
    {
        final ba animation = holder.itemView;
        deltaX = i - deltaX;
        deltaY = k - deltaY;
        if (deltaX != 0)
        {
            ai.s(animation).b(0.0F);
        }
        if (deltaY != 0)
        {
            ai.s(animation).c(0.0F);
        }
        mMoveAnimations.add(holder);
        animation = ai.s(animation);
        animation.a(d()).a(new c() {

            final com.target.ui.a.a this$0;
            final ba val$animation;
            final int val$deltaX;
            final int val$deltaY;
            final android.support.v7.widget.RecyclerView.t val$holder;

            public void a(View view)
            {
                h(holder);
            }

            public void b(View view)
            {
                animation.a(null);
                e(holder);
                com.target.ui.a.a.f(com.target.ui.a.a.this).remove(holder);
                j();
            }

            public void c(View view)
            {
                if (deltaX != 0)
                {
                    ai.a(view, 0.0F);
                }
                if (deltaY != 0)
                {
                    ai.b(view, 0.0F);
                }
            }

            
            {
                this$0 = com.target.ui.a.a.this;
                holder = t;
                deltaX = i;
                deltaY = k;
                animation = ba1;
                super();
            }
        }).b();
    }

    private void b(a a1)
    {
        if (a1.oldHolder != null)
        {
            a(a1, a1.oldHolder);
        }
        if (a1.newHolder != null)
        {
            a(a1, a1.newHolder);
        }
    }

    static ArrayList c(com.target.ui.a.a a1)
    {
        return a1.mAdditionsList;
    }

    static ArrayList d(com.target.ui.a.a a1)
    {
        return a1.mRemoveAnimations;
    }

    static ArrayList e(com.target.ui.a.a a1)
    {
        return a1.mAddAnimations;
    }

    static ArrayList f(com.target.ui.a.a a1)
    {
        return a1.mMoveAnimations;
    }

    static ArrayList g(com.target.ui.a.a a1)
    {
        return a1.mChangeAnimations;
    }

    private void p(final android.support.v7.widget.RecyclerView.t holder)
    {
        final ba animation = ai.s(holder.itemView);
        animation.a(f()).a(0.0F).a(new c() {

            final com.target.ui.a.a this$0;
            final ba val$animation;
            final android.support.v7.widget.RecyclerView.t val$holder;

            public void a(View view)
            {
                g(holder);
            }

            public void b(View view)
            {
                animation.a(null);
                ai.c(view, 1.0F);
                d(holder);
                com.target.ui.a.a.d(com.target.ui.a.a.this).remove(holder);
                j();
            }

            
            {
                this$0 = com.target.ui.a.a.this;
                holder = t;
                animation = ba1;
                super();
            }
        }).b();
        mRemoveAnimations.add(holder);
    }

    private void q(final android.support.v7.widget.RecyclerView.t holder)
    {
        final ba animation = holder.itemView;
        mAddAnimations.add(holder);
        animation = ai.s(animation);
        animation.a(1.0F).a(e()).a(new c() {

            final com.target.ui.a.a this$0;
            final ba val$animation;
            final android.support.v7.widget.RecyclerView.t val$holder;

            public void a(View view)
            {
                i(holder);
            }

            public void b(View view)
            {
                animation.a(null);
                f(holder);
                com.target.ui.a.a.e(com.target.ui.a.a.this).remove(holder);
                j();
            }

            public void c(View view)
            {
                ai.c(view, 1.0F);
            }

            
            {
                this$0 = com.target.ui.a.a.this;
                holder = t;
                animation = ba1;
                super();
            }
        }).b();
    }

    public void a()
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
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
        if (!mPendingChanges.isEmpty())
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (!mPendingAdditions.isEmpty())
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        if (flag || flag1 || flag3 || flag2)
        {
            for (Iterator iterator = mPendingRemovals.iterator(); iterator.hasNext(); p((android.support.v7.widget.RecyclerView.t)iterator.next())) { }
            mPendingRemovals.clear();
            Runnable runnable;
            if (flag1)
            {
                final ArrayList moves = new ArrayList();
                moves.addAll(mPendingMoves);
                mMovesList.add(moves);
                mPendingMoves.clear();
                runnable = new Runnable() {

                    final com.target.ui.a.a this$0;
                    final ArrayList val$moves;

                    public void run()
                    {
                        b b1;
                        for (Iterator iterator1 = moves.iterator(); iterator1.hasNext(); com.target.ui.a.a.a(com.target.ui.a.a.this, b1.holder, b1.fromX, b1.fromY, b1.toX, b1.toY))
                        {
                            b1 = (b)iterator1.next();
                        }

                        moves.clear();
                        com.target.ui.a.a.a(com.target.ui.a.a.this).remove(moves);
                    }

            
            {
                this$0 = com.target.ui.a.a.this;
                moves = arraylist;
                super();
            }
                };
                final ArrayList changes;
                final ArrayList additions;
                if (flag)
                {
                    ai.a(((b)moves.get(0)).holder.itemView, runnable, f());
                } else
                {
                    runnable.run();
                }
            }
            if (flag2)
            {
                changes = new ArrayList();
                changes.addAll(mPendingChanges);
                mChangesList.add(changes);
                mPendingChanges.clear();
                runnable = new Runnable() {

                    final com.target.ui.a.a this$0;
                    final ArrayList val$changes;

                    public void run()
                    {
                        a a1;
                        for (Iterator iterator1 = changes.iterator(); iterator1.hasNext(); com.target.ui.a.a.a(com.target.ui.a.a.this, a1))
                        {
                            a1 = (a)iterator1.next();
                        }

                        changes.clear();
                        com.target.ui.a.a.b(com.target.ui.a.a.this).remove(changes);
                    }

            
            {
                this$0 = com.target.ui.a.a.this;
                changes = arraylist;
                super();
            }
                };
                if (flag)
                {
                    ai.a(((a)changes.get(0)).oldHolder.itemView, runnable, f());
                } else
                {
                    runnable.run();
                }
            }
            if (flag3)
            {
                additions = new ArrayList();
                additions.addAll(mPendingAdditions);
                mAdditionsList.add(additions);
                mPendingAdditions.clear();
                runnable = new Runnable() {

                    final com.target.ui.a.a this$0;
                    final ArrayList val$additions;

                    public void run()
                    {
                        android.support.v7.widget.RecyclerView.t t;
                        for (Iterator iterator1 = additions.iterator(); iterator1.hasNext(); com.target.ui.a.a.a(com.target.ui.a.a.this, t))
                        {
                            t = (android.support.v7.widget.RecyclerView.t)iterator1.next();
                        }

                        additions.clear();
                        com.target.ui.a.a.c(com.target.ui.a.a.this).remove(additions);
                    }

            
            {
                this$0 = com.target.ui.a.a.this;
                additions = arraylist;
                super();
            }
                };
                if (flag || flag1 || flag2)
                {
                    long l;
                    long l1;
                    long l2;
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
                    if (flag2)
                    {
                        l2 = g();
                    } else
                    {
                        l2 = 0L;
                    }
                    l1 = Math.max(l1, l2);
                    ai.a(((android.support.v7.widget.RecyclerView.t)additions.get(0)).itemView, runnable, l + l1);
                    return;
                } else
                {
                    runnable.run();
                    return;
                }
            }
        }
    }

    void a(List list)
    {
        for (int i = list.size() - 1; i >= 0; i--)
        {
            ai.s(((android.support.v7.widget.RecyclerView.t)list.get(i)).itemView).a();
        }

    }

    public boolean a(android.support.v7.widget.RecyclerView.t t)
    {
        c(t);
        mPendingRemovals.add(t);
        return true;
    }

    public boolean a(android.support.v7.widget.RecyclerView.t t, int i, int k, int l, int i1)
    {
        View view = t.itemView;
        i = (int)((float)i + ai.o(t.itemView));
        k = (int)((float)k + ai.p(t.itemView));
        c(t);
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
        mPendingMoves.add(new b(t, i, k, l, i1));
        return true;
    }

    public boolean a(android.support.v7.widget.RecyclerView.t t, android.support.v7.widget.RecyclerView.t t1, int i, int k, int l, int i1)
    {
        float f1 = ai.o(t.itemView);
        float f2 = ai.p(t.itemView);
        float f3 = ai.f(t.itemView);
        c(t);
        int j1 = (int)((float)(l - i) - f1);
        int k1 = (int)((float)(i1 - k) - f2);
        ai.a(t.itemView, f1);
        ai.b(t.itemView, f2);
        ai.c(t.itemView, f3);
        if (t1 != null && t1.itemView != null)
        {
            c(t1);
            ai.a(t1.itemView, -j1);
            ai.b(t1.itemView, -k1);
            ai.c(t1.itemView, 0.0F);
        }
        mPendingChanges.add(new a(t, t1, i, k, l, i1));
        return true;
    }

    public void b(android.support.v7.widget.RecyclerView.d.a a1)
    {
        mListener = a1;
    }

    public boolean b()
    {
        return !mPendingAdditions.isEmpty() || !mPendingChanges.isEmpty() || !mPendingMoves.isEmpty() || !mPendingRemovals.isEmpty() || !mMoveAnimations.isEmpty() || !mRemoveAnimations.isEmpty() || !mAddAnimations.isEmpty() || !mChangeAnimations.isEmpty() || !mMovesList.isEmpty() || !mAdditionsList.isEmpty() || !mChangesList.isEmpty();
    }

    public boolean b(android.support.v7.widget.RecyclerView.t t)
    {
        c(t);
        ai.c(t.itemView, 0.0F);
        mPendingAdditions.add(t);
        return true;
    }

    public void c()
    {
        for (int i = mPendingMoves.size() - 1; i >= 0; i--)
        {
            b b1 = (b)mPendingMoves.get(i);
            View view = b1.holder.itemView;
            ai.b(view, 0.0F);
            ai.a(view, 0.0F);
            e(b1.holder);
            mPendingMoves.remove(i);
        }

        for (int k = mPendingRemovals.size() - 1; k >= 0; k--)
        {
            d((android.support.v7.widget.RecyclerView.t)mPendingRemovals.get(k));
            mPendingRemovals.remove(k);
        }

        for (int l = mPendingAdditions.size() - 1; l >= 0; l--)
        {
            android.support.v7.widget.RecyclerView.t t = (android.support.v7.widget.RecyclerView.t)mPendingAdditions.get(l);
            ai.c(t.itemView, 1.0F);
            f(t);
            mPendingAdditions.remove(l);
        }

        for (int i1 = mPendingChanges.size() - 1; i1 >= 0; i1--)
        {
            b((a)mPendingChanges.get(i1));
        }

        mPendingChanges.clear();
        if (!b())
        {
            return;
        }
        for (int j1 = mMovesList.size() - 1; j1 >= 0; j1--)
        {
            ArrayList arraylist = (ArrayList)mMovesList.get(j1);
            for (int i2 = arraylist.size() - 1; i2 >= 0; i2--)
            {
                b b2 = (b)arraylist.get(i2);
                View view1 = b2.holder.itemView;
                ai.b(view1, 0.0F);
                ai.a(view1, 0.0F);
                e(b2.holder);
                arraylist.remove(i2);
                if (arraylist.isEmpty())
                {
                    mMovesList.remove(arraylist);
                }
            }

        }

        for (int k1 = mAdditionsList.size() - 1; k1 >= 0; k1--)
        {
            ArrayList arraylist1 = (ArrayList)mAdditionsList.get(k1);
            for (int j2 = arraylist1.size() - 1; j2 >= 0; j2--)
            {
                android.support.v7.widget.RecyclerView.t t1 = (android.support.v7.widget.RecyclerView.t)arraylist1.get(j2);
                ai.c(t1.itemView, 1.0F);
                f(t1);
                arraylist1.remove(j2);
                if (arraylist1.isEmpty())
                {
                    mAdditionsList.remove(arraylist1);
                }
            }

        }

        for (int l1 = mChangesList.size() - 1; l1 >= 0; l1--)
        {
            ArrayList arraylist2 = (ArrayList)mChangesList.get(l1);
            for (int k2 = arraylist2.size() - 1; k2 >= 0; k2--)
            {
                b((a)arraylist2.get(k2));
                if (arraylist2.isEmpty())
                {
                    mChangesList.remove(arraylist2);
                }
            }

        }

        a(mRemoveAnimations);
        a(mMoveAnimations);
        a(mAddAnimations);
        a(mChangeAnimations);
        i();
    }

    public void c(android.support.v7.widget.RecyclerView.t t)
    {
        View view = t.itemView;
        ai.s(view).a();
        for (int i = mPendingMoves.size() - 1; i >= 0; i--)
        {
            if (((b)mPendingMoves.get(i)).holder == t)
            {
                ai.b(view, 0.0F);
                ai.a(view, 0.0F);
                e(t);
                mPendingMoves.remove(t);
            }
        }

        a(mPendingChanges, t);
        if (mPendingRemovals.remove(t))
        {
            ai.c(view, 1.0F);
            d(t);
        }
        if (mPendingAdditions.remove(t))
        {
            ai.c(view, 1.0F);
            f(t);
        }
        for (int k = mChangesList.size() - 1; k >= 0; k--)
        {
            ArrayList arraylist = (ArrayList)mChangesList.get(k);
            a(arraylist, t);
            if (arraylist.isEmpty())
            {
                mChangesList.remove(arraylist);
            }
        }

        int l = mMovesList.size() - 1;
label0:
        do
        {
            if (l >= 0)
            {
                ArrayList arraylist1 = (ArrayList)mMovesList.get(l);
                int j1 = arraylist1.size() - 1;
                do
                {
label1:
                    {
                        if (j1 >= 0)
                        {
                            if (((b)arraylist1.get(j1)).holder != t)
                            {
                                break label1;
                            }
                            ai.b(view, 0.0F);
                            ai.a(view, 0.0F);
                            e(t);
                            arraylist1.remove(j1);
                            if (arraylist1.isEmpty())
                            {
                                mMovesList.remove(arraylist1);
                            }
                        }
                        l--;
                        continue label0;
                    }
                    j1--;
                } while (true);
            }
            for (int i1 = mAdditionsList.size() - 1; i1 >= 0; i1--)
            {
                ArrayList arraylist2 = (ArrayList)mAdditionsList.get(i1);
                if (!arraylist2.remove(t))
                {
                    continue;
                }
                ai.c(view, 1.0F);
                f(t);
                if (arraylist2.isEmpty())
                {
                    mAdditionsList.remove(arraylist2);
                }
            }

            if (!mRemoveAnimations.remove(t));
            if (!mAddAnimations.remove(t));
            if (!mChangeAnimations.remove(t));
            if (!mMoveAnimations.remove(t));
            j();
            return;
        } while (true);
    }

    public void j()
    {
        if (!b())
        {
            i();
            if (mListener != null)
            {
                mListener.a();
            }
        }
    }
}

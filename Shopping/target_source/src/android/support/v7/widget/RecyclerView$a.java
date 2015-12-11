// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.ViewGroup;

// Referenced classes of package android.support.v7.widget:
//            RecyclerView

public static abstract class mHasStableIds
{

    private boolean mHasStableIds;
    private final c mObservable = new <init>();

    public abstract int a();

    public int a(int i)
    {
        return 0;
    }

    public abstract mHasStableIds a(ViewGroup viewgroup, int i);

    public final void a(int i, int j)
    {
        mObservable.d(i, j);
    }

    public void a(d d1)
    {
        mObservable.registerObserver(d1);
    }

    public void a(registerObserver registerobserver)
    {
    }

    public abstract void a(registerObserver registerobserver, int i);

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

    public long b(int i)
    {
        return -1L;
    }

    public final mHasStableIds b(ViewGroup viewgroup, int i)
    {
        viewgroup = a(viewgroup, i);
        viewgroup.mItemViewType = i;
        return viewgroup;
    }

    public void b(mItemViewType mitemviewtype)
    {
        mObservable.unregisterObserver(mitemviewtype);
    }

    public final void b(unregisterObserver unregisterobserver, int i)
    {
        unregisterobserver.mPosition = i;
        if (b())
        {
            unregisterobserver.mItemId = b(i);
        }
        a(unregisterobserver, i);
        unregisterobserver.a(1, 519);
    }

    public void b(RecyclerView recyclerview)
    {
    }

    public final boolean b()
    {
        return mHasStableIds;
    }

    public boolean b(mHasStableIds mhasstableids)
    {
        return false;
    }

    public final void c(int i)
    {
        mObservable.a(i, 1);
    }

    public void c(a a1)
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

    public final void d(int i)
    {
        mObservable.b(i, 1);
    }

    public void d(b b1)
    {
    }

    public final void e(int i)
    {
        mObservable.c(i, 1);
    }

    public ()
    {
        mHasStableIds = false;
    }
}

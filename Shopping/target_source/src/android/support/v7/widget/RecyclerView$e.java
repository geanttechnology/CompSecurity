// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;


// Referenced classes of package android.support.v7.widget:
//            RecyclerView

private class <init>
    implements b
{

    final RecyclerView a;

    public void a(b b1)
    {
        b1.a(true);
        if (!RecyclerView.e(a, b1.itemView) && b1.s())
        {
            a.removeDetachedView(b1.itemView, false);
        }
    }

    public void b(itemView itemview)
    {
        itemview.a(true);
        if (!b(itemview))
        {
            RecyclerView.e(a, itemview.itemView);
        }
    }

    public void c(itemView itemview)
    {
        itemview.a(true);
        if (!b(itemview))
        {
            RecyclerView.e(a, itemview.itemView);
        }
    }

    public void d(itemView itemview)
    {
        itemview.a(true);
        if (itemview.mShadowedHolder != null && itemview.mShadowingHolder == null)
        {
            itemview.mShadowedHolder = null;
            itemview.a(-65, c(itemview));
        }
        itemview.mShadowingHolder = null;
        if (!b(itemview))
        {
            RecyclerView.e(a, itemview.itemView);
        }
    }

    private b(RecyclerView recyclerview)
    {
        a = recyclerview;
        super();
    }

    a(RecyclerView recyclerview, a a1)
    {
        this(recyclerview);
    }
}

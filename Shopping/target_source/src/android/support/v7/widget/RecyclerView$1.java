// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;


// Referenced classes of package android.support.v7.widget:
//            RecyclerView, a

class a
    implements Runnable
{

    final RecyclerView a;

    public void run()
    {
        if (RecyclerView.a(a))
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

    (RecyclerView recyclerview)
    {
        a = recyclerview;
        super();
    }
}

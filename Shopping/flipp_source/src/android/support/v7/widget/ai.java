// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;


// Referenced classes of package android.support.v7.widget:
//            RecyclerView, a, d, bi, 
//            an

final class ai
    implements Runnable
{

    final RecyclerView a;

    ai(RecyclerView recyclerview)
    {
        a = recyclerview;
        super();
    }

    public final void run()
    {
        if (RecyclerView.a(a))
        {
            if (RecyclerView.b(a))
            {
                a.g();
                return;
            }
            if (a.b.d())
            {
                a.a();
                a.b.b();
                if (!RecyclerView.c(a))
                {
                    RecyclerView recyclerview = a;
                    int j = recyclerview.c.a();
                    int i = 0;
                    while (i < j) 
                    {
                        bi bi1 = RecyclerView.b(recyclerview.c.b(i));
                        if (bi1 != null && !bi1.b())
                        {
                            if (bi1.m() || bi1.i())
                            {
                                recyclerview.requestLayout();
                            } else
                            if (bi1.j())
                            {
                                int k = recyclerview.e.a(bi1.b);
                                if (bi1.e == k)
                                {
                                    if (!bi1.k() || !recyclerview.f())
                                    {
                                        recyclerview.e.b(bi1, bi1.b);
                                    } else
                                    {
                                        recyclerview.requestLayout();
                                    }
                                } else
                                {
                                    bi1.a(4);
                                    recyclerview.requestLayout();
                                }
                            }
                        }
                        i++;
                    }
                }
                a.a(true);
                return;
            }
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.Scroller;
import com.google.android.apps.youtube.kids.ui.ScrollAwareHorizontalListView;

public final class aft
    implements Runnable
{

    private ScrollAwareHorizontalListView a;

    public aft(ScrollAwareHorizontalListView scrollawarehorizontallistview)
    {
        a = scrollawarehorizontallistview;
        super();
    }

    public final void run()
    {
        a.removeCallbacks(ScrollAwareHorizontalListView.c(a));
        if (!ScrollAwareHorizontalListView.d(a).isFinished())
        {
            if (ScrollAwareHorizontalListView.e(a) != null)
            {
                afw afw1 = ScrollAwareHorizontalListView.e(a);
                ScrollAwareHorizontalListView.f(a);
                ScrollAwareHorizontalListView.g(a);
                afw1.a();
            }
            a.postDelayed(ScrollAwareHorizontalListView.c(a), 100L);
        }
        ScrollAwareHorizontalListView.a(a, ScrollAwareHorizontalListView.h(a));
    }
}

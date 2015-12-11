// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.Scroller;
import com.google.android.apps.youtube.kids.ui.ScrollAwareHorizontalListView;

public final class afu
    implements Runnable
{

    private ScrollAwareHorizontalListView a;

    public afu(ScrollAwareHorizontalListView scrollawarehorizontallistview)
    {
        a = scrollawarehorizontallistview;
        super();
    }

    public final void run()
    {
        if (ScrollAwareHorizontalListView.i(a).isFinished())
        {
            a.sendAccessibilityEvent(8);
            if (ScrollAwareHorizontalListView.j(a) != null)
            {
                ScrollAwareHorizontalListView.j(a).a();
            }
            return;
        } else
        {
            a.postDelayed(ScrollAwareHorizontalListView.a(a), 500L);
            return;
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.support.v7.widget.ListPopupWindow;
import android.widget.AbsListView;
import android.widget.PopupWindow;

public class fe
    implements android.widget.AbsListView.OnScrollListener
{

    final ListPopupWindow a;

    private fe(ListPopupWindow listpopupwindow)
    {
        a = listpopupwindow;
        super();
    }

    public fe(ListPopupWindow listpopupwindow, ev ev)
    {
        this(listpopupwindow);
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        if (i == 1 && !a.f() && ListPopupWindow.b(a).getContentView() != null)
        {
            ListPopupWindow.d(a).removeCallbacks(ListPopupWindow.c(a));
            ListPopupWindow.c(a).run();
        }
    }
}

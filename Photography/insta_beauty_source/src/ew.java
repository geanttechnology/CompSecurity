// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.widget.ListPopupWindow;
import android.view.View;

public class ew
    implements Runnable
{

    final ListPopupWindow a;

    public ew(ListPopupWindow listpopupwindow)
    {
        a = listpopupwindow;
        super();
    }

    public void run()
    {
        View view = a.d();
        if (view != null && view.getWindowToken() != null)
        {
            a.c();
        }
    }
}

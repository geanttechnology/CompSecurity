// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.widget.ListPopupWindow;
import android.widget.PopupWindow;

public class di
    implements Runnable
{

    final ListPopupWindow a;

    private di(ListPopupWindow listpopupwindow)
    {
        a = listpopupwindow;
        super();
    }

    public di(ListPopupWindow listpopupwindow, android.support.v7.widget.ListPopupWindow._cls1 _pcls1)
    {
        this(listpopupwindow);
    }

    public void run()
    {
        if (ListPopupWindow.a(a) != null && ListPopupWindow.a(a).getCount() > ListPopupWindow.a(a).getChildCount() && ListPopupWindow.a(a).getChildCount() <= a.b)
        {
            ListPopupWindow.b(a).setInputMethodMode(2);
            a.c();
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.database.DataSetObserver;
import android.support.v7.widget.ListPopupWindow;

public class df extends DataSetObserver
{

    final ListPopupWindow a;

    private df(ListPopupWindow listpopupwindow)
    {
        a = listpopupwindow;
        super();
    }

    public df(ListPopupWindow listpopupwindow, android.support.v7.widget.ListPopupWindow._cls1 _pcls1)
    {
        this(listpopupwindow);
    }

    public void onChanged()
    {
        if (a.b())
        {
            a.c();
        }
    }

    public void onInvalidated()
    {
        a.a();
    }
}

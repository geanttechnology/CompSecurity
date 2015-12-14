// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.widget.ListPopupWindow;

public class de
    implements Runnable
{

    final ListPopupWindow a;

    private de(ListPopupWindow listpopupwindow)
    {
        a = listpopupwindow;
        super();
    }

    public de(ListPopupWindow listpopupwindow, android.support.v7.widget.ListPopupWindow._cls1 _pcls1)
    {
        this(listpopupwindow);
    }

    public void run()
    {
        a.e();
    }
}

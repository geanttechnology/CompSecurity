// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.widget.ListPopupWindow;

public class fc
    implements Runnable
{

    final ListPopupWindow a;

    private fc(ListPopupWindow listpopupwindow)
    {
        a = listpopupwindow;
        super();
    }

    public fc(ListPopupWindow listpopupwindow, ev ev)
    {
        this(listpopupwindow);
    }

    public void run()
    {
        a.e();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.widget.ListPopupWindow;
import android.view.View;
import android.widget.AdapterView;

public class ex
    implements android.widget.AdapterView.OnItemSelectedListener
{

    final ListPopupWindow a;

    public ex(ListPopupWindow listpopupwindow)
    {
        a = listpopupwindow;
        super();
    }

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        if (i != -1)
        {
            adapterview = ListPopupWindow.a(a);
            if (adapterview != null)
            {
                ey.a(adapterview, false);
            }
        }
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }
}

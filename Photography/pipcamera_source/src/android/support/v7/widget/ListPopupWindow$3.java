// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.View;
import android.widget.AdapterView;
import da;

// Referenced classes of package android.support.v7.widget:
//            ListPopupWindow

class a
    implements android.widget.SelectedListener
{

    final ListPopupWindow a;

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        if (i != -1)
        {
            adapterview = ListPopupWindow.a(a);
            if (adapterview != null)
            {
                da.a(adapterview, false);
            }
        }
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }

    tener(ListPopupWindow listpopupwindow)
    {
        a = listpopupwindow;
        super();
    }
}

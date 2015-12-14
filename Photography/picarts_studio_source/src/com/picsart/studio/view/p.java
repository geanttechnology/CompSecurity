// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view;

import android.content.Context;
import android.view.View;
import android.widget.ListAdapter;

// Referenced classes of package com.picsart.studio.view:
//            WrappingListPopupWindow

public final class p
{

    public View a;
    public ListAdapter b;
    public android.widget.AdapterView.OnItemClickListener c;
    public int d;
    private Context e;

    private p(Context context)
    {
        e = context;
    }

    p(Context context, byte byte0)
    {
        this(context);
    }

    public final WrappingListPopupWindow a()
    {
        WrappingListPopupWindow wrappinglistpopupwindow;
        if (d == 0)
        {
            wrappinglistpopupwindow = new WrappingListPopupWindow(e);
        } else
        {
            wrappinglistpopupwindow = new WrappingListPopupWindow(e, null, 0, d);
        }
        wrappinglistpopupwindow.setAnchorView(a);
        wrappinglistpopupwindow.setAdapter(b);
        wrappinglistpopupwindow.setOnItemClickListener(c);
        wrappinglistpopupwindow.setModal(true);
        return wrappinglistpopupwindow;
    }

    public final WrappingListPopupWindow b()
    {
        WrappingListPopupWindow wrappinglistpopupwindow = a();
        wrappinglistpopupwindow.show();
        return wrappinglistpopupwindow;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw.dialog;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

// Referenced classes of package com.socialin.android.photo.draw.dialog:
//            SelectCanvasSizeDialog

final class a extends ArrayAdapter
{

    private String a[];

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        view = super.getView(i, view, viewgroup);
        getItem(i);
        view.setId(0x7f100032);
        ((TextView)view).setText(a[i]);
        return view;
    }

    (Context context, List list, String as[])
    {
        a = as;
        super(context, 0x7f03024f, list);
    }
}

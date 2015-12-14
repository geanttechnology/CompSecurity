// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.multiselect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.j;

// Referenced classes of package com.socialin.android.multiselect:
//            FoldersActivity, c, a

final class b extends ArrayAdapter
{

    private LayoutInflater a;
    private FoldersActivity b;

    public b(FoldersActivity foldersactivity, Context context)
    {
        b = foldersactivity;
        super(context, 0);
        a = null;
        a = foldersactivity.getLayoutInflater();
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        c c1 = null;
        View view1 = view;
        if (view == null)
        {
            view1 = a.inflate(0x7f03016c, viewgroup, false);
            c1 = new c(this);
            c1.a = (TextView)view1.findViewById(0x7f100725);
            c1.b = (TextView)view1.findViewById(0x7f100726);
            c1.c = (ImageView)view1.findViewById(0x7f100724);
            view1.setTag(0x2f0e24fb, c1);
        }
        if (c1 == null)
        {
            view = (c)view1.getTag(0x2f0e24fb);
        } else
        {
            view = c1;
        }
        viewgroup = (a)getItem(i);
        ((c) (view)).a.setText((new StringBuilder()).append(((a) (viewgroup)).c).append(" (").append(((a) (viewgroup)).a).append(")").toString());
        ((c) (view)).b.setText(((a) (viewgroup)).d);
        FoldersActivity.h(b).a((new StringBuilder("file://")).append(((a) (viewgroup)).e).toString()).a(((c) (view)).c);
        return view1;
    }
}

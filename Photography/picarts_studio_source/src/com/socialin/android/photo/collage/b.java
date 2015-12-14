// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.collage;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

// Referenced classes of package com.socialin.android.photo.collage:
//            a, SelectCollageCropShape

public final class b extends BaseAdapter
{

    private SelectCollageCropShape a;

    public b(SelectCollageCropShape selectcollagecropshape)
    {
        a = selectcollagecropshape;
        super();
    }

    public final int getCount()
    {
        int ai[] = a.c;
        return 43;
    }

    public final Object getItem(int i)
    {
        return Integer.valueOf(0);
    }

    public final long getItemId(int i)
    {
        return (long)i;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        view = new ImageView(a);
        int j = (int)TypedValue.applyDimension(1, 100F, a.getResources().getDisplayMetrics());
        view.setLayoutParams(new android.widget.AbsListView.LayoutParams(j, j));
        view.setImageResource(a.d[i]);
        return view;
    }
}

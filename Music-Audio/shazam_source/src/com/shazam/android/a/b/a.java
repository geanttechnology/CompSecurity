// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.a.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.shazam.android.a.b;
import com.shazam.android.ag.g.d;
import com.shazam.android.widget.chart.c;
import com.shazam.android.widget.image.NumberedUrlCachingImageView;
import com.shazam.android.widget.preview.PreviewButton;
import com.shazam.model.chart.FullChartItem;

public final class a extends b
{

    public a(Context context)
    {
        super(context);
    }

    public final View a(Context context, ViewGroup viewgroup)
    {
        return new c(context);
    }

    public final void a(View view, Object obj, int i)
    {
        obj = (FullChartItem)obj;
        view = (c)view;
        NumberedUrlCachingImageView numberedurlcachingimageview = ((c) (view)).b;
        com.shazam.android.widget.image.g.a a1 = new com.shazam.android.widget.image.g.a();
        com.shazam.android.widget.e.a a2 = new com.shazam.android.widget.e.a();
        a2.a = ((c) (view)).g;
        a2.b = ((c) (view)).g;
        a1.c = a2.a();
        a1.a = i + 1;
        a1.b = ((FullChartItem) (obj)).url;
        numberedurlcachingimageview.a(a1.a(), true);
        ((c) (view)).c.setText(((FullChartItem) (obj)).title);
        ((c) (view)).d.setText(((FullChartItem) (obj)).artist);
        ((c) (view)).e.a(((FullChartItem) (obj)).previewViewData, 8);
        ((c) (view)).a.a(((FullChartItem) (obj)).store, ((c) (view)).f, com.shazam.android.widget.image.c.c.a);
    }
}

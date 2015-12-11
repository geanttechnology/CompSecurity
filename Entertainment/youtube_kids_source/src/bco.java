// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewParent;
import android.widget.ScrollView;

final class bco
    implements android.view.View.OnLayoutChangeListener
{

    private bcn a;

    bco(bcn bcn1)
    {
        a = bcn1;
        super();
    }

    public final void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        bcn bcn1 = a;
        view = new int[2];
        bcn1.a.getLocationOnScreen(view);
        i = view[0];
        j = view[1];
        k = bcn1.a.getWidth();
        l = bcn1.a.getHeight();
        bcn1.c.k = new Rect(i, j, k + i, l + j);
        view = bcn1.a.getContext().getResources().getDisplayMetrics();
        i = ((DisplayMetrics) (view)).heightPixels;
        j = ((DisplayMetrics) (view)).widthPixels;
        view = bcn1.a.getParent();
        while (view != null) 
        {
            if (view instanceof ScrollView)
            {
                ScrollView scrollview = (ScrollView)view;
                l = Math.max(0, scrollview.getChildAt(0).getHeight() - scrollview.getHeight());
                k = Math.max(0, scrollview.getChildAt(0).getWidth() - scrollview.getWidth()) + j;
                j = i + l;
                i = k;
            } else
            {
                k = i;
                i = j;
                j = k;
            }
            view = view.getParent();
            k = j;
            j = i;
            i = k;
        }
        bcn1.c.l = i;
        bcn1.c.m = j;
        a.a.removeOnLayoutChangeListener(this);
    }
}

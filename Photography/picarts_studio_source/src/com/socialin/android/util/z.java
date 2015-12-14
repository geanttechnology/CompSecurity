// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;

import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.photo.collage.SelectCollageBgActivity;
import com.socialin.android.photo.collage.a;
import java.util.ArrayList;
import myobfuscated.cb.c;

public class z
{

    public SelectCollageBgActivity a;

    public z(SelectCollageBgActivity selectcollagebgactivity)
    {
        a = selectcollagebgactivity;
        super();
    }

    public void a(int i)
    {
        if (i < SelectCollageBgActivity.b(a))
        {
            c c1 = (c)SelectCollageBgActivity.c(a).get(i);
            SelectCollageBgActivity.a(a, c1.j, c1.k, c1.m);
            AnalyticUtils.getInstance(a).trackLocalAction("collageBg:load_shop_item");
        } else
        {
            i -= SelectCollageBgActivity.b(a);
            a.a(i);
            AnalyticUtils.getInstance(a).trackLocalAction("collageBg:start_download");
            if (SelectCollageBgActivity.d(a) == com.socialin.android.photo.collage.SelectCollageBgActivity.Mode.DRAWING)
            {
                String s = (new StringBuilder("texture_")).append(a.b[i]).toString();
                AnalyticUtils.getInstance(a.getApplicationContext()).track(new com.socialin.android.apiv3.events.EventsFactory.DrawingBackgroundChooseEvent(s));
                return;
            }
        }
    }
}

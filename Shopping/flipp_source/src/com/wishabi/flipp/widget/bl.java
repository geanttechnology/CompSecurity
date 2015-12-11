// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.RectF;
import com.wishabi.flipp.app.FlippApplication;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.wishabi.flipp.widget:
//            bj

public final class bl
{

    final bj a;
    public List b;
    public PointF c;
    public float d;
    public float e;
    public int f;
    public RectF g;

    private bl(bj bj1)
    {
        a = bj1;
        if (a == null)
        {
            return;
        } else
        {
            b = a.a;
            c = a.b;
            d = a.c;
            e = a.d;
            f = a.e;
            g = a.f;
            return;
        }
    }

    public bl(bj bj1, byte byte0)
    {
        this(bj1);
    }

    public final bl a(int ai[])
    {
        Context context = FlippApplication.b();
        if (context == null)
        {
            return this;
        }
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < 11; i++)
        {
            int j = ai[i];
            arraylist.add(context.getResources().getDrawable(Integer.valueOf(j).intValue()));
        }

        b = arraylist;
        return this;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.FrameLayout;
import apv;
import apw;
import apx;
import apy;

public class PlusOneDummyView extends FrameLayout
{

    public PlusOneDummyView(Context context, int i)
    {
        super(context);
        context = new Button(context);
        context.setEnabled(false);
        context.setBackgroundDrawable(a().a(i));
        Point point = a(i);
        addView(context, new android.widget.FrameLayout.LayoutParams(point.x, point.y, 17));
    }

    private Point a(int i)
    {
        Point point;
        int j;
        byte byte0;
        byte0 = 24;
        j = 20;
        point = new Point();
        i;
        JVM INSTR tableswitch 0 2: default 44
    //                   0 112
    //                   1 106
    //                   2 122;
           goto _L1 _L2 _L3 _L4
_L1:
        i = 38;
        j = 24;
_L6:
        android.util.DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        float f = TypedValue.applyDimension(1, i, displaymetrics);
        float f1 = TypedValue.applyDimension(1, j, displaymetrics);
        point.x = (int)((double)f + 0.5D);
        point.y = (int)((double)f1 + 0.5D);
        return point;
_L3:
        i = 32;
        continue; /* Loop/switch isn't completed */
_L2:
        j = 14;
        i = byte0;
        continue; /* Loop/switch isn't completed */
_L4:
        i = 50;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private apy a()
    {
        Object obj1 = new apw(getContext());
        Object obj = obj1;
        if (!((apy) (obj1)).a())
        {
            obj = new apx(getContext());
        }
        obj1 = obj;
        if (!((apy) (obj)).a())
        {
            obj1 = new apv(getContext());
        }
        return ((apy) (obj1));
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.classes;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DrawView extends View
{

    int h;
    int r;
    String str;
    public int t;
    int w;
    int x;
    int y;

    public DrawView(Context context, int i, int j, int k, int l, int i1, int j1, 
            String s)
    {
        super(context);
        w = 0;
        h = 0;
        x = 0;
        y = 0;
        r = 0;
        t = 0;
        w = i;
        h = j;
        x = k;
        y = l;
        r = i1;
        t = j1;
        str = s;
    }

    protected void onDraw(Canvas canvas)
    {
        Object obj;
        Object obj1;
        super.onDraw(canvas);
        obj = new Paint();
        ((Paint) (obj)).setColor(Color.parseColor("#000000"));
        ((Paint) (obj)).setAlpha(200);
        ((Paint) (obj)).setAntiAlias(true);
        ((Paint) (obj)).setStyle(android.graphics.Paint.Style.FILL);
        obj1 = new Path();
        ((Path) (obj1)).setFillType(android.graphics.Path.FillType.INVERSE_WINDING);
        ((Path) (obj1)).addCircle(x, y, r, android.graphics.Path.Direction.CCW);
        canvas.drawPath(((Path) (obj1)), ((Paint) (obj)));
        canvas.drawRect(0.0F, 0.0F, w, y - r - 2, ((Paint) (obj)));
        canvas.drawRect(0.0F, y + r + 2, w, h, ((Paint) (obj)));
        canvas.drawRect(0.0F, y - r - 2, x - r - 2, y + r + 2, ((Paint) (obj)));
        canvas.drawRect(x + r + 2, y - r - 2, w, y + r + 2, ((Paint) (obj)));
        obj = new Paint();
        ((Paint) (obj)).setStyle(android.graphics.Paint.Style.STROKE);
        ((Paint) (obj)).setColor(Color.parseColor("#37b9eb"));
        ((Paint) (obj)).setAntiAlias(true);
        float f = getResources().getDisplayMetrics().density;
        byte byte0 = 5;
        if ((double)f <= 1.5D)
        {
            byte0 = 3;
        }
        for (int i = 0; i < byte0; i++)
        {
            canvas.drawCircle(x, y, r + i, ((Paint) (obj)));
            canvas.drawCircle(x, y, r + byte0 * 4 + i, ((Paint) (obj)));
        }

        obj = new LinearLayout(getContext());
        obj1 = new TextView(getContext());
        ((TextView) (obj1)).setWidth((int)((float)w - 50F));
        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-2, -1);
        layoutparams.setMargins(25, 0, 25, 0);
        ((TextView) (obj1)).setLayoutParams(layoutparams);
        if (t == 4 || t == 9 || t == 10)
        {
            ((TextView) (obj1)).setGravity(5);
        }
        ((TextView) (obj1)).setVisibility(0);
        ((TextView) (obj1)).setTextColor(-1);
        ((TextView) (obj1)).setTextSize(17F);
        ((TextView) (obj1)).setText(str);
        ((LinearLayout) (obj)).addView(((View) (obj1)));
        ((LinearLayout) (obj)).measure(canvas.getWidth(), canvas.getHeight());
        ((LinearLayout) (obj)).layout(0, 0, canvas.getWidth(), canvas.getHeight());
        if (t != 1) goto _L2; else goto _L1
_L1:
        canvas.translate(0.0F, y + r + 40);
_L4:
        ((LinearLayout) (obj)).draw(canvas);
        return;
_L2:
        if (t == 2)
        {
            canvas.translate(0.0F, y - r - 50 - ((TextView) (obj1)).getHeight());
        } else
        if (t == 3)
        {
            canvas.translate(0.0F, y + r + 40);
        } else
        if (t == 4)
        {
            canvas.translate(0.0F, y + r + 40);
        } else
        if (t == 5)
        {
            canvas.translate(0.0F, y + r + 40);
        } else
        if (t == 6)
        {
            canvas.translate(0.0F, y + r + 40);
        } else
        if (t == 7)
        {
            canvas.translate(0.0F, y - r - 50 - ((TextView) (obj1)).getHeight());
        } else
        if (t == 8)
        {
            canvas.translate(0.0F, y + r + 40);
        } else
        if (t == 9)
        {
            canvas.translate(0.0F, y + r + 40);
        } else
        if (t == 10)
        {
            canvas.translate(0.0F, y + r + 40);
        } else
        if (t == 11)
        {
            canvas.translate(0.0F, y + r + 40);
        } else
        if (t == 12)
        {
            canvas.translate(0.0F, y + r + 40);
        } else
        if (t == 13)
        {
            canvas.translate(0.0F, y + r + 40);
        } else
        if (t == 14)
        {
            canvas.translate(0.0F, y + r + 40);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}

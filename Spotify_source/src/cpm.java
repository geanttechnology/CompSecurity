// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.FrameLayout;

public final class cpm extends FrameLayout
{

    public cpm(Context context, int i)
    {
        Button button;
        int j;
        j = 24;
        super(context);
        button = new Button(context);
        button.setEnabled(false);
        Object obj = new cpo(getContext(), (byte)0);
        context = ((Context) (obj));
        if (!((cpq) (obj)).a())
        {
            context = new cpp(getContext(), (byte)0);
        }
        obj = context;
        if (!context.a())
        {
            obj = new cpn(getContext(), (byte)0);
        }
        button.setBackgroundDrawable(((cpq) (obj)).a(i));
        context = new Point();
        i;
        JVM INSTR tableswitch 0 2: default 140
    //                   0 233
    //                   1 223
    //                   2 239;
           goto _L1 _L2 _L3 _L4
_L1:
        j = 38;
        i = 24;
_L6:
        android.util.DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        float f = TypedValue.applyDimension(1, j, displaymetrics);
        float f1 = TypedValue.applyDimension(1, i, displaymetrics);
        context.x = (int)((double)f + 0.5D);
        context.y = (int)((double)f1 + 0.5D);
        addView(button, new android.widget.FrameLayout.LayoutParams(((Point) (context)).x, ((Point) (context)).y, 17));
        return;
_L3:
        j = 32;
        i = 20;
        continue; /* Loop/switch isn't completed */
_L2:
        i = 14;
        continue; /* Loop/switch isn't completed */
_L4:
        j = 50;
        i = 20;
        if (true) goto _L6; else goto _L5
_L5:
    }
}

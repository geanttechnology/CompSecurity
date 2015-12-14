// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.colorsplash;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SlidingDrawer;
import com.socialin.android.photo.imgop.ImageOpCommon;

// Referenced classes of package com.picsart.effects.colorsplash:
//            ColorSplashForegroundView, ColorSplashActivity, a, b, 
//            c, f, MyGLSurfaceView

final class a
    implements Runnable
{

    private ColorSplashForegroundView a;

    public final void run()
    {
        a.invalidate(ColorSplashForegroundView.a(a));
        ColorSplashForegroundView.b(a);
        if (ColorSplashForegroundView.c(a) > 0.01F) goto _L2; else goto _L1
_L1:
        ColorSplashActivity colorsplashactivity;
        int i;
        int j;
        int k;
        ColorSplashForegroundView.a(a, ckerState.CLOSED);
        colorsplashactivity = (ColorSplashActivity)a.getContext();
        j = a.a;
        i = (int)ColorSplashForegroundView.d(a).x;
        k = (int)ColorSplashForegroundView.d(a).y;
        if (colorsplashactivity.c.s != 0) goto _L4; else goto _L3
_L3:
        Object obj;
        obj = colorsplashactivity.c;
        if (((a) (obj)).p != null)
        {
            i = ImageOpCommon.getPixel(((a) (obj)).p, i + (((a) (obj)).j - k) * ((a) (obj)).i);
            if (((a) (obj)).s == 0 && ((a) (obj)).r != null && ((a) (obj)).r.b != null)
            {
                obj = ((a) (obj)).r.b;
                float f1 = (float)ImageOpCommon.RGBTOHCL(Color.blue(i), Color.green(i), Color.red(i));
                ((c) (obj)).h[((c) (obj)).l] = f1;
                obj.g = f1;
                ((c) (obj)).a.a((new StringBuilder("selectedHue")).append(((c) (obj)).l + 1).toString(), Float.valueOf(((c) (obj)).g));
                ((c) (obj)).b(30F);
                ((c) (obj)).c(30F);
                ((SeekBar)((c) (obj)).e.findViewById(0x7f1002cb)).setProgress(30);
                ((SeekBar)((c) (obj)).e.findViewById(0x7f1002ce)).setProgress(30);
                if (((c) (obj)).e != null)
                {
                    ((c) (obj)).a(f1);
                    ((Button)((c) (obj)).e.findViewById(0x7f1002c4)).setText((new StringBuilder()).append(((c) (obj)).m.a.getResources().getString(0x7f08007c)).append(((c) (obj)).l + 1).toString());
                }
            }
            Color.argb(Color.alpha(i), Color.blue(i), Color.green(i), Color.red(i));
            i = 1;
        } else
        {
            i = 0;
        }
        if (i == 0) goto _L4; else goto _L5
_L5:
        if (colorsplashactivity.d == null || colorsplashactivity.d.b == null) goto _L7; else goto _L6
_L6:
        colorsplashactivity.d.b.l;
        JVM INSTR tableswitch 0 2: default 436
    //                   0 594
    //                   1 607
    //                   2 622;
           goto _L7 _L8 _L9 _L10
_L7:
        obj = Integer.valueOf(0x7f1002b5);
        i = 0;
_L11:
        colorsplashactivity.a(i);
        colorsplashactivity.findViewById(0x7f1002b4).setSelected(true);
        ((ImageView)colorsplashactivity.findViewById(((Integer) (obj)).intValue())).setBackgroundColor(j);
        colorsplashactivity.c.s = 1;
        colorsplashactivity.a.removeAllViews();
        colorsplashactivity.a.addView(colorsplashactivity.d.b.e);
        obj = (SlidingDrawer)colorsplashactivity.findViewById(0x7f10057c);
        colorsplashactivity.findViewById(0x7f1001ab).setVisibility(0);
        if (android.os.lashActivity.findViewById >= 11)
        {
            colorsplashactivity.findViewById(0x7f1001ab).setBackgroundColor(0);
        }
        ((SlidingDrawer) (obj)).open();
        colorsplashactivity.findViewById(0x7f1001a8).setEnabled(true);
        colorsplashactivity.findViewById(0x7f1002bb).setEnabled(true);
        colorsplashactivity.b.requestRender();
        colorsplashactivity.a(true);
_L4:
        return;
_L8:
        obj = Integer.valueOf(0x7f1002b5);
        i = 0x7f1002b4;
        continue; /* Loop/switch isn't completed */
_L9:
        obj = Integer.valueOf(0x7f1002b7);
        i = 0x7f1002b6;
        continue; /* Loop/switch isn't completed */
_L10:
        obj = Integer.valueOf(0x7f1002b9);
        i = 0x7f1002b8;
        if (true) goto _L11; else goto _L2
_L2:
        ColorSplashForegroundView.e(a).postDelayed(this, 50L);
        return;
    }

    ckerState(ColorSplashForegroundView colorsplashforegroundview)
    {
        a = colorsplashforegroundview;
        super();
    }
}

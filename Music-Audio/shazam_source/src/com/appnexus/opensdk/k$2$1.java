// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageButton;

// Referenced classes of package com.appnexus.opensdk:
//            k, x, m, z, 
//            v

final class a
    implements Runnable
{

    final android.widget.ayout.LayoutParams a;
    final Params b;

    public final void run()
    {
        b.tLayoutParams(a);
    }

    Params(Params params, android.widget.ayout.LayoutParams layoutparams)
    {
        b = params;
        a = layoutparams;
        super();
    }

    // Unreferenced inner class com/appnexus/opensdk/k$2

/* anonymous class */
    final class k._cls2 extends ImageButton
    {

        final x a;
        final k b;

        public final void onLayout(boolean flag, int i, int j, int l, int i1)
        {
            int ai[];
            Point point;
            ai = new int[2];
            getLocationOnScreen(ai);
            point = new Point(0, 0);
            Object obj = (Activity)a.b.getContext();
            i = 1;
_L1:
            int ai1[];
            int j1;
            if (i != 0)
            {
                if (android.os.Build.VERSION.SDK_INT >= 13)
                {
                    ((Activity) (obj)).getWindowManager().getDefaultDisplay().getSize(point);
                } else
                {
                    point.x = ((Activity) (obj)).getWindowManager().getDefaultDisplay().getWidth();
                    point.y = ((Activity) (obj)).getWindowManager().getDefaultDisplay().getHeight();
                }
            }
            ai1 = new int[2];
            if (b.getMediaType().equals(z.b))
            {
                v.q.measure(0, 0);
                v.q.getLocationOnScreen(ai1);
                obj = new Point(v.q.getMeasuredWidth(), v.q.getMeasuredHeight());
            } else
            {
                b.measure(0, 0);
                b.getLocationOnScreen(ai1);
                obj = new Point(b.getMeasuredWidth(), b.getMeasuredHeight());
            }
            i1 = ((Point) (obj)).x;
            j1 = b.p;
            j = ((Point) (obj)).y;
            l = b.p;
            if (i != 0)
            {
                i1 = (ai1[0] + Math.min(point.x, ((Point) (obj)).x)) - b.p;
                i = ai1[1];
                l = (Math.min(point.y, ((Point) (obj)).y) + i) - b.p;
                j = ai1[0];
                i = ai1[1];
            } else
            {
                i = 0;
                i1 -= j1;
                l = j - l;
                j = 0;
            }
            if (ai[0] + 1 < j || ai[0] - 1 > i1 || ai[1] + 1 < i || ai[1] - 1 > l)
            {
                obj = new android.widget.FrameLayout.LayoutParams(getLayoutParams());
                ((android.widget.FrameLayout.LayoutParams) (obj)).setMargins(0, 0, 0, 0);
                obj.gravity = 51;
                post(new k._cls2._cls1(this, ((android.widget.FrameLayout.LayoutParams) (obj))));
                b.l.setImageDrawable(getResources().getDrawable(0x1080038));
            }
            return;
            obj;
            i = 0;
            obj = null;
              goto _L1
        }

            
            {
                b = k1;
                a = x1;
                super(context);
            }
    }

}

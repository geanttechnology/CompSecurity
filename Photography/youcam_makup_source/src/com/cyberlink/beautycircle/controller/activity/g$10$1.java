// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            g, PostActivity

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        a.a.setOnClickListener(null);
        a.a.b.a(g.a(a.a));
    }

    <init>(<init> <init>1)
    {
        a = <init>1;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/g$10

/* anonymous class */
    class g._cls10
        implements android.view.View.OnTouchListener
    {

        public long a;
        public long b;
        public PointF c;
        public long d;
        public Runnable e;
        final View f;
        final g g;

        public boolean a(float f1, float f2, float f3)
        {
            return f1 >= -f3 && f2 >= -f3 && f1 < (float)(f.getRight() - f.getLeft()) + f3 && f2 < (float)(f.getBottom() - f.getTop()) + f3;
        }

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            if (motionevent.getAction() != 0) goto _L2; else goto _L1
_L1:
            a = System.currentTimeMillis();
            c.set(motionevent.getX(), motionevent.getY());
            f.postDelayed(e, b);
_L4:
            return false;
_L2:
            if (motionevent.getAction() == 1)
            {
                if (System.currentTimeMillis() - a < b)
                {
                    f.removeCallbacks(e);
                }
            } else
            if (!a(motionevent.getX(), motionevent.getY(), d))
            {
                f.removeCallbacks(e);
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

            
            {
                g = g1;
                f = view;
                super();
                a = 0L;
                b = 250L;
                c = new PointF();
                d = ViewConfiguration.get(f.getContext()).getScaledTouchSlop();
                e = new g._cls10._cls1(this);
            }
    }

}

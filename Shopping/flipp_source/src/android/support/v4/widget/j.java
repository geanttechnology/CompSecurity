// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package android.support.v4.widget:
//            i, ah, DrawerLayout, g

final class j
    implements Runnable
{

    final i a;

    j(i k)
    {
        a = k;
        super();
    }

    public final void run()
    {
        boolean flag = false;
        Object obj1 = a;
        int i1 = ((i) (obj1)).b.k;
        Object obj;
        int k;
        int l;
        if (((i) (obj1)).a == 3)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        if (k != 0)
        {
            obj = ((i) (obj1)).c.a(3);
            g g1;
            long l1;
            if (obj != null)
            {
                l = -((View) (obj)).getWidth();
            } else
            {
                l = 0;
            }
            l += i1;
        } else
        {
            obj = ((i) (obj1)).c.a(5);
            l = ((i) (obj1)).c.getWidth();
            l -= i1;
        }
        if (obj != null && (k != 0 && ((View) (obj)).getLeft() < l || k == 0 && ((View) (obj)).getLeft() > l) && ((i) (obj1)).c.a(((View) (obj))) == 0)
        {
            g1 = (g)((View) (obj)).getLayoutParams();
            ((i) (obj1)).b.a(((View) (obj)), l, ((View) (obj)).getTop());
            g1.c = true;
            ((i) (obj1)).c.invalidate();
            ((i) (obj1)).b();
            obj = ((i) (obj1)).c;
            if (!((DrawerLayout) (obj)).d)
            {
                l1 = SystemClock.uptimeMillis();
                obj1 = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
                l = ((DrawerLayout) (obj)).getChildCount();
                for (k = ((flag) ? 1 : 0); k < l; k++)
                {
                    ((DrawerLayout) (obj)).getChildAt(k).dispatchTouchEvent(((MotionEvent) (obj1)));
                }

                ((MotionEvent) (obj1)).recycle();
                obj.d = true;
            }
        }
    }
}

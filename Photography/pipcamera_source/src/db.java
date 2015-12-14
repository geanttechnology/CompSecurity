// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.ListPopupWindow;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

public abstract class db
    implements android.view.View.OnTouchListener
{

    private final float a;
    private final int b = ViewConfiguration.getTapTimeout();
    private final int c;
    private final View d;
    private Runnable e;
    private Runnable f;
    private boolean g;
    private boolean h;
    private int i;
    private final int j[] = new int[2];

    public db(View view)
    {
        d = view;
        a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        c = (b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    static View a(db db1)
    {
        return db1.d;
    }

    private boolean a(MotionEvent motionevent)
    {
        View view = d;
        if (view.isEnabled()) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        switch (MotionEventCompat.getActionMasked(motionevent))
        {
        default:
            return false;

        case 0: // '\0'
            i = motionevent.getPointerId(0);
            h = false;
            if (e == null)
            {
                e = new dc(this, null);
            }
            view.postDelayed(e, b);
            if (f == null)
            {
                f = new dd(this, null);
            }
            view.postDelayed(f, c);
            return false;

        case 2: // '\002'
            int k = motionevent.findPointerIndex(i);
            if (k >= 0 && !a(view, motionevent.getX(k), motionevent.getY(k), a))
            {
                d();
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
            break;

        case 1: // '\001'
        case 3: // '\003'
            d();
            return false;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private static boolean a(View view, float f1, float f2, float f3)
    {
        return f1 >= -f3 && f2 >= -f3 && f1 < (float)(view.getRight() - view.getLeft()) + f3 && f2 < (float)(view.getBottom() - view.getTop()) + f3;
    }

    private boolean a(View view, MotionEvent motionevent)
    {
        int ai[] = j;
        view.getLocationOnScreen(ai);
        motionevent.offsetLocation(-ai[0], -ai[1]);
        return true;
    }

    static void b(db db1)
    {
        db1.e();
    }

    private boolean b(MotionEvent motionevent)
    {
        boolean flag = true;
        View view = d;
        Object obj = a();
        if (obj != null && ((ListPopupWindow) (obj)).b())
        {
            if ((obj = ListPopupWindow.a(((ListPopupWindow) (obj)))) != null && ((da) (obj)).isShown())
            {
                MotionEvent motionevent1 = MotionEvent.obtainNoHistory(motionevent);
                b(view, motionevent1);
                a(((View) (obj)), motionevent1);
                boolean flag1 = ((da) (obj)).a(motionevent1, i);
                motionevent1.recycle();
                int k = MotionEventCompat.getActionMasked(motionevent);
                if (k != 1 && k != 3)
                {
                    k = 1;
                } else
                {
                    k = 0;
                }
                if (!flag1 || !k)
                {
                    flag = false;
                }
                return flag;
            }
        }
        return false;
    }

    private boolean b(View view, MotionEvent motionevent)
    {
        int ai[] = j;
        view.getLocationOnScreen(ai);
        motionevent.offsetLocation(ai[0], ai[1]);
        return true;
    }

    private void d()
    {
        if (f != null)
        {
            d.removeCallbacks(f);
        }
        if (e != null)
        {
            d.removeCallbacks(e);
        }
    }

    private void e()
    {
        d();
        while (!d.isEnabled() || !b()) 
        {
            return;
        }
        d.getParent().requestDisallowInterceptTouchEvent(true);
        long l = SystemClock.uptimeMillis();
        MotionEvent motionevent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        d.onTouchEvent(motionevent);
        motionevent.recycle();
        g = true;
        h = true;
    }

    public abstract ListPopupWindow a();

    public boolean b()
    {
        ListPopupWindow listpopupwindow = a();
        if (listpopupwindow != null && !listpopupwindow.b())
        {
            listpopupwindow.c();
        }
        return true;
    }

    protected boolean c()
    {
        ListPopupWindow listpopupwindow = a();
        if (listpopupwindow != null && listpopupwindow.b())
        {
            listpopupwindow.a();
        }
        return true;
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        boolean flag1;
        boolean flag2;
        flag1 = false;
        flag2 = g;
        if (!flag2) goto _L2; else goto _L1
_L1:
        boolean flag;
        if (h)
        {
            flag = b(motionevent);
        } else
        if (b(motionevent) || !c())
        {
            flag = true;
        } else
        {
            flag = false;
        }
_L4:
label0:
        {
            g = flag;
            if (!flag)
            {
                flag = flag1;
                if (!flag2)
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
_L2:
        if (a(motionevent) && b())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            long l = SystemClock.uptimeMillis();
            view = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
            d.onTouchEvent(view);
            view.recycle();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}

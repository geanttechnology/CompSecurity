// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.content.Context;
import android.graphics.PointF;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import com.cyberlink.beautycircle.Globals;
import com.perfectcorp.utility.e;
import java.lang.reflect.Field;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            c

public class BiDirectionSwipeRefreshLayout extends SwipeRefreshLayout
{

    private View a;
    private int b;
    private int c;
    private PointF d;
    private boolean e;
    private boolean f;
    private c g;
    private boolean h;

    public BiDirectionSwipeRefreshLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = null;
        b = -1;
        c = 8;
        e = false;
        f = false;
        g = null;
        h = false;
        c = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private PointF a(MotionEvent motionevent, int i)
    {
        i = MotionEventCompat.findPointerIndex(motionevent, i);
        if (i < 0)
        {
            return null;
        } else
        {
            return new PointF(MotionEventCompat.getX(motionevent, i), MotionEventCompat.getY(motionevent, i));
        }
    }

    private void b()
    {
        try
        {
            Field field = android/support/v4/widget/SwipeRefreshLayout.getDeclaredField("mTarget");
            field.setAccessible(true);
            a = (View)field.get(this);
            return;
        }
        catch (NoSuchFieldException nosuchfieldexception)
        {
            nosuchfieldexception.printStackTrace();
            return;
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            illegalaccessexception.printStackTrace();
            return;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            illegalargumentexception.printStackTrace();
        }
    }

    private void c()
    {
        if (e.a)
        {
            Globals.b("onLoadNext");
        }
        if (g != null)
        {
            g.a();
        }
    }

    public boolean a()
    {
        if (h)
        {
            if (a == null)
            {
                b();
            }
            if (a != null)
            {
                return ViewCompat.canScrollVertically(a, 1);
            }
        }
        return true;
    }

    public boolean canChildScrollUp()
    {
        boolean flag = false;
        if (a == null)
        {
            return super.canChildScrollUp();
        }
        if (android.os.Build.VERSION.SDK_INT < 14)
        {
            if (a instanceof AbsListView)
            {
                AbsListView abslistview = (AbsListView)a;
                return abslistview.getChildCount() > 0 && (abslistview.getFirstVisiblePosition() > 0 || abslistview.getChildAt(0).getTop() < abslistview.getPaddingTop());
            }
            if (ViewCompat.canScrollVertically(a, -1) || a.getScrollY() > 0)
            {
                flag = true;
            }
            return flag;
        } else
        {
            return ViewCompat.canScrollVertically(a, -1);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        if (motionevent.getPointerCount() <= 1 && isEnabled()) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        MotionEventCompat.getActionMasked(motionevent);
        JVM INSTR tableswitch 0 3: default 52
    //                   0 69
    //                   1 221
    //                   2 105
    //                   3 221;
           goto _L3 _L4 _L5 _L6 _L5
_L5:
        break MISSING_BLOCK_LABEL_221;
_L3:
        break; /* Loop/switch isn't completed */
_L4:
        break; /* Loop/switch isn't completed */
_L8:
        if (super.onInterceptTouchEvent(motionevent) || e)
        {
            return true;
        }
        if (true) goto _L1; else goto _L7
_L7:
        e = false;
        b = MotionEventCompat.getPointerId(motionevent, 0);
        PointF pointf = a(motionevent, b);
        if (pointf != null)
        {
            d = pointf;
        }
          goto _L8
_L6:
        if (b != -1 && d != null)
        {
            PointF pointf1 = a(motionevent, b);
            if (pointf1 != null)
            {
                float f1 = Math.abs(d.x - pointf1.x);
                if (f || f1 > (float)c)
                {
                    f = true;
                    return false;
                }
                if (!a() && d.y - pointf1.y > (float)c && !e)
                {
                    e = true;
                    c();
                }
            }
        }
          goto _L8
        e = false;
        f = false;
        b = -1;
        d = null;
          goto _L8
    }

    public void setOnLoadNextListener(c c1)
    {
        g = c1;
    }

    public void setTarget(View view)
    {
        a = view;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage;

import android.content.Context;
import android.graphics.PointF;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.view.TouchImageView;

public class TouchViewPager extends ViewPager
{

    PointF a;
    public TouchImageView b;

    public TouchViewPager(Context context)
    {
        super(context);
    }

    public TouchViewPager(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    private float[] a(MotionEvent motionevent)
    {
        motionevent.getAction() & 0xff;
        JVM INSTR tableswitch 0 2: default 36
    //                   0 38
    //                   1 62
    //                   2 62;
           goto _L1 _L2 _L3 _L3
_L1:
        return null;
_L2:
        a = new PointF(motionevent.getX(0), motionevent.getY(0));
          goto _L1
_L3:
        motionevent = new PointF(motionevent.getX(0), motionevent.getY(0));
        return (new float[] {
            ((PointF) (motionevent)).x - a.x, ((PointF) (motionevent)).y - a.y
        });
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        if ((motionevent.getAction() & 0xff) == 1)
        {
            super.onInterceptTouchEvent(motionevent);
        }
        if (b != null)
        {
            float af[] = a(motionevent);
            if (b.b())
            {
                boolean flag;
                try
                {
                    flag = super.onInterceptTouchEvent(motionevent);
                }
                // Misplaced declaration of an exception variable
                catch (MotionEvent motionevent)
                {
                    Log.e("TouchViewPager", "IllegalArgmentException: pointerIndex out of range");
                    return false;
                }
                return flag;
            }
            if (af != null && b.E && af[0] < 0.0F)
            {
                return super.onInterceptTouchEvent(motionevent);
            }
            if (af != null && b.C && af[0] > 0.0F)
            {
                return super.onInterceptTouchEvent(motionevent);
            }
            if (af == null && (b.C || b.E))
            {
                return super.onInterceptTouchEvent(motionevent);
            }
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if ((motionevent.getAction() & 0xff) == 1)
        {
            super.onTouchEvent(motionevent);
        }
        if (b != null)
        {
            float af[] = a(motionevent);
            if (b.b())
            {
                return super.onTouchEvent(motionevent);
            }
            if (af != null && b.E && af[0] < 0.0F)
            {
                return super.onTouchEvent(motionevent);
            }
            if (af != null && b.C && af[0] > 0.0F)
            {
                return super.onTouchEvent(motionevent);
            }
            if (af == null && (b.C || b.E))
            {
                return super.onTouchEvent(motionevent);
            }
        }
        return false;
    }
}

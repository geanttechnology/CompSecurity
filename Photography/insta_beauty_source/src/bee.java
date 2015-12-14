// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.MotionEvent;
import android.widget.Scroller;
import com.instamag.activity.library.view.waterfall.WaterFall;

public class bee extends android.view.GestureDetector.SimpleOnGestureListener
{

    final WaterFall a;

    public bee(WaterFall waterfall)
    {
        a = waterfall;
        super();
    }

    public boolean onDown(MotionEvent motionevent)
    {
        return true;
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        boolean flag = false;
        if (WaterFall.access$000(a).isFinished())
        {
            WaterFall.access$000(a).fling(0, WaterFall.access$100(a), 0, (int)(-f1), 0, 0, WaterFall.access$100(a) - 5000, WaterFall.access$100(a) + 5000);
            WaterFall.access$202(a, true);
            a.postInvalidate();
            flag = true;
        }
        return flag;
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        a.scrollTo(0, (int)((float)WaterFall.access$100(a) + f1));
        WaterFall.access$300(a);
        return true;
    }
}

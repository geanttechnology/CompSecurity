// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.gpu;

import android.graphics.PointF;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import com.socialin.android.util.Geom;
import myobfuscated.av.a;
import myobfuscated.av.b;
import myobfuscated.av.c;
import myobfuscated.av.d;

// Referenced classes of package com.photo.gpu:
//            GPUImage

final class a
    implements android.view.hListener
{

    private GPUImage a;

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        int i;
        int j;
        view = a.f.a.b;
        i = motionevent.getPointerCount();
        j = motionevent.getActionIndex();
        motionevent.getActionMasked();
        JVM INSTR tableswitch 0 6: default 72
    //                   0 74
    //                   1 427
    //                   2 304
    //                   3 72
    //                   4 72
    //                   5 156
    //                   6 258;
           goto _L1 _L2 _L3 _L4 _L1 _L1 _L5 _L6
_L1:
        return true;
_L2:
        float f = motionevent.getX(0);
        float f1 = motionevent.getY(0);
        ((c) (view)).o.set(f, f1);
        view.a = motionevent.getPointerId(0);
        view.h = true;
        view.j = true;
        view.k = false;
        view.i = true;
        ((c) (view)).g.postDelayed(new myobfuscated.av.yed(view, f, f1), ((c) (view)).e);
        view.n = false;
        return true;
_L5:
        view.h = false;
        if (i == 2)
        {
            view.b = motionevent.getPointerId(j);
            view.a(motionevent, i, -1);
            PointF pointf = c.a(motionevent, ((c) (view)).a);
            motionevent = c.a(motionevent, ((c) (view)).b);
            if (pointf != null && motionevent != null)
            {
                if (((c) (view)).k)
                {
                    ((c) (view)).d.a();
                }
                ((c) (view)).d.a(pointf, motionevent);
                view.j = false;
                view.k = true;
                view.i = false;
                return true;
            }
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (i != 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((c) (view)).k)
        {
            ((c) (view)).d.a();
            view.k = false;
            return true;
        }
        continue; /* Loop/switch isn't completed */
        if (i <= 2) goto _L1; else goto _L7
_L7:
        view.a(motionevent, i, j);
        return true;
_L4:
        if (!((c) (view)).k)
        {
            continue; /* Loop/switch isn't completed */
        }
        boolean flag = c.a(motionevent, ((c) (view)).a, ((c) (view)).l);
        boolean flag1 = c.a(motionevent, ((c) (view)).b, ((c) (view)).m);
        if (flag || flag1)
        {
            ((c) (view)).d.a(((c) (view)).l, ((c) (view)).m, flag, flag1);
            return true;
        }
        continue; /* Loop/switch isn't completed */
        if (!((c) (view)).j) goto _L1; else goto _L8
_L8:
        ((c) (view)).l.set(motionevent.getX(), motionevent.getY());
        if (!((c) (view)).n && Geom.a(((c) (view)).l, ((c) (view)).o) >= ((c) (view)).c)
        {
            view.n = true;
            return true;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (((c) (view)).k)
        {
            ((c) (view)).d.a();
            view.k = false;
            return true;
        }
        if (((c) (view)).h && motionevent.getEventTime() - motionevent.getDownTime() <= ((c) (view)).f)
        {
            new PointF(motionevent.getX(), motionevent.getY());
        }
        if (((c) (view)).j)
        {
            new PointF(motionevent.getX(), motionevent.getY());
            return true;
        }
        if (true) goto _L1; else goto _L9
_L9:
    }

    .Geom(GPUImage gpuimage)
    {
        a = gpuimage;
        super();
    }
}

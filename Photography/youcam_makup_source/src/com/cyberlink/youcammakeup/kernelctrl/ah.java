// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl:
//            s, an, ai, ak, 
//            al, aj, am

public class ah
    implements s
{

    public static UUID a = UUID.randomUUID();
    private ArrayList b;
    private ArrayList c;
    private ArrayList d;
    private ArrayList e;
    private ArrayList f;
    private int g;
    private float h;
    private float i;
    private float j;
    private float k;
    private View l;
    private LinkedList m;

    private ah()
    {
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        m = null;
        b = new ArrayList();
        c = new ArrayList();
        d = new ArrayList();
        e = new ArrayList();
        f = new ArrayList();
    }


    public static ah a()
    {
        return an.a();
    }

    private void a(float f1, float f2)
    {
        this;
        JVM INSTR monitorenter ;
        for (Iterator iterator = b.iterator(); iterator.hasNext(); ((ai)iterator.next()).a(f1, f2)) { }
        break MISSING_BLOCK_LABEL_43;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    private void a(MotionEvent motionevent)
    {
        float f1;
        float f2;
label0:
        {
            int i1 = motionevent.findPointerIndex(g);
            if (i1 != -1 && motionevent.getPointerCount() > i1)
            {
                f1 = motionevent.getX(i1);
                f2 = motionevent.getY(i1);
                if (f1 != j || f2 != k)
                {
                    break label0;
                }
            }
            return;
        }
        j = f1;
        k = f2;
        b(j, k);
    }

    private void b(float f1, float f2)
    {
        this;
        JVM INSTR monitorenter ;
        for (Iterator iterator = e.iterator(); iterator.hasNext(); ((ak)iterator.next()).a(f1, f2)) { }
        break MISSING_BLOCK_LABEL_43;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    private void b(MotionEvent motionevent)
    {
        int i1 = motionevent.findPointerIndex(g);
        if (i1 != -1 && motionevent.getPointerCount() > i1)
        {
            j = motionevent.getX(i1);
            k = motionevent.getY(i1);
            c(j, k);
        }
    }

    private void b(MotionEvent motionevent, Boolean boolean1)
    {
label0:
        {
            int i1 = motionevent.getActionIndex();
            g = motionevent.getPointerId(i1);
            if (motionevent.getPointerCount() > i1)
            {
                h = motionevent.getX(i1);
                i = motionevent.getY(i1);
                if (!boolean1.booleanValue())
                {
                    break label0;
                }
                if (m == null)
                {
                    m = new LinkedList();
                }
                m.add(MotionEvent.obtain(motionevent));
            }
            return;
        }
        a(h, i);
    }

    private void c(float f1, float f2)
    {
        this;
        JVM INSTR monitorenter ;
        for (Iterator iterator = f.iterator(); iterator.hasNext(); ((al)iterator.next()).a(f1, f2)) { }
        break MISSING_BLOCK_LABEL_43;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    private void c(MotionEvent motionevent, Boolean boolean1)
    {
        if (motionevent.getActionIndex() == 0)
        {
            int i1 = motionevent.getActionIndex();
            g = motionevent.getPointerId(i1);
            if (motionevent.getPointerCount() > i1)
            {
                h = motionevent.getX(i1);
                i = motionevent.getY(i1);
                if (boolean1.booleanValue())
                {
                    if (m == null)
                    {
                        m = new LinkedList();
                    }
                    m.add(MotionEvent.obtain(motionevent));
                    return;
                } else
                {
                    a(h, i);
                    return;
                }
            }
        }
    }

    private void d(float f1, float f2)
    {
        this;
        JVM INSTR monitorenter ;
        for (Iterator iterator = c.iterator(); iterator.hasNext(); ((aj)iterator.next()).a(f1, f2)) { }
        break MISSING_BLOCK_LABEL_43;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    private void d(MotionEvent motionevent, Boolean boolean1)
    {
        float f1;
        float f2;
label0:
        {
            int i1 = motionevent.findPointerIndex(g);
            if (i1 != -1 && motionevent.getPointerCount() > i1)
            {
                f1 = motionevent.getX(i1);
                f2 = motionevent.getY(i1);
                if (f1 != h || f2 != i)
                {
                    break label0;
                }
            }
            return;
        }
        h = f1;
        i = f2;
        if (boolean1.booleanValue())
        {
            if (m == null)
            {
                m = new LinkedList();
            }
            m.add(MotionEvent.obtain(motionevent));
            return;
        } else
        {
            d(h, i);
            return;
        }
    }

    private void e(float f1, float f2)
    {
        this;
        JVM INSTR monitorenter ;
        for (Iterator iterator = d.iterator(); iterator.hasNext(); ((am)iterator.next()).a(f1, f2)) { }
        break MISSING_BLOCK_LABEL_43;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    private void e(MotionEvent motionevent, Boolean boolean1)
    {
        int i1 = motionevent.getActionIndex();
        if (motionevent.getPointerId(i1) == g && motionevent.getPointerCount() > i1)
        {
            h = motionevent.getX(i1);
            i = motionevent.getY(i1);
            if (boolean1.booleanValue())
            {
                if (m == null)
                {
                    m = new LinkedList();
                }
                m.add(MotionEvent.obtain(motionevent));
            } else
            {
                e(h, i);
            }
            if (motionevent.getToolType(i1) == 3)
            {
                j = h;
                k = i;
                b(j, k);
            }
        }
    }

    public void a(MotionEvent motionevent, Boolean boolean1)
    {
        switch (motionevent.getActionMasked())
        {
        case 3: // '\003'
        case 4: // '\004'
        case 8: // '\b'
        default:
            return;

        case 5: // '\005'
            c(motionevent, boolean1);
            return;

        case 0: // '\0'
            b(motionevent, boolean1);
            return;

        case 2: // '\002'
            d(motionevent, boolean1);
            return;

        case 1: // '\001'
        case 6: // '\006'
            e(motionevent, boolean1);
            return;

        case 7: // '\007'
        case 9: // '\t'
            a(motionevent);
            return;

        case 10: // '\n'
            b(motionevent);
            break;
        }
    }

    public void a(View view)
    {
        l = view;
    }

    public void a(ai ai1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!b.contains(ai1))
        {
            b.add(ai1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        ai1;
        this;
        JVM INSTR monitorexit ;
        throw ai1;
    }

    public void a(aj aj1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!c.contains(aj1))
        {
            c.add(aj1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        aj1;
        this;
        JVM INSTR monitorexit ;
        throw aj1;
    }

    public void a(am am1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!d.contains(am1))
        {
            d.add(am1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        am1;
        this;
        JVM INSTR monitorexit ;
        throw am1;
    }

    public void a(Boolean boolean1)
    {
        if (m != null && m.size() > 0)
        {
            for (int i1 = 0; i1 < m.size(); i1++)
            {
                if (boolean1.booleanValue())
                {
                    a((MotionEvent)m.get(i1), Boolean.valueOf(false));
                }
                ((MotionEvent)m.get(i1)).recycle();
            }

        }
        m = null;
    }

    public void b(ai ai1)
    {
        this;
        JVM INSTR monitorenter ;
        if (b.contains(ai1))
        {
            b.remove(ai1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        ai1;
        this;
        JVM INSTR monitorexit ;
        throw ai1;
    }

    public void b(aj aj1)
    {
        this;
        JVM INSTR monitorenter ;
        if (c.contains(aj1))
        {
            c.remove(aj1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        aj1;
        this;
        JVM INSTR monitorexit ;
        throw aj1;
    }

    public void b(am am1)
    {
        this;
        JVM INSTR monitorenter ;
        if (d.contains(am1))
        {
            d.remove(am1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        am1;
        this;
        JVM INSTR monitorexit ;
        throw am1;
    }

}

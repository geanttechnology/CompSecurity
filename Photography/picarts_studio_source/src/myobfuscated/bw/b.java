// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bw;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package myobfuscated.bw:
//            a, e, d

public final class b extends a
    implements android.view.View.OnHoverListener, android.view.View.OnTouchListener
{

    private e a;
    private d b;
    private int c;

    public b()
    {
    }

    private boolean a(View view, MotionEvent motionevent, boolean flag)
    {
        if (a()) goto _L2; else goto _L1
_L1:
        if (a != null) goto _L4; else goto _L3
_L3:
        return false;
_L4:
        return a.a(motionevent);
_L2:
        int i = motionevent.getButtonState();
        int j = c;
        c = i;
        if ((~j & i & 2) != 0)
        {
            if (a != null && flag)
            {
                a.d(motionevent);
            } else
            if (b != null && !flag)
            {
                b.a();
            }
        }
        if ((i & 4) != 0)
        {
            if (a != null && flag)
            {
                a.d(motionevent);
            } else
            if (b != null && !flag)
            {
                b.a();
            }
        }
        if (motionevent.getPointerCount() <= 1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (a != null)
        {
            return a.a(motionevent);
        }
        if (true) goto _L3; else goto _L5
_L5:
        if (motionevent.getToolType(0) != 4 || !flag)
        {
            break; /* Loop/switch isn't completed */
        }
        if (a != null)
        {
            return a.c(motionevent);
        }
        if (true) goto _L3; else goto _L6
_L6:
        if (motionevent.getToolType(0) != 1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (a != null && flag)
        {
            return a.a(motionevent);
        }
        if (b != null && !flag)
        {
            return b.a(view, motionevent);
        }
        if (true) goto _L3; else goto _L7
_L7:
        if (motionevent.getToolType(0) != 2)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (a != null && flag)
        {
            return a.b(motionevent);
        }
        if (b == null || flag) goto _L3; else goto _L8
_L8:
        return b.a(view, motionevent);
        if (!flag || a == null) goto _L3; else goto _L9
_L9:
        return a.a(motionevent);
    }

    public final void a(View view, d d1)
    {
        b = d1;
        view.setOnHoverListener(this);
    }

    public final void a(View view, e e1)
    {
        a = e1;
        view.setOnTouchListener(this);
    }

    public final boolean onHover(View view, MotionEvent motionevent)
    {
        return a(view, motionevent, false);
    }

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        return a(view, motionevent, true);
    }
}

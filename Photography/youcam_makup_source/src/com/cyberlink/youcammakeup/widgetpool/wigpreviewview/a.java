// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.wigpreviewview;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.MotionEvent;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.wigpreviewview:
//            b

public class a
{

    private MotionEvent a;
    private boolean b;
    private float c;
    private float d;
    private int e;
    private b f;

    public a(Resources resources)
    {
        a = null;
        b = false;
        c = -1F;
        d = -1F;
        f = null;
        int i = (int)TypedValue.applyDimension(1, 5F, resources.getDisplayMetrics());
        e = i * i;
        m.b("TouchMovingCtrl", (new StringBuilder()).append("touchSlopSquare: ").append(e).toString());
    }

    public static String a(int i)
    {
        switch (i)
        {
        case 4: // '\004'
        default:
            return String.valueOf(i);

        case 0: // '\0'
            return "ACTION_DOWN";

        case 5: // '\005'
            return "ACTION_POINTER_DOWN";

        case 6: // '\006'
            return "ACTION_POINTER_UP";

        case 2: // '\002'
            return "ACTION_MOVE";

        case 3: // '\003'
            return "ACTION_CANCEL";

        case 1: // '\001'
            return "ACTION_UP";
        }
    }

    public void a(MotionEvent motionevent)
    {
        int i;
        i = motionevent.getActionMasked();
        m.b("TouchMovingCtrl#onTouch", String.format("%s: (%.4f, %.4f)", new Object[] {
            a(i), Float.valueOf(motionevent.getX()), Float.valueOf(motionevent.getY())
        }));
        i;
        JVM INSTR tableswitch 0 2: default 76
    //                   0 82
    //                   1 148
    //                   2 112;
           goto _L1 _L2 _L3 _L4
_L1:
        b = false;
_L6:
        return;
_L2:
        a = MotionEvent.obtain(motionevent);
        b = true;
        c = motionevent.getX();
        d = motionevent.getY();
        return;
_L4:
        if (!b || a(motionevent.getX(), motionevent.getY())) goto _L6; else goto _L5
_L5:
        m.b("WigView#onTouch", "Move not equals.");
        b = false;
        return;
_L3:
        if (b && f != null)
        {
            f.a(motionevent);
        }
        if (a != null)
        {
            a.recycle();
            a = null;
        }
        b = false;
        c = -1F;
        d = -1F;
        return;
    }

    public void a(b b1)
    {
        f = b1;
    }

    public boolean a()
    {
        return b;
    }

    public boolean a(float f1, float f2)
    {
        if (c != -1F && d != -1F)
        {
            int i = (int)(c - f1);
            int j = (int)(d - f2);
            i = i * i + j * j;
            m.b("TouchMovingCtrl", (new StringBuilder()).append("distance: ").append(i).toString());
            if (i < e)
            {
                return true;
            }
        }
        return false;
    }

    public MotionEvent b()
    {
        return a;
    }

    public void c()
    {
        if (a != null)
        {
            a.recycle();
            a = null;
        }
    }
}

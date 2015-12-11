// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.view.MotionEvent;

final class la extends hu
{

    private boolean b;
    private boolean c;
    private boolean d;
    private fn e;

    public la(Context context, boolean flag)
    {
        super(context, null, 0x7f0100c4);
        c = flag;
        setCacheColorHint(0);
    }

    static boolean a(la la1, boolean flag)
    {
        la1.b = flag;
        return flag;
    }

    protected final boolean a()
    {
        return d || super.a();
    }

    public final boolean a(MotionEvent motionevent, int i)
    {
        int j = dw.a(motionevent);
        j;
        JVM INSTR tableswitch 1 3: default 36
    //                   1 118
    //                   2 285
    //                   3 110;
           goto _L1 _L2 _L3 _L4
_L3:
        break MISSING_BLOCK_LABEL_285;
_L1:
        boolean flag;
        i = 0;
        flag = true;
_L7:
        if (!flag || i != 0)
        {
            d = false;
            setPressed(false);
            drawableStateChanged();
        }
        if (!flag) goto _L6; else goto _L5
_L5:
        if (e == null)
        {
            e = new fn(this);
        }
        e.a(true);
        e.onTouch(this, motionevent);
_L9:
        return flag;
_L4:
        i = 0;
        flag = false;
          goto _L7
_L2:
        flag = false;
_L10:
        int k;
        int l;
        k = motionevent.findPointerIndex(i);
        if (k < 0)
        {
            i = 0;
            flag = false;
        } else
        {
label0:
            {
                i = (int)motionevent.getX(k);
                k = (int)motionevent.getY(k);
                l = pointToPosition(i, k);
                if (l != -1)
                {
                    break label0;
                }
                i = 1;
            }
        }
          goto _L7
        android.view.View view = getChildAt(l - getFirstVisiblePosition());
        float f = i;
        float f1 = k;
        d = true;
        setPressed(true);
        layoutChildren();
        setSelection(l);
        a(l, view, f, f1);
        super.a.a = false;
        refreshDrawableState();
        if (j == 1)
        {
            performItemClick(view, l, getItemIdAtPosition(l));
        }
          goto _L1
_L6:
        if (e == null) goto _L9; else goto _L8
_L8:
        e.a(false);
        return flag;
        flag = true;
          goto _L10
    }

    public final boolean hasFocus()
    {
        return c || super.hasFocus();
    }

    public final boolean hasWindowFocus()
    {
        return c || super.hasWindowFocus();
    }

    public final boolean isFocused()
    {
        return c || super.isFocused();
    }

    public final boolean isInTouchMode()
    {
        return c && b || super.isInTouchMode();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.support.v7.internal.widget.ListViewCompat;
import android.view.MotionEvent;
import android.view.View;

public class ey extends ListViewCompat
{

    private boolean a;
    private boolean b;
    private boolean c;
    private ViewPropertyAnimatorCompat d;
    private ListViewAutoScrollHelper e;

    public ey(Context context, boolean flag)
    {
        super(context, null, r.dropDownListViewStyle);
        b = flag;
        setCacheColorHint(0);
    }

    private void a()
    {
        c = false;
        setPressed(false);
        drawableStateChanged();
        if (d != null)
        {
            d.cancel();
            d = null;
        }
    }

    private void a(View view, int i)
    {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    private void a(View view, int i, float f, float f1)
    {
        c = true;
        setPressed(true);
        layoutChildren();
        setSelection(i);
        positionSelectorLikeTouchCompat(i, view, f, f1);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    public static boolean a(ey ey1, boolean flag)
    {
        ey1.a = flag;
        return flag;
    }

    public boolean a(MotionEvent motionevent, int i)
    {
        int j = MotionEventCompat.getActionMasked(motionevent);
        j;
        JVM INSTR tableswitch 1 3: default 36
    //                   1 108
    //                   2 227
    //                   3 100;
           goto _L1 _L2 _L3 _L4
_L3:
        break MISSING_BLOCK_LABEL_227;
_L1:
        boolean flag;
        i = 0;
        flag = true;
_L7:
        if (!flag || i != 0)
        {
            a();
        }
        if (!flag) goto _L6; else goto _L5
_L5:
        if (e == null)
        {
            e = new ListViewAutoScrollHelper(this);
        }
        e.setEnabled(true);
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
        View view = getChildAt(l - getFirstVisiblePosition());
        a(view, l, i, k);
        if (j == 1)
        {
            a(view, l);
        }
          goto _L1
_L6:
        if (e == null) goto _L9; else goto _L8
_L8:
        e.setEnabled(false);
        return flag;
        flag = true;
          goto _L10
    }

    public boolean hasFocus()
    {
        return b || super.hasFocus();
    }

    public boolean hasWindowFocus()
    {
        return b || super.hasWindowFocus();
    }

    public boolean isFocused()
    {
        return b || super.isFocused();
    }

    public boolean isInTouchMode()
    {
        return b && a || super.isInTouchMode();
    }

    protected boolean touchModeDrawsInPressedStateCompat()
    {
        return c || super.touchModeDrawsInPressedStateCompat();
    }
}

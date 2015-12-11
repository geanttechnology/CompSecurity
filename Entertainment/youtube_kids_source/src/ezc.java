// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.Scroller;

final class ezc extends android.view.GestureDetector.SimpleOnGestureListener
{

    private eyz a;

    ezc(eyz eyz1)
    {
        a = eyz1;
        super();
    }

    private static boolean a(MotionEvent motionevent, View view)
    {
        Rect rect = new Rect();
        int ai[] = new int[2];
        view.getLocationOnScreen(ai);
        int i = ai[0];
        int j = view.getWidth();
        int k = ai[1];
        rect.set(i, k, j + i, view.getHeight() + k);
        return rect.contains((int)motionevent.getRawX(), (int)motionevent.getRawY());
    }

    public final boolean onDown(MotionEvent motionevent)
    {
        a.f.forceFinished(true);
        return true;
    }

    public final boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        return a.a(f);
    }

    public final void onLongPress(MotionEvent motionevent)
    {
        int j = a.getChildCount();
        int i = 0;
        do
        {
label0:
            {
                if (i < j)
                {
                    View view = a.getChildAt(i);
                    if (!a(motionevent, view))
                    {
                        break label0;
                    }
                    if (eyz.e(a) != null)
                    {
                        eyz.e(a).onItemLongClick(a, view, eyz.c(a) + 1 + i, a.c.getItemId(i + (eyz.c(a) + 1)));
                    }
                }
                return;
            }
            i++;
        } while (true);
    }

    public final boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        synchronized (a)
        {
            motionevent1 = a;
            motionevent1.e = ((eyz) (motionevent1)).e + (int)f;
        }
        a.requestLayout();
        return true;
        motionevent1;
        motionevent;
        JVM INSTR monitorexit ;
        throw motionevent1;
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        int i = 0;
        do
        {
label0:
            {
                if (i < a.getChildCount())
                {
                    View view = a.getChildAt(i);
                    if (!a(motionevent, view))
                    {
                        break label0;
                    }
                    if (eyz.b(a) != null)
                    {
                        eyz.b(a).onItemClick(a, view, eyz.c(a) + 1 + i, a.c.getItemId(eyz.c(a) + 1 + i));
                    }
                    if (eyz.d(a) != null)
                    {
                        eyz.d(a).onItemSelected(a, view, eyz.c(a) + 1 + i, a.c.getItemId(eyz.c(a) + 1 + i));
                    }
                }
                return true;
            }
            i++;
        } while (true);
    }
}

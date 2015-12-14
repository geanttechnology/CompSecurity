// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.views;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListAdapter;

// Referenced classes of package com.socialin.android.views:
//            HorizontalListView

final class c extends android.view.eOnGestureListener
{

    private float a;
    private float b;
    private float c;
    private HorizontalListView d;

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
        return d.onDown(motionevent);
    }

    public final boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        return d.onFling(motionevent, motionevent1, f, f1);
    }

    public final void onLongPress(MotionEvent motionevent)
    {
        int j = d.getChildCount();
        int i = 0;
        do
        {
label0:
            {
                if (i < j)
                {
                    View view = d.getChildAt(i);
                    if (!a(motionevent, view))
                    {
                        break label0;
                    }
                    if (HorizontalListView.access$500(d) != null)
                    {
                        HorizontalListView.access$500(d).onItemLongClick(d, view, HorizontalListView.access$300(d) + 1 + i, d.mAdapter.getItemId(i + (HorizontalListView.access$300(d) + 1)));
                    }
                }
                return;
            }
            i++;
        } while (true);
    }

    public final boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        a = a + f;
        if (b * f >= 0.0F) goto _L2; else goto _L1
_L1:
        b = f;
_L4:
        return true;
_L2:
        b = f;
        c = a;
        if (c * a < 0.0F && Math.abs(a) < 5F) goto _L4; else goto _L3
_L3:
        synchronized (d)
        {
            (new StringBuilder("distanceX: ")).append(a);
            motionevent1 = d;
            motionevent1.mNextX = ((HorizontalListView) (motionevent1)).mNextX + (int)a;
        }
        c = a;
        a = 0.0F;
        d.requestLayout();
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
                if (i < d.getChildCount())
                {
                    View view = d.getChildAt(i);
                    if (!a(motionevent, view))
                    {
                        break label0;
                    }
                    if (HorizontalListView.access$200(d) != null)
                    {
                        HorizontalListView.access$200(d).onItemClick(d, view, HorizontalListView.access$300(d) + 1 + i, d.mAdapter.getItemId(HorizontalListView.access$300(d) + 1 + i));
                    }
                    if (HorizontalListView.access$400(d) != null)
                    {
                        HorizontalListView.access$400(d).onItemSelected(d, view, HorizontalListView.access$300(d) + 1 + i, d.mAdapter.getItemId(HorizontalListView.access$300(d) + 1 + i));
                    }
                }
                return true;
            }
            i++;
        } while (true);
    }

    r(HorizontalListView horizontallistview)
    {
        d = horizontallistview;
        super();
        a = 0.0F;
        b = 0.0F;
        c = 0.0F;
    }
}

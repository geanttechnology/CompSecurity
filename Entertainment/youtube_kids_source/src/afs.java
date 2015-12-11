// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.apps.youtube.kids.ui.ScrollAwareHorizontalListView;

public final class afs extends android.view.GestureDetector.SimpleOnGestureListener
{

    private ScrollAwareHorizontalListView a;

    public afs(ScrollAwareHorizontalListView scrollawarehorizontallistview)
    {
        a = scrollawarehorizontallistview;
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

    public final boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        if (f <= 0.0F) goto _L2; else goto _L1
_L1:
        ScrollAwareHorizontalListView.b(a).b(0x7f08001a);
_L4:
        a.a();
        a.removeCallbacks(ScrollAwareHorizontalListView.a(a));
        a.postDelayed(ScrollAwareHorizontalListView.a(a), 200L);
        return false;
_L2:
        if (f < 0.0F)
        {
            ScrollAwareHorizontalListView.b(a).b(0x7f080019);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        a.a();
        a.removeCallbacks(ScrollAwareHorizontalListView.a(a));
        a.postDelayed(ScrollAwareHorizontalListView.a(a), 500L);
        return false;
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        int i = 0;
        do
        {
            if (i >= a.getChildCount())
            {
                break;
            }
            View view = a.getChildAt(i);
            if (a(motionevent, view) && (view instanceof ViewGroup))
            {
                i = 0;
                while (i < ((ViewGroup)view).getChildCount()) 
                {
                    View view1 = ((ViewGroup)view).getChildAt(i);
                    if (a(motionevent, view1))
                    {
                        ScrollAwareHorizontalListView.b(a).b(0x7f080018);
                        Object obj = view1.getTag(0x7f100016);
                        if (obj != null && (obj instanceof android.view.View.OnClickListener))
                        {
                            ((android.view.View.OnClickListener)obj).onClick(view1);
                        } else
                        {
                            view1.performClick();
                        }
                    }
                    i++;
                }
                break;
            }
            i++;
        } while (true);
        return false;
    }
}

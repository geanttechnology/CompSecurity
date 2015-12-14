// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.view;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListAdapter;

// Referenced classes of package com.wantu.view:
//            HorizontalListView

class nGestureListener extends android.view.eOnGestureListener
{

    final HorizontalListView a;

    public boolean onDown(MotionEvent motionevent)
    {
        return a.onDown(motionevent);
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        return a.onFling(motionevent, motionevent1, f, f1);
    }

    public void onLongPress(MotionEvent motionevent)
    {
        Rect rect = new Rect();
        int j = a.getChildCount();
        int i = 0;
        do
        {
label0:
            {
                if (i < j)
                {
                    View view = a.getChildAt(i);
                    int k = view.getLeft();
                    int l = view.getRight();
                    rect.set(k, view.getTop(), l, view.getBottom());
                    if (!rect.contains((int)motionevent.getX(), (int)motionevent.getY()))
                    {
                        break label0;
                    }
                    if (HorizontalListView.access$500(a) != null)
                    {
                        HorizontalListView.access$500(a).onItemLongClick(a, view, HorizontalListView.access$300(a) + 1 + i, a.mAdapter.getItemId(i + (HorizontalListView.access$300(a) + 1)));
                    }
                }
                return;
            }
            i++;
        } while (true);
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        synchronized (a)
        {
            motionevent1 = a;
            motionevent1.mNextX = ((HorizontalListView) (motionevent1)).mNextX + (int)f;
        }
        a.requestLayout();
        return true;
        motionevent1;
        motionevent;
        JVM INSTR monitorexit ;
        throw motionevent1;
    }

    public boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        Rect rect = new Rect();
        int i = 0;
        do
        {
label0:
            {
                if (i < a.getChildCount())
                {
                    View view = a.getChildAt(i);
                    int j = view.getLeft();
                    int k = view.getRight();
                    rect.set(j, view.getTop(), k, view.getBottom());
                    if (!rect.contains((int)motionevent.getX(), (int)motionevent.getY()))
                    {
                        break label0;
                    }
                    if (HorizontalListView.access$200(a) != null)
                    {
                        HorizontalListView.access$200(a).onItemClick(a, view, HorizontalListView.access$300(a) + 1 + i, a.mAdapter.getItemId(HorizontalListView.access$300(a) + 1 + i));
                    }
                    if (HorizontalListView.access$400(a) != null)
                    {
                        HorizontalListView.access$400(a).onItemSelected(a, view, HorizontalListView.access$300(a) + 1 + i, a.mAdapter.getItemId(HorizontalListView.access$300(a) + 1 + i));
                    }
                }
                return true;
            }
            i++;
        } while (true);
    }

    ectedListener(HorizontalListView horizontallistview)
    {
        a = horizontallistview;
        super();
    }
}

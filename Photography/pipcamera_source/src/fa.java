// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.MotionEvent;
import android.widget.ListAdapter;
import com.fotoable.comlib.ui.HorizontalListView;

public class fa extends android.view.GestureDetector.SimpleOnGestureListener
{

    final HorizontalListView a;

    private fa(HorizontalListView horizontallistview)
    {
        a = horizontallistview;
        super();
    }

    public fa(HorizontalListView horizontallistview, com.fotoable.comlib.ui.HorizontalListView._cls1 _pcls1)
    {
        this(horizontallistview);
    }

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
        HorizontalListView.access$400(a);
        int i = HorizontalListView.access$900(a, (int)motionevent.getX(), (int)motionevent.getY());
        if (i >= 0 && !HorizontalListView.access$1000(a))
        {
            motionevent = a.getChildAt(i);
            android.widget.AdapterView.OnItemLongClickListener onitemlongclicklistener = a.getOnItemLongClickListener();
            if (onitemlongclicklistener != null)
            {
                i = HorizontalListView.access$1100(a) + i;
                if (onitemlongclicklistener.onItemLongClick(a, motionevent, i, a.mAdapter.getItemId(i)))
                {
                    a.performHapticFeedback(0);
                }
            }
        }
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        HorizontalListView.access$600(a, Boolean.valueOf(true));
        HorizontalListView.access$700(a, com.fotoable.comlib.ui.HorizontalListView.OnScrollStateChangedListener.ScrollState.SCROLL_STATE_TOUCH_SCROLL);
        HorizontalListView.access$400(a);
        motionevent = a;
        motionevent.mNextX = ((HorizontalListView) (motionevent)).mNextX + (int)f;
        HorizontalListView.access$800(a, Math.round(f));
        a.requestLayout();
        return true;
    }

    public boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        HorizontalListView.access$400(a);
        android.widget.AdapterView.OnItemClickListener onitemclicklistener = a.getOnItemClickListener();
        int i = HorizontalListView.access$900(a, (int)motionevent.getX(), (int)motionevent.getY());
        if (i >= 0 && !HorizontalListView.access$1000(a))
        {
            motionevent = a.getChildAt(i);
            i = HorizontalListView.access$1100(a) + i;
            if (onitemclicklistener != null)
            {
                onitemclicklistener.onItemClick(a, motionevent, i, a.mAdapter.getItemId(i));
                return true;
            }
        }
        if (HorizontalListView.access$1200(a) != null && !HorizontalListView.access$1000(a))
        {
            HorizontalListView.access$1200(a).onClick(a);
        }
        return false;
    }
}

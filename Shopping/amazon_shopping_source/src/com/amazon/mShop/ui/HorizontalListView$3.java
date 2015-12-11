// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.ListAdapter;

// Referenced classes of package com.amazon.mShop.ui:
//            HorizontalListView

class ureListener extends android.view.eOnGestureListener
{

    final HorizontalListView this$0;

    public boolean onDoubleTap(MotionEvent motionevent)
    {
        HorizontalListView.access$400(HorizontalListView.this);
        return false;
    }

    public boolean onDown(MotionEvent motionevent)
    {
        return HorizontalListView.this.onDown(motionevent);
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        HorizontalListView.access$400(HorizontalListView.this);
        return HorizontalListView.this.onFling(motionevent, motionevent1, f, f1);
    }

    public void onLongPress(MotionEvent motionevent)
    {
        int j = getChildCount();
        int i = 0;
        do
        {
label0:
            {
                if (i < j)
                {
                    View view = getChildAt(i);
                    if (!HorizontalListView.access$500(HorizontalListView.this, motionevent, view))
                    {
                        break label0;
                    }
                    if (HorizontalListView.access$900(HorizontalListView.this) != null)
                    {
                        HorizontalListView.access$900(HorizontalListView.this).onItemLongClick(HorizontalListView.this, view, HorizontalListView.access$700(HorizontalListView.this) + 1 + i, mAdapter.getItemId(HorizontalListView.access$700(HorizontalListView.this) + 1 + i));
                    }
                }
                return;
            }
            i++;
        } while (true);
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        HorizontalListView.access$400(HorizontalListView.this);
        synchronized (HorizontalListView.this)
        {
            motionevent1 = HorizontalListView.this;
            motionevent1.mNextX = ((HorizontalListView) (motionevent1)).mNextX + (int)f;
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        requestLayout();
        return true;
        motionevent1;
        motionevent;
        JVM INSTR monitorexit ;
        throw motionevent1;
    }

    public void onShowPress(MotionEvent motionevent)
    {
        HorizontalListView.access$300(HorizontalListView.this, motionevent);
        getParent().requestDisallowInterceptTouchEvent(true);
    }

    public boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        boolean flag1 = false;
        int i = 0;
        do
        {
label0:
            {
                View view;
label1:
                {
                    boolean flag = flag1;
                    if (i < getChildCount())
                    {
                        view = getChildAt(i);
                        if (!HorizontalListView.access$500(HorizontalListView.this, motionevent, view))
                        {
                            break label0;
                        }
                        if (HorizontalListView.access$600(HorizontalListView.this) == null)
                        {
                            break label1;
                        }
                        HorizontalListView.access$600(HorizontalListView.this).onItemClick(HorizontalListView.this, view, HorizontalListView.access$700(HorizontalListView.this) + 1 + i, mAdapter.getItemId(HorizontalListView.access$700(HorizontalListView.this) + 1 + i));
                        flag = true;
                    }
                    return flag;
                }
                if (HorizontalListView.access$800(HorizontalListView.this) != null)
                {
                    HorizontalListView.access$800(HorizontalListView.this).onItemSelected(HorizontalListView.this, view, HorizontalListView.access$700(HorizontalListView.this) + 1 + i, mAdapter.getItemId(HorizontalListView.access$700(HorizontalListView.this) + 1 + i));
                    return true;
                } else
                {
                    return view.performClick();
                }
            }
            i++;
        } while (true);
    }

    public boolean onSingleTapUp(MotionEvent motionevent)
    {
        HorizontalListView.access$300(HorizontalListView.this, motionevent);
        postDelayed(new Runnable() {

            final HorizontalListView._cls3 this$1;

            public void run()
            {
                HorizontalListView.access$400(this$0);
            }

            
            {
                this$1 = HorizontalListView._cls3.this;
                super();
            }
        }, 300L);
        return false;
    }

    _cls1.this._cls1()
    {
        this$0 = HorizontalListView.this;
        super();
    }
}

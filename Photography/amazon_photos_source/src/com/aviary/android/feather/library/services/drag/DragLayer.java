// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.services.drag;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.aviary.android.feather.library.services.DragController;

public class DragLayer extends FrameLayout
{
    public static interface OnAttachedToWindowListener
    {

        public abstract void onAttachedToWindow();
    }


    DragController mDragController;
    OnAttachedToWindowListener mOnAttachedToWindowListener;

    public DragLayer(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        if (mDragController != null)
        {
            return mDragController.dispatchKeyEvent(keyevent);
        } else
        {
            return super.dispatchKeyEvent(keyevent);
        }
    }

    public boolean dispatchUnhandledMove(View view, int i)
    {
        if (mDragController != null)
        {
            return mDragController.dispatchUnhandledMove(view, i);
        } else
        {
            return false;
        }
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (mOnAttachedToWindowListener != null)
        {
            mOnAttachedToWindowListener.onAttachedToWindow();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        if (mDragController != null)
        {
            return mDragController.onInterceptTouchEvent(motionevent);
        } else
        {
            return false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (mDragController != null)
        {
            return mDragController.onTouchEvent(motionevent);
        } else
        {
            return false;
        }
    }

    public void setDragController(DragController dragcontroller)
    {
        mDragController = dragcontroller;
    }

    public void setOnAttachedToWindowListener(OnAttachedToWindowListener onattachedtowindowlistener)
    {
        mOnAttachedToWindowListener = onattachedtowindowlistener;
    }
}

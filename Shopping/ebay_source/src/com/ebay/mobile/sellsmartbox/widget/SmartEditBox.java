// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sellsmartbox.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;

public class SmartEditBox extends AppCompatAutoCompleteTextView
    implements android.view.View.OnTouchListener
{
    public static interface OnSoftKeyDismissListener
    {

        public abstract void onSoftKeyDismiss();
    }


    private OnSoftKeyDismissListener softkeyDismissListener;

    public SmartEditBox(Context context)
    {
        super(context);
        softkeyDismissListener = null;
        init(context);
    }

    public SmartEditBox(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        softkeyDismissListener = null;
        init(context);
    }

    public SmartEditBox(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        softkeyDismissListener = null;
        init(context);
    }

    private void init(Context context)
    {
        setOnTouchListener(this);
    }

    public boolean onKeyPreIme(int i, KeyEvent keyevent)
    {
        if (i != 4)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        if (keyevent.getAction() != 0 || keyevent.getRepeatCount() != 0) goto _L2; else goto _L1
_L1:
        android.view.KeyEvent.DispatcherState dispatcherstate = getKeyDispatcherState();
        if (dispatcherstate != null)
        {
            dispatcherstate.startTracking(keyevent, this);
        }
_L4:
        return true;
_L2:
        if (keyevent.getAction() != 1)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        android.view.KeyEvent.DispatcherState dispatcherstate1 = getKeyDispatcherState();
        if (dispatcherstate1 != null)
        {
            dispatcherstate1.handleUpEvent(keyevent);
        }
        if (!keyevent.isTracking() || keyevent.isCanceled() || !TextUtils.isEmpty(getText().toString()))
        {
            break MISSING_BLOCK_LABEL_103;
        }
        if (softkeyDismissListener == null) goto _L4; else goto _L3
_L3:
        softkeyDismissListener.onSoftKeyDismiss();
        return true;
        return super.onKeyPreIme(i, keyevent);
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (view.getId() == getId())
        {
            view = (AutoCompleteTextView)view;
            Drawable drawable = view.getCompoundDrawables()[2];
            if (motionevent.getAction() == 1 && drawable != null && motionevent.getX() > (float)(view.getWidth() - view.getPaddingRight() - drawable.getIntrinsicWidth()) && !TextUtils.isEmpty(getText().toString()))
            {
                setText("");
            }
        }
        return false;
    }

    public void setOnSoftKeyDismissListener(OnSoftKeyDismissListener onsoftkeydismisslistener)
    {
        softkeyDismissListener = onsoftkeydismisslistener;
    }
}

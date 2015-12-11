// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

public abstract class DrawableOnTouchListener
    implements android.view.View.OnTouchListener
{

    Drawable drawable;
    private int fuzz;

    public DrawableOnTouchListener(EditText edittext)
    {
        fuzz = 10;
        edittext = edittext.getCompoundDrawables();
        if (edittext != null && edittext.length == 4)
        {
            drawable = edittext[2];
        }
    }

    public abstract boolean onDrawableTouch(MotionEvent motionevent);

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 0 && drawable != null)
        {
            int i = (int)motionevent.getX();
            int j = (int)motionevent.getY();
            Rect rect = drawable.getBounds();
            if (i >= view.getRight() - rect.width() - fuzz && i <= (view.getRight() - view.getPaddingRight()) + fuzz && j >= view.getPaddingTop() - fuzz && j <= (view.getHeight() - view.getPaddingBottom()) + fuzz)
            {
                return onDrawableTouch(motionevent);
            }
        }
        return false;
    }
}

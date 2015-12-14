// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.view.compose2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import md;
import mj;
import mk;

public class ClearableEditText extends EditText
    implements android.view.View.OnFocusChangeListener, android.view.View.OnTouchListener, mk
{

    private android.view.View.OnFocusChangeListener f;
    private android.view.View.OnTouchListener l;
    private md listener;
    private Drawable xD;

    public ClearableEditText(Context context)
    {
        super(context);
        init();
    }

    public ClearableEditText(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    public ClearableEditText(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init();
    }

    private void init()
    {
        xD = getCompoundDrawables()[2];
        if (xD == null)
        {
            xD = getResources().getDrawable(0x108006a);
        }
        xD.setBounds(0, 0, xD.getIntrinsicWidth(), xD.getIntrinsicHeight());
        setClearIconVisible(false);
        super.setOnTouchListener(this);
        super.setOnFocusChangeListener(this);
        addTextChangedListener(new mj(this, this));
    }

    public static boolean isEmpty(CharSequence charsequence)
    {
        return charsequence == null || charsequence.length() == 0;
    }

    public static boolean isNotEmpty(CharSequence charsequence)
    {
        return !isEmpty(charsequence);
    }

    public void onFocusChange(View view, boolean flag)
    {
        if (flag)
        {
            setClearIconVisible(isNotEmpty(getText()));
        } else
        {
            setClearIconVisible(false);
        }
        if (f != null)
        {
            f.onFocusChange(view, flag);
        }
    }

    public void onTextChanged(EditText edittext, String s)
    {
        if (isFocused())
        {
            setClearIconVisible(isNotEmpty(s));
        }
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (getCompoundDrawables()[2] != null)
        {
            boolean flag;
            if (motionevent.getX() > (float)(getWidth() - getPaddingRight() - xD.getIntrinsicWidth()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                if (motionevent.getAction() == 1)
                {
                    setText("");
                    if (listener != null)
                    {
                        listener.a();
                    }
                }
                return true;
            }
        }
        if (l != null)
        {
            return l.onTouch(view, motionevent);
        } else
        {
            return false;
        }
    }

    protected void setClearIconVisible(boolean flag)
    {
        Drawable drawable;
        if (flag)
        {
            drawable = xD;
        } else
        {
            drawable = null;
        }
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], drawable, getCompoundDrawables()[3]);
    }

    public void setListener(md md1)
    {
        listener = md1;
    }

    public void setOnFocusChangeListener(android.view.View.OnFocusChangeListener onfocuschangelistener)
    {
        f = onfocuschangelistener;
    }

    public void setOnTouchListener(android.view.View.OnTouchListener ontouchlistener)
    {
        l = ontouchlistener;
    }
}

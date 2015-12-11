// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.AutoCompleteTextView;
import hy;
import ib;

public class c extends AutoCompleteTextView
{

    private final int a[] = {
        0x1010176
    };
    private int b;
    private final hy c;

    public boolean enoughToFilter()
    {
        return b <= 0 || super.enoughToFilter();
    }

    protected void onFocusChanged(boolean flag, int i, Rect rect)
    {
        super.onFocusChanged(flag, i, rect);
        throw new NullPointerException();
    }

    public boolean onKeyPreIme(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            if (keyevent.getAction() == 0 && keyevent.getRepeatCount() == 0)
            {
                android.view.AutoComplete autocomplete = getKeyDispatcherState();
                if (autocomplete != null)
                {
                    autocomplete.Tracking(keyevent, this);
                }
                return true;
            }
            if (keyevent.getAction() == 1)
            {
                android.view.AutoComplete autocomplete1 = getKeyDispatcherState();
                if (autocomplete1 != null)
                {
                    autocomplete1.eUpEvent(keyevent);
                }
                if (keyevent.isTracking() && !keyevent.isCanceled())
                {
                    throw new NullPointerException();
                }
            }
        }
        return super.onKeyPreIme(i, keyevent);
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        if (flag)
        {
            throw new NullPointerException();
        } else
        {
            return;
        }
    }

    public void performCompletion()
    {
    }

    protected void replaceText(CharSequence charsequence)
    {
    }

    public void setDropDownBackgroundResource(int i)
    {
        setDropDownBackgroundDrawable(c.a(i));
    }

    public void setThreshold(int i)
    {
        super.setThreshold(i);
        b = i;
    }

    public (Context context)
    {
        this(context, null);
    }

    public <init>(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x101006b);
    }

    public <init>(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        b = getThreshold();
        context = ib.a(context, attributeset, a, i, 0);
        if (context.c(0))
        {
            setDropDownBackgroundDrawable(context.a(0));
        }
        ((ib) (context)).a.recycle();
        c = context.a();
    }
}

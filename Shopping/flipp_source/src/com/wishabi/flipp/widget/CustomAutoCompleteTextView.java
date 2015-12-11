// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.AutoCompleteTextView;
import android.widget.SimpleCursorAdapter;

// Referenced classes of package com.wishabi.flipp.widget:
//            as, at, au

public class CustomAutoCompleteTextView extends AutoCompleteTextView
{

    static final String a = com/wishabi/flipp/widget/CustomAutoCompleteTextView.getSimpleName();
    private au b;
    private SimpleCursorAdapter c;

    public CustomAutoCompleteTextView(Context context)
    {
        super(context);
        a();
    }

    public CustomAutoCompleteTextView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public CustomAutoCompleteTextView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    private void a()
    {
        c = new SimpleCursorAdapter(getContext(), 0x109000a, null, new String[] {
            "suggest_intent_query"
        }, new int[] {
            0x1020014
        }, 0);
        c.setFilterQueryProvider(new as(this));
        c.setCursorToStringConverter(new at(this));
        setAdapter(c);
    }

    public boolean onKeyPreIme(int i, KeyEvent keyevent)
    {
        if (keyevent.getKeyCode() == 4 && b != null)
        {
            b.a(this);
        }
        return super.onKeyPreIme(i, keyevent);
    }

    public void setKeyboardDimissedListener(au au1)
    {
        b = au1;
    }

}

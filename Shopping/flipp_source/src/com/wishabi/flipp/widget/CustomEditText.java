// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;

// Referenced classes of package com.wishabi.flipp.widget:
//            av

public class CustomEditText extends EditText
{

    private av a;

    public CustomEditText(Context context)
    {
        super(context);
    }

    public CustomEditText(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public CustomEditText(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public boolean onKeyPreIme(int i, KeyEvent keyevent)
    {
        if (keyevent.getKeyCode() == 4 && a != null)
        {
            a.a();
        }
        return super.onKeyPreIme(i, keyevent);
    }

    public void setKeyboardDimissedListener(av av1)
    {
        a = av1;
    }
}

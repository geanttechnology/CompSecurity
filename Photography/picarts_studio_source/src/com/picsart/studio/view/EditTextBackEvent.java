// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;

// Referenced classes of package com.picsart.studio.view:
//            b

public class EditTextBackEvent extends EditText
{

    private b a;

    public EditTextBackEvent(Context context)
    {
        super(context);
    }

    public EditTextBackEvent(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public EditTextBackEvent(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public boolean onKeyPreIme(int i, KeyEvent keyevent)
    {
        if (keyevent.getKeyCode() == 4 && keyevent.getAction() == 1 && a != null)
        {
            b b1 = a;
            getText().toString();
            b1.a();
        }
        return super.dispatchKeyEvent(keyevent);
    }

    public void setOnEditTextImeBackListener(b b1)
    {
        a = b1;
    }
}

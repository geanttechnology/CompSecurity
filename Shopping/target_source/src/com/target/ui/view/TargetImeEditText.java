// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;

// Referenced classes of package com.target.ui.view:
//            TargetEditText

public class TargetImeEditText extends TargetEditText
{
    public static interface a
    {

        public abstract boolean a(int i, KeyEvent keyevent);
    }


    private a mImeListener;

    public TargetImeEditText(Context context)
    {
        super(context);
    }

    public TargetImeEditText(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public TargetImeEditText(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public boolean onKeyPreIme(int i, KeyEvent keyevent)
    {
        if (mImeListener != null)
        {
            return mImeListener.a(i, keyevent);
        } else
        {
            return false;
        }
    }

    public void setImeListener(a a1)
    {
        mImeListener = a1;
    }
}

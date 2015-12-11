// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;

// Referenced classes of package com.smule.pianoandroid.utils:
//            o

final class a
    implements android.widget.iew.OnEditorActionListener
{

    final Button a;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if (a.isEnabled())
        {
            a.performClick();
        }
        return true;
    }

    tionListener(Button button)
    {
        a = button;
        super();
    }
}

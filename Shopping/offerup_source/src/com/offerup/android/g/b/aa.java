// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.b;

import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;

// Referenced classes of package com.offerup.android.g.b:
//            z

final class aa
    implements android.widget.TextView.OnEditorActionListener
{

    private Button a;

    aa(z z, Button button)
    {
        a = button;
        super();
    }

    public final boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if (i == 6)
        {
            a.performClick();
            return true;
        } else
        {
            return false;
        }
    }
}

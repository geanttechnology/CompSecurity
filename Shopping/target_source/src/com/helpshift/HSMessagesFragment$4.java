// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.view.KeyEvent;
import android.widget.ImageButton;
import android.widget.TextView;

// Referenced classes of package com.helpshift:
//            HSMessagesFragment

class a
    implements android.widget.onListener
{

    final ImageButton a;
    final HSMessagesFragment b;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            a.performClick();
        }
        return false;
    }

    ionListener(HSMessagesFragment hsmessagesfragment, ImageButton imagebutton)
    {
        b = hsmessagesfragment;
        a = imagebutton;
        super();
    }
}

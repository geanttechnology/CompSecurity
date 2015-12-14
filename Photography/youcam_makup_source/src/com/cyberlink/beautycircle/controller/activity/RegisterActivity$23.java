// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            RegisterActivity

class a
    implements android.widget.ionListener
{

    final RegisterActivity a;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        return RegisterActivity.c(a).performClick();
    }

    (RegisterActivity registeractivity)
    {
        a = registeractivity;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.console;

import android.view.KeyEvent;
import android.view.View;

// Referenced classes of package com.smule.android.console:
//            DebugConsoleActivity

class a
    implements android.view.leActivity._cls3
{

    final DebugConsoleActivity a;

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        if (i == 66 && keyevent.getAction() == 1)
        {
            DebugConsoleActivity.a(a);
            return true;
        } else
        {
            return false;
        }
    }

    (DebugConsoleActivity debugconsoleactivity)
    {
        a = debugconsoleactivity;
        super();
    }
}

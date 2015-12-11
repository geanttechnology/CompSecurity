// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.home;

import android.view.KeyEvent;
import android.view.View;

// Referenced classes of package com.amazon.now.home:
//            WelcomeScreen

class this._cls0
    implements android.view.er
{

    final WelcomeScreen this$0;

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        if (i == 66 && keyevent.getAction() == 0)
        {
            WelcomeScreen.access$300(WelcomeScreen.this);
            return true;
        } else
        {
            return false;
        }
    }

    ()
    {
        this$0 = WelcomeScreen.this;
        super();
    }
}

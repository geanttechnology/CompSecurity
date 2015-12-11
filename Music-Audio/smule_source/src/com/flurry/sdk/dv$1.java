// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.view.KeyEvent;
import android.view.View;

// Referenced classes of package com.flurry.sdk:
//            dv, dy

class it>
    implements android.view.OnKeyListener
{

    final dv a;

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        if (keyevent.getKeyCode() == 4 && keyevent.getAction() == 1)
        {
            if (dv.a(a) != null && a.b())
            {
                dv.a(a).g();
            }
            return true;
        } else
        {
            return false;
        }
    }

    t(dv dv1)
    {
        a = dv1;
        super();
    }
}

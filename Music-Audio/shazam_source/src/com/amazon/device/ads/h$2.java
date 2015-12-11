// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.view.KeyEvent;
import android.view.View;

// Referenced classes of package com.amazon.device.ads:
//            h

final class a
    implements android.view..OnKeyListener
{

    final h a;

    public final boolean onKey(View view, int i, KeyEvent keyevent)
    {
        if (i == 4 && keyevent.getRepeatCount() == 0)
        {
            a.r();
            return true;
        } else
        {
            return false;
        }
    }

    tener(h h1)
    {
        a = h1;
        super();
    }
}

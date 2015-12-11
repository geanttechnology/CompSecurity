// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.view.View;
import android.widget.FrameLayout;

// Referenced classes of package com.jirbo.adcolony:
//            au, o

class a
    implements Runnable
{

    final View a;
    final au b;

    public void run()
    {
        if (b.P)
        {
            b.d.L.setVisibility(4);
        }
        b.d.K.removeView(a);
    }

    ut(au au1, View view)
    {
        b = au1;
        a = view;
        super();
    }
}

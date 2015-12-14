// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.app.Dialog;
import android.view.View;
import android.view.Window;
import com.cyberlink.youcammakeup.widgetpool.common.aj;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            l

class b
    implements aj
{

    final l a;
    private int b[];

    private void a()
    {
        l.a(a).getLocationOnScreen(b);
        Object obj = a.getDialog();
        if (obj != null)
        {
            obj = ((Dialog) (obj)).getWindow();
            android.view.owManager.LayoutParams layoutparams = ((Window) (obj)).getAttributes();
            layoutparams.height = b[1];
            layoutparams.gravity = 48;
            ((Window) (obj)).setAttributes(layoutparams);
        }
    }

    public void a(int i, int j, int k, int i1)
    {
        if (l.a(a) != null)
        {
            a();
        }
    }

    (l l1)
    {
        a = l1;
        super();
        b = new int[2];
    }
}

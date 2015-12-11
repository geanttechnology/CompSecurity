// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.view.View;
import android.widget.ViewSwitcher;

// Referenced classes of package android.support.v7:
//            hw, aqo

class a
    implements a
{

    final ViewSwitcher a;
    final hw b;

    public void a()
    {
        aqo.a("full image success", new Object[0]);
        if (a.getCurrentView().getId() != 0x7f100086)
        {
            a.showNext();
        }
    }

    public void b()
    {
        aqo.d("full image failed", new Object[0]);
    }

    her(hw hw1, ViewSwitcher viewswitcher)
    {
        b = hw1;
        a = viewswitcher;
        super();
    }
}

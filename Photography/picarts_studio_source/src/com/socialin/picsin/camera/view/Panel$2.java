// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera.view;

import android.view.View;

// Referenced classes of package com.socialin.picsin.camera.view:
//            Panel

final class a
    implements android.view.lickListener
{

    private Panel a;

    public final void onClick(View view)
    {
        if (Panel.b(a))
        {
            a.bringToFront();
        }
        if (a.a())
        {
            a.post(a.a);
        }
    }

    (Panel panel)
    {
        a = panel;
        super();
    }
}

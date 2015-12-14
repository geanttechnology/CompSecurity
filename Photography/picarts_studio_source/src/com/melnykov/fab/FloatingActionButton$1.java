// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.melnykov.fab;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

// Referenced classes of package com.melnykov.fab:
//            FloatingActionButton

final class a extends ViewOutlineProvider
{

    private FloatingActionButton a;

    public final void getOutline(View view, Outline outline)
    {
        view = a;
        int i;
        if (FloatingActionButton.a(a) == 0)
        {
            i = 0x7f0b00ef;
        } else
        {
            i = 0x7f0b00ee;
        }
        i = FloatingActionButton.a(view, i);
        outline.setOval(0, 0, i, i);
    }

    (FloatingActionButton floatingactionbutton)
    {
        a = floatingactionbutton;
        super();
    }
}
